package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzix extends zzeh implements zzfn {
    private static final zzix zzb;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        zzix zzixVar = new zzix();
        zzb = zzixVar;
        zzeh.zzV(zzix.class, zzixVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zzi.zza$18, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzix();
        }
        if (i2 == 4) {
            return new zze(21, zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
