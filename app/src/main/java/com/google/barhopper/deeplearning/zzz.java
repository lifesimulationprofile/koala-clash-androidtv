package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzz extends zzeh implements zzfn {
    private static final zzz zzb;

    static {
        zzz zzzVar = new zzz();
        zzb = zzzVar;
        zzeh.zzV(zzz.class, zzzVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzz();
        }
        if (i2 == 4) {
            return new zzm(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
