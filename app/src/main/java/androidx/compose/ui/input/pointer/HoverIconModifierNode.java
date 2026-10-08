package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draganddrop.DragAndDropNode$acceptDragAndDropTransfer$1;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Density;
import androidx.navigation.NavGraphNavigator$navigate$missingRequiredArgs$1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public boolean cursorInBoundsOfNode;
    public DpTouchBoundsExpansion dpTouchBoundsExpansion;
    public AndroidPointerIconType icon;

    public HoverIconModifierNode(AndroidPointerIconType androidPointerIconType, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.dpTouchBoundsExpansion = dpTouchBoundsExpansion;
        this.icon = androidPointerIconType;
    }

    public final void displayIcon() {
        AndroidPointerIconType androidPointerIconType;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.traverseAncestors(this, new HoverIconModifierNode$findOverridingAncestorNode$1(1));
        HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) ref$ObjectRef.element;
        if (hoverIconModifierNode == null || (androidPointerIconType = hoverIconModifierNode.icon) == null) {
            androidPointerIconType = this.icon;
        }
        displayIcon(androidPointerIconType);
    }

    public abstract void displayIcon(PointerIcon pointerIcon);

    public final void displayIconIfDescendantsDoNotHavePriority() {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        HitTestResultKt.traverseDescendants(this, new DragAndDropNode$acceptDragAndDropTransfer$1(ref$BooleanRef));
        if (ref$BooleanRef.element) {
            displayIcon();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public final long mo31getTouchBoundsExpansionRZrCHBk() {
        DpTouchBoundsExpansion dpTouchBoundsExpansion = this.dpTouchBoundsExpansion;
        if (dpTouchBoundsExpansion == null) {
            return TouchBoundsExpansion.None;
        }
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        int i = TouchBoundsExpansion.$r8$clinit;
        return TouchBoundsExpansion.Companion.pack$ui(density.mo86roundToPx0680j_4(dpTouchBoundsExpansion.start), density.mo86roundToPx0680j_4(dpTouchBoundsExpansion.top), density.mo86roundToPx0680j_4(dpTouchBoundsExpansion.end), density.mo86roundToPx0680j_4(dpTouchBoundsExpansion.bottom));
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return false;
    }

    /* JADX INFO: renamed from: isRelevantPointerType-uerMTgs, reason: not valid java name */
    public abstract boolean mo508isRelevantPointerTypeuerMTgs(int i);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        onExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        onExit();
    }

    public final void onExit() {
        if (this.cursorInBoundsOfNode) {
            this.cursorInBoundsOfNode = false;
            if (this.isAttached) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                HitTestResultKt.traverseAncestors(this, new NavGraphNavigator$navigate$missingRequiredArgs$1(ref$ObjectRef, 2));
                HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) ref$ObjectRef.element;
                if (hoverIconModifierNode != null) {
                    hoverIconModifierNode.displayIcon();
                } else {
                    displayIcon(null);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        if (pointerEventPass == PointerEventPass.Main) {
            ?? r3 = pointerEvent.changes;
            int size = r3.size();
            for (int i = 0; i < size; i++) {
                if (mo508isRelevantPointerTypeuerMTgs(((PointerInputChange) r3.get(i)).type)) {
                    int i2 = pointerEvent.type;
                    if (i2 == 4) {
                        this.cursorInBoundsOfNode = true;
                        displayIconIfDescendantsDoNotHavePriority();
                        return;
                    } else {
                        if (i2 == 5) {
                            onExit();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return false;
    }
}
