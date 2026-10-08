package androidx.compose.foundation.gestures;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$anchoredDragScope$1 {
    public float distance = Float.NaN;
    public Object leftBound;
    public Object rightBound;
    public final /* synthetic */ NodeChain this$0;

    public AnchoredDraggableState$anchoredDragScope$1(NodeChain nodeChain) {
        this.this$0 = nodeChain;
    }

    public final void dragTo(float f, float f2) {
        NodeChain nodeChain = this.this$0;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) nodeChain.head;
        float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
        parcelableSnapshotMutableFloatState.setFloatValue(f);
        ((ParcelableSnapshotMutableFloatState) nodeChain.current).setFloatValue(f2);
        if (Float.isNaN(floatValue)) {
            return;
        }
        boolean z = f >= floatValue;
        DefaultDraggableAnchors anchors = nodeChain.getAnchors();
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) nodeChain.innerCoordinator;
        if (parcelableSnapshotMutableFloatState.getFloatValue() == anchors.positionOf(parcelableSnapshotMutableState.getValue())) {
            Object objClosestAnchor = nodeChain.getAnchors().closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue() + (z ? 1.0f : -1.0f), z);
            if (objClosestAnchor == null) {
                objClosestAnchor = parcelableSnapshotMutableState.getValue();
            }
            if (z) {
                this.leftBound = parcelableSnapshotMutableState.getValue();
                this.rightBound = objClosestAnchor;
            } else {
                this.leftBound = objClosestAnchor;
                this.rightBound = parcelableSnapshotMutableState.getValue();
            }
        } else {
            Object objClosestAnchor2 = nodeChain.getAnchors().closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue(), false);
            if (objClosestAnchor2 == null) {
                objClosestAnchor2 = parcelableSnapshotMutableState.getValue();
            }
            Object objClosestAnchor3 = nodeChain.getAnchors().closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue(), true);
            if (objClosestAnchor3 == null) {
                objClosestAnchor3 = parcelableSnapshotMutableState.getValue();
            }
            this.leftBound = objClosestAnchor2;
            this.rightBound = objClosestAnchor3;
        }
        this.distance = Math.abs(nodeChain.getAnchors().positionOf(this.leftBound) - nodeChain.getAnchors().positionOf(this.rightBound));
        if (Math.abs(parcelableSnapshotMutableFloatState.getFloatValue() - nodeChain.getAnchors().positionOf(parcelableSnapshotMutableState.getValue())) >= this.distance / 2.0f) {
            Object value = z ? this.rightBound : this.leftBound;
            if (value == null) {
                value = parcelableSnapshotMutableState.getValue();
            }
            if (((Boolean) ((Function1) nodeChain.layoutNode).invoke(value)).booleanValue()) {
                nodeChain.setCurrentValue(value);
            }
        }
    }
}
