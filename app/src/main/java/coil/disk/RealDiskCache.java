package coil.disk;

import java.io.Closeable;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealDiskCache {
    public final DiskLruCache cache;
    public final FileSystem fileSystem;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RealSnapshot implements Closeable {
        public final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.snapshot = snapshot;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.snapshot.close();
        }
    }

    public RealDiskCache(long j, FileSystem fileSystem, Path path) {
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(j, fileSystem, path);
    }
}
