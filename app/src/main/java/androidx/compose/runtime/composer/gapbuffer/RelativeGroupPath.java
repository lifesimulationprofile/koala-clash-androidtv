package androidx.compose.runtime.composer.gapbuffer;

import com.google.android.gms.internal.mlkit_vision_barcode.zzsg;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeGroupPath extends zzsg {
    public final int index;
    public final zzsg parent;

    public RelativeGroupPath(zzsg zzsgVar, int i) {
        this.parent = zzsgVar;
        this.index = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof RelativeGroupPath)) {
            return false;
        }
        RelativeGroupPath relativeGroupPath = (RelativeGroupPath) obj;
        return Intrinsics.areEqual(relativeGroupPath.parent, this.parent) && relativeGroupPath.index == this.index;
    }

    public final int hashCode() {
        return this.parent.hashCode() + (this.index * 31);
    }
}
