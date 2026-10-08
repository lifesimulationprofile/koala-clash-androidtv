package androidx.activity.result;

import io.github.g00fy2.quickie.ScanQRCode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultRegistry$CallbackAndContract {
    public final ActivityResultCallback callback;
    public final ScanQRCode contract;

    public ActivityResultRegistry$CallbackAndContract(ActivityResultCallback activityResultCallback, ScanQRCode scanQRCode) {
        this.callback = activityResultCallback;
        this.contract = scanQRCode;
    }
}
