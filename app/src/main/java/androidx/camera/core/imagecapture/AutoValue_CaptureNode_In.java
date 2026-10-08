package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.Edge;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_CaptureNode_In {
    public final Edge errorEdge;
    public final int inputFormat;
    public final SurfaceRequest.AnonymousClass2 mPostviewSurface = null;
    public SurfaceRequest.AnonymousClass2 mSurface;
    public final int outputFormat;
    public final Edge requestEdge;
    public final Size size;
    public final boolean virtualCamera;

    public AutoValue_CaptureNode_In(Size size, int i, int i2, boolean z, Edge edge, Edge edge2) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        this.inputFormat = i;
        this.outputFormat = i2;
        this.virtualCamera = z;
        this.requestEdge = edge;
        this.errorEdge = edge2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_CaptureNode_In)) {
            return false;
        }
        AutoValue_CaptureNode_In autoValue_CaptureNode_In = (AutoValue_CaptureNode_In) obj;
        return this.size.equals(autoValue_CaptureNode_In.size) && this.inputFormat == autoValue_CaptureNode_In.inputFormat && this.outputFormat == autoValue_CaptureNode_In.outputFormat && this.virtualCamera == autoValue_CaptureNode_In.virtualCamera && this.requestEdge.equals(autoValue_CaptureNode_In.requestEdge) && this.errorEdge.equals(autoValue_CaptureNode_In.errorEdge);
    }

    public final int hashCode() {
        return ((((((((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat) * 1000003) ^ (this.virtualCamera ? 1231 : 1237)) * 583896283) ^ 35) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.errorEdge.hashCode();
    }

    public final String toString() {
        return "In{size=" + this.size + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + ", virtualCamera=" + this.virtualCamera + ", imageReaderProxyProvider=null, postviewSize=null, postviewImageFormat=35, requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + "}";
    }
}
