package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraCaptureSessionCompat$StateCallbackExecutorWrapper extends CameraCaptureSession.StateCallback {
    public final Executor mExecutor;
    public final CameraCaptureSession.StateCallback mWrappedCallback;

    public CameraCaptureSessionCompat$StateCallbackExecutorWrapper(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        this.mExecutor = executor;
        this.mWrappedCallback = stateCallback;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onActive(CameraCaptureSession cameraCaptureSession) {
        this.mExecutor.execute(new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraCaptureSession, 0));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
        this.mExecutor.execute(new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraCaptureSession, 2));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onClosed(CameraCaptureSession cameraCaptureSession) {
        this.mExecutor.execute(new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraCaptureSession, 1));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        this.mExecutor.execute(new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraCaptureSession, 5));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        this.mExecutor.execute(new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraCaptureSession, 3));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onReady(CameraCaptureSession cameraCaptureSession) {
        this.mExecutor.execute(new CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraCaptureSession, 4));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
        this.mExecutor.execute(new LiveDataObservable$$ExternalSyntheticLambda1(this, cameraCaptureSession, surface, 2));
    }
}
