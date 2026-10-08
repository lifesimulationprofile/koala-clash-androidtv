package kotlin.collections.builders;

import androidx.collection.MutableObjectList;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListStateRecord;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResult;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ListBuilder extends AbstractMutableList implements RandomAccess, Serializable {
    public static final ListBuilder Empty;
    public Object[] backing;
    public boolean isReadOnly;
    public int length;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class BuilderSubList extends AbstractMutableList implements RandomAccess, Serializable {
        public Object[] backing;
        public int length;
        public final int offset;
        public final BuilderSubList parent;
        public final ListBuilder root;

        public BuilderSubList(Object[] objArr, int i, int i2, BuilderSubList builderSubList, ListBuilder listBuilder) {
            this.backing = objArr;
            this.offset = i;
            this.length = i2;
            this.parent = builderSubList;
            this.root = listBuilder;
            ((AbstractList) this).modCount = ((AbstractList) listBuilder).modCount;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean add(Object obj) {
            checkIsMutable();
            checkForComodification$5();
            addAtInternal(this.offset + this.length, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean addAll(Collection collection) {
            checkIsMutable();
            checkForComodification$5();
            int size = collection.size();
            addAllInternal(this.offset + this.length, collection, size);
            return size > 0;
        }

        public final void addAllInternal(int i, Collection collection, int i2) {
            ((AbstractList) this).modCount++;
            ListBuilder listBuilder = this.root;
            BuilderSubList builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAllInternal(i, collection, i2);
            } else {
                ListBuilder listBuilder2 = ListBuilder.Empty;
                listBuilder.addAllInternal$1(i, collection, i2);
            }
            this.backing = listBuilder.backing;
            this.length += i2;
        }

        public final void addAtInternal(int i, Object obj) {
            ((AbstractList) this).modCount++;
            ListBuilder listBuilder = this.root;
            BuilderSubList builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAtInternal(i, obj);
            } else {
                ListBuilder listBuilder2 = ListBuilder.Empty;
                listBuilder.addAtInternal$1(i, obj);
            }
            this.backing = listBuilder.backing;
            this.length++;
        }

        public final void checkForComodification$5() {
            if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public final void checkIsMutable() {
            if (this.root.isReadOnly) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final void clear() {
            checkIsMutable();
            checkForComodification$5();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            checkForComodification$5();
            if (obj == this) {
                return true;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.backing;
                int i = this.length;
                if (i == list.size()) {
                    for (int i2 = 0; i2 < i; i2++) {
                        if (Intrinsics.areEqual(objArr[this.offset + i2], list.get(i2))) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i) {
            checkForComodification$5();
            int i2 = this.length;
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
            }
            return this.backing[this.offset + i];
        }

        @Override // kotlin.collections.AbstractMutableList
        public final int getSize() {
            checkForComodification$5();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public final int hashCode() {
            checkForComodification$5();
            Object[] objArr = this.backing;
            int i = this.length;
            int iHashCode = 1;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[this.offset + i2];
                iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public final int indexOf(Object obj) {
            checkForComodification$5();
            for (int i = 0; i < this.length; i++) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean isEmpty() {
            checkForComodification$5();
            return this.length == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public final int lastIndexOf(Object obj) {
            checkForComodification$5();
            for (int i = this.length - 1; i >= 0; i--) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean remove(Object obj) {
            checkIsMutable();
            checkForComodification$5();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                removeAt(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean removeAll(Collection collection) {
            checkIsMutable();
            checkForComodification$5();
            return retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0;
        }

        @Override // kotlin.collections.AbstractMutableList
        public final Object removeAt(int i) {
            checkIsMutable();
            checkForComodification$5();
            int i2 = this.length;
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
            }
            return removeAtInternal(this.offset + i);
        }

        public final Object removeAtInternal(int i) {
            Object objRemoveAtInternal$1;
            ((AbstractList) this).modCount++;
            BuilderSubList builderSubList = this.parent;
            if (builderSubList != null) {
                objRemoveAtInternal$1 = builderSubList.removeAtInternal(i);
            } else {
                ListBuilder listBuilder = ListBuilder.Empty;
                objRemoveAtInternal$1 = this.root.removeAtInternal$1(i);
            }
            this.length--;
            return objRemoveAtInternal$1;
        }

        public final void removeRangeInternal(int i, int i2) {
            if (i2 > 0) {
                ((AbstractList) this).modCount++;
            }
            BuilderSubList builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.removeRangeInternal(i, i2);
            } else {
                ListBuilder listBuilder = ListBuilder.Empty;
                this.root.removeRangeInternal$1(i, i2);
            }
            this.length -= i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final boolean retainAll(Collection collection) {
            checkIsMutable();
            checkForComodification$5();
            return retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0;
        }

        public final int retainOrRemoveAllInternal(int i, int i2, Collection collection, boolean z) {
            int iRetainOrRemoveAllInternal$1;
            BuilderSubList builderSubList = this.parent;
            if (builderSubList != null) {
                iRetainOrRemoveAllInternal$1 = builderSubList.retainOrRemoveAllInternal(i, i2, collection, z);
            } else {
                ListBuilder listBuilder = ListBuilder.Empty;
                iRetainOrRemoveAllInternal$1 = this.root.retainOrRemoveAllInternal$1(i, i2, collection, z);
            }
            if (iRetainOrRemoveAllInternal$1 > 0) {
                ((AbstractList) this).modCount++;
            }
            this.length -= iRetainOrRemoveAllInternal$1;
            return iRetainOrRemoveAllInternal$1;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i, Object obj) {
            checkIsMutable();
            checkForComodification$5();
            int i2 = this.length;
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
            }
            Object[] objArr = this.backing;
            int i3 = this.offset;
            Object obj2 = objArr[i3 + i];
            objArr[i3 + i] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public final List subList(int i, int i2) {
            kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this.length);
            return new BuilderSubList(this.backing, this.offset + i, i2 - i, this, this.root);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final Object[] toArray(Object[] objArr) {
            checkForComodification$5();
            int length = objArr.length;
            int i = this.length;
            int i2 = this.offset;
            if (length < i) {
                return Arrays.copyOfRange(this.backing, i2, i + i2, objArr.getClass());
            }
            ArraysKt.copyInto(this.backing, objArr, 0, i2, i + i2);
            int i3 = this.length;
            if (i3 < objArr.length) {
                objArr[i3] = null;
            }
            return objArr;
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            checkForComodification$5();
            return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i) {
            checkForComodification$5();
            int i2 = this.length;
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
            }
            return new Itr(this, i);
        }

        @Override // java.util.AbstractList, java.util.List
        public final void add(int i, Object obj) {
            checkIsMutable();
            checkForComodification$5();
            int i2 = this.length;
            if (i >= 0 && i <= i2) {
                addAtInternal(this.offset + i, obj);
                return;
            }
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }

        @Override // java.util.AbstractList, java.util.List
        public final boolean addAll(int i, Collection collection) {
            checkIsMutable();
            checkForComodification$5();
            int i2 = this.length;
            if (i >= 0 && i <= i2) {
                int size = collection.size();
                addAllInternal(this.offset + i, collection, size);
                return size > 0;
            }
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final Object[] toArray() {
            checkForComodification$5();
            Object[] objArr = this.backing;
            int i = this.length;
            int i2 = this.offset;
            int i3 = i + i2;
            ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, objArr.length);
            return Arrays.copyOfRange(objArr, i2, i3);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public ListBuilder(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.backing = new Object[i];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        checkIsMutable$1();
        int i = this.length;
        ((AbstractList) this).modCount++;
        insertAtInternal(i, 1);
        this.backing[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        checkIsMutable$1();
        int size = collection.size();
        addAllInternal$1(this.length, collection, size);
        return size > 0;
    }

    public final void addAllInternal$1(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        insertAtInternal(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.backing[i + i3] = it.next();
        }
    }

    public final void addAtInternal$1(int i, Object obj) {
        ((AbstractList) this).modCount++;
        insertAtInternal(i, 1);
        this.backing[i] = obj;
    }

    public final void checkIsMutable$1() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        checkIsMutable$1();
        removeRangeInternal$1(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.backing;
            int i = this.length;
            if (i == list.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (Intrinsics.areEqual(objArr[i2], list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.length;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
        return this.backing[i];
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.backing;
        int i = this.length;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.backing[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public final void insertAtInternal(int i, int i2) {
        int i3 = this.length + i2;
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.backing;
        if (i3 > objArr.length) {
            int length = objArr.length;
            int i4 = length + (length >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 > 0) {
                i4 = i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.backing = Arrays.copyOf(objArr, i4);
        }
        Object[] objArr2 = this.backing;
        ArraysKt.copyInto(objArr2, objArr2, i + i2, i, this.length);
        this.length += i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.backing[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        checkIsMutable$1();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            removeAt(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        checkIsMutable$1();
        return retainOrRemoveAllInternal$1(0, this.length, collection, false) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        checkIsMutable$1();
        int i2 = this.length;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
        return removeAtInternal$1(i);
    }

    public final Object removeAtInternal$1(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.backing;
        Object obj = objArr[i];
        ArraysKt.copyInto(objArr, objArr, i, i + 1, this.length);
        Object[] objArr2 = this.backing;
        int i2 = this.length;
        objArr2[i2 - 1] = null;
        this.length = i2 - 1;
        return obj;
    }

    public final void removeRangeInternal$1(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.backing;
        ArraysKt.copyInto(objArr, objArr, i, i + i2, this.length);
        Object[] objArr2 = this.backing;
        int i3 = this.length;
        ListBuilderKt.resetRange(objArr2, i3 - i2, i3);
        this.length -= i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        checkIsMutable$1();
        return retainOrRemoveAllInternal$1(0, this.length, collection, true) > 0;
    }

    public final int retainOrRemoveAllInternal$1(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.backing[i5]) == z) {
                Object[] objArr = this.backing;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.backing;
        ArraysKt.copyInto(objArr2, objArr2, i + i4, i2 + i, this.length);
        Object[] objArr3 = this.backing;
        int i7 = this.length;
        ListBuilderKt.resetRange(objArr3, i7 - i6, i7);
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.length -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        checkIsMutable$1();
        int i2 = this.length;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
        Object[] objArr = this.backing;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this.length);
        return new BuilderSubList(this.backing, i, i2 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.length;
        if (length < i) {
            return Arrays.copyOfRange(this.backing, 0, i, objArr.getClass());
        }
        ArraysKt.copyInto(this.backing, objArr, 0, 0, i);
        int i2 = this.length;
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i2 = this.length;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
        return new Itr(this, i);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Itr implements ListIterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;
        public int expectedModCount;
        public int index;
        public int lastIndex;
        public final Object list;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Itr(HitTestResult hitTestResult, int i, int i2) {
            this(hitTestResult, (i2 & 1) != 0 ? 0 : i, 0, hitTestResult.values._size);
            this.$r8$classId = 2;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    checkForComodification$4();
                    ListBuilder listBuilder = (ListBuilder) this.list;
                    int i = this.index;
                    this.index = i + 1;
                    listBuilder.add(i, obj);
                    this.lastIndex = -1;
                    this.expectedModCount = ((AbstractList) listBuilder).modCount;
                    return;
                case 1:
                    validateModification();
                    SnapshotStateList snapshotStateList = (SnapshotStateList) this.list;
                    snapshotStateList.add(this.index + 1, obj);
                    this.lastIndex = -1;
                    this.index++;
                    this.expectedModCount = SnapshotId_jvmKt.getStructure(snapshotStateList);
                    return;
                case 2:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    checkForComodification$3();
                    BuilderSubList builderSubList = (BuilderSubList) this.list;
                    int i2 = this.index;
                    this.index = i2 + 1;
                    builderSubList.add(i2, obj);
                    this.lastIndex = -1;
                    this.expectedModCount = ((AbstractList) builderSubList).modCount;
                    return;
            }
        }

        public void checkForComodification$3() {
            if (((AbstractList) ((BuilderSubList) this.list).root).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public void checkForComodification$4() {
            if (((AbstractList) ((ListBuilder) this.list)).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    return this.index < ((ListBuilder) this.list).length;
                case 1:
                    return this.index < ((SnapshotStateList) this.list).size() - 1;
                case 2:
                    return this.index < this.expectedModCount;
                default:
                    return this.index < ((BuilderSubList) this.list).length;
            }
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            switch (this.$r8$classId) {
                case 0:
                    return this.index > 0;
                case 1:
                    return this.index >= 0;
                case 2:
                    return this.index > this.lastIndex;
                default:
                    return this.index > 0;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    checkForComodification$4();
                    int i = this.index;
                    ListBuilder listBuilder = (ListBuilder) this.list;
                    if (i >= listBuilder.length) {
                        throw new NoSuchElementException();
                    }
                    this.index = i + 1;
                    this.lastIndex = i;
                    return listBuilder.backing[i];
                case 1:
                    validateModification();
                    int i2 = this.index + 1;
                    this.lastIndex = i2;
                    SnapshotStateList snapshotStateList = (SnapshotStateList) this.list;
                    SnapshotId_jvmKt.access$validateRange(i2, snapshotStateList.size());
                    Object obj = snapshotStateList.get(i2);
                    this.index = i2;
                    return obj;
                case 2:
                    MutableObjectList mutableObjectList = ((HitTestResult) this.list).values;
                    int i3 = this.index;
                    this.index = i3 + 1;
                    return (Modifier.Node) mutableObjectList.get(i3);
                default:
                    checkForComodification$3();
                    int i4 = this.index;
                    BuilderSubList builderSubList = (BuilderSubList) this.list;
                    if (i4 >= builderSubList.length) {
                        throw new NoSuchElementException();
                    }
                    this.index = i4 + 1;
                    this.lastIndex = i4;
                    return builderSubList.backing[builderSubList.offset + i4];
            }
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            switch (this.$r8$classId) {
                case 0:
                    return this.index;
                case 1:
                    return this.index + 1;
                case 2:
                    return this.index - this.lastIndex;
                default:
                    return this.index;
            }
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            switch (this.$r8$classId) {
                case 0:
                    checkForComodification$4();
                    int i = this.index;
                    if (i <= 0) {
                        throw new NoSuchElementException();
                    }
                    int i2 = i - 1;
                    this.index = i2;
                    this.lastIndex = i2;
                    return ((ListBuilder) this.list).backing[i2];
                case 1:
                    validateModification();
                    int i3 = this.index;
                    SnapshotStateList snapshotStateList = (SnapshotStateList) this.list;
                    SnapshotId_jvmKt.access$validateRange(i3, snapshotStateList.size());
                    int i4 = this.index;
                    this.lastIndex = i4;
                    Object obj = snapshotStateList.get(i4);
                    this.index--;
                    return obj;
                case 2:
                    MutableObjectList mutableObjectList = ((HitTestResult) this.list).values;
                    int i5 = this.index - 1;
                    this.index = i5;
                    return (Modifier.Node) mutableObjectList.get(i5);
                default:
                    checkForComodification$3();
                    int i6 = this.index;
                    if (i6 <= 0) {
                        throw new NoSuchElementException();
                    }
                    int i7 = i6 - 1;
                    this.index = i7;
                    this.lastIndex = i7;
                    BuilderSubList builderSubList = (BuilderSubList) this.list;
                    return builderSubList.backing[builderSubList.offset + i7];
            }
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            int i;
            switch (this.$r8$classId) {
                case 0:
                    i = this.index;
                    break;
                case 1:
                    return this.index;
                case 2:
                    i = this.index - this.lastIndex;
                    break;
                default:
                    i = this.index;
                    break;
            }
            return i - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    ListBuilder listBuilder = (ListBuilder) this.list;
                    checkForComodification$4();
                    int i = this.lastIndex;
                    if (i == -1) {
                        throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                    }
                    listBuilder.removeAt(i);
                    this.index = this.lastIndex;
                    this.lastIndex = -1;
                    this.expectedModCount = ((AbstractList) listBuilder).modCount;
                    return;
                case 1:
                    validateModification();
                    SnapshotStateList snapshotStateList = (SnapshotStateList) this.list;
                    snapshotStateList.remove(this.lastIndex);
                    this.index--;
                    this.lastIndex = -1;
                    this.expectedModCount = SnapshotId_jvmKt.getStructure(snapshotStateList);
                    return;
                case 2:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    BuilderSubList builderSubList = (BuilderSubList) this.list;
                    checkForComodification$3();
                    int i2 = this.lastIndex;
                    if (i2 == -1) {
                        throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                    }
                    builderSubList.removeAt(i2);
                    this.index = this.lastIndex;
                    this.lastIndex = -1;
                    this.expectedModCount = ((AbstractList) builderSubList).modCount;
                    return;
            }
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    checkForComodification$4();
                    int i = this.lastIndex;
                    if (i == -1) {
                        throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                    }
                    ((ListBuilder) this.list).set(i, obj);
                    return;
                case 1:
                    SnapshotStateList snapshotStateList = (SnapshotStateList) this.list;
                    validateModification();
                    int i2 = this.lastIndex;
                    if (i2 < 0) {
                        throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
                    }
                    snapshotStateList.set(i2, obj);
                    this.expectedModCount = SnapshotId_jvmKt.getStructure(snapshotStateList);
                    return;
                case 2:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    checkForComodification$3();
                    int i3 = this.lastIndex;
                    if (i3 == -1) {
                        throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                    }
                    ((BuilderSubList) this.list).set(i3, obj);
                    return;
            }
        }

        public void validateModification() {
            if (SnapshotId_jvmKt.getStructure((SnapshotStateList) this.list) != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public Itr(ListBuilder listBuilder, int i) {
            this.$r8$classId = 0;
            this.list = listBuilder;
            this.index = i;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) listBuilder).modCount;
        }

        public Itr(SnapshotStateList snapshotStateList, int i) {
            this.$r8$classId = 1;
            this.list = snapshotStateList;
            this.index = i - 1;
            this.lastIndex = -1;
            this.expectedModCount = ((StateListStateRecord) SnapshotKt.current(snapshotStateList.firstStateRecord)).structuralChange;
        }

        public Itr(HitTestResult hitTestResult, int i, int i2, int i3) {
            this.$r8$classId = 2;
            this.list = hitTestResult;
            this.index = i;
            this.lastIndex = i2;
            this.expectedModCount = i3;
        }

        public Itr(BuilderSubList builderSubList, int i) {
            this.$r8$classId = 3;
            this.list = builderSubList;
            this.index = i;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) builderSubList).modCount;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        checkIsMutable$1();
        int i2 = this.length;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            addAllInternal$1(i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        checkIsMutable$1();
        int i2 = this.length;
        if (i >= 0 && i <= i2) {
            ((AbstractList) this).modCount++;
            insertAtInternal(i, 1);
            this.backing[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] objArr = this.backing;
        int i = this.length;
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i, objArr.length);
        return Arrays.copyOfRange(objArr, 0, i);
    }
}
