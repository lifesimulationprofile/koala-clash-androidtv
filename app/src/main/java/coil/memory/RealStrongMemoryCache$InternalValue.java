package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealStrongMemoryCache$InternalValue {
    public final Bitmap bitmap;
    public final Map extras;
    public final int size;

    public RealStrongMemoryCache$InternalValue(Bitmap bitmap, Map map, int i) {
        this.bitmap = bitmap;
        this.extras = map;
        this.size = i;
    }
}
