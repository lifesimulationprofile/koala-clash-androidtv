package com.google.android.gms.internal.mlkit_vision_barcode;

import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzrf {
    public final zzvd zza;
    public final zzrc zzb;
    public final zzra zzc;
    public final zzrr zzd;
    public final zzru zze;
    public final zzfv zzf;

    public /* synthetic */ zzrf(Http2Connection.Builder builder) {
        this.zza = (zzvd) builder.taskRunner;
        this.zzb = (zzrc) builder.socket;
        this.zzc = (zzra) builder.connectionName;
        this.zzd = (zzrr) builder.source;
        this.zze = (zzru) builder.sink;
        this.zzf = (zzfv) builder.listener;
    }
}
