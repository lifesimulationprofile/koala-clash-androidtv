package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraCaptureSessionCompatApi28Impl extends SurfaceRequest.AnonymousClass1 {
    @Override // androidx.camera.core.SurfaceRequest.AnonymousClass1
    public final int captureBurstRequests(ArrayList arrayList, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.val$requestCancellationCompleter).captureBurstRequests(arrayList, sequentialExecutor, captureCallback);
    }

    @Override // androidx.camera.core.SurfaceRequest.AnonymousClass1
    public final int setSingleRepeatingRequest(CaptureRequest captureRequest, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.val$requestCancellationCompleter).setSingleRepeatingRequest(captureRequest, sequentialExecutor, captureCallback);
    }
}
