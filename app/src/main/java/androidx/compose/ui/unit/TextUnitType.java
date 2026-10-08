package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnitType {
    public final long type;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m731equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m732toStringimpl(long j) {
        if (m731equalsimpl0(j, 0L)) {
            return "Unspecified";
        }
        if (m731equalsimpl0(j, 4294967296L)) {
            return "Sp";
        }
        return m731equalsimpl0(j, 8589934592L) ? "Em" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TextUnitType) {
            return this.type == ((TextUnitType) obj).type;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.type;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return m732toStringimpl(this.type);
    }
}
