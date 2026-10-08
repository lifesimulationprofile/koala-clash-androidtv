package androidx.collection;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.MutableVectorKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableObjectList {
    public int _size;
    public Object[] content;
    public ObjectListMutableList list;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MutableObjectListIterator implements ListIterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;
        public final Object list;
        public int prevIndex;

        public MutableObjectListIterator(List list, int i, int i2) {
            this.$r8$classId = i2;
            switch (i2) {
                case 1:
                    this.list = list;
                    this.prevIndex = i;
                    break;
                default:
                    this.list = list;
                    this.prevIndex = i - 1;
                    break;
            }
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator
        public final void add(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.prevIndex + 1;
                    this.prevIndex = i;
                    this.list.add(i, obj);
                    break;
                default:
                    this.list.add(this.prevIndex, obj);
                    this.prevIndex++;
                    break;
            }
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    return this.prevIndex < this.list.size() - 1;
                default:
                    return this.prevIndex < this.list.size();
            }
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            switch (this.$r8$classId) {
                case 0:
                    return this.prevIndex >= 0;
                default:
                    return this.prevIndex > 0;
            }
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.prevIndex + 1;
                    this.prevIndex = i;
                    return this.list.get(i);
                default:
                    int i2 = this.prevIndex;
                    this.prevIndex = i2 + 1;
                    return this.list.get(i2);
            }
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            switch (this.$r8$classId) {
                case 0:
                    return this.prevIndex + 1;
                default:
                    return this.prevIndex;
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator
        public final Object previous() {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.prevIndex;
                    this.prevIndex = i - 1;
                    return this.list.get(i);
                default:
                    int i2 = this.prevIndex - 1;
                    this.prevIndex = i2;
                    return this.list.get(i2);
            }
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            switch (this.$r8$classId) {
                case 0:
                    return this.prevIndex;
                default:
                    return this.prevIndex - 1;
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    this.list.remove(this.prevIndex);
                    this.prevIndex--;
                    break;
                default:
                    int i = this.prevIndex - 1;
                    this.prevIndex = i;
                    this.list.remove(i);
                    break;
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        @Override // java.util.ListIterator
        public final void set(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    this.list.set(this.prevIndex, obj);
                    break;
                default:
                    this.list.set(this.prevIndex, obj);
                    break;
            }
        }
    }

    public MutableObjectList(int i) {
        this.content = i == 0 ? ObjectListKt.EmptyArray : new Object[i];
    }

    public final void add(Object obj) {
        int i = this._size + 1;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        Object[] objArr2 = this.content;
        int i2 = this._size;
        objArr2[i2] = obj;
        this._size = i2 + 1;
    }

    public final void addAll(MutableObjectList mutableObjectList) {
        if (mutableObjectList.isEmpty()) {
            return;
        }
        int i = this._size + mutableObjectList._size;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        ArraysKt.copyInto(mutableObjectList.content, this.content, this._size, 0, mutableObjectList._size);
        this._size += mutableObjectList._size;
    }

    public final void clear() {
        Arrays.fill(this.content, 0, this._size, (Object) null);
        this._size = 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MutableObjectList) {
            MutableObjectList mutableObjectList = (MutableObjectList) obj;
            int i = mutableObjectList._size;
            int i2 = this._size;
            if (i == i2) {
                Object[] objArr = this.content;
                Object[] objArr2 = mutableObjectList.content;
                IntRange intRangeUntil = RangesKt.until(0, i2);
                int i3 = intRangeUntil.first;
                int i4 = intRangeUntil.last;
                if (i3 > i4) {
                    return true;
                }
                while (Intrinsics.areEqual(objArr[i3], objArr2[i3])) {
                    if (i3 == i4) {
                        return true;
                    }
                    i3++;
                }
                return false;
            }
        }
        return false;
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        RuntimeHelpersKt.throwNoSuchElementException("ObjectList is empty.");
        throw null;
    }

    public final Object get(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        throwIndexOutOfBoundsExclusiveException$collection(i);
        throw null;
    }

    public final int hashCode() {
        Object[] objArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(Object obj) {
        int i = 0;
        if (obj == null) {
            Object[] objArr = this.content;
            int i2 = this._size;
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i3 = this._size;
        while (i < i3) {
            if (obj.equals(objArr2[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final Object removeAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this._size)) {
            throwIndexOutOfBoundsExclusiveException$collection(i);
            throw null;
        }
        Object[] objArr = this.content;
        Object obj = objArr[i];
        if (i != i2 - 1) {
            ArraysKt.copyInto(objArr, objArr, i, i + 1, i2);
        }
        int i3 = this._size - 1;
        this._size = i3;
        objArr[i3] = null;
        return obj;
    }

    public final void removeRange(int i, int i2) {
        int i3;
        if (i < 0 || i > (i3 = this._size) || i2 < 0 || i2 > i3) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Start (" + i + ") and end (" + i2 + ") must be in 0.." + this._size);
            throw null;
        }
        if (i2 < i) {
            RuntimeHelpersKt.throwIllegalArgumentException("Start (" + i + ") is more than end (" + i2 + ')');
            throw null;
        }
        if (i2 != i) {
            if (i2 < i3) {
                Object[] objArr = this.content;
                ArraysKt.copyInto(objArr, objArr, i, i2, i3);
            }
            int i4 = this._size;
            int i5 = i4 - (i2 - i);
            Arrays.fill(this.content, i5, i4, (Object) null);
            this._size = i5;
        }
    }

    public final void resizeStorage(int i, Object[] objArr) {
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i, (length * 3) / 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        this.content = objArr2;
    }

    public final Object set(int i, Object obj) {
        if (i < 0 || i >= this._size) {
            throwIndexOutOfBoundsExclusiveException$collection(i);
            throw null;
        }
        Object[] objArr = this.content;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final void throwIndexOutOfBoundsExclusiveException$collection(int i) {
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Index ", " must be in 0..");
        sbM.append(this._size - 1);
        RuntimeHelpersKt.throwIndexOutOfBoundsException(sbM.toString());
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) (obj == this ? "(this)" : String.valueOf(obj)));
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ObjectListMutableList implements List, KMutableCollection {
        public final /* synthetic */ int $r8$classId;
        public final Object objectList;

        public /* synthetic */ ObjectListMutableList(int i, Object obj) {
            this.$r8$classId = i;
            this.objectList = obj;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ((MutableObjectList) this.objectList).add(obj);
                    break;
                default:
                    ((MutableVector) this.objectList).add(obj);
                    break;
            }
            return true;
        }

        @Override // java.util.List
        public final boolean addAll(int i, Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) this.objectList;
                    if (i < 0 || i > mutableObjectList._size) {
                        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Index ", " must be in 0..");
                        sbM.append(mutableObjectList._size);
                        RuntimeHelpersKt.throwIndexOutOfBoundsException(sbM.toString());
                        throw null;
                    }
                    int i2 = 0;
                    if (collection.isEmpty()) {
                        return false;
                    }
                    int size = collection.size() + mutableObjectList._size;
                    Object[] objArr = mutableObjectList.content;
                    if (objArr.length < size) {
                        mutableObjectList.resizeStorage(size, objArr);
                    }
                    Object[] objArr2 = mutableObjectList.content;
                    if (i != mutableObjectList._size) {
                        ArraysKt.copyInto(objArr2, objArr2, collection.size() + i, i, mutableObjectList._size);
                    }
                    for (Object obj : collection) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            AppCompatHintHelper.throwIndexOverflow();
                            throw null;
                        }
                        objArr2[i2 + i] = obj;
                        i2 = i3;
                    }
                    mutableObjectList._size = collection.size() + mutableObjectList._size;
                    return true;
                default:
                    return ((MutableVector) this.objectList).addAll(i, collection);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            switch (this.$r8$classId) {
                case 0:
                    ((MutableObjectList) this.objectList).clear();
                    break;
                default:
                    ((MutableVector) this.objectList).clear();
                    break;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return ((MutableObjectList) this.objectList).indexOf(obj) >= 0;
                default:
                    return ((MutableVector) this.objectList).contains(obj);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) this.objectList;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        if (mutableObjectList.indexOf(it.next()) < 0) {
                            return false;
                        }
                    }
                    return true;
                default:
                    MutableVector mutableVector = (MutableVector) this.objectList;
                    mutableVector.getClass();
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        if (!mutableVector.contains(it2.next())) {
                            return false;
                        }
                    }
                    return true;
            }
        }

        @Override // java.util.List
        public final Object get(int i) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkIndex(i, this);
                    return ((MutableObjectList) this.objectList).get(i);
                default:
                    MutableVectorKt.checkIndex(i, this);
                    return ((MutableVector) this.objectList).content[i];
            }
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return ((MutableObjectList) this.objectList).indexOf(obj);
                default:
                    return ((MutableVector) this.objectList).indexOf(obj);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            switch (this.$r8$classId) {
                case 0:
                    return ((MutableObjectList) this.objectList).isEmpty();
                default:
                    return ((MutableVector) this.objectList).size == 0;
            }
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, 0);
                default:
                    return new MutableObjectListIterator(this, 0, 1);
            }
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            int i;
            switch (this.$r8$classId) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) this.objectList;
                    if (obj == null) {
                        Object[] objArr = mutableObjectList.content;
                        i = mutableObjectList._size - 1;
                        while (-1 < i) {
                            if (objArr[i] != null) {
                                i--;
                            }
                        }
                        return -1;
                    }
                    Object[] objArr2 = mutableObjectList.content;
                    i = mutableObjectList._size - 1;
                    while (-1 < i) {
                        if (!obj.equals(objArr2[i])) {
                            i--;
                        }
                    }
                    return -1;
                    return i;
                default:
                    MutableVector mutableVector = (MutableVector) this.objectList;
                    Object[] objArr3 = mutableVector.content;
                    for (int i2 = mutableVector.size - 1; i2 >= 0; i2--) {
                        if (Intrinsics.areEqual(obj, objArr3[i2])) {
                            return i2;
                        }
                    }
                    return -1;
            }
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, 0);
                default:
                    return new MutableObjectListIterator(this, 0, 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return ((MutableObjectList) this.objectList).remove(obj);
                default:
                    return ((MutableVector) this.objectList).remove(obj);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) this.objectList;
                    int i = mutableObjectList._size;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        mutableObjectList.remove(it.next());
                    }
                    return i != mutableObjectList._size;
                default:
                    MutableVector mutableVector = (MutableVector) this.objectList;
                    mutableVector.getClass();
                    if (!collection.isEmpty()) {
                        int i2 = mutableVector.size;
                        Iterator it2 = collection.iterator();
                        while (it2.hasNext()) {
                            mutableVector.remove(it2.next());
                        }
                        if (i2 != mutableVector.size) {
                            return true;
                        }
                    }
                    return false;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) this.objectList;
                    int i = mutableObjectList._size;
                    Object[] objArr = mutableObjectList.content;
                    for (int i2 = i - 1; -1 < i2; i2--) {
                        if (!collection.contains(objArr[i2])) {
                            mutableObjectList.removeAt(i2);
                        }
                    }
                    return i != mutableObjectList._size;
                default:
                    MutableVector mutableVector = (MutableVector) this.objectList;
                    int i3 = mutableVector.size;
                    for (int i4 = i3 - 1; -1 < i4; i4--) {
                        if (!collection.contains(mutableVector.content[i4])) {
                            mutableVector.removeAt(i4);
                        }
                    }
                    return i3 != mutableVector.size;
            }
        }

        @Override // java.util.List
        public final Object set(int i, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkIndex(i, this);
                    return ((MutableObjectList) this.objectList).set(i, obj);
                default:
                    MutableVectorKt.checkIndex(i, this);
                    Object[] objArr = ((MutableVector) this.objectList).content;
                    Object obj2 = objArr[i];
                    objArr[i] = obj;
                    return obj2;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            switch (this.$r8$classId) {
                case 0:
                    return ((MutableObjectList) this.objectList)._size;
                default:
                    return ((MutableVector) this.objectList).size;
            }
        }

        @Override // java.util.List
        public final List subList(int i, int i2) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkSubIndex(this, i, i2);
                    return new SubList(this, i, i2, 0);
                default:
                    MutableVectorKt.checkSubIndex(this, i, i2);
                    return new SubList(this, i, i2, 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return Intrinsics.Kotlin.toArray(this);
        }

        @Override // java.util.List
        public final void add(int i, Object obj) {
            int i2;
            switch (this.$r8$classId) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) this.objectList;
                    if (i >= 0 && i <= (i2 = mutableObjectList._size)) {
                        int i3 = i2 + 1;
                        Object[] objArr = mutableObjectList.content;
                        if (objArr.length < i3) {
                            mutableObjectList.resizeStorage(i3, objArr);
                        }
                        Object[] objArr2 = mutableObjectList.content;
                        int i4 = mutableObjectList._size;
                        if (i != i4) {
                            ArraysKt.copyInto(objArr2, objArr2, i + 1, i, i4);
                        }
                        objArr2[i] = obj;
                        mutableObjectList._size++;
                        return;
                    }
                    StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Index ", " must be in 0..");
                    sbM.append(mutableObjectList._size);
                    RuntimeHelpersKt.throwIndexOutOfBoundsException(sbM.toString());
                    throw null;
                default:
                    ((MutableVector) this.objectList).add(i, obj);
                    return;
            }
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, i, 0);
                default:
                    return new MutableObjectListIterator(this, i, 1);
            }
        }

        @Override // java.util.List
        public final Object remove(int i) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkIndex(i, this);
                    return ((MutableObjectList) this.objectList).removeAt(i);
                default:
                    MutableVectorKt.checkIndex(i, this);
                    return ((MutableVector) this.objectList).removeAt(i);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return Intrinsics.Kotlin.toArray(this, objArr);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) this.objectList;
                    int i = mutableObjectList._size;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        mutableObjectList.add(it.next());
                    }
                    return i != mutableObjectList._size;
                default:
                    MutableVector mutableVector = (MutableVector) this.objectList;
                    return mutableVector.addAll(mutableVector.size, collection);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SubList implements List, KMutableCollection {
        public final /* synthetic */ int $r8$classId;
        public int end;
        public final Object list;
        public final int start;

        public /* synthetic */ SubList(List list, int i, int i2, int i3) {
            this.$r8$classId = i3;
            this.list = list;
            this.start = i;
            this.end = i2;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean add(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end;
                    this.end = i + 1;
                    this.list.add(i, obj);
                    break;
                default:
                    int i2 = this.end;
                    this.end = i2 + 1;
                    this.list.add(i2, obj);
                    break;
            }
            return true;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final boolean addAll(int i, Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    this.list.addAll(i + this.start, collection);
                    this.end = collection.size() + this.end;
                    return collection.size() > 0;
                default:
                    this.list.addAll(i + this.start, collection);
                    int size = collection.size();
                    this.end += size;
                    return size > 0;
            }
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final void clear() {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end - 1;
                    int i2 = this.start;
                    if (i2 <= i) {
                        while (true) {
                            this.list.remove(i);
                            if (i != i2) {
                                i--;
                            }
                        }
                    }
                    this.end = i2;
                    break;
                default:
                    int i3 = this.end - 1;
                    int i4 = this.start;
                    if (i4 <= i3) {
                        while (true) {
                            this.list.remove(i3);
                            if (i3 != i4) {
                                i3--;
                            }
                        }
                    }
                    this.end = i4;
                    break;
            }
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end;
                    for (int i2 = this.start; i2 < i; i2++) {
                        if (Intrinsics.areEqual(this.list.get(i2), obj)) {
                            return true;
                        }
                    }
                    return false;
                default:
                    int i3 = this.end;
                    for (int i4 = this.start; i4 < i3; i4++) {
                        if (Intrinsics.areEqual(this.list.get(i4), obj)) {
                            return true;
                        }
                    }
                    return false;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                default:
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        if (!contains(it2.next())) {
                            return false;
                        }
                    }
                    return true;
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final Object get(int i) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkIndex(i, this);
                    return this.list.get(i + this.start);
                default:
                    MutableVectorKt.checkIndex(i, this);
                    return this.list.get(i + this.start);
            }
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final int indexOf(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end;
                    int i2 = this.start;
                    for (int i3 = i2; i3 < i; i3++) {
                        if (Intrinsics.areEqual(this.list.get(i3), obj)) {
                            return i3 - i2;
                        }
                    }
                    return -1;
                default:
                    int i4 = this.end;
                    int i5 = this.start;
                    for (int i6 = i5; i6 < i4; i6++) {
                        if (Intrinsics.areEqual(this.list.get(i6), obj)) {
                            return i6 - i5;
                        }
                    }
                    return -1;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            switch (this.$r8$classId) {
                case 0:
                    return this.end == this.start;
                default:
                    return this.end == this.start;
            }
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, 0);
                default:
                    return new MutableObjectListIterator(this, 0, 1);
            }
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end - 1;
                    int i2 = this.start;
                    if (i2 <= i) {
                        while (!Intrinsics.areEqual(this.list.get(i), obj)) {
                            if (i != i2) {
                                i--;
                            }
                        }
                        return i - i2;
                    }
                    return -1;
                default:
                    int i3 = this.end - 1;
                    int i4 = this.start;
                    if (i4 <= i3) {
                        while (!Intrinsics.areEqual(this.list.get(i3), obj)) {
                            if (i3 != i4) {
                                i3--;
                            }
                        }
                        return i3 - i4;
                    }
                    return -1;
            }
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, 0);
                default:
                    return new MutableObjectListIterator(this, 0, 1);
            }
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end;
                    for (int i2 = this.start; i2 < i; i2++) {
                        ?? r2 = this.list;
                        if (Intrinsics.areEqual(r2.get(i2), obj)) {
                            r2.remove(i2);
                            this.end--;
                            return true;
                        }
                    }
                    return false;
                default:
                    int i3 = this.end;
                    for (int i4 = this.start; i4 < i3; i4++) {
                        ?? r3 = this.list;
                        if (Intrinsics.areEqual(r3.get(i4), obj)) {
                            r3.remove(i4);
                            this.end--;
                            return true;
                        }
                    }
                    return false;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        remove(it.next());
                    }
                    return i != this.end;
                default:
                    int i2 = this.end;
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        remove(it2.next());
                    }
                    return i2 != this.end;
            }
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.end;
                    int i2 = i - 1;
                    int i3 = this.start;
                    if (i3 <= i2) {
                        while (true) {
                            ?? r3 = this.list;
                            if (!collection.contains(r3.get(i2))) {
                                r3.remove(i2);
                                this.end--;
                            }
                            if (i2 != i3) {
                                i2--;
                            }
                        }
                    }
                    return i != this.end;
                default:
                    int i4 = this.end;
                    int i5 = i4 - 1;
                    int i6 = this.start;
                    if (i6 <= i5) {
                        while (true) {
                            ?? r4 = this.list;
                            if (!collection.contains(r4.get(i5))) {
                                r4.remove(i5);
                                this.end--;
                            }
                            if (i5 != i6) {
                                i5--;
                            }
                        }
                    }
                    return i4 != this.end;
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final Object set(int i, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkIndex(i, this);
                    return this.list.set(i + this.start, obj);
                default:
                    MutableVectorKt.checkIndex(i, this);
                    return this.list.set(i + this.start, obj);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            int i;
            int i2;
            switch (this.$r8$classId) {
                case 0:
                    i = this.end;
                    i2 = this.start;
                    break;
                default:
                    i = this.end;
                    i2 = this.start;
                    break;
            }
            return i - i2;
        }

        @Override // java.util.List
        public final List subList(int i, int i2) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkSubIndex(this, i, i2);
                    return new SubList(this, i, i2, 0);
                default:
                    MutableVectorKt.checkSubIndex(this, i, i2);
                    return new SubList(this, i, i2, 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return Intrinsics.Kotlin.toArray(this);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final void add(int i, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    this.list.add(i + this.start, obj);
                    this.end++;
                    break;
                default:
                    this.list.add(i + this.start, obj);
                    this.end++;
                    break;
            }
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, i, 0);
                default:
                    return new MutableObjectListIterator(this, i, 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return Intrinsics.Kotlin.toArray(this, objArr);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    this.list.addAll(this.end, collection);
                    this.end = collection.size() + this.end;
                    return collection.size() > 0;
                default:
                    this.list.addAll(this.end, collection);
                    int size = collection.size();
                    this.end += size;
                    return size > 0;
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.List] */
        @Override // java.util.List
        public final Object remove(int i) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.access$checkIndex(i, this);
                    Object objRemove = this.list.remove(i + this.start);
                    this.end--;
                    return objRemove;
                default:
                    MutableVectorKt.checkIndex(i, this);
                    Object objRemove2 = this.list.remove(i + this.start);
                    this.end--;
                    return objRemove2;
            }
        }
    }

    public /* synthetic */ MutableObjectList() {
        this(16);
    }

    public final void addAll(List list) {
        if (list.isEmpty()) {
            return;
        }
        int i = this._size;
        int size = list.size() + i;
        Object[] objArr = this.content;
        if (objArr.length < size) {
            resizeStorage(size, objArr);
        }
        Object[] objArr2 = this.content;
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            objArr2[i2 + i] = list.get(i2);
        }
        this._size = list.size() + this._size;
    }
}
