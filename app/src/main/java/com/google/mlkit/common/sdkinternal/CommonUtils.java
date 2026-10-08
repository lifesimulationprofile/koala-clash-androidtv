package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CommonUtils {
    public static final GmsLogger zza = new GmsLogger("CommonUtils", "");

    public static String getAppVersion(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            String strConcat = "Exception thrown when trying to get app version ".concat(e.toString());
            GmsLogger gmsLogger = zza;
            if (!Log.isLoggable(gmsLogger.zza, 6)) {
                return "";
            }
            Log.e("CommonUtils", gmsLogger.zza(strConcat));
            return "";
        }
    }
}
