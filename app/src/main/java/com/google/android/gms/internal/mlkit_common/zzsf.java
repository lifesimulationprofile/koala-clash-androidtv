package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzsf implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SharedPrefManager zza;

    public /* synthetic */ zzsf(SharedPrefManager sharedPrefManager, int i) {
        this.$r8$classId = i;
        this.zza = sharedPrefManager;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.zza.getMlSdkInstanceId();
    }
}
