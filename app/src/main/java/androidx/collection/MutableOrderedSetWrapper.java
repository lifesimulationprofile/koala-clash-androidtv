package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableOrderedSetWrapper implements KMutableSet, Set, KMappedMarker {
    public final MutableOrderedScatterSet parent;
    public final MutableOrderedScatterSet parent$1;

    public MutableOrderedSetWrapper(MutableOrderedScatterSet mutableOrderedScatterSet) {
        this.parent$1 = mutableOrderedScatterSet;
        this.parent = mutableOrderedScatterSet;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.parent.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        MutableOrderedScatterSet mutableOrderedScatterSet = this.parent;
        int i = mutableOrderedScatterSet._size;
        for (Object obj : collection) {
            int iFindAbsoluteInsertIndex = mutableOrderedScatterSet.findAbsoluteInsertIndex(obj);
            mutableOrderedScatterSet.elements[iFindAbsoluteInsertIndex] = obj;
            long[] jArr = mutableOrderedScatterSet.nodes;
            int i2 = mutableOrderedScatterSet.head;
            jArr[iFindAbsoluteInsertIndex] = (((long) i2) & 2147483647L) | 4611686016279904256L;
            if (i2 != Integer.MAX_VALUE) {
                jArr[i2] = ((2147483647L & ((long) iFindAbsoluteInsertIndex)) << 31) | (jArr[i2] & (-4611686016279904257L));
            }
            mutableOrderedScatterSet.head = iFindAbsoluteInsertIndex;
            if (mutableOrderedScatterSet.tail == Integer.MAX_VALUE) {
                mutableOrderedScatterSet.tail = iFindAbsoluteInsertIndex;
            }
        }
        return i != mutableOrderedScatterSet._size;
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
        if (obj == null || MutableOrderedSetWrapper.class != obj.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.parent$1, ((MutableOrderedSetWrapper) obj).parent$1);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.parent$1.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.parent$1._size == 0;
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
        int iNumberOfTrailingZeros;
        MutableOrderedScatterSet mutableOrderedScatterSet = this.parent;
        int i = mutableOrderedScatterSet._size;
        Iterator it = collection.iterator();
        while (true) {
            int i2 = 1;
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int iHashCode = (next != null ? next.hashCode() : 0) * (-862048943);
            int i4 = iHashCode ^ (iHashCode << 16);
            int i5 = i4 & 127;
            int i6 = mutableOrderedScatterSet._capacity;
            int i7 = (i4 >>> 7) & i6;
            while (true) {
                long[] jArr = mutableOrderedScatterSet.metadata;
                int i8 = i7 >> 3;
                int i9 = (i7 & 7) << 3;
                int i10 = i2;
                int i11 = i3;
                long j = (((-i9) >> 63) & (jArr[i8 + i2] << (64 - i9))) | (jArr[i8] >>> i9);
                long j2 = (((long) i5) * 72340172838076673L) ^ j;
                long j3 = -9187201950435737472L;
                long j4 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L);
                while (j4 != 0) {
                    iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i7) & i6;
                    long j5 = j3;
                    if (Intrinsics.areEqual(mutableOrderedScatterSet.elements[iNumberOfTrailingZeros], next)) {
                        break;
                    }
                    j4 &= j4 - 1;
                    j3 = j5;
                }
                if ((j & ((~j) << 6) & j3) != 0) {
                    iNumberOfTrailingZeros = -1;
                    break;
                }
                i3 = i11 + 8;
                i7 = (i7 + i3) & i6;
                i2 = i10;
            }
            if (iNumberOfTrailingZeros >= 0) {
                mutableOrderedScatterSet.removeElementAt(iNumberOfTrailingZeros);
            }
        }
        return i != mutableOrderedScatterSet._size;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return this.parent.retainAll(collection);
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
