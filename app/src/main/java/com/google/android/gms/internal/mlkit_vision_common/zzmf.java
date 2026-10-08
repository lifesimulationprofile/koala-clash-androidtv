package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import java.util.ArrayList;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzmf implements zzmc {
    public final ArrayList zza;

    public zzmf(Context context, zzma zzmaVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.add(new zzmp(context, zzmaVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmc
    public final void zza(CacheStrategy cacheStrategy) {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzmc) obj).zza(cacheStrategy);
        }
    }
}
