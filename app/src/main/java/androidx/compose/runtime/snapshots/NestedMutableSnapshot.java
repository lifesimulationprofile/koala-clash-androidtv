package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public boolean deactivated;
    public final MutableSnapshot parent;

    public NestedMutableSnapshot(long j, SnapshotIdSet snapshotIdSet, Function1 function1, Function1 function2, MutableSnapshot mutableSnapshot) {
        super(j, snapshotIdSet, function1, function2);
        this.parent = mutableSnapshot;
        mutableSnapshot.nestedActivated$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final SnapshotId_jvmKt apply() throws Throwable {
        NestedMutableSnapshot nestedMutableSnapshot;
        MutableSnapshot mutableSnapshot = this.parent;
        if (mutableSnapshot.applied || mutableSnapshot.disposed) {
            return new SnapshotApplyResult$Failure(this);
        }
        MutableScatterSet mutableScatterSet = this.modified;
        long j = this.snapshotId;
        HashMap mapAccess$optimisticMerges = mutableScatterSet != null ? SnapshotKt.access$optimisticMerges(mutableSnapshot.getSnapshotId(), this, this.parent.getInvalid$runtime()) : null;
        synchronized (SnapshotKt.lock) {
            try {
                SnapshotKt.access$validateOpen(this);
                try {
                    if (mutableScatterSet == null || mutableScatterSet._size == 0) {
                        nestedMutableSnapshot = this;
                        closeAndReleasePinning$runtime();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        nestedMutableSnapshot = this;
                        SnapshotId_jvmKt snapshotId_jvmKtInnerApplyLocked$runtime = nestedMutableSnapshot.innerApplyLocked$runtime(this.parent.getSnapshotId(), mutableScatterSet, mapAccess$optimisticMerges, this.parent.getInvalid$runtime());
                        if (!snapshotId_jvmKtInnerApplyLocked$runtime.equals(SnapshotApplyResult$Success.INSTANCE)) {
                            return snapshotId_jvmKtInnerApplyLocked$runtime;
                        }
                        MutableScatterSet modified$runtime = nestedMutableSnapshot.parent.getModified$runtime();
                        if (modified$runtime != null) {
                            modified$runtime.plusAssign(mutableScatterSet);
                        } else {
                            nestedMutableSnapshot.parent.setModified$runtime(mutableScatterSet);
                            nestedMutableSnapshot.modified = null;
                        }
                    }
                    if (Intrinsics.compare(nestedMutableSnapshot.parent.getSnapshotId(), j) < 0) {
                        nestedMutableSnapshot.parent.advance$runtime();
                    }
                    MutableSnapshot mutableSnapshot2 = nestedMutableSnapshot.parent;
                    mutableSnapshot2.setInvalid$runtime(mutableSnapshot2.getInvalid$runtime().clear(j).andNot(nestedMutableSnapshot.previousIds));
                    nestedMutableSnapshot.parent.recordPrevious$runtime(j);
                    MutableSnapshot mutableSnapshot3 = nestedMutableSnapshot.parent;
                    int i = nestedMutableSnapshot.pinningTrackingHandle;
                    nestedMutableSnapshot.pinningTrackingHandle = -1;
                    if (i >= 0) {
                        int[] iArr = mutableSnapshot3.previousPinnedSnapshots;
                        int length = iArr.length;
                        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
                        iArrCopyOf[length] = i;
                        mutableSnapshot3.previousPinnedSnapshots = iArrCopyOf;
                    } else {
                        mutableSnapshot3.getClass();
                    }
                    nestedMutableSnapshot.parent.recordPreviousList$runtime(nestedMutableSnapshot.previousIds);
                    MutableSnapshot mutableSnapshot4 = nestedMutableSnapshot.parent;
                    int[] iArr2 = nestedMutableSnapshot.previousPinnedSnapshots;
                    mutableSnapshot4.getClass();
                    if (iArr2.length != 0) {
                        int[] iArr3 = mutableSnapshot4.previousPinnedSnapshots;
                        if (iArr3.length != 0) {
                            int length2 = iArr3.length;
                            int length3 = iArr2.length;
                            int[] iArrCopyOf2 = Arrays.copyOf(iArr3, length2 + length3);
                            System.arraycopy(iArr2, 0, iArrCopyOf2, length2, length3);
                            iArr2 = iArrCopyOf2;
                        }
                        mutableSnapshot4.previousPinnedSnapshots = iArr2;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    nestedMutableSnapshot.applied = true;
                    if (!nestedMutableSnapshot.deactivated) {
                        nestedMutableSnapshot.deactivated = true;
                        nestedMutableSnapshot.parent.nestedDeactivated$runtime();
                    }
                    return SnapshotApplyResult$Success.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        if (this.disposed) {
            return;
        }
        super.dispose();
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.nestedDeactivated$runtime();
    }
}
