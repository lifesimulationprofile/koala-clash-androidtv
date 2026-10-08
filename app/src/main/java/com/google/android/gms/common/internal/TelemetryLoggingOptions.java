package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Api$ApiOptions;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TelemetryLoggingOptions implements Api$ApiOptions {
    public static final TelemetryLoggingOptions zaa = new TelemetryLoggingOptions(null);
    public final String zab;

    public /* synthetic */ TelemetryLoggingOptions(String str) {
        this.zab = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TelemetryLoggingOptions) {
            return zzah.equal(this.zab, ((TelemetryLoggingOptions) obj).zab);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zab});
    }
}
