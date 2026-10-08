package kotlin.text;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzu;
import io.github.g00fy2.quickie.content.QRContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HexFormatKt {
    public static final boolean access$isCaseSensitive(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Intrinsics.compare((int) cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public static zzt directExecutor() {
        if (zzt.sDirectExecutor != null) {
            return zzt.sDirectExecutor;
        }
        synchronized (zzt.class) {
            try {
                if (zzt.sDirectExecutor == null) {
                    zzt.sDirectExecutor = new zzt(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzt.sDirectExecutor;
    }

    public static zzu highPriorityExecutor() {
        if (zzu.sExecutor != null) {
            return zzu.sExecutor;
        }
        synchronized (zzu.class) {
            try {
                if (zzu.sExecutor == null) {
                    zzu.sExecutor = new zzu(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzu.sExecutor;
    }

    public static zabk ioExecutor() {
        if (zabk.sExecutor != null) {
            return zabk.sExecutor;
        }
        synchronized (zabk.class) {
            try {
                if (zabk.sExecutor == null) {
                    zabk.sExecutor = new zabk();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zabk.sExecutor;
    }

    public static HandlerScheduledExecutorService mainThreadExecutor() {
        if (QRContent.sInstance != null) {
            return QRContent.sInstance;
        }
        synchronized (QRContent.class) {
            try {
                if (QRContent.sInstance == null) {
                    QRContent.sInstance = new HandlerScheduledExecutorService(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return QRContent.sInstance;
    }
}
