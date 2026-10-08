package androidx.camera.core.imagecapture;

import coil.intercept.RealInterceptorChain;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CaptureNode$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RealInterceptorChain f$0;

    public /* synthetic */ CaptureNode$$ExternalSyntheticLambda4(RealInterceptorChain realInterceptorChain, int i) {
        this.$r8$classId = i;
        this.f$0 = realInterceptorChain;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.safeClose();
                break;
            case 1:
                this.f$0.safeClose();
                break;
            default:
                RealInterceptorChain realInterceptorChain = this.f$0;
                if (realInterceptorChain != null) {
                    realInterceptorChain.safeClose();
                }
                break;
        }
    }
}
