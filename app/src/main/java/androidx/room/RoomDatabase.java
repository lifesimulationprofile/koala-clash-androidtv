package androidx.room;

import android.database.Cursor;
import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    public volatile FrameworkSQLiteDatabase mDatabase;
    public SupportSQLiteOpenHelper mOpenHelper;
    public ArchTaskExecutor$$ExternalSyntheticLambda0 mQueryExecutor;
    public TransactionExecutor mTransactionExecutor;
    public final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    public final ThreadLocal mSuspendingTransactionId = new ThreadLocal();
    public final Map mBackingFieldMap = Collections.synchronizedMap(new HashMap());
    public final InvalidationTracker mInvalidationTracker = createInvalidationTracker();
    public final HashMap mTypeConverters = new HashMap();
    public final HashMap mAutoMigrationSpecs = new HashMap();

    public static Object unwrapOpenHelper(Class cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    public final void assertNotMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void assertNotSuspendingTransaction() {
        if (!this.mOpenHelper.getWritableDatabase().inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void beginTransaction() {
        assertNotMainThread();
        assertNotMainThread();
        FrameworkSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    public List getAutoMigrations() {
        return Collections.EMPTY_LIST;
    }

    public Set getRequiredAutoMigrationSpecs() {
        return Collections.EMPTY_SET;
    }

    public Map getRequiredTypeConverters() {
        return Collections.EMPTY_MAP;
    }

    public final void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (this.mOpenHelper.getWritableDatabase().inTransaction()) {
            return;
        }
        InvalidationTracker invalidationTracker = this.mInvalidationTracker;
        if (invalidationTracker.mPendingRefresh.compareAndSet(false, true)) {
            invalidationTracker.mDatabase.mQueryExecutor.execute(invalidationTracker.mRefreshRunnable);
        }
    }

    public final boolean isOpen() {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.mDatabase;
        return frameworkSQLiteDatabase != null && frameworkSQLiteDatabase.mDelegate.isOpen();
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    public final void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }
}
