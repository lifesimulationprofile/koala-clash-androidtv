package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzp implements OnSuccessListener, OnFailureListener, OnCanceledListener, zzq {
    public final Executor zza;
    public final zzw zzc;

    public zzp(Executor executor, Path.Companion companion, zzw zzwVar) {
        this.zza = executor;
        this.zzc = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.zzc.zzc();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.zzc.zzb(obj);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(zzw zzwVar) {
        this.zza.execute(new zzi(16, this, zzwVar, false));
    }
}
