package androidx.compose.ui.graphics.painter;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapPainterKt {
    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY$default, reason: not valid java name */
    public static BitmapPainter m493BitmapPainterQZhYCtY$default(AndroidImageBitmap androidImageBitmap, int i) {
        Bitmap bitmap = androidImageBitmap.bitmap;
        BitmapPainter bitmapPainter = new BitmapPainter(androidImageBitmap, (((long) bitmap.getWidth()) << 32) | (((long) bitmap.getHeight()) & 4294967295L));
        bitmapPainter.filterQuality = i;
        return bitmapPainter;
    }
}
