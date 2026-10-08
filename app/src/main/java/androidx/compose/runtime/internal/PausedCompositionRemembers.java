package androidx.compose.runtime.internal;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PausedCompositionRemembers implements RememberObserver {
    public final Set abandoning;
    public final MutableVector pausedRemembers = new MutableVector(new RememberObserverHolder[16]);

    public PausedCompositionRemembers(Set set) {
        this.abandoning = set;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        MutableVector mutableVector = this.pausedRemembers;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            RememberObserver wrapped = ((RememberObserverHolder) objArr[i2]).getWrapped();
            this.abandoning.remove(wrapped);
            wrapped.onRemembered();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
    }
}
