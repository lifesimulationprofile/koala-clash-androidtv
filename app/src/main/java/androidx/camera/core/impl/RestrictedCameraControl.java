package androidx.camera.core.impl;

import androidx.lifecycle.Lifecycle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RestrictedCameraControl extends Lifecycle {
    public final CameraControlInternal mCameraControl;

    public RestrictedCameraControl(CameraControlInternal cameraControlInternal) {
        super(cameraControlInternal);
        this.mCameraControl = cameraControlInternal;
    }

    @Override // androidx.lifecycle.Lifecycle, androidx.camera.core.impl.CameraControlInternal
    public final ListenableFuture enableTorch(boolean z) {
        return this.mCameraControl.enableTorch(z);
    }
}
