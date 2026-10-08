package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.SurfaceEdge;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_DualSurfaceProcessorNode_In {
    public final ArrayList outConfigs;
    public final SurfaceEdge primarySurfaceEdge;
    public final SurfaceEdge secondarySurfaceEdge;

    public AutoValue_DualSurfaceProcessorNode_In(SurfaceEdge surfaceEdge, SurfaceEdge surfaceEdge2, ArrayList arrayList) {
        if (surfaceEdge == null) {
            throw new NullPointerException("Null primarySurfaceEdge");
        }
        this.primarySurfaceEdge = surfaceEdge;
        if (surfaceEdge2 == null) {
            throw new NullPointerException("Null secondarySurfaceEdge");
        }
        this.secondarySurfaceEdge = surfaceEdge2;
        this.outConfigs = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_DualSurfaceProcessorNode_In)) {
            return false;
        }
        AutoValue_DualSurfaceProcessorNode_In autoValue_DualSurfaceProcessorNode_In = (AutoValue_DualSurfaceProcessorNode_In) obj;
        return this.primarySurfaceEdge.equals(autoValue_DualSurfaceProcessorNode_In.primarySurfaceEdge) && this.secondarySurfaceEdge.equals(autoValue_DualSurfaceProcessorNode_In.secondarySurfaceEdge) && this.outConfigs.equals(autoValue_DualSurfaceProcessorNode_In.outConfigs);
    }

    public final int hashCode() {
        return ((((this.primarySurfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.secondarySurfaceEdge.hashCode()) * 1000003) ^ this.outConfigs.hashCode();
    }

    public final String toString() {
        return "In{primarySurfaceEdge=" + this.primarySurfaceEdge + ", secondarySurfaceEdge=" + this.secondarySurfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }
}
