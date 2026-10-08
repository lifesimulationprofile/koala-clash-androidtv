package com.google.photos.vision.barhopper;

import androidx.camera.core.AspectRatio;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzd implements zzel {
    public final /* synthetic */ int $r8$classId;
    public static final zzd zza$1 = new zzd(1);
    public static final zzd zza$2 = new zzd(2);
    public static final zzd zza = new zzd(0);
    public static final zzd zza$3 = new zzd(3);
    public static final zzd zza$4 = new zzd(4);

    public /* synthetic */ zzd(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final boolean zza(int i) {
        switch (this.$r8$classId) {
            case 0:
                return zze.zza(i) != 0;
            case 1:
                return i == 0 || i == 1 || i == 2;
            case 2:
                return i == 0 || i == 1 || i == 2 || i == 3 || i == 4;
            case 3:
                return AspectRatio.zza(i) != 0;
            default:
                return i == 0 || i == 1 || i == 2;
        }
    }
}
