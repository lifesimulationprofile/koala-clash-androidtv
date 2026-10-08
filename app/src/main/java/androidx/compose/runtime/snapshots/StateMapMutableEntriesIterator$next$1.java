package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StateMapMutableEntriesIterator$next$1 implements Map.Entry, KMutableMap.Entry {
    public final Object key;
    public final /* synthetic */ StateMapMutableKeysIterator this$0;
    public Object value;

    public StateMapMutableEntriesIterator$next$1(StateMapMutableKeysIterator stateMapMutableKeysIterator) {
        this.this$0 = stateMapMutableKeysIterator;
        this.key = stateMapMutableKeysIterator.current.getKey();
        this.value = stateMapMutableKeysIterator.current.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        StateMapMutableKeysIterator stateMapMutableKeysIterator = this.this$0;
        if (stateMapMutableKeysIterator.map.getReadable$runtime().modification != stateMapMutableKeysIterator.modification) {
            throw new ConcurrentModificationException();
        }
        Object obj2 = this.value;
        stateMapMutableKeysIterator.map.put(this.key, obj);
        this.value = obj;
        return obj2;
    }
}
