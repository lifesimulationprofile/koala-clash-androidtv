package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EmailParcelable implements Parcelable {
    public static final Parcelable.Creator<EmailParcelable> CREATOR = new zzb(14);
    public final String address;
    public final String body;
    public final String subject;
    public final int type;

    public EmailParcelable(int i, String str, String str2, String str3) {
        this.address = str;
        this.body = str2;
        this.subject = str3;
        this.type = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.address);
        parcel.writeString(this.body);
        parcel.writeString(this.subject);
        parcel.writeInt(this.type);
    }
}
