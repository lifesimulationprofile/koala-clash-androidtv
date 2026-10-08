package androidx.compose.ui.text.android.style;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceSpan extends MetricAffectingSpan {
    public final /* synthetic */ int $r8$classId;
    public final Object typeface;

    public /* synthetic */ TypefaceSpan(int i, Object obj) {
        this.$r8$classId = i;
        this.typeface = obj;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        switch (this.$r8$classId) {
            case 0:
                textPaint.setTypeface((Typeface) this.typeface);
                break;
            default:
                textPaint.setFontFeatureSettings((String) this.typeface);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        switch (this.$r8$classId) {
            case 0:
                textPaint.setTypeface((Typeface) this.typeface);
                break;
            default:
                textPaint.setFontFeatureSettings((String) this.typeface);
                break;
        }
    }
}
