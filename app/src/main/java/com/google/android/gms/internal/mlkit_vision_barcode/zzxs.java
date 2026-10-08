package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzxs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxs> CREATOR = new zzh(18);
    public final zzxw zza;
    public final String zzb;
    public final String zzc;
    public final zzxx[] zzd;
    public final zzxu[] zze;
    public final String[] zzf;
    public final zzxp[] zzg;

    public zzxs(zzxw zzxwVar, String str, String str2, zzxx[] zzxxVarArr, zzxu[] zzxuVarArr, String[] strArr, zzxp[] zzxpVarArr) {
        this.zza = zzxwVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzxxVarArr;
        this.zze = zzxuVarArr;
        this.zzf = strArr;
        this.zzg = zzxpVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 1, this.zza, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeTypedArray(parcel, 4, this.zzd, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeTypedArray(parcel, 5, this.zze, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeStringArray(parcel, 6, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeTypedArray(parcel, 7, this.zzg, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
