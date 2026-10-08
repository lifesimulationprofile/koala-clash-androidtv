package coil.decode;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DecodeResult {
    public final BitmapDrawable drawable;
    public final boolean isSampled;

    public DecodeResult(BitmapDrawable bitmapDrawable, boolean z) {
        this.drawable = bitmapDrawable;
        this.isSampled = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return this.drawable.equals(decodeResult.drawable) && this.isSampled == decodeResult.isSampled;
    }

    public final int hashCode() {
        return (this.drawable.hashCode() * 31) + (this.isSampled ? 1231 : 1237);
    }
}
