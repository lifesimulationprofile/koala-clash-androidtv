package coil.memory;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealMemoryCache {
    public final StrongMemoryCache strongMemoryCache;
    public final RealWeakMemoryCache weakMemoryCache;

    public RealMemoryCache(StrongMemoryCache strongMemoryCache, RealWeakMemoryCache realWeakMemoryCache) {
        this.strongMemoryCache = strongMemoryCache;
        this.weakMemoryCache = realWeakMemoryCache;
    }
}
