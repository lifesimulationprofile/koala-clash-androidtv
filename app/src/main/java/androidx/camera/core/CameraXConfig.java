package androidx.camera.core;

import android.os.Handler;
import androidx.camera.camera2.Camera2Config$$ExternalSyntheticLambda0;
import androidx.camera.camera2.Camera2Config$$ExternalSyntheticLambda1;
import androidx.camera.camera2.Camera2Config$$ExternalSyntheticLambda2;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.internal.TargetConfig;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraXConfig implements TargetConfig {
    public final OptionsBundle mConfig;
    public static final AutoValue_Config_Option OPTION_CAMERA_FACTORY_PROVIDER = new AutoValue_Config_Option("camerax.core.appConfig.cameraFactoryProvider", Camera2Config$$ExternalSyntheticLambda0.class, null);
    public static final AutoValue_Config_Option OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = new AutoValue_Config_Option("camerax.core.appConfig.deviceSurfaceManagerProvider", Camera2Config$$ExternalSyntheticLambda1.class, null);
    public static final AutoValue_Config_Option OPTION_USECASE_CONFIG_FACTORY_PROVIDER = new AutoValue_Config_Option("camerax.core.appConfig.useCaseConfigFactoryProvider", Camera2Config$$ExternalSyntheticLambda2.class, null);
    public static final AutoValue_Config_Option OPTION_CAMERA_EXECUTOR = new AutoValue_Config_Option("camerax.core.appConfig.cameraExecutor", Executor.class, null);
    public static final AutoValue_Config_Option OPTION_SCHEDULER_HANDLER = new AutoValue_Config_Option("camerax.core.appConfig.schedulerHandler", Handler.class, null);
    public static final AutoValue_Config_Option OPTION_MIN_LOGGING_LEVEL = new AutoValue_Config_Option("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE, null);
    public static final AutoValue_Config_Option OPTION_AVAILABLE_CAMERAS_LIMITER = new AutoValue_Config_Option("camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class, null);
    public static final AutoValue_Config_Option OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = new AutoValue_Config_Option("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE, null);
    public static final AutoValue_Config_Option OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY = new AutoValue_Config_Option("camerax.core.appConfig.cameraProviderInitRetryPolicy", RetryPolicy.class, null);
    public static final AutoValue_Config_Option OPTION_QUIRK_SETTINGS = new AutoValue_Config_Option("camerax.core.appConfig.quirksSettings", QuirkSettings.class, null);

    public CameraXConfig(OptionsBundle optionsBundle) {
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

    public final CameraSelector getAvailableCamerasLimiter() {
        Object objRetrieveOption;
        try {
            objRetrieveOption = this.mConfig.retrieveOption(OPTION_AVAILABLE_CAMERAS_LIMITER);
        } catch (IllegalArgumentException unused) {
            objRetrieveOption = null;
        }
        return (CameraSelector) objRetrieveOption;
    }

    public final Camera2Config$$ExternalSyntheticLambda0 getCameraFactoryProvider() {
        Object objRetrieveOption;
        try {
            objRetrieveOption = this.mConfig.retrieveOption(OPTION_CAMERA_FACTORY_PROVIDER);
        } catch (IllegalArgumentException unused) {
            objRetrieveOption = null;
        }
        return (Camera2Config$$ExternalSyntheticLambda0) objRetrieveOption;
    }

    public final long getCameraOpenRetryMaxTimeoutInMillisWhileResuming() {
        AutoValue_Config_Option autoValue_Config_Option = OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING;
        Object objRetrieveOption = -1L;
        OptionsBundle optionsBundle = this.mConfig;
        optionsBundle.getClass();
        try {
            objRetrieveOption = optionsBundle.retrieveOption(autoValue_Config_Option);
        } catch (IllegalArgumentException unused) {
        }
        return ((Long) objRetrieveOption).longValue();
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public final Config getConfig() {
        return this.mConfig;
    }

    public final Camera2Config$$ExternalSyntheticLambda1 getDeviceSurfaceManagerProvider() {
        Object objRetrieveOption;
        try {
            objRetrieveOption = this.mConfig.retrieveOption(OPTION_DEVICE_SURFACE_MANAGER_PROVIDER);
        } catch (IllegalArgumentException unused) {
            objRetrieveOption = null;
        }
        return (Camera2Config$$ExternalSyntheticLambda1) objRetrieveOption;
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(AutoValue_Config_Option autoValue_Config_Option) {
        return getConfig().getOptionPriority(autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(AutoValue_Config_Option autoValue_Config_Option) {
        return getConfig().getPriorities(autoValue_Config_Option);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName() {
        throw null;
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName(String str) {
        throw null;
    }

    public final Camera2Config$$ExternalSyntheticLambda2 getUseCaseConfigFactoryProvider() {
        Object objRetrieveOption;
        try {
            objRetrieveOption = this.mConfig.retrieveOption(OPTION_USECASE_CONFIG_FACTORY_PROVIDER);
        } catch (IllegalArgumentException unused) {
            objRetrieveOption = null;
        }
        return (Camera2Config$$ExternalSyntheticLambda2) objRetrieveOption;
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

    @Override // androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option, Object obj) {
        return getConfig().retrieveOption(autoValue_Config_Option, obj);
    }
}
