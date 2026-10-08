package androidx.compose.material3;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SheetState {
    public final SurfaceRequest.AnonymousClass1 anchoredDraggableState;
    public final Function1 confirmValueChange;
    public FiniteAnimationSpec hideMotionSpec;
    public final Function0 positionalThreshold;
    public FiniteAnimationSpec showMotionSpec;
    public final boolean skipPartiallyExpanded;

    public SheetState(boolean z, Function0 function0, SheetValue sheetValue, Function1 function1) {
        this.skipPartiallyExpanded = z;
        this.positionalThreshold = function0;
        this.confirmValueChange = function1;
        if (z && sheetValue == SheetValue.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.");
        }
        float f = SheetDefaultsKt.DragHandleVerticalPadding;
        this.anchoredDraggableState = new SurfaceRequest.AnonymousClass1(sheetValue, function1);
        this.showMotionSpec = ArcSplineKt.snap$default();
        this.hideMotionSpec = ArcSplineKt.snap$default();
    }

    public final Object animateTo$material3(SheetValue sheetValue, FiniteAnimationSpec finiteAnimationSpec, SuspendLambda suspendLambda) throws Throwable {
        NodeChain nodeChain = (NodeChain) this.anchoredDraggableState.val$requestCancellationCompleter;
        Object objAnchoredDrag = nodeChain.anchoredDrag(sheetValue, MutatePriority.Default, new AnchoredDraggableKt$animateTo$4(nodeChain, finiteAnimationSpec, null), suspendLambda);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objAnchoredDrag != coroutineSingletons) {
            objAnchoredDrag = Unit.INSTANCE;
        }
        if (objAnchoredDrag != coroutineSingletons) {
            objAnchoredDrag = Unit.INSTANCE;
        }
        return objAnchoredDrag == coroutineSingletons ? objAnchoredDrag : Unit.INSTANCE;
    }

    public final Object expand(SuspendLambda suspendLambda) throws Throwable {
        Function1 function1 = this.confirmValueChange;
        SheetValue sheetValue = SheetValue.Expanded;
        if (!((Boolean) function1.invoke(sheetValue)).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(sheetValue, this.showMotionSpec, suspendLambda);
        return objAnimateTo$material3 == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimateTo$material3 : Unit.INSTANCE;
    }

    public final SheetValue getCurrentValue() {
        return (SheetValue) ((ParcelableSnapshotMutableState) ((NodeChain) this.anchoredDraggableState.val$requestCancellationCompleter).outerCoordinator).getValue();
    }

    public final boolean getHasPartiallyExpandedState() {
        return ((NodeChain) this.anchoredDraggableState.val$requestCancellationCompleter).getAnchors().hasPositionFor(SheetValue.PartiallyExpanded);
    }

    public final Object hide(SuspendLambda suspendLambda) throws Throwable {
        Function1 function1 = this.confirmValueChange;
        SheetValue sheetValue = SheetValue.Hidden;
        if (!((Boolean) function1.invoke(sheetValue)).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(sheetValue, this.hideMotionSpec, suspendLambda);
        return objAnimateTo$material3 == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimateTo$material3 : Unit.INSTANCE;
    }

    public final boolean isVisible() {
        return ((ParcelableSnapshotMutableState) ((NodeChain) this.anchoredDraggableState.val$requestCancellationCompleter).innerCoordinator).getValue() != SheetValue.Hidden;
    }

    public final Object partialExpand(SuspendLambda suspendLambda) throws Throwable {
        if (this.skipPartiallyExpanded) {
            throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.");
        }
        Function1 function1 = this.confirmValueChange;
        SheetValue sheetValue = SheetValue.PartiallyExpanded;
        if (!((Boolean) function1.invoke(sheetValue)).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(sheetValue, this.hideMotionSpec, suspendLambda);
        return objAnimateTo$material3 == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimateTo$material3 : Unit.INSTANCE;
    }

    public final Object show(SuspendLambda suspendLambda) throws Throwable {
        SheetValue sheetValue = getHasPartiallyExpandedState() ? SheetValue.PartiallyExpanded : SheetValue.Expanded;
        if (!((Boolean) this.confirmValueChange.invoke(sheetValue)).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(sheetValue, this.showMotionSpec, suspendLambda);
        return objAnimateTo$material3 == CoroutineSingletons.COROUTINE_SUSPENDED ? objAnimateTo$material3 : Unit.INSTANCE;
    }
}
