package com.github.kr328.clash.core.bridge;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
@Keep
public interface TunInterface {
    void markSocket(int i);

    int querySocketUid(int i, String str, String str2);
}
