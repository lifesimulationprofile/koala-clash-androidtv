package okio;

import androidx.compose.ui.Modifier;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JvmFileHandle implements Closeable {
    public boolean closed;
    public final ReentrantLock lock = new ReentrantLock();
    public int openStreamCount;
    public final RandomAccessFile randomAccessFile;

    public JvmFileHandle(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                reentrantLock.unlock();
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                reentrantLock.unlock();
                return;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            synchronized (this) {
                this.randomAccessFile.close();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        long length;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            synchronized (this) {
                length = this.randomAccessFile.length();
            }
            return length;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [okio.FileHandle$FileHandleSource] */
    public final FileHandle$FileHandleSource source(final long j) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new Source(this, j) { // from class: okio.FileHandle$FileHandleSource
                public boolean closed;
                public final JvmFileHandle fileHandle;
                public long position;

                {
                    this.fileHandle = this;
                    this.position = j;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    JvmFileHandle jvmFileHandle = this.fileHandle;
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    ReentrantLock reentrantLock2 = jvmFileHandle.lock;
                    reentrantLock2.lock();
                    try {
                        int i = jvmFileHandle.openStreamCount - 1;
                        jvmFileHandle.openStreamCount = i;
                        if (i == 0 && jvmFileHandle.closed) {
                            Unit unit = Unit.INSTANCE;
                            reentrantLock2.unlock();
                            synchronized (jvmFileHandle) {
                                jvmFileHandle.randomAccessFile.close();
                            }
                            return;
                        }
                        reentrantLock2.unlock();
                    } catch (Throwable th) {
                        reentrantLock2.unlock();
                        throw th;
                    }
                }

                @Override // okio.Source
                public final long read(long j2, Buffer buffer) {
                    long j3;
                    long j4;
                    int i;
                    if (this.closed) {
                        throw new IllegalStateException("closed");
                    }
                    JvmFileHandle jvmFileHandle = this.fileHandle;
                    long j5 = this.position;
                    if (j2 < 0) {
                        throw new IllegalArgumentException(Modifier.CC.m("byteCount < 0: ", j2).toString());
                    }
                    long j6 = j2 + j5;
                    long j7 = j5;
                    while (true) {
                        if (j7 < j6) {
                            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = segmentWritableSegment$okio.data;
                            int i2 = segmentWritableSegment$okio.limit;
                            j3 = -1;
                            int iMin = (int) Math.min(j6 - j7, 8192 - i2);
                            synchronized (jvmFileHandle) {
                                jvmFileHandle.randomAccessFile.seek(j7);
                                i = 0;
                                while (true) {
                                    if (i < iMin) {
                                        int i3 = jvmFileHandle.randomAccessFile.read(bArr, i2, iMin - i);
                                        if (i3 != -1) {
                                            i += i3;
                                        } else if (i == 0) {
                                            i = -1;
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (i == -1) {
                                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                                    buffer.head = segmentWritableSegment$okio.pop();
                                    SegmentPool.recycle(segmentWritableSegment$okio);
                                }
                                if (j5 == j7) {
                                    j4 = -1;
                                    break;
                                }
                            } else {
                                segmentWritableSegment$okio.limit += i;
                                long j8 = i;
                                j7 += j8;
                                buffer.size += j8;
                            }
                        } else {
                            j3 = -1;
                        }
                        j4 = j7 - j5;
                        break;
                    }
                    if (j4 != j3) {
                        this.position += j4;
                    }
                    return j4;
                }

                @Override // okio.Source
                public final Timeout timeout() {
                    return Timeout.NONE;
                }
            };
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
