package androidx.compose.foundation.style;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StyleInnerNode extends Modifier.Node implements LayoutModifierNode {
    public StyleOuterNode outerNode;

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$maxIntrinsicHeight(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 2, 1, 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default = StyleOuterNode.resolveAnimatedStyleFor$foundation$default(this.outerNode, 1);
        float f = resolvedStyleResolveAnimatedStyleFor$foundation$default.contentPaddingStart;
        float f2 = resolvedStyleResolveAnimatedStyleFor$foundation$default.borderWidth;
        final float f3 = f + f2;
        float f4 = resolvedStyleResolveAnimatedStyleFor$foundation$default.contentPaddingEnd + f2;
        final float f5 = resolvedStyleResolveAnimatedStyleFor$foundation$default.contentPaddingTop + f2;
        float f6 = resolvedStyleResolveAnimatedStyleFor$foundation$default.contentPaddingBottom + f2;
        int iRound = Math.round(f4 + f3);
        int iRound2 = Math.round(f6 + f5);
        final Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(ConstraintsKt.m693offsetNN6EwU(-iRound, -iRound2, j));
        return measureScope.layout(ConstraintsKt.m692constrainWidthK40F9xA(placeableMo517measureBRTryo0.width + iRound, j), ConstraintsKt.m691constrainHeightK40F9xA(placeableMo517measureBRTryo0.height + iRound2, j), EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.foundation.style.StyleInnerNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, placeableMo517measureBRTryo0, Math.round(f3), Math.round(f5));
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        StyleOuterNode styleOuterNode = (StyleOuterNode) HitTestResultKt.findNearestAncestor(this, "StyleOuterNode");
        styleOuterNode.innerNodeField = this;
        this.outerNode = styleOuterNode;
        styleOuterNode.resolveStyleAndInvalidate(true);
    }
}
