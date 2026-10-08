package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzbt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbt> CREATOR = new zzal(12);
    public final float[] zza;
    public final int zzb;
    public final boolean zzc;

    public zzbt(float[] fArr, int i, boolean z) {
        this.zza = fArr;
        this.zzb = i;
        this.zzc = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        float[] fArr = this.zza;
        if (fArr != null) {
            int iZza2 = zzkp.zza(parcel, 1);
            parcel.writeFloatArray(fArr);
            zzkp.zzb(parcel, iZza2);
        }
        zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        zzkp.zzb(parcel, iZza);
    }
}
