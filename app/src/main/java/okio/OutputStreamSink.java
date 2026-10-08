package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OutputStreamSink implements Sink {
    public final /* synthetic */ int $r8$classId;
    public final Object out;
    public final Object timeout;

    public /* synthetic */ OutputStreamSink(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.out = obj;
        this.timeout = obj2;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i = this.$r8$classId;
        Object obj = this.out;
        switch (i) {
            case 0:
                ((OutputStream) obj).close();
                return;
            default:
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) obj;
                OutputStreamSink outputStreamSink = (OutputStreamSink) this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        outputStreamSink.close();
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

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.$r8$classId;
        Object obj = this.out;
        switch (i) {
            case 0:
                ((OutputStream) obj).flush();
                return;
            default:
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) obj;
                OutputStreamSink outputStreamSink = (OutputStreamSink) this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        outputStreamSink.flush();
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

    @Override // okio.Sink
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                return (Timeout) this.timeout;
            default:
                return (SocketAsyncTimeout) this.out;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "sink(" + ((OutputStream) this.out) + ')';
            default:
                return "AsyncTimeout.sink(" + ((OutputStreamSink) this.timeout) + ')';
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004c A[LOOP:0: B:5:0x001a->B:18:0x004c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x004e A[SYNTHETIC] */
    @Override // okio.Sink
    public final void write(long j, Buffer buffer) throws IOException {
        long j2;
        SocketAsyncTimeout socketAsyncTimeout;
        int i = this.$r8$classId;
        Object obj = this.timeout;
        Object obj2 = this.out;
        switch (i) {
            case 0:
                SegmentedByteString.checkOffsetAndCount(buffer.size, 0L, j);
                long j3 = j;
                while (j3 > 0) {
                    ((Timeout) obj).throwIfReached();
                    Segment segment = buffer.head;
                    int iMin = (int) Math.min(j3, segment.limit - segment.pos);
                    ((OutputStream) obj2).write(segment.data, segment.pos, iMin);
                    int i2 = segment.pos + iMin;
                    segment.pos = i2;
                    long j4 = iMin;
                    j3 -= j4;
                    buffer.size -= j4;
                    if (i2 == segment.limit) {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                }
                return;
            default:
                SegmentedByteString.checkOffsetAndCount(buffer.size, 0L, j);
                for (long j5 = j; j5 > 0; j5 -= j2) {
                    Segment segment2 = buffer.head;
                    j2 = 0;
                    try {
                        try {
                            while (j2 < 65536) {
                                j2 += (long) (segment2.limit - segment2.pos);
                                if (j2 >= j5) {
                                    j2 = j5;
                                    socketAsyncTimeout = (SocketAsyncTimeout) obj2;
                                    OutputStreamSink outputStreamSink = (OutputStreamSink) obj;
                                    socketAsyncTimeout.enter();
                                    outputStreamSink.write(j2, buffer);
                                    Unit unit = Unit.INSTANCE;
                                    if (!socketAsyncTimeout.exit()) {
                                        throw socketAsyncTimeout.newTimeoutException(null);
                                    }
                                } else {
                                    segment2 = segment2.next;
                                }
                            }
                            outputStreamSink.write(j2, buffer);
                            Unit unit2 = Unit.INSTANCE;
                            if (!socketAsyncTimeout.exit()) {
                                throw socketAsyncTimeout.newTimeoutException(null);
                            }
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
                    socketAsyncTimeout = (SocketAsyncTimeout) obj2;
                    OutputStreamSink outputStreamSink2 = (OutputStreamSink) obj;
                    socketAsyncTimeout.enter();
                }
                return;
        }
    }
}
