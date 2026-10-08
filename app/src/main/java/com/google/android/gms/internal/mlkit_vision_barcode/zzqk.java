package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzqk {
    public final zzqi zza;
    public final Integer zzb;

    public /* synthetic */ zzqk(CacheStrategy cacheStrategy) {
        this.zza = (zzqi) cacheStrategy.networkRequest;
        this.zzb = (Integer) cacheStrategy.cacheResponse;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzqk)) {
            return false;
        }
        zzqk zzqkVar = (zzqk) obj;
        return com.google.android.gms.common.internal.zzah.equal(this.zza, zzqkVar.zza) && com.google.android.gms.common.internal.zzah.equal(this.zzb, zzqkVar.zzb) && com.google.android.gms.common.internal.zzah.equal(null, null) && com.google.android.gms.common.internal.zzah.equal(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, null, null});
    }
}
