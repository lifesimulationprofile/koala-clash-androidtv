package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzsn {
    public static final void checkElementIndex$runtime(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
    }

    public static final void checkPositionIndex$runtime(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
        }
    }

    public static final void checkRangeIndexes$runtime(int i, int i2, int i3) {
        if (i >= 0 && i2 <= i3) {
            if (i > i2) {
                throw new IllegalArgumentException(Modifier.CC.m(i, i2, "fromIndex: ", " > toIndex: "));
            }
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
    }
}
