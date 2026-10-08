package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList$SubList;
import androidx.compose.runtime.snapshots.SnapshotStateList$$ExternalSyntheticLambda0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractPersistentList extends AbstractList implements List, Collection, KMappedMarker {
    @Override // java.util.List
    public abstract AbstractPersistentList add(int i, Object obj);

    @Override // java.util.Collection, java.util.List
    public abstract AbstractPersistentList add(Object obj);

    @Override // java.util.Collection, java.util.List
    public AbstractPersistentList addAll(Collection collection) {
        PersistentVectorBuilder persistentVectorBuilderBuilder = builder();
        persistentVectorBuilderBuilder.addAll(collection);
        return persistentVectorBuilderBuilder.build();
    }

    public abstract PersistentVectorBuilder builder();

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public abstract AbstractPersistentList removeAll(SnapshotStateList$$ExternalSyntheticLambda0 snapshotStateList$$ExternalSyntheticLambda0);

    public abstract AbstractPersistentList removeAt(int i);

    @Override // kotlin.collections.AbstractList, java.util.List
    public abstract AbstractPersistentList set(int i, Object obj);

    @Override // kotlin.collections.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        return new ImmutableList$SubList(this, i, i2);
    }
}
