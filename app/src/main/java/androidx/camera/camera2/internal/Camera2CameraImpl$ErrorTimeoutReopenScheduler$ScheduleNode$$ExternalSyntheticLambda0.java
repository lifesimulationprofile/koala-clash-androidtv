package androidx.camera.camera2.internal;

import androidx.camera.core.SurfaceRequest;
import androidx.core.view.MenuHostHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MenuHostHelper f$0;

    public /* synthetic */ Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0(int i, MenuHostHelper menuHostHelper) {
        this.$r8$classId = i;
        this.f$0 = menuHostHelper;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                MenuHostHelper menuHostHelper = this.f$0;
                if (!((AtomicBoolean) menuHostHelper.mMenuProviders).getAndSet(true)) {
                    ((Camera2CameraImpl) ((SurfaceRequest.AnonymousClass1) menuHostHelper.mProviderToLifecycleContainers).val$requestCancellationFuture).mExecutor.execute(new Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0(1, menuHostHelper));
                    break;
                }
                break;
            default:
                MenuHostHelper menuHostHelper2 = this.f$0;
                if (((Camera2CameraImpl) ((SurfaceRequest.AnonymousClass1) menuHostHelper2.mProviderToLifecycleContainers).val$requestCancellationFuture).mState == 8) {
                    ((Camera2CameraImpl) ((SurfaceRequest.AnonymousClass1) menuHostHelper2.mProviderToLifecycleContainers).val$requestCancellationFuture).debugLog("Camera onError timeout, reopen it.", null);
                    ((Camera2CameraImpl) ((SurfaceRequest.AnonymousClass1) menuHostHelper2.mProviderToLifecycleContainers).val$requestCancellationFuture).setState(7);
                    ((Camera2CameraImpl) ((SurfaceRequest.AnonymousClass1) menuHostHelper2.mProviderToLifecycleContainers).val$requestCancellationFuture).mStateCallback.scheduleCameraReopen();
                } else {
                    Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) ((SurfaceRequest.AnonymousClass1) menuHostHelper2.mProviderToLifecycleContainers).val$requestCancellationFuture;
                    camera2CameraImpl.debugLog("Camera skip reopen at state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(camera2CameraImpl.mState)), null);
                }
                break;
        }
    }
}
