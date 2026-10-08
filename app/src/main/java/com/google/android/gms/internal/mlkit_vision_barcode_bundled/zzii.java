package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzii extends zzeh implements zzfn {
    private static final zzii zzb;
    private int zzd;
    private int zze;
    private zzia zzh;
    private int zzj;
    private int zzk;
    private int zzn;
    private zzeo zzf = zzfv.zza;
    private int zzg = -1;
    private String zzi = "";
    private zzen zzl = zzei.zza;
    private String zzm = "";

    static {
        zzii zziiVar = new zzii();
        zzb = zziiVar;
        zzeh.zzV(zzii.class, zziiVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006\n᠌\u0007", new Object[]{"zzd", "zze", zzi.zza$8, "zzf", zzic.class, "zzg", "zzh", "zzi", "zzj", zzi.zza$9, "zzk", zzi.zza$10, "zzl", "zzm", "zzn", zzi.zza$11});
        }
        if (i2 == 3) {
            return new zzii();
        }
        if (i2 == 4) {
            return new zze(17, zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
