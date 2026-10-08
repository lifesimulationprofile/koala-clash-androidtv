package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new zzb(6);
    public final Month end;
    public final int monthSpan;
    public final Month openAt;
    public final Month start;
    public final DateValidatorPointForward validator;
    public final int yearSpan;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder {
        public static final /* synthetic */ int $r8$clinit = 0;
        public Long openAt;

        static {
            long j = Month.create(1900, 0).timeInMillis;
            Calendar utcCalendarOf = UtcDates.getUtcCalendarOf(null);
            utcCalendarOf.setTimeInMillis(j);
            UtcDates.getDayCopy(utcCalendarOf).getTimeInMillis();
            long j2 = Month.create(2100, 11).timeInMillis;
            Calendar utcCalendarOf2 = UtcDates.getUtcCalendarOf(null);
            utcCalendarOf2.setTimeInMillis(j2);
            UtcDates.getDayCopy(utcCalendarOf2).getTimeInMillis();
        }
    }

    public CalendarConstraints(Month month, Month month2, DateValidatorPointForward dateValidatorPointForward, Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidatorPointForward;
        if (month3 != null && month.firstOfMonth.compareTo(month3.firstOfMonth) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.monthSpan = month.monthsUntil(month2) + 1;
        this.yearSpan = (month2.year - month.year) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && Objects.equals(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }
}
