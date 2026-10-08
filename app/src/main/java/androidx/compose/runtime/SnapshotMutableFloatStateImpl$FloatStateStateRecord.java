package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateRecord;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMutableFloatStateImpl$FloatStateStateRecord extends StateRecord {
    public float value;

    public SnapshotMutableFloatStateImpl$FloatStateStateRecord(float f, long j) {
        super(j);
        this.value = f;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        this.value = ((SnapshotMutableFloatStateImpl$FloatStateStateRecord) stateRecord).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new SnapshotMutableFloatStateImpl$FloatStateStateRecord(this.value, j);
    }
}
