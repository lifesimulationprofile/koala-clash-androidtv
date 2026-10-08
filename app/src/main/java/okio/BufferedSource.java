package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer getBuffer();

    InputStream inputStream();

    long readAll(RealBufferedSink realBufferedSink);

    byte readByte();

    byte[] readByteArray();

    ByteString readByteString(long j);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    short readShort();

    short readShortLe();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j);

    boolean request(long j);

    void require(long j);

    void skip(long j);
}
