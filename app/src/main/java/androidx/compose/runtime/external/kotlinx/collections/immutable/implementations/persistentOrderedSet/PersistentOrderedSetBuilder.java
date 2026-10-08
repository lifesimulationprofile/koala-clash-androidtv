package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.markers.KMutableCollection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedSetBuilder extends AbstractMutableSet implements Collection, KMutableCollection {
    public Object firstElement;
    public final PersistentHashMapBuilder hashMapBuilder;
    public Object lastElement;
    public PersistentOrderedSet set;

    public PersistentOrderedSetBuilder(PersistentOrderedSet persistentOrderedSet) {
        this.set = persistentOrderedSet;
        this.firstElement = persistentOrderedSet.firstElement;
        this.lastElement = persistentOrderedSet.lastElement;
        this.hashMapBuilder = persistentOrderedSet.hashMap.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        PersistentHashMapBuilder persistentHashMapBuilder = this.hashMapBuilder;
        if (persistentHashMapBuilder.containsKey(obj)) {
            return false;
        }
        if (isEmpty()) {
            this.firstElement = obj;
            this.lastElement = obj;
            persistentHashMapBuilder.put(obj, new Links());
            return true;
        }
        persistentHashMapBuilder.put(this.lastElement, new Links(((Links) persistentHashMapBuilder.get(this.lastElement)).previous, obj));
        persistentHashMapBuilder.put(obj, new Links(this.lastElement));
        this.lastElement = obj;
        return true;
    }

    public final PersistentOrderedSet build() {
        PersistentHashMap persistentHashMapBuild = this.hashMapBuilder.build();
        PersistentOrderedSet persistentOrderedSet = this.set;
        if (persistentHashMapBuild != persistentOrderedSet.hashMap) {
            persistentOrderedSet = new PersistentOrderedSet(this.firstElement, this.lastElement, persistentHashMapBuild);
        }
        this.set = persistentOrderedSet;
        return persistentOrderedSet;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.hashMapBuilder.clear();
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this.firstElement = endOfChain;
        this.lastElement = endOfChain;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.hashMapBuilder.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        PersistentHashMapBuilder persistentHashMapBuilder = this.hashMapBuilder;
        persistentHashMapBuilder.getClass();
        return persistentHashMapBuilder.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        PersistentHashMapBuilder persistentHashMapBuilder = this.hashMapBuilder;
        Links links = (Links) persistentHashMapBuilder.remove(obj);
        if (links == null) {
            return false;
        }
        Object obj2 = links.next;
        Object obj3 = links.previous;
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        if (obj3 != endOfChain) {
            persistentHashMapBuilder.put(obj3, new Links(((Links) persistentHashMapBuilder.get(obj3)).previous, obj2));
        } else {
            this.firstElement = obj2;
        }
        if (obj2 != endOfChain) {
            persistentHashMapBuilder.put(obj2, new Links(obj3, ((Links) persistentHashMapBuilder.get(obj2)).next));
            return true;
        }
        this.lastElement = obj3;
        return true;
    }
}
