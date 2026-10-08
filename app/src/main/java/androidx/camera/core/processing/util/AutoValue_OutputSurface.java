package androidx.camera.core.processing.util;

import android.opengl.EGLSurface;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_OutputSurface {
    public final EGLSurface eglSurface;
    public final int height;
    public final int width;

    public AutoValue_OutputSurface(EGLSurface eGLSurface, int i, int i2) {
        if (eGLSurface == null) {
            throw new NullPointerException("Null eglSurface");
        }
        this.eglSurface = eGLSurface;
        this.width = i;
        this.height = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_OutputSurface) {
            AutoValue_OutputSurface autoValue_OutputSurface = (AutoValue_OutputSurface) obj;
            if (this.eglSurface.equals(autoValue_OutputSurface.eglSurface) && this.width == autoValue_OutputSurface.width && this.height == autoValue_OutputSurface.height) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.eglSurface.hashCode() ^ 1000003) * 1000003) ^ this.width) * 1000003) ^ this.height;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OutputSurface{eglSurface=");
        sb.append(this.eglSurface);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.height, "}");
    }
}
