package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_common.zzko;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = zzko.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        String strCreateString = null;
        boolean z = false;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListCreateTypedList = zzko.createTypedList(i, parcel, Feature.CREATOR);
            } else if (c == 2) {
                z = zzko.readBoolean(parcel, i);
            } else if (c == 3) {
                strCreateString2 = zzko.createString(parcel, i);
            } else if (c != 4) {
                zzko.skipUnknownField(parcel, i);
            } else {
                strCreateString = zzko.createString(parcel, i);
            }
        }
        zzko.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ApiFeatureRequest(arrayListCreateTypedList, z, strCreateString2, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ApiFeatureRequest[i];
    }
}
