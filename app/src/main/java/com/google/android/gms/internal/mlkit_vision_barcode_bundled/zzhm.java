package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzhm extends zzeh implements zzfn {
    private static final zzhm zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzhm zzhmVar = new zzhm();
        zzb = zzhmVar;
        zzeh.zzV(zzhm.class, zzhmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzhm();
        }
        if (i2 == 4) {
            return new zze(10, zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
