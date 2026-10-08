package androidx.camera.camera2.internal.compat;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CameraManagerCompat$AvailabilityCallbackExecutorWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CameraManagerCompat.AvailabilityCallbackExecutorWrapper f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ CameraManagerCompat$AvailabilityCallbackExecutorWrapper$$ExternalSyntheticLambda0(CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = availabilityCallbackExecutorWrapper;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.mWrappedCallback.onCameraAvailable(this.f$1);
                break;
            default:
                this.f$0.mWrappedCallback.onCameraUnavailable(this.f$1);
                break;
        }
    }
}
