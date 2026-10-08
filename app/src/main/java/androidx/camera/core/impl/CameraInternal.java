package androidx.camera.core.impl;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.Camera;
import androidx.camera.core.UseCase;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public enum State {
        RELEASED(false),
        RELEASING(true),
        CLOSED(false),
        PENDING_OPEN(false),
        CLOSING(true),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true);

        public final boolean mHoldsCameraSlot;

        State(boolean z) {
            this.mHoldsCameraSlot = z;
        }
    }

    void attachUseCases(ArrayList arrayList);

    void detachUseCases(ArrayList arrayList);

    CameraControlInternal getCameraControlInternal();

    @Override // androidx.camera.core.Camera
    CameraInfoInternal getCameraInfo();

    CameraInfoInternal getCameraInfoInternal();

    Observable getCameraState();

    CameraConfig getExtendedConfig();

    boolean getHasTransform();

    boolean isFrontFacing();

    void setActiveResumingMode(boolean z);

    void setExtendedConfig(Toolbar.AnonymousClass1 anonymousClass1);

    void setPrimary(boolean z);
}
