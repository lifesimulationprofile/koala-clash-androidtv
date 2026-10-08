package androidx.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class GapRememberObserverHolder implements RememberObserverHolder {
    public final int afterGroupIndex;
    public final RememberObserver wrapped;

    public GapRememberObserverHolder(RememberObserver rememberObserver, int i) {
        this.wrapped = rememberObserver;
        this.afterGroupIndex = i;
    }

    @Override // androidx.compose.runtime.RememberObserverHolder
    public final RememberObserver getWrapped() {
        return this.wrapped;
    }
}
