package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhk;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzi extends zzeh implements zzfn {
    private static final zzi zzb;
    private int zzd;
    private zzf zzj;
    private zzhk zzl;
    private String zze = "";
    private zzdf zzf = zzdf.zzb;
    private int zzg = 10;
    private float zzh = 0.5f;
    private float zzi = 0.05f;
    private int zzk = 1;
    private int zzm = 320;
    private int zzn = 4;
    private int zzo = 2;

    static {
        zzi zziVar = new zzi();
        zzb = zziVar;
        zzeh.zzV(zzi.class, zziVar);
    }

    public static zzh zza$1() {
        return (zzh) zzb.zzG();
    }

    public static /* synthetic */ void zzc(zzi zziVar, zzf zzfVar) {
        zziVar.zzj = zzfVar;
        zziVar.zzd |= 32;
    }

    public static /* synthetic */ void zzd(zzi zziVar, zzdf zzdfVar) {
        zzdfVar.getClass();
        zziVar.zzd |= 2;
        zziVar.zzf = zzdfVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0004\u000b\u0000\u0001\u0001\f\u000b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဉ\u0005\bင\u0006\tဉ\u0007\nင\b\u000bင\t\fင\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i2 == 3) {
            return new zzi();
        }
        if (i2 == 4) {
            return new zzh(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
