package com.google.android.gms.tasks;

import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Tasks {
    public static Object await(zzw zzwVar) throws InterruptedException {
        String name;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && ((name = looperMyLooper.getThread().getName()) == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler")))) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        if (zzwVar.isComplete()) {
            return zza(zzwVar);
        }
        Headers.Builder builder = new Headers.Builder(7);
        Executor executor = TaskExecutors.zza;
        zzwVar.addOnSuccessListener(executor, builder);
        zzwVar.addOnFailureListener(executor, builder);
        zzwVar.zzb.zza(new zzh(executor, (OnCanceledListener) builder));
        zzwVar.zzi();
        ((CountDownLatch) builder.namesAndValues).await();
        return zza(zzwVar);
    }

    public static Object zza(zzw zzwVar) throws ExecutionException {
        if (zzwVar.isSuccessful()) {
            return zzwVar.getResult();
        }
        if (zzwVar.zzd) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(zzwVar.getException());
    }
}
