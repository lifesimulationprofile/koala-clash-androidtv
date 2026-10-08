package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    public float alpha;
    public BlendModeColorFilter colorFilter;
    public int filterQuality = 1;
    public final AndroidImageBitmap image;
    public final long size;
    public final long srcSize;

    public BitmapPainter(AndroidImageBitmap androidImageBitmap, long j) {
        int i;
        int i2;
        this.image = androidImageBitmap;
        this.srcSize = j;
        if (((int) 0) < 0 || ((int) 0) < 0 || (i = (int) (j >> 32)) < 0 || (i2 = (int) (4294967295L & j)) < 0 || i > androidImageBitmap.bitmap.getWidth() || i2 > androidImageBitmap.bitmap.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.size = j;
        this.alpha = 1.0f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.alpha = f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter = blendModeColorFilter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        return Intrinsics.areEqual(this.image, bitmapPainter.image) && IntOffset.m712equalsimpl0(0L, 0L) && IntSize.m720equalsimpl0(this.srcSize, bitmapPainter.srcSize) && this.filterQuality == bitmapPainter.filterQuality;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public final long mo492getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m724toSizeozmzZPI(this.size);
    }

    public final int hashCode() {
        int iHashCode = (((int) 0) + (this.image.hashCode() * 31)) * 31;
        long j = this.srcSize;
        return ((((int) (j ^ (j >>> 32))) + iHashCode) * 31) + this.filterQuality;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        int iRound = Math.round(Float.intBitsToFloat((int) (layoutNodeDrawScope.mo474getSizeNHjbRc() >> 32)));
        int iRound2 = Math.round(Float.intBitsToFloat((int) (layoutNodeDrawScope.mo474getSizeNHjbRc() & 4294967295L)));
        float f = this.alpha;
        BlendModeColorFilter blendModeColorFilter = this.colorFilter;
        int i = this.filterQuality;
        AndroidImageBitmap androidImageBitmap = this.image;
        long j = this.srcSize;
        layoutNodeDrawScope.mo464drawImageAZ2fEMs(androidImageBitmap, 0L, j, (328 & 16) != 0 ? j : (((long) iRound) << 32) | (((long) iRound2) & 4294967295L), (328 & 32) != 0 ? 1.0f : f, blendModeColorFilter, (328 & 512) != 0 ? 1 : i);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BitmapPainter(image=");
        sb.append(this.image);
        sb.append(", srcOffset=");
        sb.append((Object) IntOffset.m715toStringimpl(0L));
        sb.append(", srcSize=");
        sb.append((Object) IntSize.m721toStringimpl(this.srcSize));
        sb.append(", filterQuality=");
        int i = this.filterQuality;
        if (i == 0) {
            str = "None";
        } else if (i == 1) {
            str = "Low";
        } else if (i == 2) {
            str = "Medium";
        } else {
            str = i == 3 ? "High" : "Unknown";
        }
        sb.append((Object) str);
        sb.append(')');
        return sb.toString();
    }
}
