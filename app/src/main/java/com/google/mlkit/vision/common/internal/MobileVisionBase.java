package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.vision.barcode.internal.zzl;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.ConnectionPool;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MobileVisionBase implements Closeable, LifecycleObserver {
    public static final GmsLogger zzb = new GmsLogger("MobileVisionBase", "");
    public final AtomicBoolean zzc = new AtomicBoolean(false);
    public final zzl zzd;
    public final Headers.Builder zze;
    public final Executor zzf;

    public MobileVisionBase(zzl zzlVar, Executor executor) {
        this.zzd = zzlVar;
        Headers.Builder builder = new Headers.Builder(6);
        this.zze = builder;
        this.zzf = executor;
        zzlVar.zza$1.incrementAndGet();
        zzw zzwVarCallAfterLoad = zzlVar.callAfterLoad(executor, zzb.zza, (ConnectionPool) builder.namesAndValues);
        zzc zzcVar = zzc.zza;
        zzwVarCallAfterLoad.getClass();
        zzwVarCallAfterLoad.addOnFailureListener(TaskExecutors.MAIN_THREAD, zzcVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.zzc.getAndSet(true)) {
            return;
        }
        this.zze.cancel();
        zzl zzlVar = this.zzd;
        Executor executor = this.zzf;
        if (zzlVar.zza$1.get() <= 0) {
            throw new IllegalStateException();
        }
        zzlVar.taskQueue.submit(new zzi(26, zzlVar, new TaskCompletionSource()), executor);
    }
}
