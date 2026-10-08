package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzp extends zzeh implements zzfn {
    private static final zzp zzb;
    private int zzd;
    private zzjv zzj;
    private byte zzk = 2;
    private zzen zze = zzei.zza;
    private zzem zzf = zzdz.zza;
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzeh.zzV(zzp.class, zzpVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        if (i2 == 4) {
            return new zzl(zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzk = zzehVar == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
