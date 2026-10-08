package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class LazyLayoutSemanticsModifier extends ModifierNodeElement {
    public final Function0 itemProviderLambda;
    public final Orientation orientation;
    public final boolean reverseScrolling;
    public final LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 state;
    public final boolean userScrollEnabled;

    public LazyLayoutSemanticsModifier(Function0 function0, LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1, Orientation orientation, boolean z, boolean z2) {
        this.itemProviderLambda = function0;
        this.state = lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1;
        this.orientation = orientation;
        this.userScrollEnabled = z;
        this.reverseScrolling = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new LazyLayoutSemanticsModifierNode(this.itemProviderLambda, this.state, this.orientation, this.userScrollEnabled, this.reverseScrolling);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutSemanticsModifier)) {
            return false;
        }
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = (LazyLayoutSemanticsModifier) obj;
        return this.itemProviderLambda == lazyLayoutSemanticsModifier.itemProviderLambda && Intrinsics.areEqual(this.state, lazyLayoutSemanticsModifier.state) && this.orientation == lazyLayoutSemanticsModifier.orientation && this.userScrollEnabled == lazyLayoutSemanticsModifier.userScrollEnabled && this.reverseScrolling == lazyLayoutSemanticsModifier.reverseScrolling;
    }

    public final int hashCode() {
        return ((((this.orientation.hashCode() + ((this.state.hashCode() + (this.itemProviderLambda.hashCode() * 31)) * 31)) * 31) + (this.userScrollEnabled ? 1231 : 1237)) * 31) + (this.reverseScrolling ? 1231 : 1237);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode = (LazyLayoutSemanticsModifierNode) node;
        lazyLayoutSemanticsModifierNode.itemProviderLambda = this.itemProviderLambda;
        lazyLayoutSemanticsModifierNode.state = this.state;
        Orientation orientation = lazyLayoutSemanticsModifierNode.orientation;
        Orientation orientation2 = this.orientation;
        if (orientation != orientation2) {
            lazyLayoutSemanticsModifierNode.orientation = orientation2;
            HitTestResultKt.invalidateSemantics(lazyLayoutSemanticsModifierNode);
        }
        boolean z = lazyLayoutSemanticsModifierNode.userScrollEnabled;
        boolean z2 = this.userScrollEnabled;
        boolean z3 = this.reverseScrolling;
        if (z == z2 && lazyLayoutSemanticsModifierNode.reverseScrolling == z3) {
            return;
        }
        lazyLayoutSemanticsModifierNode.userScrollEnabled = z2;
        lazyLayoutSemanticsModifierNode.reverseScrolling = z3;
        lazyLayoutSemanticsModifierNode.updateCachedSemanticsValues();
        HitTestResultKt.invalidateSemantics(lazyLayoutSemanticsModifierNode);
    }
}
