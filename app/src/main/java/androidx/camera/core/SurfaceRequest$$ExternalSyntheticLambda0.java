package androidx.camera.core;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceRequest$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener f$0;
    public final /* synthetic */ AutoValue_SurfaceRequest_TransformationInfo f$1;

    public /* synthetic */ SurfaceRequest$$ExternalSyntheticLambda0(SurfaceRequest.TransformationInfoListener transformationInfoListener, AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo, int i) {
        this.$r8$classId = i;
        this.f$0 = transformationInfoListener;
        this.f$1 = autoValue_SurfaceRequest_TransformationInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.onTransformationInfoUpdate(this.f$1);
                break;
            default:
                this.f$0.onTransformationInfoUpdate(this.f$1);
                break;
        }
    }
}
