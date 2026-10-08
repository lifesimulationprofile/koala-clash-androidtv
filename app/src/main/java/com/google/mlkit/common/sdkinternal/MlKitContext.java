package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.github.kr328.clash.remote.StatusClient;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.OptionalProvider$$Lambda$4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MlKitContext {
    public static final Object zza = new Object();
    public static MlKitContext zzb;
    public ComponentRuntime zzc;

    public static MlKitContext getInstance() {
        MlKitContext mlKitContext;
        synchronized (zza) {
            zzah.checkState("MlKitContext has not been initialized", zzb != null);
            mlKitContext = zzb;
            zzah.checkNotNull(mlKitContext);
        }
        return mlKitContext;
    }

    public static MlKitContext zzb(Context context) {
        MlKitContext mlKitContext;
        synchronized (zza) {
            zzah.checkState("MlKitContext is already initialized", zzb == null);
            MlKitContext mlKitContext2 = new MlKitContext();
            zzb = mlKitContext2;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            ArrayList arrayListDiscoverLazy = new StatusClient(context, new OptionalProvider$$Lambda$4()).discoverLazy();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(arrayListDiscoverLazy);
            arrayList2.add(Component.of(context, Context.class, new Class[0]));
            arrayList2.add(Component.of(mlKitContext2, MlKitContext.class, new Class[0]));
            ComponentRuntime componentRuntime = new ComponentRuntime(arrayList, arrayList2);
            mlKitContext2.zzc = componentRuntime;
            componentRuntime.initializeEagerComponents();
            mlKitContext = zzb;
        }
        return mlKitContext;
    }

    public final Object get(Class cls) {
        zzah.checkState("MlKitContext has been deleted", zzb == this);
        zzah.checkNotNull(this.zzc);
        return this.zzc.get(cls);
    }

    public final Context getApplicationContext() {
        return (Context) get(Context.class);
    }
}
