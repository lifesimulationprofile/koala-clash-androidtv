package com.github.kr328.clash.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.net.ProxyInfo;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.ImageLoader$Builder;
import coil.RealImageLoader$executeMain$result$1;
import coil.memory.MemoryCacheService;
import coil.network.HttpException;
import coil.request.Parameters;
import coil.request.RequestService;
import com.github.kr328.clash.common.compat.IntentsKt;
import com.github.kr328.clash.common.constants.Components;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.core.model.TunPackages;
import com.github.kr328.clash.service.clash.ClashRuntimeKt;
import com.github.kr328.clash.service.clash.module.TunModule;
import com.github.kr328.clash.service.clash.module.TunModule$attach$2;
import com.github.kr328.clash.service.model.AccessControlMode;
import com.github.kr328.clash.service.store.ServiceStore;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.github.kr328.clash.service.util.CoroutineKt;
import com.github.kr328.clash.service.util.IPNet;
import com.github.kr328.clash.service.util.NetKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjv;
import com.koala.clash.R;
import java.net.InetSocketAddress;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.json.Json;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TunService extends VpnService implements CoroutineScope {
    public final /* synthetic */ ContextScope $$delegate_0 = JobKt.CoroutineScope(Dispatchers.Default);
    public String reason;
    public final CacheStrategy runtime;
    public static final List HTTP_PROXY_LOCAL_LIST = AppCompatHintHelper.listOf("localhost", "*.local", "127.*", "10.*", "172.16.*", "172.17.*", "172.18.*", "172.19.*", "172.2*", "172.30.*", "172.31.*", "192.168.*");
    public static final List HTTP_PROXY_BLACK_LIST = AppCompatHintHelper.listOf("*zhihu.com", "*zhimg.com", "*jd.com", "100ime-iat-api.xfyun.cn", "*360buyimg.com");

    public TunService() {
        RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(this, (Continuation) null, 16);
        MutexImpl mutexImpl = ClashRuntimeKt.globalLock;
        this.runtime = new CacheStrategy(this, realImageLoader$executeMain$result$1);
    }

    public static final void access$open(TunService tunService, TunModule tunModule) {
        Object failure;
        TunPackages tunPackages;
        ServiceStore serviceStore = new ServiceStore(tunService);
        VpnService.Builder builder = new VpnService.Builder(tunService);
        builder.addAddress("172.19.0.1", 30);
        if (serviceStore.getAllowIpv6()) {
            builder.addAddress("fdfe:dcba:9876::1", 126);
        }
        if (serviceStore.getBypassPrivateNetwork()) {
            String[] stringArray = tunService.getResources().getStringArray(R.array.bypass_private_route);
            ArrayList arrayList = new ArrayList(stringArray.length);
            for (String str : stringArray) {
                arrayList.add(NetKt.parseCIDR(str));
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                IPNet iPNet = (IPNet) obj;
                builder.addRoute(iPNet.ip, iPNet.prefix);
            }
            if (serviceStore.getAllowIpv6()) {
                String[] stringArray2 = tunService.getResources().getStringArray(R.array.bypass_private_route6);
                ArrayList arrayList2 = new ArrayList(stringArray2.length);
                for (String str2 : stringArray2) {
                    arrayList2.add(NetKt.parseCIDR(str2));
                }
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    IPNet iPNet2 = (IPNet) obj2;
                    builder.addRoute(iPNet2.ip, iPNet2.prefix);
                }
            }
            builder.addRoute("172.19.0.2", 32);
            if (serviceStore.getAllowIpv6()) {
                builder.addRoute("fdfe:dcba:9876::2", 128);
            }
        } else {
            builder.addRoute("0.0.0.0", 0);
            if (serviceStore.getAllowIpv6()) {
                builder.addRoute("::", 0);
            }
        }
        UUID activeProfile = serviceStore.getActiveProfile();
        String absolutePath = activeProfile != null ? FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(tunService), activeProfile.toString()).getAbsolutePath() : null;
        if (absolutePath != null) {
            try {
                failure = (TunPackages) Json.Default.decodeFromString(Bridge.INSTANCE.nativeQueryTunPackages(absolutePath), TunPackages.Companion.serializer());
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            if (failure instanceof Result.Failure) {
                failure = null;
            }
            tunPackages = (TunPackages) failure;
        } else {
            tunPackages = null;
        }
        List list = tunPackages != null ? tunPackages.includePackage : null;
        List list2 = EmptyList.INSTANCE;
        if (list == null) {
            list = list2;
        }
        List list3 = tunPackages != null ? tunPackages.excludePackage : null;
        if (list3 == null) {
            list3 = list2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        KProperty kProperty = ServiceStore.$$delegatedProperties[2];
        int iOrdinal = ((AccessControlMode) serviceStore.accessControlMode$delegate.getValue()).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                linkedHashSet.addAll(serviceStore.getAccessControlPackages());
            } else {
                if (iOrdinal != 2) {
                    throw new HttpException();
                }
                linkedHashSet2.addAll(serviceStore.getAccessControlPackages());
            }
        }
        linkedHashSet.addAll(list);
        linkedHashSet2.addAll(list3);
        if (!linkedHashSet.isEmpty()) {
            if (!linkedHashSet2.isEmpty()) {
                Log.w("KoalaClash", "Access control: include-package active, exclude-package ignored (Android limitation)", null);
            }
            Iterator it = SetsKt.plus(linkedHashSet, tunService.getPackageName()).iterator();
            while (it.hasNext()) {
                builder.addAllowedApplication((String) it.next());
            }
        } else if (!linkedHashSet2.isEmpty()) {
            Iterator it2 = SetsKt.minus(linkedHashSet2, tunService.getPackageName()).iterator();
            while (it2.hasNext()) {
                builder.addDisallowedApplication((String) it2.next());
            }
        }
        builder.setBlocking(false);
        builder.setMtu(9000);
        builder.setSession("Clash");
        builder.addDnsServer("172.19.0.2");
        if (serviceStore.getAllowIpv6()) {
            builder.addDnsServer("fdfe:dcba:9876::2");
        }
        builder.setConfigureIntent(PendingIntent.getActivity(tunService, R.id.nf_vpn_status, new Intent().setComponent(Components.MAIN_ACTIVITY), IntentsKt.pendingIntentFlags$default()));
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            builder.setMetered(false);
        }
        if (i3 >= 29) {
            KProperty kProperty2 = ServiceStore.$$delegatedProperties[5];
            if (((Boolean) serviceStore.systemProxy$delegate.getValue()).booleanValue()) {
                SecureRandom secureRandom = TunModule.random;
                String strNativeStartHttp = Bridge.INSTANCE.nativeStartHttp("127." + Integer.valueOf(secureRandom.nextInt(199) + 1) + "." + Integer.valueOf(secureRandom.nextInt(199) + 1) + "." + Integer.valueOf(secureRandom.nextInt(199) + 1) + ":0");
                InetSocketAddress inetSocketAddress = strNativeStartHttp != null ? com.github.kr328.clash.core.util.NetKt.parseInetSocketAddress(strNativeStartHttp) : null;
                if (inetSocketAddress != null) {
                    String hostAddress = inetSocketAddress.getAddress().getHostAddress();
                    int port = inetSocketAddress.getPort();
                    if (serviceStore.getBypassPrivateNetwork()) {
                        list2 = HTTP_PROXY_LOCAL_LIST;
                    }
                    builder.setHttpProxy(ProxyInfo.buildDirectProxy(hostAddress, port, CollectionsKt.plus((Collection) HTTP_PROXY_BLACK_LIST, list2)));
                }
            }
        }
        KProperty[] kPropertyArr = ServiceStore.$$delegatedProperties;
        KProperty kProperty3 = kPropertyArr[6];
        if (((Boolean) serviceStore.allowBypass$delegate.getValue()).booleanValue()) {
            builder.allowBypass();
        }
        ParcelFileDescriptor parcelFileDescriptorEstablish = builder.establish();
        if (parcelFileDescriptorEstablish == null) {
            throw new NullPointerException("Establish VPN rejected by system");
        }
        int iDetachFd = parcelFileDescriptorEstablish.detachFd();
        KProperty kProperty4 = kPropertyArr[8];
        ImageLoader$Builder imageLoader$Builder = serviceStore.tunStackMode$delegate;
        String string = ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options);
        String strConcat = "172.19.0.1/30".concat(serviceStore.getAllowIpv6() ? ",fdfe:dcba:9876::1/126" : "");
        String strConcat2 = "172.19.0.2".concat(serviceStore.getAllowIpv6() ? ",fdfe:dcba:9876::2" : "");
        KProperty kProperty5 = kPropertyArr[4];
        Bridge.INSTANCE.nativeStartTun(iDetachFd, string, strConcat, strConcat2, ((Boolean) serviceStore.dnsHijacking$delegate.getValue()).booleanValue() ? "0.0.0.0" : "172.19.0.2".concat(serviceStore.getAllowIpv6() ? ",fdfe:dcba:9876::2" : ""), new RequestService(28, new JobKt__JobKt$invokeOnCompletion$1(1, tunModule.vpn, VpnService.class, "protect", "protect(I)Z", 0, 0, 14), new TunModule$attach$2(3, tunModule, TunModule.class, "queryUid", "queryUid(ILjava/net/InetSocketAddress;Ljava/net/InetSocketAddress;)I", 0, 0)));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
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

    @Override // android.app.Service
    public final void onDestroy() {
        SecureRandom secureRandom = TunModule.random;
        Bridge bridge = Bridge.INSTANCE;
        bridge.nativeStopHttp();
        bridge.nativeStopTun();
        boolean z = StatusProvider.serviceRunning;
        StatusProvider.Companion.setServiceRunning(false);
        BroadcastKt.sendBroadcastSelf(this, new Intent(Intents.ACTION_CLASH_STOPPED).putExtra("stop_reason", this.reason));
        CoroutineKt.cancelAndJoinBlocking(this);
        String str = this.reason;
        if (str == null) {
            str = "successfully";
        }
        Log.i("KoalaClash", "TunService destroyed: ".concat(str), null);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        BroadcastKt.sendBroadcastSelf(this, new Intent(Intents.ACTION_CLASH_STARTED));
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.runtime.getClass();
        Bridge.INSTANCE.nativeForceGc();
    }
}
