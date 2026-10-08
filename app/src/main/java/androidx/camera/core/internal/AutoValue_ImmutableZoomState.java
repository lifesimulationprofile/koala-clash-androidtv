package androidx.camera.core.internal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_ImmutableZoomState {
    public final float linearZoom;
    public final float maxZoomRatio;
    public final float minZoomRatio;
    public final float zoomRatio;

    public AutoValue_ImmutableZoomState(float f, float f2, float f3, float f4) {
        this.zoomRatio = f;
        this.maxZoomRatio = f2;
        this.minZoomRatio = f3;
        this.linearZoom = f4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_ImmutableZoomState) {
            AutoValue_ImmutableZoomState autoValue_ImmutableZoomState = (AutoValue_ImmutableZoomState) obj;
            if (Float.floatToIntBits(this.zoomRatio) == Float.floatToIntBits(autoValue_ImmutableZoomState.zoomRatio) && Float.floatToIntBits(this.maxZoomRatio) == Float.floatToIntBits(autoValue_ImmutableZoomState.maxZoomRatio) && Float.floatToIntBits(this.minZoomRatio) == Float.floatToIntBits(autoValue_ImmutableZoomState.minZoomRatio) && Float.floatToIntBits(this.linearZoom) == Float.floatToIntBits(autoValue_ImmutableZoomState.linearZoom)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((Float.floatToIntBits(this.zoomRatio) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.maxZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.minZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.linearZoom);
    }

    public final String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.zoomRatio + ", maxZoomRatio=" + this.maxZoomRatio + ", minZoomRatio=" + this.minZoomRatio + ", linearZoom=" + this.linearZoom + "}";
    }
}
