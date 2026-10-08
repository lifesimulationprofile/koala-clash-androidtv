package androidx.compose.foundation.text;

import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HeightInLinesNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode, ObserverModifierNode {
    public boolean dirty;
    public TypefaceResult$Immutable fontResolutionState;
    public int maxLines;
    public int minLines;
    public int precomputedMaxLinesHeight;
    public int precomputedMinLinesHeight;
    public TextStyle resolvedStyle;
    public TextStyle textStyle;

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
        if (this.dirty) {
            TextStyle textStyleRequireResolvedStyle = requireResolvedStyle();
            FontFamily$Resolver fontFamily$Resolver = (FontFamily$Resolver) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalFontFamilyResolver);
            String str = TextFieldDelegateKt.EmptyTextReplacement;
            int iComputeSizeForDefaultText = (int) (TextFieldDelegateKt.computeSizeForDefaultText(textStyleRequireResolvedStyle, measureScope, fontFamily$Resolver, str, 1) & 4294967295L);
            int iComputeSizeForDefaultText2 = ((int) (TextFieldDelegateKt.computeSizeForDefaultText(textStyleRequireResolvedStyle, measureScope, fontFamily$Resolver, str + '\n' + str, 2) & 4294967295L)) - iComputeSizeForDefaultText;
            int i = this.minLines;
            this.precomputedMinLinesHeight = i == 1 ? -1 : ((i - 1) * iComputeSizeForDefaultText2) + iComputeSizeForDefaultText;
            int i2 = this.maxLines;
            this.precomputedMaxLinesHeight = i2 == Integer.MAX_VALUE ? -1 : ((i2 - 1) * iComputeSizeForDefaultText2) + iComputeSizeForDefaultText;
            this.dirty = false;
        }
        int i3 = this.precomputedMinLinesHeight;
        int iCoerceIn = i3 != -1 ? RangesKt.coerceIn(i3, Constraints.m684getMinHeightimpl(j), Constraints.m682getMaxHeightimpl(j)) : Constraints.m684getMinHeightimpl(j);
        int i4 = this.precomputedMaxLinesHeight;
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(Constraints.m676copyZbe2FdA$default(j, 0, 0, iCoerceIn, i4 != -1 ? RangesKt.coerceIn(i4, Constraints.m684getMinHeightimpl(j), Constraints.m682getMaxHeightimpl(j)) : Constraints.m682getMaxHeightimpl(j), 3));
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 7));
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
        FontFamily$Resolver fontFamily$Resolver = (FontFamily$Resolver) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalFontFamilyResolver);
        this.resolvedStyle = ParagraphKt.resolveDefaults(this.textStyle, HitTestResultKt.requireLayoutNode(this).layoutDirection);
        SystemFontFamily systemFontFamily = requireResolvedStyle().spanStyle.fontFamily;
        FontWeight fontWeight = requireResolvedStyle().spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = FontWeight.Normal;
        }
        FontStyle fontStyle = requireResolvedStyle().spanStyle.fontStyle;
        int i = fontStyle != null ? fontStyle.value : 0;
        FontSynthesis fontSynthesis = requireResolvedStyle().spanStyle.fontSynthesis;
        this.fontResolutionState = ((FontFamilyResolverImpl) fontFamily$Resolver).m656resolveDPcqOEQ(systemFontFamily, fontWeight, i, fontSynthesis != null ? fontSynthesis.value : 65535);
        HitTestResultKt.observeReads(this, new HeightInLinesNode$$ExternalSyntheticLambda0(this, 0));
        this.dirty = true;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
        this.dirty = true;
        HitTestResultKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.resolvedStyle = null;
        this.fontResolutionState = null;
        this.dirty = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onLayoutDirectionChange() {
        this.resolvedStyle = ParagraphKt.resolveDefaults(this.textStyle, HitTestResultKt.requireLayoutNode(this).layoutDirection);
        this.dirty = true;
        HitTestResultKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        if (this.fontResolutionState != null) {
            HitTestResultKt.observeReads(this, new HeightInLinesNode$$ExternalSyntheticLambda0(this, 1));
        }
        this.dirty = true;
        HitTestResultKt.invalidateMeasurement(this);
    }

    public final TextStyle requireResolvedStyle() {
        TextStyle textStyle = this.resolvedStyle;
        if (textStyle != null) {
            return textStyle;
        }
        throw LazyItemScope$CC.m("Resolved style is not set.");
    }
}
