package com.github.kr328.clash.common.compat;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ServicesKt {
    public static final void startForegroundCompat(Service service, int i, Notification notification) {
        if (Build.VERSION.SDK_INT >= 34) {
            service.startForeground(i, notification, 1073741824);
        } else {
            service.startForeground(i, notification);
        }
    }

    public static final void startForegroundServiceCompat(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
