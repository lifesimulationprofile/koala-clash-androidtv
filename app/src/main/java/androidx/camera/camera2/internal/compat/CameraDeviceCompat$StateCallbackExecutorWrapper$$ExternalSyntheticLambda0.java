package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.Camera2CameraImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Camera2CameraImpl.AnonymousClass2 f$0;
    public final /* synthetic */ CameraDevice f$1;

    public /* synthetic */ CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(Camera2CameraImpl.AnonymousClass2 anonymousClass2, CameraDevice cameraDevice, int i) {
        this.$r8$classId = i;
        this.f$0 = anonymousClass2;
        this.f$1 = cameraDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((CameraDevice.StateCallback) this.f$0.val$completer).onClosed(this.f$1);
                break;
            case 1:
                ((CameraDevice.StateCallback) this.f$0.val$completer).onDisconnected(this.f$1);
                break;
            default:
                ((CameraDevice.StateCallback) this.f$0.val$completer).onOpened(this.f$1);
                break;
        }
    }
}
