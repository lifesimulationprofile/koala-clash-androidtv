package com.google.mlkit.common.sdkinternal;

import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzw;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import okhttp3.ConnectionPool;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzm implements Executor {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public final Object zzb;
    public final Object zzc;
    public Object zzd;

    public /* synthetic */ zzm(Executor executor, ConnectionPool connectionPool, Headers.Builder builder, TaskCompletionSource taskCompletionSource) {
        this.$r8$classId = 0;
        this.zza = executor;
        this.zzb = connectionPool;
        this.zzc = builder;
        this.zzd = taskCompletionSource;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                try {
                    ((Executor) this.zza).execute(runnable);
                    return;
                } catch (RuntimeException e) {
                    if (((zzw) ((ConnectionPool) this.zzb).delegate).isComplete()) {
                        ((Headers.Builder) this.zzc).cancel();
                    } else {
                        ((TaskCompletionSource) this.zzd).zza.zza(e);
                    }
                    throw e;
                }
            default:
                synchronized (this.zza) {
                    try {
                        ((ArrayDeque) this.zzb).add(new Preview$$ExternalSyntheticLambda1(2, this, runnable));
                        if (((Runnable) this.zzd) == null) {
                            scheduleNext();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    public void scheduleNext() {
        synchronized (this.zza) {
            try {
                Runnable runnable = (Runnable) ((ArrayDeque) this.zzb).poll();
                this.zzd = runnable;
                if (runnable != null) {
                    ((zzt) this.zzc).execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzm(zzt zztVar) {
        this.$r8$classId = 1;
        this.zza = new Object();
        this.zzb = new ArrayDeque();
        this.zzc = zztVar;
    }
}
