package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.internal.mlkit_vision_common.zzko;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.Month;
import io.github.g00fy2.quickie.config.ParcelableScannerConfig;
import io.github.g00fy2.quickie.content.AddressParcelable;
import io.github.g00fy2.quickie.content.CalendarDateTimeParcelable;
import io.github.g00fy2.quickie.content.CalendarEventParcelable;
import io.github.g00fy2.quickie.content.ContactInfoParcelable;
import io.github.g00fy2.quickie.content.EmailParcelable;
import io.github.g00fy2.quickie.content.GeoPointParcelable;
import io.github.g00fy2.quickie.content.PersonNameParcelable;
import io.github.g00fy2.quickie.content.PhoneParcelable;
import io.github.g00fy2.quickie.content.SmsParcelable;
import io.github.g00fy2.quickie.content.UrlBookmarkParcelable;
import io.github.g00fy2.quickie.content.WifiParcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzb(int i) {
        this.$r8$classId = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = zzko.validateObjectHeader(parcel);
                PendingIntent pendingIntent = null;
                int i = 0;
                int i2 = 0;
                String strCreateString = null;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i3 = parcel.readInt();
                    char c = (char) i3;
                    if (c == 1) {
                        i = zzko.readInt(parcel, i3);
                    } else if (c == 2) {
                        i2 = zzko.readInt(parcel, i3);
                    } else if (c == 3) {
                        pendingIntent = (PendingIntent) zzko.createParcelable(i3, parcel, PendingIntent.CREATOR);
                    } else if (c != 4) {
                        zzko.skipUnknownField(parcel, i3);
                    } else {
                        strCreateString = zzko.createString(parcel, i3);
                    }
                }
                zzko.ensureAtEnd(parcel, iValidateObjectHeader);
                return new ConnectionResult(i, i2, pendingIntent, strCreateString);
            case 1:
                int iValidateObjectHeader2 = zzko.validateObjectHeader(parcel);
                long j = -1;
                int i4 = 0;
                String strCreateString2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i5 = parcel.readInt();
                    char c2 = (char) i5;
                    if (c2 == 1) {
                        strCreateString2 = zzko.createString(parcel, i5);
                    } else if (c2 == 2) {
                        i4 = zzko.readInt(parcel, i5);
                    } else if (c2 != 3) {
                        zzko.skipUnknownField(parcel, i5);
                    } else {
                        j = zzko.readLong(parcel, i5);
                    }
                }
                zzko.ensureAtEnd(parcel, iValidateObjectHeader2);
                return new Feature(i4, j, strCreateString2);
            case 2:
                int iValidateObjectHeader3 = zzko.validateObjectHeader(parcel);
                Intent intent = null;
                int i6 = 0;
                int i7 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i8 = parcel.readInt();
                    char c3 = (char) i8;
                    if (c3 == 1) {
                        i6 = zzko.readInt(parcel, i8);
                    } else if (c3 == 2) {
                        i7 = zzko.readInt(parcel, i8);
                    } else if (c3 != 3) {
                        zzko.skipUnknownField(parcel, i8);
                    } else {
                        intent = (Intent) zzko.createParcelable(i8, parcel, Intent.CREATOR);
                    }
                }
                zzko.ensureAtEnd(parcel, iValidateObjectHeader3);
                return new zaa(i6, i7, intent);
            case 3:
                int iValidateObjectHeader4 = zzko.validateObjectHeader(parcel);
                ArrayList<String> arrayList = null;
                String strCreateString3 = null;
                while (parcel.dataPosition() < iValidateObjectHeader4) {
                    int i9 = parcel.readInt();
                    char c4 = (char) i9;
                    if (c4 == 1) {
                        int size = zzko.readSize(parcel, i9);
                        int iDataPosition = parcel.dataPosition();
                        if (size == 0) {
                            arrayList = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(iDataPosition + size);
                            arrayList = arrayListCreateStringArrayList;
                        }
                    } else if (c4 != 2) {
                        zzko.skipUnknownField(parcel, i9);
                    } else {
                        strCreateString3 = zzko.createString(parcel, i9);
                    }
                }
                zzko.ensureAtEnd(parcel, iValidateObjectHeader4);
                return new zag(arrayList, strCreateString3);
            case 4:
                int iValidateObjectHeader5 = zzko.validateObjectHeader(parcel);
                zat zatVar = null;
                int i10 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader5) {
                    int i11 = parcel.readInt();
                    char c5 = (char) i11;
                    if (c5 == 1) {
                        i10 = zzko.readInt(parcel, i11);
                    } else if (c5 != 2) {
                        zzko.skipUnknownField(parcel, i11);
                    } else {
                        zatVar = (zat) zzko.createParcelable(i11, parcel, zat.CREATOR);
                    }
                }
                zzko.ensureAtEnd(parcel, iValidateObjectHeader5);
                return new zai(i10, zatVar);
            case 5:
                int iValidateObjectHeader6 = zzko.validateObjectHeader(parcel);
                ConnectionResult connectionResult = null;
                int i12 = 0;
                zav zavVar = null;
                while (parcel.dataPosition() < iValidateObjectHeader6) {
                    int i13 = parcel.readInt();
                    char c6 = (char) i13;
                    if (c6 == 1) {
                        i12 = zzko.readInt(parcel, i13);
                    } else if (c6 == 2) {
                        connectionResult = (ConnectionResult) zzko.createParcelable(i13, parcel, ConnectionResult.CREATOR);
                    } else if (c6 != 3) {
                        zzko.skipUnknownField(parcel, i13);
                    } else {
                        zavVar = (zav) zzko.createParcelable(i13, parcel, zav.CREATOR);
                    }
                }
                zzko.ensureAtEnd(parcel, iValidateObjectHeader6);
                return new zak(i12, connectionResult, zavVar);
            case 6:
                return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidatorPointForward) parcel.readParcelable(DateValidatorPointForward.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
            case 7:
                return new DateValidatorPointForward(parcel.readLong());
            case 8:
                return Month.create(parcel.readInt(), parcel.readInt());
            case 9:
                int[] iArrCreateIntArray = parcel.createIntArray();
                int i14 = parcel.readInt();
                Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                boolean z = true;
                if (parcel.readInt() == 0) {
                    z = false;
                }
                return new ParcelableScannerConfig(iArrCreateIntArray, i14, numValueOf, z, parcel.readInt() != 0, parcel.readFloat(), parcel.readInt() != 0 ? z : false, parcel.readInt() != 0 ? z : false, parcel.readInt() != 0 ? z : false);
            case 10:
                return new AddressParcelable(parcel.readInt(), parcel.createStringArrayList());
            case 11:
                return new CalendarDateTimeParcelable(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
            case 12:
                String string = parcel.readString();
                Parcelable.Creator<CalendarDateTimeParcelable> creator = CalendarDateTimeParcelable.CREATOR;
                return new CalendarEventParcelable(string, creator.createFromParcel(parcel), parcel.readString(), parcel.readString(), creator.createFromParcel(parcel), parcel.readString(), parcel.readString());
            case 13:
                int i15 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i15);
                for (int i16 = 0; i16 != i15; i16++) {
                    arrayList2.add(AddressParcelable.CREATOR.createFromParcel(parcel));
                }
                int i17 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i17);
                for (int i18 = 0; i18 != i17; i18++) {
                    arrayList3.add(EmailParcelable.CREATOR.createFromParcel(parcel));
                }
                PersonNameParcelable personNameParcelableCreateFromParcel = PersonNameParcelable.CREATOR.createFromParcel(parcel);
                String string2 = parcel.readString();
                int i19 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(i19);
                for (int i20 = 0; i20 != i19; i20++) {
                    arrayList4.add(PhoneParcelable.CREATOR.createFromParcel(parcel));
                }
                return new ContactInfoParcelable(arrayList2, arrayList3, personNameParcelableCreateFromParcel, string2, arrayList4, parcel.readString(), parcel.createStringArrayList());
            case 14:
                return new EmailParcelable(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
            case 15:
                return new GeoPointParcelable(parcel.readDouble(), parcel.readDouble());
            case 16:
                return new PersonNameParcelable(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            case 17:
                return new PhoneParcelable(parcel.readString(), parcel.readInt());
            case 18:
                return new SmsParcelable(parcel.readString(), parcel.readString());
            case 19:
                return new UrlBookmarkParcelable(parcel.readString(), parcel.readString());
            default:
                return new WifiParcelable(parcel.readInt(), parcel.readString(), parcel.readString());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new ConnectionResult[i];
            case 1:
                return new Feature[i];
            case 2:
                return new zaa[i];
            case 3:
                return new zag[i];
            case 4:
                return new zai[i];
            case 5:
                return new zak[i];
            case 6:
                return new CalendarConstraints[i];
            case 7:
                return new DateValidatorPointForward[i];
            case 8:
                return new Month[i];
            case 9:
                return new ParcelableScannerConfig[i];
            case 10:
                return new AddressParcelable[i];
            case 11:
                return new CalendarDateTimeParcelable[i];
            case 12:
                return new CalendarEventParcelable[i];
            case 13:
                return new ContactInfoParcelable[i];
            case 14:
                return new EmailParcelable[i];
            case 15:
                return new GeoPointParcelable[i];
            case 16:
                return new PersonNameParcelable[i];
            case 17:
                return new PhoneParcelable[i];
            case 18:
                return new SmsParcelable[i];
            case 19:
                return new UrlBookmarkParcelable[i];
            default:
                return new WifiParcelable[i];
        }
    }
}
