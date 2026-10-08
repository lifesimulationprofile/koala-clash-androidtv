package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zza {
    public final int zza;
    public Boolean zza$1;
    public final Bundle zzb;
    public boolean zzb$1;
    public final /* synthetic */ GmsClient zzc;
    public final /* synthetic */ GmsClient zzd;

    public zza(GmsClient gmsClient, int i, Bundle bundle) {
        this.zzc = gmsClient;
        Boolean bool = Boolean.TRUE;
        this.zzd = gmsClient;
        this.zza$1 = bool;
        this.zzb$1 = false;
        this.zza = i;
        this.zzb = bundle;
    }

    public abstract void zzb(ConnectionResult connectionResult);

    public abstract boolean zzd();

    public final void zzf() {
        synchronized (this) {
            this.zza$1 = null;
        }
    }

    public final void zzg() {
        zzf();
        synchronized (this.zzd.zzt) {
            this.zzd.zzt.remove(this);
        }
    }
}
