package com.google.mlkit.vision.barcode.internal;

import androidx.room.RoomOpenHelper;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzru;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwo;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zza implements zzwo {
    public zzrb zza;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwo
    public RoomOpenHelper zza() {
        Http2Connection.Builder builder = new Http2Connection.Builder();
        zzra zzraVar = zzb.zzf() ? zzra.zzc : zzra.zzb;
        zzrb zzrbVar = this.zza;
        builder.connectionName = zzraVar;
        zza zzaVar = new zza();
        zzaVar.zza = zzrbVar;
        builder.sink = new zzru(zzaVar);
        return new RoomOpenHelper(builder, 0);
    }
}
