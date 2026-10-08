package com.google.android.gms.tasks;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import coil.memory.RealWeakMemoryCache;
import com.google.android.gms.common.api.internal.zaae;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzg implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public /* synthetic */ zzg(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    private final void run$androidx$camera$core$impl$utils$executor$SequentialExecutor$QueueWorker() {
        try {
            workOnQueue();
        } catch (Error e) {
            synchronized (((SequentialExecutor) this.zza).mQueue) {
                ((SequentialExecutor) this.zza).mWorkerRunningState = 1;
                throw e;
            }
        }
    }

    private final void run$androidx$room$InvalidationTracker$1() {
        ReentrantReadWriteLock.ReadLock lock = ((InvalidationTracker) this.zza).mDatabase.mCloseLock.readLock();
        lock.lock();
        HashSet hashSetCheckUpdatedTable = null;
        try {
            try {
                if (!((InvalidationTracker) this.zza).ensureInitialization()) {
                    lock.unlock();
                    return;
                }
                if (!((InvalidationTracker) this.zza).mPendingRefresh.compareAndSet(true, false)) {
                    lock.unlock();
                    return;
                }
                if (((InvalidationTracker) this.zza).mDatabase.mOpenHelper.getWritableDatabase().inTransaction()) {
                    lock.unlock();
                    return;
                }
                FrameworkSQLiteDatabase writableDatabase = ((InvalidationTracker) this.zza).mDatabase.mOpenHelper.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    hashSetCheckUpdatedTable = checkUpdatedTable();
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    lock.unlock();
                    if (hashSetCheckUpdatedTable == null || hashSetCheckUpdatedTable.isEmpty()) {
                        return;
                    }
                    synchronized (((InvalidationTracker) this.zza).mObserverMap) {
                        try {
                            SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) ((InvalidationTracker) this.zza).mObserverMap.iterator();
                            if (ascendingIterator.hasNext()) {
                                ((InvalidationTracker.ObserverWrapper) ((Map.Entry) ascendingIterator.next()).getValue()).getClass();
                                throw null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    writableDatabase.endTransaction();
                    throw th2;
                }
            } catch (Throwable th3) {
                lock.unlock();
                throw th3;
            }
        } catch (SQLiteException | IllegalStateException e) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
        }
    }

    private final void run$com$google$android$gms$tasks$zzg() {
        synchronized (((zzh) this.zza).zzb) {
            ((OnCanceledListener) ((zzh) this.zza).zzc).onCanceled();
        }
    }

    public HashSet checkUpdatedTable() {
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = ((InvalidationTracker) this.zza).mDatabase.query(new Symbol("SELECT * FROM room_table_modification_log WHERE invalidated = 1;", 1));
        while (cursorQuery.moveToNext()) {
            try {
                hashSet.add(Integer.valueOf(cursorQuery.getInt(0)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        if (!hashSet.isEmpty()) {
            ((InvalidationTracker) this.zza).mCleanupStatement.executeUpdateDelete();
        }
        return hashSet;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    /* JADX WARN: Code duplicated, block: B:93:0x0225  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzg.run():void");
    }

    /* JADX WARN: Code duplicated, block: B:42:0x003a A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r1 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        r4.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        androidx.camera.core.Logger.e("SequentialExecutor", "Exception while executing runnable " + r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void workOnQueue() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.zza     // Catch: java.lang.Throwable -> L4f
            androidx.camera.core.impl.utils.executor.SequentialExecutor r2 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r2     // Catch: java.lang.Throwable -> L4f
            java.util.ArrayDeque r2 = r2.mQueue     // Catch: java.lang.Throwable -> L4f
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L4f
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.zza     // Catch: java.lang.Throwable -> L20
            androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.mWorkerRunningState     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L44
        L18:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L44
        L20:
            r0 = move-exception
            goto L69
        L22:
            long r6 = r0.mWorkerRunCount     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.mWorkerRunCount = r6     // Catch: java.lang.Throwable -> L20
            r0.mWorkerRunningState = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.zza     // Catch: java.lang.Throwable -> L20
            androidx.camera.core.impl.utils.executor.SequentialExecutor r4 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.mQueue     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L45
            java.lang.Object r0 = r10.zza     // Catch: java.lang.Throwable -> L20
            androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r0     // Catch: java.lang.Throwable -> L20
            r0.mWorkerRunningState = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L44
            goto L18
        L44:
            return
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L4f
            r1 = r1 | r2
            r4.run()     // Catch: java.lang.Throwable -> L4f java.lang.RuntimeException -> L51
            goto L2
        L4f:
            r0 = move-exception
            goto L6b
        L51:
            r2 = move-exception
            java.lang.String r3 = "SequentialExecutor"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r5.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r6 = "Exception while executing runnable "
            r5.append(r6)     // Catch: java.lang.Throwable -> L4f
            r5.append(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L4f
            androidx.camera.core.Logger.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L4f
            goto L2
        L69:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L4f
        L6b:
            if (r1 == 0) goto L74
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L74:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzg.workOnQueue():void");
    }

    public zzg(zaae zaaeVar, RealWeakMemoryCache realWeakMemoryCache) {
        this.$r8$classId = 23;
        this.zza = realWeakMemoryCache;
    }
}
