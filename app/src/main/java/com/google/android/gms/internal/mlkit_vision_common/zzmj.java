package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzse;
import com.google.android.gms.internal.mlkit_common.zzsf;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzmj {
    public static zzu zza;
    public static final zzz zzb;
    public final String zzc;
    public final String zzd;
    public final zzmf zze;
    public final SharedPrefManager zzf;
    public final com.google.android.gms.tasks.zzw zzg;
    public final com.google.android.gms.tasks.zzw zzh;
    public final String zzi;
    public final int zzj;
    public final HashMap zzk = new HashMap();

    static {
        Object[] objArr = {"optional-module-barcode", "com.google.android.gms.vision.barcode"};
        objArr[0].getClass();
        objArr[1].getClass();
        zzb = new zzz(0, objArr);
    }

    public zzmj(Context context, SharedPrefManager sharedPrefManager, zzmf zzmfVar) {
        new HashMap();
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzmfVar;
        zzmw.zza();
        this.zzi = "vision-common";
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        zzse zzseVar = new zzse(3, this);
        mLTaskExecutor.getClass();
        this.zzg = MLTaskExecutor.scheduleCallable(zzseVar);
        MLTaskExecutor mLTaskExecutor2 = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        zzsf zzsfVar = new zzsf(sharedPrefManager, 2);
        mLTaskExecutor2.getClass();
        this.zzh = MLTaskExecutor.scheduleCallable(zzsfVar);
        zzz zzzVar = zzb;
        this.zzj = zzzVar.containsKey("vision-common") ? DynamiteModule.zza(context, (String) zzzVar.get("vision-common"), false) : -1;
    }
}
