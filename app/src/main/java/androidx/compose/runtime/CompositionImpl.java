package androidx.compose.runtime;

import android.os.Trace;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.MutableSetWrapper;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapAnchorKt;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.core.view.MenuHostHelper;
import coil.network.HttpException;
import coil.request.Parameters;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionImpl implements Composition {
    public final MutableSetWrapper abandonSet;
    public final MenuHostHelper applier;
    public final ChangeList changes;
    public final GapComposer composer;
    public final MutableScatterSet conditionallyInvalidatedScopes;
    public final MutableScatterMap derivedStates;
    public final MutableScatterSet invalidatedScopes;
    public CompositionImpl invalidationDelegate;
    public int invalidationDelegateGroup;
    public MutableScatterMap invalidations;
    public final ChangeList lateChanges;
    public final MutableScatterMap observations;
    public final MutableScatterMap observationsProcessed;
    public final Parameters.Builder observerHolder;
    public final CompositionContext parent;
    public boolean pendingInvalidScopes;
    public PausedCompositionImpl pendingPausedComposition;
    public final zzky rememberManager;
    public ShouldPauseCallback shouldPause;
    public final SlotTable slotStorage;
    public int state;
    public final AtomicReference pendingModifications = new AtomicReference(null);
    public final Object lock = new Object();

    public CompositionImpl(CompositionContext compositionContext, MenuHostHelper menuHostHelper) {
        this.parent = compositionContext;
        this.applier = menuHostHelper;
        MutableSetWrapper mutableSetWrapper = new MutableSetWrapper(new MutableScatterSet());
        this.abandonSet = mutableSetWrapper;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable.calledByMap = new MutableIntObjectMap();
        }
        if (compositionContext.getCollectingSourceInformation$runtime()) {
            slotTable.collectSourceInformation();
        }
        this.slotStorage = slotTable;
        this.observations = ScopeMap.m298constructorimpl$default();
        this.invalidatedScopes = new MutableScatterSet();
        this.conditionallyInvalidatedScopes = new MutableScatterSet();
        this.derivedStates = ScopeMap.m298constructorimpl$default();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = ScopeMap.m298constructorimpl$default();
        this.invalidations = ScopeMap.m298constructorimpl$default();
        Parameters.Builder builder = new Parameters.Builder(2, compositionContext);
        this.observerHolder = builder;
        this.rememberManager = new zzky();
        GapComposer gapComposer = new GapComposer(menuHostHelper, compositionContext, SlotTableKt.asGapBufferSlotTable(slotTable), mutableSetWrapper, changeList, changeList2, builder, this);
        compositionContext.registerComposer$runtime(gapComposer);
        this.composer = gapComposer;
    }

    public final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        MutableSetWrapper mutableSetWrapper = this.abandonSet;
        if (mutableSetWrapper.parent$1.isEmpty()) {
            return;
        }
        zzky zzkyVar = this.rememberManager;
        try {
            zzkyVar.prepare(mutableSetWrapper, this.composer.getErrorContext$runtime());
            zzkyVar.dispatchAbandons();
        } finally {
            zzkyVar.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    public final void addPendingInvalidationsLocked(Object obj, boolean z) {
        int i;
        Object obj2 = this.observations.get(obj);
        if (obj2 == null) {
            return;
        }
        boolean z2 = obj2 instanceof MutableScatterSet;
        MutableScatterSet mutableScatterSet = this.invalidatedScopes;
        MutableScatterSet mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        MutableScatterMap mutableScatterMap = this.observationsProcessed;
        if (!z2) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
            if (ScopeMap.m299removeimpl(mutableScatterMap, obj, recomposeScopeImpl) || recomposeScopeImpl.invalidateForResult(obj) == 1) {
                return;
            }
            if (recomposeScopeImpl.trackedDependencies == null || z) {
                mutableScatterSet.add(recomposeScopeImpl);
                return;
            } else {
                mutableScatterSet2.add(recomposeScopeImpl);
                return;
            }
        }
        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
        Object[] objArr = mutableScatterSet3.elements;
        long[] jArr = mutableScatterSet3.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((j & 255) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i2 << 3) + i5];
                        if (ScopeMap.m299removeimpl(mutableScatterMap, obj, recomposeScopeImpl2)) {
                            i = i3;
                        } else {
                            i = i3;
                            if (recomposeScopeImpl2.invalidateForResult(obj) != 1) {
                                if (recomposeScopeImpl2.trackedDependencies == null || z) {
                                    mutableScatterSet.add(recomposeScopeImpl2);
                                } else {
                                    mutableScatterSet2.add(recomposeScopeImpl2);
                                }
                            }
                        }
                    } else {
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                }
                if (i4 != i3) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        zzky zzkyVar = this.rememberManager;
                        try {
                            zzkyVar.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            zzkyVar.dispatchAbandons();
                        } finally {
                            zzkyVar.clear();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:164:0x013c A[EDGE_INSN: B:164:0x013c->B:82:0x013c BREAK  A[LOOP:2: B:144:0x00ef->B:80:0x0132], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0130 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0132 A[Catch: all -> 0x0122, LOOP:2: B:144:0x00ef->B:80:0x0132, LOOP_END, TryCatch #3 {all -> 0x0122, blocks: (B:64:0x00ef, B:66:0x00fe, B:68:0x0108, B:70:0x010e, B:72:0x011e, B:76:0x0127, B:82:0x013c, B:90:0x015b, B:93:0x016e, B:80:0x0132, B:85:0x0146, B:99:0x018c, B:101:0x0198), top: B:144:0x00ef }] */
    public final void applyChangesInLocked(ChangeList changeList) throws Throwable {
        MenuHostHelper menuHostHelper;
        zzky zzkyVar;
        zzky zzkyVar2;
        long[] jArr;
        int i;
        long[] jArr2;
        zzky zzkyVar3;
        long j;
        char c;
        long j2;
        int i2;
        boolean zIsEmpty;
        long j3;
        ChangeList changeList2 = this.lateChanges;
        GapComposer gapComposer = this.composer;
        CompositionErrorContextImpl errorContext$runtime = gapComposer.getErrorContext$runtime();
        zzky zzkyVar4 = this.rememberManager;
        zzkyVar4.prepare(this.abandonSet, errorContext$runtime);
        try {
            if (changeList.operations.isEmpty()) {
                try {
                    if (changeList2.operations.isEmpty() && this.pendingPausedComposition == null) {
                        zzkyVar4.dispatchAbandons();
                    }
                    return;
                } finally {
                    zzkyVar4.clear();
                }
            }
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            if (pausedCompositionImpl == null || (menuHostHelper = pausedCompositionImpl.pausableApplier) == null) {
                menuHostHelper = this.applier;
            }
            try {
                Trace.beginSection(menuHostHelper.equals(pausedCompositionImpl != null ? pausedCompositionImpl.pausableApplier : null) ? "Compose:recordChanges" : "Compose:applyChanges");
                try {
                    PausedCompositionImpl pausedCompositionImpl2 = this.pendingPausedComposition;
                    if (pausedCompositionImpl2 == null || (zzkyVar = pausedCompositionImpl2.rememberManager) == null) {
                        zzkyVar = zzkyVar4;
                    }
                    SlotTable slotTable = this.slotStorage;
                    CompositionErrorContextImpl errorContext$runtime2 = gapComposer.getErrorContext$runtime();
                    SlotWriter slotWriterOpenWriter = SlotTableKt.asGapBufferSlotTable(slotTable).openWriter();
                    int i3 = 0;
                    try {
                        changeList.executeAndFlushAllPendingChanges(menuHostHelper, slotWriterOpenWriter, zzkyVar, errorContext$runtime2);
                        Unit unit = Unit.INSTANCE;
                        slotWriterOpenWriter.close(true);
                        menuHostHelper.onEndChanges();
                        Trace.endSection();
                        zzkyVar4.dispatchRememberObservers();
                        zzkyVar4.dispatchSideEffects();
                        if (this.pendingInvalidScopes) {
                            Trace.beginSection("Compose:unobserve");
                            try {
                                this.pendingInvalidScopes = false;
                                MutableScatterMap mutableScatterMap = this.observations;
                                long[] jArr3 = mutableScatterMap.metadata;
                                int length = jArr3.length - 2;
                                if (length >= 0) {
                                    int i4 = 0;
                                    while (true) {
                                        long j4 = jArr3[i4];
                                        char c2 = 7;
                                        long j5 = -9187201950435737472L;
                                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i5 = 8;
                                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                                            int i7 = i3;
                                            while (i7 < i6) {
                                                if ((j4 & 255) < 128) {
                                                    c = c2;
                                                    int i8 = (i4 << 3) + i7;
                                                    j2 = j5;
                                                    Object obj = mutableScatterMap.keys[i8];
                                                    Object obj2 = mutableScatterMap.values[i8];
                                                    if (obj2 instanceof MutableScatterSet) {
                                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                        Object[] objArr = mutableScatterSet.elements;
                                                        long[] jArr4 = mutableScatterSet.metadata;
                                                        int i9 = i5;
                                                        int length2 = jArr4.length - 2;
                                                        i = i7;
                                                        jArr2 = jArr3;
                                                        zzkyVar3 = zzkyVar4;
                                                        if (length2 >= 0) {
                                                            int i10 = 0;
                                                            while (true) {
                                                                try {
                                                                    long j6 = jArr4[i10];
                                                                    j = j4;
                                                                    long[] jArr5 = jArr4;
                                                                    if ((((~j6) << c) & j6 & j2) == j2) {
                                                                        if (i10 != length2) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i10++;
                                                                        jArr4 = jArr5;
                                                                        j4 = j;
                                                                        i9 = 8;
                                                                    } else {
                                                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                                        for (int i12 = 0; i12 < i11; i12++) {
                                                                            if ((j6 & 255) < 128) {
                                                                                j3 = j6;
                                                                                int i13 = (i10 << 3) + i12;
                                                                                if (!((RecomposeScopeImpl) objArr[i13]).getValid()) {
                                                                                    mutableScatterSet.removeElementAt(i13);
                                                                                }
                                                                            } else {
                                                                                j3 = j6;
                                                                            }
                                                                            j6 = j3 >> i9;
                                                                        }
                                                                        if (i11 != i9) {
                                                                            break;
                                                                        }
                                                                        if (i10 != length2) {
                                                                            break;
                                                                        }
                                                                        i10++;
                                                                        jArr4 = jArr5;
                                                                        j4 = j;
                                                                        i9 = 8;
                                                                    }
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    Trace.endSection();
                                                                    throw th;
                                                                }
                                                            }
                                                        } else {
                                                            j = j4;
                                                        }
                                                        zIsEmpty = mutableScatterSet.isEmpty();
                                                    } else {
                                                        i = i7;
                                                        jArr2 = jArr3;
                                                        zzkyVar3 = zzkyVar4;
                                                        j = j4;
                                                        zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                    }
                                                    if (zIsEmpty) {
                                                        mutableScatterMap.removeValueAt(i8);
                                                    }
                                                    i2 = 8;
                                                } else {
                                                    i = i7;
                                                    jArr2 = jArr3;
                                                    zzkyVar3 = zzkyVar4;
                                                    j = j4;
                                                    c = c2;
                                                    j2 = j5;
                                                    i2 = i5;
                                                }
                                                j4 = j >> i2;
                                                i7 = i + 1;
                                                i5 = i2;
                                                c2 = c;
                                                j5 = j2;
                                                zzkyVar4 = zzkyVar3;
                                                jArr3 = jArr2;
                                            }
                                            jArr = jArr3;
                                            zzkyVar2 = zzkyVar4;
                                            if (i6 != i5) {
                                                break;
                                            }
                                        } else {
                                            jArr = jArr3;
                                            zzkyVar2 = zzkyVar4;
                                        }
                                        if (i4 == length) {
                                            break;
                                        }
                                        i4++;
                                        zzkyVar4 = zzkyVar2;
                                        jArr3 = jArr;
                                        i3 = 0;
                                    }
                                } else {
                                    zzkyVar2 = zzkyVar4;
                                }
                                cleanUpDerivedStateObservations();
                                Unit unit2 = Unit.INSTANCE;
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            zzkyVar2 = zzkyVar4;
                        }
                        try {
                            if (changeList2.operations.isEmpty() && this.pendingPausedComposition == null) {
                                zzkyVar2.dispatchAbandons();
                            }
                            return;
                        } finally {
                            zzkyVar2.clear();
                        }
                    } catch (Throwable th3) {
                        try {
                            slotWriterOpenWriter.close(false);
                            throw th3;
                        } catch (Throwable th4) {
                            th = th4;
                            Trace.endSection();
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
        try {
            if (changeList2.operations.isEmpty() && this.pendingPausedComposition == null) {
                zzkyVar4.dispatchAbandons();
            }
            throw th;
        } finally {
            zzkyVar4.clear();
        }
    }

    public final void applyLateChanges() {
        synchronized (this.lock) {
            try {
                ChangeList changeList = this.lateChanges;
                changeList.getClass();
                if (!changeList.operations.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        zzky zzkyVar = this.rememberManager;
                        try {
                            zzkyVar.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            zzkyVar.dispatchAbandons();
                        } finally {
                            zzkyVar.clear();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    public final void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.providerUpdates = null;
                if (!this.abandonSet.parent$1.isEmpty()) {
                    zzky zzkyVar = this.rememberManager;
                    try {
                        zzkyVar.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        zzkyVar.dispatchAbandons();
                        zzkyVar.clear();
                    } catch (Throwable th) {
                        zzkyVar.clear();
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        zzky zzkyVar2 = this.rememberManager;
                        try {
                            zzkyVar2.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            zzkyVar2.dispatchAbandons();
                        } finally {
                            zzkyVar2.clear();
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a1 A[LOOP:2: B:16:0x005a->B:30:0x00a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x00b0 A[EDGE_INSN: B:83:0x00b0->B:32:0x00b0 BREAK  A[LOOP:2: B:16:0x005a->B:30:0x00a1], SYNTHETIC] */
    public final void cleanUpDerivedStateObservations() {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4;
        char c2;
        long j5;
        long j6;
        int i2;
        boolean zIsEmpty;
        int i3;
        long j7;
        MutableScatterMap mutableScatterMap = this.derivedStates;
        long[] jArr3 = mutableScatterMap.metadata;
        int length = jArr3.length - 2;
        char c3 = 7;
        long j8 = -9187201950435737472L;
        int i4 = 8;
        if (length >= 0) {
            int i5 = 0;
            long j9 = 128;
            while (true) {
                long j10 = jArr3[i5];
                j2 = 255;
                if ((((~j10) << c3) & j10 & j8) != j8) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j10 & 255) < j9) {
                            c2 = c3;
                            int i8 = (i5 << 3) + i7;
                            j5 = j8;
                            Object obj = mutableScatterMap.keys[i8];
                            Object obj2 = mutableScatterMap.values[i8];
                            boolean z = obj2 instanceof MutableScatterSet;
                            MutableScatterMap mutableScatterMap2 = this.observations;
                            if (z) {
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                j6 = j9;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    j4 = j10;
                                    int i9 = i4;
                                    int i10 = 0;
                                    while (true) {
                                        long j11 = jArr4[i10];
                                        jArr2 = jArr3;
                                        i = length;
                                        if ((((~j11) << c2) & j11 & j5) == j5) {
                                            if (i10 != length2) {
                                                break;
                                                break;
                                            }
                                            i10++;
                                            jArr3 = jArr2;
                                            length = i;
                                            i9 = 8;
                                        } else {
                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                            int i12 = 0;
                                            while (i12 < i11) {
                                                if ((j11 & 255) < j6) {
                                                    i3 = i12;
                                                    int i13 = (i10 << 3) + i3;
                                                    j7 = j11;
                                                    if (!mutableScatterMap2.containsKey((DerivedSnapshotState) objArr[i13])) {
                                                        mutableScatterSet.removeElementAt(i13);
                                                    }
                                                } else {
                                                    i3 = i12;
                                                    j7 = j11;
                                                }
                                                j11 = j7 >> i9;
                                                i12 = i3 + 1;
                                            }
                                            if (i11 != i9) {
                                                break;
                                            }
                                            if (i10 != length2) {
                                                break;
                                            }
                                            i10++;
                                            jArr3 = jArr2;
                                            length = i;
                                            i9 = 8;
                                        }
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    i = length;
                                    j4 = j10;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr3;
                                i = length;
                                j4 = j10;
                                j6 = j9;
                                zIsEmpty = !mutableScatterMap2.containsKey((DerivedSnapshotState) obj2);
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i8);
                            }
                            i2 = 8;
                        } else {
                            jArr2 = jArr3;
                            i = length;
                            j4 = j10;
                            c2 = c3;
                            j5 = j8;
                            j6 = j9;
                            i2 = i4;
                        }
                        j10 = j4 >> i2;
                        i7++;
                        i4 = i2;
                        c3 = c2;
                        j8 = j5;
                        j9 = j6;
                        jArr3 = jArr2;
                        length = i;
                    }
                    jArr = jArr3;
                    int i14 = length;
                    c = c3;
                    j = j8;
                    j3 = j9;
                    if (i6 != i4) {
                        break;
                    } else {
                        length = i14;
                    }
                } else {
                    jArr = jArr3;
                    c = c3;
                    j = j8;
                    j3 = j9;
                }
                if (i5 == length) {
                    break;
                }
                i5++;
                c3 = c;
                j8 = j;
                j9 = j3;
                jArr3 = jArr;
                i4 = 8;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 255;
            j3 = 128;
        }
        MutableScatterSet mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        if (!mutableScatterSet2.isNotEmpty()) {
            return;
        }
        Object[] objArr2 = mutableScatterSet2.elements;
        long[] jArr5 = mutableScatterSet2.metadata;
        int length3 = jArr5.length - 2;
        if (length3 < 0) {
            return;
        }
        int i15 = 0;
        while (true) {
            long j12 = jArr5[i15];
            if ((((~j12) << c) & j12 & j) != j) {
                int i16 = 8 - ((~(i15 - length3)) >>> 31);
                for (int i17 = 0; i17 < i16; i17++) {
                    if ((j12 & j2) < j3) {
                        int i18 = (i15 << 3) + i17;
                        if (!(((RecomposeScopeImpl) objArr2[i18]).trackedDependencies != null)) {
                            mutableScatterSet2.removeElementAt(i18);
                        }
                    }
                    j12 >>= 8;
                }
                if (i16 != 8) {
                    return;
                }
            }
            if (i15 == length3) {
                return;
            } else {
                i15++;
            }
        }
    }

    public final boolean clearDeactivated() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            if (z) {
                this.state = 0;
            }
        }
        return z;
    }

    public final void composeContent(Function2 function2) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap mutableScatterMap = this.invalidations;
                this.invalidations = ScopeMap.m298constructorimpl$default();
                try {
                    GapComposer gapComposer = this.composer;
                    ShouldPauseCallback shouldPauseCallback = this.shouldPause;
                    if (!gapComposer.changes.operations.isEmpty()) {
                        ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
                    }
                    gapComposer.shouldPauseCallback = shouldPauseCallback;
                    try {
                        gapComposer.m288doComposeaFTiNEg(mutableScatterMap, function2);
                        gapComposer.shouldPauseCallback = null;
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        gapComposer.shouldPauseCallback = null;
                        throw th;
                    }
                } catch (Throwable th2) {
                    this.invalidations = mutableScatterMap;
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                if (!this.abandonSet.parent$1.isEmpty()) {
                    zzky zzkyVar = this.rememberManager;
                    try {
                        zzkyVar.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        zzkyVar.dispatchAbandons();
                    } finally {
                        zzkyVar.clear();
                    }
                }
                throw th3;
            } catch (Throwable th4) {
                abandonChanges();
                throw th4;
            }
        }
    }

    public final PausedCompositionImpl composeInitialPaused(boolean z, Function2 function2) {
        if (this.pendingPausedComposition != null) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, function2, z, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    public final void deactivate() {
        synchronized (this.lock) {
            try {
                if (this.pendingPausedComposition != null) {
                    PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
                }
                boolean z = this.slotStorage.groupsSize == 0;
                if (!z || !this.abandonSet.parent$1.isEmpty()) {
                    Trace.beginSection("Compose:deactivate");
                    try {
                        zzky zzkyVar = this.rememberManager;
                        try {
                            zzkyVar.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            if (!z) {
                                SlotTable slotTable = this.slotStorage;
                                zzky zzkyVar2 = this.rememberManager;
                                SlotWriter slotWriterOpenWriter = slotTable.openWriter();
                                try {
                                    slotWriterOpenWriter.forAllDataInRememberOrder(slotWriterOpenWriter.currentGroup, new TextKt$$ExternalSyntheticLambda2(20, zzkyVar2, slotWriterOpenWriter));
                                    Unit unit = Unit.INSTANCE;
                                    slotWriterOpenWriter.close(true);
                                    this.applier.onEndChanges();
                                    zzkyVar.dispatchRememberObservers();
                                } catch (Throwable th) {
                                    slotWriterOpenWriter.close(false);
                                    throw th;
                                }
                            }
                            zzkyVar.dispatchAbandons();
                            zzkyVar.clear();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.endSection();
                        } catch (Throwable th2) {
                            zzkyVar.clear();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                this.observations.clear();
                this.derivedStates.clear();
                this.invalidations.clear();
                this.changes.clear();
                this.lateChanges.clear();
                GapComposer gapComposer = this.composer;
                gapComposer.invalidateStack.clear();
                gapComposer.invalidations.clear();
                gapComposer.changes.clear();
                gapComposer.providerUpdates = null;
                this.state = 1;
                Unit unit3 = Unit.INSTANCE;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final void dispose() {
        synchronized (this.lock) {
            try {
                if (this.composer.isComposing) {
                    PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (this.state != 3) {
                    this.state = 3;
                    ChangeList changeList = this.composer.deferredChanges;
                    if (changeList != null) {
                        applyChangesInLocked(changeList);
                    }
                    boolean z = this.slotStorage.groupsSize == 0;
                    if (!z || !this.abandonSet.parent$1.isEmpty()) {
                        zzky zzkyVar = this.rememberManager;
                        try {
                            zzkyVar.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            if (!z) {
                                SlotTable slotTable = this.slotStorage;
                                zzky zzkyVar2 = this.rememberManager;
                                SlotWriter slotWriterOpenWriter = slotTable.openWriter();
                                try {
                                    slotWriterOpenWriter.forAllDataInRememberOrder(slotWriterOpenWriter.currentGroup, new Updater$$ExternalSyntheticLambda0(20, zzkyVar2));
                                    slotWriterOpenWriter.removeGroup();
                                    Unit unit = Unit.INSTANCE;
                                    slotWriterOpenWriter.close(true);
                                    this.applier.clear();
                                    this.applier.onEndChanges();
                                    zzkyVar.dispatchRememberObservers();
                                } catch (Throwable th) {
                                    slotWriterOpenWriter.close(false);
                                    throw th;
                                }
                            }
                            zzkyVar.dispatchAbandons();
                            zzkyVar.clear();
                        } catch (Throwable th2) {
                            zzkyVar.clear();
                            throw th2;
                        }
                    }
                    GapComposer gapComposer = this.composer;
                    gapComposer.getClass();
                    Trace.beginSection("Compose:Composer.dispose");
                    try {
                        gapComposer.parentContext.unregisterComposer$runtime(gapComposer);
                        gapComposer.invalidateStack.clear();
                        gapComposer.invalidations.clear();
                        gapComposer.changes.clear();
                        gapComposer.providerUpdates = null;
                        gapComposer.applier.clear();
                        Unit unit2 = Unit.INSTANCE;
                        Trace.endSection();
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            } catch (Throwable th4) {
                throw th4;
            }
        }
        this.parent.unregisterComposition$runtime(this);
    }

    public final void drainPendingModificationsForCompositionLocked() {
        Object obj = Stack.PendingApplyNoModifications;
        AtomicReference atomicReference = this.pendingModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            if (andSet.equals(obj)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new HttpException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
                throw new HttpException();
            }
            for (Set set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    public final void drainPendingModificationsLocked() {
        AtomicReference atomicReference = this.pendingModifications;
        Object andSet = atomicReference.getAndSet(null);
        if (Intrinsics.areEqual(andSet, Stack.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet != null) {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
            throw new HttpException();
        }
        if (this.pendingPausedComposition == null) {
            ComposerKt.composeImmediateRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
        }
    }

    public final void drainPendingModificationsOutOfBandLocked() {
        EmptySet emptySet = EmptySet.INSTANCE;
        AtomicReference atomicReference = this.pendingModifications;
        Object andSet = atomicReference.getAndSet(emptySet);
        if (Intrinsics.areEqual(andSet, Stack.PendingApplyNoModifications) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
            throw new HttpException();
        }
        for (Set set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    public final void ensureRunning() {
        String str;
        int i = this.state;
        if (i != 0) {
            if (i == 1) {
                str = "The composition should be activated before setting content.";
            } else if (i != 2) {
                str = i != 3 ? "" : "The composition is disposed";
            } else {
                str = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            }
            PreconditionsKt.throwIllegalStateException(str);
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    public final void insertMovableContent(ArrayList arrayList) {
        MutableSetWrapper mutableSetWrapper = this.abandonSet;
        GapComposer gapComposer = this.composer;
        if (arrayList.size() > 0) {
            ((MovableContentStateReference) ((Pair) arrayList.get(0)).first).getClass();
            throw null;
        }
        try {
            gapComposer.getClass();
            Trace.beginSection("Compose:insertMovableContent");
            try {
                try {
                    gapComposer.insertMovableContentGuarded(arrayList);
                    gapComposer.cleanUpCompose();
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                } catch (Throwable th) {
                    gapComposer.abortRoot();
                    throw th;
                }
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                if (!mutableSetWrapper.parent$1.isEmpty()) {
                    zzky zzkyVar = this.rememberManager;
                    try {
                        zzkyVar.prepare(mutableSetWrapper, gapComposer.getErrorContext$runtime());
                        zzkyVar.dispatchAbandons();
                    } finally {
                        zzkyVar.clear();
                    }
                }
                throw th3;
            } catch (Throwable th4) {
                abandonChanges();
                throw th4;
            }
        }
    }

    public final int invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        CompositionImpl compositionImpl;
        int i = recomposeScopeImpl.flags;
        if ((i & 2) != 0) {
            recomposeScopeImpl.flags = i | 4;
        }
        GapAnchor gapAnchor = recomposeScopeImpl.anchor;
        if (gapAnchor == null || !gapAnchor.getValid()) {
            return 1;
        }
        SlotTable slotTable = this.slotStorage;
        slotTable.getClass();
        GapAnchor gapAnchor2 = recomposeScopeImpl.anchor;
        if (gapAnchor2 != null && slotTable.ownsAnchor(GapAnchorKt.asGapAnchor(gapAnchor2))) {
            if (recomposeScopeImpl.block == null) {
                return 1;
            }
            int iInvalidateChecked = invalidateChecked(recomposeScopeImpl, gapAnchor, obj);
            if (iInvalidateChecked != 1) {
                this.observerHolder.current();
            }
            return iInvalidateChecked;
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null) {
            GapComposer gapComposer = compositionImpl.composer;
            if (gapComposer.isComposing && gapComposer.tryImminentInvalidation$runtime(recomposeScopeImpl, obj)) {
                return 4;
            }
        }
        return 1;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:69:0x00eb  */
    public final int invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, GapAnchor gapAnchor, Object obj) {
        int i;
        int i2;
        synchronized (this.lock) {
            try {
                CompositionImpl compositionImpl = this.invalidationDelegate;
                int i3 = 3;
                CompositionImpl compositionImpl2 = null;
                if (compositionImpl != null) {
                    SlotTable slotTable = this.slotStorage;
                    int i4 = this.invalidationDelegateGroup;
                    if (slotTable.writer) {
                        ComposerKt.composeImmediateRuntimeError("Writer is active");
                    }
                    if (i4 < 0 || i4 >= slotTable.groupsSize) {
                        ComposerKt.composeImmediateRuntimeError("Invalid group index");
                    }
                    GapAnchor gapAnchorAsGapAnchor = GapAnchorKt.asGapAnchor(gapAnchor);
                    if (slotTable.ownsAnchor(gapAnchorAsGapAnchor)) {
                        int i5 = slotTable.groups[(i4 * 5) + 3] + i4;
                        int i6 = gapAnchorAsGapAnchor.location;
                        if (i4 > i6 || i6 >= i5) {
                            compositionImpl = null;
                        }
                    } else {
                        compositionImpl = null;
                    }
                    compositionImpl2 = compositionImpl;
                }
                int i7 = 2;
                if (compositionImpl2 == null) {
                    GapComposer gapComposer = this.composer;
                    if (gapComposer.isComposing && gapComposer.tryImminentInvalidation$runtime(recomposeScopeImpl, obj)) {
                        return 4;
                    }
                    if (obj != null && (obj instanceof DerivedSnapshotState)) {
                        Object obj2 = this.invalidations.get(recomposeScopeImpl);
                        if (obj2 != null) {
                            if (!(obj2 instanceof MutableScatterSet)) {
                                i = 2;
                                i2 = 3;
                                if (obj2 != NeverEqualPolicy.INSTANCE$2) {
                                    ScopeMap.m297addimpl(this.invalidations, recomposeScopeImpl, obj);
                                    break;
                                }
                            } else {
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr = mutableScatterSet.metadata;
                                int length = jArr.length - 2;
                                if (length >= 0) {
                                    int i8 = 0;
                                    loop0: while (true) {
                                        long j = jArr[i8];
                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i9 = 8 - ((~(i8 - length)) >>> 31);
                                            i = i7;
                                            int i10 = 0;
                                            while (i10 < i9) {
                                                if ((j & 255) < 128) {
                                                    i2 = i3;
                                                    if (objArr[(i8 << 3) + i10] == NeverEqualPolicy.INSTANCE$2) {
                                                        break loop0;
                                                    }
                                                } else {
                                                    i2 = i3;
                                                }
                                                j >>= 8;
                                                i10++;
                                                i3 = i2;
                                            }
                                            i2 = i3;
                                            if (i9 == 8) {
                                            }
                                        } else {
                                            i = i7;
                                            i2 = i3;
                                        }
                                        if (i8 != length) {
                                            i8++;
                                            i7 = i;
                                            i3 = i2;
                                        }
                                    }
                                } else {
                                    i = 2;
                                    i2 = 3;
                                }
                                ScopeMap.m297addimpl(this.invalidations, recomposeScopeImpl, obj);
                                break;
                            }
                        } else {
                            i = 2;
                            i2 = 3;
                            ScopeMap.m297addimpl(this.invalidations, recomposeScopeImpl, obj);
                            break;
                        }
                    } else {
                        this.invalidations.set(recomposeScopeImpl, NeverEqualPolicy.INSTANCE$2);
                        i = 2;
                        i2 = 3;
                    }
                } else {
                    i = 2;
                    i2 = 3;
                }
                if (compositionImpl2 != null) {
                    return compositionImpl2.invalidateChecked(recomposeScopeImpl, gapAnchor, obj);
                }
                this.parent.invalidate$runtime(this);
                return this.composer.isComposing ? i2 : i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void invalidateScopeOfLocked(Object obj) {
        Object obj2 = this.observations.get(obj);
        if (obj2 == null) {
            return;
        }
        boolean z = obj2 instanceof MutableScatterSet;
        MutableScatterMap mutableScatterMap = this.observationsProcessed;
        if (!z) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
            if (recomposeScopeImpl.invalidateForResult(obj) == 4) {
                ScopeMap.m297addimpl(mutableScatterMap, obj, recomposeScopeImpl);
                return;
            }
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                        if (recomposeScopeImpl2.invalidateForResult(obj) == 4) {
                            ScopeMap.m297addimpl(mutableScatterMap, obj, recomposeScopeImpl2);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x005b A[LOOP:0: B:7:0x001c->B:21:0x005b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x007b A[SYNTHETIC] */
    public final boolean observesAnyOf(Set set) {
        boolean z = set instanceof ScatterSetWrapper;
        MutableScatterMap mutableScatterMap = this.derivedStates;
        MutableScatterMap mutableScatterMap2 = this.observations;
        if (z) {
            MutableScatterSet mutableScatterSet = ((ScatterSetWrapper) set).set;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (mutableScatterMap2.containsKey(obj) || mutableScatterMap.containsKey(obj)) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i != length) {
                                i++;
                            }
                        }
                    } else if (i != length) {
                        i++;
                    }
                }
                return true;
            }
        } else {
            for (Object obj2 : set) {
                if (mutableScatterMap2.containsKey(obj2) || mutableScatterMap.containsKey(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            boolean z = false;
            if (pausedCompositionImpl != null && (pausedCompositionImpl.state.get() != PausedCompositionState.Recomposing || pausedCompositionImpl.owningThread != Thread_jvmKt.currentThreadId())) {
                AtomicReference atomicReference = pausedCompositionImpl.state;
                PausedCompositionState pausedCompositionState = PausedCompositionState.ApplyPending;
                PausedCompositionState pausedCompositionState2 = PausedCompositionState.RecomposePending;
                while (!atomicReference.compareAndSet(pausedCompositionState, pausedCompositionState2) && atomicReference.get() == pausedCompositionState) {
                }
                ((MutableIntList) pausedCompositionImpl.pausableApplier.mOnInvalidateMenuCallback).add(9);
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            try {
                MutableScatterMap mutableScatterMap = this.invalidations;
                this.invalidations = ScopeMap.m298constructorimpl$default();
                try {
                    GapComposer gapComposer = this.composer;
                    ShouldPauseCallback shouldPauseCallback = this.shouldPause;
                    Operations operations = gapComposer.changes.operations;
                    if (!operations.isEmpty()) {
                        ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
                    }
                    if (mutableScatterMap._size > 0 || !gapComposer.invalidations.isEmpty()) {
                        gapComposer.shouldPauseCallback = shouldPauseCallback;
                        try {
                            gapComposer.m288doComposeaFTiNEg(mutableScatterMap, null);
                            gapComposer.shouldPauseCallback = null;
                            z = !operations.isEmpty();
                        } catch (Throwable th) {
                            gapComposer.shouldPauseCallback = null;
                            throw th;
                        }
                    }
                    if (!z) {
                        drainPendingModificationsLocked();
                    }
                    return z;
                } catch (Throwable th2) {
                    this.invalidations = mutableScatterMap;
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        zzky zzkyVar = this.rememberManager;
                        try {
                            zzkyVar.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            zzkyVar.dispatchAbandons();
                        } finally {
                            zzkyVar.clear();
                        }
                    }
                    throw th3;
                } catch (Throwable th4) {
                    abandonChanges();
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void recordModificationsOf(ScatterSetWrapper scatterSetWrapper) {
        Object obj;
        while (true) {
            Object obj2 = this.pendingModifications.get();
            if (obj2 == null || obj2.equals(Stack.PendingApplyNoModifications)) {
                obj = scatterSetWrapper;
            } else if (obj2 instanceof Set) {
                obj = new Set[]{obj2, scatterSetWrapper};
            } else {
                if (!(obj2 instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Set[] setArr = (Set[]) obj2;
                int length = setArr.length;
                Object[] objArrCopyOf = Arrays.copyOf(setArr, length + 1);
                objArrCopyOf[length] = scatterSetWrapper;
                obj = objArrCopyOf;
            }
            AtomicReference atomicReference = this.pendingModifications;
            do {
                if (atomicReference.compareAndSet(obj2, obj)) {
                    if (obj2 == null) {
                        synchronized (this.lock) {
                            drainPendingModificationsLocked();
                            Unit unit = Unit.INSTANCE;
                        }
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public final void recordReadOf(Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        GapComposer gapComposer = this.composer;
        if (gapComposer.childrenComposing <= 0 && (currentRecomposeScope$runtime = gapComposer.getCurrentRecomposeScope$runtime()) != null) {
            currentRecomposeScope$runtime.setUsed();
            boolean z4 = true;
            if ((currentRecomposeScope$runtime.flags & 32) == 0) {
                MutableObjectIntMap mutableObjectIntMap = currentRecomposeScope$runtime.trackedInstances;
                if (mutableObjectIntMap == null) {
                    mutableObjectIntMap = new MutableObjectIntMap();
                    currentRecomposeScope$runtime.trackedInstances = mutableObjectIntMap;
                }
                int i2 = currentRecomposeScope$runtime.currentToken;
                int iFindIndex = mutableObjectIntMap.findIndex(obj);
                if (iFindIndex < 0) {
                    iFindIndex = ~iFindIndex;
                    i = -1;
                } else {
                    i = mutableObjectIntMap.values[iFindIndex];
                }
                mutableObjectIntMap.keys[iFindIndex] = obj;
                mutableObjectIntMap.values[iFindIndex] = i2;
                if (i == currentRecomposeScope$runtime.currentToken) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            this.observerHolder.current();
            if (z) {
                return;
            }
            if (obj instanceof StateObjectImpl) {
                ((StateObjectImpl) obj).m304recordReadInh_f27i8$runtime(1);
            }
            ScopeMap.m297addimpl(this.observations, obj, currentRecomposeScope$runtime);
            if (obj instanceof DerivedSnapshotState) {
                DerivedSnapshotState derivedSnapshotState = (DerivedSnapshotState) obj;
                DerivedSnapshotState.ResultRecord currentRecord = derivedSnapshotState.getCurrentRecord();
                MutableScatterMap mutableScatterMap = this.derivedStates;
                ScopeMap.m300removeScopeimpl(mutableScatterMap, obj);
                MutableObjectIntMap mutableObjectIntMap2 = currentRecord.dependencies;
                Object[] objArr = mutableObjectIntMap2.keys;
                long[] jArr = mutableObjectIntMap2.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    while (true) {
                        long j = jArr[i3];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i4 = 8;
                            int i5 = 8 - ((~(i3 - length)) >>> 31);
                            int i6 = 0;
                            while (i6 < i5) {
                                if ((j & 255) < 128) {
                                    StateObject stateObject = (StateObject) objArr[(i3 << 3) + i6];
                                    if (stateObject instanceof StateObjectImpl) {
                                        z3 = true;
                                        ((StateObjectImpl) stateObject).m304recordReadInh_f27i8$runtime(1);
                                    } else {
                                        z3 = true;
                                    }
                                    ScopeMap.m297addimpl(mutableScatterMap, stateObject, obj);
                                } else {
                                    z3 = z4;
                                }
                                j >>= i4;
                                i6++;
                                z4 = z3;
                                i4 = i4;
                            }
                            z2 = z4;
                            if (i5 != i4) {
                                break;
                            }
                        } else {
                            z2 = z4;
                        }
                        if (i3 == length) {
                            break;
                        }
                        i3++;
                        z4 = z2;
                    }
                }
                Object obj2 = currentRecord.result;
                MutableScatterMap mutableScatterMap2 = currentRecomposeScope$runtime.trackedDependencies;
                if (mutableScatterMap2 == null) {
                    mutableScatterMap2 = new MutableScatterMap();
                    currentRecomposeScope$runtime.trackedDependencies = mutableScatterMap2;
                }
                mutableScatterMap2.set(derivedSnapshotState, obj2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[Catch: all -> 0x004f, LOOP:0: B:11:0x001f->B:23:0x0059, LOOP_END, TryCatch #0 {all -> 0x004f, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0012, B:11:0x001f, B:13:0x002f, B:15:0x003b, B:17:0x0044, B:20:0x0051, B:23:0x0059, B:24:0x005c, B:25:0x0061), top: B:30:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0061 A[EDGE_INSN: B:33:0x0061->B:25:0x0061 BREAK  A[LOOP:0: B:11:0x001f->B:23:0x0059], SYNTHETIC] */
    public final void recordWriteOf(Object obj) {
        synchronized (this.lock) {
            try {
                invalidateScopeOfLocked(obj);
                Object obj2 = this.derivedStates.get(obj);
                if (obj2 != null) {
                    if (obj2 instanceof MutableScatterSet) {
                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                        Object[] objArr = mutableScatterSet.elements;
                        long[] jArr = mutableScatterSet.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                long j = jArr[i];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                    if (i != length) {
                                        break;
                                        break;
                                    }
                                    i++;
                                } else {
                                    int i2 = 8 - ((~(i - length)) >>> 31);
                                    for (int i3 = 0; i3 < i2; i3++) {
                                        if ((255 & j) < 128) {
                                            invalidateScopeOfLocked((DerivedSnapshotState) objArr[(i << 3) + i3]);
                                        }
                                        j >>= 8;
                                    }
                                    if (i2 != 8) {
                                        break;
                                    } else if (i != length) {
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        }
                    } else {
                        invalidateScopeOfLocked((DerivedSnapshotState) obj2);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setContent(Function2 function2) {
        boolean zClearDeactivated = clearDeactivated();
        ensureRunning();
        CompositionContext compositionContext = this.parent;
        if (!zClearDeactivated) {
            compositionContext.composeInitial$runtime(this, function2);
            return;
        }
        GapComposer gapComposer = this.composer;
        gapComposer.reusingGroup = 0;
        gapComposer.reusing = true;
        compositionContext.composeInitial$runtime(this, function2);
        gapComposer.endReuseFromRoot$runtime();
    }

    /* JADX WARN: Code duplicated, block: B:112:0x023c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x023e A[LOOP:6: B:96:0x01ea->B:113:0x023e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:206:0x024b A[EDGE_INSN: B:206:0x024b->B:115:0x024b BREAK  A[LOOP:6: B:96:0x01ea->B:113:0x023e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0196 A[EDGE_INSN: B:221:0x0196->B:77:0x0196 BREAK  A[LOOP:13: B:64:0x015a->B:75:0x018e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x018c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x018e A[LOOP:13: B:64:0x015a->B:75:0x018e, LOOP_END] */
    public final void addPendingInvalidationsLocked(Set set, boolean z) {
        long j;
        long j2;
        long j3;
        char c;
        long[] jArr;
        long[] jArr2;
        long j4;
        boolean zContains;
        long[] jArr3;
        long j5;
        long[] jArr4;
        long[] jArr5;
        int i;
        long j6;
        boolean zIsEmpty;
        int i2;
        long j7;
        long[] jArr6;
        long[] jArr7;
        char c2;
        long j8;
        int i3;
        int i4;
        boolean z2 = set instanceof ScatterSetWrapper;
        MutableScatterMap mutableScatterMap = this.derivedStates;
        Object obj = null;
        int i5 = 8;
        if (z2) {
            MutableScatterSet mutableScatterSet = ((ScatterSetWrapper) set).set;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr8 = mutableScatterSet.metadata;
            int length = jArr8.length - 2;
            if (length >= 0) {
                int i6 = 0;
                j = 128;
                j2 = 255;
                while (true) {
                    long j9 = jArr8[i6];
                    char c3 = 7;
                    j3 = -9187201950435737472L;
                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j9 & 255) < 128) {
                                Object obj2 = objArr[(i6 << 3) + i8];
                                c2 = c3;
                                if (obj2 instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                                    jArr7 = jArr8;
                                    j8 = j9;
                                    i3 = length;
                                } else {
                                    addPendingInvalidationsLocked(obj2, z);
                                    Object obj3 = mutableScatterMap.get(obj2);
                                    if (obj3 == null) {
                                        jArr7 = jArr8;
                                        j8 = j9;
                                        i3 = length;
                                    } else if (obj3 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj3;
                                        Object[] objArr2 = mutableScatterSet2.elements;
                                        long[] jArr9 = mutableScatterSet2.metadata;
                                        int length2 = jArr9.length - 2;
                                        if (length2 >= 0) {
                                            int i9 = i5;
                                            i3 = length;
                                            int i10 = 0;
                                            while (true) {
                                                long j10 = jArr9[i10];
                                                j8 = j9;
                                                long[] jArr10 = jArr9;
                                                if ((((~j10) << c2) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                    int i12 = 0;
                                                    while (i12 < i11) {
                                                        if ((j10 & 255) < 128) {
                                                            addPendingInvalidationsLocked((DerivedSnapshotState) objArr2[(i10 << 3) + i12], z);
                                                        }
                                                        j10 >>= i9;
                                                        i12++;
                                                        jArr8 = jArr8;
                                                    }
                                                    jArr7 = jArr8;
                                                    if (i11 != i9) {
                                                        break;
                                                    }
                                                } else {
                                                    jArr7 = jArr8;
                                                }
                                                if (i10 == length2) {
                                                    break;
                                                }
                                                i10++;
                                                jArr9 = jArr10;
                                                j9 = j8;
                                                jArr8 = jArr7;
                                                i9 = 8;
                                            }
                                        } else {
                                            jArr7 = jArr8;
                                            j8 = j9;
                                            i3 = length;
                                        }
                                    } else {
                                        jArr7 = jArr8;
                                        j8 = j9;
                                        i3 = length;
                                        addPendingInvalidationsLocked((DerivedSnapshotState) obj3, z);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                                i4 = 8;
                            } else {
                                jArr7 = jArr8;
                                c2 = c3;
                                j8 = j9;
                                i3 = length;
                                i4 = i5;
                            }
                            j9 = j8 >> i4;
                            i8++;
                            length = i3;
                            i5 = i4;
                            c3 = c2;
                            jArr8 = jArr7;
                            obj = null;
                        }
                        jArr6 = jArr8;
                        c = c3;
                        int i13 = length;
                        if (i7 != i5) {
                            break;
                        } else {
                            length = i13;
                        }
                    } else {
                        jArr6 = jArr8;
                        c = 7;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    jArr8 = jArr6;
                    obj = null;
                    i5 = 8;
                }
            } else {
                j = 128;
                j2 = 255;
                j3 = -9187201950435737472L;
                c = 7;
            }
        } else {
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
            c = 7;
            for (Object obj4 : set) {
                if (obj4 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj4).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj4, z);
                    Object obj5 = mutableScatterMap.get(obj4);
                    if (obj5 != null) {
                        if (obj5 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj5;
                            Object[] objArr3 = mutableScatterSet3.elements;
                            long[] jArr11 = mutableScatterSet3.metadata;
                            int length3 = jArr11.length - 2;
                            if (length3 >= 0) {
                                int i14 = 0;
                                while (true) {
                                    long j11 = jArr11[i14];
                                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i14 != length3) {
                                            break;
                                            break;
                                        }
                                        i14++;
                                    } else {
                                        int i15 = 8 - ((~(i14 - length3)) >>> 31);
                                        for (int i16 = 0; i16 < i15; i16++) {
                                            if ((j11 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedSnapshotState) objArr3[(i14 << 3) + i16], z);
                                            }
                                            j11 >>= 8;
                                        }
                                        if (i15 != 8) {
                                            break;
                                        } else if (i14 != length3) {
                                            break;
                                        } else {
                                            i14++;
                                        }
                                    }
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedSnapshotState) obj5, z);
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
        MutableScatterMap mutableScatterMap2 = this.observations;
        MutableScatterSet mutableScatterSet4 = this.invalidatedScopes;
        if (z) {
            MutableScatterSet mutableScatterSet5 = this.conditionallyInvalidatedScopes;
            if (mutableScatterSet5.isNotEmpty()) {
                long[] jArr12 = mutableScatterMap2.metadata;
                int length4 = jArr12.length - 2;
                if (length4 >= 0) {
                    int i17 = 0;
                    while (true) {
                        long j12 = jArr12[i17];
                        if ((((~j12) << c) & j12 & j3) != j3) {
                            int i18 = 8 - ((~(i17 - length4)) >>> 31);
                            int i19 = 0;
                            while (i19 < i18) {
                                if ((j12 & j2) < j) {
                                    int i20 = (i17 << 3) + i19;
                                    Object obj6 = mutableScatterMap2.keys[i20];
                                    Object obj7 = mutableScatterMap2.values[i20];
                                    if (obj7 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj7;
                                        Object[] objArr4 = mutableScatterSet6.elements;
                                        long[] jArr13 = mutableScatterSet6.metadata;
                                        int length5 = jArr13.length - 2;
                                        if (length5 >= 0) {
                                            j6 = j12;
                                            int i21 = 0;
                                            while (true) {
                                                long j13 = jArr13[i21];
                                                jArr5 = jArr12;
                                                i = length4;
                                                if ((((~j13) << c) & j13 & j3) != j3) {
                                                    int i22 = 8 - ((~(i21 - length5)) >>> 31);
                                                    for (int i23 = 0; i23 < i22; i23 = i2 + 1) {
                                                        if ((j13 & j2) < j) {
                                                            i2 = i23;
                                                            int i24 = (i21 << 3) + i2;
                                                            j7 = j13;
                                                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr4[i24];
                                                            if (mutableScatterSet5.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                                mutableScatterSet6.removeElementAt(i24);
                                                            }
                                                        } else {
                                                            i2 = i23;
                                                            j7 = j13;
                                                        }
                                                        j13 = j7 >> 8;
                                                    }
                                                    if (i22 != 8) {
                                                        break;
                                                    }
                                                    if (i21 != length5) {
                                                        break;
                                                    }
                                                    i21++;
                                                    length4 = i;
                                                    jArr12 = jArr5;
                                                } else if (i21 != length5) {
                                                    break;
                                                    break;
                                                } else {
                                                    i21++;
                                                    length4 = i;
                                                    jArr12 = jArr5;
                                                }
                                            }
                                        } else {
                                            jArr5 = jArr12;
                                            i = length4;
                                            j6 = j12;
                                        }
                                        zIsEmpty = mutableScatterSet6.isEmpty();
                                    } else {
                                        jArr5 = jArr12;
                                        i = length4;
                                        j6 = j12;
                                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj7;
                                        zIsEmpty = mutableScatterSet5.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                                    }
                                    if (zIsEmpty) {
                                        mutableScatterMap2.removeValueAt(i20);
                                    }
                                } else {
                                    jArr5 = jArr12;
                                    i = length4;
                                    j6 = j12;
                                }
                                j12 = j6 >> 8;
                                i19++;
                                length4 = i;
                                jArr12 = jArr5;
                            }
                            jArr4 = jArr12;
                            int i25 = length4;
                            if (i18 != 8) {
                                break;
                            } else {
                                length4 = i25;
                            }
                        } else {
                            jArr4 = jArr12;
                        }
                        if (i17 == length4) {
                            break;
                        }
                        i17++;
                        jArr12 = jArr4;
                    }
                }
                mutableScatterSet5.clear();
                cleanUpDerivedStateObservations();
                return;
            }
        }
        if (mutableScatterSet4.isNotEmpty()) {
            long[] jArr14 = mutableScatterMap2.metadata;
            int length6 = jArr14.length - 2;
            if (length6 >= 0) {
                int i26 = 0;
                while (true) {
                    long j14 = jArr14[i26];
                    if ((((~j14) << c) & j14 & j3) != j3) {
                        int i27 = 8 - ((~(i26 - length6)) >>> 31);
                        int i28 = 0;
                        while (i28 < i27) {
                            if ((j14 & j2) < j) {
                                int i29 = (i26 << 3) + i28;
                                Object obj8 = mutableScatterMap2.keys[i29];
                                Object obj9 = mutableScatterMap2.values[i29];
                                if (obj9 instanceof MutableScatterSet) {
                                    MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj9;
                                    Object[] objArr5 = mutableScatterSet7.elements;
                                    long[] jArr15 = mutableScatterSet7.metadata;
                                    int length7 = jArr15.length - 2;
                                    if (length7 >= 0) {
                                        j4 = j14;
                                        int i30 = 0;
                                        while (true) {
                                            long j15 = jArr15[i30];
                                            Object[] objArr6 = objArr5;
                                            long[] jArr16 = jArr15;
                                            if ((((~j15) << c) & j15 & j3) != j3) {
                                                int i31 = 8 - ((~(i30 - length7)) >>> 31);
                                                int i32 = 0;
                                                while (i32 < i31) {
                                                    if ((j15 & j2) < j) {
                                                        jArr3 = jArr14;
                                                        int i33 = (i30 << 3) + i32;
                                                        j5 = j15;
                                                        if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr6[i33])) {
                                                            mutableScatterSet7.removeElementAt(i33);
                                                        }
                                                    } else {
                                                        jArr3 = jArr14;
                                                        j5 = j15;
                                                    }
                                                    i32++;
                                                    jArr14 = jArr3;
                                                    j15 = j5 >> 8;
                                                }
                                                jArr2 = jArr14;
                                                if (i31 != 8) {
                                                    break;
                                                }
                                            } else {
                                                jArr2 = jArr14;
                                            }
                                            if (i30 == length7) {
                                                break;
                                            }
                                            i30++;
                                            objArr5 = objArr6;
                                            jArr15 = jArr16;
                                            jArr14 = jArr2;
                                        }
                                    } else {
                                        jArr2 = jArr14;
                                        j4 = j14;
                                    }
                                    zContains = mutableScatterSet7.isEmpty();
                                } else {
                                    jArr2 = jArr14;
                                    j4 = j14;
                                    zContains = mutableScatterSet4.contains((RecomposeScopeImpl) obj9);
                                }
                                if (zContains) {
                                    mutableScatterMap2.removeValueAt(i29);
                                }
                            } else {
                                jArr2 = jArr14;
                                j4 = j14;
                            }
                            i28++;
                            j14 = j4 >> 8;
                            jArr14 = jArr2;
                        }
                        jArr = jArr14;
                        if (i27 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr14;
                    }
                    if (i26 == length6) {
                        break;
                    }
                    i26++;
                    jArr14 = jArr;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet4.clear();
        }
    }
}
