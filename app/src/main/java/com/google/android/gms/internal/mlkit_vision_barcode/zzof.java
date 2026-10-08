package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzof implements ObjectEncoder {
    public static final zzof zza = new zzof();
    public static final FieldDescriptor zzb = new FieldDescriptor("xMin", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("yMin", Density.CC.m(Density.CC.m(zzfe.class, new zzez(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("xMax", Density.CC.m(Density.CC.m(zzfe.class, new zzez(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("yMax", Density.CC.m(Density.CC.m(zzfe.class, new zzez(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("confidenceScore", Density.CC.m(Density.CC.m(zzfe.class, new zzez(5))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        ((zzur) obj).getClass();
        objectEncoderContext.add(zzb, (Object) null);
        objectEncoderContext.add(zzc, (Object) null);
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) null);
        objectEncoderContext.add(zzf, (Object) null);
    }
}
