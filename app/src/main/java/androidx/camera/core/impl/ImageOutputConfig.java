package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface ImageOutputConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_APP_TARGET_ROTATION;
    public static final AutoValue_Config_Option OPTION_CUSTOM_ORDERED_RESOLUTIONS;
    public static final AutoValue_Config_Option OPTION_DEFAULT_RESOLUTION;
    public static final AutoValue_Config_Option OPTION_MAX_RESOLUTION;
    public static final AutoValue_Config_Option OPTION_MIRROR_MODE;
    public static final AutoValue_Config_Option OPTION_RESOLUTION_SELECTOR;
    public static final AutoValue_Config_Option OPTION_SUPPORTED_RESOLUTIONS;
    public static final AutoValue_Config_Option OPTION_TARGET_ASPECT_RATIO = new AutoValue_Config_Option("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class, null);
    public static final AutoValue_Config_Option OPTION_TARGET_RESOLUTION;
    public static final AutoValue_Config_Option OPTION_TARGET_ROTATION;

    /* JADX INFO: renamed from: androidx.camera.core.impl.ImageOutputConfig$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class CC {
        public static final /* synthetic */ int $r8$clinit = 0;

        public static ArrayList $default$getCustomOrderedResolutions(ImageOutputConfig imageOutputConfig) {
            List list = (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, null);
            if (list != null) {
                return new ArrayList(list);
            }
            return null;
        }

        static {
            AutoValue_Config_Option autoValue_Config_Option = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        }

        public static void validateConfig(ImageOutputConfig imageOutputConfig) {
            boolean zHasTargetAspectRatio = imageOutputConfig.hasTargetAspectRatio();
            boolean z = imageOutputConfig.getTargetResolution() != null;
            if (zHasTargetAspectRatio && z) {
                throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
            }
            if (imageOutputConfig.getResolutionSelector$1() != null) {
                if (zHasTargetAspectRatio || z) {
                    throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
                }
            }
        }
    }

    static {
        Class cls = Integer.TYPE;
        OPTION_TARGET_ROTATION = new AutoValue_Config_Option("camerax.core.imageOutput.targetRotation", cls, null);
        OPTION_APP_TARGET_ROTATION = new AutoValue_Config_Option("camerax.core.imageOutput.appTargetRotation", cls, null);
        OPTION_MIRROR_MODE = new AutoValue_Config_Option("camerax.core.imageOutput.mirrorMode", cls, null);
        OPTION_TARGET_RESOLUTION = new AutoValue_Config_Option("camerax.core.imageOutput.targetResolution", Size.class, null);
        OPTION_DEFAULT_RESOLUTION = new AutoValue_Config_Option("camerax.core.imageOutput.defaultResolution", Size.class, null);
        OPTION_MAX_RESOLUTION = new AutoValue_Config_Option("camerax.core.imageOutput.maxResolution", Size.class, null);
        OPTION_SUPPORTED_RESOLUTIONS = new AutoValue_Config_Option("camerax.core.imageOutput.supportedResolutions", List.class, null);
        OPTION_RESOLUTION_SELECTOR = new AutoValue_Config_Option("camerax.core.imageOutput.resolutionSelector", ResolutionSelector.class, null);
        OPTION_CUSTOM_ORDERED_RESOLUTIONS = new AutoValue_Config_Option("camerax.core.imageOutput.customOrderedResolutions", List.class, null);
    }

    int getAppTargetRotation();

    ArrayList getCustomOrderedResolutions();

    Size getDefaultResolution();

    Size getMaxResolution();

    int getMirrorMode();

    ResolutionSelector getResolutionSelector();

    ResolutionSelector getResolutionSelector$1();

    List getSupportedResolutions();

    int getTargetAspectRatio();

    Size getTargetResolution();

    int getTargetRotation();

    boolean hasTargetAspectRatio();
}
