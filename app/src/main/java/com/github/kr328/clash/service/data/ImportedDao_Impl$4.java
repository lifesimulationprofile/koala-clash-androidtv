package com.github.kr328.clash.service.data;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.util.concurrent.Callable;
import kotlin.Unit;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImportedDao_Impl$4 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Dispatcher this$0;
    public final /* synthetic */ Imported val$imported;

    public /* synthetic */ ImportedDao_Impl$4(Dispatcher dispatcher, Imported imported, int i) {
        this.$r8$classId = i;
        this.this$0 = dispatcher;
        this.val$imported = imported;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                Dispatcher dispatcher = this.this$0;
                Database_Impl database_Impl = (Database_Impl) dispatcher.executorServiceOrNull;
                database_Impl.beginTransaction();
                try {
                    ImportedDao_Impl$1 importedDao_Impl$1 = (ImportedDao_Impl$1) dispatcher.readyAsyncCalls;
                    Imported imported = this.val$imported;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = importedDao_Impl$1.acquire();
                    try {
                        importedDao_Impl$1.bind(frameworkSQLiteStatementAcquire, imported);
                        long jExecuteInsert = frameworkSQLiteStatementAcquire.executeInsert();
                        importedDao_Impl$1.release(frameworkSQLiteStatementAcquire);
                        database_Impl.setTransactionSuccessful();
                        Long lValueOf = Long.valueOf(jExecuteInsert);
                        database_Impl.internalEndTransaction();
                        return lValueOf;
                    } catch (Throwable th) {
                        importedDao_Impl$1.release(frameworkSQLiteStatementAcquire);
                        throw th;
                    }
                } catch (Throwable th2) {
                    database_Impl.internalEndTransaction();
                    throw th2;
                }
            default:
                Dispatcher dispatcher2 = this.this$0;
                Database_Impl database_Impl2 = (Database_Impl) dispatcher2.executorServiceOrNull;
                database_Impl2.beginTransaction();
                try {
                    ImportedDao_Impl$2 importedDao_Impl$2 = (ImportedDao_Impl$2) dispatcher2.runningAsyncCalls;
                    Imported imported2 = this.val$imported;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire2 = importedDao_Impl$2.acquire();
                    try {
                        importedDao_Impl$2.bind(frameworkSQLiteStatementAcquire2, imported2);
                        frameworkSQLiteStatementAcquire2.executeUpdateDelete();
                        importedDao_Impl$2.release(frameworkSQLiteStatementAcquire2);
                        database_Impl2.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        database_Impl2.internalEndTransaction();
                        return unit;
                    } catch (Throwable th3) {
                        importedDao_Impl$2.release(frameworkSQLiteStatementAcquire2);
                        throw th3;
                    }
                } catch (Throwable th4) {
                    database_Impl2.internalEndTransaction();
                    throw th4;
                }
        }
    }
}
