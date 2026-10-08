package androidx.compose.ui.text;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextStyle {
    public static final TextStyle Default = new TextStyle(0, 0, null, 0, 0, 0, 16777215);
    public final ParagraphStyle paragraphStyle;
    public final PlatformTextStyle platformStyle;
    public final SpanStyle spanStyle;

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    /* JADX INFO: renamed from: copy-p1EtxEg$default, reason: not valid java name */
    public static TextStyle m647copyp1EtxEg$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, SystemFontFamily systemFontFamily, long j3, long j4, LineHeightStyle lineHeightStyle, int i) {
        TextForegroundStyle colorStyle;
        long jMo668getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.textForegroundStyle.mo668getColor0d7_KjU() : j;
        long j5 = (i & 2) != 0 ? textStyle.spanStyle.fontSize : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.fontWeight : fontWeight;
        SpanStyle spanStyle = textStyle.spanStyle;
        FontStyle fontStyle = spanStyle.fontStyle;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        SystemFontFamily systemFontFamily2 = (i & 32) != 0 ? spanStyle.fontFamily : systemFontFamily;
        String str = spanStyle.fontFeatureSettings;
        long j6 = (i & 128) != 0 ? spanStyle.letterSpacing : j3;
        BaselineShift baselineShift = spanStyle.baselineShift;
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        LocaleList localeList = spanStyle.localeList;
        long j7 = spanStyle.background;
        TextDecoration textDecoration = spanStyle.textDecoration;
        Shadow shadow = spanStyle.shadow;
        DrawStyle drawStyle = spanStyle.drawStyle;
        ParagraphStyle paragraphStyle = textStyle.paragraphStyle;
        int i2 = paragraphStyle.textAlign;
        int i3 = paragraphStyle.textDirection;
        long j8 = (i & 131072) != 0 ? paragraphStyle.lineHeight : j4;
        TextIndent textIndent = paragraphStyle.textIndent;
        PlatformTextStyle platformTextStyle = (i & 524288) != 0 ? textStyle.platformStyle : LayoutUtilKt.DefaultPlatformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & 1048576) != 0 ? paragraphStyle.lineHeightStyle : lineHeightStyle;
        int i4 = paragraphStyle.lineBreak;
        int i5 = paragraphStyle.hyphens;
        TextMotion textMotion = paragraphStyle.textMotion;
        if (Color.m435equalsimpl0(jMo668getColor0d7_KjU, spanStyle.textForegroundStyle.mo668getColor0d7_KjU())) {
            colorStyle = spanStyle.textForegroundStyle;
        } else {
            colorStyle = jMo668getColor0d7_KjU != 16 ? new ColorStyle(jMo668getColor0d7_KjU) : TextForegroundStyle.Unspecified.INSTANCE;
        }
        return new TextStyle(new SpanStyle(colorStyle, j5, fontWeight2, fontStyle, fontSynthesis, systemFontFamily2, str, j6, baselineShift, textGeometricTransform, localeList, j7, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.spanStyle : null, drawStyle), new ParagraphStyle(i2, i3, j8, textIndent, platformTextStyle != null ? platformTextStyle.paragraphStyle : null, lineHeightStyle2, i4, i5, textMotion), platformTextStyle);
    }

    /* JADX INFO: renamed from: merge-dA7vx0o$default, reason: not valid java name */
    public static TextStyle m648mergedA7vx0o$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, long j3, int i, long j4, int i2) {
        long j5 = (i2 & 2) != 0 ? TextUnit.Unspecified : j2;
        FontWeight fontWeight2 = (i2 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i2 & 8) != 0 ? null : fontStyle;
        long j6 = (i2 & 128) != 0 ? TextUnit.Unspecified : j3;
        long j7 = Color.Unspecified;
        int i3 = (32768 & i2) != 0 ? 0 : i;
        long j8 = (i2 & 131072) != 0 ? TextUnit.Unspecified : j4;
        SpanStyle spanStyleM636fastMergedSHsh3o = SpanStyleKt.m636fastMergedSHsh3o(textStyle.spanStyle, j, null, Float.NaN, j5, fontWeight2, fontStyle2, null, null, null, j6, null, null, null, j7, null, null, null, null);
        ParagraphStyle paragraphStyleM635fastMergej5T8yCg = ParagraphStyleKt.m635fastMergej5T8yCg(textStyle.paragraphStyle, i3, 0, j8, null, null, null, 0, 0, null);
        return (textStyle.spanStyle == spanStyleM636fastMergedSHsh3o && textStyle.paragraphStyle == paragraphStyleM635fastMergej5T8yCg) ? textStyle : new TextStyle(spanStyleM636fastMergedSHsh3o, paragraphStyleM635fastMergej5T8yCg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle);
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m649getColor0d7_KjU() {
        return this.spanStyle.textForegroundStyle.mo668getColor0d7_KjU();
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle textStyle) {
        if (this != textStyle) {
            return Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text(textStyle.spanStyle);
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = (this.paragraphStyle.hashCode() + (this.spanStyle.hashCode() * 31)) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final TextStyle merge(TextStyle textStyle) {
        return (textStyle == null || textStyle.equals(Default)) ? this : new TextStyle(this.spanStyle.merge(textStyle.spanStyle), this.paragraphStyle.merge(textStyle.paragraphStyle));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextStyle(color=");
        sb.append((Object) Color.m441toStringimpl(m649getColor0d7_KjU()));
        sb.append(", brush=");
        SpanStyle spanStyle = this.spanStyle;
        sb.append(spanStyle.textForegroundStyle.getBrush());
        sb.append(", alpha=");
        sb.append(spanStyle.textForegroundStyle.getAlpha());
        sb.append(", fontSize=");
        sb.append((Object) TextUnit.m729toStringimpl(spanStyle.fontSize));
        sb.append(", fontWeight=");
        sb.append(spanStyle.fontWeight);
        sb.append(", fontStyle=");
        sb.append(spanStyle.fontStyle);
        sb.append(", fontSynthesis=");
        sb.append(spanStyle.fontSynthesis);
        sb.append(", fontFamily=");
        sb.append(spanStyle.fontFamily);
        sb.append(", fontFeatureSettings=");
        sb.append(spanStyle.fontFeatureSettings);
        sb.append(", letterSpacing=");
        sb.append((Object) TextUnit.m729toStringimpl(spanStyle.letterSpacing));
        sb.append(", baselineShift=");
        sb.append(spanStyle.baselineShift);
        sb.append(", textGeometricTransform=");
        sb.append(spanStyle.textGeometricTransform);
        sb.append(", localeList=");
        sb.append(spanStyle.localeList);
        sb.append(", background=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(spanStyle.background, sb, ", textDecoration=");
        sb.append(spanStyle.textDecoration);
        sb.append(", shadow=");
        sb.append(spanStyle.shadow);
        sb.append(", drawStyle=");
        sb.append(spanStyle.drawStyle);
        sb.append(", textAlign=");
        ParagraphStyle paragraphStyle = this.paragraphStyle;
        sb.append((Object) TextAlign.m673toStringimpl(paragraphStyle.textAlign));
        sb.append(", textDirection=");
        sb.append((Object) TextDirection.m674toStringimpl(paragraphStyle.textDirection));
        sb.append(", lineHeight=");
        sb.append((Object) TextUnit.m729toStringimpl(paragraphStyle.lineHeight));
        sb.append(", textIndent=");
        sb.append(paragraphStyle.textIndent);
        sb.append(", platformStyle=");
        sb.append(this.platformStyle);
        sb.append(", lineHeightStyle=");
        sb.append(paragraphStyle.lineHeightStyle);
        sb.append(", lineBreak=");
        sb.append((Object) LineBreak.m670toStringimpl(paragraphStyle.lineBreak));
        sb.append(", hyphens=");
        sb.append((Object) Hyphens.m669toStringimpl(paragraphStyle.hyphens));
        sb.append(", textMotion=");
        sb.append(paragraphStyle.textMotion);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        PlatformSpanStyle platformSpanStyle = spanStyle.platformStyle;
        PlatformParagraphStyle platformParagraphStyle = paragraphStyle.platformStyle;
        this(spanStyle, paragraphStyle, (platformSpanStyle == null && platformParagraphStyle == null) ? null : new PlatformTextStyle(platformSpanStyle, platformParagraphStyle));
    }

    public TextStyle(long j, long j2, FontWeight fontWeight, long j3, int i, long j4, int i2) {
        this((i2 & 1) != 0 ? Color.Unspecified : j, (i2 & 2) != 0 ? TextUnit.Unspecified : j2, (i2 & 4) != 0 ? null : fontWeight, null, null, null, null, (i2 & 128) != 0 ? TextUnit.Unspecified : j3, null, null, null, Color.Unspecified, null, null, null, (32768 & i2) != 0 ? 0 : i, 0, (i2 & 131072) != 0 ? TextUnit.Unspecified : j4, null, null, null, 0, 0, null);
    }

    public TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, SystemFontFamily systemFontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, systemFontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.spanStyle : null, drawStyle), new ParagraphStyle(i, i2, j5, textIndent, platformTextStyle != null ? platformTextStyle.paragraphStyle : null, lineHeightStyle, i3, i4, textMotion), platformTextStyle);
    }
}
