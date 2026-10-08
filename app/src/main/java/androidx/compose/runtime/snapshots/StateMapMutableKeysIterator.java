package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StateMapMutableKeysIterator implements Iterator, KMappedMarker {
    public final /* synthetic */ int $r8$classId;
    public Map.Entry current;
    public final Iterator iterator;
    public final SnapshotStateMap map;
    public int modification;
    public Map.Entry next;

    public StateMapMutableKeysIterator(SnapshotStateMap snapshotStateMap, Iterator it, int i) {
        this.$r8$classId = i;
        this.map = snapshotStateMap;
        this.iterator = it;
        this.modification = snapshotStateMap.getReadable$runtime().modification;
        advance$1();
    }

    public final void advance$1() {
        this.current = this.next;
        Iterator it = this.iterator;
        this.next = it.hasNext() ? (Map.Entry) it.next() : null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                Map.Entry entry = this.next;
                if (entry == null) {
                    throw new IllegalStateException();
                }
                advance$1();
                return entry.getKey();
            case 1:
                advance$1();
                if (this.current != null) {
                    return new StateMapMutableEntriesIterator$next$1(this);
                }
                throw new IllegalStateException();
            default:
                Map.Entry entry2 = this.next;
                if (entry2 == null) {
                    throw new IllegalStateException();
                }
                advance$1();
                return entry2.getValue();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        SnapshotStateMap snapshotStateMap = this.map;
        if (snapshotStateMap.getReadable$runtime().modification != this.modification) {
            throw new ConcurrentModificationException();
        }
        Map.Entry entry = this.current;
        if (entry == null) {
            throw new IllegalStateException();
        }
        snapshotStateMap.remove(entry.getKey());
        this.current = null;
        Unit unit = Unit.INSTANCE;
        this.modification = snapshotStateMap.getReadable$runtime().modification;
    }
}
