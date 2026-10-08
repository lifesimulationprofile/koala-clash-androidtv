package coil.decode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ExifData {
    public static final ExifData NONE = new ExifData(0, false);
    public final boolean isFlipped;
    public final int rotationDegrees;

    public ExifData(int i, boolean z) {
        this.isFlipped = z;
        this.rotationDegrees = i;
    }
}
