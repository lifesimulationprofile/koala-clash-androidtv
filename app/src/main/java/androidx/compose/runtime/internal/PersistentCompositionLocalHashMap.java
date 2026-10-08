package androidx.compose.runtime.internal;

import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.ValueHolder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import coil.memory.RealWeakMemoryCache;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentCompositionLocalHashMap extends PersistentHashMap implements PersistentCompositionLocalMap {
    public static final PersistentCompositionLocalHashMap Empty = new PersistentCompositionLocalHashMap(TrieNode.EMPTY, 0);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder extends PersistentHashMapBuilder {
        public PersistentCompositionLocalHashMap map;

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public final PersistentCompositionLocalHashMap build() {
            TrieNode trieNode = this.node;
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = this.map;
            if (trieNode != persistentCompositionLocalHashMap.node) {
                this.ownership = new EndOfChain();
                persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(this.node, this.size);
            }
            this.map = persistentCompositionLocalHashMap;
            return persistentCompositionLocalHashMap;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof ProvidableCompositionLocal) {
                return super.containsKey((ProvidableCompositionLocal) obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof ValueHolder) {
                return super.containsValue((ValueHolder) obj);
            }
            return false;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof ProvidableCompositionLocal) {
                return (ValueHolder) super.get((ProvidableCompositionLocal) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof ProvidableCompositionLocal) ? obj2 : (ValueHolder) super.getOrDefault((ProvidableCompositionLocal) obj, (ValueHolder) obj2);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof ProvidableCompositionLocal) {
                return (ValueHolder) super.remove((ProvidableCompositionLocal) obj);
            }
            return null;
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof ProvidableCompositionLocal) {
            return super.containsKey((ProvidableCompositionLocal) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof ValueHolder) {
            return super.containsValue((ValueHolder) obj);
        }
        return false;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof ProvidableCompositionLocal) {
            return (ValueHolder) super.get((ProvidableCompositionLocal) obj);
        }
        return null;
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public final Object getCurrentValue(ProvidableCompositionLocal providableCompositionLocal) {
        return Stack.read(this, providableCompositionLocal);
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof ProvidableCompositionLocal) ? obj2 : (ValueHolder) super.getOrDefault((ProvidableCompositionLocal) obj, (ValueHolder) obj2);
    }

    public final PersistentCompositionLocalHashMap putValue(ProvidableCompositionLocal providableCompositionLocal, ValueHolder valueHolder) {
        RealWeakMemoryCache realWeakMemoryCachePut = this.node.put(providableCompositionLocal.hashCode(), 0, providableCompositionLocal, valueHolder);
        return realWeakMemoryCachePut == null ? this : new PersistentCompositionLocalHashMap((TrieNode) realWeakMemoryCachePut.cache, this.size + realWeakMemoryCachePut.operationsSinceCleanUp);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public final Builder builder() {
        Builder builder = new Builder(this);
        builder.map = this;
        return builder;
    }
}
