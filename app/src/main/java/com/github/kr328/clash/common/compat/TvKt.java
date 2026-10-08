package com.github.kr328.clash.common.compat;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TvKt {
    public static final boolean isTvDevice(Context context) {
        Object systemService = context.getSystemService("uimode");
        UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
        return (uiModeManager != null ? uiModeManager.getCurrentModeType() : 1) == 4 || context.getPackageManager().hasSystemFeature("android.software.leanback");
    }
}
