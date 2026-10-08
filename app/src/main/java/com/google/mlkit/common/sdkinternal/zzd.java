package com.google.mlkit.common.sdkinternal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzd extends PhantomReference {
    public final Set zza;
    public final zza zzb;

    public /* synthetic */ zzd(Cleaner cleaner, ReferenceQueue referenceQueue, Set set, zza zzaVar) {
        super(cleaner, referenceQueue);
        this.zza = set;
        this.zzb = zzaVar;
    }
}
