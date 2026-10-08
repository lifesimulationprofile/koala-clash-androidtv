package io.github.g00fy2.quickie.content;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda1;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda3;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.activity.compose.PredictiveBackHandlerInfo;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.enums.EnumEntriesList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class QRContent {
    public static volatile HandlerScheduledExecutorService sInstance;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CalendarEvent extends QRContent {
        public final String description;
        public final CalendarDateTime end;
        public final String location;
        public final String organizer;
        public final byte[] rawBytes;
        public final String rawValue;
        public final CalendarDateTime start;
        public final String status;
        public final String summary;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class CalendarDateTime {
            public final int day;
            public final int hours;
            public final int minutes;
            public final int month;
            public final int seconds;
            public final boolean utc;
            public final int year;

            public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
                this.day = i;
                this.hours = i2;
                this.minutes = i3;
                this.month = i4;
                this.seconds = i5;
                this.year = i6;
                this.utc = z;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CalendarDateTime)) {
                    return false;
                }
                CalendarDateTime calendarDateTime = (CalendarDateTime) obj;
                return this.day == calendarDateTime.day && this.hours == calendarDateTime.hours && this.minutes == calendarDateTime.minutes && this.month == calendarDateTime.month && this.seconds == calendarDateTime.seconds && this.year == calendarDateTime.year && this.utc == calendarDateTime.utc;
            }

            public final int hashCode() {
                return (((((((((((this.day * 31) + this.hours) * 31) + this.minutes) * 31) + this.month) * 31) + this.seconds) * 31) + this.year) * 31) + (this.utc ? 1231 : 1237);
            }

            public final String toString() {
                return "CalendarDateTime(day=" + this.day + ", hours=" + this.hours + ", minutes=" + this.minutes + ", month=" + this.month + ", seconds=" + this.seconds + ", year=" + this.year + ", utc=" + this.utc + ")";
            }
        }

        public CalendarEvent(byte[] bArr, String str, String str2, CalendarDateTime calendarDateTime, String str3, String str4, CalendarDateTime calendarDateTime2, String str5, String str6) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.description = str2;
            this.end = calendarDateTime;
            this.location = str3;
            this.organizer = str4;
            this.start = calendarDateTime2;
            this.status = str5;
            this.summary = str6;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalendarEvent)) {
                return false;
            }
            CalendarEvent calendarEvent = (CalendarEvent) obj;
            return Intrinsics.areEqual(this.rawBytes, calendarEvent.rawBytes) && Intrinsics.areEqual(this.rawValue, calendarEvent.rawValue) && Intrinsics.areEqual(this.description, calendarEvent.description) && Intrinsics.areEqual(this.end, calendarEvent.end) && Intrinsics.areEqual(this.location, calendarEvent.location) && Intrinsics.areEqual(this.organizer, calendarEvent.organizer) && Intrinsics.areEqual(this.start, calendarEvent.start) && Intrinsics.areEqual(this.status, calendarEvent.status) && Intrinsics.areEqual(this.summary, calendarEvent.summary);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.summary.hashCode() + Modifier.CC.m((this.start.hashCode() + Modifier.CC.m(Modifier.CC.m((this.end.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.description)) * 31, 31, this.location), 31, this.organizer)) * 31, 31, this.status);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("CalendarEvent(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", description=");
            sbM.append(this.description);
            sbM.append(", end=");
            sbM.append(this.end);
            sbM.append(", location=");
            Density.CC.m(sbM, this.location, ", organizer=", this.organizer, ", start=");
            sbM.append(this.start);
            sbM.append(", status=");
            sbM.append(this.status);
            sbM.append(", summary=");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.summary, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ContactInfo extends QRContent {
        public final ArrayList addresses;
        public final ArrayList emails;
        public final PersonName name;
        public final String organization;
        public final ArrayList phones;
        public final byte[] rawBytes;
        public final String rawValue;
        public final String title;
        public final List urls;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Address {
            public final List addressLines;
            public final AddressType type;

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
            public final class AddressType {
                public static final /* synthetic */ EnumEntriesList $ENTRIES;
                public static final /* synthetic */ AddressType[] $VALUES;
                public static final AddressType UNKNOWN;

                static {
                    AddressType addressType = new AddressType("UNKNOWN", 0);
                    UNKNOWN = addressType;
                    AddressType[] addressTypeArr = {addressType, new AddressType("WORK", 1), new AddressType("HOME", 2)};
                    $VALUES = addressTypeArr;
                    $ENTRIES = new EnumEntriesList(addressTypeArr);
                }

                public static AddressType valueOf(String str) {
                    return (AddressType) Enum.valueOf(AddressType.class, str);
                }

                public static AddressType[] values() {
                    return (AddressType[]) $VALUES.clone();
                }
            }

            public Address(List list, AddressType addressType) {
                this.addressLines = list;
                this.type = addressType;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Address)) {
                    return false;
                }
                Address address = (Address) obj;
                return Intrinsics.areEqual(this.addressLines, address.addressLines) && this.type == address.type;
            }

            public final int hashCode() {
                return this.type.hashCode() + (this.addressLines.hashCode() * 31);
            }

            public final String toString() {
                return "Address(addressLines=" + this.addressLines + ", type=" + this.type + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class PersonName {
            public final String first;
            public final String formattedName;
            public final String last;
            public final String middle;
            public final String prefix;
            public final String pronunciation;
            public final String suffix;

            public PersonName(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                this.first = str;
                this.formattedName = str2;
                this.last = str3;
                this.middle = str4;
                this.prefix = str5;
                this.pronunciation = str6;
                this.suffix = str7;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PersonName)) {
                    return false;
                }
                PersonName personName = (PersonName) obj;
                return Intrinsics.areEqual(this.first, personName.first) && Intrinsics.areEqual(this.formattedName, personName.formattedName) && Intrinsics.areEqual(this.last, personName.last) && Intrinsics.areEqual(this.middle, personName.middle) && Intrinsics.areEqual(this.prefix, personName.prefix) && Intrinsics.areEqual(this.pronunciation, personName.pronunciation) && Intrinsics.areEqual(this.suffix, personName.suffix);
            }

            public final int hashCode() {
                return this.suffix.hashCode() + Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(this.first.hashCode() * 31, 31, this.formattedName), 31, this.last), 31, this.middle), 31, this.prefix), 31, this.pronunciation);
            }

            public final String toString() {
                StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("PersonName(first=", this.first, ", formattedName=", this.formattedName, ", last=");
                Density.CC.m(sbM, this.last, ", middle=", this.middle, ", prefix=");
                Density.CC.m(sbM, this.prefix, ", pronunciation=", this.pronunciation, ", suffix=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.suffix, ")");
            }
        }

        public ContactInfo(byte[] bArr, String str, ArrayList arrayList, ArrayList arrayList2, PersonName personName, String str2, ArrayList arrayList3, String str3, List list) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.addresses = arrayList;
            this.emails = arrayList2;
            this.name = personName;
            this.organization = str2;
            this.phones = arrayList3;
            this.title = str3;
            this.urls = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ContactInfo)) {
                return false;
            }
            ContactInfo contactInfo = (ContactInfo) obj;
            return Intrinsics.areEqual(this.rawBytes, contactInfo.rawBytes) && Intrinsics.areEqual(this.rawValue, contactInfo.rawValue) && this.addresses.equals(contactInfo.addresses) && this.emails.equals(contactInfo.emails) && this.name.equals(contactInfo.name) && Intrinsics.areEqual(this.organization, contactInfo.organization) && this.phones.equals(contactInfo.phones) && Intrinsics.areEqual(this.title, contactInfo.title) && Intrinsics.areEqual(this.urls, contactInfo.urls);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.urls.hashCode() + Modifier.CC.m((this.phones.hashCode() + Modifier.CC.m((this.name.hashCode() + ((this.emails.hashCode() + ((this.addresses.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31)) * 31, 31, this.organization)) * 31, 31, this.title);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("ContactInfo(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", addresses=");
            sbM.append(this.addresses);
            sbM.append(", emails=");
            sbM.append(this.emails);
            sbM.append(", name=");
            sbM.append(this.name);
            sbM.append(", organization=");
            sbM.append(this.organization);
            sbM.append(", phones=");
            sbM.append(this.phones);
            sbM.append(", title=");
            sbM.append(this.title);
            sbM.append(", urls=");
            sbM.append(this.urls);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Email extends QRContent {
        public final String address;
        public final String body;
        public final byte[] rawBytes;
        public final String rawValue;
        public final String subject;
        public final EmailType type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class EmailType {
            public static final /* synthetic */ EnumEntriesList $ENTRIES;
            public static final /* synthetic */ EmailType[] $VALUES;
            public static final EmailType UNKNOWN;

            static {
                EmailType emailType = new EmailType("UNKNOWN", 0);
                UNKNOWN = emailType;
                EmailType[] emailTypeArr = {emailType, new EmailType("WORK", 1), new EmailType("HOME", 2)};
                $VALUES = emailTypeArr;
                $ENTRIES = new EnumEntriesList(emailTypeArr);
            }

            public static EmailType valueOf(String str) {
                return (EmailType) Enum.valueOf(EmailType.class, str);
            }

            public static EmailType[] values() {
                return (EmailType[]) $VALUES.clone();
            }
        }

        public Email(byte[] bArr, String str, String str2, String str3, String str4, EmailType emailType) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.address = str2;
            this.body = str3;
            this.subject = str4;
            this.type = emailType;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Email)) {
                return false;
            }
            Email email = (Email) obj;
            return Intrinsics.areEqual(this.rawBytes, email.rawBytes) && Intrinsics.areEqual(this.rawValue, email.rawValue) && Intrinsics.areEqual(this.address, email.address) && Intrinsics.areEqual(this.body, email.body) && Intrinsics.areEqual(this.subject, email.subject) && this.type == email.type;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.type.hashCode() + Modifier.CC.m(Modifier.CC.m(Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.address), 31, this.body), 31, this.subject);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Email(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", address=");
            Density.CC.m(sbM, this.address, ", body=", this.body, ", subject=");
            sbM.append(this.subject);
            sbM.append(", type=");
            sbM.append(this.type);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class GeoPoint extends QRContent {
        public final double lat;
        public final double lng;
        public final byte[] rawBytes;
        public final String rawValue;

        public GeoPoint(byte[] bArr, String str, double d, double d2) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.lat = d;
            this.lng = d2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GeoPoint)) {
                return false;
            }
            GeoPoint geoPoint = (GeoPoint) obj;
            return Intrinsics.areEqual(this.rawBytes, geoPoint.rawBytes) && Intrinsics.areEqual(this.rawValue, geoPoint.rawValue) && Double.compare(this.lat, geoPoint.lat) == 0 && Double.compare(this.lng, geoPoint.lng) == 0;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            int iHashCode2 = str != null ? str.hashCode() : 0;
            long jDoubleToLongBits = Double.doubleToLongBits(this.lat);
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31;
            long jDoubleToLongBits2 = Double.doubleToLongBits(this.lng);
            return i + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("GeoPoint(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", lat=");
            sbM.append(this.lat);
            sbM.append(", lng=");
            sbM.append(this.lng);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Phone extends QRContent {
        public final String number;
        public final byte[] rawBytes;
        public final String rawValue;
        public final PhoneType type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class PhoneType {
            public static final /* synthetic */ EnumEntriesList $ENTRIES;
            public static final /* synthetic */ PhoneType[] $VALUES;
            public static final PhoneType UNKNOWN;

            static {
                PhoneType phoneType = new PhoneType("UNKNOWN", 0);
                UNKNOWN = phoneType;
                PhoneType[] phoneTypeArr = {phoneType, new PhoneType("WORK", 1), new PhoneType("HOME", 2), new PhoneType("FAX", 3), new PhoneType("MOBILE", 4)};
                $VALUES = phoneTypeArr;
                $ENTRIES = new EnumEntriesList(phoneTypeArr);
            }

            public static PhoneType valueOf(String str) {
                return (PhoneType) Enum.valueOf(PhoneType.class, str);
            }

            public static PhoneType[] values() {
                return (PhoneType[]) $VALUES.clone();
            }
        }

        public Phone(byte[] bArr, String str, String str2, PhoneType phoneType) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.number = str2;
            this.type = phoneType;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Phone)) {
                return false;
            }
            Phone phone = (Phone) obj;
            return Intrinsics.areEqual(this.rawBytes, phone.rawBytes) && Intrinsics.areEqual(this.rawValue, phone.rawValue) && Intrinsics.areEqual(this.number, phone.number) && this.type == phone.type;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.type.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.number);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Phone(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", number=");
            sbM.append(this.number);
            sbM.append(", type=");
            sbM.append(this.type);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Plain extends QRContent {
        public final byte[] rawBytes;
        public final String rawValue;

        public Plain(byte[] bArr, String str) {
            this.rawBytes = bArr;
            this.rawValue = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Plain)) {
                return false;
            }
            Plain plain = (Plain) obj;
            return Intrinsics.areEqual(this.rawBytes, plain.rawBytes) && Intrinsics.areEqual(this.rawValue, plain.rawValue);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            return "Plain(rawBytes=" + Arrays.toString(this.rawBytes) + ", rawValue=" + this.rawValue + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Sms extends QRContent {
        public final String message;
        public final String phoneNumber;
        public final byte[] rawBytes;
        public final String rawValue;

        public Sms(byte[] bArr, String str, String str2, String str3) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.message = str2;
            this.phoneNumber = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Sms)) {
                return false;
            }
            Sms sms = (Sms) obj;
            return Intrinsics.areEqual(this.rawBytes, sms.rawBytes) && Intrinsics.areEqual(this.rawValue, sms.rawValue) && Intrinsics.areEqual(this.message, sms.message) && Intrinsics.areEqual(this.phoneNumber, sms.phoneNumber);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.phoneNumber.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.message);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Sms(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", message=");
            sbM.append(this.message);
            sbM.append(", phoneNumber=");
            sbM.append(this.phoneNumber);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Url extends QRContent {
        public final byte[] rawBytes;
        public final String rawValue;
        public final String title;
        public final String url;

        public Url(byte[] bArr, String str, String str2, String str3) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.title = str2;
            this.url = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Url)) {
                return false;
            }
            Url url = (Url) obj;
            return Intrinsics.areEqual(this.rawBytes, url.rawBytes) && Intrinsics.areEqual(this.rawValue, url.rawValue) && Intrinsics.areEqual(this.title, url.title) && Intrinsics.areEqual(this.url, url.url);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.url.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.title);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Url(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", title=");
            sbM.append(this.title);
            sbM.append(", url=");
            sbM.append(this.url);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Wifi extends QRContent {
        public final int encryptionType;
        public final String password;
        public final byte[] rawBytes;
        public final String rawValue;
        public final String ssid;

        public Wifi(byte[] bArr, String str, int i, String str2, String str3) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.encryptionType = i;
            this.password = str2;
            this.ssid = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wifi)) {
                return false;
            }
            Wifi wifi = (Wifi) obj;
            return Intrinsics.areEqual(this.rawBytes, wifi.rawBytes) && Intrinsics.areEqual(this.rawValue, wifi.rawValue) && this.encryptionType == wifi.encryptionType && Intrinsics.areEqual(this.password, wifi.password) && Intrinsics.areEqual(this.ssid, wifi.ssid);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.ssid.hashCode() + Modifier.CC.m((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.encryptionType) * 31, 31, this.password);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Wifi(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", encryptionType=");
            sbM.append(this.encryptionType);
            sbM.append(", password=");
            sbM.append(this.password);
            sbM.append(", ssid=");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.ssid, ")");
        }
    }

    public static final void PredictiveBackHandler(boolean z, Function2 function2, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-642000585);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            NavigationEventDispatcherOwner current = LocalNavigationEventDispatcherOwner.getCurrent(gapComposer);
            OnBackPressedDispatcherOwner current2 = LocalOnBackPressedDispatcherOwner.getCurrent(gapComposer);
            Object obj = current == null ? current2 : current;
            if (obj == null) {
                throw new IllegalArgumentException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.");
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj2 = Composer$Companion.Empty;
            if (objRememberedValue == obj2) {
                objRememberedValue = new BackHandlerDispatcherCompat(current != null ? current.getNavigationEventDispatcher() : null, current2 != null ? current2.getOnBackPressedDispatcher() : null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Object obj3 = (BackHandlerDispatcherCompat) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj2) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            long j = gapComposer.compositeKeyHashCode;
            boolean zChanged = gapComposer.changed(obj3) | gapComposer.changed(j);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == obj2) {
                objRememberedValue3 = new ComposePredictiveBackHandler(coroutineScope, new PredictiveBackHandlerInfo(j, obj));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) objRememberedValue3;
            gapComposer.startReplaceGroup(-348495408);
            boolean zChangedInstance = gapComposer.changedInstance(composePredictiveBackHandler) | gapComposer.changedInstance(function2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == obj2) {
                objRememberedValue4 = new Recomposer$$ExternalSyntheticLambda6(2, composePredictiveBackHandler, function2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
            int i3 = i2;
            Boolean boolValueOf = Boolean.valueOf(z);
            int i4 = i3 & 14;
            boolean zChangedInstance2 = gapComposer.changedInstance(composePredictiveBackHandler) | (i4 == 4);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == obj2) {
                objRememberedValue5 = new BackHandlerKt$$ExternalSyntheticLambda1(composePredictiveBackHandler, z, 1);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            LifecycleEffectKt.LifecycleStartEffect(boolValueOf, composePredictiveBackHandler, null, (Function1) objRememberedValue5, gapComposer, i4);
            boolean zChangedInstance3 = gapComposer.changedInstance(obj3) | gapComposer.changedInstance(composePredictiveBackHandler);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == obj2) {
                objRememberedValue6 = new BackHandlerKt$$ExternalSyntheticLambda2(1, obj3, composePredictiveBackHandler);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Stack.DisposableEffect(obj3, composePredictiveBackHandler, (Function1) objRememberedValue6, gapComposer);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BackHandlerKt$$ExternalSyntheticLambda3(i, 1, function2, z);
        }
    }

    public abstract byte[] getRawBytes();

    public abstract String getRawValue();
}
