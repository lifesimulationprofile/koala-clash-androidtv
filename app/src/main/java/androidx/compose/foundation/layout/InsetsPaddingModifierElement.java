package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class InsetsPaddingModifierElement extends ModifierNodeElement {
    public final WindowInsets insets;

    public InsetsPaddingModifierElement(WindowInsets windowInsets) {
        this.insets = windowInsets;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new InsetsPaddingModifierNode(this.insets);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InsetsPaddingModifierElement) {
            return Intrinsics.areEqual(((InsetsPaddingModifierElement) obj).insets, this.insets);
        }
        return false;
    }

    public final int hashCode() {
        return this.insets.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        InsetsPaddingModifierNode insetsPaddingModifierNode = (InsetsPaddingModifierNode) node;
        WindowInsets windowInsets = insetsPaddingModifierNode.insets;
        WindowInsets windowInsets2 = this.insets;
        if (Intrinsics.areEqual(windowInsets2, windowInsets)) {
            return;
        }
        insetsPaddingModifierNode.insets = windowInsets2;
        insetsPaddingModifierNode.insetsInvalidated();
    }
}
