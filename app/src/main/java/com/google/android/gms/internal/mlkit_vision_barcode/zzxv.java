package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzxv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxv> CREATOR = new zzh(21);
    public final double zza;
    public final double zzb;

    public zzxv(double d, double d2) {
        this.zza = d;
        this.zzb = d2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 1, 8);
        parcel.writeDouble(this.zza);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 2, 8);
        parcel.writeDouble(this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
