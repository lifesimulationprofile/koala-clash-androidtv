package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new FragmentState.AnonymousClass1(24);
    public Bundle zza;
    public Feature[] zzb;
    public int zzc;
    public ConnectionTelemetryConfiguration zzd;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        Bundle bundle = this.zza;
        if (bundle != null) {
            int iZza2 = zzkp.zza(parcel, 1);
            parcel.writeBundle(bundle);
            zzkp.zzb(parcel, iZza2);
        }
        zzkp.writeTypedArray(parcel, 2, this.zzb, i);
        int i2 = this.zzc;
        zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(i2);
        zzkp.writeParcelable(parcel, 4, this.zzd, i);
        zzkp.zzb(parcel, iZza);
    }
}
