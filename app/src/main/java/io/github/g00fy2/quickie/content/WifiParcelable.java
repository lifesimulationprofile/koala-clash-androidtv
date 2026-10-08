package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class WifiParcelable implements Parcelable {
    public static final Parcelable.Creator<WifiParcelable> CREATOR = new zzb(20);
    public final int encryptionType;
    public final String password;
    public final String ssid;

    public WifiParcelable(int i, String str, String str2) {
        this.encryptionType = i;
        this.password = str;
        this.ssid = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.encryptionType);
        parcel.writeString(this.password);
        parcel.writeString(this.ssid);
    }
}
