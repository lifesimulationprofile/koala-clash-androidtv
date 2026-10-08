package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import coil.network.EmptyNetworkObserver;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface CameraControlInternal {
    public static final EmptyNetworkObserver DEFAULT_EMPTY_INSTANCE = new EmptyNetworkObserver();

    void addInteropConfig(Config config);

    void addZslConfig(SessionConfig.Builder builder);

    void clearInteropConfig();

    ListenableFuture enableTorch(boolean z);

    Config getInteropConfig();

    Rect getSensorRect();

    void setFlashMode(int i);

    void setScreenFlash(ImageCapture.ScreenFlash screenFlash);
}
