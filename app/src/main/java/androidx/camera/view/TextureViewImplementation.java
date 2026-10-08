package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextureViewImplementation extends PreviewViewImplementation {
    public SurfaceTexture mDetachedSurfaceTexture;
    public boolean mIsSurfaceTextureDetachedFromView;
    public AtomicReference mNextFrameCompleter;
    public PreviewView$1$$ExternalSyntheticLambda2 mOnSurfaceNotInUseListener;
    public CallbackToFutureAdapter.SafeFuture mSurfaceReleaseFuture;
    public SurfaceRequest mSurfaceRequest;
    public SurfaceTexture mSurfaceTexture;
    public TextureView mTextureView;

    /* JADX INFO: renamed from: androidx.camera.view.TextureViewImplementation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Logger.d("TextureViewImpl", "SurfaceTexture available. Size: " + i + "x" + i2);
            TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
            textureViewImplementation.mSurfaceTexture = surfaceTexture;
            if (textureViewImplementation.mSurfaceReleaseFuture == null) {
                textureViewImplementation.tryToProvidePreviewSurface();
                return;
            }
            textureViewImplementation.mSurfaceRequest.getClass();
            Logger.d("TextureViewImpl", "Surface invalidated " + textureViewImplementation.mSurfaceRequest);
            textureViewImplementation.mSurfaceRequest.mInternalDeferrableSurface.close();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
            textureViewImplementation.mSurfaceTexture = null;
            CallbackToFutureAdapter.SafeFuture safeFuture = textureViewImplementation.mSurfaceReleaseFuture;
            if (safeFuture == null) {
                Logger.d("TextureViewImpl", "SurfaceTexture about to be destroyed");
                return true;
            }
            SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(20, this, surfaceTexture);
            safeFuture.addListener(new zzi(1, safeFuture, anonymousClass1), ContextCompat.getMainExecutor(textureViewImplementation.mTextureView.getContext()));
            textureViewImplementation.mDetachedSurfaceTexture = surfaceTexture;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Logger.d("TextureViewImpl", "SurfaceTexture size changed: " + i + "x" + i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) TextureViewImplementation.this.mNextFrameCompleter.getAndSet(null);
            if (completer != null) {
                completer.set(null);
            }
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final View getPreview() {
        return this.mTextureView;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final Bitmap getPreviewBitmap() {
        TextureView textureView = this.mTextureView;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.mTextureView.getBitmap();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final void onAttachedToWindow() {
        if (!this.mIsSurfaceTextureDetachedFromView || this.mDetachedSurfaceTexture == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.mDetachedSurfaceTexture;
        if (surfaceTexture != surfaceTexture2) {
            this.mTextureView.setSurfaceTexture(surfaceTexture2);
            this.mDetachedSurfaceTexture = null;
            this.mIsSurfaceTextureDetachedFromView = false;
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final void onDetachedFromWindow() {
        this.mIsSurfaceTextureDetachedFromView = true;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2) {
        Size size = surfaceRequest.mResolution;
        this.mResolution = size;
        this.mOnSurfaceNotInUseListener = previewView$1$$ExternalSyntheticLambda2;
        size.getClass();
        FrameLayout frameLayout = this.mParent;
        TextureView textureView = new TextureView(frameLayout.getContext());
        this.mTextureView = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mTextureView.setSurfaceTextureListener(new AnonymousClass1());
        frameLayout.removeAllViews();
        frameLayout.addView(this.mTextureView);
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        Executor mainExecutor = ContextCompat.getMainExecutor(this.mTextureView.getContext());
        Preview$$ExternalSyntheticLambda1 preview$$ExternalSyntheticLambda1 = new Preview$$ExternalSyntheticLambda1(22, this, surfaceRequest);
        ResolvableFuture resolvableFuture = surfaceRequest.mRequestCancellationCompleter.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(preview$$ExternalSyntheticLambda1, mainExecutor);
        }
        tryToProvidePreviewSurface();
    }

    public final void tryToProvidePreviewSurface() {
        SurfaceTexture surfaceTexture;
        Size size = this.mResolution;
        if (size == null || (surfaceTexture = this.mSurfaceTexture) == null || this.mSurfaceRequest == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.mResolution.getHeight());
        Surface surface = new Surface(this.mSurfaceTexture);
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        CallbackToFutureAdapter.SafeFuture future = CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(12, this, surface));
        this.mSurfaceReleaseFuture = future;
        future.delegate.addListener(new TextureViewImplementation$$ExternalSyntheticLambda2(this, surface, future, surfaceRequest, 0), ContextCompat.getMainExecutor(this.mTextureView.getContext()));
        this.mWasSurfaceProvided = true;
        redrawPreview();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public final ListenableFuture waitForNextFrame() {
        return CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(12, this));
    }
}
