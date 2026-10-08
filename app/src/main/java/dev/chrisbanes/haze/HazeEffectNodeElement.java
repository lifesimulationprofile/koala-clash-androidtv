package dev.chrisbanes.haze;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HazeEffectNodeElement extends ModifierNodeElement {
    public final HazeState state;
    public final HazeStyle style;

    public HazeEffectNodeElement(HazeState hazeState, HazeStyle hazeStyle) {
        this.state = hazeState;
        this.style = hazeStyle;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new HazeEffectNode(this.state, this.style);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HazeEffectNodeElement)) {
            return false;
        }
        HazeEffectNodeElement hazeEffectNodeElement = (HazeEffectNodeElement) obj;
        return Intrinsics.areEqual(this.state, hazeEffectNodeElement.state) && this.style.equals(hazeEffectNodeElement.style);
    }

    public final int hashCode() {
        HazeState hazeState = this.state;
        return (this.style.hashCode() + ((hazeState == null ? 0 : hazeState.hashCode()) * 31)) * 31;
    }

    public final String toString() {
        return "HazeEffectNodeElement(state=" + this.state + ", style=" + this.style + ", block=null)";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        HazeEffectNode hazeEffectNode = (HazeEffectNode) node;
        hazeEffectNode.state = this.state;
        HazeStyle hazeStyle = hazeEffectNode.style;
        HazeStyle hazeStyle2 = this.style;
        if (!Intrinsics.areEqual(hazeStyle, hazeStyle2)) {
            hazeEffectNode.onStyleChanged(hazeEffectNode.style, hazeStyle2);
            hazeEffectNode.style = hazeStyle2;
        }
        hazeEffectNode.onObservedReadsChanged();
    }
}
