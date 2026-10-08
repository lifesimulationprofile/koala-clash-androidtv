package androidx.camera.core.internal.utils;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SizeUtil {
    public static final Size RESOLUTION_1080P;
    public static final Size RESOLUTION_1440P;
    public static final Size RESOLUTION_480P;
    public static final Size RESOLUTION_720P;
    public static final Size RESOLUTION_VGA;
    public static final Size RESOLUTION_ZERO = new Size(0, 0);

    static {
        new Size(320, 240);
        RESOLUTION_VGA = new Size(640, 480);
        RESOLUTION_480P = new Size(720, 480);
        RESOLUTION_720P = new Size(1280, 720);
        RESOLUTION_1080P = new Size(1920, 1080);
        RESOLUTION_1440P = new Size(1920, 1440);
    }

    public static int getArea(Size size) {
        return size.getHeight() * size.getWidth();
    }
}
