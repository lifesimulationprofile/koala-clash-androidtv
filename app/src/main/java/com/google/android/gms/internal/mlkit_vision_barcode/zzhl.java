package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzhl implements ObjectEncoder {
    public static final zzhl zza = new zzhl();
    public static final FieldDescriptor zzb = new FieldDescriptor("errorCode", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("hasResult", Density.CC.m(Density.CC.m(zzfe.class, new zzez(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("isColdCall", Density.CC.m(Density.CC.m(zzfe.class, new zzez(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("imageInfo", Density.CC.m(Density.CC.m(zzfe.class, new zzez(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("options", Density.CC.m(Density.CC.m(zzfe.class, new zzez(5))));
    public static final FieldDescriptor zzg = new FieldDescriptor("detectedBarcodeFormats", Density.CC.m(Density.CC.m(zzfe.class, new zzez(6))));
    public static final FieldDescriptor zzh = new FieldDescriptor("detectedBarcodeValueTypes", Density.CC.m(Density.CC.m(zzfe.class, new zzez(7))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        zzft zzftVar = (zzft) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zzftVar.zza);
        objectEncoderContext.add(zzc, (Object) null);
        objectEncoderContext.add(zzd, zzftVar.zzc);
        objectEncoderContext.add(zze, (Object) null);
        objectEncoderContext.add(zzf, zzftVar.zze);
        objectEncoderContext.add(zzg, zzftVar.zzf);
        objectEncoderContext.add(zzh, zzftVar.zzg);
    }
}
