package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.LazyKt__LazyJVMKt;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object zac = new Object();
    public static GoogleApiManager zad;
    public long zae;
    public boolean zaf;
    public TelemetryData zag;
    public zao zah;
    public final Context zai;
    public final GoogleApiAvailability zaj;
    public final CacheStrategy zak;
    public final AtomicInteger zal;
    public final AtomicInteger zam;
    public final ConcurrentHashMap zan;
    public final ArraySet zap;
    public final ArraySet zaq;
    public final zau zar;
    public volatile boolean zas;

    public GoogleApiManager(Context context, Looper looper) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        this.zae = 10000L;
        this.zaf = false;
        this.zal = new AtomicInteger(1);
        this.zam = new AtomicInteger(0);
        this.zan = new ConcurrentHashMap(5, 0.75f, 1);
        this.zap = new ArraySet(0);
        this.zaq = new ArraySet(0);
        this.zas = true;
        this.zai = context;
        zau zauVar = new zau(looper, this);
        Looper.getMainLooper();
        this.zar = zauVar;
        this.zaj = googleApiAvailability;
        this.zak = new CacheStrategy(12);
        PackageManager packageManager = context.getPackageManager();
        if (DeviceProperties.zzj == null) {
            DeviceProperties.zzj = Boolean.valueOf(Build.VERSION.SDK_INT >= 26 && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (DeviceProperties.zzj.booleanValue()) {
            this.zas = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static Status zaF(ApiKey apiKey, ConnectionResult connectionResult) {
        return new Status(17, "API: " + ((String) apiKey.zab.cacheResponse) + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult), connectionResult.zzc, connectionResult);
    }

    public static GoogleApiManager zak(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            try {
                if (zad == null) {
                    Looper looper = zzs.getOrStartHandlerThread().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = GoogleApiAvailability.zaa;
                    zad = new GoogleApiManager(applicationContext, looper);
                }
                googleApiManager = zad;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    /* JADX WARN: Code duplicated, block: B:165:0x033d  */
    /* JADX WARN: Code duplicated, block: B:167:0x0343  */
    /* JADX WARN: Code duplicated, block: B:169:0x036f  */
    /* JADX WARN: Code duplicated, block: B:171:0x0379  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v6 com.google.android.gms.common.api.internal.zabq, still in use, count: 2, list:
          (r2v6 com.google.android.gms.common.api.internal.zabq) from 0x0335: IGET (r2v6 com.google.android.gms.common.api.internal.zabq) A[WRAPPED] (LINE:822) com.google.android.gms.common.api.internal.zabq.zah int
          (r2v6 com.google.android.gms.common.api.internal.zabq) from 0x033b: PHI (r2 I:??) = (r2v3 com.google.android.gms.common.api.internal.zabq), (r2v6 com.google.android.gms.common.api.internal.zabq) binds: [B:163:0x033a, B:218:0x033b] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instruction units count: 1108
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.GoogleApiManager.handleMessage(android.os.Message):boolean");
    }

    public final boolean zaD() {
        if (this.zaf) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) com.google.android.gms.common.internal.zah.getInstance().zaa;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.zzb) {
            return false;
        }
        int i = ((SparseIntArray) this.zak.networkRequest).get(203400000, -1);
        return i == -1 || i == 0;
    }

    public final boolean zaE(ConnectionResult connectionResult, int i) {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        GoogleApiAvailability googleApiAvailability = this.zaj;
        Context context = this.zai;
        googleApiAvailability.getClass();
        synchronized (LazyKt__LazyJVMKt.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = LazyKt__LazyJVMKt.zza;
            if (context2 == null || (bool = LazyKt__LazyJVMKt.zzb) == null || context2 != applicationContext) {
                LazyKt__LazyJVMKt.zzb = null;
                if (Build.VERSION.SDK_INT >= 26) {
                    LazyKt__LazyJVMKt.zzb = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        LazyKt__LazyJVMKt.zzb = Boolean.TRUE;
                    } catch (ClassNotFoundException unused) {
                        LazyKt__LazyJVMKt.zzb = Boolean.FALSE;
                    }
                }
                LazyKt__LazyJVMKt.zza = applicationContext;
                zBooleanValue = LazyKt__LazyJVMKt.zzb.booleanValue();
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (!zBooleanValue) {
            int i2 = connectionResult.zzb;
            if ((i2 == 0 || connectionResult.zzc == null) ? false : true) {
                activity = connectionResult.zzc;
            } else {
                Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(i2, context, null);
                activity = errorResolutionIntent != null ? PendingIntent.getActivity(context, 0, errorResolutionIntent, 201326592) : null;
            }
            if (activity != null) {
                int i3 = connectionResult.zzb;
                int i4 = GoogleApiActivity.$r8$clinit;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                googleApiAvailability.zae(context, i3, PendingIntent.getActivity(context, 0, intent, zap.zaa | 134217728));
                return true;
            }
        }
        return false;
    }

    public final zabq zaG(GoogleApi googleApi) {
        ApiKey apiKey = googleApi.zaf;
        ConcurrentHashMap concurrentHashMap = this.zan;
        zabq zabqVar = (zabq) concurrentHashMap.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            concurrentHashMap.put(apiKey, zabqVar);
        }
        if (zabqVar.zac.requiresSignIn()) {
            this.zaq.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    public final void zax(ConnectionResult connectionResult, int i) {
        if (zaE(connectionResult, i)) {
            return;
        }
        zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(5, i, 0, connectionResult));
    }
}
