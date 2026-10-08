package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.internal.Camera2SessionOptionUnpacker;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageCaptureConfig implements UseCaseConfig, ImageOutputConfig, IoConfig {
    public static final AutoValue_Config_Option OPTION_BUFFER_FORMAT;
    public static final AutoValue_Config_Option OPTION_FLASH_MODE;
    public static final AutoValue_Config_Option OPTION_FLASH_TYPE;
    public static final AutoValue_Config_Option OPTION_IMAGE_CAPTURE_MODE;
    public static final AutoValue_Config_Option OPTION_IMAGE_READER_PROXY_PROVIDER;
    public static final AutoValue_Config_Option OPTION_OUTPUT_FORMAT;
    public static final AutoValue_Config_Option OPTION_POSTVIEW_ENABLED;
    public static final AutoValue_Config_Option OPTION_SCREEN_FLASH;
    public static final AutoValue_Config_Option OPTION_USE_SOFTWARE_JPEG_ENCODER;
    public final OptionsBundle mConfig;

    static {
        Class cls = Integer.TYPE;
        OPTION_IMAGE_CAPTURE_MODE = new AutoValue_Config_Option("camerax.core.imageCapture.captureMode", cls, null);
        OPTION_FLASH_MODE = new AutoValue_Config_Option("camerax.core.imageCapture.flashMode", cls, null);
        OPTION_BUFFER_FORMAT = new AutoValue_Config_Option("camerax.core.imageCapture.bufferFormat", Integer.class, null);
        OPTION_OUTPUT_FORMAT = new AutoValue_Config_Option("camerax.core.imageCapture.outputFormat", Integer.class, null);
        OPTION_IMAGE_READER_PROXY_PROVIDER = new AutoValue_Config_Option("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class, null);
        OPTION_USE_SOFTWARE_JPEG_ENCODER = new AutoValue_Config_Option("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE, null);
        OPTION_FLASH_TYPE = new AutoValue_Config_Option("camerax.core.imageCapture.flashType", cls, null);
        OPTION_SCREEN_FLASH = new AutoValue_Config_Option("camerax.core.imageCapture.screenFlash", ImageCapture.ScreenFlash.class, null);
        OPTION_POSTVIEW_ENABLED = new AutoValue_Config_Option("camerax.core.useCase.isPostviewEnabled", Boolean.class, null);
    }

    public ImageCaptureConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ boolean containsOption(AutoValue_Config_Option autoValue_Config_Option) {
        return getConfig().containsOption(autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ void findOptions(CaptureRequestOptions$Builder$$ExternalSyntheticLambda0 captureRequestOptions$Builder$$ExternalSyntheticLambda0) {
        getConfig().findOptions(captureRequestOptions$Builder$$ExternalSyntheticLambda0);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getAppTargetRotation() {
        return ((Integer) retrieveOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, -1)).intValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ UseCaseConfigFactory.CaptureType getCaptureType() {
        return ImageAnalysis$$ExternalSyntheticLambda1.$default$getCaptureType(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public final Config getConfig() {
        return this.mConfig;
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ ArrayList getCustomOrderedResolutions() {
        return ImageOutputConfig.CC.$default$getCustomOrderedResolutions(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final CaptureConfig getDefaultCaptureConfig() {
        return (CaptureConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, null);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final Size getDefaultResolution() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return (Size) retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, null);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final SessionConfig getDefaultSessionConfig() {
        return (SessionConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final SessionConfig getDefaultSessionConfig$1() {
        return (SessionConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, null);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public final /* synthetic */ DynamicRange getDynamicRange() {
        return ImageAnalysis$$ExternalSyntheticLambda1.$default$getDynamicRange(this);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public final int getInputFormat() {
        return ((Integer) getConfig().retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final Size getMaxResolution() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return (Size) retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, null);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getMirrorMode() {
        return ((Integer) retrieveOption(ImageOutputConfig.OPTION_MIRROR_MODE, -1)).intValue();
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(AutoValue_Config_Option autoValue_Config_Option) {
        return getConfig().getOptionPriority(autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getPreviewStabilizationMode() {
        return ((Integer) retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue();
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(AutoValue_Config_Option autoValue_Config_Option) {
        return getConfig().getPriorities(autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final ResolutionSelector getResolutionSelector() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return (ResolutionSelector) retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final ResolutionSelector getResolutionSelector$1() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return (ResolutionSelector) retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, null);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final Camera2SessionOptionUnpacker getSessionOptionUnpacker() {
        return (Camera2SessionOptionUnpacker) retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, null);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final List getSupportedResolutions() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return (List) retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getSurfaceOccupancyPriority() {
        return ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, 0)).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final int getTargetAspectRatio() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final Range getTargetFrameRate() {
        return (Range) retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, null);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName() {
        return ImageAnalysis$$ExternalSyntheticLambda1.$default$getTargetName(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final Size getTargetResolution() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return (Size) retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getTargetRotation() {
        return ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, 0)).intValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getVideoStabilizationMode() {
        return ((Integer) retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0)).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final boolean hasTargetAspectRatio() {
        int i = ImageOutputConfig.CC.$r8$clinit;
        return containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean isHighResolutionDisabled() {
        return ((Boolean) retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.FALSE)).booleanValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean isZslDisabled() {
        return ((Boolean) retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.FALSE)).booleanValue();
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Set listOptions() {
        return getConfig().listOptions();
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option) {
        return getConfig().retrieveOption(autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOptionWithPriority(AutoValue_Config_Option autoValue_Config_Option, Config.OptionPriority optionPriority) {
        return getConfig().retrieveOptionWithPriority(autoValue_Config_Option, optionPriority);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName(String str) {
        return ImageAnalysis$$ExternalSyntheticLambda1.$default$getTargetName(this, str);
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option, Object obj) {
        return getConfig().retrieveOption(autoValue_Config_Option, obj);
    }
}
