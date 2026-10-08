package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CombinedClickableElement extends ModifierNodeElement {
    public final Function0 onClick;
    public final Function0 onLongClick;

    public CombinedClickableElement(Function0 function0, Function0 function1) {
        this.onClick = function0;
        this.onLongClick = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new CombinedClickableNode(this.onClick, this.onLongClick);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CombinedClickableElement.class != obj.getClass()) {
            return false;
        }
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return this.onClick == combinedClickableElement.onClick && this.onLongClick == combinedClickableElement.onLongClick;
    }

    public final int hashCode() {
        int iHashCode = (this.onClick.hashCode() + (((1231 * 31) + 1231) * 29791)) * 961;
        Function0 function0 = this.onLongClick;
        return ((iHashCode + (function0 != null ? function0.hashCode() : 0)) * 961) + 1231;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        CombinedClickableNode combinedClickableNode = (CombinedClickableNode) node;
        combinedClickableNode.hapticFeedbackEnabled = true;
        boolean z2 = combinedClickableNode.onLongClick == null;
        Function0 function0 = this.onLongClick;
        if (z2 != (function0 == null)) {
            combinedClickableNode.disposeInteractions();
            HitTestResultKt.invalidateSemantics(combinedClickableNode);
            z = true;
        } else {
            z = false;
        }
        combinedClickableNode.onLongClick = function0;
        boolean z3 = !combinedClickableNode.enabled ? true : z;
        combinedClickableNode.m38updateCommonO2vRcR0(null, null, true, true, null, null, this.onClick);
        if (z3) {
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = combinedClickableNode.pointerInputNode;
            if (suspendingPointerInputModifierNodeImpl != null) {
                suspendingPointerInputModifierNodeImpl.resetPointerInputHandler();
                Unit unit = Unit.INSTANCE;
            }
            combinedClickableNode.cancelInput$1(false);
            combinedClickableNode.cancelInput$1(true);
        }
    }
}
