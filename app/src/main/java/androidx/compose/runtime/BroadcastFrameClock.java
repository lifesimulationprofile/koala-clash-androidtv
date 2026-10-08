package androidx.compose.runtime;

import android.view.Choreographer;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.navigation.NavController$handleDeepLink$2;
import coil.disk.DiskLruCache;
import coil.util.ContinuationCallback;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BroadcastFrameClock implements CoroutineContext.Element {
    public final /* synthetic */ int $r8$classId;
    public final Object onNewAwaiters;
    public final Object queue;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FrameAwaiter extends AwaiterQueue$Awaiter {
        public CancellableContinuationImpl continuation;
        public Function1 onFrame;

        @Override // androidx.compose.runtime.internal.AwaiterQueue$Awaiter
        public final void cancel() {
            this.onFrame = null;
            this.continuation = null;
        }

        @Override // androidx.compose.runtime.internal.AwaiterQueue$Awaiter
        public final void resumeWithException(Throwable th) {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.resumeWith(new Result.Failure(th));
            }
        }
    }

    public BroadcastFrameClock(Choreographer choreographer, AndroidUiDispatcher androidUiDispatcher) {
        this.$r8$classId = 2;
        this.onNewAwaiters = choreographer;
        this.queue = androidUiDispatcher;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    private final Object withFrameNanos$androidx$compose$runtime$PausableMonotonicFrameClock(Function1 function1, Continuation continuation) {
        PausableMonotonicFrameClock$withFrameNanos$1 pausableMonotonicFrameClock$withFrameNanos$1;
        Object result;
        if (continuation instanceof PausableMonotonicFrameClock$withFrameNanos$1) {
            pausableMonotonicFrameClock$withFrameNanos$1 = (PausableMonotonicFrameClock$withFrameNanos$1) continuation;
            int i = pausableMonotonicFrameClock$withFrameNanos$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                pausableMonotonicFrameClock$withFrameNanos$1.label = i - Integer.MIN_VALUE;
            } else {
                pausableMonotonicFrameClock$withFrameNanos$1 = new PausableMonotonicFrameClock$withFrameNanos$1(this, continuation);
            }
        } else {
            pausableMonotonicFrameClock$withFrameNanos$1 = new PausableMonotonicFrameClock$withFrameNanos$1(this, continuation);
        }
        Object obj = pausableMonotonicFrameClock$withFrameNanos$1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = pausableMonotonicFrameClock$withFrameNanos$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DiskLruCache.Editor editor = (DiskLruCache.Editor) this.queue;
            pausableMonotonicFrameClock$withFrameNanos$1.L$0 = function1;
            pausableMonotonicFrameClock$withFrameNanos$1.label = 1;
            if (editor.isOpen()) {
                result = Unit.INSTANCE;
            } else {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(pausableMonotonicFrameClock$withFrameNanos$1));
                cancellableContinuationImpl.initCancellability();
                synchronized (editor.entry) {
                    ((ArrayList) editor.written).add(cancellableContinuationImpl);
                }
                cancellableContinuationImpl.invokeOnCancellation(new ContinuationCallback(3, editor, cancellableContinuationImpl));
                result = cancellableContinuationImpl.getResult();
                if (result != coroutineSingletons) {
                    result = Unit.INSTANCE;
                }
            }
            if (result != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        function1 = pausableMonotonicFrameClock$withFrameNanos$1.L$0;
        ResultKt.throwOnFailure(obj);
        BroadcastFrameClock broadcastFrameClock = (BroadcastFrameClock) this.onNewAwaiters;
        pausableMonotonicFrameClock$withFrameNanos$1.L$0 = null;
        pausableMonotonicFrameClock$withFrameNanos$1.label = 2;
        Object objWithFrameNanos = broadcastFrameClock.withFrameNanos(function1, pausableMonotonicFrameClock$withFrameNanos$1);
        return objWithFrameNanos == coroutineSingletons ? coroutineSingletons : objWithFrameNanos;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return NeverEqualPolicy.$$INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return CameraIdUtil.plus(this, coroutineContext);
    }

    public final Object withFrameNanos(final Function1 function1, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuation));
                cancellableContinuationImpl.initCancellability();
                Request request = (Request) this.queue;
                FrameAwaiter frameAwaiter = new FrameAwaiter();
                frameAwaiter.continuation = cancellableContinuationImpl;
                frameAwaiter.onFrame = function1;
                cancellableContinuationImpl.invokeOnCancellation(new RenderScriptBlurEffect$updateSurface$2$4(3, request.addAwaiter(frameAwaiter, (Recomposer$$ExternalSyntheticLambda1) this.onNewAwaiters)));
                return cancellableContinuationImpl.getResult();
            case 1:
                return withFrameNanos$androidx$compose$runtime$PausableMonotonicFrameClock(function1, continuation);
            default:
                AndroidUiDispatcher androidUiDispatcher = (AndroidUiDispatcher) this.queue;
                final CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(1, zzga.intercepted(continuation));
                cancellableContinuationImpl2.initCancellability();
                Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback(this, function1) { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1
                    public final /* synthetic */ Function1 $onFrame;

                    {
                        this.$onFrame = function1;
                    }

                    @Override // android.view.Choreographer.FrameCallback
                    public final void doFrame(long j) {
                        Object failure;
                        try {
                            failure = this.$onFrame.invoke(Long.valueOf(j));
                        } catch (Throwable th) {
                            failure = new Result.Failure(th);
                        }
                        this.$co.resumeWith(failure);
                    }
                };
                if (Intrinsics.areEqual(androidUiDispatcher.choreographer, (Choreographer) this.onNewAwaiters)) {
                    synchronized (androidUiDispatcher.lock) {
                        try {
                            androidUiDispatcher.toRunOnFrame.add(frameCallback);
                            if (!androidUiDispatcher.scheduledFrameDispatch) {
                                androidUiDispatcher.scheduledFrameDispatch = true;
                                androidUiDispatcher.choreographer.postFrameCallback(androidUiDispatcher.dispatchCallback);
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    cancellableContinuationImpl2.invokeOnCancellation(new NavController$handleDeepLink$2(7, androidUiDispatcher, frameCallback));
                } else {
                    ((Choreographer) this.onNewAwaiters).postFrameCallback(frameCallback);
                    cancellableContinuationImpl2.invokeOnCancellation(new NavController$handleDeepLink$2(8, this, frameCallback));
                }
                return cancellableContinuationImpl2.getResult();
        }
    }

    public BroadcastFrameClock(BroadcastFrameClock broadcastFrameClock) {
        this.$r8$classId = 1;
        this.onNewAwaiters = broadcastFrameClock;
        this.queue = new DiskLruCache.Editor(2, false);
    }

    public BroadcastFrameClock(Recomposer$$ExternalSyntheticLambda1 recomposer$$ExternalSyntheticLambda1) {
        this.$r8$classId = 0;
        this.onNewAwaiters = recomposer$$ExternalSyntheticLambda1;
        this.queue = new Request(6);
    }
}
