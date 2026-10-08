package okhttp3.internal.http1;

import androidx.compose.ui.node.RulerTrackingMap;
import java.io.IOException;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Http1ExchangeCodec$AbstractSource implements Source {
    public boolean closed;
    public final /* synthetic */ RulerTrackingMap this$0;
    public final ForwardingTimeout timeout;

    public Http1ExchangeCodec$AbstractSource(RulerTrackingMap rulerTrackingMap) {
        this.this$0 = rulerTrackingMap;
        Timeout timeout = ((BufferedSource) rulerTrackingMap.accessFlags).timeout();
        ForwardingTimeout forwardingTimeout = new ForwardingTimeout();
        forwardingTimeout.delegate = timeout;
        this.timeout = forwardingTimeout;
    }

    @Override // okio.Source
    public long read(long j, Buffer buffer) throws IOException {
        RulerTrackingMap rulerTrackingMap = this.this$0;
        try {
            return ((BufferedSource) rulerTrackingMap.accessFlags).read(j, buffer);
        } catch (IOException e) {
            ((RealConnection) rulerTrackingMap.values).noNewExchanges$okhttp();
            responseBodyComplete();
            throw e;
        }
    }

    public final void responseBodyComplete() {
        RulerTrackingMap rulerTrackingMap = this.this$0;
        int i = rulerTrackingMap.size;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + rulerTrackingMap.size);
        }
        ForwardingTimeout forwardingTimeout = this.timeout;
        Timeout timeout = forwardingTimeout.delegate;
        forwardingTimeout.delegate = Timeout.NONE;
        timeout.clearDeadline();
        timeout.clearTimeout();
        rulerTrackingMap.size = 6;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.timeout;
    }
}
