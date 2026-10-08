package androidx.camera.core.impl.utils.futures;

import androidx.appcompat.widget.Toolbar;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.Preconditions;
import com.google.android.gms.tasks.zzg;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Futures {
    public static Object getDone(Future future) {
        Preconditions.checkState("Future was expected to be done, " + future, future.isDone());
        return getUninterruptibly(future);
    }

    public static Object getUninterruptibly(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static ImmediateFuture$ImmediateFailedFuture immediateFuture(Object obj) {
        return obj == null ? ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE : new ImmediateFuture$ImmediateFailedFuture(1, obj);
    }

    public static ListenableFuture nonCancellationPropagating(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        return listenableFuture.isDone() ? listenableFuture : CallbackToFutureAdapter.getFuture(new Futures$$ExternalSyntheticLambda3(listenableFuture, 1));
    }

    public static void propagateTransform(boolean z, ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, zzt zztVar) {
        listenableFuture.getClass();
        completer.getClass();
        zztVar.getClass();
        listenableFuture.addListener(new zzi(1, listenableFuture, new Toolbar.AnonymousClass1(20, completer)), zztVar);
        if (z) {
            zzg zzgVar = new zzg(7, listenableFuture);
            zzt zztVarDirectExecutor = HexFormatKt.directExecutor();
            ResolvableFuture resolvableFuture = completer.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(zzgVar, zztVarDirectExecutor);
            }
        }
    }

    public static ChainingListenableFuture transformAsync(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, listenableFuture);
        listenableFuture.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }
}
