package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface DynamicRangesCompat$DynamicRangeProfilesCompatImpl {
    Set getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange);

    Set getSupportedDynamicRanges();

    DynamicRangeProfiles unwrap();
}
