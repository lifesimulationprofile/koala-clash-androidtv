package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzio extends zzeh implements zzfn {
    private static final zzio zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        zzio zzioVar = new zzio();
        zzb = zzioVar;
        zzeh.zzV(zzio.class, zzioVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzi zziVar = zzi.zza$14;
            return new zzfw(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", zzi.zza$15, "zzg", "zzh", zzi.zza$13, "zzi", zziVar, "zzj", zziVar, "zzk", zziVar, "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzio();
        }
        if (i2 == 4) {
            return new zze(19, zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
