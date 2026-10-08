package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class zzde extends zzdf {
    public final byte[] zza;

    public zzde(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdf) && zzd() == ((zzdf) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (!(obj instanceof zzde)) {
                return obj.equals(this);
            }
            zzde zzdeVar = (zzde) obj;
            int i = super.zza;
            int i2 = ((zzdf) zzdeVar).zza;
            if (i == 0 || i2 == 0 || i == i2) {
                return zzg(zzdeVar, 0, zzd());
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public void zze(int i, int i2, int i3, byte[] bArr) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzf() {
        return 0;
    }

    public final boolean zzg(zzde zzdeVar, int i, int i2) {
        if (i2 > zzdeVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        if (i + i2 > zzdeVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzdeVar.zzd());
        }
        byte[] bArr = zzdeVar.zza;
        int iZzc = zzc() + i2;
        int iZzc2 = zzc();
        int iZzc3 = zzdeVar.zzc() + i;
        while (iZzc2 < iZzc) {
            if (this.zza[iZzc2] != bArr[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzi(int i, int i2, int i3) {
        int iZzc = zzc() + i2;
        Charset charset = zzep.zza;
        for (int i4 = iZzc; i4 < iZzc + i3; i4++) {
            i = (i * 31) + this.zza[i4];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzj(int i, int i2, int i3) {
        int iZzc = zzc() + i2;
        zzhe.zzb.getClass();
        return zzea.zza(i, iZzc, i3 + iZzc, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf zzk(int i, int i2) {
        int iZzo = zzdf.zzo(i, i2, zzd());
        if (iZzo == 0) {
            return zzdf.zzb;
        }
        return new zzda(this.zza, zzc() + i, iZzo);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String zzl(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zzm(zzdk zzdkVar) {
        zzdkVar.zzc(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzn() {
        int iZzc = zzc();
        int iZzd = zzd() + iZzc;
        zzhe.zzb.getClass();
        return zzea.zza(0, iZzc, iZzd, this.zza) == 0;
    }
}
