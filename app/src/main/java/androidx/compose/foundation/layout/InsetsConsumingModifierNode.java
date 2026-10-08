package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.TraversableNode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class InsetsConsumingModifierNode extends Modifier.Node implements TraversableNode {
    public WindowInsets ancestorConsumedInsets;
    public WindowInsets consumedInsets;

    public InsetsConsumingModifierNode() {
        FixedIntInsets fixedIntInsets = OffsetKt.EmptyWindowInsets;
        this.ancestorConsumedInsets = fixedIntInsets;
        this.consumedInsets = fixedIntInsets;
    }

    public abstract WindowInsets calculateInsets(WindowInsets windowInsets);

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return "androidx.compose.foundation.layout.ConsumedInsetsProvider";
    }

    public void insetsInvalidated() {
        this.consumedInsets = calculateInsets(this.ancestorConsumedInsets);
        HitTestResultKt.traverseDescendants(this, "androidx.compose.foundation.layout.ConsumedInsetsProvider", new InsetsConsumingModifierNode$$ExternalSyntheticLambda0(this, 0));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        HitTestResultKt.traverseAncestors(this, "androidx.compose.foundation.layout.ConsumedInsetsProvider", new InsetsConsumingModifierNode$$ExternalSyntheticLambda0(this, 1));
        insetsInvalidated();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.consumedInsets = this.ancestorConsumedInsets;
        HitTestResultKt.traverseDescendants(this, "androidx.compose.foundation.layout.ConsumedInsetsProvider", new InsetsConsumingModifierNode$$ExternalSyntheticLambda0(this, 0));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        this.ancestorConsumedInsets = OffsetKt.EmptyWindowInsets;
    }
}
