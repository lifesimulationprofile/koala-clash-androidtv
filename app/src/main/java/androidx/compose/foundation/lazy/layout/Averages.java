package androidx.compose.foundation.lazy.layout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Averages {
    public long applyTimeNanos;
    public long measureTimeNanos;
    public int nestedPrefetchCount;
    public long pauseTimeNanos;
    public long resumeTimeNanos;

    public static long calculateAverageTime(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        long j3 = 4;
        return (j / j3) + ((j2 / j3) * ((long) 3));
    }
}
