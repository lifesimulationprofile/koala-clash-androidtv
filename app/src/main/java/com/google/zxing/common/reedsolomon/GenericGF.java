package com.google.zxing.common.reedsolomon;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GenericGF {
    public static final GenericGF QR_CODE_FIELD_256;
    public final int[] expTable;
    public final int generatorBase;
    public final int[] logTable;
    public final int primitive;
    public final int size;
    public final GenericGFPoly zero;

    static {
        new GenericGF(4201, 4096, 1);
        new GenericGF(1033, 1024, 1);
        new GenericGF(67, 64, 1);
        new GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
        new GenericGF(301, 256, 1);
    }

    public GenericGF(int i, int i2, int i3) {
        this.primitive = i;
        this.size = i2;
        this.generatorBase = i3;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.expTable[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.logTable[this.expTable[i6]] = i6;
        }
        this.zero = new GenericGFPoly(this, new int[]{0});
    }

    public final int multiply(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.logTable;
        return this.expTable[(iArr[i] + iArr[i2]) % (this.size - 1)];
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.primitive));
        sb.append(',');
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.size, ')');
    }
}
