package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public enum zzro implements zzfc {
    zza("TYPE_UNKNOWN"),
    zzb("TYPE_CONTACT_INFO"),
    zzc("TYPE_EMAIL"),
    zzd("TYPE_ISBN"),
    zze("TYPE_PHONE"),
    zzf("TYPE_PRODUCT"),
    zzg("TYPE_SMS"),
    zzh("TYPE_TEXT"),
    zzi("TYPE_URL"),
    zzj("TYPE_WIFI"),
    zzk("TYPE_GEO"),
    zzl("TYPE_CALENDAR_EVENT"),
    zzm("TYPE_DRIVER_LICENSE");

    public final int zzo;

    zzro(String str) {
        this.zzo = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzo;
    }
}
