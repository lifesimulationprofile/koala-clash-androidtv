package okhttp3.internal.cache;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.view.PreviewView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import coil.ImageLoader$Builder;
import coil.util.ContinuationCallback;
import com.github.kr328.clash.remote.Resource$get$2$callback$1;
import com.github.kr328.clash.service.remote.IRemoteService;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.android.gms.internal.mlkit_vision_common.zzmw;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.mlkit.common.model.RemoteModelManager;
import fi.iki.elonen.NanoHTTPD;
import io.github.g00fy2.quickie.QROverlayView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.Headers;
import okhttp3.internal.http2.Http2Connection;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CacheStrategy implements Factory, SynchronizationGuard.CriticalSection, SQLiteEventStore.Function, OnCompleteListener, OnApplyWindowInsetsListener {
    public final /* synthetic */ int $r8$classId;
    public Object cacheResponse;
    public Object networkRequest;

    public /* synthetic */ CacheStrategy(int i, Object obj) {
        this.$r8$classId = i;
        this.cacheResponse = null;
        this.networkRequest = obj;
    }

    public void add(Object obj, String str) {
        ((ArrayList) this.networkRequest).add(ImageAnalysis$$ExternalSyntheticLambda1.m(str, "=", String.valueOf(obj)));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.networkRequest;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.cacheResponse;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        sQLiteEventStore.getClass();
        ArrayList arrayList = new ArrayList();
        Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, autoValue_TransportContext);
        if (transportContextId != null) {
            SQLiteEventStore.tryWithCursor(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{transportContextId.toString()}, null, null, null, String.valueOf(sQLiteEventStore.config.loadBatchSize)), new ImageLoader$Builder(sQLiteEventStore, arrayList, autoValue_TransportContext, 15));
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(((AutoValue_PersistedEvent) arrayList.get(i)).id);
            if (i < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        SQLiteEventStore.tryWithCursor(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new RemoteModelManager(map));
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) listIterator.next();
            long j = autoValue_PersistedEvent.id;
            if (map.containsKey(Long.valueOf(j))) {
                Http2Connection.Builder builder = autoValue_PersistedEvent.event.toBuilder();
                for (SQLiteEventStore.Metadata metadata : (Set) map.get(Long.valueOf(j))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(new AutoValue_PersistedEvent(j, autoValue_PersistedEvent.transportContext, builder.build()));
            }
        }
        return arrayList;
    }

    public void clear() {
        ArrayList arrayList = (ArrayList) this.cacheResponse;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NanoHTTPD.DefaultTempFile defaultTempFile = (NanoHTTPD.DefaultTempFile) obj;
            try {
                NanoHTTPD.safeClose(defaultTempFile.fstream);
                File file = defaultTempFile.file;
                if (!file.delete()) {
                    throw new Exception("could not delete temporary file: " + file.getAbsolutePath());
                }
            } catch (Exception e) {
                NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", (Throwable) e);
            }
        }
        arrayList.clear();
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        TooltipPopup tooltipPopup = (TooltipPopup) this.networkRequest;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.cacheResponse;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((EventStore) tooltipPopup.mMessageView);
        sQLiteEventStore.getClass();
        return (Iterable) sQLiteEventStore.inTransaction(new CacheStrategy(6, sQLiteEventStore, autoValue_TransportContext));
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new MetadataBackendRegistry((Context) ((ExposureStateImpl) this.networkRequest).mLock, (ImageLoader$Builder) ((Headers.Builder) this.cacheResponse).get());
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008a  */
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        Composer composer = (Composer) this.networkRequest;
        ViewUtils.RelativePadding relativePadding = (ViewUtils.RelativePadding) this.cacheResponse;
        int i = relativePadding.start;
        int i2 = relativePadding.end;
        int i3 = relativePadding.bottom;
        WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        Insets insets = impl.getInsets(519);
        Insets insets2 = impl.getInsets(32);
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) composer.writer;
        int i4 = insets.top;
        int i5 = insets.right;
        int i6 = insets.left;
        bottomSheetBehavior.insetTop = i4;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        boolean z2 = bottomSheetBehavior.paddingBottomSystemWindowInsets;
        if (z2) {
            int systemWindowInsetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
            bottomSheetBehavior.insetBottom = systemWindowInsetBottom;
            paddingBottom = systemWindowInsetBottom + i3;
        }
        if (bottomSheetBehavior.paddingLeftSystemWindowInsets) {
            paddingLeft = (zIsLayoutRtl ? i2 : i) + i6;
        }
        if (bottomSheetBehavior.paddingRightSystemWindowInsets) {
            if (!zIsLayoutRtl) {
                i = i2;
            }
            paddingRight = i + i5;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z3 = true;
        if (!bottomSheetBehavior.marginLeftSystemWindowInsets || marginLayoutParams.leftMargin == i6) {
            z = false;
        } else {
            marginLayoutParams.leftMargin = i6;
            z = true;
        }
        if (bottomSheetBehavior.marginRightSystemWindowInsets && marginLayoutParams.rightMargin != i5) {
            marginLayoutParams.rightMargin = i5;
            z = true;
        }
        if (bottomSheetBehavior.marginTopSystemWindowInsets) {
            int i7 = marginLayoutParams.topMargin;
            int i8 = insets.top;
            if (i7 != i8) {
                marginLayoutParams.topMargin = i8;
            } else {
                z3 = z;
            }
        } else {
            z3 = z;
        }
        if (z3) {
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z4 = composer.writingFirst;
        if (z4) {
            bottomSheetBehavior.gestureInsetBottom = insets2.bottom;
        }
        if (!z2 && !z4) {
            return windowInsetsCompat;
        }
        bottomSheetBehavior.updatePeekHeight();
        return windowInsetsCompat;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(zzw zzwVar) {
        ((Map) ((CacheStrategy) this.cacheResponse).cacheResponse).remove((TaskCompletionSource) this.networkRequest);
    }

    public void set(IRemoteService iRemoteService) {
        synchronized (this) {
            try {
                this.cacheResponse = iRemoteService;
                if (iRemoteService != null) {
                    Iterator it = ((LinkedHashSet) this.networkRequest).iterator();
                    while (it.hasNext()) {
                        ((Resource$get$2$callback$1) it.next()).$ctx.resumeWith(iRemoteService);
                    }
                    ((LinkedHashSet) this.networkRequest).clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 11:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.cacheResponse.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.networkRequest;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void zah(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.networkRequest)) {
            map = new HashMap((Map) this.networkRequest);
        }
        synchronized (((Map) this.cacheResponse)) {
            map2 = new HashMap((Map) this.cacheResponse);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    public /* synthetic */ CacheStrategy(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.networkRequest = obj;
        this.cacheResponse = obj2;
    }

    public /* synthetic */ CacheStrategy(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.cacheResponse = obj;
        this.networkRequest = obj2;
    }

    public CacheStrategy(Context context) {
        this.$r8$classId = 14;
        this.cacheResponse = new AtomicLong(-1L);
        this.networkRequest = new zao(context, zao.zae, new TelemetryLoggingOptions("mlkit:vision"), GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Object get(ContinuationImpl continuationImpl) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuationImpl));
        cancellableContinuationImpl.initCancellability();
        Resource$get$2$callback$1 resource$get$2$callback$1 = new Resource$get$2$callback$1(cancellableContinuationImpl);
        cancellableContinuationImpl.invokeOnCancellation(new ContinuationCallback(8, this, resource$get$2$callback$1));
        synchronized (this) {
            try {
                Object obj = this.cacheResponse;
                if (obj == null) {
                    ((LinkedHashSet) this.networkRequest).add(resource$get$2$callback$1);
                } else {
                    cancellableContinuationImpl.resumeWith(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cancellableContinuationImpl.getResult();
    }

    public CacheStrategy(ImageLoader$Builder imageLoader$Builder) {
        this.$r8$classId = 15;
        this.cacheResponse = new zzky();
        this.networkRequest = imageLoader$Builder;
        zzmw.zza();
    }

    public /* synthetic */ CacheStrategy(Object obj) {
        this.$r8$classId = 11;
        this.cacheResponse = obj;
        this.networkRequest = new ArrayList();
    }

    public CacheStrategy(String str, zaa zaaVar, Path.Companion companion) {
        this.$r8$classId = 7;
        this.cacheResponse = str;
        this.networkRequest = zaaVar;
    }

    public CacheStrategy(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 9:
                this.networkRequest = Collections.synchronizedMap(new WeakHashMap());
                this.cacheResponse = Collections.synchronizedMap(new WeakHashMap());
                break;
            case 12:
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
                this.networkRequest = new SparseIntArray();
                this.cacheResponse = googleApiAvailability;
                break;
            case 13:
                break;
            case 18:
                File file = new File(System.getProperty("java.io.tmpdir"));
                this.networkRequest = file;
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.cacheResponse = new ArrayList();
                break;
            default:
                this.networkRequest = new LinkedHashSet();
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:20:0x0059  */
    public CctBackendFactory get(String str) {
        Bundle bundle;
        Map map;
        Object obj;
        if (((Map) this.cacheResponse) == null) {
            Context context = (Context) this.networkRequest;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                    if (bundle == null) {
                        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                        map = Collections.EMPTY_MAP;
                    } else {
                        HashMap map2 = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            obj = bundle.get(str2);
                            if (!(obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String strTrim = str3.trim();
                                    if (!strTrim.isEmpty()) {
                                        map2.put(strTrim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        map = map2;
                    }
                    this.cacheResponse = map;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
            }
            bundle = null;
            if (bundle == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                map = Collections.EMPTY_MAP;
            } else {
                HashMap map3 = new HashMap();
                while (r6.hasNext()) {
                    obj = bundle.get(str2);
                    if (!(obj instanceof String)) {
                    }
                }
                map = map3;
            }
            this.cacheResponse = map;
        }
        String str4 = (String) ((Map) this.cacheResponse).get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str4).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            Log.w("BackendRegistry", "Class " + str4 + " is not found.", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e5);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CacheStrategy(CoroutineScope coroutineScope, Function2 function2) {
        this.$r8$classId = 2;
        this.networkRequest = (Service) coroutineScope;
        this.cacheResponse = (SuspendLambda) function2;
    }

    public CacheStrategy(FrameLayout frameLayout, QROverlayView qROverlayView, PreviewView previewView) {
        this.$r8$classId = 19;
        this.networkRequest = qROverlayView;
        this.cacheResponse = previewView;
    }
}
