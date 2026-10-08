package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzjs extends zzeh implements zzfn {
    private static final zzjs zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        zzjs zzjsVar = new zzjs();
        zzb = zzjsVar;
        zzeh.zzV(zzjs.class, zzjsVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", zzi.zza$21, "zzg"});
        }
        if (i2 == 3) {
            return new zzjs();
        }
        if (i2 == 4) {
            return new zzl(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
