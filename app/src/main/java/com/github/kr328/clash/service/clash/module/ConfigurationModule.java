package com.github.kr328.clash.service.clash.module;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import com.github.kr328.clash.common.compat.IntentsKt;
import com.github.kr328.clash.common.constants.Components;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.store.ServiceStore;
import com.koala.clash.R;
import java.util.UUID;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationModule extends Module {
    public final /* synthetic */ int $r8$classId;
    public final Object reload;
    public final Object store;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class LoadException {
        public final String message;

        public LoadException(String str) {
            this.message = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadException) && Intrinsics.areEqual(this.message, ((LoadException) obj).message);
        }

        public final int hashCode() {
            return this.message.hashCode();
        }

        public final String toString() {
            return ImageAnalysis$$ExternalSyntheticLambda1.m$1("LoadException(message=", this.message, ")");
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.ConfigurationModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public ConfigurationModule L$0;
        public ReceiveChannel L$1;
        public UUID L$2;
        public UUID L$3;
        public Imported L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigurationModule.this.run(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigurationModule(Service service, int i) {
        super(service);
        this.$r8$classId = i;
        switch (i) {
            case 1:
                super(service);
                NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(service, "clash_status_channel");
                notificationCompat$Builder.mNotification.icon = R.drawable.ic_logo_service;
                notificationCompat$Builder.setFlag(2);
                notificationCompat$Builder.mColor = service.getColor(R.color.color_clash);
                notificationCompat$Builder.setFlag(8);
                notificationCompat$Builder.mShowWhen = false;
                notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength("Not Selected");
                notificationCompat$Builder.mFgsDeferBehavior = 1;
                notificationCompat$Builder.mContentIntent = PendingIntent.getActivity(service, R.id.nf_clash_status, new Intent().setComponent(Components.MAIN_ACTIVITY).setFlags(872415232), IntentsKt.pendingIntentFlags$default());
                this.store = notificationCompat$Builder;
                this.reload = new NotificationManagerCompat(service);
                break;
            default:
                this.store = new ServiceStore(service);
                this.reload = ChannelKt.Channel$default(-1, 0, 6);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ff A[Catch: Exception -> 0x010f, TryCatch #0 {Exception -> 0x010f, blocks: (B:41:0x00f5, B:43:0x00ff, B:46:0x0107, B:51:0x0113, B:79:0x025a, B:80:0x025f), top: B:92:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0105 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x0129  */
    /* JADX WARN: Code duplicated, block: B:57:0x0132 A[Catch: Exception -> 0x005f, TryCatch #1 {Exception -> 0x005f, blocks: (B:21:0x005a, B:76:0x0215, B:55:0x012d, B:57:0x0132, B:60:0x0163, B:63:0x01a2, B:64:0x01ad, B:66:0x01b3, B:68:0x01c6, B:70:0x01cb, B:72:0x01dd, B:73:0x01eb, B:77:0x0254, B:78:0x0259, B:26:0x006c, B:29:0x007b, B:32:0x0088), top: B:94:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0161  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b3 A[Catch: Exception -> 0x005f, TryCatch #1 {Exception -> 0x005f, blocks: (B:21:0x005a, B:76:0x0215, B:55:0x012d, B:57:0x0132, B:60:0x0163, B:63:0x01a2, B:64:0x01ad, B:66:0x01b3, B:68:0x01c6, B:70:0x01cb, B:72:0x01dd, B:73:0x01eb, B:77:0x0254, B:78:0x0259, B:26:0x006c, B:29:0x007b, B:32:0x0088), top: B:94:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01c6 A[Catch: Exception -> 0x005f, TryCatch #1 {Exception -> 0x005f, blocks: (B:21:0x005a, B:76:0x0215, B:55:0x012d, B:57:0x0132, B:60:0x0163, B:63:0x01a2, B:64:0x01ad, B:66:0x01b3, B:68:0x01c6, B:70:0x01cb, B:72:0x01dd, B:73:0x01eb, B:77:0x0254, B:78:0x0259, B:26:0x006c, B:29:0x007b, B:32:0x0088), top: B:94:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01dd A[Catch: Exception -> 0x005f, LOOP:1: B:71:0x01db->B:72:0x01dd, LOOP_END, TryCatch #1 {Exception -> 0x005f, blocks: (B:21:0x005a, B:76:0x0215, B:55:0x012d, B:57:0x0132, B:60:0x0163, B:63:0x01a2, B:64:0x01ad, B:66:0x01b3, B:68:0x01c6, B:70:0x01cb, B:72:0x01dd, B:73:0x01eb, B:77:0x0254, B:78:0x0259, B:26:0x006c, B:29:0x007b, B:32:0x0088), top: B:94:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0213  */
    /* JADX WARN: Code duplicated, block: B:79:0x025a A[Catch: Exception -> 0x010f, TRY_ENTER, TryCatch #0 {Exception -> 0x010f, blocks: (B:41:0x00f5, B:43:0x00ff, B:46:0x0107, B:51:0x0113, B:79:0x025a, B:80:0x025f), top: B:92:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01c9 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x010d -> B:36:0x00b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0211 -> B:76:0x0215). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.github.kr328.clash.service.clash.module.Module
    public final java.lang.Object run(kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instruction units count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.ConfigurationModule.run(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
