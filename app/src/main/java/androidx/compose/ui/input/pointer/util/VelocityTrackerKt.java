package androidx.compose.ui.input.pointer.util;

import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import coil.request.Parameters;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class VelocityTrackerKt {
    /* JADX INFO: renamed from: addPointerInputChange-0AR0LA0, reason: not valid java name */
    public static final void m515addPointerInputChange0AR0LA0(Parameters.Builder builder, PointerInputChange pointerInputChange, long j) {
        VirtualCameraCaptureResult virtualCameraCaptureResult = (VirtualCameraCaptureResult) builder.entries;
        virtualCameraCaptureResult.getClass();
        VelocityTracker1D velocityTracker1D = (VelocityTracker1D) virtualCameraCaptureResult.mTagBundle;
        VelocityTracker1D velocityTracker1D2 = (VelocityTracker1D) virtualCameraCaptureResult.mBaseCameraCaptureResult;
        boolean zChangedToDownIgnoreConsumed = PointerId.changedToDownIgnoreConsumed(pointerInputChange);
        long j2 = pointerInputChange.uptimeMillis;
        if (zChangedToDownIgnoreConsumed) {
            DataPointAtTime[] dataPointAtTimeArr = velocityTracker1D2.samples;
            Arrays.fill(dataPointAtTimeArr, 0, dataPointAtTimeArr.length, (Object) null);
            velocityTracker1D2.index = 0;
            DataPointAtTime[] dataPointAtTimeArr2 = velocityTracker1D.samples;
            Arrays.fill(dataPointAtTimeArr2, 0, dataPointAtTimeArr2.length, (Object) null);
            velocityTracker1D.index = 0;
            virtualCameraCaptureResult.mTimestamp = 0L;
        }
        if (!PointerId.changedToUpIgnoreConsumed(pointerInputChange)) {
            List list = pointerInputChange._historical;
            if (list == null) {
                list = EmptyList.INSTANCE;
            }
            int i = 0;
            for (int size = list.size(); i < size; size = size) {
                HistoricalChange historicalChange = (HistoricalChange) list.get(i);
                virtualCameraCaptureResult.m18addPositionUv8p0NA(historicalChange.uptimeMillis, Offset.m373plusMKHz9U(historicalChange.originalEventPosition, j));
                i++;
            }
            virtualCameraCaptureResult.m18addPositionUv8p0NA(j2, Offset.m373plusMKHz9U(pointerInputChange.originalEventPosition, j));
        }
        if (PointerId.changedToUpIgnoreConsumed(pointerInputChange) && j2 - virtualCameraCaptureResult.mTimestamp > 40) {
            DataPointAtTime[] dataPointAtTimeArr3 = velocityTracker1D2.samples;
            Arrays.fill(dataPointAtTimeArr3, 0, dataPointAtTimeArr3.length, (Object) null);
            velocityTracker1D2.index = 0;
            DataPointAtTime[] dataPointAtTimeArr4 = velocityTracker1D.samples;
            Arrays.fill(dataPointAtTimeArr4, 0, dataPointAtTimeArr4.length, (Object) null);
            velocityTracker1D.index = 0;
            virtualCameraCaptureResult.mTimestamp = 0L;
        }
        virtualCameraCaptureResult.mTimestamp = j2;
    }

    public static final float dot(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i] * fArr2[i];
        }
        return f;
    }

    public static final void polyFitLeastSquares(float[] fArr, float[] fArr2, int i, float[] fArr3) {
        if (i == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("At least one point must be provided");
        }
        int i2 = 2 >= i ? i - 1 : 2;
        int i3 = i2 + 1;
        float[][] fArr4 = new float[i3][];
        for (int i4 = 0; i4 < i3; i4++) {
            fArr4[i4] = new float[i];
        }
        for (int i5 = 0; i5 < i; i5++) {
            fArr4[0][i5] = 1.0f;
            for (int i6 = 1; i6 < i3; i6++) {
                fArr4[i6][i5] = fArr4[i6 - 1][i5] * fArr[i5];
            }
        }
        float[][] fArr5 = new float[i3][];
        for (int i7 = 0; i7 < i3; i7++) {
            fArr5[i7] = new float[i];
        }
        float[][] fArr6 = new float[i3][];
        for (int i8 = 0; i8 < i3; i8++) {
            fArr6[i8] = new float[i3];
        }
        int i9 = 0;
        while (i9 < i3) {
            float[] fArr7 = fArr5[i9];
            System.arraycopy(fArr4[i9], 0, fArr7, 0, i);
            for (int i10 = 0; i10 < i9; i10++) {
                float[] fArr8 = fArr5[i10];
                float fDot = dot(fArr7, fArr8);
                for (int i11 = 0; i11 < i; i11++) {
                    fArr7[i11] = fArr7[i11] - (fArr8[i11] * fDot);
                }
            }
            float fSqrt = (float) Math.sqrt(dot(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f = 1.0f / fSqrt;
            for (int i12 = 0; i12 < i; i12++) {
                fArr7[i12] = fArr7[i12] * f;
            }
            float[] fArr9 = fArr6[i9];
            int i13 = 0;
            while (i13 < i3) {
                fArr9[i13] = i13 < i9 ? 0.0f : dot(fArr7, fArr4[i13]);
                i13++;
            }
            i9++;
        }
        for (int i14 = i2; -1 < i14; i14--) {
            float fDot2 = dot(fArr5[i14], fArr2);
            float[] fArr10 = fArr6[i14];
            int i15 = i14 + 1;
            if (i15 <= i2) {
                int i16 = i2;
                while (true) {
                    fDot2 -= fArr10[i16] * fArr3[i16];
                    if (i16 != i15) {
                        i16--;
                    }
                }
            }
            fArr3[i14] = fDot2 / fArr10[i14];
        }
    }
}
