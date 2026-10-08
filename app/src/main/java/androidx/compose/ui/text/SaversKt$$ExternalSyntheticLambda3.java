package androidx.compose.ui.text;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.ui.geometry.Offset;
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
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import coil.network.HttpException;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda3(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        AnnotationType annotationType;
        Object objSave;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                LinkAnnotation.Clickable clickable = (LinkAnnotation.Clickable) obj2;
                return AppCompatHintHelper.arrayListOf(clickable.tag, SaversKt.save(clickable.styles, SaversKt.TextLinkStylesSaver, (SaveableHolder) obj));
            case 1:
                return Float.valueOf(((BaselineShift) obj2).multiplier);
            case 2:
                SaveableHolder saveableHolder = (SaveableHolder) obj;
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                while (i < size) {
                    arrayList.add(SaversKt.save((AnnotatedString.Range) list.get(i), SaversKt.AnnotationRangeSaver, saveableHolder));
                    i++;
                }
                return arrayList;
            case 3:
                TextRange textRange = (TextRange) obj2;
                return AppCompatHintHelper.arrayListOf(Integer.valueOf((int) (textRange.packedValue >> 32)), Integer.valueOf((int) (4294967295L & textRange.packedValue)));
            case 4:
                SaveableHolder saveableHolder2 = (SaveableHolder) obj;
                Shadow shadow = (Shadow) obj2;
                return AppCompatHintHelper.arrayListOf(SaversKt.save(new Color(shadow.color), SaversKt.ColorSaver, saveableHolder2), SaversKt.save(new Offset(shadow.offset), SaversKt.OffsetSaver, saveableHolder2), Float.valueOf(shadow.blurRadius));
            case 5:
                return Integer.valueOf(((TextAlign) obj2).value);
            case 6:
                return Integer.valueOf(((TextDirection) obj2).value);
            case 7:
                return Integer.valueOf(((Hyphens) obj2).value);
            case 8:
                return Integer.valueOf(((FontStyle) obj2).value);
            case 9:
                return Integer.valueOf(((FontSynthesis) obj2).value);
            case 10:
                TextUnit textUnit = (TextUnit) obj2;
                return textUnit == null ? false : TextUnit.m725equalsimpl0(textUnit.packedValue, TextUnit.Unspecified) ? Boolean.FALSE : AppCompatHintHelper.arrayListOf(Float.valueOf(TextUnit.m727getValueimpl(textUnit.packedValue)), SaversKt.save(new TextUnitType(TextUnit.m726getTypeUIouoOA(textUnit.packedValue)), SaversKt.TextUnitTypeSaver, (SaveableHolder) obj));
            case 11:
                long j = ((TextUnitType) obj2).type;
                if (TextUnitType.m731equalsimpl0(j, 8589934592L)) {
                    return 0;
                }
                if (TextUnitType.m731equalsimpl0(j, 4294967296L)) {
                    return 1;
                }
                return Boolean.FALSE;
            case 12:
                Offset offset = (Offset) obj2;
                return offset == null ? false : Offset.m369equalsimpl0(offset.packedValue, 9205357640488583168L) ? Boolean.FALSE : AppCompatHintHelper.arrayListOf(Float.valueOf(Float.intBitsToFloat((int) (offset.packedValue >> 32))), Float.valueOf(Float.intBitsToFloat((int) (4294967295L & offset.packedValue))));
            case 13:
                SaveableHolder saveableHolder3 = (SaveableHolder) obj;
                AnnotatedString.Range range = (AnnotatedString.Range) obj2;
                Object obj3 = range.item;
                if (obj3 instanceof ParagraphStyle) {
                    annotationType = AnnotationType.Paragraph;
                } else if (obj3 instanceof SpanStyle) {
                    annotationType = AnnotationType.Span;
                } else if (obj3 instanceof VerbatimTtsAnnotation) {
                    annotationType = AnnotationType.VerbatimTts;
                } else if (obj3 instanceof UrlAnnotation) {
                    annotationType = AnnotationType.Url;
                } else if (obj3 instanceof LinkAnnotation.Url) {
                    annotationType = AnnotationType.Link;
                } else if (obj3 instanceof LinkAnnotation.Clickable) {
                    annotationType = AnnotationType.Clickable;
                } else {
                    if (!(obj3 instanceof StringAnnotation)) {
                        throw new UnsupportedOperationException();
                    }
                    annotationType = AnnotationType.String;
                }
                switch (annotationType.ordinal()) {
                    case 0:
                        objSave = SaversKt.save((ParagraphStyle) obj3, SaversKt.ParagraphStyleSaver, saveableHolder3);
                        break;
                    case 1:
                        objSave = SaversKt.save((SpanStyle) obj3, SaversKt.SpanStyleSaver, saveableHolder3);
                        break;
                    case 2:
                        objSave = SaversKt.save((VerbatimTtsAnnotation) obj3, SaversKt.VerbatimTtsAnnotationSaver, saveableHolder3);
                        break;
                    case 3:
                        objSave = SaversKt.save((UrlAnnotation) obj3, SaversKt.UrlAnnotationSaver, saveableHolder3);
                        break;
                    case 4:
                        objSave = SaversKt.save((LinkAnnotation.Url) obj3, SaversKt.LinkSaver, saveableHolder3);
                        break;
                    case 5:
                        objSave = SaversKt.save((LinkAnnotation.Clickable) obj3, SaversKt.ClickableSaver, saveableHolder3);
                        break;
                    case 6:
                        objSave = ((StringAnnotation) obj3).value;
                        break;
                    default:
                        throw new HttpException();
                }
                return AppCompatHintHelper.arrayListOf(annotationType, objSave, Integer.valueOf(range.start), Integer.valueOf(range.end), range.tag);
            case 14:
                SaveableHolder saveableHolder4 = (SaveableHolder) obj;
                List list2 = ((LocaleList) obj2).localeList;
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size2 = list2.size();
                while (i < size2) {
                    arrayList2.add(SaversKt.save((Locale) list2.get(i), SaversKt.LocaleSaver, saveableHolder4));
                    i++;
                }
                return arrayList2;
            case 15:
                return ((Locale) obj2).platformLocale.toLanguageTag();
            case 16:
                SaveableHolder saveableHolder5 = (SaveableHolder) obj;
                LineHeightStyle lineHeightStyle = (LineHeightStyle) obj2;
                return AppCompatHintHelper.arrayListOf(SaversKt.save(new LineHeightStyle.Alignment(lineHeightStyle.alignment), SaversKt.LineHeightStyleAlignmentSaver, saveableHolder5), SaversKt.save(new LineHeightStyle.Trim(lineHeightStyle.trim), SaversKt.LineHeightStyleTrimSaver, saveableHolder5), SaversKt.save(new LineHeightStyle.Mode(lineHeightStyle.mode), SaversKt.LineHeightStyleModeSaver, saveableHolder5));
            case 17:
                return Float.valueOf(((LineHeightStyle.Alignment) obj2).topRatio);
            case 18:
                return Integer.valueOf(((LineHeightStyle.Trim) obj2).value);
            case 19:
                return Integer.valueOf(((LineHeightStyle.Mode) obj2).value);
            case 20:
                return ((VerbatimTtsAnnotation) obj2).verbatim;
            case 21:
                SaveableHolder saveableHolder6 = (SaveableHolder) obj;
                ParagraphStyle paragraphStyle = (ParagraphStyle) obj2;
                Object objSave2 = SaversKt.save(new TextAlign(paragraphStyle.textAlign), SaversKt.TextAlignSaver, saveableHolder6);
                Object objSave3 = SaversKt.save(new TextDirection(paragraphStyle.textDirection), SaversKt.TextDirectionSaver, saveableHolder6);
                Object objSave4 = SaversKt.save(new TextUnit(paragraphStyle.lineHeight), SaversKt.TextUnitSaver, saveableHolder6);
                TextIndent textIndent = paragraphStyle.textIndent;
                TextIndent textIndent2 = TextIndent.None;
                Object objSave5 = SaversKt.save(textIndent, SaversKt.TextIndentSaver, saveableHolder6);
                Object objSave6 = SaversKt.save(paragraphStyle.platformStyle, ParagraphKt.PlatformParagraphStyleSaver, saveableHolder6);
                LineHeightStyle lineHeightStyle2 = paragraphStyle.lineHeightStyle;
                LineHeightStyle lineHeightStyle3 = LineHeightStyle.Default;
                return AppCompatHintHelper.arrayListOf(objSave2, objSave3, objSave4, objSave5, objSave6, SaversKt.save(lineHeightStyle2, SaversKt.LineHeightStyleSaver, saveableHolder6), SaversKt.save(new LineBreak(paragraphStyle.lineBreak), ParagraphKt.LineBreakSaver, saveableHolder6), SaversKt.save(new Hyphens(paragraphStyle.hyphens), SaversKt.HyphensSaver, saveableHolder6), SaversKt.save(paragraphStyle.textMotion, ParagraphKt.TextMotionSaver, saveableHolder6));
            case 22:
                return ((UrlAnnotation) obj2).url;
            case 23:
                SaveableHolder saveableHolder7 = (SaveableHolder) obj;
                SpanStyle spanStyle = (SpanStyle) obj2;
                Color color = new Color(spanStyle.textForegroundStyle.mo668getColor0d7_KjU());
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$1 = SaversKt.ColorSaver;
                Object objSave7 = SaversKt.save(color, saversKt$NonNullValueClassSaver$1, saveableHolder7);
                TextUnit textUnit2 = new TextUnit(spanStyle.fontSize);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$2 = SaversKt.TextUnitSaver;
                Object objSave8 = SaversKt.save(textUnit2, saversKt$NonNullValueClassSaver$2, saveableHolder7);
                FontWeight fontWeight = spanStyle.fontWeight;
                FontWeight fontWeight2 = FontWeight.W600;
                Object objSave9 = SaversKt.save(fontWeight, SaversKt.FontWeightSaver, saveableHolder7);
                Object objSave10 = SaversKt.save(spanStyle.fontStyle, SaversKt.FontStyleSaver, saveableHolder7);
                Object objSave11 = SaversKt.save(spanStyle.fontSynthesis, SaversKt.FontSynthesisSaver, saveableHolder7);
                String str = spanStyle.fontFeatureSettings;
                Object objSave12 = SaversKt.save(new TextUnit(spanStyle.letterSpacing), saversKt$NonNullValueClassSaver$2, saveableHolder7);
                Object objSave13 = SaversKt.save(spanStyle.baselineShift, SaversKt.BaselineShiftSaver, saveableHolder7);
                Object objSave14 = SaversKt.save(spanStyle.textGeometricTransform, SaversKt.TextGeometricTransformSaver, saveableHolder7);
                LocaleList localeList = spanStyle.localeList;
                LocaleList localeList2 = LocaleList.Empty;
                Object objSave15 = SaversKt.save(localeList, SaversKt.LocaleListSaver, saveableHolder7);
                Object objSave16 = SaversKt.save(new Color(spanStyle.background), saversKt$NonNullValueClassSaver$1, saveableHolder7);
                Object objSave17 = SaversKt.save(spanStyle.textDecoration, SaversKt.TextDecorationSaver, saveableHolder7);
                Shadow shadow2 = spanStyle.shadow;
                Shadow shadow3 = Shadow.None;
                return AppCompatHintHelper.arrayListOf(objSave7, objSave8, objSave9, objSave10, objSave11, -1, str, objSave12, objSave13, objSave14, objSave15, objSave16, objSave17, SaversKt.save(shadow2, SaversKt.ShadowSaver, saveableHolder7));
            case 24:
                SaveableHolder saveableHolder8 = (SaveableHolder) obj;
                TextLinkStyles textLinkStyles = (TextLinkStyles) obj2;
                SpanStyle spanStyle2 = textLinkStyles.style;
                RequestService requestService = SaversKt.SpanStyleSaver;
                return AppCompatHintHelper.arrayListOf(SaversKt.save(spanStyle2, requestService, saveableHolder8), SaversKt.save(textLinkStyles.focusedStyle, requestService, saveableHolder8), SaversKt.save(textLinkStyles.hoveredStyle, requestService, saveableHolder8), SaversKt.save(textLinkStyles.pressedStyle, requestService, saveableHolder8));
            case 25:
                PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) obj2;
                Boolean boolValueOf = Boolean.valueOf(platformParagraphStyle.includeFontPadding);
                RequestService requestService2 = SaversKt.AnnotationRangeListSaver;
                return AppCompatHintHelper.arrayListOf(boolValueOf, SaversKt.save(new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), ParagraphKt.emojiSupportMatchSaver, (SaveableHolder) obj));
            case 26:
                return Integer.valueOf(((EmojiSupportMatch) obj2).value);
            case 27:
                return Integer.valueOf(((LineBreak) obj2).mask);
            case 28:
                TextMotion textMotion = (TextMotion) obj2;
                return AppCompatHintHelper.arrayListOf(SaversKt.save(new TextMotion.Linearity(textMotion.linearity), ParagraphKt.TextMotionLinearitySaver, (SaveableHolder) obj), Boolean.valueOf(textMotion.subpixelTextPositioning));
            default:
                return Integer.valueOf(((TextMotion.Linearity) obj2).value);
        }
    }
}
