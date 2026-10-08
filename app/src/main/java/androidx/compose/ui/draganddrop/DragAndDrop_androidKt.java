package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import coil.memory.MemoryCacheService;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DragAndDrop_androidKt {
    public static final long getPositionInRoot(MemoryCacheService memoryCacheService) {
        DragEvent dragEvent = (DragEvent) memoryCacheService.imageLoader;
        float x = dragEvent.getX();
        float y = dragEvent.getY();
        return (((long) Float.floatToRawIntBits(x)) << 32) | (((long) Float.floatToRawIntBits(y)) & 4294967295L);
    }
}
