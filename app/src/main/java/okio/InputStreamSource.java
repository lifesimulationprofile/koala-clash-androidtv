package okio;

import androidx.compose.ui.Modifier;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InputStreamSource implements Source {
    public final /* synthetic */ int $r8$classId;
    public final Object input;
    public final Object timeout;

    public /* synthetic */ InputStreamSource(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.input = obj;
        this.timeout = obj2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.$r8$classId;
        Object obj = this.input;
        switch (i) {
            case 0:
                ((InputStream) obj).close();
                return;
            default:
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) obj;
                InputStreamSource inputStreamSource = (InputStreamSource) this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        inputStreamSource.close();
                        Unit unit = Unit.INSTANCE;
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!socketAsyncTimeout.exit()) {
                            throw e;
                        }
                        throw socketAsyncTimeout.newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0099  */
    @Override // okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        boolean z;
        int i = this.$r8$classId;
        Object obj = this.timeout;
        Object obj2 = this.input;
        switch (i) {
            case 0:
                if (j == 0) {
                    return 0L;
                }
                if (j < 0) {
                    throw new IllegalArgumentException(Modifier.CC.m("byteCount < 0: ", j).toString());
                }
                try {
                    ((Timeout) obj).throwIfReached();
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                    int i2 = ((InputStream) obj2).read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit));
                    if (i2 == -1) {
                        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                            buffer.head = segmentWritableSegment$okio.pop();
                            SegmentPool.recycle(segmentWritableSegment$okio);
                        }
                        return -1L;
                    }
                    segmentWritableSegment$okio.limit += i2;
                    long j2 = i2;
                    buffer.size += j2;
                    return j2;
                } catch (AssertionError e) {
                    Logger logger = Okio__JvmOkioKt.logger;
                    if (e.getCause() != null) {
                        String message = e.getMessage();
                        z = message != null ? StringsKt.contains(message, "getsockname failed", false) : false;
                    }
                    if (z) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            default:
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) obj2;
                InputStreamSource inputStreamSource = (InputStreamSource) obj;
                socketAsyncTimeout.enter();
                try {
                    try {
                        long j3 = inputStreamSource.read(j, buffer);
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                        return j3;
                    } catch (Throwable th) {
                        socketAsyncTimeout.exit();
                        throw th;
                    }
                } catch (IOException e2) {
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.newTimeoutException(e2);
                    }
                    throw e2;
                }
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                return (Timeout) this.timeout;
            default:
                return (SocketAsyncTimeout) this.input;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "source(" + ((InputStream) this.input) + ')';
            default:
                return "AsyncTimeout.source(" + ((InputStreamSource) this.timeout) + ')';
        }
    }
}
