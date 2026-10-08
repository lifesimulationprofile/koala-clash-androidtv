package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.compose.ui.Modifier;
import androidx.core.provider.CallbackWrapper$2;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Api$Client zac;
    public final ApiKey zad;
    public final CacheStrategy zae;
    public final int zah;
    public final zact zai;
    public boolean zaj;
    public final LinkedList zab = new LinkedList();
    public final HashSet zaf = new HashSet();
    public final HashMap zag = new HashMap();
    public final ArrayList zak = new ArrayList();
    public ConnectionResult zal = null;
    public int zam = 0;

    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        Looper looper = googleApiManager.zar.getLooper();
        ImageLoader$Builder imageLoader$BuilderCreateClientSettingsBuilder = googleApi.createClientSettingsBuilder();
        Http2Connection.Builder builder = new Http2Connection.Builder((String) imageLoader$BuilderCreateClientSettingsBuilder.defaults, (String) imageLoader$BuilderCreateClientSettingsBuilder.options, (ArraySet) imageLoader$BuilderCreateClientSettingsBuilder.applicationContext);
        zaa zaaVar = (zaa) googleApi.zad.networkRequest;
        zzah.checkNotNull(zaaVar);
        Api$Client api$ClientBuildClient = zaaVar.buildClient(googleApi.zab, looper, builder, googleApi.zae, this, this);
        String str = googleApi.zac;
        if (str != null && (api$ClientBuildClient instanceof GmsClient)) {
            ((GmsClient) api$ClientBuildClient).zzA = str;
        }
        if (str != null && (api$ClientBuildClient instanceof NonGmsServiceBrokerClient)) {
            Modifier.CC.m(api$ClientBuildClient);
            throw null;
        }
        this.zac = api$ClientBuildClient;
        this.zad = googleApi.zaf;
        this.zae = new CacheStrategy(9);
        this.zah = googleApi.zah;
        if (!api$ClientBuildClient.requiresSignIn()) {
            this.zai = null;
            return;
        }
        Context context = googleApiManager.zai;
        zau zauVar = googleApiManager.zar;
        ImageLoader$Builder imageLoader$BuilderCreateClientSettingsBuilder2 = googleApi.createClientSettingsBuilder();
        this.zai = new zact(context, zauVar, new Http2Connection.Builder((String) imageLoader$BuilderCreateClientSettingsBuilder2.defaults, (String) imageLoader$BuilderCreateClientSettingsBuilder2.options, (ArraySet) imageLoader$BuilderCreateClientSettingsBuilder2.applicationContext));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected() {
        Looper looperMyLooper = Looper.myLooper();
        zau zauVar = this.zaa.zar;
        if (looperMyLooper == zauVar.getLooper()) {
            zaH();
        } else {
            zauVar.post(new zzg(20, this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Looper looperMyLooper = Looper.myLooper();
        zau zauVar = this.zaa.zar;
        if (looperMyLooper == zauVar.getLooper()) {
            zaI(i);
        } else {
            zauVar.post(new CallbackWrapper$2(i, 2, this));
        }
    }

    public final void zaD(ConnectionResult connectionResult) {
        HashSet hashSet = this.zaf;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (zzah.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                this.zac.getEndpointPackageName();
            }
            throw null;
        }
    }

    public final void zaE(Status status) {
        zzah.checkHandlerThread(this.zaa.zar);
        zaF(status, null, false);
    }

    public final void zaF(Status status, Exception exc, boolean z) {
        zzah.checkHandlerThread(this.zaa.zar);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.zab.iterator();
        while (it.hasNext()) {
            zac zacVar = (zac) it.next();
            if (!z || zacVar.zac == 2) {
                if (status != null) {
                    zacVar.zad(status);
                } else {
                    zacVar.zae(exc);
                }
                it.remove();
            }
        }
    }

    public final void zaG() {
        LinkedList linkedList = this.zab;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zac zacVar = (zac) arrayList.get(i);
            if (!this.zac.isConnected()) {
                return;
            }
            if (zaM(zacVar)) {
                linkedList.remove(zacVar);
            }
        }
    }

    public final void zaH() {
        GoogleApiManager googleApiManager = this.zaa;
        zzah.checkHandlerThread(googleApiManager.zar);
        this.zal = null;
        zaD(ConnectionResult.RESULT_SUCCESS);
        zau zauVar = googleApiManager.zar;
        if (this.zaj) {
            ApiKey apiKey = this.zad;
            zauVar.removeMessages(11, apiKey);
            zauVar.removeMessages(9, apiKey);
            this.zaj = false;
        }
        Iterator it = this.zag.values().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zaG();
        zaJ();
    }

    public final void zaI(int i) {
        GoogleApiManager googleApiManager = this.zaa;
        zau zauVar = googleApiManager.zar;
        zzah.checkHandlerThread(googleApiManager.zar);
        this.zal = null;
        this.zaj = true;
        String lastDisconnectMessage = this.zac.getLastDisconnectMessage();
        CacheStrategy cacheStrategy = this.zae;
        cacheStrategy.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        cacheStrategy.zah(true, new Status(20, sb.toString(), null, null));
        ApiKey apiKey = this.zad;
        zauVar.sendMessageDelayed(Message.obtain(zauVar, 9, apiKey), 5000L);
        zauVar.sendMessageDelayed(Message.obtain(zauVar, 11, apiKey), 120000L);
        ((SparseIntArray) googleApiManager.zak.networkRequest).clear();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            ((zaci) it.next()).getClass();
        }
    }

    public final void zaJ() {
        GoogleApiManager googleApiManager = this.zaa;
        zau zauVar = googleApiManager.zar;
        ApiKey apiKey = this.zad;
        zauVar.removeMessages(12, apiKey);
        zauVar.sendMessageDelayed(zauVar.obtainMessage(12, apiKey), googleApiManager.zae);
    }

    public final boolean zaM(zac zacVar) {
        Feature feature;
        if (zacVar == null) {
            CacheStrategy cacheStrategy = this.zae;
            Api$Client api$Client = this.zac;
            zacVar.zag(cacheStrategy, api$Client.requiresSignIn());
            try {
                zacVar.zaf(this);
                return true;
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                api$Client.disconnect("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Feature[] featureArrZab = zacVar.zab(this);
        if (featureArrZab == null || featureArrZab.length == 0) {
            feature = null;
            break;
        }
        Feature[] availableFeatures = this.zac.getAvailableFeatures();
        if (availableFeatures == null) {
            availableFeatures = new Feature[0];
        }
        ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
        for (Feature feature2 : availableFeatures) {
            arrayMap.put(feature2.zza, Long.valueOf(feature2.getVersion()));
        }
        int length = featureArrZab.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                feature = null;
                break;
            }
            feature = featureArrZab[i];
            Long l = (Long) arrayMap.get(feature.zza);
            if (l == null || l.longValue() < feature.getVersion()) {
                break;
            }
            i++;
        }
        if (feature == null) {
            CacheStrategy cacheStrategy2 = this.zae;
            Api$Client api$Client2 = this.zac;
            zacVar.zag(cacheStrategy2, api$Client2.requiresSignIn());
            try {
                zacVar.zaf(this);
                return true;
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                api$Client2.disconnect("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.zac.getClass().getName() + " could not execute call because it requires feature (" + feature.zza + ", " + feature.getVersion() + ").");
        if (!this.zaa.zas || !zacVar.zaa(this)) {
            zacVar.zae(new UnsupportedApiCallException(feature));
            return true;
        }
        zabs zabsVar = new zabs(this.zad, feature);
        int iIndexOf = this.zak.indexOf(zabsVar);
        if (iIndexOf >= 0) {
            zabs zabsVar2 = (zabs) this.zak.get(iIndexOf);
            this.zaa.zar.removeMessages(15, zabsVar2);
            zau zauVar = this.zaa.zar;
            zauVar.sendMessageDelayed(Message.obtain(zauVar, 15, zabsVar2), 5000L);
        } else {
            this.zak.add(zabsVar);
            zau zauVar2 = this.zaa.zar;
            zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 15, zabsVar), 5000L);
            zau zauVar3 = this.zaa.zar;
            zauVar3.sendMessageDelayed(Message.obtain(zauVar3, 16, zabsVar), 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!zaN(connectionResult)) {
                this.zaa.zaE(connectionResult, this.zah);
            }
        }
        return false;
    }

    public final boolean zaN(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.zac) {
        }
        return false;
    }

    public final void zao() {
        GoogleApiManager googleApiManager = this.zaa;
        zzah.checkHandlerThread(googleApiManager.zar);
        Api$Client api$Client = this.zac;
        if (api$Client.isConnected() || api$Client.isConnecting()) {
            return;
        }
        try {
            CacheStrategy cacheStrategy = googleApiManager.zak;
            Context context = googleApiManager.zai;
            SparseIntArray sparseIntArray = (SparseIntArray) cacheStrategy.networkRequest;
            zzah.checkNotNull(context);
            int minApkVersion = api$Client.getMinApkVersion();
            int iIsGooglePlayServicesAvailable = ((SparseIntArray) cacheStrategy.networkRequest).get(minApkVersion, -1);
            if (iIsGooglePlayServicesAvailable == -1) {
                iIsGooglePlayServicesAvailable = 0;
                int i = 0;
                while (true) {
                    if (i >= sparseIntArray.size()) {
                        iIsGooglePlayServicesAvailable = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i);
                    if (iKeyAt > minApkVersion && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (iIsGooglePlayServicesAvailable == -1) {
                    iIsGooglePlayServicesAvailable = ((GoogleApiAvailability) cacheStrategy.cacheResponse).isGooglePlayServicesAvailable(context, minApkVersion);
                }
                sparseIntArray.put(minApkVersion, iIsGooglePlayServicesAvailable);
            }
            if (iIsGooglePlayServicesAvailable != 0) {
                ConnectionResult connectionResult = new ConnectionResult(iIsGooglePlayServicesAvailable, null);
                Log.w("GoogleApiManager", "The service for " + api$Client.getClass().getName() + " is not available: " + connectionResult.toString());
                zar(connectionResult, null);
                return;
            }
            ZoomControl zoomControl = new ZoomControl(googleApiManager, api$Client, this.zad);
            if (api$Client.requiresSignIn()) {
                zact zactVar = this.zai;
                zzah.checkNotNull(zactVar);
                Handler handler = zactVar.zac;
                Http2Connection.Builder builder = zactVar.zaf;
                SignInClientImpl signInClientImpl = zactVar.zag;
                if (signInClientImpl != null) {
                    signInClientImpl.disconnect();
                }
                builder.listener = Integer.valueOf(System.identityHashCode(zactVar));
                zactVar.zag = (SignInClientImpl) zactVar.zad.buildClient(zactVar.zab, handler.getLooper(), builder, (SignInOptions) builder.sink, zactVar, zactVar);
                zactVar.zah = zoomControl;
                Set set = zactVar.zae;
                if (set == null || set.isEmpty()) {
                    handler.post(new zzg(22, zactVar));
                } else {
                    SignInClientImpl signInClientImpl2 = zactVar.zag;
                    signInClientImpl2.getClass();
                    signInClientImpl2.connect(new com.google.android.gms.common.internal.zah(signInClientImpl2));
                }
            }
            try {
                api$Client.connect(zoomControl);
            } catch (SecurityException e) {
                zar(new ConnectionResult(10), e);
            }
        } catch (IllegalStateException e2) {
            zar(new ConnectionResult(10), e2);
        }
    }

    public final void zap(zac zacVar) {
        zzah.checkHandlerThread(this.zaa.zar);
        boolean zIsConnected = this.zac.isConnected();
        LinkedList linkedList = this.zab;
        if (zIsConnected) {
            if (zaM(zacVar)) {
                zaJ();
                return;
            } else {
                linkedList.add(zacVar);
                return;
            }
        }
        linkedList.add(zacVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult == null || connectionResult.zzb == 0 || connectionResult.zzc == null) {
            zao();
        } else {
            zar(connectionResult, null);
        }
    }

    public final void zar(ConnectionResult connectionResult, RuntimeException runtimeException) {
        SignInClientImpl signInClientImpl;
        zzah.checkHandlerThread(this.zaa.zar);
        zact zactVar = this.zai;
        if (zactVar != null && (signInClientImpl = zactVar.zag) != null) {
            signInClientImpl.disconnect();
        }
        zzah.checkHandlerThread(this.zaa.zar);
        this.zal = null;
        ((SparseIntArray) this.zaa.zak.networkRequest).clear();
        zaD(connectionResult);
        if ((this.zac instanceof zap) && connectionResult.zzb != 24) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zaf = true;
            zau zauVar = googleApiManager.zar;
            zauVar.sendMessageDelayed(zauVar.obtainMessage(19), 300000L);
        }
        if (connectionResult.zzb == 4) {
            zaE(GoogleApiManager.zab);
            return;
        }
        if (this.zab.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (runtimeException != null) {
            zzah.checkHandlerThread(this.zaa.zar);
            zaF(null, runtimeException, false);
            return;
        }
        if (!this.zaa.zas) {
            zaE(GoogleApiManager.zaF(this.zad, connectionResult));
            return;
        }
        zaF(GoogleApiManager.zaF(this.zad, connectionResult), null, true);
        if (this.zab.isEmpty() || zaN(connectionResult) || this.zaa.zaE(connectionResult, this.zah)) {
            return;
        }
        if (connectionResult.zzb == 18) {
            this.zaj = true;
        }
        if (!this.zaj) {
            zaE(GoogleApiManager.zaF(this.zad, connectionResult));
            return;
        }
        GoogleApiManager googleApiManager2 = this.zaa;
        ApiKey apiKey = this.zad;
        zau zauVar2 = googleApiManager2.zar;
        zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 9, apiKey), 5000L);
    }

    public final void zas(ConnectionResult connectionResult) {
        zzah.checkHandlerThread(this.zaa.zar);
        Api$Client api$Client = this.zac;
        api$Client.disconnect("onSignInFailed for " + api$Client.getClass().getName() + " with " + String.valueOf(connectionResult));
        zar(connectionResult, null);
    }

    public final void zav() {
        zzah.checkHandlerThread(this.zaa.zar);
        Status status = GoogleApiManager.zaa;
        zaE(status);
        this.zae.zah(false, status);
        for (ListenerHolder$ListenerKey listenerHolder$ListenerKey : (ListenerHolder$ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder$ListenerKey[0])) {
            zap(new zah(listenerHolder$ListenerKey, new TaskCompletionSource()));
        }
        zaD(new ConnectionResult(4));
        Api$Client api$Client = this.zac;
        if (api$Client.isConnected()) {
            api$Client.onUserSignOut(new MemoryCacheService(27, this));
        }
    }
}
