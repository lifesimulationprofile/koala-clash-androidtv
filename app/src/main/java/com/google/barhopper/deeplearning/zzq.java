package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfv;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzq extends zzeh implements zzfn {
    private static final zzq zzb;
    private zzeo zzd;
    private zzeo zze;

    static {
        zzq zzqVar = new zzq();
        zzb = zzqVar;
        zzeh.zzV(zzq.class, zzqVar);
    }

    public zzq() {
        zzfv zzfvVar = zzfv.zza;
        this.zzd = zzfvVar;
        this.zze = zzfvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zzn.class, "zze", zzn.class});
        }
        if (i2 == 3) {
            return new zzq();
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
