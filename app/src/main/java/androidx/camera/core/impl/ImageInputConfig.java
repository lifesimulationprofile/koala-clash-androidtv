package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface ImageInputConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_INPUT_FORMAT = new AutoValue_Config_Option("camerax.core.imageInput.inputFormat", Integer.TYPE, null);
    public static final AutoValue_Config_Option OPTION_INPUT_DYNAMIC_RANGE = new AutoValue_Config_Option("camerax.core.imageInput.inputDynamicRange", DynamicRange.class, null);

    DynamicRange getDynamicRange();

    int getInputFormat();
}
