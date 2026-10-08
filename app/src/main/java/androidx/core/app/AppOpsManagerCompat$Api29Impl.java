package androidx.core.app;

import android.app.Notification;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppOpsManagerCompat$Api29Impl {
    public static String getOpPackageName(Context context) {
        return context.getOpPackageName();
    }

    public static void setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void setBubbleMetadata(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void setContextual(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
