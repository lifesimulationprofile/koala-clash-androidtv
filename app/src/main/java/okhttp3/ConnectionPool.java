package okhttp3;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.TooltipPopup;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_barcode.zzi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionPool implements OnSuccessListener, AccessibilityViewCommand, BarcodeSource {
    public final Object delegate;

    public /* synthetic */ ConnectionPool(Object obj) {
        this.delegate = obj;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Rect getBoundingBox() {
        zzu zzuVar = (zzu) this.delegate;
        if (zzuVar.zze == null) {
            return null;
        }
        int i = 0;
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = zzuVar.zze;
            if (i >= pointArr.length) {
                return new Rect(iMin, iMin2, iMax, iMax2);
            }
            Point point = pointArr[i];
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
            i++;
        }
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public TooltipPopup getCalendarEvent() {
        zzk zzkVar = ((zzu) this.delegate).zzl;
        if (zzkVar == null) {
            return null;
        }
        String str = zzkVar.zza;
        String str2 = zzkVar.zzb;
        String str3 = zzkVar.zzc;
        String str4 = zzkVar.zzd;
        String str5 = zzkVar.zze;
        zzj zzjVar = zzkVar.zzf;
        Barcode.CalendarDateTime calendarDateTime = zzjVar == null ? null : new Barcode.CalendarDateTime(zzjVar.zza, zzjVar.zzb, zzjVar.zzc, zzjVar.zzd, zzjVar.zze, zzjVar.zzf, zzjVar.zzg);
        zzj zzjVar2 = zzkVar.zzg;
        return new TooltipPopup(str, str2, str3, str4, str5, calendarDateTime, zzjVar2 == null ? null : new Barcode.CalendarDateTime(zzjVar2.zza, zzjVar2.zzb, zzjVar2.zzc, zzjVar2.zzd, zzjVar2.zze, zzjVar2.zzf, zzjVar2.zzg));
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public TooltipPopup getContactInfo() {
        zzl zzlVar = ((zzu) this.delegate).zzm;
        if (zzlVar == null) {
            return null;
        }
        zzp zzpVar = zzlVar.zza;
        TooltipPopup tooltipPopup = zzpVar == null ? null : new TooltipPopup(zzpVar.zza, zzpVar.zzb, zzpVar.zzc, zzpVar.zzd, zzpVar.zze, zzpVar.zzf, zzpVar.zzg);
        String str = zzlVar.zzb;
        String str2 = zzlVar.zzc;
        zzq[] zzqVarArr = zzlVar.zzd;
        ArrayList arrayList = new ArrayList();
        if (zzqVarArr != null) {
            for (zzq zzqVar : zzqVarArr) {
                if (zzqVar != null) {
                    arrayList.add(new Barcode.Phone(zzqVar.zzb, zzqVar.zza));
                }
            }
        }
        zzn[] zznVarArr = zzlVar.zze;
        ArrayList arrayList2 = new ArrayList();
        if (zznVarArr != null) {
            for (zzn zznVar : zznVarArr) {
                if (zznVar != null) {
                    arrayList2.add(new Barcode.Email(zznVar.zza, zznVar.zzb, zznVar.zzc, zznVar.zzd));
                }
            }
        }
        String[] strArr = zzlVar.zzf;
        Object objAsList = strArr != null ? Arrays.asList(strArr) : new ArrayList();
        zzi[] zziVarArr = zzlVar.zzg;
        ArrayList arrayList3 = new ArrayList();
        if (zziVarArr != null) {
            for (zzi zziVar : zziVarArr) {
                if (zziVar != null) {
                    arrayList3.add(new Barcode.Address(zziVar.zza, zziVar.zzb));
                }
            }
        }
        return new TooltipPopup(tooltipPopup, str, str2, arrayList, arrayList2, objAsList, arrayList3);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Point[] getCornerPoints() {
        return ((zzu) this.delegate).zze;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.Email getEmail() {
        zzn zznVar = ((zzu) this.delegate).zzf;
        if (zznVar != null) {
            return new Barcode.Email(zznVar.zza, zznVar.zzb, zznVar.zzc, zznVar.zzd);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public int getFormat() {
        return ((zzu) this.delegate).zza;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.GeoPoint getGeoPoint() {
        zzo zzoVar = ((zzu) this.delegate).zzk;
        if (zzoVar != null) {
            return new Barcode.GeoPoint(zzoVar.zza, zzoVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.Phone getPhone() {
        zzq zzqVar = ((zzu) this.delegate).zzg;
        if (zzqVar != null) {
            return new Barcode.Phone(zzqVar.zzb, zzqVar.zza);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public byte[] getRawBytes() {
        return ((zzu) this.delegate).zzo;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public String getRawValue() {
        return ((zzu) this.delegate).zzb;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public GmsLogger getSms() {
        zzr zzrVar = ((zzu) this.delegate).zzh;
        if (zzrVar != null) {
            return new GmsLogger(zzrVar.zza, zzrVar.zzb, false);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public GmsLogger getUrl() {
        zzs zzsVar = ((zzu) this.delegate).zzj;
        if (zzsVar != null) {
            return new GmsLogger(zzsVar.zza, zzsVar.zzb, false);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public int getValueType() {
        return ((zzu) this.delegate).zzd;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public RoomOpenHelper getWifi() {
        zzt zztVar = ((zzu) this.delegate).zzi;
        if (zztVar == null) {
            return null;
        }
        return new RoomOpenHelper(zztVar.zzc, 12, zztVar.zza, zztVar.zzb);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((TaskCompletionSource) ((Headers.Builder) this.delegate).namesAndValues).zza.zzc();
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.delegate;
        if (!swipeDismissBehavior.canSwipeDismissView(view)) {
            return false;
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.swipeDirection;
        view.offsetLeftAndRight((!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    public ConnectionPool(int i) {
        switch (i) {
            case 2:
                this.delegate = new zzw();
                break;
            case 10:
                MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                this.delegate = new MutableScatterSet();
                break;
            case 11:
                this.delegate = new ConcurrentHashMap(16);
                break;
            default:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                this.delegate = new RealConnectionPool(TaskRunner.INSTANCE);
                break;
        }
    }

    public ConnectionPool(Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda1) {
        this.delegate = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), util$$ExternalSyntheticLambda1);
    }
}
