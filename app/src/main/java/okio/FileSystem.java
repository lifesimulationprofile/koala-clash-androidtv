package okio;

import java.io.FileNotFoundException;
import java.util.List;
import okio.internal.ResourceFileSystem;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FileSystem {
    public static final JvmSystemFileSystem SYSTEM;

    static {
        JvmSystemFileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        String str = Path.DIRECTORY_SEPARATOR;
        Path.Companion.get$default(System.getProperty("java.io.tmpdir"));
        new ResourceFileSystem(ResourceFileSystem.class.getClassLoader());
    }

    public abstract Sink appendingSink(Path path);

    public abstract void atomicMove(Path path, Path path2);

    public abstract void createDirectory(Path path);

    public abstract void delete(Path path);

    public final boolean exists(Path path) {
        return metadataOrNull(path) != null;
    }

    public abstract List list(Path path);

    public final FileMetadata metadata(Path path) throws FileNotFoundException {
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract JvmFileHandle openReadOnly(Path path);

    public abstract Sink sink(Path path);

    public abstract Source source(Path path);
}
