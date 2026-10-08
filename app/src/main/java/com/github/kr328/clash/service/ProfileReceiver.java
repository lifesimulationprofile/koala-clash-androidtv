package com.github.kr328.clash.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.material3.ThumbNode;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.common.compat.ServicesKt;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.util.ComponentsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.MutexImpl;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileReceiver extends BroadcastReceiver {
    public static boolean initialized;
    public static final AsyncTimeout.Companion Companion = new AsyncTimeout.Companion(14);
    public static final MutexImpl lock = new MutexImpl();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intrinsics.areEqual(action, "android.intent.action.BOOT_COMPLETED") || Intrinsics.areEqual(action, "android.intent.action.MY_PACKAGE_REPLACED") || Intrinsics.areEqual(action, "android.intent.action.TIMEZONE_CHANGED") || Intrinsics.areEqual(action, "android.intent.action.TIME_SET")) {
            JobKt.launch$default(Global.INSTANCE, null, new ThumbNode.AnonymousClass1(context, (Continuation) null, 24), 3);
        } else if (Intrinsics.areEqual(action, Intents.ACTION_PROFILE_REQUEST_UPDATE)) {
            ServicesKt.startForegroundServiceCompat(context, intent.setComponent(ComponentsKt.getComponentName(Reflection.getOrCreateKotlinClass(ProfileWorker.class))));
        }
    }
}
