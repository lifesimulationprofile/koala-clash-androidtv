package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusRequesterNode extends Modifier.Node implements FocusRequesterModifierNode {
    public FocusRequester focusRequester;

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.focusRequester.focusRequesterNodes.add(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.focusRequester.focusRequesterNodes.remove(this);
    }
}
