package com.google.android.gms.internal.mlkit_vision_common;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzej implements ObjectEncoder {
    public static final zzej zza = new zzej();
    public static final FieldDescriptor zzb = new FieldDescriptor("durationMs", Density.CC.m(Density.CC.m(zzai.class, new zzad(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("imageSource", Density.CC.m(Density.CC.m(zzai.class, new zzad(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("imageFormat", Density.CC.m(Density.CC.m(zzai.class, new zzad(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("imageByteSize", Density.CC.m(Density.CC.m(zzai.class, new zzad(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("imageWidth", Density.CC.m(Density.CC.m(zzai.class, new zzad(5))));
    public static final FieldDescriptor zzg = new FieldDescriptor("imageHeight", Density.CC.m(Density.CC.m(zzai.class, new zzad(6))));
    public static final FieldDescriptor zzh = new FieldDescriptor("rotationDegrees", Density.CC.m(Density.CC.m(zzai.class, new zzad(7))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        zziq zziqVar = (zziq) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zziqVar.zza);
        objectEncoderContext.add(zzc, zziqVar.zzb);
        objectEncoderContext.add(zzd, zziqVar.zzc);
        objectEncoderContext.add(zze, zziqVar.zzd);
        objectEncoderContext.add(zzf, zziqVar.zze);
        objectEncoderContext.add(zzg, zziqVar.zzf);
        objectEncoderContext.add(zzh, zziqVar.zzg);
    }
}
