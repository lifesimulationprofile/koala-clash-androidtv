package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PersonNameParcelable implements Parcelable {
    public static final Parcelable.Creator<PersonNameParcelable> CREATOR = new zzb(16);
    public final String first;
    public final String formattedName;
    public final String last;
    public final String middle;
    public final String prefix;
    public final String pronunciation;
    public final String suffix;

    public PersonNameParcelable(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.first = str;
        this.formattedName = str2;
        this.last = str3;
        this.middle = str4;
        this.prefix = str5;
        this.pronunciation = str6;
        this.suffix = str7;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.first);
        parcel.writeString(this.formattedName);
        parcel.writeString(this.last);
        parcel.writeString(this.middle);
        parcel.writeString(this.prefix);
        parcel.writeString(this.pronunciation);
        parcel.writeString(this.suffix);
    }
}
