package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import coil.network.EmptyNetworkObserver;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzw;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.util.Map;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zag extends zac {
    public final MinimalEncoder zaa;
    public final TaskCompletionSource zab;
    public final EmptyNetworkObserver zad;

    public zag(int i, MinimalEncoder minimalEncoder, TaskCompletionSource taskCompletionSource, EmptyNetworkObserver emptyNetworkObserver) {
        super(i);
        this.zab = taskCompletionSource;
        this.zaa = minimalEncoder;
        this.zad = emptyNetworkObserver;
        if (i == 2 && minimalEncoder.isGS1) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        return this.zaa.isGS1;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq zabqVar) {
        return (Feature[]) this.zaa.stringToEncode;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zad(Status status) {
        this.zad.getClass();
        this.zab.trySetException(status.zzd != null ? new ResolvableApiException(status) : new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zae(Exception exc) {
        this.zab.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        TaskCompletionSource taskCompletionSource = this.zab;
        try {
            MinimalEncoder minimalEncoder = this.zaa;
            ((RemoteCall) ((MinimalEncoder) minimalEncoder.encoders).stringToEncode).accept(zabqVar.zac, taskCompletionSource);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zad(zac.zah(e2));
        } catch (RuntimeException e3) {
            taskCompletionSource.trySetException(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zag(CacheStrategy cacheStrategy, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Map map = (Map) cacheStrategy.cacheResponse;
        TaskCompletionSource taskCompletionSource = this.zab;
        map.put(taskCompletionSource, boolValueOf);
        zzw zzwVar = taskCompletionSource.zza;
        CacheStrategy cacheStrategy2 = new CacheStrategy(8, cacheStrategy, taskCompletionSource, false);
        zzwVar.getClass();
        zzwVar.zzb.zza(new zzh(TaskExecutors.MAIN_THREAD, cacheStrategy2));
        zzwVar.zzi();
    }
}
