package androidx.compose.ui.text;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.util.ListUtilsKt;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.network.HttpException;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ParagraphKt {
    public static final RequestService LineBreakSaver;
    public static final RequestService PlatformParagraphStyleSaver;
    public static final RequestService TextMotionLinearitySaver;
    public static final RequestService TextMotionSaver;
    public static final RequestService emojiSupportMatchSaver;

    static {
        int i = 2;
        PlatformParagraphStyleSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(25), new SaversKt$$ExternalSyntheticLambda2(26));
        emojiSupportMatchSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(26), new SaversKt$$ExternalSyntheticLambda2(27));
        LineBreakSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(27), new SaversKt$$ExternalSyntheticLambda2(28));
        TextMotionSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(28), new SaversKt$$ExternalSyntheticLambda2(29));
        TextMotionLinearitySaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(29), new AsyncImagePainter$$ExternalSyntheticLambda0(1));
    }

    /* JADX INFO: renamed from: Paragraph-Ul8oQg4$default, reason: not valid java name */
    public static AndroidParagraph m632ParagraphUl8oQg4$default(String str, TextStyle textStyle, long j, Density density, FontFamily$Resolver fontFamily$Resolver, int i, int i2) {
        EmptyList emptyList = EmptyList.INSTANCE;
        return new AndroidParagraph(new AndroidParagraphIntrinsics(str, textStyle, emptyList, emptyList, fontFamily$Resolver, density), i, 1, j);
    }

    public static final long TextRange(int i, int i2) {
        if (i < 0 || i2 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start and end cannot be negative. [start: " + i + ", end: " + i2 + ']');
        }
        long j = (((long) i2) & 4294967295L) | (((long) i) << 32);
        int i3 = TextRange.$r8$clinit;
        return j;
    }

    /* JADX INFO: renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m633coerceIn8ffj60Q(int i, long j) {
        int i2 = TextRange.$r8$clinit;
        int i3 = (int) (j >> 32);
        int i4 = i3 < 0 ? 0 : i3;
        if (i4 > i) {
            i4 = i;
        }
        int i5 = (int) (4294967295L & j);
        int i6 = i5 >= 0 ? i5 : 0;
        if (i6 <= i) {
            i = i6;
        }
        return (i4 == i3 && i == i5) ? j : TextRange(i4, i);
    }

    public static final int findParagraphByIndex(int i, List list) {
        int i2;
        byte b;
        int i3 = ((ParagraphInfo) CollectionsKt.last(list)).endIndex;
        if (i > ((ParagraphInfo) CollectionsKt.last(list)).endIndex) {
            InlineClassHelperKt.throwIllegalArgumentException("Index " + i + " should be less or equal than last line's end " + i3);
        }
        int size = list.size() - 1;
        int i4 = 0;
        while (true) {
            if (i4 > size) {
                i2 = -(i4 + 1);
                break;
            }
            i2 = (i4 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i2);
            if (paragraphInfo.startIndex > i) {
                b = 1;
            } else {
                b = paragraphInfo.endIndex <= i ? (byte) -1 : (byte) 0;
            }
            if (b >= 0) {
                if (b <= 0) {
                    break;
                }
                size = i2 - 1;
            } else {
                i4 = i2 + 1;
            }
        }
        if (i2 >= 0 && i2 < list.size()) {
            return i2;
        }
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i2, "Found paragraph index ", " should be in range [0, ");
        sbM.append(list.size());
        sbM.append(").\nDebug info: index=");
        sbM.append(i);
        sbM.append(", paragraphs=[");
        sbM.append(ListUtilsKt.fastJoinToString$default(list, null, new SaversKt$$ExternalSyntheticLambda10(25), 31));
        sbM.append(']');
        InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
        return i2;
    }

    public static final int findParagraphByLineIndex(int i, List list) {
        byte b;
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i3);
            if (paragraphInfo.startLineIndex > i) {
                b = 1;
            } else {
                b = paragraphInfo.endLineIndex <= i ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByY(ArrayList arrayList, float f) {
        byte b;
        if (f <= 0.0f) {
            return 0;
        }
        if (f >= ((ParagraphInfo) CollectionsKt.last(arrayList)).bottom) {
            return AppCompatHintHelper.getLastIndex(arrayList);
        }
        int size = arrayList.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i2);
            if (paragraphInfo.top > f) {
                b = 1;
            } else {
                b = paragraphInfo.bottom <= f ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i = i2 + 1;
            } else {
                if (b <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: renamed from: findParagraphsByRange-Sb-Bc2M, reason: not valid java name */
    public static final void m634findParagraphsByRangeSbBc2M(ArrayList arrayList, long j, Function1 function1) {
        int size = arrayList.size();
        for (int iFindParagraphByIndex = findParagraphByIndex(TextRange.m644getMinimpl(j), arrayList); iFindParagraphByIndex < size; iFindParagraphByIndex++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(iFindParagraphByIndex);
            if (paragraphInfo.startIndex >= TextRange.m643getMaximpl(j)) {
                return;
            }
            if (paragraphInfo.startIndex != paragraphInfo.endIndex) {
                function1.invoke(paragraphInfo);
            }
        }
    }

    public static final TextStyle resolveDefaults(TextStyle textStyle, LayoutDirection layoutDirection) {
        SpanStyle spanStyle = textStyle.spanStyle;
        TextForegroundStyle textForegroundStyle = SpanStyleKt.DefaultColorForegroundStyle;
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.textForegroundStyle.takeOrElse(new ImageLoader$Builder$$ExternalSyntheticLambda2(13));
        long j = spanStyle.fontSize;
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        if ((j & 1095216660480L) == 0) {
            j = SpanStyleKt.DefaultFontSize;
        }
        long j2 = j;
        FontWeight fontWeight = spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = FontWeight.Normal;
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.fontStyle;
        FontStyle fontStyle2 = new FontStyle(fontStyle != null ? fontStyle.value : 0);
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        FontSynthesis fontSynthesis2 = new FontSynthesis(fontSynthesis != null ? fontSynthesis.value : 65535);
        SystemFontFamily systemFontFamily = spanStyle.fontFamily;
        if (systemFontFamily == null) {
            systemFontFamily = SystemFontFamily.Default;
        }
        SystemFontFamily systemFontFamily2 = systemFontFamily;
        String str = spanStyle.fontFeatureSettings;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        long j3 = spanStyle.letterSpacing;
        if ((j3 & 1095216660480L) == 0) {
            j3 = SpanStyleKt.DefaultLetterSpacing;
        }
        long j4 = j3;
        BaselineShift baselineShift = spanStyle.baselineShift;
        float f = baselineShift != null ? baselineShift.multiplier : 0.0f;
        BaselineShift baselineShift2 = new BaselineShift(Float.isNaN(f) ? 0.0f : f);
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.None;
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList current = spanStyle.localeList;
        if (current == null) {
            LocaleList localeList = LocaleList.Empty;
            current = PlatformLocaleKt.platformLocaleDelegate.getCurrent();
        }
        LocaleList localeList2 = current;
        long j5 = spanStyle.background;
        if (j5 == 16) {
            j5 = SpanStyleKt.DefaultBackgroundColor;
        }
        long j6 = j5;
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
        PlatformSpanStyle platformSpanStyle = spanStyle.platformStyle;
        DrawStyle drawStyle = spanStyle.drawStyle;
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        SpanStyle spanStyle2 = new SpanStyle(textForegroundStyleTakeOrElse, j2, fontWeight2, fontStyle2, fontSynthesis2, systemFontFamily2, str2, j4, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, platformSpanStyle, drawStyle);
        ParagraphStyle paragraphStyle = textStyle.paragraphStyle;
        int i = ParagraphStyleKt.$r8$clinit;
        int i2 = paragraphStyle.textAlign;
        int i3 = 5;
        int i4 = i2 == 0 ? 5 : i2;
        int i5 = paragraphStyle.textDirection;
        if (i5 == 3) {
            int iOrdinal = layoutDirection.ordinal();
            if (iOrdinal == 0) {
                i3 = 4;
            } else if (iOrdinal != 1) {
                throw new HttpException();
            }
        } else if (i5 == 0) {
            int iOrdinal2 = layoutDirection.ordinal();
            if (iOrdinal2 == 0) {
                i3 = 1;
            } else {
                if (iOrdinal2 != 1) {
                    throw new HttpException();
                }
                i3 = 2;
            }
        } else {
            i3 = i5;
        }
        long j7 = paragraphStyle.lineHeight;
        if ((j7 & 1095216660480L) == 0) {
            j7 = ParagraphStyleKt.DefaultLineHeight;
        }
        TextIndent textIndent = paragraphStyle.textIndent;
        if (textIndent == null) {
            textIndent = TextIndent.None;
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformParagraphStyle = paragraphStyle.platformStyle;
        LineHeightStyle lineHeightStyle = paragraphStyle.lineHeightStyle;
        int i6 = paragraphStyle.lineBreak;
        if (i6 == 0) {
            i6 = LineBreak.Simple;
        }
        int i7 = i6;
        int i8 = paragraphStyle.hyphens;
        int i9 = i8 == 0 ? 1 : i8;
        TextMotion textMotion = paragraphStyle.textMotion;
        if (textMotion == null) {
            textMotion = TextMotion.Static;
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(i4, i3, j7, textIndent2, platformParagraphStyle, lineHeightStyle, i7, i9, textMotion), textStyle.platformStyle);
    }
}
