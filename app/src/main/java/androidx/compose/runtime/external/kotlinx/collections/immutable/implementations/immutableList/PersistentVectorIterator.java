package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentVectorIterator extends AbstractListIterator {
    public final Object[] tail;
    public final TrieIterator trieIterator;

    public PersistentVectorIterator(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        super(i, i2);
        this.tail = objArr2;
        int i4 = (i2 - 1) & (-32);
        this.trieIterator = new TrieIterator(objArr, i > i4 ? i4 : i, i4, i3);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        TrieIterator trieIterator = this.trieIterator;
        if (trieIterator.hasNext()) {
            this.index++;
            return trieIterator.next();
        }
        int i = this.index;
        this.index = i + 1;
        return this.tail[i - trieIterator.size];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.index;
        TrieIterator trieIterator = this.trieIterator;
        int i2 = trieIterator.size;
        if (i <= i2) {
            this.index = i - 1;
            return trieIterator.previous();
        }
        int i3 = i - 1;
        this.index = i3;
        return this.tail[i3 - i2];
    }
}
