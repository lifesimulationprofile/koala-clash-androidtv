package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.foundation.lazy.LazyListIntervalContent$$ExternalSyntheticLambda2;
import androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda14;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleDelegate;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.core.view.MenuHostHelper;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.TypefaceEmojiSpan;
import coil.request.Parameters;
import com.google.android.gms.internal.mlkit_vision_barcode.zztz;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {
    public final List annotations;
    public final CharSequence charSequence;
    public final Density density;
    public final boolean emojiCompatProcessed;
    public final FontFamily$Resolver fontFamilyResolver;
    public final LayoutIntrinsics layoutIntrinsics;
    public final List placeholders;
    public MenuHostHelper resolvedTypefaces;
    public final TextStyle style;
    public final String text;
    public final int textDirectionHeuristic;
    public final AndroidTextPaint textPaint;

    /* JADX WARN: Code duplicated, block: B:15:0x0071  */
    /* JADX WARN: Code duplicated, block: B:18:0x0076  */
    /* JADX WARN: Code duplicated, block: B:236:0x0474  */
    /* JADX WARN: Code duplicated, block: B:248:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:249:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:251:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:252:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:255:0x04df  */
    /* JADX WARN: Code duplicated, block: B:256:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:258:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:259:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:261:0x0515  */
    /* JADX WARN: Code duplicated, block: B:264:0x0528  */
    /* JADX WARN: Code duplicated, block: B:266:0x0534  */
    /* JADX WARN: Code duplicated, block: B:268:0x053b  */
    /* JADX WARN: Code duplicated, block: B:274:0x0546  */
    /* JADX WARN: Code duplicated, block: B:276:0x054a  */
    /* JADX WARN: Code duplicated, block: B:278:0x0550  */
    /* JADX WARN: Code duplicated, block: B:282:0x055c  */
    /* JADX WARN: Code duplicated, block: B:288:0x0567  */
    /* JADX WARN: Code duplicated, block: B:290:0x056b  */
    /* JADX WARN: Code duplicated, block: B:294:0x0573  */
    /* JADX WARN: Code duplicated, block: B:297:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:299:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:302:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:305:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:307:0x05f3 A[LOOP:8: B:306:0x05f1->B:307:0x05f3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:310:0x0609  */
    /* JADX WARN: Code duplicated, block: B:312:0x060e  */
    /* JADX WARN: Code duplicated, block: B:314:0x0615  */
    /* JADX WARN: Code duplicated, block: B:316:0x0619  */
    /* JADX WARN: Code duplicated, block: B:317:0x0620  */
    /* JADX WARN: Code duplicated, block: B:319:0x0628  */
    /* JADX WARN: Code duplicated, block: B:321:0x063c  */
    /* JADX WARN: Code duplicated, block: B:330:0x0660  */
    /* JADX WARN: Code duplicated, block: B:335:0x067d  */
    /* JADX WARN: Code duplicated, block: B:337:0x0689  */
    /* JADX WARN: Code duplicated, block: B:339:0x068f  */
    /* JADX WARN: Code duplicated, block: B:344:0x069d  */
    /* JADX WARN: Code duplicated, block: B:395:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:397:0x07de  */
    /* JADX WARN: Code duplicated, block: B:399:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:401:0x07f2  */
    /* JADX WARN: Code duplicated, block: B:406:0x0800  */
    /* JADX WARN: Code duplicated, block: B:420:0x0860  */
    /* JADX WARN: Code duplicated, block: B:422:0x0871  */
    /* JADX WARN: Code duplicated, block: B:423:0x0875  */
    /* JADX WARN: Code duplicated, block: B:425:0x0880  */
    /* JADX WARN: Code duplicated, block: B:428:0x088a A[LOOP:6: B:427:0x0888->B:428:0x088a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:431:0x089b  */
    /* JADX WARN: Code duplicated, block: B:433:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:435:0x08b5 A[LOOP:7: B:434:0x08b3->B:435:0x08b5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:438:0x08c2  */
    /* JADX WARN: Code duplicated, block: B:442:0x08d6  */
    /* JADX WARN: Code duplicated, block: B:454:0x0553 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:470:0x064f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:433:0x08a8, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    public AndroidParagraphIntrinsics(String str, TextStyle textStyle, List list, List list2, FontFamily$Resolver fontFamily$Resolver, Density density) {
        boolean zBooleanValue;
        Locale locale;
        int i;
        Object obj;
        FontWeight fontWeight;
        int i2;
        Typeface typeface;
        ?? arrayList;
        CharSequence charSequenceProcess;
        int i3;
        TextIndent textIndent;
        ParagraphStyle paragraphStyle;
        ArrayList arrayList2;
        int size;
        int i4;
        SpanStyle spanStyle;
        SystemFontFamily systemFontFamily;
        boolean z;
        SpanStyle spanStyle2;
        AlertDialogKt$$ExternalSyntheticLambda14 alertDialogKt$$ExternalSyntheticLambda14;
        int size2;
        int i5;
        int[] iArr;
        int size3;
        int i6;
        int i7;
        int i8;
        int i9;
        int size4;
        SpanStyle spanStyleMerge;
        int i10;
        ArrayList arrayList3;
        SpanStyle spanStyle3;
        ParagraphStyle paragraphStyle2;
        int i11;
        int i12;
        ParagraphStyle paragraphStyle3;
        int size5;
        int i13;
        boolean z2;
        Density density2;
        Density density3;
        TextIndent textIndent2;
        int size6;
        int i14;
        int i15;
        AnnotatedString.Range range;
        long j;
        long jM726getTypeUIouoOA;
        int size7;
        int i16;
        AnnotatedString.Range range2;
        AnnotatedString.Annotation annotation;
        int i17;
        int i18;
        Density density4;
        int i19;
        Object letterSpacingSpanEm;
        AnnotatedString.Range range3;
        Object obj2;
        int i20;
        int i21;
        ParagraphStyle paragraphStyle4;
        int i22;
        int i23;
        int i24;
        AnnotatedString.Range range4;
        Object obj3;
        SpanStyle spanStyle4;
        boolean z3;
        int i25;
        long j2;
        long j3;
        long jM726getTypeUIouoOA2;
        float fM727getValueimpl;
        long jM726getTypeUIouoOA3;
        float fM727getValueimpl2;
        PlatformParagraphStyle platformParagraphStyle;
        CharSequence charSequence;
        PlatformParagraphStyle platformParagraphStyle2;
        this.text = str;
        this.style = textStyle;
        this.annotations = list;
        this.placeholders = list2;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.density = density;
        float density5 = density.getDensity();
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1);
        ((TextPaint) androidTextPaint).density = density5;
        androidTextPaint.textDecoration = TextDecoration.None;
        androidTextPaint.backingBlendMode = 3;
        androidTextPaint.shadow = Shadow.None;
        this.textPaint = androidTextPaint;
        boolean zAccess$getHasEmojiCompat = AndroidTextPaint_androidKt.access$getHasEmojiCompat(textStyle);
        SpanStyle spanStyle5 = textStyle.spanStyle;
        ParagraphStyle paragraphStyle5 = textStyle.paragraphStyle;
        if (zAccess$getHasEmojiCompat) {
            Parameters.Builder builder = EmojiCompatStatus.delegate;
            Parameters.Builder builder2 = EmojiCompatStatus.delegate;
            State fontLoadState = (State) builder2.entries;
            if (fontLoadState == null) {
                if (EmojiCompat.isConfigured()) {
                    fontLoadState = builder2.getFontLoadState();
                    builder2.entries = fontLoadState;
                } else {
                    fontLoadState = AndroidTextPaint_androidKt.Falsey;
                }
            }
            zBooleanValue = ((Boolean) fontLoadState.getValue()).booleanValue();
        } else {
            zBooleanValue = false;
        }
        this.emojiCompatProcessed = zBooleanValue;
        int i26 = paragraphStyle5.textDirection;
        LocaleList localeList = spanStyle5.localeList;
        int i27 = 2;
        if (i26 == 4) {
            i = 2;
        } else if (i26 == 5) {
            i = 3;
        } else if (i26 == 1) {
            i = 0;
        } else if (i26 == 2) {
            i = 1;
        } else {
            if (i26 != 3 && i26 != 0) {
                throw new IllegalStateException("Invalid TextDirection.");
            }
            int layoutDirectionFromLocale = TextUtils.getLayoutDirectionFromLocale((localeList == null || (locale = localeList.get().platformLocale) == null) ? Locale.getDefault() : locale);
            if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                i = 2;
            } else {
                i = 3;
            }
        }
        this.textDirectionHeuristic = i;
        LazyListIntervalContent$$ExternalSyntheticLambda2 lazyListIntervalContent$$ExternalSyntheticLambda2 = new LazyListIntervalContent$$ExternalSyntheticLambda2(i27, this);
        TextMotion textMotion = paragraphStyle5.textMotion;
        textMotion = textMotion == null ? TextMotion.Static : textMotion;
        androidTextPaint.setFlags(textMotion.subpixelTextPositioning ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int i28 = textMotion.linearity;
        if (i28 == 1) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (i28 == 2) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (i28 == 3) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
        int size8 = list.size();
        int i29 = 0;
        while (true) {
            if (i29 >= size8) {
                obj = null;
                break;
            }
            obj = list.get(i29);
            if (((AnnotatedString.Range) obj).item instanceof SpanStyle) {
                break;
            } else {
                i29++;
            }
        }
        boolean z4 = obj != null;
        long j4 = spanStyle5.fontSize;
        FontWeight fontWeight2 = spanStyle5.fontWeight;
        FontStyle fontStyle = spanStyle5.fontStyle;
        String str2 = spanStyle5.fontFeatureSettings;
        TextForegroundStyle textForegroundStyle = spanStyle5.textForegroundStyle;
        TextGeometricTransform textGeometricTransform = spanStyle5.textGeometricTransform;
        LocaleList localeList2 = spanStyle5.localeList;
        long j5 = spanStyle5.letterSpacing;
        long jM726getTypeUIouoOA4 = TextUnit.m726getTypeUIouoOA(j4);
        boolean z5 = z4;
        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA4, 4294967296L)) {
            androidTextPaint.setTextSize(density.mo91toPxR2X_6o(j4));
        } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA4, 8589934592L)) {
            androidTextPaint.setTextSize(TextUnit.m727getValueimpl(j4) * androidTextPaint.getTextSize());
        }
        SystemFontFamily systemFontFamily2 = spanStyle5.fontFamily;
        if (systemFontFamily2 != null || fontStyle != null || fontWeight2 != null) {
            if (fontWeight2 == null) {
                fontWeight = FontWeight.Normal;
            }
            if (fontStyle != null) {
                fontWeight = fontWeight2;
                i2 = fontStyle.value;
            } else {
                fontWeight = fontWeight2;
                i2 = 0;
            }
            FontSynthesis fontSynthesis = spanStyle5.fontSynthesis;
            int i30 = fontSynthesis != null ? fontSynthesis.value : 65535;
            AndroidParagraphIntrinsics androidParagraphIntrinsics = (AndroidParagraphIntrinsics) lazyListIntervalContent$$ExternalSyntheticLambda2.f$0;
            TypefaceResult$Immutable typefaceResult$ImmutableM656resolveDPcqOEQ = ((FontFamilyResolverImpl) androidParagraphIntrinsics.fontFamilyResolver).m656resolveDPcqOEQ(systemFontFamily2, fontWeight, i2, i30);
            if (typefaceResult$ImmutableM656resolveDPcqOEQ instanceof TypefaceResult$Immutable) {
                typeface = (Typeface) typefaceResult$ImmutableM656resolveDPcqOEQ.value;
            } else {
                MenuHostHelper menuHostHelper = new MenuHostHelper(typefaceResult$ImmutableM656resolveDPcqOEQ, androidParagraphIntrinsics.resolvedTypefaces);
                androidParagraphIntrinsics.resolvedTypefaces = menuHostHelper;
                typeface = (Typeface) menuHostHelper.mProviderToLifecycleContainers;
            }
            androidTextPaint.setTypeface(typeface);
        }
        if (localeList2 != null) {
            List list3 = localeList2.localeList;
            LocaleList localeList3 = LocaleList.Empty;
            PlatformLocaleDelegate platformLocaleDelegate = PlatformLocaleKt.platformLocaleDelegate;
            if (!localeList2.equals(platformLocaleDelegate.getCurrent())) {
                if (Build.VERSION.SDK_INT >= 24) {
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList2, 10));
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(((androidx.compose.ui.text.intl.Locale) it.next()).platformLocale);
                    }
                    Locale[] localeArr = (Locale[]) arrayList4.toArray(new Locale[0]);
                    androidTextPaint.setTextLocales(LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
                } else {
                    androidTextPaint.setTextLocale((list3.isEmpty() ? platformLocaleDelegate.getCurrent().get() : localeList2.get()).platformLocale);
                }
            }
        }
        if (str2 != null && !str2.equals("")) {
            androidTextPaint.setFontFeatureSettings(str2);
        }
        if (textGeometricTransform != null && !textGeometricTransform.equals(TextGeometricTransform.None)) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * textGeometricTransform.scaleX);
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + textGeometricTransform.skewX);
        }
        androidTextPaint.m666setColor8_81llA(textForegroundStyle.mo668getColor0d7_KjU());
        androidTextPaint.m665setBrush12SF9DM(textForegroundStyle.getBrush(), 9205357640488583168L, textForegroundStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle5.shadow);
        androidTextPaint.setTextDecoration(spanStyle5.textDecoration);
        androidTextPaint.setDrawStyle(spanStyle5.drawStyle);
        if (TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j5), 4294967296L) && TextUnit.m727getValueimpl(j5) != 0.0f) {
            float textScaleX = androidTextPaint.getTextScaleX() * androidTextPaint.getTextSize();
            float fMo91toPxR2X_6o = density.mo91toPxR2X_6o(j5);
            if (textScaleX != 0.0f) {
                androidTextPaint.setLetterSpacing(fMo91toPxR2X_6o / textScaleX);
            }
        } else if (TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j5), 8589934592L)) {
            androidTextPaint.setLetterSpacing(TextUnit.m727getValueimpl(j5));
        }
        long j6 = spanStyle5.background;
        BaselineShift baselineShift = spanStyle5.baselineShift;
        boolean z6 = z5 && TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j5), 4294967296L) && TextUnit.m727getValueimpl(j5) != 0.0f;
        long j7 = Color.Unspecified;
        boolean z7 = (Color.m435equalsimpl0(j6, j7) || Color.m435equalsimpl0(j6, Color.Transparent)) ? false : true;
        boolean z8 = (baselineShift == null || Float.compare(baselineShift.multiplier, 0.0f) == 0) ? false : true;
        SpanStyle spanStyle6 = (z6 || z7 || z8) ? new SpanStyle(0L, 0L, null, null, null, null, null, z6 ? j5 : TextUnit.Unspecified, z8 ? baselineShift : null, null, null, z7 ? j6 : j7, null, null, 63103) : null;
        if (spanStyle6 != null) {
            int size9 = this.annotations.size() + 1;
            arrayList = new ArrayList(size9);
            int i31 = 0;
            while (i31 < size9) {
                arrayList.add(i31 == 0 ? new AnnotatedString.Range(0, this.text.length(), spanStyle6) : (AnnotatedString.Range) this.annotations.get(i31 - 1));
                i31++;
            }
        } else {
            arrayList = this.annotations;
        }
        String str3 = this.text;
        float textSize = this.textPaint.getTextSize();
        TextStyle textStyle2 = this.style;
        List list4 = this.placeholders;
        Density density6 = this.density;
        boolean z9 = this.emojiCompatProcessed;
        AndroidParagraphHelper_androidKt$NoopSpan$1 androidParagraphHelper_androidKt$NoopSpan$1 = AndroidParagraphHelper_androidKt.NoopSpan;
        if (z9 && EmojiCompat.isConfigured()) {
            PlatformTextStyle platformTextStyle = textStyle2.platformStyle;
            EmojiSupportMatch emojiSupportMatch = (platformTextStyle == null || (platformParagraphStyle2 = platformTextStyle.paragraphStyle) == null) ? null : new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch);
            charSequenceProcess = EmojiCompat.get().process(0, str3.length(), (emojiSupportMatch != null && emojiSupportMatch.value == 2) ? 1 : 0, str3);
        } else {
            charSequenceProcess = str3;
        }
        if (!arrayList.isEmpty() || !list4.isEmpty() || !Intrinsics.areEqual(textStyle2.paragraphStyle.textIndent, TextIndent.None) || (textStyle2.paragraphStyle.lineHeight & 1095216660480L) != 0) {
            charSequence = charSequenceProcess;
            Spannable spannableString = charSequenceProcess instanceof Spannable ? (Spannable) charSequenceProcess : new SpannableString(charSequenceProcess);
            SpanStyle spanStyle7 = textStyle2.spanStyle;
            ParagraphStyle paragraphStyle6 = textStyle2.paragraphStyle;
            if (Intrinsics.areEqual(spanStyle7.textDecoration, TextDecoration.Underline)) {
                spannableString.setSpan(AndroidParagraphHelper_androidKt.NoopSpan, 0, str3.length(), 33);
            }
            PlatformTextStyle platformTextStyle2 = textStyle2.platformStyle;
            if (((platformTextStyle2 == null || (platformParagraphStyle = platformTextStyle2.paragraphStyle) == null) ? false : platformParagraphStyle.includeFontPadding) && paragraphStyle6.lineHeightStyle == null) {
                float fM816resolveLineHeightInPxo2QH7mI = zztz.m816resolveLineHeightInPxo2QH7mI(paragraphStyle6.lineHeight, textSize, density6);
                if (!Float.isNaN(fM816resolveLineHeightInPxo2QH7mI)) {
                    spannableString.setSpan(new LineHeightSpan(fM816resolveLineHeightInPxo2QH7mI), 0, spannableString.length(), 33);
                }
            } else {
                LineHeightStyle lineHeightStyle = paragraphStyle6.lineHeightStyle;
                lineHeightStyle = lineHeightStyle == null ? LineHeightStyle.Default : lineHeightStyle;
                float fM816resolveLineHeightInPxo2QH7mI2 = zztz.m816resolveLineHeightInPxo2QH7mI(paragraphStyle6.lineHeight, textSize, density6);
                if (!Float.isNaN(fM816resolveLineHeightInPxo2QH7mI2)) {
                    int length = (spannableString.length() == 0 || StringsKt.last(spannableString) == '\n') ? spannableString.length() + 1 : spannableString.length();
                    int i32 = lineHeightStyle.trim;
                    i3 = 0;
                    spannableString.setSpan(new LineHeightStyleSpan(fM816resolveLineHeightInPxo2QH7mI2, length, (i32 & 1) > 0, (i32 & 16) > 0, lineHeightStyle.alignment, lineHeightStyle.mode), 0, spannableString.length(), 33);
                }
                textIndent = paragraphStyle6.textIndent;
                if (textIndent != null) {
                    i25 = i3;
                    j2 = textIndent.firstLine;
                    j3 = textIndent.restLine;
                    paragraphStyle = paragraphStyle6;
                    if ((TextUnit.m725equalsimpl0(j2, TextUnitKt.getSp(i25)) || !TextUnit.m725equalsimpl0(j3, TextUnitKt.getSp(i25))) && (j2 & 1095216660480L) != r13 && (j3 & 1095216660480L) != 0) {
                        jM726getTypeUIouoOA2 = TextUnit.m726getTypeUIouoOA(j2);
                        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA2, 4294967296L)) {
                            fM727getValueimpl = density6.mo91toPxR2X_6o(j2);
                        } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA2, 8589934592L)) {
                            fM727getValueimpl = TextUnit.m727getValueimpl(j2) * textSize;
                        } else {
                            fM727getValueimpl = 0.0f;
                        }
                        jM726getTypeUIouoOA3 = TextUnit.m726getTypeUIouoOA(j3);
                        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA3, 4294967296L)) {
                            fM727getValueimpl2 = density6.mo91toPxR2X_6o(j3);
                        } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA3, 8589934592L)) {
                            fM727getValueimpl2 = TextUnit.m727getValueimpl(j3) * textSize;
                        } else {
                            fM727getValueimpl2 = 0.0f;
                        }
                        spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fM727getValueimpl), (int) Math.ceil(fM727getValueimpl2)), 0, spannableString.length(), 33);
                    }
                    arrayList2 = new ArrayList(arrayList.size());
                    size = arrayList.size();
                    for (i4 = 0; i4 < size; i4++) {
                        range4 = (AnnotatedString.Range) arrayList.get(i4);
                        obj3 = range4.item;
                        if (obj3 instanceof SpanStyle) {
                            spanStyle4 = (SpanStyle) obj3;
                            if (spanStyle4.fontFamily != null && spanStyle4.fontStyle == null && spanStyle4.fontWeight == null) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (z3 || ((SpanStyle) obj3).fontSynthesis != null) {
                                arrayList2.add(range4);
                            }
                        }
                    }
                    spanStyle = textStyle2.spanStyle;
                    systemFontFamily = spanStyle.fontFamily;
                    if (systemFontFamily != null && spanStyle.fontStyle == null && spanStyle.fontWeight == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z && spanStyle.fontSynthesis == null) {
                        spanStyle2 = null;
                    } else {
                        spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, systemFontFamily, null, 0L, null, null, null, 0L, null, null, 65475);
                    }
                    alertDialogKt$$ExternalSyntheticLambda14 = new AlertDialogKt$$ExternalSyntheticLambda14(4, spannableString, lazyListIntervalContent$$ExternalSyntheticLambda2);
                    if (arrayList2.size() <= 1) {
                        size2 = arrayList2.size();
                        i5 = size2 * 2;
                        iArr = new int[i5];
                        size3 = arrayList2.size();
                        for (i6 = 0; i6 < size3; i6++) {
                            AnnotatedString.Range range5 = (AnnotatedString.Range) arrayList2.get(i6);
                            iArr[i6] = range5.start;
                            iArr[i6 + size2] = range5.end;
                        }
                        if (i5 > 1) {
                            Arrays.sort(iArr);
                        }
                        if (i5 != 0) {
                            throw new NoSuchElementException("Array is empty.");
                        }
                        i7 = iArr[0];
                        i8 = 0;
                        while (i8 < i5) {
                            i9 = iArr[i8];
                            if (i9 == i7) {
                                arrayList3 = arrayList2;
                                spanStyle3 = spanStyle2;
                                paragraphStyle2 = paragraphStyle;
                            } else {
                                size4 = arrayList2.size();
                                spanStyleMerge = spanStyle2;
                                i10 = 0;
                                while (i10 < size4) {
                                    ArrayList arrayList5 = arrayList2;
                                    AnnotatedString.Range range6 = (AnnotatedString.Range) arrayList2.get(i10);
                                    SpanStyle spanStyle8 = spanStyle2;
                                    i11 = range6.start;
                                    ParagraphStyle paragraphStyle7 = paragraphStyle;
                                    i12 = range6.end;
                                    if (i11 == i12 && AnnotatedStringKt.intersect(i7, i9, i11, i12)) {
                                        SpanStyle spanStyle9 = (SpanStyle) range6.item;
                                        spanStyleMerge = spanStyleMerge != null ? spanStyleMerge.merge(spanStyle9) : spanStyle9;
                                    }
                                    i10++;
                                    arrayList2 = arrayList5;
                                    spanStyle2 = spanStyle8;
                                    paragraphStyle = paragraphStyle7;
                                }
                                arrayList3 = arrayList2;
                                spanStyle3 = spanStyle2;
                                paragraphStyle2 = paragraphStyle;
                                if (spanStyleMerge != null) {
                                    alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyleMerge, Integer.valueOf(i7), Integer.valueOf(i9));
                                }
                                i7 = i9;
                            }
                            i8++;
                            arrayList2 = arrayList3;
                            spanStyle2 = spanStyle3;
                            paragraphStyle = paragraphStyle2;
                        }
                    } else if (!arrayList2.isEmpty()) {
                        SpanStyle spanStyle10 = (SpanStyle) ((AnnotatedString.Range) arrayList2.get(0)).item;
                        alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyle2 != null ? spanStyle2.merge(spanStyle10) : spanStyle10, Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).start), Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).end));
                    }
                    paragraphStyle3 = paragraphStyle;
                    size5 = arrayList.size();
                    i13 = 0;
                    z2 = false;
                    while (i13 < size5) {
                        range3 = (AnnotatedString.Range) arrayList.get(i13);
                        obj2 = range3.item;
                        if (obj2 instanceof SpanStyle) {
                            i22 = range3.start;
                            int i33 = range3.end;
                            if (i22 >= 0 || i22 >= spannableString.length() || i33 <= i22 || i33 > spannableString.length()) {
                                i20 = size5;
                                i21 = i13;
                                z2 = z2;
                                density6 = density6;
                                paragraphStyle4 = paragraphStyle3;
                            } else {
                                SpanStyle spanStyle11 = (SpanStyle) obj2;
                                long j8 = spanStyle11.letterSpacing;
                                BaselineShift baselineShift2 = spanStyle11.baselineShift;
                                TextForegroundStyle textForegroundStyle2 = spanStyle11.textForegroundStyle;
                                if (baselineShift2 != null) {
                                    spannableString.setSpan(new SkewXSpan(1, baselineShift2.multiplier), i22, i33, 33);
                                }
                                i20 = size5;
                                i21 = i13;
                                zztz.m817setColorRPmYEkk(spannableString, textForegroundStyle2.mo668getColor0d7_KjU(), i22, i33);
                                Brush brush = textForegroundStyle2.getBrush();
                                float alpha = textForegroundStyle2.getAlpha();
                                if (brush != null) {
                                    if (brush instanceof SolidColor) {
                                        zztz.m817setColorRPmYEkk(spannableString, ((SolidColor) brush).value, i22, i33);
                                    } else {
                                        spannableString.setSpan(new ShaderBrushSpan((ShaderBrush) brush, alpha), i22, i33, 33);
                                    }
                                }
                                TextDecoration textDecoration = spanStyle11.textDecoration;
                                if (textDecoration != null) {
                                    int i34 = textDecoration.mask;
                                    TextDecorationSpan textDecorationSpan = new TextDecorationSpan((i34 | 1) == i34, (i34 | 2) == i34);
                                    i23 = 33;
                                    spannableString.setSpan(textDecorationSpan, i22, i33, 33);
                                } else {
                                    i23 = 33;
                                }
                                int i35 = i23;
                                paragraphStyle4 = paragraphStyle3;
                                zztz.m818setFontSizeKmRG4DE(spannableString, spanStyle11.fontSize, density6, i22, i33);
                                String str4 = spanStyle11.fontFeatureSettings;
                                if (str4 != null) {
                                    spannableString.setSpan(new TypefaceSpan(1, str4), i22, i33, i35);
                                }
                                TextGeometricTransform textGeometricTransform2 = spanStyle11.textGeometricTransform;
                                if (textGeometricTransform2 != null) {
                                    spannableString.setSpan(new ScaleXSpan(textGeometricTransform2.scaleX), i22, i33, i35);
                                    spannableString.setSpan(new SkewXSpan(0, textGeometricTransform2.skewX), i22, i33, i35);
                                }
                                zztz.setLocaleList(spannableString, spanStyle11.localeList, i22, i33);
                                long j9 = spanStyle11.background;
                                if (j9 != 16) {
                                    spannableString.setSpan(new BackgroundColorSpan(BrushKt.m426toArgb8_81llA(j9)), i22, i33, i35);
                                }
                                Shadow shadow = spanStyle11.shadow;
                                if (shadow != null) {
                                    long j10 = shadow.offset;
                                    int iM426toArgb8_81llA = BrushKt.m426toArgb8_81llA(shadow.color);
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
                                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
                                    float f = shadow.blurRadius;
                                    ShadowSpan shadowSpan = new ShadowSpan(fIntBitsToFloat, fIntBitsToFloat2, f == 0.0f ? Float.MIN_VALUE : f, iM426toArgb8_81llA);
                                    i24 = 33;
                                    spannableString.setSpan(shadowSpan, i22, i33, 33);
                                } else {
                                    i24 = i35;
                                }
                                DrawStyle drawStyle = spanStyle11.drawStyle;
                                if (drawStyle != null) {
                                    spannableString.setSpan(new DrawStyleSpan(drawStyle), i22, i33, i24);
                                }
                                z2 = (TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j8), 4294967296L) || TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j8), 8589934592L)) ? true : z2;
                            }
                            z2 = z2;
                        } else {
                            i20 = size5;
                            i21 = i13;
                            z2 = z2;
                            density6 = density6;
                            paragraphStyle4 = paragraphStyle3;
                            z2 = z2;
                        }
                        i13 = i21 + 1;
                        paragraphStyle3 = paragraphStyle4;
                        density6 = density6;
                        size5 = i20;
                    }
                    density2 = density6;
                    ParagraphStyle paragraphStyle8 = paragraphStyle3;
                    if (z2) {
                        size7 = arrayList.size();
                        i16 = 0;
                        while (i16 < size7) {
                            range2 = (AnnotatedString.Range) arrayList.get(i16);
                            annotation = (AnnotatedString.Annotation) range2.item;
                            if (annotation instanceof SpanStyle) {
                                i19 = range2.start;
                                int i36 = range2.end;
                                if (i19 >= 0 || i19 >= spannableString.length() || i36 <= i19 || i36 > spannableString.length()) {
                                    i17 = size7;
                                    i18 = i16;
                                    density4 = density2;
                                } else {
                                    long j11 = ((SpanStyle) annotation).letterSpacing;
                                    long jM726getTypeUIouoOA5 = TextUnit.m726getTypeUIouoOA(j11);
                                    if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA5, 4294967296L)) {
                                        density4 = density2;
                                        letterSpacingSpanEm = new LetterSpacingSpanPx(density4.mo91toPxR2X_6o(j11));
                                        i17 = size7;
                                        i18 = i16;
                                    } else {
                                        i17 = size7;
                                        i18 = i16;
                                        density4 = density2;
                                        letterSpacingSpanEm = TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA5, 8589934592L) ? new LetterSpacingSpanEm(TextUnit.m727getValueimpl(j11)) : null;
                                    }
                                    if (letterSpacingSpanEm != null) {
                                        spannableString.setSpan(letterSpacingSpanEm, i19, i36, 33);
                                    }
                                }
                            } else {
                                i17 = size7;
                                i18 = i16;
                                density4 = density2;
                            }
                            i16 = i18 + 1;
                            size7 = i17;
                            density2 = density4;
                        }
                    }
                    density3 = density2;
                    textIndent2 = paragraphStyle8.textIndent;
                    if (textIndent2 != null) {
                        j = textIndent2.firstLine;
                        jM726getTypeUIouoOA = TextUnit.m726getTypeUIouoOA(j);
                        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
                            density3.mo91toPxR2X_6o(j);
                        } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
                            TextUnit.m727getValueimpl(j);
                        }
                    }
                    size6 = arrayList.size();
                    for (i14 = 0; i14 < size6; i14++) {
                        Object obj4 = ((AnnotatedString.Range) arrayList.get(i14)).item;
                    }
                    charSequence = spannableString;
                    if (list4.size() > 0) {
                        range = (AnnotatedString.Range) list4.get(0);
                        if (range.item == null) {
                            throw new ClassCastException();
                        }
                        for (Object obj5 : spannableString.getSpans(range.start, range.end, TypefaceEmojiSpan.class)) {
                            spannableString.removeSpan((TypefaceEmojiSpan) obj5);
                        }
                        throw null;
                    }
                } else {
                    paragraphStyle = paragraphStyle6;
                }
                arrayList2 = new ArrayList(arrayList.size());
                size = arrayList.size();
                while (i4 < size) {
                    range4 = (AnnotatedString.Range) arrayList.get(i4);
                    obj3 = range4.item;
                    if (obj3 instanceof SpanStyle) {
                        spanStyle4 = (SpanStyle) obj3;
                        if (spanStyle4.fontFamily != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            arrayList2.add(range4);
                        } else {
                            arrayList2.add(range4);
                        }
                    }
                }
                spanStyle = textStyle2.spanStyle;
                systemFontFamily = spanStyle.fontFamily;
                if (systemFontFamily != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, systemFontFamily, null, 0L, null, null, null, 0L, null, null, 65475);
                } else {
                    spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, systemFontFamily, null, 0L, null, null, null, 0L, null, null, 65475);
                }
                alertDialogKt$$ExternalSyntheticLambda14 = new AlertDialogKt$$ExternalSyntheticLambda14(4, spannableString, lazyListIntervalContent$$ExternalSyntheticLambda2);
                if (arrayList2.size() <= 1) {
                    size2 = arrayList2.size();
                    i5 = size2 * 2;
                    iArr = new int[i5];
                    size3 = arrayList2.size();
                    while (i6 < size3) {
                        AnnotatedString.Range range7 = (AnnotatedString.Range) arrayList2.get(i6);
                        iArr[i6] = range7.start;
                        iArr[i6 + size2] = range7.end;
                    }
                    if (i5 > 1) {
                        Arrays.sort(iArr);
                    }
                    if (i5 != 0) {
                        throw new NoSuchElementException("Array is empty.");
                    }
                    i7 = iArr[0];
                    i8 = 0;
                    while (i8 < i5) {
                        i9 = iArr[i8];
                        if (i9 == i7) {
                            arrayList3 = arrayList2;
                            spanStyle3 = spanStyle2;
                            paragraphStyle2 = paragraphStyle;
                        } else {
                            size4 = arrayList2.size();
                            spanStyleMerge = spanStyle2;
                            i10 = 0;
                            while (i10 < size4) {
                                ArrayList arrayList6 = arrayList2;
                                AnnotatedString.Range range8 = (AnnotatedString.Range) arrayList2.get(i10);
                                SpanStyle spanStyle12 = spanStyle2;
                                i11 = range8.start;
                                ParagraphStyle paragraphStyle9 = paragraphStyle;
                                i12 = range8.end;
                                if (i11 == i12) {
                                }
                                i10++;
                                arrayList2 = arrayList6;
                                spanStyle2 = spanStyle12;
                                paragraphStyle = paragraphStyle9;
                            }
                            arrayList3 = arrayList2;
                            spanStyle3 = spanStyle2;
                            paragraphStyle2 = paragraphStyle;
                            if (spanStyleMerge != null) {
                                alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyleMerge, Integer.valueOf(i7), Integer.valueOf(i9));
                            }
                            i7 = i9;
                        }
                        i8++;
                        arrayList2 = arrayList3;
                        spanStyle2 = spanStyle3;
                        paragraphStyle = paragraphStyle2;
                    }
                } else if (!arrayList2.isEmpty()) {
                    SpanStyle spanStyle13 = (SpanStyle) ((AnnotatedString.Range) arrayList2.get(0)).item;
                    alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyle2 != null ? spanStyle2.merge(spanStyle13) : spanStyle13, Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).start), Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).end));
                }
                paragraphStyle3 = paragraphStyle;
                size5 = arrayList.size();
                i13 = 0;
                z2 = false;
                while (i13 < size5) {
                    range3 = (AnnotatedString.Range) arrayList.get(i13);
                    obj2 = range3.item;
                    if (obj2 instanceof SpanStyle) {
                        i22 = range3.start;
                        int i37 = range3.end;
                        if (i22 >= 0) {
                            i20 = size5;
                            i21 = i13;
                            z2 = z2;
                            density6 = density6;
                            paragraphStyle4 = paragraphStyle3;
                            z2 = z2;
                        } else {
                            i20 = size5;
                            i21 = i13;
                            z2 = z2;
                            density6 = density6;
                            paragraphStyle4 = paragraphStyle3;
                            z2 = z2;
                        }
                    } else {
                        i20 = size5;
                        i21 = i13;
                        z2 = z2;
                        density6 = density6;
                        paragraphStyle4 = paragraphStyle3;
                        z2 = z2;
                    }
                    i13 = i21 + 1;
                    paragraphStyle3 = paragraphStyle4;
                    density6 = density6;
                    size5 = i20;
                }
                density2 = density6;
                ParagraphStyle paragraphStyle10 = paragraphStyle3;
                if (z2) {
                    size7 = arrayList.size();
                    i16 = 0;
                    while (i16 < size7) {
                        range2 = (AnnotatedString.Range) arrayList.get(i16);
                        annotation = (AnnotatedString.Annotation) range2.item;
                        if (annotation instanceof SpanStyle) {
                            i19 = range2.start;
                            int i38 = range2.end;
                            if (i19 >= 0) {
                                i17 = size7;
                                i18 = i16;
                                density4 = density2;
                            } else {
                                i17 = size7;
                                i18 = i16;
                                density4 = density2;
                            }
                        } else {
                            i17 = size7;
                            i18 = i16;
                            density4 = density2;
                        }
                        i16 = i18 + 1;
                        size7 = i17;
                        density2 = density4;
                    }
                }
                density3 = density2;
                textIndent2 = paragraphStyle10.textIndent;
                if (textIndent2 != null) {
                    j = textIndent2.firstLine;
                    jM726getTypeUIouoOA = TextUnit.m726getTypeUIouoOA(j);
                    if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
                        density3.mo91toPxR2X_6o(j);
                    } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
                        TextUnit.m727getValueimpl(j);
                    }
                }
                size6 = arrayList.size();
                while (i14 < size6) {
                    Object obj6 = ((AnnotatedString.Range) arrayList.get(i14)).item;
                }
                charSequence = spannableString;
                if (list4.size() > 0) {
                    range = (AnnotatedString.Range) list4.get(0);
                    if (range.item == null) {
                        throw new ClassCastException();
                    }
                    while (i15 < r2) {
                        spannableString.removeSpan((TypefaceEmojiSpan) obj5);
                    }
                    throw null;
                }
            }
            i3 = 0;
            textIndent = paragraphStyle6.textIndent;
            if (textIndent != null) {
                i25 = i3;
                j2 = textIndent.firstLine;
                j3 = textIndent.restLine;
                paragraphStyle = paragraphStyle6;
                if (TextUnit.m725equalsimpl0(j2, TextUnitKt.getSp(i25))) {
                    jM726getTypeUIouoOA2 = TextUnit.m726getTypeUIouoOA(j2);
                    if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA2, 4294967296L)) {
                        fM727getValueimpl = density6.mo91toPxR2X_6o(j2);
                    } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA2, 8589934592L)) {
                        fM727getValueimpl = TextUnit.m727getValueimpl(j2) * textSize;
                    } else {
                        fM727getValueimpl = 0.0f;
                    }
                    jM726getTypeUIouoOA3 = TextUnit.m726getTypeUIouoOA(j3);
                    if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA3, 4294967296L)) {
                        fM727getValueimpl2 = density6.mo91toPxR2X_6o(j3);
                    } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA3, 8589934592L)) {
                        fM727getValueimpl2 = TextUnit.m727getValueimpl(j3) * textSize;
                    } else {
                        fM727getValueimpl2 = 0.0f;
                    }
                    spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fM727getValueimpl), (int) Math.ceil(fM727getValueimpl2)), 0, spannableString.length(), 33);
                } else {
                    jM726getTypeUIouoOA2 = TextUnit.m726getTypeUIouoOA(j2);
                    if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA2, 4294967296L)) {
                        fM727getValueimpl = density6.mo91toPxR2X_6o(j2);
                    } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA2, 8589934592L)) {
                        fM727getValueimpl = TextUnit.m727getValueimpl(j2) * textSize;
                    } else {
                        fM727getValueimpl = 0.0f;
                    }
                    jM726getTypeUIouoOA3 = TextUnit.m726getTypeUIouoOA(j3);
                    if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA3, 4294967296L)) {
                        fM727getValueimpl2 = density6.mo91toPxR2X_6o(j3);
                    } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA3, 8589934592L)) {
                        fM727getValueimpl2 = TextUnit.m727getValueimpl(j3) * textSize;
                    } else {
                        fM727getValueimpl2 = 0.0f;
                    }
                    spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fM727getValueimpl), (int) Math.ceil(fM727getValueimpl2)), 0, spannableString.length(), 33);
                }
                arrayList2 = new ArrayList(arrayList.size());
                size = arrayList.size();
                while (i4 < size) {
                    range4 = (AnnotatedString.Range) arrayList.get(i4);
                    obj3 = range4.item;
                    if (obj3 instanceof SpanStyle) {
                        spanStyle4 = (SpanStyle) obj3;
                        if (spanStyle4.fontFamily != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            arrayList2.add(range4);
                        } else {
                            arrayList2.add(range4);
                        }
                    }
                }
                spanStyle = textStyle2.spanStyle;
                systemFontFamily = spanStyle.fontFamily;
                if (systemFontFamily != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, systemFontFamily, null, 0L, null, null, null, 0L, null, null, 65475);
                } else {
                    spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, systemFontFamily, null, 0L, null, null, null, 0L, null, null, 65475);
                }
                alertDialogKt$$ExternalSyntheticLambda14 = new AlertDialogKt$$ExternalSyntheticLambda14(4, spannableString, lazyListIntervalContent$$ExternalSyntheticLambda2);
                if (arrayList2.size() <= 1) {
                    size2 = arrayList2.size();
                    i5 = size2 * 2;
                    iArr = new int[i5];
                    size3 = arrayList2.size();
                    while (i6 < size3) {
                        AnnotatedString.Range range9 = (AnnotatedString.Range) arrayList2.get(i6);
                        iArr[i6] = range9.start;
                        iArr[i6 + size2] = range9.end;
                    }
                    if (i5 > 1) {
                        Arrays.sort(iArr);
                    }
                    if (i5 != 0) {
                        throw new NoSuchElementException("Array is empty.");
                    }
                    i7 = iArr[0];
                    i8 = 0;
                    while (i8 < i5) {
                        i9 = iArr[i8];
                        if (i9 == i7) {
                            arrayList3 = arrayList2;
                            spanStyle3 = spanStyle2;
                            paragraphStyle2 = paragraphStyle;
                        } else {
                            size4 = arrayList2.size();
                            spanStyleMerge = spanStyle2;
                            i10 = 0;
                            while (i10 < size4) {
                                ArrayList arrayList7 = arrayList2;
                                AnnotatedString.Range range10 = (AnnotatedString.Range) arrayList2.get(i10);
                                SpanStyle spanStyle14 = spanStyle2;
                                i11 = range10.start;
                                ParagraphStyle paragraphStyle11 = paragraphStyle;
                                i12 = range10.end;
                                if (i11 == i12) {
                                }
                                i10++;
                                arrayList2 = arrayList7;
                                spanStyle2 = spanStyle14;
                                paragraphStyle = paragraphStyle11;
                            }
                            arrayList3 = arrayList2;
                            spanStyle3 = spanStyle2;
                            paragraphStyle2 = paragraphStyle;
                            if (spanStyleMerge != null) {
                                alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyleMerge, Integer.valueOf(i7), Integer.valueOf(i9));
                            }
                            i7 = i9;
                        }
                        i8++;
                        arrayList2 = arrayList3;
                        spanStyle2 = spanStyle3;
                        paragraphStyle = paragraphStyle2;
                    }
                } else if (!arrayList2.isEmpty()) {
                    SpanStyle spanStyle15 = (SpanStyle) ((AnnotatedString.Range) arrayList2.get(0)).item;
                    alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyle2 != null ? spanStyle2.merge(spanStyle15) : spanStyle15, Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).start), Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).end));
                }
                paragraphStyle3 = paragraphStyle;
                size5 = arrayList.size();
                i13 = 0;
                z2 = false;
                while (i13 < size5) {
                    range3 = (AnnotatedString.Range) arrayList.get(i13);
                    obj2 = range3.item;
                    if (obj2 instanceof SpanStyle) {
                        i22 = range3.start;
                        int i39 = range3.end;
                        if (i22 >= 0) {
                            i20 = size5;
                            i21 = i13;
                            z2 = z2;
                            density6 = density6;
                            paragraphStyle4 = paragraphStyle3;
                            z2 = z2;
                        } else {
                            i20 = size5;
                            i21 = i13;
                            z2 = z2;
                            density6 = density6;
                            paragraphStyle4 = paragraphStyle3;
                            z2 = z2;
                        }
                    } else {
                        i20 = size5;
                        i21 = i13;
                        z2 = z2;
                        density6 = density6;
                        paragraphStyle4 = paragraphStyle3;
                        z2 = z2;
                    }
                    i13 = i21 + 1;
                    paragraphStyle3 = paragraphStyle4;
                    density6 = density6;
                    size5 = i20;
                }
                density2 = density6;
                ParagraphStyle paragraphStyle12 = paragraphStyle3;
                if (z2) {
                    size7 = arrayList.size();
                    i16 = 0;
                    while (i16 < size7) {
                        range2 = (AnnotatedString.Range) arrayList.get(i16);
                        annotation = (AnnotatedString.Annotation) range2.item;
                        if (annotation instanceof SpanStyle) {
                            i19 = range2.start;
                            int i310 = range2.end;
                            if (i19 >= 0) {
                                i17 = size7;
                                i18 = i16;
                                density4 = density2;
                            } else {
                                i17 = size7;
                                i18 = i16;
                                density4 = density2;
                            }
                        } else {
                            i17 = size7;
                            i18 = i16;
                            density4 = density2;
                        }
                        i16 = i18 + 1;
                        size7 = i17;
                        density2 = density4;
                    }
                }
                density3 = density2;
                textIndent2 = paragraphStyle12.textIndent;
                if (textIndent2 != null) {
                    j = textIndent2.firstLine;
                    jM726getTypeUIouoOA = TextUnit.m726getTypeUIouoOA(j);
                    if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
                        density3.mo91toPxR2X_6o(j);
                    } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
                        TextUnit.m727getValueimpl(j);
                    }
                }
                size6 = arrayList.size();
                while (i14 < size6) {
                    Object obj7 = ((AnnotatedString.Range) arrayList.get(i14)).item;
                }
                charSequence = spannableString;
                if (list4.size() > 0) {
                    range = (AnnotatedString.Range) list4.get(0);
                    if (range.item == null) {
                        throw new ClassCastException();
                    }
                    while (i15 < r2) {
                        spannableString.removeSpan((TypefaceEmojiSpan) obj5);
                    }
                    throw null;
                }
            } else {
                paragraphStyle = paragraphStyle6;
            }
            arrayList2 = new ArrayList(arrayList.size());
            size = arrayList.size();
            while (i4 < size) {
                range4 = (AnnotatedString.Range) arrayList.get(i4);
                obj3 = range4.item;
                if (obj3 instanceof SpanStyle) {
                    spanStyle4 = (SpanStyle) obj3;
                    if (spanStyle4.fontFamily != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        arrayList2.add(range4);
                    } else {
                        arrayList2.add(range4);
                    }
                }
            }
            spanStyle = textStyle2.spanStyle;
            systemFontFamily = spanStyle.fontFamily;
            if (systemFontFamily != null) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, systemFontFamily, null, 0L, null, null, null, 0L, null, null, 65475);
            } else {
                spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, systemFontFamily, null, 0L, null, null, null, 0L, null, null, 65475);
            }
            alertDialogKt$$ExternalSyntheticLambda14 = new AlertDialogKt$$ExternalSyntheticLambda14(4, spannableString, lazyListIntervalContent$$ExternalSyntheticLambda2);
            if (arrayList2.size() <= 1) {
                size2 = arrayList2.size();
                i5 = size2 * 2;
                iArr = new int[i5];
                size3 = arrayList2.size();
                while (i6 < size3) {
                    AnnotatedString.Range range11 = (AnnotatedString.Range) arrayList2.get(i6);
                    iArr[i6] = range11.start;
                    iArr[i6 + size2] = range11.end;
                }
                if (i5 > 1) {
                    Arrays.sort(iArr);
                }
                if (i5 != 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                i7 = iArr[0];
                i8 = 0;
                while (i8 < i5) {
                    i9 = iArr[i8];
                    if (i9 == i7) {
                        arrayList3 = arrayList2;
                        spanStyle3 = spanStyle2;
                        paragraphStyle2 = paragraphStyle;
                    } else {
                        size4 = arrayList2.size();
                        spanStyleMerge = spanStyle2;
                        i10 = 0;
                        while (i10 < size4) {
                            ArrayList arrayList8 = arrayList2;
                            AnnotatedString.Range range12 = (AnnotatedString.Range) arrayList2.get(i10);
                            SpanStyle spanStyle16 = spanStyle2;
                            i11 = range12.start;
                            ParagraphStyle paragraphStyle13 = paragraphStyle;
                            i12 = range12.end;
                            if (i11 == i12) {
                            }
                            i10++;
                            arrayList2 = arrayList8;
                            spanStyle2 = spanStyle16;
                            paragraphStyle = paragraphStyle13;
                        }
                        arrayList3 = arrayList2;
                        spanStyle3 = spanStyle2;
                        paragraphStyle2 = paragraphStyle;
                        if (spanStyleMerge != null) {
                            alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyleMerge, Integer.valueOf(i7), Integer.valueOf(i9));
                        }
                        i7 = i9;
                    }
                    i8++;
                    arrayList2 = arrayList3;
                    spanStyle2 = spanStyle3;
                    paragraphStyle = paragraphStyle2;
                }
            } else if (!arrayList2.isEmpty()) {
                SpanStyle spanStyle17 = (SpanStyle) ((AnnotatedString.Range) arrayList2.get(0)).item;
                alertDialogKt$$ExternalSyntheticLambda14.invoke(spanStyle2 != null ? spanStyle2.merge(spanStyle17) : spanStyle17, Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).start), Integer.valueOf(((AnnotatedString.Range) arrayList2.get(0)).end));
            }
            paragraphStyle3 = paragraphStyle;
            size5 = arrayList.size();
            i13 = 0;
            z2 = false;
            while (i13 < size5) {
                range3 = (AnnotatedString.Range) arrayList.get(i13);
                obj2 = range3.item;
                if (obj2 instanceof SpanStyle) {
                    i22 = range3.start;
                    int i311 = range3.end;
                    if (i22 >= 0) {
                        i20 = size5;
                        i21 = i13;
                        z2 = z2;
                        density6 = density6;
                        paragraphStyle4 = paragraphStyle3;
                        z2 = z2;
                    } else {
                        i20 = size5;
                        i21 = i13;
                        z2 = z2;
                        density6 = density6;
                        paragraphStyle4 = paragraphStyle3;
                        z2 = z2;
                    }
                } else {
                    i20 = size5;
                    i21 = i13;
                    z2 = z2;
                    density6 = density6;
                    paragraphStyle4 = paragraphStyle3;
                    z2 = z2;
                }
                i13 = i21 + 1;
                paragraphStyle3 = paragraphStyle4;
                density6 = density6;
                size5 = i20;
            }
            density2 = density6;
            ParagraphStyle paragraphStyle14 = paragraphStyle3;
            if (z2) {
                size7 = arrayList.size();
                i16 = 0;
                while (i16 < size7) {
                    range2 = (AnnotatedString.Range) arrayList.get(i16);
                    annotation = (AnnotatedString.Annotation) range2.item;
                    if (annotation instanceof SpanStyle) {
                        i19 = range2.start;
                        int i312 = range2.end;
                        if (i19 >= 0) {
                            i17 = size7;
                            i18 = i16;
                            density4 = density2;
                        } else {
                            i17 = size7;
                            i18 = i16;
                            density4 = density2;
                        }
                    } else {
                        i17 = size7;
                        i18 = i16;
                        density4 = density2;
                    }
                    i16 = i18 + 1;
                    size7 = i17;
                    density2 = density4;
                }
            }
            density3 = density2;
            textIndent2 = paragraphStyle14.textIndent;
            if (textIndent2 != null) {
                j = textIndent2.firstLine;
                jM726getTypeUIouoOA = TextUnit.m726getTypeUIouoOA(j);
                if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
                    density3.mo91toPxR2X_6o(j);
                } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
                    TextUnit.m727getValueimpl(j);
                }
            }
            size6 = arrayList.size();
            while (i14 < size6) {
                Object obj8 = ((AnnotatedString.Range) arrayList.get(i14)).item;
            }
            charSequence = spannableString;
            if (list4.size() > 0) {
                range = (AnnotatedString.Range) list4.get(0);
                if (range.item == null) {
                    throw new ClassCastException();
                }
                while (i15 < r2) {
                    spannableString.removeSpan((TypefaceEmojiSpan) obj5);
                }
                throw null;
            }
        }
        charSequence = charSequenceProcess;
        this.charSequence = charSequence;
        this.layoutIntrinsics = new LayoutIntrinsics(charSequence, this.textPaint, this.textDirectionHeuristic);
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final boolean getHasStaleResolvedFonts() {
        MenuHostHelper menuHostHelper = this.resolvedTypefaces;
        if (menuHostHelper != null ? menuHostHelper.isStaleResolvedFont() : false) {
            return true;
        }
        if (!this.emojiCompatProcessed && AndroidTextPaint_androidKt.access$getHasEmojiCompat(this.style)) {
            Parameters.Builder builder = EmojiCompatStatus.delegate;
            Parameters.Builder builder2 = EmojiCompatStatus.delegate;
            State fontLoadState = (State) builder2.entries;
            if (fontLoadState == null) {
                if (EmojiCompat.isConfigured()) {
                    fontLoadState = builder2.getFontLoadState();
                    builder2.entries = fontLoadState;
                } else {
                    fontLoadState = AndroidTextPaint_androidKt.Falsey;
                }
            }
            if (((Boolean) fontLoadState.getValue()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMinIntrinsicWidth() {
        float f;
        LayoutIntrinsics layoutIntrinsics = this.layoutIntrinsics;
        float f2 = layoutIntrinsics._minIntrinsicWidth;
        TextPaint textPaint = layoutIntrinsics.textPaint;
        if (!Float.isNaN(f2)) {
            return layoutIntrinsics._minIntrinsicWidth;
        }
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        CharSequence charSequence = layoutIntrinsics.charSequence;
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, charSequence.length()));
        PriorityQueue priorityQueue = new PriorityQueue(10, StaticLayoutFactory.IntRangeComparator);
        int i = 0;
        for (int next = lineInstance.next(); next != -1; next = lineInstance.next()) {
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new IntRange(i, next, 1));
            } else {
                IntRange intRange = (IntRange) priorityQueue.peek();
                if (intRange != null && intRange.last - intRange.first < next - i) {
                    priorityQueue.poll();
                    priorityQueue.add(new IntRange(i, next, 1));
                }
            }
            i = next;
        }
        if (priorityQueue.isEmpty()) {
            f = 0.0f;
        } else {
            Iterator it = priorityQueue.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            IntRange intRange2 = (IntRange) it.next();
            float desiredWidth = Layout.getDesiredWidth(layoutIntrinsics.getCharSequenceForIntrinsicWidth(), intRange2.first, intRange2.last, textPaint);
            while (it.hasNext()) {
                IntRange intRange3 = (IntRange) it.next();
                desiredWidth = Math.max(desiredWidth, Layout.getDesiredWidth(layoutIntrinsics.getCharSequenceForIntrinsicWidth(), intRange3.first, intRange3.last, textPaint));
            }
            f = desiredWidth;
        }
        layoutIntrinsics._minIntrinsicWidth = f;
        return f;
    }
}
