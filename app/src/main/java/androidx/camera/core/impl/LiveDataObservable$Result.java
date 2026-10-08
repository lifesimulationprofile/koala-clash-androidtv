package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataObservable$Result {
    public final CameraInternal.State mValue;

    public LiveDataObservable$Result(CameraInternal.State state) {
        this.mValue = state;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[Result: <");
        sb.append("Value: " + this.mValue);
        sb.append(">]");
        return sb.toString();
    }
}
