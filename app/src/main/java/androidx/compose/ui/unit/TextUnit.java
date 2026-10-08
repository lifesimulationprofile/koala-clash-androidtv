package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnit {
    public static final TextUnitType[] TextUnitTypes = {new TextUnitType(0), new TextUnitType(4294967296L), new TextUnitType(8589934592L)};
    public static final long Unspecified = TextUnitKt.pack(Float.NaN, 0);
    public final long packedValue;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m725equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m726getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) ((j & 1095216660480L) >>> 32)].type;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m727getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m728hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m729toStringimpl(long j) {
        long jM726getTypeUIouoOA = m726getTypeUIouoOA(j);
        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 0L)) {
            return "Unspecified";
        }
        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
            return m727getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
            return "Invalid";
        }
        return m727getValueimpl(j) + ".em";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TextUnit) {
            return this.packedValue == ((TextUnit) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return m728hashCodeimpl(this.packedValue);
    }

    public final String toString() {
        return m729toStringimpl(this.packedValue);
    }
}
