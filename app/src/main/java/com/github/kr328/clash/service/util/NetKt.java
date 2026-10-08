package com.github.kr328.clash.service.util;

import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NetKt {
    public static final IPNet parseCIDR(String str) {
        List listSplit$default = StringsKt.split$default(str, new String[]{"/"}, 2, 2);
        if (listSplit$default.size() == 2) {
            return new IPNet((String) listSplit$default.get(0), Integer.parseInt((String) listSplit$default.get(1)));
        }
        throw new IllegalArgumentException("Invalid address");
    }
}
