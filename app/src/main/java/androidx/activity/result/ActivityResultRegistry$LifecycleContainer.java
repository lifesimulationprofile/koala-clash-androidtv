package androidx.activity.result;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultRegistry$LifecycleContainer {
    public final Lifecycle lifecycle;
    public final ArrayList observers = new ArrayList();

    public ActivityResultRegistry$LifecycleContainer(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }
}
