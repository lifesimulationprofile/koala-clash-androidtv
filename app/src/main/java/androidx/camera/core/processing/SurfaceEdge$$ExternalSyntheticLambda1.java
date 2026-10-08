package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SurfaceEdge.SettableSurface f$0;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda1(SurfaceEdge.SettableSurface settableSurface, int i) {
        this.$r8$classId = i;
        this.f$0 = settableSurface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.close();
                break;
            case 1:
                this.f$0.decrementUseCount();
                break;
            default:
                SurfaceEdge.SettableSurface settableSurface = this.f$0;
                SurfaceOutputImpl surfaceOutputImpl = settableSurface.mConsumer;
                if (surfaceOutputImpl != null) {
                    surfaceOutputImpl.requestClose();
                }
                if (settableSurface.mProvider == null) {
                    CallbackToFutureAdapter.Completer completer = settableSurface.mCompleter;
                    completer.attemptedSetting = true;
                    CallbackToFutureAdapter.SafeFuture safeFuture = completer.future;
                    if (safeFuture != null && safeFuture.delegate.cancel(true)) {
                        completer.tag = null;
                        completer.future = null;
                        completer.cancellationFuture = null;
                        break;
                    }
                }
                break;
        }
    }
}
