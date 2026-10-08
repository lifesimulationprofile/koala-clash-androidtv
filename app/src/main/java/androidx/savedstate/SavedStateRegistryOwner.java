package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;
import coil.request.RequestService;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    RequestService getSavedStateRegistry();
}
