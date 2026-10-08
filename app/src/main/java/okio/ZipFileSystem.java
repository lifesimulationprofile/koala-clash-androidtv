package okio;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;
import kotlin.collections.CollectionsKt;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ZipFileSystem extends FileSystem {
    public static final Path ROOT;
    public final LinkedHashMap entries;
    public final FileSystem fileSystem;
    public final Path zipPath;

    static {
        String str = Path.DIRECTORY_SEPARATOR;
        ROOT = Path.Companion.get$default("/");
    }

    public ZipFileSystem(Path path, JvmSystemFileSystem jvmSystemFileSystem, LinkedHashMap linkedHashMap) {
        this.zipPath = path;
        this.fileSystem = jvmSystemFileSystem;
        this.entries = linkedHashMap;
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path path) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path path, Path path2) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path path) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void delete(Path path) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final List list(Path path) throws IOException {
        Path path2 = ROOT;
        path2.getClass();
        ZipEntry zipEntry = (ZipEntry) this.entries.get(okio.internal.Path.commonResolve(path2, path, true));
        if (zipEntry != null) {
            return CollectionsKt.toList(zipEntry.children);
        }
        throw new IOException("not a directory: " + path);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0113  */
    /* JADX WARN: Code duplicated, block: B:66:0x0121  */
    /* JADX WARN: Code duplicated, block: B:68:0x0125  */
    /* JADX WARN: Code duplicated, block: B:69:0x0130  */
    @Override // okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) throws Throwable {
        Long lValueOf;
        long j;
        Long l;
        Long lValueOf2;
        Long l2;
        Integer num;
        Long l3;
        Long lValueOf3;
        Throwable th;
        Throwable th2;
        ZipEntry orSkipLocalHeader;
        Path path2 = ROOT;
        path2.getClass();
        ZipEntry zipEntry = (ZipEntry) this.entries.get(okio.internal.Path.commonResolve(path2, path, true));
        if (zipEntry == null) {
            return null;
        }
        long j2 = zipEntry.offset;
        if (j2 != -1) {
            JvmFileHandle jvmFileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
            try {
                RealBufferedSource realBufferedSource = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(j2));
                try {
                    orSkipLocalHeader = ZipFilesKt.readOrSkipLocalHeader(realBufferedSource, zipEntry);
                    try {
                        realBufferedSource.close();
                        th2 = null;
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                } catch (Throwable th4) {
                    try {
                        realBufferedSource.close();
                    } catch (Throwable th5) {
                        ScanQRCode.addSuppressed(th4, th5);
                    }
                    th2 = th4;
                    orSkipLocalHeader = null;
                }
                if (th2 != null) {
                    throw th2;
                }
                try {
                    jvmFileHandleOpenReadOnly.close();
                    th = null;
                } catch (Throwable th6) {
                    th = th6;
                }
                ZipEntry zipEntry2 = orSkipLocalHeader;
                th = th;
                zipEntry = zipEntry2;
            } catch (Throwable th7) {
                th = th7;
                if (jvmFileHandleOpenReadOnly != null) {
                    try {
                        jvmFileHandleOpenReadOnly.close();
                    } catch (Throwable th8) {
                        ScanQRCode.addSuppressed(th, th8);
                    }
                }
                zipEntry = null;
            }
            if (th != null) {
                throw th;
            }
        }
        boolean z = zipEntry.isDirectory;
        boolean z2 = !z;
        Long lValueOf4 = z ? null : Long.valueOf(zipEntry.size);
        Long l4 = zipEntry.ntfsCreatedAtFiletime;
        if (l4 != null) {
            lValueOf = Long.valueOf((l4.longValue() / ((long) ModuleDescriptor.MODULE_VERSION)) - 11644473600000L);
        } else {
            Integer num2 = zipEntry.extendedCreatedAtSeconds;
            lValueOf = num2 != null ? Long.valueOf(((long) num2.intValue()) * 1000) : null;
        }
        Long l5 = zipEntry.ntfsLastModifiedAtFiletime;
        if (l5 != null) {
            j = 11644473600000L;
            lValueOf2 = Long.valueOf((l5.longValue() / ((long) ModuleDescriptor.MODULE_VERSION)) - 11644473600000L);
        } else {
            j = 11644473600000L;
            Integer num3 = zipEntry.extendedLastModifiedAtSeconds;
            if (num3 == null) {
                int i = zipEntry.dosLastModifiedAtTime;
                if (i != -1) {
                    int i2 = zipEntry.dosLastModifiedAtDate;
                    if (i != -1) {
                        int i3 = (i >> 11) & 31;
                        int i4 = (i >> 5) & 63;
                        int i5 = (i & 31) << 1;
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.set(14, 0);
                        gregorianCalendar.set(((i2 >> 9) & 127) + 1980, ((i2 >> 5) & 15) - 1, i2 & 31, i3, i4, i5);
                        lValueOf2 = Long.valueOf(gregorianCalendar.getTime().getTime());
                    }
                    l2 = zipEntry.ntfsLastAccessedAtFiletime;
                    if (l2 == null) {
                        num = zipEntry.extendedLastAccessedAtSeconds;
                        if (num != null) {
                            lValueOf3 = Long.valueOf(((long) num.intValue()) * 1000);
                        } else {
                            l3 = null;
                        }
                        return new FileMetadata(z2, z, null, lValueOf4, lValueOf, l, l3);
                    }
                    lValueOf3 = Long.valueOf((l2.longValue() / ((long) ModuleDescriptor.MODULE_VERSION)) - j);
                    l3 = lValueOf3;
                    return new FileMetadata(z2, z, null, lValueOf4, lValueOf, l, l3);
                }
                l = null;
                l2 = zipEntry.ntfsLastAccessedAtFiletime;
                if (l2 == null) {
                    num = zipEntry.extendedLastAccessedAtSeconds;
                    if (num != null) {
                        lValueOf3 = Long.valueOf(((long) num.intValue()) * 1000);
                    } else {
                        l3 = null;
                    }
                    return new FileMetadata(z2, z, null, lValueOf4, lValueOf, l, l3);
                }
                lValueOf3 = Long.valueOf((l2.longValue() / ((long) ModuleDescriptor.MODULE_VERSION)) - j);
                l3 = lValueOf3;
                return new FileMetadata(z2, z, null, lValueOf4, lValueOf, l, l3);
            }
            lValueOf2 = Long.valueOf(((long) num3.intValue()) * 1000);
        }
        l = lValueOf2;
        l2 = zipEntry.ntfsLastAccessedAtFiletime;
        if (l2 == null) {
            num = zipEntry.extendedLastAccessedAtSeconds;
            if (num != null) {
                lValueOf3 = Long.valueOf(((long) num.intValue()) * 1000);
            } else {
                l3 = null;
            }
            return new FileMetadata(z2, z, null, lValueOf4, lValueOf, l, l3);
        }
        lValueOf3 = Long.valueOf((l2.longValue() / ((long) ModuleDescriptor.MODULE_VERSION)) - j);
        l3 = lValueOf3;
        return new FileMetadata(z2, z, null, lValueOf4, lValueOf, l, l3);
    }

    @Override // okio.FileSystem
    public final JvmFileHandle openReadOnly(Path path) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public final Sink sink(Path path) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final Source source(Path path) throws Throwable {
        RealBufferedSource realBufferedSource;
        Throwable th;
        Path path2 = ROOT;
        path2.getClass();
        ZipEntry zipEntry = (ZipEntry) this.entries.get(okio.internal.Path.commonResolve(path2, path, true));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + path);
        }
        long j = zipEntry.size;
        JvmFileHandle jvmFileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            realBufferedSource = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(zipEntry.offset));
            try {
                jvmFileHandleOpenReadOnly.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (jvmFileHandleOpenReadOnly != null) {
                try {
                    jvmFileHandleOpenReadOnly.close();
                } catch (Throwable th4) {
                    ScanQRCode.addSuppressed(th3, th4);
                }
            }
            realBufferedSource = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        ZipFilesKt.readOrSkipLocalHeader(realBufferedSource, null);
        if (zipEntry.compressionMethod == 0) {
            return new FixedLengthSource(realBufferedSource, j, true);
        }
        return new FixedLengthSource(new InflaterSource(new RealBufferedSource(new FixedLengthSource(realBufferedSource, zipEntry.compressedSize, true)), new Inflater(true)), j, false);
    }
}
