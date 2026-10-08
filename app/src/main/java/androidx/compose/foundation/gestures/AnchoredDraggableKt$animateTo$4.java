package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.node.NodeChain;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableKt$animateTo$4 extends SuspendLambda implements Function4 {
    public final /* synthetic */ AnimationSpec $animationSpec;
    public final /* synthetic */ NodeChain $this_animateTo;
    public /* synthetic */ AnchoredDraggableState$anchoredDragScope$1 L$0;
    public /* synthetic */ DefaultDraggableAnchors L$1;
    public /* synthetic */ Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableKt$animateTo$4(NodeChain nodeChain, AnimationSpec animationSpec, Continuation continuation) {
        super(4, continuation);
        this.$this_animateTo = nodeChain;
        this.$animationSpec = animationSpec;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        AnchoredDraggableKt$animateTo$4 anchoredDraggableKt$animateTo$4 = new AnchoredDraggableKt$animateTo$4(this.$this_animateTo, this.$animationSpec, (Continuation) obj4);
        anchoredDraggableKt$animateTo$4.L$0 = (AnchoredDraggableState$anchoredDragScope$1) obj;
        anchoredDraggableKt$animateTo$4.L$1 = (DefaultDraggableAnchors) obj2;
        anchoredDraggableKt$animateTo$4.L$2 = obj3;
        return anchoredDraggableKt$animateTo$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = this.L$0;
            DefaultDraggableAnchors defaultDraggableAnchors = this.L$1;
            Object obj2 = this.L$2;
            NodeChain nodeChain = this.$this_animateTo;
            float floatValue = ((ParcelableSnapshotMutableFloatState) nodeChain.current).getFloatValue();
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            Object objAccess$animateTo = ScrollableKt.access$animateTo(nodeChain, floatValue, anchoredDraggableState$anchoredDragScope$1, defaultDraggableAnchors, obj2, this.$animationSpec, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAccess$animateTo == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
