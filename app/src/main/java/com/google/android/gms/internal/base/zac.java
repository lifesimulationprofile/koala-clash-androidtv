package com.google.android.gms.internal.base;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zac {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        zac.class.getClassLoader();
    }

    public static Parcelable zaa(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zab(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(ImageAnalysis$$ExternalSyntheticLambda1.m("Parcel data not fully consumed, unread size: ", iDataAvail));
        }
    }

    public static void zac(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
