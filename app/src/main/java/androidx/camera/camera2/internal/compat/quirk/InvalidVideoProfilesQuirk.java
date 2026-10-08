package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class InvalidVideoProfilesQuirk implements Quirk {
    public static final List AFFECTED_PIXEL_MODELS = Arrays.asList("pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro");
    public static final List AFFECTED_ONE_PLUS_MODELS = Arrays.asList("cph2417", "cph2451");
    public static final List AFFECTED_OPPO_MODELS = Arrays.asList("cph2437", "cph2525", "pht110");
}
