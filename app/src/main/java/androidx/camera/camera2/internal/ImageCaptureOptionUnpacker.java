package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import coil.intercept.RealInterceptorChain;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageCaptureOptionUnpacker extends Camera2CaptureOptionUnpacker {
    public static final ImageCaptureOptionUnpacker INSTANCE;

    static {
        new ByteString.Companion(2);
        INSTANCE = new ImageCaptureOptionUnpacker();
    }

    @Override // androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker
    public final void unpack(UseCaseConfig useCaseConfig, RealInterceptorChain realInterceptorChain) {
        super.unpack(useCaseConfig, realInterceptorChain);
        if (!(useCaseConfig instanceof ImageCaptureConfig)) {
            throw new IllegalArgumentException("config is not ImageCaptureConfig");
        }
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) useCaseConfig;
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        AutoValue_Config_Option autoValue_Config_Option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (((OptionsBundle) imageCaptureConfig.getConfig()).containsOption(autoValue_Config_Option)) {
            int iIntValue = ((Integer) imageCaptureConfig.getConfig().retrieveOption(autoValue_Config_Option)).intValue();
            if (((ImageCapturePixelHDRPlusQuirk) DeviceQuirks.sQuirks.get(ImageCapturePixelHDRPlusQuirk.class)) != null) {
                if (iIntValue == 0) {
                    CaptureRequest.Key key = CaptureRequest.CONTROL_ENABLE_ZSL;
                    mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), Boolean.TRUE);
                } else if (iIntValue == 1) {
                    CaptureRequest.Key key2 = CaptureRequest.CONTROL_ENABLE_ZSL;
                    mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.createCaptureRequestOption(key2), Boolean.FALSE);
                }
            }
        }
        realInterceptorChain.addImplementationOptions(new Camera2ImplConfig(14, OptionsBundle.from(mutableOptionsBundleCreate)));
    }
}
