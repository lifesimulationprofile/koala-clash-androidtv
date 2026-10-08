package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker;
import androidx.camera.camera2.internal.Camera2SessionOptionUnpacker;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.internal.TargetConfig;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface UseCaseConfig extends TargetConfig, ImageInputConfig {
    public static final AutoValue_Config_Option OPTION_CAPTURE_TYPE;
    public static final AutoValue_Config_Option OPTION_HIGH_RESOLUTION_DISABLED;
    public static final AutoValue_Config_Option OPTION_PREVIEW_STABILIZATION_MODE;
    public static final AutoValue_Config_Option OPTION_SURFACE_OCCUPANCY_PRIORITY;
    public static final AutoValue_Config_Option OPTION_TARGET_FRAME_RATE;
    public static final AutoValue_Config_Option OPTION_VIDEO_STABILIZATION_MODE;
    public static final AutoValue_Config_Option OPTION_ZSL_DISABLED;
    public static final AutoValue_Config_Option OPTION_DEFAULT_SESSION_CONFIG = new AutoValue_Config_Option("camerax.core.useCase.defaultSessionConfig", SessionConfig.class, null);
    public static final AutoValue_Config_Option OPTION_DEFAULT_CAPTURE_CONFIG = new AutoValue_Config_Option("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class, null);
    public static final AutoValue_Config_Option OPTION_SESSION_CONFIG_UNPACKER = new AutoValue_Config_Option("camerax.core.useCase.sessionConfigUnpacker", Camera2SessionOptionUnpacker.class, null);
    public static final AutoValue_Config_Option OPTION_CAPTURE_CONFIG_UNPACKER = new AutoValue_Config_Option("camerax.core.useCase.captureConfigUnpacker", Camera2CaptureOptionUnpacker.class, null);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Builder extends ExtendableBuilder {
        UseCaseConfig getUseCaseConfig();
    }

    static {
        Class cls = Integer.TYPE;
        OPTION_SURFACE_OCCUPANCY_PRIORITY = new AutoValue_Config_Option("camerax.core.useCase.surfaceOccupancyPriority", cls, null);
        OPTION_TARGET_FRAME_RATE = new AutoValue_Config_Option("camerax.core.useCase.targetFrameRate", Range.class, null);
        Class cls2 = Boolean.TYPE;
        OPTION_ZSL_DISABLED = new AutoValue_Config_Option("camerax.core.useCase.zslDisabled", cls2, null);
        OPTION_HIGH_RESOLUTION_DISABLED = new AutoValue_Config_Option("camerax.core.useCase.highResolutionDisabled", cls2, null);
        OPTION_CAPTURE_TYPE = new AutoValue_Config_Option("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class, null);
        OPTION_PREVIEW_STABILIZATION_MODE = new AutoValue_Config_Option("camerax.core.useCase.previewStabilizationMode", cls, null);
        OPTION_VIDEO_STABILIZATION_MODE = new AutoValue_Config_Option("camerax.core.useCase.videoStabilizationMode", cls, null);
    }

    UseCaseConfigFactory.CaptureType getCaptureType();

    CaptureConfig getDefaultCaptureConfig();

    SessionConfig getDefaultSessionConfig();

    SessionConfig getDefaultSessionConfig$1();

    int getPreviewStabilizationMode();

    Camera2SessionOptionUnpacker getSessionOptionUnpacker();

    int getSurfaceOccupancyPriority();

    Range getTargetFrameRate();

    int getVideoStabilizationMode();

    boolean isHighResolutionDisabled();

    boolean isZslDisabled();
}
