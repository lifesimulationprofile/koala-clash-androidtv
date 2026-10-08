package androidx.camera.core.impl;

import android.util.ArrayMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableTagBundle extends TagBundle {
    public static MutableTagBundle create() {
        return new MutableTagBundle(new ArrayMap());
    }
}
