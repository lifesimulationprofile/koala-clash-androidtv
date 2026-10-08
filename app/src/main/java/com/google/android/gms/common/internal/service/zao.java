package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.zzw;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import okhttp3.Headers;
import okhttp3.internal.cache.CacheStrategy;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zao extends GoogleApi {
    public static final CacheStrategy zae = new CacheStrategy("ClientTelemetry.API", new zaa(1), new Path.Companion());

    public final zzw log(TelemetryData telemetryData) {
        MinimalEncoder minimalEncoder = new MinimalEncoder();
        minimalEncoder.ecLevel = 0;
        minimalEncoder.encoders = new Feature[]{zaf.zaa};
        minimalEncoder.isGS1 = false;
        minimalEncoder.stringToEncode = new Headers.Builder(4, telemetryData);
        return zae(2, minimalEncoder.build());
    }
}
