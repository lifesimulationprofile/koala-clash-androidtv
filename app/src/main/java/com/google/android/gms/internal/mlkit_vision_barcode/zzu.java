package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzh(10);
    public int zza;
    public String zzb;
    public String zzc;
    public int zzd;
    public Point[] zze;
    public zzn zzf;
    public zzq zzg;
    public zzr zzh;
    public zzt zzi;
    public zzs zzj;
    public zzo zzk;
    public zzk zzl;
    public zzl zzm;
    public zzm zzn;
    public byte[] zzo;
    public boolean zzp;
    public double zzq;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzkp.zza(parcel, 20293);
        int i2 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(i2);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeString(parcel, 4, this.zzc);
        int i3 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 5, 4);
        parcel.writeInt(i3);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeTypedArray(parcel, 6, this.zze, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 7, this.zzf, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 8, this.zzg, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 9, this.zzh, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 10, this.zzi, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 11, this.zzj, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 12, this.zzk, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 13, this.zzl, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 14, this.zzm, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeParcelable(parcel, 15, this.zzn, i);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.writeByteArray(parcel, 16, this.zzo);
        boolean z = this.zzp;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 17, 4);
        parcel.writeInt(z ? 1 : 0);
        double d = this.zzq;
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzc(parcel, 18, 8);
        parcel.writeDouble(d);
        com.google.android.gms.internal.mlkit_vision_common.zzkp.zzb(parcel, iZza);
    }
}
