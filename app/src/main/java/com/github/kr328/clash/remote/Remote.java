package com.github.kr328.clash.remote;

import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.common.Global;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Remote {
    public static final DiskLruCache.Editor broadcasts;
    public static final Service service;

    static {
        Global.INSTANCE.getClass();
        broadcasts = new DiskLruCache.Editor(Global.getApplication$1());
        service = new Service(Global.getApplication$1(), new ImageLoader$Builder$$ExternalSyntheticLambda2(29));
        ChannelKt.Channel$default(-1, 0, 6);
    }
}
