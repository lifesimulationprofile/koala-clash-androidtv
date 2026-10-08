package com.google.android.gms.common.api;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ApiException extends Exception {
    public final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    public ApiException(Status status) {
        int i = status.zzb;
        String str = status.zzc;
        super(i + ": " + (str == null ? "" : str));
        this.mStatus = status;
    }
}
