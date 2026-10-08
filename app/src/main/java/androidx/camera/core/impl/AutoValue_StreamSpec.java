package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_StreamSpec {
    public static final Range FRAME_RATE_RANGE_UNSPECIFIED = new Range(0, 0);
    public final DynamicRange dynamicRange;
    public final Range expectedFrameRateRange;
    public final Config implementationOptions;
    public final Size resolution;
    public final boolean zslDisabled;

    public AutoValue_StreamSpec(Size size, DynamicRange dynamicRange, Range range, Config config, boolean z) {
        this.resolution = size;
        this.dynamicRange = dynamicRange;
        this.expectedFrameRateRange = range;
        this.implementationOptions = config;
        this.zslDisabled = z;
    }

    public final boolean equals(Object obj) {
        Config config;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_StreamSpec) {
            AutoValue_StreamSpec autoValue_StreamSpec = (AutoValue_StreamSpec) obj;
            Config config2 = autoValue_StreamSpec.implementationOptions;
            if (this.resolution.equals(autoValue_StreamSpec.resolution) && this.dynamicRange.equals(autoValue_StreamSpec.dynamicRange) && this.expectedFrameRateRange.equals(autoValue_StreamSpec.expectedFrameRateRange) && ((config = this.implementationOptions) != null ? config.equals(config2) : config2 == null) && this.zslDisabled == autoValue_StreamSpec.zslDisabled) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.expectedFrameRateRange.hashCode()) * 1000003;
        Config config = this.implementationOptions;
        return ((iHashCode ^ (config == null ? 0 : config.hashCode())) * 1000003) ^ (this.zslDisabled ? 1231 : 1237);
    }

    public final Request toBuilder() {
        Request request = new Request(2, false);
        request.url = this.resolution;
        request.method = this.dynamicRange;
        request.headers = this.expectedFrameRateRange;
        request.tags = this.implementationOptions;
        request.lazyCacheControl = Boolean.valueOf(this.zslDisabled);
        return request;
    }

    public final String toString() {
        return "StreamSpec{resolution=" + this.resolution + ", dynamicRange=" + this.dynamicRange + ", expectedFrameRateRange=" + this.expectedFrameRateRange + ", implementationOptions=" + this.implementationOptions + ", zslDisabled=" + this.zslDisabled + "}";
    }
}
