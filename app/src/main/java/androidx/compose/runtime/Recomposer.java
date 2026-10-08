package androidx.compose.runtime;

import android.util.Log;
import androidx.camera.core.SurfaceRequest;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.core.view.MenuHostHelper;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Handshake;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    public final ArrayList _knownCompositions;
    public Object _knownCompositionsCache;
    public final StateFlowImpl _state;
    public final BroadcastFrameClock broadcastFrameClock;
    public Throwable closeCause;
    public final MutableVector compositionInvalidations;
    public final ArrayList compositionsAwaitingApply;
    public MutableScatterSet compositionsRemoved;
    public final CoroutineContext effectCoroutineContext;
    public final JobImpl effectJob;
    public final StateFlowImpl errorState;
    public ArrayList failedCompositions;
    public boolean frameClockPaused;
    public final ArrayList movableContentAwaitingInsert;
    public final MutableScatterMap movableContentNestedExtractionsPending;
    public final SurfaceRequest.AnonymousClass1 movableContentNestedStatesAvailable;
    public final MutableScatterMap movableContentRemoved;
    public final MutableScatterMap movableContentStatesAvailable;
    public final MenuHostHelper nextFrameEndCallbackQueue;
    public final MenuHostHelper pausedScopes;
    public final NeverEqualPolicy recomposerInfo;
    public Job runnerJob;
    public MutableScatterSet snapshotInvalidations;
    public final Object stateLock;
    public CancellableContinuationImpl workContinuation;
    public static final StateFlowImpl _runningRecomposers = FlowKt.MutableStateFlow(PersistentOrderedSet.EMPTY);
    public static final AtomicReference _hotReloadEnabled = new AtomicReference(Boolean.FALSE);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RecomposerErrorState {
        public final Throwable cause;

        public RecomposerErrorState(Throwable th) {
            this.cause = th;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static final State Idle;
        public static final State Inactive;
        public static final State InactivePendingWork;
        public static final State PendingWork;
        public static final State ShutDown;
        public static final State ShuttingDown;

        static {
            State state = new State("ShutDown", 0);
            ShutDown = state;
            State state2 = new State("ShuttingDown", 1);
            ShuttingDown = state2;
            State state3 = new State("Inactive", 2);
            Inactive = state3;
            State state4 = new State("InactivePendingWork", 3);
            InactivePendingWork = state4;
            State state5 = new State("Idle", 4);
            Idle = state5;
            State state6 = new State("PendingWork", 5);
            PendingWork = state6;
            $VALUES = new State[]{state, state2, state3, state4, state5, state6};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Recomposer$$ExternalSyntheticLambda1(this, 0));
        this.broadcastFrameClock = broadcastFrameClock;
        this.nextFrameEndCallbackQueue = new MenuHostHelper(new Recomposer$$ExternalSyntheticLambda1(this, 1));
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet();
        this.compositionInvalidations = new MutableVector(new CompositionImpl[16]);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = new MutableScatterMap();
        this.movableContentNestedStatesAvailable = new SurfaceRequest.AnonymousClass1(28);
        this.movableContentStatesAvailable = new MutableScatterMap();
        this.movableContentNestedExtractionsPending = new MutableScatterMap();
        this.errorState = FlowKt.MutableStateFlow(null);
        this._state = FlowKt.MutableStateFlow(State.Inactive);
        this.pausedScopes = new MenuHostHelper(18);
        JobImpl jobImpl = new JobImpl((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        jobImpl.invokeOnCompletion(new Recomposer$$ExternalSyntheticLambda0(28, this));
        this.effectJob = jobImpl;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(jobImpl);
        this.recomposerInfo = new NeverEqualPolicy(9);
    }

    public static final Object access$awaitWorkAvailable(Recomposer recomposer, Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (recomposer.getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(1, zzga.intercepted(recomposer$runRecomposeAndApplyChanges$2));
        cancellableContinuationImpl2.initCancellability();
        synchronized (recomposer.stateLock) {
            if (recomposer.getHasSchedulingWork()) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                recomposer.workContinuation = cancellableContinuationImpl2;
                cancellableContinuationImpl = null;
            }
        }
        if (cancellableContinuationImpl != null) {
            cancellableContinuationImpl.resumeWith(Unit.INSTANCE);
        }
        Object result = cancellableContinuationImpl2.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0065 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0067 A[Catch: all -> 0x00a8, LOOP:2: B:12:0x0028->B:25:0x0067, LOOP_END, TryCatch #0 {all -> 0x00a8, blocks: (B:4:0x0005, B:6:0x000e, B:8:0x0016, B:27:0x006b, B:29:0x0093, B:32:0x00aa, B:9:0x0019, B:12:0x0028, B:14:0x0038, B:16:0x0044, B:18:0x004d, B:20:0x0056, B:21:0x005c, B:22:0x005f, B:25:0x0067, B:33:0x00b0), top: B:41:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x006a A[EDGE_INSN: B:45:0x006a->B:26:0x006a BREAK  A[LOOP:2: B:12:0x0028->B:25:0x0067], SYNTHETIC] */
    public static final void access$discardUnusedMovableContentState(Recomposer recomposer) {
        int i;
        MutableObjectList mutableObjectList;
        MutableObjectList mutableObjectList2;
        synchronized (recomposer.stateLock) {
            try {
                if (recomposer.movableContentRemoved.isNotEmpty()) {
                    MutableScatterMap mutableScatterMap = recomposer.movableContentRemoved;
                    if (mutableScatterMap.isEmpty()) {
                        mutableObjectList2 = ObjectListKt.EmptyObjectList;
                    } else {
                        MutableObjectList mutableObjectList3 = new MutableObjectList();
                        Object[] objArr = mutableScatterMap.values;
                        long[] jArr = mutableScatterMap.metadata;
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
                                            Object obj = objArr[(i2 << 3) + i4];
                                            if (obj instanceof MutableObjectList) {
                                                mutableObjectList3.addAll((MutableObjectList) obj);
                                            } else {
                                                mutableObjectList3.add(obj);
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
                        mutableObjectList2 = mutableObjectList3;
                    }
                    recomposer.movableContentRemoved.clear();
                    SurfaceRequest.AnonymousClass1 anonymousClass1 = recomposer.movableContentNestedStatesAvailable;
                    ((MutableScatterMap) anonymousClass1.val$requestCancellationCompleter).clear();
                    ((MutableScatterMap) anonymousClass1.val$requestCancellationFuture).clear();
                    recomposer.movableContentNestedExtractionsPending.clear();
                    mutableObjectList = new MutableObjectList(mutableObjectList2._size);
                    Object[] objArr2 = mutableObjectList2.content;
                    int i5 = mutableObjectList2._size;
                    for (int i6 = 0; i6 < i5; i6++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr2[i6];
                        mutableObjectList.add(new Pair(movableContentStateReference, recomposer.movableContentStatesAvailable.get(movableContentStateReference)));
                    }
                    recomposer.movableContentStatesAvailable.clear();
                } else {
                    mutableObjectList = ObjectListKt.EmptyObjectList;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object[] objArr3 = mutableObjectList.content;
        int i7 = mutableObjectList._size;
        for (i = 0; i < i7; i++) {
            Pair pair = (Pair) objArr3[i];
        }
    }

    public static final boolean access$getHasBroadcastFrameClockAwaiters(Recomposer recomposer) {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (recomposer.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = recomposer.getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    public static final List access$knownCompositions(Recomposer recomposer) {
        List listKnownCompositionsLocked;
        synchronized (recomposer.stateLock) {
            listKnownCompositionsLocked = recomposer.knownCompositionsLocked();
        }
        return listKnownCompositionsLocked;
    }

    public static final void access$registerRunnerJob(Recomposer recomposer, Job job) {
        synchronized (recomposer.stateLock) {
            try {
                Throwable th = recomposer.closeCause;
                if (th != null) {
                    throw th;
                }
                if (((State) recomposer._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                    throw new IllegalStateException("Recomposer shut down");
                }
                if (recomposer.runnerJob != null) {
                    throw new IllegalStateException("Recomposer already running");
                }
                recomposer.runnerJob = job;
                if (recomposer.deriveStateLocked() != null) {
                    ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult$Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
            mutableSnapshot.dispose();
        } catch (Throwable th) {
            mutableSnapshot.dispose();
            throw th;
        }
    }

    public static final void performInitialMovableContentInserts$fillToInsert(ArrayList arrayList, Recomposer recomposer, CompositionImpl compositionImpl) {
        arrayList.clear();
        synchronized (recomposer.stateLock) {
            Iterator it = recomposer.movableContentAwaitingInsert.iterator();
            if (it.hasNext()) {
                ((MovableContentStateReference) it.next()).getClass();
                throw null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            try {
                if (((State) this._state.getValue()).compareTo(State.Idle) >= 0) {
                    StateFlowImpl stateFlowImpl = this._state;
                    State state = State.ShuttingDown;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, state);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.effectJob.cancel((CancellationException) null);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void composeInitial$runtime(CompositionImpl compositionImpl, Function2 function2) throws Throwable {
        State state;
        boolean zContains;
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        boolean z = compositionImpl.composer.isComposing;
        synchronized (this.stateLock) {
            State state2 = (State) this._state.getValue();
            state = State.ShuttingDown;
            zContains = state2.compareTo(state) > 0 ? true ^ knownCompositionsLocked().contains(compositionImpl) : true;
        }
        try {
            Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(0, compositionImpl);
            BlurEffectKt$$ExternalSyntheticLambda1 blurEffectKt$$ExternalSyntheticLambda1 = new BlurEffectKt$$ExternalSyntheticLambda1(8, compositionImpl, null);
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(recomposer$$ExternalSyntheticLambda0, blurEffectKt$$ExternalSyntheticLambda1)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                try {
                    compositionImpl.composeContent(function2);
                    Unit unit = Unit.INSTANCE;
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                    synchronized (this.stateLock) {
                        if (((State) this._state.getValue()).compareTo(state) > 0 && !knownCompositionsLocked().contains(compositionImpl)) {
                            this._knownCompositions.add(compositionImpl);
                            this._knownCompositionsCache = null;
                        }
                    }
                    if (!z) {
                        SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
                    }
                    try {
                        performInitialMovableContentInserts(compositionImpl);
                        try {
                            compositionImpl.applyChanges();
                            compositionImpl.applyLateChanges();
                            if (z) {
                                return;
                            }
                            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
                        } catch (Throwable th) {
                            processCompositionError(th, null);
                        }
                    } catch (Throwable th2) {
                        processCompositionError(th2, compositionImpl);
                    }
                } catch (Throwable th3) {
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th3;
                }
            } catch (Throwable th4) {
                applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                throw th4;
            }
        } catch (Throwable th5) {
            if (zContains) {
                synchronized (this.stateLock) {
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            processCompositionError(th5, compositionImpl);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final MutableScatterSet composeInitialPaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, Function2 function2) {
        MenuHostHelper menuHostHelper = this.pausedScopes;
        try {
            ShouldPauseCallback shouldPauseCallback2 = compositionImpl.shouldPause;
            compositionImpl.shouldPause = shouldPauseCallback;
            try {
                composeInitial$runtime(compositionImpl, function2);
                MutableScatterSet mutableScatterSet = (MutableScatterSet) menuHostHelper.get();
                if (mutableScatterSet == null) {
                    mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                }
                compositionImpl.shouldPause = shouldPauseCallback2;
                menuHostHelper.set(null);
                return mutableScatterSet;
            } catch (Throwable th) {
                compositionImpl.shouldPause = shouldPauseCallback2;
                throw th;
            }
        } catch (Throwable th2) {
            menuHostHelper.set(null);
            throw th2;
        }
    }

    public final CancellableContinuation deriveStateLocked() throws DispatchException {
        StateFlowImpl stateFlowImpl = this._state;
        int iCompareTo = ((State) stateFlowImpl.getValue()).compareTo(State.ShuttingDown);
        StateFlowImpl stateFlowImpl2 = this.errorState;
        ArrayList arrayList = this.movableContentAwaitingInsert;
        ArrayList arrayList2 = this.compositionsAwaitingApply;
        MutableVector mutableVector = this.compositionInvalidations;
        if (iCompareTo > 0) {
            Object value = stateFlowImpl2.getValue();
            State state = State.PendingWork;
            State state2 = State.Inactive;
            if (value == null) {
                if (this.runnerJob == null) {
                    this.snapshotInvalidations = new MutableScatterSet();
                    mutableVector.clear();
                    if (getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked()) {
                        state2 = State.InactivePendingWork;
                    }
                } else {
                    state2 = (mutableVector.size != 0 || this.snapshotInvalidations.isNotEmpty() || !arrayList2.isEmpty() || !arrayList.isEmpty() || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked() || this.movableContentRemoved.isNotEmpty()) ? state : State.Idle;
                }
            }
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, state2);
            if (state2 != state) {
                return null;
            }
            CancellableContinuationImpl cancellableContinuationImpl = this.workContinuation;
            this.workContinuation = null;
            return cancellableContinuationImpl;
        }
        List listKnownCompositionsLocked = knownCompositionsLocked();
        int size = listKnownCompositionsLocked.size();
        for (int i = 0; i < size; i++) {
        }
        this._knownCompositions.clear();
        this._knownCompositionsCache = EmptyList.INSTANCE;
        this.snapshotInvalidations = new MutableScatterSet();
        mutableVector.clear();
        arrayList2.clear();
        arrayList.clear();
        this.failedCompositions = null;
        CancellableContinuationImpl cancellableContinuationImpl2 = this.workContinuation;
        if (cancellableContinuationImpl2 != null) {
            cancellableContinuationImpl2.cancel(null);
        }
        this.workContinuation = null;
        stateFlowImpl2.setValue(null);
        return null;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final boolean getCollectingCallByInformation$runtime() {
        return ((Boolean) _hotReloadEnabled.get()).booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final boolean getCollectingParameterInformation$runtime() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final boolean getCollectingSourceInformation$runtime() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final long getCompositeKeyHashCode$runtime() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final Composition getComposition$runtime() {
        return null;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && (((AtomicInt) ((Request) this.broadcastFrameClock.queue).headers).get() & 134217727) > 0;
    }

    public final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.size != 0 || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked() || this.movableContentRemoved.isNotEmpty();
    }

    public final boolean getHasNextFrameEndAwaitersLocked() {
        return !this.frameClockPaused && (((AtomicInt) ((Request) this.nextFrameEndCallbackQueue.mMenuProviders).headers).get() & 134217727) > 0;
    }

    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.size != 0 || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked();
        }
        return z;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final boolean getStackTraceEnabled$runtime() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void invalidate$runtime(CompositionImpl compositionImpl) {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(compositionImpl)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(compositionImpl);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    public final List knownCompositionsLocked() {
        ?? r0 = this._knownCompositionsCache;
        if (r0 != 0) {
            return r0;
        }
        ArrayList arrayList = this._knownCompositions;
        List arrayList2 = arrayList.isEmpty() ? EmptyList.INSTANCE : new ArrayList(arrayList);
        this._knownCompositionsCache = arrayList2;
        return arrayList2;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final MovableContentState movableContentStateResolve$runtime(MovableContentStateReference movableContentStateReference) {
        MovableContentState movableContentState;
        synchronized (this.stateLock) {
            movableContentState = (MovableContentState) this.movableContentStatesAvailable.remove(movableContentStateReference);
        }
        return movableContentState;
    }

    public final void onNewFrameAwaiter() {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
            if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                Throwable th = this.closeCause;
                CancellationException cancellationException = new CancellationException("Recomposer shutdown; frame clock awaiter will never resume");
                cancellationException.initCause(th);
                throw cancellationException;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
        }
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void performInitialMovableContentInserts(CompositionImpl compositionImpl) {
        synchronized (this.stateLock) {
            ArrayList arrayList = this.movableContentAwaitingInsert;
            if (arrayList.size() > 0) {
                ((MovableContentStateReference) arrayList.get(0)).getClass();
                throw null;
            }
        }
    }

    public final List performInsertValues(List list, MutableScatterSet mutableScatterSet) {
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        ArrayList arrayList;
        HashMap map = new HashMap(list.size());
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            ((MovableContentStateReference) obj).getClass();
            Object arrayList2 = map.get(null);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(null, arrayList2);
            }
            ((ArrayList) arrayList2).add(obj);
        }
        for (Map.Entry entry : map.entrySet()) {
            CompositionImpl compositionImpl = (CompositionImpl) entry.getKey();
            List list2 = (List) entry.getValue();
            if (compositionImpl.composer.isComposing) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(i, compositionImpl);
            BlurEffectKt$$ExternalSyntheticLambda1 blurEffectKt$$ExternalSyntheticLambda1 = new BlurEffectKt$$ExternalSyntheticLambda1(8, compositionImpl, mutableScatterSet);
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(recomposer$$ExternalSyntheticLambda0, blurEffectKt$$ExternalSyntheticLambda1)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        try {
                            arrayList = new ArrayList(list2.size());
                            int size2 = list2.size();
                            for (int i3 = i; i3 < size2; i3++) {
                                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) list2.get(i3);
                                MutableScatterMap mutableScatterMap = this.movableContentRemoved;
                                movableContentStateReference.getClass();
                                Object objM296removeLastimpl = MultiValueMap.m296removeLastimpl(mutableScatterMap);
                                arrayList.add(new Pair(movableContentStateReference, objM296removeLastimpl));
                            }
                            int size3 = arrayList.size();
                            for (int i4 = 0; i4 < size3; i4++) {
                                Pair pair = (Pair) arrayList.get(i4);
                                if (pair.second == null) {
                                    SurfaceRequest.AnonymousClass1 anonymousClass1 = this.movableContentNestedStatesAvailable;
                                    ((MovableContentStateReference) pair.first).getClass();
                                    if (((MutableScatterMap) anonymousClass1.val$requestCancellationCompleter).contains(null)) {
                                        ArrayList arrayList3 = new ArrayList(arrayList.size());
                                        int size4 = arrayList.size();
                                        for (int i5 = 0; i5 < size4; i5++) {
                                            Pair pair2 = (Pair) arrayList.get(i5);
                                            if (pair2.second == null) {
                                                SurfaceRequest.AnonymousClass1 anonymousClass2 = this.movableContentNestedStatesAvailable;
                                                ((MovableContentStateReference) pair2.first).getClass();
                                                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) anonymousClass2.val$requestCancellationCompleter;
                                                if (mutableScatterMap2.isEmpty()) {
                                                    ((MutableScatterMap) anonymousClass2.val$requestCancellationFuture).clear();
                                                }
                                            }
                                            arrayList3.add(pair2);
                                        }
                                        arrayList = arrayList3;
                                        break;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    int size5 = arrayList.size();
                    for (int i6 = 0; i6 < size5; i6++) {
                        if (((Pair) arrayList.get(i6)).second != null) {
                            int size6 = arrayList.size();
                            for (int i7 = 0; i7 < size6; i7++) {
                                if (((Pair) arrayList.get(i7)).second == null) {
                                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                                    int size7 = arrayList.size();
                                    for (int i8 = 0; i8 < size7; i8++) {
                                        Pair pair3 = (Pair) arrayList.get(i8);
                                        if (pair3.second == null) {
                                        }
                                    }
                                    synchronized (this.stateLock) {
                                        CollectionsKt__MutableCollectionsKt.addAll(arrayList4, this.movableContentAwaitingInsert);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    ArrayList arrayList5 = new ArrayList(arrayList.size());
                                    int size8 = arrayList.size();
                                    for (int i9 = 0; i9 < size8; i9++) {
                                        Object obj2 = arrayList.get(i9);
                                        if (((Pair) obj2).second != null) {
                                            arrayList5.add(obj2);
                                        }
                                    }
                                    arrayList = arrayList5;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    compositionImpl.insertMovableContent(arrayList);
                    Unit unit2 = Unit.INSTANCE;
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                    i = 0;
                } catch (Throwable th2) {
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th2;
                }
            } catch (Throwable th3) {
                applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                throw th3;
            }
        }
        return CollectionsKt.toList(map.keySet());
    }

    public final CompositionImpl performRecompose(CompositionImpl compositionImpl, MutableScatterSet mutableScatterSet) {
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        if (compositionImpl.composer.isComposing || compositionImpl.state == 3) {
            return null;
        }
        MutableScatterSet mutableScatterSet2 = this.compositionsRemoved;
        if (mutableScatterSet2 == null || !mutableScatterSet2.contains(compositionImpl)) {
            Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(0, compositionImpl);
            BlurEffectKt$$ExternalSyntheticLambda1 blurEffectKt$$ExternalSyntheticLambda1 = new BlurEffectKt$$ExternalSyntheticLambda1(8, compositionImpl, mutableScatterSet);
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(recomposer$$ExternalSyntheticLambda0, blurEffectKt$$ExternalSyntheticLambda1)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                if (mutableScatterSet != null) {
                    try {
                        if (mutableScatterSet.isNotEmpty()) {
                            Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6(0, mutableScatterSet, compositionImpl);
                            GapComposer gapComposer = compositionImpl.composer;
                            if (gapComposer.isComposing) {
                                ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
                            }
                            gapComposer.isComposing = true;
                            try {
                                recomposer$$ExternalSyntheticLambda6.invoke();
                                gapComposer.isComposing = false;
                            } catch (Throwable th) {
                                gapComposer.isComposing = false;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        Snapshot.restoreCurrent(snapshotMakeCurrent);
                        throw th2;
                    }
                }
                boolean zRecompose = compositionImpl.recompose();
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                if (zRecompose) {
                    return compositionImpl;
                }
            } catch (Throwable th3) {
                applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                throw th3;
            }
        }
        return null;
    }

    public final void processCompositionError(Throwable th, CompositionImpl compositionImpl) throws Throwable {
        if (!((Boolean) _hotReloadEnabled.get()).booleanValue() || (th instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                Log.e("ComposeInternal", "Error was captured in composition.", th);
                RecomposerErrorState recomposerErrorState = (RecomposerErrorState) this.errorState.getValue();
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.cause;
                }
                StateFlowImpl stateFlowImpl = this.errorState;
                RecomposerErrorState recomposerErrorState2 = new RecomposerErrorState(th);
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, recomposerErrorState2);
                Unit unit = Unit.INSTANCE;
            }
            throw th;
        }
        synchronized (this.stateLock) {
            try {
                Log.e("ComposeInternal", "Error was captured in composition while live edit was enabled.", th);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet();
                this.movableContentAwaitingInsert.clear();
                this.movableContentRemoved.clear();
                this.movableContentStatesAvailable.clear();
                StateFlowImpl stateFlowImpl2 = this.errorState;
                RecomposerErrorState recomposerErrorState3 = new RecomposerErrorState(th);
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, recomposerErrorState3);
                if (compositionImpl != null) {
                    recordFailedCompositionLocked(compositionImpl);
                }
                if (deriveStateLocked() != null) {
                    ComposerKt.composeImmediateRuntimeError("expected to go to inactive state due to composition error");
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final MutableScatterSet recomposePaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, MutableScatterSet mutableScatterSet) {
        MenuHostHelper menuHostHelper = this.pausedScopes;
        try {
            recordComposerModifications();
            compositionImpl.recordModificationsOf(new ScatterSetWrapper(mutableScatterSet));
            ShouldPauseCallback shouldPauseCallback2 = compositionImpl.shouldPause;
            compositionImpl.shouldPause = shouldPauseCallback;
            try {
                CompositionImpl compositionImplPerformRecompose = performRecompose(compositionImpl, null);
                if (compositionImplPerformRecompose != null) {
                    performInitialMovableContentInserts(compositionImpl);
                    compositionImplPerformRecompose.applyChanges();
                    compositionImplPerformRecompose.applyLateChanges();
                }
                MutableScatterSet mutableScatterSet2 = (MutableScatterSet) menuHostHelper.get();
                if (mutableScatterSet2 == null) {
                    mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                }
                compositionImpl.shouldPause = shouldPauseCallback2;
                menuHostHelper.set(null);
                return mutableScatterSet2;
            } catch (Throwable th) {
                compositionImpl.shouldPause = shouldPauseCallback2;
                throw th;
            }
        } catch (Throwable th2) {
            menuHostHelper.set(null);
            throw th2;
        }
    }

    public final boolean recordComposerModifications() {
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            List listKnownCompositionsLocked = knownCompositionsLocked();
            ScatterSetWrapper scatterSetWrapper = new ScatterSetWrapper(this.snapshotInvalidations);
            this.snapshotInvalidations = new MutableScatterSet();
            try {
                int size = listKnownCompositionsLocked.size();
                for (int i = 0; i < size; i++) {
                    ((CompositionImpl) listKnownCompositionsLocked.get(i)).recordModificationsOf(scatterSetWrapper);
                    if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    MutableScatterSet mutableScatterSet = this.snapshotInvalidations;
                    int i2 = mutableScatterSet._size;
                    Iterator<E> it = scatterSetWrapper.iterator();
                    while (it.hasNext()) {
                        mutableScatterSet.plusAssign(it.next());
                    }
                    throw th;
                }
            }
        }
    }

    public final void recordFailedCompositionLocked(CompositionImpl compositionImpl) {
        ArrayList arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(compositionImpl)) {
            arrayList.add(compositionImpl);
        }
        if (this._knownCompositions.remove(compositionImpl)) {
            this._knownCompositionsCache = null;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void reportPausedScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
        MenuHostHelper menuHostHelper = this.pausedScopes;
        MutableScatterSet mutableScatterSet = (MutableScatterSet) menuHostHelper.get();
        if (mutableScatterSet == null) {
            MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
            mutableScatterSet = new MutableScatterSet();
            menuHostHelper.set(mutableScatterSet);
        }
        mutableScatterSet.add(recomposeScopeImpl);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void reportRemovedComposition$runtime(CompositionImpl compositionImpl) {
        synchronized (this.stateLock) {
            try {
                MutableScatterSet mutableScatterSet = this.compositionsRemoved;
                if (mutableScatterSet == null) {
                    MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                    mutableScatterSet = new MutableScatterSet();
                    this.compositionsRemoved = mutableScatterSet;
                }
                mutableScatterSet.add(compositionImpl);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final CancellationHandle scheduleFrameEndCallback(Handshake.AnonymousClass2 anonymousClass2) {
        MenuHostHelper menuHostHelper = this.nextFrameEndCallbackQueue;
        Request request = (Request) menuHostHelper.mMenuProviders;
        NextFrameEndCallbackQueue$NextFrameEndAwaiter nextFrameEndCallbackQueue$NextFrameEndAwaiter = new NextFrameEndCallbackQueue$NextFrameEndAwaiter();
        nextFrameEndCallbackQueue$NextFrameEndAwaiter.onNextFrameEnd = anonymousClass2;
        return request.addAwaiter(nextFrameEndCallbackQueue$NextFrameEndAwaiter, (Recomposer$$ExternalSyntheticLambda6) menuHostHelper.mProviderToLifecycleContainers);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void unregisterComposition$runtime(CompositionImpl compositionImpl) {
        synchronized (this.stateLock) {
            if (this._knownCompositions.remove(compositionImpl)) {
                this._knownCompositionsCache = null;
            }
            this.compositionInvalidations.remove(compositionImpl);
            this.compositionsAwaitingApply.remove(compositionImpl);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void recordInspectionTable$runtime(Set set) {
    }
}
