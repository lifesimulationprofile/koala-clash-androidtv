package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConfigurationCompat {
    public static LocaleListCompat getLocales(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? new LocaleListCompat(new LocaleListPlatformWrapper(LocaleListCompat.Api24Impl.getLocales(configuration))) : LocaleListCompat.create(configuration.locale);
    }
}
