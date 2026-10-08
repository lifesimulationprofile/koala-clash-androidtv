package androidx.camera.core;

import androidx.camera.core.processing.SurfaceOutputImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceOutput_Event {
    public final SurfaceOutputImpl surfaceOutput;

    public AutoValue_SurfaceOutput_Event(SurfaceOutputImpl surfaceOutputImpl) {
        this.surfaceOutput = surfaceOutputImpl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AutoValue_SurfaceOutput_Event) && this.surfaceOutput.equals(((AutoValue_SurfaceOutput_Event) obj).surfaceOutput);
    }

    public final int hashCode() {
        return this.surfaceOutput.hashCode() ^ (-721379959);
    }

    public final String toString() {
        return "Event{eventCode=0, surfaceOutput=" + this.surfaceOutput + "}";
    }
}
