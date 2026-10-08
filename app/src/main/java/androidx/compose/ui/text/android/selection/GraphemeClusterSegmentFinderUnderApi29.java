package androidx.compose.ui.text.android.selection;

import com.google.android.gms.internal.mlkit_vision_barcode.zztp;
import java.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GraphemeClusterSegmentFinderUnderApi29 extends zztp {
    public final BreakIterator breakIterator;

    public GraphemeClusterSegmentFinderUnderApi29(CharSequence charSequence) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(charSequence.toString());
        this.breakIterator = characterInstance;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztp
    public final int next(int i) {
        return this.breakIterator.following(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztp
    public final int previous(int i) {
        return this.breakIterator.preceding(i);
    }
}
