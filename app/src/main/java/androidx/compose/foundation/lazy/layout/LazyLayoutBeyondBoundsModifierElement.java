package androidx.compose.foundation.lazy.layout;

import androidx.camera.view.PreviewView;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class LazyLayoutBeyondBoundsModifierElement extends ModifierNodeElement {
    public final PreviewView.AnonymousClass1 beyondBoundsInfo;
    public final Orientation orientation;
    public final boolean reverseLayout;
    public final LazyListBeyondBoundsState state;

    public LazyLayoutBeyondBoundsModifierElement(LazyListBeyondBoundsState lazyListBeyondBoundsState, PreviewView.AnonymousClass1 anonymousClass1, boolean z, Orientation orientation) {
        this.state = lazyListBeyondBoundsState;
        this.beyondBoundsInfo = anonymousClass1;
        this.reverseLayout = z;
        this.orientation = orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        LazyLayoutBeyondBoundsProviderModifierNode lazyLayoutBeyondBoundsProviderModifierNode = new LazyLayoutBeyondBoundsProviderModifierNode();
        lazyLayoutBeyondBoundsProviderModifierNode.state = this.state;
        lazyLayoutBeyondBoundsProviderModifierNode.beyondBoundsInfo = this.beyondBoundsInfo;
        lazyLayoutBeyondBoundsProviderModifierNode.reverseLayout = this.reverseLayout;
        lazyLayoutBeyondBoundsProviderModifierNode.orientation = this.orientation;
        return lazyLayoutBeyondBoundsProviderModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutBeyondBoundsModifierElement)) {
            return false;
        }
        LazyLayoutBeyondBoundsModifierElement lazyLayoutBeyondBoundsModifierElement = (LazyLayoutBeyondBoundsModifierElement) obj;
        return Intrinsics.areEqual(this.state, lazyLayoutBeyondBoundsModifierElement.state) && Intrinsics.areEqual(this.beyondBoundsInfo, lazyLayoutBeyondBoundsModifierElement.beyondBoundsInfo) && this.reverseLayout == lazyLayoutBeyondBoundsModifierElement.reverseLayout && this.orientation == lazyLayoutBeyondBoundsModifierElement.orientation;
    }

    public final int hashCode() {
        return this.orientation.hashCode() + ((((this.beyondBoundsInfo.hashCode() + (this.state.hashCode() * 31)) * 31) + (this.reverseLayout ? 1231 : 1237)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        LazyLayoutBeyondBoundsProviderModifierNode lazyLayoutBeyondBoundsProviderModifierNode = (LazyLayoutBeyondBoundsProviderModifierNode) node;
        lazyLayoutBeyondBoundsProviderModifierNode.state = this.state;
        lazyLayoutBeyondBoundsProviderModifierNode.beyondBoundsInfo = this.beyondBoundsInfo;
        lazyLayoutBeyondBoundsProviderModifierNode.reverseLayout = this.reverseLayout;
        lazyLayoutBeyondBoundsProviderModifierNode.orientation = this.orientation;
    }
}
