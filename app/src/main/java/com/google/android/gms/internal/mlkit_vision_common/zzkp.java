package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkp {
    public static void writeByteArray(Parcel parcel, int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeByteArray(bArr);
        zzb(parcel, iZza);
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        zzb(parcel, iZza);
    }

    public static void writeString(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeString(str);
        zzb(parcel, iZza);
    }

    public static void writeStringArray(Parcel parcel, int i, String[] strArr) {
        if (strArr == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeStringArray(strArr);
        zzb(parcel, iZza);
    }

    public static void writeTypedArray(Parcel parcel, int i, Parcelable[] parcelableArr, int i2) {
        if (parcelableArr == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i2);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        zzb(parcel, iZza);
    }

    public static void writeTypedList(int i, Parcel parcel, List list) {
        if (list == null) {
            return;
        }
        int iZza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        zzb(parcel, iZza);
    }

    public static int zza(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void zzb(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }
}
