package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class CameraManagerCompatApi28Impl extends SurfaceRequest.AnonymousClass1 {
    public static boolean isDndFailCase(RuntimeException runtimeException) {
        StackTraceElement[] stackTrace;
        if (Build.VERSION.SDK_INT == 28) {
            if ((!runtimeException.getClass().equals(RuntimeException.class) || (stackTrace = runtimeException.getStackTrace()) == null || stackTrace.length < 0) ? false : "_enableShutterSound".equals(stackTrace[0].getMethodName())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.SurfaceRequest.AnonymousClass1
    public CameraCharacteristics getCameraCharacteristics(String str) throws CameraAccessExceptionCompat {
        try {
            return super.getCameraCharacteristics(str);
        } catch (RuntimeException e) {
            if (isDndFailCase(e)) {
                throw new CameraAccessExceptionCompat(e);
            }
            throw e;
        }
    }

    @Override // androidx.camera.core.SurfaceRequest.AnonymousClass1
    public void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            ((CameraManager) this.val$requestCancellationCompleter).openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e) {
            throw new CameraAccessExceptionCompat(e);
        } catch (IllegalArgumentException e2) {
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            if (!isDndFailCase(e4)) {
                throw e4;
            }
            throw new CameraAccessExceptionCompat(e4);
        }
    }

    @Override // androidx.camera.core.SurfaceRequest.AnonymousClass1
    public final void registerAvailabilityCallback(SequentialExecutor sequentialExecutor, Camera2CameraImpl.CameraAvailability cameraAvailability) {
        ((CameraManager) this.val$requestCancellationCompleter).registerAvailabilityCallback(sequentialExecutor, cameraAvailability);
    }

    @Override // androidx.camera.core.SurfaceRequest.AnonymousClass1
    public final void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        ((CameraManager) this.val$requestCancellationCompleter).unregisterAvailabilityCallback(availabilityCallback);
    }
}
