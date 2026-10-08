package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableLongObjectMap {
    public int _capacity;
    public int _size;
    public int growthLimit;
    public long[] keys;
    public long[] metadata;
    public Object[] values;

    public MutableLongObjectMap(int i) {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.EmptyLongArray;
        this.values = RuntimeHelpersKt.EMPTY_OBJECTS;
        if (i >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i));
        } else {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
            throw null;
        }
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            Arrays.fill(jArr, 0, jArr.length, -9187201950435737472L);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        Arrays.fill(this.values, 0, this._capacity, (Object) null);
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
    }

    public final boolean containsKey(long j) {
        int iNumberOfTrailingZeros;
        int i = ((int) (j ^ (j >>> 32))) * (-862048943);
        int i2 = i ^ (i << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j2 = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j3 = (((long) i3) * 72340172838076673L) ^ j2;
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    break loop0;
                }
            }
            if ((j2 & ((~j2) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return iNumberOfTrailingZeros >= 0;
    }

    public final boolean equals(Object obj) {
        boolean z;
        long[] jArr;
        boolean z2;
        long[] jArr2;
        boolean z3 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MutableLongObjectMap)) {
            return false;
        }
        MutableLongObjectMap mutableLongObjectMap = (MutableLongObjectMap) obj;
        if (mutableLongObjectMap._size != this._size) {
            return false;
        }
        long[] jArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        loop0: while (true) {
            long j = jArr4[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                int i3 = 0;
                while (i3 < i2) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        z2 = z3;
                        jArr2 = jArr3;
                        long j2 = jArr2[i4];
                        Object obj2 = objArr[i4];
                        if (obj2 == null) {
                            if (mutableLongObjectMap.get(j2) != null || !mutableLongObjectMap.containsKey(j2)) {
                                break loop0;
                            }
                        } else if (!obj2.equals(mutableLongObjectMap.get(j2))) {
                            return false;
                        }
                    } else {
                        z2 = z3;
                        jArr2 = jArr3;
                    }
                    j >>= 8;
                    i3++;
                    z3 = z2;
                    jArr3 = jArr2;
                }
                z = z3;
                jArr = jArr3;
                if (i2 != 8) {
                    return z;
                }
            } else {
                z = z3;
                jArr = jArr3;
            }
            if (i == length) {
                return z;
            }
            i++;
            z3 = z;
            jArr3 = jArr;
        }
        return false;
    }

    public final int findAbsoluteInsertIndex(long j) {
        long j2;
        int i;
        long j3;
        long[] jArr;
        long[] jArr2;
        char c = ' ';
        int i2 = -862048943;
        int i3 = ((int) (j ^ (j >>> 32))) * (-862048943);
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 >>> 7;
        int i6 = i4 & 127;
        int i7 = this._capacity;
        int i8 = i5 & i7;
        int i9 = 0;
        while (true) {
            long[] jArr3 = this.metadata;
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            int i12 = 1;
            int i13 = i9;
            long j4 = (((-i11) >> 63) & (jArr3[i10 + 1] << (64 - i11))) | (jArr3[i10] >>> i11);
            long j5 = i6;
            char c2 = c;
            int i14 = i6;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            long j7 = -9187201950435737472L;
            long j8 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (j8 != 0) {
                int iNumberOfTrailingZeros = (i8 + (Long.numberOfTrailingZeros(j8) >> 3)) & i7;
                int i15 = i2;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    return iNumberOfTrailingZeros;
                }
                j8 &= j8 - 1;
                i2 = i15;
            }
            int i16 = i2;
            if ((((~j4) << 6) & j4 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i5);
                if (this.growthLimit != 0 || ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) == 254) {
                    j2 = 255;
                    i = 1;
                    j3 = 128;
                } else {
                    int i17 = this._capacity;
                    if (i17 > 8) {
                        j3 = 128;
                        if (Long.compare((((long) this._size) * 32) ^ Long.MIN_VALUE, (((long) i17) * 25) ^ Long.MIN_VALUE) <= 0) {
                            long[] jArr4 = this.metadata;
                            int i18 = this._capacity;
                            long[] jArr5 = this.keys;
                            Object[] objArr = this.values;
                            int i19 = (i18 + 7) >> 3;
                            j2 = 255;
                            int i20 = 0;
                            while (i20 < i19) {
                                long j9 = j7;
                                long j10 = jArr4[i20] & j9;
                                jArr4[i20] = (-72340172838076674L) & ((~j10) + (j10 >>> 7));
                                i20++;
                                i12 = i12;
                                c2 = c2;
                                j7 = j9;
                            }
                            char c3 = c2;
                            int i21 = i12;
                            int length = jArr4.length;
                            int i22 = length - 1;
                            int i23 = length - 2;
                            long j11 = 72057594037927935L;
                            jArr4[i23] = (jArr4[i23] & 72057594037927935L) | (-72057594037927936L);
                            jArr4[i22] = jArr4[0];
                            int i24 = 0;
                            while (i24 != i18) {
                                int i25 = i24 >> 3;
                                int i26 = (i24 & 7) << 3;
                                long j12 = (jArr4[i25] >> i26) & 255;
                                if (j12 != 128 && j12 == 254) {
                                    long j13 = jArr5[i24];
                                    int i27 = ((int) (j13 ^ (j13 >>> c3))) * i16;
                                    int i28 = i27 ^ (i27 << 16);
                                    int i29 = i28 >>> 7;
                                    int iFindFirstAvailableSlot2 = findFirstAvailableSlot(i29);
                                    int i30 = i29 & i18;
                                    int i31 = i21;
                                    if (((iFindFirstAvailableSlot2 - i30) & i18) / 8 == ((i24 - i30) & i18) / 8) {
                                        long j14 = j11;
                                        jArr4[i25] = (((long) (i28 & 127)) << i26) | (jArr4[i25] & (~(255 << i26)));
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j14) | Long.MIN_VALUE;
                                        i24++;
                                        i21 = i31;
                                        j11 = j14;
                                    } else {
                                        long j15 = j11;
                                        int i32 = iFindFirstAvailableSlot2 >> 3;
                                        long j16 = jArr4[i32];
                                        int i33 = (iFindFirstAvailableSlot2 & 7) << 3;
                                        if (((j16 >> i33) & 255) == 128) {
                                            jArr2 = jArr5;
                                            jArr4[i32] = ((~(255 << i33)) & j16) | (((long) (i28 & 127)) << i33);
                                            jArr4[i25] = (jArr4[i25] & (~(255 << i26))) | (128 << i26);
                                            jArr2[iFindFirstAvailableSlot2] = jArr2[i24];
                                            jArr2[i24] = 0;
                                            objArr[iFindFirstAvailableSlot2] = objArr[i24];
                                            objArr[i24] = null;
                                        } else {
                                            jArr2 = jArr5;
                                            jArr4[i32] = ((~(255 << i33)) & j16) | (((long) (i28 & 127)) << i33);
                                            long j17 = jArr2[iFindFirstAvailableSlot2];
                                            jArr2[iFindFirstAvailableSlot2] = jArr2[i24];
                                            jArr2[i24] = j17;
                                            Object obj = objArr[iFindFirstAvailableSlot2];
                                            objArr[iFindFirstAvailableSlot2] = objArr[i24];
                                            objArr[i24] = obj;
                                            i24--;
                                        }
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j15) | Long.MIN_VALUE;
                                        i24++;
                                        i18 = i18;
                                        i21 = i31;
                                        j11 = j15;
                                        jArr5 = jArr2;
                                    }
                                } else {
                                    i24++;
                                }
                            }
                            i = i21;
                            this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
                        }
                        iFindFirstAvailableSlot = findFirstAvailableSlot(i5);
                    } else {
                        j3 = 128;
                    }
                    j2 = 255;
                    i = 1;
                    int iNextCapacity = ScatterMapKt.nextCapacity(this._capacity);
                    long[] jArr6 = this.metadata;
                    long[] jArr7 = this.keys;
                    Object[] objArr2 = this.values;
                    int i34 = this._capacity;
                    initializeStorage(iNextCapacity);
                    long[] jArr8 = this.metadata;
                    long[] jArr9 = this.keys;
                    Object[] objArr3 = this.values;
                    int i35 = this._capacity;
                    int i36 = 0;
                    while (i36 < i34) {
                        if (((jArr6[i36 >> 3] >> ((i36 & 7) << 3)) & 255) < j3) {
                            long j18 = jArr7[i36];
                            jArr = jArr8;
                            int i37 = ((int) (j18 ^ (j18 >>> c2))) * i16;
                            int i38 = i37 ^ (i37 << 16);
                            int iFindFirstAvailableSlot3 = findFirstAvailableSlot(i38 >>> 7);
                            int i39 = iFindFirstAvailableSlot3 >> 3;
                            int i40 = (iFindFirstAvailableSlot3 & 7) << 3;
                            long j19 = (jArr[i39] & (~(255 << i40))) | (((long) (i38 & 127)) << i40);
                            jArr[i39] = j19;
                            jArr[(((iFindFirstAvailableSlot3 - 7) & i35) + (i35 & 7)) >> 3] = j19;
                            jArr9[iFindFirstAvailableSlot3] = j18;
                            objArr3[iFindFirstAvailableSlot3] = objArr2[i36];
                        } else {
                            jArr = jArr8;
                        }
                        i36++;
                        jArr6 = jArr6;
                        jArr8 = jArr;
                    }
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i5);
                }
                this._size++;
                int i41 = this.growthLimit;
                long[] jArr10 = this.metadata;
                int i42 = iFindFirstAvailableSlot >> 3;
                long j20 = jArr10[i42];
                int i43 = (iFindFirstAvailableSlot & 7) << 3;
                if (((j20 >> i43) & j2) != j3) {
                    i = 0;
                }
                this.growthLimit = i41 - i;
                int i44 = this._capacity;
                long j21 = (j20 & (~(j2 << i43))) | (j5 << i43);
                jArr10[i42] = j21;
                jArr10[(((iFindFirstAvailableSlot - 7) & i44) + (i44 & 7)) >> 3] = j21;
                return iFindFirstAvailableSlot;
            }
            i9 = i13 + 8;
            i8 = (i8 + i9) & i7;
            i6 = i14;
            i2 = i16;
            c = c2;
        }
    }

    public final int findFirstAvailableSlot(int i) {
        int i2 = this._capacity;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    public final Object get(long j) {
        int iNumberOfTrailingZeros;
        int i = ((int) ((j >>> 32) ^ j)) * (-862048943);
        int i2 = i ^ (i << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j2 = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j3 = (((long) i3) * 72340172838076673L) ^ j2;
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    break loop0;
                }
            }
            if ((j2 & ((~j2) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (iNumberOfTrailingZeros >= 0) {
            return this.values[iNumberOfTrailingZeros];
        }
        return null;
    }

    public final int hashCode() {
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        long j2 = jArr[i4];
                        Object obj = objArr[i4];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ ((int) (j2 ^ (j2 >>> 32)));
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    public final void initializeStorage(int i) {
        long[] jArr;
        int iMax = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = iMax;
        if (iMax == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            int i2 = ((iMax + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i2];
            Arrays.fill(jArr2, 0, i2, -9187201950435737472L);
            jArr = jArr2;
        }
        this.metadata = jArr;
        int i3 = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j)) | j;
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
        this.keys = new long[iMax];
        this.values = new Object[iMax];
    }

    public final Object remove(long j) {
        int iNumberOfTrailingZeros;
        int i = ((int) ((j >>> 32) ^ j)) * (-862048943);
        int i2 = i ^ (i << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j2 = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j3 = (((long) i3) * 72340172838076673L) ^ j2;
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    break loop0;
                }
            }
            if ((j2 & ((~j2) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (iNumberOfTrailingZeros < 0) {
            return null;
        }
        this._size--;
        long[] jArr2 = this.metadata;
        int i9 = this._capacity;
        int i10 = iNumberOfTrailingZeros >> 3;
        int i11 = (iNumberOfTrailingZeros & 7) << 3;
        long j5 = (jArr2[i10] & (~(255 << i11))) | (254 << i11);
        jArr2[i10] = j5;
        jArr2[(((iNumberOfTrailingZeros - 7) & i9) + (i9 & 7)) >> 3] = j5;
        Object[] objArr = this.values;
        Object obj = objArr[iNumberOfTrailingZeros];
        objArr[iNumberOfTrailingZeros] = null;
        return obj;
    }

    public final void set(long j, Object obj) {
        int iFindAbsoluteInsertIndex = findAbsoluteInsertIndex(j);
        this.keys[iFindAbsoluteInsertIndex] = j;
        this.values[iFindAbsoluteInsertIndex] = obj;
    }

    public final String toString() {
        int i;
        int i2;
        if (this._size == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((255 & j) < 128) {
                            int i7 = (i3 << 3) + i6;
                            i2 = i3;
                            long j2 = jArr[i7];
                            Object obj = objArr[i7];
                            sb.append(j2);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i4++;
                            if (i4 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i2 = i3;
                        }
                        j >>= 8;
                        i6++;
                        i3 = i2;
                    }
                    int i8 = i3;
                    if (i5 != 8) {
                        break;
                    }
                    i = i8;
                } else {
                    i = i3;
                }
                if (i == length) {
                    break;
                }
                i3 = i + 1;
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ MutableLongObjectMap() {
        this(6);
    }
}
