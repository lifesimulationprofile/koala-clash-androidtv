package kotlin.collections.builders;

import androidx.emoji2.text.flatbuffer.Table;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MapBuilder implements Map, Serializable, KMutableMap {
    public static final MapBuilder Empty;
    public MapBuilderKeys entriesView;
    public int[] hashArray;
    public int hashShift;
    public boolean isReadOnly;
    public Object[] keysArray;
    public MapBuilderKeys keysView;
    public int length;
    public int maxProbeDistance;
    public int modCount;
    public int[] presenceArray;
    public int size;
    public Object[] valuesArray;
    public MapBuilderValues valuesView;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EntryRef implements Map.Entry, KMutableMap.Entry {
        public final int expectedModCount;
        public final int index;
        public final MapBuilder map;

        public EntryRef(MapBuilder mapBuilder, int i) {
            this.map = mapBuilder;
            this.index = i;
            this.expectedModCount = mapBuilder.modCount;
        }

        public final void checkForComodification$6() {
            if (this.map.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            checkForComodification$6();
            return this.map.keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            checkForComodification$6();
            return this.map.valuesArray[this.index];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            checkForComodification$6();
            MapBuilder mapBuilder = this.map;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            Object[] objArr = mapBuilder.valuesArray;
            if (objArr == null) {
                int length = mapBuilder.keysArray.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                mapBuilder.valuesArray = objArr;
            }
            int i = this.index;
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class KeysItr extends Table implements Iterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;

        public KeysItr(MapBuilder mapBuilder, int i) {
            this.$r8$classId = i;
            this.bb = mapBuilder;
            this.vtable_start = -1;
            this.vtable_size = mapBuilder.modCount;
            initNext$kotlin_stdlib();
        }

        @Override // java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    checkForComodification$kotlin_stdlib();
                    int i = this.bb_pos;
                    MapBuilder mapBuilder = (MapBuilder) this.bb;
                    if (i >= mapBuilder.length) {
                        throw new NoSuchElementException();
                    }
                    this.bb_pos = i + 1;
                    this.vtable_start = i;
                    Object obj = mapBuilder.keysArray[i];
                    initNext$kotlin_stdlib();
                    return obj;
                case 1:
                    checkForComodification$kotlin_stdlib();
                    int i2 = this.bb_pos;
                    MapBuilder mapBuilder2 = (MapBuilder) this.bb;
                    if (i2 >= mapBuilder2.length) {
                        throw new NoSuchElementException();
                    }
                    this.bb_pos = i2 + 1;
                    this.vtable_start = i2;
                    EntryRef entryRef = new EntryRef(mapBuilder2, i2);
                    initNext$kotlin_stdlib();
                    return entryRef;
                default:
                    checkForComodification$kotlin_stdlib();
                    int i3 = this.bb_pos;
                    MapBuilder mapBuilder3 = (MapBuilder) this.bb;
                    if (i3 >= mapBuilder3.length) {
                        throw new NoSuchElementException();
                    }
                    this.bb_pos = i3 + 1;
                    this.vtable_start = i3;
                    Object obj2 = mapBuilder3.valuesArray[i3];
                    initNext$kotlin_stdlib();
                    return obj2;
            }
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    public MapBuilder(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.keysArray = objArr;
        this.valuesArray = null;
        this.presenceArray = iArr;
        this.hashArray = new int[iHighestOneBit];
        this.maxProbeDistance = 2;
        this.length = 0;
        this.hashShift = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int addKey$kotlin_stdlib(Object obj) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iHash = hash(obj);
            int i = this.maxProbeDistance * 2;
            int length = this.hashArray.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.hashArray;
                int i3 = iArr[iHash];
                if (i3 <= 0) {
                    int i4 = this.length;
                    Object[] objArr = this.keysArray;
                    if (i4 >= objArr.length) {
                        ensureExtraCapacity$1(1);
                        break;
                    }
                    int i5 = i4 + 1;
                    this.length = i5;
                    objArr[i4] = obj;
                    this.presenceArray[i4] = iHash;
                    iArr[iHash] = i5;
                    this.size++;
                    this.modCount++;
                    if (i2 > this.maxProbeDistance) {
                        this.maxProbeDistance = i2;
                    }
                    return i4;
                }
                if (Intrinsics.areEqual(this.keysArray[i3 - 1], obj)) {
                    return -i3;
                }
                i2++;
                if (i2 > i) {
                    rehash(this.hashArray.length * 2);
                    break;
                }
                iHash = iHash == 0 ? this.hashArray.length - 1 : iHash - 1;
            }
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.length - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.hashArray[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        Object[] objArr = this.valuesArray;
        if (objArr != null) {
            ListBuilderKt.resetRange(objArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        this.modCount++;
    }

    public final void compact(boolean z) {
        int i;
        Object[] objArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.keysArray;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.hashArray[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        ListBuilderKt.resetRange(this.keysArray, i3, i);
        if (objArr != null) {
            ListBuilderKt.resetRange(objArr, i3, this.length);
        }
        this.length = i3;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        int i;
        int i2 = this.length;
        while (true) {
            i = -1;
            i2--;
            if (i2 >= 0) {
                if (this.presenceArray[i2] >= 0 && Intrinsics.areEqual(this.valuesArray[i2], obj)) {
                    i = i2;
                    break;
                }
            } else {
                break;
            }
        }
        return i >= 0;
    }

    public final void ensureExtraCapacity$1(int i) {
        Object[] objArr = this.keysArray;
        int length = objArr.length;
        int i2 = this.length;
        int i3 = length - i2;
        int i4 = i2 - this.size;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            compact(true);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = objArr.length;
            int i6 = length2 + (length2 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.keysArray = Arrays.copyOf(objArr, i6);
            Object[] objArr2 = this.valuesArray;
            this.valuesArray = objArr2 != null ? Arrays.copyOf(objArr2, i6) : null;
            this.presenceArray = Arrays.copyOf(this.presenceArray, i6);
            int iHighestOneBit = Integer.highestOneBit((i6 >= 1 ? i6 : 1) * 3);
            if (iHighestOneBit > this.hashArray.length) {
                rehash(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        MapBuilderKeys mapBuilderKeys = this.entriesView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this, 1);
        this.entriesView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean z;
        Map.Entry entry;
        int iFindKey;
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.size == map.size()) {
                    Iterator it = map.entrySet().iterator();
                    do {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (next == null) {
                                break;
                            }
                            try {
                                entry = (Map.Entry) next;
                                iFindKey = findKey(entry.getKey());
                            } catch (ClassCastException unused) {
                            }
                        } else {
                            z = true;
                        }
                        if (z) {
                        }
                    } while (iFindKey < 0 ? false : Intrinsics.areEqual(this.valuesArray[iFindKey], entry.getValue()));
                    z = false;
                    if (z) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int findKey(Object obj) {
        int iHash = hash(obj);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[iHash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.areEqual(this.keysArray[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iHash = iHash == 0 ? this.hashArray.length - 1 : iHash - 1;
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        return this.valuesArray[iFindKey];
    }

    public final int hash(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    @Override // java.util.Map
    public final int hashCode() {
        KeysItr keysItr = new KeysItr(this, 1);
        int i = 0;
        while (keysItr.hasNext()) {
            int i2 = keysItr.bb_pos;
            MapBuilder mapBuilder = (MapBuilder) keysItr.bb;
            if (i2 >= mapBuilder.length) {
                throw new NoSuchElementException();
            }
            keysItr.bb_pos = i2 + 1;
            keysItr.vtable_start = i2;
            Object obj = mapBuilder.keysArray[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object obj2 = mapBuilder.valuesArray[keysItr.vtable_start];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            keysItr.initNext$kotlin_stdlib();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        MapBuilderKeys mapBuilderKeys = this.keysView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this, 0);
        this.keysView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(obj);
        Object[] objArr = this.valuesArray;
        if (objArr == null) {
            int length = this.keysArray.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.valuesArray = objArr;
        }
        if (iAddKey$kotlin_stdlib >= 0) {
            objArr[iAddKey$kotlin_stdlib] = obj2;
            return null;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        ensureExtraCapacity$1(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
            Object[] objArr = this.valuesArray;
            if (objArr == null) {
                int length = this.keysArray.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.valuesArray = objArr;
            }
            if (iAddKey$kotlin_stdlib >= 0) {
                objArr[iAddKey$kotlin_stdlib] = entry.getValue();
            } else {
                int i = (-iAddKey$kotlin_stdlib) - 1;
                if (!Intrinsics.areEqual(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    public final void rehash(int i) {
        int[] iArr;
        this.modCount++;
        int i2 = 0;
        if (this.length > this.size) {
            compact(false);
        }
        this.hashArray = new int[i];
        this.hashShift = Integer.numberOfLeadingZeros(i) + 1;
        while (i2 < this.length) {
            int i3 = i2 + 1;
            int iHash = hash(this.keysArray[i2]);
            int i4 = this.maxProbeDistance;
            while (true) {
                iArr = this.hashArray;
                if (iArr[iHash] == 0) {
                    break;
                }
                i4--;
                if (i4 < 0) {
                    throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                }
                iHash = iHash == 0 ? iArr.length - 1 : iHash - 1;
            }
            iArr[iHash] = i3;
            this.presenceArray[i2] = iHash;
            i2 = i3;
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        Object obj2 = this.valuesArray[iFindKey];
        removeEntryAt(iFindKey);
        return obj2;
    }

    public final void removeEntryAt(int i) {
        this.keysArray[i] = null;
        Object[] objArr = this.valuesArray;
        if (objArr != null) {
            objArr[i] = null;
        }
        int length = this.presenceArray[i];
        int i2 = this.maxProbeDistance * 2;
        int length2 = this.hashArray.length / 2;
        if (i2 > length2) {
            i2 = length2;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = length;
        do {
            length = length == 0 ? this.hashArray.length - 1 : length - 1;
            i4++;
            if (i4 > this.maxProbeDistance) {
                this.hashArray[i5] = 0;
            } else {
                int[] iArr = this.hashArray;
                int i6 = iArr[length];
                if (i6 == 0) {
                    iArr[i5] = 0;
                } else {
                    if (i6 < 0) {
                        iArr[i5] = -1;
                    } else {
                        int i7 = i6 - 1;
                        int iHash = hash(this.keysArray[i7]) - length;
                        int[] iArr2 = this.hashArray;
                        if ((iHash & (iArr2.length - 1)) >= i4) {
                            iArr2[i5] = i6;
                            this.presenceArray[i7] = i5;
                        }
                        i3--;
                    }
                    i5 = length;
                    i4 = 0;
                    i3--;
                }
            }
            this.presenceArray[i] = -1;
            this.size--;
            this.modCount++;
        } while (i3 >= 0);
        this.hashArray[i5] = -1;
        this.presenceArray[i] = -1;
        this.size--;
        this.modCount++;
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.size * 3) + 2);
        sb.append("{");
        KeysItr keysItr = new KeysItr(this, 1);
        int i = 0;
        while (keysItr.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = keysItr.bb_pos;
            MapBuilder mapBuilder = (MapBuilder) keysItr.bb;
            if (i2 >= mapBuilder.length) {
                throw new NoSuchElementException();
            }
            keysItr.bb_pos = i2 + 1;
            keysItr.vtable_start = i2;
            Object obj = mapBuilder.keysArray[i2];
            if (obj == mapBuilder) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object obj2 = mapBuilder.valuesArray[keysItr.vtable_start];
            if (obj2 == mapBuilder) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            keysItr.initNext$kotlin_stdlib();
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        MapBuilderValues mapBuilderValues = this.valuesView;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues mapBuilderValues2 = new MapBuilderValues(0, this);
        this.valuesView = mapBuilderValues2;
        return mapBuilderValues2;
    }
}
