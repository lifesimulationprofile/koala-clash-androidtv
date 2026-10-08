package com.google.mlkit.vision.barcode.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.room.DatabaseConfiguration;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdk;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;
import okio.AsyncTimeout;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class BarcodeRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        DatabaseConfiguration databaseConfigurationBuilder = Component.builder(zzi.class);
        databaseConfigurationBuilder.add(new Dependency(1, 0, MlKitContext.class));
        databaseConfigurationBuilder.typeConverters = new AsyncTimeout.Companion(19);
        Component componentBuild = databaseConfigurationBuilder.build();
        DatabaseConfiguration databaseConfigurationBuilder2 = Component.builder(zzg.class);
        databaseConfigurationBuilder2.add(new Dependency(1, 0, zzi.class));
        databaseConfigurationBuilder2.add(new Dependency(1, 0, ExecutorSelector.class));
        databaseConfigurationBuilder2.add(new Dependency(1, 0, MlKitContext.class));
        databaseConfigurationBuilder2.typeConverters = new ByteString.Companion(19);
        Component componentBuild2 = databaseConfigurationBuilder2.build();
        zzcq zzcqVar = zzcs.zza;
        Object[] objArr = {componentBuild, componentBuild2};
        for (int i = 0; i < 2; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(ImageAnalysis$$ExternalSyntheticLambda1.m("at index ", i));
            }
        }
        return new zzdk(2, objArr);
    }
}
