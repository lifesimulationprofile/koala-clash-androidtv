package androidx.compose.runtime;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IntStack {
    public int[] slots;
    public int tos;

    public IntStack() {
        this.slots = new int[10];
    }

    public int peekOr(int i) {
        int i2 = this.tos - 1;
        return i2 >= 0 ? this.slots[i2] : i;
    }

    public int pop() {
        int[] iArr = this.slots;
        int i = this.tos - 1;
        this.tos = i;
        return iArr[i];
    }

    public void push(int i) {
        int[] iArrCopyOf = this.slots;
        if (this.tos >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            this.slots = iArrCopyOf;
        }
        int i2 = this.tos;
        this.tos = i2 + 1;
        iArrCopyOf[i2] = i;
    }

    public void pushDiagonal(int i, int i2, int i3) {
        int i4 = this.tos;
        int[] iArrCopyOf = this.slots;
        int i5 = i4 + 3;
        if (i5 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            this.slots = iArrCopyOf;
        }
        iArrCopyOf[i4] = i + i3;
        iArrCopyOf[i4 + 1] = i2 + i3;
        iArrCopyOf[i4 + 2] = i3;
        this.tos = i5;
    }

    public void pushRange(int i, int i2, int i3, int i4) {
        int i5 = this.tos;
        int[] iArrCopyOf = this.slots;
        int i6 = i5 + 4;
        if (i6 >= iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            this.slots = iArrCopyOf;
        }
        iArrCopyOf[i5] = i;
        iArrCopyOf[i5 + 1] = i2;
        iArrCopyOf[i5 + 2] = i3;
        iArrCopyOf[i5 + 3] = i4;
        this.tos = i6;
    }

    public void quickSort(int i, int i2) {
        if (i < i2) {
            int i3 = i - 3;
            for (int i4 = i; i4 < i2; i4 += 3) {
                int[] iArr = this.slots;
                int i5 = iArr[i4];
                int i6 = iArr[i2];
                if (i5 < i6 || (i5 == i6 && iArr[i4 + 1] <= iArr[i2 + 1])) {
                    i3 += 3;
                    swapDiagonal(i3, i4);
                }
            }
            swapDiagonal(i3 + 3, i2);
            quickSort(i, i3);
            quickSort(i3 + 6, i2);
        }
    }

    public void swapDiagonal(int i, int i2) {
        int[] iArr = this.slots;
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
        int i4 = i + 1;
        int i5 = i2 + 1;
        int i6 = iArr[i4];
        iArr[i4] = iArr[i5];
        iArr[i5] = i6;
        int i7 = i + 2;
        int i8 = i2 + 2;
        int i9 = iArr[i7];
        iArr[i7] = iArr[i8];
        iArr[i8] = i9;
    }

    public IntStack(int i) {
        this.slots = new int[i];
    }
}
