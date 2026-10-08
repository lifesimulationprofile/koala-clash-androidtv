package coil.decode;

import coil.util.Utils;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.FileSystem;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SourceImageSource extends ResponseBody {
    public boolean isClosed;
    public final ImageSource$Metadata metadata;
    public final BufferedSource source;

    public SourceImageSource(BufferedSource bufferedSource, ImageSource$Metadata imageSource$Metadata) {
        this.metadata = imageSource$Metadata;
        this.source = bufferedSource;
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.isClosed = true;
        BufferedSource bufferedSource = this.source;
        if (bufferedSource != null) {
            Utils.closeQuietly(bufferedSource);
        }
    }

    @Override // okhttp3.ResponseBody
    public final ImageSource$Metadata getMetadata() {
        return this.metadata;
    }

    @Override // okhttp3.ResponseBody
    public final synchronized BufferedSource source() {
        BufferedSource bufferedSource;
        try {
            if (this.isClosed) {
                throw new IllegalStateException("closed");
            }
            bufferedSource = this.source;
            if (bufferedSource == null) {
                FileSystem.SYSTEM.source(null);
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return bufferedSource;
    }
}
