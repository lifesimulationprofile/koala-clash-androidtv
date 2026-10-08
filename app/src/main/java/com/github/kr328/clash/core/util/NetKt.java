package com.github.kr328.clash.core.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NetKt {
    public static final InetSocketAddress parseInetSocketAddress(String str) {
        URL url = new URL("https://".concat(str));
        return new InetSocketAddress(InetAddress.getByName(url.getHost()), url.getPort());
    }
}
