package androidx.compose.runtime.snapshots;

import androidx.camera.core.internal.SupportedOutputSizesSorter;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.WeakReference;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.core.view.MenuHostHelper;
import androidx.room.RoomOpenHelper;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SnapshotKt {
    public static Object applyObservers;
    public static final RoomOpenHelper extraStateObjects;
    public static final GlobalSnapshot globalSnapshot;
    public static Object globalWriteObservers;
    public static long nextSnapshotId;
    public static SnapshotIdSet openSnapshots;
    public static final AtomicInt pendingApplyObserverCount;
    public static final SupportedOutputSizesSorter pinningTable;
    public static final SaversKt$$ExternalSyntheticLambda10 emptyLambda = new SaversKt$$ExternalSyntheticLambda10(23);
    public static final MenuHostHelper threadSnapshot = new MenuHostHelper(18);
    public static final Object lock = new Object();

    /* JADX WARN: Type inference failed for: r5v1, types: [int[], java.io.Serializable] */
    static {
        SnapshotIdSet snapshotIdSet = SnapshotIdSet.EMPTY;
        openSnapshots = snapshotIdSet;
        long j = 1;
        nextSnapshotId = j + j;
        SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter();
        supportedOutputSizesSorter.mCameraInfoInternal = new long[16];
        supportedOutputSizesSorter.mFullFovRatio = new int[16];
        int[] iArr = new int[16];
        int i = 0;
        while (i < 16) {
            int i2 = i + 1;
            iArr[i] = i2;
            i = i2;
        }
        supportedOutputSizesSorter.mSupportedOutputSizesSorterLegacy = iArr;
        pinningTable = supportedOutputSizesSorter;
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper((char) 0, 5);
        roomOpenHelper.mConfiguration = new int[16];
        roomOpenHelper.mDelegate = new WeakReference[16];
        extraStateObjects = roomOpenHelper;
        EmptyList emptyList = EmptyList.INSTANCE;
        applyObservers = emptyList;
        globalWriteObservers = emptyList;
        long j2 = nextSnapshotId;
        nextSnapshotId = j + j2;
        GlobalSnapshot globalSnapshot2 = new GlobalSnapshot(j2, snapshotIdSet, null, new SaversKt$$ExternalSyntheticLambda10(22));
        openSnapshots = openSnapshots.set(globalSnapshot2.snapshotId);
        globalSnapshot = globalSnapshot2;
        pendingApplyObserverCount = new AtomicInt(0);
    }

    public static final HashMap access$optimisticMerges(long j, MutableSnapshot mutableSnapshot, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        SnapshotIdSet snapshotIdSet2;
        long[] jArr2;
        int i;
        int i2;
        StateRecord stateRecord;
        MutableScatterSet modified$runtime = mutableSnapshot.getModified$runtime();
        if (modified$runtime != null) {
            long snapshotId = mutableSnapshot.getSnapshotId();
            SnapshotIdSet snapshotIdSetOr = mutableSnapshot.getInvalid$runtime().set(snapshotId).or(mutableSnapshot.previousIds);
            Object[] objArr = modified$runtime.elements;
            long[] jArr3 = modified$runtime.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i3 = 0;
                HashMap map = null;
                while (true) {
                    long j2 = jArr3[i3];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i4 = 8;
                        int i5 = 8 - ((~(i3 - length)) >>> 31);
                        int i6 = 0;
                        while (i6 < i5) {
                            if ((j2 & 255) < 128) {
                                StateObject stateObject = (StateObject) objArr[(i3 << 3) + i6];
                                StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                                jArr2 = jArr3;
                                i = i4;
                                i2 = i6;
                                StateRecord stateRecord2 = readable(firstStateRecord, j, snapshotIdSet);
                                if (stateRecord2 != null && (stateRecord = readable(firstStateRecord, snapshotId, snapshotIdSetOr)) != null && !stateRecord2.equals(stateRecord)) {
                                    StateRecord stateRecord3 = readable(firstStateRecord, snapshotId, mutableSnapshot.getInvalid$runtime());
                                    if (stateRecord3 == null) {
                                        readError();
                                        throw null;
                                    }
                                    StateRecord stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                                    if (stateRecordMergeRecords == null) {
                                        return null;
                                    }
                                    if (map == null) {
                                        map = new HashMap();
                                    }
                                    map.put(stateRecord2, stateRecordMergeRecords);
                                    map = map;
                                }
                            } else {
                                jArr2 = jArr3;
                                i = i4;
                                i2 = i6;
                            }
                            j2 >>= i;
                            i6 = i2 + 1;
                            i4 = i;
                            jArr3 = jArr2;
                            snapshotIdSetOr = snapshotIdSetOr;
                        }
                        jArr = jArr3;
                        snapshotIdSet2 = snapshotIdSetOr;
                        if (i5 != i4) {
                            return map;
                        }
                    } else {
                        jArr = jArr3;
                        snapshotIdSet2 = snapshotIdSetOr;
                    }
                    if (i3 == length) {
                        return map;
                    }
                    i3++;
                    jArr3 = jArr;
                    snapshotIdSetOr = snapshotIdSet2;
                }
            }
        }
        return null;
    }

    public static final void access$validateOpen(Snapshot snapshot) {
        long j;
        if (openSnapshots.get(snapshot.getSnapshotId())) {
            return;
        }
        StringBuilder sb = new StringBuilder("Snapshot is not open: snapshotId=");
        sb.append(snapshot.getSnapshotId());
        sb.append(", disposed=");
        sb.append(snapshot.disposed);
        sb.append(", applied=");
        MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
        sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.applied) : "read-only");
        sb.append(", lowestPin=");
        synchronized (lock) {
            SupportedOutputSizesSorter supportedOutputSizesSorter = pinningTable;
            j = supportedOutputSizesSorter.mSensorOrientation > 0 ? ((long[]) supportedOutputSizesSorter.mCameraInfoInternal)[0] : -1L;
        }
        sb.append(j);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, long j, long j2) {
        while (Intrinsics.compare(j, j2) < 0) {
            snapshotIdSet = snapshotIdSet.set(j);
            j += (long) 1;
        }
        return snapshotIdSet;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0090 A[Catch: all -> 0x0086, LOOP:1: B:30:0x0056->B:42:0x0090, LOOP_END, TryCatch #1 {all -> 0x0086, blocks: (B:25:0x0047, B:27:0x004c, B:30:0x0056, B:32:0x0066, B:34:0x0072, B:36:0x007b, B:39:0x0088, B:42:0x0090, B:43:0x0093), top: B:52:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0093 A[EDGE_INSN: B:58:0x0093->B:43:0x0093 BREAK  A[LOOP:1: B:30:0x0056->B:42:0x0090], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public static final Object advanceGlobalSnapshot(Function1 function1) {
        MutableScatterSet mutableScatterSet;
        Object objResetGlobalSnapshotLocked;
        GlobalSnapshot globalSnapshot2 = globalSnapshot;
        synchronized (lock) {
            try {
                mutableScatterSet = globalSnapshot2.modified;
                if (mutableScatterSet != null) {
                    pendingApplyObserverCount.addAndGet(1);
                }
                objResetGlobalSnapshotLocked = resetGlobalSnapshotLocked(globalSnapshot2, function1);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (mutableScatterSet != null) {
            try {
                ?? r4 = applyObservers;
                ScatterSetWrapper scatterSetWrapper = new ScatterSetWrapper(mutableScatterSet);
                int size = r4.size();
                for (int i = 0; i < size; i++) {
                    ((Function2) r4.get(i)).invoke(scatterSetWrapper, globalSnapshot2);
                }
                pendingApplyObserverCount.addAndGet(-1);
            } catch (Throwable th2) {
                pendingApplyObserverCount.addAndGet(-1);
                throw th2;
            }
        }
        synchronized (lock) {
            try {
                checkAndOverwriteUnusedRecordsLocked();
                if (mutableScatterSet != null) {
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
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
                                        processForUnusedRecordsLocked((StateObject) objArr[(i2 << 3) + i4]);
                                    }
                                    j >>= 8;
                                }
                                if (i3 != 8) {
                                    break;
                                }
                                if (i2 != length) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return objResetGlobalSnapshotLocked;
    }

    public static final void checkAndOverwriteUnusedRecordsLocked() {
        RoomOpenHelper roomOpenHelper = extraStateObjects;
        int i = roomOpenHelper.version;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            WeakReference weakReference = ((WeakReference[]) roomOpenHelper.mDelegate)[i2];
            Object obj = weakReference != null ? weakReference.get() : null;
            if (obj != null && overwriteUnusedRecordsLocked((StateObject) obj)) {
                if (i3 != i2) {
                    ((WeakReference[]) roomOpenHelper.mDelegate)[i3] = weakReference;
                    int[] iArr = (int[]) roomOpenHelper.mConfiguration;
                    iArr[i3] = iArr[i2];
                }
                i3++;
            }
            i2++;
        }
        for (int i4 = i3; i4 < i; i4++) {
            ((WeakReference[]) roomOpenHelper.mDelegate)[i4] = null;
            ((int[]) roomOpenHelper.mConfiguration)[i4] = 0;
        }
        if (i3 != i) {
            roomOpenHelper.version = i3;
        }
    }

    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1 function1, boolean z) {
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (z2 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z2 ? (MutableSnapshot) snapshot : null, function1, null, false, z);
        }
        return new TransparentObserverSnapshot(snapshot, function1, false, z);
    }

    public static final StateRecord current(StateRecord stateRecord) {
        StateRecord stateRecord2;
        Snapshot snapshotCurrentSnapshot = currentSnapshot();
        StateRecord stateRecord3 = readable(stateRecord, snapshotCurrentSnapshot.getSnapshotId(), snapshotCurrentSnapshot.getInvalid$runtime());
        if (stateRecord3 != null) {
            return stateRecord3;
        }
        synchronized (lock) {
            Snapshot snapshotCurrentSnapshot2 = currentSnapshot();
            stateRecord2 = readable(stateRecord, snapshotCurrentSnapshot2.getSnapshotId(), snapshotCurrentSnapshot2.getInvalid$runtime());
        }
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        readError();
        throw null;
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = (Snapshot) threadSnapshot.get();
        return snapshot == null ? globalSnapshot : snapshot;
    }

    public static final Function1 mergedReadObserver(Function1 function1, Function1 function2, boolean z) {
        if (!z) {
            function2 = null;
        }
        if (function1 == null || function2 == null || function1 == function2) {
            return function1 == null ? function2 : function1;
        }
        return new SnapshotKt$$ExternalSyntheticLambda0(function1, function2, 0);
    }

    public static final Function1 mergedWriteObserver(Function1 function1, Function1 function2) {
        if (function1 == null || function2 == null || function1 == function2) {
            return function1 == null ? function2 : function1;
        }
        return new SnapshotKt$$ExternalSyntheticLambda0(function1, function2, 1);
    }

    public static final StateRecord newOverwritableRecordLocked(StateRecord stateRecord, StateObject stateObject) {
        long j = nextSnapshotId;
        SupportedOutputSizesSorter supportedOutputSizesSorter = pinningTable;
        if (supportedOutputSizesSorter.mSensorOrientation > 0) {
            j = ((long[]) supportedOutputSizesSorter.mCameraInfoInternal)[0];
        }
        long j2 = j - ((long) 1);
        StateRecord stateRecord2 = null;
        StateRecord stateRecord3 = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.next) {
            long j3 = firstStateRecord.snapshotId;
            if (j3 != 0) {
                if (j3 != 0 && Intrinsics.compare(j3, j2) <= 0 && !SnapshotIdSet.EMPTY.get(j3)) {
                    if (stateRecord3 != null) {
                        if (Intrinsics.compare(firstStateRecord.snapshotId, stateRecord3.snapshotId) >= 0) {
                            stateRecord2 = stateRecord3;
                            break;
                        }
                        break;
                    }
                    stateRecord3 = firstStateRecord;
                }
            }
            stateRecord2 = firstStateRecord;
            break;
        }
        if (stateRecord2 != null) {
            stateRecord2.snapshotId = Long.MAX_VALUE;
            return stateRecord2;
        }
        StateRecord stateRecordCreate = stateRecord.create(Long.MAX_VALUE);
        stateRecordCreate.next = stateObject.getFirstStateRecord();
        stateObject.prependStateRecord(stateRecordCreate);
        return stateRecordCreate;
    }

    public static final StateRecord newWritableRecord(StateRecord stateRecord, DerivedSnapshotState derivedSnapshotState, Snapshot snapshot) {
        StateRecord stateRecordNewOverwritableRecordLocked;
        synchronized (lock) {
            stateRecordNewOverwritableRecordLocked = newOverwritableRecordLocked(stateRecord, derivedSnapshotState);
            stateRecordNewOverwritableRecordLocked.assign(stateRecord);
            stateRecordNewOverwritableRecordLocked.snapshotId = snapshot.getSnapshotId();
        }
        return stateRecordNewOverwritableRecordLocked;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        snapshot.setWriteCount$runtime(snapshot.getWriteCount$runtime() + 1);
        Function1 writeObserver$runtime = snapshot.getWriteObserver$runtime();
        if (writeObserver$runtime != null) {
            writeObserver$runtime.invoke(stateObject);
        }
    }

    public static final StateRecord overwritableRecord(StateRecord stateRecord, StateObjectImpl stateObjectImpl, Snapshot snapshot, StateRecord stateRecord2) {
        StateRecord stateRecordNewOverwritableRecordLocked;
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime(stateObjectImpl);
        }
        long snapshotId = snapshot.getSnapshotId();
        if (stateRecord2.snapshotId == snapshotId) {
            return stateRecord2;
        }
        synchronized (lock) {
            stateRecordNewOverwritableRecordLocked = newOverwritableRecordLocked(stateRecord, stateObjectImpl);
        }
        stateRecordNewOverwritableRecordLocked.snapshotId = snapshotId;
        if (stateRecord2.snapshotId != 1) {
            snapshot.recordModified$runtime(stateObjectImpl);
        }
        return stateRecordNewOverwritableRecordLocked;
    }

    public static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        long j = nextSnapshotId;
        SupportedOutputSizesSorter supportedOutputSizesSorter = pinningTable;
        if (supportedOutputSizesSorter.mSensorOrientation > 0) {
            j = ((long[]) supportedOutputSizesSorter.mCameraInfoInternal)[0];
        }
        StateRecord stateRecord2 = null;
        StateRecord firstStateRecord = null;
        int i = 0;
        for (StateRecord firstStateRecord2 = stateObject.getFirstStateRecord(); firstStateRecord2 != null; firstStateRecord2 = firstStateRecord2.next) {
            long j2 = firstStateRecord2.snapshotId;
            if (j2 != 0) {
                if (Intrinsics.compare(j2, j) >= 0) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord2;
                } else {
                    if (Intrinsics.compare(firstStateRecord2.snapshotId, stateRecord2.snapshotId) < 0) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord2;
                    } else {
                        stateRecord = firstStateRecord2;
                    }
                    if (firstStateRecord == null) {
                        firstStateRecord = stateObject.getFirstStateRecord();
                        StateRecord stateRecord3 = firstStateRecord;
                        while (true) {
                            if (firstStateRecord == null) {
                                firstStateRecord = stateRecord3;
                                break;
                            }
                            if (Intrinsics.compare(firstStateRecord.snapshotId, j) >= 0) {
                                break;
                            }
                            if (Intrinsics.compare(stateRecord3.snapshotId, firstStateRecord.snapshotId) < 0) {
                                stateRecord3 = firstStateRecord;
                            }
                            firstStateRecord = firstStateRecord.next;
                        }
                    }
                    stateRecord2.snapshotId = 0L;
                    stateRecord2.assign(firstStateRecord);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i > 1;
    }

    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            RoomOpenHelper roomOpenHelper = extraStateObjects;
            int i = roomOpenHelper.version;
            int iIdentityHashCode = System.identityHashCode(stateObject);
            int i2 = -1;
            if (i > 0) {
                int i3 = roomOpenHelper.version - 1;
                int i4 = 0;
                while (true) {
                    if (i4 > i3) {
                        i2 = -(i4 + 1);
                        break;
                    }
                    int i5 = (i4 + i3) >>> 1;
                    int i6 = ((int[]) roomOpenHelper.mConfiguration)[i5];
                    if (i6 < iIdentityHashCode) {
                        i4 = i5 + 1;
                    } else if (i6 > iIdentityHashCode) {
                        i3 = i5 - 1;
                    } else {
                        WeakReference weakReference = ((WeakReference[]) roomOpenHelper.mDelegate)[i5];
                        if (stateObject == (weakReference != null ? weakReference.get() : null)) {
                            i2 = i5;
                            break;
                        }
                        int i7 = i5 - 1;
                        while (true) {
                            if (-1 >= i7 || ((int[]) roomOpenHelper.mConfiguration)[i7] != iIdentityHashCode) {
                                i5++;
                                int i8 = roomOpenHelper.version;
                                while (true) {
                                    if (i5 >= i8) {
                                        i2 = -(roomOpenHelper.version + 1);
                                        break;
                                    }
                                    if (((int[]) roomOpenHelper.mConfiguration)[i5] != iIdentityHashCode) {
                                        i2 = -(i5 + 1);
                                        break;
                                    }
                                    WeakReference weakReference2 = ((WeakReference[]) roomOpenHelper.mDelegate)[i5];
                                    if ((weakReference2 != null ? weakReference2.get() : null) == stateObject) {
                                        i2 = i5;
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                WeakReference weakReference3 = ((WeakReference[]) roomOpenHelper.mDelegate)[i7];
                                if ((weakReference3 != null ? weakReference3.get() : null) == stateObject) {
                                    i2 = i7;
                                    break;
                                }
                                i7--;
                            }
                        }
                    }
                }
                if (i2 >= 0) {
                    return;
                }
            }
            int i9 = -(i2 + 1);
            WeakReference[] weakReferenceArr = (WeakReference[]) roomOpenHelper.mDelegate;
            int length = weakReferenceArr.length;
            if (i == length) {
                int i10 = length * 2;
                WeakReference[] weakReferenceArr2 = new WeakReference[i10];
                int[] iArr = new int[i10];
                int i11 = i9 + 1;
                System.arraycopy(weakReferenceArr, i9, weakReferenceArr2, i11, i - i9);
                System.arraycopy((WeakReference[]) roomOpenHelper.mDelegate, 0, weakReferenceArr2, 0, i9);
                ArraysKt.copyInto(i11, i9, i, (int[]) roomOpenHelper.mConfiguration, iArr);
                ArraysKt.copyInto$default(0, i9, 6, (int[]) roomOpenHelper.mConfiguration, iArr);
                roomOpenHelper.mDelegate = weakReferenceArr2;
                roomOpenHelper.mConfiguration = iArr;
            } else {
                int i12 = i9 + 1;
                System.arraycopy(weakReferenceArr, i9, weakReferenceArr, i12, i - i9);
                int[] iArr2 = (int[]) roomOpenHelper.mConfiguration;
                ArraysKt.copyInto(i12, i9, i, iArr2, iArr2);
            }
            ((WeakReference[]) roomOpenHelper.mDelegate)[i9] = new WeakReference(stateObject);
            ((int[]) roomOpenHelper.mConfiguration)[i9] = iIdentityHashCode;
            roomOpenHelper.version++;
        }
    }

    public static final void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final StateRecord readable(StateRecord stateRecord, StateObject stateObject) {
        StateRecord stateRecord2;
        Snapshot snapshotCurrentSnapshot = currentSnapshot();
        Function1 readObserver = snapshotCurrentSnapshot.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        StateRecord stateRecord3 = readable(stateRecord, snapshotCurrentSnapshot.getSnapshotId(), snapshotCurrentSnapshot.getInvalid$runtime());
        if (stateRecord3 != null) {
            return stateRecord3;
        }
        synchronized (lock) {
            Snapshot snapshotCurrentSnapshot2 = currentSnapshot();
            stateRecord2 = readable(stateObject.getFirstStateRecord(), snapshotCurrentSnapshot2.getSnapshotId(), snapshotCurrentSnapshot2.getInvalid$runtime());
            if (stateRecord2 == null) {
                readError();
                throw null;
            }
        }
        return stateRecord2;
    }

    public static final void releasePinningLocked(int i) {
        SupportedOutputSizesSorter supportedOutputSizesSorter = pinningTable;
        int i2 = ((int[]) supportedOutputSizesSorter.mSupportedOutputSizesSorterLegacy)[i];
        supportedOutputSizesSorter.swap(i2, supportedOutputSizesSorter.mSensorOrientation - 1);
        supportedOutputSizesSorter.mSensorOrientation--;
        long[] jArr = (long[]) supportedOutputSizesSorter.mCameraInfoInternal;
        long j = jArr[i2];
        int i3 = i2;
        while (i3 > 0) {
            int i4 = ((i3 + 1) >> 1) - 1;
            if (Intrinsics.compare(jArr[i4], j) <= 0) {
                break;
            }
            supportedOutputSizesSorter.swap(i4, i3);
            i3 = i4;
        }
        long[] jArr2 = (long[]) supportedOutputSizesSorter.mCameraInfoInternal;
        int i5 = supportedOutputSizesSorter.mSensorOrientation >> 1;
        while (i2 < i5) {
            int i6 = (i2 + 1) << 1;
            int i7 = i6 - 1;
            if (i6 < supportedOutputSizesSorter.mSensorOrientation && Intrinsics.compare(jArr2[i6], jArr2[i7]) < 0) {
                if (Intrinsics.compare(jArr2[i6], jArr2[i2]) >= 0) {
                    break;
                }
                supportedOutputSizesSorter.swap(i6, i2);
                i2 = i6;
            } else {
                if (Intrinsics.compare(jArr2[i7], jArr2[i2]) >= 0) {
                    break;
                }
                supportedOutputSizesSorter.swap(i7, i2);
                i2 = i7;
            }
        }
        ((int[]) supportedOutputSizesSorter.mSupportedOutputSizesSorterLegacy)[i] = supportedOutputSizesSorter.mLensFacing;
        supportedOutputSizesSorter.mLensFacing = i;
    }

    public static final Object resetGlobalSnapshotLocked(GlobalSnapshot globalSnapshot2, Function1 function1) {
        long j = globalSnapshot2.snapshotId;
        Object objInvoke = function1.invoke(openSnapshots.clear(j));
        long j2 = nextSnapshotId;
        nextSnapshotId = ((long) 1) + j2;
        SnapshotIdSet snapshotIdSetClear = openSnapshots.clear(j);
        openSnapshots = snapshotIdSetClear;
        globalSnapshot2.snapshotId = j2;
        globalSnapshot2.invalid = snapshotIdSetClear;
        globalSnapshot2.writeCount = 0;
        globalSnapshot2.modified = null;
        globalSnapshot2.releasePinnedSnapshotLocked$runtime();
        openSnapshots = openSnapshots.set(j2);
        return objInvoke;
    }

    public static final StateRecord writableRecord(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord stateRecord2;
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime(stateObject);
        }
        long snapshotId = snapshot.getSnapshotId();
        StateRecord stateRecord3 = readable(stateRecord, snapshotId, snapshot.getInvalid$runtime());
        if (stateRecord3 == null) {
            readError();
            throw null;
        }
        if (stateRecord3.snapshotId == snapshot.getSnapshotId()) {
            return stateRecord3;
        }
        synchronized (lock) {
            stateRecord2 = readable(stateObject.getFirstStateRecord(), snapshotId, snapshot.getInvalid$runtime());
            if (stateRecord2 == null) {
                readError();
                throw null;
            }
            if (stateRecord2.snapshotId != snapshotId) {
                StateRecord stateRecordNewOverwritableRecordLocked = newOverwritableRecordLocked(stateRecord2, stateObject);
                stateRecordNewOverwritableRecordLocked.assign(stateRecord2);
                stateRecordNewOverwritableRecordLocked.snapshotId = snapshot.getSnapshotId();
                stateRecord2 = stateRecordNewOverwritableRecordLocked;
            }
        }
        if (stateRecord3.snapshotId != 1) {
            snapshot.recordModified$runtime(stateObject);
        }
        return stateRecord2;
    }

    public static final StateRecord current(StateRecord stateRecord, Snapshot snapshot) {
        StateRecord stateRecord2;
        StateRecord stateRecord3 = readable(stateRecord, snapshot.getSnapshotId(), snapshot.getInvalid$runtime());
        if (stateRecord3 != null) {
            return stateRecord3;
        }
        synchronized (lock) {
            stateRecord2 = readable(stateRecord, snapshot.getSnapshotId(), snapshot.getInvalid$runtime());
        }
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        readError();
        throw null;
    }

    public static final StateRecord readable(StateRecord stateRecord, long j, SnapshotIdSet snapshotIdSet) {
        StateRecord stateRecord2 = null;
        while (stateRecord != null) {
            long j2 = stateRecord.snapshotId;
            if (j2 != 0 && Intrinsics.compare(j2, j) <= 0 && !snapshotIdSet.get(j2) && (stateRecord2 == null || Intrinsics.compare(stateRecord2.snapshotId, stateRecord.snapshotId) < 0)) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.next;
        }
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        return null;
    }
}
