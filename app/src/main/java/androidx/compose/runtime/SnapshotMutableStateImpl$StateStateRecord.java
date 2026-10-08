package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateRecord;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMutableStateImpl$StateStateRecord extends StateRecord {
    public Object value;

    public SnapshotMutableStateImpl$StateStateRecord(long j, Object obj) {
        super(j);
        this.value = obj;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        this.value = ((SnapshotMutableStateImpl$StateStateRecord) stateRecord).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new SnapshotMutableStateImpl$StateStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.value);
    }
}
