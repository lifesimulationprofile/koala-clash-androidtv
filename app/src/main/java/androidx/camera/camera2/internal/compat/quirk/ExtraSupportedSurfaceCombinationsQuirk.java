package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.impl.AutoValue_SurfaceConfig;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig$ConfigSize;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ExtraSupportedSurfaceCombinationsQuirk implements Quirk {
    public static final SurfaceCombination FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION;
    public static final SurfaceCombination LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION;
    public static final HashSet SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS;
    public static final HashSet SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS;

    static {
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.VGA;
        CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombination);
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize2 = SurfaceConfig$ConfigSize.PREVIEW;
        CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize2, 0L, surfaceCombination);
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize3 = SurfaceConfig$ConfigSize.MAXIMUM;
        CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize3, 0L, surfaceCombination);
        FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION = surfaceCombination;
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
        surfaceCombination2.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize, 0L));
        CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize3, 0L, surfaceCombination2);
        LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION = surfaceCombination2;
        SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS = new HashSet(Arrays.asList("PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"));
        SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS = new HashSet(Arrays.asList("SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26"));
    }

    public static boolean supportExtraLevel3ConfigurationsSamsungDevice() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String upperCase = Build.MODEL.toUpperCase(Locale.US);
        Iterator it = SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS.iterator();
        while (it.hasNext()) {
            if (upperCase.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
