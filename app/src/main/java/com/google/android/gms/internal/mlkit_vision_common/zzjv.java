package com.google.android.gms.internal.mlkit_vision_common;

import android.app.Service;
import androidx.core.app.NotificationCompat$Builder;
import com.github.kr328.clash.common.compat.ServicesKt;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjv {
    public static void notifyLoadingNotification(Service service) {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(service, "clash_status_channel");
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_logo_service;
        notificationCompat$Builder.setFlag(2);
        notificationCompat$Builder.mColor = service.getColor(R.color.color_clash);
        notificationCompat$Builder.setFlag(8);
        notificationCompat$Builder.mShowWhen = false;
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(service.getText(R.string.loading));
        ServicesKt.startForegroundCompat(service, R.id.nf_clash_status, notificationCompat$Builder.build());
    }
}
