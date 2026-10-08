package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzle {
    public static int zza(byte[] bArr, int i, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        int iZzj = zzj(bArr, i, zzcuVar);
        int i2 = zzcuVar.zza;
        if (i2 < 0) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzj) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzcuVar.zzc = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf.zzb;
            return iZzj;
        }
        zzcuVar.zzc = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf.zzr(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzc(int i, byte[] bArr) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzf(com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge zzgeVar, int i, byte[] bArr, int i2, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo zzeoVar, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        Object objZze = zzgeVar.zze();
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge zzgeVar2 = zzgeVar;
        byte[] bArr2 = bArr;
        int i4 = i3;
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar2 = zzcuVar;
        int iZzo = zzo(objZze, zzgeVar2, bArr2, i2, i4, zzcuVar2);
        zzgeVar2.zzf(objZze);
        zzcuVar2.zzc = objZze;
        zzeoVar.add(objZze);
        while (iZzo < i4) {
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar3 = zzcuVar2;
            int i5 = i4;
            int iZzj = zzj(bArr2, iZzo, zzcuVar3);
            if (i != zzcuVar3.zza) {
                break;
            }
            byte[] bArr3 = bArr2;
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge zzgeVar3 = zzgeVar2;
            Object objZze2 = zzgeVar3.zze();
            iZzo = zzo(objZze2, zzgeVar3, bArr3, iZzj, i5, zzcuVar3);
            zzgeVar2 = zzgeVar3;
            bArr2 = bArr3;
            i4 = i5;
            zzcuVar2 = zzcuVar3;
            zzgeVar2.zzf(objZze2);
            zzcuVar2.zzc = objZze2;
            zzeoVar.add(objZze2);
        }
        return iZzo;
    }

    public static int zzg(byte[] bArr, int i, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo zzeoVar, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei zzeiVar = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei) zzeoVar;
        int iZzj = zzj(bArr, i, zzcuVar);
        int i2 = zzcuVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt zzgtVar, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        if ((i >>> 3) == 0) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzcuVar);
            zzgtVar.zzj(i, Long.valueOf(zzcuVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzgtVar.zzj(i, Long.valueOf(zzq(i2, bArr)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzcuVar);
            int i5 = zzcuVar.zza;
            if (i5 < 0) {
                throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzj) {
                throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzgtVar.zzj(i, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf.zzb);
            } else {
                zzgtVar.zzj(i, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf.zzr(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Protocol message contained an invalid tag (zero).");
            }
            zzgtVar.zzj(i, Integer.valueOf(zzc(i2, bArr)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt zzgtVarZzf = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt.zzf();
        int i7 = zzcuVar.zze + 1;
        zzcuVar.zze = i7;
        if (i7 >= 100) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i8 = 0;
        while (i2 < i3) {
            int iZzj2 = zzj(bArr, i2, zzcuVar);
            int i9 = zzcuVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZzj2;
                break;
            }
            i2 = zzi(i9, bArr, iZzj2, i3, zzgtVarZzf, zzcuVar);
            i8 = i9;
        }
        zzcuVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Failed to parse the message.");
        }
        zzgtVar.zzj(i, zzgtVarZzf);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzcuVar);
        }
        zzcuVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzcuVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzcuVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzcuVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzcuVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzcuVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo zzeoVar, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei zzeiVar = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei) zzeoVar;
        int iZzj = zzj(bArr, i2, zzcuVar);
        zzeiVar.zzg(zzcuVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzcuVar);
            if (i != zzcuVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzcuVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzcuVar.zzb = j2;
        return i3;
    }

    public static int zzn(Object obj, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge zzgeVar, byte[] bArr, int i, int i2, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp zzfpVar = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp) zzgeVar;
        int i4 = zzcuVar.zze + 1;
        zzcuVar.zze = i4;
        if (i4 >= 100) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iZzc = zzfpVar.zzc(obj, bArr, i, i2, i3, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return iZzc;
    }

    public static int zzo(Object obj, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge zzgeVar, byte[] bArr, int i, int i2, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzcuVar);
            i3 = zzcuVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzcuVar.zze + 1;
        zzcuVar.zze = i5;
        if (i5 >= 100) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i6 = i4 + i3;
        zzgeVar.zzh(obj, bArr, i4, i6, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return i6;
    }

    public static int zzp(int i, byte[] bArr, int i2, int i3, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu zzcuVar) {
        if ((i >>> 3) == 0) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zzcuVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zzcuVar) + zzcuVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zzcuVar);
            i6 = zzcuVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzcuVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Failed to parse the message.");
        }
        return i2;
    }

    public static long zzq(int i, byte[] bArr) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
