package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new zac();
    public final List zab;
    public final boolean zac;
    public final String zad;
    public final String zae;

    public ApiFeatureRequest(ArrayList arrayList, boolean z, String str, String str2) {
        zzah.checkNotNull(arrayList);
        this.zab = arrayList;
        this.zac = z;
        this.zad = str;
        this.zae = str2;
    }

    public static ApiFeatureRequest zaa(List list, boolean z) {
        TreeSet treeSet = new TreeSet(zab.zaa);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((OptionalModuleApi) it.next()).getOptionalFeatures());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z, null, null);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.zac == apiFeatureRequest.zac && zzah.equal(this.zab, apiFeatureRequest.zab) && zzah.equal(this.zad, apiFeatureRequest.zad) && zzah.equal(this.zae, apiFeatureRequest.zae);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zac), this.zab, this.zad, this.zae});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.writeTypedList(1, parcel, this.zab);
        zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(this.zac ? 1 : 0);
        zzkp.writeString(parcel, 3, this.zad);
        zzkp.writeString(parcel, 4, this.zae);
        zzkp.zzb(parcel, iZza);
    }
}
