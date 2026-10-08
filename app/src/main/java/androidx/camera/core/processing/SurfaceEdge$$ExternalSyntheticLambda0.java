package androidx.camera.core.processing;

import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SurfaceEdge f$0;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda0(SurfaceEdge surfaceEdge, int i) {
        this.$r8$classId = i;
        this.f$0 = surfaceEdge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                HexFormatKt.mainThreadExecutor().execute(new SurfaceEdge$$ExternalSyntheticLambda0(this.f$0, 1));
                break;
            default:
                SurfaceEdge surfaceEdge = this.f$0;
                if (!surfaceEdge.mIsClosed) {
                    surfaceEdge.invalidate();
                }
                break;
        }
    }
}
