package com.github.kr328.clash;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import com.github.kr328.clash.common.compat.IntentsKt;
import com.github.kr328.clash.common.compat.ServicesKt;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.log.LogcatCache;
import com.github.kr328.clash.service.RemoteService;
import com.koala.clash.R;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatService extends Service implements CoroutineScope, IInterface {
    public static boolean running;
    public final /* synthetic */ ContextScope $$delegate_0 = JobKt.CoroutineScope(Dispatchers.Default);
    public final LogcatCache cache = new LogcatCache(0);
    public final LogcatService$connection$1 connection = new ServiceConnection() { // from class: com.github.kr328.clash.LogcatService$connection$1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogcatService logcatService = this.this$0;
            if (iBinder == null) {
                logcatService.stopSelf();
                return;
            }
            boolean z = LogcatService.running;
            if (!iBinder.isBinderAlive()) {
                logcatService.stopSelf();
            } else {
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                JobKt.launch$default(logcatService, DefaultIoScheduler.INSTANCE, new FilesActivity$Content$5$1$1$1(iBinder, logcatService, null), 2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this.this$0.stopSelf();
        }
    };

    /* JADX INFO: renamed from: com.github.kr328.clash.LogcatService$asBinder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends Binder {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ CoroutineScope this$0;

        public /* synthetic */ AnonymousClass1(CoroutineScope coroutineScope, int i) {
            this.$r8$classId = i;
            this.this$0 = coroutineScope;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (this.$r8$classId) {
                case 1:
                    if (i == 1) {
                        ((StandaloneCoroutine) this.this$0).cancel((CancellationException) null);
                    } else {
                        super.onTransact(i, parcel, parcel2, i2);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        @Override // android.os.Binder, android.os.IBinder
        public IInterface queryLocalInterface(String str) {
            switch (this.$r8$classId) {
                case 0:
                    return (LogcatService) this.this$0;
                default:
                    return super.queryLocalInterface(str);
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return new AnonymousClass1(this, 0);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new AnonymousClass1(this, 0);
    }

    @Override // android.app.Service
    public final void onCreate() {
        NotificationChannel notificationChannel;
        super.onCreate();
        running = true;
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(this);
        Uri uri = Settings.System.DEFAULT_NOTIFICATION_URI;
        AudioAttributes audioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        String string = getString(R.string.clash_logcat);
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            notificationChannel = null;
        } else {
            NotificationChannel notificationChannelCreateNotificationChannel = NotificationChannelCompat.Api26Impl.createNotificationChannel(3, string, "clash_logcat_channel");
            NotificationChannelCompat.Api26Impl.setDescription(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setGroup(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setShowBadge(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setSound(notificationChannelCreateNotificationChannel, uri, audioAttributes);
            NotificationChannelCompat.Api26Impl.enableLights(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setLightColor(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setVibrationPattern(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.enableVibration(notificationChannelCreateNotificationChannel);
            notificationChannel = notificationChannelCreateNotificationChannel;
        }
        if (i >= 26) {
            NotificationChannelCompat.Api26Impl.createNotificationChannel(notificationManagerCompat.mNotificationManager, notificationChannel);
        }
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, "clash_logcat_channel");
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_logo_service;
        notificationCompat$Builder.mColor = getColor(R.color.color_clash_light);
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(getString(R.string.clash_logcat));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(getString(R.string.running));
        notificationCompat$Builder.mContentIntent = PendingIntent.getActivity(this, R.id.nf_logcat_status, ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatActivity.class)).setFlags(872415232), IntentsKt.pendingIntentFlags$default());
        ServicesKt.startForegroundCompat(this, R.id.nf_logcat_status, notificationCompat$Builder.build());
        bindService(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(RemoteService.class)), this.connection, 1);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        JobKt.cancel(this, (CancellationException) null);
        unbindService(this.connection);
        stopForeground(true);
        running = false;
        super.onDestroy();
    }
}
