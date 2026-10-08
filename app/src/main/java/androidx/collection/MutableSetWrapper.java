package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableSetWrapper implements KMutableSet, Set, KMappedMarker {
    public final MutableScatterSet parent;
    public final MutableScatterSet parent$1;

    public MutableSetWrapper(MutableScatterSet mutableScatterSet) {
        this.parent$1 = mutableScatterSet;
        this.parent = mutableScatterSet;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.parent.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        MutableScatterSet mutableScatterSet = this.parent;
        int i = mutableScatterSet._size;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            mutableScatterSet.plusAssign(it.next());
        }
        return i != mutableScatterSet._size;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.parent.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.parent$1.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.parent$1.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MutableSetWrapper.class != obj.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.parent$1, ((MutableSetWrapper) obj).parent$1);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.parent$1.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.parent$1.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new GeneratorSequence.AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.parent.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        MutableScatterSet mutableScatterSet = this.parent;
        int i = mutableScatterSet._size;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            mutableScatterSet.minusAssign(it.next());
        }
        return i != mutableScatterSet._size;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0050 A[LOOP:0: B:5:0x0011->B:17:0x0050, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[EDGE_INSN: B:24:0x0053->B:18:0x0053 BREAK  A[LOOP:0: B:5:0x0011->B:17:0x0050], SYNTHETIC] */
    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        MutableScatterSet mutableScatterSet = this.parent;
        Object[] objArr = mutableScatterSet.elements;
        int i = mutableScatterSet._size;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i2 != length) {
                        break;
                        break;
                    }
                    i2++;
                } else {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            if (!CollectionsKt.contains(collection, objArr[i5])) {
                                mutableScatterSet.removeElementAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                    if (i2 != length) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return i != mutableScatterSet._size;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.parent$1._size;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    public final String toString() {
        return this.parent$1.toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }
}
