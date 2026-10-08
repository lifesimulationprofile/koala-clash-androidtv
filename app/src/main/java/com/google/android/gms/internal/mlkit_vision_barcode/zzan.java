package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzh(9);
    public int zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zzan(int i, int i2, int i3, int i4, long j) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = j;
        this.zze = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        int i2 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(i2);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 5, 8);
        parcel.writeLong(this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 6, 4);
        parcel.writeInt(this.zze);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
