package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.base.zaa;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzaj extends zaa {
    public final zzu[] zze(ObjectWrapper objectWrapper, zzan zzanVar) {
        Parcel parcelZza = zza();
        int i = zzc.$r8$clinit;
        parcelZza.writeStrongBinder(objectWrapper);
        parcelZza.writeInt(1);
        zzanVar.writeToParcel(parcelZza, 0);
        Parcel parcelZzb = zzb(parcelZza, 1);
        zzu[] zzuVarArr = (zzu[]) parcelZzb.createTypedArray(zzu.CREATOR);
        parcelZzb.recycle();
        return zzuVarArr;
    }
}
