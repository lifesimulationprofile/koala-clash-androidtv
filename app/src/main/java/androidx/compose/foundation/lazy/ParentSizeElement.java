package androidx.compose.foundation.lazy;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ParentSizeElement extends ModifierNodeElement {
    public final State heightState;
    public final State widthState;

    public ParentSizeElement(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2) {
        this.widthState = parcelableSnapshotMutableIntState;
        this.heightState = parcelableSnapshotMutableIntState2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ParentSizeNode parentSizeNode = new ParentSizeNode();
        parentSizeNode.fraction = 1.0f;
        parentSizeNode.widthState = this.widthState;
        parentSizeNode.heightState = this.heightState;
        return parentSizeNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentSizeElement)) {
            return false;
        }
        ParentSizeElement parentSizeElement = (ParentSizeElement) obj;
        return Intrinsics.areEqual(this.widthState, parentSizeElement.widthState) && Intrinsics.areEqual(this.heightState, parentSizeElement.heightState);
    }

    public final int hashCode() {
        State state = this.widthState;
        int iHashCode = (state != null ? state.hashCode() : 0) * 31;
        State state2 = this.heightState;
        return Float.floatToIntBits(1.0f) + ((iHashCode + (state2 != null ? state2.hashCode() : 0)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ParentSizeNode parentSizeNode = (ParentSizeNode) node;
        parentSizeNode.fraction = 1.0f;
        parentSizeNode.widthState = this.widthState;
        parentSizeNode.heightState = this.heightState;
    }
}
