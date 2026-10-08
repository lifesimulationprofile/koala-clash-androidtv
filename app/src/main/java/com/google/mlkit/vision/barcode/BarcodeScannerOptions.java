package com.google.mlkit.vision.barcode;

import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BarcodeScannerOptions {
    public final int zza;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BarcodeScannerOptions) && this.zza == ((BarcodeScannerOptions) obj).zza && zzah.equal(null, null) && zzah.equal(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Boolean.FALSE, null, null});
    }
}
