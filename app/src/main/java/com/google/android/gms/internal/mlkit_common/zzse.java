package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.internal.mlkit_vision_common.zzmj;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzse implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    public /* synthetic */ zzse(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                zzsh zzshVar = (zzsh) this.zza;
                zzshVar.getClass();
                return LibraryVersion.zzb.getVersion(zzshVar.zzi);
            case 1:
                ((Runnable) this.zza).run();
                return null;
            case 2:
                zzwp zzwpVar = (zzwp) this.zza;
                zzwpVar.getClass();
                return LibraryVersion.zzb.getVersion(zzwpVar.zzi);
            default:
                zzmj zzmjVar = (zzmj) this.zza;
                zzmjVar.getClass();
                return LibraryVersion.zzb.getVersion(zzmjVar.zzi);
        }
    }
}
