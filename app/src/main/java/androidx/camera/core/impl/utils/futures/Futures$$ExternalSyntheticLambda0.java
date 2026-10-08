package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.gms.tasks.zzt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Futures$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ListenableFuture f$0;
    public final /* synthetic */ ScheduledExecutorService f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ Futures$$ExternalSyntheticLambda0(ListenableFuture listenableFuture, ScheduledExecutorService scheduledExecutorService, long j) {
        this.f$0 = listenableFuture;
        this.f$1 = scheduledExecutorService;
        this.f$2 = j;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
        zzt zztVarDirectExecutor = HexFormatKt.directExecutor();
        final ListenableFuture listenableFuture = this.f$0;
        Futures.propagateTransform(true, listenableFuture, completer, zztVarDirectExecutor);
        if (!listenableFuture.isDone()) {
            final long j = this.f$2;
            listenableFuture.addListener(new Preview$$ExternalSyntheticLambda0(16, this.f$1.schedule(new Callable() { // from class: androidx.camera.core.impl.utils.futures.Futures$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(completer.setException(new TimeoutException("Future[" + listenableFuture + "] is not done within " + j + " ms.")));
                }
            }, j, TimeUnit.MILLISECONDS)), HexFormatKt.directExecutor());
        }
        return "TimeoutFuture[" + listenableFuture + "]";
    }
}
