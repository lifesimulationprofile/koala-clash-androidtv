package com.google.android.gms.common.internal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GmsLogger {
    public final String zza;
    public final String zzb;

    public /* synthetic */ GmsLogger(String str, String str2, boolean z) {
        this.zza = str;
        this.zzb = str2;
    }

    public String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }

    public GmsLogger(String str, String str2) {
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
