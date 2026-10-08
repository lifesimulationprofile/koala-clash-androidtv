package com.github.kr328.clash.compose.util;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FormatKt {
    public static final String formatBytesRemaining(long j) {
        if (j <= 0) {
            return "0 B";
        }
        long jAbs = Math.abs(j);
        if (jAbs >= 1073741824) {
            return String.format(Locale.US, "%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(jAbs / 1073741824)}, 1));
        }
        if (jAbs >= 1048576) {
            return String.format(Locale.US, "%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf(jAbs / 1048576)}, 1));
        }
        if (jAbs >= 1024) {
            return String.format(Locale.US, "%.1f KB", Arrays.copyOf(new Object[]{Double.valueOf(jAbs / 1024)}, 1));
        }
        return jAbs + " B";
    }
}
