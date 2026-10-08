package androidx.camera.camera2.interop;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraControl {
    public final Camera2CameraControlImpl mCamera2CameraControlImpl;
    public CallbackToFutureAdapter.Completer mCompleter;
    public final SequentialExecutor mExecutor;
    public boolean mIsActive = false;
    public boolean mPendingUpdate = false;
    public final Object mLock = new Object();
    public ImageCapture.Builder mBuilder = new ImageCapture.Builder(1);

    public Camera2CameraControl(Camera2CameraControlImpl camera2CameraControlImpl, SequentialExecutor sequentialExecutor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = sequentialExecutor;
    }

    public final void applyOptionsToBuilder(ImageCapture.Builder builder) {
        synchronized (this.mLock) {
            MutableOptionsBundle mutableOptionsBundle = this.mBuilder.mMutableConfig;
            Config.OptionPriority optionPriority = Config.OptionPriority.ALWAYS_OVERRIDE;
            for (AutoValue_Config_Option autoValue_Config_Option : mutableOptionsBundle.listOptions()) {
                builder.mMutableConfig.insertOption(autoValue_Config_Option, optionPriority, mutableOptionsBundle.retrieveOption(autoValue_Config_Option));
            }
        }
    }
}
