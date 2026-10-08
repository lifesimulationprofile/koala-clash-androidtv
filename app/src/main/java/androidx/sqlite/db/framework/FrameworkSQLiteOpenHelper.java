package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import coil.memory.MemoryCacheService;
import com.github.kr328.clash.service.data.Database_Impl;
import com.google.android.gms.common.internal.zzv;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final RoomOpenHelper mCallback;
    public final Context mContext;
    public OpenHelper mDelegate;
    public final Object mLock = new Object();
    public final String mName;
    public boolean mWriteAheadLoggingEnabled;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class OpenHelper extends SQLiteOpenHelper {
        public final RoomOpenHelper mCallback;
        public final FrameworkSQLiteDatabase[] mDbRef;
        public boolean mMigrated;

        public OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final RoomOpenHelper roomOpenHelper) {
            super(context, str, null, roomOpenHelper.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.1
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteDatabase wrappedDb = OpenHelper.getWrappedDb(frameworkSQLiteDatabaseArr, sQLiteDatabase);
                    roomOpenHelper.getClass();
                    Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + wrappedDb.mDelegate.getPath());
                    SQLiteDatabase sQLiteDatabase2 = wrappedDb.mDelegate;
                    if (!sQLiteDatabase2.isOpen()) {
                        RoomOpenHelper.deleteDatabaseFile(sQLiteDatabase2.getPath());
                        return;
                    }
                    List<Pair<String, String>> attachedDbs = null;
                    try {
                        try {
                            attachedDbs = sQLiteDatabase2.getAttachedDbs();
                        } finally {
                            if (attachedDbs != null) {
                                Iterator<Pair<String, String>> it = attachedDbs.iterator();
                                while (it.hasNext()) {
                                    RoomOpenHelper.deleteDatabaseFile((String) it.next().second);
                                }
                            } else {
                                RoomOpenHelper.deleteDatabaseFile(sQLiteDatabase2.getPath());
                            }
                        }
                    } catch (SQLiteException unused) {
                    }
                    try {
                        wrappedDb.close();
                    } catch (IOException unused2) {
                    }
                }
            });
            this.mCallback = roomOpenHelper;
            this.mDbRef = frameworkSQLiteDatabaseArr;
        }

        public static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase == null || frameworkSQLiteDatabase.mDelegate != sQLiteDatabase) {
                frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return frameworkSQLiteDatabaseArr[0];
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final synchronized void close() {
            super.close();
            this.mDbRef[0] = null;
        }

        public final synchronized FrameworkSQLiteDatabase getWritableSupportDatabase() {
            this.mMigrated = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!this.mMigrated) {
                return getWrappedDb(this.mDbRef, writableDatabase);
            }
            close();
            return getWritableSupportDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            getWrappedDb(this.mDbRef, sQLiteDatabase);
            this.mCallback.getClass();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase wrappedDb = getWrappedDb(this.mDbRef, sQLiteDatabase);
            this.mCallback.getClass();
            Cursor cursorQuery = wrappedDb.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z = false;
                if (cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 0) {
                    z = true;
                }
                cursorQuery.close();
                wrappedDb.execSQL("CREATE TABLE IF NOT EXISTS `imported` (`uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `source` TEXT NOT NULL, `interval` INTEGER NOT NULL, `upload` INTEGER NOT NULL, `download` INTEGER NOT NULL, `total` INTEGER NOT NULL, `expire` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL DEFAULT 0, `announce` TEXT, `supportURL` TEXT, `profileImage` BLOB, `modeSwitchAllowed` INTEGER NOT NULL DEFAULT 1, PRIMARY KEY(`uuid`))");
                wrappedDb.execSQL("CREATE TABLE IF NOT EXISTS `selections` (`uuid` TEXT NOT NULL, `proxy` TEXT NOT NULL, `selected` TEXT NOT NULL, PRIMARY KEY(`uuid`, `proxy`), FOREIGN KEY(`uuid`) REFERENCES `imported`(`uuid`) ON UPDATE CASCADE ON DELETE CASCADE )");
                wrappedDb.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                wrappedDb.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8c35d7d374f413febfcb9ee273005d53')");
                if (!z) {
                    zzv zzvVarOnValidateSchema = MemoryCacheService.onValidateSchema(wrappedDb);
                    if (!zzvVarOnValidateSchema.zzc) {
                        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + zzvVarOnValidateSchema.zza);
                    }
                }
                wrappedDb.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                wrappedDb.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8c35d7d374f413febfcb9ee273005d53')");
                int i = Database_Impl.$r8$clinit;
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(this.mDbRef, sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.mMigrated) {
                return;
            }
            RoomOpenHelper roomOpenHelper = this.mCallback;
            FrameworkSQLiteDatabase wrappedDb = getWrappedDb(this.mDbRef, sQLiteDatabase);
            roomOpenHelper.getClass();
            Cursor cursorQuery = wrappedDb.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                cursorQuery.close();
                if (z) {
                    Cursor cursorQuery2 = wrappedDb.query(new Symbol("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1", 1));
                    try {
                        String string = cursorQuery2.moveToFirst() ? cursorQuery2.getString(0) : null;
                        cursorQuery2.close();
                        if (!"8c35d7d374f413febfcb9ee273005d53".equals(string) && !"8731d63cf0904261553028e2b05e0179".equals(string)) {
                            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                        }
                    } catch (Throwable th) {
                        cursorQuery2.close();
                        throw th;
                    }
                } else {
                    zzv zzvVarOnValidateSchema = MemoryCacheService.onValidateSchema(wrappedDb);
                    if (!zzvVarOnValidateSchema.zzc) {
                        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + zzvVarOnValidateSchema.zza);
                    }
                    wrappedDb.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                    wrappedDb.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8c35d7d374f413febfcb9ee273005d53')");
                }
                MemoryCacheService memoryCacheService = (MemoryCacheService) roomOpenHelper.mDelegate;
                Database_Impl database_Impl = (Database_Impl) memoryCacheService.imageLoader;
                int i = Database_Impl.$r8$clinit;
                database_Impl.mDatabase = wrappedDb;
                wrappedDb.execSQL("PRAGMA foreign_keys = ON");
                InvalidationTracker invalidationTracker = ((Database_Impl) memoryCacheService.imageLoader).mInvalidationTracker;
                synchronized (invalidationTracker) {
                    try {
                        if (invalidationTracker.mInitialized) {
                            Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                        } else {
                            wrappedDb.execSQL("PRAGMA temp_store = MEMORY;");
                            wrappedDb.execSQL("PRAGMA recursive_triggers='ON';");
                            wrappedDb.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                            invalidationTracker.syncTriggers(wrappedDb);
                            invalidationTracker.mCleanupStatement = wrappedDb.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                            invalidationTracker.mInitialized = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                roomOpenHelper.mConfiguration = null;
            } catch (Throwable th3) {
                cursorQuery.close();
                throw th3;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(this.mDbRef, sQLiteDatabase), i, i2);
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, RoomOpenHelper roomOpenHelper) {
        this.mContext = context;
        this.mName = str;
        this.mCallback = roomOpenHelper;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        getDelegate().close();
    }

    public final OpenHelper getDelegate() {
        OpenHelper openHelper;
        synchronized (this.mLock) {
            try {
                if (this.mDelegate == null) {
                    OpenHelper openHelper2 = new OpenHelper(this.mContext, this.mName, new FrameworkSQLiteDatabase[1], this.mCallback);
                    this.mDelegate = openHelper2;
                    openHelper2.setWriteAheadLoggingEnabled(this.mWriteAheadLoggingEnabled);
                }
                openHelper = this.mDelegate;
            } catch (Throwable th) {
                throw th;
            }
        }
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final FrameworkSQLiteDatabase getWritableDatabase() {
        return getDelegate().getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.mLock) {
            try {
                OpenHelper openHelper = this.mDelegate;
                if (openHelper != null) {
                    openHelper.setWriteAheadLoggingEnabled(z);
                }
                this.mWriteAheadLoggingEnabled = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
