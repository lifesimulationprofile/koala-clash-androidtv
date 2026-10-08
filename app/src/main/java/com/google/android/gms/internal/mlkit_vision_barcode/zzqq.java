package com.google.android.gms.internal.mlkit_vision_barcode;

import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzqq {
    public final Long zza;
    public final zzrb zzb;
    public final Boolean zzc;
    public final Boolean zzd;
    public final Boolean zze;

    public /* synthetic */ zzqq(Request request) {
        this.zza = (Long) request.url;
        this.zzb = (zzrb) request.method;
        this.zzc = (Boolean) request.headers;
        this.zzd = (Boolean) request.tags;
        this.zze = (Boolean) request.lazyCacheControl;
    }
}
