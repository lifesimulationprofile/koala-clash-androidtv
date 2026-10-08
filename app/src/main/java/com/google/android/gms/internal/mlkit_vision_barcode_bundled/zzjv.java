package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzjv extends zzed {
    private static final zzjv zzd;
    private byte zze;

    static {
        zzjv zzjvVar = new zzjv();
        zzd = zzjvVar;
        zzeh.zzV(zzjv.class, zzjvVar);
    }

    public zzjv() {
        this.zzb = zzdx.zzb;
        this.zze = (byte) 2;
    }

    public static zzjv zzf() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return new zzfw(zzd, "\u0003\u0000", null);
        }
        if (i2 == 3) {
            return new zzjv();
        }
        if (i2 == 4) {
            return new zze(1, zzd);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = zzehVar == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
