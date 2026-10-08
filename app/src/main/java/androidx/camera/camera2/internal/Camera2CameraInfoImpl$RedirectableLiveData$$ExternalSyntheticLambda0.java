package androidx.camera.camera2.internal;

import androidx.lifecycle.Observer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ Camera2CameraInfoImpl.RedirectableLiveData f$0;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f$0.setValue(obj);
    }
}
