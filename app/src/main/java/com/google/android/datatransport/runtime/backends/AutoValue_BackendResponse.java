package com.google.android.datatransport.runtime.backends;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_BackendResponse {
    public final long nextRequestWaitMillis;
    public final int status;

    public AutoValue_BackendResponse(int i, long j) {
        if (i == 0) {
            throw new NullPointerException("Null status");
        }
        this.status = i;
        this.nextRequestWaitMillis = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_BackendResponse)) {
            return false;
        }
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) obj;
        return CaptureSession$State$EnumUnboxingLocalUtility.equals(this.status, autoValue_BackendResponse.status) && this.nextRequestWaitMillis == autoValue_BackendResponse.nextRequestWaitMillis;
    }

    public final int hashCode() {
        int iOrdinal = (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.status) ^ 1000003) * 1000003;
        long j = this.nextRequestWaitMillis;
        return iOrdinal ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.status;
        if (i == 1) {
            str = "OK";
        } else if (i != 2) {
            str = i != 3 ? "null" : "FATAL_ERROR";
        } else {
            str = "TRANSIENT_ERROR";
        }
        sb.append(str);
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.nextRequestWaitMillis);
        sb.append("}");
        return sb.toString();
    }
}
