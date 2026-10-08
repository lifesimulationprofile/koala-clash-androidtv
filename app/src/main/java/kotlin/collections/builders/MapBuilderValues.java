package kotlin.collections.builders;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilderKeysIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeKeysIterator;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MapBuilderValues extends AbstractCollection implements Collection, KMutableCollection {
    public final /* synthetic */ int $r8$classId;
    public final Object backing;

    public /* synthetic */ MapBuilderValues(int i, Object obj) {
        this.$r8$classId = i;
        this.backing = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return super.addAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                ((MapBuilder) this.backing).clear();
                break;
            default:
                ((PersistentHashMapBuilder) this.backing).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return ((MapBuilder) this.backing).containsValue(obj);
            default:
                return ((PersistentHashMapBuilder) this.backing).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                return ((MapBuilder) this.backing).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                MapBuilder mapBuilder = (MapBuilder) this.backing;
                mapBuilder.getClass();
                return new MapBuilder.KeysItr(mapBuilder, 2);
            default:
                PersistentHashMapBuilder persistentHashMapBuilder = (PersistentHashMapBuilder) this.backing;
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
                for (int i = 0; i < 8; i++) {
                    trieNodeBaseIteratorArr[i] = new TrieNodeKeysIterator(2);
                }
                return new PersistentHashMapBuilderKeysIterator(persistentHashMapBuilder, trieNodeBaseIteratorArr);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        int i;
        switch (this.$r8$classId) {
            case 0:
                MapBuilder mapBuilder = (MapBuilder) this.backing;
                mapBuilder.checkIsMutable$kotlin_stdlib();
                int i2 = mapBuilder.length;
                while (true) {
                    i = -1;
                    i2--;
                    if (i2 >= 0) {
                        if (mapBuilder.presenceArray[i2] >= 0 && Intrinsics.areEqual(mapBuilder.valuesArray[i2], obj)) {
                            i = i2;
                        }
                    }
                }
                if (i < 0) {
                    return false;
                }
                mapBuilder.removeEntryAt(i);
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                ((MapBuilder) this.backing).checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                ((MapBuilder) this.backing).checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.$r8$classId) {
            case 0:
                return ((MapBuilder) this.backing).size;
            default:
                PersistentHashMapBuilder persistentHashMapBuilder = (PersistentHashMapBuilder) this.backing;
                persistentHashMapBuilder.getClass();
                return persistentHashMapBuilder.size;
        }
    }
}
