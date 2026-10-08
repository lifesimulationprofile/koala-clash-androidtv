package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.core.provider.RequestExecutor$DefaultThreadFactory;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzu implements Executor {
    public static volatile zzu sExecutor;
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public /* synthetic */ zzu(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ((zau) this.zza).post(runnable);
                return;
            case 1:
                ((ExecutorService) this.zza).execute(runnable);
                return;
            case 2:
                Handler handler = (Handler) this.zza;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                ((Executor) this.zza).execute(new SequentialExecutor.AnonymousClass1(runnable, 1));
                return;
        }
    }

    public zzu(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.zza = Executors.newSingleThreadExecutor(new RequestExecutor$DefaultThreadFactory(1));
                break;
            default:
                zau zauVar = new zau(Looper.getMainLooper());
                Looper.getMainLooper();
                this.zza = zauVar;
                break;
        }
    }
}
