package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzal(3);
    public final zzbt zza;
    public final zzbv zzb;
    public final boolean zzd;

    public zzbc(zzbt zzbtVar, zzbv zzbvVar, boolean z) {
        this.zza = zzbtVar;
        this.zzb = zzbvVar;
        this.zzd = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.writeParcelable(parcel, 1, this.zza, i);
        zzkp.writeParcelable(parcel, 2, this.zzb, i);
        zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(1);
        zzkp.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        zzkp.zzb(parcel, iZza);
    }
}
