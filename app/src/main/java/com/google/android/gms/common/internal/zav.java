package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new FragmentState.AnonymousClass1(22);
    public final int zaa;
    public final IBinder zab;
    public final ConnectionResult zac;
    public final boolean zad;
    public final boolean zae;

    public zav(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.zaa = i;
        this.zab = iBinder;
        this.zac = connectionResult;
        this.zad = z;
        this.zae = z2;
    }

    public final boolean equals(Object obj) {
        Object zzwVar;
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            if (!(obj instanceof zav)) {
                return false;
            }
            zav zavVar = (zav) obj;
            if (!this.zac.equals(zavVar.zac)) {
                return false;
            }
            Object zzwVar2 = null;
            IBinder iBinder = this.zab;
            if (iBinder == null) {
                zzwVar = null;
            } else {
                int i = AccountAccessor.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                zzwVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzw(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            IBinder iBinder2 = zavVar.zab;
            if (iBinder2 != null) {
                int i2 = AccountAccessor.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                zzwVar2 = iInterfaceQueryLocalInterface2 instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface2 : new zzw(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            if (!zzah.equal(zzwVar, zzwVar2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        IBinder iBinder = this.zab;
        if (iBinder != null) {
            int iZza2 = zzkp.zza(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            zzkp.zzb(parcel, iZza2);
        }
        zzkp.writeParcelable(parcel, 3, this.zac, i);
        zzkp.zzc(parcel, 4, 4);
        parcel.writeInt(this.zad ? 1 : 0);
        zzkp.zzc(parcel, 5, 4);
        parcel.writeInt(this.zae ? 1 : 0);
        zzkp.zzb(parcel, iZza);
    }
}
