package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiValueMap {
    public final MutableScatterMap map;

    /* JADX INFO: renamed from: removeLast-impl, reason: not valid java name */
    public static final Object m296removeLastimpl(MutableScatterMap mutableScatterMap) {
        Object obj = mutableScatterMap.get(null);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof MutableObjectList)) {
            mutableScatterMap.remove(null);
            return obj;
        }
        MutableObjectList mutableObjectList = (MutableObjectList) obj;
        if (mutableObjectList.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        int i = mutableObjectList._size - 1;
        Object obj2 = mutableObjectList.get(i);
        mutableObjectList.removeAt(i);
        if (mutableObjectList.isEmpty()) {
            mutableScatterMap.remove(null);
        }
        if (mutableObjectList._size == 1) {
            mutableScatterMap.set(null, mutableObjectList.first());
        }
        return obj2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MultiValueMap) {
            return Intrinsics.areEqual(this.map, ((MultiValueMap) obj).map);
        }
        return false;
    }

    public final int hashCode() {
        return this.map.hashCode();
    }

    public final String toString() {
        return "MultiValueMap(map=" + this.map + ')';
    }
}
