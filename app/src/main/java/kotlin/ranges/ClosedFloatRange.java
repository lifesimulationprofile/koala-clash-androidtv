package kotlin.ranges;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ClosedFloatRange {
    public final boolean equals(Object obj) {
        return obj instanceof ClosedFloatRange;
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f) + (Float.floatToIntBits(0.0f) * 31);
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
