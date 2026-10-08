package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzon implements ObjectEncoder {
    public static final zzon zza = new zzon();
    public static final FieldDescriptor zzb = new FieldDescriptor("appId", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("appVersion", Density.CC.m(Density.CC.m(zzfe.class, new zzez(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("firebaseProjectId", Density.CC.m(Density.CC.m(zzfe.class, new zzez(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("mlSdkVersion", Density.CC.m(Density.CC.m(zzfe.class, new zzez(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("tfliteSchemaVersion", Density.CC.m(Density.CC.m(zzfe.class, new zzez(5))));
    public static final FieldDescriptor zzg = new FieldDescriptor("gcmSenderId", Density.CC.m(Density.CC.m(zzfe.class, new zzez(6))));
    public static final FieldDescriptor zzh = new FieldDescriptor("apiKey", Density.CC.m(Density.CC.m(zzfe.class, new zzez(7))));
    public static final FieldDescriptor zzi = new FieldDescriptor("languages", Density.CC.m(Density.CC.m(zzfe.class, new zzez(8))));
    public static final FieldDescriptor zzj = new FieldDescriptor("mlSdkInstanceId", Density.CC.m(Density.CC.m(zzfe.class, new zzez(9))));
    public static final FieldDescriptor zzk = new FieldDescriptor("isClearcutClient", Density.CC.m(Density.CC.m(zzfe.class, new zzez(10))));
    public static final FieldDescriptor zzl = new FieldDescriptor("isStandaloneMlkit", Density.CC.m(Density.CC.m(zzfe.class, new zzez(11))));
    public static final FieldDescriptor zzm = new FieldDescriptor("isJsonLogging", Density.CC.m(Density.CC.m(zzfe.class, new zzez(12))));
    public static final FieldDescriptor zzn = new FieldDescriptor("buildLevel", Density.CC.m(Density.CC.m(zzfe.class, new zzez(13))));
    public static final FieldDescriptor zzo = new FieldDescriptor("optionalModuleVersion", Density.CC.m(Density.CC.m(zzfe.class, new zzez(14))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        zzvd zzvdVar = (zzvd) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zzvdVar.zza);
        objectEncoderContext.add(zzc, zzvdVar.zzb);
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, zzvdVar.zzc);
        objectEncoderContext.add(zzf, zzvdVar.zzd);
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, zzvdVar.zze);
        objectEncoderContext.add(zzj, zzvdVar.zzf);
        objectEncoderContext.add(zzk, zzvdVar.zzg);
        objectEncoderContext.add(zzl, zzvdVar.zzh);
        objectEncoderContext.add(zzm, zzvdVar.zzi);
        objectEncoderContext.add(zzn, zzvdVar.zzj);
        objectEncoderContext.add(zzo, zzvdVar.zzk);
    }
}
