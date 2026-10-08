package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableLongIntMap {
    public int _capacity;
    public int _size;
    public int growthLimit;
    public long[] metadata = ScatterMapKt.EmptyGroup;
    public long[] keys = LongSetKt.EmptyLongArray;
    public int[] values = IntSetKt.EmptyIntArray;

    public MutableLongIntMap(int i) {
        if (i >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i));
        } else {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        long[] jArr;
        long[] jArr2;
        boolean z2 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MutableLongIntMap)) {
            return false;
        }
        MutableLongIntMap mutableLongIntMap = (MutableLongIntMap) obj;
        if (mutableLongIntMap._size != this._size) {
            return false;
        }
        long[] jArr3 = this.keys;
        int[] iArr = this.values;
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
                        jArr2 = jArr3;
                        long j2 = jArr2[i4];
                        int i5 = iArr[i4];
                        int iFindKeyIndex = mutableLongIntMap.findKeyIndex(j2);
                        if (iFindKeyIndex < 0 || i5 != mutableLongIntMap.values[iFindKeyIndex]) {
                            break loop0;
                        }
                    } else {
                        jArr2 = jArr3;
                    }
                    j >>= 8;
                    i3++;
                    z2 = z2;
                    jArr3 = jArr2;
                }
                z = z2;
                jArr = jArr3;
                if (i2 != 8) {
                    return z;
                }
            } else {
                z = z2;
                jArr = jArr3;
            }
            if (i == length) {
                return z;
            }
            i++;
            z2 = z;
            jArr3 = jArr;
        }
        return false;
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

    public final int findKeyIndex(long j) {
        int i = ((int) ((j >>> 32) ^ j)) * (-862048943);
        int i2 = i ^ (i << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j2 = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j3 = (((long) i3) * 72340172838076673L) ^ j2;
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j2 & ((~j2) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
    }

    public final int get(long j) {
        int iFindKeyIndex = findKeyIndex(j);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        RuntimeHelpersKt.throwNoSuchElementException("Cannot find value for key " + j);
        throw null;
    }

    public final int hashCode() {
        long[] jArr = this.keys;
        int[] iArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        long j2 = jArr[i5];
                        i2 += iArr[i5] ^ ((int) (j2 ^ (j2 >>> 32)));
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return i2;
                }
            }
            if (i == length) {
                return i2;
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
        this.values = new int[iMax];
    }

    public final void set(int i, long j) {
        long j2;
        int i2;
        long j3;
        int i3;
        long[] jArr;
        long[] jArr2;
        char c = ' ';
        int i4 = -862048943;
        int i5 = ((int) (j ^ (j >>> 32))) * (-862048943);
        int i6 = i5 ^ (i5 << 16);
        int i7 = i6 >>> 7;
        int i8 = i6 & 127;
        int i9 = this._capacity;
        int i10 = i7 & i9;
        int i11 = 0;
        loop0: while (true) {
            long[] jArr3 = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            int i14 = 1;
            int i15 = i11;
            long j4 = (((-i13) >> 63) & (jArr3[i12 + 1] << (64 - i13))) | (jArr3[i12] >>> i13);
            long j5 = i8;
            char c2 = c;
            int i16 = i8;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            long j7 = -9187201950435737472L;
            long j8 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (j8 != 0) {
                int iNumberOfTrailingZeros = (i10 + (Long.numberOfTrailingZeros(j8) >> 3)) & i9;
                int i17 = i4;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    i3 = iNumberOfTrailingZeros;
                    break loop0;
                } else {
                    j8 &= j8 - 1;
                    i4 = i17;
                }
            }
            int i18 = i4;
            if ((((~j4) << 6) & j4 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                if (this.growthLimit != 0 || ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) == 254) {
                    j2 = 255;
                    i2 = 1;
                    j3 = 128;
                } else {
                    int i19 = this._capacity;
                    if (i19 > 8) {
                        j3 = 128;
                        if (Long.compare((((long) this._size) * 32) ^ Long.MIN_VALUE, (((long) i19) * 25) ^ Long.MIN_VALUE) <= 0) {
                            long[] jArr4 = this.metadata;
                            int i20 = this._capacity;
                            long[] jArr5 = this.keys;
                            int[] iArr = this.values;
                            int i21 = (i20 + 7) >> 3;
                            j2 = 255;
                            int i22 = 0;
                            while (i22 < i21) {
                                long j9 = j7;
                                long j10 = jArr4[i22] & j9;
                                jArr4[i22] = (-72340172838076674L) & ((~j10) + (j10 >>> 7));
                                i22++;
                                i14 = i14;
                                c2 = c2;
                                j7 = j9;
                            }
                            char c3 = c2;
                            int i23 = i14;
                            int length = jArr4.length;
                            int i24 = length - 1;
                            int i25 = length - 2;
                            long j11 = 72057594037927935L;
                            jArr4[i25] = (jArr4[i25] & 72057594037927935L) | (-72057594037927936L);
                            jArr4[i24] = jArr4[0];
                            int i26 = 0;
                            while (i26 != i20) {
                                int i27 = i26 >> 3;
                                int i28 = (i26 & 7) << 3;
                                long j12 = (jArr4[i27] >> i28) & 255;
                                if (j12 != 128 && j12 == 254) {
                                    long j13 = jArr5[i26];
                                    int i29 = ((int) (j13 ^ (j13 >>> c3))) * i18;
                                    int i30 = i29 ^ (i29 << 16);
                                    int i31 = i30 >>> 7;
                                    int iFindFirstAvailableSlot2 = findFirstAvailableSlot(i31);
                                    int i32 = i31 & i20;
                                    int i33 = i23;
                                    if (((iFindFirstAvailableSlot2 - i32) & i20) / 8 == ((i26 - i32) & i20) / 8) {
                                        long j14 = j11;
                                        jArr4[i27] = (((long) (i30 & 127)) << i28) | (jArr4[i27] & (~(255 << i28)));
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j14) | Long.MIN_VALUE;
                                        i26++;
                                        i23 = i33;
                                        j11 = j14;
                                    } else {
                                        long j15 = j11;
                                        int i34 = iFindFirstAvailableSlot2 >> 3;
                                        long j16 = jArr4[i34];
                                        int i35 = (iFindFirstAvailableSlot2 & 7) << 3;
                                        if (((j16 >> i35) & 255) == 128) {
                                            jArr2 = jArr5;
                                            jArr4[i34] = ((~(255 << i35)) & j16) | (((long) (i30 & 127)) << i35);
                                            jArr4[i27] = (jArr4[i27] & (~(255 << i28))) | (128 << i28);
                                            jArr2[iFindFirstAvailableSlot2] = jArr2[i26];
                                            jArr2[i26] = 0;
                                            iArr[iFindFirstAvailableSlot2] = iArr[i26];
                                            iArr[i26] = 0;
                                        } else {
                                            jArr2 = jArr5;
                                            jArr4[i34] = ((~(255 << i35)) & j16) | (((long) (i30 & 127)) << i35);
                                            long j17 = jArr2[iFindFirstAvailableSlot2];
                                            jArr2[iFindFirstAvailableSlot2] = jArr2[i26];
                                            jArr2[i26] = j17;
                                            int i36 = iArr[iFindFirstAvailableSlot2];
                                            iArr[iFindFirstAvailableSlot2] = iArr[i26];
                                            iArr[i26] = i36;
                                            i26--;
                                        }
                                        jArr4[jArr4.length - 1] = (jArr4[0] & j15) | Long.MIN_VALUE;
                                        i26++;
                                        i20 = i20;
                                        i23 = i33;
                                        j11 = j15;
                                        jArr5 = jArr2;
                                    }
                                } else {
                                    i26++;
                                }
                            }
                            i2 = i23;
                            this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
                        }
                        iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                    } else {
                        j3 = 128;
                    }
                    j2 = 255;
                    i2 = 1;
                    int iNextCapacity = ScatterMapKt.nextCapacity(this._capacity);
                    long[] jArr6 = this.metadata;
                    long[] jArr7 = this.keys;
                    int[] iArr2 = this.values;
                    int i37 = this._capacity;
                    initializeStorage(iNextCapacity);
                    long[] jArr8 = this.metadata;
                    long[] jArr9 = this.keys;
                    int[] iArr3 = this.values;
                    int i38 = this._capacity;
                    int i39 = 0;
                    while (i39 < i37) {
                        if (((jArr6[i39 >> 3] >> ((i39 & 7) << 3)) & 255) < j3) {
                            long j18 = jArr7[i39];
                            jArr = jArr8;
                            int i40 = ((int) (j18 ^ (j18 >>> c2))) * i18;
                            int i41 = i40 ^ (i40 << 16);
                            int iFindFirstAvailableSlot3 = findFirstAvailableSlot(i41 >>> 7);
                            int i42 = iFindFirstAvailableSlot3 >> 3;
                            int i43 = (iFindFirstAvailableSlot3 & 7) << 3;
                            long j19 = (jArr[i42] & (~(255 << i43))) | (((long) (i41 & 127)) << i43);
                            jArr[i42] = j19;
                            jArr[(((iFindFirstAvailableSlot3 - 7) & i38) + (i38 & 7)) >> 3] = j19;
                            jArr9[iFindFirstAvailableSlot3] = j18;
                            iArr3[iFindFirstAvailableSlot3] = iArr2[i39];
                        } else {
                            jArr = jArr8;
                        }
                        i39++;
                        jArr6 = jArr6;
                        jArr8 = jArr;
                    }
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                }
                this._size++;
                int i44 = this.growthLimit;
                long[] jArr10 = this.metadata;
                int i45 = iFindFirstAvailableSlot >> 3;
                long j20 = jArr10[i45];
                int i46 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i44 - (((j20 >> i46) & j2) == j3 ? i2 : 0);
                int i47 = this._capacity;
                long j21 = (j20 & (~(j2 << i46))) | (j5 << i46);
                jArr10[i45] = j21;
                jArr10[(((iFindFirstAvailableSlot - 7) & i47) + (i47 & 7)) >> 3] = j21;
                i3 = ~iFindFirstAvailableSlot;
                break;
            }
            i11 = i15 + 8;
            i10 = (i10 + i11) & i9;
            i8 = i16;
            i4 = i18;
            c = c2;
        }
        if (i3 < 0) {
            i3 = ~i3;
        }
        this.keys[i3] = j;
        this.values[i3] = i;
    }

    public final String toString() {
        int i;
        int i2;
        if (this._size == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.keys;
        int[] iArr = this.values;
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
                            int i8 = iArr[i7];
                            sb.append(j2);
                            sb.append("=");
                            sb.append(i8);
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
                    int i9 = i3;
                    if (i5 != 8) {
                        break;
                    }
                    i = i9;
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
}
