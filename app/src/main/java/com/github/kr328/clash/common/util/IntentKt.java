package com.github.kr328.clash.common.util;

import android.content.Intent;
import android.net.Uri;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntentKt {
    public static final UUID getUuid(Intent intent) {
        String schemeSpecificPart;
        Uri data = intent.getData();
        if (data != null) {
            if (!Intrinsics.areEqual(data.getScheme(), "uuid")) {
                data = null;
            }
            if (data != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null) {
                return UUID.fromString(schemeSpecificPart);
            }
        }
        return null;
    }

    public static final void setUUID(Intent intent, UUID uuid) {
        intent.setData(Uri.fromParts("uuid", String.valueOf(uuid), null));
    }
}
