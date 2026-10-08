package kotlin;

import androidx.collection.SparseArrayCompat;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.internal.EnumDescriptor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UIntArray implements Collection, KMappedMarker {
    public final int[] storage;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class Iterator implements java.util.Iterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;
        public final Object array;
        public int index;

        public /* synthetic */ Iterator(int i, Object obj) {
            this.$r8$classId = i;
            this.array = obj;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    return this.index < ((int[]) this.array).length;
                case 1:
                    return this.index < ((SparseArrayCompat) this.array).size();
                case 2:
                    return this.index < ((byte[]) this.array).length;
                case 3:
                    return this.index < ((long[]) this.array).length;
                case 4:
                    return this.index < ((short[]) this.array).length;
                case 5:
                    return this.index < ((AbstractList) this.array).getSize();
                case 6:
                    return this.index < ((Object[]) this.array).length;
                default:
                    return this.index > 0;
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.index;
                    int[] iArr = (int[]) this.array;
                    if (i >= iArr.length) {
                        throw new NoSuchElementException(String.valueOf(this.index));
                    }
                    this.index = i + 1;
                    return new UInt(iArr[i]);
                case 1:
                    SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.array;
                    int i2 = this.index;
                    this.index = i2 + 1;
                    return sparseArrayCompat.valueAt(i2);
                case 2:
                    int i3 = this.index;
                    byte[] bArr = (byte[]) this.array;
                    if (i3 >= bArr.length) {
                        throw new NoSuchElementException(String.valueOf(this.index));
                    }
                    this.index = i3 + 1;
                    return new UByte(bArr[i3]);
                case 3:
                    int i4 = this.index;
                    long[] jArr = (long[]) this.array;
                    if (i4 >= jArr.length) {
                        throw new NoSuchElementException(String.valueOf(this.index));
                    }
                    this.index = i4 + 1;
                    return new ULong(jArr[i4]);
                case 4:
                    int i5 = this.index;
                    short[] sArr = (short[]) this.array;
                    if (i5 >= sArr.length) {
                        throw new NoSuchElementException(String.valueOf(this.index));
                    }
                    this.index = i5 + 1;
                    return new UShort(sArr[i5]);
                case 5:
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    AbstractList abstractList = (AbstractList) this.array;
                    int i6 = this.index;
                    this.index = i6 + 1;
                    return abstractList.get(i6);
                case 6:
                    try {
                        Object[] objArr = (Object[]) this.array;
                        int i7 = this.index;
                        this.index = i7 + 1;
                        return objArr[i7];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        this.index--;
                        throw new NoSuchElementException(e.getMessage());
                    }
                default:
                    EnumDescriptor enumDescriptor = (EnumDescriptor) this.array;
                    int i8 = enumDescriptor.elementsCount;
                    int i9 = this.index;
                    this.index = i9 - 1;
                    return enumDescriptor.names[i8 - i9];
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 1:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 2:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 3:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 4:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 5:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 6:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public Iterator(EnumDescriptor enumDescriptor) {
            this.$r8$classId = 7;
            this.array = enumDescriptor;
            this.index = enumDescriptor.elementsCount;
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return ArraysKt.contains(this.storage, ((UInt) obj).data);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof UInt)) {
                return false;
            }
            if (!ArraysKt.contains(this.storage, ((UInt) obj).data)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof UIntArray) {
            return Intrinsics.areEqual(this.storage, ((UIntArray) obj).storage);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.storage);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.storage.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator iterator() {
        return new Iterator(0, this.storage);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.storage.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.storage) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }
}
