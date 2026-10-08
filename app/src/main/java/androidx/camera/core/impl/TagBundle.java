package androidx.camera.core.impl;

import android.util.ArrayMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class TagBundle {
    public static final TagBundle EMPTY_TAGBUNDLE = new TagBundle(new ArrayMap());
    public final ArrayMap mTagMap;

    public TagBundle(ArrayMap arrayMap) {
        this.mTagMap = arrayMap;
    }

    public final String toString() {
        return "android.hardware.camera2.CaptureRequest.setTag.CX";
    }
}
