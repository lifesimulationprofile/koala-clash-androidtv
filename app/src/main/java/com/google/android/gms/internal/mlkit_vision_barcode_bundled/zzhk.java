package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzhk extends zzeh implements zzfn {
    private static final zzhk zzb;
    private int zzd;
    private int zze;
    private zzjp zzf;
    private zzjb zzg;
    private zzjd zzh;

    static {
        zzhk zzhkVar = new zzhk();
        zzb = zzhkVar;
        zzeh.zzV(zzhk.class, zzhkVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zzd", "zze", zzi.zza$12, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzhk();
        }
        if (i2 == 4) {
            return new zze(9, zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
