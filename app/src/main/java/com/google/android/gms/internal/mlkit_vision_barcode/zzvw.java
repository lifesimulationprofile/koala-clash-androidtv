package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public enum zzvw implements zzfc {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("UNRECOGNIZED"),
    zzb("CODE_128"),
    zzc("CODE_39"),
    zzd("CODE_93"),
    zze("CODABAR"),
    zzf("DATA_MATRIX"),
    zzg("EAN_13"),
    zzh("EAN_8"),
    zzi("ITF"),
    zzj("QR_CODE"),
    zzk("UPC_A"),
    zzl("UPC_E"),
    zzm("PDF417"),
    zzn("AZTEC"),
    /* JADX INFO: Fake field, exist only in values array */
    EF180("DATABAR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF197("TEZ_CODE");

    public final int zzr;

    zzvw(String str) {
        this.zzr = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzr;
    }
}
