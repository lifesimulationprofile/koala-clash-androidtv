package androidx.camera.camera2.internal;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusMeteringControl {
    public static final MeteringRectangle[] EMPTY_RECTANGLES = new MeteringRectangle[0];
    public MeteringRectangle[] mAeRects;
    public MeteringRectangle[] mAfRects;
    public MeteringRectangle[] mAwbRects;
    public final Camera2CameraControlImpl mCameraControl;
    public final boolean mIsExternalFlashAeModeEnabled;
    public volatile boolean mIsActive = false;
    public int mTemplate = 1;

    public FocusMeteringControl(Camera2CameraControlImpl camera2CameraControlImpl, SequentialExecutor sequentialExecutor) {
        MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr;
        this.mAwbRects = meteringRectangleArr;
        this.mIsExternalFlashAeModeEnabled = false;
        this.mCameraControl = camera2CameraControlImpl;
    }
}
