package okio.internal;

import java.io.EOFException;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: okio.internal.-Buffer, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Buffer {
    public static final byte[] HEX_DIGIT_BYTES = "0123456789abcdef".getBytes(Charsets.UTF_8);

    public static final String readUtf8Line(long j, okio.Buffer buffer) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == 13) {
                String string = buffer.readString(j2, Charsets.UTF_8);
                buffer.skip(2L);
                return string;
            }
        }
        String string2 = buffer.readString(j, Charsets.UTF_8);
        buffer.skip(1L);
        return string2;
    }
}
