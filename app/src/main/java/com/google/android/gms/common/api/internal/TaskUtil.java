package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TaskUtil {
    public static void trySetResultOrApiException(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (status.zzb <= 0) {
            taskCompletionSource.zza.zze(obj);
        } else {
            taskCompletionSource.trySetException(status.zzd != null ? new ResolvableApiException(status) : new ApiException(status));
        }
    }
}
