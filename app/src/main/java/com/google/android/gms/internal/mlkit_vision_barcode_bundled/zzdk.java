package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_common.zzlf;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.io.FileSystemException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzdk extends zzlf {
    public static final Logger zzb$1 = Logger.getLogger(zzdk.class.getName());
    public static final boolean zzc$1 = zzgz.zzh;
    public zzfe zza;
    public final byte[] zzb;
    public final int zzc;
    public int zzd;

    public zzdk(int i, byte[] bArr) {
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i;
    }

    public static int zzA(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzB(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzhe.zze(str);
        } catch (zzhd unused) {
            length = str.getBytes(zzep.zza).length;
        }
        return zzA(length) + length;
    }

    public final void zzb(byte b) throws FileSystemException {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            this.zzd = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new FileSystemException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
            this.zzd += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new FileSystemException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i2)), e);
        }
    }

    public final void zze(int i, zzdf zzdfVar) throws FileSystemException {
        zzt((i << 3) | 2);
        zzt(zzdfVar.zzd());
        zzdfVar.zzm(this);
    }

    public final void zzf(int i, int i2) throws FileSystemException {
        zzt((i << 3) | 5);
        zzg(i2);
    }

    public final void zzg(int i) throws FileSystemException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            int i3 = i2 + 1;
            this.zzd = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.zzd = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.zzd = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zzd = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new FileSystemException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    public final void zzh(int i, long j) throws FileSystemException {
        zzt((i << 3) | 1);
        zzi(j);
    }

    public final void zzi(long j) throws FileSystemException {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            int i2 = i + 1;
            this.zzd = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.zzd = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.zzd = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.zzd = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.zzd = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zzd = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new FileSystemException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    public final void zzj(int i, int i2) throws FileSystemException {
        zzt(i << 3);
        zzk(i2);
    }

    public final void zzk(int i) throws FileSystemException {
        if (i >= 0) {
            zzt(i);
        } else {
            zzv(i);
        }
    }

    public final void zzp(String str, int i) throws FileSystemException {
        zzt((i << 3) | 2);
        int i2 = this.zzd;
        try {
            int iZzA = zzA(str.length() * 3);
            int iZzA2 = zzA(str.length());
            int i3 = this.zzc;
            byte[] bArr = this.zzb;
            if (iZzA2 != iZzA) {
                zzt(zzhe.zze(str));
                int i4 = this.zzd;
                this.zzd = zzhe.zzd(str, bArr, i4, i3 - i4);
            } else {
                int i5 = i2 + iZzA2;
                this.zzd = i5;
                int iZzd = zzhe.zzd(str, bArr, i5, i3 - i5);
                this.zzd = i2;
                zzt((iZzd - i2) - iZzA2);
                this.zzd = iZzd;
            }
        } catch (zzhd e) {
            this.zzd = i2;
            zzb$1.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
            byte[] bytes = str.getBytes(zzep.zza);
            try {
                int length = bytes.length;
                zzt(length);
                zzc(bytes, 0, length);
            } catch (IndexOutOfBoundsException e2) {
                throw new FileSystemException(e2);
            }
        } catch (IndexOutOfBoundsException e3) {
            throw new FileSystemException(e3);
        }
    }

    public final void zzr(int i, int i2) throws FileSystemException {
        zzt((i << 3) | i2);
    }

    public final void zzs(int i, int i2) throws FileSystemException {
        zzt(i << 3);
        zzt(i2);
    }

    public final void zzt(int i) throws FileSystemException {
        while (true) {
            int i2 = i & (-128);
            byte[] bArr = this.zzb;
            if (i2 == 0) {
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr[i3] = (byte) i;
                return;
            } else {
                try {
                    int i4 = this.zzd;
                    this.zzd = i4 + 1;
                    bArr[i4] = (byte) ((i | 128) & 255);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new FileSystemException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
                }
            }
            throw new FileSystemException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    public final void zzu(int i, long j) throws FileSystemException {
        zzt(i << 3);
        zzv(j);
    }

    public final void zzv(long j) throws FileSystemException {
        boolean z = zzc$1;
        int i = this.zzc;
        byte[] bArr = this.zzb;
        if (!z || i - this.zzd < 10) {
            while ((j & (-128)) != 0) {
                try {
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new FileSystemException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(i), 1), e);
                }
            }
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            bArr[i3] = (byte) j;
            return;
        }
        while (true) {
            int i4 = (int) j;
            if ((j & (-128)) == 0) {
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                zzgz.zzf.zzd(bArr, zzgz.zza + ((long) i5), (byte) i4);
                return;
            } else {
                int i6 = this.zzd;
                this.zzd = i6 + 1;
                zzgz.zzf.zzd(bArr, zzgz.zza + ((long) i6), (byte) ((i4 | 128) & 255));
                j >>>= 7;
            }
        }
    }
}
