package kotlin.collections;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayDeque extends AbstractMutableList {
    public static final Object[] emptyElementData = new Object[0];
    public Object[] elementData;
    public int head;
    public int size;

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        registerModification();
        ensureCapacity$1(this.size + 1);
        int iPositiveMod = positiveMod(this.head + i);
        int i3 = this.size;
        if (i < ((i3 + 1) >> 1)) {
            int length = iPositiveMod == 0 ? this.elementData.length - 1 : iPositiveMod - 1;
            int i4 = this.head;
            int length2 = i4 == 0 ? this.elementData.length - 1 : i4 - 1;
            if (length >= i4) {
                Object[] objArr = this.elementData;
                objArr[length2] = objArr[i4];
                ArraysKt.copyInto(objArr, objArr, i4, i4 + 1, length + 1);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.copyInto(objArr2, objArr2, i4 - 1, i4, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt.copyInto(objArr3, objArr3, 0, 1, length + 1);
            }
            this.elementData[length] = obj;
            this.head = length2;
        } else {
            int iPositiveMod2 = positiveMod(i3 + this.head);
            if (iPositiveMod < iPositiveMod2) {
                Object[] objArr4 = this.elementData;
                ArraysKt.copyInto(objArr4, objArr4, iPositiveMod + 1, iPositiveMod, iPositiveMod2);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, 1, 0, iPositiveMod2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt.copyInto(objArr6, objArr6, iPositiveMod + 1, iPositiveMod, objArr6.length - 1);
            }
            this.elementData[iPositiveMod] = obj;
        }
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.size) {
            return addAll(collection);
        }
        registerModification();
        ensureCapacity$1(collection.size() + this.size);
        int iPositiveMod = positiveMod(this.size + this.head);
        int iPositiveMod2 = positiveMod(this.head + i);
        int size = collection.size();
        if (i >= ((this.size + 1) >> 1)) {
            int i3 = iPositiveMod2 + size;
            if (iPositiveMod2 < iPositiveMod) {
                int i4 = size + iPositiveMod;
                Object[] objArr = this.elementData;
                if (i4 <= objArr.length) {
                    ArraysKt.copyInto(objArr, objArr, i3, iPositiveMod2, iPositiveMod);
                } else if (i3 >= objArr.length) {
                    ArraysKt.copyInto(objArr, objArr, i3 - objArr.length, iPositiveMod2, iPositiveMod);
                } else {
                    int length = iPositiveMod - (i4 - objArr.length);
                    ArraysKt.copyInto(objArr, objArr, 0, length, iPositiveMod);
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2, i3, iPositiveMod2, length);
                }
            } else {
                Object[] objArr3 = this.elementData;
                ArraysKt.copyInto(objArr3, objArr3, size, 0, iPositiveMod);
                Object[] objArr4 = this.elementData;
                if (i3 >= objArr4.length) {
                    ArraysKt.copyInto(objArr4, objArr4, i3 - objArr4.length, iPositiveMod2, objArr4.length);
                } else {
                    ArraysKt.copyInto(objArr4, objArr4, 0, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto(objArr5, objArr5, i3, iPositiveMod2, objArr5.length - size);
                }
            }
            copyCollectionElements(iPositiveMod2, collection);
            return true;
        }
        int i5 = this.head;
        int length2 = i5 - size;
        if (iPositiveMod2 < i5) {
            Object[] objArr6 = this.elementData;
            ArraysKt.copyInto(objArr6, objArr6, length2, i5, objArr6.length);
            if (size >= iPositiveMod2) {
                Object[] objArr7 = this.elementData;
                ArraysKt.copyInto(objArr7, objArr7, objArr7.length - size, 0, iPositiveMod2);
            } else {
                Object[] objArr8 = this.elementData;
                ArraysKt.copyInto(objArr8, objArr8, objArr8.length - size, 0, size);
                Object[] objArr9 = this.elementData;
                ArraysKt.copyInto(objArr9, objArr9, 0, size, iPositiveMod2);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.elementData;
            ArraysKt.copyInto(objArr10, objArr10, length2, i5, iPositiveMod2);
        } else {
            Object[] objArr11 = this.elementData;
            length2 += objArr11.length;
            int i6 = iPositiveMod2 - i5;
            int length3 = objArr11.length - length2;
            if (length3 >= i6) {
                ArraysKt.copyInto(objArr11, objArr11, length2, i5, iPositiveMod2);
            } else {
                ArraysKt.copyInto(objArr11, objArr11, length2, i5, i5 + length3);
                Object[] objArr12 = this.elementData;
                ArraysKt.copyInto(objArr12, objArr12, 0, this.head + length3, iPositiveMod2);
            }
        }
        this.head = length2;
        copyCollectionElements(negativeMod(iPositiveMod2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        registerModification();
        ensureCapacity$1(this.size + 1);
        int length = this.head;
        if (length == 0) {
            length = this.elementData.length;
        }
        int i = length - 1;
        this.head = i;
        this.elementData[i] = obj;
        this.size++;
    }

    public final void addLast(Object obj) {
        registerModification();
        ensureCapacity$1(getSize() + 1);
        this.elementData[positiveMod(getSize() + this.head)] = obj;
        this.size = getSize() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(getSize() + this.head));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void copyCollectionElements(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.elementData.length;
        while (i < length && it.hasNext()) {
            this.elementData[i] = it.next();
            i++;
        }
        int i2 = this.head;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.elementData[i3] = it.next();
        }
        this.size = collection.size() + this.size;
    }

    public final void ensureCapacity$1(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            if (i < 10) {
                i = 10;
            }
            this.elementData = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        ArraysKt.copyInto(objArr, objArr2, 0, this.head, objArr.length);
        Object[] objArr3 = this.elementData;
        int length2 = objArr3.length;
        int i3 = this.head;
        ArraysKt.copyInto(objArr3, objArr2, length2 - i3, 0, i3);
        this.head = 0;
        this.elementData = objArr2;
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.elementData[this.head];
    }

    public final Object firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int size = getSize();
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, size, "index: ", ", size: "));
        }
        return this.elementData[positiveMod(this.head + i)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.size;
    }

    public final int incremented(int i) {
        if (i == this.elementData.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iPositiveMod = positiveMod(getSize() + this.head);
        int length = this.head;
        if (length < iPositiveMod) {
            while (length < iPositiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[length])) {
                    i = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iPositiveMod) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (length < length2) {
            if (Intrinsics.areEqual(obj, this.elementData[length])) {
                i = this.head;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iPositiveMod; i2++) {
            if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                length = i2 + this.elementData.length;
                i = this.head;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.elementData[positiveMod(AppCompatHintHelper.getLastIndex(this) + this.head)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iPositiveMod = positiveMod(getSize() + this.head);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            length = iPositiveMod - 1;
            if (i2 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
            return -1;
        }
        if (i2 > iPositiveMod) {
            for (int i3 = iPositiveMod - 1; -1 < i3; i3--) {
                if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                    length = i3 + this.elementData.length;
                    i = this.head;
                    return length - i;
                }
            }
            length = this.elementData.length - 1;
            int i4 = this.head;
            if (i4 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i4) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
        }
        return -1;
    }

    public final Object lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[positiveMod(AppCompatHintHelper.getLastIndex(this) + this.head)];
    }

    public final int negativeMod(int i) {
        return i < 0 ? i + this.elementData.length : i;
    }

    public final void nullifyNonEmpty(int i, int i2) {
        if (i < i2) {
            Arrays.fill(this.elementData, i, i2, (Object) null);
            return;
        }
        Object[] objArr = this.elementData;
        Arrays.fill(objArr, i, objArr.length, (Object) null);
        Arrays.fill(this.elementData, 0, i2, (Object) null);
    }

    public final int positiveMod(int i) {
        Object[] objArr = this.elementData;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void registerModification() {
        ((java.util.AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iPositiveMod;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(getSize() + this.head);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (i < iPositiveMod2) {
                    Object obj = this.elementData[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    }
                    i++;
                }
                Arrays.fill(this.elementData, iPositiveMod, iPositiveMod2, (Object) null);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.elementData[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(iPositiveMod - this.head);
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
        if (i == AppCompatHintHelper.getLastIndex(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        registerModification();
        int iPositiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj = objArr[iPositiveMod];
        if (i < (this.size >> 1)) {
            int i3 = this.head;
            if (iPositiveMod >= i3) {
                ArraysKt.copyInto(objArr, objArr, i3 + 1, i3, iPositiveMod);
            } else {
                ArraysKt.copyInto(objArr, objArr, 1, 0, iPositiveMod);
                Object[] objArr2 = this.elementData;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i4 = this.head;
                ArraysKt.copyInto(objArr2, objArr2, i4 + 1, i4, objArr2.length - 1);
            }
            Object[] objArr3 = this.elementData;
            int i5 = this.head;
            objArr3[i5] = null;
            this.head = incremented(i5);
        } else {
            int iPositiveMod2 = positiveMod(AppCompatHintHelper.getLastIndex(this) + this.head);
            if (iPositiveMod <= iPositiveMod2) {
                Object[] objArr4 = this.elementData;
                ArraysKt.copyInto(objArr4, objArr4, iPositiveMod, iPositiveMod + 1, iPositiveMod2 + 1);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, iPositiveMod, iPositiveMod + 1, objArr5.length);
                Object[] objArr6 = this.elementData;
                objArr6[objArr6.length - 1] = objArr6[0];
                ArraysKt.copyInto(objArr6, objArr6, 0, 1, iPositiveMod2 + 1);
            }
            this.elementData[iPositiveMod2] = null;
        }
        this.size--;
        return obj;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        Object[] objArr = this.elementData;
        int i = this.head;
        Object obj = objArr[i];
        objArr[i] = null;
        this.head = incremented(i);
        this.size = getSize() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int iPositiveMod = positiveMod(AppCompatHintHelper.getLastIndex(this) + this.head);
        Object[] objArr = this.elementData;
        Object obj = objArr[iPositiveMod];
        objArr[iPositiveMod] = null;
        this.size = getSize() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this.size);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.size) {
            clear();
            return;
        }
        if (i3 == 1) {
            removeAt(i);
            return;
        }
        registerModification();
        if (i < this.size - i2) {
            int iPositiveMod = positiveMod(this.head + (i - 1));
            int iPositiveMod2 = positiveMod(this.head + (i2 - 1));
            while (i > 0) {
                int i4 = iPositiveMod + 1;
                int iMin = Math.min(i, Math.min(i4, iPositiveMod2 + 1));
                Object[] objArr = this.elementData;
                int i5 = iPositiveMod2 - iMin;
                int i6 = iPositiveMod - iMin;
                ArraysKt.copyInto(objArr, objArr, i5 + 1, i6 + 1, i4);
                iPositiveMod = negativeMod(i6);
                iPositiveMod2 = negativeMod(i5);
                i -= iMin;
            }
            int iPositiveMod3 = positiveMod(this.head + i3);
            nullifyNonEmpty(this.head, iPositiveMod3);
            this.head = iPositiveMod3;
        } else {
            int iPositiveMod4 = positiveMod(this.head + i2);
            int iPositiveMod5 = positiveMod(this.head + i);
            int i7 = this.size;
            while (true) {
                i7 -= i2;
                if (i7 <= 0) {
                    break;
                }
                Object[] objArr2 = this.elementData;
                i2 = Math.min(i7, Math.min(objArr2.length - iPositiveMod4, objArr2.length - iPositiveMod5));
                Object[] objArr3 = this.elementData;
                int i8 = iPositiveMod4 + i2;
                ArraysKt.copyInto(objArr3, objArr3, iPositiveMod5, iPositiveMod4, i8);
                iPositiveMod4 = positiveMod(i8);
                iPositiveMod5 = positiveMod(iPositiveMod5 + i2);
            }
            int iPositiveMod6 = positiveMod(this.size + this.head);
            nullifyNonEmpty(negativeMod(iPositiveMod6 - i3), iPositiveMod6);
        }
        this.size -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iPositiveMod;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(getSize() + this.head);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (i < iPositiveMod2) {
                    Object obj = this.elementData[i];
                    if (collection.contains(obj)) {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Arrays.fill(this.elementData, iPositiveMod, iPositiveMod2, (Object) null);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.elementData[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(iPositiveMod - this.head);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int size = getSize();
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, size, "index: ", ", size: "));
        }
        int iPositiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj2 = objArr[iPositiveMod];
        objArr[iPositiveMod] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[getSize()]);
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = emptyElementData;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Illegal Capacity: ", i));
        }
        this.elementData = objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.size;
        if (length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        int iPositiveMod = positiveMod(this.size + this.head);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            ArraysKt.copyInto$default(this.elementData, objArr, i2, iPositiveMod, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
            Object[] objArr3 = this.elementData;
            ArraysKt.copyInto(objArr3, objArr, objArr3.length - this.head, 0, iPositiveMod);
        }
        int i3 = this.size;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity$1(collection.size() + getSize());
        copyCollectionElements(positiveMod(getSize() + this.head), collection);
        return true;
    }
}
