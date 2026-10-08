package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.Preconditions;
import kotlin.jvm.JvmClassMappingKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewTransformation {
    public boolean mHasCameraTransform;
    public boolean mIsFrontCamera;
    public int mPreviewRotationDegrees;
    public Size mResolution;
    public PreviewView.ScaleType mScaleType;
    public Matrix mSensorToBufferTransform;
    public Rect mSurfaceCropRect;
    public int mTargetRotation;

    public final void getPreviewViewToNormalizedSensorMatrix(Size size, int i, Rect rect) {
        Matrix matrix;
        if (isTransformationInfoReady()) {
            Matrix matrix2 = new Matrix();
            if (isTransformationInfoReady()) {
                Matrix matrix3 = new Matrix(this.mSensorToBufferTransform);
                matrix3.postConcat(getSurfaceToPreviewViewMatrix(size, i));
                matrix = matrix3;
            } else {
                matrix = null;
            }
            matrix.invert(matrix2);
            Matrix matrix4 = new Matrix();
            matrix4.setRectToRect(new RectF(0.0f, 0.0f, rect.width(), rect.height()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
            matrix2.postConcat(matrix4);
        }
    }

    public final Size getRotatedViewportSize() {
        return TransformUtils.is90or270(this.mPreviewRotationDegrees) ? new Size(this.mSurfaceCropRect.height(), this.mSurfaceCropRect.width()) : new Size(this.mSurfaceCropRect.width(), this.mSurfaceCropRect.height());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0078  */
    /* JADX WARN: Code duplicated, block: B:18:0x007b  */
    /* JADX WARN: Code duplicated, block: B:19:0x007e  */
    public final Matrix getSurfaceToPreviewViewMatrix(Size size, int i) {
        Matrix.ScaleToFit scaleToFit;
        RectF rectF;
        Preconditions.checkState(null, isTransformationInfoReady());
        if (TransformUtils.isAspectRatioMatchingWithRoundingError(size, true, getRotatedViewportSize())) {
            rectF = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        } else {
            RectF rectF2 = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
            Size rotatedViewportSize = getRotatedViewportSize();
            RectF rectF3 = new RectF(0.0f, 0.0f, rotatedViewportSize.getWidth(), rotatedViewportSize.getHeight());
            Matrix matrix = new Matrix();
            PreviewView.ScaleType scaleType = this.mScaleType;
            int iOrdinal = scaleType.ordinal();
            if (iOrdinal == 0) {
                scaleToFit = Matrix.ScaleToFit.START;
            } else if (iOrdinal == 1) {
                scaleToFit = Matrix.ScaleToFit.CENTER;
            } else if (iOrdinal == 2) {
                scaleToFit = Matrix.ScaleToFit.END;
            } else if (iOrdinal == 3) {
                scaleToFit = Matrix.ScaleToFit.START;
            } else if (iOrdinal == 4) {
                scaleToFit = Matrix.ScaleToFit.CENTER;
            } else if (iOrdinal != 5) {
                Logger.e("PreviewTransform", "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
            } else {
                scaleToFit = Matrix.ScaleToFit.END;
            }
            if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
                matrix.setRectToRect(rectF3, rectF2, scaleToFit);
            } else {
                matrix.setRectToRect(rectF2, rectF3, scaleToFit);
                matrix.invert(matrix);
            }
            matrix.mapRect(rectF3);
            if (i == 1) {
                float width = size.getWidth() / 2.0f;
                float f = width + width;
                rectF = new RectF(f - rectF3.right, rectF3.top, f - rectF3.left, rectF3.bottom);
            } else {
                rectF = rectF3;
            }
        }
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(this.mSurfaceCropRect), rectF, this.mPreviewRotationDegrees, false);
        if (this.mIsFrontCamera && this.mHasCameraTransform) {
            if (TransformUtils.is90or270(this.mPreviewRotationDegrees)) {
                rectToRect.preScale(1.0f, -1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
                return rectToRect;
            }
            rectToRect.preScale(-1.0f, 1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
        }
        return rectToRect;
    }

    public final Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState(null, isTransformationInfoReady());
        RectF rectF = new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight());
        return TransformUtils.getRectToRect(rectF, rectF, !this.mHasCameraTransform ? this.mPreviewRotationDegrees : -JvmClassMappingKt.surfaceRotationToDegrees(this.mTargetRotation), false);
    }

    public final RectF getTransformedSurfaceRect(Size size, int i) {
        Preconditions.checkState(null, isTransformationInfoReady());
        Matrix surfaceToPreviewViewMatrix = getSurfaceToPreviewViewMatrix(size, i);
        RectF rectF = new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight());
        surfaceToPreviewViewMatrix.mapRect(rectF);
        return rectF;
    }

    public final boolean isTransformationInfoReady() {
        return (this.mSurfaceCropRect == null || this.mResolution == null || !(!this.mHasCameraTransform || this.mTargetRotation != -1)) ? false : true;
    }
}
