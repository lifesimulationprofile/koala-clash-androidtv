package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FillNode extends Modifier.Node implements LayoutModifierNode {
    public int direction;
    public float fraction;

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
        int iM685getMinWidthimpl;
        int iM683getMaxWidthimpl;
        int iM682getMaxHeightimpl;
        int iM682getMaxHeightimpl2;
        if (!Constraints.m679getHasBoundedWidthimpl(j) || this.direction == 1) {
            iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
            iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        } else {
            int iRound = Math.round(Constraints.m683getMaxWidthimpl(j) * this.fraction);
            int iM685getMinWidthimpl2 = Constraints.m685getMinWidthimpl(j);
            iM685getMinWidthimpl = Constraints.m683getMaxWidthimpl(j);
            if (iRound < iM685getMinWidthimpl2) {
                iRound = iM685getMinWidthimpl2;
            }
            if (iRound <= iM685getMinWidthimpl) {
                iM685getMinWidthimpl = iRound;
            }
            iM683getMaxWidthimpl = iM685getMinWidthimpl;
        }
        if (!Constraints.m678getHasBoundedHeightimpl(j) || this.direction == 2) {
            int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
            iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
            iM682getMaxHeightimpl2 = iM684getMinHeightimpl;
        } else {
            int iRound2 = Math.round(Constraints.m682getMaxHeightimpl(j) * this.fraction);
            int iM684getMinHeightimpl2 = Constraints.m684getMinHeightimpl(j);
            iM682getMaxHeightimpl2 = Constraints.m682getMaxHeightimpl(j);
            if (iRound2 < iM684getMinHeightimpl2) {
                iRound2 = iM684getMinHeightimpl2;
            }
            if (iRound2 <= iM682getMaxHeightimpl2) {
                iM682getMaxHeightimpl2 = iRound2;
            }
            iM682getMaxHeightimpl = iM682getMaxHeightimpl2;
        }
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(ConstraintsKt.Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM682getMaxHeightimpl2, iM682getMaxHeightimpl));
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 1));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
    }
}
