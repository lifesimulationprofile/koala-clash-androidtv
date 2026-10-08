package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface CameraConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_USECASE_CONFIG_FACTORY = new AutoValue_Config_Option("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class, null);
    public static final AutoValue_Config_Option OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = new AutoValue_Config_Option("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class, null);
    public static final AutoValue_Config_Option OPTION_SESSION_PROCESSOR = new AutoValue_Config_Option("camerax.core.camera.SessionProcessor", SessionProcessor.class, null);
    public static final AutoValue_Config_Option OPTION_POSTVIEW_SUPPORTED = new AutoValue_Config_Option("camerax.core.camera.isPostviewSupported", Boolean.class, null);
    public static final AutoValue_Config_Option OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED = new AutoValue_Config_Option("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class, null);
}
