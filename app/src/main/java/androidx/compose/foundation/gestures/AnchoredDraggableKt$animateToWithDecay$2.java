package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.ui.node.NodeChain;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableKt$animateToWithDecay$2 extends SuspendLambda implements Function4 {
    public final /* synthetic */ DecayAnimationSpecImpl $decayAnimationSpec;
    public final /* synthetic */ Ref$FloatRef $remainingVelocity;
    public final /* synthetic */ AnimationSpec $snapAnimationSpec;
    public final /* synthetic */ NodeChain $this_animateToWithDecay;
    public final /* synthetic */ float $velocity;
    public /* synthetic */ AnchoredDraggableState$anchoredDragScope$1 L$0;
    public /* synthetic */ DefaultDraggableAnchors L$1;
    public /* synthetic */ Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableKt$animateToWithDecay$2(NodeChain nodeChain, float f, AnimationSpec animationSpec, Ref$FloatRef ref$FloatRef, DecayAnimationSpecImpl decayAnimationSpecImpl, Continuation continuation) {
        super(4, continuation);
        this.$this_animateToWithDecay = nodeChain;
        this.$velocity = f;
        this.$snapAnimationSpec = animationSpec;
        this.$remainingVelocity = ref$FloatRef;
        this.$decayAnimationSpec = decayAnimationSpecImpl;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        Ref$FloatRef ref$FloatRef = this.$remainingVelocity;
        DecayAnimationSpecImpl decayAnimationSpecImpl = this.$decayAnimationSpec;
        AnchoredDraggableKt$animateToWithDecay$2 anchoredDraggableKt$animateToWithDecay$2 = new AnchoredDraggableKt$animateToWithDecay$2(this.$this_animateToWithDecay, this.$velocity, this.$snapAnimationSpec, ref$FloatRef, decayAnimationSpecImpl, (Continuation) obj4);
        anchoredDraggableKt$animateToWithDecay$2.L$0 = (AnchoredDraggableState$anchoredDragScope$1) obj;
        anchoredDraggableKt$animateToWithDecay$2.L$1 = (DefaultDraggableAnchors) obj2;
        anchoredDraggableKt$animateToWithDecay$2.L$2 = obj3;
        return anchoredDraggableKt$animateToWithDecay$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a8, code lost:
    
        if (androidx.compose.animation.core.ArcSplineKt.animateDecay(r0, r3, false, r4, r14) == r13) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ba, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollableKt.access$animateTo(r14.$this_animateToWithDecay, r6, r7, r8, r9, r14.$snapAnimationSpec, r14) == r13) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ce, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollableKt.access$animateTo(r14.$this_animateToWithDecay, r6, r7, r8, r9, r14.$snapAnimationSpec, r14) == r13) goto L42;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
