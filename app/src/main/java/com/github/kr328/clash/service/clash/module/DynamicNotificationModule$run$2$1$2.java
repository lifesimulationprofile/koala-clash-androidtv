package com.github.kr328.clash.service.clash.module;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.core.util.TrafficKt;
import com.github.kr328.clash.service.StatusProvider;
import com.koala.clash.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicNotificationModule$run$2$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ConfigurationModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicNotificationModule$run$2$1$2(ConfigurationModule configurationModule, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = configurationModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new DynamicNotificationModule$run$2$1$2(this.this$0, continuation, 0);
            default:
                return new DynamicNotificationModule$run$2$1$2(this.this$0, continuation, 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((DynamicNotificationModule$run$2$1$2) create((Intent) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((DynamicNotificationModule$run$2$1$2) create(Long.valueOf(((Number) obj).longValue()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                NotificationCompat$Builder notificationCompat$Builder = (NotificationCompat$Builder) this.this$0.store;
                String str = StatusProvider.currentProfile;
                if (str == null) {
                    str = "Not selected";
                }
                notificationCompat$Builder.getClass();
                notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(str);
                return Unit.INSTANCE;
            default:
                ResultKt.throwOnFailure(obj);
                ConfigurationModule configurationModule = this.this$0;
                Bridge bridge = Bridge.INSTANCE;
                long jNativeQueryTrafficNow = bridge.nativeQueryTrafficNow();
                long jNativeQueryTrafficTotal = bridge.nativeQueryTrafficTotal();
                String strTrafficString = TrafficKt.trafficString(TrafficKt.scaleTraffic(jNativeQueryTrafficNow >>> 32));
                String strTrafficString2 = TrafficKt.trafficString(TrafficKt.scaleTraffic(jNativeQueryTrafficNow & 4294967295L));
                String strTrafficString3 = TrafficKt.trafficString(TrafficKt.scaleTraffic(jNativeQueryTrafficTotal >>> 32));
                String strTrafficString4 = TrafficKt.trafficString(TrafficKt.scaleTraffic(jNativeQueryTrafficTotal & 4294967295L));
                NotificationCompat$Builder notificationCompat$Builder2 = (NotificationCompat$Builder) configurationModule.store;
                String string = configurationModule.service.getString(R.string.clash_notification_content, ImageAnalysis$$ExternalSyntheticLambda1.m(strTrafficString, "/s"), ImageAnalysis$$ExternalSyntheticLambda1.m(strTrafficString2, "/s"));
                notificationCompat$Builder2.getClass();
                notificationCompat$Builder2.mContentText = NotificationCompat$Builder.limitCharSequenceLength(string);
                notificationCompat$Builder2.mSubText = NotificationCompat$Builder.limitCharSequenceLength(configurationModule.service.getString(R.string.clash_notification_content, strTrafficString3, strTrafficString4));
                Notification notificationBuild = notificationCompat$Builder2.build();
                NotificationManagerCompat notificationManagerCompat = (NotificationManagerCompat) configurationModule.reload;
                notificationManagerCompat.getClass();
                Bundle bundle = notificationBuild.extras;
                if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
                    notificationManagerCompat.mNotificationManager.notify(null, R.id.nf_clash_status, notificationBuild);
                } else {
                    NotificationManagerCompat.NotifyTask notifyTask = new NotificationManagerCompat.NotifyTask(notificationManagerCompat.mContext.getPackageName(), notificationBuild);
                    synchronized (NotificationManagerCompat.sLock) {
                        try {
                            if (NotificationManagerCompat.sSideChannelManager == null) {
                                NotificationManagerCompat.sSideChannelManager = new NotificationManagerCompat.SideChannelManager(notificationManagerCompat.mContext.getApplicationContext());
                            }
                            NotificationManagerCompat.sSideChannelManager.mHandler.obtainMessage(0, notifyTask).sendToTarget();
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    notificationManagerCompat.mNotificationManager.cancel(null, R.id.nf_clash_status);
                }
                return Unit.INSTANCE;
        }
    }
}
