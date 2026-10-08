package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableIntObjectMap extends IntObjectMap {
    public int growthLimit;

    public MutableIntObjectMap(int i) {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.EmptyIntArray;
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

    public final int findAbsoluteInsertIndex(int i) {
        long j;
        int i2;
        int i3;
        long j2;
        long[] jArr;
        int i4;
        int i5 = -862048943;
        int i6 = i * (-862048943);
        int i7 = i6 ^ (i6 << 16);
        int i8 = i7 >>> 7;
        int i9 = i7 & 127;
        int i10 = this._capacity;
        int i11 = i8 & i10;
        int i12 = 0;
        while (true) {
            long[] jArr2 = this.metadata;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            int i15 = 1;
            int i16 = i12;
            int i17 = 0;
            long j3 = (((-i14) >> 63) & (jArr2[i13 + 1] << (64 - i14))) | (jArr2[i13] >>> i14);
            long j4 = i9;
            int i18 = i5;
            int i19 = i9;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            long j6 = -9187201950435737472L;
            long j7 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L);
            while (j7 != 0) {
                int iNumberOfTrailingZeros = (i11 + (Long.numberOfTrailingZeros(j7) >> 3)) & i10;
                long j8 = j6;
                if (this.keys[iNumberOfTrailingZeros] == i) {
                    return iNumberOfTrailingZeros;
                }
                j7 &= j7 - 1;
                j6 = j8;
            }
            long j9 = j6;
            if ((((~j3) << 6) & j3 & j9) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i8);
                long j10 = 255;
                if (this.growthLimit != 0 || ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) == 254) {
                    j = 255;
                    i2 = 1;
                    i3 = 0;
                    j2 = 128;
                } else {
                    int i20 = this._capacity;
                    if (i20 > 8) {
                        j2 = 128;
                        if (Long.compare((((long) this._size) * 32) ^ Long.MIN_VALUE, (((long) i20) * 25) ^ Long.MIN_VALUE) <= 0) {
                            long[] jArr3 = this.metadata;
                            int i21 = this._capacity;
                            int[] iArr = this.keys;
                            Object[] objArr = this.values;
                            int i22 = (i21 + 7) >> 3;
                            int i23 = 0;
                            while (i23 < i22) {
                                long j11 = j10;
                                long j12 = jArr3[i23] & j9;
                                jArr3[i23] = (-72340172838076674L) & ((~j12) + (j12 >>> 7));
                                i23++;
                                i22 = i22;
                                j10 = j11;
                            }
                            j = j10;
                            int length = jArr3.length;
                            int i24 = length - 1;
                            int i25 = length - 2;
                            jArr3[i25] = (jArr3[i25] & 72057594037927935L) | (-72057594037927936L);
                            jArr3[i24] = jArr3[0];
                            int i26 = 0;
                            while (i26 != i21) {
                                int i27 = i26 >> 3;
                                int i28 = (i26 & 7) << 3;
                                long j13 = (jArr3[i27] >> i28) & j;
                                if (j13 != 128 && j13 == 254) {
                                    int i29 = iArr[i26] * i18;
                                    int i30 = i29 ^ (i29 << 16);
                                    int i31 = i30 >>> 7;
                                    int iFindFirstAvailableSlot2 = findFirstAvailableSlot(i31);
                                    int i32 = i31 & i21;
                                    int i33 = i18;
                                    if (((iFindFirstAvailableSlot2 - i32) & i21) / 8 == ((i26 - i32) & i21) / 8) {
                                        int i34 = i15;
                                        int i35 = i17;
                                        jArr3[i27] = (((long) (i30 & 127)) << i28) | (jArr3[i27] & (~(j << i28)));
                                        jArr3[jArr3.length - i34] = (jArr3[i35] & 72057594037927935L) | Long.MIN_VALUE;
                                        i26++;
                                        i15 = i34;
                                        i18 = i33;
                                        i17 = i35;
                                    } else {
                                        int i36 = i15;
                                        int i37 = i17;
                                        int i38 = iFindFirstAvailableSlot2 >> 3;
                                        long j14 = jArr3[i38];
                                        int i39 = (iFindFirstAvailableSlot2 & 7) << 3;
                                        if (((j14 >> i39) & j) == 128) {
                                            int i40 = i26;
                                            jArr3[i38] = (j14 & (~(j << i39))) | (((long) (i30 & 127)) << i39);
                                            jArr3[i27] = (jArr3[i27] & (~(j << i28))) | (128 << i28);
                                            iArr[iFindFirstAvailableSlot2] = iArr[i40];
                                            iArr[i40] = i37;
                                            objArr[iFindFirstAvailableSlot2] = objArr[i40];
                                            objArr[i40] = null;
                                            i4 = i40;
                                        } else {
                                            int i41 = i26;
                                            jArr3[i38] = (((long) (i30 & 127)) << i39) | (j14 & (~(j << i39)));
                                            int i42 = iArr[iFindFirstAvailableSlot2];
                                            iArr[iFindFirstAvailableSlot2] = iArr[i41];
                                            iArr[i41] = i42;
                                            Object obj = objArr[iFindFirstAvailableSlot2];
                                            objArr[iFindFirstAvailableSlot2] = objArr[i41];
                                            objArr[i41] = obj;
                                            i4 = i41 - 1;
                                        }
                                        jArr3[jArr3.length - 1] = (jArr3[i37] & 72057594037927935L) | Long.MIN_VALUE;
                                        i26 = i4 + 1;
                                        i21 = i21;
                                        i18 = i33;
                                        i17 = i37;
                                        i15 = i36;
                                    }
                                } else {
                                    i26++;
                                }
                            }
                            i2 = i15;
                            i3 = i17;
                            this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
                        }
                        iFindFirstAvailableSlot = findFirstAvailableSlot(i8);
                    } else {
                        j2 = 128;
                    }
                    j = 255;
                    i2 = 1;
                    i3 = 0;
                    int iNextCapacity = ScatterMapKt.nextCapacity(this._capacity);
                    long[] jArr4 = this.metadata;
                    int[] iArr2 = this.keys;
                    Object[] objArr2 = this.values;
                    int i43 = this._capacity;
                    initializeStorage(iNextCapacity);
                    long[] jArr5 = this.metadata;
                    int[] iArr3 = this.keys;
                    Object[] objArr3 = this.values;
                    int i44 = this._capacity;
                    int i45 = 0;
                    while (i45 < i43) {
                        if (((jArr4[i45 >> 3] >> ((i45 & 7) << 3)) & 255) < j2) {
                            int i46 = iArr2[i45];
                            int i47 = i46 * i18;
                            int i48 = i47 ^ (i47 << 16);
                            int iFindFirstAvailableSlot3 = findFirstAvailableSlot(i48 >>> 7);
                            jArr = jArr5;
                            long j15 = i48 & 127;
                            int i49 = iFindFirstAvailableSlot3 >> 3;
                            int i50 = (iFindFirstAvailableSlot3 & 7) << 3;
                            long j16 = (jArr[i49] & (~(255 << i50))) | (j15 << i50);
                            jArr[i49] = j16;
                            jArr[(((iFindFirstAvailableSlot3 - 7) & i44) + (i44 & 7)) >> 3] = j16;
                            iArr3[iFindFirstAvailableSlot3] = i46;
                            objArr3[iFindFirstAvailableSlot3] = objArr2[i45];
                        } else {
                            jArr = jArr5;
                        }
                        i45++;
                        jArr4 = jArr4;
                        jArr5 = jArr;
                    }
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i8);
                }
                this._size++;
                int i51 = this.growthLimit;
                long[] jArr6 = this.metadata;
                int i52 = iFindFirstAvailableSlot >> 3;
                long j17 = jArr6[i52];
                int i53 = (iFindFirstAvailableSlot & 7) << 3;
                if (((j17 >> i53) & j) == j2) {
                    i3 = i2;
                }
                this.growthLimit = i51 - i3;
                int i54 = this._capacity;
                long j18 = (j17 & (~(j << i53))) | (j4 << i53);
                jArr6[i52] = j18;
                jArr6[(((iFindFirstAvailableSlot - 7) & i54) + (i54 & 7)) >> 3] = j18;
                return iFindFirstAvailableSlot;
            }
            i12 = i16 + 8;
            i11 = (i11 + i12) & i10;
            i9 = i19;
            i5 = i18;
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
        this.values = new Object[iMax];
    }

    public final Object remove(int i) {
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
                if (this.keys[iNumberOfTrailingZeros] == i) {
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
        if (iNumberOfTrailingZeros < 0) {
            return null;
        }
        this._size--;
        long[] jArr2 = this.metadata;
        int i10 = this._capacity;
        int i11 = iNumberOfTrailingZeros >> 3;
        int i12 = (iNumberOfTrailingZeros & 7) << 3;
        long j4 = (jArr2[i11] & (~(255 << i12))) | (254 << i12);
        jArr2[i11] = j4;
        jArr2[(((iNumberOfTrailingZeros - 7) & i10) + (i10 & 7)) >> 3] = j4;
        Object[] objArr = this.values;
        Object obj = objArr[iNumberOfTrailingZeros];
        objArr[iNumberOfTrailingZeros] = null;
        return obj;
    }

    public final void set(int i, Object obj) {
        int iFindAbsoluteInsertIndex = findAbsoluteInsertIndex(i);
        this.keys[iFindAbsoluteInsertIndex] = i;
        this.values[iFindAbsoluteInsertIndex] = obj;
    }

    public /* synthetic */ MutableIntObjectMap() {
        this(6);
    }
}
