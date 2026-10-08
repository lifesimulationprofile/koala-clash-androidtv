package com.google.android.datatransport.cct.internal;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_LogRequest extends LogRequest {
    public final AutoValue_ClientInfo clientInfo;
    public final ArrayList logEvents;
    public final Integer logSource;
    public final String logSourceName;
    public final long requestTimeMs;
    public final long requestUptimeMs;

    public AutoValue_LogRequest(long j, long j2, AutoValue_ClientInfo autoValue_ClientInfo, Integer num, String str, ArrayList arrayList) {
        QosTier qosTier = QosTier.DEFAULT;
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = autoValue_ClientInfo;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
        Object obj2 = QosTier.DEFAULT;
        ArrayList arrayList = autoValue_LogRequest.logEvents;
        String str = autoValue_LogRequest.logSourceName;
        Integer num = autoValue_LogRequest.logSource;
        AutoValue_ClientInfo autoValue_ClientInfo = autoValue_LogRequest.clientInfo;
        if (this.requestTimeMs != autoValue_LogRequest.requestTimeMs || this.requestUptimeMs != autoValue_LogRequest.requestUptimeMs || !this.clientInfo.equals(autoValue_ClientInfo)) {
            return false;
        }
        Integer num2 = this.logSource;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str2 = this.logSourceName;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return this.logEvents.equals(arrayList) && obj2.equals(obj2);
    }

    public final int hashCode() {
        long j = this.requestTimeMs;
        long j2 = this.requestUptimeMs;
        int iHashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.clientInfo.hashCode()) * 1000003;
        Integer num = this.logSource;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.logSourceName;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.logEvents.hashCode()) * 1000003) ^ QosTier.DEFAULT.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.requestTimeMs + ", requestUptimeMs=" + this.requestUptimeMs + ", clientInfo=" + this.clientInfo + ", logSource=" + this.logSource + ", logSourceName=" + this.logSourceName + ", logEvents=" + this.logEvents + ", qosTier=" + QosTier.DEFAULT + "}";
    }
}
