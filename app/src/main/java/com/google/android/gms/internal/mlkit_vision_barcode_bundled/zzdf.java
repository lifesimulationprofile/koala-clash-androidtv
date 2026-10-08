package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import com.google.android.gms.internal.mlkit_vision_common.zzlh;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzdf implements Iterable, Serializable {
    public static final zzde zzb = new zzde(zzep.zzb);
    public int zza = 0;

    static {
        int i = zzct.$r8$clinit;
    }

    public static zzdf zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "length (", ") must be >= 1"));
        }
        if (i == 1) {
            return (zzdf) it.next();
        }
        int i2 = i >>> 1;
        zzdf zzdfVarZzc = zzc(it, i2);
        zzdf zzdfVarZzc2 = zzc(it, i - i2);
        if (Integer.MAX_VALUE - zzdfVarZzc.zzd() < zzdfVarZzc2.zzd()) {
            throw new IllegalArgumentException(Modifier.CC.m(zzdfVarZzc.zzd(), zzdfVarZzc2.zzd(), "ByteString would be too long: ", "+"));
        }
        if (zzdfVarZzc2.zzd() == 0) {
            return zzdfVarZzc;
        }
        if (zzdfVarZzc.zzd() == 0) {
            return zzdfVarZzc2;
        }
        int iZzd = zzdfVarZzc2.zzd() + zzdfVarZzc.zzd();
        if (iZzd < 128) {
            int iZzd2 = zzdfVarZzc.zzd();
            int iZzd3 = zzdfVarZzc2.zzd();
            int i3 = iZzd2 + iZzd3;
            byte[] bArr = new byte[i3];
            zzo(0, iZzd2, zzdfVarZzc.zzd());
            zzo(0, iZzd2, i3);
            if (iZzd2 > 0) {
                zzdfVarZzc.zze(0, 0, iZzd2, bArr);
            }
            zzo(0, iZzd3, zzdfVarZzc2.zzd());
            zzo(iZzd2, i3, i3);
            if (iZzd3 > 0) {
                zzdfVarZzc2.zze(0, iZzd2, iZzd3, bArr);
            }
            return new zzde(bArr);
        }
        if (zzdfVarZzc instanceof zzgd) {
            zzgd zzgdVar = (zzgd) zzdfVarZzc;
            zzdf zzdfVar = zzgdVar.zzd;
            zzdf zzdfVar2 = zzgdVar.zze;
            if (zzdfVarZzc2.zzd() + zzdfVar2.zzd() < 128) {
                int iZzd4 = zzdfVar2.zzd();
                int iZzd5 = zzdfVarZzc2.zzd();
                int i4 = iZzd4 + iZzd5;
                byte[] bArr2 = new byte[i4];
                zzo(0, iZzd4, zzdfVar2.zzd());
                zzo(0, iZzd4, i4);
                if (iZzd4 > 0) {
                    zzdfVar2.zze(0, 0, iZzd4, bArr2);
                }
                zzo(0, iZzd5, zzdfVarZzc2.zzd());
                zzo(iZzd4, i4, i4);
                if (iZzd5 > 0) {
                    zzdfVarZzc2.zze(0, iZzd4, iZzd5, bArr2);
                }
                return new zzgd(zzdfVar, new zzde(bArr2));
            }
            if (zzdfVar.zzf() > zzdfVar2.zzf() && zzgdVar.zzg > zzdfVarZzc2.zzf()) {
                return new zzgd(zzdfVar, new zzgd(zzdfVar2, zzdfVarZzc2));
            }
        }
        if (iZzd >= zzgd.zzc(Math.max(zzdfVarZzc.zzf(), zzdfVarZzc2.zzf()) + 1)) {
            return new zzgd(zzdfVarZzc, zzdfVarZzc2);
        }
        zzfe zzfeVar = new zzfe(3);
        zzfeVar.zzb(zzdfVarZzc);
        zzfeVar.zzb(zzdfVarZzc2);
        ArrayDeque arrayDeque = (ArrayDeque) zzfeVar.zzb;
        zzdf zzgdVar2 = (zzdf) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zzgdVar2 = new zzgd((zzdf) arrayDeque.pop(), zzgdVar2);
        }
        return zzgdVar2;
    }

    public static int zzo(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(Modifier.CC.m(i2, i3, "End index: ", " >= "));
    }

    public static zzde zzr(byte[] bArr, int i, int i2) {
        zzo(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzde(bArr2);
    }

    public static zzdf zzs(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i = 0;
            while (i < iMin) {
                int i2 = inputStream.read(bArr, i, iMin - i);
                if (i2 == -1) {
                    break;
                }
                i += i2;
            }
            zzde zzdeVarZzr = i == 0 ? null : zzr(bArr, 0, i);
            if (zzdeVarZzr == null) {
                break;
            }
            arrayList.add(zzdeVarZzr);
            iMin = Math.min(iMin + iMin, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : zzc(arrayList.iterator(), size);
    }

    public static void zzu(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i >= 0) {
                throw new ArrayIndexOutOfBoundsException(Modifier.CC.m(i, i2, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(ImageAnalysis$$ExternalSyntheticLambda1.m("Index < 0: ", i));
        }
    }

    public final int hashCode() {
        int iZzi = this.zza;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zza = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strZza = zzd() <= 50 ? zzlh.zza(this) : zzlh.zza(zzk(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzd);
        sb.append(" contents=\"");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, strZza, "\">");
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract void zze(int i, int i2, int i3, byte[] bArr);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i, int i2, int i3);

    public abstract int zzj(int i, int i2, int i3);

    public abstract zzdf zzk(int i, int i2);

    public abstract String zzl(Charset charset);

    public abstract void zzm(zzdk zzdkVar);

    public abstract boolean zzn();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.internal.mlkit_common.zzas iterator() {
        return new zzcy(this);
    }
}
