package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$$ExternalSyntheticLambda4;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda4;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.processing.util.GLUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    public final HandlerScheduledExecutorService mGlExecutor;
    public final Handler mGlHandler;
    public final OpenGlRenderer mGlRenderer;
    public final HandlerThread mGlThread;
    public int mInputSurfaceCount;
    public final AtomicBoolean mIsReleaseRequested;
    public boolean mIsReleased;
    public final LinkedHashMap mOutputSurfaces;
    public final ArrayList mPendingSnapshots;
    public final float[] mSurfaceOutputMatrix;
    public final float[] mTextureMatrix;

    public DefaultSurfaceProcessor(DynamicRange dynamicRange) {
        Map map = Collections.EMPTY_MAP;
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.mGlThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mGlHandler = handler;
        this.mGlExecutor = new HandlerScheduledExecutorService(handler);
        this.mGlRenderer = new OpenGlRenderer();
        try {
            try {
                CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(this, dynamicRange)).get();
            } catch (InterruptedException | ExecutionException e) {
                e = e;
                e = e instanceof ExecutionException ? e.getCause() : e;
                if (!(e instanceof RuntimeException)) {
                    throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
                }
                throw ((RuntimeException) e);
            }
        } catch (RuntimeException e2) {
            release();
            throw e2;
        }
    }

    public final void checkReadyToRelease() {
        if (this.mIsReleased && this.mInputSurfaceCount == 0) {
            LinkedHashMap linkedHashMap = this.mOutputSurfaces;
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((SurfaceOutputImpl) it.next()).close();
            }
            ArrayList arrayList = this.mPendingSnapshots;
            if (arrayList.size() > 0) {
                ((AutoValue_DefaultSurfaceProcessor_PendingSnapshot) arrayList.get(0)).getClass();
                new Exception("Failed to snapshot: DefaultSurfaceProcessor is released.");
                throw null;
            }
            linkedHashMap.clear();
            this.mGlRenderer.release();
            this.mGlThread.quit();
        }
    }

    public final void executeSafely(Runnable runnable, Runnable runnable2) {
        try {
            this.mGlExecutor.execute(new LiveDataObservable$$ExternalSyntheticLambda1(this, runnable2, runnable, 4));
        } catch (RejectedExecutionException e) {
            Logger.w("DefaultSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    public final void failAllPendingSnapshots(Exception exc) {
        ArrayList arrayList = this.mPendingSnapshots;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            ((AutoValue_DefaultSurfaceProcessor_PendingSnapshot) arrayList.get(0)).getClass();
            throw null;
        }
    }

    public final Bitmap getBitmap(Size size, float[] fArr, int i) {
        float[] fArr2 = (float[]) fArr.clone();
        MatrixExt.preRotate(fArr2, i);
        MatrixExt.preVerticalFlip(fArr2);
        Size sizeRotateSize = TransformUtils.rotateSize(size, i);
        OpenGlRenderer openGlRenderer = this.mGlRenderer;
        openGlRenderer.getClass();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(sizeRotateSize.getHeight() * sizeRotateSize.getWidth() * 4);
        Preconditions.checkArgument("ByteBuffer capacity is not equal to width * height * 4.", byteBufferAllocateDirect.capacity() == (sizeRotateSize.getHeight() * sizeRotateSize.getWidth()) * 4);
        Preconditions.checkArgument("ByteBuffer is not direct.", byteBufferAllocateDirect.isDirect());
        int[] iArr = GLUtils.EMPTY_ATTRIBS;
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        GLUtils.checkGlErrorOrThrow("glGenTextures");
        int i2 = iArr2[0];
        GLES20.glActiveTexture(33985);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(3553, i2);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, sizeRotateSize.getWidth(), sizeRotateSize.getHeight(), 0, 6407, 5121, null);
        GLUtils.checkGlErrorOrThrow("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int[] iArr3 = new int[1];
        GLES20.glGenFramebuffers(1, iArr3, 0);
        GLUtils.checkGlErrorOrThrow("glGenFramebuffers");
        int i3 = iArr3[0];
        GLES20.glBindFramebuffer(36160, i3);
        GLUtils.checkGlErrorOrThrow("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        GLUtils.checkGlErrorOrThrow("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, openGlRenderer.mExternalTextureId);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
        openGlRenderer.mCurrentSurface = null;
        GLES20.glViewport(0, 0, sizeRotateSize.getWidth(), sizeRotateSize.getHeight());
        GLES20.glScissor(0, 0, sizeRotateSize.getWidth(), sizeRotateSize.getHeight());
        GLUtils.Program2D program2D = (GLUtils.Program2D) openGlRenderer.mCurrentProgram;
        program2D.getClass();
        if (program2D instanceof GLUtils.SamplerShaderProgram) {
            GLES20.glUniformMatrix4fv(((GLUtils.SamplerShaderProgram) program2D).mTexMatrixLoc, 1, false, fArr2, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        GLES20.glReadPixels(0, 0, sizeRotateSize.getWidth(), sizeRotateSize.getHeight(), 6408, 5121, byteBufferAllocateDirect);
        GLUtils.checkGlErrorOrThrow("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
        GLUtils.checkGlErrorOrThrow("glDeleteTextures");
        GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
        GLUtils.checkGlErrorOrThrow("glDeleteFramebuffers");
        int i4 = openGlRenderer.mExternalTextureId;
        GLES20.glActiveTexture(33984);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, i4);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizeRotateSize.getWidth(), sizeRotateSize.getHeight(), Bitmap.Config.ARGB_8888);
        byteBufferAllocateDirect.rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(bitmapCreateBitmap, byteBufferAllocateDirect, sizeRotateSize.getWidth() * 4);
        return bitmapCreateBitmap;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.mIsReleaseRequested.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        float[] fArr = this.mTextureMatrix;
        surfaceTexture.getTransformMatrix(fArr);
        Triple triple = null;
        for (Map.Entry entry : this.mOutputSurfaces.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            SurfaceOutputImpl surfaceOutputImpl = (SurfaceOutputImpl) entry.getKey();
            float[] fArr2 = surfaceOutputImpl.mAdditionalTransform;
            float[] fArr3 = this.mSurfaceOutputMatrix;
            Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
            int i = surfaceOutputImpl.mFormat;
            if (i == 34) {
                try {
                    this.mGlRenderer.render(surfaceTexture.getTimestamp(), fArr3, surface);
                } catch (RuntimeException e) {
                    Logger.e("DefaultSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            } else {
                Preconditions.checkState("Unsupported format: " + i, i == 256);
                Preconditions.checkState("Only one JPEG output is supported.", triple == null);
                triple = new Triple(surface, surfaceOutputImpl.mSize, (float[]) fArr3.clone());
            }
        }
        try {
            takeSnapshotAndDrawJpeg(triple);
        } catch (RuntimeException e2) {
            failAllPendingSnapshots(e2);
        }
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public final void onInputSurface(SurfaceRequest surfaceRequest) {
        if (this.mIsReleaseRequested.get()) {
            surfaceRequest.willNotProvideSurface();
        } else {
            executeSafely(new Preview$$ExternalSyntheticLambda1(17, this, surfaceRequest), new SurfaceRequest$$ExternalSyntheticLambda4(surfaceRequest, 1));
        }
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public final void onOutputSurface(SurfaceOutputImpl surfaceOutputImpl) {
        if (this.mIsReleaseRequested.get()) {
            surfaceOutputImpl.close();
            return;
        }
        Preview$$ExternalSyntheticLambda1 preview$$ExternalSyntheticLambda1 = new Preview$$ExternalSyntheticLambda1(16, this, surfaceOutputImpl);
        Objects.requireNonNull(surfaceOutputImpl);
        executeSafely(preview$$ExternalSyntheticLambda1, new Preview$$ExternalSyntheticLambda0(18, surfaceOutputImpl));
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public final void release() {
        if (this.mIsReleaseRequested.getAndSet(true)) {
            return;
        }
        executeSafely(new Preview$$ExternalSyntheticLambda0(19, this), new Camera2CameraControlImpl$$ExternalSyntheticLambda4(0));
    }

    public final void takeSnapshotAndDrawJpeg(Triple triple) {
        ArrayList arrayList = this.mPendingSnapshots;
        if (arrayList.isEmpty()) {
            return;
        }
        if (triple == null) {
            failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator it = arrayList.iterator();
                if (!it.hasNext()) {
                    byteArrayOutputStream.close();
                    return;
                }
                ((AutoValue_DefaultSurfaceProcessor_PendingSnapshot) it.next()).getClass();
                Bitmap bitmap = getBitmap((Size) triple.second, (float[]) triple.third, 0);
                byteArrayOutputStream.reset();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Surface surface = (Surface) triple.first;
                Objects.requireNonNull(byteArray);
                ImageProcessingUtil.writeJpegBytesToSurface(byteArray, surface);
                throw null;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            failAllPendingSnapshots(e);
        }
        failAllPendingSnapshots(e);
    }
}
