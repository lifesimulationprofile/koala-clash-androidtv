package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.internal.utils.SizeUtil;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceConfig {
    public final SurfaceConfig$ConfigSize configSize;
    public final int configType;
    public final long streamUseCase;

    public AutoValue_SurfaceConfig(int i, SurfaceConfig$ConfigSize surfaceConfig$ConfigSize, long j) {
        if (i == 0) {
            throw new NullPointerException("Null configType");
        }
        this.configType = i;
        this.configSize = surfaceConfig$ConfigSize;
        this.streamUseCase = j;
    }

    public static int getConfigType(int i) {
        if (i == 35) {
            return 2;
        }
        if (i == 256) {
            return 3;
        }
        if (i == 4101) {
            return 4;
        }
        return i == 32 ? 5 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    public static AutoValue_SurfaceConfig transformSurfaceConfig(int i, int i2, Size size, AutoValue_SurfaceSizeDefinition autoValue_SurfaceSizeDefinition) {
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize;
        int configType = getConfigType(i2);
        int area = SizeUtil.getArea(size);
        if (i == 1) {
            if (area <= SizeUtil.getArea((Size) autoValue_SurfaceSizeDefinition.s720pSizeMap.get(Integer.valueOf(i2)))) {
                surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.s720p;
            } else if (area <= SizeUtil.getArea((Size) autoValue_SurfaceSizeDefinition.s1440pSizeMap.get(Integer.valueOf(i2)))) {
                surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.s1440p;
            } else {
                surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.NOT_SUPPORT;
            }
        } else if (area <= SizeUtil.getArea(autoValue_SurfaceSizeDefinition.analysisSize)) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.VGA;
        } else if (area <= SizeUtil.getArea(autoValue_SurfaceSizeDefinition.previewSize)) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.PREVIEW;
        } else if (area <= SizeUtil.getArea(autoValue_SurfaceSizeDefinition.recordSize)) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.RECORD;
        } else if (area <= SizeUtil.getArea((Size) autoValue_SurfaceSizeDefinition.maximumSizeMap.get(Integer.valueOf(i2)))) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.MAXIMUM;
        } else {
            Size size2 = (Size) autoValue_SurfaceSizeDefinition.ultraMaximumSizeMap.get(Integer.valueOf(i2));
            if (size2 != null) {
                if (area <= size2.getHeight() * size2.getWidth()) {
                    surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.ULTRA_MAXIMUM;
                } else {
                    surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.NOT_SUPPORT;
                }
            } else {
                surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.NOT_SUPPORT;
            }
        }
        return new AutoValue_SurfaceConfig(configType, surfaceConfig$ConfigSize, 0L);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SurfaceConfig)) {
            return false;
        }
        AutoValue_SurfaceConfig autoValue_SurfaceConfig = (AutoValue_SurfaceConfig) obj;
        return CaptureSession$State$EnumUnboxingLocalUtility.equals(this.configType, autoValue_SurfaceConfig.configType) && this.configSize.equals(autoValue_SurfaceConfig.configSize) && this.streamUseCase == autoValue_SurfaceConfig.streamUseCase;
    }

    public final int hashCode() {
        int iOrdinal = (((CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.configType) ^ 1000003) * 1000003) ^ this.configSize.hashCode()) * 1000003;
        long j = this.streamUseCase;
        return iOrdinal ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("SurfaceConfig{configType=");
        int i = this.configType;
        if (i == 1) {
            str = "PRIV";
        } else if (i == 2) {
            str = "YUV";
        } else if (i == 3) {
            str = "JPEG";
        } else if (i != 4) {
            str = i != 5 ? "null" : "RAW";
        } else {
            str = "JPEG_R";
        }
        sb.append(str);
        sb.append(", configSize=");
        sb.append(this.configSize);
        sb.append(", streamUseCase=");
        sb.append(this.streamUseCase);
        sb.append("}");
        return sb.toString();
    }
}
