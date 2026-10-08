package okio.internal;

import coil.network.EmptyNetworkObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.text.StringsKt;
import okhttp3.Handshake;
import okio.FileMetadata;
import okio.FileSystem;
import okio.JvmFileHandle;
import okio.JvmSystemFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceFileSystem extends FileSystem {
    public static final Path ROOT;
    public final ClassLoader classLoader;
    public final JvmSystemFileSystem systemFileSystem = FileSystem.SYSTEM;
    public final SynchronizedLazyImpl roots$delegate = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(24, this));

    static {
        String str = Path.DIRECTORY_SEPARATOR;
        ROOT = Path.Companion.get$default("/");
    }

    public ResourceFileSystem(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public static String toRelativePath(Path path) {
        Path path2 = ROOT;
        path2.getClass();
        return Path.commonResolve(path2, path, true).relativeTo(path2).bytes.utf8();
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path path) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path path, Path path2) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path path) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void delete(Path path) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final List list(Path path) throws FileNotFoundException {
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair pair : (List) this.roots$delegate.getValue()) {
            FileSystem fileSystem = (FileSystem) pair.first;
            Path path2 = (Path) pair.second;
            try {
                List list = fileSystem.list(path2.resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (EmptyNetworkObserver.access$keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    arrayList2.add(ROOT.resolve(StringsKt.removePrefix(((Path) obj2).bytes.utf8(), path2.bytes.utf8()).replace('\\', '/')));
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, linkedHashSet);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt.toList(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    @Override // okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) {
        if (!EmptyNetworkObserver.access$keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair pair : (List) this.roots$delegate.getValue()) {
            FileMetadata fileMetadataMetadataOrNull = ((FileSystem) pair.first).metadataOrNull(((Path) pair.second).resolve(relativePath));
            if (fileMetadataMetadataOrNull != null) {
                return fileMetadataMetadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    public final JvmFileHandle openReadOnly(Path path) throws FileNotFoundException {
        if (!EmptyNetworkObserver.access$keepPath(path)) {
            throw new FileNotFoundException("file not found: " + path);
        }
        String relativePath = toRelativePath(path);
        for (Pair pair : (List) this.roots$delegate.getValue()) {
            try {
                return ((FileSystem) pair.first).openReadOnly(((Path) pair.second).resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    @Override // okio.FileSystem
    public final Sink sink(Path path) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final Source source(Path path) throws IOException {
        if (!EmptyNetworkObserver.access$keepPath(path)) {
            throw new FileNotFoundException("file not found: " + path);
        }
        Path path2 = ROOT;
        path2.getClass();
        URL resource = this.classLoader.getResource(Path.commonResolve(path2, path, false).relativeTo(path2).bytes.utf8());
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + path);
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        return Okio.source(uRLConnectionOpenConnection.getInputStream());
    }
}
