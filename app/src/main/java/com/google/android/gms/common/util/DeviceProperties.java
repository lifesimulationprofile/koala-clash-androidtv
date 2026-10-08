package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DeviceProperties {
    public static Boolean zze;
    public static Boolean zzf;
    public static Boolean zzh;
    public static Boolean zzj;

    public static boolean isWearableWithoutPlayStore(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zze == null) {
            zze = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (zze.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (zzf == null) {
            zzf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (!zzf.booleanValue()) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        return i < 26 || i >= 30;
    }
}
