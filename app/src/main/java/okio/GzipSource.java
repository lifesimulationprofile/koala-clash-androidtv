package okio;

import androidx.compose.ui.Modifier;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GzipSource implements Source {
    public final CRC32 crc;
    public final Inflater inflater;
    public final InflaterSource inflaterSource;
    public byte section;
    public final RealBufferedSource source;

    public GzipSource(Source source) {
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource(realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    public static void checkEqual(int i, int i2, String str) throws IOException {
        if (i2 == i) {
            return;
        }
        throw new IOException(str + ": actual 0x" + StringsKt.padStart(SegmentedByteString.toHexString(i2), 8) + " != expected 0x" + StringsKt.padStart(SegmentedByteString.toHexString(i), 8));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) throws IOException {
        GzipSource gzipSource = this;
        if (j < 0) {
            throw new IllegalArgumentException(Modifier.CC.m("byteCount < 0: ", j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        byte b = gzipSource.section;
        CRC32 crc32 = gzipSource.crc;
        RealBufferedSource realBufferedSource = gzipSource.source;
        if (b == 0) {
            realBufferedSource.require(10L);
            Buffer buffer2 = realBufferedSource.bufferField;
            byte b2 = buffer2.getByte(3L);
            boolean z = ((b2 >> 1) & 1) == 1;
            if (z) {
                gzipSource.updateCrc(buffer2, 0L, 10L);
            }
            checkEqual(8075, realBufferedSource.readShort(), "ID1ID2");
            realBufferedSource.skip(8L);
            if (((b2 >> 2) & 1) == 1) {
                realBufferedSource.require(2L);
                if (z) {
                    updateCrc(buffer2, 0L, 2L);
                }
                long shortLe = buffer2.readShortLe() & 65535;
                realBufferedSource.require(shortLe);
                if (z) {
                    updateCrc(buffer2, 0L, shortLe);
                }
                realBufferedSource.skip(shortLe);
            }
            if (((b2 >> 3) & 1) == 1) {
                long jIndexOf = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf == -1) {
                    throw new EOFException();
                }
                if (z) {
                    updateCrc(buffer2, 0L, jIndexOf + 1);
                }
                realBufferedSource.skip(jIndexOf + 1);
            }
            if (((b2 >> 4) & 1) == 1) {
                long jIndexOf2 = realBufferedSource.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    gzipSource = this;
                    gzipSource.updateCrc(buffer2, 0L, jIndexOf2 + 1);
                } else {
                    gzipSource = this;
                }
                realBufferedSource.skip(jIndexOf2 + 1);
            } else {
                gzipSource = this;
            }
            if (z) {
                checkEqual(realBufferedSource.readShortLe(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            gzipSource.section = (byte) 1;
        }
        if (gzipSource.section == 1) {
            long j2 = buffer.size;
            long j3 = gzipSource.inflaterSource.read(j, buffer);
            if (j3 != -1) {
                gzipSource.updateCrc(buffer, j2, j3);
                return j3;
            }
            gzipSource.section = (byte) 2;
        }
        if (gzipSource.section == 2) {
            checkEqual(realBufferedSource.readIntLe(), (int) crc32.getValue(), "CRC");
            checkEqual(realBufferedSource.readIntLe(), (int) gzipSource.inflater.getBytesWritten(), "ISIZE");
            gzipSource.section = (byte) 3;
            if (!realBufferedSource.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.source.timeout();
    }

    public final void updateCrc(Buffer buffer, long j, long j2) {
        Segment segment = buffer.head;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) segment.pos) + j);
            int iMin = (int) Math.min(segment.limit - i3, j2);
            this.crc.update(segment.data, i3, iMin);
            j2 -= (long) iMin;
            segment = segment.next;
            j = 0;
        }
    }
}
