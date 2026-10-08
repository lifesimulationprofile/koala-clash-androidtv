package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.SparseArray;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$ClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogEventEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.ConnectionPool;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CctTransportBackend implements TransportBackend {
    public final Context applicationContext;
    public final ConnectivityManager connectivityManager;
    public final ConnectionPool dataEncoder;
    public final URL endPoint;
    public final int readTimeout;
    public final Clock uptimeClock;
    public final Clock wallTimeClock;

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder autoBatchedLogRequestEncoder$BatchedLogRequestEncoder = AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(BatchedLogRequest.class, autoBatchedLogRequestEncoder$BatchedLogRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_BatchedLogRequest.class, autoBatchedLogRequestEncoder$BatchedLogRequestEncoder);
        AutoBatchedLogRequestEncoder$LogRequestEncoder autoBatchedLogRequestEncoder$LogRequestEncoder = AutoBatchedLogRequestEncoder$LogRequestEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogRequest.class, autoBatchedLogRequestEncoder$LogRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogRequest.class, autoBatchedLogRequestEncoder$LogRequestEncoder);
        AutoBatchedLogRequestEncoder$ClientInfoEncoder autoBatchedLogRequestEncoder$ClientInfoEncoder = AutoBatchedLogRequestEncoder$ClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(ClientInfo.class, autoBatchedLogRequestEncoder$ClientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_ClientInfo.class, autoBatchedLogRequestEncoder$ClientInfoEncoder);
        AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder autoBatchedLogRequestEncoder$AndroidClientInfoEncoder = AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(AndroidClientInfo.class, autoBatchedLogRequestEncoder$AndroidClientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_AndroidClientInfo.class, autoBatchedLogRequestEncoder$AndroidClientInfoEncoder);
        AutoBatchedLogRequestEncoder$LogEventEncoder autoBatchedLogRequestEncoder$LogEventEncoder = AutoBatchedLogRequestEncoder$LogEventEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogEvent.class, autoBatchedLogRequestEncoder$LogEventEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogEvent.class, autoBatchedLogRequestEncoder$LogEventEncoder);
        AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder = AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(NetworkConnectionInfo.class, autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_NetworkConnectionInfo.class, autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder);
        jsonDataEncoderBuilder.ignoreNullValues = true;
        this.dataEncoder = new ConnectionPool(jsonDataEncoderBuilder);
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = 40000;
    }

    public static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m("Invalid url: ", str), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00af  */
    /* JADX WARN: Code duplicated, block: B:30:0x0110  */
    public final AutoValue_EventInternal decorate(AutoValue_EventInternal autoValue_EventInternal) {
        int type;
        int subtype;
        HashMap map;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        Http2Connection.Builder builder = autoValue_EventInternal.toBuilder();
        int i = Build.VERSION.SDK_INT;
        HashMap map2 = (HashMap) builder.listener;
        if (map2 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map2.put("sdk-version", String.valueOf(i));
        builder.addMetadata("model", Build.MODEL);
        builder.addMetadata("hardware", Build.HARDWARE);
        builder.addMetadata("device", Build.DEVICE);
        builder.addMetadata("product", Build.PRODUCT);
        builder.addMetadata("os-uild", Build.ID);
        builder.addMetadata("manufacturer", Build.MANUFACTURER);
        builder.addMetadata("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        HashMap map3 = (HashMap) builder.listener;
        if (map3 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map3.put("tz-offset", String.valueOf(offset));
        int i2 = -1;
        if (activeNetworkInfo == null) {
            SparseArray sparseArray = NetworkConnectionInfo.NetworkType.valueMap;
            type = -1;
        } else {
            type = activeNetworkInfo.getType();
        }
        HashMap map4 = (HashMap) builder.listener;
        if (map4 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map4.put("net-type", String.valueOf(type));
        if (activeNetworkInfo != null) {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                SparseArray sparseArray2 = NetworkConnectionInfo.MobileSubtype.valueMap;
                subtype = 100;
            } else if (((NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.valueMap.get(subtype)) == null) {
            }
            map = (HashMap) builder.listener;
            if (map != null) {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
            map.put("mobile-subtype", String.valueOf(subtype));
            builder.addMetadata("country", Locale.getDefault().getCountry());
            builder.addMetadata("locale", Locale.getDefault().getLanguage());
            Context context = this.applicationContext;
            builder.addMetadata("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Unable to find version code for package", e);
            }
            builder.addMetadata("application_build", Integer.toString(i2));
            return builder.build();
        }
        SparseArray sparseArray3 = NetworkConnectionInfo.MobileSubtype.valueMap;
        subtype = 0;
        map = (HashMap) builder.listener;
        if (map != null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put("mobile-subtype", String.valueOf(subtype));
        builder.addMetadata("country", Locale.getDefault().getCountry());
        builder.addMetadata("locale", Locale.getDefault().getLanguage());
        Context context2 = this.applicationContext;
        builder.addMetadata("mcc_mnc", ((TelephonyManager) context2.getSystemService("phone")).getSimOperator());
        i2 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
        builder.addMetadata("application_build", Integer.toString(i2));
        return builder.build();
    }
}
