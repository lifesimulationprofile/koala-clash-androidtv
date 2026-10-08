package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzah;
import okhttp3.ConnectionPool;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TaskCompletionSource {
    public final zzw zza = new zzw();

    public TaskCompletionSource() {
    }

    public final boolean trySetException(Exception exc) {
        zzw zzwVar = this.zza;
        zzwVar.getClass();
        zzah.checkNotNull(exc, "Exception must not be null");
        synchronized (zzwVar.zza) {
            try {
                if (zzwVar.zzc) {
                    return false;
                }
                zzwVar.zzc = true;
                zzwVar.zzf = exc;
                zzwVar.zzb.zzb(zzwVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public TaskCompletionSource(ConnectionPool connectionPool) {
        Headers.Builder builder = new Headers.Builder(8, this);
        connectionPool.getClass();
        ((zzw) connectionPool.delegate).addOnSuccessListener(TaskExecutors.MAIN_THREAD, new ConnectionPool(builder));
    }
}
