package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class FocusPropertiesElement extends ModifierNodeElement {
    public final FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 scope;

    public FocusPropertiesElement(FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 focusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0) {
        this.scope = focusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        FocusPropertiesNode focusPropertiesNode = new FocusPropertiesNode();
        focusPropertiesNode.focusPropertiesScope = this.scope;
        return focusPropertiesNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusPropertiesElement) && Intrinsics.areEqual(this.scope, ((FocusPropertiesElement) obj).scope);
    }

    public final int hashCode() {
        return this.scope.function.hashCode();
    }

    public final String toString() {
        return "FocusPropertiesElement(scope=" + this.scope + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((FocusPropertiesNode) node).focusPropertiesScope = this.scope;
    }
}
