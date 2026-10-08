package androidx.camera.core.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.OpenGlRenderer;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.core.processing.concurrent.DualOpenGlRenderer;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.util.GLUtils;
import androidx.core.util.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CameraUseCaseAdapter$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ CameraUseCaseAdapter$$ExternalSyntheticLambda1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Surface surface = (Surface) this.f$0;
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.f$1;
                surface.release();
                surfaceTexture.release();
                break;
            case 1:
                DefaultSurfaceProcessor defaultSurfaceProcessor = (DefaultSurfaceProcessor) this.f$0;
                SurfaceOutputImpl surfaceOutputImpl = (SurfaceOutputImpl) this.f$1;
                surfaceOutputImpl.close();
                Surface surface2 = (Surface) defaultSurfaceProcessor.mOutputSurfaces.remove(surfaceOutputImpl);
                if (surface2 != null) {
                    OpenGlRenderer openGlRenderer = defaultSurfaceProcessor.mGlRenderer;
                    GLUtils.checkInitializedOrThrow((AtomicBoolean) openGlRenderer.mInitialized, true);
                    GLUtils.checkGlThreadOrThrow((Thread) openGlRenderer.mGlThread);
                    openGlRenderer.removeOutputSurfaceInternal(surface2, true);
                }
                break;
            default:
                DualSurfaceProcessor dualSurfaceProcessor = (DualSurfaceProcessor) this.f$0;
                SurfaceOutputImpl surfaceOutputImpl2 = (SurfaceOutputImpl) this.f$1;
                surfaceOutputImpl2.close();
                Surface surface3 = (Surface) dualSurfaceProcessor.mOutputSurfaces.remove(surfaceOutputImpl2);
                if (surface3 != null) {
                    DualOpenGlRenderer dualOpenGlRenderer = dualSurfaceProcessor.mGlRenderer;
                    GLUtils.checkInitializedOrThrow((AtomicBoolean) dualOpenGlRenderer.mInitialized, true);
                    GLUtils.checkGlThreadOrThrow((Thread) dualOpenGlRenderer.mGlThread);
                    dualOpenGlRenderer.removeOutputSurfaceInternal(surface3, true);
                }
                break;
        }
    }
}
