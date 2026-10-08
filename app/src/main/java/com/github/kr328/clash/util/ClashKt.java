package com.github.kr328.clash.util;

import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import com.github.kr328.clash.common.compat.ServicesKt;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.ClashService;
import com.github.kr328.clash.service.TunService;
import com.github.kr328.clash.service.util.BroadcastKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ClashKt {
    public static final Intent startClashService(Context context) {
        UiStore uiStore = new UiStore(context);
        KProperty kProperty = UiStore.$$delegatedProperties[0];
        if (!((Boolean) uiStore.enableVpn$delegate.getValue()).booleanValue()) {
            ServicesKt.startForegroundServiceCompat(context, ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(ClashService.class)));
            return null;
        }
        Intent intentPrepare = VpnService.prepare(context);
        if (intentPrepare != null) {
            return intentPrepare;
        }
        ServicesKt.startForegroundServiceCompat(context, ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(TunService.class)));
        return null;
    }

    public static final void stopClashService(Context context) {
        String str = Intents.ACTION_START_CLASH;
        BroadcastKt.sendBroadcastSelf(context, new Intent(Intents.ACTION_CLASH_REQUEST_STOP));
    }
}
