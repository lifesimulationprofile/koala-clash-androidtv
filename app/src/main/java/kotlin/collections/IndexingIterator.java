package kotlin.collections;

import androidx.appcompat.widget.AppCompatHintHelper;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropSequence;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IndexingIterator implements Iterator, KMappedMarker {
    public final /* synthetic */ int $r8$classId = 0;
    public int index;
    public final Iterator iterator;

    public IndexingIterator(Iterator it) {
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.$r8$classId) {
            case 0:
                return this.iterator.hasNext();
        }
        while (true) {
            int i = this.index;
            it = this.iterator;
            if (i > 0 && it.hasNext()) {
                it.next();
                this.index--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.$r8$classId) {
            case 0:
                int i = this.index;
                this.index = i + 1;
                if (i >= 0) {
                    return new IndexedValue(i, this.iterator.next());
                }
                AppCompatHintHelper.throwIndexOverflow();
                throw null;
        }
        while (true) {
            int i2 = this.index;
            it = this.iterator;
            if (i2 > 0 && it.hasNext()) {
                it.next();
                this.index--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public IndexingIterator(DropSequence dropSequence) {
        this.iterator = dropSequence.sequence.iterator();
        this.index = dropSequence.count;
    }
}
