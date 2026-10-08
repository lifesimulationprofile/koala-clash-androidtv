package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SupportedSurfaceCombination_FeatureSettings {
    public final int cameraMode;
    public final boolean previewStabilizationOn;
    public final int requiredMaxBitDepth;
    public final boolean ultraHdrOn;

    public AutoValue_SupportedSurfaceCombination_FeatureSettings(int i, int i2, boolean z, boolean z2) {
        this.cameraMode = i;
        this.requiredMaxBitDepth = i2;
        this.previewStabilizationOn = z;
        this.ultraHdrOn = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_SupportedSurfaceCombination_FeatureSettings) {
            AutoValue_SupportedSurfaceCombination_FeatureSettings autoValue_SupportedSurfaceCombination_FeatureSettings = (AutoValue_SupportedSurfaceCombination_FeatureSettings) obj;
            if (this.cameraMode == autoValue_SupportedSurfaceCombination_FeatureSettings.cameraMode && this.requiredMaxBitDepth == autoValue_SupportedSurfaceCombination_FeatureSettings.requiredMaxBitDepth && this.previewStabilizationOn == autoValue_SupportedSurfaceCombination_FeatureSettings.previewStabilizationOn && this.ultraHdrOn == autoValue_SupportedSurfaceCombination_FeatureSettings.ultraHdrOn) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.cameraMode ^ 1000003) * 1000003) ^ this.requiredMaxBitDepth) * 1000003) ^ (this.previewStabilizationOn ? 1231 : 1237)) * 1000003) ^ (this.ultraHdrOn ? 1231 : 1237);
    }

    public final String toString() {
        return "FeatureSettings{cameraMode=" + this.cameraMode + ", requiredMaxBitDepth=" + this.requiredMaxBitDepth + ", previewStabilizationOn=" + this.previewStabilizationOn + ", ultraHdrOn=" + this.ultraHdrOn + "}";
    }
}
