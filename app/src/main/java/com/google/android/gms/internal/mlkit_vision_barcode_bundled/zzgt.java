package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.compose.ui.unit.Density;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzgt {
    public static final zzgt zza = new zzgt(0, new int[0], new Object[0], false);
    public int zzb;
    public int[] zzc;
    public Object[] zzd;
    public int zze = -1;
    public boolean zzf;

    public zzgt(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzgt zzf() {
        return new zzgt(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgt)) {
            return false;
        }
        zzgt zzgtVar = (zzgt) obj;
        int i = this.zzb;
        if (i == zzgtVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgtVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzgtVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzA;
        int iZzB;
        int iZzA2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iM = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        int i6 = i4 << 3;
                        zzdf zzdfVar = (zzdf) this.zzd[i2];
                        int iZzA3 = zzdk.zzA(i6);
                        int iZzd = zzdfVar.zzd();
                        iM = Density.CC.m(iZzd, iZzd, iZzA3, iM);
                    } else if (i5 == 3) {
                        int iZzA4 = zzdk.zzA(i4 << 3);
                        iZzA = iZzA4 + iZzA4;
                        iZzB = ((zzgt) this.zzd[i2]).zza();
                    } else {
                        if (i5 != 5) {
                            throw new IllegalStateException(new zzeq());
                        }
                        ((Integer) this.zzd[i2]).getClass();
                        iZzA2 = zzdk.zzA(i4 << 3) + 4;
                    }
                } else {
                    ((Long) this.zzd[i2]).getClass();
                    iZzA2 = zzdk.zzA(i4 << 3) + 8;
                }
                iM = iZzA2 + iM;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzA = zzdk.zzA(i7);
                iZzB = zzdk.zzB(jLongValue);
            }
            iM = iZzB + iZzA + iM;
        }
        this.zze = iM;
        return iM;
    }

    public final void zzj(int i, Object obj) {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzl(zzfe zzfeVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    ((zzdk) zzfeVar.zzb).zzu(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    ((zzdk) zzfeVar.zzb).zzh(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    ((zzdk) zzfeVar.zzb).zze(i4, (zzdf) obj);
                } else if (i3 == 3) {
                    ((zzdk) zzfeVar.zzb).zzr(i4, 3);
                    ((zzgt) obj).zzl(zzfeVar);
                    ((zzdk) zzfeVar.zzb).zzr(i4, 4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new zzeq());
                    }
                    ((zzdk) zzfeVar.zzb).zzf(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }
}
