package androidx.appcompat.app;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TwilightManager$TwilightState {
    public boolean isNight;
    public long nextUpdate;

    public long availableTimeNanos() {
        if (this.isNight) {
            return Long.MAX_VALUE;
        }
        return Math.max(0L, this.nextUpdate - System.nanoTime());
    }
}
