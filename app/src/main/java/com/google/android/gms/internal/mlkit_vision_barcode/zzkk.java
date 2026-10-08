package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzkk implements ObjectEncoder {
    public static final zzkk zza = new zzkk();
    public static final FieldDescriptor zzb = new FieldDescriptor("durationMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("errorCode", Density.CC.m(Density.CC.m(zzfe.class, new zzez(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("isColdCall", Density.CC.m(Density.CC.m(zzfe.class, new zzez(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("autoManageModelOnBackground", Density.CC.m(Density.CC.m(zzfe.class, new zzez(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("autoManageModelOnLowMemory", Density.CC.m(Density.CC.m(zzfe.class, new zzez(5))));
    public static final FieldDescriptor zzg = new FieldDescriptor("isNnApiEnabled", Density.CC.m(Density.CC.m(zzfe.class, new zzez(6))));
    public static final FieldDescriptor zzh = new FieldDescriptor("eventsCount", Density.CC.m(Density.CC.m(zzfe.class, new zzez(7))));
    public static final FieldDescriptor zzi = new FieldDescriptor("otherErrors", Density.CC.m(Density.CC.m(zzfe.class, new zzez(8))));
    public static final FieldDescriptor zzj = new FieldDescriptor("remoteConfigValueForAcceleration", Density.CC.m(Density.CC.m(zzfe.class, new zzez(9))));
    public static final FieldDescriptor zzk = new FieldDescriptor("isAccelerated", Density.CC.m(Density.CC.m(zzfe.class, new zzez(10))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        zzqq zzqqVar = (zzqq) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zzqqVar.zza);
        objectEncoderContext.add(zzc, zzqqVar.zzb);
        objectEncoderContext.add(zzd, zzqqVar.zzc);
        objectEncoderContext.add(zze, zzqqVar.zzd);
        objectEncoderContext.add(zzf, zzqqVar.zze);
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) null);
        objectEncoderContext.add(zzj, (Object) null);
        objectEncoderContext.add(zzk, (Object) null);
    }
}
