package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UiConfiguration implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return (UiConfiguration) serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new UiConfiguration[i];
        }

        public final KSerializer serializer() {
            return UiConfiguration$$serializer.INSTANCE;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        CREATOR.serializer().serialize(new Parcelizer$ParcelDecoder(parcel, 1), this);
    }
}
