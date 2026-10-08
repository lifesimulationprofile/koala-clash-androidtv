package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceRequest_TransformationInfo {
    public final Rect getCropRect;
    public final int getRotationDegrees;
    public final Matrix getSensorToBufferTransform;
    public final int getTargetRotation;
    public final boolean hasCameraTransform;
    public final boolean isMirroring;

    public AutoValue_SurfaceRequest_TransformationInfo(Rect rect, int i, int i2, boolean z, Matrix matrix, boolean z2) {
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.getCropRect = rect;
        this.getRotationDegrees = i;
        this.getTargetRotation = i2;
        this.hasCameraTransform = z;
        if (matrix == null) {
            throw new NullPointerException("Null getSensorToBufferTransform");
        }
        this.getSensorToBufferTransform = matrix;
        this.isMirroring = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_SurfaceRequest_TransformationInfo) {
            AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo = (AutoValue_SurfaceRequest_TransformationInfo) obj;
            if (this.getCropRect.equals(autoValue_SurfaceRequest_TransformationInfo.getCropRect) && this.getRotationDegrees == autoValue_SurfaceRequest_TransformationInfo.getRotationDegrees && this.getTargetRotation == autoValue_SurfaceRequest_TransformationInfo.getTargetRotation && this.hasCameraTransform == autoValue_SurfaceRequest_TransformationInfo.hasCameraTransform && this.getSensorToBufferTransform.equals(autoValue_SurfaceRequest_TransformationInfo.getSensorToBufferTransform) && this.isMirroring == autoValue_SurfaceRequest_TransformationInfo.isMirroring) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((this.getCropRect.hashCode() ^ 1000003) * 1000003) ^ this.getRotationDegrees) * 1000003) ^ this.getTargetRotation) * 1000003) ^ (this.hasCameraTransform ? 1231 : 1237)) * 1000003) ^ this.getSensorToBufferTransform.hashCode()) * 1000003) ^ (this.isMirroring ? 1231 : 1237);
    }

    public final String toString() {
        return "TransformationInfo{getCropRect=" + this.getCropRect + ", getRotationDegrees=" + this.getRotationDegrees + ", getTargetRotation=" + this.getTargetRotation + ", hasCameraTransform=" + this.hasCameraTransform + ", getSensorToBufferTransform=" + this.getSensorToBufferTransform + ", isMirroring=" + this.isMirroring + "}";
    }
}
