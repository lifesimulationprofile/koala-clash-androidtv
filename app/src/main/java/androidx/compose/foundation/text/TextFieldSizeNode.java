package androidx.compose.foundation.text;

import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSizeNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public TypefaceResult$Immutable fontResolutionState;
    public TextFieldSize minSizeState;
    public final TextStyle style;

    public TextFieldSizeNode(TextStyle textStyle) {
        this.style = textStyle;
    }

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
        TextFieldSize textFieldSize = this.minSizeState;
        if (textFieldSize == null) {
            throw LazyItemScope$CC.m("Min size state is not set.");
        }
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldSize.dirty$delegate;
        TypefaceResult$Immutable typefaceResult$Immutable = this.fontResolutionState;
        if (typefaceResult$Immutable == null) {
            throw LazyItemScope$CC.m("Font resolution state is not set.");
        }
        Object obj = typefaceResult$Immutable.value;
        if (!Intrinsics.areEqual(obj, textFieldSize.typeface)) {
            textFieldSize.typeface = obj;
            parcelableSnapshotMutableState.setValue(Boolean.TRUE);
        }
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            textFieldSize.minSize = TextFieldDelegateKt.computeSizeForDefaultText(textFieldSize.resolvedStyle, textFieldSize.density, textFieldSize.fontFamilyResolver, TextFieldDelegateKt.EmptyTextReplacement, 1);
            parcelableSnapshotMutableState.setValue(Boolean.FALSE);
        }
        long j2 = textFieldSize.minSize;
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(ConstraintsKt.m690constrainN9IONVI(j, ConstraintsKt.Constraints$default((int) (j2 >> 32), 0, (int) (j2 & 4294967295L), 0, 10)));
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 8));
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
        TextStyle textStyleResolveDefaults = ParagraphKt.resolveDefaults(this.style, HitTestResultKt.requireLayoutNode(this).layoutDirection);
        FontFamily$Resolver fontFamily$Resolver = (FontFamily$Resolver) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalFontFamilyResolver);
        updateFontResolutionState(textStyleResolveDefaults, fontFamily$Resolver);
        LayoutDirection layoutDirection = HitTestResultKt.requireLayoutNode(this).layoutDirection;
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        TypefaceResult$Immutable typefaceResult$Immutable = this.fontResolutionState;
        if (typefaceResult$Immutable == null) {
            throw LazyItemScope$CC.m("Font resolution state is not set.");
        }
        this.minSizeState = new TextFieldSize(layoutDirection, density, fontFamily$Resolver, textStyleResolveDefaults, typefaceResult$Immutable.value);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
        TextFieldSize textFieldSize = this.minSizeState;
        if (textFieldSize != null) {
            TextFieldSize.update$default(textFieldSize, null, HitTestResultKt.requireLayoutNode(this).density, null, 29);
        }
        HitTestResultKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.fontResolutionState = null;
        this.minSizeState = null;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onLayoutDirectionChange() {
        TextFieldSize textFieldSize = this.minSizeState;
        if (textFieldSize != null) {
            TextFieldSize.update$default(textFieldSize, HitTestResultKt.requireLayoutNode(this).layoutDirection, null, null, 30);
        }
        HitTestResultKt.invalidateMeasurement(this);
    }

    public final void updateFontResolutionState(TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver) {
        SpanStyle spanStyle = textStyle.spanStyle;
        SystemFontFamily systemFontFamily = spanStyle.fontFamily;
        FontWeight fontWeight = spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = FontWeight.Normal;
        }
        FontStyle fontStyle = spanStyle.fontStyle;
        int i = fontStyle != null ? fontStyle.value : 0;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        this.fontResolutionState = ((FontFamilyResolverImpl) fontFamily$Resolver).m656resolveDPcqOEQ(systemFontFamily, fontWeight, i, fontSynthesis != null ? fontSynthesis.value : 65535);
        HitTestResultKt.invalidateMeasurement(this);
    }
}
