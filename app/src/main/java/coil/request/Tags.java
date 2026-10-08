package coil.request;

import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Tags {
    public static final Tags EMPTY = new Tags(EmptyMap.INSTANCE);
    public final Map tags;

    public Tags(Map map) {
        this.tags = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tags) {
            return Intrinsics.areEqual(this.tags, ((Tags) obj).tags);
        }
        return false;
    }

    public final int hashCode() {
        return this.tags.hashCode();
    }

    public final String toString() {
        return "Tags(tags=" + this.tags + ')';
    }
}
