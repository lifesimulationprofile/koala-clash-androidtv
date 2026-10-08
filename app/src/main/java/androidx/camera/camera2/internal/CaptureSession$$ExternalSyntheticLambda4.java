package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CaptureSession$$ExternalSyntheticLambda4 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ CaptureSession f$0;

    public /* synthetic */ CaptureSession$$ExternalSyntheticLambda4(CaptureSession captureSession) {
        this.f$0 = captureSession;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        String str;
        CaptureSession captureSession = this.f$0;
        synchronized (captureSession.mSessionLock) {
            Preconditions.checkState("Release completer expected to be null", captureSession.mReleaseCompleter == null);
            captureSession.mReleaseCompleter = completer;
            str = "Release[session=" + captureSession + "]";
        }
        return str;
    }

    public void onCaptureSequenceCompletedOrAborted() {
        CaptureSession captureSession = this.f$0;
        synchronized (captureSession.mSessionLock) {
            try {
                if (captureSession.mState == 5) {
                    captureSession.issueRepeatingCaptureRequests(captureSession.mSessionConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
