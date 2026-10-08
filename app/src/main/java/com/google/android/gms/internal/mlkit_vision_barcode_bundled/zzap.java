package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new zzal(7);
    public final zzat zza;
    public final String zzb;
    public final String zzc;
    public final zzau[] zzd;
    public final zzar[] zze;
    public final String[] zzf;
    public final zzam[] zzg;

    public zzap(zzat zzatVar, String str, String str2, zzau[] zzauVarArr, zzar[] zzarVarArr, String[] strArr, zzam[] zzamVarArr) {
        this.zza = zzatVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzauVarArr;
        this.zze = zzarVarArr;
        this.zzf = strArr;
        this.zzg = zzamVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.writeParcelable(parcel, 1, this.zza, i);
        zzkp.writeString(parcel, 2, this.zzb);
        zzkp.writeString(parcel, 3, this.zzc);
        zzkp.writeTypedArray(parcel, 4, this.zzd, i);
        zzkp.writeTypedArray(parcel, 5, this.zze, i);
        zzkp.writeStringArray(parcel, 6, this.zzf);
        zzkp.writeTypedArray(parcel, 7, this.zzg, i);
        zzkp.zzb(parcel, iZza);
    }
}
