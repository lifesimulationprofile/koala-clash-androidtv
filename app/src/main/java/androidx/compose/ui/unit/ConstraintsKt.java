package androidx.compose.ui.unit;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintsKt {
    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (!((i3 >= 0) & (i2 >= i) & (i4 >= i3) & (i >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final int bitsNeedForSizeUnchecked(int i) {
        if (i < 8191) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < 262143 ? 18 : 255;
    }

    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m689constrain4WqzIAM(long j, long j2) {
        int i = (int) (j2 >> 32);
        int iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
        int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        if (i < iM685getMinWidthimpl) {
            i = iM685getMinWidthimpl;
        }
        if (i <= iM683getMaxWidthimpl) {
            iM683getMaxWidthimpl = i;
        }
        int i2 = (int) (j2 & 4294967295L);
        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
        int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
        if (i2 < iM684getMinHeightimpl) {
            i2 = iM684getMinHeightimpl;
        }
        if (i2 <= iM682getMaxHeightimpl) {
            iM682getMaxHeightimpl = i2;
        }
        return (((long) iM683getMaxWidthimpl) << 32) | (4294967295L & ((long) iM682getMaxHeightimpl));
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m690constrainN9IONVI(long j, long j2) {
        int iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
        int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
        int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
        int iM685getMinWidthimpl2 = Constraints.m685getMinWidthimpl(j2);
        if (iM685getMinWidthimpl2 < iM685getMinWidthimpl) {
            iM685getMinWidthimpl2 = iM685getMinWidthimpl;
        }
        if (iM685getMinWidthimpl2 > iM683getMaxWidthimpl) {
            iM685getMinWidthimpl2 = iM683getMaxWidthimpl;
        }
        int iM683getMaxWidthimpl2 = Constraints.m683getMaxWidthimpl(j2);
        if (iM683getMaxWidthimpl2 >= iM685getMinWidthimpl) {
            iM685getMinWidthimpl = iM683getMaxWidthimpl2;
        }
        if (iM685getMinWidthimpl <= iM683getMaxWidthimpl) {
            iM683getMaxWidthimpl = iM685getMinWidthimpl;
        }
        int iM684getMinHeightimpl2 = Constraints.m684getMinHeightimpl(j2);
        if (iM684getMinHeightimpl2 < iM684getMinHeightimpl) {
            iM684getMinHeightimpl2 = iM684getMinHeightimpl;
        }
        if (iM684getMinHeightimpl2 > iM682getMaxHeightimpl) {
            iM684getMinHeightimpl2 = iM682getMaxHeightimpl;
        }
        int iM682getMaxHeightimpl2 = Constraints.m682getMaxHeightimpl(j2);
        if (iM682getMaxHeightimpl2 >= iM684getMinHeightimpl) {
            iM684getMinHeightimpl = iM682getMaxHeightimpl2;
        }
        if (iM684getMinHeightimpl <= iM682getMaxHeightimpl) {
            iM682getMaxHeightimpl = iM684getMinHeightimpl;
        }
        return Constraints(iM685getMinWidthimpl2, iM683getMaxWidthimpl, iM684getMinHeightimpl2, iM682getMaxHeightimpl);
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m691constrainHeightK40F9xA(int i, long j) {
        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
        int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
        if (i < iM684getMinHeightimpl) {
            i = iM684getMinHeightimpl;
        }
        return i > iM682getMaxHeightimpl ? iM682getMaxHeightimpl : i;
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m692constrainWidthK40F9xA(int i, long j) {
        int iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
        int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        if (i < iM685getMinWidthimpl) {
            i = iM685getMinWidthimpl;
        }
        return i > iM683getMaxWidthimpl ? iM683getMaxWidthimpl : i;
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            throwInvalidConstraintException(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i4 + 1;
        int i9 = iBitsNeedForSizeUnchecked2 - 13;
        return (((long) (i7 & (~(i7 >> 31)))) << 33) | ((long) ((i9 >> 1) + (i9 & 1))) | (((long) i) << 2) | (((long) i3) << (iBitsNeedForSizeUnchecked2 + 2)) | (((long) (i8 & (~(i8 >> 31)))) << (iBitsNeedForSizeUnchecked2 + 33));
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m693offsetNN6EwU(int i, int i2, long j) {
        int iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j) + i;
        if (iM685getMinWidthimpl < 0) {
            iM685getMinWidthimpl = 0;
        }
        int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        if (iM683getMaxWidthimpl != Integer.MAX_VALUE && (iM683getMaxWidthimpl = iM683getMaxWidthimpl + i) < 0) {
            iM683getMaxWidthimpl = 0;
        }
        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j) + i2;
        if (iM684getMinHeightimpl < 0) {
            iM684getMinHeightimpl = 0;
        }
        int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
        return Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM684getMinHeightimpl, (iM682getMaxHeightimpl == Integer.MAX_VALUE || (iM682getMaxHeightimpl = iM682getMaxHeightimpl + i2) >= 0) ? iM682getMaxHeightimpl : 0);
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m694offsetNN6EwU$default(int i, int i2, int i3, long j) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m693offsetNN6EwU(i, i2, j);
    }

    public static final void throwInvalidConstraintException(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    public static final Void throwInvalidConstraintsSizeException(int i) {
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Can't represent a size of ", " in Constraints"));
    }
}
