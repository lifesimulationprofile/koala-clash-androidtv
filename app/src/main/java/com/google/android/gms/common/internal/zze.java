package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zze implements ServiceConnection {
    public final /* synthetic */ GmsClient zza;
    public final int zzb;

    public zze(GmsClient gmsClient, int i) {
        this.zza = gmsClient;
        this.zzb = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        GmsClient gmsClient = this.zza;
        if (iBinder == null) {
            GmsClient.zzk(gmsClient);
            return;
        }
        synchronized (gmsClient.zzq) {
            try {
                GmsClient gmsClient2 = this.zza;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                gmsClient2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzad)) ? new zzad(iBinder) : (zzad) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        GmsClient gmsClient3 = this.zza;
        int i = this.zzb;
        zzg zzgVar = new zzg(gmsClient3, 0);
        zzb zzbVar = gmsClient3.zzb;
        zzbVar.sendMessage(zzbVar.obtainMessage(7, i, -1, zzgVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        GmsClient gmsClient;
        synchronized (this.zza.zzq) {
            gmsClient = this.zza;
            gmsClient.zzr = null;
        }
        int i = this.zzb;
        zzb zzbVar = gmsClient.zzb;
        zzbVar.sendMessage(zzbVar.obtainMessage(6, i, 1));
    }
}
