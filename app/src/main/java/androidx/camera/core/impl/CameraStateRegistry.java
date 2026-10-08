package androidx.camera.core.impl;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.view.PreviewView;
import androidx.core.util.Preconditions;
import androidx.room.DatabaseConfiguration;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraStateRegistry {
    public int mAvailableCameras;
    public final DatabaseConfiguration mCameraCoordinator;
    public final HashMap mCameraStates;
    public final StringBuilder mDebugString = new StringBuilder();
    public final Object mLock;
    public int mMaxAllowedOpenedCameras;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CameraRegistration {
        public final SequentialExecutor mNotifyExecutor;
        public final PreviewView.AnonymousClass1 mOnConfigureAvailableListener;
        public final Camera2CameraImpl.CameraAvailability mOnOpenAvailableListener;
        public CameraInternal.State mState = null;

        public CameraRegistration(SequentialExecutor sequentialExecutor, PreviewView.AnonymousClass1 anonymousClass1, Camera2CameraImpl.CameraAvailability cameraAvailability) {
            this.mNotifyExecutor = sequentialExecutor;
            this.mOnConfigureAvailableListener = anonymousClass1;
            this.mOnOpenAvailableListener = cameraAvailability;
        }
    }

    public CameraStateRegistry(DatabaseConfiguration databaseConfiguration) {
        Object obj = new Object();
        this.mLock = obj;
        this.mCameraStates = new HashMap();
        this.mMaxAllowedOpenedCameras = 1;
        synchronized (obj) {
            this.mCameraCoordinator = databaseConfiguration;
            this.mAvailableCameras = this.mMaxAllowedOpenedCameras;
        }
    }

    public static void traceState(Camera2CameraImpl camera2CameraImpl, CameraInternal.State state) throws Throwable {
        if (Trace.isEnabled()) {
            Trace.setCounter("CX:State[" + camera2CameraImpl + "]", state.ordinal());
        }
    }

    public final CameraRegistration getCameraRegistration(String str) {
        HashMap map = this.mCameraStates;
        for (Camera camera : map.keySet()) {
            if (str.equals(camera.getCameraInfo().getCameraId())) {
                return (CameraRegistration) map.get(camera);
            }
        }
        return null;
    }

    public final void recalculateAvailableCameras() {
        boolean zIsDebugEnabled = Logger.isDebugEnabled("CameraStateRegistry");
        StringBuilder sb = this.mDebugString;
        if (zIsDebugEnabled) {
            sb.setLength(0);
            sb.append("Recalculating open cameras:\n");
            sb.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            sb.append("-------------------------------------------------------------------\n");
        }
        int i = 0;
        for (Map.Entry entry : this.mCameraStates.entrySet()) {
            if (Logger.isDebugEnabled("CameraStateRegistry")) {
                sb.append(String.format(Locale.US, "%-45s%-22s\n", ((Camera) entry.getKey()).toString(), ((CameraRegistration) entry.getValue()).mState != null ? ((CameraRegistration) entry.getValue()).mState.toString() : "UNKNOWN"));
            }
            CameraInternal.State state = ((CameraRegistration) entry.getValue()).mState;
            if (state != null && state.mHoldsCameraSlot) {
                i++;
            }
        }
        if (Logger.isDebugEnabled("CameraStateRegistry")) {
            sb.append("-------------------------------------------------------------------\n");
            Locale locale = Locale.US;
            sb.append("Open count: " + i + " (Max allowed: " + this.mMaxAllowedOpenedCameras + ")");
            Logger.d("CameraStateRegistry", sb.toString());
        }
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - i, 0);
    }

    public final boolean tryOpenCamera(Camera2CameraImpl camera2CameraImpl) {
        boolean z;
        synchronized (this.mLock) {
            try {
                CameraRegistration cameraRegistration = (CameraRegistration) this.mCameraStates.get(camera2CameraImpl);
                Preconditions.checkNotNull(cameraRegistration, "Camera must first be registered with registerCamera()");
                z = true;
                if (Logger.isDebugEnabled("CameraStateRegistry")) {
                    this.mDebugString.setLength(0);
                    StringBuilder sb = this.mDebugString;
                    Locale locale = Locale.US;
                    int i = this.mAvailableCameras;
                    CameraInternal.State state = cameraRegistration.mState;
                    boolean z2 = state != null && state.mHoldsCameraSlot;
                    sb.append("tryOpenCamera(" + camera2CameraImpl + ") [Available Cameras: " + i + ", Already Open: " + z2 + " (Previous state: " + cameraRegistration.mState + ")]");
                }
                if (this.mAvailableCameras > 0) {
                    CameraInternal.State state2 = CameraInternal.State.OPENING;
                    cameraRegistration.mState = state2;
                    traceState(camera2CameraImpl, state2);
                } else {
                    CameraInternal.State state3 = cameraRegistration.mState;
                    if (state3 != null && state3.mHoldsCameraSlot) {
                        CameraInternal.State state4 = CameraInternal.State.OPENING;
                        cameraRegistration.mState = state4;
                        traceState(camera2CameraImpl, state4);
                    } else {
                        z = false;
                    }
                }
                if (Logger.isDebugEnabled("CameraStateRegistry")) {
                    StringBuilder sb2 = this.mDebugString;
                    Locale locale2 = Locale.US;
                    sb2.append(" --> ".concat(z ? "SUCCESS" : "FAIL"));
                    Logger.d("CameraStateRegistry", this.mDebugString.toString());
                }
                if (z) {
                    recalculateAvailableCameras();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final boolean tryOpenCaptureSession(String str, String str2) {
        synchronized (this.mLock) {
            try {
                boolean z = true;
                if (this.mCameraCoordinator.journalMode != 2) {
                    return true;
                }
                CameraRegistration cameraRegistration = getCameraRegistration(str);
                CameraInternal.State state = cameraRegistration != null ? cameraRegistration.mState : null;
                CameraRegistration cameraRegistration2 = str2 != null ? getCameraRegistration(str2) : null;
                CameraInternal.State state2 = cameraRegistration2 != null ? cameraRegistration2.mState : null;
                CameraInternal.State state3 = CameraInternal.State.OPEN;
                boolean z2 = state3.equals(state) || CameraInternal.State.CONFIGURED.equals(state);
                boolean z3 = state3.equals(state2) || CameraInternal.State.CONFIGURED.equals(state2);
                if (!z2 || !z3) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
