package coil.disk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Reflection;
import okio.FileMetadata;
import okio.FileSystem;
import okio.JvmFileHandle;
import okio.Path;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache$fileSystem$1 extends FileSystem {
    public final FileSystem delegate;

    public DiskLruCache$fileSystem$1(FileSystem fileSystem) {
        this.delegate = fileSystem;
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path path) {
        return this.delegate.appendingSink(path);
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path path, Path path2) {
        this.delegate.atomicMove(path, path2);
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path path) {
        this.delegate.createDirectory(path);
    }

    @Override // okio.FileSystem
    public final void delete(Path path) {
        this.delegate.delete(path);
    }

    @Override // okio.FileSystem
    public final List list(Path path) {
        List list = this.delegate.list(path);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((Path) it.next());
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    @Override // okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) {
        FileMetadata fileMetadataMetadataOrNull = this.delegate.metadataOrNull(path);
        if (fileMetadataMetadataOrNull == null) {
            return null;
        }
        Path path2 = (Path) fileMetadataMetadataOrNull.symlinkTarget;
        return path2 == null ? fileMetadataMetadataOrNull : new FileMetadata(fileMetadataMetadataOrNull.isRegularFile, fileMetadataMetadataOrNull.isDirectory, path2, (Long) fileMetadataMetadataOrNull.size, (Long) fileMetadataMetadataOrNull.createdAtMillis, (Long) fileMetadataMetadataOrNull.lastModifiedAtMillis, (Long) fileMetadataMetadataOrNull.lastAccessedAtMillis, (Map) fileMetadataMetadataOrNull.extras);
    }

    @Override // okio.FileSystem
    public final JvmFileHandle openReadOnly(Path path) {
        return this.delegate.openReadOnly(path);
    }

    @Override // okio.FileSystem
    public final Sink sink(Path path) {
        Path pathParent = path.parent();
        if (pathParent != null) {
            ArrayDeque arrayDeque = new ArrayDeque();
            while (pathParent != null && !exists(pathParent)) {
                arrayDeque.addFirst(pathParent);
                pathParent = pathParent.parent();
            }
            Iterator<E> it = arrayDeque.iterator();
            while (it.hasNext()) {
                createDirectory((Path) it.next());
            }
        }
        return this.delegate.sink(path);
    }

    @Override // okio.FileSystem
    public final Source source(Path path) {
        return this.delegate.source(path);
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(DiskLruCache$fileSystem$1.class).getSimpleName() + '(' + this.delegate + ')';
    }
}
