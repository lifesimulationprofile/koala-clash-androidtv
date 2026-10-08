package androidx.camera.lifecycle;

import androidx.camera.core.internal.AutoValue_CameraUseCaseAdapter_CameraId;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_LifecycleCameraRepository_Key {
    public final AutoValue_CameraUseCaseAdapter_CameraId cameraId;
    public final LifecycleOwner lifecycleOwner;

    public AutoValue_LifecycleCameraRepository_Key(LifecycleOwner lifecycleOwner, AutoValue_CameraUseCaseAdapter_CameraId autoValue_CameraUseCaseAdapter_CameraId) {
        if (lifecycleOwner == null) {
            throw new NullPointerException("Null lifecycleOwner");
        }
        this.lifecycleOwner = lifecycleOwner;
        if (autoValue_CameraUseCaseAdapter_CameraId == null) {
            throw new NullPointerException("Null cameraId");
        }
        this.cameraId = autoValue_CameraUseCaseAdapter_CameraId;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_LifecycleCameraRepository_Key) {
            AutoValue_LifecycleCameraRepository_Key autoValue_LifecycleCameraRepository_Key = (AutoValue_LifecycleCameraRepository_Key) obj;
            if (this.lifecycleOwner.equals(autoValue_LifecycleCameraRepository_Key.lifecycleOwner) && this.cameraId.equals(autoValue_LifecycleCameraRepository_Key.cameraId)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.lifecycleOwner.hashCode() ^ 1000003) * 1000003) ^ this.cameraId.hashCode();
    }

    public final String toString() {
        return "Key{lifecycleOwner=" + this.lifecycleOwner + ", cameraId=" + this.cameraId + "}";
    }
}
