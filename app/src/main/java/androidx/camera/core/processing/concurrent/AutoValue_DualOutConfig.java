package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.util.AutoValue_OutConfig;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_DualOutConfig {
    public final AutoValue_OutConfig primaryOutConfig;
    public final AutoValue_OutConfig secondaryOutConfig;

    public AutoValue_DualOutConfig(AutoValue_OutConfig autoValue_OutConfig, AutoValue_OutConfig autoValue_OutConfig2) {
        this.primaryOutConfig = autoValue_OutConfig;
        this.secondaryOutConfig = autoValue_OutConfig2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_DualOutConfig) {
            AutoValue_DualOutConfig autoValue_DualOutConfig = (AutoValue_DualOutConfig) obj;
            if (this.primaryOutConfig.equals(autoValue_DualOutConfig.primaryOutConfig) && this.secondaryOutConfig.equals(autoValue_DualOutConfig.secondaryOutConfig)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.primaryOutConfig.hashCode() ^ 1000003) * 1000003) ^ this.secondaryOutConfig.hashCode();
    }

    public final String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.primaryOutConfig + ", secondaryOutConfig=" + this.secondaryOutConfig + "}";
    }
}
