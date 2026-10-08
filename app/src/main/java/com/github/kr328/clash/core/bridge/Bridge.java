package com.github.kr328.clash.core.bridge;

import android.app.Application;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Keep;
import com.github.kr328.clash.common.Global;
import java.io.File;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
@Keep
public final class Bridge {
    public static final Bridge INSTANCE;

    static {
        Bridge bridge = new Bridge();
        INSTANCE = bridge;
        System.loadLibrary("bridge");
        Global.INSTANCE.getClass();
        Application application$1 = Global.getApplication$1();
        ParcelFileDescriptor.open(new File(application$1.getPackageCodePath()), 268435456).detachFd();
        File fileResolve = FilesKt.resolve(application$1.getFilesDir(), "clash");
        fileResolve.mkdirs();
        String absolutePath = fileResolve.getAbsolutePath();
        String str = application$1.getPackageManager().getPackageInfo(application$1.getPackageName(), 0).versionName;
        if (str == null) {
            str = "unknown";
        }
        int i = Build.VERSION.SDK_INT;
        Log.d("KoalaClash", "Home = " + absolutePath, null);
        bridge.nativeInit(absolutePath, str, i);
    }

    private Bridge() {
    }

    private final native void nativeInit(String str, String str2, int i);

    public final native void nativeCloseAllConnections();

    public final native void nativeCloseConnection(String str);

    public final native String nativeCoreVersion();

    public final native void nativeForceGc();

    public final native void nativeHealthCheck(CompletableDeferred<Unit> completableDeferred, String str);

    public final native void nativeHealthCheckAll();

    public final native void nativeHealthCheckProxy(CompletableDeferred<Unit> completableDeferred, String str, String str2);

    public final native void nativeLoad(CompletableDeferred<Unit> completableDeferred, String str);

    public final native void nativeNotifyDnsChanged(String str);

    public final native void nativeNotifyInstalledAppChanged(String str);

    public final native void nativeNotifyTimeZoneChanged(String str, int i);

    public final native boolean nativePatchSelector(String str, String str2);

    public final native String nativeQueryConfiguration();

    public final native String nativeQueryConnections();

    public final native String nativeQueryGroup(String str, String str2);

    public final native String nativeQueryGroupNames(boolean z);

    public final native String nativeQueryProviders();

    public final native long nativeQueryTrafficNow();

    public final native long nativeQueryTrafficTotal();

    public final native String nativeQueryTunPackages(String str);

    public final native String nativeQueryTunnelState();

    public final native String nativeReadConfigMode();

    public final native String nativeReadOverrideMode();

    public final native void nativeReset();

    public final native String nativeStartHttp(String str);

    public final native void nativeStartTun(int i, String str, String str2, String str3, String str4, TunInterface tunInterface);

    public final native void nativeStopHttp();

    public final native void nativeStopTun();

    public final native void nativeSubscribeLogcat(LogcatInterface logcatInterface);

    public final native void nativeSuspend(boolean z);

    public final native void nativeUpdateProvider(CompletableDeferred<Unit> completableDeferred, String str, String str2);

    public final native void nativeValidate(FetchCallback fetchCallback, String str);

    public final native void nativeWriteOverrideMode(String str);
}
