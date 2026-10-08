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
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    public boolean enforceIncoming;
    public float maxHeight;
    public float maxWidth;
    public float minHeight;
    public float minWidth;

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    public final long m146getTargetConstraintsOenEA2s(MeasureScope measureScope) {
        int iMo86roundToPx0680j_4;
        int iMo86roundToPx0680j_5;
        int iMo86roundToPx0680j_6;
        int i = 0;
        if (Float.isNaN(this.maxWidth)) {
            iMo86roundToPx0680j_4 = Integer.MAX_VALUE;
        } else {
            iMo86roundToPx0680j_4 = measureScope.mo86roundToPx0680j_4(this.maxWidth);
            if (iMo86roundToPx0680j_4 < 0) {
                iMo86roundToPx0680j_4 = 0;
            }
        }
        if (Float.isNaN(this.maxHeight)) {
            iMo86roundToPx0680j_5 = Integer.MAX_VALUE;
        } else {
            iMo86roundToPx0680j_5 = measureScope.mo86roundToPx0680j_4(this.maxHeight);
            if (iMo86roundToPx0680j_5 < 0) {
                iMo86roundToPx0680j_5 = 0;
            }
        }
        if (Float.isNaN(this.minWidth)) {
            iMo86roundToPx0680j_6 = 0;
        } else {
            iMo86roundToPx0680j_6 = measureScope.mo86roundToPx0680j_4(this.minWidth);
            if (iMo86roundToPx0680j_6 < 0) {
                iMo86roundToPx0680j_6 = 0;
            }
            if (iMo86roundToPx0680j_6 > iMo86roundToPx0680j_4) {
                iMo86roundToPx0680j_6 = iMo86roundToPx0680j_4;
            }
            if (iMo86roundToPx0680j_6 == Integer.MAX_VALUE) {
                iMo86roundToPx0680j_6 = 0;
            }
        }
        if (!Float.isNaN(this.minHeight)) {
            int iMo86roundToPx0680j_7 = measureScope.mo86roundToPx0680j_4(this.minHeight);
            if (iMo86roundToPx0680j_7 < 0) {
                iMo86roundToPx0680j_7 = 0;
            }
            if (iMo86roundToPx0680j_7 > iMo86roundToPx0680j_5) {
                iMo86roundToPx0680j_7 = iMo86roundToPx0680j_5;
            }
            if (iMo86roundToPx0680j_7 != Integer.MAX_VALUE) {
                i = iMo86roundToPx0680j_7;
            }
        }
        return ConstraintsKt.Constraints(iMo86roundToPx0680j_6, iMo86roundToPx0680j_4, i, iMo86roundToPx0680j_5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM146getTargetConstraintsOenEA2s = m146getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m680getHasFixedHeightimpl(jM146getTargetConstraintsOenEA2s)) {
            return Constraints.m682getMaxHeightimpl(jM146getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m692constrainWidthK40F9xA(i, jM146getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m691constrainHeightK40F9xA(measurable.maxIntrinsicHeight(i), jM146getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM146getTargetConstraintsOenEA2s = m146getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m681getHasFixedWidthimpl(jM146getTargetConstraintsOenEA2s)) {
            return Constraints.m683getMaxWidthimpl(jM146getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m691constrainHeightK40F9xA(i, jM146getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m692constrainWidthK40F9xA(measurable.maxIntrinsicWidth(i), jM146getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM685getMinWidthimpl;
        int iM683getMaxWidthimpl;
        int iM684getMinHeightimpl;
        int iM682getMaxHeightimpl;
        long jConstraints;
        long jM146getTargetConstraintsOenEA2s = m146getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m690constrainN9IONVI(j, jM146getTargetConstraintsOenEA2s);
        } else {
            if (Float.isNaN(this.minWidth)) {
                iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
                int iM683getMaxWidthimpl2 = Constraints.m683getMaxWidthimpl(jM146getTargetConstraintsOenEA2s);
                if (iM685getMinWidthimpl > iM683getMaxWidthimpl2) {
                    iM685getMinWidthimpl = iM683getMaxWidthimpl2;
                }
            } else {
                iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(jM146getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.maxWidth)) {
                iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
                int iM685getMinWidthimpl2 = Constraints.m685getMinWidthimpl(jM146getTargetConstraintsOenEA2s);
                if (iM683getMaxWidthimpl < iM685getMinWidthimpl2) {
                    iM683getMaxWidthimpl = iM685getMinWidthimpl2;
                }
            } else {
                iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(jM146getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.minHeight)) {
                iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
                int iM682getMaxHeightimpl2 = Constraints.m682getMaxHeightimpl(jM146getTargetConstraintsOenEA2s);
                if (iM684getMinHeightimpl > iM682getMaxHeightimpl2) {
                    iM684getMinHeightimpl = iM682getMaxHeightimpl2;
                }
            } else {
                iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(jM146getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.maxHeight)) {
                iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
                int iM684getMinHeightimpl2 = Constraints.m684getMinHeightimpl(jM146getTargetConstraintsOenEA2s);
                if (iM682getMaxHeightimpl < iM684getMinHeightimpl2) {
                    iM682getMaxHeightimpl = iM684getMinHeightimpl2;
                }
            } else {
                iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(jM146getTargetConstraintsOenEA2s);
            }
            jConstraints = ConstraintsKt.Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM684getMinHeightimpl, iM682getMaxHeightimpl);
        }
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(jConstraints);
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM146getTargetConstraintsOenEA2s = m146getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m680getHasFixedHeightimpl(jM146getTargetConstraintsOenEA2s)) {
            return Constraints.m682getMaxHeightimpl(jM146getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m692constrainWidthK40F9xA(i, jM146getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m691constrainHeightK40F9xA(measurable.minIntrinsicHeight(i), jM146getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM146getTargetConstraintsOenEA2s = m146getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m681getHasFixedWidthimpl(jM146getTargetConstraintsOenEA2s)) {
            return Constraints.m683getMaxWidthimpl(jM146getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m691constrainHeightK40F9xA(i, jM146getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m692constrainWidthK40F9xA(measurable.minIntrinsicWidth(i), jM146getTargetConstraintsOenEA2s);
    }
}
