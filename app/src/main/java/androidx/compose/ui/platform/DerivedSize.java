package androidx.compose.ui.platform;

import androidx.compose.ui.unit.IntSize;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DerivedSize {
    public static final DerivedSize Zero = new DerivedSize(0, 0);
    public final long dpSize;
    public final long pxSize;

    public DerivedSize(long j, long j2) {
        this.pxSize = j;
        this.dpSize = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DerivedSize) {
            DerivedSize derivedSize = (DerivedSize) obj;
            return IntSize.m720equalsimpl0(this.pxSize, derivedSize.pxSize) && this.dpSize == derivedSize.dpSize;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.pxSize;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.dpSize;
        return ((int) ((j2 >>> 32) ^ j2)) + i;
    }
}
