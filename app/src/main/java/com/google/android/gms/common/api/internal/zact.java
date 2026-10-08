package com.google.android.gms.common.api.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.camera2.internal.ZoomControl;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.signin.internal.zaf;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.zzi;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.internal.http2.Http2Connection;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final zaa zaa = zad.zac;
    public final Context zab;
    public final Handler zac;
    public final zaa zad;
    public final Set zae;
    public final Http2Connection.Builder zaf;
    public SignInClientImpl zag;
    public ZoomControl zah;

    public zact(Context context, zau zauVar, Http2Connection.Builder builder) {
        super("com.google.android.gms.signin.internal.ISignInCallbacks", 0);
        this.zab = context;
        this.zac = zauVar;
        this.zaf = builder;
        this.zae = (Set) builder.taskRunner;
        this.zad = zaa;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected() {
        GoogleSignInAccount googleSignInAccountZab;
        SignInClientImpl signInClientImpl = this.zag;
        signInClientImpl.getClass();
        int i = 12;
        try {
            signInClientImpl.zac.getClass();
            Account account = new Account("<<default account>>", "com.google");
            if ("<<default account>>".equals(account.name)) {
                Context context = signInClientImpl.zzl;
                ReentrantLock reentrantLock = Storage.zaa;
                zzah.checkNotNull(context);
                ReentrantLock reentrantLock2 = Storage.zaa;
                reentrantLock2.lock();
                try {
                    if (Storage.zab == null) {
                        Storage.zab = new Storage(context.getApplicationContext());
                    }
                    Storage storage = Storage.zab;
                    reentrantLock2.unlock();
                    String strZaa = storage.zaa("defaultGoogleSignInAccount");
                    if (!TextUtils.isEmpty(strZaa)) {
                        String strZaa2 = storage.zaa("googleSignInAccount:" + strZaa);
                        if (strZaa2 != null) {
                            try {
                                googleSignInAccountZab = GoogleSignInAccount.zab(strZaa2);
                            } catch (JSONException unused) {
                                googleSignInAccountZab = null;
                            }
                        }
                    }
                    googleSignInAccountZab = null;
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            } else {
                googleSignInAccountZab = null;
            }
            Integer num = signInClientImpl.zae;
            zzah.checkNotNull(num);
            zat zatVar = new zat(2, account, num.intValue(), googleSignInAccountZab);
            zaf zafVar = (zaf) signInClientImpl.getService();
            zai zaiVar = new zai(1, zatVar);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(zafVar.zab);
            com.google.android.gms.internal.base.zac.zac(parcelObtain, zaiVar);
            parcelObtain.writeStrongBinder(this);
            zafVar.zac(parcelObtain, 12);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.zac.post(new zzi(i, this, new zak(1, new ConnectionResult(8, null), null), false));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zah.zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        ZoomControl zoomControl = this.zah;
        zabq zabqVar = (zabq) ((GoogleApiManager) zoomControl.mCaptureResultListener).zan.get((ApiKey) zoomControl.mCurrentZoomState);
        if (zabqVar != null) {
            if (zabqVar.zaj) {
                zabqVar.zas(new ConnectionResult(17));
            } else {
                zabqVar.onConnectionSuspended(i);
            }
        }
    }
}
