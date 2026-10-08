package androidx.camera.camera2.internal;

import android.text.TextUtils;
import androidx.camera.core.Preview;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Camera2CameraImpl f$0;
    public final /* synthetic */ ArrayList f$1;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda5(Camera2CameraImpl camera2CameraImpl, ArrayList arrayList, int i) {
        this.$r8$classId = i;
        this.f$0 = camera2CameraImpl;
        this.f$1 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        MenuHostHelper menuHostHelper;
        switch (this.$r8$classId) {
            case 0:
                Camera2CameraImpl camera2CameraImpl = this.f$0;
                ArrayList arrayList = this.f$1;
                Camera2CameraControlImpl camera2CameraControlImpl = camera2CameraImpl.mCameraControlInternal;
                try {
                    camera2CameraImpl.tryAttachUseCases(arrayList);
                    return;
                } finally {
                    camera2CameraControlImpl.decrementUseCount();
                }
            default:
                Camera2CameraImpl camera2CameraImpl2 = this.f$0;
                ArrayList arrayList2 = this.f$1;
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                boolean z = false;
                boolean z2 = false;
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    AutoValue_Camera2CameraImpl_UseCaseInfo autoValue_Camera2CameraImpl_UseCaseInfo = (AutoValue_Camera2CameraImpl_UseCaseInfo) obj;
                    if (camera2CameraImpl2.mUseCaseAttachState.isUseCaseAttached(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseId)) {
                        ((LinkedHashMap) camera2CameraImpl2.mUseCaseAttachState.val$requestCancellationFuture).remove(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseId);
                        arrayList3.add(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseId);
                        if (autoValue_Camera2CameraImpl_UseCaseInfo.useCaseType == Preview.class) {
                            z2 = true;
                        }
                    }
                }
                if (arrayList3.isEmpty()) {
                    return;
                }
                camera2CameraImpl2.debugLog("Use cases [" + TextUtils.join(", ", arrayList3) + "] now DETACHED for camera", null);
                if (z2) {
                    camera2CameraImpl2.mCameraControlInternal.mFocusMeteringControl.getClass();
                }
                camera2CameraImpl2.addOrRemoveMeteringRepeatingUseCase();
                if (camera2CameraImpl2.mUseCaseAttachState.getAttachedUseCaseConfigs().isEmpty()) {
                    camera2CameraImpl2.mCameraControlInternal.mZslControl.mIsZslDisabledByUseCaseConfig = false;
                } else {
                    camera2CameraImpl2.updateZslDisabledByUseCaseConfigStatus();
                }
                if (!camera2CameraImpl2.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty()) {
                    camera2CameraImpl2.updateCaptureSessionConfig();
                    camera2CameraImpl2.resetCaptureSession();
                    if (camera2CameraImpl2.mState == 9) {
                        camera2CameraImpl2.openCaptureSession();
                        return;
                    }
                    return;
                }
                camera2CameraImpl2.mCameraControlInternal.decrementUseCount();
                camera2CameraImpl2.resetCaptureSession();
                camera2CameraImpl2.mCameraControlInternal.setActive(false);
                camera2CameraImpl2.mCaptureSession = camera2CameraImpl2.newCaptureSession();
                camera2CameraImpl2.debugLog("Closing camera.", null);
                switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(camera2CameraImpl2.mState)) {
                    case 3:
                        Preconditions.checkState(null, camera2CameraImpl2.mCameraDevice == null);
                        camera2CameraImpl2.setState(3);
                        return;
                    case 4:
                    default:
                        camera2CameraImpl2.debugLog("close() ignored due to being in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(camera2CameraImpl2.mState)), null);
                        return;
                    case 5:
                    case 6:
                    case 7:
                        if (camera2CameraImpl2.mStateCallback.cancelScheduledReopen() || ((menuHostHelper = (MenuHostHelper) camera2CameraImpl2.mErrorTimeoutReopenScheduler.val$requestCancellationCompleter) != null && !((AtomicBoolean) menuHostHelper.mMenuProviders).get())) {
                            z = true;
                        }
                        camera2CameraImpl2.mErrorTimeoutReopenScheduler.cancel();
                        camera2CameraImpl2.setState(5);
                        if (z) {
                            Preconditions.checkState(null, camera2CameraImpl2.mReleasedCaptureSessions.isEmpty());
                            camera2CameraImpl2.configAndCloseIfNeeded();
                            return;
                        }
                        return;
                    case 8:
                    case 9:
                        camera2CameraImpl2.setState(5);
                        camera2CameraImpl2.closeCamera();
                        return;
                }
        }
    }
}
