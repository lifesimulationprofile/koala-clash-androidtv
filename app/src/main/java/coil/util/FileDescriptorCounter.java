package coil.util;

import android.os.SystemClock;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FileDescriptorCounter {
    public static final FileDescriptorCounter INSTANCE = new FileDescriptorCounter();
    public static final File fileDescriptorList = new File("/proc/self/fd");
    public static int decodesSinceLastFileDescriptorCheck = 30;
    public static long lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
    public static boolean hasAvailableFileDescriptors = true;
}
