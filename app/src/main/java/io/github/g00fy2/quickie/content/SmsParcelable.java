package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SmsParcelable implements Parcelable {
    public static final Parcelable.Creator<SmsParcelable> CREATOR = new zzb(18);
    public final String message;
    public final String phoneNumber;

    public SmsParcelable(String str, String str2) {
        this.message = str;
        this.phoneNumber = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.message);
        parcel.writeString(this.phoneNumber);
    }
}
