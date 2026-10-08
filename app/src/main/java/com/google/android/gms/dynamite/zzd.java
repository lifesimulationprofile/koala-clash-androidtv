package com.google.android.gms.dynamite;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.core.os.HandlerCompat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import kotlin.text.HexFormatKt;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzd extends ThreadLocal {
    public final /* synthetic */ int $r8$classId;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.$r8$classId) {
            case 0:
                return 0L;
            case 1:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return HexFormatKt.mainThreadExecutor();
                }
                if (Looper.myLooper() != null) {
                    return new HandlerScheduledExecutorService(new Handler(Looper.myLooper()));
                }
                return null;
            case 2:
                Choreographer choreographer = Choreographer.getInstance();
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper == null) {
                    throw new IllegalStateException("no Looper on this thread");
                }
                AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, HandlerCompat.createAsync(looperMyLooper));
                return CameraIdUtil.plus(androidUiDispatcher, androidUiDispatcher.frameClock);
            case 3:
                return new Random();
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(Util.UTC);
                return simpleDateFormat;
        }
    }
}
