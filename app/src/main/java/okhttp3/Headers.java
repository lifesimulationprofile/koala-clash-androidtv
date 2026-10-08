package okhttp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.room.RoomOpenHelper;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.zaf;
import com.google.android.gms.common.moduleinstall.internal.zar;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.dynamite.zzd;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxy;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzya;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyb;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.internal.MaterialCheckable;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import javax.inject.Provider;
import kotlin.Pair;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okio.AsyncTimeout;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Headers implements Iterable, KMappedMarker {
    public final String[] namesAndValues;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder implements Factory, SynchronizationGuard.CriticalSection, RemoteCall, OnSuccessListener, OnFailureListener, OnCanceledListener, MaterialButton.OnPressedChangeListener, ChipGroup.OnCheckedStateChangeListener, MaterialCheckable.OnCheckedChangeListener, BarcodeSource {
        public final /* synthetic */ int $r8$classId;
        public final Object namesAndValues;

        public /* synthetic */ Builder(int i, Object obj) {
            this.$r8$classId = i;
            this.namesAndValues = obj;
        }

        @Override // com.google.android.gms.common.api.internal.RemoteCall
        public void accept(Object obj, Object obj2) {
            int i = this.$r8$classId;
            Object obj3 = this.namesAndValues;
            switch (i) {
                case 4:
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                    zai zaiVar = (zai) ((zap) obj).getService();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken(zaiVar.zab);
                    zac.zac(parcelObtain, (TelemetryData) obj3);
                    try {
                        zaiVar.zaa.transact(1, parcelObtain, null, 1);
                        parcelObtain.recycle();
                        taskCompletionSource.zza.zzb(null);
                        return;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                default:
                    zar zarVar = new zar((TaskCompletionSource) obj2, 1);
                    zaf zafVar = (zaf) ((zaz) obj).getService();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken(zafVar.zab);
                    int i2 = zac.$r8$clinit;
                    parcelObtain2.writeStrongBinder(zarVar);
                    zac.zac(parcelObtain2, (ApiFeatureRequest) obj3);
                    parcelObtain2.writeStrongBinder(null);
                    zafVar.zac(parcelObtain2, 2);
                    return;
            }
        }

        public void addLenient$okhttp(String str, String str2) {
            ArrayList arrayList = (ArrayList) this.namesAndValues;
            arrayList.add(str);
            arrayList.add(StringsKt.trim(str2).toString());
        }

        public void addUnsafeNonAscii(String str, String str2) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
            addLenient$okhttp(str, str2);
        }

        public Headers build() {
            return new Headers((String[]) ((ArrayList) this.namesAndValues).toArray(new String[0]));
        }

        public void cancel() {
            ((zzw) ((ConnectionPool) this.namesAndValues).delegate).zze(null);
        }

        public synchronized void connected(Route route) {
            ((LinkedHashSet) this.namesAndValues).remove(route);
        }

        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
        public Object execute() {
            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((EventStore) this.namesAndValues);
            long time = sQLiteEventStore.wallClock.getTime() - sQLiteEventStore.config.eventCleanUpAge;
            SQLiteDatabase db = sQLiteEventStore.getDb();
            db.beginTransaction();
            try {
                int iDelete = db.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(time)});
                db.setTransactionSuccessful();
                return Integer.valueOf(iDelete);
            } finally {
                db.endTransaction();
            }
        }

        @Override // javax.inject.Provider
        public Object get() {
            int i = this.$r8$classId;
            Object obj = this.namesAndValues;
            switch (i) {
                case 1:
                    int i2 = 15;
                    return new ImageLoader$Builder((Context) ((ExposureStateImpl) obj).mLock, new ByteString.Companion(i2), new AsyncTimeout.Companion(i2), 11);
                default:
                    Context context = (Context) ((Provider) obj).get();
                    List list = SchemaManager.INCREMENTAL_MIGRATIONS;
                    return new SchemaManager(4, context, "com.google.android.datatransport.events");
            }
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public Rect getBoundingBox() {
            Point[] pointArr = ((zzyb) this.namesAndValues).zze;
            if (pointArr == null) {
                return null;
            }
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            for (Point point : pointArr) {
                iMin = Math.min(iMin, point.x);
                iMax = Math.max(iMax, point.x);
                iMin2 = Math.min(iMin2, point.y);
                iMax2 = Math.max(iMax2, point.y);
            }
            return new Rect(iMin, iMin2, iMax, iMax2);
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public TooltipPopup getCalendarEvent() {
            Barcode.CalendarDateTime calendarDateTime;
            Barcode.CalendarDateTime calendarDateTime2;
            zzxr zzxrVar = ((zzyb) this.namesAndValues).zzm;
            if (zzxrVar == null) {
                return null;
            }
            String str = zzxrVar.zza;
            String str2 = zzxrVar.zzb;
            String str3 = zzxrVar.zzc;
            String str4 = zzxrVar.zzd;
            String str5 = zzxrVar.zze;
            zzxq zzxqVar = zzxrVar.zzf;
            if (zzxqVar == null) {
                calendarDateTime2 = null;
                calendarDateTime = null;
            } else {
                calendarDateTime = null;
                calendarDateTime2 = new Barcode.CalendarDateTime(zzxqVar.zza, zzxqVar.zzb, zzxqVar.zzc, zzxqVar.zzd, zzxqVar.zze, zzxqVar.zzf, zzxqVar.zzg);
            }
            zzxq zzxqVar2 = zzxrVar.zzg;
            return new TooltipPopup(str, str2, str3, str4, str5, calendarDateTime2, zzxqVar2 == null ? calendarDateTime : new Barcode.CalendarDateTime(zzxqVar2.zza, zzxqVar2.zzb, zzxqVar2.zzc, zzxqVar2.zzd, zzxqVar2.zze, zzxqVar2.zzf, zzxqVar2.zzg));
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public TooltipPopup getContactInfo() {
            zzxs zzxsVar = ((zzyb) this.namesAndValues).zzn;
            if (zzxsVar == null) {
                return null;
            }
            zzxw zzxwVar = zzxsVar.zza;
            TooltipPopup tooltipPopup = zzxwVar == null ? null : new TooltipPopup(zzxwVar.zza, zzxwVar.zzb, zzxwVar.zzc, zzxwVar.zzd, zzxwVar.zze, zzxwVar.zzf, zzxwVar.zzg);
            String str = zzxsVar.zzb;
            String str2 = zzxsVar.zzc;
            zzxx[] zzxxVarArr = zzxsVar.zzd;
            ArrayList arrayList = new ArrayList();
            if (zzxxVarArr != null) {
                for (zzxx zzxxVar : zzxxVarArr) {
                    if (zzxxVar != null) {
                        arrayList.add(new Barcode.Phone(zzxxVar.zzb, zzxxVar.zza));
                    }
                }
            }
            zzxu[] zzxuVarArr = zzxsVar.zze;
            ArrayList arrayList2 = new ArrayList();
            if (zzxuVarArr != null) {
                for (zzxu zzxuVar : zzxuVarArr) {
                    if (zzxuVar != null) {
                        arrayList2.add(new Barcode.Email(zzxuVar.zza, zzxuVar.zzb, zzxuVar.zzc, zzxuVar.zzd));
                    }
                }
            }
            String[] strArr = zzxsVar.zzf;
            Object objAsList = strArr != null ? Arrays.asList(strArr) : new ArrayList();
            zzxp[] zzxpVarArr = zzxsVar.zzg;
            ArrayList arrayList3 = new ArrayList();
            if (zzxpVarArr != null) {
                for (zzxp zzxpVar : zzxpVarArr) {
                    if (zzxpVar != null) {
                        arrayList3.add(new Barcode.Address(zzxpVar.zza, zzxpVar.zzb));
                    }
                }
            }
            return new TooltipPopup(tooltipPopup, str, str2, arrayList, arrayList2, objAsList, arrayList3);
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public Point[] getCornerPoints() {
            return ((zzyb) this.namesAndValues).zze;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public Barcode.Email getEmail() {
            zzxu zzxuVar = ((zzyb) this.namesAndValues).zzg;
            if (zzxuVar == null) {
                return null;
            }
            return new Barcode.Email(zzxuVar.zza, zzxuVar.zzb, zzxuVar.zzc, zzxuVar.zzd);
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public int getFormat() {
            return ((zzyb) this.namesAndValues).zza;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public Barcode.GeoPoint getGeoPoint() {
            zzxv zzxvVar = ((zzyb) this.namesAndValues).zzl;
            if (zzxvVar != null) {
                return new Barcode.GeoPoint(zzxvVar.zza, zzxvVar.zzb);
            }
            return null;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public Barcode.Phone getPhone() {
            zzxx zzxxVar = ((zzyb) this.namesAndValues).zzh;
            if (zzxxVar != null) {
                return new Barcode.Phone(zzxxVar.zzb, zzxxVar.zza);
            }
            return null;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public byte[] getRawBytes() {
            return ((zzyb) this.namesAndValues).zzd;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public String getRawValue() {
            return ((zzyb) this.namesAndValues).zzc;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public GmsLogger getSms() {
            zzxy zzxyVar = ((zzyb) this.namesAndValues).zzi;
            if (zzxyVar != null) {
                return new GmsLogger(zzxyVar.zza, zzxyVar.zzb, false);
            }
            return null;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public GmsLogger getUrl() {
            zzxz zzxzVar = ((zzyb) this.namesAndValues).zzk;
            if (zzxzVar != null) {
                return new GmsLogger(zzxzVar.zza, zzxzVar.zzb, false);
            }
            return null;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public int getValueType() {
            return ((zzyb) this.namesAndValues).zzf;
        }

        @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
        public RoomOpenHelper getWifi() {
            zzya zzyaVar = ((zzyb) this.namesAndValues).zzj;
            if (zzyaVar == null) {
                return null;
            }
            return new RoomOpenHelper(zzyaVar.zzc, 12, zzyaVar.zza, zzyaVar.zzb);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            ((CountDownLatch) this.namesAndValues).countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            ((CountDownLatch) this.namesAndValues).countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(Object obj) {
            ((CountDownLatch) this.namesAndValues).countDown();
        }

        public void removeAll(String str) {
            ArrayList arrayList = (ArrayList) this.namesAndValues;
            int i = 0;
            while (i < arrayList.size()) {
                if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                    arrayList.remove(i);
                    arrayList.remove(i);
                    i -= 2;
                }
                i += 2;
            }
        }

        public void set(String str, String str2) {
            Companion.checkName(str);
            Companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
        }

        public /* synthetic */ Builder(zay zayVar, ApiFeatureRequest apiFeatureRequest) {
            this.$r8$classId = 5;
            this.namesAndValues = apiFeatureRequest;
        }

        public Builder(int i) {
            this.$r8$classId = i;
            switch (i) {
                case 6:
                    this.namesAndValues = new ConnectionPool(2);
                    break;
                case 7:
                    this.namesAndValues = new CountDownLatch(1);
                    break;
                case 16:
                    this.namesAndValues = new LinkedHashSet();
                    break;
                default:
                    this.namesAndValues = new ArrayList(20);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static ImageVector _clearAll;

        public static void checkName(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        public static void checkValue(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2));
                    sb.append(Util.isSensitiveHeader(str2) ? "" : ": ".concat(str));
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        public static Headers of(String... strArr) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr2[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i2] = StringsKt.trim(str).toString();
            }
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr2.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    String str2 = strArr2[i];
                    String str3 = strArr2[i + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            return new Headers(strArr2);
        }
    }

    public Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
        }
        return false;
    }

    public final String get(String str) {
        String[] strArr = this.namesAndValues;
        int length = strArr.length - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement > length) {
            return null;
        }
        while (!StringsKt__StringsJVMKt.equals(str, strArr[length], true)) {
            if (length == progressionLastElement) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final Date getDate(String str) {
        String str2 = get(str);
        if (str2 == null) {
            return null;
        }
        zzd zzdVar = DatesKt.STANDARD_DATE_FORMAT;
        if (str2.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat) DatesKt.STANDARD_DATE_FORMAT.get()).parse(str2, parsePosition);
        if (parsePosition.getIndex() == str2.length()) {
            return date;
        }
        String[] strArr = DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    DateFormat[] dateFormatArr = DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS;
                    DateFormat simpleDateFormat = dateFormatArr[i];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
                        simpleDateFormat.setTimeZone(Util.UTC);
                        dateFormatArr[i] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date date2 = simpleDateFormat.parse(str2, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return date2;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = new Pair(name(i), value(i));
        }
        return new UIntArray.Iterator(6, pairArr);
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final Builder newBuilder() {
        Builder builder = new Builder(0);
        ((ArrayList) builder.namesAndValues).addAll(Arrays.asList(this.namesAndValues));
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strName = name(i);
            String strValue = value(i);
            sb.append(strName);
            sb.append(": ");
            if (Util.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb.append(strValue);
            sb.append("\n");
        }
        return sb.toString();
    }

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }
}
