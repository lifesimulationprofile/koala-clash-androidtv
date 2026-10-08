package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    public PaddingValues paddingValues;

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
        float fMo118calculateLeftPaddingu2uoSUM = this.paddingValues.mo118calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection());
        float fMo120calculateTopPaddingD9Ej5fM = this.paddingValues.mo120calculateTopPaddingD9Ej5fM();
        float fMo119calculateRightPaddingu2uoSUM = this.paddingValues.mo119calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection());
        float fMo117calculateBottomPaddingD9Ej5fM = this.paddingValues.mo117calculateBottomPaddingD9Ej5fM();
        float f = 0;
        if (!((Dp.m703compareTo0680j_4(fMo117calculateBottomPaddingD9Ej5fM, f) >= 0) & (Dp.m703compareTo0680j_4(fMo118calculateLeftPaddingu2uoSUM, f) >= 0) & (Dp.m703compareTo0680j_4(fMo120calculateTopPaddingD9Ej5fM, f) >= 0) & (Dp.m703compareTo0680j_4(fMo119calculateRightPaddingu2uoSUM, f) >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        int iMo86roundToPx0680j_4 = measureScope.mo86roundToPx0680j_4(fMo118calculateLeftPaddingu2uoSUM);
        int iMo86roundToPx0680j_5 = measureScope.mo86roundToPx0680j_4(fMo119calculateRightPaddingu2uoSUM) + iMo86roundToPx0680j_4;
        int iMo86roundToPx0680j_6 = measureScope.mo86roundToPx0680j_4(fMo120calculateTopPaddingD9Ej5fM);
        int iMo86roundToPx0680j_7 = measureScope.mo86roundToPx0680j_4(fMo117calculateBottomPaddingD9Ej5fM) + iMo86roundToPx0680j_6;
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(ConstraintsKt.m693offsetNN6EwU(-iMo86roundToPx0680j_5, -iMo86roundToPx0680j_7, j));
        return measureScope.layout(ConstraintsKt.m692constrainWidthK40F9xA(placeableMo517measureBRTryo0.width + iMo86roundToPx0680j_5, j), ConstraintsKt.m691constrainHeightK40F9xA(placeableMo517measureBRTryo0.height + iMo86roundToPx0680j_7, j), EmptyMap.INSTANCE, new MultiParagraph$$ExternalSyntheticLambda1(placeableMo517measureBRTryo0, iMo86roundToPx0680j_4, iMo86roundToPx0680j_6, 2));
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
