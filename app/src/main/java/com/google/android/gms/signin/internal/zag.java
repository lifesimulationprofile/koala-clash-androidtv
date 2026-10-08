package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zag> CREATOR = new zzb(3);
    public final List zaa;
    public final String zab;

    public zag(ArrayList arrayList, String str) {
        this.zaa = arrayList;
        this.zab = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        List<String> list = this.zaa;
        if (list != null) {
            int iZza2 = zzkp.zza(parcel, 1);
            parcel.writeStringList(list);
            zzkp.zzb(parcel, iZza2);
        }
        zzkp.writeString(parcel, 2, this.zab);
        zzkp.zzb(parcel, iZza);
    }
}
