package com.google.android.gms.internal.mlkit_vision_barcode;

import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzrr {
    public final zzqq zza;
    public final zzvz zzb;
    public final zzdk zzc;
    public final zzdk zzd;
    public final zzqk zze;

    public /* synthetic */ zzrr(Request request) {
        this.zza = (zzqq) request.url;
        this.zzb = (zzvz) request.method;
        this.zzc = (zzdk) request.headers;
        this.zzd = (zzdk) request.tags;
        this.zze = (zzqk) request.lazyCacheControl;
    }
}
