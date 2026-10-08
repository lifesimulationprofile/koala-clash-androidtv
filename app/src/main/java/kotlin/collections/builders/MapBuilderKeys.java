package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MapBuilderKeys extends AbstractMutableSet {
    public final /* synthetic */ int $r8$classId;
    public final MapBuilder backing;

    public /* synthetic */ MapBuilderKeys(MapBuilder mapBuilder, int i) {
        this.$r8$classId = i;
        this.backing = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                this.backing.clear();
                break;
            default:
                this.backing.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return this.backing.containsKey(obj);
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                MapBuilder mapBuilder = this.backing;
                mapBuilder.getClass();
                int iFindKey = mapBuilder.findKey(entry.getKey());
                if (iFindKey < 0) {
                    return false;
                }
                return Intrinsics.areEqual(mapBuilder.valuesArray[iFindKey], entry.getValue());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.$r8$classId) {
            case 1:
                MapBuilder mapBuilder = this.backing;
                mapBuilder.getClass();
                for (Object obj : collection) {
                    if (obj == null) {
                        return false;
                    }
                    try {
                        Map.Entry entry = (Map.Entry) obj;
                        int iFindKey = mapBuilder.findKey(entry.getKey());
                        if (!(iFindKey < 0 ? false : Intrinsics.areEqual(mapBuilder.valuesArray[iFindKey], entry.getValue()))) {
                            return false;
                        }
                    } catch (ClassCastException unused) {
                        return false;
                    }
                }
                return true;
            default:
                return super.containsAll(collection);
        }
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.backing.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                MapBuilder mapBuilder = this.backing;
                mapBuilder.getClass();
                return new MapBuilder.KeysItr(mapBuilder, 0);
            default:
                MapBuilder mapBuilder2 = this.backing;
                mapBuilder2.getClass();
                return new MapBuilder.KeysItr(mapBuilder2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                MapBuilder mapBuilder = this.backing;
                mapBuilder.checkIsMutable$kotlin_stdlib();
                int iFindKey = mapBuilder.findKey(obj);
                if (iFindKey < 0) {
                    return false;
                }
                mapBuilder.removeEntryAt(iFindKey);
                return true;
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                MapBuilder mapBuilder2 = this.backing;
                mapBuilder2.checkIsMutable$kotlin_stdlib();
                int iFindKey2 = mapBuilder2.findKey(entry.getKey());
                if (iFindKey2 < 0 || !Intrinsics.areEqual(mapBuilder2.valuesArray[iFindKey2], entry.getValue())) {
                    return false;
                }
                mapBuilder2.removeEntryAt(iFindKey2);
                return true;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                this.backing.checkIsMutable$kotlin_stdlib();
                break;
            default:
                this.backing.checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                this.backing.checkIsMutable$kotlin_stdlib();
                break;
            default:
                this.backing.checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.retainAll(collection);
    }
}
