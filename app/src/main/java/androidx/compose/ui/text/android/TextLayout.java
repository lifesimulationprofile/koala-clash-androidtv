package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.github.kr328.clash.log.LogcatCache;
import com.google.android.gms.internal.mlkit_vision_barcode.zztr;
import java.util.NoSuchElementException;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayout {
    public Request backingLayoutHelper;
    public LogcatCache backingWordIterator;
    public final int bottomPadding;
    public final boolean didExceedMaxLines;
    public final TextUtils.TruncateAt ellipsize;
    public final boolean includePadding;
    public final boolean isBoringLayout;
    public final int lastLineExtra;
    public final Paint.FontMetricsInt lastLineFontMetrics;
    public final Layout layout;
    public final float leftPadding;
    public final int lineCount;
    public final LineHeightStyleSpan[] lineHeightSpans;
    public final Rect rect = new Rect();
    public final float rightPadding;
    public final TextPaint textPaint;
    public final int topPadding;

    /* JADX WARN: Code duplicated, block: B:100:0x01a4 A[PHI: r7
      0x01a4: PHI (r7v7 int) = (r7v6 int), (r7v9 int) binds: [B:105:0x01b6, B:98:0x019d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x0222  */
    /* JADX WARN: Code duplicated, block: B:129:0x0224  */
    /* JADX WARN: Code duplicated, block: B:131:0x0229  */
    /* JADX WARN: Code duplicated, block: B:132:0x022b  */
    /* JADX WARN: Code duplicated, block: B:77:0x0164  */
    /* JADX WARN: Code duplicated, block: B:89:0x017b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r25v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public TextLayout(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, LayoutIntrinsics layoutIntrinsics) {
        int i9;
        int i10;
        TextDirectionHeuristic textDirectionHeuristic;
        Layout layoutCreate;
        int i11;
        int i12;
        int i13;
        char c;
        long j;
        int i14;
        int i15;
        int i16;
        int i17;
        long jVerticalPaddings;
        ?? r9;
        boolean zIsFallbackLineSpacingEnabled;
        int topPadding;
        boolean zIsFallbackLineSpacingEnabled2;
        long jVerticalPaddings2;
        Paint.FontMetricsInt fontMetricsInt;
        int i18;
        this.textPaint = textPaint;
        this.ellipsize = truncateAt;
        this.includePadding = z;
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic2 = TextLayout_androidKt.getTextDirectionHeuristic(i2);
        Layout.Alignment alignment = TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK;
        Layout.Alignment alignment2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? Layout.Alignment.ALIGN_NORMAL : TextAlignmentAdapter.ALIGN_RIGHT_FRAMEWORK : TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK : Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        boolean z2 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, SkewXSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics boringMetrics = layoutIntrinsics.getBoringMetrics();
            double d = f;
            int iCeil = (int) Math.ceil(d);
            if (boringMetrics == null || layoutIntrinsics.getMaxIntrinsicWidth() > f || z2) {
                i9 = 0;
                this.isBoringLayout = false;
                i10 = i3;
                textDirectionHeuristic = textDirectionHeuristic2;
                layoutCreate = StaticLayoutFactory.create(charSequence, textPaint, iCeil, charSequence.length(), textDirectionHeuristic, alignment2, i10, truncateAt, (int) Math.ceil(d), i8, z, i4, i5, i6, i7);
            } else {
                this.isBoringLayout = true;
                if (iCeil < 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("negative width");
                }
                if (iCeil < 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("negative ellipsized width");
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    layoutCreate = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(charSequence, textPaint, iCeil, alignment2, boringMetrics, z, truncateAt, iCeil);
                    i9 = 0;
                } else {
                    i9 = 0;
                    layoutCreate = new BoringLayout(charSequence, textPaint, iCeil, alignment2, 1.0f, 0.0f, boringMetrics, z, truncateAt, iCeil);
                }
                i10 = i3;
                textDirectionHeuristic = textDirectionHeuristic2;
            }
            this.layout = layoutCreate;
            Trace.endSection();
            int iMin = Math.min(layoutCreate.getLineCount(), i10);
            this.lineCount = iMin;
            int i19 = iMin - 1;
            this.didExceedMaxLines = (iMin >= i10 && (layoutCreate.getEllipsisCount(i19) > 0 || layoutCreate.getLineEnd(i19) != charSequence.length())) ? 1 : i9;
            LineHeightStyleSpan[] lineHeightStyleSpanArr = ((layoutCreate.getText() instanceof Spanned) && (StaticLayoutFactory.hasSpan((Spanned) layoutCreate.getText(), LineHeightStyleSpan.class) || layoutCreate.getText().length() <= 0)) ? (LineHeightStyleSpan[]) ((Spanned) layoutCreate.getText()).getSpans(i9, layoutCreate.getText().length(), LineHeightStyleSpan.class) : null;
            this.lineHeightSpans = lineHeightStyleSpanArr;
            if (lineHeightStyleSpanArr == null) {
                i11 = 2;
                i12 = i9;
            } else {
                LineHeightStyleSpan lineHeightStyleSpan = lineHeightStyleSpanArr.length == 0 ? null : lineHeightStyleSpanArr[i9];
                if (lineHeightStyleSpan != null) {
                    if (lineHeightStyleSpan.trimFirstLineTop) {
                        i11 = 2;
                        i18 = lineHeightStyleSpan.mode == 2 ? 1 : i18;
                        i12 = i18;
                    } else {
                        i11 = 2;
                    }
                    i18 = i9;
                    i12 = i18;
                } else {
                    i11 = 2;
                    i12 = i9;
                }
            }
            if (lineHeightStyleSpanArr == null) {
                i13 = i9;
            } else {
                LineHeightStyleSpan lineHeightStyleSpan2 = lineHeightStyleSpanArr.length == 0 ? null : lineHeightStyleSpanArr[i9];
                if (lineHeightStyleSpan2 != null && lineHeightStyleSpan2.trimLastLineBottom && lineHeightStyleSpan2.mode == i11) {
                    i13 = 1;
                } else {
                    i13 = i9;
                }
            }
            if (i12 == 0 || i13 == 0) {
                long jVerticalPaddings3 = TextLayout_androidKt.ZeroVerticalPadding;
                if (z) {
                    c = ' ';
                    j = 4294967295L;
                    i14 = 33;
                } else {
                    if (this.isBoringLayout) {
                        BoringLayout boringLayout = (BoringLayout) layoutCreate;
                        i14 = 33;
                        if (Build.VERSION.SDK_INT >= 33) {
                            zIsFallbackLineSpacingEnabled2 = boringLayout.isFallbackLineSpacingEnabled();
                        } else {
                            r9 = i9;
                        }
                    } else {
                        i14 = 33;
                        StaticLayout staticLayout = (StaticLayout) layoutCreate;
                        int i20 = Build.VERSION.SDK_INT;
                        if (i20 >= 33) {
                            zIsFallbackLineSpacingEnabled = staticLayout.isFallbackLineSpacingEnabled();
                        } else if (i20 >= 28) {
                            r9 = 1;
                        } else {
                            r9 = i9;
                        }
                    }
                    if (r9 != 0) {
                        r9 = zIsFallbackLineSpacingEnabled;
                        r9 = zIsFallbackLineSpacingEnabled2;
                        c = ' ';
                        j = 4294967295L;
                    } else {
                        r9 = zIsFallbackLineSpacingEnabled;
                        TextPaint paint = layoutCreate.getPaint();
                        CharSequence text = layoutCreate.getText();
                        c = ' ';
                        j = 4294967295L;
                        Rect charSequenceBounds = StaticLayoutFactory.getCharSequenceBounds(paint, text, layoutCreate.getLineStart(i9), layoutCreate.getLineEnd(i9));
                        int lineAscent = layoutCreate.getLineAscent(i9);
                        int i21 = charSequenceBounds.top;
                        if (i21 < lineAscent) {
                            r9 = zIsFallbackLineSpacingEnabled2;
                            topPadding = lineAscent - i21;
                        } else {
                            r9 = zIsFallbackLineSpacingEnabled2;
                            topPadding = layoutCreate.getTopPadding();
                        }
                        i15 = 1;
                        charSequenceBounds = iMin != 1 ? StaticLayoutFactory.getCharSequenceBounds(paint, text, layoutCreate.getLineStart(i19), layoutCreate.getLineEnd(i19)) : charSequenceBounds;
                        int lineDescent = layoutCreate.getLineDescent(i19);
                        int i22 = charSequenceBounds.bottom;
                        int bottomPadding = i22 > lineDescent ? i22 - lineDescent : layoutCreate.getBottomPadding();
                        if (topPadding != 0 || bottomPadding != 0) {
                            jVerticalPaddings3 = TextLayout_androidKt.VerticalPaddings(topPadding, bottomPadding);
                        }
                    }
                    if (i12 != 0) {
                        i16 = i9;
                    } else {
                        i16 = (int) (jVerticalPaddings3 >> c);
                    }
                    if (i13 != 0) {
                        i17 = i9;
                    } else {
                        i17 = (int) (jVerticalPaddings3 & j);
                    }
                    jVerticalPaddings = TextLayout_androidKt.VerticalPaddings(i16, i17);
                }
                i15 = 1;
                if (i12 != 0) {
                    i16 = i9;
                } else {
                    i16 = (int) (jVerticalPaddings3 >> c);
                }
                if (i13 != 0) {
                    i17 = i9;
                } else {
                    i17 = (int) (jVerticalPaddings3 & j);
                }
                jVerticalPaddings = TextLayout_androidKt.VerticalPaddings(i16, i17);
            } else {
                jVerticalPaddings = TextLayout_androidKt.ZeroVerticalPadding;
                c = ' ';
                j = 4294967295L;
                i14 = 33;
                i15 = 1;
            }
            if (lineHeightStyleSpanArr != null) {
                int length2 = lineHeightStyleSpanArr.length;
                int iMax = i9;
                int i23 = iMax;
                int iMax2 = i23;
                while (i23 < length2) {
                    LineHeightStyleSpan lineHeightStyleSpan3 = lineHeightStyleSpanArr[i23];
                    int i24 = lineHeightStyleSpan3.firstAscentDiff;
                    iMax = i24 < 0 ? Math.max(iMax, Math.abs(i24)) : iMax;
                    int i25 = lineHeightStyleSpan3.lastDescentDiff;
                    if (i25 < 0) {
                        iMax2 = Math.max(iMax, Math.abs(i25));
                    }
                    i23++;
                }
                jVerticalPaddings2 = (iMax == 0 && iMax2 == 0) ? TextLayout_androidKt.ZeroVerticalPadding : TextLayout_androidKt.VerticalPaddings(iMax, iMax2);
            } else {
                jVerticalPaddings2 = TextLayout_androidKt.ZeroVerticalPadding;
            }
            this.topPadding = Math.max((int) (jVerticalPaddings >> c), (int) (jVerticalPaddings2 >> c));
            this.bottomPadding = Math.max((int) (jVerticalPaddings & j), (int) (jVerticalPaddings2 & j));
            TextPaint textPaint2 = this.textPaint;
            LineHeightStyleSpan[] lineHeightStyleSpanArr2 = this.lineHeightSpans;
            int i26 = this.lineCount - i15;
            Layout layout = this.layout;
            if (layout.getLineStart(i26) != layout.getLineEnd(i26) || lineHeightStyleSpanArr2 == null || lineHeightStyleSpanArr2.length == 0) {
                fontMetricsInt = null;
            } else {
                TextDirectionHeuristic textDirectionHeuristic3 = textDirectionHeuristic;
                SpannableString spannableString = new SpannableString("\u200b");
                if (lineHeightStyleSpanArr2.length == 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                LineHeightStyleSpan lineHeightStyleSpan4 = lineHeightStyleSpanArr2[i9];
                spannableString.setSpan(new LineHeightStyleSpan(lineHeightStyleSpan4.lineHeight, spannableString.length(), (i26 == 0 || !lineHeightStyleSpan4.trimLastLineBottom) ? lineHeightStyleSpan4.trimLastLineBottom : i9, lineHeightStyleSpan4.trimLastLineBottom, lineHeightStyleSpan4.topRatio, lineHeightStyleSpan4.mode), i9, spannableString.length(), i14);
                StaticLayout staticLayoutCreate = StaticLayoutFactory.create(spannableString, textPaint2, Integer.MAX_VALUE, spannableString.length(), textDirectionHeuristic3, LayoutCompat.DEFAULT_LAYOUT_ALIGNMENT, Integer.MAX_VALUE, null, Integer.MAX_VALUE, 0, this.includePadding, 0, 0, 0, 0);
                fontMetricsInt = new Paint.FontMetricsInt();
                fontMetricsInt.ascent = staticLayoutCreate.getLineAscent(i9);
                fontMetricsInt.descent = staticLayoutCreate.getLineDescent(i9);
                fontMetricsInt.top = staticLayoutCreate.getLineTop(i9);
                fontMetricsInt.bottom = staticLayoutCreate.getLineBottom(i9);
            }
            this.lastLineExtra = fontMetricsInt != null ? fontMetricsInt.bottom - ((int) (getLineBottom(i19) - getLineTop(i19))) : i9;
            this.lastLineFontMetrics = fontMetricsInt;
            Layout layout2 = this.layout;
            this.leftPadding = zztr.getEllipsizedLeftPadding(layout2, i19, layout2.getPaint());
            Layout layout3 = this.layout;
            this.rightPadding = zztr.getEllipsizedRightPadding(layout3, i19, layout3.getPaint());
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final int getHeight() {
        boolean z = this.didExceedMaxLines;
        Layout layout = this.layout;
        return (z ? layout.getLineBottom(this.lineCount - 1) : layout.getHeight()) + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    public final float getHorizontalPadding(int i) {
        if (i == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }
        return 0.0f;
    }

    public final Request getLayoutHelper() {
        Request request = this.backingLayoutHelper;
        if (request != null) {
            return request;
        }
        Request request2 = new Request(this.layout);
        this.backingLayoutHelper = request2;
        return request2;
    }

    public final float getLineBaseline(int i) {
        Paint.FontMetricsInt fontMetricsInt;
        return this.topPadding + ((i != this.lineCount + (-1) || (fontMetricsInt = this.lastLineFontMetrics) == null) ? this.layout.getLineBaseline(i) : getLineTop(i) - fontMetricsInt.ascent);
    }

    public final float getLineBottom(int i) {
        Paint.FontMetricsInt fontMetricsInt;
        int i2 = this.lineCount;
        int i3 = i2 - 1;
        Layout layout = this.layout;
        if (i != i3 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            return this.topPadding + layout.getLineBottom(i) + (i == i2 + (-1) ? this.bottomPadding : 0);
        }
        return layout.getLineBottom(i - 1) + fontMetricsInt.bottom;
    }

    public final int getLineEnd(int i) {
        ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
        Layout layout = this.layout;
        return (layout.getEllipsisCount(i) <= 0 || this.ellipsize != TextUtils.TruncateAt.END) ? layout.getLineEnd(i) : layout.getText().length();
    }

    public final float getLineTop(int i) {
        return this.layout.getLineTop(i) + (i == 0 ? 0 : this.topPadding);
    }

    public final float getPrimaryHorizontal(int i, boolean z) {
        return getHorizontalPadding(this.layout.getLineForOffset(i)) + getLayoutHelper().getHorizontalPosition(i, true, z);
    }

    public final float getSecondaryHorizontal(int i, boolean z) {
        return getHorizontalPadding(this.layout.getLineForOffset(i)) + getLayoutHelper().getHorizontalPosition(i, false, z);
    }

    public final LogcatCache getWordIterator() {
        LogcatCache logcatCache = this.backingWordIterator;
        if (logcatCache != null) {
            return logcatCache;
        }
        Layout layout = this.layout;
        LogcatCache logcatCache2 = new LogcatCache(layout.getText(), layout.getText().length(), this.textPaint.getTextLocale());
        this.backingWordIterator = logcatCache2;
        return logcatCache2;
    }
}
