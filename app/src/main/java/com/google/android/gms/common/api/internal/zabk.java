package com.google.android.gms.common.api.internal;

import android.os.Handler;
import androidx.camera.core.CameraExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zabk implements Executor {
    public static volatile zabk sExecutor;
    public final /* synthetic */ int $r8$classId;
    public final Object zaa;

    public /* synthetic */ zabk(Handler handler, int i) {
        this.$r8$classId = i;
        this.zaa = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ((Handler) this.zaa).post(runnable);
                return;
            case 1:
                Handler handler = (Handler) this.zaa;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                ((ExecutorService) this.zaa).execute(runnable);
                return;
        }
    }

    public zabk() {
        this.$r8$classId = 2;
        this.zaa = Executors.newFixedThreadPool(2, new CameraExecutor.AnonymousClass1(2));
    }
}
