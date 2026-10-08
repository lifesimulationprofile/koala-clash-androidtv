package okhttp3.internal.http1;

import androidx.compose.ui.Modifier;
import java.io.IOException;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Http1ExchangeCodec$UnknownLengthSource extends Http1ExchangeCodec$AbstractSource {
    public boolean inputExhausted;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        if (!this.inputExhausted) {
            responseBodyComplete();
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
        if (this.inputExhausted) {
            return -1L;
        }
        long j2 = super.read(j, buffer);
        if (j2 != -1) {
            return j2;
        }
        this.inputExhausted = true;
        responseBodyComplete();
        return -1L;
    }
}
