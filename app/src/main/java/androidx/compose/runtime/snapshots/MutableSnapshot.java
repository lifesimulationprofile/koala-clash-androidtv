package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    public static final int[] EmptyIntArray = new int[0];
    public boolean applied;
    public ArrayList merged;
    public MutableScatterSet modified;
    public SnapshotIdSet previousIds;
    public int[] previousPinnedSnapshots;
    public final Function1 readObserver;
    public int snapshots;
    public int writeCount;
    public final Function1 writeObserver;

    public MutableSnapshot(long j, SnapshotIdSet snapshotIdSet, Function1 function1, Function1 function2) {
        super(j, snapshotIdSet);
        this.readObserver = function1;
        this.writeObserver = function2;
        this.previousIds = SnapshotIdSet.EMPTY;
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    public final void advance$runtime() {
        long j;
        recordPrevious$runtime(getSnapshotId());
        Unit unit = Unit.INSTANCE;
        if (this.applied || this.disposed) {
            return;
        }
        long snapshotId = getSnapshotId();
        synchronized (SnapshotKt.lock) {
            long j2 = SnapshotKt.nextSnapshotId;
            j = 1;
            SnapshotKt.nextSnapshotId = j2 + j;
            setSnapshotId$runtime(j2);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getSnapshotId());
        }
        setInvalid$runtime(SnapshotKt.addRange(getInvalid$runtime(), snapshotId + j, getSnapshotId()));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x014d A[EDGE_INSN: B:102:0x014d->B:77:0x014d BREAK  A[LOOP:4: B:66:0x011e->B:76:0x014a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0109 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x010b A[Catch: all -> 0x0100, LOOP:2: B:48:0x00d8->B:60:0x010b, LOOP_END, TryCatch #0 {all -> 0x0100, blocks: (B:43:0x00bc, B:45:0x00cc, B:48:0x00d8, B:50:0x00e4, B:52:0x00ee, B:54:0x00f4, B:57:0x0103, B:63:0x0114, B:66:0x011e, B:68:0x0128, B:70:0x0132, B:72:0x0138, B:73:0x0142, B:76:0x014a, B:77:0x014d, B:79:0x0151, B:81:0x0158, B:82:0x0164, B:60:0x010b), top: B:90:0x00bc }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x014a A[Catch: all -> 0x0100, LOOP:4: B:66:0x011e->B:76:0x014a, LOOP_END, TryCatch #0 {all -> 0x0100, blocks: (B:43:0x00bc, B:45:0x00cc, B:48:0x00d8, B:50:0x00e4, B:52:0x00ee, B:54:0x00f4, B:57:0x0103, B:63:0x0114, B:66:0x011e, B:68:0x0128, B:70:0x0132, B:72:0x0138, B:73:0x0142, B:76:0x014a, B:77:0x014d, B:79:0x0151, B:81:0x0158, B:82:0x0164, B:60:0x010b), top: B:90:0x00bc }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0112 A[EDGE_INSN: B:97:0x0112->B:62:0x0112 BREAK  A[LOOP:2: B:48:0x00d8->B:60:0x010b], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.Collection, java.util.List] */
    public SnapshotId_jvmKt apply() {
        HashMap mapAccess$optimisticMerges;
        ?? r3;
        MutableScatterSet mutableScatterSet;
        long j;
        long j2;
        MutableScatterSet modified$runtime = getModified$runtime();
        if (modified$runtime != null) {
            long j3 = SnapshotKt.globalSnapshot.snapshotId;
            mapAccess$optimisticMerges = SnapshotKt.access$optimisticMerges(j3, this, SnapshotKt.openSnapshots.clear(j3));
        } else {
            mapAccess$optimisticMerges = null;
        }
        EmptyList emptyList = EmptyList.INSTANCE;
        synchronized (SnapshotKt.lock) {
            try {
                SnapshotKt.access$validateOpen(this);
                if (modified$runtime == null || modified$runtime._size == 0) {
                    closeLocked$runtime();
                    GlobalSnapshot globalSnapshot = SnapshotKt.globalSnapshot;
                    MutableScatterSet mutableScatterSet2 = globalSnapshot.modified;
                    SnapshotKt.resetGlobalSnapshotLocked(globalSnapshot, SnapshotKt.emptyLambda);
                    if (mutableScatterSet2 == null || !mutableScatterSet2.isNotEmpty()) {
                        r3 = emptyList;
                        mutableScatterSet = null;
                    } else {
                        r3 = SnapshotKt.applyObservers;
                        mutableScatterSet = mutableScatterSet2;
                    }
                } else {
                    GlobalSnapshot globalSnapshot2 = SnapshotKt.globalSnapshot;
                    SnapshotId_jvmKt snapshotId_jvmKtInnerApplyLocked$runtime = innerApplyLocked$runtime(SnapshotKt.nextSnapshotId, modified$runtime, mapAccess$optimisticMerges, SnapshotKt.openSnapshots.clear(globalSnapshot2.snapshotId));
                    if (!snapshotId_jvmKtInnerApplyLocked$runtime.equals(SnapshotApplyResult$Success.INSTANCE)) {
                        return snapshotId_jvmKtInnerApplyLocked$runtime;
                    }
                    closeLocked$runtime();
                    mutableScatterSet = globalSnapshot2.modified;
                    SnapshotKt.resetGlobalSnapshotLocked(globalSnapshot2, SnapshotKt.emptyLambda);
                    setModified$runtime(null);
                    globalSnapshot2.modified = null;
                    r3 = SnapshotKt.applyObservers;
                }
                Unit unit = Unit.INSTANCE;
                this.applied = true;
                if (mutableScatterSet != null) {
                    ScatterSetWrapper scatterSetWrapper = new ScatterSetWrapper(mutableScatterSet);
                    if (!mutableScatterSet.isEmpty()) {
                        int size = r3.size();
                        for (int i = 0; i < size; i++) {
                            ((Function2) r3.get(i)).invoke(scatterSetWrapper, this);
                        }
                    }
                }
                if (modified$runtime != null && modified$runtime.isNotEmpty()) {
                    ScatterSetWrapper scatterSetWrapper2 = new ScatterSetWrapper(modified$runtime);
                    int size2 = r3.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((Function2) r3.get(i2)).invoke(scatterSetWrapper2, this);
                    }
                }
                synchronized (SnapshotKt.lock) {
                    try {
                        releasePinnedSnapshotsForCloseLocked$runtime();
                        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                        if (mutableScatterSet != null) {
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr = mutableScatterSet.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                j = 128;
                                while (true) {
                                    long j4 = jArr[i3];
                                    j2 = 255;
                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i3 != length) {
                                            break;
                                            break;
                                        }
                                        i3++;
                                    } else {
                                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if ((j4 & 255) < 128) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr[(i3 << 3) + i5]);
                                            }
                                            j4 >>= 8;
                                        }
                                        if (i4 != 8) {
                                            break;
                                        }
                                        if (i3 != length) {
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                            } else {
                                j = 128;
                                j2 = 255;
                            }
                        } else {
                            j = 128;
                            j2 = 255;
                        }
                        if (modified$runtime != null) {
                            Object[] objArr2 = modified$runtime.elements;
                            long[] jArr2 = modified$runtime.metadata;
                            int length2 = jArr2.length - 2;
                            if (length2 >= 0) {
                                int i6 = 0;
                                while (true) {
                                    long j5 = jArr2[i6];
                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i6 != length2) {
                                            break;
                                            break;
                                        }
                                        i6++;
                                    } else {
                                        int i7 = 8 - ((~(i6 - length2)) >>> 31);
                                        for (int i8 = 0; i8 < i7; i8++) {
                                            if ((j5 & j2) < j) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr2[(i6 << 3) + i8]);
                                            }
                                            j5 >>= 8;
                                        }
                                        if (i7 != 8) {
                                            break;
                                        }
                                        if (i6 != length2) {
                                            break;
                                        }
                                        i6++;
                                    }
                                }
                            }
                        }
                        ArrayList arrayList = this.merged;
                        if (arrayList != null) {
                            int size3 = arrayList.size();
                            for (int i9 = 0; i9 < size3; i9++) {
                                SnapshotKt.processForUnusedRecordsLocked((StateObject) arrayList.get(i9));
                            }
                        }
                        this.merged = null;
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return SnapshotApplyResult$Success.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void closeLocked$runtime() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getSnapshotId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (this.disposed) {
            return;
        }
        super.dispose();
        nestedDeactivated$runtime();
    }

    public MutableScatterSet getModified$runtime() {
        return this.modified;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: getReadObserver$runtime, reason: merged with bridge method [inline-methods] */
    public Function1 getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getWriteCount$runtime() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1 getWriteObserver$runtime() {
        return this.writeObserver;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0173  */
    /* JADX WARN: Code duplicated, block: B:69:0x017d  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ab A[LOOP:3: B:79:0x01a9->B:80:0x01ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:84:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final SnapshotId_jvmKt innerApplyLocked$runtime(long j, MutableScatterSet mutableScatterSet, HashMap map, SnapshotIdSet snapshotIdSet) {
        ArrayList arrayList;
        ArrayList arrayListPlus;
        ArrayList arrayList2;
        int size;
        int i;
        ArrayList arrayList3;
        int size2;
        int i2;
        StateObject stateObject;
        StateRecord stateRecord;
        SnapshotIdSet snapshotIdSet2;
        Object[] objArr;
        long[] jArr;
        SnapshotIdSet snapshotIdSet3;
        Object[] objArr2;
        long[] jArr2;
        int i3;
        long j2;
        ArrayList arrayList4;
        StateRecord stateRecordMergeRecords;
        SnapshotIdSet snapshotIdSetOr = getInvalid$runtime().set(getSnapshotId()).or(this.previousIds);
        Object[] objArr3 = mutableScatterSet.elements;
        long[] jArr3 = mutableScatterSet.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i4 = 0;
            arrayList2 = null;
            arrayListPlus = null;
            while (true) {
                long j3 = jArr3[i4];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j3 & 255) < 128) {
                            objArr2 = objArr3;
                            StateObject stateObject2 = (StateObject) objArr3[(i4 << 3) + i6];
                            jArr2 = jArr3;
                            StateRecord firstStateRecord = stateObject2.getFirstStateRecord();
                            i3 = i6;
                            ArrayList arrayList5 = arrayList2;
                            StateRecord stateRecord2 = SnapshotKt.readable(firstStateRecord, j, snapshotIdSet);
                            if (stateRecord2 == null) {
                                snapshotIdSet3 = snapshotIdSetOr;
                                arrayList4 = arrayListPlus;
                                j2 = j3;
                            } else {
                                arrayList4 = arrayListPlus;
                                j2 = j3;
                                StateRecord stateRecord3 = SnapshotKt.readable(firstStateRecord, getSnapshotId(), snapshotIdSetOr);
                                if (stateRecord3 == null) {
                                    snapshotIdSet3 = snapshotIdSetOr;
                                } else {
                                    snapshotIdSet3 = snapshotIdSetOr;
                                    if (stateRecord3.snapshotId != 1 && !stateRecord2.equals(stateRecord3)) {
                                        StateRecord stateRecord4 = SnapshotKt.readable(firstStateRecord, getSnapshotId(), getInvalid$runtime());
                                        if (stateRecord4 == null) {
                                            SnapshotKt.readError();
                                            throw null;
                                        }
                                        if (map == null || (stateRecordMergeRecords = (StateRecord) map.get(stateRecord2)) == null) {
                                            stateRecordMergeRecords = stateObject2.mergeRecords(stateRecord3, stateRecord2, stateRecord4);
                                        }
                                        if (stateRecordMergeRecords == null) {
                                            return new SnapshotApplyResult$Failure(this);
                                        }
                                        if (!stateRecordMergeRecords.equals(stateRecord4)) {
                                            if (stateRecordMergeRecords.equals(stateRecord2)) {
                                                ArrayList arrayList6 = arrayList5 == null ? new ArrayList() : arrayList5;
                                                arrayList6.add(new Pair(stateObject2, stateRecord2.create(getSnapshotId())));
                                                arrayListPlus = arrayList4 == null ? new ArrayList() : arrayList4;
                                                arrayListPlus.add(stateObject2);
                                                arrayList2 = arrayList6;
                                            } else {
                                                arrayList2 = arrayList5 == null ? new ArrayList() : arrayList5;
                                                arrayList2.add(!stateRecordMergeRecords.equals(stateRecord3) ? new Pair(stateObject2, stateRecordMergeRecords) : new Pair(stateObject2, stateRecord3.create(getSnapshotId())));
                                            }
                                        }
                                        arrayListPlus = arrayList4;
                                    }
                                }
                            }
                            arrayList2 = arrayList5;
                            arrayListPlus = arrayList4;
                        } else {
                            snapshotIdSet3 = snapshotIdSetOr;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i3 = i6;
                            j2 = j3;
                        }
                        j3 = j2 >> 8;
                        i6 = i3 + 1;
                        jArr3 = jArr2;
                        objArr3 = objArr2;
                        snapshotIdSetOr = snapshotIdSet3;
                    }
                    snapshotIdSet2 = snapshotIdSetOr;
                    objArr = objArr3;
                    jArr = jArr3;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    snapshotIdSet2 = snapshotIdSetOr;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                if (i4 != length) {
                    i4++;
                    jArr3 = jArr;
                    objArr3 = objArr;
                    snapshotIdSetOr = snapshotIdSet2;
                } else {
                    arrayList = arrayList2;
                }
            }
            if (arrayList2 != null) {
                advance$runtime();
                size2 = arrayList2.size();
                for (i2 = 0; i2 < size2; i2++) {
                    Pair pair = (Pair) arrayList2.get(i2);
                    stateObject = (StateObject) pair.first;
                    stateRecord = (StateRecord) pair.second;
                    stateRecord.snapshotId = j;
                    synchronized (SnapshotKt.lock) {
                        stateRecord.next = stateObject.getFirstStateRecord();
                        stateObject.prependStateRecord(stateRecord);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            if (arrayListPlus != null) {
                size = arrayListPlus.size();
                for (i = 0; i < size; i++) {
                    mutableScatterSet.remove((StateObject) arrayListPlus.get(i));
                }
                arrayList3 = this.merged;
                if (arrayList3 != null) {
                    arrayListPlus = CollectionsKt.plus((Collection) arrayList3, (List) arrayListPlus);
                }
                this.merged = arrayListPlus;
            }
            return SnapshotApplyResult$Success.INSTANCE;
        }
        arrayList = null;
        arrayListPlus = null;
        arrayList2 = arrayList;
        if (arrayList2 != null) {
            advance$runtime();
            size2 = arrayList2.size();
            while (i2 < size2) {
                Pair pair2 = (Pair) arrayList2.get(i2);
                stateObject = (StateObject) pair2.first;
                stateRecord = (StateRecord) pair2.second;
                stateRecord.snapshotId = j;
                synchronized (SnapshotKt.lock) {
                    stateRecord.next = stateObject.getFirstStateRecord();
                    stateObject.prependStateRecord(stateRecord);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
        if (arrayListPlus != null) {
            size = arrayListPlus.size();
            while (i < size) {
                mutableScatterSet.remove((StateObject) arrayListPlus.get(i));
            }
            arrayList3 = this.merged;
            if (arrayList3 != null) {
                arrayListPlus = CollectionsKt.plus((Collection) arrayList3, (List) arrayListPlus);
            }
            this.merged = arrayListPlus;
        }
        return SnapshotApplyResult$Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedActivated$runtime() {
        this.snapshots++;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008e A[LOOP:0: B:18:0x0039->B:35:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x0091 A[EDGE_INSN: B:39:0x0091->B:36:0x0091 BREAK  A[LOOP:0: B:18:0x0039->B:35:0x008e], SYNTHETIC] */
    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedDeactivated$runtime() {
        if (this.snapshots <= 0) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i != 0 || this.applied) {
            return;
        }
        MutableScatterSet modified$runtime = getModified$runtime();
        if (modified$runtime != null) {
            if (this.applied) {
                PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
            }
            setModified$runtime(null);
            long snapshotId = getSnapshotId();
            Object[] objArr = modified$runtime.elements;
            long[] jArr = modified$runtime.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i2 != length) {
                            break;
                            break;
                        }
                        i2++;
                    } else {
                        int i3 = 8 - ((~(i2 - length)) >>> 31);
                        for (int i4 = 0; i4 < i3; i4++) {
                            if ((255 & j) < 128) {
                                for (StateRecord firstStateRecord = ((StateObject) objArr[(i2 << 3) + i4]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.next) {
                                    long j2 = firstStateRecord.snapshotId;
                                    if (j2 == snapshotId || CollectionsKt.contains(this.previousIds, Long.valueOf(j2))) {
                                        SaversKt$$ExternalSyntheticLambda10 saversKt$$ExternalSyntheticLambda10 = SnapshotKt.emptyLambda;
                                        firstStateRecord.snapshotId = 0L;
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i3 != 8) {
                            break;
                        } else if (i2 != length) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        closeAndReleasePinning$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime() {
        if (this.applied || this.disposed) {
            return;
        }
        advance$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void recordModified$runtime(StateObject stateObject) {
        MutableScatterSet modified$runtime = getModified$runtime();
        if (modified$runtime == null) {
            MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
            modified$runtime = new MutableScatterSet();
            setModified$runtime(modified$runtime);
        }
        modified$runtime.add(stateObject);
    }

    public final void recordPrevious$runtime(long j) {
        synchronized (SnapshotKt.lock) {
            this.previousIds = this.previousIds.set(j);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.lock) {
            this.previousIds = this.previousIds.or(snapshotIdSet);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void releasePinnedSnapshotsForCloseLocked$runtime() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
        releasePinnedSnapshotLocked$runtime();
    }

    public void setModified$runtime(MutableScatterSet mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime(int i) {
        this.writeCount = i;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1 function1, Function1 function2) throws Throwable {
        if (this.disposed) {
            PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        }
        if (this.applied && this.pinningTrackingHandle < 0) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
        }
        recordPrevious$runtime(getSnapshotId());
        Object obj = SnapshotKt.lock;
        synchronized (obj) {
            try {
                long j = SnapshotKt.nextSnapshotId;
                long j2 = 1;
                SnapshotKt.nextSnapshotId = j + j2;
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(j);
                SnapshotIdSet invalid$runtime = getInvalid$runtime();
                setInvalid$runtime(invalid$runtime.set(j));
                try {
                    NestedMutableSnapshot nestedMutableSnapshot = new NestedMutableSnapshot(j, SnapshotKt.addRange(invalid$runtime, getSnapshotId() + j2, j), SnapshotKt.mergedReadObserver(function1, getReadObserver(), true), SnapshotKt.mergedWriteObserver(function2, getWriteObserver$runtime()), this);
                    if (this.applied || this.disposed) {
                        return nestedMutableSnapshot;
                    }
                    long snapshotId = getSnapshotId();
                    synchronized (obj) {
                        long j3 = SnapshotKt.nextSnapshotId;
                        SnapshotKt.nextSnapshotId = j3 + j2;
                        setSnapshotId$runtime(j3);
                        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getSnapshotId());
                        Unit unit = Unit.INSTANCE;
                    }
                    setInvalid$runtime(SnapshotKt.addRange(getInvalid$runtime(), snapshotId + j2, getSnapshotId()));
                    return nestedMutableSnapshot;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1 function1) throws Throwable {
        if (this.disposed) {
            PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        }
        if (this.applied && this.pinningTrackingHandle < 0) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
        }
        long snapshotId = getSnapshotId();
        recordPrevious$runtime(getSnapshotId());
        Object obj = SnapshotKt.lock;
        synchronized (obj) {
            try {
                long j = SnapshotKt.nextSnapshotId;
                long j2 = 1;
                SnapshotKt.nextSnapshotId = j + j2;
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(j);
                try {
                    NestedReadonlySnapshot nestedReadonlySnapshot = new NestedReadonlySnapshot(j, SnapshotKt.addRange(getInvalid$runtime(), snapshotId + j2, j), SnapshotKt.mergedReadObserver(function1, getReadObserver(), true), this);
                    if (this.applied || this.disposed) {
                        return nestedReadonlySnapshot;
                    }
                    long snapshotId2 = getSnapshotId();
                    synchronized (obj) {
                        long j3 = SnapshotKt.nextSnapshotId;
                        SnapshotKt.nextSnapshotId = j3 + j2;
                        setSnapshotId$runtime(j3);
                        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getSnapshotId());
                        Unit unit = Unit.INSTANCE;
                    }
                    setInvalid$runtime(SnapshotKt.addRange(getInvalid$runtime(), snapshotId2 + j2, getSnapshotId()));
                    return nestedReadonlySnapshot;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
