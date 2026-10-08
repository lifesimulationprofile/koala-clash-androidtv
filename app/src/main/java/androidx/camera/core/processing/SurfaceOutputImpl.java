package androidx.camera.core.processing;

import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.core.AutoValue_SurfaceOutput_CameraInputInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceOutputImpl implements Closeable {
    public final float[] mAdditionalTransform;
    public final CallbackToFutureAdapter.SafeFuture mCloseFuture;
    public CallbackToFutureAdapter.Completer mCloseFutureCompleter;
    public Consumer mEventListener;
    public Executor mExecutor;
    public final int mFormat;
    public final Size mSize;
    public final Surface mSurface;
    public final Object mLock = new Object();
    public boolean mHasPendingCloseRequest = false;
    public boolean mIsClosed = false;

    public SurfaceOutputImpl(Surface surface, int i, Size size, AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo, AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo2) {
        float[] fArr = new float[16];
        this.mAdditionalTransform = fArr;
        this.mSurface = surface;
        this.mFormat = i;
        this.mSize = size;
        calculateAdditionalTransform(fArr, new float[16], autoValue_SurfaceOutput_CameraInputInfo);
        calculateAdditionalTransform(new float[16], new float[16], autoValue_SurfaceOutput_CameraInputInfo2);
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(9, this));
    }

    public static void calculateAdditionalTransform(float[] fArr, float[] fArr2, AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo) {
        Matrix.setIdentityM(fArr, 0);
        if (autoValue_SurfaceOutput_CameraInputInfo == null) {
            return;
        }
        Size size = autoValue_SurfaceOutput_CameraInputInfo.inputSize;
        boolean z = autoValue_SurfaceOutput_CameraInputInfo.mirroring;
        int i = autoValue_SurfaceOutput_CameraInputInfo.rotationDegrees;
        MatrixExt.preVerticalFlip(fArr);
        MatrixExt.preRotate(fArr, i);
        if (z) {
            Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
            Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
        }
        Size sizeRotateSize = TransformUtils.rotateSize(size, i);
        float f = 0;
        android.graphics.Matrix rectToRect = TransformUtils.getRectToRect(new RectF(f, f, size.getWidth(), size.getHeight()), new RectF(f, f, sizeRotateSize.getWidth(), sizeRotateSize.getHeight()), i, z);
        RectF rectF = new RectF(autoValue_SurfaceOutput_CameraInputInfo.inputCropRect);
        rectToRect.mapRect(rectF);
        float width = rectF.left / sizeRotateSize.getWidth();
        float height = ((sizeRotateSize.getHeight() - rectF.height()) - rectF.top) / sizeRotateSize.getHeight();
        float fWidth = rectF.width() / sizeRotateSize.getWidth();
        float fHeight = rectF.height() / sizeRotateSize.getHeight();
        Matrix.translateM(fArr, 0, width, height, 0.0f);
        Matrix.scaleM(fArr, 0, fWidth, fHeight, 1.0f);
        CameraInternal cameraInternal = autoValue_SurfaceOutput_CameraInputInfo.cameraInternal;
        Matrix.setIdentityM(fArr2, 0);
        MatrixExt.preVerticalFlip(fArr2);
        if (cameraInternal != null) {
            Preconditions.checkState("Camera has no transform.", cameraInternal.getHasTransform());
            MatrixExt.preRotate(fArr2, cameraInternal.getCameraInfo().getSensorRotationDegrees());
            if (cameraInternal.isFrontFacing()) {
                Matrix.translateM(fArr2, 0, 1.0f, 0.0f, 0.0f);
                Matrix.scaleM(fArr2, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        Matrix.invertM(fArr2, 0, fArr2, 0);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.mLock) {
            try {
                if (!this.mIsClosed) {
                    this.mIsClosed = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mCloseFutureCompleter.set(null);
    }

    public final Surface getSurface(HandlerScheduledExecutorService handlerScheduledExecutorService, Consumer consumer) {
        boolean z;
        synchronized (this.mLock) {
            this.mExecutor = handlerScheduledExecutorService;
            this.mEventListener = consumer;
            z = this.mHasPendingCloseRequest;
        }
        if (z) {
            requestClose();
        }
        return this.mSurface;
    }

    public final void requestClose() {
        Executor executor;
        Consumer consumer;
        AtomicReference atomicReference = new AtomicReference();
        synchronized (this.mLock) {
            try {
                if (this.mExecutor == null || (consumer = this.mEventListener) == null) {
                    this.mHasPendingCloseRequest = true;
                } else if (!this.mIsClosed) {
                    atomicReference.set(consumer);
                    executor = this.mExecutor;
                    this.mHasPendingCloseRequest = false;
                }
                executor = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executor != null) {
            try {
                executor.execute(new Preview$$ExternalSyntheticLambda1(18, this, atomicReference));
            } catch (RejectedExecutionException e) {
                String strTruncateTag = Logger.truncateTag("SurfaceOutputImpl");
                if (Logger.isLogLevelEnabled(strTruncateTag, 3)) {
                    Log.d(strTruncateTag, "Processor executor closed. Close request not posted.", e);
                }
            }
        }
    }
}
