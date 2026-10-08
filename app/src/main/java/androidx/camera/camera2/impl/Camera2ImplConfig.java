package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.impl.AutoValue_Config_Option;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2ImplConfig extends Toolbar.AnonymousClass1 {
    public static final AutoValue_Config_Option TEMPLATE_TYPE_OPTION = new AutoValue_Config_Option("camera2.captureRequest.templateType", Integer.TYPE, null);
    public static final AutoValue_Config_Option STREAM_USE_CASE_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.streamUseCase", Long.TYPE, null);
    public static final AutoValue_Config_Option DEVICE_STATE_CALLBACK_OPTION = new AutoValue_Config_Option("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class, null);
    public static final AutoValue_Config_Option SESSION_STATE_CALLBACK_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class, null);
    public static final AutoValue_Config_Option SESSION_CAPTURE_CALLBACK_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class, null);
    public static final AutoValue_Config_Option SESSION_PHYSICAL_CAMERA_ID_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.physicalCameraId", String.class, null);

    public static AutoValue_Config_Option createCaptureRequestOption(CaptureRequest.Key key) {
        return new AutoValue_Config_Option("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }
}
