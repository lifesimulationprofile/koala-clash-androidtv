package androidx.compose.foundation.gestures;

import android.os.Build;
import android.view.ViewConfiguration;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.SequenceBuilderIterator;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MouseWheelScrollingLogic extends NonTouchScrollingLogic {
    public final BufferedChannel channel;
    public final PreviewView.AnonymousClass1 mouseWheelScrollConfig;
    public StandaloneCoroutine receivingMouseWheelEventsJob;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MouseWheelScrollDelta {
        public final boolean shouldApplyImmediately;
        public final long timeMillis;
        public final long value;

        public MouseWheelScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.shouldApplyImmediately = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MouseWheelScrollDelta)) {
                return false;
            }
            MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) obj;
            return Offset.m369equalsimpl0(this.value, mouseWheelScrollDelta.value) && this.timeMillis == mouseWheelScrollDelta.timeMillis && this.shouldApplyImmediately == mouseWheelScrollDelta.shouldApplyImmediately;
        }

        public final int hashCode() {
            int iM371hashCodeimpl = Offset.m371hashCodeimpl(this.value) * 31;
            long j = this.timeMillis;
            return ((iM371hashCodeimpl + ((int) (j ^ (j >>> 32)))) * 31) + (this.shouldApplyImmediately ? 1231 : 1237);
        }

        public final MouseWheelScrollDelta plus(MouseWheelScrollDelta mouseWheelScrollDelta) {
            return new MouseWheelScrollDelta(Offset.m373plusMKHz9U(this.value, mouseWheelScrollDelta.value), Math.max(this.timeMillis, mouseWheelScrollDelta.timeMillis), this.shouldApplyImmediately);
        }

        public final String toString() {
            return "MouseWheelScrollDelta(value=" + ((Object) Offset.m375toStringimpl(this.value)) + ", timeMillis=" + this.timeMillis + ", shouldApplyImmediately=" + this.shouldApplyImmediately + ')';
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public ScrollingLogic L$0;
        public Ref$FloatRef L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(MouseWheelScrollingLogic.this, null, null, 0.0f, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Ref$ObjectRef $animationState;
        public final /* synthetic */ float $speed;
        public final /* synthetic */ Ref$ObjectRef $targetScrollDelta;
        public final /* synthetic */ Ref$FloatRef $targetValue;
        public final /* synthetic */ ScrollingLogic $this_dispatchMouseWheelScroll;
        public final /* synthetic */ float $threshold;
        public int I$0;
        public /* synthetic */ Object L$0;
        public Ref$BooleanRef L$1;
        public Ref$BooleanRef L$2;
        public int label;
        public final /* synthetic */ MouseWheelScrollingLogic this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Ref$FloatRef ref$FloatRef, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, float f, MouseWheelScrollingLogic mouseWheelScrollingLogic, float f2, ScrollingLogic scrollingLogic, Continuation continuation) {
            super(2, continuation);
            this.$targetValue = ref$FloatRef;
            this.$animationState = ref$ObjectRef;
            this.$targetScrollDelta = ref$ObjectRef2;
            this.$threshold = f;
            this.this$0 = mouseWheelScrollingLogic;
            this.$speed = f2;
            this.$this_dispatchMouseWheelScroll = scrollingLogic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$targetValue, this.$animationState, this.$targetScrollDelta, this.$threshold, this.this$0, this.$speed, this.$this_dispatchMouseWheelScroll, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0071  */
        /* JADX WARN: Code duplicated, block: B:18:0x0091  */
        /* JADX WARN: Code duplicated, block: B:20:0x009b  */
        /* JADX WARN: Code duplicated, block: B:42:0x01ad  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006c -> B:14:0x006d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x017a -> B:37:0x017b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 449
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public MouseWheelScrollingLogic(ScrollingLogic scrollingLogic, PreviewView.AnonymousClass1 anonymousClass1, ComposableLambdaImpl.AnonymousClass1 anonymousClass2, Density density) {
        super(scrollingLogic, anonymousClass2, density);
        this.mouseWheelScrollConfig = anonymousClass1;
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, 0, 6);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0163, code lost:
    
        if (r0.invoke(r1, r10) == r14) goto L40;
     */
    /* JADX WARN: Type inference failed for: r0v19, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.AdaptedFunctionReference] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object access$dispatchMouseWheelScroll(androidx.compose.foundation.gestures.MouseWheelScrollingLogic r20, androidx.compose.foundation.gestures.ScrollingLogic r21, androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta r22, float r23, float r24, kotlin.coroutines.jvm.internal.ContinuationImpl r25) {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(androidx.compose.foundation.gestures.MouseWheelScrollingLogic, androidx.compose.foundation.gestures.ScrollingLogic, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta, float, float, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static final Object access$dispatchMouseWheelScroll$waitNextScrollDelta(MouseWheelScrollingLogic mouseWheelScrollingLogic, Ref$ObjectRef ref$ObjectRef, Ref$FloatRef ref$FloatRef, ScrollingLogic scrollingLogic, Ref$ObjectRef ref$ObjectRef2, long j, ContinuationImpl continuationImpl) throws Throwable {
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1 mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1;
        Ref$FloatRef ref$FloatRef2;
        ScrollingLogic scrollingLogic2;
        Ref$ObjectRef ref$ObjectRef3;
        boolean z;
        if (continuationImpl instanceof MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1) {
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1 = (MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1) continuationImpl;
            int i = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.label = i - Integer.MIN_VALUE;
            } else {
                mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1(continuationImpl);
            }
        } else {
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1(continuationImpl);
        }
        Object objWithTimeoutOrNull = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.result;
        int i2 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
            if (j < 0) {
                return Boolean.FALSE;
            }
            ThumbNode.AnonymousClass1 anonymousClass1 = new ThumbNode.AnonymousClass1(mouseWheelScrollingLogic, (Continuation) null, 5);
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$0 = mouseWheelScrollingLogic;
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$1 = ref$ObjectRef;
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$2 = ref$FloatRef;
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$3 = scrollingLogic;
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$4 = ref$ObjectRef2;
            mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.label = 1;
            objWithTimeoutOrNull = JobKt.withTimeoutOrNull(j, anonymousClass1, mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithTimeoutOrNull == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$FloatRef2 = ref$FloatRef;
            scrollingLogic2 = scrollingLogic;
            ref$ObjectRef3 = ref$ObjectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref$ObjectRef ref$ObjectRef4 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$4;
            ScrollingLogic scrollingLogic3 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$3;
            ref$FloatRef2 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$2;
            Ref$ObjectRef ref$ObjectRef5 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$1;
            MouseWheelScrollingLogic mouseWheelScrollingLogic2 = mouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1.L$0;
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
            ref$ObjectRef3 = ref$ObjectRef4;
            scrollingLogic2 = scrollingLogic3;
            ref$ObjectRef = ref$ObjectRef5;
            mouseWheelScrollingLogic = mouseWheelScrollingLogic2;
        }
        MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) objWithTimeoutOrNull;
        if (mouseWheelScrollDelta != null) {
            boolean z2 = ((MouseWheelScrollDelta) ref$ObjectRef.element).shouldApplyImmediately;
            long j2 = mouseWheelScrollDelta.value;
            ref$ObjectRef.element = new MouseWheelScrollDelta(j2, mouseWheelScrollDelta.timeMillis, z2);
            ref$FloatRef2.element = scrollingLogic2.m109toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic2.m106reverseIfNeededMKHz9U(j2));
            ref$ObjectRef3.element = ArcSplineKt.AnimationState$default(0.0f, 0.0f, 30);
            SurfaceRequest.AnonymousClass1 anonymousClass2 = mouseWheelScrollingLogic.velocityTracker;
            long j3 = mouseWheelScrollDelta.timeMillis;
            long j4 = mouseWheelScrollDelta.value;
            ((VelocityTracker1D) anonymousClass2.val$requestCancellationCompleter).addDataPoint(Float.intBitsToFloat((int) (j4 >> 32)), j3);
            ((VelocityTracker1D) anonymousClass2.val$requestCancellationFuture).addDataPoint(Float.intBitsToFloat((int) (j4 & 4294967295L)), j3);
            z = !MouseWheelScrollingLogicKt.access$isLowScrollingDelta(ref$FloatRef2.element);
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MouseWheelScrollDelta sumOrNull(BufferedChannel bufferedChannel) {
        MouseWheelScrollDelta mouseWheelScrollDelta = null;
        SequenceBuilderIterator it = MatrixExt.iterator(new ForEachGestureKt$awaitEachGesture$2((Object) new TrackpadScrollingLogic$$ExternalSyntheticLambda0(bufferedChannel, 1), (Continuation) (0 == true ? 1 : 0), 1));
        while (it.hasNext()) {
            MouseWheelScrollDelta mouseWheelScrollDeltaPlus = (MouseWheelScrollDelta) it.next();
            if (mouseWheelScrollDelta != null) {
                mouseWheelScrollDeltaPlus = mouseWheelScrollDelta.plus(mouseWheelScrollDeltaPlus);
            }
            mouseWheelScrollDelta = mouseWheelScrollDeltaPlus;
        }
        return mouseWheelScrollDelta;
    }

    public final float dispatchMouseWheelScroll(ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1, float f) {
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        long jM108toOffsettuRUvjQ = scrollingLogic.m108toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(f));
        ScrollingLogic scrollingLogic2 = scrollingLogic$nestedScrollScope$1.this$0;
        return scrollingLogic.m107toFloatk4lQ0M(scrollingLogic.m106reverseIfNeededMKHz9U(scrollingLogic2.m105performScroll3eAAhYA(scrollingLogic2.outerStateScope, jM108toOffsettuRUvjQ, 1)));
    }

    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX INFO: renamed from: onMouseWheel-O0kMr_c, reason: not valid java name */
    public final boolean m85onMouseWheelO0kMr_c(PointerEvent pointerEvent) {
        long j;
        Density density = this.density;
        PreviewView.AnonymousClass1 anonymousClass1 = this.mouseWheelScrollConfig;
        ViewConfiguration viewConfiguration = (ViewConfiguration) anonymousClass1.this$0;
        int i = Build.VERSION.SDK_INT;
        float f = -(i > 26 ? ViewConfigurationApi26Impl.getVerticalScrollFactor(viewConfiguration) : density.mo92toPx0680j_4(64));
        float f2 = -(i > 26 ? ViewConfigurationApi26Impl.getHorizontalScrollFactor(viewConfiguration) : density.mo92toPx0680j_4(64));
        ?? r2 = pointerEvent.changes;
        Offset offset = new Offset(0L);
        int size = r2.size();
        boolean canScrollForward = false;
        int i2 = 0;
        while (true) {
            j = offset.packedValue;
            if (i2 >= size) {
                break;
            }
            offset = new Offset(Offset.m373plusMKHz9U(j, ((PointerInputChange) r2.get(i2)).scrollDelta));
            i2++;
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) * f2)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) * f)) & 4294967295L);
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        float fM109toSingleAxisDeltaFromAnglek4lQ0M = scrollingLogic.m109toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m106reverseIfNeededMKHz9U(jFloatToRawIntBits));
        if (fM109toSingleAxisDeltaFromAnglek4lQ0M != 0.0f) {
            canScrollForward = fM109toSingleAxisDeltaFromAnglek4lQ0M > 0.0f ? scrollingLogic.scrollableState.getCanScrollForward() : scrollingLogic.scrollableState.getCanScrollBackward();
        }
        if (!canScrollForward) {
            return this.isScrolling;
        }
        long j2 = ((PointerInputChange) CollectionsKt.first((List) pointerEvent.changes)).uptimeMillis;
        anonymousClass1.getClass();
        return !(this.channel.mo842trySendJP2dKIU(new MouseWheelScrollDelta(jFloatToRawIntBits, j2, false)) instanceof ChannelResult.Failed);
    }
}
