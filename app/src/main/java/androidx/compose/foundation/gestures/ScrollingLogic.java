package androidx.compose.foundation.gestures;

import android.view.ViewTreeObserver;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Velocity;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import java.lang.reflect.Method;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic {
    public FlingBehavior flingBehavior;
    public boolean isFlinging;
    public final ScrollableNode$$ExternalSyntheticLambda0 isScrollableNodeAttached;
    public Dispatcher nestedScrollDispatcher;
    public final ScrollableNode onScrollChangedDispatcher;
    public Orientation orientation;
    public AndroidEdgeEffectOverscrollEffect overscrollEffect;
    public boolean reverseDirection;
    public ScrollableState scrollableState;
    public int latestScrollSource = 1;
    public ScrollScope outerStateScope = ScrollableKt.NoOpScrollScope;
    public final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new ScrollingLogic$nestedScrollScope$1(this);
    public final Recomposer$$ExternalSyntheticLambda0 performScrollForOverscroll = new Recomposer$$ExternalSyntheticLambda0(6, this);

    public ScrollingLogic(ScrollableState scrollableState, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, Dispatcher dispatcher, ScrollableNode scrollableNode, ScrollableNode$$ExternalSyntheticLambda0 scrollableNode$$ExternalSyntheticLambda0) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = dispatcher;
        this.onScrollChangedDispatcher = scrollableNode;
        this.isScrollableNodeAttached = scrollableNode$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    public final Object m103doFlingAnimationQWom1Mo(long j, ContinuationImpl continuationImpl) throws Throwable {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        ScrollingLogic scrollingLogic;
        Throwable th;
        Ref$LongRef ref$LongRef;
        if (continuationImpl instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuationImpl;
            int i = scrollingLogic$doFlingAnimation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuationImpl);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuationImpl);
        }
        Object obj = scrollingLogic$doFlingAnimation$1.result;
        int i2 = scrollingLogic$doFlingAnimation$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$LongRef = scrollingLogic$doFlingAnimation$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                scrollingLogic = this;
                scrollingLogic.isFlinging = false;
                return new Velocity(ref$LongRef.element);
            } catch (Throwable th2) {
                th = th2;
                scrollingLogic = this;
                scrollingLogic.isFlinging = false;
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = j;
        this.isFlinging = true;
        try {
            MutatePriority mutatePriority = MutatePriority.Default;
            scrollingLogic = this;
            try {
                ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(scrollingLogic, ref$LongRef2, j, null);
                scrollingLogic$doFlingAnimation$1.L$0 = ref$LongRef2;
                scrollingLogic$doFlingAnimation$1.label = 1;
                Object objScroll = scroll(mutatePriority, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objScroll == coroutineSingletons) {
                    return coroutineSingletons;
                }
                ref$LongRef = ref$LongRef2;
                scrollingLogic.isFlinging = false;
                return new Velocity(ref$LongRef.element);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                scrollingLogic.isFlinging = false;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            scrollingLogic = this;
        }
    }

    /* JADX INFO: renamed from: onScrollStopped-BMRW4eQ, reason: not valid java name */
    public final Object m104onScrollStoppedBMRW4eQ(long j, boolean z, SuspendLambda suspendLambda) {
        if (z && (this.flingBehavior instanceof DefaultFlingBehavior)) {
            return Unit.INSTANCE;
        }
        long jM733copyOhffZ5M$default = Velocity.m733copyOhffZ5M$default(j, 0.0f, 0.0f, this.orientation == Orientation.Horizontal ? 1 : 2);
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.overscrollEffect;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (androidEdgeEffectOverscrollEffect != null && (this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward())) {
            Object objM39applyToFlingBMRW4eQ = androidEdgeEffectOverscrollEffect.m39applyToFlingBMRW4eQ(jM733copyOhffZ5M$default, scrollingLogic$onScrollStopped$performFling$1, suspendLambda);
            return objM39applyToFlingBMRW4eQ == coroutineSingletons ? objM39applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$2 = new ScrollingLogic$onScrollStopped$performFling$1(this, suspendLambda);
        scrollingLogic$onScrollStopped$performFling$2.J$0 = jM733copyOhffZ5M$default;
        Unit unit = Unit.INSTANCE;
        Object objInvokeSuspend = scrollingLogic$onScrollStopped$performFling$2.invokeSuspend(unit);
        return objInvokeSuspend == coroutineSingletons ? objInvokeSuspend : unit;
    }

    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m105performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        NestedScrollNode nestedScrollNode = (NestedScrollNode) this.nestedScrollDispatcher.executorServiceOrNull;
        NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
        long jMo102onPreScrollOzD1aCk = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo102onPreScrollOzD1aCk(i, j) : 0L;
        long jM372minusMKHz9U = Offset.m372minusMKHz9U(j, jMo102onPreScrollOzD1aCk);
        long jM106reverseIfNeededMKHz9U = m106reverseIfNeededMKHz9U(m108toOffsettuRUvjQ(scrollScope.scrollBy(m107toFloatk4lQ0M(m106reverseIfNeededMKHz9U(this.orientation == Orientation.Horizontal ? Offset.m368copydBAh8RU$default(0.0f, 1, jM372minusMKHz9U) : Offset.m368copydBAh8RU$default(0.0f, 2, jM372minusMKHz9U))))));
        ScrollableNode scrollableNode = this.onScrollChangedDispatcher;
        if (scrollableNode.isAttached) {
            ViewTreeObserver viewTreeObserver = ((AndroidComposeView) HitTestResultKt.requireOwner(scrollableNode)).getViewTreeObserver();
            try {
                if (AndroidComposeView.dispatchOnScrollChangedMethod == null) {
                    Method declaredMethod = viewTreeObserver.getClass().getDeclaredMethod("dispatchOnScrollChanged", null);
                    declaredMethod.setAccessible(true);
                    AndroidComposeView.dispatchOnScrollChangedMethod = declaredMethod;
                }
                Method method = AndroidComposeView.dispatchOnScrollChangedMethod;
                if (method != null) {
                    method.invoke(viewTreeObserver, null);
                }
            } catch (Exception unused) {
            }
        }
        long jM372minusMKHz9U2 = Offset.m372minusMKHz9U(jM372minusMKHz9U, jM106reverseIfNeededMKHz9U);
        NestedScrollNode nestedScrollNode2 = (NestedScrollNode) this.nestedScrollDispatcher.executorServiceOrNull;
        NestedScrollNode parentNestedScrollNode$ui2 = nestedScrollNode2 != null ? nestedScrollNode2.getParentNestedScrollNode$ui() : null;
        return Offset.m373plusMKHz9U(Offset.m373plusMKHz9U(jMo102onPreScrollOzD1aCk, jM106reverseIfNeededMKHz9U), parentNestedScrollNode$ui2 != null ? parentNestedScrollNode$ui2.mo100onPostScrollDzOQY0M(jM106reverseIfNeededMKHz9U, jM372minusMKHz9U2, i) : 0L);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m106reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m374timestuRUvjQ(-1.0f, j) : j;
    }

    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, new NavHostKt$NavHost$28$1(this, function2, (Continuation) null, 12), continuationImpl);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m107toFloatk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m108toOffsettuRUvjQ(float f) {
        long jFloatToRawIntBits;
        long j;
        if (f == 0.0f) {
            return 0L;
        }
        if (this.orientation == Orientation.Horizontal) {
            long jFloatToRawIntBits2 = Float.floatToRawIntBits(f);
            jFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
            j = jFloatToRawIntBits2 << 32;
        } else {
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(0.0f);
            jFloatToRawIntBits = Float.floatToRawIntBits(f);
            j = jFloatToRawIntBits3 << 32;
        }
        return j | (4294967295L & jFloatToRawIntBits);
    }

    /* JADX INFO: renamed from: toSingleAxisDeltaFromAngle-k-4lQ0M, reason: not valid java name */
    public final float m109toSingleAxisDeltaFromAnglek4lQ0M(long j) {
        int i = (int) (4294967295L & j);
        int i2 = (int) (j >> 32);
        if (((float) Math.atan2(Math.abs(Float.intBitsToFloat(i)), Math.abs(Float.intBitsToFloat(i2)))) >= 0.7853981633974483d) {
            if (this.orientation == Orientation.Vertical) {
                return Float.intBitsToFloat(i);
            }
            return 0.0f;
        }
        if (this.orientation == Orientation.Horizontal) {
            return Float.intBitsToFloat(i2);
        }
        return 0.0f;
    }
}
