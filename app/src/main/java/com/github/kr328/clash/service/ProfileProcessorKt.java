package com.github.kr328.clash.service;

import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileProcessorKt {
    public static final HwidLimitMarker parseHwidLimitMarker(String str) {
        if (str == null || !StringsKt__StringsJVMKt.startsWith(str, "HWID_LIMIT", false)) {
            return null;
        }
        String strRemovePrefix = StringsKt.removePrefix(StringsKt.removePrefix(str, "HWID_LIMIT"), "|");
        return new HwidLimitMarker(strRemovePrefix.length() > 0 ? strRemovePrefix : null);
    }
}
