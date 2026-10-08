package androidx.camera.core.impl;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RestrictedCameraInfo extends ForwardingCameraInfo {
    public final Toolbar.AnonymousClass1 mCameraConfig;
    public final CameraInfoInternal mCameraInfo;

    public RestrictedCameraInfo(CameraInfoInternal cameraInfoInternal, Toolbar.AnonymousClass1 anonymousClass1) {
        super(cameraInfoInternal);
        this.mCameraInfo = cameraInfoInternal;
        this.mCameraConfig = anonymousClass1;
        anonymousClass1.getSessionProcessor();
        AutoValue_Config_Option autoValue_Config_Option = CameraConfig.OPTION_POSTVIEW_SUPPORTED;
        Boolean bool = Boolean.FALSE;
        ((Boolean) ((OptionsBundle) anonymousClass1.getConfig()).retrieveOption(autoValue_Config_Option, bool)).getClass();
        ((Boolean) ((OptionsBundle) anonymousClass1.getConfig()).retrieveOption(CameraConfig.OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED, bool)).getClass();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public final CameraInfoInternal getImplementation() {
        return this.mCameraInfo;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public final LiveData getTorchState() {
        return this.mCameraInfo.getTorchState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public final boolean hasFlashUnit() {
        return this.mCameraInfo.hasFlashUnit();
    }
}
