package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import coil.network.HttpException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public ParagraphLayoutCache _layoutCache;
    public HashMap baselineCache;
    public FontFamily$Resolver fontFamilyResolver;
    public int maxLines;
    public int minLines;
    public int overflow;
    public TextStyle resolvedInheritedStyle;
    public TextStringSimpleNode$$ExternalSyntheticLambda0 semanticsTextLayoutResult;
    public boolean softWrap;
    public TextStyle style;
    public String text;
    public TextSubstitutionValue textSubstitution;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TextSubstitutionValue {
        public boolean isShowingSubstitution = false;
        public ParagraphLayoutCache layoutCache = null;
        public final String original;
        public String substitution;

        public TextSubstitutionValue(String str, String str2) {
            this.original = str;
            this.substitution = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) obj;
            return Intrinsics.areEqual(this.original, textSubstitutionValue.original) && Intrinsics.areEqual(this.substitution, textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && Intrinsics.areEqual(this.layoutCache, textSubstitutionValue.layoutCache);
        }

        public final int hashCode() {
            int iM = (Modifier.CC.m(this.original.hashCode() * 31, 31, this.substitution) + (this.isShowingSubstitution ? 1231 : 1237)) * 31;
            ParagraphLayoutCache paragraphLayoutCache = this.layoutCache;
            return iM + (paragraphLayoutCache == null ? 0 : paragraphLayoutCache.hashCode());
        }

        public final String toString() {
            return "TextSubstitution(layoutCache=" + this.layoutCache + ", isShowingSubstitution=" + this.isShowingSubstitution + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextStringSimpleNode$$ExternalSyntheticLambda0 textStringSimpleNode$$ExternalSyntheticLambda0 = this.semanticsTextLayoutResult;
        ?? r0 = textStringSimpleNode$$ExternalSyntheticLambda0;
        if (textStringSimpleNode$$ExternalSyntheticLambda0 == null) {
            final int i = 0;
            ?? r1 = new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0
                public final /* synthetic */ TextStringSimpleNode f$0;

                {
                    this.f$0 = this;
                }

                /* JADX WARN: Code duplicated, block: B:23:0x00a7  */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Density density;
                    TextLayoutResult textLayoutResult;
                    boolean z;
                    switch (i) {
                        case 0:
                            List list = (List) obj;
                            TextStringSimpleNode textStringSimpleNode = this.f$0;
                            ParagraphLayoutCache layoutCache = textStringSimpleNode.getLayoutCache();
                            TextStyle textStyleM648mergedA7vx0o$default = TextStyle.m648mergedA7vx0o$default(textStringSimpleNode.style, Color.Unspecified, 0L, null, null, 0L, 0, 0L, 16777214);
                            LayoutDirection layoutDirection = layoutCache.intrinsicsLayoutDirection;
                            TextLayoutResult textLayoutResult2 = null;
                            if (layoutDirection == null || (density = layoutCache.density) == null) {
                                textLayoutResult = null;
                            } else {
                                AnnotatedString annotatedString = new AnnotatedString(layoutCache.text);
                                if (layoutCache.paragraph == null || layoutCache.paragraphIntrinsics == null) {
                                    textLayoutResult = null;
                                } else {
                                    long j = layoutCache.prevConstraints & (-8589934589L);
                                    int i2 = layoutCache.maxLines;
                                    boolean z2 = layoutCache.softWrap;
                                    int i3 = layoutCache.overflow;
                                    FontFamily$Resolver fontFamily$Resolver = layoutCache.fontFamilyResolver;
                                    EmptyList emptyList = EmptyList.INSTANCE;
                                    textLayoutResult = new TextLayoutResult(new TextLayoutInput(annotatedString, textStyleM648mergedA7vx0o$default, emptyList, i2, z2, i3, density, layoutDirection, fontFamily$Resolver, j), new MultiParagraph(new Request(annotatedString, textStyleM648mergedA7vx0o$default, emptyList, density, fontFamily$Resolver), j, layoutCache.maxLines, layoutCache.overflow), layoutCache.layoutSize);
                                }
                            }
                            if (textLayoutResult != null) {
                                list.add(textLayoutResult);
                                textLayoutResult2 = textLayoutResult;
                            }
                            return Boolean.valueOf(textLayoutResult2 != null);
                        case 1:
                            String str = ((AnnotatedString) obj).text;
                            TextStringSimpleNode textStringSimpleNode2 = this.f$0;
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue = textStringSimpleNode2.textSubstitution;
                            if (textSubstitutionValue == null) {
                                TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue2 = new TextStringSimpleNode.TextSubstitutionValue(textStringSimpleNode2.text, str);
                                ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, textStringSimpleNode2.style, textStringSimpleNode2.fontFamilyResolver, textStringSimpleNode2.overflow, textStringSimpleNode2.softWrap, textStringSimpleNode2.maxLines, textStringSimpleNode2.minLines);
                                paragraphLayoutCache.setDensity$foundation(textStringSimpleNode2.getLayoutCache().density);
                                textSubstitutionValue2.layoutCache = paragraphLayoutCache;
                                textStringSimpleNode2.textSubstitution = textSubstitutionValue2;
                            } else if (!Intrinsics.areEqual(str, textSubstitutionValue.substitution)) {
                                textSubstitutionValue.substitution = str;
                                ParagraphLayoutCache paragraphLayoutCache2 = textSubstitutionValue.layoutCache;
                                if (paragraphLayoutCache2 != null) {
                                    paragraphLayoutCache2.m206updateL6sJoHM(str, textStringSimpleNode2.style, textStringSimpleNode2.fontFamilyResolver, textStringSimpleNode2.overflow, textStringSimpleNode2.softWrap, textStringSimpleNode2.maxLines, textStringSimpleNode2.minLines);
                                }
                            }
                            HitTestResultKt.invalidateSemantics(textStringSimpleNode2);
                            HitTestResultKt.invalidateMeasurement(textStringSimpleNode2);
                            HitTestResultKt.invalidateDraw(textStringSimpleNode2);
                            return Boolean.TRUE;
                        default:
                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                            TextStringSimpleNode textStringSimpleNode3 = this.f$0;
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue3 = textStringSimpleNode3.textSubstitution;
                            if (textSubstitutionValue3 == null) {
                                z = false;
                            } else {
                                textSubstitutionValue3.isShowingSubstitution = zBooleanValue;
                                HitTestResultKt.invalidateSemantics(textStringSimpleNode3);
                                HitTestResultKt.invalidateMeasurement(textStringSimpleNode3);
                                HitTestResultKt.invalidateDraw(textStringSimpleNode3);
                                z = true;
                            }
                            return Boolean.valueOf(z);
                    }
                }
            };
            this.semanticsTextLayoutResult = r1;
            r0 = r1;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text);
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        semanticsPropertyReceiver.set(SemanticsProperties.Text, Collections.singletonList(annotatedString));
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null) {
            boolean z = textSubstitutionValue.isShowingSubstitution;
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.IsShowingTextSubstitution;
            KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
            KProperty kProperty = kPropertyArr2[17];
            semanticsPropertyReceiver.set(semanticsPropertyKey, Boolean.valueOf(z));
            AnnotatedString annotatedString2 = new AnnotatedString(textSubstitutionValue.substitution);
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.TextSubstitution;
            KProperty kProperty2 = kPropertyArr2[16];
            semanticsPropertyReceiver.set(semanticsPropertyKey2, annotatedString2);
        }
        final int i2 = 1;
        semanticsPropertyReceiver.set(SemanticsActions.SetTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0
            public final /* synthetic */ TextStringSimpleNode f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x00a7  */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Density density;
                TextLayoutResult textLayoutResult;
                boolean z2;
                switch (i2) {
                    case 0:
                        List list = (List) obj;
                        TextStringSimpleNode textStringSimpleNode = this.f$0;
                        ParagraphLayoutCache layoutCache = textStringSimpleNode.getLayoutCache();
                        TextStyle textStyleM648mergedA7vx0o$default = TextStyle.m648mergedA7vx0o$default(textStringSimpleNode.style, Color.Unspecified, 0L, null, null, 0L, 0, 0L, 16777214);
                        LayoutDirection layoutDirection = layoutCache.intrinsicsLayoutDirection;
                        TextLayoutResult textLayoutResult2 = null;
                        if (layoutDirection == null || (density = layoutCache.density) == null) {
                            textLayoutResult = null;
                        } else {
                            AnnotatedString annotatedString3 = new AnnotatedString(layoutCache.text);
                            if (layoutCache.paragraph == null || layoutCache.paragraphIntrinsics == null) {
                                textLayoutResult = null;
                            } else {
                                long j = layoutCache.prevConstraints & (-8589934589L);
                                int i3 = layoutCache.maxLines;
                                boolean z3 = layoutCache.softWrap;
                                int i4 = layoutCache.overflow;
                                FontFamily$Resolver fontFamily$Resolver = layoutCache.fontFamilyResolver;
                                EmptyList emptyList = EmptyList.INSTANCE;
                                textLayoutResult = new TextLayoutResult(new TextLayoutInput(annotatedString3, textStyleM648mergedA7vx0o$default, emptyList, i3, z3, i4, density, layoutDirection, fontFamily$Resolver, j), new MultiParagraph(new Request(annotatedString3, textStyleM648mergedA7vx0o$default, emptyList, density, fontFamily$Resolver), j, layoutCache.maxLines, layoutCache.overflow), layoutCache.layoutSize);
                            }
                        }
                        if (textLayoutResult != null) {
                            list.add(textLayoutResult);
                            textLayoutResult2 = textLayoutResult;
                        }
                        return Boolean.valueOf(textLayoutResult2 != null);
                    case 1:
                        String str = ((AnnotatedString) obj).text;
                        TextStringSimpleNode textStringSimpleNode2 = this.f$0;
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue2 = textStringSimpleNode2.textSubstitution;
                        if (textSubstitutionValue2 == null) {
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue3 = new TextStringSimpleNode.TextSubstitutionValue(textStringSimpleNode2.text, str);
                            ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, textStringSimpleNode2.style, textStringSimpleNode2.fontFamilyResolver, textStringSimpleNode2.overflow, textStringSimpleNode2.softWrap, textStringSimpleNode2.maxLines, textStringSimpleNode2.minLines);
                            paragraphLayoutCache.setDensity$foundation(textStringSimpleNode2.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = paragraphLayoutCache;
                            textStringSimpleNode2.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(str, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = str;
                            ParagraphLayoutCache paragraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (paragraphLayoutCache2 != null) {
                                paragraphLayoutCache2.m206updateL6sJoHM(str, textStringSimpleNode2.style, textStringSimpleNode2.fontFamilyResolver, textStringSimpleNode2.overflow, textStringSimpleNode2.softWrap, textStringSimpleNode2.maxLines, textStringSimpleNode2.minLines);
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textStringSimpleNode2);
                        HitTestResultKt.invalidateMeasurement(textStringSimpleNode2);
                        HitTestResultKt.invalidateDraw(textStringSimpleNode2);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextStringSimpleNode textStringSimpleNode3 = this.f$0;
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue4 = textStringSimpleNode3.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            textSubstitutionValue4.isShowingSubstitution = zBooleanValue;
                            HitTestResultKt.invalidateSemantics(textStringSimpleNode3);
                            HitTestResultKt.invalidateMeasurement(textStringSimpleNode3);
                            HitTestResultKt.invalidateDraw(textStringSimpleNode3);
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        final int i3 = 2;
        semanticsPropertyReceiver.set(SemanticsActions.ShowTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0
            public final /* synthetic */ TextStringSimpleNode f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x00a7  */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Density density;
                TextLayoutResult textLayoutResult;
                boolean z2;
                switch (i3) {
                    case 0:
                        List list = (List) obj;
                        TextStringSimpleNode textStringSimpleNode = this.f$0;
                        ParagraphLayoutCache layoutCache = textStringSimpleNode.getLayoutCache();
                        TextStyle textStyleM648mergedA7vx0o$default = TextStyle.m648mergedA7vx0o$default(textStringSimpleNode.style, Color.Unspecified, 0L, null, null, 0L, 0, 0L, 16777214);
                        LayoutDirection layoutDirection = layoutCache.intrinsicsLayoutDirection;
                        TextLayoutResult textLayoutResult2 = null;
                        if (layoutDirection == null || (density = layoutCache.density) == null) {
                            textLayoutResult = null;
                        } else {
                            AnnotatedString annotatedString3 = new AnnotatedString(layoutCache.text);
                            if (layoutCache.paragraph == null || layoutCache.paragraphIntrinsics == null) {
                                textLayoutResult = null;
                            } else {
                                long j = layoutCache.prevConstraints & (-8589934589L);
                                int i4 = layoutCache.maxLines;
                                boolean z3 = layoutCache.softWrap;
                                int i5 = layoutCache.overflow;
                                FontFamily$Resolver fontFamily$Resolver = layoutCache.fontFamilyResolver;
                                EmptyList emptyList = EmptyList.INSTANCE;
                                textLayoutResult = new TextLayoutResult(new TextLayoutInput(annotatedString3, textStyleM648mergedA7vx0o$default, emptyList, i4, z3, i5, density, layoutDirection, fontFamily$Resolver, j), new MultiParagraph(new Request(annotatedString3, textStyleM648mergedA7vx0o$default, emptyList, density, fontFamily$Resolver), j, layoutCache.maxLines, layoutCache.overflow), layoutCache.layoutSize);
                            }
                        }
                        if (textLayoutResult != null) {
                            list.add(textLayoutResult);
                            textLayoutResult2 = textLayoutResult;
                        }
                        return Boolean.valueOf(textLayoutResult2 != null);
                    case 1:
                        String str = ((AnnotatedString) obj).text;
                        TextStringSimpleNode textStringSimpleNode2 = this.f$0;
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue2 = textStringSimpleNode2.textSubstitution;
                        if (textSubstitutionValue2 == null) {
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue3 = new TextStringSimpleNode.TextSubstitutionValue(textStringSimpleNode2.text, str);
                            ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, textStringSimpleNode2.style, textStringSimpleNode2.fontFamilyResolver, textStringSimpleNode2.overflow, textStringSimpleNode2.softWrap, textStringSimpleNode2.maxLines, textStringSimpleNode2.minLines);
                            paragraphLayoutCache.setDensity$foundation(textStringSimpleNode2.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = paragraphLayoutCache;
                            textStringSimpleNode2.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(str, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = str;
                            ParagraphLayoutCache paragraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (paragraphLayoutCache2 != null) {
                                paragraphLayoutCache2.m206updateL6sJoHM(str, textStringSimpleNode2.style, textStringSimpleNode2.fontFamilyResolver, textStringSimpleNode2.overflow, textStringSimpleNode2.softWrap, textStringSimpleNode2.maxLines, textStringSimpleNode2.minLines);
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textStringSimpleNode2);
                        HitTestResultKt.invalidateMeasurement(textStringSimpleNode2);
                        HitTestResultKt.invalidateDraw(textStringSimpleNode2);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextStringSimpleNode textStringSimpleNode3 = this.f$0;
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue4 = textStringSimpleNode3.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            textSubstitutionValue4.isShowingSubstitution = zBooleanValue;
                            HitTestResultKt.invalidateSemantics(textStringSimpleNode3);
                            HitTestResultKt.invalidateMeasurement(textStringSimpleNode3);
                            HitTestResultKt.invalidateDraw(textStringSimpleNode3);
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        semanticsPropertyReceiver.set(SemanticsActions.ClearTextSubstitution, new AccessibilityAction(null, new BasicTextKt$$ExternalSyntheticLambda0(18, this)));
        semanticsPropertyReceiver.set(SemanticsActions.GetTextLayoutResult, new AccessibilityAction(null, r0));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0016  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        ParagraphLayoutCache layoutCache;
        if (this.isAttached) {
            TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
            if (textSubstitutionValue == null) {
                layoutCache = getLayoutCache();
            } else {
                if (!textSubstitutionValue.isShowingSubstitution) {
                    textSubstitutionValue = null;
                }
                if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                    layoutCache = getLayoutCache();
                }
            }
            AndroidParagraph androidParagraph = layoutCache.paragraph;
            if (androidParagraph == null) {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Internal Error: ParagraphLayoutCache could not provide a Paragraph during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: (layoutCache=" + this._layoutCache + ", textSubstitution=" + this.textSubstitution + ')');
                throw new HttpException();
            }
            Canvas canvas = layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas();
            boolean z = layoutCache.didOverflow;
            if (z) {
                long j = layoutCache.layoutSize;
                canvas.save();
                canvas.mo393clipRectN_I0leg(0.0f, 0.0f, (int) (j >> 32), (int) (j & 4294967295L), 1);
            }
            try {
                m212resolveInheritedStyleuwmK9pY(2);
                TextStyle textStyle = this.resolvedInheritedStyle;
                if (textStyle == null) {
                    textStyle = this.style;
                }
                SpanStyle spanStyle = textStyle.spanStyle;
                TextDecoration textDecoration = spanStyle.textDecoration;
                if (textDecoration == null) {
                    textDecoration = TextDecoration.None;
                }
                TextDecoration textDecoration2 = textDecoration;
                Shadow shadow = spanStyle.shadow;
                if (shadow == null) {
                    shadow = Shadow.None;
                }
                Shadow shadow2 = shadow;
                DrawStyle drawStyle = spanStyle.drawStyle;
                if (drawStyle == null) {
                    drawStyle = Fill.INSTANCE;
                }
                DrawStyle drawStyle2 = drawStyle;
                Brush brush = spanStyle.textForegroundStyle.getBrush();
                if (brush != null) {
                    androidParagraph.m624painthn5TExg(canvas, brush, textStyle.spanStyle.textForegroundStyle.getAlpha(), shadow2, textDecoration2, drawStyle2);
                } else {
                    long jM649getColor0d7_KjU = Color.Unspecified;
                    if (jM649getColor0d7_KjU == 16) {
                        jM649getColor0d7_KjU = textStyle.m649getColor0d7_KjU() != 16 ? textStyle.m649getColor0d7_KjU() : Color.Black;
                    }
                    androidParagraph.m623paintLG529CI(canvas, jM649getColor0d7_KjU, shadow2, textDecoration2, drawStyle2);
                }
            } finally {
                if (z) {
                    canvas.restore();
                }
            }
        }
    }

    public final ParagraphLayoutCache getLayoutCache() {
        TextStyle textStyle = this.resolvedInheritedStyle;
        if (textStyle == null) {
            textStyle = this.style;
        }
        TextStyle textStyle2 = textStyle;
        if (this._layoutCache == null) {
            this._layoutCache = new ParagraphLayoutCache(this.text, textStyle2, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
        }
        return this._layoutCache;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0031  */
    public final ParagraphLayoutCache getLayoutCacheForMeasure(MeasureScope measureScope) {
        ParagraphLayoutCache layoutCache;
        if (m212resolveInheritedStyleuwmK9pY(1)) {
            TextStyle textStyle = this.resolvedInheritedStyle;
            if (textStyle == null) {
                textStyle = this.style;
            }
            getLayoutCache().m206updateL6sJoHM(this.text, textStyle, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
        }
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            layoutCache = getLayoutCache();
        } else {
            if (!textSubstitutionValue.isShowingSubstitution) {
                textSubstitutionValue = null;
            }
            if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                layoutCache = getLayoutCache();
            }
        }
        layoutCache.setDensity$foundation(measureScope);
        return layoutCache;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return getLayoutCacheForMeasure(lookaheadCapablePlaceable).intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return BasicTextKt.ceilToIntPx(getLayoutCacheForMeasure(lookaheadCapablePlaceable).setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMaxIntrinsicWidth());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Trace.beginSection("TextStringSimpleNode::measure");
        try {
            ParagraphLayoutCache layoutCacheForMeasure = getLayoutCacheForMeasure(measureScope);
            boolean zM205layoutWithConstraintsK40F9xA = layoutCacheForMeasure.m205layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
            ParagraphIntrinsics paragraphIntrinsics = layoutCacheForMeasure.paragraphIntrinsics;
            if (paragraphIntrinsics != null) {
                paragraphIntrinsics.getHasStaleResolvedFonts();
            }
            Unit unit = Unit.INSTANCE;
            AndroidParagraph androidParagraph = layoutCacheForMeasure.paragraph;
            long j2 = layoutCacheForMeasure.layoutSize;
            if (zM205layoutWithConstraintsK40F9xA) {
                HitTestResultKt.invalidateLayer(this);
                HashMap map = this.baselineCache;
                if (map == null) {
                    map = new HashMap(2);
                    this.baselineCache = map;
                }
                map.put(AlignmentLineKt.FirstBaseline, Integer.valueOf(Math.round(androidParagraph.layout.getLineBaseline(0))));
                HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.LastBaseline;
                TextLayout textLayout = androidParagraph.layout;
                map.put(horizontalAlignmentLine, Integer.valueOf(Math.round(textLayout.getLineBaseline(textLayout.lineCount - 1))));
            }
            int i = (int) (j2 >> 32);
            int i2 = (int) (j2 & 4294967295L);
            return measureScope.layout(i, i2, this.baselineCache, new ContentPainterNode$$ExternalSyntheticLambda0(measurable.mo517measureBRTryo0(Constraints.Companion.m688fitPrioritizingWidthZbe2FdA(i, i, i2, i2)), 10));
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return getLayoutCacheForMeasure(lookaheadCapablePlaceable).intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return BasicTextKt.ceilToIntPx(getLayoutCacheForMeasure(lookaheadCapablePlaceable).setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMinIntrinsicWidth());
    }

    /* JADX INFO: renamed from: resolveInheritedStyle-uwmK9pY, reason: not valid java name */
    public final boolean m212resolveInheritedStyleuwmK9pY(int i) {
        TextStyle textStyle = this.resolvedInheritedStyle;
        TextStyle textStyle2 = this.style;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = textStyle2;
        HitTestResultKt.traverseAncestors(this, "StyleOuterNode", new ScrollNode$$ExternalSyntheticLambda0(i, 3, ref$ObjectRef, textStyle2));
        TextStyle textStyle3 = (TextStyle) ref$ObjectRef.element;
        this.resolvedInheritedStyle = textStyle3;
        if (textStyle == null) {
            return false;
        }
        return !textStyle.equals(textStyle3);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
