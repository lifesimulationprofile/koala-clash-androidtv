package androidx.room;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.compose.ui.unit.Density;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.service.data.Database_Impl;
import com.google.android.gms.tasks.zzg;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InvalidationTracker {
    public static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    public volatile FrameworkSQLiteStatement mCleanupStatement;
    public final Database_Impl mDatabase;
    public final DiskLruCache.Editor mObservedTableTracker;
    public final String[] mTableNames;
    public final AtomicBoolean mPendingRefresh = new AtomicBoolean(false);
    public volatile boolean mInitialized = false;
    public final SafeIterableMap mObserverMap = new SafeIterableMap();
    public final Object mSyncTriggersLock = new Object();
    public final zzg mRefreshRunnable = new zzg(18, this);
    public final HashMap mTableIdLookup = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class ObserverWrapper {
    }

    public InvalidationTracker(Database_Impl database_Impl, HashMap map, HashMap map2, String... strArr) {
        this.mDatabase = database_Impl;
        this.mObservedTableTracker = new DiskLruCache.Editor(strArr.length);
        Collections.newSetFromMap(new IdentityHashMap());
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str2 = (String) map.get(strArr[i]);
            if (str2 != null) {
                this.mTableNames[i] = str2.toLowerCase(locale);
            } else {
                this.mTableNames[i] = lowerCase;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = str3.toLowerCase(locale2);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap map3 = this.mTableIdLookup;
                map3.put(lowerCase3, (Integer) map3.get(lowerCase2));
            }
        }
    }

    public final boolean ensureInitialization() {
        if (!this.mDatabase.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.mOpenHelper.getWritableDatabase();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void startTrackingTable(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i) {
        frameworkSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.mTableNames[i];
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = TRIGGERS[i2];
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            Density.CC.m(sb, str, "_", str2, "`");
            Density.CC.m(sb, " AFTER ", str2, " ON `", str);
            Density.CC.m(sb, "` BEGIN UPDATE ", "room_table_modification_log", " SET ", "invalidated");
            Density.CC.m(sb, " = 1", " WHERE ", "table_id", " = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            frameworkSQLiteDatabase.execSQL(sb.toString());
        }
    }

    public final void syncTriggers(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        if (frameworkSQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.mDatabase.mCloseLock.readLock();
            lock.lock();
            try {
                synchronized (this.mSyncTriggersLock) {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync != null) {
                        int length = tablesToSync.length;
                        if (frameworkSQLiteDatabase.isWriteAheadLoggingEnabled()) {
                            frameworkSQLiteDatabase.beginTransactionNonExclusive();
                        } else {
                            frameworkSQLiteDatabase.beginTransaction();
                        }
                        for (int i = 0; i < length; i++) {
                            try {
                                int i2 = tablesToSync[i];
                                if (i2 == 1) {
                                    startTrackingTable(frameworkSQLiteDatabase, i);
                                } else if (i2 == 2) {
                                    String str = this.mTableNames[i];
                                    StringBuilder sb = new StringBuilder();
                                    String[] strArr = TRIGGERS;
                                    for (int i3 = 0; i3 < 3; i3++) {
                                        String str2 = strArr[i3];
                                        sb.setLength(0);
                                        sb.append("DROP TRIGGER IF EXISTS ");
                                        sb.append("`");
                                        sb.append("room_table_modification_trigger_");
                                        sb.append(str);
                                        sb.append("_");
                                        sb.append(str2);
                                        sb.append("`");
                                        frameworkSQLiteDatabase.execSQL(sb.toString());
                                    }
                                }
                            } catch (Throwable th) {
                                frameworkSQLiteDatabase.endTransaction();
                                throw th;
                            }
                        }
                        frameworkSQLiteDatabase.setTransactionSuccessful();
                        frameworkSQLiteDatabase.endTransaction();
                    }
                }
                lock.unlock();
            } catch (Throwable th2) {
                lock.unlock();
                throw th2;
            }
        } catch (SQLiteException | IllegalStateException e) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
        }
    }
}
