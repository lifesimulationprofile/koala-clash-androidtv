package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PrefetchScheduler_androidKt {
    public static final PrefetchScheduler_androidKt$RobolectricImpl$1 RobolectricImpl;

    static {
        String str = Build.FINGERPRINT;
        RobolectricImpl = (str == null || !str.toLowerCase(Locale.ROOT).equals("robolectric")) ? null : new PrefetchScheduler_androidKt$RobolectricImpl$1();
    }
}
