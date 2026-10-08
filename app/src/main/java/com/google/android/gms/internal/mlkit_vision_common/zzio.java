package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public enum zzio implements zzag {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("SOURCE_UNKNOWN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("BITMAP"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("BYTEARRAY"),
    /* JADX INFO: Fake field, exist only in values array */
    EF6("BYTEBUFFER"),
    /* JADX INFO: Fake field, exist only in values array */
    EF8("FILEPATH"),
    zzf("ANDROID_MEDIA_IMAGE");

    public final int zzh;

    zzio(String str) {
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzag
    public final int zza() {
        return this.zzh;
    }
}
