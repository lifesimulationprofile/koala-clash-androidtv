package com.google.android.datatransport.runtime;

import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_EventInternal {
    public final Map autoMetadata;
    public final Integer code;
    public final EncodedPayload encodedPayload;
    public final long eventMillis;
    public final String transportName;
    public final long uptimeMillis;

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, HashMap map) {
        this.transportName = str;
        this.code = num;
        this.encodedPayload = encodedPayload;
        this.eventMillis = j;
        this.uptimeMillis = j2;
        this.autoMetadata = map;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_EventInternal) {
            AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj;
            Integer num2 = autoValue_EventInternal.code;
            if (this.transportName.equals(autoValue_EventInternal.transportName) && ((num = this.code) != null ? num.equals(num2) : num2 == null) && this.encodedPayload.equals(autoValue_EventInternal.encodedPayload) && this.eventMillis == autoValue_EventInternal.eventMillis && this.uptimeMillis == autoValue_EventInternal.uptimeMillis && this.autoMetadata.equals(autoValue_EventInternal.autoMetadata)) {
                return true;
            }
        }
        return false;
    }

    public final String get(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        return str2 == null ? "" : str2;
    }

    public final int getInteger(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final int hashCode() {
        int iHashCode = (this.transportName.hashCode() ^ 1000003) * 1000003;
        Integer num = this.code;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.encodedPayload.hashCode()) * 1000003;
        long j = this.eventMillis;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.uptimeMillis;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.autoMetadata.hashCode();
    }

    public final Http2Connection.Builder toBuilder() {
        Http2Connection.Builder builder = new Http2Connection.Builder();
        String str = this.transportName;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        builder.connectionName = str;
        builder.taskRunner = this.code;
        EncodedPayload encodedPayload = this.encodedPayload;
        if (encodedPayload == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        builder.socket = encodedPayload;
        builder.source = Long.valueOf(this.eventMillis);
        builder.sink = Long.valueOf(this.uptimeMillis);
        builder.listener = new HashMap(this.autoMetadata);
        return builder;
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.transportName + ", code=" + this.code + ", encodedPayload=" + this.encodedPayload + ", eventMillis=" + this.eventMillis + ", uptimeMillis=" + this.uptimeMillis + ", autoMetadata=" + this.autoMetadata + "}";
    }
}
