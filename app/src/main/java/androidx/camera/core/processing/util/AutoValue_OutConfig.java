package androidx.camera.core.processing.util;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_OutConfig {
    public final Rect getCropRect;
    public final int getFormat;
    public final int getRotationDegrees;
    public final Size getSize;
    public final int getTargets;
    public final UUID getUuid;
    public final boolean isMirroring;

    public AutoValue_OutConfig(UUID uuid, int i, int i2, Rect rect, Size size, int i3, boolean z) {
        if (uuid == null) {
            throw new NullPointerException("Null getUuid");
        }
        this.getUuid = uuid;
        this.getTargets = i;
        this.getFormat = i2;
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.getCropRect = rect;
        if (size == null) {
            throw new NullPointerException("Null getSize");
        }
        this.getSize = size;
        this.getRotationDegrees = i3;
        this.isMirroring = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_OutConfig)) {
            return false;
        }
        AutoValue_OutConfig autoValue_OutConfig = (AutoValue_OutConfig) obj;
        return this.getUuid.equals(autoValue_OutConfig.getUuid) && this.getTargets == autoValue_OutConfig.getTargets && this.getFormat == autoValue_OutConfig.getFormat && this.getCropRect.equals(autoValue_OutConfig.getCropRect) && this.getSize.equals(autoValue_OutConfig.getSize) && this.getRotationDegrees == autoValue_OutConfig.getRotationDegrees && this.isMirroring == autoValue_OutConfig.isMirroring;
    }

    public final int hashCode() {
        return ((((((((((((((this.getUuid.hashCode() ^ 1000003) * 1000003) ^ this.getTargets) * 1000003) ^ this.getFormat) * 1000003) ^ this.getCropRect.hashCode()) * 1000003) ^ this.getSize.hashCode()) * 1000003) ^ this.getRotationDegrees) * 1000003) ^ (this.isMirroring ? 1231 : 1237)) * 1000003) ^ 1237;
    }

    public final String toString() {
        return "OutConfig{getUuid=" + this.getUuid + ", getTargets=" + this.getTargets + ", getFormat=" + this.getFormat + ", getCropRect=" + this.getCropRect + ", getSize=" + this.getSize + ", getRotationDegrees=" + this.getRotationDegrees + ", isMirroring=" + this.isMirroring + ", shouldRespectInputCropRect=false}";
    }
}
