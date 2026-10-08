package androidx.compose.ui.graphics.colorspace;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorModel {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Cmyk;
    public static final long Lab;
    public static final long Rgb;
    public static final long Xyz;

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = (((long) 0) & 4294967295L) | j2;
        Xyz = (((long) 1) & 4294967295L) | j2;
        Lab = j2 | (((long) 2) & 4294967295L);
        Cmyk = (j & 4294967295L) | (((long) 4) << 32);
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m455equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m456toStringimpl(long j) {
        if (m455equalsimpl0(j, Rgb)) {
            return "Rgb";
        }
        if (m455equalsimpl0(j, Xyz)) {
            return "Xyz";
        }
        if (m455equalsimpl0(j, Lab)) {
            return "Lab";
        }
        return m455equalsimpl0(j, Cmyk) ? "Cmyk" : "Unknown";
    }
}
