package okio;

import androidx.compose.ui.Modifier;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final RealBufferedSource source;

    public InflaterSource(RealBufferedSource realBufferedSource, Inflater inflater) {
        this.source = realBufferedSource;
        this.inflater = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        long j2;
        while (j >= 0) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            RealBufferedSource realBufferedSource = this.source;
            Inflater inflater = this.inflater;
            if (j == 0) {
                j2 = 0;
            } else {
                try {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                    int iMin = (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit);
                    if (inflater.needsInput() && !realBufferedSource.exhausted()) {
                        Segment segment = realBufferedSource.bufferField.head;
                        int i = segment.limit;
                        int i2 = segment.pos;
                        int i3 = i - i2;
                        this.bufferBytesHeldByInflater = i3;
                        inflater.setInput(segment.data, i2, i3);
                    }
                    int iInflate = inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
                    int i4 = this.bufferBytesHeldByInflater;
                    if (i4 != 0) {
                        int remaining = i4 - inflater.getRemaining();
                        this.bufferBytesHeldByInflater -= remaining;
                        realBufferedSource.skip(remaining);
                    }
                    if (iInflate > 0) {
                        segmentWritableSegment$okio.limit += iInflate;
                        j2 = iInflate;
                        buffer.size += j2;
                    } else {
                        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                            buffer.head = segmentWritableSegment$okio.pop();
                            SegmentPool.recycle(segmentWritableSegment$okio);
                        }
                        j2 = 0;
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            if (j2 > 0) {
                return j2;
            }
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
            if (realBufferedSource.exhausted()) {
                throw new EOFException("source exhausted prematurely");
            }
        }
        throw new IllegalArgumentException(Modifier.CC.m("byteCount < 0: ", j).toString());
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.source.timeout();
    }
}
