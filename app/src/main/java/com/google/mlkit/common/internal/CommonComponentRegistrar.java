package com.google.mlkit.common.internal;

import androidx.room.DatabaseConfiguration;
import coil.network.EmptyNetworkObserver;
import com.google.android.gms.dynamite.zze;
import com.google.android.gms.internal.mlkit_common.zzad;
import com.google.android.gms.internal.mlkit_common.zzaf;
import com.google.android.gms.internal.mlkit_common.zzak;
import com.google.android.gms.internal.mlkit_common.zzal;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.List;
import okio.AsyncTimeout;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class CommonComponentRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        DatabaseConfiguration databaseConfigurationBuilder = Component.builder(ByteString.Companion.class);
        databaseConfigurationBuilder.add(new Dependency(1, 0, MlKitContext.class));
        databaseConfigurationBuilder.typeConverters = new zze(16);
        Component componentBuild = databaseConfigurationBuilder.build();
        DatabaseConfiguration databaseConfigurationBuilder2 = Component.builder(MlKitThreadPool.class);
        databaseConfigurationBuilder2.typeConverters = new AsyncTimeout.Companion(17);
        Component componentBuild2 = databaseConfigurationBuilder2.build();
        DatabaseConfiguration databaseConfigurationBuilder3 = Component.builder(RemoteModelManager.class);
        databaseConfigurationBuilder3.add(new Dependency(2, 0, RemoteModelManager.RemoteModelManagerRegistration.class));
        databaseConfigurationBuilder3.typeConverters = new ByteString.Companion(17);
        Component componentBuild3 = databaseConfigurationBuilder3.build();
        DatabaseConfiguration databaseConfigurationBuilder4 = Component.builder(ExecutorSelector.class);
        databaseConfigurationBuilder4.add(new Dependency(1, 1, MlKitThreadPool.class));
        databaseConfigurationBuilder4.typeConverters = new Path.Companion();
        Component componentBuild4 = databaseConfigurationBuilder4.build();
        DatabaseConfiguration databaseConfigurationBuilder5 = Component.builder(Cleaner.class);
        databaseConfigurationBuilder5.typeConverters = new EmptyNetworkObserver();
        Component componentBuild5 = databaseConfigurationBuilder5.build();
        DatabaseConfiguration databaseConfigurationBuilder6 = Component.builder(AsyncTimeout.Companion.class);
        databaseConfigurationBuilder6.add(new Dependency(1, 0, Cleaner.class));
        databaseConfigurationBuilder6.typeConverters = new zze(17);
        Component componentBuild6 = databaseConfigurationBuilder6.build();
        DatabaseConfiguration databaseConfigurationBuilder7 = Component.builder(zze.class);
        databaseConfigurationBuilder7.add(new Dependency(1, 0, MlKitContext.class));
        databaseConfigurationBuilder7.typeConverters = new AsyncTimeout.Companion(18);
        Component componentBuild7 = databaseConfigurationBuilder7.build();
        DatabaseConfiguration databaseConfigurationBuilder8 = Component.builder(RemoteModelManager.RemoteModelManagerRegistration.class);
        databaseConfigurationBuilder8.journalMode = 1;
        databaseConfigurationBuilder8.add(new Dependency(1, 1, zze.class));
        databaseConfigurationBuilder8.typeConverters = new ByteString.Companion(18);
        Component componentBuild8 = databaseConfigurationBuilder8.build();
        zzad zzadVar = zzaf.zza;
        Object[] objArr = {SharedPrefManager.COMPONENT, componentBuild, componentBuild2, componentBuild3, componentBuild4, componentBuild5, componentBuild6, componentBuild7, componentBuild8};
        zzak.zza(9, objArr);
        return new zzal(9, objArr);
    }
}
