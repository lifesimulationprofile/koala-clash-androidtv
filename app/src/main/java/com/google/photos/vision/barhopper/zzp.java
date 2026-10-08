package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzci;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfv;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfw;
import com.google.barhopper.deeplearning.zzm;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzp extends zzeh implements zzfn {
    private static final zzp zzb;
    private int zzd;
    private zzck zze;
    private zzeo zzh;
    private zzeo zzi;
    private zzeo zzj;
    private zzeo zzk;
    private String zzl;
    private byte zzm = 2;
    private String zzf = "";
    private String zzg = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzeh.zzV(zzp.class, zzpVar);
    }

    public zzp() {
        zzfv zzfvVar = zzfv.zza;
        this.zzh = zzfvVar;
        this.zzi = zzfvVar;
        this.zzj = zzfvVar;
        this.zzk = zzfvVar;
        this.zzl = "";
    }

    public static zzp zzc() {
        return zzb;
    }

    public final zzck zza() {
        zzck zzckVar = this.zze;
        return zzckVar == null ? zzck.zzb() : zzckVar;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final String zze() {
        return this.zzg;
    }

    public final zzeo zzf() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0004\u0001\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004\u001b\u0005\u001b\u0006\u001a\u0007Л\bဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzco.class, "zzi", zzv.class, "zzj", "zzk", zzci.class, "zzl"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        if (i2 == 4) {
            return new zzm(zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzm = zzehVar == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final zzeo zzh() {
        return this.zzi;
    }

    public final zzeo zzi() {
        return this.zzh;
    }

    public final zzeo zzj() {
        return this.zzj;
    }
}
