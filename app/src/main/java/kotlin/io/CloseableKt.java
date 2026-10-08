package kotlin.io;

import android.media.ImageReader;
import com.google.android.gms.tasks.zzr;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CloseableKt {
    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ScanQRCode.addSuppressed(th, th2);
            }
        }
    }

    public static zzr createIsolatedReader(int i, int i2, int i3, int i4) {
        return new zzr(ImageReader.newInstance(i, i2, i3, i4));
    }
}
