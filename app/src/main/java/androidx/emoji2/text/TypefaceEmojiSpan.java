package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.nio.ByteBuffer;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceEmojiSpan extends ReplacementSpan {
    public final TypefaceEmojiRasterizer mRasterizer;
    public TextPaint mWorkingPaint;
    public final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    public short mWidth = -1;
    public float mRatio = 1.0f;

    public TypefaceEmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.checkNotNull(typefaceEmojiRasterizer, "rasterizer cannot be null");
        this.mRasterizer = typefaceEmojiRasterizer;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i, i2, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.mWorkingPaint;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.mWorkingPaint = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        if (!(characterStyle instanceof MetricAffectingSpan)) {
                            characterStyle.updateDrawState(textPaint);
                        }
                    }
                } else if (paint instanceof TextPaint) {
                    textPaint = (TextPaint) paint;
                }
            } else if (paint instanceof TextPaint) {
                textPaint = (TextPaint) paint;
            }
        } else if (paint instanceof TextPaint) {
            textPaint = (TextPaint) paint;
        }
        TextPaint textPaint3 = textPaint;
        if (textPaint3 != null && textPaint3.bgColor != 0) {
            int color = textPaint3.getColor();
            Paint.Style style = textPaint3.getStyle();
            textPaint3.setColor(textPaint3.bgColor);
            textPaint3.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, i3, f + this.mWidth, i5, textPaint3);
            textPaint3.setStyle(style);
            textPaint3.setColor(color);
        }
        EmojiCompat.get().getClass();
        float f2 = i4;
        Paint paint2 = textPaint3;
        if (textPaint3 == null) {
            paint2 = paint;
        }
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        Dispatcher dispatcher = typefaceEmojiRasterizer.mMetadataRepo;
        Typeface typeface = (Typeface) dispatcher.runningSyncCalls;
        Typeface typeface2 = paint2.getTypeface();
        paint2.setTypeface(typeface);
        canvas.drawText((char[]) dispatcher.readyAsyncCalls, typefaceEmojiRasterizer.mIndex * 2, 2, f, f2, paint2);
        paint2.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.mTmpFontMetrics;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
        int i__offset = metadataItem.__offset(14);
        this.mRatio = fAbs / (i__offset != 0 ? ((ByteBuffer) metadataItem.bb).getShort(i__offset + metadataItem.bb_pos) : (short) 0);
        MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
        int i__offset2 = metadataItem2.__offset(14);
        if (i__offset2 != 0) {
            ((ByteBuffer) metadataItem2.bb).getShort(i__offset2 + metadataItem2.bb_pos);
        }
        MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
        int i__offset3 = metadataItem3.__offset(12);
        short s = (short) ((i__offset3 != 0 ? ((ByteBuffer) metadataItem3.bb).getShort(i__offset3 + metadataItem3.bb_pos) : (short) 0) * this.mRatio);
        this.mWidth = s;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
