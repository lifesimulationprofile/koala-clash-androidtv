package androidx.camera.core.processing;

import android.view.Surface;
import androidx.camera.core.AutoValue_SurfaceOutput_CameraInputInfo;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda4 implements AsyncFunction {
    public final /* synthetic */ SurfaceEdge f$0;
    public final /* synthetic */ SurfaceEdge.SettableSurface f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ AutoValue_SurfaceOutput_CameraInputInfo f$3;
    public final /* synthetic */ AutoValue_SurfaceOutput_CameraInputInfo f$4;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda4(SurfaceEdge surfaceEdge, SurfaceEdge.SettableSurface settableSurface, int i, AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo, AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo2) {
        this.f$0 = surfaceEdge;
        this.f$1 = settableSurface;
        this.f$2 = i;
        this.f$3 = autoValue_SurfaceOutput_CameraInputInfo;
        this.f$4 = autoValue_SurfaceOutput_CameraInputInfo2;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
    public final ListenableFuture apply(Object obj) {
        SurfaceEdge.SettableSurface settableSurface = this.f$1;
        Surface surface = (Surface) obj;
        SurfaceEdge surfaceEdge = this.f$0;
        surfaceEdge.getClass();
        surface.getClass();
        try {
            settableSurface.incrementUseCount();
            SurfaceOutputImpl surfaceOutputImpl = new SurfaceOutputImpl(surface, this.f$2, surfaceEdge.mStreamSpec.resolution, this.f$3, this.f$4);
            surfaceOutputImpl.mCloseFuture.delegate.addListener(new SurfaceEdge$$ExternalSyntheticLambda1(settableSurface, 1), HexFormatKt.directExecutor());
            Preconditions.checkState("Consumer can only be linked once.", settableSurface.mConsumer == null);
            settableSurface.mConsumer = surfaceOutputImpl;
            return Futures.immediateFuture(surfaceOutputImpl);
        } catch (DeferrableSurface.SurfaceClosedException e) {
            return new ImmediateFuture$ImmediateFailedFuture(0, e);
        }
    }
}
