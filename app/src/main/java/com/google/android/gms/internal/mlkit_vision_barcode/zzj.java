package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzh(11);
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public String zzh;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        int i2 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 5, 4);
        parcel.writeInt(i5);
        int i6 = this.zze;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 6, 4);
        parcel.writeInt(i6);
        int i7 = this.zzf;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 7, 4);
        parcel.writeInt(i7);
        boolean z = this.zzg;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 8, 4);
        parcel.writeInt(z ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 9, this.zzh);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
