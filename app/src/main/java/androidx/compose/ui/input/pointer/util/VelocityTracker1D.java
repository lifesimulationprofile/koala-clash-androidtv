package androidx.compose.ui.input.pointer.util;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.internal.InlineClassHelperKt;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VelocityTracker1D {
    public int index;
    public final boolean isDataDifferential;
    public final int minSampleSize;
    public final float[] reusableDataPointsArray;
    public final float[] reusableTimeArray;
    public final float[] reusableVelocityCoefficients;
    public final DataPointAtTime[] samples;
    public final int strategy;

    public VelocityTracker1D(int i, boolean z) {
        int i2;
        this.isDataDifferential = z;
        this.strategy = i;
        if (z && CaptureSession$State$EnumUnboxingLocalUtility.equals(i, 1)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            i2 = 3;
        } else {
            if (iOrdinal != 1) {
                throw new HttpException();
            }
            i2 = 2;
        }
        this.minSampleSize = i2;
        this.samples = new DataPointAtTime[20];
        this.reusableDataPointsArray = new float[20];
        this.reusableTimeArray = new float[20];
        this.reusableVelocityCoefficients = new float[3];
    }

    public final void addDataPoint(float f, long j) {
        int i = (this.index + 1) % 20;
        this.index = i;
        DataPointAtTime[] dataPointAtTimeArr = this.samples;
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i];
        if (dataPointAtTime != null) {
            dataPointAtTime.time = j;
            dataPointAtTime.dataPoint = f;
        } else {
            DataPointAtTime dataPointAtTime2 = new DataPointAtTime();
            dataPointAtTime2.time = j;
            dataPointAtTime2.dataPoint = f;
            dataPointAtTimeArr[i] = dataPointAtTime2;
        }
    }

    public final float calculateVelocity(float f) {
        int i;
        float[] fArr;
        float[] fArr2;
        float f2;
        boolean z;
        float fSignum;
        float f3 = f;
        float f4 = 0.0f;
        if (f3 <= 0.0f) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + f3);
        }
        int i2 = this.index;
        DataPointAtTime[] dataPointAtTimeArr = this.samples;
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i2];
        if (dataPointAtTime == null) {
            f2 = 0.0f;
        } else {
            int i3 = 0;
            DataPointAtTime dataPointAtTime2 = dataPointAtTime;
            while (true) {
                DataPointAtTime dataPointAtTime3 = dataPointAtTimeArr[i2];
                boolean z2 = this.isDataDifferential;
                i = this.strategy;
                fArr = this.reusableDataPointsArray;
                fArr2 = this.reusableTimeArray;
                if (dataPointAtTime3 == null) {
                    f2 = f4;
                    z = z2;
                    break;
                }
                long j = dataPointAtTime.time;
                f2 = f4;
                int i4 = i2;
                long j2 = dataPointAtTime3.time;
                float f5 = j - j2;
                z = z2;
                float fAbs = Math.abs(j2 - dataPointAtTime2.time);
                dataPointAtTime2 = (i == 1 || z) ? dataPointAtTime3 : dataPointAtTime;
                if (f5 > 100.0f || fAbs > 40.0f) {
                    break;
                }
                fArr[i3] = dataPointAtTime3.dataPoint;
                fArr2[i3] = -f5;
                i2 = (i4 == 0 ? 20 : i4) - 1;
                i3++;
                if (i3 >= 20) {
                    break;
                }
                f4 = f2;
            }
            if (i3 >= this.minSampleSize) {
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
                if (iOrdinal == 0) {
                    try {
                        float[] fArr3 = this.reusableVelocityCoefficients;
                        VelocityTrackerKt.polyFitLeastSquares(fArr2, fArr, i3, fArr3);
                        fSignum = fArr3[1];
                    } catch (IllegalArgumentException unused) {
                        fSignum = f2;
                    }
                } else {
                    if (iOrdinal != 1) {
                        throw new HttpException();
                    }
                    int i5 = i3 - 1;
                    float f6 = fArr2[i5];
                    int i6 = i5;
                    float fAbs2 = f2;
                    while (i6 > 0) {
                        int i7 = i6 - 1;
                        float f7 = fArr2[i7];
                        if (f6 != f7) {
                            float f8 = (z ? -fArr[i7] : fArr[i6] - fArr[i7]) / (f6 - f7);
                            fAbs2 += Math.abs(f8) * (f8 - (Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2))));
                            if (i6 == i5) {
                                fAbs2 *= 0.5f;
                            }
                        }
                        i6--;
                        f6 = f7;
                    }
                    fSignum = Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2));
                }
                f4 = fSignum * 1000;
            } else {
                f4 = f2;
            }
        }
        if (f4 == f2 || Float.isNaN(f4)) {
            return f2;
        }
        if (f4 <= f2) {
            f3 = -f3;
            if (f4 >= f3) {
                return f4;
            }
        } else if (f4 <= f3) {
            f3 = f4;
        }
        return f3;
    }

    public /* synthetic */ VelocityTracker1D() {
        this(1, false);
    }

    public VelocityTracker1D(int i) {
        this(2, true);
    }
}
