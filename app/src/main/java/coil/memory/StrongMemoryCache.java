package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface StrongMemoryCache {
    MemoryCache$Value get(MemoryCache$Key memoryCache$Key);

    void set(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map);

    void trimMemory(int i);
}
