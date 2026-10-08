package androidx.appcompat.widget;

import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.CameraProviderExecutionState;
import androidx.room.DatabaseConfiguration;
import coil.ImageLoader$Builder;
import coil.request.Parameters;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.internal.mlkit_vision_common.zzkl;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TooltipPopup {
    public Object mContentView;
    public Object mContext;
    public Object mLayoutParams;
    public Object mMessageView;
    public Object mTmpAnchorPos;
    public Object mTmpAppPos;
    public Object mTmpDisplayFrame;

    public /* synthetic */ TooltipPopup(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        this.mContext = obj;
        this.mContentView = obj2;
        this.mMessageView = obj3;
        this.mLayoutParams = obj4;
        this.mTmpDisplayFrame = obj5;
        this.mTmpAnchorPos = obj6;
        this.mTmpAppPos = obj7;
    }

    public void logAndUpdateState(AutoValue_TransportContext autoValue_TransportContext, int i) {
        Iterable iterable;
        AutoValue_BackendResponse autoValue_BackendResponse;
        String str;
        CameraProviderExecutionState cameraProviderExecutionStateApply;
        String str2;
        Integer numValueOf;
        TooltipPopup tooltipPopup;
        TransportBackend transportBackend = ((MetadataBackendRegistry) this.mContentView).get(autoValue_TransportContext.backendName);
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((SynchronizationGuard) this.mTmpAnchorPos);
        Iterable iterable2 = (Iterable) sQLiteEventStore.runCriticalSection(new CacheStrategy(5, this, autoValue_TransportContext));
        if (iterable2.iterator().hasNext()) {
            if (transportBackend == null) {
                zzkl.d("Uploader", "Unknown backend for %s, deleting event batch for it...", autoValue_TransportContext);
                autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                iterable = iterable2;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AutoValue_PersistedEvent) it.next()).event);
                }
                byte[] bArr = autoValue_TransportContext.extras;
                CctTransportBackend cctTransportBackend = (CctTransportBackend) transportBackend;
                HashMap map = new HashMap();
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj;
                    String str3 = autoValue_EventInternal.transportName;
                    if (map.containsKey(str3)) {
                        ((List) map.get(str3)).add(autoValue_EventInternal);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(autoValue_EventInternal);
                        map.put(str3, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    AutoValue_EventInternal autoValue_EventInternal2 = (AutoValue_EventInternal) ((List) entry.getValue()).get(i2);
                    QosTier qosTier = QosTier.DEFAULT;
                    long time = cctTransportBackend.wallTimeClock.getTime();
                    long time2 = cctTransportBackend.uptimeClock.getTime();
                    AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(new AutoValue_AndroidClientInfo(Integer.valueOf(autoValue_EventInternal2.getInteger("sdk-version")), autoValue_EventInternal2.get("model"), autoValue_EventInternal2.get("hardware"), autoValue_EventInternal2.get("device"), autoValue_EventInternal2.get("product"), autoValue_EventInternal2.get("os-uild"), autoValue_EventInternal2.get("manufacturer"), autoValue_EventInternal2.get("fingerprint"), autoValue_EventInternal2.get("locale"), autoValue_EventInternal2.get("country"), autoValue_EventInternal2.get("mcc_mnc"), autoValue_EventInternal2.get("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (AutoValue_EventInternal autoValue_EventInternal3 : (List) entry.getValue()) {
                        EncodedPayload encodedPayload = autoValue_EventInternal3.encodedPayload;
                        Encoding encoding = encodedPayload.encoding;
                        byte[] bArr2 = encodedPayload.bytes;
                        Iterable iterable3 = iterable2;
                        if (encoding.equals(new Encoding("proto"))) {
                            tooltipPopup = new TooltipPopup();
                            tooltipPopup.mLayoutParams = bArr2;
                        } else {
                            if (encoding.equals(new Encoding("json"))) {
                                String str4 = new String(bArr2, Charset.forName("UTF-8"));
                                TooltipPopup tooltipPopup2 = new TooltipPopup();
                                tooltipPopup2.mTmpDisplayFrame = str4;
                                tooltipPopup = tooltipPopup2;
                            } else {
                                Log.w("TransportRuntime.".concat("CctTransportBackend"), "Received event of unsupported encoding " + encoding + ". Skipping...");
                            }
                            iterable2 = iterable3;
                        }
                        tooltipPopup.mContext = Long.valueOf(autoValue_EventInternal3.eventMillis);
                        tooltipPopup.mMessageView = Long.valueOf(autoValue_EventInternal3.uptimeMillis);
                        String str5 = (String) autoValue_EventInternal3.autoMetadata.get("tz-offset");
                        tooltipPopup.mTmpAnchorPos = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        tooltipPopup.mTmpAppPos = new AutoValue_NetworkConnectionInfo((NetworkConnectionInfo.NetworkType) NetworkConnectionInfo.NetworkType.valueMap.get(autoValue_EventInternal3.getInteger("net-type")), (NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.valueMap.get(autoValue_EventInternal3.getInteger("mobile-subtype")));
                        Integer num = autoValue_EventInternal3.code;
                        if (num != null) {
                            tooltipPopup.mContentView = num;
                        }
                        String strM = ((Long) tooltipPopup.mContext) == null ? " eventTimeMs" : "";
                        if (((Long) tooltipPopup.mMessageView) == null) {
                            strM = strM.concat(" eventUptimeMs");
                        }
                        if (((Long) tooltipPopup.mTmpAnchorPos) == null) {
                            strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " timezoneOffsetSeconds");
                        }
                        if (!strM.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strM));
                        }
                        arrayList4.add(new AutoValue_LogEvent(((Long) tooltipPopup.mContext).longValue(), (Integer) tooltipPopup.mContentView, ((Long) tooltipPopup.mMessageView).longValue(), (byte[]) tooltipPopup.mLayoutParams, (String) tooltipPopup.mTmpDisplayFrame, ((Long) tooltipPopup.mTmpAnchorPos).longValue(), (AutoValue_NetworkConnectionInfo) tooltipPopup.mTmpAppPos));
                        iterable2 = iterable3;
                    }
                    arrayList3.add(new AutoValue_LogRequest(time, time2, autoValue_ClientInfo, numValueOf, str2, arrayList4));
                    i2 = 0;
                }
                iterable = iterable2;
                AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(arrayList3);
                URL urlOrThrow = cctTransportBackend.endPoint;
                if (bArr != null) {
                    try {
                        CCTDestination cCTDestinationFromByteArray = CCTDestination.fromByteArray(bArr);
                        str = cCTDestinationFromByteArray.apiKey;
                        if (str == null) {
                            str = null;
                        }
                        String str6 = cCTDestinationFromByteArray.endPoint;
                        if (str6 != null) {
                            urlOrThrow = CctTransportBackend.parseUrlOrThrow(str6);
                        }
                    } catch (IllegalArgumentException unused2) {
                        autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    int i4 = 8;
                    ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(urlOrThrow, autoValue_BatchedLogRequest, str, i4);
                    Parameters.Builder builder = new Parameters.Builder(29, cctTransportBackend);
                    int i5 = 5;
                    do {
                        cameraProviderExecutionStateApply = builder.apply(imageLoader$Builder);
                        URL url = (URL) cameraProviderExecutionStateApply.mCause;
                        if (url != null) {
                            zzkl.d("CctTransportBackend", "Following redirect to: %s", url);
                            imageLoader$Builder = new ImageLoader$Builder(url, (AutoValue_BatchedLogRequest) imageLoader$Builder.defaults, (String) imageLoader$Builder.options, i4);
                        } else {
                            imageLoader$Builder = null;
                        }
                        if (imageLoader$Builder == null) {
                            break;
                        } else {
                            i5--;
                        }
                    } while (i5 >= 1);
                    int i6 = cameraProviderExecutionStateApply.mStatus;
                    if (i6 == 200) {
                        autoValue_BackendResponse = new AutoValue_BackendResponse(1, cameraProviderExecutionStateApply.mTaskExecutedTimeInMillis);
                    } else if (i6 >= 500 || i6 == 404) {
                        autoValue_BackendResponse = new AutoValue_BackendResponse(2, -1L);
                    } else {
                        try {
                            autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                        } catch (IOException e) {
                            e = e;
                            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Could not make request to the backend", e);
                            autoValue_BackendResponse = new AutoValue_BackendResponse(2, -1L);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
            sQLiteEventStore.runCriticalSection(new DatabaseConfiguration(this, autoValue_BackendResponse, iterable, autoValue_TransportContext, i));
        }
    }
}
