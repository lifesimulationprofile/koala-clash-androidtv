package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class UnionInsetsConsumingModifierElement extends ModifierNodeElement {
    public final WindowInsets insets;

    public UnionInsetsConsumingModifierElement(WindowInsets windowInsets) {
        this.insets = windowInsets;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        UnionInsetsConsumingModifierNode unionInsetsConsumingModifierNode = new UnionInsetsConsumingModifierNode();
        unionInsetsConsumingModifierNode.insets = this.insets;
        return unionInsetsConsumingModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnionInsetsConsumingModifierElement) {
            return Intrinsics.areEqual(((UnionInsetsConsumingModifierElement) obj).insets, this.insets);
        }
        return false;
    }

    public final int hashCode() {
        return this.insets.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        UnionInsetsConsumingModifierNode unionInsetsConsumingModifierNode = (UnionInsetsConsumingModifierNode) node;
        WindowInsets windowInsets = unionInsetsConsumingModifierNode.insets;
        WindowInsets windowInsets2 = this.insets;
        if (Intrinsics.areEqual(windowInsets2, windowInsets)) {
            return;
        }
        unionInsetsConsumingModifierNode.insets = windowInsets2;
        unionInsetsConsumingModifierNode.insetsInvalidated();
    }
}
