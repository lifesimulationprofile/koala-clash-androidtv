package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Objects;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzsh {
    public static final zzaq zzb = zzaq.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    public final String zzi;

    public zzsh(Context context, SharedPrefManager sharedPrefManager) {
        new HashMap();
        new HashMap();
        context.getPackageName();
        CommonUtils.getAppVersion(context);
        synchronized (Path.Companion.class) {
            if (Path.Companion.zza == null) {
                Path.Companion.zza = new Path.Companion();
            }
        }
        this.zzi = "common";
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        zzse zzseVar = new zzse(0, this);
        mLTaskExecutor.getClass();
        MLTaskExecutor.scheduleCallable(zzseVar);
        MLTaskExecutor mLTaskExecutor2 = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        zzsf zzsfVar = new zzsf(sharedPrefManager, 0);
        mLTaskExecutor2.getClass();
        MLTaskExecutor.scheduleCallable(zzsfVar);
        zzaq zzaqVar = zzb;
        if (zzaqVar.containsKey("common")) {
            DynamiteModule.zza(context, (String) zzaqVar.get("common"), false);
        }
    }
}
