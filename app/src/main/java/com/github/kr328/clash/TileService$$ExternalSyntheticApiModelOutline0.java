package com.github.kr328.clash;

import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.internal.mlkit_common.zzav;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class TileService$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ LocaleList m(Object obj) {
        return (LocaleList) obj;
    }

    public static /* synthetic */ void m(zzav zzavVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || zzavVar != ForkJoinPool.commonPool()) && !(zIsTerminated = zzavVar.isTerminated())) {
            zzavVar.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = zzavVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        zzavVar.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
