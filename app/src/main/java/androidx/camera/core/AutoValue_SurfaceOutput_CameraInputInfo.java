package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceOutput_CameraInputInfo {
    public final CameraInternal cameraInternal;
    public final Rect inputCropRect;
    public final Size inputSize;
    public final boolean mirroring;
    public final int rotationDegrees;

    public AutoValue_SurfaceOutput_CameraInputInfo(Size size, Rect rect, CameraInternal cameraInternal, int i, boolean z) {
        if (size == null) {
            throw new NullPointerException("Null inputSize");
        }
        this.inputSize = size;
        if (rect == null) {
            throw new NullPointerException("Null inputCropRect");
        }
        this.inputCropRect = rect;
        this.cameraInternal = cameraInternal;
        this.rotationDegrees = i;
        this.mirroring = z;
    }

    public final boolean equals(Object obj) {
        CameraInternal cameraInternal;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_SurfaceOutput_CameraInputInfo) {
            AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo = (AutoValue_SurfaceOutput_CameraInputInfo) obj;
            CameraInternal cameraInternal2 = autoValue_SurfaceOutput_CameraInputInfo.cameraInternal;
            if (this.inputSize.equals(autoValue_SurfaceOutput_CameraInputInfo.inputSize) && this.inputCropRect.equals(autoValue_SurfaceOutput_CameraInputInfo.inputCropRect) && ((cameraInternal = this.cameraInternal) != null ? cameraInternal.equals(cameraInternal2) : cameraInternal2 == null) && this.rotationDegrees == autoValue_SurfaceOutput_CameraInputInfo.rotationDegrees && this.mirroring == autoValue_SurfaceOutput_CameraInputInfo.mirroring) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.inputSize.hashCode() ^ 1000003) * 1000003) ^ this.inputCropRect.hashCode()) * 1000003;
        CameraInternal cameraInternal = this.cameraInternal;
        return ((((iHashCode ^ (cameraInternal == null ? 0 : cameraInternal.hashCode())) * 1000003) ^ this.rotationDegrees) * 1000003) ^ (this.mirroring ? 1231 : 1237);
    }

    public final String toString() {
        return "CameraInputInfo{inputSize=" + this.inputSize + ", inputCropRect=" + this.inputCropRect + ", cameraInternal=" + this.cameraInternal + ", rotationDegrees=" + this.rotationDegrees + ", mirroring=" + this.mirroring + "}";
    }
}
