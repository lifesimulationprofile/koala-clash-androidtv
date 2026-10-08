package coil.util;

import android.os.SystemClock;
import coil.disk.RealDiskCache;
import coil.size.Dimension;
import coil.size.Size;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SingletonDiskCache implements HardwareBitmapService {
    public static final SingletonDiskCache INSTANCE = new SingletonDiskCache();
    public static RealDiskCache instance;

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        Dimension dimension = size.width;
        if ((dimension instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension).px : Integer.MAX_VALUE) <= 100) {
            return false;
        }
        Dimension dimension2 = size.height;
        return (dimension2 instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension2).px : Integer.MAX_VALUE) > 100;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        boolean z;
        synchronized (FileDescriptorCounter.INSTANCE) {
            try {
                int i = FileDescriptorCounter.decodesSinceLastFileDescriptorCheck;
                FileDescriptorCounter.decodesSinceLastFileDescriptorCheck = i + 1;
                if (i >= 30 || SystemClock.uptimeMillis() > FileDescriptorCounter.lastFileDescriptorCheckTimestamp + ((long) 30000)) {
                    FileDescriptorCounter.decodesSinceLastFileDescriptorCheck = 0;
                    FileDescriptorCounter.lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
                    String[] list = FileDescriptorCounter.fileDescriptorList.list();
                    if (list == null) {
                        list = new String[0];
                    }
                    FileDescriptorCounter.hasAvailableFileDescriptors = list.length < 800;
                }
                z = FileDescriptorCounter.hasAvailableFileDescriptors;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
