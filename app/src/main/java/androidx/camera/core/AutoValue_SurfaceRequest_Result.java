package androidx.camera.core;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceRequest_Result {
    public final int resultCode;
    public final Surface surface;

    public AutoValue_SurfaceRequest_Result(int i, Surface surface) {
        this.resultCode = i;
        if (surface == null) {
            throw new NullPointerException("Null surface");
        }
        this.surface = surface;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SurfaceRequest_Result)) {
            return false;
        }
        AutoValue_SurfaceRequest_Result autoValue_SurfaceRequest_Result = (AutoValue_SurfaceRequest_Result) obj;
        return this.resultCode == autoValue_SurfaceRequest_Result.resultCode && this.surface.equals(autoValue_SurfaceRequest_Result.surface);
    }

    public final int hashCode() {
        return ((this.resultCode ^ 1000003) * 1000003) ^ this.surface.hashCode();
    }

    public final String toString() {
        return "Result{resultCode=" + this.resultCode + ", surface=" + this.surface + "}";
    }
}
