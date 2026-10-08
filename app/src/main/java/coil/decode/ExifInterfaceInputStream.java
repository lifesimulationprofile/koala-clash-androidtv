package coil.decode;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ExifInterfaceInputStream extends InputStream {
    public int availableBytes = 1073741824;
    public final InputStream delegate;

    public ExifInterfaceInputStream(InputStream inputStream) {
        this.delegate = inputStream;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.availableBytes;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.delegate.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i = this.delegate.read();
        if (i == -1) {
            this.availableBytes = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.delegate.skip(j);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.delegate.read(bArr);
        if (i == -1) {
            this.availableBytes = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.delegate.read(bArr, i, i2);
        if (i3 == -1) {
            this.availableBytes = 0;
        }
        return i3;
    }
}
