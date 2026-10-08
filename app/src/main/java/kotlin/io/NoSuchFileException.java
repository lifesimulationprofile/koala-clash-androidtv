package kotlin.io;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NoSuchFileException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSuchFileException(File file, int i) {
        super(file, null, "The source file doesn't exist.");
        switch (i) {
            case 1:
                super(file, null, "Cannot list files in a directory");
                break;
            default:
                break;
        }
    }
}
