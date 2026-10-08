package okhttp3.internal.http2;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Unit;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Stream {
    public final Http2Connection connection;
    public int errorCode;
    public IOException errorException;
    public boolean hasResponseHeaders;
    public final ArrayDeque headersQueue;
    public final int id;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final StreamTimeout readTimeout;
    public final FramingSink sink;
    public final FramingSource source;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final StreamTimeout writeTimeout;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FramingSink implements Sink {
        public boolean closed;
        public final boolean finished;
        public final Buffer sendBuffer = new Buffer();

        public FramingSink(boolean z) {
            this.finished = z;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws SocketTimeoutException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            synchronized (http2Stream) {
                if (this.closed) {
                    return;
                }
                boolean z = http2Stream.getErrorCode$okhttp() == 0;
                Unit unit = Unit.INSTANCE;
                Http2Stream http2Stream2 = Http2Stream.this;
                if (!http2Stream2.sink.finished) {
                    if (this.sendBuffer.size > 0) {
                        while (this.sendBuffer.size > 0) {
                            emitFrame(true);
                        }
                    } else if (z) {
                        http2Stream2.connection.writeData(http2Stream2.id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                    Unit unit2 = Unit.INSTANCE;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        public final void emitFrame(boolean z) throws SocketTimeoutException {
            long jMin;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                try {
                    http2Stream.writeTimeout.enter();
                    while (http2Stream.writeBytesTotal >= http2Stream.writeBytesMaximum && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == 0) {
                        try {
                            try {
                                http2Stream.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw new InterruptedIOException();
                            }
                        } catch (Throwable th) {
                            http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                            throw th;
                        }
                    }
                    http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                    http2Stream.checkOutNotClosed$okhttp();
                    jMin = Math.min(http2Stream.writeBytesMaximum - http2Stream.writeBytesTotal, this.sendBuffer.size);
                    http2Stream.writeBytesTotal += jMin;
                    z2 = z && jMin == this.sendBuffer.size;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream http2Stream2 = Http2Stream.this;
                http2Stream2.connection.writeData(http2Stream2.id, z2, this.sendBuffer, jMin);
            } finally {
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws SocketTimeoutException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            synchronized (http2Stream) {
                http2Stream.checkOutNotClosed$okhttp();
                Unit unit = Unit.INSTANCE;
            }
            while (this.sendBuffer.size > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink
        public final void write(long j, Buffer buffer) throws SocketTimeoutException {
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            Buffer buffer2 = this.sendBuffer;
            buffer2.write(j, buffer);
            while (buffer2.size >= 16384) {
                emitFrame(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FramingSource implements Source {
        public boolean closed;
        public boolean finished;
        public final long maxByteCount;
        public final Buffer receiveBuffer = new Buffer();
        public final Buffer readBuffer = new Buffer();

        public FramingSource(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            long j;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                Buffer buffer = this.readBuffer;
                j = buffer.size;
                buffer.skip(j);
                http2Stream.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (j > 0) {
                Http2Stream http2Stream2 = Http2Stream.this;
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                http2Stream2.connection.updateConnectionFlowControl$okhttp(j);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        @Override // okio.Source
        public final long read(long j, Buffer buffer) throws Throwable {
            Throwable streamResetException;
            boolean z;
            long j2;
            long j3 = 0;
            if (j < 0) {
                throw new IllegalArgumentException(Modifier.CC.m("byteCount < 0: ", j).toString());
            }
            while (true) {
                Http2Stream http2Stream = Http2Stream.this;
                synchronized (http2Stream) {
                    http2Stream.readTimeout.enter();
                    try {
                        if (http2Stream.getErrorCode$okhttp() == 0 || this.finished) {
                            streamResetException = null;
                        } else {
                            streamResetException = http2Stream.errorException;
                            if (streamResetException == null) {
                                streamResetException = new StreamResetException(http2Stream.getErrorCode$okhttp());
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        Buffer buffer2 = this.readBuffer;
                        long j4 = buffer2.size;
                        z = false;
                        if (j4 > j3) {
                            j2 = buffer2.read(Math.min(j, j4), buffer);
                            long j5 = http2Stream.readBytesTotal + j2;
                            http2Stream.readBytesTotal = j5;
                            long j6 = j5 - http2Stream.readBytesAcknowledged;
                            if (streamResetException == null && j6 >= http2Stream.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                http2Stream.connection.writeWindowUpdateLater$okhttp(http2Stream.id, j6);
                                http2Stream.readBytesAcknowledged = http2Stream.readBytesTotal;
                            }
                        } else {
                            if (!this.finished && streamResetException == null) {
                                try {
                                    http2Stream.wait();
                                    z = true;
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    throw new InterruptedIOException();
                                }
                            }
                            j2 = -1;
                        }
                        http2Stream.readTimeout.exitAndThrowIfTimedOut();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        http2Stream.readTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                if (!z) {
                    if (j2 != -1) {
                        return j2;
                    }
                    if (streamResetException == null) {
                        return -1L;
                    }
                    throw streamResetException;
                }
                j3 = 0;
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws SocketTimeoutException {
            if (exit()) {
                throw new SocketTimeoutException("timeout");
            }
        }

        @Override // okio.AsyncTimeout
        public final void timedOut() {
            Http2Stream.this.closeLater(9);
            Http2Connection http2Connection = Http2Stream.this.connection;
            synchronized (http2Connection) {
                long j = http2Connection.degradedPongsReceived;
                long j2 = http2Connection.degradedPingsSent;
                if (j < j2) {
                    return;
                }
                http2Connection.degradedPingsSent = j2 + 1;
                http2Connection.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);
                Unit unit = Unit.INSTANCE;
                http2Connection.writerQueue.schedule(new TaskQueue$execute$1(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), http2Connection.connectionName, " ping"), http2Connection, 2), 0L);
            }
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        this.id = i;
        this.connection = http2Connection;
        this.writeBytesMaximum = http2Connection.peerSettings.getInitialWindowSize();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001c  */
    public final void cancelStreamIfNecessary$okhttp() {
        boolean z;
        boolean zIsOpen;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            try {
                FramingSource framingSource = this.source;
                if (framingSource.finished || !framingSource.closed) {
                    z = false;
                } else {
                    FramingSink framingSink = this.sink;
                    if (framingSink.finished || framingSink.closed) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                zIsOpen = isOpen();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            close(9, null);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != 0) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                throw new StreamResetException(this.errorCode);
            }
        }
    }

    public final void close(int i, IOException iOException) {
        if (closeInternal(i, iOException)) {
            this.connection.writer.rstStream(this.id, i);
        }
    }

    public final boolean closeInternal(int i, IOException iOException) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            if (this.errorCode != 0) {
                return false;
            }
            this.errorCode = i;
            this.errorException = iOException;
            notifyAll();
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            Unit unit = Unit.INSTANCE;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void closeLater(int i) {
        if (closeInternal(i, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, i);
        }
    }

    public final synchronized int getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final boolean isLocallyInitiated() {
        boolean z = (this.id & 1) == 1;
        this.connection.getClass();
        return true == z;
    }

    public final synchronized boolean isOpen() {
        try {
            if (this.errorCode != 0) {
                return false;
            }
            FramingSource framingSource = this.source;
            if (framingSource.finished || framingSource.closed) {
                FramingSink framingSink = this.sink;
                if ((framingSink.finished || framingSink.closed) && this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void receiveHeaders(Headers headers, boolean z) {
        boolean zIsOpen;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && z) {
                    this.source.getClass();
                } else {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                }
                if (z) {
                    this.source.finished = true;
                }
                zIsOpen = isOpen();
                notifyAll();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream$okhttp(this.id);
    }

    public final synchronized void receiveRstStream(int i) {
        if (this.errorCode == 0) {
            this.errorCode = i;
            notifyAll();
        }
    }
}
