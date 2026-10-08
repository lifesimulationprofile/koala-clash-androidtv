package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MemoryCache$Value {
    public final Bitmap bitmap;
    public final Map extras;

    public MemoryCache$Value(Bitmap bitmap, Map map) {
        this.bitmap = bitmap;
        this.extras = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemoryCache$Value)) {
            return false;
        }
        MemoryCache$Value memoryCache$Value = (MemoryCache$Value) obj;
        return Intrinsics.areEqual(this.bitmap, memoryCache$Value.bitmap) && Intrinsics.areEqual(this.extras, memoryCache$Value.extras);
    }

    public final int hashCode() {
        return this.extras.hashCode() + (this.bitmap.hashCode() * 31);
    }

    public final String toString() {
        return "Value(bitmap=" + this.bitmap + ", extras=" + this.extras + ')';
    }
}
