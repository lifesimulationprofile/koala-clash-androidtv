package io.github.g00fy2.quickie;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.content.IntentCompat;
import io.github.g00fy2.quickie.content.AddressParcelable;
import io.github.g00fy2.quickie.content.CalendarDateTimeParcelable;
import io.github.g00fy2.quickie.content.CalendarEventParcelable;
import io.github.g00fy2.quickie.content.ContactInfoParcelable;
import io.github.g00fy2.quickie.content.EmailParcelable;
import io.github.g00fy2.quickie.content.GeoPointParcelable;
import io.github.g00fy2.quickie.content.PersonNameParcelable;
import io.github.g00fy2.quickie.content.PhoneParcelable;
import io.github.g00fy2.quickie.content.QRContent;
import io.github.g00fy2.quickie.content.SmsParcelable;
import io.github.g00fy2.quickie.content.UrlBookmarkParcelable;
import io.github.g00fy2.quickie.content.WifiParcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.enums.EnumEntriesList;
import kotlin.internal.PlatformImplementations$ReflectThrowable;
import kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScanQRCode {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ScanQRCode(int i) {
        this.$r8$classId = i;
    }

    public static void addSuppressed(Throwable th, Throwable th2) {
        if (th != th2) {
            Integer num = JDK7PlatformImplementations$ReflectSdkVersion.sdkVersion;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = PlatformImplementations$ReflectThrowable.addSuppressed;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
    
        if (migrationFromLegacy1(r9, r10, r1) == r0) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object migrationFromLegacy(android.content.Context r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.g00fy2.quickie.ScanQRCode.migrationFromLegacy(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00c1 A[Catch: all -> 0x00d0, TRY_ENTER, TryCatch #0 {all -> 0x00d0, blocks: (B:59:0x019e, B:32:0x00af, B:40:0x00ca, B:45:0x00d8, B:36:0x00c1, B:61:0x01a4), top: B:68:0x019e }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a4 A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:59:0x019e, B:32:0x00af, B:40:0x00ca, B:45:0x00d8, B:36:0x00c1, B:61:0x01a4), top: B:68:0x019e }] */
    /* JADX WARN: Code duplicated, block: B:68:0x019e A[EXC_TOP_SPLITTER, PHI: r0 r2 r3 r4 r7 r10 r11 r14
      0x019e: PHI (r0v16 android.content.Context) = (r0v14 android.content.Context), (r0v24 android.content.Context) binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019e: PHI (r2v7 int) = (r2v5 int), (r2v9 int) binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019e: PHI (r3v7 com.github.kr328.clash.service.data.migrations.LegacyMigrationKt$migrationFromLegacy1$1) = 
      (r3v5 com.github.kr328.clash.service.data.migrations.LegacyMigrationKt$migrationFromLegacy1$1)
      (r3v9 com.github.kr328.clash.service.data.migrations.LegacyMigrationKt$migrationFromLegacy1$1)
     binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019e: PHI (r4v6 boolean) = (r4v5 boolean), (r4v7 boolean) binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019e: PHI (r7v9 int) = (r7v8 int), (r7v11 int) binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019e: PHI (r10v6 int) = (r10v4 int), (r10v8 int) binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019e: PHI (r11v5 java.io.Closeable) = (r11v3 java.io.Closeable), (r11v7 java.io.Closeable) binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019e: PHI (r14v6 android.database.Cursor) = (r14v4 android.database.Cursor), (r14v9 android.database.Cursor) binds: [B:37:0x00c5, B:58:0x0197] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c5 -> B:68:0x019e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0179 -> B:57:0x017c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object migrationFromLegacy1(android.content.Context r28, android.database.sqlite.SQLiteDatabase r29, kotlin.coroutines.jvm.internal.ContinuationImpl r30) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.g00fy2.quickie.ScanQRCode.migrationFromLegacy1(android.content.Context, android.database.sqlite.SQLiteDatabase, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:103:0x027c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x0101 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:76:0x0240, B:78:0x0246, B:38:0x00ee, B:45:0x0101, B:51:0x010e, B:49:0x010a), top: B:96:0x0240 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x010a A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:76:0x0240, B:78:0x0246, B:38:0x00ee, B:45:0x0101, B:51:0x010e, B:49:0x010a), top: B:96:0x0240 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x010d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0214  */
    /* JADX WARN: Code duplicated, block: B:78:0x0246 A[Catch: all -> 0x0105, TRY_LEAVE, TryCatch #1 {all -> 0x0105, blocks: (B:76:0x0240, B:78:0x0246, B:38:0x00ee, B:45:0x0101, B:51:0x010e, B:49:0x010a), top: B:96:0x0240 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:81:0x0269  */
    /* JADX WARN: Code duplicated, block: B:83:0x026d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0279  */
    /* JADX WARN: Code duplicated, block: B:89:0x0282  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00fb -> B:96:0x0240). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0214 -> B:74:0x021a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object migrationFromLegacy234(android.content.Context r27, android.database.sqlite.SQLiteDatabase r28, int r29, kotlin.coroutines.jvm.internal.ContinuationImpl r30) {
        /*
            Method dump skipped, instruction units count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.g00fy2.quickie.ScanQRCode.migrationFromLegacy234(android.content.Context, android.database.sqlite.SQLiteDatabase, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0193  */
    /* JADX WARN: Code duplicated, block: B:190:0x03a0  */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Iterable, java.lang.Object] */
    public final Object parseResult(int i, Intent intent) {
        Object qRSuccess;
        QRContent contactInfo;
        Object obj;
        CalendarEventParcelable calendarEventParcelable;
        Exception illegalStateException;
        Intent intent2 = intent;
        switch (this.$r8$classId) {
            case 0:
                if (i == -1) {
                    QRContent plain = null;
                    byte[] byteArrayExtra = intent2 != null ? intent2.getByteArrayExtra("quickie-bytes") : null;
                    String stringExtra = intent2 != null ? intent2.getStringExtra("quickie-value") : null;
                    if (intent2 == null) {
                        plain = new QRContent.Plain(byteArrayExtra, stringExtra);
                    } else {
                        Bundle extras = intent2.getExtras();
                        Integer numValueOf = extras != null ? Integer.valueOf(extras.getInt("quickie-type", 0)) : null;
                        QRContent.Phone.PhoneType phoneType = QRContent.Phone.PhoneType.UNKNOWN;
                        EnumEntriesList enumEntriesList = QRContent.Phone.PhoneType.$ENTRIES;
                        Object obj2 = QRContent.Email.EmailType.UNKNOWN;
                        EnumEntriesList enumEntriesList2 = QRContent.Email.EmailType.$ENTRIES;
                        int i2 = 10;
                        if (numValueOf != null && numValueOf.intValue() == 1) {
                            ContactInfoParcelable contactInfoParcelable = (ContactInfoParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", ContactInfoParcelable.class);
                            if (contactInfoParcelable != null) {
                                ?? r3 = contactInfoParcelable.addressParcelables;
                                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r3, 10));
                                for (AddressParcelable addressParcelable : r3) {
                                    List list = addressParcelable.addressLines;
                                    int i3 = addressParcelable.type;
                                    if (i3 >= 0) {
                                        EnumEntriesList enumEntriesList3 = QRContent.ContactInfo.Address.AddressType.$ENTRIES;
                                        if (i3 < enumEntriesList3.getSize()) {
                                            obj = enumEntriesList3.get(i3);
                                        } else {
                                            obj = QRContent.ContactInfo.Address.AddressType.UNKNOWN;
                                        }
                                    } else {
                                        obj = QRContent.ContactInfo.Address.AddressType.UNKNOWN;
                                    }
                                    arrayList.add(new QRContent.ContactInfo.Address(list, (QRContent.ContactInfo.Address.AddressType) obj));
                                }
                                ?? r4 = contactInfoParcelable.emailParcelables;
                                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, 10));
                                for (EmailParcelable emailParcelable : r4) {
                                    int i4 = i2;
                                    String str = emailParcelable.address;
                                    String str2 = emailParcelable.body;
                                    String str3 = emailParcelable.subject;
                                    int i5 = emailParcelable.type;
                                    arrayList2.add(new QRContent.Email(byteArrayExtra, stringExtra, str, str2, str3, (QRContent.Email.EmailType) ((i5 < 0 || i5 >= enumEntriesList2.getSize()) ? obj2 : enumEntriesList2.get(i5))));
                                    enumEntriesList2 = enumEntriesList2;
                                    i2 = i4;
                                    arrayList = arrayList;
                                }
                                ArrayList arrayList3 = arrayList;
                                PersonNameParcelable personNameParcelable = contactInfoParcelable.nameParcelable;
                                QRContent.ContactInfo.PersonName personName = new QRContent.ContactInfo.PersonName(personNameParcelable.first, personNameParcelable.formattedName, personNameParcelable.last, personNameParcelable.middle, personNameParcelable.prefix, personNameParcelable.pronunciation, personNameParcelable.suffix);
                                String str4 = contactInfoParcelable.organization;
                                ?? r1 = contactInfoParcelable.phoneParcelables;
                                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, i2));
                                for (PhoneParcelable phoneParcelable : r1) {
                                    String str5 = phoneParcelable.number;
                                    int i6 = phoneParcelable.type;
                                    arrayList4.add(new QRContent.Phone(byteArrayExtra, stringExtra, str5, (QRContent.Phone.PhoneType) ((i6 < 0 || i6 >= enumEntriesList.getSize()) ? phoneType : enumEntriesList.get(i6))));
                                }
                                contactInfo = new QRContent.ContactInfo(byteArrayExtra, stringExtra, arrayList3, arrayList2, personName, str4, arrayList4, contactInfoParcelable.title, contactInfoParcelable.urls);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 2) {
                            EmailParcelable emailParcelable2 = (EmailParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", EmailParcelable.class);
                            if (emailParcelable2 != null) {
                                String str6 = emailParcelable2.address;
                                String str7 = emailParcelable2.body;
                                String str8 = emailParcelable2.subject;
                                int i7 = emailParcelable2.type;
                                if (i7 >= 0 && i7 < enumEntriesList2.getSize()) {
                                    obj2 = enumEntriesList2.get(i7);
                                }
                                contactInfo = new QRContent.Email(byteArrayExtra, stringExtra, str6, str7, str8, (QRContent.Email.EmailType) obj2);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 4) {
                            PhoneParcelable phoneParcelable2 = (PhoneParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", PhoneParcelable.class);
                            if (phoneParcelable2 != null) {
                                String str9 = phoneParcelable2.number;
                                int i8 = phoneParcelable2.type;
                                plain = new QRContent.Phone(byteArrayExtra, stringExtra, str9, (QRContent.Phone.PhoneType) ((i8 < 0 || i8 >= enumEntriesList.getSize()) ? phoneType : enumEntriesList.get(i8)));
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 6) {
                            SmsParcelable smsParcelable = (SmsParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", SmsParcelable.class);
                            if (smsParcelable != null) {
                                plain = new QRContent.Sms(byteArrayExtra, stringExtra, smsParcelable.message, smsParcelable.phoneNumber);
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 8) {
                            UrlBookmarkParcelable urlBookmarkParcelable = (UrlBookmarkParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", UrlBookmarkParcelable.class);
                            if (urlBookmarkParcelable != null) {
                                plain = new QRContent.Url(byteArrayExtra, stringExtra, urlBookmarkParcelable.title, urlBookmarkParcelable.url);
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 9) {
                            WifiParcelable wifiParcelable = (WifiParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", WifiParcelable.class);
                            if (wifiParcelable != null) {
                                contactInfo = new QRContent.Wifi(byteArrayExtra, stringExtra, wifiParcelable.encryptionType, wifiParcelable.password, wifiParcelable.ssid);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 10) {
                            GeoPointParcelable geoPointParcelable = (GeoPointParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", GeoPointParcelable.class);
                            if (geoPointParcelable != null) {
                                contactInfo = new QRContent.GeoPoint(byteArrayExtra, stringExtra, geoPointParcelable.lat, geoPointParcelable.lng);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 11 && (calendarEventParcelable = (CalendarEventParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", CalendarEventParcelable.class)) != null) {
                            String str10 = calendarEventParcelable.description;
                            CalendarDateTimeParcelable calendarDateTimeParcelable = calendarEventParcelable.end;
                            QRContent.CalendarEvent.CalendarDateTime calendarDateTime = new QRContent.CalendarEvent.CalendarDateTime(calendarDateTimeParcelable.day, calendarDateTimeParcelable.hours, calendarDateTimeParcelable.minutes, calendarDateTimeParcelable.month, calendarDateTimeParcelable.seconds, calendarDateTimeParcelable.year, calendarDateTimeParcelable.utc);
                            String str11 = calendarEventParcelable.location;
                            String str12 = calendarEventParcelable.organizer;
                            CalendarDateTimeParcelable calendarDateTimeParcelable2 = calendarEventParcelable.start;
                            contactInfo = new QRContent.CalendarEvent(byteArrayExtra, stringExtra, str10, calendarDateTime, str11, str12, new QRContent.CalendarEvent.CalendarDateTime(calendarDateTimeParcelable2.day, calendarDateTimeParcelable2.hours, calendarDateTimeParcelable2.minutes, calendarDateTimeParcelable2.month, calendarDateTimeParcelable2.seconds, calendarDateTimeParcelable2.year, calendarDateTimeParcelable2.utc), calendarEventParcelable.status, calendarEventParcelable.summary);
                            plain = contactInfo;
                        }
                        if (plain == null) {
                            plain = new QRContent.Plain(byteArrayExtra, stringExtra);
                        }
                    }
                    qRSuccess = new QRResult.QRSuccess(plain);
                } else {
                    if (i == 0) {
                        return QRResult.QRUserCanceled.INSTANCE;
                    }
                    if (i == 2) {
                        return QRResult.QRMissingPermission.INSTANCE;
                    }
                    if (i != 3) {
                        return new QRResult.QRError(new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown activity result code ", i)));
                    }
                    if (intent2 == null || (illegalStateException = (Exception) IntentCompat.getParcelableExtra(intent2, "quickie-exception", Exception.class)) == null) {
                        illegalStateException = new IllegalStateException("Could retrieve root exception");
                    }
                    qRSuccess = new QRResult.QRError(illegalStateException);
                }
                return qRSuccess;
            case 1:
                if (i != -1) {
                    intent2 = null;
                }
                if (intent2 != null) {
                    return intent2.getData();
                }
                return null;
            case 2:
                if (i != -1) {
                    intent2 = null;
                }
                if (intent2 != null) {
                    return intent2.getData();
                }
                return null;
            case 3:
                if (i == -1 && intent2 != null) {
                    String[] stringArrayExtra = intent2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent2.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList5 = new ArrayList(intArrayExtra.length);
                        for (int i9 : intArrayExtra) {
                            arrayList5.add(Boolean.valueOf(i9 == 0));
                        }
                        ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(stringArrayExtra);
                        Iterator it = arrayListFilterNotNull.iterator();
                        Iterator it2 = arrayList5.iterator();
                        ArrayList arrayList6 = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListFilterNotNull, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList6.add(new Pair(it.next(), it2.next()));
                        }
                        return MapsKt__MapsKt.toMap(arrayList6);
                    }
                }
                return EmptyMap.INSTANCE;
            case 4:
                if (intent2 == null || i != -1) {
                    return Boolean.FALSE;
                }
                int[] intArrayExtra2 = intent2.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                boolean z = false;
                if (intArrayExtra2 != null) {
                    for (int i10 : intArrayExtra2) {
                        if (i10 == 0) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            case 5:
                return new ActivityResult(i, intent2);
            default:
                return new ActivityResult(i, intent2);
        }
    }
}
