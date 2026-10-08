package kotlin.io;

import androidx.camera.core.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class FilesKt extends Logger {
    public static void copyRecursively$default(File file, File file2, int i) throws IOException {
        int i2 = 1;
        boolean z = (i & 2) == 0;
        if (!file.exists()) {
            throw new NoSuchFileException(file, 0);
        }
        FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator(new FileTreeWalk(i2, 0, file, new FilesKt__UtilsKt$$ExternalSyntheticLambda0(0)));
        while (fileTreeWalkIterator.hasNext()) {
            File file3 = (File) fileTreeWalkIterator.next();
            if (!file3.exists()) {
                throw new NoSuchFileException(file3, 0);
            }
            File file4 = new File(file2, toRelativeString(file3, file));
            if (file4.exists() && (!file3.isDirectory() || !file4.isDirectory())) {
                if (z) {
                    if (file4.isDirectory()) {
                        if (!deleteRecursively(file4)) {
                        }
                    } else if (!file4.delete()) {
                    }
                }
                throw new NoSuchFileException(file3, file4, "The destination file already exists.");
            }
            if (file3.isDirectory()) {
                file4.mkdirs();
            } else {
                copyTo$default(file3, file4, z);
                if (file4.length() != file3.length()) {
                    throw new IOException("Source file wasn't copied completely, length of destination file differs.");
                }
            }
        }
    }

    public static void copyTo$default(File file, File file2, boolean z) throws IOException {
        if (!file.exists()) {
            throw new NoSuchFileException(file, 0);
        }
        if (file2.exists()) {
            if (!z) {
                throw new NoSuchFileException(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new NoSuchFileException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new FileSystemException(file, file2, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                byte[] bArr = new byte[8192];
                for (int i = fileInputStream.read(bArr); i >= 0; i = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, i);
                }
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileInputStream, th3);
                throw th4;
            }
        }
    }

    public static boolean deleteRecursively(File file) {
        FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator(new FileTreeWalk(2, 0, file, null));
        while (true) {
            boolean z = true;
            while (fileTreeWalkIterator.hasNext()) {
                File file2 = (File) fileTreeWalkIterator.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
            return z;
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.util.List] */
    public static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        File file = filePathComponents.root;
        ?? r6 = filePathComponents.segments;
        ArrayList arrayList = new ArrayList(r6.size());
        for (File file2 : r6) {
            String name = file2.getName();
            if (Intrinsics.areEqual(name, ".")) {
                Unit unit = Unit.INSTANCE;
            } else if (!Intrinsics.areEqual(name, "..")) {
                arrayList.add(file2);
            } else if (arrayList.isEmpty() || Intrinsics.areEqual(((File) CollectionsKt.last(arrayList)).getName(), "..")) {
                arrayList.add(file2);
            }
        }
        return new FilePathComponents(file, arrayList);
    }

    public static File resolve(File file, String str) {
        File file2 = new File(str);
        if (Logger.getRootLength$FilesKt__FilePathComponentsKt(file2.getPath()) > 0) {
            return file2;
        }
        String string = file.toString();
        if (string.length() != 0) {
            char c = File.separatorChar;
            if (string.length() <= 0 || !CharsKt.equals(string.charAt(StringsKt.getLastIndex(string)), c, false)) {
                return new File(string + c + file2);
            }
        }
        return new File(string + file2);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x006f  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    public static final String toRelativeString(File file, File file2) {
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(Logger.toComponents(file));
        ?? r1 = filePathComponentsNormalize$FilesKt__UtilsKt.segments;
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(Logger.toComponents(file2));
        ?? r3 = filePathComponentsNormalize$FilesKt__UtilsKt2.segments;
        boolean zEquals = filePathComponentsNormalize$FilesKt__UtilsKt.root.equals(filePathComponentsNormalize$FilesKt__UtilsKt2.root);
        String string = null;
        if (zEquals) {
            int size = r3.size();
            int size2 = r1.size();
            int iMin = Math.min(size2, size);
            int i = 0;
            while (i < iMin && Intrinsics.areEqual(r1.get(i), r3.get(i))) {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = size - 1;
            if (i <= i2) {
                while (true) {
                    if (!Intrinsics.areEqual(((File) r3.get(i2)).getName(), "..")) {
                        sb.append("..");
                        if (i2 != i) {
                            sb.append(File.separatorChar);
                        }
                        if (i2 != i) {
                            i2--;
                        } else {
                            if (i < size2) {
                                if (i < size) {
                                    sb.append(File.separatorChar);
                                }
                                CollectionsKt.joinTo$default(CollectionsKt.drop(i, (List) r1), sb, File.separator, null, 124);
                            }
                            string = sb.toString();
                        }
                    }
                }
            } else {
                if (i < size2) {
                    if (i < size) {
                        sb.append(File.separatorChar);
                    }
                    CollectionsKt.joinTo$default(CollectionsKt.drop(i, (List) r1), sb, File.separator, null, 124);
                }
                string = sb.toString();
            }
        }
        if (string != null) {
            return string;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }
}
