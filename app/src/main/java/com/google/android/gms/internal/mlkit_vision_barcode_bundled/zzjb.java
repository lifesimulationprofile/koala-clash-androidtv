package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzjb extends zzeh implements zzfn {
    private static final zzjb zzb;
    private int zzd;
    private String zze = "";
    private zzjh zzf;

    static {
        zzjb zzjbVar = new zzjb();
        zzb = zzjbVar;
        zzeh.zzV(zzjb.class, zzjbVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzjb();
        }
        if (i2 == 4) {
            return new zze(23, zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
