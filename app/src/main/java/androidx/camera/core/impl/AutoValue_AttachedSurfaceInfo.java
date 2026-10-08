package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_AttachedSurfaceInfo {
    public final List captureTypes;
    public final DynamicRange dynamicRange;
    public final int imageFormat;
    public final Config implementationOptions;
    public final Size size;
    public final AutoValue_SurfaceConfig surfaceConfig;
    public final Range targetFrameRate;

    public AutoValue_AttachedSurfaceInfo(AutoValue_SurfaceConfig autoValue_SurfaceConfig, int i, Size size, DynamicRange dynamicRange, List list, Config config, Range range) {
        if (autoValue_SurfaceConfig == null) {
            throw new NullPointerException("Null surfaceConfig");
        }
        this.surfaceConfig = autoValue_SurfaceConfig;
        this.imageFormat = i;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        if (dynamicRange == null) {
            throw new NullPointerException("Null dynamicRange");
        }
        this.dynamicRange = dynamicRange;
        if (list == null) {
            throw new NullPointerException("Null captureTypes");
        }
        this.captureTypes = list;
        this.implementationOptions = config;
        this.targetFrameRate = range;
    }

    public final boolean equals(Object obj) {
        Config config;
        Range range;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_AttachedSurfaceInfo) {
            AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo = (AutoValue_AttachedSurfaceInfo) obj;
            Range range2 = autoValue_AttachedSurfaceInfo.targetFrameRate;
            Config config2 = autoValue_AttachedSurfaceInfo.implementationOptions;
            if (this.surfaceConfig.equals(autoValue_AttachedSurfaceInfo.surfaceConfig) && this.imageFormat == autoValue_AttachedSurfaceInfo.imageFormat && this.size.equals(autoValue_AttachedSurfaceInfo.size) && this.dynamicRange.equals(autoValue_AttachedSurfaceInfo.dynamicRange) && this.captureTypes.equals(autoValue_AttachedSurfaceInfo.captureTypes) && ((config = this.implementationOptions) != null ? config.equals(config2) : config2 == null) && ((range = this.targetFrameRate) != null ? range.equals(range2) : range2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((((this.surfaceConfig.hashCode() ^ 1000003) * 1000003) ^ this.imageFormat) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.captureTypes.hashCode()) * 1000003;
        Config config = this.implementationOptions;
        int iHashCode2 = (iHashCode ^ (config == null ? 0 : config.hashCode())) * 1000003;
        Range range = this.targetFrameRate;
        return iHashCode2 ^ (range != null ? range.hashCode() : 0);
    }

    public final String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.surfaceConfig + ", imageFormat=" + this.imageFormat + ", size=" + this.size + ", dynamicRange=" + this.dynamicRange + ", captureTypes=" + this.captureTypes + ", implementationOptions=" + this.implementationOptions + ", targetFrameRate=" + this.targetFrameRate + "}";
    }
}
