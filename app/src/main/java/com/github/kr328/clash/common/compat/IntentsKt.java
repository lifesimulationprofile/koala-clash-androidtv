package com.github.kr328.clash.common.compat;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntentsKt {
    public static int pendingIntentFlags$default() {
        return Build.VERSION.SDK_INT >= 24 ? 201326592 : 134217728;
    }
}
