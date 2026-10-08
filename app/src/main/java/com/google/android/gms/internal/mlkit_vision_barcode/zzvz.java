package com.google.android.gms.internal.mlkit_vision_barcode;

import coil.memory.MemoryCacheService;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzvz {
    public final zzdk zza;

    public /* synthetic */ zzvz(MemoryCacheService memoryCacheService) {
        this.zza = (zzdk) memoryCacheService.imageLoader;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzvz) {
            return com.google.android.gms.common.internal.zzah.equal(this.zza, ((zzvz) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }
}
