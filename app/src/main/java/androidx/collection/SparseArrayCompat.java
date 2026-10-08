package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayCompat implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat(int i) {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.keys = new int[i5];
        this.values = new Object[i5];
    }

    public final void append(int i, Object obj) {
        int i2 = this.size;
        if (i2 != 0 && i <= this.keys[i2 - 1]) {
            put(i, obj);
            return;
        }
        if (this.garbage && i2 >= this.keys.length) {
            ArraySetKt.access$gc(this);
        }
        int i3 = this.size;
        if (i3 >= this.keys.length) {
            int i4 = (i3 + 1) * 4;
            for (int i5 = 4; i5 < 32; i5++) {
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
            }
            int i7 = i4 / 4;
            this.keys = Arrays.copyOf(this.keys, i7);
            this.values = Arrays.copyOf(this.values, i7);
        }
        this.keys[i3] = i;
        this.values[i3] = obj;
        this.size = i3 + 1;
    }

    public final Object get(int i) {
        Object obj;
        int iBinarySearch = RuntimeHelpersKt.binarySearch(this.size, i, this.keys);
        if (iBinarySearch < 0 || (obj = this.values[iBinarySearch]) == ArraySetKt.DELETED$1) {
            return null;
        }
        return obj;
    }

    public final int keyAt(int i) {
        if (this.garbage) {
            ArraySetKt.access$gc(this);
        }
        return this.keys[i];
    }

    public final void put(int i, Object obj) {
        int iBinarySearch = RuntimeHelpersKt.binarySearch(this.size, i, this.keys);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = obj;
            return;
        }
        int i2 = ~iBinarySearch;
        int i3 = this.size;
        if (i2 < i3) {
            Object[] objArr = this.values;
            if (objArr[i2] == ArraySetKt.DELETED$1) {
                this.keys[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.garbage && i3 >= this.keys.length) {
            ArraySetKt.access$gc(this);
            i2 = ~RuntimeHelpersKt.binarySearch(this.size, i, this.keys);
        }
        int i4 = this.size;
        if (i4 >= this.keys.length) {
            int i5 = (i4 + 1) * 4;
            for (int i6 = 4; i6 < 32; i6++) {
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
            }
            int i8 = i5 / 4;
            this.keys = Arrays.copyOf(this.keys, i8);
            this.values = Arrays.copyOf(this.values, i8);
        }
        int i9 = this.size;
        if (i9 - i2 != 0) {
            int[] iArr = this.keys;
            int i10 = i2 + 1;
            ArraysKt.copyInto(i10, i2, i9, iArr, iArr);
            Object[] objArr2 = this.values;
            ArraysKt.copyInto(objArr2, objArr2, i10, i2, this.size);
        }
        this.keys[i2] = i;
        this.values[i2] = obj;
        this.size++;
    }

    public final int size() {
        if (this.garbage) {
            ArraySetKt.access$gc(this);
        }
        return this.size;
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            Object objValueAt = valueAt(i2);
            if (objValueAt != this) {
                sb.append(objValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object valueAt(int i) {
        if (this.garbage) {
            ArraySetKt.access$gc(this);
        }
        Object[] objArr = this.values;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final SparseArrayCompat m23clone() {
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) super.clone();
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }
}
