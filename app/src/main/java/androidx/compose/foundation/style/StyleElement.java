package androidx.compose.foundation.style;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StyleElement extends ModifierNodeElement {
    public final Style style;
    public final MutableStyleState styleState;

    public StyleElement(MutableStyleState mutableStyleState, Style style) {
        this.styleState = mutableStyleState;
        this.style = style;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new StyleOuterNode(this.styleState, this.style);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StyleElement)) {
            return false;
        }
        StyleElement styleElement = (StyleElement) obj;
        return Intrinsics.areEqual(styleElement.style, this.style) && Intrinsics.areEqual(styleElement.styleState, this.styleState);
    }

    public final int hashCode() {
        return this.style.hashCode();
    }

    public final String toString() {
        return "StyleElement(styleState=" + this.styleState + ", style=" + this.style + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        StyleOuterNode styleOuterNode = (StyleOuterNode) node;
        styleOuterNode.style = this.style;
        styleOuterNode.resolveStyleAndInvalidate(false);
        MutableStyleState mutableStyleState = this.styleState;
        if (mutableStyleState == null) {
            mutableStyleState = new MutableStyleState(null);
        }
        if (Intrinsics.areEqual(styleOuterNode._state, mutableStyleState)) {
            return;
        }
        styleOuterNode._state = mutableStyleState;
        styleOuterNode.resolveStyleAndInvalidate(false);
        StyleInnerNode styleInnerNode = styleOuterNode.innerNodeField;
        if (styleInnerNode == null) {
            throw new IllegalStateException("StyleOuterNode with no corresponding StyleInnerNode");
        }
        HitTestResultKt.invalidateLayer(styleInnerNode);
    }
}
