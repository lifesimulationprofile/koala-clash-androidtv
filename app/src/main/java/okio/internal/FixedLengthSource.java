package okio.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FixedLengthSource extends ForwardingSource {
    public long bytesReceived;
    public final long size;
    public final boolean truncate;

    public FixedLengthSource(Source source, long j, boolean z) {
        super(source);
        this.size = j;
        this.truncate = z;
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        long j2 = this.bytesReceived;
        long j3 = this.size;
        if (j2 > j3) {
            j = 0;
        } else if (this.truncate) {
            long j4 = j3 - j2;
            if (j4 == 0) {
                return -1L;
            }
            j = Math.min(j, j4);
        }
        long j5 = this.delegate.read(j, buffer);
        if (j5 != -1) {
            this.bytesReceived += j5;
        }
        long j6 = this.bytesReceived;
        if ((j6 >= j3 || j5 != -1) && j6 <= j3) {
            return j5;
        }
        if (j5 > 0 && j6 > j3) {
            long j7 = buffer.size - (j6 - j3);
            Buffer buffer2 = new Buffer();
            buffer2.writeAll(buffer);
            buffer.write(j7, buffer2);
            buffer2.skip(buffer2.size);
        }
        throw new IOException("expected " + j3 + " bytes but got " + this.bytesReceived);
    }
}
