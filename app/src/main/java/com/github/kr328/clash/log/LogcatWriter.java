package com.github.kr328.clash.log;

import android.content.Context;
import com.github.kr328.clash.design.model.LogFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import kotlin.io.FilesKt;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatWriter implements AutoCloseable {
    public final BufferedWriter writer;

    public LogcatWriter(Context context) {
        Regex regex = LogFile.REGEX_FILE;
        this.writer = new BufferedWriter(new FileWriter(FilesKt.resolve(FilesKt.resolve(context.getCacheDir(), "logs"), String.format("clash-%d.log", Arrays.copyOf(new Object[]{Long.valueOf(new Date().getTime())}, 1)))));
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.writer.close();
    }
}
