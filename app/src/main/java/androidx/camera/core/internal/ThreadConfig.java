package androidx.camera.core.internal;

import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface ThreadConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_BACKGROUND_EXECUTOR = new AutoValue_Config_Option("camerax.core.thread.backgroundExecutor", Executor.class, null);
}
