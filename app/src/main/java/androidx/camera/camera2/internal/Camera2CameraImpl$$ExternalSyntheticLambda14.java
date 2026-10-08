package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda14 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Camera2CameraImpl f$0;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda14(Camera2CameraImpl camera2CameraImpl, int i) {
        this.$r8$classId = i;
        this.f$0 = camera2CameraImpl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.$r8$classId) {
            case 1:
                Camera2CameraImpl camera2CameraImpl = this.f$0;
                try {
                    camera2CameraImpl.mExecutor.execute(new Preview$$ExternalSyntheticLambda1(7, camera2CameraImpl, completer));
                    return "isMeteringRepeatingAttached";
                } catch (RejectedExecutionException unused) {
                    completer.setException(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
                    return "isMeteringRepeatingAttached";
                }
            default:
                Camera2CameraImpl camera2CameraImpl2 = this.f$0;
                try {
                    ArrayList arrayList = new ArrayList(camera2CameraImpl2.mUseCaseAttachState.getAttachedBuilder().build().mDeviceStateCallbacks);
                    arrayList.add((CaptureSessionRepository$1) camera2CameraImpl2.mCaptureSessionRepository.listener);
                    arrayList.add(new Camera2CameraImpl.AnonymousClass2(camera2CameraImpl2, completer));
                    camera2CameraImpl2.mCameraManager.mImpl.openCamera(camera2CameraImpl2.mCameraInfoInternal.mCameraId, camera2CameraImpl2.mExecutor, ComparisonsKt__ComparisonsKt.createComboCallback(arrayList));
                    return "configAndCloseTask";
                } catch (CameraAccessExceptionCompat | SecurityException e) {
                    camera2CameraImpl2.debugLog("Unable to open camera for configAndClose: " + e.getMessage(), e);
                    completer.setException(e);
                    return "configAndCloseTask";
                }
        }
    }
}
