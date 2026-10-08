package androidx.compose.ui.text.intl;

import android.os.Build;
import androidx.core.view.MenuHostHelper;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformLocaleKt {
    public static final PlatformLocaleDelegate platformLocaleDelegate;

    static {
        platformLocaleDelegate = Build.VERSION.SDK_INT >= 24 ? new MenuHostHelper(25) : new Path.Companion();
    }
}
