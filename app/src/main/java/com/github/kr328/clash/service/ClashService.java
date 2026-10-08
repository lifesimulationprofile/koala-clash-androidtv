package com.github.kr328.clash.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.service.clash.ClashRuntimeKt;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.github.kr328.clash.service.util.CoroutineKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjv;
import com.koala.clash.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ClashService extends BaseService {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String reason;
    public final CacheStrategy runtime;

    public ClashService() {
        NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(this, (Continuation) null, 21);
        MutexImpl mutexImpl = ClashRuntimeKt.globalLock;
        this.runtime = new CacheStrategy(this, navHostKt$NavHost$29$1);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new Binder();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.app.Service, kotlinx.coroutines.CoroutineScope] */
    @Override // android.app.Service
    public final void onCreate() {
        NotificationChannel notificationChannelCreateNotificationChannel;
        super.onCreate();
        if (StatusProvider.serviceRunning) {
            stopSelf();
            return;
        }
        StatusProvider.Companion.setServiceRunning(true);
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(this);
        Uri uri = Settings.System.DEFAULT_NOTIFICATION_URI;
        AudioAttributes audioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        CharSequence text = getText(R.string.clash_service_status_channel);
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            notificationChannelCreateNotificationChannel = null;
        } else {
            notificationChannelCreateNotificationChannel = NotificationChannelCompat.Api26Impl.createNotificationChannel(2, text, "clash_status_channel");
            NotificationChannelCompat.Api26Impl.setDescription(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setGroup(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setShowBadge(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setSound(notificationChannelCreateNotificationChannel, uri, audioAttributes);
            NotificationChannelCompat.Api26Impl.enableLights(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setLightColor(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.setVibrationPattern(notificationChannelCreateNotificationChannel);
            NotificationChannelCompat.Api26Impl.enableVibration(notificationChannelCreateNotificationChannel);
        }
        if (i >= 26) {
            NotificationChannelCompat.Api26Impl.createNotificationChannel(notificationManagerCompat.mNotificationManager, notificationChannelCreateNotificationChannel);
        }
        zzjv.notifyLoadingNotification(this);
        CacheStrategy cacheStrategy = this.runtime;
        ?? r1 = (Service) cacheStrategy.networkRequest;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobKt.launch$default(r1, DefaultIoScheduler.INSTANCE, new NavHostKt$NavHost$29$1((SuspendLambda) cacheStrategy.cacheResponse, null), 2);
    }

    @Override // com.github.kr328.clash.service.BaseService, android.app.Service
    public final void onDestroy() {
        boolean z = StatusProvider.serviceRunning;
        StatusProvider.Companion.setServiceRunning(false);
        BroadcastKt.sendBroadcastSelf(this, new Intent(Intents.ACTION_CLASH_STOPPED).putExtra("stop_reason", this.reason));
        CoroutineKt.cancelAndJoinBlocking(this);
        String str = this.reason;
        if (str == null) {
            str = "successfully";
        }
        Log.i("KoalaClash", "ClashService destroyed: ".concat(str), null);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        BroadcastKt.sendBroadcastSelf(this, new Intent(Intents.ACTION_CLASH_STARTED));
        return 1;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.runtime.getClass();
        Bridge.INSTANCE.nativeForceGc();
    }
}
