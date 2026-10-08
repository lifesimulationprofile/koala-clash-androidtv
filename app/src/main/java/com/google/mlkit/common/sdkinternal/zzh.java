package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzh implements Executor {
    public static final zzh zza;
    public static final /* synthetic */ zzh[] zzb;

    static {
        zzh zzhVar = new zzh("INSTANCE", 0);
        zza = zzhVar;
        zzb = new zzh[]{zzhVar};
    }

    public static zzh[] values() {
        return (zzh[]) zzb.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        MLTaskExecutor.getInstance().zzc.post(runnable);
    }
}
