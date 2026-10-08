package androidx.room;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import com.github.kr328.clash.service.data.Database_Impl;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    public final Database_Impl mDatabase;
    public final AtomicBoolean mLock = new AtomicBoolean(false);
    public volatile FrameworkSQLiteStatement mStmt;

    public SharedSQLiteStatement(Database_Impl database_Impl) {
        this.mDatabase = database_Impl;
    }

    public final FrameworkSQLiteStatement acquire() {
        this.mDatabase.assertNotMainThread();
        if (!this.mLock.compareAndSet(false, true)) {
            String strCreateQuery = createQuery();
            Database_Impl database_Impl = this.mDatabase;
            database_Impl.assertNotMainThread();
            database_Impl.assertNotSuspendingTransaction();
            return database_Impl.mOpenHelper.getWritableDatabase().compileStatement(strCreateQuery);
        }
        if (this.mStmt == null) {
            String strCreateQuery2 = createQuery();
            Database_Impl database_Impl2 = this.mDatabase;
            database_Impl2.assertNotMainThread();
            database_Impl2.assertNotSuspendingTransaction();
            this.mStmt = database_Impl2.mOpenHelper.getWritableDatabase().compileStatement(strCreateQuery2);
        }
        return this.mStmt;
    }

    public abstract String createQuery();

    public final void release(FrameworkSQLiteStatement frameworkSQLiteStatement) {
        if (frameworkSQLiteStatement == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
