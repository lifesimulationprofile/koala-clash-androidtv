package com.github.kr328.clash.service.util;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FilesKt {
    public static final File getImportedDir(Context context) {
        return kotlin.io.FilesKt.resolve(context.getFilesDir(), "imported");
    }

    public static final void writeProfileLogo(Context context, UUID uuid, byte[] bArr) throws IOException {
        File fileResolve = kotlin.io.FilesKt.resolve(kotlin.io.FilesKt.resolve(getImportedDir(context), uuid.toString()), "profile-logo");
        if (bArr == null || bArr.length == 0) {
            fileResolve.delete();
            return;
        }
        File parentFile = fileResolve.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileResolve);
        try {
            fileOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }
}
