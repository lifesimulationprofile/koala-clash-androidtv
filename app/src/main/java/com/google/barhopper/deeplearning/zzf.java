package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfv;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzf extends zzeh implements zzfn {
    private static final zzf zzb;
    private zzeo zzd = zzfv.zza;

    static {
        zzf zzfVar = new zzf();
        zzb = zzfVar;
        zzeh.zzV(zzf.class, zzfVar);
    }

    public static zze zza$1() {
        return (zze) zzb.zzG();
    }

    public static void zzc(zzf zzfVar, zzc zzcVar) {
        zzeo zzeoVar = zzfVar.zzd;
        if (!((zzcs) zzeoVar).zza) {
            int size = zzeoVar.size();
            zzfVar.zzd = zzeoVar.zzd(size == 0 ? 10 : size + size);
        }
        zzfVar.zzd.add(zzcVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzc.class});
        }
        if (i2 == 3) {
            return new zzf();
        }
        if (i2 == 4) {
            return new zze(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
