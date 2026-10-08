package com.github.kr328.clash.log;

import com.github.kr328.clash.LogcatActivity;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatFilter extends BufferedWriter {
    public final LogcatActivity context;

    public LogcatFilter(OutputStreamWriter outputStreamWriter, LogcatActivity logcatActivity) {
        super(outputStreamWriter);
        this.context = logcatActivity;
    }
}
