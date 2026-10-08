package androidx.camera.core.impl;

import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface CameraInfoInternal {
    void addSessionCaptureCallback(Executor executor, PreviewStreamStateObserver$2 previewStreamStateObserver$2);

    String getCameraId();

    Quirks getCameraQuirks();

    CameraInfoInternal getImplementation();

    String getImplementationType();

    int getLensFacing();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i);

    List getSupportedResolutions(int i);

    LiveData getTorchState();

    boolean hasFlashUnit();

    void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback);
}
