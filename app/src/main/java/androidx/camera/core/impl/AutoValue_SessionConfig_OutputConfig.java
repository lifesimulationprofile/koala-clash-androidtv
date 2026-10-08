package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import java.util.Collections;
import java.util.List;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SessionConfig_OutputConfig {
    public final DynamicRange dynamicRange;
    public final int mirrorMode;
    public final List sharedSurfaces;
    public final DeferrableSurface surface;
    public final int surfaceGroupId;

    public AutoValue_SessionConfig_OutputConfig(DeferrableSurface deferrableSurface, List list, int i, int i2, DynamicRange dynamicRange) {
        this.surface = deferrableSurface;
        this.sharedSurfaces = list;
        this.mirrorMode = i;
        this.surfaceGroupId = i2;
        this.dynamicRange = dynamicRange;
    }

    public static Request builder(DeferrableSurface deferrableSurface) {
        Request request = new Request(1, false);
        if (deferrableSurface == null) {
            throw new NullPointerException("Null surface");
        }
        request.url = deferrableSurface;
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            throw new NullPointerException("Null sharedSurfaces");
        }
        request.method = list;
        request.headers = -1;
        request.tags = -1;
        request.lazyCacheControl = DynamicRange.SDR;
        return request;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SessionConfig_OutputConfig)) {
            return false;
        }
        AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig = (AutoValue_SessionConfig_OutputConfig) obj;
        return this.surface.equals(autoValue_SessionConfig_OutputConfig.surface) && this.sharedSurfaces.equals(autoValue_SessionConfig_OutputConfig.sharedSurfaces) && this.mirrorMode == autoValue_SessionConfig_OutputConfig.mirrorMode && this.surfaceGroupId == autoValue_SessionConfig_OutputConfig.surfaceGroupId && this.dynamicRange.equals(autoValue_SessionConfig_OutputConfig.dynamicRange);
    }

    public final int hashCode() {
        return ((((((((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.sharedSurfaces.hashCode()) * (-721379959)) ^ this.mirrorMode) * 1000003) ^ this.surfaceGroupId) * 1000003) ^ this.dynamicRange.hashCode();
    }

    public final String toString() {
        return "OutputConfig{surface=" + this.surface + ", sharedSurfaces=" + this.sharedSurfaces + ", physicalCameraId=null, mirrorMode=" + this.mirrorMode + ", surfaceGroupId=" + this.surfaceGroupId + ", dynamicRange=" + this.dynamicRange + "}";
    }
}
