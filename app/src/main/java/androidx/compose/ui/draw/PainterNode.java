package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.request.Parameters;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    public Alignment alignment;
    public float alpha;
    public BlendModeColorFilter colorFilter;
    public ContentScale contentScale;
    public Painter painter;
    public boolean sizeToIntrinsics;

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    public static boolean m339hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        return !Size.m384equalsimpl0(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    public static boolean m340hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        return !Size.m384equalsimpl0(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jMo492getIntrinsicSizeNHjbRc = this.painter.mo492getIntrinsicSizeNHjbRc();
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(m340hasSpecifiedAndFiniteWidthuvyYCjk(jMo492getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo492getIntrinsicSizeNHjbRc >> 32)) : Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(m339hasSpecifiedAndFiniteHeightuvyYCjk(jMo492getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo492getIntrinsicSizeNHjbRc & 4294967295L)) : Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() & 4294967295L)))) & 4294967295L);
        long jM539timesUQTWf7w = (Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() >> 32)) == 0.0f || Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() & 4294967295L)) == 0.0f) ? 0L : RulerKt.m539timesUQTWf7w(jFloatToRawIntBits, this.contentScale.mo516computeScaleFactorH7hwNQA(jFloatToRawIntBits, canvasDrawScope.drawContext.m756getSizeNHjbRc()));
        long jMo305alignKFBX0sM = this.alignment.mo305alignKFBX0sM((((long) Math.round(Float.intBitsToFloat((int) (jM539timesUQTWf7w >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (jM539timesUQTWf7w & 4294967295L)))) & 4294967295L), (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() & 4294967295L)))) & 4294967295L), layoutNodeDrawScope.getLayoutDirection());
        float f = (int) (jMo305alignKFBX0sM >> 32);
        float f2 = (int) (jMo305alignKFBX0sM & 4294967295L);
        ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(f, f2);
        try {
            this.painter.m495drawx_KDEd0(layoutNodeDrawScope, jM539timesUQTWf7w, this.alpha, this.colorFilter);
            ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(-f, -f2);
            layoutNodeDrawScope.drawContent();
        } catch (Throwable th) {
            ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(-f, -f2);
            throw th;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo492getIntrinsicSizeNHjbRc() != 9205357640488583168L;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicHeight(i);
        }
        long jM341modifyConstraintsZezNO4M = m341modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        return Math.max(Constraints.m684getMinHeightimpl(jM341modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicWidth(i);
        }
        long jM341modifyConstraintsZezNO4M = m341modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        return Math.max(Constraints.m685getMinWidthimpl(jM341modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(m341modifyConstraintsZezNO4M(j));
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new PainterNode$measure$1(placeableMo517measureBRTryo0, 0));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicHeight(i);
        }
        long jM341modifyConstraintsZezNO4M = m341modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        return Math.max(Constraints.m684getMinHeightimpl(jM341modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicWidth(i);
        }
        long jM341modifyConstraintsZezNO4M = m341modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        return Math.max(Constraints.m685getMinWidthimpl(jM341modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    public final long m341modifyConstraintsZezNO4M(long j) {
        boolean z = false;
        boolean z2 = Constraints.m679getHasBoundedWidthimpl(j) && Constraints.m678getHasBoundedHeightimpl(j);
        if (Constraints.m681getHasFixedWidthimpl(j) && Constraints.m680getHasFixedHeightimpl(j)) {
            z = true;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m676copyZbe2FdA$default(j, Constraints.m683getMaxWidthimpl(j), 0, Constraints.m682getMaxHeightimpl(j), 0, 10);
        }
        long jMo492getIntrinsicSizeNHjbRc = this.painter.mo492getIntrinsicSizeNHjbRc();
        int iRound = m340hasSpecifiedAndFiniteWidthuvyYCjk(jMo492getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo492getIntrinsicSizeNHjbRc >> 32))) : Constraints.m685getMinWidthimpl(j);
        int iRound2 = m339hasSpecifiedAndFiniteHeightuvyYCjk(jMo492getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo492getIntrinsicSizeNHjbRc & 4294967295L))) : Constraints.m684getMinHeightimpl(j);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(ConstraintsKt.m691constrainHeightK40F9xA(iRound2, j))) & 4294967295L) | (((long) Float.floatToRawIntBits(ConstraintsKt.m692constrainWidthK40F9xA(iRound, j))) << 32);
        if (getUseIntrinsicSize()) {
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(!m340hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo492getIntrinsicSizeNHjbRc()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) : Float.intBitsToFloat((int) (this.painter.mo492getIntrinsicSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(!m339hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo492getIntrinsicSizeNHjbRc()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) : Float.intBitsToFloat((int) (this.painter.mo492getIntrinsicSizeNHjbRc() & 4294967295L)))) & 4294967295L);
            jFloatToRawIntBits = (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) == 0.0f || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) == 0.0f) ? 0L : RulerKt.m539timesUQTWf7w(jFloatToRawIntBits2, this.contentScale.mo516computeScaleFactorH7hwNQA(jFloatToRawIntBits2, jFloatToRawIntBits));
        }
        return Constraints.m676copyZbe2FdA$default(j, ConstraintsKt.m692constrainWidthK40F9xA(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))), j), 0, ConstraintsKt.m691constrainHeightK40F9xA(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L))), j), 0, 10);
    }

    public final String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
