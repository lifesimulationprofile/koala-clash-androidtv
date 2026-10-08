package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.core.view.MenuHostHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DerivedSnapshotState extends StateObjectImpl implements State {
    public final Function0 calculation;
    public ResultRecord first = new ResultRecord(SnapshotKt.currentSnapshot().getSnapshotId());
    public final SnapshotMutationPolicy policy;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ResultRecord extends StateRecord {
        public static final Object Unset = new Object();
        public MutableObjectIntMap dependencies;
        public Object result;
        public int resultHash;
        public long validSnapshotId;
        public int validSnapshotWriteCount;

        public ResultRecord(long j) {
            super(j);
            this.dependencies = ObjectIntMapKt.EmptyObjectIntMap;
            this.result = Unset;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord stateRecord) {
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            this.dependencies = resultRecord.dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create(long j) {
            return new ResultRecord(j);
        }

        public final boolean isValid(DerivedSnapshotState derivedSnapshotState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            Object obj = SnapshotKt.lock;
            synchronized (obj) {
                z = true;
                z2 = (this.validSnapshotId == snapshot.getSnapshotId() && this.validSnapshotWriteCount == snapshot.getWriteCount$runtime()) ? false : true;
            }
            if (this.result == Unset || (z2 && this.resultHash != readableHash(derivedSnapshotState, snapshot))) {
                z = false;
            }
            if (!z || !z2) {
                return z;
            }
            synchronized (obj) {
                this.validSnapshotId = snapshot.getSnapshotId();
                this.validSnapshotWriteCount = snapshot.getWriteCount$runtime();
                Unit unit = Unit.INSTANCE;
            }
            return z;
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00d9 A[DONT_INVERT, PHI: r10
          0x00d9: PHI (r10v14 int) = (r10v13 int), (r10v15 int) binds: [B:30:0x00aa, B:40:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:42:0x00db A[Catch: all -> 0x00cd, LOOP:3: B:29:0x009c->B:42:0x00db, LOOP_END, TryCatch #1 {all -> 0x00cd, blocks: (B:12:0x0024, B:15:0x0031, B:17:0x0040, B:19:0x004e, B:21:0x0058, B:49:0x011b, B:24:0x0075, B:26:0x0079, B:29:0x009c, B:31:0x00ac, B:33:0x00b6, B:35:0x00bc, B:38:0x00d0, B:46:0x00fb, B:42:0x00db, B:45:0x00eb, B:55:0x0140, B:59:0x0153), top: B:75:0x0024 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x015c A[DONT_GENERATE, LOOP:5: B:61:0x015a->B:62:0x015c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:83:0x00e8 A[EDGE_INSN: B:83:0x00e8->B:44:0x00e8 BREAK  A[LOOP:3: B:29:0x009c->B:42:0x00db], SYNTHETIC] */
        public final int readableHash(DerivedSnapshotState derivedSnapshotState, Snapshot snapshot) {
            MutableObjectIntMap mutableObjectIntMap;
            int iIdentityHashCode;
            long[] jArr;
            int i;
            Object[] objArr;
            int[] iArr;
            int[] iArr2;
            long j;
            int i2;
            StateRecord stateRecordCurrent;
            ResultRecord resultRecord;
            synchronized (SnapshotKt.lock) {
                mutableObjectIntMap = this.dependencies;
            }
            int i3 = 7;
            if (mutableObjectIntMap._size == 0) {
                return 7;
            }
            MutableVector mutableVectorDerivedStateObservers = Stack.derivedStateObservers();
            Object[] objArr2 = mutableVectorDerivedStateObservers.content;
            int i4 = mutableVectorDerivedStateObservers.size;
            for (int i5 = 0; i5 < i4; i5++) {
                ((GapComposer$derivedStateObserver$1) objArr2[i5]).start();
            }
            try {
                Object[] objArr3 = mutableObjectIntMap.keys;
                int[] iArr3 = mutableObjectIntMap.values;
                long[] jArr2 = mutableObjectIntMap.metadata;
                int length = jArr2.length - 2;
                if (length >= 0) {
                    iIdentityHashCode = 7;
                    int i6 = 0;
                    while (true) {
                        long j2 = jArr2[i6];
                        long j3 = -9187201950435737472L;
                        if ((((~j2) << i3) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i7 = 8;
                            int i8 = 8 - ((~(i6 - length)) >>> 31);
                            i = i3;
                            int i9 = 0;
                            while (i9 < i8) {
                                if ((j2 & 255) < 128) {
                                    int i10 = (i6 << 3) + i9;
                                    j = j3;
                                    int i11 = i7;
                                    StateObject stateObject = (StateObject) objArr3[i10];
                                    if (iArr3[i10] != 1) {
                                        jArr2 = jArr2;
                                        i9 = i9;
                                        objArr3 = objArr3;
                                        iArr2 = iArr3;
                                    } else {
                                        if (stateObject instanceof DerivedSnapshotState) {
                                            DerivedSnapshotState derivedSnapshotState2 = (DerivedSnapshotState) stateObject;
                                            ResultRecord resultRecordCurrentRecord = derivedSnapshotState2.currentRecord((ResultRecord) SnapshotKt.current(derivedSnapshotState2.first, snapshot), snapshot, false, derivedSnapshotState2.calculation);
                                            MutableObjectIntMap mutableObjectIntMap2 = resultRecordCurrentRecord.dependencies;
                                            Object[] objArr4 = mutableObjectIntMap2.keys;
                                            long[] jArr3 = mutableObjectIntMap2.metadata;
                                            int length2 = jArr3.length - 2;
                                            if (length2 >= 0) {
                                                int i12 = 0;
                                                while (true) {
                                                    long j4 = jArr3[i12];
                                                    iArr2 = iArr3;
                                                    resultRecord = resultRecordCurrentRecord;
                                                    if ((((~j4) << i) & j4 & j) == j) {
                                                        if (i12 != length2) {
                                                            break;
                                                            break;
                                                        }
                                                        i12++;
                                                        iArr3 = iArr2;
                                                        resultRecordCurrentRecord = resultRecord;
                                                        i11 = 8;
                                                    } else {
                                                        int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                                        for (int i14 = 0; i14 < i13; i14++) {
                                                            if ((j4 & 255) < 128) {
                                                                iIdentityHashCode = (iIdentityHashCode * 31) + System.identityHashCode((StateObject) objArr4[(i12 << 3) + i14]);
                                                            }
                                                            j4 >>= i11;
                                                        }
                                                        if (i13 != i11) {
                                                            break;
                                                        }
                                                        if (i12 != length2) {
                                                            break;
                                                        }
                                                        i12++;
                                                        iArr3 = iArr2;
                                                        resultRecordCurrentRecord = resultRecord;
                                                        i11 = 8;
                                                    }
                                                }
                                            } else {
                                                iArr2 = iArr3;
                                                resultRecord = resultRecordCurrentRecord;
                                            }
                                            stateRecordCurrent = resultRecord;
                                        } else {
                                            iArr2 = iArr3;
                                            stateRecordCurrent = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                                        }
                                        int iIdentityHashCode2 = ((iIdentityHashCode * 31) + System.identityHashCode(stateRecordCurrent)) * 31;
                                        long j5 = stateRecordCurrent.snapshotId;
                                        iIdentityHashCode = iIdentityHashCode2 + ((int) (j5 ^ (j5 >>> 32)));
                                    }
                                    i2 = 8;
                                } else {
                                    jArr2 = jArr2;
                                    i9 = i9;
                                    objArr3 = objArr3;
                                    iArr2 = iArr3;
                                    j = j3;
                                    i2 = i7;
                                }
                                j2 >>= i2;
                                i7 = i2;
                                jArr2 = jArr2;
                                j3 = j;
                                objArr3 = objArr3;
                                iArr3 = iArr2;
                                i9++;
                            }
                            jArr = jArr2;
                            objArr = objArr3;
                            iArr = iArr3;
                            if (i8 != i7) {
                                break;
                            }
                        } else {
                            jArr = jArr2;
                            i = i3;
                            objArr = objArr3;
                            iArr = iArr3;
                        }
                        if (i6 != length) {
                            i6++;
                            i3 = i;
                            jArr2 = jArr;
                            objArr3 = objArr;
                            iArr3 = iArr;
                        } else {
                            i3 = iIdentityHashCode;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    return iIdentityHashCode;
                }
                iIdentityHashCode = i3;
                Unit unit2 = Unit.INSTANCE;
                return iIdentityHashCode;
            } finally {
                Object[] objArr5 = mutableVectorDerivedStateObservers.content;
                int i15 = mutableVectorDerivedStateObservers.size;
                for (int i16 = 0; i16 < i15; i16++) {
                    ((GapComposer$derivedStateObserver$1) objArr5[i16]).done();
                }
            }
        }
    }

    public DerivedSnapshotState(Function0 function0, SnapshotMutationPolicy snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x009e A[Catch: all -> 0x0038, LOOP:1: B:16:0x0049->B:30:0x009e, LOOP_END, TryCatch #1 {all -> 0x0038, blocks: (B:8:0x0023, B:10:0x002f, B:13:0x003b, B:16:0x0049, B:18:0x005c, B:20:0x0068, B:22:0x0072, B:24:0x008a, B:26:0x0090, B:30:0x009e, B:31:0x00a3), top: B:86:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x00a3 A[EDGE_INSN: B:92:0x00a3->B:31:0x00a3 BREAK  A[LOOP:1: B:16:0x0049->B:30:0x009e], SYNTHETIC] */
    public final ResultRecord currentRecord(ResultRecord resultRecord, Snapshot snapshot, boolean z, Function0 function0) {
        ResultRecord resultRecord2;
        SnapshotMutationPolicy snapshotMutationPolicy;
        int i;
        if (resultRecord.isValid(this, snapshot)) {
            if (z) {
                MutableVector mutableVectorDerivedStateObservers = Stack.derivedStateObservers();
                Object[] objArr = mutableVectorDerivedStateObservers.content;
                int i2 = mutableVectorDerivedStateObservers.size;
                for (int i3 = 0; i3 < i2; i3++) {
                    ((GapComposer$derivedStateObserver$1) objArr[i3]).start();
                }
                try {
                    MutableObjectIntMap mutableObjectIntMap = resultRecord.dependencies;
                    MenuHostHelper menuHostHelper = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    IntRef intRef = (IntRef) menuHostHelper.get();
                    if (intRef == null) {
                        intRef = new IntRef();
                        menuHostHelper.set(intRef);
                    }
                    int i4 = intRef.element;
                    Object[] objArr2 = mutableObjectIntMap.keys;
                    int[] iArr = mutableObjectIntMap.values;
                    long[] jArr = mutableObjectIntMap.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j = jArr[i5];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i5 != length) {
                                    break;
                                    break;
                                }
                                i5++;
                            } else {
                                int i6 = 8;
                                int i7 = 8 - ((~(i5 - length)) >>> 31);
                                int i8 = 0;
                                while (i8 < i7) {
                                    if ((j & 255) < 128) {
                                        int i9 = (i5 << 3) + i8;
                                        i = i6;
                                        StateObject stateObject = (StateObject) objArr2[i9];
                                        intRef.element = i4 + iArr[i9];
                                        Function1 readObserver = snapshot.getReadObserver();
                                        if (readObserver != null) {
                                            readObserver.invoke(stateObject);
                                        }
                                    } else {
                                        i = i6;
                                    }
                                    j >>= i;
                                    i8++;
                                    i6 = i;
                                }
                                if (i7 != i6) {
                                    break;
                                }
                                if (i5 != length) {
                                    break;
                                }
                                i5++;
                            }
                        }
                    }
                    intRef.element = i4;
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Object[] objArr3 = mutableVectorDerivedStateObservers.content;
                    int i10 = mutableVectorDerivedStateObservers.size;
                    for (int i11 = 0; i11 < i10; i11++) {
                        ((GapComposer$derivedStateObserver$1) objArr3[i11]).done();
                    }
                }
            }
            return resultRecord;
        }
        MutableObjectIntMap mutableObjectIntMap2 = new MutableObjectIntMap();
        MenuHostHelper menuHostHelper2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        IntRef intRef2 = (IntRef) menuHostHelper2.get();
        if (intRef2 == null) {
            intRef2 = new IntRef();
            menuHostHelper2.set(intRef2);
        }
        int i12 = intRef2.element;
        MutableVector mutableVectorDerivedStateObservers2 = Stack.derivedStateObservers();
        Object[] objArr4 = mutableVectorDerivedStateObservers2.content;
        int i13 = mutableVectorDerivedStateObservers2.size;
        for (int i14 = 0; i14 < i13; i14++) {
            ((GapComposer$derivedStateObserver$1) objArr4[i14]).start();
        }
        try {
            intRef2.element = i12 + 1;
            Object objObserve = SnapshotId_jvmKt.observe(new DerivedSnapshotState$$ExternalSyntheticLambda0(this, intRef2, mutableObjectIntMap2, i12, 0), function0);
            intRef2.element = i12;
            Object[] objArr5 = mutableVectorDerivedStateObservers2.content;
            int i15 = mutableVectorDerivedStateObservers2.size;
            for (int i16 = 0; i16 < i15; i16++) {
                ((GapComposer$derivedStateObserver$1) objArr5[i16]).done();
            }
            Object obj = SnapshotKt.lock;
            synchronized (obj) {
                try {
                    Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                    Object obj2 = resultRecord.result;
                    if (obj2 == ResultRecord.Unset || (snapshotMutationPolicy = this.policy) == null || !snapshotMutationPolicy.equivalent(objObserve, obj2)) {
                        resultRecord2 = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, snapshotCurrentSnapshot);
                        resultRecord2.dependencies = mutableObjectIntMap2;
                        resultRecord2.resultHash = resultRecord2.readableHash(this, snapshotCurrentSnapshot);
                        resultRecord2.result = objObserve;
                    } else {
                        resultRecord.dependencies = mutableObjectIntMap2;
                        resultRecord.resultHash = resultRecord.readableHash(this, snapshotCurrentSnapshot);
                        resultRecord2 = resultRecord;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            IntRef intRef3 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            if (intRef3 == null || intRef3.element != 0) {
                return resultRecord2;
            }
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
            synchronized (obj) {
                Snapshot snapshotCurrentSnapshot2 = SnapshotKt.currentSnapshot();
                resultRecord2.validSnapshotId = snapshotCurrentSnapshot2.getSnapshotId();
                resultRecord2.validSnapshotWriteCount = snapshotCurrentSnapshot2.getWriteCount$runtime();
                Unit unit2 = Unit.INSTANCE;
            }
            return resultRecord2;
        } catch (Throwable th2) {
            Object[] objArr6 = mutableVectorDerivedStateObservers2.content;
            int i17 = mutableVectorDerivedStateObservers2.size;
            for (int i18 = 0; i18 < i17; i18++) {
                ((GapComposer$derivedStateObserver$1) objArr6[i18]).done();
            }
            throw th2;
        }
    }

    public final ResultRecord getCurrentRecord() {
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshotCurrentSnapshot), snapshotCurrentSnapshot, false, this.calculation);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        Function1 readObserver = SnapshotKt.currentSnapshot().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshotCurrentSnapshot), snapshotCurrentSnapshot, true, this.calculation).result;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.first = (ResultRecord) stateRecord;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DerivedState(value=");
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        sb.append(resultRecord.isValid(this, SnapshotKt.currentSnapshot()) ? String.valueOf(resultRecord.result) : "<Not calculated>");
        sb.append(")@");
        sb.append(hashCode());
        return sb.toString();
    }
}
