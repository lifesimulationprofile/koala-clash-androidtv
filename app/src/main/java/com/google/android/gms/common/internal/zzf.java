package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzf extends zza {
    public final IBinder zze;
    public final /* synthetic */ GmsClient zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(GmsClient gmsClient, int i, IBinder iBinder, Bundle bundle) {
        super(gmsClient, i, bundle);
        this.zzf = gmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        zah zahVar = this.zzf.zzx;
        if (zahVar != null) {
            ((GoogleApiClient.OnConnectionFailedListener) zahVar.zaa).onConnectionFailed(connectionResult);
        }
        System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        IBinder iBinder = this.zze;
        try {
            zzah.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            GmsClient gmsClient = this.zzf;
            if (!gmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + gmsClient.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = gmsClient.createServiceInterface(iBinder);
            if (iInterfaceCreateServiceInterface == null || !(GmsClient.zzn(gmsClient, 2, 4, iInterfaceCreateServiceInterface) || GmsClient.zzn(gmsClient, 3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            gmsClient.zzB = null;
            zah zahVar = gmsClient.zzw;
            if (zahVar == null) {
                return true;
            }
            ((GoogleApiClient.ConnectionCallbacks) zahVar.zaa).onConnected();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
