package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.ui.graphics.vector.VectorGroup;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractMutableSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapBuilderKeys extends AbstractMutableSet {
    public final /* synthetic */ int $r8$classId;
    public final PersistentHashMapBuilder builder;

    public /* synthetic */ PersistentHashMapBuilderKeys(int i, PersistentHashMapBuilder persistentHashMapBuilder) {
        this.$r8$classId = i;
        this.builder = persistentHashMapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                this.builder.clear();
                break;
            default:
                this.builder.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return this.builder.containsKey(obj);
            default:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
                    Object obj2 = persistentHashMapBuilder.get(key);
                    if (obj2 != null) {
                        return obj2.equals(entry.getValue());
                    }
                    if (entry.getValue() == null && persistentHashMapBuilder.containsKey(entry.getKey())) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        switch (this.$r8$classId) {
            case 0:
                PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
                persistentHashMapBuilder.getClass();
                return persistentHashMapBuilder.size;
            default:
                PersistentHashMapBuilder persistentHashMapBuilder2 = this.builder;
                persistentHashMapBuilder2.getClass();
                return persistentHashMapBuilder2.size;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
                for (int i = 0; i < 8; i++) {
                    trieNodeBaseIteratorArr[i] = new TrieNodeKeysIterator(0);
                }
                return new PersistentHashMapBuilderKeysIterator(this.builder, trieNodeBaseIteratorArr);
            default:
                return new VectorGroup.AnonymousClass1(this.builder);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
                if (!persistentHashMapBuilder.containsKey(obj)) {
                    return false;
                }
                persistentHashMapBuilder.remove(obj);
                return true;
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.builder.remove(entry.getKey(), entry.getValue());
        }
    }
}
