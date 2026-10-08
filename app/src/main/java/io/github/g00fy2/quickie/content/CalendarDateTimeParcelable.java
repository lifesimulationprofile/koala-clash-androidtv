package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CalendarDateTimeParcelable implements Parcelable {
    public static final Parcelable.Creator<CalendarDateTimeParcelable> CREATOR = new zzb(11);
    public final int day;
    public final int hours;
    public final int minutes;
    public final int month;
    public final int seconds;
    public final boolean utc;
    public final int year;

    public CalendarDateTimeParcelable(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        this.day = i;
        this.hours = i2;
        this.minutes = i3;
        this.month = i4;
        this.seconds = i5;
        this.year = i6;
        this.utc = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.day);
        parcel.writeInt(this.hours);
        parcel.writeInt(this.minutes);
        parcel.writeInt(this.month);
        parcel.writeInt(this.seconds);
        parcel.writeInt(this.year);
        parcel.writeInt(this.utc ? 1 : 0);
    }
}
