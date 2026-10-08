package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import kotlin.io.ByteStreamsKt;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TorchControl {
    public final Camera2CameraControlImpl mCamera2CameraControlImpl;
    public CallbackToFutureAdapter.Completer mEnableTorchCompleter;
    public final SequentialExecutor mExecutor;
    public final boolean mHasFlashUnit;
    public boolean mIsActive;
    public boolean mTargetTorchEnabled;
    public final MutableLiveData mTorchState = new MutableLiveData(0);

    public TorchControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, SequentialExecutor sequentialExecutor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = sequentialExecutor;
        this.mHasFlashUnit = ByteStreamsKt.isFlashAvailable(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(3, cameraCharacteristicsCompat));
        camera2CameraControlImpl.addCaptureResultListener(new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.TorchControl$$ExternalSyntheticLambda1
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                TorchControl torchControl = this.f$0;
                if (torchControl.mEnableTorchCompleter != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == torchControl.mTargetTorchEnabled) {
                        torchControl.mEnableTorchCompleter.set(null);
                        torchControl.mEnableTorchCompleter = null;
                    }
                }
                return false;
            }
        });
    }

    public static void setLiveDataValue(MutableLiveData mutableLiveData, Integer num) {
        if (CharsKt.isMainThread()) {
            mutableLiveData.setValue(num);
        } else {
            mutableLiveData.postValue(num);
        }
    }
}
