package androidx.camera.core.internal;

import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.ReadableConfig;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface TargetConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_TARGET_NAME = new AutoValue_Config_Option("camerax.core.target.name", String.class, null);
    public static final AutoValue_Config_Option OPTION_TARGET_CLASS = new AutoValue_Config_Option("camerax.core.target.class", Class.class, null);

    String getTargetName();

    String getTargetName(String str);
}
