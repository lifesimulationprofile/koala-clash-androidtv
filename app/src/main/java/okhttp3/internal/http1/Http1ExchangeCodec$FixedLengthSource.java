package okhttp3.internal.http1;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.RulerTrackingMap;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Http1ExchangeCodec$FixedLengthSource extends Http1ExchangeCodec$AbstractSource {
    public long bytesRemaining;
    public final /* synthetic */ RulerTrackingMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http1ExchangeCodec$FixedLengthSource(RulerTrackingMap rulerTrackingMap, long j) {
        super(rulerTrackingMap);
        this.this$0 = rulerTrackingMap;
        this.bytesRemaining = j;
        if (j == 0) {
            responseBodyComplete();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zSkipAll;
        if (this.closed) {
            return;
        }
        if (this.bytesRemaining != 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            try {
                zSkipAll = Util.skipAll(this, 100);
            } catch (IOException unused) {
                zSkipAll = false;
            }
            if (!zSkipAll) {
                ((RealConnection) this.this$0.values).noNewExchanges$okhttp();
                responseBodyComplete();
            }
        }
        this.closed = true;
    }

    @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource, okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException(Modifier.CC.m("byteCount < 0: ", j).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long j2 = this.bytesRemaining;
        if (j2 == 0) {
            return -1L;
        }
        long j3 = super.read(Math.min(j2, j), buffer);
        if (j3 == -1) {
            ((RealConnection) this.this$0.values).noNewExchanges$okhttp();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw protocolException;
        }
        long j4 = this.bytesRemaining - j3;
        this.bytesRemaining = j4;
        if (j4 == 0) {
            responseBodyComplete();
        }
        return j3;
    }
}
