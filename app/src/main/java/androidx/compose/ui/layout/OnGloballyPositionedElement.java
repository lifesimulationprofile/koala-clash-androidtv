package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class OnGloballyPositionedElement extends ModifierNodeElement {
    public final Function1 onGloballyPositioned;

    public OnGloballyPositionedElement(Function1 function1) {
        this.onGloballyPositioned = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        OnGloballyPositionedNode onGloballyPositionedNode = new OnGloballyPositionedNode();
        onGloballyPositionedNode.callback = this.onGloballyPositioned;
        return onGloballyPositionedNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnGloballyPositionedElement) {
            return this.onGloballyPositioned == ((OnGloballyPositionedElement) obj).onGloballyPositioned;
        }
        return false;
    }

    public final int hashCode() {
        return this.onGloballyPositioned.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((OnGloballyPositionedNode) node).callback = this.onGloballyPositioned;
    }
}
