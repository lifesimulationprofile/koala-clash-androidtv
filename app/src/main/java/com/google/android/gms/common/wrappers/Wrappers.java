package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.compose.ui.platform.AndroidUriHandler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Wrappers {
    public static final Wrappers zza;
    public AndroidUriHandler zzb;

    static {
        Wrappers wrappers = new Wrappers();
        wrappers.zzb = null;
        zza = wrappers;
    }

    public static AndroidUriHandler packageManager(Context context) {
        AndroidUriHandler androidUriHandler;
        Wrappers wrappers = zza;
        synchronized (wrappers) {
            try {
                if (wrappers.zzb == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    wrappers.zzb = new AndroidUriHandler(context, (byte) 0);
                }
                androidUriHandler = wrappers.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return androidUriHandler;
    }
}
