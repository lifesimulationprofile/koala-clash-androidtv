package androidx.profileinstaller;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class WritableFileSection {
    public final byte[] mContents;
    public final boolean mNeedsCompression;
    public final int mType;

    public WritableFileSection(int i, byte[] bArr, boolean z) {
        this.mType = i;
        this.mContents = bArr;
        this.mNeedsCompression = z;
    }
}
