package androidx.camera.core.impl;

import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.lifecycle.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataObservable$LiveDataObserverAdapter implements Observer {
    public final AtomicBoolean mActive = new AtomicBoolean(true);
    public final Executor mExecutor;
    public final ZoomControl mObserver;

    public LiveDataObservable$LiveDataObserverAdapter(Executor executor, ZoomControl zoomControl) {
        this.mExecutor = executor;
        this.mObserver = zoomControl;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.mExecutor.execute(new Preview$$ExternalSyntheticLambda1(15, this, (LiveDataObservable$Result) obj));
    }
}
