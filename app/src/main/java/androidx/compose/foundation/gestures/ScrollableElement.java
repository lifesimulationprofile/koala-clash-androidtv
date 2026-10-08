package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableElement extends ModifierNodeElement {
    public final boolean enabled;
    public final MutableInteractionSourceImpl interactionSource;
    public final Orientation orientation;
    public final boolean reverseDirection;
    public final ScrollableState state;

    public ScrollableElement(ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        this.state = scrollableState;
        this.orientation = orientation;
        this.enabled = z;
        this.reverseDirection = z2;
        this.interactionSource = mutableInteractionSourceImpl;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        boolean z = this.reverseDirection;
        return new ScrollableNode(null, null, this.orientation, this.state, this.interactionSource, this.enabled, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollableElement)) {
            return false;
        }
        ScrollableElement scrollableElement = (ScrollableElement) obj;
        return Intrinsics.areEqual(this.state, scrollableElement.state) && this.orientation == scrollableElement.orientation && this.enabled == scrollableElement.enabled && this.reverseDirection == scrollableElement.reverseDirection && Intrinsics.areEqual(this.interactionSource, scrollableElement.interactionSource);
    }

    public final int hashCode() {
        int iHashCode = (((((this.orientation.hashCode() + (this.state.hashCode() * 31)) * 961) + (this.enabled ? 1231 : 1237)) * 31) + (this.reverseDirection ? 1231 : 1237)) * 961;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        return (iHashCode + (mutableInteractionSourceImpl != null ? mutableInteractionSourceImpl.hashCode() : 0)) * 31;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((ScrollableNode) node).update(null, null, this.orientation, this.state, this.interactionSource, this.enabled, this.reverseDirection);
    }
}
