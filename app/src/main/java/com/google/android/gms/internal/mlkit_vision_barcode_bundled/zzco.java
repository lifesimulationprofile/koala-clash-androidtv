package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzco extends zzeh implements zzfn {
    private static final zzco zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzco zzcoVar = new zzco();
        zzb = zzcoVar;
        zzeh.zzV(zzco.class, zzcoVar);
    }

    public static zzco zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final int zzd() {
        int i;
        int i2 = this.zze;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    i = 4;
                    if (i2 != 3) {
                        i = i2 != 4 ? 0 : 5;
                    }
                } else {
                    i = 3;
                }
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
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzi.zza$3, "zzf"});
        }
        if (i2 == 3) {
            return new zzco();
        }
        if (i2 == 4) {
            return new zze(7, zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
