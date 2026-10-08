package com.github.kr328.clash.core.util;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TrafficKt {
    public static final long scaleTraffic(long j) {
        long j2;
        long j3 = (j >>> 30) & 3;
        long j4 = j & 1073741823;
        if (j3 == 0) {
            return j4;
        }
        if (j3 == 1) {
            j2 = 1024;
        } else {
            if (j3 == 2) {
                j2 = 1024;
            } else {
                if (j3 != 3) {
                    throw new IllegalArgumentException("invalid value type");
                }
                j2 = 1024;
                j4 *= j2;
            }
            j4 *= j2;
        }
        return j4 * j2;
    }

    public static final String trafficString(long j) {
        if (j > 107374182400L) {
            long j2 = 1024;
            return String.format(Locale.US, "%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf((((j / j2) / j2) / j2) / 100)}, 1));
        }
        if (j > 104857600) {
            long j3 = 1024;
            return String.format(Locale.US, "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(((j / j3) / j3) / 100)}, 1));
        }
        if (j > 102400) {
            return String.format(Locale.US, "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf((j / ((long) 1024)) / 100)}, 1));
        }
        return j + " Bytes";
    }
}
