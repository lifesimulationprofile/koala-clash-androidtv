package androidx.compose.runtime.snapshots;

import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.DerivedSnapshotState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.internal.Thread_jvmKt;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SnapshotId_jvmKt {
    public static final Object sync = new Object();
    public static final Object sync$1 = new Object();
    public static final Object sync$2 = new Object();

    public static final void access$validateRange(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index (" + i + ") is out of bound of [0, " + i2 + ')');
        }
    }

    public static final boolean attemptUpdate(StateSetStateRecord stateSetStateRecord, int i, PersistentOrderedSet persistentOrderedSet) {
        boolean z;
        synchronized (sync$2) {
            int i2 = stateSetStateRecord.modification;
            if (i2 == i) {
                stateSetStateRecord.set = persistentOrderedSet;
                z = true;
                stateSetStateRecord.modification = i2 + 1;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static final int binarySearch(long[] jArr, long j) {
        int length = jArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            long j2 = jArr[i2];
            if (j > j2) {
                i = i2 + 1;
            } else {
                if (j >= j2) {
                    return i2;
                }
                length = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static Snapshot getCurrentThreadSnapshot() {
        return (Snapshot) SnapshotKt.threadSnapshot.get();
    }

    public static final int getStructure(SnapshotStateList snapshotStateList) {
        return ((StateListStateRecord) SnapshotKt.current(snapshotStateList.firstStateRecord)).structuralChange;
    }

    public static Snapshot makeCurrentNonObservable(Snapshot snapshot) {
        if (snapshot instanceof TransparentObserverMutableSnapshot) {
            TransparentObserverMutableSnapshot transparentObserverMutableSnapshot = (TransparentObserverMutableSnapshot) snapshot;
            if (transparentObserverMutableSnapshot.threadId == Thread_jvmKt.currentThreadId()) {
                transparentObserverMutableSnapshot.readObserver = null;
                return snapshot;
            }
        }
        if (snapshot instanceof TransparentObserverSnapshot) {
            TransparentObserverSnapshot transparentObserverSnapshot = (TransparentObserverSnapshot) snapshot;
            if (transparentObserverSnapshot.threadId == Thread_jvmKt.currentThreadId()) {
                transparentObserverSnapshot.readObserver = null;
                return snapshot;
            }
        }
        Snapshot snapshotCreateTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(snapshot, null, false);
        snapshotCreateTransparentSnapshotWithNoParentReadObserver.makeCurrent();
        return snapshotCreateTransparentSnapshotWithNoParentReadObserver;
    }

    public static final boolean mutateBoolean(SnapshotStateList snapshotStateList, Function1 function1) {
        int i;
        AbstractPersistentList abstractPersistentList;
        Object objInvoke;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current(snapshotStateList.firstStateRecord);
                i = stateListStateRecord.modification;
                abstractPersistentList = stateListStateRecord.list;
                Unit unit = Unit.INSTANCE;
            }
            PersistentVectorBuilder persistentVectorBuilderBuilder = abstractPersistentList.builder();
            objInvoke = function1.invoke(persistentVectorBuilderBuilder);
            AbstractPersistentList abstractPersistentListBuild = persistentVectorBuilderBuilder.build();
            if (Intrinsics.areEqual(abstractPersistentListBuild, abstractPersistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord2 = snapshotStateList.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, snapshotCurrentSnapshot), i, abstractPersistentListBuild, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateList);
        } while (!zAttemptUpdate);
        return ((Boolean) objInvoke).booleanValue();
    }

    public static Object observe(DerivedSnapshotState$$ExternalSyntheticLambda0 derivedSnapshotState$$ExternalSyntheticLambda0, Function0 function0) {
        Snapshot transparentObserverMutableSnapshot;
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        if (snapshot instanceof TransparentObserverMutableSnapshot) {
            TransparentObserverMutableSnapshot transparentObserverMutableSnapshot2 = (TransparentObserverMutableSnapshot) snapshot;
            if (transparentObserverMutableSnapshot2.threadId == Thread_jvmKt.currentThreadId()) {
                Function1 function1 = transparentObserverMutableSnapshot2.readObserver;
                Function1 function2 = transparentObserverMutableSnapshot2.writeObserver;
                try {
                    ((TransparentObserverMutableSnapshot) snapshot).readObserver = SnapshotKt.mergedReadObserver(derivedSnapshotState$$ExternalSyntheticLambda0, function1, true);
                    ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function2;
                    return function0.invoke();
                } finally {
                    transparentObserverMutableSnapshot2.readObserver = function1;
                    transparentObserverMutableSnapshot2.writeObserver = function2;
                }
            }
        }
        if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, derivedSnapshotState$$ExternalSyntheticLambda0, null, true, false);
        } else {
            transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(derivedSnapshotState$$ExternalSyntheticLambda0);
        }
        try {
            Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
            try {
                Object objInvoke = function0.invoke();
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                transparentObserverMutableSnapshot.dispose();
                return objInvoke;
            } catch (Throwable th) {
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            transparentObserverMutableSnapshot.dispose();
            throw th2;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.Collection] */
    public static OnBackPressedDispatcher$$ExternalSyntheticLambda0 registerApplyObserver(Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0) {
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.plus((Collection) SnapshotKt.applyObservers, updater$$ExternalSyntheticLambda0);
            Unit unit = Unit.INSTANCE;
        }
        return new OnBackPressedDispatcher$$ExternalSyntheticLambda0(13, updater$$ExternalSyntheticLambda0);
    }

    public static void restoreNonObservable(Snapshot snapshot, Snapshot snapshot2, Function1 function1) {
        if (snapshot != snapshot2) {
            snapshot2.getClass();
            Snapshot.restoreCurrent(snapshot);
            snapshot2.dispose();
        } else if (snapshot instanceof TransparentObserverMutableSnapshot) {
            ((TransparentObserverMutableSnapshot) snapshot).readObserver = function1;
        } else if (snapshot instanceof TransparentObserverSnapshot) {
            ((TransparentObserverSnapshot) snapshot).readObserver = function1;
        } else {
            throw new IllegalStateException(("Non-transparent snapshot was reused: " + snapshot).toString());
        }
    }

    public static void sendApplyNotifications() {
        boolean z;
        synchronized (SnapshotKt.lock) {
            MutableScatterSet mutableScatterSet = SnapshotKt.globalSnapshot.modified;
            z = false;
            if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
                z = true;
            }
        }
        if (z) {
            SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        }
    }

    public static final void unsupported() {
        throw new UnsupportedOperationException();
    }

    public abstract void check();

    public static final boolean attemptUpdate(StateListStateRecord stateListStateRecord, int i, AbstractPersistentList abstractPersistentList, boolean z) {
        boolean z2;
        synchronized (sync) {
            try {
                int i2 = stateListStateRecord.modification;
                if (i2 == i) {
                    stateListStateRecord.list = abstractPersistentList;
                    z2 = true;
                    if (z) {
                        stateListStateRecord.structuralChange++;
                    }
                    stateListStateRecord.modification = i2 + 1;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }
}
