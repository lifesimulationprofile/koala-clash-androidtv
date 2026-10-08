package androidx.compose.foundation.layout;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class BoxChildDataElement extends ModifierNodeElement {
    public final BiasAlignment alignment;

    public BoxChildDataElement(BiasAlignment biasAlignment) {
        this.alignment = biasAlignment;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        BoxChildDataNode boxChildDataNode = new BoxChildDataNode();
        boxChildDataNode.alignment = this.alignment;
        return boxChildDataNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        BoxChildDataElement boxChildDataElement = obj instanceof BoxChildDataElement ? (BoxChildDataElement) obj : null;
        return boxChildDataElement != null && this.alignment.equals(boxChildDataElement.alignment);
    }

    public final int hashCode() {
        return (this.alignment.hashCode() * 31) + 1237;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((BoxChildDataNode) node).alignment = this.alignment;
    }
}
