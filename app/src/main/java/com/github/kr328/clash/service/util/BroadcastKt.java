package com.github.kr328.clash.service.util;

import android.content.Context;
import android.content.Intent;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.constants.Permissions;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BroadcastKt {
    public static final void sendBroadcastSelf(Context context, Intent intent) {
        Intent intent2 = intent.setPackage(context.getPackageName());
        String str = Permissions.RECEIVE_SELF_BROADCASTS;
        context.sendBroadcast(intent2, Permissions.RECEIVE_SELF_BROADCASTS);
    }

    public static final void sendProfileChanged(Context context, UUID uuid) {
        String str = Intents.ACTION_START_CLASH;
        sendBroadcastSelf(context, new Intent(Intents.ACTION_PROFILE_CHANGED).putExtra("uuid", uuid.toString()));
    }
}
