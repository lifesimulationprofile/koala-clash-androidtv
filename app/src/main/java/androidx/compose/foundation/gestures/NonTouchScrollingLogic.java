package androidx.compose.foundation.gestures;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.foundation.lazy.LazyListKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import coil.RealImageLoader$execute$3;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.SupervisorCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NonTouchScrollingLogic {
    public Density density;
    public boolean isScrolling;
    public final AdaptedFunctionReference onScrollStopped;
    public final ScrollingLogic scrollingLogic;
    public final SurfaceRequest.AnonymousClass1 velocityTracker = new SurfaceRequest.AnonymousClass1(21);

    /* JADX WARN: Multi-variable type inference failed */
    public NonTouchScrollingLogic(ScrollingLogic scrollingLogic, Function2 function2, Density density) {
        this.scrollingLogic = scrollingLogic;
        this.onScrollStopped = (AdaptedFunctionReference) function2;
        this.density = density;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public static void consume$foundation(PointerEvent pointerEvent) {
        ?? r3 = pointerEvent.changes;
        int size = r3.size();
        for (int i = 0; i < size; i++) {
            ((PointerInputChange) r3.get(i)).consume();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object userScroll$foundation(Function2 function2, ContinuationImpl continuationImpl) throws Throwable {
        NonTouchScrollingLogic$userScroll$1 nonTouchScrollingLogic$userScroll$1;
        if (continuationImpl instanceof NonTouchScrollingLogic$userScroll$1) {
            nonTouchScrollingLogic$userScroll$1 = (NonTouchScrollingLogic$userScroll$1) continuationImpl;
            int i = nonTouchScrollingLogic$userScroll$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nonTouchScrollingLogic$userScroll$1.label = i - Integer.MIN_VALUE;
            } else {
                nonTouchScrollingLogic$userScroll$1 = new NonTouchScrollingLogic$userScroll$1(this, continuationImpl);
            }
        } else {
            nonTouchScrollingLogic$userScroll$1 = new NonTouchScrollingLogic$userScroll$1(this, continuationImpl);
        }
        Object obj = nonTouchScrollingLogic$userScroll$1.result;
        int i2 = nonTouchScrollingLogic$userScroll$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.isScrolling = true;
            RealImageLoader$execute$3 realImageLoader$execute$3 = new RealImageLoader$execute$3(this, function2, null, 6);
            nonTouchScrollingLogic$userScroll$1.label = 1;
            SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(nonTouchScrollingLogic$userScroll$1, nonTouchScrollingLogic$userScroll$1._context);
            Object objStartUndispatchedOrReturn = LazyListKt.startUndispatchedOrReturn(supervisorCoroutine, supervisorCoroutine, realImageLoader$execute$3);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objStartUndispatchedOrReturn == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.isScrolling = false;
        return Unit.INSTANCE;
    }
}
