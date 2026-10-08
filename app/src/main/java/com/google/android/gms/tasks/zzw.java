package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzah;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzw {
    public final Object zza = new Object();
    public final zzr zzb;
    public boolean zzc;
    public volatile boolean zzd;
    public Object zze;
    public Exception zzf;

    public zzw() {
        zzr zzrVar = new zzr();
        zzrVar.zza = new Object();
        this.zzb = zzrVar;
    }

    public final void addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.zzb.zza(new zzh(executor, onFailureListener));
        zzi();
    }

    public final void addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        this.zzb.zza(new zzh(executor, onSuccessListener));
        zzi();
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    public final Object getResult() {
        Object obj;
        synchronized (this.zza) {
            try {
                zzah.checkState("Task is not yet complete", this.zzc);
                if (this.zzd) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.zzf;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            try {
                z = false;
                if (this.zzc && !this.zzd && this.zzf == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final void zza(Exception exc) {
        zzah.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zzb(this);
    }

    public final void zzb(Object obj) {
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zze = obj;
        }
        this.zzb.zzb(this);
    }

    public final void zzc() {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    return;
                }
                this.zzc = true;
                this.zzd = true;
                this.zzb.zzb(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zze(Object obj) {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    return false;
                }
                this.zzc = true;
                this.zze = obj;
                this.zzb.zzb(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzh() {
        String strConcat;
        if (this.zzc) {
            int i = ClosedSendChannelException.$r8$clinit;
            if (!isComplete()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception exception = getException();
            if (exception != null) {
                strConcat = "failure";
            } else if (isSuccessful()) {
                strConcat = "result ".concat(String.valueOf(getResult()));
            } else {
                strConcat = this.zzd ? "cancellation" : "unknown issue";
            }
        }
    }

    public final void zzi() {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    this.zzb.zzb(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
