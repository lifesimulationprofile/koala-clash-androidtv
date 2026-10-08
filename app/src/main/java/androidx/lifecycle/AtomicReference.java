package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import okhttp3.Dispatcher;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicReference {
    public static final Path.Companion VIEW_MODEL_KEY = new Path.Companion();
    public final Object base;

    public AtomicReference() {
        this.base = new java.util.concurrent.atomic.AtomicReference(null);
    }

    public AtomicReference(ViewModelStore viewModelStore, ViewModelProvider$Factory viewModelProvider$Factory, CreationExtras creationExtras) {
        this.base = new Dispatcher(viewModelStore, viewModelProvider$Factory, creationExtras);
    }

    public AtomicReference(ProcessLifecycleOwner processLifecycleOwner) {
        this.base = processLifecycleOwner;
    }
}
