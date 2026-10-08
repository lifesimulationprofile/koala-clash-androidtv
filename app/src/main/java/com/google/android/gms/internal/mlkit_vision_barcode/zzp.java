package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzh(3);
    public String zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public String zzg;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 2, this.zza);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 4, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 5, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 6, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 7, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 8, this.zzg);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
