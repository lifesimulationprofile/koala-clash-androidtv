package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreviewStreamStateObserver$$ExternalSyntheticLambda1 implements AsyncFunction, Function {
    public final /* synthetic */ ZoomControl f$0;

    public /* synthetic */ PreviewStreamStateObserver$$ExternalSyntheticLambda1(ZoomControl zoomControl) {
        this.f$0 = zoomControl;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
    public ListenableFuture apply(Object obj) {
        return ((PreviewViewImplementation) this.f$0.mZoomImpl).waitForNextFrame();
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        this.f$0.updatePreviewStreamState(PreviewView.StreamState.STREAMING);
        return null;
    }
}
