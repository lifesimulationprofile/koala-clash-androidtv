package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzd extends zab {
    public GmsClient zza;
    public final int zzb;

    public zzd(GmsClient gmsClient, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 1);
        this.zza = gmsClient;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zza(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int i2 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
            zzc.zzb(parcel);
            zzah.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            GmsClient gmsClient = this.zza;
            int i3 = this.zzb;
            gmsClient.getClass();
            zzf zzfVar = new zzf(gmsClient, i2, strongBinder, bundle);
            zzb zzbVar = gmsClient.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(1, i3, -1, zzfVar));
            this.zza = null;
        } else if (i == 2) {
            parcel.readInt();
            zzc.zzb(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i4 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) zzc.zza(parcel, zzk.CREATOR);
            zzc.zzb(parcel);
            GmsClient gmsClient2 = this.zza;
            zzah.checkNotNull(gmsClient2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            zzah.checkNotNull(zzkVar);
            gmsClient2.zzD = zzkVar;
            if (gmsClient2 instanceof zaz) {
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.zzd;
                zah zahVar = zah.getInstance();
                RootTelemetryConfiguration rootTelemetryConfiguration = connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza;
                synchronized (zahVar) {
                    try {
                        if (rootTelemetryConfiguration == null) {
                            rootTelemetryConfiguration = zah.zzb;
                        } else {
                            RootTelemetryConfiguration rootTelemetryConfiguration2 = (RootTelemetryConfiguration) zahVar.zaa;
                            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.zza < rootTelemetryConfiguration.zza) {
                            }
                        }
                        zahVar.zaa = rootTelemetryConfiguration;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            Bundle bundle2 = zzkVar.zza;
            zzah.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            GmsClient gmsClient3 = this.zza;
            int i5 = this.zzb;
            gmsClient3.getClass();
            zzf zzfVar2 = new zzf(gmsClient3, i4, strongBinder2, bundle2);
            zzb zzbVar2 = gmsClient3.zzb;
            zzbVar2.sendMessage(zzbVar2.obtainMessage(1, i5, -1, zzfVar2));
            this.zza = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
