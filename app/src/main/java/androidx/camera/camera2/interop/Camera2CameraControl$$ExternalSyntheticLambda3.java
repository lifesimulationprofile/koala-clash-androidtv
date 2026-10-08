package androidx.camera.camera2.interop;

import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.zxing.WriterException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraControl$$ExternalSyntheticLambda3 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Camera2CameraControl f$0;

    public /* synthetic */ Camera2CameraControl$$ExternalSyntheticLambda3(Camera2CameraControl camera2CameraControl, int i) {
        this.$r8$classId = i;
        this.f$0 = camera2CameraControl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
        switch (this.$r8$classId) {
            case 0:
                final Camera2CameraControl camera2CameraControl = this.f$0;
                final int i = 1;
                camera2CameraControl.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.interop.Camera2CameraControl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                Camera2CameraControl camera2CameraControl2 = camera2CameraControl;
                                camera2CameraControl2.mPendingUpdate = true;
                                WriterException writerException = new WriterException("Camera2CameraControl was updated with new options.");
                                CallbackToFutureAdapter.Completer completer2 = camera2CameraControl2.mCompleter;
                                if (completer2 != null) {
                                    completer2.setException(writerException);
                                    camera2CameraControl2.mCompleter = null;
                                }
                                camera2CameraControl2.mCompleter = completer;
                                if (camera2CameraControl2.mIsActive) {
                                    Camera2CameraControlImpl camera2CameraControlImpl = camera2CameraControl2.mCamera2CameraControlImpl;
                                    camera2CameraControlImpl.getClass();
                                    Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(2, camera2CameraControlImpl))).addListener(new Preview$$ExternalSyntheticLambda0(9, camera2CameraControl2), camera2CameraControl2.mExecutor);
                                    camera2CameraControl2.mPendingUpdate = false;
                                }
                                break;
                            default:
                                Camera2CameraControl camera2CameraControl3 = camera2CameraControl;
                                camera2CameraControl3.mPendingUpdate = true;
                                WriterException writerException2 = new WriterException("Camera2CameraControl was updated with new options.");
                                CallbackToFutureAdapter.Completer completer3 = camera2CameraControl3.mCompleter;
                                if (completer3 != null) {
                                    completer3.setException(writerException2);
                                    camera2CameraControl3.mCompleter = null;
                                }
                                camera2CameraControl3.mCompleter = completer;
                                if (camera2CameraControl3.mIsActive) {
                                    Camera2CameraControlImpl camera2CameraControlImpl2 = camera2CameraControl3.mCamera2CameraControlImpl;
                                    camera2CameraControlImpl2.getClass();
                                    Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(2, camera2CameraControlImpl2))).addListener(new Preview$$ExternalSyntheticLambda0(9, camera2CameraControl3), camera2CameraControl3.mExecutor);
                                    camera2CameraControl3.mPendingUpdate = false;
                                }
                                break;
                        }
                    }
                });
                return "addCaptureRequestOptions";
            default:
                final Camera2CameraControl camera2CameraControl2 = this.f$0;
                final int i2 = 0;
                camera2CameraControl2.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.interop.Camera2CameraControl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                Camera2CameraControl camera2CameraControl3 = camera2CameraControl2;
                                camera2CameraControl3.mPendingUpdate = true;
                                WriterException writerException = new WriterException("Camera2CameraControl was updated with new options.");
                                CallbackToFutureAdapter.Completer completer2 = camera2CameraControl3.mCompleter;
                                if (completer2 != null) {
                                    completer2.setException(writerException);
                                    camera2CameraControl3.mCompleter = null;
                                }
                                camera2CameraControl3.mCompleter = completer;
                                if (camera2CameraControl3.mIsActive) {
                                    Camera2CameraControlImpl camera2CameraControlImpl = camera2CameraControl3.mCamera2CameraControlImpl;
                                    camera2CameraControlImpl.getClass();
                                    Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(2, camera2CameraControlImpl))).addListener(new Preview$$ExternalSyntheticLambda0(9, camera2CameraControl3), camera2CameraControl3.mExecutor);
                                    camera2CameraControl3.mPendingUpdate = false;
                                }
                                break;
                            default:
                                Camera2CameraControl camera2CameraControl4 = camera2CameraControl2;
                                camera2CameraControl4.mPendingUpdate = true;
                                WriterException writerException2 = new WriterException("Camera2CameraControl was updated with new options.");
                                CallbackToFutureAdapter.Completer completer3 = camera2CameraControl4.mCompleter;
                                if (completer3 != null) {
                                    completer3.setException(writerException2);
                                    camera2CameraControl4.mCompleter = null;
                                }
                                camera2CameraControl4.mCompleter = completer;
                                if (camera2CameraControl4.mIsActive) {
                                    Camera2CameraControlImpl camera2CameraControlImpl2 = camera2CameraControl4.mCamera2CameraControlImpl;
                                    camera2CameraControlImpl2.getClass();
                                    Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(2, camera2CameraControlImpl2))).addListener(new Preview$$ExternalSyntheticLambda0(9, camera2CameraControl4), camera2CameraControl4.mExecutor);
                                    camera2CameraControl4.mPendingUpdate = false;
                                }
                                break;
                        }
                    }
                });
                return "clearCaptureRequestOptions";
        }
    }
}
