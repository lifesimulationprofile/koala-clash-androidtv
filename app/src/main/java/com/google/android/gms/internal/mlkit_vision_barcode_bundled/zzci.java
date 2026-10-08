package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzci extends zzeh implements zzfn {
    private static final zzci zzb;
    private int zzd;
    private int zze;
    private zzf zzg;
    private byte zzh = 2;
    private zzeo zzf = zzfv.zza;

    static {
        zzci zzciVar = new zzci();
        zzb = zzciVar;
        zzeh.zzV(zzci.class, zzciVar);
    }

    public final zzeo zzb() {
        return this.zzf;
    }

    public final int zzc() {
        int i;
        int i2 = this.zze;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                i = i2 != 2 ? 0 : 3;
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001᠌\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zzd", "zze", zzi.zza$2, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzci();
        }
        if (i2 == 4) {
            return new zze(5, zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzh = zzehVar == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
