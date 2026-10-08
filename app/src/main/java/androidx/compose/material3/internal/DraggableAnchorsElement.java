package androidx.compose.material3.internal;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class DraggableAnchorsElement<T> extends ModifierNodeElement {
    public final Function2 anchors;
    public final SurfaceRequest.AnonymousClass1 state;

    public DraggableAnchorsElement(SurfaceRequest.AnonymousClass1 anonymousClass1, Function2 function2) {
        this.state = anonymousClass1;
        this.anchors = function2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DraggableAnchorsNode draggableAnchorsNode = new DraggableAnchorsNode();
        draggableAnchorsNode.state = this.state;
        draggableAnchorsNode.anchors = this.anchors;
        draggableAnchorsNode.orientation = Orientation.Vertical;
        return draggableAnchorsNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraggableAnchorsElement)) {
            return false;
        }
        DraggableAnchorsElement draggableAnchorsElement = (DraggableAnchorsElement) obj;
        return Intrinsics.areEqual(this.state, draggableAnchorsElement.state) && this.anchors == draggableAnchorsElement.anchors;
    }

    public final int hashCode() {
        return Orientation.Vertical.hashCode() + ((this.anchors.hashCode() + (this.state.hashCode() * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        DraggableAnchorsNode draggableAnchorsNode = (DraggableAnchorsNode) node;
        SurfaceRequest.AnonymousClass1 anonymousClass1 = draggableAnchorsNode.state;
        SurfaceRequest.AnonymousClass1 anonymousClass2 = this.state;
        boolean zAreEqual = Intrinsics.areEqual(anonymousClass1, anonymousClass2);
        draggableAnchorsNode.state = anonymousClass2;
        draggableAnchorsNode.anchors = this.anchors;
        draggableAnchorsNode.orientation = Orientation.Vertical;
        if (zAreEqual) {
            return;
        }
        draggableAnchorsNode.didInitializeAnchors = false;
        HitTestResultKt.invalidateMeasurement(draggableAnchorsNode);
    }
}
