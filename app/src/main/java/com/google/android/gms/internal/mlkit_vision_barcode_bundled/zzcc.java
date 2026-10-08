package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzal(19);
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final long zze;

    public zzcc(int i, int i2, int i3, int i4, long j) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        zzkp.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        zzkp.zzc(parcel, 5, 8);
        parcel.writeLong(this.zze);
        zzkp.zzb(parcel, iZza);
    }
}
