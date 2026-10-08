package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzaf extends zzeh implements zzfn {
    private static final zzaf zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        zzaf zzafVar = new zzaf();
        zzb = zzafVar;
        zzeh.zzV(zzaf.class, zzafVar);
    }

    public static zzae zzc() {
        return (zzae) zzb.zzG();
    }

    public static /* synthetic */ void zze(zzaf zzafVar, int i) {
        zzafVar.zzd |= 1;
        zzafVar.zze = i;
    }

    public static /* synthetic */ void zzf(zzaf zzafVar, int i) {
        zzafVar.zzd |= 2;
        zzafVar.zzf = i;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaf();
        }
        if (i2 == 4) {
            return new zzae(zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = zzehVar == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
