package androidx.compose.runtime.composer.gapbuffer;

import com.google.android.gms.internal.mlkit_vision_barcode.zzsg;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredGroupPath extends zzsg {
    public final int group;

    public AnchoredGroupPath(int i) {
        this.group = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AnchoredGroupPath) && ((AnchoredGroupPath) obj).group == this.group;
    }

    public final int hashCode() {
        return this.group * 31;
    }
}
