package com.github.kr328.clash.common.util;

import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SliceParcelableListBpBinder extends Binder {
    public final int flags;
    public final Object list;

    public SliceParcelableListBpBinder(int i, List list) {
        this.list = list;
        this.flags = i;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, java.util.List] */
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = this.flags;
        if (i != 10) {
            return super.onTransact(i, parcel, parcel2, i3);
        }
        if (parcel2 == null) {
            return false;
        }
        int i4 = parcel.readInt();
        int i5 = parcel.readInt() + i4;
        ?? r6 = this.list;
        int size = r6.size();
        if (i5 > size) {
            i5 = size;
        }
        parcel2.writeInt(i5 - i4);
        while (i4 < i5) {
            ((Parcelable) r6.get(i4)).writeToParcel(parcel2, i3);
            i4++;
        }
        return true;
    }
}
