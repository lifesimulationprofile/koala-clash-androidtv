package com.github.kr328.clash.common.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ParcelableKt {
    public static final ArrayList createListFromParcelSlice(int i, Parcel parcel, Parcelable.Creator creator) {
        int i2 = parcel.readInt();
        IBinder strongBinder = parcel.readStrongBinder();
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        while (i3 < i2) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i3);
                parcelObtain.writeInt(i);
                if (strongBinder.transact(10, parcelObtain, parcelObtain2, 0)) {
                    int i4 = parcelObtain2.readInt();
                    for (int i5 = 0; i5 < i4; i5++) {
                        arrayList.add(creator.createFromParcel(parcelObtain2));
                    }
                    i3 += i4;
                    if (i4 != 0) {
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    }
                }
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return arrayList;
            } catch (Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th;
            }
        }
        return arrayList;
    }

    public static final void writeToParcelSlice(int i, Parcel parcel, List list) {
        SliceParcelableListBpBinder sliceParcelableListBpBinder = new SliceParcelableListBpBinder(i, list);
        parcel.writeInt(list.size());
        parcel.writeStrongBinder(sliceParcelableListBpBinder);
    }
}
