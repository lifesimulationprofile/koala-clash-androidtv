package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Preconditions;
import java.util.LinkedHashSet;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$0;

    public /* synthetic */ SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, int i) {
        this.$r8$classId = i;
        this.f$0 = synchronizedCaptureSessionImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.f$0;
                synchronizedCaptureSessionImpl.debugLog("Session call super.close()");
                Preconditions.checkNotNull(synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
                Http2Connection.Builder builder = synchronizedCaptureSessionImpl.mCaptureSessionRepository;
                synchronized (builder.socket) {
                    ((LinkedHashSet) builder.source).add(synchronizedCaptureSessionImpl);
                    break;
                }
                ((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat.this$0).val$requestCancellationCompleter).close();
                synchronizedCaptureSessionImpl.mExecutor.execute(new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0(synchronizedCaptureSessionImpl, 1));
                return;
            default:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = this.f$0;
                synchronizedCaptureSessionImpl2.onSessionFinished(synchronizedCaptureSessionImpl2);
                return;
        }
    }
}
