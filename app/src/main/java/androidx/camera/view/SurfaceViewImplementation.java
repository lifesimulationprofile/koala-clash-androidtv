package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.ContextCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceViewImplementation extends PreviewViewImplementation {
    public final SurfaceRequestCallback mSurfaceRequestCallback;
    public SurfaceView mSurfaceView;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SurfaceRequestCallback implements SurfaceHolder.Callback {
        public Size mCurrentSurfaceSize;
        public PreviewView$1$$ExternalSyntheticLambda2 mOnSurfaceNotInUseListener;
        public SurfaceRequest mSurfaceRequest;
        public SurfaceRequest mSurfaceRequestToBeInvalidated;
        public Size mTargetSize;
        public boolean mWasSurfaceProvided = false;
        public boolean mNeedToInvalidate = false;

        public SurfaceRequestCallback() {
        }

        public final void cancelPreviousRequest() {
            if (this.mSurfaceRequest != null) {
                Logger.d("SurfaceViewImpl", "Request canceled: " + this.mSurfaceRequest);
                this.mSurfaceRequest.willNotProvideSurface();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Logger.d("SurfaceViewImpl", "Surface changed. Size: " + i2 + "x" + i3);
            this.mCurrentSurfaceSize = new Size(i2, i3);
            tryToComplete();
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            SurfaceRequest surfaceRequest;
            Logger.d("SurfaceViewImpl", "Surface created.");
            if (!this.mNeedToInvalidate || (surfaceRequest = this.mSurfaceRequestToBeInvalidated) == null) {
                return;
            }
            surfaceRequest.willNotProvideSurface();
            surfaceRequest.mSurfaceRecreationCompleter.set(null);
            this.mSurfaceRequestToBeInvalidated = null;
            this.mNeedToInvalidate = false;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Logger.d("SurfaceViewImpl", "Surface destroyed.");
            if (!this.mWasSurfaceProvided) {
                cancelPreviousRequest();
            } else if (this.mSurfaceRequest != null) {
                Logger.d("SurfaceViewImpl", "Surface closed " + this.mSurfaceRequest);
                this.mSurfaceRequest.mInternalDeferrableSurface.close();
            }
            this.mNeedToInvalidate = true;
            SurfaceRequest surfaceRequest = this.mSurfaceRequest;
            if (surfaceRequest != null) {
                this.mSurfaceRequestToBeInvalidated = surfaceRequest;
            }
            this.mWasSurfaceProvided = false;
            this.mSurfaceRequest = null;
            this.mOnSurfaceNotInUseListener = null;
            this.mCurrentSurfaceSize = null;
            this.mTargetSize = null;
        }

        public final boolean tryToComplete() {
            SurfaceViewImplementation surfaceViewImplementation = SurfaceViewImplementation.this;
            Surface surface = surfaceViewImplementation.mSurfaceView.getHolder().getSurface();
            if (this.mWasSurfaceProvided || this.mSurfaceRequest == null || !Objects.equals(this.mTargetSize, this.mCurrentSurfaceSize)) {
                return false;
            }
            Logger.d("SurfaceViewImpl", "Surface set on Preview.");
            PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2 = this.mOnSurfaceNotInUseListener;
            SurfaceRequest surfaceRequest = this.mSurfaceRequest;
            Objects.requireNonNull(surfaceRequest);
            surfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(surfaceViewImplementation.mSurfaceView.getContext()), new CaptureNode$$ExternalSyntheticLambda3(2, previewView$1$$ExternalSyntheticLambda2));
            this.mWasSurfaceProvided = true;
            surfaceViewImplementation.mWasSurfaceProvided = true;
            surfaceViewImplementation.redrawPreview();
            return true;
        }
    }

    public SurfaceViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
        this.mSurfaceRequestCallback = new SurfaceRequestCallback();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final View getPreview() {
        return this.mSurfaceView;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.camera.view.SurfaceViewImplementation$$ExternalSyntheticLambda2] */
    @Override // androidx.camera.view.PreviewViewImplementation
    public final Bitmap getPreviewBitmap() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.mSurfaceView.getHolder().getSurface().isValid()) {
            return null;
        }
        final Semaphore semaphore = new Semaphore(0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        PixelCopy.request(this.mSurfaceView, bitmapCreateBitmap, (PixelCopy.OnPixelCopyFinishedListener) new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.camera.view.SurfaceViewImplementation$$ExternalSyntheticLambda2
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                Semaphore semaphore2 = semaphore;
                if (i == 0) {
                    Logger.d("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
                } else {
                    Logger.e("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i);
                }
                semaphore2.release();
            }
        }, new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(1, 100L, TimeUnit.MILLISECONDS)) {
                Logger.e("SurfaceViewImpl", "Timed out while trying to acquire screenshot.");
            }
            return bitmapCreateBitmap;
        } catch (InterruptedException e) {
            Logger.e("SurfaceViewImpl", "Interrupted while trying to acquire screenshot.", e);
            return bitmapCreateBitmap;
        } finally {
            handlerThread.quitSafely();
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2) {
        SurfaceView surfaceView = this.mSurfaceView;
        boolean zEquals = Objects.equals(this.mResolution, surfaceRequest.mResolution);
        if (surfaceView == null || !zEquals) {
            Size size = surfaceRequest.mResolution;
            this.mResolution = size;
            size.getClass();
            FrameLayout frameLayout = this.mParent;
            SurfaceView surfaceView2 = new SurfaceView(frameLayout.getContext());
            this.mSurfaceView = surfaceView2;
            surfaceView2.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
            frameLayout.removeAllViews();
            frameLayout.addView(this.mSurfaceView);
            this.mSurfaceView.getHolder().addCallback(this.mSurfaceRequestCallback);
        }
        Executor mainExecutor = ContextCompat.getMainExecutor(this.mSurfaceView.getContext());
        Preview$$ExternalSyntheticLambda0 preview$$ExternalSyntheticLambda0 = new Preview$$ExternalSyntheticLambda0(23, previewView$1$$ExternalSyntheticLambda2);
        ResolvableFuture resolvableFuture = surfaceRequest.mRequestCancellationCompleter.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(preview$$ExternalSyntheticLambda0, mainExecutor);
        }
        this.mSurfaceView.post(new LiveDataObservable$$ExternalSyntheticLambda1(this, surfaceRequest, previewView$1$$ExternalSyntheticLambda2, 9));
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final ListenableFuture waitForNextFrame() {
        return ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final void onAttachedToWindow() {
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final void onDetachedFromWindow() {
    }
}
