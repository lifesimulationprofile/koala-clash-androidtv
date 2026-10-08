package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import androidx.room.DatabaseConfiguration;
import com.google.android.gms.dynamite.zze;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPrefManager {
    public static final Component COMPONENT;
    public final Context zza;

    static {
        DatabaseConfiguration databaseConfigurationBuilder = Component.builder(SharedPrefManager.class);
        databaseConfigurationBuilder.add(new Dependency(1, 0, MlKitContext.class));
        databaseConfigurationBuilder.add(new Dependency(1, 0, Context.class));
        databaseConfigurationBuilder.typeConverters = new zze(18);
        COMPONENT = databaseConfigurationBuilder.build();
    }

    public SharedPrefManager(Context context) {
        this.zza = context;
    }

    public final synchronized String getMlSdkInstanceId() {
        String string = this.zza.getSharedPreferences("com.google.mlkit.internal", 0).getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        this.zza.getSharedPreferences("com.google.mlkit.internal", 0).edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }
}
