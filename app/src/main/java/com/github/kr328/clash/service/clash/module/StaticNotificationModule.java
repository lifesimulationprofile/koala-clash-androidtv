package com.github.kr328.clash.service.clash.module;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import androidx.core.app.NotificationCompat$Builder;
import com.github.kr328.clash.common.compat.IntentsKt;
import com.github.kr328.clash.common.constants.Components;
import com.koala.clash.R;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StaticNotificationModule extends Module {
    public final NotificationCompat$Builder builder;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.StaticNotificationModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public StaticNotificationModule L$0;
        public ReceiveChannel L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            StaticNotificationModule.this.run(this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    public StaticNotificationModule(Service service) {
        super(service);
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(service, "clash_status_channel");
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_logo_service;
        notificationCompat$Builder.setFlag(2);
        notificationCompat$Builder.mColor = service.getColor(R.color.color_clash);
        notificationCompat$Builder.setFlag(8);
        notificationCompat$Builder.mShowWhen = false;
        notificationCompat$Builder.mFgsDeferBehavior = 1;
        notificationCompat$Builder.mContentIntent = PendingIntent.getActivity(service, R.id.nf_clash_status, new Intent().setComponent(Components.MAIN_ACTIVITY).setFlags(872415232), IntentsKt.pendingIntentFlags$default());
        this.builder = notificationCompat$Builder;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.github.kr328.clash.service.clash.module.Module
    public final java.lang.Object run(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.github.kr328.clash.service.clash.module.StaticNotificationModule.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.github.kr328.clash.service.clash.module.StaticNotificationModule$run$1 r0 = (com.github.kr328.clash.service.clash.module.StaticNotificationModule.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L13:
            com.github.kr328.clash.service.clash.module.StaticNotificationModule$run$1 r0 = new com.github.kr328.clash.service.clash.module.StaticNotificationModule$run$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r7 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r7
            r0.<init>(r7)
        L1a:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlinx.coroutines.channels.ReceiveChannel r1 = r0.L$1
            com.github.kr328.clash.service.clash.module.StaticNotificationModule r3 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1 r7 = new com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1
            r1 = 9
            r7.<init>(r1)
            kotlinx.coroutines.channels.BufferedChannel r7 = com.github.kr328.clash.service.clash.module.Module.receiveBroadcast$default(r6, r7, r2)
            r3 = r6
            r1 = r7
        L43:
            r0.L$0 = r3
            r0.L$1 = r1
            r0.label = r2
            java.lang.Object r7 = r1.receive(r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r7 != r4) goto L52
            return r4
        L52:
            java.lang.String r7 = com.github.kr328.clash.service.StatusProvider.currentProfile
            if (r7 != 0) goto L58
            java.lang.String r7 = "Not selected"
        L58:
            androidx.core.app.NotificationCompat$Builder r4 = r3.builder
            android.app.Service r5 = r3.service
            r4.getClass()
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(r7)
            r4.mContentTitle = r7
            r7 = 2131689921(0x7f0f01c1, float:1.9008871E38)
            java.lang.CharSequence r7 = r5.getText(r7)
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(r7)
            r4.mContentText = r7
            android.app.Notification r7 = r4.build()
            r4 = 2131296579(0x7f090143, float:1.8211079E38)
            com.github.kr328.clash.common.compat.ServicesKt.startForegroundCompat(r5, r4, r7)
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.StaticNotificationModule.run(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
