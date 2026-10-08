package androidx.camera.core.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_CameraThreadConfig {
    public final Executor cameraExecutor;
    public final Handler schedulerHandler;

    public AutoValue_CameraThreadConfig(Executor executor, Handler handler) {
        if (executor == null) {
            throw new NullPointerException("Null cameraExecutor");
        }
        this.cameraExecutor = executor;
        if (handler == null) {
            throw new NullPointerException("Null schedulerHandler");
        }
        this.schedulerHandler = handler;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_CameraThreadConfig) {
            AutoValue_CameraThreadConfig autoValue_CameraThreadConfig = (AutoValue_CameraThreadConfig) obj;
            if (this.cameraExecutor.equals(autoValue_CameraThreadConfig.cameraExecutor) && this.schedulerHandler.equals(autoValue_CameraThreadConfig.schedulerHandler)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.cameraExecutor.hashCode() ^ 1000003) * 1000003) ^ this.schedulerHandler.hashCode();
    }

    public final String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.cameraExecutor + ", schedulerHandler=" + this.schedulerHandler + "}";
    }
}
