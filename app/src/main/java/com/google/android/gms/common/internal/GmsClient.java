package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import coil.memory.MemoryCacheService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.internal.base.zaa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class GmsClient implements Api$Client {
    public static final Feature[] zze = new Feature[0];
    public final Set zac;
    public volatile String zzA;
    public ConnectionResult zzB;
    public boolean zzC;
    public volatile zzk zzD;
    public zzv zza;
    public final zzb zzb;
    public BaseGmsClient$ConnectionProgressReportCallbacks zzc;
    public final AtomicInteger zzd;
    public volatile String zzk;
    public final Context zzl;
    public final zzs zzn;
    public final Object zzp;
    public final Object zzq;
    public zzad zzr;
    public IInterface zzs;
    public final ArrayList zzt;
    public zze zzu;
    public int zzv;
    public final zah zzw;
    public final zah zzx;
    public final int zzy;
    public final String zzz;

    public GmsClient(Context context, Looper looper, int i, Http2Connection.Builder builder, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        synchronized (zzs.zzb$1) {
            try {
                if (zzs.zzc$1 == null) {
                    zzs.zzc$1 = new zzs(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzs zzsVar = zzs.zzc$1;
        Object obj = GoogleApiAvailability.zaa;
        zzah.checkNotNull(connectionCallbacks);
        zzah.checkNotNull(onConnectionFailedListener);
        zah zahVar = new zah(connectionCallbacks);
        zah zahVar2 = new zah(onConnectionFailedListener);
        String str = (String) builder.source;
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        zzah.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        zzah.checkNotNull(looper, "Looper must not be null");
        zzah.checkNotNull(zzsVar, "Supervisor must not be null");
        this.zzn = zzsVar;
        this.zzb = new zzb(this, looper);
        this.zzy = i;
        this.zzw = zahVar;
        this.zzx = zahVar2;
        this.zzz = str;
        Set set = (Set) builder.socket;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.zac = set;
    }

    public static /* bridge */ /* synthetic */ void zzk(GmsClient gmsClient) {
        int i;
        int i2;
        synchronized (gmsClient.zzp) {
            i = gmsClient.zzv;
        }
        if (i == 3) {
            gmsClient.zzC = true;
            i2 = 5;
        } else {
            i2 = 4;
        }
        zzb zzbVar = gmsClient.zzb;
        zzbVar.sendMessage(zzbVar.obtainMessage(i2, gmsClient.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(GmsClient gmsClient, int i, int i2, IInterface iInterface) {
        synchronized (gmsClient.zzp) {
            try {
                if (gmsClient.zzv != i) {
                    return false;
                }
                gmsClient.zzp(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final void connect(BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks) {
        this.zzc = baseGmsClient$ConnectionProgressReportCallbacks;
        zzp(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    @Override // com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i = 0; i < size; i++) {
                    ((zza) this.zzt.get(i)).zzf();
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final Feature[] getAvailableFeatures() {
        zzk zzkVar = this.zzD;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzb;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final void getEndpointPackageName() {
        if (!isConnected() || this.zza == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final String getLastDisconnectMessage() {
        return this.zzk;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.Api$Client
    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = this.zzA;
        int i = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        int i2 = this.zzy;
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i2, i, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.zzl.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            getServiceRequest.zzj = new Account("<<default account>>", "com.google");
            if (iAccountAccessor != 0) {
                getServiceRequest.zzg = ((zaa) iAccountAccessor).zaa;
            }
        }
        getServiceRequest.zzk = zze;
        getServiceRequest.zzl = getApiFeatures();
        if (this instanceof zaz) {
            getServiceRequest.zzo = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    zzad zzadVar = this.zzr;
                    if (zzadVar != null) {
                        zzadVar.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i3 = this.zzd.get();
            zzb zzbVar = this.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(6, i3, 3));
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i4 = this.zzd.get();
            zzf zzfVar = new zzf(this, 8, null, null);
            zzb zzbVar2 = this.zzb;
            zzbVar2.sendMessage(zzbVar2.obtainMessage(1, i4, -1, zzfVar));
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i5 = this.zzd.get();
            zzf zzfVar2 = new zzf(this, 8, null, null);
            zzb zzbVar3 = this.zzb;
            zzbVar3.sendMessage(zzbVar3.obtainMessage(1, i5, -1, zzfVar2));
        }
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.EMPTY_SET;
    }

    public final IInterface getService() {
        IInterface iInterface;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                if (!isConnected()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.zzs;
                zzah.checkNotNull(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final void onUserSignOut(MemoryCacheService memoryCacheService) {
        ((zabq) memoryCacheService.imageLoader).zaa.zar.post(new com.google.android.gms.tasks.zzg(21, memoryCacheService));
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public boolean requiresSignIn() {
        return false;
    }

    public final void zzp(int i, IInterface iInterface) {
        zzv zzvVar;
        if ((i == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.zzp) {
            try {
                this.zzv = i;
                this.zzs = iInterface;
                if (i == 1) {
                    zze zzeVar = this.zzu;
                    if (zzeVar != null) {
                        zzs zzsVar = this.zzn;
                        String str = this.zza.zza;
                        zzah.checkNotNull(str);
                        this.zza.getClass();
                        if (this.zzz == null) {
                            this.zzl.getClass();
                        }
                        zzsVar.zzb(str, zzeVar, this.zza.zzc);
                        this.zzu = null;
                    }
                } else if (i == 2 || i == 3) {
                    zze zzeVar2 = this.zzu;
                    if (zzeVar2 != null && (zzvVar = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzvVar.zza + " on com.google.android.gms");
                        zzs zzsVar2 = this.zzn;
                        String str2 = this.zza.zza;
                        zzah.checkNotNull(str2);
                        this.zza.getClass();
                        if (this.zzz == null) {
                            this.zzl.getClass();
                        }
                        zzsVar2.zzb(str2, zzeVar2, this.zza.zzc);
                        this.zzd.incrementAndGet();
                    }
                    zze zzeVar3 = new zze(this, this.zzd.get());
                    this.zzu = zzeVar3;
                    String startServiceAction = getStartServiceAction();
                    boolean useDynamicLookup = getUseDynamicLookup();
                    this.zza = new zzv(startServiceAction, useDynamicLookup);
                    if (useDynamicLookup && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.zza)));
                    }
                    zzs zzsVar3 = this.zzn;
                    String str3 = this.zza.zza;
                    zzah.checkNotNull(str3);
                    this.zza.getClass();
                    String name = this.zzz;
                    if (name == null) {
                        name = this.zzl.getClass().getName();
                    }
                    if (!zzsVar3.zzc(new zzo(str3, this.zza.zzc), zzeVar3, name)) {
                        Log.w("GmsClient", "unable to connect to service: " + this.zza.zza + " on com.google.android.gms");
                        int i2 = this.zzd.get();
                        zzg zzgVar = new zzg(this, 16);
                        zzb zzbVar = this.zzb;
                        zzbVar.sendMessage(zzbVar.obtainMessage(7, i2, -1, zzgVar));
                    }
                } else if (i == 4) {
                    zzah.checkNotNull(iInterface);
                    System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
