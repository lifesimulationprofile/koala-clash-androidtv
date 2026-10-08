package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.provider.Settings;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationChannelCompat {
    public final String mId;
    public final int mImportance;
    public CharSequence mName;
    public final Uri mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
    public final AudioAttributes mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api26Impl {
        public static Notification.Builder createBuilder(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static NotificationChannel createNotificationChannel(int i, CharSequence charSequence, String str) {
            return new NotificationChannel(str, charSequence, i);
        }

        public static void createNotificationChannels(NotificationManager notificationManager, ArrayList arrayList) {
            notificationManager.createNotificationChannels(arrayList);
        }

        public static void enableLights(NotificationChannel notificationChannel) {
            notificationChannel.enableLights(false);
        }

        public static void enableVibration(NotificationChannel notificationChannel) {
            notificationChannel.enableVibration(false);
        }

        public static void setBadgeIconType(Notification.Builder builder) {
            builder.setBadgeIconType(0);
        }

        public static void setDescription(NotificationChannel notificationChannel) {
            notificationChannel.setDescription(null);
        }

        public static void setGroup(NotificationChannel notificationChannel) {
            notificationChannel.setGroup(null);
        }

        public static void setGroupAlertBehavior(Notification.Builder builder) {
            builder.setGroupAlertBehavior(0);
        }

        public static void setLightColor(NotificationChannel notificationChannel) {
            notificationChannel.setLightColor(0);
        }

        public static void setSettingsText(Notification.Builder builder) {
            builder.setSettingsText(null);
        }

        public static void setShortcutId(Notification.Builder builder) {
            builder.setShortcutId(null);
        }

        public static void setShowBadge(NotificationChannel notificationChannel) {
            notificationChannel.setShowBadge(true);
        }

        public static void setSound(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        public static void setTimeoutAfter(Notification.Builder builder) {
            builder.setTimeoutAfter(0L);
        }

        public static void setVibrationPattern(NotificationChannel notificationChannel) {
            notificationChannel.setVibrationPattern(null);
        }

        public static void createNotificationChannel(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public NotificationChannelCompat(String str, int i) {
        this.mId = str;
        this.mImportance = i;
    }
}
