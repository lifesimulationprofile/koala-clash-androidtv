package com.github.kr328.clash.store;

import android.content.Context;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.google.android.gms.tasks.zzr;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppStore {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public final zzr autoCheckUpdate$delegate;
    public final Parameters.Builder updatedAt$delegate;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(AppStore.class, "updatedAt", "getUpdatedAt()J", 0);
        Reflection.factory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl(AppStore.class, "autoCheckUpdate", "getAutoCheckUpdate()Z", 0)};
    }

    public AppStore(Context context) {
        Parameters.Builder builder = new Parameters.Builder(28, new MemoryCacheService(21, context.getSharedPreferences("app", 0)));
        this.updatedAt$delegate = new Parameters.Builder(27, builder);
        this.autoCheckUpdate$delegate = new zzr(builder, "auto_check_update", true);
    }
}
