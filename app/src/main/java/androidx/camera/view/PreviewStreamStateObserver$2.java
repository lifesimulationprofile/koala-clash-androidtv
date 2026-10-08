package androidx.camera.view;

import android.util.ArrayMap;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewStreamStateObserver$2 extends CameraCaptureCallback {
    public final /* synthetic */ int $r8$classId = 1;
    public Object val$cameraInfo;
    public Object val$completer;

    public /* synthetic */ PreviewStreamStateObserver$2() {
    }

    @Override // androidx.camera.core.impl.CameraCaptureCallback
    public void onCaptureCancelled(int i) {
        switch (this.$r8$classId) {
            case 1:
                for (CameraCaptureCallback cameraCaptureCallback : (HashSet) this.val$completer) {
                    try {
                        ((Executor) ((ArrayMap) this.val$cameraInfo).get(cameraCaptureCallback)).execute(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(i, 1, cameraCaptureCallback));
                    } catch (RejectedExecutionException e) {
                        Logger.e("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e);
                    }
                }
                break;
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureCallback
    public final void onCaptureCompleted(int i, CameraCaptureResult cameraCaptureResult) {
        switch (this.$r8$classId) {
            case 0:
                ((CallbackToFutureAdapter.Completer) this.val$completer).set(null);
                ((CameraInfoInternal) this.val$cameraInfo).removeSessionCaptureCallback(this);
                break;
            default:
                for (CameraCaptureCallback cameraCaptureCallback : (HashSet) this.val$completer) {
                    try {
                        ((Executor) ((ArrayMap) this.val$cameraInfo).get(cameraCaptureCallback)).execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(i, 4, cameraCaptureCallback, cameraCaptureResult));
                    } catch (RejectedExecutionException e) {
                        Logger.e("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e);
                    }
                }
                break;
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureCallback
    public void onCaptureFailed(int i, Path.Companion companion) {
        switch (this.$r8$classId) {
            case 1:
                for (CameraCaptureCallback cameraCaptureCallback : (HashSet) this.val$completer) {
                    try {
                        ((Executor) ((ArrayMap) this.val$cameraInfo).get(cameraCaptureCallback)).execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(i, 3, cameraCaptureCallback, companion));
                    } catch (RejectedExecutionException e) {
                        Logger.e("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e);
                    }
                }
                break;
        }
    }

    public PreviewStreamStateObserver$2(CallbackToFutureAdapter.Completer completer, CameraInfoInternal cameraInfoInternal) {
        this.val$completer = completer;
        this.val$cameraInfo = cameraInfoInternal;
    }
}
