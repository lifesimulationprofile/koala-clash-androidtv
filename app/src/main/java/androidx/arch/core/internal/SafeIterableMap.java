package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap implements Iterable {
    public Entry mEnd;
    public final WeakHashMap mIterators = new WeakHashMap();
    public int mSize = 0;
    public Entry mStart;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AscendingIterator extends SupportRemove implements Iterator {
        public final /* synthetic */ int $r8$classId;
        public Entry mExpectedEnd;
        public Entry mNext;

        public AscendingIterator(Entry entry, Entry entry2, int i) {
            this.$r8$classId = i;
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        public final Entry forward(Entry entry) {
            switch (this.$r8$classId) {
                case 0:
                    return entry.mNext;
                default:
                    return entry.mPrevious;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.mNext != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Entry entry = this.mNext;
            Entry entry2 = this.mExpectedEnd;
            this.mNext = (entry == entry2 || entry2 == null) ? null : forward(entry);
            return entry;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void supportRemove(Entry entry) {
            Entry entry2;
            Entry entryForward = null;
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            Entry entry3 = this.mExpectedEnd;
            if (entry3 == entry) {
                switch (this.$r8$classId) {
                    case 0:
                        entry2 = entry3.mPrevious;
                        break;
                    default:
                        entry2 = entry3.mNext;
                        break;
                }
                this.mExpectedEnd = entry2;
            }
            Entry entry4 = this.mNext;
            if (entry4 == entry) {
                Entry entry5 = this.mExpectedEnd;
                if (entry4 != entry5 && entry5 != null) {
                    entryForward = forward(entry4);
                }
                this.mNext = entryForward;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Entry implements Map.Entry {
        public final Object mKey;
        public Entry mNext;
        public Entry mPrevious;
        public final Object mValue;

        public Entry(Object obj, Object obj2) {
            this.mKey = obj;
            this.mValue = obj2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.mKey.equals(entry.mKey) && this.mValue.equals(entry.mValue);
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class IteratorWithAdditions extends SupportRemove implements Iterator {
        public boolean mBeforeStart = true;
        public Entry mCurrent;

        public IteratorWithAdditions() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mBeforeStart) {
                return SafeIterableMap.this.mStart != null;
            }
            Entry entry = this.mCurrent;
            return (entry == null || entry.mNext == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.mStart;
            } else {
                Entry entry = this.mCurrent;
                this.mCurrent = entry != null ? entry.mNext : null;
            }
            return this.mCurrent;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void supportRemove(Entry entry) {
            Entry entry2 = this.mCurrent;
            if (entry == entry2) {
                Entry entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                this.mBeforeStart = entry3 == null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class SupportRemove {
        public abstract void supportRemove(Entry entry);
    }

    public final boolean equals(Object obj) {
        AscendingIterator ascendingIterator;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (this.mSize != safeIterableMap.mSize) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (true) {
            ascendingIterator = (AscendingIterator) it;
            if (!ascendingIterator.hasNext()) {
                break;
            }
            AscendingIterator ascendingIterator2 = (AscendingIterator) it2;
            if (!ascendingIterator2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) ascendingIterator.next();
            Object next = ascendingIterator2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (ascendingIterator.hasNext() || ((AscendingIterator) it2).hasNext()) ? false : true;
    }

    public Entry get(Object obj) {
        Entry entry = this.mStart;
        while (entry != null && !entry.mKey.equals(obj)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            AscendingIterator ascendingIterator = (AscendingIterator) it;
            if (!ascendingIterator.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) ascendingIterator.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd, 0);
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public Object remove(Object obj) {
        Entry entry = get(obj);
        if (entry == null) {
            return null;
        }
        this.mSize--;
        WeakHashMap weakHashMap = this.mIterators;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((SupportRemove) it.next()).supportRemove(entry);
            }
        }
        Entry entry2 = entry.mPrevious;
        if (entry2 != null) {
            entry2.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        Entry entry3 = entry.mNext;
        if (entry3 != null) {
            entry3.mPrevious = entry2;
        } else {
            this.mEnd = entry2;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            AscendingIterator ascendingIterator = (AscendingIterator) it;
            if (!ascendingIterator.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) ascendingIterator.next()).toString());
            if (ascendingIterator.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
