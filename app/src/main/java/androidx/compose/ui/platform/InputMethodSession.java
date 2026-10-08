package androidx.compose.ui.platform;

import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.WeakReference;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InputMethodSession {
    public boolean disposed;
    public final Handshake.AnonymousClass2 onAllConnectionsClosed;
    public final LegacyTextInputMethodRequest request;
    public final Object lock = new Object();
    public final MutableVector connections = new MutableVector(new WeakReference[16]);

    public InputMethodSession(LegacyTextInputMethodRequest legacyTextInputMethodRequest, Handshake.AnonymousClass2 anonymousClass2) {
        this.request = legacyTextInputMethodRequest;
        this.onAllConnectionsClosed = anonymousClass2;
    }
}
