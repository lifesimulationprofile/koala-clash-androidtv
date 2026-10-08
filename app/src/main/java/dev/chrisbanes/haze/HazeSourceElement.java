package dev.chrisbanes.haze;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HazeSourceElement extends ModifierNodeElement {
    public final HazeState state;

    public HazeSourceElement(HazeState hazeState) {
        this.state = hazeState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new HazeSourceNode(this.state);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HazeSourceElement) && Intrinsics.areEqual(this.state, ((HazeSourceElement) obj).state) && Float.compare(0.0f, 0.0f) == 0;
    }

    public final int hashCode() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(0.0f, this.state.hashCode() * 31, 31);
    }

    public final String toString() {
        return "HazeSourceElement(state=" + this.state + ", zIndex=0.0, key=null)";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        HazeSourceNode hazeSourceNode = (HazeSourceNode) node;
        SnapshotStateList snapshotStateList = hazeSourceNode.state._areas;
        HazeArea hazeArea = hazeSourceNode.area;
        boolean zContains = snapshotStateList.contains(hazeArea);
        if (zContains) {
            hazeSourceNode.state._areas.remove(hazeArea);
        }
        HazeState hazeState = this.state;
        hazeSourceNode.state = hazeState;
        if (zContains) {
            hazeState._areas.add(hazeArea);
        }
        hazeArea.zIndex$delegate.setFloatValue(0.0f);
    }
}
