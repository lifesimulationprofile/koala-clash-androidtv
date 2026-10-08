package androidx.camera.core.internal;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import kotlin.jvm.JvmClassMappingKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SupportedOutputSizesSorterLegacy {
    public final Rational mFullFovRatio;
    public final boolean mIsSensorLandscapeResolution;
    public final int mLensFacing;
    public final int mSensorOrientation;

    public SupportedOutputSizesSorterLegacy(CameraInfoInternal cameraInfoInternal, Rational rational) {
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        this.mFullFovRatio = rational;
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        this.mIsSensorLandscapeResolution = z;
    }

    public final Size getTargetSize(ImageOutputConfig imageOutputConfig) {
        int targetRotation = imageOutputConfig.getTargetRotation();
        Size targetResolution = imageOutputConfig.getTargetResolution();
        if (targetResolution != null) {
            int relativeImageRotation = JvmClassMappingKt.getRelativeImageRotation(JvmClassMappingKt.surfaceRotationToDegrees(targetRotation), this.mSensorOrientation, 1 == this.mLensFacing);
            if (relativeImageRotation == 90 || relativeImageRotation == 270) {
                return new Size(targetResolution.getHeight(), targetResolution.getWidth());
            }
        }
        return targetResolution;
    }
}
