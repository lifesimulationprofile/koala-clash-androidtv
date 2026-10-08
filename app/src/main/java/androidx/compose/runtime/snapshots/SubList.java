package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.ReversedListReadOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SubList implements List, KMutableCollection {
    public final int offset;
    public final SnapshotStateList parentList;
    public int size;
    public int structure;

    public SubList(SnapshotStateList snapshotStateList, int i, int i2) {
        this.parentList = snapshotStateList;
        this.offset = i;
        this.structure = ((StateListStateRecord) SnapshotKt.current(snapshotStateList.firstStateRecord)).structuralChange;
        this.size = i2 - i;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        validateModification$2();
        int i = this.offset + this.size;
        SnapshotStateList snapshotStateList = this.parentList;
        snapshotStateList.add(i, obj);
        this.size++;
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        return addAll(this.size, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        if (this.size > 0) {
            validateModification$2();
            int i = this.size;
            int i2 = this.offset;
            SnapshotStateList snapshotStateList = this.parentList;
            snapshotStateList.removeRange(i2, i + i2);
            this.size = 0;
            this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        validateModification$2();
        SnapshotId_jvmKt.access$validateRange(i, this.size);
        return this.parentList.get(this.offset + i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        validateModification$2();
        int i = this.size;
        int i2 = this.offset;
        Iterator it = RangesKt.until(i2, i + i2).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (Intrinsics.areEqual(obj, this.parentList.get(iNextInt))) {
                return iNextInt - i2;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        validateModification$2();
        int i = this.size;
        int i2 = this.offset;
        for (int i3 = (i + i2) - 1; i3 >= i2; i3--) {
            if (Intrinsics.areEqual(obj, this.parentList.get(i3))) {
                return i3 - i2;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        validateModification$2();
        SnapshotStateList snapshotStateList = this.parentList;
        int i2 = this.offset;
        int i3 = this.size + i2;
        int size = snapshotStateList.size();
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current(snapshotStateList.firstStateRecord);
                i = stateListStateRecord.modification;
                abstractPersistentList = stateListStateRecord.list;
                Unit unit = Unit.INSTANCE;
            }
            PersistentVectorBuilder persistentVectorBuilderBuilder = abstractPersistentList.builder();
            persistentVectorBuilderBuilder.subList(i2, i3).retainAll(collection);
            AbstractPersistentList abstractPersistentListBuild = persistentVectorBuilderBuilder.build();
            if (Intrinsics.areEqual(abstractPersistentListBuild, abstractPersistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord2 = snapshotStateList.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, snapshotCurrentSnapshot), i, abstractPersistentListBuild, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateList);
        } while (!zAttemptUpdate);
        int size2 = size - snapshotStateList.size();
        if (size2 > 0) {
            this.structure = ((StateListStateRecord) SnapshotKt.current(this.parentList.firstStateRecord)).structuralChange;
            this.size -= size2;
        }
        return size2 > 0;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        SnapshotId_jvmKt.access$validateRange(i, this.size);
        validateModification$2();
        int i2 = i + this.offset;
        SnapshotStateList snapshotStateList = this.parentList;
        Object obj2 = snapshotStateList.set(i2, obj);
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= this.size)) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        validateModification$2();
        int i3 = this.offset;
        return new SubList(this.parentList, i + i3, i2 + i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    public final void validateModification$2() {
        if (SnapshotId_jvmKt.getStructure(this.parentList) != this.structure) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        validateModification$2();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = i - 1;
        return new ReversedListReadOnly.AnonymousClass1(ref$IntRef, this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        validateModification$2();
        int i2 = i + this.offset;
        SnapshotStateList snapshotStateList = this.parentList;
        boolean zAddAll = snapshotStateList.addAll(i2, collection);
        if (zAddAll) {
            this.size = collection.size() + this.size;
            this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final Object remove(int i) {
        validateModification$2();
        int i2 = this.offset + i;
        SnapshotStateList snapshotStateList = this.parentList;
        Object objRemove = snapshotStateList.remove(i2);
        this.size--;
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
        return objRemove;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        validateModification$2();
        int i2 = this.offset + i;
        SnapshotStateList snapshotStateList = this.parentList;
        snapshotStateList.add(i2, obj);
        this.size++;
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
    }
}
