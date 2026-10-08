package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda3;
import androidx.core.view.MenuHostHelper;
import coil.disk.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPrefetchState {
    public int lastNumberOfNestedPrefetchItems;
    public final LazyListState$$ExternalSyntheticLambda3 onNestedPrefetch;
    public DiskLruCache.Editor prefetchHandleProvider;
    public final MenuHostHelper prefetchMetrics = new MenuHostHelper(13);
    public int realizedNestedPrefetchCount = -1;
    public int idealNestedPrefetchCount = -1;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class NestedPrefetchScopeImpl {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface PrefetchHandle {
        void cancel();

        void markAsUrgent();
    }

    public LazyLayoutPrefetchState(LazyListState$$ExternalSyntheticLambda3 lazyListState$$ExternalSyntheticLambda3) {
        this.onNestedPrefetch = lazyListState$$ExternalSyntheticLambda3;
    }
}
