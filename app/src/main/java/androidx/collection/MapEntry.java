package androidx.collection;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class MapEntry implements Map.Entry, KMappedMarker {
    public final /* synthetic */ int $r8$classId;
    public final Object key;
    public final Object value;

    public /* synthetic */ MapEntry(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.key = obj;
        this.value = obj2;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                Map.Entry entry = obj instanceof Map.Entry ? (Map.Entry) obj : null;
                return entry != null && Intrinsics.areEqual(entry.getKey(), this.key) && Intrinsics.areEqual(entry.getValue(), getValue());
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.key;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.value;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        switch (this.$r8$classId) {
            case 1:
                Object obj = this.key;
                int iHashCode = obj != null ? obj.hashCode() : 0;
                Object value = getValue();
                return (value != null ? value.hashCode() : 0) ^ iHashCode;
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append(this.key);
                sb.append('=');
                sb.append(getValue());
                return sb.toString();
            default:
                return super.toString();
        }
    }
}
