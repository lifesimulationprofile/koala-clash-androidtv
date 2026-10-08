package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new FragmentState.AnonymousClass1(29);
    public final int zaa;
    public final boolean zab;

    public ModuleInstallResponse(int i, boolean z) {
        this.zaa = i;
        this.zab = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(this.zab ? 1 : 0);
        zzkp.zzb(parcel, iZza);
    }
}
