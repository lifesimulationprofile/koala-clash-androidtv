package androidx.camera.camera2;

import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2Config$DefaultProvider {
    public CameraXConfig getCameraXConfig() {
        Camera2Config$$ExternalSyntheticLambda0 camera2Config$$ExternalSyntheticLambda0 = new Camera2Config$$ExternalSyntheticLambda0();
        Camera2Config$$ExternalSyntheticLambda1 camera2Config$$ExternalSyntheticLambda1 = new Camera2Config$$ExternalSyntheticLambda1();
        Camera2Config$$ExternalSyntheticLambda2 camera2Config$$ExternalSyntheticLambda2 = new Camera2Config$$ExternalSyntheticLambda2();
        ImageCapture.Builder builder = new ImageCapture.Builder(2);
        AutoValue_Config_Option autoValue_Config_Option = CameraXConfig.OPTION_CAMERA_FACTORY_PROVIDER;
        MutableOptionsBundle mutableOptionsBundle = builder.mMutableConfig;
        mutableOptionsBundle.insertOption(autoValue_Config_Option, camera2Config$$ExternalSyntheticLambda0);
        mutableOptionsBundle.insertOption(CameraXConfig.OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, camera2Config$$ExternalSyntheticLambda1);
        mutableOptionsBundle.insertOption(CameraXConfig.OPTION_USECASE_CONFIG_FACTORY_PROVIDER, camera2Config$$ExternalSyntheticLambda2);
        return new CameraXConfig(OptionsBundle.from(mutableOptionsBundle));
    }
}
