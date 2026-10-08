package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import androidx.customview.view.AbsSavedState;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateSet implements Parcelable, StateObject, Set, RandomAccess, KMutableSet {
    public static final Parcelable.Creator<SnapshotStateSet> CREATOR = new AbsSavedState.AnonymousClass2(3);
    public StateSetStateRecord firstStateRecord;

    public SnapshotStateSet() {
        PersistentOrderedSet persistentOrderedSet = PersistentOrderedSet.EMPTY;
        StateSetStateRecord stateSetStateRecord = new StateSetStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), persistentOrderedSet);
        if (SnapshotKt.threadSnapshot.get() != null) {
            stateSetStateRecord.next = new StateSetStateRecord(1, persistentOrderedSet);
        }
        this.firstStateRecord = stateSetStateRecord;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        int i;
        PersistentSet persistentSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord);
                i = stateSetStateRecord.modification;
                persistentSet = stateSetStateRecord.set;
                Unit unit = Unit.INSTANCE;
            }
            PersistentOrderedSet persistentOrderedSetAdd = ((PersistentOrderedSet) persistentSet).add(obj);
            if (persistentOrderedSetAdd.equals(persistentSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetAdd);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i;
        PersistentSet persistentSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord);
                i = stateSetStateRecord.modification;
                persistentSet = stateSetStateRecord.set;
                Unit unit = Unit.INSTANCE;
            }
            PersistentOrderedSetBuilder persistentOrderedSetBuilder = new PersistentOrderedSetBuilder((PersistentOrderedSet) persistentSet);
            persistentOrderedSetBuilder.addAll(collection);
            PersistentOrderedSet persistentOrderedSetBuild = persistentOrderedSetBuilder.build();
            if (persistentOrderedSetBuild.equals(persistentSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        Snapshot snapshotCurrentSnapshot;
        StateSetStateRecord stateSetStateRecord = this.firstStateRecord;
        synchronized (SnapshotKt.lock) {
            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord, this, snapshotCurrentSnapshot);
            synchronized (SnapshotId_jvmKt.sync$2) {
                stateSetStateRecord2.set = PersistentOrderedSet.EMPTY;
                stateSetStateRecord2.modification++;
            }
        }
        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return ((StateSetStateRecord) SnapshotKt.readable(this.firstStateRecord, this)).set.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return ((StateSetStateRecord) SnapshotKt.readable(this.firstStateRecord, this)).set.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return ((StateSetStateRecord) SnapshotKt.readable(this.firstStateRecord, this)).set.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new StateSetIterator(this, ((StateSetStateRecord) SnapshotKt.readable(this.firstStateRecord, this)).set.iterator());
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        stateRecord.next = this.firstStateRecord;
        this.firstStateRecord = (StateSetStateRecord) stateRecord;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        PersistentSet persistentSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord);
                i = stateSetStateRecord.modification;
                persistentSet = stateSetStateRecord.set;
                Unit unit = Unit.INSTANCE;
            }
            PersistentOrderedSet persistentOrderedSetRemove = ((PersistentOrderedSet) persistentSet).remove(obj);
            if (persistentOrderedSetRemove.equals(persistentSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetRemove);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i;
        PersistentSet persistentSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord);
                i = stateSetStateRecord.modification;
                persistentSet = stateSetStateRecord.set;
                Unit unit = Unit.INSTANCE;
            }
            PersistentOrderedSetBuilder persistentOrderedSetBuilder = new PersistentOrderedSetBuilder((PersistentOrderedSet) persistentSet);
            persistentOrderedSetBuilder.removeAll(collection);
            PersistentOrderedSet persistentOrderedSetBuild = persistentOrderedSetBuilder.build();
            if (persistentOrderedSetBuild.equals(persistentSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i;
        PersistentSet persistentSet;
        boolean zRetainAll;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord);
                i = stateSetStateRecord.modification;
                persistentSet = stateSetStateRecord.set;
                Unit unit = Unit.INSTANCE;
            }
            if (persistentSet == null) {
                throw new IllegalStateException("No set to mutate");
            }
            PersistentOrderedSetBuilder persistentOrderedSetBuilder = new PersistentOrderedSetBuilder((PersistentOrderedSet) persistentSet);
            zRetainAll = persistentOrderedSetBuilder.retainAll(CollectionsKt.toSet(collection));
            PersistentOrderedSet persistentOrderedSetBuild = persistentOrderedSetBuilder.build();
            if (persistentOrderedSetBuild.equals(persistentSet)) {
                break;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return zRetainAll;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return ((StateSetStateRecord) SnapshotKt.readable(this.firstStateRecord, this)).set.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    public final String toString() {
        return "SnapshotStateSet(value=" + ((StateSetStateRecord) SnapshotKt.current(this.firstStateRecord)).set + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        PersistentSet persistentSet = ((StateSetStateRecord) SnapshotKt.readable(this.firstStateRecord, this)).set;
        parcel.writeInt(size());
        Iterator it = persistentSet.iterator();
        if (it.hasNext()) {
            parcel.writeValue(it.next());
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }
}
