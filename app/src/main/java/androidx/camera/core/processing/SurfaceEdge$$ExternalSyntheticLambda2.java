package androidx.camera.core.processing;

import androidx.camera.core.impl.DeferrableSurface;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DeferrableSurface f$0;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda2(DeferrableSurface deferrableSurface, int i) {
        this.$r8$classId = i;
        this.f$0 = deferrableSurface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.close();
                break;
            default:
                this.f$0.decrementUseCount();
                break;
        }
    }
}
