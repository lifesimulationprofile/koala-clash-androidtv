package okhttp3.internal.http2;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Reader implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final BufferedSource source;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static int lengthWithoutPadding(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException(Modifier.CC.m(i3, i, "PROTOCOL_ERROR padding ", " > remaining length "));
        }
    }

    public Http2Reader(RealBufferedSource realBufferedSource) {
        this.source = realBufferedSource;
        ContinuationSource continuationSource = new ContinuationSource(realBufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.source.close();
    }

    /* JADX WARN: Code duplicated, block: B:113:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:121:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:123:0x01f8  */
    public final boolean nextFrame(boolean z, Http2Connection.ReaderRunnable readerRunnable) throws IOException {
        Http2Connection http2Connection;
        Http2Stream http2StreamRemoveStream$okhttp;
        int i = 0;
        try {
            this.source.require(9L);
            int medium = Util.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("FRAME_SIZE_ERROR: ", medium));
            }
            int i2 = this.source.readByte() & 255;
            byte b = this.source.readByte();
            int i3 = b & 255;
            int i4 = this.source.readInt();
            int i5 = Integer.MAX_VALUE & i4;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.frameLog(true, i5, medium, i2, i3));
            }
            if (z && i2 != 4) {
                StringBuilder sb = new StringBuilder("Expected a SETTINGS frame but was ");
                String[] strArr = Http2.FRAME_NAMES;
                sb.append(i2 < strArr.length ? strArr[i2] : Util.format("0x%02x", Integer.valueOf(i2)));
                throw new IOException(sb.toString());
            }
            switch (i2) {
                case 0:
                    readData(readerRunnable, medium, i3, i5);
                    return true;
                case 1:
                    readHeaders(readerRunnable, medium, i3, i5);
                    return true;
                case 2:
                    if (medium != 5) {
                        throw new IOException(CaptureSession$State$EnumUnboxingLocalUtility.m(medium, "TYPE_PRIORITY length: ", " != 5"));
                    }
                    if (i5 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    BufferedSource bufferedSource = this.source;
                    bufferedSource.readInt();
                    bufferedSource.readByte();
                    return true;
                case 3:
                    if (medium != 4) {
                        throw new IOException(CaptureSession$State$EnumUnboxingLocalUtility.m(medium, "TYPE_RST_STREAM length: ", " != 4"));
                    }
                    if (i5 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i6 = this.source.readInt();
                    for (int i7 : CaptureSession$State$EnumUnboxingLocalUtility.values(14)) {
                        if (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i7) == i6) {
                            i = i7;
                            if (i != 0) {
                                throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("TYPE_RST_STREAM unexpected error code: ", i6));
                            }
                            http2Connection = (Http2Connection) readerRunnable.this$0;
                            if (i5 != 0 || (i4 & 1) != 0) {
                                http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i5);
                                if (http2StreamRemoveStream$okhttp != null) {
                                    http2StreamRemoveStream$okhttp.receiveRstStream(i);
                                }
                                return true;
                            }
                            http2Connection.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(http2Connection.connectionName + '[' + i5 + "] onReset", http2Connection, i5, i), 0L);
                            return true;
                        }
                    }
                    if (i != 0) {
                        throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("TYPE_RST_STREAM unexpected error code: ", i6));
                    }
                    http2Connection = (Http2Connection) readerRunnable.this$0;
                    if (i5 != 0) {
                    }
                    http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i5);
                    if (http2StreamRemoveStream$okhttp != null) {
                        http2StreamRemoveStream$okhttp.receiveRstStream(i);
                    }
                    return true;
                case 4:
                    BufferedSource bufferedSource2 = this.source;
                    if (i5 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((b & 1) != 0) {
                        if (medium != 0) {
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        return true;
                    }
                    if (medium % 6 != 0) {
                        throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("TYPE_SETTINGS length % 6 != 0: ", medium));
                    }
                    Settings settings = new Settings();
                    IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, medium), 6);
                    int i8 = intProgressionStep.first;
                    int i9 = intProgressionStep.last;
                    int i10 = intProgressionStep.step;
                    if ((i10 > 0 && i8 <= i9) || (i10 < 0 && i9 <= i8)) {
                        while (true) {
                            short s = bufferedSource2.readShort();
                            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                            int i11 = s & 65535;
                            int i12 = bufferedSource2.readInt();
                            if (i11 != 2) {
                                if (i11 == 3) {
                                    i11 = 4;
                                } else if (i11 == 4) {
                                    if (i12 < 0) {
                                        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                    }
                                    i11 = 7;
                                } else if (i11 == 5 && (i12 < 16384 || i12 > 16777215)) {
                                    throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", i12));
                                }
                            } else if (i12 != 0 && i12 != 1) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                            }
                            settings.set(i11, i12);
                            if (i8 != i9) {
                                i8 += i10;
                            }
                        }
                    }
                    Http2Connection http2Connection2 = (Http2Connection) readerRunnable.this$0;
                    http2Connection2.writerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), http2Connection2.connectionName, " applyAndAckSettings"), readerRunnable, settings, i), 0L);
                    return true;
                case 5:
                    readPushPromise(readerRunnable, medium, i3, i5);
                    return true;
                case 6:
                    readPing(readerRunnable, medium, i3, i5);
                    return true;
                case 7:
                    readGoAway(readerRunnable, medium, i5);
                    return true;
                case 8:
                    if (medium != 4) {
                        throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("TYPE_WINDOW_UPDATE length !=4: ", medium));
                    }
                    long j = 2147483647L & ((long) this.source.readInt());
                    if (j == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    if (i5 == 0) {
                        Http2Connection http2Connection3 = (Http2Connection) readerRunnable.this$0;
                        synchronized (http2Connection3) {
                            http2Connection3.writeBytesMaximum += j;
                            http2Connection3.notifyAll();
                            Unit unit = Unit.INSTANCE;
                        }
                        return true;
                    }
                    Http2Stream stream = ((Http2Connection) readerRunnable.this$0).getStream(i5);
                    if (stream != null) {
                        synchronized (stream) {
                            stream.writeBytesMaximum += j;
                            if (j > 0) {
                                stream.notifyAll();
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                        return true;
                    }
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readData(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, final int i3) throws IOException {
        int i4;
        boolean z;
        long j;
        boolean z2;
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        final boolean z3 = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        final int iLengthWithoutPadding = Companion.lengthWithoutPadding(i, i2, i4);
        BufferedSource bufferedSource = this.source;
        final Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
        long j2 = 0;
        if (i3 == 0 || (i3 & 1) != 0) {
            Http2Stream stream = http2Connection.getStream(i3);
            if (stream == null) {
                ((Http2Connection) readerRunnable.this$0).writeSynResetLater$okhttp(i3, 2);
                long j3 = iLengthWithoutPadding;
                ((Http2Connection) readerRunnable.this$0).updateConnectionFlowControl$okhttp(j3);
                bufferedSource.skip(j3);
            } else {
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                Http2Stream.FramingSource framingSource = stream.source;
                long j4 = iLengthWithoutPadding;
                framingSource.getClass();
                long j5 = j4;
                while (true) {
                    if (j5 <= j2) {
                        Http2Stream http2Stream = Http2Stream.this;
                        byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                        http2Stream.connection.updateConnectionFlowControl$okhttp(j4);
                        break;
                    }
                    synchronized (Http2Stream.this) {
                        z = framingSource.finished;
                        j = j2;
                        z2 = framingSource.readBuffer.size + j5 > framingSource.maxByteCount;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (z2) {
                        bufferedSource.skip(j5);
                        Http2Stream.this.closeLater(4);
                        break;
                    }
                    if (z) {
                        bufferedSource.skip(j5);
                        break;
                    }
                    long j6 = bufferedSource.read(j5, framingSource.receiveBuffer);
                    if (j6 == -1) {
                        throw new EOFException();
                    }
                    j5 -= j6;
                    Http2Stream http2Stream2 = Http2Stream.this;
                    synchronized (http2Stream2) {
                        try {
                            if (framingSource.closed) {
                                Buffer buffer = framingSource.receiveBuffer;
                                buffer.skip(buffer.size);
                            } else {
                                Buffer buffer2 = framingSource.readBuffer;
                                boolean z4 = buffer2.size == j;
                                buffer2.writeAll(framingSource.receiveBuffer);
                                if (z4) {
                                    http2Stream2.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    j2 = j;
                }
                if (z3) {
                    stream.receiveHeaders(Util.EMPTY_HEADERS, true);
                }
            }
        } else {
            final Buffer buffer3 = new Buffer();
            long j7 = iLengthWithoutPadding;
            bufferedSource.require(j7);
            bufferedSource.read(j7, buffer3);
            TaskQueue taskQueue = http2Connection.pushQueue;
            final String str = http2Connection.connectionName + '[' + i3 + "] onData";
            taskQueue.schedule(new Task(str, http2Connection, i3, buffer3, iLengthWithoutPadding, z3) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1
                public final /* synthetic */ Buffer $buffer$inlined;
                public final /* synthetic */ int $byteCount$inlined;
                public final /* synthetic */ int $streamId$inlined;
                public final /* synthetic */ Http2Connection this$0;

                @Override // okhttp3.internal.concurrent.Task
                public final long runOnce() {
                    try {
                        PushObserver$Companion$PushObserverCancel pushObserver$Companion$PushObserverCancel = this.this$0.pushObserver;
                        Buffer buffer4 = this.$buffer$inlined;
                        int i5 = this.$byteCount$inlined;
                        pushObserver$Companion$PushObserverCancel.getClass();
                        buffer4.skip(i5);
                        this.this$0.writer.rstStream(this.$streamId$inlined, 9);
                        synchronized (this.this$0) {
                            this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                        }
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }, 0L);
        }
        this.source.skip(i4);
    }

    public final void readGoAway(Http2Connection.ReaderRunnable readerRunnable, int i, int i2) throws IOException {
        int i3;
        Object[] array;
        if (i < 8) {
            throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("TYPE_GOAWAY length < 8: ", i));
        }
        if (i2 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i4 = this.source.readInt();
        int i5 = this.source.readInt();
        int i6 = i - 8;
        int[] iArrValues = CaptureSession$State$EnumUnboxingLocalUtility.values(14);
        int length = iArrValues.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                i3 = 0;
                break;
            }
            i3 = iArrValues[i7];
            if (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i3) == i5) {
                break;
            } else {
                i7++;
            }
        }
        if (i3 == 0) {
            throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("TYPE_GOAWAY unexpected error code: ", i5));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i6 > 0) {
            byteString = this.source.readByteString(i6);
        }
        byteString.getSize$okio();
        Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
        synchronized (http2Connection) {
            array = http2Connection.streams.values().toArray(new Http2Stream[0]);
            http2Connection.isShutdown = true;
            Unit unit = Unit.INSTANCE;
        }
        for (Http2Stream http2Stream : (Http2Stream[]) array) {
            if (http2Stream.id > i4 && http2Stream.isLocallyInitiated()) {
                http2Stream.receiveRstStream(8);
                ((Http2Connection) readerRunnable.this$0).removeStream$okhttp(http2Stream.id);
            }
        }
    }

    public final List readHeaderBlock(int i, int i2, int i3, int i4) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = i2;
        continuationSource.flags = i3;
        continuationSource.streamId = i4;
        Hpack.Reader reader = this.hpackReader;
        RealBufferedSource realBufferedSource = reader.source;
        ArrayList arrayList = reader.headerList;
        while (!realBufferedSource.exhausted()) {
            byte b = realBufferedSource.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int i5 = b & 255;
            if (i5 == 128) {
                throw new IOException("index == 0");
            }
            if ((b & 128) == 128) {
                int i6 = reader.readInt(i5, 127);
                int i7 = i6 - 1;
                if (i7 >= 0) {
                    Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                    if (i7 <= headerArr.length - 1) {
                        arrayList.add(headerArr[i7]);
                    }
                }
                int length = reader.nextHeaderIndex + 1 + (i7 - Hpack.STATIC_HEADER_TABLE.length);
                if (length >= 0) {
                    Header[] headerArr2 = reader.dynamicTable;
                    if (length < headerArr2.length) {
                        arrayList.add(headerArr2[length]);
                    }
                }
                throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("Header index too large ", i6));
            }
            if (i5 == 64) {
                Header[] headerArr3 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString = reader.readByteString();
                Hpack.checkLowercase(byteString);
                reader.insertIntoDynamicTable(new Header(byteString, reader.readByteString()));
            } else if ((b & 64) == 64) {
                reader.insertIntoDynamicTable(new Header(reader.getName(reader.readInt(i5, 63) - 1), reader.readByteString()));
            } else if ((b & 32) == 32) {
                int i8 = reader.readInt(i5, 31);
                reader.maxDynamicTableByteCount = i8;
                if (i8 < 0 || i8 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + reader.maxDynamicTableByteCount);
                }
                int i9 = reader.dynamicTableByteCount;
                if (i8 < i9) {
                    if (i8 == 0) {
                        Header[] headerArr4 = reader.dynamicTable;
                        Arrays.fill(headerArr4, 0, headerArr4.length, (Object) null);
                        reader.nextHeaderIndex = reader.dynamicTable.length - 1;
                        reader.headerCount = 0;
                        reader.dynamicTableByteCount = 0;
                    } else {
                        reader.evictToRecoverBytes(i9 - i8);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                Header[] headerArr5 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString2 = reader.readByteString();
                Hpack.checkLowercase(byteString2);
                arrayList.add(new Header(byteString2, reader.readByteString()));
            } else {
                arrayList.add(new Header(reader.getName(reader.readInt(i5, 15) - 1), reader.readByteString()));
            }
        }
        List list = CollectionsKt.toList(arrayList);
        arrayList.clear();
        return list;
    }

    public final void readHeaders(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        int i4 = 0;
        boolean z = (i2 & 1) != 0;
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        }
        if ((i2 & 32) != 0) {
            BufferedSource bufferedSource = this.source;
            bufferedSource.readInt();
            bufferedSource.readByte();
            byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
            i -= 5;
        }
        List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i, i2, i4), i4, i2, i3);
        Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
        if (i3 != 0 && (i3 & 1) == 0) {
            http2Connection.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(http2Connection.connectionName + '[' + i3 + "] onHeaders", http2Connection, i3, headerBlock, z), 0L);
            return;
        }
        synchronized (http2Connection) {
            Http2Stream stream = http2Connection.getStream(i3);
            if (stream != null) {
                Unit unit = Unit.INSTANCE;
                stream.receiveHeaders(Util.toHeaders(headerBlock), z);
                return;
            }
            if (http2Connection.isShutdown) {
                return;
            }
            if (i3 <= http2Connection.lastGoodStreamId) {
                return;
            }
            int i5 = 2;
            if (i3 % 2 == http2Connection.nextStreamId % 2) {
                return;
            }
            Http2Stream http2Stream = new Http2Stream(i3, http2Connection, false, z, Util.toHeaders(headerBlock));
            http2Connection.lastGoodStreamId = i3;
            http2Connection.streams.put(Integer.valueOf(i3), http2Stream);
            http2Connection.taskRunner.newQueue().schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(http2Connection.connectionName + '[' + i3 + "] onStream", http2Connection, http2Stream, i5), 0L);
        }
    }

    public final void readPing(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("TYPE_PING length != 8: ", i));
        }
        if (i3 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        int i4 = this.source.readInt();
        int i5 = this.source.readInt();
        if (!((i2 & 1) != 0)) {
            ((Http2Connection) readerRunnable.this$0).writerQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$default$1(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), ((Http2Connection) readerRunnable.this$0).connectionName, " ping"), (Http2Connection) readerRunnable.this$0, i4, i5, 1), 0L);
            return;
        }
        Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
        synchronized (http2Connection) {
            try {
                if (i4 == 1) {
                    http2Connection.intervalPongsReceived++;
                } else if (i4 != 2) {
                    if (i4 == 3) {
                        http2Connection.notifyAll();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    http2Connection.degradedPongsReceived++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void readPushPromise(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        int i5 = this.source.readInt() & Integer.MAX_VALUE;
        List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i - 4, i2, i4), i4, i2, i3);
        Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
        synchronized (http2Connection) {
            if (http2Connection.currentPushRequests.contains(Integer.valueOf(i5))) {
                http2Connection.writeSynResetLater$okhttp(i5, 2);
                return;
            }
            http2Connection.currentPushRequests.add(Integer.valueOf(i5));
            http2Connection.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(http2Connection.connectionName + '[' + i5 + "] onRequest", http2Connection, i5, headerBlock), 0L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ContinuationSource implements Source {
        public int flags;
        public int left;
        public int length;
        public int padding;
        public final BufferedSource source;
        public int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        @Override // okio.Source
        public final long read(long j, Buffer buffer) throws IOException {
            int i;
            int i2;
            do {
                int i3 = this.left;
                BufferedSource bufferedSource = this.source;
                if (i3 == 0) {
                    bufferedSource.skip(this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) == 0) {
                        i = this.streamId;
                        int medium = Util.readMedium(bufferedSource);
                        this.left = medium;
                        this.length = medium;
                        int i4 = bufferedSource.readByte() & 255;
                        this.flags = bufferedSource.readByte() & 255;
                        Logger logger = Http2Reader.logger;
                        if (logger.isLoggable(Level.FINE)) {
                            ByteString byteString = Http2.CONNECTION_PREFACE;
                            logger.fine(Http2.frameLog(true, this.streamId, this.length, i4, this.flags));
                        }
                        i2 = bufferedSource.readInt() & Integer.MAX_VALUE;
                        this.streamId = i2;
                        if (i4 != 9) {
                            throw new IOException(i4 + " != TYPE_CONTINUATION");
                        }
                    }
                } else {
                    long j2 = bufferedSource.read(Math.min(j, i3), buffer);
                    if (j2 != -1) {
                        this.left -= (int) j2;
                        return j2;
                    }
                }
                return -1L;
            } while (i2 == i);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.source.timeout();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }
}
