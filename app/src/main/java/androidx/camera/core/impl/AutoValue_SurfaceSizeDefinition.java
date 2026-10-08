package androidx.camera.core.impl;

import android.util.Size;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceSizeDefinition {
    public final Size analysisSize;
    public final HashMap maximumSizeMap;
    public final Size previewSize;
    public final Size recordSize;
    public final HashMap s1440pSizeMap;
    public final HashMap s720pSizeMap;
    public final HashMap ultraMaximumSizeMap;

    public AutoValue_SurfaceSizeDefinition(Size size, HashMap map, Size size2, HashMap map2, Size size3, HashMap map3, HashMap map4) {
        if (size == null) {
            throw new NullPointerException("Null analysisSize");
        }
        this.analysisSize = size;
        this.s720pSizeMap = map;
        if (size2 == null) {
            throw new NullPointerException("Null previewSize");
        }
        this.previewSize = size2;
        this.s1440pSizeMap = map2;
        if (size3 == null) {
            throw new NullPointerException("Null recordSize");
        }
        this.recordSize = size3;
        this.maximumSizeMap = map3;
        this.ultraMaximumSizeMap = map4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SurfaceSizeDefinition)) {
            return false;
        }
        AutoValue_SurfaceSizeDefinition autoValue_SurfaceSizeDefinition = (AutoValue_SurfaceSizeDefinition) obj;
        return this.analysisSize.equals(autoValue_SurfaceSizeDefinition.analysisSize) && this.s720pSizeMap.equals(autoValue_SurfaceSizeDefinition.s720pSizeMap) && this.previewSize.equals(autoValue_SurfaceSizeDefinition.previewSize) && this.s1440pSizeMap.equals(autoValue_SurfaceSizeDefinition.s1440pSizeMap) && this.recordSize.equals(autoValue_SurfaceSizeDefinition.recordSize) && this.maximumSizeMap.equals(autoValue_SurfaceSizeDefinition.maximumSizeMap) && this.ultraMaximumSizeMap.equals(autoValue_SurfaceSizeDefinition.ultraMaximumSizeMap);
    }

    public final int hashCode() {
        return ((((((((((((this.analysisSize.hashCode() ^ 1000003) * 1000003) ^ this.s720pSizeMap.hashCode()) * 1000003) ^ this.previewSize.hashCode()) * 1000003) ^ this.s1440pSizeMap.hashCode()) * 1000003) ^ this.recordSize.hashCode()) * 1000003) ^ this.maximumSizeMap.hashCode()) * 1000003) ^ this.ultraMaximumSizeMap.hashCode();
    }

    public final String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.analysisSize + ", s720pSizeMap=" + this.s720pSizeMap + ", previewSize=" + this.previewSize + ", s1440pSizeMap=" + this.s1440pSizeMap + ", recordSize=" + this.recordSize + ", maximumSizeMap=" + this.maximumSizeMap + ", ultraMaximumSizeMap=" + this.ultraMaximumSizeMap + "}";
    }
}
