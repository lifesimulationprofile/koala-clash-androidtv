package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzxt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxt> CREATOR = new zzh(19);
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final String zzg;
    public final String zzh;
    public final String zzi;
    public final String zzj;
    public final String zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;

    public zzxt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = str9;
        this.zzj = str10;
        this.zzk = str11;
        this.zzl = str12;
        this.zzm = str13;
        this.zzn = str14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 1, this.zza);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 5, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 6, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 7, this.zzg);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 8, this.zzh);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 9, this.zzi);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 10, this.zzj);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 11, this.zzk);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 12, this.zzl);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 13, this.zzm);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 14, this.zzn);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
