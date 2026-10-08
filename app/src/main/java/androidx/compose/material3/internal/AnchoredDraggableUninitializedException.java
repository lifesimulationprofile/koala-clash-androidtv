package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.DefaultDraggableAnchors;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableUninitializedException extends Throwable {
    public final String message;

    public AnchoredDraggableUninitializedException(boolean z, boolean z2, DefaultDraggableAnchors defaultDraggableAnchors, Object obj) {
        this.message = "AnchoredDraggableState was not initialized correctly. isLookingAhead=" + z + ",didLookahead=" + z2 + ",anchors=" + defaultDraggableAnchors + ",targetValue=" + obj;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
