package androidx.compose.runtime.composer.gapbuffer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class KeyInfo {
    public final int key;
    public final int location;
    public final int nodes;
    public final Object objectKey;

    public KeyInfo(Object obj, int i, int i2, int i3) {
        this.key = i;
        this.objectKey = obj;
        this.location = i2;
        this.nodes = i3;
    }
}
