package androidx.camera.core.processing.concurrent;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.processing.OpenGlRenderer;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.core.processing.util.AutoValue_GraphicDeviceInfo;
import androidx.camera.core.processing.util.AutoValue_OutputSurface;
import androidx.camera.core.processing.util.GLUtils;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DualOpenGlRenderer extends OpenGlRenderer {
    public final LayoutSettings mPrimaryLayoutSettings;
    public final LayoutSettings mSecondaryLayoutSettings;
    public int mPrimaryExternalTextureId = -1;
    public int mSecondaryExternalTextureId = -1;

    public DualOpenGlRenderer(LayoutSettings layoutSettings, LayoutSettings layoutSettings2) {
        this.mPrimaryLayoutSettings = layoutSettings;
        this.mSecondaryLayoutSettings = layoutSettings2;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer
    public final AutoValue_GraphicDeviceInfo init(DynamicRange dynamicRange) throws Throwable {
        Map map = Collections.EMPTY_MAP;
        AutoValue_GraphicDeviceInfo autoValue_GraphicDeviceInfoInit = super.init(dynamicRange);
        this.mPrimaryExternalTextureId = GLUtils.createTexture();
        this.mSecondaryExternalTextureId = GLUtils.createTexture();
        return autoValue_GraphicDeviceInfoInit;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer
    public final void release() {
        super.release();
        this.mPrimaryExternalTextureId = -1;
        this.mSecondaryExternalTextureId = -1;
    }

    public final void render(long j, Surface surface, SurfaceOutputImpl surfaceOutputImpl, SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
        GLUtils.checkInitializedOrThrow((AtomicBoolean) this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow((Thread) this.mGlThread);
        HashMap map = (HashMap) this.mOutputSurfaceMap;
        Preconditions.checkState("The surface is not registered.", map.containsKey(surface));
        AutoValue_OutputSurface autoValue_OutputSurfaceCreateOutputSurfaceInternal = (AutoValue_OutputSurface) map.get(surface);
        Objects.requireNonNull(autoValue_OutputSurfaceCreateOutputSurfaceInternal);
        if (autoValue_OutputSurfaceCreateOutputSurfaceInternal == GLUtils.NO_OUTPUT_SURFACE) {
            autoValue_OutputSurfaceCreateOutputSurfaceInternal = createOutputSurfaceInternal(surface);
            if (autoValue_OutputSurfaceCreateOutputSurfaceInternal == null) {
                return;
            } else {
                map.put(surface, autoValue_OutputSurfaceCreateOutputSurfaceInternal);
            }
        }
        AutoValue_OutputSurface autoValue_OutputSurface = autoValue_OutputSurfaceCreateOutputSurfaceInternal;
        EGLSurface eGLSurface = autoValue_OutputSurface.eglSurface;
        if (surface != ((Surface) this.mCurrentSurface)) {
            makeCurrent(eGLSurface);
            this.mCurrentSurface = surface;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        renderInternal(autoValue_OutputSurface, surfaceOutputImpl, surfaceTexture, this.mPrimaryLayoutSettings, this.mPrimaryExternalTextureId);
        renderInternal(autoValue_OutputSurface, surfaceOutputImpl, surfaceTexture2, this.mSecondaryLayoutSettings, this.mSecondaryExternalTextureId);
        EGLExt.eglPresentationTimeANDROID((EGLDisplay) this.mEglDisplay, eGLSurface, j);
        if (EGL14.eglSwapBuffers((EGLDisplay) this.mEglDisplay, eGLSurface)) {
            return;
        }
        Logger.w("DualOpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        removeOutputSurfaceInternal(surface, false);
    }

    public final void renderInternal(AutoValue_OutputSurface autoValue_OutputSurface, SurfaceOutputImpl surfaceOutputImpl, SurfaceTexture surfaceTexture, LayoutSettings layoutSettings, int i) {
        useAndConfigureProgramWithTexture(i);
        int i2 = autoValue_OutputSurface.width;
        int i3 = autoValue_OutputSurface.height;
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glScissor(0, 0, i2, i3);
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, fArr, 0, surfaceOutputImpl.mAdditionalTransform, 0);
        GLUtils.Program2D program2D = (GLUtils.Program2D) this.mCurrentProgram;
        program2D.getClass();
        if (program2D instanceof GLUtils.SamplerShaderProgram) {
            GLES20.glUniformMatrix4fv(((GLUtils.SamplerShaderProgram) program2D).mTexMatrixLoc, 1, false, fArr2, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        }
        layoutSettings.getClass();
        Size size = new Size((int) (i2 * 1.0f), (int) (i3 * 1.0f));
        Size size2 = new Size(i2, i3);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        float[] fArr5 = new float[16];
        Matrix.setIdentityM(fArr5, 0);
        Matrix.scaleM(fArr3, 0, size.getWidth() / size2.getWidth(), size.getHeight() / size2.getHeight(), 1.0f);
        Matrix.translateM(fArr4, 0, 0.0f, 0.0f, 0.0f);
        Matrix.multiplyMM(fArr5, 0, fArr3, 0, fArr4, 0);
        GLES20.glUniformMatrix4fv(program2D.mTransMatrixLoc, 1, false, fArr5, 0);
        GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        GLES20.glUniform1f(program2D.mAlphaScaleLoc, 1.0f);
        GLUtils.checkGlErrorOrThrow("glUniform1f");
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        GLES20.glDisable(3042);
    }
}
