package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new zzal(9);
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;

    public zzar(int i, String str, String str2, String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        zzkp.writeString(parcel, 2, this.zzb);
        zzkp.writeString(parcel, 3, this.zzc);
        zzkp.writeString(parcel, 4, this.zzd);
        zzkp.zzb(parcel, iZza);
    }
}
