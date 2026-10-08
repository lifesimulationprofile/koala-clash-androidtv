package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    public final Alignment handleReferencePoint;
    public final OffsetProvider positionProvider;
    public long prevPosition = 0;

    public HandlePositionProvider(Alignment alignment, OffsetProvider offsetProvider) {
        this.handleReferencePoint = alignment;
        this.positionProvider = offsetProvider;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo10calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        long jMo169provideF1C5BW0 = this.positionProvider.mo169provideF1C5BW0();
        if ((9223372034707292159L & jMo169provideF1C5BW0) == 9205357640488583168L) {
            jMo169provideF1C5BW0 = this.prevPosition;
        }
        this.prevPosition = jMo169provideF1C5BW0;
        return IntOffset.m714plusqkQi6aY(IntOffset.m714plusqkQi6aY((((long) intRect.left) << 32) | (((long) intRect.top) & 4294967295L), IntOffsetKt.m717roundk4lQ0M(jMo169provideF1C5BW0)), this.handleReferencePoint.mo305alignKFBX0sM(j2, 0L, layoutDirection));
    }
}
