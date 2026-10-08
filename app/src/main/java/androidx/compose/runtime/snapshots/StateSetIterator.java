package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StateSetIterator implements Iterator, KMappedMarker {
    public Object current;
    public final Iterator iterator;
    public int modification;
    public Object next;
    public final SnapshotStateSet set;

    public StateSetIterator(SnapshotStateSet snapshotStateSet, Iterator it) {
        this.set = snapshotStateSet;
        this.iterator = it;
        this.modification = ((StateSetStateRecord) SnapshotKt.current(snapshotStateSet.firstStateRecord)).modification;
        this.current = this.next;
        this.next = it.hasNext() ? it.next() : null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (((StateSetStateRecord) SnapshotKt.current(this.set.firstStateRecord)).modification != this.modification) {
            throw new ConcurrentModificationException();
        }
        this.current = this.next;
        Iterator it = this.iterator;
        this.next = it.hasNext() ? it.next() : null;
        Object obj = this.current;
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        SnapshotStateSet snapshotStateSet = this.set;
        if (((StateSetStateRecord) SnapshotKt.current(snapshotStateSet.firstStateRecord)).modification != this.modification) {
            throw new ConcurrentModificationException();
        }
        Object obj = this.current;
        if (obj == null) {
            throw new IllegalStateException();
        }
        snapshotStateSet.remove(obj);
        this.current = null;
        Unit unit = Unit.INSTANCE;
        this.modification = ((StateSetStateRecord) SnapshotKt.current(snapshotStateSet.firstStateRecord)).modification;
    }
}
