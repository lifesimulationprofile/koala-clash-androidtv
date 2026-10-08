package androidx.compose.ui.spatial;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RectListKt {
    public static final long EverythingButLastChildOffset = (((long) 1023) << 50) ^ (-1);
    public static final long EverythingButParentId = (-1) ^ (((long) 33554431) << 25);
    public static final long TombStone;

    static {
        long j = 33554431;
        TombStone = j | (((long) Math.min(0, 1023)) << 50) | (j << 25);
    }
}
