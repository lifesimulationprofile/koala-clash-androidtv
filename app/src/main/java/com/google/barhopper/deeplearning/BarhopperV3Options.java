package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BarhopperV3Options extends zzeh implements zzfn {
    private static final BarhopperV3Options zzb;
    private int zzd;
    private zzi zze;
    private zzac zzf;
    private zzq zzg;

    static {
        BarhopperV3Options barhopperV3Options = new BarhopperV3Options();
        zzb = barhopperV3Options;
        zzeh.zzV(BarhopperV3Options.class, barhopperV3Options);
    }

    public static zzk zza() {
        return (zzk) zzb.zzG();
    }

    public static /* synthetic */ void zzc(BarhopperV3Options barhopperV3Options, zzi zziVar) {
        barhopperV3Options.zze = zziVar;
        barhopperV3Options.zzd |= 1;
    }

    public static /* synthetic */ void zzd(BarhopperV3Options barhopperV3Options, zzac zzacVar) {
        barhopperV3Options.zzf = zzacVar;
        barhopperV3Options.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new BarhopperV3Options();
        }
        if (i2 == 4) {
            return new zzk(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
