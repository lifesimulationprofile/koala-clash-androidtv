package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.ArraySet;
import coil.ImageLoader$Builder;
import coil.network.EmptyNetworkObserver;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zacd;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zag;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zah;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzw;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.util.Collections;
import java.util.Set;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApi {
    public final GoogleApiManager zaa;
    public final Context zab;
    public final String zac;
    public final CacheStrategy zad;
    public final Api$ApiOptions zae;
    public final ApiKey zaf;
    public final int zah;
    public final EmptyNetworkObserver zaj;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Settings {
        public static final Settings DEFAULT_SETTINGS = new Settings(new EmptyNetworkObserver(), Looper.getMainLooper());
        public final EmptyNetworkObserver zaa;

        public Settings(EmptyNetworkObserver emptyNetworkObserver, Looper looper) {
            this.zaa = emptyNetworkObserver;
        }
    }

    public GoogleApi(Context context, CacheStrategy cacheStrategy, Api$ApiOptions api$ApiOptions, Settings settings) {
        zzah.checkNotNull(context, "Null context is not permitted.");
        zzah.checkNotNull(cacheStrategy, "Api must not be null.");
        zzah.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        zzah.checkNotNull(applicationContext, "The provided context did not have an application context.");
        this.zab = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.zac = attributionTag;
        this.zad = cacheStrategy;
        this.zae = api$ApiOptions;
        this.zaf = new ApiKey(cacheStrategy, api$ApiOptions, attributionTag);
        GoogleApiManager googleApiManagerZak = GoogleApiManager.zak(applicationContext);
        this.zaa = googleApiManagerZak;
        this.zah = googleApiManagerZak.zal.getAndIncrement();
        this.zaj = settings.zaa;
        zau zauVar = googleApiManagerZak.zar;
        zauVar.sendMessage(zauVar.obtainMessage(7, this));
    }

    public final ImageLoader$Builder createClientSettingsBuilder() {
        ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(17);
        Set set = Collections.EMPTY_SET;
        if (((ArraySet) imageLoader$Builder.applicationContext) == null) {
            imageLoader$Builder.applicationContext = new ArraySet(0);
        }
        ((ArraySet) imageLoader$Builder.applicationContext).addAll(set);
        Context context = this.zab;
        imageLoader$Builder.options = context.getClass().getName();
        imageLoader$Builder.defaults = context.getPackageName();
        return imageLoader$Builder;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    public final zzw zae(int i, MinimalEncoder minimalEncoder) {
        zacd zacdVar;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        EmptyNetworkObserver emptyNetworkObserver = this.zaj;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        int i2 = minimalEncoder.ecLevel;
        if (i2 != 0) {
            ApiKey apiKey = this.zaf;
            if (googleApiManager.zaD()) {
                RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) zah.getInstance().zaa;
                boolean z = true;
                if (rootTelemetryConfiguration != null) {
                    if (rootTelemetryConfiguration.zzb) {
                        boolean z2 = rootTelemetryConfiguration.zzc;
                        zabq zabqVar = (zabq) googleApiManager.zan.get(apiKey);
                        if (zabqVar != null) {
                            Api$Client api$Client = zabqVar.zac;
                            if (api$Client instanceof GmsClient) {
                                GmsClient gmsClient = (GmsClient) api$Client;
                                if (gmsClient.zzD == null || gmsClient.isConnecting()) {
                                    z = z2;
                                } else {
                                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationZab = zacd.zab(zabqVar, gmsClient, i2);
                                    if (connectionTelemetryConfigurationZab != null) {
                                        zabqVar.zam++;
                                        z = connectionTelemetryConfigurationZab.zzc;
                                    }
                                }
                            }
                        } else {
                            z = z2;
                        }
                    }
                    zacdVar = null;
                }
                zacdVar = new zacd(googleApiManager, i2, apiKey, z ? System.currentTimeMillis() : 0L, z ? SystemClock.elapsedRealtime() : 0L);
            } else {
                zacdVar = null;
            }
            if (zacdVar != null) {
                zzw zzwVar = taskCompletionSource.zza;
                zau zauVar = googleApiManager.zar;
                zauVar.getClass();
                zabk zabkVar = new zabk(zauVar, 0);
                zzwVar.getClass();
                zzwVar.zzb.zza(new zzh(zabkVar, zacdVar));
                zzwVar.zzi();
            }
        }
        zach zachVar = new zach(new zag(i, minimalEncoder, taskCompletionSource, emptyNetworkObserver), googleApiManager.zam.get(), this);
        zau zauVar2 = googleApiManager.zar;
        zauVar2.sendMessage(zauVar2.obtainMessage(4, zachVar));
        return taskCompletionSource.zza;
    }
}
