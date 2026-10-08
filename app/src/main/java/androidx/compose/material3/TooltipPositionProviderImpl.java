package androidx.compose.material3;

import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TooltipPositionProviderImpl implements PopupPositionProvider {
    public final int tooltipAnchorSpacing;
    public final long windowContainerSize;

    public TooltipPositionProviderImpl(int i, long j) {
        this.tooltipAnchorSpacing = i;
        this.windowContainerSize = j;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo10calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        int i = (int) (j2 >> 32);
        int width = ((intRect.getWidth() - i) / 2) + intRect.left;
        long j3 = this.windowContainerSize;
        if (width < 0) {
            int i2 = intRect.left;
            int i3 = (i + i2) - ((int) (j3 >> 32));
            width = i2 - (i3 >= 0 ? i3 : 0);
        } else if (width + i > ((int) (j3 >> 32)) && (width = intRect.right - i) < 0) {
            width = 0;
        }
        int i4 = intRect.top - ((int) (j2 & 4294967295L));
        int i5 = this.tooltipAnchorSpacing;
        int i6 = i4 - i5;
        if (i6 < 0) {
            i6 = intRect.bottom + i5;
        }
        return (((long) i6) & 4294967295L) | (((long) width) << 32);
    }
}
