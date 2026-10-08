package androidx.camera.camera2.internal;

import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.zxing.WriterException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda12 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda12(int i, Object obj, boolean z) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) this.f$0;
                boolean z = this.f$1;
                camera2CameraImpl.mIsActiveResumingMode = z;
                if (z && camera2CameraImpl.mState == 4) {
                    camera2CameraImpl.tryForceOpenCameraDevice(false);
                    break;
                }
                break;
            default:
                Camera2CameraControl camera2CameraControl = (Camera2CameraControl) this.f$0;
                boolean z2 = this.f$1;
                if (camera2CameraControl.mIsActive != z2) {
                    camera2CameraControl.mIsActive = z2;
                    if (!z2) {
                        WriterException writerException = new WriterException("The camera control has became inactive.");
                        CallbackToFutureAdapter.Completer completer = camera2CameraControl.mCompleter;
                        if (completer != null) {
                            completer.setException(writerException);
                            camera2CameraControl.mCompleter = null;
                        }
                    } else if (camera2CameraControl.mPendingUpdate) {
                        Camera2CameraControlImpl camera2CameraControlImpl = camera2CameraControl.mCamera2CameraControlImpl;
                        camera2CameraControlImpl.getClass();
                        Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(2, camera2CameraControlImpl))).addListener(new Preview$$ExternalSyntheticLambda0(9, camera2CameraControl), camera2CameraControl.mExecutor);
                        camera2CameraControl.mPendingUpdate = false;
                    }
                    break;
                }
                break;
        }
    }
}
