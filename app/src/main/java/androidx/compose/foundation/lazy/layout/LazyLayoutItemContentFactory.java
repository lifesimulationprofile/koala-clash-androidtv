package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutItemContentFactory {
    public final TooltipKt$$ExternalSyntheticLambda0 itemProvider;
    public final MutableScatterMap lambdasCache;
    public final SaveableStateHolder saveableStateHolder;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CachedItemContent {
        public ComposableLambdaImpl _content;
        public final Object contentType;
        public int index;
        public final Object key;

        public CachedItemContent(int i, Object obj, Object obj2) {
            this.key = obj;
            this.contentType = obj2;
            this.index = i;
        }
    }

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder, TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda0) {
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = tooltipKt$$ExternalSyntheticLambda0;
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.lambdasCache = new MutableScatterMap();
    }

    public final Function2 getContent(int i, Object obj, Object obj2) {
        MutableScatterMap mutableScatterMap = this.lambdasCache;
        CachedItemContent cachedItemContent = (CachedItemContent) mutableScatterMap.get(obj);
        if (cachedItemContent != null && cachedItemContent.index == i && Intrinsics.areEqual(cachedItemContent.contentType, obj2)) {
            ComposableLambdaImpl composableLambdaImpl = cachedItemContent._content;
            if (composableLambdaImpl != null) {
                return composableLambdaImpl;
            }
            ComposableLambdaImpl composableLambdaImpl2 = new ComposableLambdaImpl(818252804, new TextKt$$ExternalSyntheticLambda2(4, LazyLayoutItemContentFactory.this, cachedItemContent), true);
            cachedItemContent._content = composableLambdaImpl2;
            return composableLambdaImpl2;
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(i, obj, obj2);
        mutableScatterMap.set(obj, cachedItemContent2);
        ComposableLambdaImpl composableLambdaImpl3 = cachedItemContent2._content;
        if (composableLambdaImpl3 != null) {
            return composableLambdaImpl3;
        }
        ComposableLambdaImpl composableLambdaImpl4 = new ComposableLambdaImpl(818252804, new TextKt$$ExternalSyntheticLambda2(4, this, cachedItemContent2), true);
        cachedItemContent2._content = composableLambdaImpl4;
        return composableLambdaImpl4;
    }

    public final Object getContentType(Object obj) {
        if (obj == null) {
            return null;
        }
        CachedItemContent cachedItemContent = (CachedItemContent) this.lambdasCache.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.contentType;
        }
        LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) this.itemProvider.invoke();
        int index = lazyListItemProviderImpl.keyIndexMap.getIndex(obj);
        if (index != -1) {
            return lazyListItemProviderImpl.getContentType(index);
        }
        return null;
    }
}
