package androidx.compose.foundation.gestures;

import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AnchoredDraggableState$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NodeChain f$0;

    public /* synthetic */ AnchoredDraggableState$$ExternalSyntheticLambda1(NodeChain nodeChain, int i) {
        this.$r8$classId = i;
        this.f$0 = nodeChain;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                NodeChain nodeChain = this.f$0;
                Object value = ((ParcelableSnapshotMutableState) nodeChain.buffer).getValue();
                if (value != null) {
                    return value;
                }
                float floatValue = ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) nodeChain.innerCoordinator;
                if (Float.isNaN(floatValue)) {
                    return parcelableSnapshotMutableState.getValue();
                }
                float fPositionOf = nodeChain.getAnchors().positionOf(parcelableSnapshotMutableState.getValue());
                if (Float.isNaN(fPositionOf) || floatValue == fPositionOf) {
                    return parcelableSnapshotMutableState.getValue();
                }
                Object objClosestAnchor = nodeChain.getAnchors().closestAnchor(floatValue);
                return objClosestAnchor == null ? parcelableSnapshotMutableState.getValue() : objClosestAnchor;
            case 1:
                return this.f$0.getAnchors();
            default:
                NodeChain nodeChain2 = this.f$0;
                return new Pair(nodeChain2.getAnchors(), ((DerivedSnapshotState) nodeChain2.tail).getValue());
        }
    }
}
