package coil.decode;

import android.app.NotificationChannel;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ NotificationChannel m(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* bridge */ /* synthetic */ AdaptiveIconDrawable m(Drawable drawable) {
        return (AdaptiveIconDrawable) drawable;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m784m(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }
}
