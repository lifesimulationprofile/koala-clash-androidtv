package androidx.compose.foundation.selection;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class ToggleableElement extends ModifierNodeElement {
    public final boolean enabled;
    public final MutableInteractionSourceImpl interactionSource;
    public final Function1 onValueChange;
    public final Role role;
    public final boolean value;

    public ToggleableElement(boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z2, Role role, Function1 function1) {
        this.value = z;
        this.interactionSource = mutableInteractionSourceImpl;
        this.enabled = z2;
        this.role = role;
        this.onValueChange = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new ToggleableNode(this.value, this.interactionSource, this.enabled, this.role, this.onValueChange);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ToggleableElement.class != obj.getClass()) {
            return false;
        }
        ToggleableElement toggleableElement = (ToggleableElement) obj;
        return this.value == toggleableElement.value && Intrinsics.areEqual(this.interactionSource, toggleableElement.interactionSource) && this.enabled == toggleableElement.enabled && this.role.equals(toggleableElement.role) && this.onValueChange == toggleableElement.onValueChange;
    }

    public final int hashCode() {
        int i = (this.value ? 1231 : 1237) * 31;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        return this.onValueChange.hashCode() + ((((((((i + (mutableInteractionSourceImpl != null ? mutableInteractionSourceImpl.hashCode() : 0)) * 961) + 1237) * 31) + (this.enabled ? 1231 : 1237)) * 31) + this.role.value) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ToggleableNode toggleableNode = (ToggleableNode) node;
        boolean z = toggleableNode.value;
        boolean z2 = this.value;
        if (z != z2) {
            toggleableNode.value = z2;
            HitTestResultKt.invalidateSemantics(toggleableNode);
        }
        toggleableNode.onValueChange = this.onValueChange;
        toggleableNode.m38updateCommonO2vRcR0(this.interactionSource, null, false, this.enabled, null, this.role, toggleableNode._onClick);
    }
}
