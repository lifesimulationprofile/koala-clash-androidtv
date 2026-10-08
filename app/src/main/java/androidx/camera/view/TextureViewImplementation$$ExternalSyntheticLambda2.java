package androidx.camera.view;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextureViewImplementation$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ TextureViewImplementation$$ExternalSyntheticLambda2(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                TextureViewImplementation textureViewImplementation = (TextureViewImplementation) this.f$0;
                Surface surface = (Surface) this.f$1;
                CallbackToFutureAdapter.SafeFuture safeFuture = (CallbackToFutureAdapter.SafeFuture) this.f$2;
                SurfaceRequest surfaceRequest = (SurfaceRequest) this.f$3;
                Logger.d("TextureViewImpl", "Safe to release surface.");
                PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2 = textureViewImplementation.mOnSurfaceNotInUseListener;
                if (previewView$1$$ExternalSyntheticLambda2 != null) {
                    previewView$1$$ExternalSyntheticLambda2.onSurfaceNotInUse();
                    textureViewImplementation.mOnSurfaceNotInUseListener = null;
                }
                surface.release();
                if (textureViewImplementation.mSurfaceReleaseFuture == safeFuture) {
                    textureViewImplementation.mSurfaceReleaseFuture = null;
                }
                if (textureViewImplementation.mSurfaceRequest == surfaceRequest) {
                    textureViewImplementation.mSurfaceRequest = null;
                }
                break;
            case 1:
                CameraBurstCaptureCallback cameraBurstCaptureCallback = (CameraBurstCaptureCallback) this.f$0;
                ((CameraCaptureSession.CaptureCallback) cameraBurstCaptureCallback.mCallbackMap).onCaptureCompleted((CameraCaptureSession) this.f$1, (CaptureRequest) this.f$2, (TotalCaptureResult) this.f$3);
                break;
            case 2:
                CameraBurstCaptureCallback cameraBurstCaptureCallback2 = (CameraBurstCaptureCallback) this.f$0;
                ((CameraCaptureSession.CaptureCallback) cameraBurstCaptureCallback2.mCallbackMap).onCaptureProgressed((CameraCaptureSession) this.f$1, (CaptureRequest) this.f$2, (CaptureResult) this.f$3);
                break;
            default:
                CameraBurstCaptureCallback cameraBurstCaptureCallback3 = (CameraBurstCaptureCallback) this.f$0;
                ((CameraCaptureSession.CaptureCallback) cameraBurstCaptureCallback3.mCallbackMap).onCaptureFailed((CameraCaptureSession) this.f$1, (CaptureRequest) this.f$2, (CaptureFailure) this.f$3);
                break;
        }
    }
}
