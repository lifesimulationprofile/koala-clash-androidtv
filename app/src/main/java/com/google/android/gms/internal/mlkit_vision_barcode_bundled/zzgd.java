package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode.zzbk;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzgd extends zzdf {
    public static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    public final int zzc;
    public final zzdf zzd;
    public final zzdf zze;
    public final int zzf;
    public final int zzg;

    public zzgd(zzdf zzdfVar, zzdf zzdfVar2) {
        this.zzd = zzdfVar;
        this.zze = zzdfVar2;
        int iZzd = zzdfVar.zzd();
        this.zzf = iZzd;
        this.zzc = zzdfVar2.zzd() + iZzd;
        this.zzg = Math.max(zzdfVar.zzf(), zzdfVar2.zzf()) + 1;
    }

    public static int zzc(int i) {
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return zza[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdf) {
            zzdf zzdfVar = (zzdf) obj;
            int iZzd = zzdfVar.zzd();
            int i = this.zzc;
            if (i == iZzd) {
                if (i == 0) {
                    return true;
                }
                int i2 = this.zza;
                int i3 = zzdfVar.zza;
                if (i2 == 0 || i3 == 0 || i2 == i3) {
                    zzbk zzbkVar = new zzbk(this);
                    zzde zzdeVarZza = zzbkVar.zza();
                    zzbk zzbkVar2 = new zzbk(zzdfVar);
                    zzde zzdeVarZza2 = zzbkVar2.zza();
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        int iZzd2 = zzdeVarZza.zzd() - i4;
                        int iZzd3 = zzdeVarZza2.zzd() - i5;
                        int iMin = Math.min(iZzd2, iZzd3);
                        if (!(i4 == 0 ? zzdeVarZza.zzg(zzdeVarZza2, i5, iMin) : zzdeVarZza2.zzg(zzdeVarZza, i4, iMin))) {
                            break;
                        }
                        i6 += iMin;
                        if (i6 >= i) {
                            if (i6 == i) {
                                return true;
                            }
                            throw new IllegalStateException();
                        }
                        if (iMin == iZzd2) {
                            zzdeVarZza = zzbkVar.zza();
                            i4 = 0;
                        } else {
                            i4 += iMin;
                        }
                        if (iMin == iZzd3) {
                            zzdeVarZza2 = zzbkVar2.zza();
                            i5 = 0;
                        } else {
                            i5 += iMin;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzfx(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zza(int i) {
        zzdf.zzu(i, this.zzc);
        return zzb(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zzb(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zzb(i) : this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zze(int i, int i2, int i3, byte[] bArr) {
        int i4 = i + i3;
        zzdf zzdfVar = this.zzd;
        int i5 = this.zzf;
        if (i4 <= i5) {
            zzdfVar.zze(i, i2, i3, bArr);
            return;
        }
        zzdf zzdfVar2 = this.zze;
        if (i >= i5) {
            zzdfVar2.zze(i - i5, i2, i3, bArr);
            return;
        }
        int i6 = i5 - i;
        zzdfVar.zze(i, i2, i6, bArr);
        zzdfVar2.zze(0, i2 + i6, i3 - i6, bArr);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        zzdf zzdfVar = this.zzd;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return zzdfVar.zzi(i, i2, i3);
        }
        zzdf zzdfVar2 = this.zze;
        if (i2 >= i5) {
            return zzdfVar2.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return zzdfVar2.zzi(zzdfVar.zzi(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        zzdf zzdfVar = this.zzd;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return zzdfVar.zzj(i, i2, i3);
        }
        zzdf zzdfVar2 = this.zze;
        if (i2 >= i5) {
            return zzdfVar2.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return zzdfVar2.zzj(zzdfVar.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf zzk(int i, int i2) {
        int i3 = this.zzc;
        int iZzo = zzdf.zzo(i, i2, i3);
        if (iZzo == 0) {
            return zzdf.zzb;
        }
        if (iZzo == i3) {
            return this;
        }
        zzdf zzdfVar = this.zzd;
        int i4 = this.zzf;
        if (i2 <= i4) {
            return zzdfVar.zzk(i, i2);
        }
        zzdf zzdfVar2 = this.zze;
        if (i < i4) {
            return new zzgd(zzdfVar.zzk(i, zzdfVar.zzd()), zzdfVar2.zzk(0, i2 - i4));
        }
        return zzdfVar2.zzk(i - i4, i2 - i4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String zzl(Charset charset) {
        byte[] bArr;
        int iZzd = zzd();
        if (iZzd == 0) {
            bArr = zzep.zzb;
        } else {
            byte[] bArr2 = new byte[iZzd];
            zze(0, 0, iZzd, bArr2);
            bArr = bArr2;
        }
        return new String(bArr, charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zzm(zzdk zzdkVar) {
        this.zzd.zzm(zzdkVar);
        this.zze.zzm(zzdkVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzn() {
        int iZzj = this.zzd.zzj(0, 0, this.zzf);
        zzdf zzdfVar = this.zze;
        return zzdfVar.zzj(iZzj, 0, zzdfVar.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    /* JADX INFO: renamed from: zzq */
    public final com.google.android.gms.internal.mlkit_common.zzas iterator() {
        return new zzfx(this);
    }
}
