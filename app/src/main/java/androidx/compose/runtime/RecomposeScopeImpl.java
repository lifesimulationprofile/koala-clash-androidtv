package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RecomposeScopeImpl {
    public GapAnchor anchor;
    public Function2 block;
    public int currentToken;
    public int flags;
    public CompositionImpl owner;
    public MutableScatterMap trackedDependencies;
    public MutableObjectIntMap trackedInstances;

    public RecomposeScopeImpl(CompositionImpl compositionImpl) {
        this.owner = compositionImpl;
    }

    public final boolean getValid() {
        if (this.owner != null) {
            GapAnchor gapAnchor = this.anchor;
            if (gapAnchor != null ? gapAnchor.getValid() : false) {
                return true;
            }
        }
        return false;
    }

    public final void invalidate() {
        CompositionImpl compositionImpl = this.owner;
        if (compositionImpl != null) {
            compositionImpl.invalidate(this, null);
        }
    }

    public final int invalidateForResult(Object obj) {
        int iInvalidate;
        CompositionImpl compositionImpl = this.owner;
        if (compositionImpl == null || (iInvalidate = compositionImpl.invalidate(this, obj)) == 0) {
            return 1;
        }
        return iInvalidate;
    }

    public final void release() {
        CompositionImpl compositionImpl = this.owner;
        if (compositionImpl != null) {
            compositionImpl.pendingInvalidScopes = true;
            compositionImpl.observerHolder.current();
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
        this.block = null;
    }

    public final void setRereading(boolean z) {
        int i = this.flags;
        this.flags = z ? i | 32 : i & (-33);
    }

    public final void setUsed() {
        this.flags |= 1;
    }
}
