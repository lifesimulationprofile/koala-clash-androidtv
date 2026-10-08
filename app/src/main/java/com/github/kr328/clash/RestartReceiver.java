package com.github.kr328.clash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.service.StatusProvider;
import com.github.kr328.clash.util.ClashKt;
import kotlin.io.FilesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RestartReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != 798292259) {
                if (iHashCode != 1737074039 || !action.equals("android.intent.action.MY_PACKAGE_REPLACED")) {
                    return;
                }
            } else if (!action.equals("android.intent.action.BOOT_COMPLETED")) {
                return;
            }
            boolean z = StatusProvider.serviceRunning;
            Global.INSTANCE.getClass();
            if (FilesKt.resolve(Global.getApplication$1().getFilesDir(), "service_running.lock").exists()) {
                ClashKt.startClashService(context);
            }
        }
    }
}
