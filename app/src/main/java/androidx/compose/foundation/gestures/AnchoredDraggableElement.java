package androidx.compose.foundation.gestures;

import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableElement<T> extends ModifierNodeElement {
    public final boolean enabled;
    public final BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 flingBehavior;
    public final Boolean reverseDirection;
    public final NodeChain state;

    public AnchoredDraggableElement(NodeChain nodeChain, boolean z, Boolean bool, BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1) {
        this.state = nodeChain;
        this.enabled = z;
        this.reverseDirection = bool;
        this.flingBehavior = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        BorderKt$$ExternalSyntheticLambda1 borderKt$$ExternalSyntheticLambda1 = ScrollableKt.AlwaysDrag;
        boolean z = this.enabled;
        Orientation orientation = Orientation.Vertical;
        AnchoredDraggableNode anchoredDraggableNode = new AnchoredDraggableNode(borderKt$$ExternalSyntheticLambda1, z, null, orientation);
        anchoredDraggableNode.state = this.state;
        anchoredDraggableNode.orientation = orientation;
        anchoredDraggableNode.reverseDirection = this.reverseDirection;
        anchoredDraggableNode.flingBehavior = this.flingBehavior;
        return anchoredDraggableNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnchoredDraggableElement)) {
            return false;
        }
        AnchoredDraggableElement anchoredDraggableElement = (AnchoredDraggableElement) obj;
        return Intrinsics.areEqual(this.state, anchoredDraggableElement.state) && this.enabled == anchoredDraggableElement.enabled && this.reverseDirection.equals(anchoredDraggableElement.reverseDirection) && Intrinsics.areEqual(this.flingBehavior, anchoredDraggableElement.flingBehavior);
    }

    public final int hashCode() {
        int iHashCode = (this.reverseDirection.hashCode() + ((((Orientation.Vertical.hashCode() + (this.state.hashCode() * 31)) * 31) + (this.enabled ? 1231 : 1237)) * 31)) * 923521;
        BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 = this.flingBehavior;
        return iHashCode + (bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 != null ? bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        boolean z2;
        AnchoredDraggableNode anchoredDraggableNode = (AnchoredDraggableNode) node;
        BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 = this.flingBehavior;
        anchoredDraggableNode.flingBehavior = bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
        NodeChain nodeChain = anchoredDraggableNode.state;
        NodeChain nodeChain2 = this.state;
        if (Intrinsics.areEqual(nodeChain, nodeChain2)) {
            z = false;
        } else {
            anchoredDraggableNode.state = nodeChain2;
            anchoredDraggableNode.updateFlingBehavior(bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1);
            z = true;
        }
        Orientation orientation = anchoredDraggableNode.orientation;
        Orientation orientation2 = Orientation.Vertical;
        if (orientation != orientation2) {
            anchoredDraggableNode.orientation = orientation2;
            z = true;
        }
        Boolean bool = anchoredDraggableNode.reverseDirection;
        Boolean bool2 = this.reverseDirection;
        if (Intrinsics.areEqual(bool, bool2)) {
            z2 = z;
        } else {
            anchoredDraggableNode.reverseDirection = bool2;
            z2 = true;
        }
        anchoredDraggableNode.update(anchoredDraggableNode.canDrag, this.enabled, null, orientation2, z2);
    }
}
