package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public enum zzra implements zzfc {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("TYPE_UNKNOWN"),
    zzb("TYPE_THIN"),
    zzc("TYPE_THICK"),
    /* JADX INFO: Fake field, exist only in values array */
    EF33("TYPE_GMV");

    public final int zzf;

    zzra(String str) {
        this.zzf = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzf;
    }
}
