package okio;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Charsets;
import okio.internal.ZipFilesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    public long size;

    public final Object clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segment = this.head;
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            segmentSharedCopy.prev.push(segment2.sharedCopy());
        }
        buffer.size = this.size;
        return buffer;
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        int i = segment.limit;
        return (i >= 8192 || !segment.owner) ? j : j - ((long) (i - segment.pos));
    }

    public final void copyTo(Buffer buffer, long j, long j2) {
        long j3 = j;
        SegmentedByteString.checkOffsetAndCount(this.size, j3, j2);
        if (j2 == 0) {
            return;
        }
        buffer.size += j2;
        Segment segment = this.head;
        while (true) {
            long j4 = segment.limit - segment.pos;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            segment = segment.next;
        }
        Segment segment2 = segment;
        long j5 = j2;
        while (j5 > 0) {
            Segment segmentSharedCopy = segment2.sharedCopy();
            int i = segmentSharedCopy.pos + ((int) j3);
            segmentSharedCopy.pos = i;
            segmentSharedCopy.limit = Math.min(i + ((int) j5), segmentSharedCopy.limit);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                buffer.head = segmentSharedCopy;
            } else {
                segment3.prev.push(segmentSharedCopy);
            }
            j5 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
            segment2 = segment2.next;
            j3 = 0;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        long j = this.size;
        Buffer buffer = (Buffer) obj;
        if (j != buffer.size) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i = segment.pos;
        int i2 = segment2.pos;
        long j2 = 0;
        while (j2 < this.size) {
            long jMin = Math.min(segment.limit - i, segment2.limit - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            }
            j2 += jMin;
        }
        return true;
    }

    public final boolean exhausted() {
        return this.size == 0;
    }

    public final byte getByte(long j) {
        SegmentedByteString.checkOffsetAndCount(this.size, j, 1L);
        Segment segment = this.head;
        segment.getClass();
        long j2 = this.size;
        if (j2 - j < j) {
            while (j2 > j) {
                segment = segment.prev;
                j2 -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return segment.data[(int) ((((long) i2) + j) - j3)];
            }
            segment = segment.next;
            j3 = j4;
        }
    }

    public final int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    public final long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + this.size + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        long j4 = this.size;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j == j2 || (segment = this.head) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.prev;
                j4 -= (long) (segment.limit - segment.pos);
            }
            while (j4 < j2) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - j4);
                for (int i = (int) ((((long) segment.pos) + j) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - segment.pos)) + j4;
                    }
                }
                j4 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = ((long) (segment.limit - segment.pos)) + j3;
            if (j5 > j) {
                break;
            }
            segment = segment.next;
            j3 = j5;
        }
        while (j3 < j2) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - j3);
            for (int i2 = (int) ((((long) segment.pos) + j) - j3); i2 < iMin2; i2++) {
                if (bArr2[i2] == b) {
                    return ((long) (i2 - segment.pos)) + j3;
                }
            }
            j3 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j = j3;
        }
        return -1L;
    }

    public final long indexOfElement(ByteString byteString) {
        int i;
        int i2;
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j = this.size;
        long j2 = 0;
        if (j < 0) {
            while (j > 0) {
                segment = segment.prev;
                j -= (long) (segment.limit - segment.pos);
            }
            if (byteString.getSize$okio() == 2) {
                byte bInternalGet$okio = byteString.internalGet$okio(0);
                byte bInternalGet$okio2 = byteString.internalGet$okio(1);
                while (j < this.size) {
                    byte[] bArr = segment.data;
                    i = (int) ((((long) segment.pos) + j2) - j);
                    int i3 = segment.limit;
                    while (true) {
                        if (i >= i3) {
                            j2 = ((long) (segment.limit - segment.pos)) + j;
                            segment = segment.next;
                            j = j2;
                        } else {
                            byte b = bArr[i];
                            if (b == bInternalGet$okio || b == bInternalGet$okio2) {
                                i2 = segment.pos;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = byteString.internalArray$okio();
            while (j < this.size) {
                byte[] bArr2 = segment.data;
                i = (int) ((((long) segment.pos) + j2) - j);
                int i4 = segment.limit;
                while (true) {
                    if (i < i4) {
                        byte b2 = bArr2[i];
                        int length = bArrInternalArray$okio.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                i++;
                            } else if (b2 == bArrInternalArray$okio[i5]) {
                                i2 = segment.pos;
                            } else {
                                i5++;
                            }
                        }
                    } else {
                        j2 = ((long) (segment.limit - segment.pos)) + j;
                        segment = segment.next;
                        j = j2;
                    }
                }
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j;
            if (j3 > 0) {
                break;
            }
            segment = segment.next;
            j = j3;
        }
        if (byteString.getSize$okio() == 2) {
            byte bInternalGet$okio3 = byteString.internalGet$okio(0);
            byte bInternalGet$okio4 = byteString.internalGet$okio(1);
            while (j < this.size) {
                byte[] bArr3 = segment.data;
                i = (int) ((((long) segment.pos) + j2) - j);
                int i6 = segment.limit;
                while (true) {
                    if (i >= i6) {
                        j2 = ((long) (segment.limit - segment.pos)) + j;
                        segment = segment.next;
                        j = j2;
                    } else {
                        byte b3 = bArr3[i];
                        if (b3 == bInternalGet$okio3 || b3 == bInternalGet$okio4) {
                            i2 = segment.pos;
                        } else {
                            i++;
                        }
                    }
                }
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
        while (j < this.size) {
            byte[] bArr4 = segment.data;
            i = (int) ((((long) segment.pos) + j2) - j);
            int i7 = segment.limit;
            while (true) {
                if (i < i7) {
                    byte b4 = bArr4[i];
                    int length2 = bArrInternalArray$okio2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            i++;
                        } else if (b4 == bArrInternalArray$okio2[i8]) {
                            i2 = segment.pos;
                        } else {
                            i8++;
                        }
                    }
                } else {
                    j2 = ((long) (segment.limit - segment.pos)) + j;
                    segment = segment.next;
                    j = j2;
                }
            }
        }
        return -1L;
        return ((long) (i - i2)) + j;
    }

    @Override // okio.BufferedSource
    public final InputStream inputStream() {
        return new AnonymousClass1(this, 0);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final boolean rangeEquals(ByteString byteString) {
        int size$okio = byteString.getSize$okio();
        if (size$okio >= 0 && this.size >= size$okio && byteString.getSize$okio() >= size$okio) {
            for (int i = 0; i < size$okio; i++) {
                if (getByte(i) == byteString.internalGet$okio(i)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // okio.Source
    public final long read(long j, Buffer buffer) {
        if (j < 0) {
            throw new IllegalArgumentException(Modifier.CC.m("byteCount < 0: ", j).toString());
        }
        long j2 = this.size;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer.write(j, this);
        return j;
    }

    @Override // okio.BufferedSource
    public final long readAll(RealBufferedSink realBufferedSink) {
        long j = this.size;
        if (j > 0) {
            realBufferedSink.write(j, this);
        }
        return j;
    }

    @Override // okio.BufferedSource
    public final byte readByte() {
        long j = this.size;
        if (j == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size = j - 1;
        if (i3 != i2) {
            segment.pos = i3;
            return b;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return b;
    }

    @Override // okio.BufferedSource
    public final byte[] readByteArray() {
        return readByteArray(this.size);
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString(long j) {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(Modifier.CC.m("byteCount: ", j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(readByteArray(j));
        }
        ByteString byteStringSnapshot = snapshot((int) j);
        skip(j);
        return byteStringSnapshot;
    }

    @Override // okio.BufferedSource
    public final long readHexadecimalUnsignedLong() throws EOFException {
        int i;
        if (this.size == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            Segment segment = this.head;
            byte[] bArr = segment.data;
            int i3 = segment.pos;
            int i4 = segment.limit;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else {
                    if (b < 65 || b > 70) {
                        z = true;
                        if (i2 != 0) {
                            break;
                        }
                        char[] cArr = ZipFilesKt.HEX_DIGIT_CHARS;
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]})));
                    }
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    Buffer buffer = new Buffer();
                    buffer.writeHexadecimalUnsignedLong(j);
                    buffer.m857writeByte((int) b);
                    throw new NumberFormatException("Number too large: ".concat(buffer.readString(buffer.size, Charsets.UTF_8)));
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            if (z) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i2;
        return j;
    }

    @Override // okio.BufferedSource
    public final int readInt() throws EOFException {
        long j = this.size;
        if (j < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.size = j - 4;
        if (i5 != i2) {
            segment.pos = i5;
            return i6;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return i6;
    }

    @Override // okio.BufferedSource
    public final int readIntLe() throws EOFException {
        int i = readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // okio.BufferedSource
    public final short readShort() throws EOFException {
        long j = this.size;
        if (j < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.size = j - 2;
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @Override // okio.BufferedSource
    public final short readShortLe() throws EOFException {
        short s = readShort();
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public final String readString(long j, Charset charset) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(Modifier.CC.m("byteCount: ", j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.head;
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment.data, i, i2, charset);
        int i3 = segment.pos + i2;
        segment.pos = i3;
        this.size -= j;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public final void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final void skip(long j) {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(this.size, 0L, i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new C0045SegmentedByteString(bArr, iArr);
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final String toString() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.size).toString());
    }

    public final Segment writableSegment$okio(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            this.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        Segment segment2 = segment.prev;
        if (segment2.limit + i <= 8192 && segment2.owner) {
            return segment2;
        }
        Segment segmentTake2 = SegmentPool.take();
        segment2.push(segmentTake2);
        return segmentTake2;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink write(ByteString byteString) {
        m856write(byteString);
        return this;
    }

    public final void writeAll(Source source) {
        while (source.read(8192L, this) != -1) {
        }
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        m857writeByte(i);
        return this;
    }

    public final void writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            m857writeByte(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = okio.internal.Buffer.HEX_DIGIT_BYTES[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        this.size += (long) i;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeInt(int i) {
        m858writeInt(i);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeShort(int i) {
        m859writeShort(i);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeUtf8(String str) {
        m860writeUtf8(str);
        return this;
    }

    public final void writeUtf8CodePoint(int i) {
        if (i < 128) {
            m857writeByte(i);
            return;
        }
        if (i < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            this.size += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            m857writeByte(63);
            return;
        }
        if (i < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i3 = segmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i3 + 3;
            this.size += 3;
            return;
        }
        if (i > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(SegmentedByteString.toHexString(i)));
        }
        Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
        byte[] bArr3 = segmentWritableSegment$okio3.data;
        int i4 = segmentWritableSegment$okio3.limit;
        bArr3[i4] = (byte) ((i >> 18) | 240);
        bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i4 + 3] = (byte) ((i & 63) | 128);
        segmentWritableSegment$okio3.limit = i4 + 4;
        this.size += 4;
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(Modifier.CC.m("limit < 0: ", j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(jIndexOf, this);
        }
        if (j2 < this.size && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return okio.internal.Buffer.readUtf8Line(j2, this);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, this.size));
        throw new EOFException("\\n not found: limit=" + Math.min(this.size, j) + " content=" + buffer.readByteString(buffer.size).hex() + (char) 8230);
    }

    @Override // okio.Sink
    public final void write(long j, Buffer buffer) {
        Segment segmentTake;
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        SegmentedByteString.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            Segment segment = buffer.head;
            int i = segment.limit - segment.pos;
            if (j < i) {
                Segment segment2 = this.head;
                Segment segment3 = segment2 != null ? segment2.prev : null;
                if (segment3 != null && segment3.owner) {
                    if ((((long) segment3.limit) + j) - ((long) (segment3.shared ? 0 : segment3.pos)) <= 8192) {
                        segment.writeTo(segment3, (int) j);
                        buffer.size -= j;
                        this.size += j;
                        return;
                    }
                }
                int i2 = (int) j;
                if (i2 <= 0 || i2 > i) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i2 >= 1024) {
                    segmentTake = segment.sharedCopy();
                } else {
                    segmentTake = SegmentPool.take();
                    byte[] bArr = segment.data;
                    byte[] bArr2 = segmentTake.data;
                    int i3 = segment.pos;
                    System.arraycopy(bArr, i3, bArr2, 0, (i3 + i2) - i3);
                }
                segmentTake.limit = segmentTake.pos + i2;
                segment.pos += i2;
                segment.prev.push(segmentTake);
                buffer.head = segmentTake;
            }
            Segment segment4 = buffer.head;
            long j2 = segment4.limit - segment4.pos;
            buffer.head = segment4.pop();
            Segment segment5 = this.head;
            if (segment5 == null) {
                this.head = segment4;
                segment4.prev = segment4;
                segment4.next = segment4;
            } else {
                segment5.prev.push(segment4);
                Segment segment6 = segment4.prev;
                if (segment6 == segment4) {
                    throw new IllegalStateException("cannot compact");
                }
                if (segment6.owner) {
                    int i4 = segment4.limit - segment4.pos;
                    if (i4 <= (8192 - segment6.limit) + (segment6.shared ? 0 : segment6.pos)) {
                        segment4.writeTo(segment6, i4);
                        segment4.pop();
                        SegmentPool.recycle(segment4);
                    }
                }
            }
            buffer.size -= j2;
            this.size += j2;
            j -= j2;
        }
    }

    /* JADX INFO: renamed from: writeByte, reason: collision with other method in class */
    public final void m857writeByte(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
    }

    /* JADX INFO: renamed from: writeInt, reason: collision with other method in class */
    public final void m858writeInt(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 4;
        this.size += 4;
    }

    /* JADX INFO: renamed from: writeShort, reason: collision with other method in class */
    public final void m859writeShort(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 2;
        this.size += 2;
    }

    /* JADX INFO: renamed from: writeUtf8, reason: collision with other method in class */
    public final void m860writeUtf8(String str) {
        writeUtf8(0, str.length(), str);
    }

    public final byte[] readByteArray(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(Modifier.CC.m("byteCount: ", j).toString());
        }
        if (this.size >= j) {
            int i = (int) j;
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = read(bArr, i2, i - i2);
                if (i3 == -1) {
                    throw new EOFException();
                }
                i2 += i3;
            }
            return bArr;
        }
        throw new EOFException();
    }

    public final void writeUtf8(int i, int i2, String str) {
        char cCharAt;
        if (i < 0) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("beginIndex < 0: ", i).toString());
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i2, "endIndex > string.length: ", " > ");
                sbM.append(str.length());
                throw new IllegalArgumentException(sbM.toString().toString());
            }
            while (i < i2) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 128) {
                    Segment segmentWritableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = segmentWritableSegment$okio.data;
                    int i3 = segmentWritableSegment$okio.limit - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt2;
                    while (true) {
                        i = i4;
                        if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) cCharAt;
                    }
                    int i5 = segmentWritableSegment$okio.limit;
                    int i6 = (i3 + i) - i5;
                    segmentWritableSegment$okio.limit = i5 + i6;
                    this.size += (long) i6;
                } else {
                    if (cCharAt2 < 2048) {
                        Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = segmentWritableSegment$okio2.data;
                        int i7 = segmentWritableSegment$okio2.limit;
                        bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                        bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                        segmentWritableSegment$okio2.limit = i7 + 2;
                        this.size += 2;
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i8 = i + 1;
                        char cCharAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                        if (cCharAt2 <= 56319 && 56320 <= cCharAt3 && cCharAt3 < 57344) {
                            int i9 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = segmentWritableSegment$okio3.data;
                            int i10 = segmentWritableSegment$okio3.limit;
                            bArr3[i10] = (byte) ((i9 >> 18) | 240);
                            bArr3[i10 + 1] = (byte) (((i9 >> 12) & 63) | 128);
                            bArr3[i10 + 2] = (byte) (((i9 >> 6) & 63) | 128);
                            bArr3[i10 + 3] = (byte) ((i9 & 63) | 128);
                            segmentWritableSegment$okio3.limit = i10 + 4;
                            this.size += 4;
                            i += 2;
                        } else {
                            m857writeByte(63);
                            i = i8;
                        }
                    } else {
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i11 = segmentWritableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((cCharAt2 >> '\f') | 224);
                        bArr4[i11 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                        bArr4[i11 + 2] = (byte) ((cCharAt2 & '?') | 128);
                        segmentWritableSegment$okio4.limit = i11 + 3;
                        this.size += 3;
                    }
                    i++;
                }
            }
            return;
        }
        throw new IllegalArgumentException(Modifier.CC.m(i2, i, "endIndex < beginIndex: ", " < ").toString());
    }

    /* JADX INFO: renamed from: okio.Buffer$inputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends InputStream {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ BufferedSource this$0;

        public /* synthetic */ AnonymousClass1(BufferedSource bufferedSource, int i) {
            this.$r8$classId = i;
            this.this$0 = bufferedSource;
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            long jMin;
            switch (this.$r8$classId) {
                case 0:
                    jMin = Math.min(((Buffer) this.this$0).size, Integer.MAX_VALUE);
                    break;
                default:
                    RealBufferedSource realBufferedSource = (RealBufferedSource) this.this$0;
                    if (realBufferedSource.closed) {
                        throw new IOException("closed");
                    }
                    jMin = Math.min(realBufferedSource.bufferField.size, Integer.MAX_VALUE);
                    break;
            }
            return (int) jMin;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            switch (this.$r8$classId) {
                case 0:
                    break;
                default:
                    ((RealBufferedSource) this.this$0).close();
                    break;
            }
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            switch (this.$r8$classId) {
                case 0:
                    Buffer buffer = (Buffer) this.this$0;
                    if (buffer.size > 0) {
                        return buffer.readByte() & 255;
                    }
                    return -1;
                default:
                    RealBufferedSource realBufferedSource = (RealBufferedSource) this.this$0;
                    Buffer buffer2 = realBufferedSource.bufferField;
                    if (realBufferedSource.closed) {
                        throw new IOException("closed");
                    }
                    if (buffer2.size == 0 && realBufferedSource.source.read(8192L, buffer2) == -1) {
                        return -1;
                    }
                    return buffer2.readByte() & 255;
            }
        }

        public final String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return ((Buffer) this.this$0) + ".inputStream()";
                default:
                    return ((RealBufferedSource) this.this$0) + ".inputStream()";
            }
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            switch (this.$r8$classId) {
                case 0:
                    return ((Buffer) this.this$0).read(bArr, i, i2);
                default:
                    RealBufferedSource realBufferedSource = (RealBufferedSource) this.this$0;
                    Buffer buffer = realBufferedSource.bufferField;
                    if (!realBufferedSource.closed) {
                        SegmentedByteString.checkOffsetAndCount(bArr.length, i, i2);
                        if (buffer.size == 0 && realBufferedSource.source.read(8192L, buffer) == -1) {
                            return -1;
                        }
                        return buffer.read(bArr, i, i2);
                    }
                    throw new IOException("closed");
            }
        }

        private final void close$okio$Buffer$inputStream$1() {
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        int i = segment.pos + iMin;
        segment.pos = i;
        this.size -= (long) iMin;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public final int read(byte[] bArr, int i, int i2) {
        SegmentedByteString.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        System.arraycopy(bArr2, i3, bArr, i, (i3 + iMin) - i3);
        int i4 = segment.pos + iMin;
        segment.pos = i4;
        this.size -= (long) iMin;
        if (i4 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // okio.BufferedSource
    public final Buffer getBuffer() {
        return this;
    }

    /* JADX INFO: renamed from: write, reason: collision with other method in class */
    public final void m856write(ByteString byteString) {
        byteString.write$okio(this, byteString.getSize$okio());
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i, 8192 - segmentWritableSegment$okio.limit);
            byteBuffer.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] bArr) {
        write(bArr.length, bArr);
        return this;
    }

    public final void write(int i, byte[] bArr) {
        int i2 = 0;
        long j = i;
        SegmentedByteString.checkOffsetAndCount(bArr.length, 0, j);
        while (i2 < i) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i - i2, 8192 - segmentWritableSegment$okio.limit);
            int i3 = i2 + iMin;
            System.arraycopy(bArr, i2, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i3 - i2);
            segmentWritableSegment$okio.limit += iMin;
            i2 = i3;
        }
        this.size += j;
    }
}
