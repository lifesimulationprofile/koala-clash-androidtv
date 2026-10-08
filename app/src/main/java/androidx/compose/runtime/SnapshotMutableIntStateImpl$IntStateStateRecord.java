package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateRecord;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMutableIntStateImpl$IntStateStateRecord extends StateRecord {
    public int value;

    public SnapshotMutableIntStateImpl$IntStateStateRecord(int i, long j) {
        super(j);
        this.value = i;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        this.value = ((SnapshotMutableIntStateImpl$IntStateStateRecord) stateRecord).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new SnapshotMutableIntStateImpl$IntStateStateRecord(this.value, j);
    }
}
