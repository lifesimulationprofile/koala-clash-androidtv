package okio.internal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EocdRecord {
    public final long centralDirectoryOffset;
    public final long entryCount;

    public EocdRecord(long j, long j2, int i) {
        this.entryCount = j;
        this.centralDirectoryOffset = j2;
    }
}
