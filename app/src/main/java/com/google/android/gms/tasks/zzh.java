package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzh implements zzq {
    public final Executor zza;
    public final Object zzc;
    public final /* synthetic */ int $r8$classId = 0;
    public final Object zzb = new Object();

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    private final void zzd$com$google$android$gms$tasks$zzh(zzw zzwVar) {
        if (zzwVar.zzd) {
            synchronized (this.zzb) {
            }
            this.zza.execute(new zzg(0, this));
        }
    }

    private final void zzd$com$google$android$gms$tasks$zzj(zzw zzwVar) {
        synchronized (this.zzb) {
        }
        this.zza.execute(new zzi(0, this, zzwVar, false));
    }

    private final void zzd$com$google$android$gms$tasks$zzl(zzw zzwVar) {
        if (zzwVar.isSuccessful() || zzwVar.zzd) {
            return;
        }
        synchronized (this.zzb) {
        }
        this.zza.execute(new zzi(14, this, zzwVar, false));
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(zzw zzwVar) {
        switch (this.$r8$classId) {
            case 0:
                zzd$com$google$android$gms$tasks$zzh(zzwVar);
                return;
            case 1:
                zzd$com$google$android$gms$tasks$zzj(zzwVar);
                return;
            case 2:
                zzd$com$google$android$gms$tasks$zzl(zzwVar);
                return;
            default:
                if (zzwVar.isSuccessful()) {
                    synchronized (this.zzb) {
                        break;
                    }
                    this.zza.execute(new zzi(15, this, zzwVar, false));
                    return;
                }
                return;
        }
    }

    public zzh(Executor executor, OnCompleteListener onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public zzh(Executor executor, OnFailureListener onFailureListener) {
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    public zzh(Executor executor, OnSuccessListener onSuccessListener) {
        this.zza = executor;
        this.zzc = onSuccessListener;
    }
}
