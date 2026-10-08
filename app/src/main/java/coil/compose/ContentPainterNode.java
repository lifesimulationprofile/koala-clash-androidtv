package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.request.Parameters;
import coil.size.RealSizeResolver;
import kotlin.collections.EmptyMap;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode {
    public Alignment alignment;
    public float alpha;
    public ContentScale contentScale;
    public AsyncImagePainter painter;

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU$1, reason: not valid java name */
    public final long m779calculateScaledSizeE7KxVPU$1(long j) {
        if (Size.m388isEmptyimpl(j)) {
            return 0L;
        }
        long jMo492getIntrinsicSizeNHjbRc = this.painter.mo492getIntrinsicSizeNHjbRc();
        if (jMo492getIntrinsicSizeNHjbRc == 9205357640488583168L) {
            return j;
        }
        float fM387getWidthimpl = Size.m387getWidthimpl(jMo492getIntrinsicSizeNHjbRc);
        if (Float.isInfinite(fM387getWidthimpl) || Float.isNaN(fM387getWidthimpl)) {
            fM387getWidthimpl = Size.m387getWidthimpl(j);
        }
        float fM385getHeightimpl = Size.m385getHeightimpl(jMo492getIntrinsicSizeNHjbRc);
        if (Float.isInfinite(fM385getHeightimpl) || Float.isNaN(fM385getHeightimpl)) {
            fM385getHeightimpl = Size.m385getHeightimpl(j);
        }
        long jSize = SizeKt.Size(fM387getWidthimpl, fM385getHeightimpl);
        long jMo516computeScaleFactorH7hwNQA = this.contentScale.mo516computeScaleFactorH7hwNQA(jSize, j);
        int i = ScaleFactor.$r8$clinit;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo516computeScaleFactorH7hwNQA >> 32));
        if (Float.isInfinite(fIntBitsToFloat) || Float.isNaN(fIntBitsToFloat)) {
            return j;
        }
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & jMo516computeScaleFactorH7hwNQA));
        return (Float.isInfinite(fIntBitsToFloat2) || Float.isNaN(fIntBitsToFloat2)) ? j : RulerKt.m539timesUQTWf7w(jSize, jMo516computeScaleFactorH7hwNQA);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jM779calculateScaledSizeE7KxVPU$1 = m779calculateScaledSizeE7KxVPU$1(canvasDrawScope.drawContext.m756getSizeNHjbRc());
        Alignment alignment = this.alignment;
        RealSizeResolver realSizeResolver = UtilsKt.OriginalSizeResolver;
        long jRoundToInt = (((long) MathKt.roundToInt(Size.m387getWidthimpl(jM779calculateScaledSizeE7KxVPU$1))) << 32) | (((long) MathKt.roundToInt(Size.m385getHeightimpl(jM779calculateScaledSizeE7KxVPU$1))) & 4294967295L);
        long jM756getSizeNHjbRc = canvasDrawScope.drawContext.m756getSizeNHjbRc();
        long jMo305alignKFBX0sM = alignment.mo305alignKFBX0sM(jRoundToInt, (((long) MathKt.roundToInt(Size.m387getWidthimpl(jM756getSizeNHjbRc))) << 32) | (((long) MathKt.roundToInt(Size.m385getHeightimpl(jM756getSizeNHjbRc))) & 4294967295L), layoutNodeDrawScope.getLayoutDirection());
        float f = (int) (jMo305alignKFBX0sM >> 32);
        float f2 = (int) (jMo305alignKFBX0sM & 4294967295L);
        ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(f, f2);
        this.painter.m495drawx_KDEd0(layoutNodeDrawScope, jM779calculateScaledSizeE7KxVPU$1, this.alpha, null);
        ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(-f, -f2);
        layoutNodeDrawScope.drawContent();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo492getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.maxIntrinsicHeight(i);
        }
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(Constraints.m683getMaxWidthimpl(m780modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, i, 0, 0, 13))));
        return Math.max(MathKt.roundToInt(Size.m385getHeightimpl(m779calculateScaledSizeE7KxVPU$1(SizeKt.Size(i, iMaxIntrinsicHeight)))), iMaxIntrinsicHeight);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo492getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.maxIntrinsicWidth(i);
        }
        int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m682getMaxHeightimpl(m780modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, 0, 0, i, 7))));
        return Math.max(MathKt.roundToInt(Size.m387getWidthimpl(m779calculateScaledSizeE7KxVPU$1(SizeKt.Size(iMaxIntrinsicWidth, i)))), iMaxIntrinsicWidth);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(m780modifyConstraintsZezNO4M$1(j));
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 0));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo492getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.minIntrinsicHeight(i);
        }
        int iMinIntrinsicHeight = measurable.minIntrinsicHeight(Constraints.m683getMaxWidthimpl(m780modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, i, 0, 0, 13))));
        return Math.max(MathKt.roundToInt(Size.m385getHeightimpl(m779calculateScaledSizeE7KxVPU$1(SizeKt.Size(i, iMinIntrinsicHeight)))), iMinIntrinsicHeight);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo492getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.minIntrinsicWidth(i);
        }
        int iMinIntrinsicWidth = measurable.minIntrinsicWidth(Constraints.m682getMaxHeightimpl(m780modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, 0, 0, i, 7))));
        return Math.max(MathKt.roundToInt(Size.m387getWidthimpl(m779calculateScaledSizeE7KxVPU$1(SizeKt.Size(iMinIntrinsicWidth, i)))), iMinIntrinsicWidth);
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M$1, reason: not valid java name */
    public final long m780modifyConstraintsZezNO4M$1(long j) {
        float fM685getMinWidthimpl;
        int iM684getMinHeightimpl;
        float fCoerceIn;
        boolean zM681getHasFixedWidthimpl = Constraints.m681getHasFixedWidthimpl(j);
        boolean zM680getHasFixedHeightimpl = Constraints.m680getHasFixedHeightimpl(j);
        if (!zM681getHasFixedWidthimpl || !zM680getHasFixedHeightimpl) {
            boolean z = Constraints.m679getHasBoundedWidthimpl(j) && Constraints.m678getHasBoundedHeightimpl(j);
            long jMo492getIntrinsicSizeNHjbRc = this.painter.mo492getIntrinsicSizeNHjbRc();
            if (jMo492getIntrinsicSizeNHjbRc != 9205357640488583168L) {
                if (!z || (!zM681getHasFixedWidthimpl && !zM680getHasFixedHeightimpl)) {
                    float fM387getWidthimpl = Size.m387getWidthimpl(jMo492getIntrinsicSizeNHjbRc);
                    float fM385getHeightimpl = Size.m385getHeightimpl(jMo492getIntrinsicSizeNHjbRc);
                    if (Float.isInfinite(fM387getWidthimpl) || Float.isNaN(fM387getWidthimpl)) {
                        fM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
                    } else {
                        RealSizeResolver realSizeResolver = UtilsKt.OriginalSizeResolver;
                        fM685getMinWidthimpl = RangesKt.coerceIn(fM387getWidthimpl, Constraints.m685getMinWidthimpl(j), Constraints.m683getMaxWidthimpl(j));
                    }
                    if (Float.isInfinite(fM385getHeightimpl) || Float.isNaN(fM385getHeightimpl)) {
                        iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
                    } else {
                        RealSizeResolver realSizeResolver2 = UtilsKt.OriginalSizeResolver;
                        fCoerceIn = RangesKt.coerceIn(fM385getHeightimpl, Constraints.m684getMinHeightimpl(j), Constraints.m682getMaxHeightimpl(j));
                    }
                    long jM779calculateScaledSizeE7KxVPU$1 = m779calculateScaledSizeE7KxVPU$1(SizeKt.Size(fM685getMinWidthimpl, fCoerceIn));
                    return Constraints.m676copyZbe2FdA$default(j, ConstraintsKt.m692constrainWidthK40F9xA(MathKt.roundToInt(Size.m387getWidthimpl(jM779calculateScaledSizeE7KxVPU$1)), j), 0, ConstraintsKt.m691constrainHeightK40F9xA(MathKt.roundToInt(Size.m385getHeightimpl(jM779calculateScaledSizeE7KxVPU$1)), j), 0, 10);
                }
                fM685getMinWidthimpl = Constraints.m683getMaxWidthimpl(j);
                iM684getMinHeightimpl = Constraints.m682getMaxHeightimpl(j);
                fCoerceIn = iM684getMinHeightimpl;
                long jM779calculateScaledSizeE7KxVPU$2 = m779calculateScaledSizeE7KxVPU$1(SizeKt.Size(fM685getMinWidthimpl, fCoerceIn));
                return Constraints.m676copyZbe2FdA$default(j, ConstraintsKt.m692constrainWidthK40F9xA(MathKt.roundToInt(Size.m387getWidthimpl(jM779calculateScaledSizeE7KxVPU$2)), j), 0, ConstraintsKt.m691constrainHeightK40F9xA(MathKt.roundToInt(Size.m385getHeightimpl(jM779calculateScaledSizeE7KxVPU$2)), j), 0, 10);
            }
            if (z) {
                return Constraints.m676copyZbe2FdA$default(j, Constraints.m683getMaxWidthimpl(j), 0, Constraints.m682getMaxHeightimpl(j), 0, 10);
            }
        }
        return j;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
