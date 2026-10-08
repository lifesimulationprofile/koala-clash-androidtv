package com.google.mlkit.common;

import com.google.android.gms.common.internal.zzah;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MlKitException extends Exception {
    public final int zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MlKitException(String str, int i) {
        super(str);
        zzah.checkNotEmpty(str, "Provided message must not be empty.");
        this.zza = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MlKitException(String str, Exception exc) {
        super(str, exc);
        zzah.checkNotEmpty(str, "Provided message must not be empty.");
        this.zza = 13;
    }
}
