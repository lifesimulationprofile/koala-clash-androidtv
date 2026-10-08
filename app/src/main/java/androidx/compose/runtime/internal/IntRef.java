package androidx.compose.runtime.internal;

import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IntRef {
    public int element = 0;

    public final String toString() {
        StringBuilder sb = new StringBuilder("IntRef(element = ");
        sb.append(this.element);
        sb.append(")@");
        int iHashCode = hashCode();
        CharsKt.checkRadix(16);
        sb.append(Integer.toString(iHashCode, 16));
        return sb.toString();
    }
}
