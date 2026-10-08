package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.os.SystemClock;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzse;
import com.google.android.gms.internal.mlkit_vision_common.zzz;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzwp {
    public static zzdk zza;
    public static final zzz zzb;
    public final String zzc;
    public final String zzd;
    public final zzwi zze;
    public final SharedPrefManager zzf;
    public final zzw zzg;
    public final zzw zzh;
    public final String zzi;
    public final int zzj;
    public final HashMap zzk = new HashMap();
    public final HashMap zzl = new HashMap();

    static {
        Object[] objArr = {"optional-module-barcode", "com.google.android.gms.vision.barcode"};
        Objects.requireNonNull(objArr[0]);
        Objects.requireNonNull(objArr[1]);
        zzb = new zzz(1, objArr);
    }

    public zzwp(Context context, SharedPrefManager sharedPrefManager, zzwi zzwiVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzwiVar;
        zzxb.zza();
        this.zzi = str;
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        zzse zzseVar = new zzse(2, this);
        mLTaskExecutor.getClass();
        this.zzg = MLTaskExecutor.scheduleCallable(zzseVar);
        MLTaskExecutor mLTaskExecutor2 = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        com.google.android.gms.internal.mlkit_common.zzsf zzsfVar = new com.google.android.gms.internal.mlkit_common.zzsf(sharedPrefManager, 1);
        mLTaskExecutor2.getClass();
        this.zzh = MLTaskExecutor.scheduleCallable(zzsfVar);
        zzz zzzVar = zzb;
        this.zzj = zzzVar.containsKey(str) ? DynamiteModule.zza(context, (String) zzzVar.get(str), false) : -1;
    }

    public static long zza(ArrayList arrayList, double d) {
        return ((Long) arrayList.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) arrayList.size()))) - 1, 0))).longValue();
    }

    public final void zzf(zzwo zzwoVar, zzrc zzrcVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzrcVar, jElapsedRealtime)) {
            this.zzk.put(zzrcVar, Long.valueOf(jElapsedRealtime));
            com.google.mlkit.common.sdkinternal.zzh.zza.execute(new CascadingMenuPopup$3$1(this, zzwoVar.zza(), zzrcVar, zzj(), 2));
        }
    }

    public final String zzj() {
        zzw zzwVar = this.zzg;
        if (zzwVar.isSuccessful()) {
            return (String) zzwVar.getResult();
        }
        return LibraryVersion.zzb.getVersion(this.zzi);
    }

    public final boolean zzk(zzrc zzrcVar, long j) {
        HashMap map = this.zzk;
        return map.get(zzrcVar) == null || j - ((Long) map.get(zzrcVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }
}
