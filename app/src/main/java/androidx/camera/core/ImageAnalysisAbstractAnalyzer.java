package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import coil.intercept.RealInterceptorChain;
import coil.network.HttpException;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import kotlin.io.CloseableKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    public volatile boolean mOnePixelShiftEnabled;
    public volatile boolean mOutputImageRotationEnabled;
    public volatile int mPrevBufferRotationDegrees;
    public RealInterceptorChain mProcessedImageReaderProxy;
    public ImageWriter mProcessedImageWriter;
    public ByteBuffer mRGBConvertedBuffer;
    public volatile int mRelativeRotation;
    public ImageAnalysis.Analyzer mSubscribedAnalyzer;
    public ByteBuffer mURotatedBuffer;
    public Executor mUserExecutor;
    public ByteBuffer mVRotatedBuffer;
    public ByteBuffer mYRotatedBuffer;
    public volatile int mOutputImageFormat = 1;
    public Rect mOriginalViewPortCropRect = new Rect();
    public Rect mUpdatedViewPortCropRect = new Rect();
    public Matrix mOriginalSensorToBufferTransformMatrix = new Matrix();
    public Matrix mUpdatedSensorToBufferTransformMatrix = new Matrix();
    public final Object mAnalyzerLock = new Object();
    public boolean mIsAttached = true;

    public abstract ImageProxy acquireImage(ImageReaderProxy imageReaderProxy);

    public final ListenableFuture analyzeImage(final ImageProxy imageProxy) throws Throwable {
        Object obj;
        final Executor executor;
        final ImageAnalysis.Analyzer analyzer;
        boolean z;
        RealInterceptorChain realInterceptorChain;
        ImageWriter imageWriter;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        SingleCloseImageProxy singleCloseImageProxy;
        SingleCloseImageProxy singleCloseImageProxyRotateYUV;
        int i = this.mOutputImageRotationEnabled ? this.mRelativeRotation : 0;
        Object obj2 = this.mAnalyzerLock;
        synchronized (obj2) {
            try {
                try {
                    executor = this.mUserExecutor;
                    analyzer = this.mSubscribedAnalyzer;
                    z = this.mOutputImageRotationEnabled && i != this.mPrevBufferRotationDegrees;
                    if (z) {
                        recreateImageReaderProxy(imageProxy, i);
                    }
                    if (this.mOutputImageRotationEnabled) {
                        createHelperBuffer(imageProxy);
                    }
                    try {
                        realInterceptorChain = this.mProcessedImageReaderProxy;
                        try {
                            imageWriter = this.mProcessedImageWriter;
                            byteBuffer = this.mRGBConvertedBuffer;
                            try {
                                byteBuffer2 = this.mYRotatedBuffer;
                                byteBuffer3 = this.mURotatedBuffer;
                                byteBuffer4 = this.mVRotatedBuffer;
                            } catch (Throwable th) {
                                th = th;
                                obj = obj2;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            obj = obj2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj = obj2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    obj = obj2;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        if (analyzer == null || executor == null || !this.mIsAttached) {
            return new ImmediateFuture$ImmediateFailedFuture(0, new HttpException("No analyzer or executor currently set."));
        }
        if (realInterceptorChain == null) {
            singleCloseImageProxy = null;
        } else {
            if (this.mOutputImageFormat == 2) {
                singleCloseImageProxyRotateYUV = ImageProcessingUtil.convertYUVToRGB(imageProxy, realInterceptorChain, byteBuffer, i, this.mOnePixelShiftEnabled);
            } else {
                if (this.mOutputImageFormat == 1) {
                    if (this.mOnePixelShiftEnabled) {
                        ImageProcessingUtil.applyPixelShiftForYUV(imageProxy);
                    }
                    if (imageWriter != null && byteBuffer2 != null && byteBuffer3 != null && byteBuffer4 != null) {
                        singleCloseImageProxyRotateYUV = ImageProcessingUtil.rotateYUV(imageProxy, realInterceptorChain, imageWriter, byteBuffer2, byteBuffer3, byteBuffer4, i);
                    }
                }
                singleCloseImageProxy = null;
            }
            singleCloseImageProxy = singleCloseImageProxyRotateYUV;
        }
        boolean z2 = singleCloseImageProxy == null;
        final ImageProxy imageProxy2 = z2 ? imageProxy : singleCloseImageProxy;
        final Rect rect = new Rect();
        final Matrix matrix = new Matrix();
        synchronized (this.mAnalyzerLock) {
            if (z && !z2) {
                try {
                    recalculateTransformMatrixAndCropRect(imageProxy.getWidth(), imageProxy.getHeight(), imageProxy2.getWidth(), imageProxy2.getHeight());
                } catch (Throwable th6) {
                    throw th6;
                }
            }
            this.mPrevBufferRotationDegrees = i;
            rect.set(this.mUpdatedViewPortCropRect);
            matrix.set(this.mUpdatedSensorToBufferTransformMatrix);
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.f$0;
                final ImageProxy imageProxy3 = imageProxy;
                final Matrix matrix2 = matrix;
                final ImageProxy imageProxy4 = imageProxy2;
                final Rect rect2 = rect;
                final ImageAnalysis.Analyzer analyzer2 = analyzer;
                executor.execute(new Runnable() { // from class: androidx.camera.core.ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer2 = imageAnalysisAbstractAnalyzer;
                        ImageProxy imageProxy5 = imageProxy3;
                        Matrix matrix3 = matrix2;
                        ImageProxy imageProxy6 = imageProxy4;
                        Rect rect3 = rect2;
                        ImageAnalysis.Analyzer analyzer3 = analyzer2;
                        CallbackToFutureAdapter.Completer completer2 = completer;
                        if (!imageAnalysisAbstractAnalyzer2.mIsAttached) {
                            completer2.setException(new HttpException("ImageAnalysis is detached"));
                            return;
                        }
                        SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy6, null, new AutoValue_ImmutableImageInfo(imageProxy5.getImageInfo().getTagBundle(), imageProxy5.getImageInfo().getTimestamp(), imageAnalysisAbstractAnalyzer2.mOutputImageRotationEnabled ? 0 : imageAnalysisAbstractAnalyzer2.mRelativeRotation, matrix3));
                        if (!rect3.isEmpty()) {
                            Rect rect4 = new Rect(rect3);
                            if (!rect4.intersect(0, 0, settableImageProxy.mWidth, settableImageProxy.mHeight)) {
                                rect4.setEmpty();
                            }
                            synchronized (settableImageProxy.mLock) {
                            }
                        }
                        analyzer3.analyze(settableImageProxy);
                        completer2.set(null);
                    }
                });
                return "analyzeImage";
            }
        });
    }

    public abstract void clearCache();

    public final void createHelperBuffer(ImageProxy imageProxy) {
        if (this.mOutputImageFormat != 1) {
            if (this.mOutputImageFormat == 2 && this.mRGBConvertedBuffer == null) {
                this.mRGBConvertedBuffer = ByteBuffer.allocateDirect(imageProxy.getHeight() * imageProxy.getWidth() * 4);
                return;
            }
            return;
        }
        if (this.mYRotatedBuffer == null) {
            this.mYRotatedBuffer = ByteBuffer.allocateDirect(imageProxy.getHeight() * imageProxy.getWidth());
        }
        this.mYRotatedBuffer.position(0);
        if (this.mURotatedBuffer == null) {
            this.mURotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getHeight() * imageProxy.getWidth()) / 4);
        }
        this.mURotatedBuffer.position(0);
        if (this.mVRotatedBuffer == null) {
            this.mVRotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getHeight() * imageProxy.getWidth()) / 4);
        }
        this.mVRotatedBuffer.position(0);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireImage = acquireImage(imageReaderProxy);
            if (imageProxyAcquireImage != null) {
                onValidImageAvailable(imageProxyAcquireImage);
            }
        } catch (IllegalStateException e) {
            Logger.e("ImageAnalysisAnalyzer", "Failed to acquire image.", e);
        }
    }

    public abstract void onValidImageAvailable(ImageProxy imageProxy);

    public final void recalculateTransformMatrixAndCropRect(int i, int i2, int i3, int i4) {
        int i5 = this.mRelativeRotation;
        Matrix matrix = new Matrix();
        if (i5 > 0) {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            RectF rectF2 = TransformUtils.NORMALIZED_RECT;
            Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            matrix.postRotate(i5);
            RectF rectF3 = new RectF(0.0f, 0.0f, i3, i4);
            Matrix matrix2 = new Matrix();
            matrix2.setRectToRect(rectF2, rectF3, scaleToFit);
            matrix.postConcat(matrix2);
        }
        RectF rectF4 = new RectF(this.mOriginalViewPortCropRect);
        matrix.mapRect(rectF4);
        Rect rect = new Rect();
        rectF4.round(rect);
        this.mUpdatedViewPortCropRect = rect;
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, matrix);
    }

    public final void recreateImageReaderProxy(ImageProxy imageProxy, int i) {
        RealInterceptorChain realInterceptorChain = this.mProcessedImageReaderProxy;
        if (realInterceptorChain == null) {
            return;
        }
        realInterceptorChain.safeClose();
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int imageFormat = this.mProcessedImageReaderProxy.getImageFormat();
        int maxImages = this.mProcessedImageReaderProxy.getMaxImages();
        boolean z = i == 90 || i == 270;
        int i2 = z ? height : width;
        if (!z) {
            width = height;
        }
        this.mProcessedImageReaderProxy = new RealInterceptorChain(CloseableKt.createIsolatedReader(i2, width, imageFormat, maxImages));
        if (this.mOutputImageFormat == 1) {
            ImageWriter imageWriter = this.mProcessedImageWriter;
            if (imageWriter != null) {
                imageWriter.close();
            }
            this.mProcessedImageWriter = ImageWriter.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
        }
    }

    public final void setAnalyzer(Executor executor, ImageAnalysis$$ExternalSyntheticLambda0 imageAnalysis$$ExternalSyntheticLambda0) {
        if (imageAnalysis$$ExternalSyntheticLambda0 == null) {
            clearCache();
        }
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = imageAnalysis$$ExternalSyntheticLambda0;
            this.mUserExecutor = executor;
        }
    }
}
