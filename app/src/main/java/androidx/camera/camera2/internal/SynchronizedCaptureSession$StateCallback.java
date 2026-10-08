package androidx.camera.camera2.internal;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SynchronizedCaptureSession$StateCallback {
    public abstract void onConfigureFailed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public abstract void onConfigured(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public abstract void onReady(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public abstract void onSessionFinished(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public void onActive(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
    }

    public void onCaptureQueueEmpty(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
    }

    public void onClosed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
    }

    public void onSurfacePrepared(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, Surface surface) {
    }
}
