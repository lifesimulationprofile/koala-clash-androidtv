package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.unit.Density;
import androidx.core.view.MenuHostHelper;
import coil.RealImageLoader$execute$3;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableNode extends DragGestureNode {
    public Density density;
    public BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 flingBehavior;
    public Orientation orientation;
    public FlingBehavior resolvedFlingBehavior;
    public Boolean reverseDirection;
    public NodeChain state;

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$fling(AnchoredDraggableNode anchoredDraggableNode, float f, ContinuationImpl continuationImpl) {
        AnchoredDraggableNode$fling$1 anchoredDraggableNode$fling$1;
        Ref$FloatRef ref$FloatRef;
        if (continuationImpl instanceof AnchoredDraggableNode$fling$1) {
            anchoredDraggableNode$fling$1 = (AnchoredDraggableNode$fling$1) continuationImpl;
            int i = anchoredDraggableNode$fling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anchoredDraggableNode$fling$1.label = i - Integer.MIN_VALUE;
            } else {
                anchoredDraggableNode$fling$1 = new AnchoredDraggableNode$fling$1(anchoredDraggableNode, continuationImpl);
            }
        } else {
            anchoredDraggableNode$fling$1 = new AnchoredDraggableNode$fling$1(anchoredDraggableNode, continuationImpl);
        }
        Object obj = anchoredDraggableNode$fling$1.result;
        int i2 = anchoredDraggableNode$fling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (anchoredDraggableNode.state.getUsePreModifierChangeBehavior$foundation()) {
                NodeChain nodeChain = anchoredDraggableNode.state;
                anchoredDraggableNode$fling$1.label = 1;
                if (!nodeChain.getUsePreModifierChangeBehavior$foundation()) {
                    InlineClassHelperKt.throwIllegalArgumentException("AnchoredDraggableState was configured through a constructor without providing positional and velocity threshold. This overload of settle has been deprecated. Please refer to AnchoredDraggableState#settle(animationSpec) for more information.");
                }
                ((ParcelableSnapshotMutableState) nodeChain.innerCoordinator).getValue();
                nodeChain.getAnchors();
                nodeChain.requireOffset();
                Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
                throw null;
            }
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            ref$FloatRef2.element = f;
            NodeChain nodeChain2 = anchoredDraggableNode.state;
            AnchoredDraggableNode$fling$2 anchoredDraggableNode$fling$2 = new AnchoredDraggableNode$fling$2(anchoredDraggableNode, ref$FloatRef2, f, null);
            anchoredDraggableNode$fling$1.L$0 = ref$FloatRef2;
            anchoredDraggableNode$fling$1.label = 2;
            Object objAnchoredDrag$default = NodeChain.anchoredDrag$default(nodeChain2, anchoredDraggableNode$fling$2, anchoredDraggableNode$fling$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnchoredDrag$default == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$FloatRef = anchoredDraggableNode$fling$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Float(ref$FloatRef.element);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final Object drag(DragGestureNode.AnonymousClass1 anonymousClass1, DragGestureNode.AnonymousClass1 anonymousClass2) {
        Object objAnchoredDrag$default = NodeChain.anchoredDrag$default(this.state, new FlowKt__MergeKt$mapLatest$1(anonymousClass1, this, null), anonymousClass2);
        return objAnchoredDrag$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        updateFlingBehavior(this.flingBehavior);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
        onCancelPointerInput();
        if (this.isAttached) {
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            Density density2 = this.density;
            if (density2 == null || !density2.equals(density)) {
                this.density = density;
                updateFlingBehavior(this.flingBehavior);
            }
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final void onDragStopped(DragEvent.DragStopped dragStopped) {
        if (this.isAttached) {
            JobKt.launch$default(getCoroutineScope(), null, new RealImageLoader$execute$3(this, dragStopped, null, 4), 3);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final boolean startDragImmediately() {
        return ((ParcelableSnapshotMutableState) this.state.buffer).getValue() != null;
    }

    public final void updateFlingBehavior(BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1) {
        FlingBehavior snapFlingBehavior = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
        if (bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 == null) {
            TweenSpec tweenSpec = AnchoredDraggableDefaults.SnapAnimationSpec;
            BorderKt$$ExternalSyntheticLambda1 borderKt$$ExternalSyntheticLambda1 = AnchoredDraggableDefaults.PositionalThreshold;
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            this.density = density;
            snapFlingBehavior = new SnapFlingBehavior(new MenuHostHelper(this.state, borderKt$$ExternalSyntheticLambda1, new BasicTextKt$$ExternalSyntheticLambda0(4, density), 11), tweenSpec);
        }
        this.resolvedFlingBehavior = snapFlingBehavior;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public final void mo61onDragStartedk4lQ0M(long j) {
    }
}
