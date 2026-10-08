package androidx.room;

import android.os.CancellationSignal;
import androidx.navigation.NavController$handleDeepLink$2;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.service.data.Database_Impl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutinesRoom {
    public static final Object execute(Database_Impl database_Impl, Callable callable, ContinuationImpl continuationImpl) {
        if (database_Impl.isOpen() && database_Impl.mOpenHelper.getWritableDatabase().inTransaction()) {
            return callable.call();
        }
        if (continuationImpl.getContext().get(TransactionElement.Key) != null) {
            throw new ClassCastException();
        }
        Map map = database_Impl.mBackingFieldMap;
        Object executorCoroutineDispatcherImpl = map.get("TransactionDispatcher");
        if (executorCoroutineDispatcherImpl == null) {
            executorCoroutineDispatcherImpl = new ExecutorCoroutineDispatcherImpl(database_Impl.mTransactionExecutor);
            map.put("TransactionDispatcher", executorCoroutineDispatcherImpl);
        }
        return JobKt.withContext((CoroutineDispatcher) executorCoroutineDispatcherImpl, new DiskLruCache.AnonymousClass1(callable, null, 4), continuationImpl);
    }

    public static final Object execute(Database_Impl database_Impl, CancellationSignal cancellationSignal, Callable callable, ContinuationImpl continuationImpl) {
        if (database_Impl.isOpen() && database_Impl.mOpenHelper.getWritableDatabase().inTransaction()) {
            return callable.call();
        }
        if (continuationImpl.getContext().get(TransactionElement.Key) == null) {
            Map map = database_Impl.mBackingFieldMap;
            Object executorCoroutineDispatcherImpl = map.get("QueryDispatcher");
            if (executorCoroutineDispatcherImpl == null) {
                executorCoroutineDispatcherImpl = new ExecutorCoroutineDispatcherImpl(database_Impl.mQueryExecutor);
                map.put("QueryDispatcher", executorCoroutineDispatcherImpl);
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuationImpl));
            cancellableContinuationImpl.initCancellability();
            InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(callable, cancellableContinuationImpl, null, 3);
            cancellableContinuationImpl.invokeOnCancellation(new NavController$handleDeepLink$2(13, cancellationSignal, JobKt.launch$default(GlobalScope.INSTANCE, (CoroutineDispatcher) executorCoroutineDispatcherImpl, interruptibleKt$runInterruptible$2, 2)));
            return cancellableContinuationImpl.getResult();
        }
        throw new ClassCastException();
    }
}
