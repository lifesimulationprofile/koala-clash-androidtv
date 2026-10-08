package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Iterator;
import kotlin.collections.AbstractSet;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedSet extends AbstractSet implements PersistentSet {
    public static final PersistentOrderedSet EMPTY;
    public final Object firstElement;
    public final PersistentHashMap hashMap;
    public final Object lastElement;

    static {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        EMPTY = new PersistentOrderedSet(endOfChain, endOfChain, PersistentHashMap.EMPTY);
    }

    public PersistentOrderedSet(Object obj, Object obj2, PersistentHashMap persistentHashMap) {
        this.firstElement = obj;
        this.lastElement = obj2;
        this.hashMap = persistentHashMap;
    }

    @Override // java.util.Collection, java.util.Set
    public final PersistentOrderedSet add(Object obj) {
        PersistentHashMap persistentHashMap = this.hashMap;
        if (persistentHashMap.containsKey(obj)) {
            return this;
        }
        if (isEmpty()) {
            return new PersistentOrderedSet(obj, obj, persistentHashMap.put(obj, new Links()));
        }
        Object obj2 = this.lastElement;
        return new PersistentOrderedSet(this.firstElement, obj, persistentHashMap.put(obj2, new Links(((Links) persistentHashMap.get(obj2)).previous, obj)).put(obj, new Links(obj2)));
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        PersistentHashMap persistentHashMap = this.hashMap;
        persistentHashMap.getClass();
        return persistentHashMap.size;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new GeneratorSequence.AnonymousClass1(this.firstElement, this.hashMap);
    }

    @Override // java.util.Collection, java.util.Set
    public final PersistentOrderedSet remove(Object obj) {
        PersistentHashMap persistentHashMapPut = this.hashMap;
        Links links = (Links) persistentHashMapPut.get(obj);
        if (links == null) {
            return this;
        }
        Object obj2 = links.previous;
        Object obj3 = links.next;
        TrieNode trieNode = persistentHashMapPut.node;
        TrieNode trieNodeRemove = trieNode.remove(obj != null ? obj.hashCode() : 0, 0, obj);
        if (trieNode != trieNodeRemove) {
            persistentHashMapPut = trieNodeRemove == null ? PersistentHashMap.EMPTY : new PersistentHashMap(trieNodeRemove, persistentHashMapPut.size - 1);
        }
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        if (obj2 != endOfChain) {
            persistentHashMapPut = persistentHashMapPut.put(obj2, new Links(((Links) persistentHashMapPut.get(obj2)).previous, obj3));
        }
        if (obj3 != endOfChain) {
            persistentHashMapPut = persistentHashMapPut.put(obj3, new Links(obj2, ((Links) persistentHashMapPut.get(obj3)).next));
        }
        Object obj4 = obj2 != endOfChain ? this.firstElement : obj3;
        if (obj3 != endOfChain) {
            obj2 = this.lastElement;
        }
        return new PersistentOrderedSet(obj4, obj2, persistentHashMapPut);
    }
}
