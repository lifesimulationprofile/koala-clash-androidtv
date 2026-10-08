package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AddTextContextMenuDataComponentsNode extends Modifier.Node implements TraversableNode {
    public Recomposer$$ExternalSyntheticLambda0 builder;

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return TextContextMenuDataTraverseKey.INSTANCE;
    }
}
