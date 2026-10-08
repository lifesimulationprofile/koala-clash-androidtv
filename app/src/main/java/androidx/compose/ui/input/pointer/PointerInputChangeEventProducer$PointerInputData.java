package androidx.compose.ui.input.pointer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputChangeEventProducer$PointerInputData {
    public final boolean down;
    public final long positionOnScreen;
    public final long uptime;

    public PointerInputChangeEventProducer$PointerInputData(long j, long j2, boolean z) {
        this.uptime = j;
        this.positionOnScreen = j2;
        this.down = z;
    }
}
