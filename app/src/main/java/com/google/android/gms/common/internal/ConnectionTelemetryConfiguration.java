package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new FragmentState.AnonymousClass1(25);
    public final RootTelemetryConfiguration zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int[] zzd;
    public final int zze;
    public final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.writeParcelable(parcel, 1, this.zza, i);
        zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        int[] iArr = this.zzd;
        if (iArr != null) {
            int iZza2 = zzkp.zza(parcel, 4);
            parcel.writeIntArray(iArr);
            zzkp.zzb(parcel, iZza2);
        }
        zzkp.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        int[] iArr2 = this.zzf;
        if (iArr2 != null) {
            int iZza3 = zzkp.zza(parcel, 6);
            parcel.writeIntArray(iArr2);
            zzkp.zzb(parcel, iZza3);
        }
        zzkp.zzb(parcel, iZza);
    }
}
