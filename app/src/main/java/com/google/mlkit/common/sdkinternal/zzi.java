package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.zzah;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Runnable zza;

    public /* synthetic */ zzi(Runnable runnable, int i) {
        this.$r8$classId = i;
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Deque deque = (Deque) MlKitThreadPool.zza.get();
                zzah.checkNotNull(deque);
                Runnable runnable = this.zza;
                deque.add(runnable);
                if (deque.size() <= 1) {
                    do {
                        runnable.run();
                        deque.removeFirst();
                        runnable = (Runnable) deque.peekFirst();
                    } while (runnable != null);
                }
                break;
            default:
                MlKitThreadPool.zza.set(new ArrayDeque());
                this.zza.run();
                break;
        }
    }
}
