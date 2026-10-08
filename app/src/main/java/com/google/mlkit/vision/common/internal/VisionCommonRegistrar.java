package com.google.mlkit.vision.common.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.room.DatabaseConfiguration;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.android.gms.internal.mlkit_vision_common.zzu;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class VisionCommonRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        DatabaseConfiguration databaseConfigurationBuilder = Component.builder(zzc.class);
        databaseConfigurationBuilder.add(new Dependency(2, 0, BarcodeScanning.class));
        databaseConfigurationBuilder.typeConverters = zzc.zza$1;
        Object[] objArr = {databaseConfigurationBuilder.build()};
        for (int i = 0; i < 1; i++) {
            zzn zznVar = zzp.zza;
            if (objArr[i] == null) {
                throw new NullPointerException(ImageAnalysis$$ExternalSyntheticLambda1.m("at index ", i));
            }
        }
        zzn zznVar2 = zzp.zza;
        return new zzu(1, objArr);
    }
}
