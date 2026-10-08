package kotlin.comparisons;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.CameraDeviceStateCallbacks$NoOpDeviceStateCallback;
import androidx.camera.camera2.internal.CaptureSessionRepository$1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComparisonsKt__ComparisonsKt {
    public static int compareValues(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static CameraDevice.StateCallback createComboCallback(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return new CameraDeviceStateCallbacks$NoOpDeviceStateCallback();
        }
        return arrayList.size() == 1 ? (CameraDevice.StateCallback) arrayList.get(0) : new CaptureSessionRepository$1(arrayList);
    }
}
