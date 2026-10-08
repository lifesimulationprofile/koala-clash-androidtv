package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzb extends zau {
    public final /* synthetic */ GmsClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(GmsClient gmsClient, Looper looper) {
        super(looper, 1);
        this.zza = gmsClient;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        if (this.zza.zzd.get() != message.arg1) {
            int i = message.what;
            if (i == 2 || i == 1 || i == 7) {
                zza zzaVar = (zza) message.obj;
                zzaVar.getClass();
                zzaVar.zzg();
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || i2 == 4 || i2 == 5) && !this.zza.isConnecting()) {
            zza zzaVar2 = (zza) message.obj;
            zzaVar2.getClass();
            zzaVar2.zzg();
            return;
        }
        int i3 = message.what;
        if (i3 == 4) {
            GmsClient gmsClient = this.zza;
            gmsClient.zzB = new ConnectionResult(message.arg2);
            if (!gmsClient.zzC && !TextUtils.isEmpty(gmsClient.getServiceDescriptor()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(gmsClient.getServiceDescriptor());
                    GmsClient gmsClient2 = this.zza;
                    if (!gmsClient2.zzC) {
                        gmsClient2.zzp(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            GmsClient gmsClient3 = this.zza;
            ConnectionResult connectionResult = gmsClient3.zzB;
            if (connectionResult == null) {
                connectionResult = new ConnectionResult(8);
            }
            gmsClient3.zzc.onReportServiceBinding(connectionResult);
            System.currentTimeMillis();
            return;
        }
        if (i3 == 5) {
            GmsClient gmsClient4 = this.zza;
            ConnectionResult connectionResult2 = gmsClient4.zzB;
            if (connectionResult2 == null) {
                connectionResult2 = new ConnectionResult(8);
            }
            gmsClient4.zzc.onReportServiceBinding(connectionResult2);
            System.currentTimeMillis();
            return;
        }
        if (i3 == 3) {
            Object obj = message.obj;
            this.zza.zzc.onReportServiceBinding(new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i3 == 6) {
            this.zza.zzp(5, null);
            zah zahVar = this.zza.zzw;
            if (zahVar != null) {
                ((GoogleApiClient.ConnectionCallbacks) zahVar.zaa).onConnectionSuspended(message.arg2);
            }
            System.currentTimeMillis();
            GmsClient.zzn(this.zza, 5, 1, null);
            return;
        }
        if (i3 == 2 && !this.zza.isConnected()) {
            zza zzaVar3 = (zza) message.obj;
            zzaVar3.getClass();
            zzaVar3.zzg();
            return;
        }
        int i4 = message.what;
        if (i4 != 2 && i4 != 1 && i4 != 7) {
            Log.wtf("GmsClient", ImageAnalysis$$ExternalSyntheticLambda1.m("Don't know how to handle message: ", i4), new Exception());
            return;
        }
        zza zzaVar4 = (zza) message.obj;
        synchronized (zzaVar4) {
            try {
                bool = zzaVar4.zza$1;
                if (zzaVar4.zzb$1) {
                    Log.w("GmsClient", "Callback proxy " + zzaVar4.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            GmsClient gmsClient5 = zzaVar4.zzc;
            int i5 = zzaVar4.zza;
            if (i5 != 0) {
                gmsClient5.zzp(1, null);
                Bundle bundle = zzaVar4.zzb;
                zzaVar4.zzb(new ConnectionResult(i5, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!zzaVar4.zzd()) {
                gmsClient5.zzp(1, null);
                zzaVar4.zzb(new ConnectionResult(8, null));
            }
        }
        synchronized (zzaVar4) {
            zzaVar4.zzb$1 = true;
        }
        zzaVar4.zzg();
    }
}
