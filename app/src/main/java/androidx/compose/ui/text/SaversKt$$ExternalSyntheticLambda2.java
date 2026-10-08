package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import coil.network.HttpException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda2(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Color color;
        Color color2;
        Color color3;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                List list = (List) obj;
                Object obj2 = list.get(0);
                String str = obj2 != null ? (String) obj2 : null;
                Object obj3 = list.get(1);
                return new LinkAnnotation.Url(str, (Intrinsics.areEqual(obj3, Boolean.FALSE) || obj3 == null) ? null : (TextLinkStyles) ((Function1) SaversKt.TextLinkStylesSaver.hardwareBitmapService).invoke(obj3));
            case 1:
                return new FontWeight(((Integer) obj).intValue());
            case 2:
                return new BaselineShift(((Float) obj).floatValue());
            case 3:
                List list2 = (List) obj;
                Object obj4 = list2.get(0);
                int iIntValue = (obj4 != null ? (Integer) obj4 : null).intValue();
                Object obj5 = list2.get(1);
                return new TextRange(ParagraphKt.TextRange(iIntValue, (obj5 != null ? (Integer) obj5 : null).intValue()));
            case 4:
                List list3 = (List) obj;
                Object obj6 = list3.get(0);
                int i2 = Color.$r8$clinit;
                Boolean bool = Boolean.FALSE;
                Intrinsics.areEqual(obj6, bool);
                if (obj6 != null) {
                    color = Intrinsics.areEqual(obj6, Boolean.FALSE) ? new Color(Color.Unspecified) : new Color(BrushKt.Color(((Integer) obj6).intValue()));
                } else {
                    color = null;
                }
                long j = color.value;
                Object obj7 = list3.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$1 = SaversKt.OffsetSaver;
                Intrinsics.areEqual(obj7, bool);
                long j2 = (obj7 != null ? (Offset) saversKt$NonNullValueClassSaver$1.$restore.invoke(obj7) : null).packedValue;
                Object obj8 = list3.get(2);
                return new Shadow(j, j2, (obj8 != null ? (Float) obj8 : null).floatValue());
            case 5:
                return new TextAlign(((Integer) obj).intValue());
            case 6:
                return new TextDirection(((Integer) obj).intValue());
            case 7:
                return new Hyphens(((Integer) obj).intValue());
            case 8:
                List list4 = (List) obj;
                ArrayList arrayList = new ArrayList(list4.size());
                int size = list4.size();
                while (i < size) {
                    Object obj9 = list4.get(i);
                    arrayList.add((Intrinsics.areEqual(obj9, Boolean.FALSE) || obj9 == null) ? null : (AnnotatedString.Range) ((Function1) SaversKt.AnnotationRangeSaver.hardwareBitmapService).invoke(obj9));
                    i++;
                }
                return arrayList;
            case 9:
                return new FontStyle(((Integer) obj).intValue());
            case 10:
                return new FontSynthesis(((Integer) obj).intValue());
            case 11:
                Boolean bool2 = Boolean.FALSE;
                if (Intrinsics.areEqual(obj, bool2)) {
                    return new TextUnit(TextUnit.Unspecified);
                }
                List list5 = (List) obj;
                Object obj10 = list5.get(0);
                float fFloatValue = (obj10 != null ? (Float) obj10 : null).floatValue();
                Object obj11 = list5.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$2 = SaversKt.TextUnitTypeSaver;
                Intrinsics.areEqual(obj11, bool2);
                return new TextUnit(TextUnitKt.pack(fFloatValue, (obj11 != null ? (TextUnitType) saversKt$NonNullValueClassSaver$2.$restore.invoke(obj11) : null).type));
            case 12:
                if (Intrinsics.areEqual(obj, 0)) {
                    return new TextUnitType(8589934592L);
                }
                return Intrinsics.areEqual(obj, 1) ? new TextUnitType(4294967296L) : new TextUnitType(0L);
            case 13:
                if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                    return new Offset(9205357640488583168L);
                }
                List list6 = (List) obj;
                Object obj12 = list6.get(0);
                float fFloatValue2 = (obj12 != null ? (Float) obj12 : null).floatValue();
                Object obj13 = list6.get(1);
                return new Offset((((long) Float.floatToRawIntBits(fFloatValue2)) << 32) | (((long) Float.floatToRawIntBits((obj13 != null ? (Float) obj13 : null).floatValue())) & 4294967295L));
            case 14:
                List list7 = (List) obj;
                ArrayList arrayList2 = new ArrayList(list7.size());
                int size2 = list7.size();
                while (i < size2) {
                    Object obj14 = list7.get(i);
                    arrayList2.add((Intrinsics.areEqual(obj14, Boolean.FALSE) || obj14 == null) ? null : (Locale) ((Function1) SaversKt.LocaleSaver.hardwareBitmapService).invoke(obj14));
                    i++;
                }
                return new LocaleList(arrayList2);
            case 15:
                String str2 = (String) obj;
                java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(str2);
                if (Intrinsics.areEqual(localeForLanguageTag.toLanguageTag(), "und")) {
                    System.err.println("The language tag " + str2 + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
                }
                return new Locale(localeForLanguageTag);
            case 16:
                List list8 = (List) obj;
                Object obj15 = list8.get(0);
                String str3 = obj15 != null ? (String) obj15 : null;
                Object obj16 = list8.get(1);
                return new LinkAnnotation.Clickable(str3, (Intrinsics.areEqual(obj16, Boolean.FALSE) || obj16 == null) ? null : (TextLinkStyles) ((Function1) SaversKt.TextLinkStylesSaver.hardwareBitmapService).invoke(obj16));
            case 17:
                List list9 = (List) obj;
                Object obj17 = list9.get(0);
                float f = LineHeightStyle.Alignment.Center;
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$3 = SaversKt.LineHeightStyleAlignmentSaver;
                Boolean bool3 = Boolean.FALSE;
                Intrinsics.areEqual(obj17, bool3);
                float f2 = (obj17 != null ? (LineHeightStyle.Alignment) saversKt$NonNullValueClassSaver$3.$restore.invoke(obj17) : null).topRatio;
                Object obj18 = list9.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$4 = SaversKt.LineHeightStyleTrimSaver;
                Intrinsics.areEqual(obj18, bool3);
                int i3 = (obj18 != null ? (LineHeightStyle.Trim) saversKt$NonNullValueClassSaver$4.$restore.invoke(obj18) : null).value;
                Object obj19 = list9.get(2);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$5 = SaversKt.LineHeightStyleModeSaver;
                Intrinsics.areEqual(obj19, bool3);
                return new LineHeightStyle(f2, i3, (obj19 != null ? (LineHeightStyle.Mode) saversKt$NonNullValueClassSaver$5.$restore.invoke(obj19) : null).value);
            case 18:
                float fFloatValue3 = ((Float) obj).floatValue();
                LineHeightStyle.Alignment.m671constructorimpl(fFloatValue3);
                return new LineHeightStyle.Alignment(fFloatValue3);
            case 19:
                return new LineHeightStyle.Trim(((Integer) obj).intValue());
            case 20:
                List list10 = (List) obj;
                Object obj20 = list10.get(0);
                AnnotationType annotationType = obj20 != null ? (AnnotationType) obj20 : null;
                Object obj21 = list10.get(2);
                int iIntValue2 = (obj21 != null ? (Integer) obj21 : null).intValue();
                Object obj22 = list10.get(3);
                int iIntValue3 = (obj22 != null ? (Integer) obj22 : null).intValue();
                Object obj23 = list10.get(4);
                String str4 = obj23 != null ? (String) obj23 : null;
                switch (annotationType.ordinal()) {
                    case 0:
                        Object obj24 = list10.get(1);
                        return new AnnotatedString.Range((Intrinsics.areEqual(obj24, Boolean.FALSE) || obj24 == null) ? null : (ParagraphStyle) ((Function1) SaversKt.ParagraphStyleSaver.hardwareBitmapService).invoke(obj24), iIntValue2, iIntValue3, str4);
                    case 1:
                        Object obj25 = list10.get(1);
                        return new AnnotatedString.Range((Intrinsics.areEqual(obj25, Boolean.FALSE) || obj25 == null) ? null : (SpanStyle) ((Function1) SaversKt.SpanStyleSaver.hardwareBitmapService).invoke(obj25), iIntValue2, iIntValue3, str4);
                    case 2:
                        Object obj26 = list10.get(1);
                        return new AnnotatedString.Range((Intrinsics.areEqual(obj26, Boolean.FALSE) || obj26 == null) ? null : (VerbatimTtsAnnotation) ((Function1) SaversKt.VerbatimTtsAnnotationSaver.hardwareBitmapService).invoke(obj26), iIntValue2, iIntValue3, str4);
                    case 3:
                        Object obj27 = list10.get(1);
                        return new AnnotatedString.Range((Intrinsics.areEqual(obj27, Boolean.FALSE) || obj27 == null) ? null : (UrlAnnotation) ((Function1) SaversKt.UrlAnnotationSaver.hardwareBitmapService).invoke(obj27), iIntValue2, iIntValue3, str4);
                    case 4:
                        Object obj28 = list10.get(1);
                        return new AnnotatedString.Range((Intrinsics.areEqual(obj28, Boolean.FALSE) || obj28 == null) ? null : (LinkAnnotation.Url) ((Function1) SaversKt.LinkSaver.hardwareBitmapService).invoke(obj28), iIntValue2, iIntValue3, str4);
                    case 5:
                        Object obj29 = list10.get(1);
                        return new AnnotatedString.Range((Intrinsics.areEqual(obj29, Boolean.FALSE) || obj29 == null) ? null : (LinkAnnotation.Clickable) ((Function1) SaversKt.ClickableSaver.hardwareBitmapService).invoke(obj29), iIntValue2, iIntValue3, str4);
                    case 6:
                        Object obj30 = list10.get(1);
                        return new AnnotatedString.Range(new StringAnnotation(obj30 != null ? (String) obj30 : null), iIntValue2, iIntValue3, str4);
                    default:
                        throw new HttpException();
                }
            case 21:
                return new LineHeightStyle.Mode(((Integer) obj).intValue());
            case 22:
                return new VerbatimTtsAnnotation(obj != null ? (String) obj : null);
            case 23:
                return new UrlAnnotation(obj != null ? (String) obj : null);
            case 24:
                List list11 = (List) obj;
                Object obj31 = list11.get(0);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$6 = SaversKt.TextAlignSaver;
                Boolean bool4 = Boolean.FALSE;
                Intrinsics.areEqual(obj31, bool4);
                int i4 = (obj31 != null ? (TextAlign) saversKt$NonNullValueClassSaver$6.$restore.invoke(obj31) : null).value;
                Object obj32 = list11.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$7 = SaversKt.TextDirectionSaver;
                Intrinsics.areEqual(obj32, bool4);
                int i5 = (obj32 != null ? (TextDirection) saversKt$NonNullValueClassSaver$7.$restore.invoke(obj32) : null).value;
                Object obj33 = list11.get(2);
                TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$8 = SaversKt.TextUnitSaver;
                Intrinsics.areEqual(obj33, bool4);
                long j3 = (obj33 != null ? (TextUnit) saversKt$NonNullValueClassSaver$8.$restore.invoke(obj33) : null).packedValue;
                Object obj34 = list11.get(3);
                TextIndent textIndent = TextIndent.None;
                TextIndent textIndent2 = (Intrinsics.areEqual(obj34, bool4) || obj34 == null) ? null : (TextIndent) ((Function1) SaversKt.TextIndentSaver.hardwareBitmapService).invoke(obj34);
                Object obj35 = list11.get(4);
                PlatformParagraphStyle platformParagraphStyle = (Intrinsics.areEqual(obj35, bool4) || obj35 == null) ? null : (PlatformParagraphStyle) ((Function1) ParagraphKt.PlatformParagraphStyleSaver.hardwareBitmapService).invoke(obj35);
                Object obj36 = list11.get(5);
                LineHeightStyle lineHeightStyle = LineHeightStyle.Default;
                LineHeightStyle lineHeightStyle2 = (Intrinsics.areEqual(obj36, bool4) || obj36 == null) ? null : (LineHeightStyle) ((Function1) SaversKt.LineHeightStyleSaver.hardwareBitmapService).invoke(obj36);
                Object obj37 = list11.get(6);
                int i6 = ((Intrinsics.areEqual(obj37, bool4) || obj37 == null) ? null : (LineBreak) ((Function1) ParagraphKt.LineBreakSaver.hardwareBitmapService).invoke(obj37)).mask;
                Object obj38 = list11.get(7);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$9 = SaversKt.HyphensSaver;
                Intrinsics.areEqual(obj38, bool4);
                int i7 = (obj38 != null ? (Hyphens) saversKt$NonNullValueClassSaver$9.$restore.invoke(obj38) : null).value;
                Object obj39 = list11.get(8);
                return new ParagraphStyle(i4, i5, j3, textIndent2, platformParagraphStyle, lineHeightStyle2, i6, i7, (Intrinsics.areEqual(obj39, bool4) || obj39 == null) ? null : (TextMotion) ((Function1) ParagraphKt.TextMotionSaver.hardwareBitmapService).invoke(obj39));
            case 25:
                List list12 = (List) obj;
                Object obj40 = list12.get(0);
                int i8 = Color.$r8$clinit;
                Boolean bool5 = Boolean.FALSE;
                Intrinsics.areEqual(obj40, bool5);
                if (obj40 != null) {
                    color2 = obj40.equals(bool5) ? new Color(Color.Unspecified) : new Color(BrushKt.Color(((Integer) obj40).intValue()));
                } else {
                    color2 = null;
                }
                long j4 = color2.value;
                Object obj41 = list12.get(1);
                TextUnitType[] textUnitTypeArr2 = TextUnit.TextUnitTypes;
                Function1 function1 = SaversKt.TextUnitSaver.$restore;
                Intrinsics.areEqual(obj41, bool5);
                long j5 = (obj41 != null ? (TextUnit) function1.invoke(obj41) : null).packedValue;
                Object obj42 = list12.get(2);
                FontWeight fontWeight = FontWeight.W600;
                FontWeight fontWeight2 = (Intrinsics.areEqual(obj42, bool5) || obj42 == null) ? null : (FontWeight) ((Function1) SaversKt.FontWeightSaver.hardwareBitmapService).invoke(obj42);
                Object obj43 = list12.get(3);
                FontStyle fontStyle = (Intrinsics.areEqual(obj43, bool5) || obj43 == null) ? null : (FontStyle) ((Function1) SaversKt.FontStyleSaver.hardwareBitmapService).invoke(obj43);
                Object obj44 = list12.get(4);
                FontSynthesis fontSynthesis = (Intrinsics.areEqual(obj44, bool5) || obj44 == null) ? null : (FontSynthesis) ((Function1) SaversKt.FontSynthesisSaver.hardwareBitmapService).invoke(obj44);
                Object obj45 = list12.get(6);
                String str5 = obj45 != null ? (String) obj45 : null;
                Object obj46 = list12.get(7);
                Intrinsics.areEqual(obj46, bool5);
                long j6 = (obj46 != null ? (TextUnit) function1.invoke(obj46) : null).packedValue;
                Object obj47 = list12.get(8);
                BaselineShift baselineShift = (Intrinsics.areEqual(obj47, bool5) || obj47 == null) ? null : (BaselineShift) ((Function1) SaversKt.BaselineShiftSaver.hardwareBitmapService).invoke(obj47);
                Object obj48 = list12.get(9);
                TextGeometricTransform textGeometricTransform = (Intrinsics.areEqual(obj48, bool5) || obj48 == null) ? null : (TextGeometricTransform) ((Function1) SaversKt.TextGeometricTransformSaver.hardwareBitmapService).invoke(obj48);
                Object obj49 = list12.get(10);
                LocaleList localeList = LocaleList.Empty;
                LocaleList localeList2 = (Intrinsics.areEqual(obj49, bool5) || obj49 == null) ? null : (LocaleList) ((Function1) SaversKt.LocaleListSaver.hardwareBitmapService).invoke(obj49);
                Object obj50 = list12.get(11);
                Intrinsics.areEqual(obj50, bool5);
                if (obj50 != null) {
                    color3 = obj50.equals(bool5) ? new Color(Color.Unspecified) : new Color(BrushKt.Color(((Integer) obj50).intValue()));
                } else {
                    color3 = null;
                }
                long j7 = color3.value;
                Object obj51 = list12.get(12);
                TextDecoration textDecoration = (Intrinsics.areEqual(obj51, bool5) || obj51 == null) ? null : (TextDecoration) ((Function1) SaversKt.TextDecorationSaver.hardwareBitmapService).invoke(obj51);
                Object obj52 = list12.get(13);
                Shadow shadow = Shadow.None;
                return new SpanStyle(j4, j5, fontWeight2, fontStyle, fontSynthesis, null, str5, j6, baselineShift, textGeometricTransform, localeList2, j7, textDecoration, (Intrinsics.areEqual(obj52, bool5) || obj52 == null) ? null : (Shadow) ((Function1) SaversKt.ShadowSaver.hardwareBitmapService).invoke(obj52), 49184);
            case 26:
                List list13 = (List) obj;
                Object obj53 = list13.get(0);
                boolean zBooleanValue = (obj53 != null ? (Boolean) obj53 : null).booleanValue();
                Object obj54 = list13.get(1);
                return new PlatformParagraphStyle(((Intrinsics.areEqual(obj54, Boolean.FALSE) || obj54 == null) ? null : (EmojiSupportMatch) ((Function1) ParagraphKt.emojiSupportMatchSaver.hardwareBitmapService).invoke(obj54)).value, zBooleanValue);
            case 27:
                return new EmojiSupportMatch(((Integer) obj).intValue());
            case 28:
                return new LineBreak(((Integer) obj).intValue());
            default:
                List list14 = (List) obj;
                Object obj55 = list14.get(0);
                int i9 = ((Intrinsics.areEqual(obj55, Boolean.FALSE) || obj55 == null) ? null : (TextMotion.Linearity) ((Function1) ParagraphKt.TextMotionLinearitySaver.hardwareBitmapService).invoke(obj55)).value;
                Object obj56 = list14.get(1);
                return new TextMotion(i9, (obj56 != null ? (Boolean) obj56 : null).booleanValue());
        }
    }
}
