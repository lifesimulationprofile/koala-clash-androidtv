package com.github.kr328.clash.service.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IPNet {
    public final String ip;
    public final int prefix;

    public IPNet(String str, int i) {
        this.ip = str;
        this.prefix = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IPNet)) {
            return false;
        }
        IPNet iPNet = (IPNet) obj;
        return Intrinsics.areEqual(this.ip, iPNet.ip) && this.prefix == iPNet.prefix;
    }

    public final int hashCode() {
        return (this.ip.hashCode() * 31) + this.prefix;
    }

    public final String toString() {
        return "IPNet(ip=" + this.ip + ", prefix=" + this.prefix + ")";
    }
}
