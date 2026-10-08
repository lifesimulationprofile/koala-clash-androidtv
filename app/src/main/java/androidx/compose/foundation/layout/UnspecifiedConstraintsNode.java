package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    public float minHeight;
    public float minWidth;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(i);
        int iM695$default$roundToPx0680j_4 = !Float.isNaN(this.minHeight) ? Density.CC.m695$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minHeight) : 0;
        return iMaxIntrinsicHeight < iM695$default$roundToPx0680j_4 ? iM695$default$roundToPx0680j_4 : iMaxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(i);
        int iM695$default$roundToPx0680j_4 = !Float.isNaN(this.minWidth) ? Density.CC.m695$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minWidth) : 0;
        return iMaxIntrinsicWidth < iM695$default$roundToPx0680j_4 ? iM695$default$roundToPx0680j_4 : iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM685getMinWidthimpl;
        int iM684getMinHeightimpl;
        if (Float.isNaN(this.minWidth) || Constraints.m685getMinWidthimpl(j) != 0) {
            iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
        } else {
            int iMo86roundToPx0680j_4 = measureScope.mo86roundToPx0680j_4(this.minWidth);
            iM685getMinWidthimpl = Constraints.m683getMaxWidthimpl(j);
            if (iMo86roundToPx0680j_4 < 0) {
                iMo86roundToPx0680j_4 = 0;
            }
            if (iMo86roundToPx0680j_4 <= iM685getMinWidthimpl) {
                iM685getMinWidthimpl = iMo86roundToPx0680j_4;
            }
        }
        int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        if (Float.isNaN(this.minHeight) || Constraints.m684getMinHeightimpl(j) != 0) {
            iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
        } else {
            int iMo86roundToPx0680j_5 = measureScope.mo86roundToPx0680j_4(this.minHeight);
            iM684getMinHeightimpl = Constraints.m682getMaxHeightimpl(j);
            int i = iMo86roundToPx0680j_5 >= 0 ? iMo86roundToPx0680j_5 : 0;
            if (i <= iM684getMinHeightimpl) {
                iM684getMinHeightimpl = i;
            }
        }
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(ConstraintsKt.Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM684getMinHeightimpl, Constraints.m682getMaxHeightimpl(j)));
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 4));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMinIntrinsicHeight = measurable.minIntrinsicHeight(i);
        int iM695$default$roundToPx0680j_4 = !Float.isNaN(this.minHeight) ? Density.CC.m695$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minHeight) : 0;
        return iMinIntrinsicHeight < iM695$default$roundToPx0680j_4 ? iM695$default$roundToPx0680j_4 : iMinIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMinIntrinsicWidth = measurable.minIntrinsicWidth(i);
        int iM695$default$roundToPx0680j_4 = !Float.isNaN(this.minWidth) ? Density.CC.m695$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minWidth) : 0;
        return iMinIntrinsicWidth < iM695$default$roundToPx0680j_4 ? iM695$default$roundToPx0680j_4 : iMinIntrinsicWidth;
    }
}
