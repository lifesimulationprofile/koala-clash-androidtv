package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraManagerCompat {
    public final ArrayMap mCameraCharacteristicsMap = new ArrayMap(4);
    public final SurfaceRequest.AnonymousClass1 mImpl;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        public final SequentialExecutor mExecutor;
        public final Camera2CameraImpl.CameraAvailability mWrappedCallback;
        public final Object mLock = new Object();
        public boolean mDisabled = false;

        public AvailabilityCallbackExecutorWrapper(SequentialExecutor sequentialExecutor, Camera2CameraImpl.CameraAvailability cameraAvailability) {
            this.mExecutor = sequentialExecutor;
            this.mWrappedCallback = cameraAvailability;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAccessPrioritiesChanged() {
            synchronized (this.mLock) {
                try {
                    if (!this.mDisabled) {
                        this.mExecutor.execute(new Preview$$ExternalSyntheticLambda0(8, this));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAvailable(String str) {
            synchronized (this.mLock) {
                try {
                    if (!this.mDisabled) {
                        this.mExecutor.execute(new CameraManagerCompat$AvailabilityCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, str, 0));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraUnavailable(String str) {
            synchronized (this.mLock) {
                try {
                    if (!this.mDisabled) {
                        this.mExecutor.execute(new CameraManagerCompat$AvailabilityCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, str, 1));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void setDisabled() {
            synchronized (this.mLock) {
                this.mDisabled = true;
            }
        }
    }

    public CameraManagerCompat(SurfaceRequest.AnonymousClass1 anonymousClass1) {
        this.mImpl = anonymousClass1;
    }

    public static CameraManagerCompat from(Context context, Handler handler) {
        SurfaceRequest.AnonymousClass1 cameraManagerCompatApi28Impl;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            cameraManagerCompatApi28Impl = new CameraManagerCompatApi30Impl(context, null);
        } else if (i >= 29) {
            cameraManagerCompatApi28Impl = new CameraManagerCompatApi29Impl(context, null);
        } else {
            cameraManagerCompatApi28Impl = i >= 28 ? new CameraManagerCompatApi28Impl(context, null) : new SurfaceRequest.AnonymousClass1(context, new CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21(handler));
        }
        return new CameraManagerCompat(cameraManagerCompatApi28Impl);
    }

    public final CameraCharacteristicsCompat getCameraCharacteristicsCompat(String str) {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        synchronized (this.mCameraCharacteristicsMap) {
            cameraCharacteristicsCompat = (CameraCharacteristicsCompat) this.mCameraCharacteristicsMap.get(str);
            if (cameraCharacteristicsCompat == null) {
                try {
                    CameraCharacteristicsCompat cameraCharacteristicsCompat2 = new CameraCharacteristicsCompat(this.mImpl.getCameraCharacteristics(str), str);
                    this.mCameraCharacteristicsMap.put(str, cameraCharacteristicsCompat2);
                    cameraCharacteristicsCompat = cameraCharacteristicsCompat2;
                } catch (AssertionError e) {
                    throw new CameraAccessExceptionCompat(e.getMessage(), e);
                }
            }
        }
        return cameraCharacteristicsCompat;
    }
}
