package androidx.compose.material3.internal.ripple;

import com.google.android.gms.internal.mlkit_vision_barcode.zzrx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzry;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsa;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RippleNodeConfig {
    public final zzrx drag;
    public final zzry focus;
    public final zzrz hover;
    public final zzsa press;

    public RippleNodeConfig(zzsa zzsaVar, zzry zzryVar, zzrz zzrzVar, zzrx zzrxVar) {
        this.press = zzsaVar;
        this.focus = zzryVar;
        this.hover = zzrzVar;
        this.drag = zzrxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeConfig)) {
            return false;
        }
        RippleNodeConfig rippleNodeConfig = (RippleNodeConfig) obj;
        return Intrinsics.areEqual(this.press, rippleNodeConfig.press) && Intrinsics.areEqual(this.focus, rippleNodeConfig.focus) && Intrinsics.areEqual(this.hover, rippleNodeConfig.hover) && Intrinsics.areEqual(this.drag, rippleNodeConfig.drag);
    }

    public final int hashCode() {
        return this.drag.hashCode() + ((this.hover.hashCode() + ((this.focus.hashCode() + (this.press.hashCode() * 31)) * 31)) * 31);
    }
}
