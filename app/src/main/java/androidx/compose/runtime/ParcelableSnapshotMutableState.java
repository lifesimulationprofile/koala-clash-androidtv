package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableSnapshotMutableState extends StateObjectImpl implements Parcelable, SnapshotMutableState {
    public static final Parcelable.Creator<ParcelableSnapshotMutableState> CREATOR = new ParcelableSnapshotMutableState$Companion$CREATOR$1();
    public SnapshotMutableStateImpl$StateStateRecord next;
    public final SnapshotMutationPolicy policy;

    public ParcelableSnapshotMutableState(Object obj, SnapshotMutationPolicy snapshotMutationPolicy) {
        this.policy = snapshotMutationPolicy;
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        SnapshotMutableStateImpl$StateStateRecord snapshotMutableStateImpl$StateStateRecord = new SnapshotMutableStateImpl$StateStateRecord(snapshotCurrentSnapshot.getSnapshotId(), obj);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            snapshotMutableStateImpl$StateStateRecord.next = new SnapshotMutableStateImpl$StateStateRecord(1, obj);
        }
        this.next = snapshotMutableStateImpl$StateStateRecord;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final SnapshotMutationPolicy getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return ((SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateObjectImpl, androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (this.policy.equivalent(((SnapshotMutableStateImpl$StateStateRecord) stateRecord2).value, ((SnapshotMutableStateImpl$StateStateRecord) stateRecord3).value)) {
            return stateRecord2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (SnapshotMutableStateImpl$StateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        Snapshot snapshotCurrentSnapshot;
        SnapshotMutableStateImpl$StateStateRecord snapshotMutableStateImpl$StateStateRecord = (SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.current(this.next);
        if (this.policy.equivalent(snapshotMutableStateImpl$StateStateRecord.value, obj)) {
            return;
        }
        SnapshotMutableStateImpl$StateStateRecord snapshotMutableStateImpl$StateStateRecord2 = this.next;
        synchronized (SnapshotKt.lock) {
            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            ((SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.overwritableRecord(snapshotMutableStateImpl$StateStateRecord2, this, snapshotCurrentSnapshot, snapshotMutableStateImpl$StateStateRecord)).value = obj;
            Unit unit = Unit.INSTANCE;
        }
        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
    }

    public final String toString() {
        return "MutableState(value=" + ((SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.current(this.next)).value + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeValue(getValue());
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE;
        SnapshotMutationPolicy snapshotMutationPolicy = this.policy;
        if (Intrinsics.areEqual(snapshotMutationPolicy, neverEqualPolicy)) {
            i2 = 0;
        } else if (Intrinsics.areEqual(snapshotMutationPolicy, NeverEqualPolicy.INSTANCE$3)) {
            i2 = 1;
        } else {
            if (!Intrinsics.areEqual(snapshotMutationPolicy, NeverEqualPolicy.INSTANCE$1)) {
                throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
            }
            i2 = 2;
        }
        parcel.writeInt(i2);
    }
}
