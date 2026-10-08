package androidx.compose.runtime.snapshots;

import com.google.zxing.WriterException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotApplyResult$Failure extends SnapshotId_jvmKt {
    public final MutableSnapshot snapshot;

    public SnapshotApplyResult$Failure(MutableSnapshot mutableSnapshot) {
        this.snapshot = mutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotId_jvmKt
    public final void check() throws WriterException {
        this.snapshot.dispose();
        throw new WriterException();
    }
}
