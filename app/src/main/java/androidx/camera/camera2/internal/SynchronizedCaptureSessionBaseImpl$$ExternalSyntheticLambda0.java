package androidx.camera.camera2.internal;

import androidx.camera.core.Logger;
import java.util.LinkedHashSet;
import java.util.Objects;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$0;
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$1;

    public /* synthetic */ SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2, int i) {
        this.$r8$classId = i;
        this.f$0 = synchronizedCaptureSessionImpl;
        this.f$1 = synchronizedCaptureSessionImpl2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.f$0;
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = this.f$1;
                Objects.requireNonNull(synchronizedCaptureSessionImpl.mCaptureSessionStateCallback);
                synchronizedCaptureSessionImpl.mCaptureSessionStateCallback.onSessionFinished(synchronizedCaptureSessionImpl2);
                return;
            default:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl3 = this.f$0;
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl4 = this.f$1;
                Http2Connection.Builder builder = synchronizedCaptureSessionImpl3.mCaptureSessionRepository;
                synchronized (builder.socket) {
                    ((LinkedHashSet) builder.connectionName).remove(synchronizedCaptureSessionImpl3);
                    ((LinkedHashSet) builder.source).remove(synchronizedCaptureSessionImpl3);
                    break;
                }
                synchronizedCaptureSessionImpl3.onSessionFinished(synchronizedCaptureSessionImpl4);
                if (synchronizedCaptureSessionImpl3.mCameraCaptureSessionCompat != null) {
                    Objects.requireNonNull(synchronizedCaptureSessionImpl3.mCaptureSessionStateCallback);
                    synchronizedCaptureSessionImpl3.mCaptureSessionStateCallback.onClosed(synchronizedCaptureSessionImpl4);
                    return;
                } else {
                    Logger.w("SyncCaptureSessionBase", "[" + synchronizedCaptureSessionImpl3 + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
                    return;
                }
        }
    }
}
