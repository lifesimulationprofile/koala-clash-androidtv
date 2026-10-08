package androidx.compose.ui.text.android.selection;

import android.text.TextPaint;
import com.google.android.gms.internal.mlkit_vision_barcode.zztp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GraphemeClusterSegmentFinderApi29 extends zztp {
    public final CharSequence text;
    public final TextPaint textPaint;

    public GraphemeClusterSegmentFinderApi29(CharSequence charSequence, TextPaint textPaint) {
        this.text = charSequence;
        this.textPaint = textPaint;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztp
    public final int next(int i) {
        CharSequence charSequence = this.text;
        return this.textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztp
    public final int previous(int i) {
        CharSequence charSequence = this.text;
        return this.textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 2);
    }
}
