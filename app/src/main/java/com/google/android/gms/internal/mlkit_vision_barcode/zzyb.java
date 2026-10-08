package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzyb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyb> CREATOR = new zzh(15);
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    public final Point[] zze;
    public final int zzf;
    public final zzxu zzg;
    public final zzxx zzh;
    public final zzxy zzi;
    public final zzya zzj;
    public final zzxz zzk;
    public final zzxv zzl;
    public final zzxr zzm;
    public final zzxs zzn;
    public final zzxt zzo;

    public zzyb(int i, String str, String str2, byte[] bArr, Point[] pointArr, int i2, zzxu zzxuVar, zzxx zzxxVar, zzxy zzxyVar, zzya zzyaVar, zzxz zzxzVar, zzxv zzxvVar, zzxr zzxrVar, zzxs zzxsVar, zzxt zzxtVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzxuVar;
        this.zzh = zzxxVar;
        this.zzi = zzxyVar;
        this.zzj = zzyaVar;
        this.zzk = zzxzVar;
        this.zzl = zzxvVar;
        this.zzm = zzxrVar;
        this.zzn = zzxsVar;
        this.zzo = zzxtVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeByteArray(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeTypedArray(parcel, 5, this.zze, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 7, this.zzg, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 8, this.zzh, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 9, this.zzi, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 10, this.zzj, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 11, this.zzk, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 12, this.zzl, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 13, this.zzm, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 14, this.zzn, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 15, this.zzo, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
