package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzf extends zzeh implements zzfn {
    private static final zzf zzb;
    private int zzd;
    private zzeo zzf;
    private zzeo zzg;
    private zzeo zzh;
    private zzjv zzi;
    private zzf zzj;
    private zzx zzk;
    private byte zzl = 2;
    private String zze = "";

    static {
        zzf zzfVar = new zzf();
        zzb = zzfVar;
        zzeh.zzV(zzf.class, zzfVar);
        zzjv zzjvVarZzf = zzjv.zzf();
        zzhf zzhfVar = zzhf.zzj;
        if (zzjvVarZzf == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    public zzf() {
        zzfv zzfvVar = zzfv.zza;
        this.zzf = zzfvVar;
        this.zzg = zzfvVar;
        this.zzh = zzfvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\u0007\u0000\u0001\u0002Ǵ\u0007\u0000\u0003\u0004\u0002Л\u0005Л\u0006\u001b\bᐉ\u0001\nဈ\u0000\u000bᐉ\u0002Ǵဉ\u0003", new Object[]{"zzd", "zzf", zzj.class, "zzh", zzj.class, "zzg", zzm.class, "zzi", "zze", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzf();
        }
        if (i2 == 4) {
            return new zze(0, zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzl = zzehVar == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
