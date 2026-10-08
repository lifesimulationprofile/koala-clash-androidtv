package androidx.compose.runtime.snapshots;

import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer$derivedStateObserver$1;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.node.OwnerScope;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.network.HttpException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateObserver {
    public OnBackPressedDispatcher$$ExternalSyntheticLambda0 applyUnsubscribe;
    public ObservedScopeMap currentMap;
    public final Function1 onChangedExecutor;
    public boolean sendingNotifications;
    public final AtomicReference pendingChanges = new AtomicReference(null);
    public final Updater$$ExternalSyntheticLambda0 applyObserver = new Updater$$ExternalSyntheticLambda0(25, this);
    public final DiskLruCache$$ExternalSyntheticLambda0 readObserver = new DiskLruCache$$ExternalSyntheticLambda0(2, this);
    public final MutableVector observedScopeMaps = new MutableVector(new ObservedScopeMap[16]);
    public final Object observedScopeMapsLock = new Object();
    public long currentMapThreadId = -1;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ObservedScopeMap {
        public Object currentScope;
        public MutableObjectIntMap currentScopeReads;
        public int deriveStateScopeCount;
        public final Function1 onChanged;
        public boolean readingDerivedStates;
        public int currentToken = -1;
        public final MutableScatterMap valueToScopes = ScopeMap.m298constructorimpl$default();
        public final MutableScatterMap scopeToValues = new MutableScatterMap();
        public final MutableScatterSet invalidated = new MutableScatterSet();
        public final MutableVector statesToReread = new MutableVector(new DerivedSnapshotState[16]);
        public final GapComposer$derivedStateObserver$1 derivedStateObserver = new GapComposer$derivedStateObserver$1(1, this);
        public final MutableScatterMap dependencyToDerivedStates = ScopeMap.m298constructorimpl$default();
        public final HashMap recordedDerivedStateValues = new HashMap();

        public ObservedScopeMap(Function1 function1) {
            this.onChanged = function1;
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16861. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        public final boolean recordInvalidation(java.util.Set r46) {
            /*
                Method dump skipped, instruction units count: 1686
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordInvalidation(java.util.Set):boolean");
        }

        /* JADX WARN: Code duplicated, block: B:27:0x008b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x008d A[LOOP:0: B:15:0x0048->B:28:0x008d, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:37:0x0090 A[EDGE_INSN: B:37:0x0090->B:29:0x0090 BREAK  A[LOOP:0: B:15:0x0048->B:28:0x008d], SYNTHETIC] */
        public final void recordRead(Object obj, int i, Object obj2, MutableObjectIntMap mutableObjectIntMap) {
            int i2;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iFindIndex = mutableObjectIntMap.findIndex(obj);
            if (iFindIndex < 0) {
                iFindIndex = ~iFindIndex;
                i2 = -1;
            } else {
                i2 = mutableObjectIntMap.values[iFindIndex];
            }
            mutableObjectIntMap.keys[iFindIndex] = obj;
            mutableObjectIntMap.values[iFindIndex] = i;
            if ((obj instanceof DerivedSnapshotState) && i2 != i) {
                DerivedSnapshotState.ResultRecord currentRecord = ((DerivedSnapshotState) obj).getCurrentRecord();
                this.recordedDerivedStateValues.put(obj, currentRecord.result);
                MutableObjectIntMap mutableObjectIntMap2 = currentRecord.dependencies;
                MutableScatterMap mutableScatterMap = this.dependencyToDerivedStates;
                ScopeMap.m300removeScopeimpl(mutableScatterMap, obj);
                Object[] objArr = mutableObjectIntMap2.keys;
                long[] jArr = mutableObjectIntMap2.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    while (true) {
                        long j = jArr[i3];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        } else {
                            int i4 = 8 - ((~(i3 - length)) >>> 31);
                            for (int i5 = 0; i5 < i4; i5++) {
                                if ((j & 255) < 128) {
                                    StateObject stateObject = (StateObject) objArr[(i3 << 3) + i5];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ((StateObjectImpl) stateObject).m304recordReadInh_f27i8$runtime(2);
                                    }
                                    ScopeMap.m297addimpl(mutableScatterMap, stateObject, obj);
                                }
                                j >>= 8;
                            }
                            if (i4 != 8) {
                                break;
                            } else if (i3 != length) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
            }
            if (i2 == -1) {
                if (obj instanceof StateObjectImpl) {
                    ((StateObjectImpl) obj).m304recordReadInh_f27i8$runtime(2);
                }
                ScopeMap.m297addimpl(this.valueToScopes, obj, obj2);
            }
        }

        public final void removeObservation(Object obj, Object obj2) {
            MutableScatterMap mutableScatterMap = this.valueToScopes;
            ScopeMap.m299removeimpl(mutableScatterMap, obj2, obj);
            if (!(obj2 instanceof DerivedSnapshotState) || mutableScatterMap.containsKey(obj2)) {
                return;
            }
            ScopeMap.m300removeScopeimpl(this.dependencyToDerivedStates, obj2);
            this.recordedDerivedStateValues.remove(obj2);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x009a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x009c A[LOOP:2: B:16:0x0061->B:28:0x009c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:48:0x00ab A[EDGE_INSN: B:48:0x00ab->B:30:0x00ab BREAK  A[LOOP:2: B:16:0x0061->B:28:0x009c], SYNTHETIC] */
        public final void removeScopeIf() {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            boolean z;
            MutableScatterMap mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j3 = jArr3[i2];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j3 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c = c2;
                            Object obj = mutableScatterMap.keys[i6];
                            j2 = j4;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i6];
                            boolean zIsValidOwnerScope = ((OwnerScope) obj).isValidOwnerScope();
                            if (zIsValidOwnerScope) {
                                jArr2 = jArr3;
                                j = j3;
                                z = zIsValidOwnerScope;
                            } else {
                                Object[] objArr = mutableObjectIntMap.keys;
                                int[] iArr = mutableObjectIntMap.values;
                                long[] jArr4 = mutableObjectIntMap.metadata;
                                int i7 = i3;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j3;
                                    int i8 = 0;
                                    while (true) {
                                        long j5 = jArr4[i8];
                                        long[] jArr5 = jArr4;
                                        z = zIsValidOwnerScope;
                                        if ((((~j5) << c) & j5 & j2) == j2) {
                                            if (i8 != length2) {
                                                break;
                                                break;
                                            }
                                            i8++;
                                            zIsValidOwnerScope = z;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        } else {
                                            int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                            for (int i10 = 0; i10 < i9; i10++) {
                                                if ((j5 & 255) < 128) {
                                                    int i11 = (i8 << 3) + i10;
                                                    Object obj2 = objArr[i11];
                                                    int i12 = iArr[i11];
                                                    removeObservation(obj, obj2);
                                                }
                                                j5 >>= i7;
                                            }
                                            if (i9 != i7) {
                                                break;
                                            }
                                            if (i8 != length2) {
                                                break;
                                            }
                                            i8++;
                                            zIsValidOwnerScope = z;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        }
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j = j3;
                                    z = zIsValidOwnerScope;
                                }
                            }
                            if (!z) {
                                mutableScatterMap.removeValueAt(i6);
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            j = j3;
                            c = c2;
                            j2 = j4;
                            i = i3;
                        }
                        i5++;
                        i3 = i;
                        j3 = j >> i;
                        c2 = c;
                        j4 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }
    }

    public SnapshotStateObserver(Function1 function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0073 A[Catch: all -> 0x0090, LOOP:1: B:12:0x002e->B:23:0x0073, LOOP_END, TryCatch #0 {all -> 0x0090, blocks: (B:4:0x0007, B:6:0x000f, B:24:0x007a, B:26:0x0082, B:31:0x0092, B:28:0x0087, B:9:0x0022, B:12:0x002e, B:14:0x0043, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:23:0x0073, B:32:0x0098), top: B:37:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x007a A[EDGE_INSN: B:44:0x007a->B:24:0x007a BREAK  A[LOOP:1: B:12:0x002e->B:23:0x0073], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    public final void clear(SeekableTransitionState seekableTransitionState) {
        int i;
        synchronized (this.observedScopeMapsLock) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                int i2 = mutableVector.size;
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.content[i3];
                    MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) observedScopeMap.scopeToValues.remove(seekableTransitionState);
                    if (mutableObjectIntMap == null) {
                        i = i3;
                    } else {
                        Object[] objArr = mutableObjectIntMap.keys;
                        int[] iArr = mutableObjectIntMap.values;
                        long[] jArr = mutableObjectIntMap.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i5 = 0;
                            while (true) {
                                long j = jArr[i5];
                                i = i3;
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                                    for (int i7 = 0; i7 < i6; i7++) {
                                        if ((j & 255) < 128) {
                                            int i8 = (i5 << 3) + i7;
                                            Object obj = objArr[i8];
                                            int i9 = iArr[i8];
                                            observedScopeMap.removeObservation(seekableTransitionState, obj);
                                        }
                                        j >>= 8;
                                    }
                                    if (i6 != 8) {
                                        break;
                                    }
                                    if (i5 != length) {
                                        break;
                                    }
                                    i5++;
                                    i3 = i;
                                } else if (i5 != length) {
                                    break;
                                    break;
                                } else {
                                    i5++;
                                    i3 = i;
                                }
                            }
                        } else {
                            i = i3;
                        }
                    }
                    if (!observedScopeMap.scopeToValues.isNotEmpty()) {
                        i4++;
                    } else if (i4 > 0) {
                        Object[] objArr2 = mutableVector.content;
                        objArr2[i - i4] = objArr2[i];
                    }
                    i3 = i + 1;
                }
                int i10 = i2 - i4;
                Arrays.fill(mutableVector.content, i10, i2, (Object) null);
                mutableVector.size = i10;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean drainChanges() {
        boolean z;
        Set set;
        Set set2;
        synchronized (this.observedScopeMapsLock) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            AtomicReference atomicReference = this.pendingChanges;
            while (true) {
                Object obj = atomicReference.get();
                set = null;
                Object obj2 = null;
                Object objSubList = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof Set) {
                    set2 = (Set) obj;
                } else {
                    if (!(obj instanceof List)) {
                        ComposerKt.composeRuntimeError("Unexpected notification");
                        throw new HttpException();
                    }
                    List list = (List) obj;
                    Set set3 = (Set) list.get(0);
                    if (list.size() == 2) {
                        objSubList = list.get(1);
                    } else if (list.size() > 2) {
                        objSubList = list.subList(1, list.size());
                    }
                    set2 = set3;
                    obj2 = objSubList;
                }
                do {
                    if (atomicReference.compareAndSet(obj, obj2)) {
                        set = set2;
                        break;
                    }
                } while (atomicReference.get() == obj);
            }
            if (set == null) {
                return z2;
            }
            synchronized (this.observedScopeMapsLock) {
                try {
                    MutableVector mutableVector = this.observedScopeMaps;
                    Object[] objArr = mutableVector.content;
                    int i = mutableVector.size;
                    for (int i2 = 0; i2 < i; i2++) {
                        z2 = ((ObservedScopeMap) objArr[i2]).recordInvalidation(set) || z2;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x010f  */
    /* JADX WARN: Code duplicated, block: B:56:0x011c A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:41:0x00ce, B:43:0x00db, B:45:0x00f6, B:49:0x0105, B:50:0x010e, B:52:0x0111, B:55:0x0116, B:63:0x013c, B:56:0x011c, B:58:0x0122, B:59:0x0125, B:44:0x00e5), top: B:134:0x00ce, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0122 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:41:0x00ce, B:43:0x00db, B:45:0x00f6, B:49:0x0105, B:50:0x010e, B:52:0x0111, B:55:0x0116, B:63:0x013c, B:56:0x011c, B:58:0x0122, B:59:0x0125, B:44:0x00e5), top: B:134:0x00ce, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01d9  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void observeReads(Object obj, Function1 function1, Function0 function0) {
        Object obj2;
        ObservedScopeMap observedScopeMap;
        ObservedScopeMap observedScopeMap2;
        long j;
        SnapshotStateObserver snapshotStateObserver;
        Snapshot transparentObserverMutableSnapshot;
        Snapshot snapshotMakeCurrent;
        ObservedScopeMap observedScopeMap3;
        int i;
        long j2;
        int i2;
        ObservedScopeMap observedScopeMap4;
        long jCurrentThreadId = Thread_jvmKt.currentThreadId();
        synchronized (this.observedScopeMapsLock) {
            MutableVector mutableVector = this.observedScopeMaps;
            Object[] objArr = mutableVector.content;
            int i3 = mutableVector.size;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    obj2 = null;
                    break;
                }
                obj2 = objArr[i4];
                if (((ObservedScopeMap) obj2).onChanged == function1) {
                    break;
                } else {
                    i4++;
                }
            }
            observedScopeMap = (ObservedScopeMap) obj2;
            if (observedScopeMap == null) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function1);
                observedScopeMap = new ObservedScopeMap(function1);
                mutableVector.add(observedScopeMap);
            }
            observedScopeMap2 = this.currentMap;
            j = this.currentMapThreadId;
            Unit unit = Unit.INSTANCE;
        }
        if (j != -1 && j != jCurrentThreadId) {
            PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + jCurrentThreadId + ", name=" + Thread.currentThread().getName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
        }
        try {
            synchronized (this.observedScopeMapsLock) {
                try {
                    this.currentMap = observedScopeMap;
                    this.currentMapThreadId = jCurrentThreadId;
                } catch (Throwable th) {
                    th = th;
                    snapshotStateObserver = jCurrentThreadId;
                }
            }
            DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = this.readObserver;
            Object obj3 = observedScopeMap.currentScope;
            MutableObjectIntMap mutableObjectIntMap = observedScopeMap.currentScopeReads;
            int i5 = observedScopeMap.currentToken;
            observedScopeMap.currentScope = obj;
            observedScopeMap.currentScopeReads = (MutableObjectIntMap) observedScopeMap.scopeToValues.get(obj);
            if (observedScopeMap.currentToken == -1) {
                long snapshotId = SnapshotKt.currentSnapshot().getSnapshotId();
                observedScopeMap.currentToken = (int) (snapshotId ^ (snapshotId >>> 32));
            }
            GapComposer$derivedStateObserver$1 gapComposer$derivedStateObserver$1 = observedScopeMap.derivedStateObserver;
            MutableVector mutableVectorDerivedStateObservers = Stack.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(gapComposer$derivedStateObserver$1);
                if (diskLruCache$$ExternalSyntheticLambda0 == null) {
                    function0.invoke();
                } else {
                    Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
                    if (snapshot instanceof TransparentObserverMutableSnapshot) {
                        try {
                            if (((TransparentObserverMutableSnapshot) snapshot).threadId == Thread_jvmKt.currentThreadId()) {
                                Function1 function2 = ((TransparentObserverMutableSnapshot) snapshot).readObserver;
                                Function1 function3 = ((TransparentObserverMutableSnapshot) snapshot).writeObserver;
                                try {
                                    ((TransparentObserverMutableSnapshot) snapshot).readObserver = SnapshotKt.mergedReadObserver(diskLruCache$$ExternalSyntheticLambda0, function2, true);
                                    ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function3;
                                    function0.invoke();
                                    ((TransparentObserverMutableSnapshot) snapshot).readObserver = function2;
                                    ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function3;
                                } catch (Throwable th2) {
                                    ((TransparentObserverMutableSnapshot) snapshot).readObserver = function2;
                                    ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function3;
                                    throw th2;
                                }
                            } else {
                                if (snapshot != null || (snapshot instanceof MutableSnapshot)) {
                                    transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, diskLruCache$$ExternalSyntheticLambda0, null, true, false);
                                } else {
                                    transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(diskLruCache$$ExternalSyntheticLambda0);
                                }
                                try {
                                    snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                                    try {
                                        function0.invoke();
                                        Snapshot.restoreCurrent(snapshotMakeCurrent);
                                        transparentObserverMutableSnapshot.dispose();
                                    } catch (Throwable th3) {
                                        try {
                                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                                            throw th3;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            try {
                                                transparentObserverMutableSnapshot.dispose();
                                                throw th;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.size - 1);
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.size - 1);
                            throw th;
                        }
                    } else {
                        if (snapshot != null) {
                            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, diskLruCache$$ExternalSyntheticLambda0, null, true, false);
                        } else {
                            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, diskLruCache$$ExternalSyntheticLambda0, null, true, false);
                        }
                        snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                        function0.invoke();
                        Snapshot.restoreCurrent(snapshotMakeCurrent);
                        transparentObserverMutableSnapshot.dispose();
                    }
                }
                try {
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.size - 1);
                    Object obj4 = observedScopeMap.currentScope;
                    int i6 = observedScopeMap.currentToken;
                    MutableObjectIntMap mutableObjectIntMap2 = observedScopeMap.currentScopeReads;
                    if (mutableObjectIntMap2 != null) {
                        long[] jArr = mutableObjectIntMap2.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            boolean z = true;
                            int i7 = 0;
                            while (true) {
                                long j3 = jArr[i7];
                                boolean z2 = z;
                                ObservedScopeMap observedScopeMap5 = observedScopeMap;
                                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i8 = 8 - ((~(i7 - length)) >>> 31);
                                    int i9 = 0;
                                    while (i9 < i8) {
                                        if ((j3 & 255) < 128) {
                                            j2 = j3;
                                            int i10 = (i7 << 3) + i9;
                                            Object obj5 = mutableObjectIntMap2.keys[i10];
                                            i2 = i9;
                                            boolean z3 = mutableObjectIntMap2.values[i10] != i6 ? z2 : false;
                                            if (z3) {
                                                observedScopeMap4 = observedScopeMap5;
                                                observedScopeMap4.removeObservation(obj4, obj5);
                                            } else {
                                                observedScopeMap4 = observedScopeMap5;
                                            }
                                            if (z3) {
                                                mutableObjectIntMap2.removeValueAt(i10);
                                            }
                                        } else {
                                            i6 = i6;
                                            j2 = j3;
                                            i2 = i9;
                                            observedScopeMap4 = observedScopeMap5;
                                        }
                                        j3 = j2 >> 8;
                                        i9 = i2 + 1;
                                        observedScopeMap5 = observedScopeMap4;
                                        i6 = i6;
                                    }
                                    i = i6;
                                    observedScopeMap3 = observedScopeMap5;
                                    if (i8 != 8) {
                                        break;
                                    }
                                } else {
                                    i = i6;
                                    observedScopeMap3 = observedScopeMap5;
                                }
                                if (i7 == length) {
                                    break;
                                }
                                i7++;
                                z = z2;
                                observedScopeMap = observedScopeMap3;
                                i6 = i;
                            }
                        } else {
                            observedScopeMap3 = observedScopeMap;
                        }
                    } else {
                        observedScopeMap3 = observedScopeMap;
                    }
                    observedScopeMap3.currentScope = obj3;
                    observedScopeMap3.currentScopeReads = mutableObjectIntMap;
                    observedScopeMap3.currentToken = i5;
                    synchronized (this.observedScopeMapsLock) {
                        this.currentMap = observedScopeMap2;
                        this.currentMapThreadId = j;
                        Unit unit2 = Unit.INSTANCE;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    snapshotStateObserver = this;
                    synchronized (snapshotStateObserver.observedScopeMapsLock) {
                        snapshotStateObserver.currentMap = observedScopeMap2;
                        snapshotStateObserver.currentMapThreadId = j;
                        Unit unit3 = Unit.INSTANCE;
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
            }
        } catch (Throwable th10) {
            th = th10;
            snapshotStateObserver = this;
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.Collection] */
    public final void start() {
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = this.applyObserver;
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.plus((Collection) SnapshotKt.applyObservers, updater$$ExternalSyntheticLambda0);
            Unit unit = Unit.INSTANCE;
        }
        this.applyUnsubscribe = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(13, updater$$ExternalSyntheticLambda0);
    }

    public final void clear() {
        synchronized (this.observedScopeMapsLock) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                Object[] objArr = mutableVector.content;
                int i = mutableVector.size;
                for (int i2 = 0; i2 < i; i2++) {
                    ObservedScopeMap observedScopeMap = (ObservedScopeMap) objArr[i2];
                    observedScopeMap.valueToScopes.clear();
                    observedScopeMap.scopeToValues.clear();
                    observedScopeMap.dependencyToDerivedStates.clear();
                    observedScopeMap.recordedDerivedStateValues.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
