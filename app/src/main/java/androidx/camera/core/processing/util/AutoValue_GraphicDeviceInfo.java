package androidx.camera.core.processing.util;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_GraphicDeviceInfo {
    public final String eglExtensions;
    public final String eglVersion;
    public final String glExtensions;
    public final String glVersion;

    public AutoValue_GraphicDeviceInfo(String str, String str2, String str3, String str4) {
        this.glVersion = str;
        this.eglVersion = str2;
        this.glExtensions = str3;
        this.eglExtensions = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_GraphicDeviceInfo) {
            AutoValue_GraphicDeviceInfo autoValue_GraphicDeviceInfo = (AutoValue_GraphicDeviceInfo) obj;
            if (this.glVersion.equals(autoValue_GraphicDeviceInfo.glVersion) && this.eglVersion.equals(autoValue_GraphicDeviceInfo.eglVersion) && this.glExtensions.equals(autoValue_GraphicDeviceInfo.glExtensions) && this.eglExtensions.equals(autoValue_GraphicDeviceInfo.eglExtensions)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.glVersion.hashCode() ^ 1000003) * 1000003) ^ this.eglVersion.hashCode()) * 1000003) ^ this.glExtensions.hashCode()) * 1000003) ^ this.eglExtensions.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GraphicDeviceInfo{glVersion=");
        sb.append(this.glVersion);
        sb.append(", eglVersion=");
        sb.append(this.eglVersion);
        sb.append(", glExtensions=");
        sb.append(this.glExtensions);
        sb.append(", eglExtensions=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.eglExtensions, "}");
    }
}
