package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.core.view.MenuHostHelper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraCharacteristicsCompat {
    public final PreviewView.AnonymousClass1 mCameraCharacteristicsImpl;
    public final String mCameraId;
    public final HashMap mValuesCache = new HashMap();
    public MenuHostHelper mStreamConfigurationMapCompat = null;

    public CameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mCameraCharacteristicsImpl = new CameraCharacteristicsApi28Impl(9, cameraCharacteristics);
        } else {
            this.mCameraCharacteristicsImpl = new PreviewView.AnonymousClass1(9, cameraCharacteristics);
        }
        this.mCameraId = str;
    }

    public final Object get(CameraCharacteristics.Key key) {
        if (key.equals(CameraCharacteristics.SENSOR_ORIENTATION)) {
            return ((CameraCharacteristics) this.mCameraCharacteristicsImpl.this$0).get(key);
        }
        synchronized (this) {
            try {
                Object obj = this.mValuesCache.get(key);
                if (obj != null) {
                    return obj;
                }
                Object obj2 = ((CameraCharacteristics) this.mCameraCharacteristicsImpl.this$0).get(key);
                if (obj2 != null) {
                    this.mValuesCache.put(key, obj2);
                }
                return obj2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final MenuHostHelper getStreamConfigurationMapCompat() {
        if (this.mStreamConfigurationMapCompat == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
                this.mStreamConfigurationMapCompat = new MenuHostHelper(streamConfigurationMap, new SurfaceRequest.AnonymousClass1(this.mCameraId, 10));
            } catch (AssertionError | NullPointerException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return this.mStreamConfigurationMapCompat;
    }
}
