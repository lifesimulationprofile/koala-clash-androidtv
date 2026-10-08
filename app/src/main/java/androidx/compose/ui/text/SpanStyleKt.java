package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import coil.network.HttpException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpanStyleKt {
    public static final TextForegroundStyle DefaultColorForegroundStyle;
    public static final long DefaultFontSize = TextUnitKt.getSp(14);
    public static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    public static final long DefaultBackgroundColor = Color.Transparent;

    static {
        long j = Color.Black;
        DefaultColorForegroundStyle = j != 16 ? new ColorStyle(j) : TextForegroundStyle.Unspecified.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x015d  */
    /* JADX WARN: Code duplicated, block: B:101:0x0160  */
    /* JADX WARN: Code duplicated, block: B:103:0x0164  */
    /* JADX WARN: Code duplicated, block: B:104:0x0167  */
    /* JADX WARN: Code duplicated, block: B:106:0x016a  */
    /* JADX WARN: Code duplicated, block: B:108:0x016f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0178  */
    /* JADX WARN: Code duplicated, block: B:113:0x017c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0181  */
    /* JADX WARN: Code duplicated, block: B:116:0x0184  */
    /* JADX WARN: Code duplicated, block: B:119:0x018a  */
    /* JADX WARN: Code duplicated, block: B:120:0x018d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0193  */
    /* JADX WARN: Code duplicated, block: B:124:0x019a  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:80:0x0112  */
    /* JADX WARN: Code duplicated, block: B:82:0x0116  */
    /* JADX WARN: Code duplicated, block: B:84:0x0125  */
    /* JADX WARN: Code duplicated, block: B:85:0x012b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0131  */
    /* JADX WARN: Code duplicated, block: B:88:0x013a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0140  */
    /* JADX WARN: Code duplicated, block: B:92:0x0144  */
    /* JADX WARN: Code duplicated, block: B:95:0x0151  */
    /* JADX WARN: Code duplicated, block: B:97:0x0156  */
    /* JADX WARN: Code duplicated, block: B:98:0x0159  */
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    public static final SpanStyle m636fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, SystemFontFamily systemFontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        BaselineShift baselineShift2;
        Shadow shadow2;
        PlatformSpanStyle platformSpanStyle2;
        DrawStyle drawStyle2;
        TextForegroundStyle colorStyle;
        long j5;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j6;
        TextDecoration textDecoration2;
        PlatformSpanStyle platformSpanStyle3;
        long jM675modulateDxMtmZc;
        FontSynthesis fontSynthesis2 = fontSynthesis;
        SystemFontFamily systemFontFamily2 = systemFontFamily;
        String str2 = str;
        long j7 = j3;
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        long j8 = j2 & 1095216660480L;
        if ((j8 == 0 || TextUnit.m725equalsimpl0(j2, spanStyle.fontSize)) && ((brush != null || j == 16 || Color.m435equalsimpl0(j, spanStyle.textForegroundStyle.mo668getColor0d7_KjU())) && ((fontStyle == null || fontStyle.equals(spanStyle.fontStyle)) && ((fontWeight == null || fontWeight.equals(spanStyle.fontWeight)) && ((systemFontFamily2 == null || systemFontFamily2 == spanStyle.fontFamily) && (((j7 & 1095216660480L) == 0 || TextUnit.m725equalsimpl0(j7, spanStyle.letterSpacing)) && ((textDecoration == null || textDecoration.equals(spanStyle.textDecoration)) && Intrinsics.areEqual(brush, spanStyle.textForegroundStyle.getBrush()) && ((brush == null || f == spanStyle.textForegroundStyle.getAlpha()) && ((fontSynthesis2 == null || fontSynthesis2.equals(spanStyle.fontSynthesis)) && (str2 == null || str2.equals(spanStyle.fontFeatureSettings))))))))))) {
            if (baselineShift != null) {
                baselineShift2 = baselineShift;
                if (baselineShift2.equals(spanStyle.baselineShift)) {
                }
                colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
                if (brush != null) {
                    if (brush instanceof SolidColor) {
                        jM675modulateDxMtmZc = TextDrawStyleKt.m675modulateDxMtmZc(f, ((SolidColor) brush).value);
                        if (jM675modulateDxMtmZc != 16) {
                            colorStyle = new ColorStyle(jM675modulateDxMtmZc);
                        }
                    } else {
                        if (!(brush instanceof ShaderBrush)) {
                            throw new HttpException();
                        }
                        colorStyle = new BrushStyle((ShaderBrush) brush, f);
                    }
                } else if (j != 16) {
                    colorStyle = new ColorStyle(j);
                }
                TextForegroundStyle textForegroundStyleMerge = spanStyle.textForegroundStyle.merge(colorStyle);
                if (systemFontFamily2 == null) {
                    systemFontFamily2 = spanStyle.fontFamily;
                }
                if (j8 == 0) {
                    j5 = spanStyle.fontSize;
                } else {
                    j5 = j2;
                }
                if (fontWeight == null) {
                    fontWeight2 = spanStyle.fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (fontStyle == null) {
                    fontStyle2 = spanStyle.fontStyle;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (fontSynthesis2 == null) {
                    fontSynthesis2 = spanStyle.fontSynthesis;
                }
                if (str2 == null) {
                    str2 = spanStyle.fontFeatureSettings;
                }
                if ((j7 & 1095216660480L) == 0) {
                    j7 = spanStyle.letterSpacing;
                }
                if (baselineShift2 == null) {
                    baselineShift2 = spanStyle.baselineShift;
                }
                if (textGeometricTransform == null) {
                    textGeometricTransform2 = spanStyle.textGeometricTransform;
                } else {
                    textGeometricTransform2 = textGeometricTransform;
                }
                if (localeList == null) {
                    localeList2 = spanStyle.localeList;
                } else {
                    localeList2 = localeList;
                }
                if (j4 != 16) {
                    j6 = j4;
                } else {
                    j6 = spanStyle.background;
                }
                if (textDecoration == null) {
                    textDecoration2 = spanStyle.textDecoration;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (shadow2 == null) {
                    shadow2 = spanStyle.shadow;
                }
                long j9 = j6;
                platformSpanStyle3 = spanStyle.platformStyle;
                if (platformSpanStyle3 == null) {
                    platformSpanStyle3 = platformSpanStyle2;
                }
                if (drawStyle2 == null) {
                    drawStyle2 = spanStyle.drawStyle;
                }
                return new SpanStyle(textForegroundStyleMerge, j5, fontWeight2, fontStyle2, fontSynthesis2, systemFontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j9, textDecoration2, shadow2, platformSpanStyle3, drawStyle2);
            }
            baselineShift2 = baselineShift;
            if (textGeometricTransform == null || textGeometricTransform.equals(spanStyle.textGeometricTransform)) {
                if (localeList == null || localeList.equals(spanStyle.localeList)) {
                    if (j4 == 16 || Color.m435equalsimpl0(j4, spanStyle.background)) {
                        shadow2 = shadow;
                        if (shadow2 == null || shadow2.equals(spanStyle.shadow)) {
                            platformSpanStyle2 = platformSpanStyle;
                            if (platformSpanStyle2 == null || platformSpanStyle2.equals(spanStyle.platformStyle)) {
                                drawStyle2 = drawStyle;
                                if (drawStyle2 == null || drawStyle2.equals(spanStyle.drawStyle)) {
                                    return spanStyle;
                                }
                            }
                        }
                        drawStyle2 = drawStyle;
                    }
                    platformSpanStyle2 = platformSpanStyle;
                    drawStyle2 = drawStyle;
                }
            }
            colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
            if (brush != null) {
                if (brush instanceof SolidColor) {
                    jM675modulateDxMtmZc = TextDrawStyleKt.m675modulateDxMtmZc(f, ((SolidColor) brush).value);
                    if (jM675modulateDxMtmZc != 16) {
                        colorStyle = new ColorStyle(jM675modulateDxMtmZc);
                    }
                } else {
                    if (!(brush instanceof ShaderBrush)) {
                        throw new HttpException();
                    }
                    colorStyle = new BrushStyle((ShaderBrush) brush, f);
                }
            } else if (j != 16) {
                colorStyle = new ColorStyle(j);
            }
            TextForegroundStyle textForegroundStyleMerge2 = spanStyle.textForegroundStyle.merge(colorStyle);
            if (systemFontFamily2 == null) {
                systemFontFamily2 = spanStyle.fontFamily;
            }
            if (j8 == 0) {
                j5 = spanStyle.fontSize;
            } else {
                j5 = j2;
            }
            if (fontWeight == null) {
                fontWeight2 = spanStyle.fontWeight;
            } else {
                fontWeight2 = fontWeight;
            }
            if (fontStyle == null) {
                fontStyle2 = spanStyle.fontStyle;
            } else {
                fontStyle2 = fontStyle;
            }
            if (fontSynthesis2 == null) {
                fontSynthesis2 = spanStyle.fontSynthesis;
            }
            if (str2 == null) {
                str2 = spanStyle.fontFeatureSettings;
            }
            if ((j7 & 1095216660480L) == 0) {
                j7 = spanStyle.letterSpacing;
            }
            if (baselineShift2 == null) {
                baselineShift2 = spanStyle.baselineShift;
            }
            if (textGeometricTransform == null) {
                textGeometricTransform2 = spanStyle.textGeometricTransform;
            } else {
                textGeometricTransform2 = textGeometricTransform;
            }
            if (localeList == null) {
                localeList2 = spanStyle.localeList;
            } else {
                localeList2 = localeList;
            }
            if (j4 != 16) {
                j6 = j4;
            } else {
                j6 = spanStyle.background;
            }
            if (textDecoration == null) {
                textDecoration2 = spanStyle.textDecoration;
            } else {
                textDecoration2 = textDecoration;
            }
            if (shadow2 == null) {
                shadow2 = spanStyle.shadow;
            }
            long j10 = j6;
            platformSpanStyle3 = spanStyle.platformStyle;
            if (platformSpanStyle3 == null) {
                platformSpanStyle3 = platformSpanStyle2;
            }
            if (drawStyle2 == null) {
                drawStyle2 = spanStyle.drawStyle;
            }
            return new SpanStyle(textForegroundStyleMerge2, j5, fontWeight2, fontStyle2, fontSynthesis2, systemFontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j10, textDecoration2, shadow2, platformSpanStyle3, drawStyle2);
        }
        baselineShift2 = baselineShift;
        shadow2 = shadow;
        platformSpanStyle2 = platformSpanStyle;
        drawStyle2 = drawStyle;
        colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
        if (brush != null) {
            if (brush instanceof SolidColor) {
                jM675modulateDxMtmZc = TextDrawStyleKt.m675modulateDxMtmZc(f, ((SolidColor) brush).value);
                if (jM675modulateDxMtmZc != 16) {
                    colorStyle = new ColorStyle(jM675modulateDxMtmZc);
                }
            } else {
                if (!(brush instanceof ShaderBrush)) {
                    throw new HttpException();
                }
                colorStyle = new BrushStyle((ShaderBrush) brush, f);
            }
        } else if (j != 16) {
            colorStyle = new ColorStyle(j);
        }
        TextForegroundStyle textForegroundStyleMerge3 = spanStyle.textForegroundStyle.merge(colorStyle);
        if (systemFontFamily2 == null) {
            systemFontFamily2 = spanStyle.fontFamily;
        }
        if (j8 == 0) {
            j5 = spanStyle.fontSize;
        } else {
            j5 = j2;
        }
        if (fontWeight == null) {
            fontWeight2 = spanStyle.fontWeight;
        } else {
            fontWeight2 = fontWeight;
        }
        if (fontStyle == null) {
            fontStyle2 = spanStyle.fontStyle;
        } else {
            fontStyle2 = fontStyle;
        }
        if (fontSynthesis2 == null) {
            fontSynthesis2 = spanStyle.fontSynthesis;
        }
        if (str2 == null) {
            str2 = spanStyle.fontFeatureSettings;
        }
        if ((j7 & 1095216660480L) == 0) {
            j7 = spanStyle.letterSpacing;
        }
        if (baselineShift2 == null) {
            baselineShift2 = spanStyle.baselineShift;
        }
        if (textGeometricTransform == null) {
            textGeometricTransform2 = spanStyle.textGeometricTransform;
        } else {
            textGeometricTransform2 = textGeometricTransform;
        }
        if (localeList == null) {
            localeList2 = spanStyle.localeList;
        } else {
            localeList2 = localeList;
        }
        if (j4 != 16) {
            j6 = j4;
        } else {
            j6 = spanStyle.background;
        }
        if (textDecoration == null) {
            textDecoration2 = spanStyle.textDecoration;
        } else {
            textDecoration2 = textDecoration;
        }
        if (shadow2 == null) {
            shadow2 = spanStyle.shadow;
        }
        long j11 = j6;
        platformSpanStyle3 = spanStyle.platformStyle;
        if (platformSpanStyle3 == null) {
            platformSpanStyle3 = platformSpanStyle2;
        }
        if (drawStyle2 == null) {
            drawStyle2 = spanStyle.drawStyle;
        }
        return new SpanStyle(textForegroundStyleMerge3, j5, fontWeight2, fontStyle2, fontSynthesis2, systemFontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j11, textDecoration2, shadow2, platformSpanStyle3, drawStyle2);
    }

    public static final Object lerpDiscrete(float f, Object obj, Object obj2) {
        return ((double) f) < 0.5d ? obj : obj2;
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m637lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        return ((j & 1095216660480L) == 0 || (1095216660480L & j2) == 0) ? ((TextUnit) lerpDiscrete(f, new TextUnit(j), new TextUnit(j2))).packedValue : TextUnitKt.m730lerpC3pnCVY(j, j2, f);
    }
}
