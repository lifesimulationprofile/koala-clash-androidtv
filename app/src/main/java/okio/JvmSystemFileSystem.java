package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class JvmSystemFileSystem extends FileSystem {
    @Override // okio.FileSystem
    public final Sink appendingSink(Path path) {
        File file = path.toFile();
        Logger logger = Okio__JvmOkioKt.logger;
        return new OutputStreamSink(0, new FileOutputStream(file, true), new Timeout());
    }

    @Override // okio.FileSystem
    public void atomicMove(Path path, Path path2) throws IOException {
        if (path.toFile().renameTo(path2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + path + " to " + path2);
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path path) throws IOException {
        if (path.toFile().mkdir()) {
            return;
        }
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull == null || !fileMetadataMetadataOrNull.isDirectory) {
            throw new IOException("failed to create directory: " + path);
        }
    }

    @Override // okio.FileSystem
    public final void delete(Path path) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("failed to delete " + path);
    }

    @Override // okio.FileSystem
    public final List list(Path path) throws IOException {
        File file = path.toFile();
        String[] list = file.list();
        if (list == null) {
            if (file.exists()) {
                throw new IOException("failed to list " + path);
            }
            throw new FileNotFoundException("no such file: " + path);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(path.resolve(str));
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
    }

    @Override // okio.FileSystem
    public final JvmFileHandle openReadOnly(Path path) {
        return new JvmFileHandle(new RandomAccessFile(path.toFile(), "r"));
    }

    @Override // okio.FileSystem
    public final Sink sink(Path path) {
        File file = path.toFile();
        Logger logger = Okio__JvmOkioKt.logger;
        return new OutputStreamSink(0, new FileOutputStream(file, false), new Timeout());
    }

    @Override // okio.FileSystem
    public final Source source(Path path) {
        File file = path.toFile();
        Logger logger = Okio__JvmOkioKt.logger;
        return new InputStreamSource(0, new FileInputStream(file), Timeout.NONE);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
