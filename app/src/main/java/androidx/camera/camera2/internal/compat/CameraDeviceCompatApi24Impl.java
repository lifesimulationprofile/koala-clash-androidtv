package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.SurfaceRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class CameraDeviceCompatApi24Impl extends SurfaceRequest.AnonymousClass1 {
    @Override // androidx.camera.core.SurfaceRequest.AnonymousClass1
    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        CameraDevice cameraDevice = (CameraDevice) this.val$requestCancellationCompleter;
        SurfaceRequest.AnonymousClass1.checkPreconditions(cameraDevice, sessionConfigurationCompat);
        SessionConfigurationCompat.SessionConfigurationCompatImpl sessionConfigurationCompatImpl = sessionConfigurationCompat.mImpl;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper(sessionConfigurationCompatImpl.getExecutor(), sessionConfigurationCompatImpl.getStateCallback());
        List outputConfigurations = sessionConfigurationCompatImpl.getOutputConfigurations();
        CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 = (CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21) this.val$requestCancellationFuture;
        cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.getClass();
        Handler handler = cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.mCompatHandler;
        InputConfigurationCompat inputConfiguration = sessionConfigurationCompatImpl.getInputConfiguration();
        try {
            if (inputConfiguration != null) {
                InputConfiguration inputConfiguration2 = inputConfiguration.mImpl.mObject;
                inputConfiguration2.getClass();
                cameraDevice.createReprocessableCaptureSessionByConfigurations(inputConfiguration2, SessionConfigurationCompat.transformFromCompat(outputConfigurations), cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
            } else if (sessionConfigurationCompatImpl.getSessionType() == 1) {
                cameraDevice.createConstrainedHighSpeedCaptureSession(SurfaceRequest.AnonymousClass1.unpackSurfaces(outputConfigurations), cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
            } else {
                cameraDevice.createCaptureSessionByOutputConfigurations(SessionConfigurationCompat.transformFromCompat(outputConfigurations), cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
            }
        } catch (CameraAccessException e) {
            throw new CameraAccessExceptionCompat(e);
        }
    }
}
