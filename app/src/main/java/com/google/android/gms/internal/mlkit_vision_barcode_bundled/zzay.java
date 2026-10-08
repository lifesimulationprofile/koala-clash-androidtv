package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzal(1);
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    public final Point[] zze;
    public final int zzf;
    public final zzar zzg;
    public final zzau zzh;
    public final zzav zzi;
    public final zzax zzj;
    public final zzaw zzk;
    public final zzas zzl;
    public final zzao zzm;
    public final zzap zzn;
    public final zzaq zzo;

    public zzay(int i, String str, String str2, byte[] bArr, Point[] pointArr, int i2, zzar zzarVar, zzau zzauVar, zzav zzavVar, zzax zzaxVar, zzaw zzawVar, zzas zzasVar, zzao zzaoVar, zzap zzapVar, zzaq zzaqVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzarVar;
        this.zzh = zzauVar;
        this.zzi = zzavVar;
        this.zzj = zzaxVar;
        this.zzk = zzawVar;
        this.zzl = zzasVar;
        this.zzm = zzaoVar;
        this.zzn = zzapVar;
        this.zzo = zzaqVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        zzkp.writeString(parcel, 2, this.zzb);
        zzkp.writeString(parcel, 3, this.zzc);
        zzkp.writeByteArray(parcel, 4, this.zzd);
        zzkp.writeTypedArray(parcel, 5, this.zze, i);
        zzkp.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf);
        zzkp.writeParcelable(parcel, 7, this.zzg, i);
        zzkp.writeParcelable(parcel, 8, this.zzh, i);
        zzkp.writeParcelable(parcel, 9, this.zzi, i);
        zzkp.writeParcelable(parcel, 10, this.zzj, i);
        zzkp.writeParcelable(parcel, 11, this.zzk, i);
        zzkp.writeParcelable(parcel, 12, this.zzl, i);
        zzkp.writeParcelable(parcel, 13, this.zzm, i);
        zzkp.writeParcelable(parcel, 14, this.zzn, i);
        zzkp.writeParcelable(parcel, 15, this.zzo, i);
        zzkp.zzb(parcel, iZza);
    }
}
