package com.github.kr328.clash.service;

import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HwidLimitException extends IllegalStateException {
    public final String supportURL;

    public HwidLimitException(String str) {
        super((str == null || StringsKt.isBlank(str)) ? "HWID_LIMIT" : "HWID_LIMIT|".concat(str));
        this.supportURL = str;
    }
}
