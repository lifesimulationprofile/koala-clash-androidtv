package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TailModifierNode extends Modifier.Node {
    public boolean attachHasBeenRun;

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.attachHasBeenRun = true;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.attachHasBeenRun = false;
    }

    public final String toString() {
        return "<tail>";
    }
}
