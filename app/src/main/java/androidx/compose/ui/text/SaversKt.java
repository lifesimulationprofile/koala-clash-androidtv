package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import coil.request.RequestService;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SaversKt {
    public static final RequestService AnnotationRangeListSaver;
    public static final RequestService AnnotationRangeSaver;
    public static final RequestService BaselineShiftSaver;
    public static final RequestService ClickableSaver;
    public static final SaversKt$NonNullValueClassSaver$1 ColorSaver;
    public static final RequestService FontStyleSaver;
    public static final RequestService FontSynthesisSaver;
    public static final RequestService FontWeightSaver;
    public static final SaversKt$NonNullValueClassSaver$1 HyphensSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleAlignmentSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleModeSaver;
    public static final RequestService LineHeightStyleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleTrimSaver;
    public static final RequestService LinkSaver;
    public static final RequestService LocaleListSaver;
    public static final RequestService LocaleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 OffsetSaver;
    public static final RequestService ParagraphStyleSaver;
    public static final RequestService ShadowSaver;
    public static final RequestService SpanStyleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextAlignSaver;
    public static final RequestService TextDecorationSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextDirectionSaver;
    public static final RequestService TextGeometricTransformSaver;
    public static final RequestService TextIndentSaver;
    public static final RequestService TextLinkStylesSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextUnitSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextUnitTypeSaver;
    public static final RequestService UrlAnnotationSaver;
    public static final RequestService VerbatimTtsAnnotationSaver;

    static {
        int i = 2;
        new RequestService(i, new SaversKt$$ExternalSyntheticLambda0(0), new SaversKt$$ExternalSyntheticLambda10(26));
        AnnotationRangeListSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(2), new SaversKt$$ExternalSyntheticLambda2(8));
        AnnotationRangeSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(13), new SaversKt$$ExternalSyntheticLambda2(20));
        VerbatimTtsAnnotationSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(20), new SaversKt$$ExternalSyntheticLambda2(22));
        UrlAnnotationSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(22), new SaversKt$$ExternalSyntheticLambda2(23));
        LinkSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda0(29), new SaversKt$$ExternalSyntheticLambda2(0));
        ClickableSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(0), new SaversKt$$ExternalSyntheticLambda2(16));
        ParagraphStyleSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(21), new SaversKt$$ExternalSyntheticLambda2(24));
        SpanStyleSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(23), new SaversKt$$ExternalSyntheticLambda2(25));
        TextLinkStylesSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(24), new SaversKt$$ExternalSyntheticLambda10(0));
        TextDecorationSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda0(25), new SaversKt$$ExternalSyntheticLambda10(27));
        TextGeometricTransformSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda0(26), new SaversKt$$ExternalSyntheticLambda10(28));
        TextIndentSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda0(27), new SaversKt$$ExternalSyntheticLambda10(29));
        FontWeightSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda0(28), new SaversKt$$ExternalSyntheticLambda2(1));
        BaselineShiftSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(1), new SaversKt$$ExternalSyntheticLambda2(2));
        new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(3), new SaversKt$$ExternalSyntheticLambda2(3));
        ShadowSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(4), new SaversKt$$ExternalSyntheticLambda2(4));
        ColorSaver = new SaversKt$NonNullValueClassSaver$1(SaversKt$ColorSaver$1.INSTANCE, SaversKt$ColorSaver$2.INSTANCE);
        TextAlignSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(5), new SaversKt$$ExternalSyntheticLambda2(5));
        TextDirectionSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(6), new SaversKt$$ExternalSyntheticLambda2(6));
        HyphensSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(7), new SaversKt$$ExternalSyntheticLambda2(7));
        FontStyleSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(8), new SaversKt$$ExternalSyntheticLambda2(9));
        FontSynthesisSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(9), new SaversKt$$ExternalSyntheticLambda2(10));
        TextUnitSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(10), new SaversKt$$ExternalSyntheticLambda2(11));
        TextUnitTypeSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(11), new SaversKt$$ExternalSyntheticLambda2(12));
        OffsetSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(12), new SaversKt$$ExternalSyntheticLambda2(13));
        LocaleListSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(14), new SaversKt$$ExternalSyntheticLambda2(14));
        LocaleSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(15), new SaversKt$$ExternalSyntheticLambda2(15));
        LineHeightStyleSaver = new RequestService(i, new SaversKt$$ExternalSyntheticLambda3(16), new SaversKt$$ExternalSyntheticLambda2(17));
        LineHeightStyleAlignmentSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(17), new SaversKt$$ExternalSyntheticLambda2(18));
        LineHeightStyleTrimSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(18), new SaversKt$$ExternalSyntheticLambda2(19));
        LineHeightStyleModeSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(19), new SaversKt$$ExternalSyntheticLambda2(21));
    }

    public static final Object save(Object obj, Saver saver, SaveableHolder saveableHolder) {
        Object objSave;
        return (obj == null || (objSave = saver.save(saveableHolder, obj)) == null) ? Boolean.FALSE : objSave;
    }
}
