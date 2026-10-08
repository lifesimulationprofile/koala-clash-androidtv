package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.JvmClassMappingKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PreviewViewImplementation {
    public final FrameLayout mParent;
    public final PreviewTransformation mPreviewTransform;
    public Size mResolution;
    public boolean mWasSurfaceProvided = false;

    public PreviewViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        this.mParent = frameLayout;
        this.mPreviewTransform = previewTransformation;
    }

    public abstract View getPreview();

    public abstract Bitmap getPreviewBitmap();

    public abstract void onAttachedToWindow();

    public abstract void onDetachedFromWindow();

    public abstract void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2);

    public final void redrawPreview() {
        View preview = getPreview();
        if (preview == null || !this.mWasSurfaceProvided) {
            return;
        }
        FrameLayout frameLayout = this.mParent;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        PreviewTransformation previewTransformation = this.mPreviewTransform;
        previewTransformation.getClass();
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            Logger.w("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
            return;
        }
        if (previewTransformation.isTransformationInfoReady()) {
            if (preview instanceof TextureView) {
                ((TextureView) preview).setTransform(previewTransformation.getTextureViewCorrectionMatrix());
            } else {
                Display display = preview.getDisplay();
                boolean z = false;
                boolean z2 = (!previewTransformation.mHasCameraTransform || display == null || display.getRotation() == previewTransformation.mTargetRotation) ? false : true;
                boolean z3 = previewTransformation.mHasCameraTransform;
                if (!z3) {
                    if ((!z3 ? previewTransformation.mPreviewRotationDegrees : -JvmClassMappingKt.surfaceRotationToDegrees(previewTransformation.mTargetRotation)) != 0) {
                        z = true;
                    }
                }
                if (z2 || z) {
                    Logger.e("PreviewTransform", "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                }
            }
            RectF transformedSurfaceRect = previewTransformation.getTransformedSurfaceRect(size, layoutDirection);
            preview.setPivotX(0.0f);
            preview.setPivotY(0.0f);
            preview.setScaleX(transformedSurfaceRect.width() / previewTransformation.mResolution.getWidth());
            preview.setScaleY(transformedSurfaceRect.height() / previewTransformation.mResolution.getHeight());
            preview.setTranslationX(transformedSurfaceRect.left - preview.getLeft());
            preview.setTranslationY(transformedSurfaceRect.top - preview.getTop());
        }
    }

    public abstract ListenableFuture waitForNextFrame();
}
