package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdz;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzem;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzc extends zzeh implements zzfn {
    private static final zzc zzb;
    private int zzd;
    private zzem zze;
    private zzem zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzc zzcVar = new zzc();
        zzb = zzcVar;
        zzeh.zzV(zzc.class, zzcVar);
    }

    public zzc() {
        zzdz zzdzVar = zzdz.zza;
        this.zze = zzdzVar;
        this.zzf = zzdzVar;
    }

    public static zzb zza$1() {
        return (zzb) zzb.zzG();
    }

    public static /* synthetic */ void zzc(zzc zzcVar, int i) {
        zzcVar.zzd |= 2;
        zzcVar.zzh = i;
    }

    public static void zzd(zzc zzcVar, float f) {
        RandomAccess randomAccess = zzcVar.zze;
        if (!((zzcs) randomAccess).zza) {
            zzdz zzdzVar = (zzdz) randomAccess;
            int i = zzdzVar.zzc;
            int i2 = i == 0 ? 10 : i + i;
            if (i2 < i) {
                throw new IllegalArgumentException();
            }
            zzcVar.zze = new zzdz(Arrays.copyOf(zzdzVar.zzb, i2), zzdzVar.zzc, true);
        }
        ((zzdz) zzcVar.zze).zzh(f);
    }

    public static void zze(zzc zzcVar, float f) {
        RandomAccess randomAccess = zzcVar.zzf;
        if (!((zzcs) randomAccess).zza) {
            zzdz zzdzVar = (zzdz) randomAccess;
            int i = zzdzVar.zzc;
            int i2 = i == 0 ? 10 : i + i;
            if (i2 < i) {
                throw new IllegalArgumentException();
            }
            zzcVar.zzf = new zzdz(Arrays.copyOf(zzdzVar.zzb, i2), zzdzVar.zzc, true);
        }
        ((zzdz) zzcVar.zzf).zzh(f);
    }

    public static /* synthetic */ void zzf(zzc zzcVar, int i) {
        zzcVar.zzd |= 1;
        zzcVar.zzg = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzc();
        }
        if (i2 == 4) {
            return new zzb(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
