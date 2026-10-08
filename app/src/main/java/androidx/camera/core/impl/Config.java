package androidx.camera.core.impl;

import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface Config {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class OptionPriority {
        public static final /* synthetic */ OptionPriority[] $VALUES;
        public static final OptionPriority ALWAYS_OVERRIDE;
        public static final OptionPriority OPTIONAL;
        public static final OptionPriority REQUIRED;

        static {
            OptionPriority optionPriority = new OptionPriority("ALWAYS_OVERRIDE", 0);
            ALWAYS_OVERRIDE = optionPriority;
            OptionPriority optionPriority2 = new OptionPriority("HIGH_PRIORITY_REQUIRED", 1);
            OptionPriority optionPriority3 = new OptionPriority("REQUIRED", 2);
            REQUIRED = optionPriority3;
            OptionPriority optionPriority4 = new OptionPriority("OPTIONAL", 3);
            OPTIONAL = optionPriority4;
            $VALUES = new OptionPriority[]{optionPriority, optionPriority2, optionPriority3, optionPriority4};
        }

        public static OptionPriority valueOf(String str) {
            return (OptionPriority) Enum.valueOf(OptionPriority.class, str);
        }

        public static OptionPriority[] values() {
            return (OptionPriority[]) $VALUES.clone();
        }
    }

    boolean containsOption(AutoValue_Config_Option autoValue_Config_Option);

    void findOptions(CaptureRequestOptions$Builder$$ExternalSyntheticLambda0 captureRequestOptions$Builder$$ExternalSyntheticLambda0);

    OptionPriority getOptionPriority(AutoValue_Config_Option autoValue_Config_Option);

    Set getPriorities(AutoValue_Config_Option autoValue_Config_Option);

    Set listOptions();

    Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option);

    Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option, Object obj);

    Object retrieveOptionWithPriority(AutoValue_Config_Option autoValue_Config_Option, OptionPriority optionPriority);
}
