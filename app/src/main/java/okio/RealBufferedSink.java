package okio;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        this.sink = sink;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Sink sink = this.sink;
        if (this.closed) {
            return;
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        if (j > 0) {
            sink.write(j, buffer);
        }
        th = null;
        try {
            sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final BufferedSink emitCompleteSegments() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.bufferField;
        long jCompleteSegmentByteCount = buffer.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(jCompleteSegmentByteCount, buffer);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        Sink sink = this.sink;
        if (j > 0) {
            sink.write(j, buffer);
        }
        sink.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.sink.timeout();
    }

    public final String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.bufferField.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeByte(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.m857writeByte(i);
        emitCompleteSegments();
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0032  */
    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:41:0x0089  */
    /* JADX WARN: Code duplicated, block: B:43:0x0090  */
    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    /* JADX WARN: Code duplicated, block: B:45:0x0095  */
    /* JADX WARN: Code duplicated, block: B:47:0x009e  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00da  */
    /* JADX WARN: Code duplicated, block: B:63:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ff A[LOOP:0: B:71:0x00fb->B:73:0x00ff, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x010f  */
    public final BufferedSink writeDecimalLong(long j) {
        byte[] bArr;
        int i;
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.bufferField;
        buffer.getClass();
        if (j == 0) {
            buffer.m857writeByte(48);
        } else {
            boolean z = false;
            int i2 = 1;
            if (j < 0) {
                j = -j;
                if (j < 0) {
                    buffer.writeUtf8(0, 20, "-9223372036854775808");
                } else {
                    z = true;
                    if (j < 100000000) {
                        if (j < 10000) {
                            if (j < 100) {
                                if (j >= 10) {
                                    i2 = 2;
                                }
                            } else if (j < 1000) {
                                i2 = 3;
                            } else {
                                i2 = 4;
                            }
                        } else if (j < 1000000) {
                            if (j < 100000) {
                                i2 = 5;
                            } else {
                                i2 = 6;
                            }
                        } else if (j < 10000000) {
                            i2 = 7;
                        } else {
                            i2 = 8;
                        }
                    } else if (j < 1000000000000L) {
                        if (j < 10000000000L) {
                            if (j < 1000000000) {
                                i2 = 9;
                            } else {
                                i2 = 10;
                            }
                        } else if (j < 100000000000L) {
                            i2 = 11;
                        } else {
                            i2 = 12;
                        }
                    } else if (j < 1000000000000000L) {
                        if (j < 10000000000000L) {
                            i2 = 13;
                        } else if (j < 100000000000000L) {
                            i2 = 14;
                        } else {
                            i2 = 15;
                        }
                    } else if (j < 100000000000000000L) {
                        if (j < 10000000000000000L) {
                            i2 = 16;
                        } else {
                            i2 = 17;
                        }
                    } else if (j < 1000000000000000000L) {
                        i2 = 18;
                    } else {
                        i2 = 19;
                    }
                    if (z) {
                        i2++;
                    }
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
                    bArr = segmentWritableSegment$okio.data;
                    i = segmentWritableSegment$okio.limit + i2;
                    while (j != 0) {
                        long j2 = 10;
                        i--;
                        bArr[i] = okio.internal.Buffer.HEX_DIGIT_BYTES[(int) (j % j2)];
                        j /= j2;
                    }
                    if (z) {
                        bArr[i - 1] = 45;
                    }
                    segmentWritableSegment$okio.limit += i2;
                    buffer.size += (long) i2;
                }
            } else {
                if (j < 100000000) {
                    if (j < 10000) {
                        if (j < 100) {
                            if (j >= 10) {
                                i2 = 2;
                            }
                        } else if (j < 1000) {
                            i2 = 3;
                        } else {
                            i2 = 4;
                        }
                    } else if (j < 1000000) {
                        if (j < 100000) {
                            i2 = 5;
                        } else {
                            i2 = 6;
                        }
                    } else if (j < 10000000) {
                        i2 = 7;
                    } else {
                        i2 = 8;
                    }
                } else if (j < 1000000000000L) {
                    if (j < 10000000000L) {
                        if (j < 1000000000) {
                            i2 = 9;
                        } else {
                            i2 = 10;
                        }
                    } else if (j < 100000000000L) {
                        i2 = 11;
                    } else {
                        i2 = 12;
                    }
                } else if (j < 1000000000000000L) {
                    if (j < 10000000000000L) {
                        i2 = 13;
                    } else if (j < 100000000000000L) {
                        i2 = 14;
                    } else {
                        i2 = 15;
                    }
                } else if (j < 100000000000000000L) {
                    if (j < 10000000000000000L) {
                        i2 = 16;
                    } else {
                        i2 = 17;
                    }
                } else if (j < 1000000000000000000L) {
                    i2 = 18;
                } else {
                    i2 = 19;
                }
                if (z) {
                    i2++;
                }
                Segment segmentWritableSegment$okio2 = buffer.writableSegment$okio(i2);
                bArr = segmentWritableSegment$okio2.data;
                i = segmentWritableSegment$okio2.limit + i2;
                while (j != 0) {
                    long j3 = 10;
                    i--;
                    bArr[i] = okio.internal.Buffer.HEX_DIGIT_BYTES[(int) (j % j3)];
                    j /= j3;
                }
                if (z) {
                    bArr[i - 1] = 45;
                }
                segmentWritableSegment$okio2.limit += i2;
                buffer.size += (long) i2;
            }
        }
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeInt(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.m858writeInt(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeShort(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.m859writeShort(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String str) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.m860writeUtf8(str);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.Sink
    public final void write(long j, Buffer buffer) {
        if (!this.closed) {
            this.bufferField.write(j, buffer);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(ByteString byteString) {
        if (!this.closed) {
            this.bufferField.m856write(byteString);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] bArr) {
        if (!this.closed) {
            this.bufferField.write(bArr.length, bArr);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
