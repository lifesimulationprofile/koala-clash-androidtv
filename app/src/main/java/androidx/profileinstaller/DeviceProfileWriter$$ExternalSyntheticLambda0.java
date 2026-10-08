package androidx.profileinstaller;

import android.content.Intent;
import android.content.IntentSender;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry$CallbackAndContract;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.view.PreviewView;
import java.io.Serializable;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DeviceProfileWriter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ DeviceProfileWriter$$ExternalSyntheticLambda0(int i, int i2, Object obj, Object obj2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((DeviceProfileWriter) this.f$0).mDiagnostics.onResultReceived(this.f$1, this.f$2);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1 = (ComponentActivity$activityResultRegistry$1) this.f$0;
                Serializable serializable = (Serializable) ((PreviewView.AnonymousClass1) this.f$2).this$0;
                String str = (String) componentActivity$activityResultRegistry$1.rcToKey.get(Integer.valueOf(this.f$1));
                if (str != null) {
                    ActivityResultRegistry$CallbackAndContract activityResultRegistry$CallbackAndContract = (ActivityResultRegistry$CallbackAndContract) componentActivity$activityResultRegistry$1.keyToCallback.get(str);
                    if ((activityResultRegistry$CallbackAndContract != null ? activityResultRegistry$CallbackAndContract.callback : null) != null) {
                        ActivityResultCallback activityResultCallback = activityResultRegistry$CallbackAndContract.callback;
                        if (componentActivity$activityResultRegistry$1.launchedKeys.remove(str)) {
                            activityResultCallback.onActivityResult(serializable);
                        }
                    } else {
                        componentActivity$activityResultRegistry$1.pendingResults.remove(str);
                        componentActivity$activityResultRegistry$1.parsedPendingResults.put(str, serializable);
                    }
                    break;
                }
                break;
            case 2:
                ((ComponentActivity$activityResultRegistry$1) this.f$0).dispatchResult(this.f$1, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f$2));
                break;
            case 3:
                ((CameraCaptureCallback) this.f$0).onCaptureFailed(this.f$1, (Path.Companion) this.f$2);
                break;
            case 4:
                ((CameraCaptureCallback) this.f$0).onCaptureCompleted(this.f$1, (CameraCaptureResult) this.f$2);
                break;
            case 5:
                ((CameraCaptureSession.CaptureCallback) ((CameraBurstCaptureCallback) this.f$0).mCallbackMap).onCaptureSequenceAborted((CameraCaptureSession) this.f$2, this.f$1);
                break;
            default:
                ((CameraDevice.StateCallback) ((Camera2CameraImpl.AnonymousClass2) this.f$0).val$completer).onError((CameraDevice) this.f$2, this.f$1);
                break;
        }
    }

    public /* synthetic */ DeviceProfileWriter$$ExternalSyntheticLambda0(Object obj, AutoCloseable autoCloseable, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$2 = autoCloseable;
        this.f$1 = i;
    }
}
