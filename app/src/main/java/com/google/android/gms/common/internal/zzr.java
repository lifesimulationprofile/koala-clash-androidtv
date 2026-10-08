package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzr implements Handler.Callback {
    public final /* synthetic */ zzs zza;

    public /* synthetic */ zzr(zzs zzsVar) {
        this.zza = zzsVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zza.zzb) {
                try {
                    zzo zzoVar = (zzo) message.obj;
                    zzp zzpVar = (zzp) this.zza.zzb.get(zzoVar);
                    if (zzpVar != null && zzpVar.zzb.isEmpty()) {
                        if (zzpVar.zzd) {
                            zzpVar.zza.zzd.removeMessages(1, zzpVar.zzf);
                            zzs zzsVar = zzpVar.zza;
                            zzsVar.zzf.unbindService(zzsVar.zzc, zzpVar);
                            zzpVar.zzd = false;
                            zzpVar.zzc = 2;
                        }
                        this.zza.zzb.remove(zzoVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.zza.zzb) {
            try {
                zzo zzoVar2 = (zzo) message.obj;
                zzp zzpVar2 = (zzp) this.zza.zzb.get(zzoVar2);
                if (zzpVar2 != null && zzpVar2.zzc == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(zzoVar2)), new Exception());
                    ComponentName componentName = zzpVar2.zzg;
                    if (componentName == null) {
                        zzoVar2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = zzoVar2.zzc;
                        zzah.checkNotNull(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    zzpVar2.onServiceDisconnected(componentName);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}
