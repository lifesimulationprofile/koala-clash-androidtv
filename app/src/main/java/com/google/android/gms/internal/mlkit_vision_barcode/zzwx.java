package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import androidx.room.RoomOpenHelper;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzwx implements zzwf {
    public final Lazy zza;
    public final Lazy zzb;
    public final zzwd zzc;

    public zzwx(Context context, zzwd zzwdVar) {
        this.zzc = zzwdVar;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        ImageLoader$Builder imageLoader$BuilderNewFactory = TransportRuntime.getInstance().newFactory(cCTDestination);
        if (CCTDestination.SUPPORTED_ENCODINGS.contains(new Encoding("json"))) {
            this.zza = new Lazy(new com.google.android.gms.internal.mlkit_vision_common.zzmm(1, imageLoader$BuilderNewFactory));
        }
        this.zzb = new Lazy(new com.google.android.gms.internal.mlkit_vision_common.zzmm(2, imageLoader$BuilderNewFactory));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwf
    public final void zza(RoomOpenHelper roomOpenHelper) {
        int i = this.zzc.zzc;
        Priority priority = Priority.VERY_LOW;
        Priority priority2 = Priority.DEFAULT;
        if (i != 0) {
            ((TransportImpl) this.zzb.get()).send(roomOpenHelper.version != 0 ? new AutoValue_Event(roomOpenHelper.zze(i), priority2) : new AutoValue_Event(roomOpenHelper.zze(i), priority));
            return;
        }
        Lazy lazy = this.zza;
        if (lazy != null) {
            ((TransportImpl) lazy.get()).send(roomOpenHelper.version != 0 ? new AutoValue_Event(roomOpenHelper.zze(i), priority2) : new AutoValue_Event(roomOpenHelper.zze(i), priority));
        }
    }
}
