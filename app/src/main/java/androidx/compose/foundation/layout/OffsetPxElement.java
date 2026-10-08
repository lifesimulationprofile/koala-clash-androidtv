package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class OffsetPxElement extends ModifierNodeElement {
    public final Function1 offset;

    public OffsetPxElement(Function1 function1) {
        this.offset = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        OffsetPxNode offsetPxNode = new OffsetPxNode();
        offsetPxNode.offset = this.offset;
        offsetPxNode.rtlAware = true;
        return offsetPxNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetPxElement offsetPxElement = obj instanceof OffsetPxElement ? (OffsetPxElement) obj : null;
        return offsetPxElement != null && this.offset == offsetPxElement.offset;
    }

    public final int hashCode() {
        return (this.offset.hashCode() * 31) + 1231;
    }

    public final String toString() {
        return "OffsetPxModifier(offset=" + this.offset + ", rtlAware=true)";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        OffsetPxNode offsetPxNode = (OffsetPxNode) node;
        Function1 function1 = offsetPxNode.offset;
        Function1 function2 = this.offset;
        if (function1 != function2 || !offsetPxNode.rtlAware) {
            HitTestResultKt.requireLayoutNode(offsetPxNode).requestRelayout$ui(false);
        }
        offsetPxNode.offset = function2;
        offsetPxNode.rtlAware = true;
    }
}
