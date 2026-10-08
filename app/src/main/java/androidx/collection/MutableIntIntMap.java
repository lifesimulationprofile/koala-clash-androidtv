package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableIntIntMap {
    public int _capacity;
    public int _size;
    public int growthLimit;
    public int[] keys;
    public long[] metadata;
    public int[] values;

    public MutableIntIntMap(int i) {
        this.metadata = ScatterMapKt.EmptyGroup;
        int[] iArr = IntSetKt.EmptyIntArray;
        this.keys = iArr;
        this.values = iArr;
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
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MutableIntIntMap)) {
            return false;
        }
        MutableIntIntMap mutableIntIntMap = (MutableIntIntMap) obj;
        if (mutableIntIntMap._size != this._size) {
            return false;
        }
        int[] iArr = this.keys;
        int[] iArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        loop0: while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                int i3 = 0;
                while (i3 < i2) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        int i5 = iArr[i4];
                        int i6 = iArr2[i4];
                        int iFindKeyIndex = mutableIntIntMap.findKeyIndex(i5);
                        if (iFindKeyIndex < 0 || i6 != mutableIntIntMap.values[iFindKeyIndex]) {
                            break loop0;
                        }
                    }
                    j >>= 8;
                    i3++;
                    z2 = z2;
                }
                z = z2;
                if (i2 != 8) {
                    return z;
                }
            } else {
                z = z2;
            }
            if (i == length) {
                return z;
            }
            i++;
            z2 = z;
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

    public final int findKeyIndex(int i) {
        int i2 = (-862048943) * i;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 & 127;
        int i5 = this._capacity;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (((long) i4) * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i5;
                if (this.keys[iNumberOfTrailingZeros] == i) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
    }

    public final int getOrDefault(int i, int i2) {
        int iFindKeyIndex = findKeyIndex(i);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : i2;
    }

    public final int hashCode() {
        int[] iArr = this.keys;
        int[] iArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        i2 += iArr2[i5] ^ iArr[i5];
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
        this.keys = new int[iMax];
        this.values = new int[iMax];
    }

    public final void set(int i, int i2) {
        long j;
        long j2;
        int i3;
        long j3;
        int i4;
        char c;
        long[] jArr;
        int i5 = i;
        int i6 = -862048943;
        int i7 = i5 * (-862048943);
        int i8 = i7 ^ (i7 << 16);
        int i9 = i8 >>> 7;
        int i10 = i8 & 127;
        int i11 = this._capacity;
        int i12 = i9 & i11;
        int i13 = 0;
        loop0: while (true) {
            long[] jArr2 = this.metadata;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            int i16 = 1;
            int i17 = i13;
            long j4 = (((-i15) >> 63) & (jArr2[i14 + 1] << (64 - i15))) | (jArr2[i14] >>> i15);
            long j5 = i10;
            int i18 = i6;
            int i19 = i10;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            long j7 = -9187201950435737472L;
            long j8 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (j8 != 0) {
                int iNumberOfTrailingZeros = (i12 + (Long.numberOfTrailingZeros(j8) >> 3)) & i11;
                long j9 = j7;
                if (this.keys[iNumberOfTrailingZeros] == i5) {
                    i4 = iNumberOfTrailingZeros;
                    break loop0;
                } else {
                    j8 &= j8 - 1;
                    j7 = j9;
                }
            }
            long j10 = j7;
            char c2 = '\b';
            if ((((~j4) << 6) & j4 & j10) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i9);
                long j11 = 255;
                if (this.growthLimit != 0 || ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) == 254) {
                    j = j5;
                    j2 = 255;
                    i3 = 1;
                    j3 = 128;
                } else {
                    int i20 = this._capacity;
                    if (i20 > 8) {
                        j3 = 128;
                        j = j5;
                        char c3 = 7;
                        if (Long.compare((((long) this._size) * 32) ^ Long.MIN_VALUE, (((long) i20) * 25) ^ Long.MIN_VALUE) <= 0) {
                            long[] jArr3 = this.metadata;
                            int i21 = this._capacity;
                            int[] iArr = this.keys;
                            int[] iArr2 = this.values;
                            int i22 = (i21 + 7) >> 3;
                            int i23 = 0;
                            while (i23 < i22) {
                                long j12 = j11;
                                long j13 = jArr3[i23] & j10;
                                jArr3[i23] = (-72340172838076674L) & ((~j13) + (j13 >>> 7));
                                i23++;
                                i16 = i16;
                                i18 = i18;
                                j11 = j12;
                            }
                            j2 = j11;
                            int i24 = i18;
                            i3 = i16;
                            int length = jArr3.length;
                            int i25 = length - 1;
                            int i26 = length - 2;
                            long j14 = 72057594037927935L;
                            jArr3[i26] = (jArr3[i26] & 72057594037927935L) | (-72057594037927936L);
                            jArr3[i25] = jArr3[0];
                            int i27 = 0;
                            while (i27 != i21) {
                                int i28 = i27 >> 3;
                                int i29 = (i27 & 7) << 3;
                                long j15 = (jArr3[i28] >> i29) & j2;
                                if (j15 != 128 && j15 == 254) {
                                    int i30 = iArr[i27] * i24;
                                    int i31 = i30 ^ (i30 << 16);
                                    int i32 = i31 >>> 7;
                                    int iFindFirstAvailableSlot2 = findFirstAvailableSlot(i32);
                                    int i33 = i32 & i21;
                                    char c4 = c2;
                                    if (((iFindFirstAvailableSlot2 - i33) & i21) / 8 == ((i27 - i33) & i21) / 8) {
                                        jArr3[i28] = (jArr3[i28] & (~(j2 << i29))) | (((long) (i31 & 127)) << i29);
                                        jArr3[jArr3.length - 1] = (jArr3[0] & j14) | Long.MIN_VALUE;
                                        i27++;
                                        c3 = c3;
                                        i21 = i21;
                                        c2 = c4;
                                    } else {
                                        char c5 = c3;
                                        int i34 = i21;
                                        int i35 = iFindFirstAvailableSlot2 >> 3;
                                        long j16 = jArr3[i35];
                                        int i36 = (iFindFirstAvailableSlot2 & 7) << 3;
                                        if (((j16 >> i36) & j2) == 128) {
                                            jArr3[i35] = (((long) (i31 & 127)) << i36) | (j16 & (~(j2 << i36)));
                                            jArr3[i28] = (jArr3[i28] & (~(j2 << i29))) | (128 << i29);
                                            iArr[iFindFirstAvailableSlot2] = iArr[i27];
                                            iArr[i27] = 0;
                                            iArr2[iFindFirstAvailableSlot2] = iArr2[i27];
                                            iArr2[i27] = 0;
                                        } else {
                                            jArr3[i35] = (((long) (i31 & 127)) << i36) | (j16 & (~(j2 << i36)));
                                            int i37 = iArr[iFindFirstAvailableSlot2];
                                            iArr[iFindFirstAvailableSlot2] = iArr[i27];
                                            iArr[i27] = i37;
                                            int i38 = iArr2[iFindFirstAvailableSlot2];
                                            iArr2[iFindFirstAvailableSlot2] = iArr2[i27];
                                            iArr2[i27] = i38;
                                            i27--;
                                        }
                                        jArr3[jArr3.length - 1] = (jArr3[0] & j14) | Long.MIN_VALUE;
                                        i27++;
                                        c3 = c5;
                                        i21 = i34;
                                        c2 = c4;
                                        j14 = j14;
                                    }
                                } else {
                                    i27++;
                                }
                            }
                            c = c3;
                            this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
                        } else {
                            c = 7;
                        }
                        iFindFirstAvailableSlot = findFirstAvailableSlot(i9);
                    } else {
                        j = j5;
                        c = 7;
                        j3 = 128;
                    }
                    j2 = 255;
                    i3 = 1;
                    int iNextCapacity = ScatterMapKt.nextCapacity(this._capacity);
                    long[] jArr4 = this.metadata;
                    int[] iArr3 = this.keys;
                    int[] iArr4 = this.values;
                    int i39 = this._capacity;
                    initializeStorage(iNextCapacity);
                    long[] jArr5 = this.metadata;
                    int[] iArr5 = this.keys;
                    int[] iArr6 = this.values;
                    int i40 = this._capacity;
                    int i41 = 0;
                    while (i41 < i39) {
                        if (((jArr4[i41 >> 3] >> ((i41 & 7) << 3)) & 255) < j3) {
                            int i42 = iArr3[i41];
                            int i43 = i42 * i18;
                            int i44 = i43 ^ (i43 << 16);
                            int iFindFirstAvailableSlot3 = findFirstAvailableSlot(i44 >>> 7);
                            jArr = jArr5;
                            long j17 = i44 & 127;
                            int i45 = iFindFirstAvailableSlot3 >> 3;
                            int i46 = (iFindFirstAvailableSlot3 & 7) << 3;
                            long j18 = (jArr[i45] & (~(255 << i46))) | (j17 << i46);
                            jArr[i45] = j18;
                            jArr[(((iFindFirstAvailableSlot3 - 7) & i40) + (i40 & 7)) >> 3] = j18;
                            iArr5[iFindFirstAvailableSlot3] = i42;
                            iArr6[iFindFirstAvailableSlot3] = iArr4[i41];
                        } else {
                            jArr = jArr5;
                        }
                        i41++;
                        c = c;
                        jArr5 = jArr;
                    }
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i9);
                }
                this._size++;
                int i47 = this.growthLimit;
                long[] jArr6 = this.metadata;
                int i48 = iFindFirstAvailableSlot >> 3;
                long j19 = jArr6[i48];
                int i49 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i47 - (((j19 >> i49) & j2) == j3 ? i3 : 0);
                int i50 = this._capacity;
                long j20 = (j19 & (~(j2 << i49))) | (j << i49);
                jArr6[i48] = j20;
                jArr6[(((iFindFirstAvailableSlot - 7) & i50) + (i50 & 7)) >> 3] = j20;
                i4 = ~iFindFirstAvailableSlot;
                break;
            }
            i13 = i17 + 8;
            i12 = (i12 + i13) & i11;
            i5 = i;
            i10 = i19;
            i6 = i18;
        }
        if (i4 < 0) {
            i4 = ~i4;
        }
        this.keys[i4] = i;
        this.values[i4] = i2;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0066 A[DONT_INVERT, PHI: r8
      0x0066: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x002c, B:19:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x0068 A[LOOP:0: B:9:0x001e->B:21:0x0068, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x006b A[EDGE_INSN: B:25:0x006b->B:22:0x006b BREAK  A[LOOP:0: B:9:0x001e->B:21:0x0068], SYNTHETIC] */
    public final String toString() {
        if (this._size == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        int[] iArr = this.keys;
        int[] iArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            int i7 = iArr2[i5];
                            sb.append(i6);
                            sb.append("=");
                            sb.append(i7);
                            i2++;
                            if (i2 < this._size) {
                                sb.append(", ");
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ MutableIntIntMap() {
        this(6);
    }
}
