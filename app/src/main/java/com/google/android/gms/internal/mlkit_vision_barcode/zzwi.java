package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import androidx.room.RoomOpenHelper;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzwi implements zzwf {
    public final ArrayList zza;

    public zzwi(Context context, zzwd zzwdVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.add(new zzwx(context, zzwdVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwf
    public final void zza(RoomOpenHelper roomOpenHelper) {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzwf) obj).zza(roomOpenHelper);
        }
    }
}
