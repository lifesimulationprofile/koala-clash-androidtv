package androidx.lifecycle;

import java.util.LinkedHashMap;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.MapBuilder;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandle {
    public final Request impl;
    public final LinkedHashMap liveDatas;

    public SavedStateHandle(MapBuilder mapBuilder) {
        this.liveDatas = new LinkedHashMap();
        this.impl = new Request(mapBuilder);
    }

    public SavedStateHandle() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new Request(EmptyMap.INSTANCE);
    }
}
