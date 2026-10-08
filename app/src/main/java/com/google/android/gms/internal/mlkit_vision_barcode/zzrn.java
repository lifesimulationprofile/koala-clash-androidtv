package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public enum zzrn implements zzfc {
    zza("FORMAT_UNKNOWN"),
    zzb("FORMAT_CODE_128"),
    zzc("FORMAT_CODE_39"),
    zzd("FORMAT_CODE_93"),
    zze("FORMAT_CODABAR"),
    zzf("FORMAT_DATA_MATRIX"),
    zzg("FORMAT_EAN_13"),
    zzh("FORMAT_EAN_8"),
    zzi("FORMAT_ITF"),
    zzj("FORMAT_QR_CODE"),
    zzk("FORMAT_UPC_A"),
    zzl("FORMAT_UPC_E"),
    zzm("FORMAT_PDF417"),
    zzn("FORMAT_AZTEC");

    public final int zzp;

    zzrn(String str) {
        this.zzp = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzp;
    }
}
