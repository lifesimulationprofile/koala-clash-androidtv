package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableIntSet {
    public int _capacity;
    public int _size;
    public int[] elements;
    public int growthLimit;
    public long[] metadata;

    public MutableIntSet(int i) {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = IntSetKt.EmptyIntArray;
        if (i >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i));
        } else {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
            throw null;
        }
    }

    public final boolean add(int i) {
        long j;
        long j2;
        int i2;
        long j3;
        int iNumberOfTrailingZeros;
        char c;
        long[] jArr;
        int i3 = this._size;
        int i4 = -862048943;
        int i5 = i * (-862048943);
        int i6 = i5 ^ (i5 << 16);
        int i7 = i6 >>> 7;
        int i8 = i6 & 127;
        int i9 = this._capacity;
        int i10 = i7 & i9;
        int i11 = 0;
        loop0: while (true) {
            long[] jArr2 = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            int i14 = 1;
            int i15 = i11;
            long j4 = (((-i13) >> 63) & (jArr2[i12 + 1] << (64 - i13))) | (jArr2[i12] >>> i13);
            long j5 = i8;
            int i16 = i4;
            int i17 = i8;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            long j7 = -9187201950435737472L;
            long j8 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (j8 != 0) {
                iNumberOfTrailingZeros = (i10 + (Long.numberOfTrailingZeros(j8) >> 3)) & i9;
                long j9 = j7;
                if (this.elements[iNumberOfTrailingZeros] == i) {
                    break loop0;
                }
                j8 &= j8 - 1;
                j7 = j9;
            }
            long j10 = j7;
            char c2 = '\b';
            if ((((~j4) << 6) & j4 & j10) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                long j11 = 255;
                if (this.growthLimit != 0 || ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) == 254) {
                    j = j5;
                    j2 = 255;
                    i2 = 1;
                    j3 = 128;
                } else {
                    int i18 = this._capacity;
                    if (i18 > 8) {
                        j3 = 128;
                        j = j5;
                        char c3 = 7;
                        if (Long.compare((((long) this._size) * 32) ^ Long.MIN_VALUE, (((long) i18) * 25) ^ Long.MIN_VALUE) <= 0) {
                            long[] jArr3 = this.metadata;
                            int i19 = this._capacity;
                            int[] iArr = this.elements;
                            int i20 = (i19 + 7) >> 3;
                            int i21 = 0;
                            while (i21 < i20) {
                                long j12 = j11;
                                long j13 = jArr3[i21] & j10;
                                jArr3[i21] = (-72340172838076674L) & ((~j13) + (j13 >>> 7));
                                i21++;
                                i14 = i14;
                                i16 = i16;
                                j11 = j12;
                            }
                            j2 = j11;
                            int i22 = i16;
                            int i23 = i14;
                            int length = jArr3.length;
                            int i24 = length - 1;
                            int i25 = length - 2;
                            jArr3[i25] = (jArr3[i25] & 72057594037927935L) | (-72057594037927936L);
                            jArr3[i24] = jArr3[0];
                            int i26 = 0;
                            while (i26 != i19) {
                                int i27 = i26 >> 3;
                                int i28 = (i26 & 7) << 3;
                                long j14 = (jArr3[i27] >> i28) & j2;
                                if (j14 != 128 && j14 == 254) {
                                    int i29 = iArr[i26] * i22;
                                    int i30 = i29 ^ (i29 << 16);
                                    int i31 = i30 >>> 7;
                                    int iFindFirstAvailableSlot2 = findFirstAvailableSlot(i31);
                                    int i32 = i31 & i19;
                                    char c4 = c2;
                                    if (((iFindFirstAvailableSlot2 - i32) & i19) / 8 == ((i26 - i32) & i19) / 8) {
                                        jArr3[i27] = (jArr3[i27] & (~(j2 << i28))) | (((long) (i30 & 127)) << i28);
                                        jArr3[jArr3.length - i23] = (jArr3[0] & 72057594037927935L) | Long.MIN_VALUE;
                                        i26++;
                                        c3 = c3;
                                        i19 = i19;
                                        c2 = c4;
                                    } else {
                                        char c5 = c3;
                                        int i33 = i19;
                                        int i34 = iFindFirstAvailableSlot2 >> 3;
                                        long j15 = jArr3[i34];
                                        int i35 = (iFindFirstAvailableSlot2 & 7) << 3;
                                        if (((j15 >> i35) & j2) == 128) {
                                            jArr3[i34] = (j15 & (~(j2 << i35))) | (((long) (i30 & 127)) << i35);
                                            jArr3[i27] = (jArr3[i27] & (~(j2 << i28))) | (128 << i28);
                                            iArr[iFindFirstAvailableSlot2] = iArr[i26];
                                            iArr[i26] = 0;
                                        } else {
                                            jArr3[i34] = (((long) (i30 & 127)) << i35) | (j15 & (~(j2 << i35)));
                                            int i36 = iArr[iFindFirstAvailableSlot2];
                                            iArr[iFindFirstAvailableSlot2] = iArr[i26];
                                            iArr[i26] = i36;
                                            i26--;
                                        }
                                        jArr3[jArr3.length - 1] = (jArr3[0] & 72057594037927935L) | Long.MIN_VALUE;
                                        i26++;
                                        c3 = c5;
                                        i19 = i33;
                                        c2 = c4;
                                        i23 = i23;
                                    }
                                } else {
                                    i26++;
                                }
                            }
                            c = c3;
                            i2 = i23;
                            this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
                        } else {
                            c = 7;
                        }
                        iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                    } else {
                        j = j5;
                        c = 7;
                        j3 = 128;
                    }
                    j2 = 255;
                    i2 = 1;
                    int iNextCapacity = ScatterMapKt.nextCapacity(this._capacity);
                    long[] jArr4 = this.metadata;
                    int[] iArr2 = this.elements;
                    int i37 = this._capacity;
                    initializeStorage(iNextCapacity);
                    long[] jArr5 = this.metadata;
                    int[] iArr3 = this.elements;
                    int i38 = this._capacity;
                    int i39 = 0;
                    while (i39 < i37) {
                        if (((jArr4[i39 >> 3] >> ((i39 & 7) << 3)) & 255) < j3) {
                            int i40 = iArr2[i39];
                            int i41 = i40 * i16;
                            int i42 = i41 ^ (i41 << 16);
                            int iFindFirstAvailableSlot3 = findFirstAvailableSlot(i42 >>> 7);
                            long j16 = i42 & 127;
                            int i43 = iFindFirstAvailableSlot3 >> 3;
                            int i44 = (iFindFirstAvailableSlot3 & 7) << 3;
                            jArr = jArr5;
                            long j17 = (jArr5[i43] & (~(255 << i44))) | (j16 << i44);
                            jArr[i43] = j17;
                            jArr[(((iFindFirstAvailableSlot3 - 7) & i38) + (i38 & 7)) >> 3] = j17;
                            iArr3[iFindFirstAvailableSlot3] = i40;
                        } else {
                            jArr = jArr5;
                        }
                        i39++;
                        i7 = i7;
                        c = c;
                        jArr5 = jArr;
                    }
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                }
                this._size++;
                int i45 = this.growthLimit;
                long[] jArr6 = this.metadata;
                int i46 = iFindFirstAvailableSlot >> 3;
                long j18 = jArr6[i46];
                int i47 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i45 - (((j18 >> i47) & j2) == j3 ? i2 : 0);
                int i48 = this._capacity;
                long j19 = (j18 & (~(j2 << i47))) | (j << i47);
                jArr6[i46] = j19;
                jArr6[(((iFindFirstAvailableSlot - 7) & i48) + (i48 & 7)) >> 3] = j19;
                iNumberOfTrailingZeros = iFindFirstAvailableSlot;
                break;
            }
            i11 = i15 + 8;
            i10 = (i10 + i11) & i9;
            i8 = i17;
            i4 = i16;
        }
        this.elements[iNumberOfTrailingZeros] = i;
        return this._size != i3;
    }

    public final boolean contains(int i) {
        int iNumberOfTrailingZeros;
        int i2 = (-862048943) * i;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 & 127;
        int i5 = this._capacity;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (((long) i4) * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i5;
                if (this.elements[iNumberOfTrailingZeros] == i) {
                    break loop0;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
        return iNumberOfTrailingZeros >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x005a A[LOOP:0: B:14:0x0021->B:26:0x005a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x005d A[SYNTHETIC] */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MutableIntSet)) {
            return false;
        }
        MutableIntSet mutableIntSet = (MutableIntSet) obj;
        if (mutableIntSet._size != this._size) {
            return false;
        }
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && !mutableIntSet.contains(iArr[(i << 3) + i3])) {
                            return false;
                        }
                        j >>= 8;
                    }
                    if (i2 == 8) {
                        if (i != length) {
                            i++;
                        }
                    }
                } else if (i != length) {
                    i++;
                }
            }
        }
        return true;
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

    public final int hashCode() {
        int[] iArr = this.elements;
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
                        i2 += iArr[(i << 3) + i4];
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
        this.elements = new int[iMax];
    }

    public final boolean remove(int i) {
        int iNumberOfTrailingZeros;
        int i2 = (-862048943) * i;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 & 127;
        int i5 = this._capacity;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (((long) i4) * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i5;
                if (this.elements[iNumberOfTrailingZeros] == i) {
                    break loop0;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
        boolean z = iNumberOfTrailingZeros >= 0;
        if (z) {
            removeElementAt(iNumberOfTrailingZeros);
        }
        return z;
    }

    public final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d A[DONT_INVERT, PHI: r7
      0x005d: PHI (r7v2 int) = (r7v1 int), (r7v3 int) binds: [B:6:0x0026, B:18:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x005f A[LOOP:0: B:5:0x0018->B:20:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0062 A[SYNTHETIC] */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sb.append((CharSequence) "]");
            break;
        }
        int i = 0;
        int i2 = 0;
        loop0: while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = iArr[(i << 3) + i4];
                        if (i2 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i2 != 0) {
                            sb.append((CharSequence) ", ");
                        }
                        sb.append(i5);
                        i2++;
                    }
                    j >>= 8;
                }
                if (i3 == 8) {
                    if (i == length) {
                        i++;
                    }
                }
                sb.append((CharSequence) "]");
                break;
            }
            if (i == length) {
                sb.append((CharSequence) "]");
                break;
            }
            i++;
        }
        return sb.toString();
    }

    public /* synthetic */ MutableIntSet() {
        this(6);
    }
}
