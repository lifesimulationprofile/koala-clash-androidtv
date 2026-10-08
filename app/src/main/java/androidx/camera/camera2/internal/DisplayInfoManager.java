package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.Size;
import android.view.Display;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.camera.core.internal.utils.SizeUtil;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DisplayInfoManager {
    public static volatile DisplayInfoManager sInstance;
    public final DisplayManager mDisplayManager;
    public static final Size MAX_PREVIEW_SIZE = new Size(1920, 1080);
    public static final Size ABNORMAL_DISPLAY_SIZE_THRESHOLD = new Size(320, 240);
    public static final Size FALLBACK_DISPLAY_SIZE = new Size(640, 480);
    public static final Object INSTANCE_LOCK = new Object();
    public volatile Size mPreviewSize = null;
    public final Toolbar.AnonymousClass1 mMaxPreviewSize = new Toolbar.AnonymousClass1(12);
    public final Toolbar.AnonymousClass1 mDisplaySizeCorrector = new Toolbar.AnonymousClass1(10);

    public DisplayInfoManager(Context context) {
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
    }

    public static DisplayInfoManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (INSTANCE_LOCK) {
                try {
                    if (sInstance == null) {
                        sInstance = new DisplayInfoManager(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public static Display getMaxSizeDisplayInternal(Display[] displayArr, boolean z) {
        Display display = null;
        int i = -1;
        for (Display display2 : displayArr) {
            if (!z || display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i2 = point.x * point.y;
                if (i2 > i) {
                    display = display2;
                    i = i2;
                }
            }
        }
        return display;
    }

    public final Size calculatePreviewSize() {
        Size verifiedResolution;
        Point point = new Point();
        getMaxSizeDisplay(false).getRealSize(point);
        Size size = new Size(point.x, point.y);
        Size size2 = SizeUtil.RESOLUTION_ZERO;
        if (size.getHeight() * size.getWidth() < SizeUtil.getArea(ABNORMAL_DISPLAY_SIZE_THRESHOLD)) {
            size = ((SmallDisplaySizeQuirk) this.mDisplaySizeCorrector.this$0) != null ? (Size) SmallDisplaySizeQuirk.MODEL_TO_DISPLAY_SIZE_MAP.get(Build.MODEL.toUpperCase(Locale.US)) : null;
            if (size == null) {
                size = FALLBACK_DISPLAY_SIZE;
            }
        }
        if (size.getHeight() > size.getWidth()) {
            size = new Size(size.getHeight(), size.getWidth());
        }
        int height = size.getHeight() * size.getWidth();
        Size size3 = MAX_PREVIEW_SIZE;
        if (height > size3.getHeight() * size3.getWidth()) {
            size = size3;
        }
        if (((ExtraCroppingQuirk) this.mMaxPreviewSize.this$0) != null && (verifiedResolution = ExtraCroppingQuirk.getVerifiedResolution(1)) != null) {
            if (verifiedResolution.getHeight() * verifiedResolution.getWidth() > size.getHeight() * size.getWidth()) {
                return verifiedResolution;
            }
        }
        return size;
    }

    public final Display getMaxSizeDisplay(boolean z) {
        Display[] displays = this.mDisplayManager.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display maxSizeDisplayInternal = getMaxSizeDisplayInternal(displays, z);
        if (maxSizeDisplayInternal == null && z) {
            maxSizeDisplayInternal = getMaxSizeDisplayInternal(displays, false);
        }
        if (maxSizeDisplayInternal != null) {
            return maxSizeDisplayInternal;
        }
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    }

    public final Size getPreviewSize() {
        if (this.mPreviewSize != null) {
            return this.mPreviewSize;
        }
        this.mPreviewSize = calculatePreviewSize();
        return this.mPreviewSize;
    }
}
