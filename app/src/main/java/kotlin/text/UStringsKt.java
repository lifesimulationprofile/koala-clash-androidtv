package kotlin.text;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.CameraX;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$2;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class UStringsKt {
    public static ChainingListenableFuture getInstance(Context context) {
        CallbackToFutureAdapter.SafeFuture future;
        ProcessCameraProvider processCameraProvider = ProcessCameraProvider.sAppInstance;
        synchronized (processCameraProvider.mLock) {
            future = processCameraProvider.mCameraXInitializeFuture;
            if (future == null) {
                future = CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(10, processCameraProvider, new CameraX(context)));
                processCameraProvider.mCameraXInitializeFuture = future;
            }
        }
        OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(11, new NavHostControllerKt$NavControllerSaver$2(context, 1));
        return Futures.transformAsync(future, new PreviewView.AnonymousClass1(18, onBackPressedDispatcher$$ExternalSyntheticLambda0), HexFormatKt.directExecutor());
    }

    public static final UInt toUIntOrNull(String str) {
        int i;
        CharsKt.checkRadix(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i = 0;
        }
        int i3 = 119304647;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            int i4 = i2 ^ Integer.MIN_VALUE;
            if (Integer.compare(i4, i3 ^ Integer.MIN_VALUE) > 0) {
                if (i3 != 119304647) {
                    return null;
                }
                i3 = (int) ((((long) (-1)) & 4294967295L) / (4294967295L & ((long) 10)));
                if (Integer.compare(i4, i3 ^ Integer.MIN_VALUE) > 0) {
                    return null;
                }
            }
            int i5 = i2 * 10;
            int i6 = iDigit + i5;
            if (Integer.compare(i6 ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i++;
            i2 = i6;
        }
        return new UInt(i2);
    }

    public static final ULong toULongOrNull(String str) {
        int i;
        int i2 = 10;
        CharsKt.checkRadix(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        char cCharAt = str.charAt(0);
        int i3 = 1;
        if (Intrinsics.compare((int) cCharAt, 48) >= 0) {
            i = 0;
        } else {
            if (length == 1 || cCharAt != '+') {
                return null;
            }
            i = 1;
        }
        long j = 10;
        long j2 = 0;
        long j3 = 512409557603043100L;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), i2);
            if (iDigit < 0) {
                return null;
            }
            int i4 = length;
            long j4 = j2 ^ Long.MIN_VALUE;
            int i5 = i;
            if (Long.compare(j4, j3 ^ Long.MIN_VALUE) <= 0) {
                j = j;
            } else {
                if (j3 != 512409557603043100L) {
                    return null;
                }
                if (j < 0) {
                    j3 = Long.MAX_VALUE < (j ^ Long.MIN_VALUE) ? 0L : 1L;
                } else {
                    long j5 = (Long.MAX_VALUE / j) << i3;
                    j3 = j5 + ((long) ((((-1) - (j5 * j)) ^ Long.MIN_VALUE) >= (j ^ Long.MIN_VALUE) ? i3 : 0));
                }
                if (Long.compare(j4, j3 ^ Long.MIN_VALUE) > 0) {
                    return null;
                }
            }
            long j6 = j2 * j;
            long j7 = (((long) iDigit) & 4294967295L) + j6;
            if (Long.compare(j7 ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i = i5 + 1;
            j2 = j7;
            length = i4;
            j = j;
            i2 = 10;
            i3 = 1;
        }
        return new ULong(j2);
    }
}
