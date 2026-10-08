package dev.chrisbanes.haze;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedCallbackInfo;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.foundation.layout.ExcludeInsets;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.room.RoomOpenHelper;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.FilesActivity$DisposableBackPressed$callback$1$1;
import com.github.kr328.clash.remote.Broadcasts$Observer;
import com.github.kr328.clash.remote.Remote;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import io.github.g00fy2.quickie.QROverlayView;
import io.github.g00fy2.quickie.QRScannerActivity;
import io.github.g00fy2.quickie.ScanQRCode;
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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Dispatcher;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BlurEffectKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ BlurEffectKt$$ExternalSyntheticLambda1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.appcompat.widget.TooltipPopup] */
    /* JADX WARN: Type inference failed for: r5v73 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9 */
    private final Object invoke$io$github$g00fy2$quickie$QRScannerActivity$$ExternalSyntheticLambda4(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Object obj2;
        Object obj3;
        ?? r23;
        Object obj4;
        ?? r24;
        Object obj5;
        ?? r25;
        Object obj6;
        ?? r26;
        Object obj7;
        ?? r27;
        Object obj8;
        ?? r28;
        Object obj9;
        ?? r22;
        ArrayList arrayList5;
        Object obj10;
        ?? r29;
        ArrayList arrayList6;
        Parcelable contactInfoParcelable;
        List<String> list;
        String str;
        ?? r13;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        ?? r14;
        ?? r7;
        String str11;
        String str12;
        ArrayList arrayList7;
        ?? arrayList8;
        String[] strArr;
        Parcelable emailParcelable;
        String str13;
        ImageAnalysis imageAnalysis = (ImageAnalysis) this.f$0;
        QRScannerActivity qRScannerActivity = (QRScannerActivity) this.f$1;
        Barcode barcode = (Barcode) obj;
        int i = QRScannerActivity.$r8$clinit;
        synchronized (imageAnalysis.mAnalysisLock) {
            arrayList = null;
            contactInfoParcelable = null;
            imageAnalysis.mImageAnalysisAbstractAnalyzer.setAnalyzer(null, null);
            if (imageAnalysis.mSubscribedAnalyzer != null) {
                imageAnalysis.mState = 2;
                imageAnalysis.notifyState();
            }
            imageAnalysis.mSubscribedAnalyzer = null;
        }
        CacheStrategy cacheStrategy = qRScannerActivity.binding;
        if (cacheStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        ((QROverlayView) cacheStrategy.networkRequest).setHighlighted(true);
        if (qRScannerActivity.hapticFeedback) {
            CacheStrategy cacheStrategy2 = qRScannerActivity.binding;
            if (cacheStrategy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            ((QROverlayView) cacheStrategy2.networkRequest).performHapticFeedback(3, 3);
        }
        Intent intent = new Intent();
        BarcodeSource barcodeSource = barcode.zza;
        byte[] rawBytes = barcodeSource.getRawBytes();
        intent.putExtra("quickie-bytes", rawBytes != null ? Arrays.copyOf(rawBytes, rawBytes.length) : null);
        intent.putExtra("quickie-value", barcodeSource.getRawValue());
        intent.putExtra("quickie-type", barcodeSource.getValueType());
        EmptyList emptyList = EmptyList.INSTANCE;
        int valueType = barcodeSource.getValueType();
        if (valueType != 1) {
            if (valueType == 2) {
                Barcode.Email email = barcodeSource.getEmail();
                String str14 = email != null ? email.zzb : null;
                if (str14 == null) {
                    str14 = "";
                }
                Barcode.Email email2 = barcodeSource.getEmail();
                String str15 = email2 != null ? email2.zzd : null;
                if (str15 == null) {
                    str15 = "";
                }
                Barcode.Email email3 = barcodeSource.getEmail();
                String str16 = email3 != null ? email3.zzc : null;
                str13 = str16 != null ? str16 : "";
                Barcode.Email email4 = barcodeSource.getEmail();
                emailParcelable = new EmailParcelable(email4 != null ? email4.zza : 0, str14, str15, str13);
            } else if (valueType == 4) {
                Barcode.Phone phone = barcodeSource.getPhone();
                String str17 = phone != null ? phone.zza : null;
                str13 = str17 != null ? str17 : "";
                Barcode.Phone phone2 = barcodeSource.getPhone();
                emailParcelable = new PhoneParcelable(str13, phone2 != null ? phone2.zzb : 0);
            } else if (valueType != 6) {
                switch (valueType) {
                    case 8:
                        GmsLogger url = barcodeSource.getUrl();
                        String str18 = url != null ? url.zza : null;
                        if (str18 == null) {
                            str18 = "";
                        }
                        GmsLogger url2 = barcodeSource.getUrl();
                        String str19 = url2 != null ? url2.zzb : null;
                        emailParcelable = new UrlBookmarkParcelable(str18, str19 != null ? str19 : "");
                        break;
                    case 9:
                        RoomOpenHelper wifi = barcodeSource.getWifi();
                        int i2 = wifi != null ? wifi.version : 0;
                        RoomOpenHelper wifi2 = barcodeSource.getWifi();
                        String str20 = wifi2 != null ? (String) wifi2.mDelegate : null;
                        if (str20 == null) {
                            str20 = "";
                        }
                        RoomOpenHelper wifi3 = barcodeSource.getWifi();
                        String str21 = wifi3 != null ? (String) wifi3.mConfiguration : null;
                        emailParcelable = new WifiParcelable(i2, str20, str21 != null ? str21 : "");
                        break;
                    case 10:
                        Barcode.GeoPoint geoPoint = barcodeSource.getGeoPoint();
                        double d = geoPoint != null ? geoPoint.zza : 0.0d;
                        Barcode.GeoPoint geoPoint2 = barcodeSource.getGeoPoint();
                        contactInfoParcelable = new GeoPointParcelable(d, geoPoint2 != null ? geoPoint2.zzb : 0.0d);
                        break;
                    case 11:
                        TooltipPopup calendarEvent = barcodeSource.getCalendarEvent();
                        String str22 = calendarEvent != null ? (String) calendarEvent.mContentView : null;
                        String str23 = str22 == null ? "" : str22;
                        TooltipPopup calendarEvent2 = barcodeSource.getCalendarEvent();
                        CalendarDateTimeParcelable parcelableCalendarEvent = ShortcutManagerCompat.toParcelableCalendarEvent(calendarEvent2 != null ? (Barcode.CalendarDateTime) calendarEvent2.mTmpAppPos : null);
                        TooltipPopup calendarEvent3 = barcodeSource.getCalendarEvent();
                        String str24 = calendarEvent3 != null ? (String) calendarEvent3.mMessageView : null;
                        String str25 = str24 == null ? "" : str24;
                        TooltipPopup calendarEvent4 = barcodeSource.getCalendarEvent();
                        String str26 = calendarEvent4 != null ? (String) calendarEvent4.mLayoutParams : null;
                        String str27 = str26 == null ? "" : str26;
                        TooltipPopup calendarEvent5 = barcodeSource.getCalendarEvent();
                        CalendarDateTimeParcelable parcelableCalendarEvent2 = ShortcutManagerCompat.toParcelableCalendarEvent(calendarEvent5 != null ? (Barcode.CalendarDateTime) calendarEvent5.mTmpAnchorPos : null);
                        TooltipPopup calendarEvent6 = barcodeSource.getCalendarEvent();
                        String str28 = calendarEvent6 != null ? (String) calendarEvent6.mTmpDisplayFrame : null;
                        String str29 = str28 == null ? "" : str28;
                        TooltipPopup calendarEvent7 = barcodeSource.getCalendarEvent();
                        String str30 = calendarEvent7 != null ? (String) calendarEvent7.mContext : null;
                        contactInfoParcelable = new CalendarEventParcelable(str23, parcelableCalendarEvent, str25, str27, parcelableCalendarEvent2, str29, str30 == null ? "" : str30);
                        break;
                }
            } else {
                GmsLogger sms = barcodeSource.getSms();
                String str31 = sms != null ? sms.zza : null;
                if (str31 == null) {
                    str31 = "";
                }
                GmsLogger sms2 = barcodeSource.getSms();
                String str32 = sms2 != null ? sms2.zzb : null;
                emailParcelable = new SmsParcelable(str31, str32 != null ? str32 : "");
            }
            contactInfoParcelable = emailParcelable;
        } else {
            TooltipPopup contactInfo = barcodeSource.getContactInfo();
            if (contactInfo != null) {
                ArrayList arrayList9 = (ArrayList) contactInfo.mTmpAppPos;
                arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList9, 10));
                int size = arrayList9.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj11 = arrayList9.get(i3);
                    i3++;
                    Barcode.Address address = (Barcode.Address) obj11;
                    if (address == null || (strArr = address.zzb) == null) {
                        arrayList7 = arrayList;
                        arrayList8 = arrayList7;
                    } else {
                        List<String> list2 = ArraysKt.toList(strArr);
                        arrayList7 = arrayList;
                        arrayList8 = new ArrayList();
                        for (String str33 : list2) {
                            if (str33 != null) {
                                arrayList8.add(str33);
                            }
                        }
                    }
                    if (arrayList8 == 0) {
                        arrayList8 = emptyList;
                    }
                    arrayList3.add(new AddressParcelable(address != null ? address.zza : 0, arrayList8));
                    arrayList = arrayList7;
                }
                arrayList2 = arrayList;
            } else {
                arrayList2 = null;
                arrayList3 = null;
            }
            List list3 = arrayList3 == null ? emptyList : arrayList3;
            TooltipPopup contactInfo2 = barcodeSource.getContactInfo();
            if (contactInfo2 != null) {
                ArrayList arrayList10 = (ArrayList) contactInfo2.mTmpDisplayFrame;
                arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList10, 10));
                int size2 = arrayList10.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj12 = arrayList10.get(i4);
                    i4++;
                    Barcode.Email email5 = (Barcode.Email) obj12;
                    if (email5 != null) {
                        str12 = email5.zzb;
                    } else {
                        r14 = arrayList2;
                    }
                    if (r14 == 0) {
                        r14 = str12;
                        r14 = "";
                    }
                    ?? r15 = email5 != null ? email5.zzd : arrayList2;
                    if (r15 == 0) {
                        r15 = "";
                    }
                    if (email5 != null) {
                        str11 = email5.zzc;
                    } else {
                        r7 = arrayList2;
                    }
                    if (r7 == 0) {
                        r7 = str11;
                        r7 = "";
                    }
                    arrayList4.add(new EmailParcelable(email5 != null ? email5.zza : 0, r14, r15, r7));
                }
            } else {
                arrayList4 = arrayList2;
            }
            List list4 = arrayList4 == null ? emptyList : arrayList4;
            TooltipPopup contactInfo3 = barcodeSource.getContactInfo();
            ?? r5 = contactInfo3 != null ? (TooltipPopup) contactInfo3.mContext : arrayList2;
            if (r5 != 0) {
                str10 = (String) r5.mLayoutParams;
            } else {
                obj2 = arrayList2;
            }
            ?? r210 = obj2 == null ? "" : obj2;
            if (r5 != 0) {
                obj2 = str10;
                str9 = (String) r5.mContext;
            } else {
                obj2 = str10;
                obj3 = arrayList2;
            }
            if (obj3 == null) {
                obj2 = str10;
                r23 = "";
            } else {
                obj2 = str10;
                r23 = obj3;
            }
            if (r5 != 0) {
                obj2 = str10;
                obj3 = str9;
                str8 = (String) r5.mTmpAnchorPos;
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = arrayList2;
            }
            if (obj4 == null) {
                obj2 = str10;
                obj3 = str9;
                r24 = "";
            } else {
                obj2 = str10;
                obj3 = str9;
                r24 = obj4;
            }
            if (r5 != 0) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                str7 = (String) r5.mTmpDisplayFrame;
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = arrayList2;
            }
            if (obj5 == null) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                r25 = "";
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                r25 = obj5;
            }
            if (r5 != 0) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                str6 = (String) r5.mMessageView;
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = arrayList2;
            }
            if (obj6 == null) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                r26 = "";
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                r26 = obj6;
            }
            if (r5 != 0) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                str5 = (String) r5.mContentView;
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                obj7 = arrayList2;
            }
            if (obj7 == null) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                r27 = "";
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                r27 = obj7;
            }
            if (r5 != 0) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                obj7 = str5;
                str4 = (String) r5.mTmpAppPos;
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                obj7 = str5;
                obj8 = arrayList2;
            }
            if (obj8 == null) {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                obj7 = str5;
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                obj7 = str5;
                obj8 = str4;
                r28 = "";
            } else {
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                obj7 = str5;
                obj2 = str10;
                obj3 = str9;
                obj4 = str8;
                obj5 = str7;
                obj6 = str6;
                obj7 = str5;
                obj8 = str4;
                r28 = obj8;
            }
            PersonNameParcelable personNameParcelable = new PersonNameParcelable(r210, r23, r24, r25, r26, r27, r28);
            TooltipPopup contactInfo4 = barcodeSource.getContactInfo();
            if (contactInfo4 != null) {
                str3 = (String) contactInfo4.mContentView;
            } else {
                obj9 = arrayList2;
            }
            if (obj9 == null) {
                obj9 = str3;
                r22 = "";
            } else {
                obj9 = str3;
                r22 = obj9;
            }
            TooltipPopup contactInfo5 = barcodeSource.getContactInfo();
            if (contactInfo5 != null) {
                ArrayList arrayList11 = (ArrayList) contactInfo5.mLayoutParams;
                arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList11, 10));
                int size3 = arrayList11.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj13 = arrayList11.get(i5);
                    i5++;
                    Barcode.Phone phone3 = (Barcode.Phone) obj13;
                    if (phone3 != null) {
                        str2 = phone3.zza;
                    } else {
                        r13 = arrayList2;
                    }
                    if (r13 == 0) {
                        r13 = str2;
                        r13 = "";
                    }
                    arrayList5.add(new PhoneParcelable(r13, phone3 != null ? phone3.zzb : 0));
                }
            } else {
                arrayList5 = arrayList2;
            }
            List list5 = arrayList5 == null ? emptyList : arrayList5;
            TooltipPopup contactInfo6 = barcodeSource.getContactInfo();
            if (contactInfo6 != null) {
                str = (String) contactInfo6.mMessageView;
            } else {
                obj10 = arrayList2;
            }
            if (obj10 == null) {
                obj10 = str;
                r29 = "";
            } else {
                obj10 = str;
                r29 = obj10;
            }
            TooltipPopup contactInfo7 = barcodeSource.getContactInfo();
            if (contactInfo7 == null || (list = (List) contactInfo7.mTmpAnchorPos) == null) {
                arrayList6 = arrayList2;
            } else {
                arrayList6 = new ArrayList();
                for (String str34 : list) {
                    if (str34 != null) {
                        arrayList6.add(str34);
                    }
                }
            }
            contactInfoParcelable = new ContactInfoParcelable(list3, list4, personNameParcelable, r22, list5, r29, arrayList6 == null ? emptyList : arrayList6);
        }
        intent.putExtra("quickie-parcelable", contactInfoParcelable);
        Unit unit = Unit.INSTANCE;
        qRScannerActivity.setResult(-1, intent);
        qRScannerActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:151:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x01c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x01ca A[LOOP:0: B:74:0x0194->B:84:0x01ca, LOOP_END] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        Selection selection;
        NavDestination navDestination;
        int i = 7;
        switch (this.$r8$classId) {
            case 0:
                ((StringsKt__StringsKt$$ExternalSyntheticLambda0) this.f$0).invoke((DrawScope) obj, (GraphicsLayer) this.f$1);
                return Unit.INSTANCE;
            case 1:
                SelectionManager selectionManager = (SelectionManager) this.f$0;
                Function1 function1 = (Function1) this.f$1;
                Selection selection2 = (Selection) obj;
                selectionManager.setSelection(selection2);
                function1.invoke(selection2);
                return Unit.INSTANCE;
            case 2:
                SelectionManager selectionManager2 = (SelectionManager) this.f$0;
                Context context = (Context) this.f$1;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                textContextMenuBuilderScope.separator();
                MutableObjectList mutableObjectList = textContextMenuBuilderScope.components;
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.Autofill;
                boolean zIsNonEmptySelection$foundation = selectionManager2.isNonEmptySelection$foundation();
                SelectionManager$$ExternalSyntheticLambda0 selectionManager$$ExternalSyntheticLambda0 = new SelectionManager$$ExternalSyntheticLambda0(selectionManager2, 5);
                Resources resources = context.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda0 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(selectionManager$$ExternalSyntheticLambda0, null, 0);
                if (zIsNonEmptySelection$foundation) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.CopyKey, resources.getString(R.string.copy), R.attr.actionModeCopyDrawable, selectionManager_androidKt$$ExternalSyntheticLambda0));
                }
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Autofill;
                SelectionRegistrarImpl selectionRegistrarImpl = selectionManager2.selectionRegistrar;
                ArrayList arrayListSort = selectionRegistrarImpl.sort(selectionManager2.requireContainerCoordinates$foundation());
                if (arrayListSort.isEmpty()) {
                    z = true;
                } else {
                    int size = arrayListSort.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 < size) {
                            MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = (MultiWidgetSelectionDelegate) arrayListSort.get(i2);
                            AnnotatedString text = multiWidgetSelectionDelegate.getText();
                            if (text.text.length() != 0 && ((selection = (Selection) selectionRegistrarImpl.getSubselections().get(multiWidgetSelectionDelegate.selectableId)) == null || Math.abs(selection.start.offset - selection.end.offset) != text.text.length())) {
                                z = false;
                            } else {
                                i2++;
                            }
                        } else {
                            z = true;
                        }
                    }
                }
                SelectionManager$$ExternalSyntheticLambda0 selectionManager$$ExternalSyntheticLambda1 = new SelectionManager$$ExternalSyntheticLambda0(selectionManager2, 6);
                SelectionManager$$ExternalSyntheticLambda0 selectionManager$$ExternalSyntheticLambda2 = new SelectionManager$$ExternalSyntheticLambda0(selectionManager2, i);
                Resources resources2 = context.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda1 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(selectionManager$$ExternalSyntheticLambda2, selectionManager$$ExternalSyntheticLambda1, 0);
                if (!z) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.SelectAllKey, resources2.getString(R.string.selectAll), R.attr.actionModeSelectAllDrawable, selectionManager_androidKt$$ExternalSyntheticLambda1));
                }
                textContextMenuBuilderScope.separator();
                return Unit.INSTANCE;
            case 3:
                ((MutableWindowInsets) this.f$0).insets$delegate.setValue(new ExcludeInsets((WindowInsets) this.f$1, (WindowInsets) obj));
                return Unit.INSTANCE;
            case 4:
                String str = (String) this.f$0;
                Function0 function0 = (Function0) this.f$1;
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TraversalIndex;
                KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[11];
                semanticsPropertyReceiver.set(semanticsPropertyKey, Float.valueOf(1.0f));
                if (str != null) {
                    SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                }
                semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(null, new ScrimKt$$ExternalSyntheticLambda3(0, function0)));
                return Unit.INSTANCE;
            case 5:
                Http2Connection.Builder builder = (Http2Connection.Builder) this.f$0;
                SolidColor solidColor = (SolidColor) this.f$1;
                DrawScope drawScope = (DrawScope) obj;
                float f = ((Dp) ((Function0) builder.socket).invoke()).value;
                float f2 = 2;
                float fMin = Math.min(Dp.m704equalsimpl0(f, 0.0f) ? 1.0f : (float) Math.ceil(drawScope.mo92toPx0680j_4(f)), (float) Math.ceil((Size.m386getMinDimensionimpl(drawScope.mo474getSizeNHjbRc()) - (((float) Math.ceil(drawScope.mo92toPx0680j_4(((Dp) ((Function0) builder.connectionName).invoke()).value))) * f2)) / f2));
                float f3 = fMin < 0.0f ? 0.0f : fMin;
                float fCeil = (float) Math.ceil(drawScope.mo92toPx0680j_4(((Dp) ((Function0) builder.connectionName).invoke()).value));
                float f4 = (f3 / f2) + fCeil;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (((long) Float.floatToRawIntBits(f4)) << 32);
                float f5 = fCeil * f2;
                long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) - f3) - f5)) & 4294967295L) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)) - f3) - f5)) << 32);
                boolean z2 = fCeil == 0.0f && f3 * f2 > Size.m386getMinDimensionimpl(drawScope.mo474getSizeNHjbRc());
                if (z2) {
                    jFloatToRawIntBits = 0;
                }
                if (z2) {
                    jFloatToRawIntBits2 = drawScope.mo474getSizeNHjbRc();
                }
                Modifier.CC.m314drawRectAsUm42w$default(drawScope, solidColor, jFloatToRawIntBits, jFloatToRawIntBits2, 0.0f, z2 ? Fill.INSTANCE : new Stroke(f3, 0.0f, 0, 0, 30), null, 0, 104);
                return Unit.INSTANCE;
            case 6:
                ((MultiSubscriptionSnapshotFlowManager) this.f$0).pendingChanges.add(new MultiSubscriptionSnapshotFlowManager.Add(obj, (SendChannel) this.f$1));
                return Unit.INSTANCE;
            case 7:
                Set set = (Set) this.f$0;
                MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager = (MultiSubscriptionSnapshotFlowManager) this.f$1;
                if (set.contains(obj)) {
                    MutableScatterMap mutableScatterMap = multiSubscriptionSnapshotFlowManager.subscriptions;
                    MutableScatterSet mutableScatterSet = multiSubscriptionSnapshotFlowManager.toNotify;
                    Object obj2 = mutableScatterMap.get(obj);
                    if (obj2 != null) {
                        if (obj2 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet2.elements;
                            long[] jArr = mutableScatterSet2.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                while (true) {
                                    long j = jArr[i3];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if ((255 & j) < 128) {
                                                mutableScatterSet.add((SendChannel) objArr[(i3 << 3) + i5]);
                                            }
                                            j >>= 8;
                                        }
                                        if (i4 == 8) {
                                            if (i3 != length) {
                                                i3++;
                                            }
                                        }
                                    } else if (i3 != length) {
                                        i3++;
                                    }
                                }
                            }
                        } else {
                            mutableScatterSet.add((SendChannel) obj2);
                        }
                    }
                }
                return Unit.INSTANCE;
            case 8:
                CompositionImpl compositionImpl = (CompositionImpl) this.f$0;
                MutableScatterSet mutableScatterSet3 = (MutableScatterSet) this.f$1;
                compositionImpl.recordWriteOf(obj);
                if (mutableScatterSet3 != null) {
                    mutableScatterSet3.add(obj);
                }
                return Unit.INSTANCE;
            case 9:
                Recomposer recomposer = (Recomposer) this.f$0;
                Throwable th = (Throwable) this.f$1;
                Throwable th2 = (Throwable) obj;
                synchronized (recomposer.stateLock) {
                    if (th == null) {
                        th = null;
                    } else if (th2 != null) {
                        try {
                            if (th2 instanceof CancellationException) {
                                th2 = null;
                            }
                            if (th2 != null) {
                                ScanQRCode.addSuppressed(th, th2);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    recomposer.closeCause = th;
                    StateFlowImpl stateFlowImpl = recomposer._state;
                    Recomposer.State state = Recomposer.State.ShutDown;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, state);
                }
                return Unit.INSTANCE;
            case 10:
                FilesActivity filesActivity = (FilesActivity) this.f$0;
                FilesActivity$DisposableBackPressed$callback$1$1 filesActivity$DisposableBackPressed$callback$1$1 = (FilesActivity$DisposableBackPressed$callback$1$1) this.f$1;
                int i6 = FilesActivity.$r8$clinit;
                OnBackPressedDispatcher onBackPressedDispatcher = filesActivity.getOnBackPressedDispatcher();
                onBackPressedDispatcher.getClass();
                OnBackPressedCallback.OnBackPressedEventHandler onBackPressedEventHandler = new OnBackPressedCallback.OnBackPressedEventHandler(filesActivity$DisposableBackPressed$callback$1$1, new OnBackPressedCallbackInfo(filesActivity$DisposableBackPressed$callback$1$1, null));
                filesActivity$DisposableBackPressed$callback$1$1.eventHandlers.add(onBackPressedEventHandler);
                Dispatcher.addHandler$default(onBackPressedDispatcher.eventDispatcher, onBackPressedEventHandler);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(14, filesActivity$DisposableBackPressed$callback$1$1);
            case 11:
                String str2 = (String) this.f$0;
                NavHostController navHostController = (NavHostController) this.f$1;
                String str3 = (String) obj;
                if (!str3.equals(str2)) {
                    DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0(9, navHostController);
                    navHostController.getClass();
                    NavOptions navOptions = NavOptionsBuilderKt.navOptions(diskLruCache$$ExternalSyntheticLambda0);
                    if (navHostController._graph == null) {
                        throw new IllegalArgumentException(("Cannot navigate to " + str3 + ". Navigation graph has not been set for NavController " + navHostController + '.').toString());
                    }
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) navHostController.backQueue.lastOrNull();
                    if (navBackStackEntry == null || (navDestination = navBackStackEntry.destination) == null) {
                        navDestination = navHostController._graph;
                    }
                    NavGraph navGraph = navDestination instanceof NavGraph ? (NavGraph) navDestination : navDestination.parent;
                    NavDestination.DeepLinkMatch deepLinkMatchMatchRouteComprehensive = navGraph.matchRouteComprehensive(str3, true, navGraph);
                    if (deepLinkMatchMatchRouteComprehensive == null) {
                        StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Navigation destination that matches route ", str3, " cannot be found in the navigation graph ");
                        sbM16m.append(navHostController._graph);
                        throw new IllegalArgumentException(sbM16m.toString());
                    }
                    NavDestination navDestination2 = deepLinkMatchMatchRouteComprehensive.destination;
                    Bundle bundleAddInDefaultArgs = navDestination2.addInDefaultArgs(deepLinkMatchMatchRouteComprehensive.matchingArgs);
                    if (bundleAddInDefaultArgs == null) {
                        bundleAddInDefaultArgs = new Bundle();
                    }
                    Intent intent = new Intent();
                    int i7 = NavDestination.$r8$clinit;
                    String str4 = navDestination2.route;
                    intent.setDataAndType(Uri.parse(str4 != null ? "android-app://androidx.navigation/".concat(str4) : ""), null);
                    intent.setAction(null);
                    bundleAddInDefaultArgs.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                    navHostController.navigate(navDestination2, bundleAddInDefaultArgs, navOptions);
                }
                return Unit.INSTANCE;
            case 12:
                final MutableState mutableState = (MutableState) this.f$0;
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.f$1;
                Broadcasts$Observer broadcasts$Observer = new Broadcasts$Observer() { // from class: com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$2$1$observer$1
                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileChanged() {
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState;
                        parcelableSnapshotMutableIntState2.setIntValue(parcelableSnapshotMutableIntState2.getIntValue() + 1);
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileLoaded() {
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState;
                        parcelableSnapshotMutableIntState2.setIntValue(parcelableSnapshotMutableIntState2.getIntValue() + 1);
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onServiceRecreated() {
                        mutableState.setValue(Boolean.FALSE);
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onStarted() {
                        mutableState.setValue(Boolean.TRUE);
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState;
                        parcelableSnapshotMutableIntState2.setIntValue(parcelableSnapshotMutableIntState2.getIntValue() + 1);
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onStopped() {
                        mutableState.setValue(Boolean.FALSE);
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileUpdateCompleted(UUID uuid) {
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileUpdateFailed(UUID uuid, String str5) {
                    }
                };
                Remote.broadcasts.addObserver(broadcasts$Observer);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(20, broadcasts$Observer);
            case 13:
                return invoke$io$github$g00fy2$quickie$QRScannerActivity$$ExternalSyntheticLambda4(obj);
            default:
                ((HandlerContext) this.f$0).handler.removeCallbacks((Preview$$ExternalSyntheticLambda1) this.f$1);
                return Unit.INSTANCE;
        }
    }
}
