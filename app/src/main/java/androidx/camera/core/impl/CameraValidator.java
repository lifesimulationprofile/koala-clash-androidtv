package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.core.widget.TextViewCompat;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CameraValidator {
    public static final CameraSelector EXTERNAL_LENS_FACING;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CameraIdListIncorrectException extends Exception {
        public final int mAvailableCameraCount;

        public CameraIdListIncorrectException(String str, int i, IllegalArgumentException illegalArgumentException) {
            super(str, illegalArgumentException);
            this.mAvailableCameraCount = i;
        }
    }

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new LensFacingCameraFilter(2));
        EXTERNAL_LENS_FACING = new CameraSelector(linkedHashSet);
    }

    public static void validateCameras(Context context, SurfaceRequest.AnonymousClass1 anonymousClass1, CameraSelector cameraSelector) throws CameraIdListIncorrectException {
        Integer lensFacing;
        int i = 0;
        IllegalArgumentException illegalArgumentException = null;
        if (Build.VERSION.SDK_INT >= 34 && TextViewCompat.Api34Impl.getDeviceId(context) != 0) {
            LinkedHashSet cameras = anonymousClass1.getCameras();
            if (cameras.isEmpty()) {
                throw new CameraIdListIncorrectException("No cameras available", 0, null);
            }
            Logger.d("CameraValidator", "Virtual device with ID: " + TextViewCompat.Api34Impl.getDeviceId(context) + " has " + cameras.size() + " cameras. Skipping validation.");
            return;
        }
        if (cameraSelector != null) {
            try {
                lensFacing = cameraSelector.getLensFacing();
                if (lensFacing == null) {
                    Logger.w("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e) {
                Logger.e("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
                return;
            }
        } else {
            lensFacing = null;
        }
        Logger.d("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + lensFacing);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (cameraSelector == null || lensFacing.intValue() == 1)) {
                CameraSelector.DEFAULT_BACK_CAMERA.select(anonymousClass1.getCameras());
                i = 1;
            }
        } catch (IllegalArgumentException e2) {
            illegalArgumentException = e2;
            Logger.w("CameraValidator", "Camera LENS_FACING_BACK verification failed", illegalArgumentException);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front") && (cameraSelector == null || lensFacing.intValue() == 0)) {
                CameraSelector.DEFAULT_FRONT_CAMERA.select(anonymousClass1.getCameras());
                i++;
            }
        } catch (IllegalArgumentException e3) {
            illegalArgumentException = e3;
            Logger.w("CameraValidator", "Camera LENS_FACING_FRONT verification failed", illegalArgumentException);
        }
        try {
            EXTERNAL_LENS_FACING.select(anonymousClass1.getCameras());
            Logger.d("CameraValidator", "Found a LENS_FACING_EXTERNAL camera");
            i++;
        } catch (IllegalArgumentException unused) {
        }
        if (illegalArgumentException == null) {
            return;
        }
        Logger.e("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + anonymousClass1.getCameras());
        throw new CameraIdListIncorrectException("Expected camera missing from device.", i, illegalArgumentException);
    }
}
