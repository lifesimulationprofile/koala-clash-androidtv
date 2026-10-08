package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ApiKey {
    public final int zaa;
    public final CacheStrategy zab;
    public final Api$ApiOptions zac;
    public final String zad;

    public ApiKey(CacheStrategy cacheStrategy, Api$ApiOptions api$ApiOptions, String str) {
        this.zab = cacheStrategy;
        this.zac = api$ApiOptions;
        this.zad = str;
        this.zaa = Arrays.hashCode(new Object[]{cacheStrategy, api$ApiOptions, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return zzah.equal(this.zab, apiKey.zab) && zzah.equal(this.zac, apiKey.zac) && zzah.equal(this.zad, apiKey.zad);
    }

    public final int hashCode() {
        return this.zaa;
    }
}
