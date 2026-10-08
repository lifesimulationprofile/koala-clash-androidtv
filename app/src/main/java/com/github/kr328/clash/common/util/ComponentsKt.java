package com.github.kr328.clash.common.util;

import android.content.ComponentName;
import android.content.Intent;
import com.github.kr328.clash.common.Global;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentsKt {
    public static final ComponentName getComponentName(ClassReference classReference) {
        Global.INSTANCE.getClass();
        return new ComponentName(Global.getApplication$1().getPackageName(), classReference.getJClass().getName());
    }

    public static final Intent getIntent(ClassReference classReference) {
        Global.INSTANCE.getClass();
        return new Intent(Global.getApplication$1(), (Class<?>) classReference.getJClass());
    }
}
