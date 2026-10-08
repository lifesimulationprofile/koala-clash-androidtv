package com.github.kr328.clash.common.compat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextKt {
    public static final Intent registerReceiverCompat(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, null, str == null ? 2 : 4);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, null);
    }
}
