package androidx.compose.runtime;

import android.os.Trace;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.MutableSetWrapper;
import androidx.collection.ScatterSetKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.GroupInfo;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapAnchorKt;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.FixupList;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operation;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.runtime.tooling.ReaderTraceBuilder;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzso;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GapComposer {
    public GapCompositionDataImpl _compositionData;
    public final MutableSetWrapper abandonSet;
    public final MenuHostHelper applier;
    public final CoroutineContext applyCoroutineContext;
    public final ComposerChangeListWriter changeListWriter;
    public final ChangeList changes;
    public int childrenComposing;
    public long compositeKeyHashCode;
    public final CompositionImpl composition;
    public int compositionToken;
    public ChangeList deferredChanges;
    public final GapComposer$derivedStateObserver$1 derivedStateObserver;
    public final CompositionErrorContextImpl errorContext;
    public boolean forceRecomposeScopes;
    public int groupNodeCount;
    public GapAnchor insertAnchor;
    public FixupList insertFixups;
    public SlotTable insertTable;
    public boolean inserting;
    public final ArrayList invalidateStack;
    public boolean isComposing;
    public final ChangeList lateChanges;
    public int[] nodeCountOverrides;
    public MutableIntIntMap nodeCountVirtualOverrides;
    public boolean nodeExpected;
    public int nodeIndex;
    public final Parameters.Builder observerHolder;
    public final CompositionContext parentContext;
    public GapPending pending;
    public PersistentCompositionLocalMap providerCache;
    public MutableIntObjectMap providerUpdates;
    public boolean providersInvalid;
    public int rGroupIndex;
    public SlotReader reader;
    public boolean reusing;
    public ShouldPauseCallback shouldPauseCallback;
    public final SlotTable slotTable;
    public boolean sourceMarkersEnabled;
    public SlotWriter writer;
    public boolean writerHasAProvider;
    public final ArrayList pendingStack = new ArrayList();
    public final IntStack parentStateStack = new IntStack();
    public final ArrayList invalidations = new ArrayList();
    public final IntStack entersStack = new IntStack();
    public PersistentCompositionLocalMap rootProvider = PersistentCompositionLocalHashMap.Empty;
    public final IntStack providersInvalidStack = new IntStack();
    public int reusingGroup = -1;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CompositionContextImpl extends CompositionContext {
        public final boolean collectingParameterInformation;
        public final boolean collectingSourceInformation;
        public final MutableScatterSet composers;
        public final long compositeKeyHashCode;
        public final ParcelableSnapshotMutableState compositionLocalScope$delegate;
        public HashSet inspectionTables;

        public CompositionContextImpl(long j, boolean z, boolean z2, Parameters.Builder builder) {
            this.compositeKeyHashCode = j;
            this.collectingParameterInformation = z;
            this.collectingSourceInformation = z2;
            MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
            this.composers = new MutableScatterSet();
            this.compositionLocalScope$delegate = new ParcelableSnapshotMutableState(PersistentCompositionLocalHashMap.Empty, NeverEqualPolicy.INSTANCE$1);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void composeInitial$runtime(CompositionImpl compositionImpl, Function2 function2) {
            GapComposer.this.parentContext.composeInitial$runtime(compositionImpl, function2);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final MutableScatterSet composeInitialPaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, Function2 function2) {
            return GapComposer.this.parentContext.composeInitialPaused$runtime(compositionImpl, shouldPauseCallback, function2);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0062 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:22:0x0064 A[LOOP:0: B:9:0x0018->B:22:0x0064, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:26:0x0067 A[EDGE_INSN: B:26:0x0067->B:23:0x0067 BREAK  A[LOOP:0: B:9:0x0018->B:22:0x0064], SYNTHETIC] */
        public final void dispose() {
            MutableScatterSet mutableScatterSet = this.composers;
            if (mutableScatterSet.isNotEmpty()) {
                HashSet hashSet = this.inspectionTables;
                if (hashSet != null) {
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
                                        GapComposer gapComposer = (GapComposer) objArr[(i << 3) + i3];
                                        Iterator it = hashSet.iterator();
                                        while (it.hasNext()) {
                                            ((Set) it.next()).remove(gapComposer.getCompositionData());
                                        }
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
                }
                mutableScatterSet.clear();
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void doneComposing$runtime() {
            GapComposer.this.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final boolean getCollectingCallByInformation$runtime() {
            return GapComposer.this.parentContext.getCollectingCallByInformation$runtime();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final boolean getCollectingParameterInformation$runtime() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final boolean getCollectingSourceInformation$runtime() {
            return this.collectingSourceInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final long getCompositeKeyHashCode$runtime() {
            return this.compositeKeyHashCode;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final Composition getComposition$runtime() {
            return GapComposer.this.composition;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final PersistentCompositionLocalMap getCompositionLocalScope$runtime() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope$delegate.getValue();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final CoroutineContext getEffectCoroutineContext() {
            return GapComposer.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final boolean getStackTraceEnabled$runtime() {
            return GapComposer.this.parentContext.getStackTraceEnabled$runtime();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void invalidate$runtime(CompositionImpl compositionImpl) {
            GapComposer gapComposer = GapComposer.this;
            gapComposer.parentContext.invalidate$runtime(gapComposer.composition);
            gapComposer.parentContext.invalidate$runtime(compositionImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final MovableContentState movableContentStateResolve$runtime(MovableContentStateReference movableContentStateReference) {
            return GapComposer.this.parentContext.movableContentStateResolve$runtime(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final MutableScatterSet recomposePaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, MutableScatterSet mutableScatterSet) {
            return GapComposer.this.parentContext.recomposePaused$runtime(compositionImpl, shouldPauseCallback, mutableScatterSet);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void recordInspectionTable$runtime(Set set) {
            HashSet hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(set);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void registerComposer$runtime(GapComposer gapComposer) {
            this.composers.add(gapComposer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void reportPausedScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
            GapComposer.this.parentContext.reportPausedScope$runtime(recomposeScopeImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void reportRemovedComposition$runtime(CompositionImpl compositionImpl) {
            GapComposer.this.parentContext.reportRemovedComposition$runtime(compositionImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final CancellationHandle scheduleFrameEndCallback(Handshake.AnonymousClass2 anonymousClass2) {
            return GapComposer.this.parentContext.scheduleFrameEndCallback(anonymousClass2);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void startComposing$runtime() {
            GapComposer.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void unregisterComposer$runtime(GapComposer gapComposer) {
            HashSet hashSet = this.inspectionTables;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(gapComposer.getCompositionData());
                }
            }
            if (ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) gapComposer)) {
                this.composers.remove(gapComposer);
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void unregisterComposition$runtime(CompositionImpl compositionImpl) {
            GapComposer.this.parentContext.unregisterComposition$runtime(compositionImpl);
        }
    }

    public GapComposer(MenuHostHelper menuHostHelper, CompositionContext compositionContext, SlotTable slotTable, MutableSetWrapper mutableSetWrapper, ChangeList changeList, ChangeList changeList2, Parameters.Builder builder, CompositionImpl compositionImpl) {
        this.applier = menuHostHelper;
        this.parentContext = compositionContext;
        this.slotTable = slotTable;
        this.abandonSet = mutableSetWrapper;
        this.changes = changeList;
        this.lateChanges = changeList2;
        this.observerHolder = builder;
        this.composition = compositionImpl;
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation$runtime() || compositionContext.getCollectingCallByInformation$runtime();
        this.derivedStateObserver = new GapComposer$derivedStateObserver$1(0, this);
        this.invalidateStack = new ArrayList();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        slotReaderOpenReader.close();
        this.reader = slotReaderOpenReader;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.getCollectingSourceInformation$runtime()) {
            slotTable2.collectSourceInformation();
        }
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable2.calledByMap = new MutableIntObjectMap();
        }
        this.insertTable = slotTable2;
        SlotWriter slotWriterOpenWriter = slotTable2.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, changeList);
        SlotReader slotReaderOpenReader2 = this.insertTable.openReader();
        try {
            GapAnchor gapAnchorAnchor = slotReaderOpenReader2.anchor(0);
            slotReaderOpenReader2.close();
            this.insertAnchor = gapAnchorAnchor;
            this.insertFixups = new FixupList();
            this.errorContext = new CompositionErrorContextImpl(this);
            CoroutineContext effectCoroutineContext = compositionContext.getEffectCoroutineContext();
            CoroutineContext errorContext$runtime = getErrorContext$runtime();
            this.applyCoroutineContext = effectCoroutineContext.plus(errorContext$runtime == null ? EmptyCoroutineContext.INSTANCE : errorContext$runtime);
        } catch (Throwable th) {
            slotReaderOpenReader2.close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00eb  */
    public static final int reportFreeMovableContent$reportGroup(GapComposer gapComposer, int i, boolean z, int i2) {
        int i3;
        long[] jArr;
        Object[] objArr;
        int i4;
        int i5;
        SlotReader slotReader = gapComposer.reader;
        ComposerChangeListWriter composerChangeListWriter = gapComposer.changeListWriter;
        boolean zHasMark = slotReader.hasMark(i);
        int[] iArr = slotReader.groups;
        int i6 = 0;
        if (zHasMark) {
            int iGroupKey = slotReader.groupKey(i);
            Object objObjectKey = slotReader.objectKey(iArr, i);
            if (iGroupKey == 206 && Intrinsics.areEqual(objObjectKey, ComposerKt.reference)) {
                Object objGroupGet = slotReader.groupGet(i, 0);
                RememberObserverHolder rememberObserverHolder = objGroupGet instanceof RememberObserverHolder ? (RememberObserverHolder) objGroupGet : null;
                RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
                CompositionContextHolder compositionContextHolder = wrapped instanceof CompositionContextHolder ? (CompositionContextHolder) wrapped : null;
                if (compositionContextHolder != null) {
                    MutableScatterSet mutableScatterSet = compositionContextHolder.ref.composers;
                    Object[] objArr2 = mutableScatterSet.elements;
                    long[] jArr2 = mutableScatterSet.metadata;
                    int length = jArr2.length - 2;
                    if (length >= 0) {
                        int i7 = 0;
                        while (true) {
                            long j = jArr2[i7];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i8 = 8;
                                int i9 = 8 - ((~(i7 - length)) >>> 31);
                                int i10 = i6;
                                while (i10 < i9) {
                                    if ((255 & j) < 128) {
                                        GapComposer gapComposer2 = (GapComposer) objArr2[(i7 << 3) + i10];
                                        ComposerChangeListWriter composerChangeListWriter2 = gapComposer2.changeListWriter;
                                        CompositionImpl compositionImpl = gapComposer2.composition;
                                        SlotTable slotTable = gapComposer2.slotTable;
                                        if (slotTable.groupsSize <= 0 || (slotTable.groups[1] & 67108864) == 0) {
                                            i5 = 0;
                                        } else {
                                            synchronized (compositionImpl.lock) {
                                                compositionImpl.drainPendingModificationsOutOfBandLocked();
                                                MutableScatterMap mutableScatterMap = compositionImpl.invalidations;
                                                compositionImpl.invalidations = ScopeMap.m298constructorimpl$default();
                                                try {
                                                    compositionImpl.composer.m290updateComposerInvalidationsRY85e9Y$runtime(mutableScatterMap);
                                                    Unit unit = Unit.INSTANCE;
                                                } catch (Throwable th) {
                                                    compositionImpl.invalidations = mutableScatterMap;
                                                    throw th;
                                                }
                                            }
                                            ChangeList changeList = new ChangeList();
                                            gapComposer2.deferredChanges = changeList;
                                            SlotReader slotReaderOpenReader = slotTable.openReader();
                                            try {
                                                gapComposer2.reader = slotReaderOpenReader;
                                                ChangeList changeList2 = composerChangeListWriter2.changeList;
                                                try {
                                                    composerChangeListWriter2.changeList = changeList;
                                                    gapComposer2.reportFreeMovableContent(0);
                                                    composerChangeListWriter2.pushPendingUpsAndDowns();
                                                    if (composerChangeListWriter2.startedGroup) {
                                                        composerChangeListWriter2.changeList.operations.pushOp(Operation.SkipToEndOfCurrentGroup.INSTANCE);
                                                        if (composerChangeListWriter2.startedGroup) {
                                                            i5 = 0;
                                                            composerChangeListWriter2.realizeOperationLocation(false);
                                                            composerChangeListWriter2.realizeOperationLocation(false);
                                                            composerChangeListWriter2.changeList.operations.pushOp(Operation.EndCurrentGroup.INSTANCE);
                                                            composerChangeListWriter2.startedGroup = false;
                                                        } else {
                                                            i5 = 0;
                                                        }
                                                    } else {
                                                        i5 = 0;
                                                    }
                                                    composerChangeListWriter2.changeList = changeList2;
                                                    slotReaderOpenReader.close();
                                                } catch (Throwable th2) {
                                                    composerChangeListWriter2.changeList = changeList2;
                                                    throw th2;
                                                }
                                            } catch (Throwable th3) {
                                                slotReaderOpenReader.close();
                                                throw th3;
                                            }
                                        }
                                        gapComposer.parentContext.reportRemovedComposition$runtime(compositionImpl);
                                    } else {
                                        jArr2 = jArr2;
                                        objArr2 = objArr2;
                                        i5 = i6;
                                    }
                                    j >>= i8;
                                    i10++;
                                    objArr2 = objArr2;
                                    i6 = i5;
                                    jArr2 = jArr2;
                                    i8 = i8;
                                }
                                jArr = jArr2;
                                objArr = objArr2;
                                int i11 = i8;
                                i4 = i6;
                                if (i9 != i11) {
                                    break;
                                }
                            } else {
                                jArr = jArr2;
                                objArr = objArr2;
                                i4 = i6;
                            }
                            if (i7 == length) {
                                break;
                            }
                            i7++;
                            objArr2 = objArr;
                            i6 = i4;
                            jArr2 = jArr;
                        }
                    }
                }
                return slotReader.nodeCount(i);
            }
            i3 = 1;
            if (!slotReader.isNode(i)) {
                return slotReader.nodeCount(i);
            }
        } else {
            i3 = 1;
            if (slotReader.containsMark(i)) {
                int i12 = iArr[(i * 5) + 3] + i;
                int iReportFreeMovableContent$reportGroup = 0;
                for (int i13 = i + 1; i13 < i12; i13 += iArr[(i13 * 5) + 3]) {
                    boolean zIsNode = slotReader.isNode(i13);
                    if (zIsNode) {
                        composerChangeListWriter.realizeNodeMovementOperations();
                        Object objNode = slotReader.node(i13);
                        composerChangeListWriter.realizeNodeMovementOperations();
                        composerChangeListWriter.pendingDownNodes.add(objNode);
                    }
                    iReportFreeMovableContent$reportGroup += reportFreeMovableContent$reportGroup(gapComposer, i13, zIsNode || z, zIsNode ? 0 : i2 + iReportFreeMovableContent$reportGroup);
                    if (zIsNode) {
                        composerChangeListWriter.realizeNodeMovementOperations();
                        composerChangeListWriter.moveUp();
                    }
                }
                if (!slotReader.isNode(i)) {
                    return iReportFreeMovableContent$reportGroup;
                }
            } else if (!slotReader.isNode(i)) {
                return slotReader.nodeCount(i);
            }
        }
        return i3;
    }

    public final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.parentStateStack.tos = 0;
        this.entersStack.tos = 0;
        this.providersInvalidStack.tos = 0;
        this.providerUpdates = null;
        FixupList fixupList = this.insertFixups;
        fixupList.pendingOperations.clear();
        fixupList.operations.clear();
        this.compositeKeyHashCode = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.reusingGroup = -1;
        SlotReader slotReader = this.reader;
        if (!slotReader.closed) {
            slotReader.close();
        }
        if (this.writer.closed) {
            return;
        }
        forceFreshInsertTable();
    }

    public final void apply(Object obj, Function2 function2) {
        if (this.inserting) {
            Operations operations = this.insertFixups.operations;
            operations.pushOp(Operation.UpdateNode.INSTANCE);
            zzsi.m814setObjectsGr0YRc(operations, 0, obj);
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
            zzsi.m814setObjectsGr0YRc(operations, 1, function2);
            return;
        }
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        composerChangeListWriter.pushPendingUpsAndDowns();
        Operations operations2 = composerChangeListWriter.changeList.operations;
        operations2.pushOp(Operation.UpdateNode.INSTANCE);
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
        zzsi.m815setObjectsEsEZvaA(operations2, 0, obj, 1, function2);
    }

    public final boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    public final boolean changedInstance(Object obj) {
        if (nextSlot() == obj) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    public final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compositeKeyHashCode = 0L;
        this.nodeExpected = false;
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        composerChangeListWriter.startedGroup = false;
        composerChangeListWriter.startedGroups.tos = 0;
        composerChangeListWriter.writersReaderDelta = 0;
        composerChangeListWriter.implicitRootStart = true;
        composerChangeListWriter.pendingUps = 0;
        composerChangeListWriter.pendingDownNodes.clear();
        composerChangeListWriter.removeFrom = -1;
        composerChangeListWriter.moveFrom = -1;
        composerChangeListWriter.moveTo = -1;
        composerChangeListWriter.moveCount = 0;
        this.invalidateStack.clear();
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    public final Object consume(ProvidableCompositionLocal providableCompositionLocal) {
        return Stack.read(currentCompositionLocalScope(), providableCompositionLocal);
    }

    public final void createNode(Function0 function0) {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
        if (!this.inserting) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        IntStack intStack = this.parentStateStack;
        int i = intStack.slots[intStack.tos - 1];
        SlotWriter slotWriter = this.writer;
        GapAnchor gapAnchorAnchor = slotWriter.anchor(slotWriter.parent);
        this.groupNodeCount++;
        FixupList fixupList = this.insertFixups;
        Operations operations = fixupList.operations;
        operations.pushOp(Operation.UpdateValue.INSTANCE$1);
        zzsi.m814setObjectsGr0YRc(operations, 0, function0);
        operations.intArgs[operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].ints] = i;
        zzsi.m814setObjectsGr0YRc(operations, 1, gapAnchorAnchor);
        Operations operations2 = fixupList.pendingOperations;
        operations2.pushOp(Operation.UpdateValue.INSTANCE$2);
        operations2.intArgs[operations2.intArgsSize - operations2.opCodes[operations2.opCodesSize - 1].ints] = i;
        zzsi.m814setObjectsGr0YRc(operations2, 0, gapAnchorAnchor);
    }

    public final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        PersistentCompositionLocalMap persistentCompositionLocalMap2 = this.providerCache;
        if (persistentCompositionLocalMap2 != null) {
            return persistentCompositionLocalMap2;
        }
        int iParent = this.reader.parent;
        boolean z = this.inserting;
        OpaqueKey opaqueKey = ComposerKt.compositionLocalMap;
        if (z && this.writerHasAProvider) {
            int iParent2 = this.writer.parent;
            while (iParent2 > 0) {
                if (this.writer.groupKey(iParent2) == 202 && Intrinsics.areEqual(this.writer.groupObjectKey(iParent2), opaqueKey)) {
                    PersistentCompositionLocalMap persistentCompositionLocalMap3 = (PersistentCompositionLocalMap) this.writer.groupAux(iParent2);
                    this.providerCache = persistentCompositionLocalMap3;
                    return persistentCompositionLocalMap3;
                }
                SlotWriter slotWriter = this.writer;
                iParent2 = slotWriter.parent(slotWriter.groups, iParent2);
            }
        }
        if (this.reader.groupsSize > 0) {
            while (iParent > 0) {
                if (this.reader.groupKey(iParent) == 202) {
                    SlotReader slotReader = this.reader;
                    if (Intrinsics.areEqual(slotReader.objectKey(slotReader.groups, iParent), opaqueKey)) {
                        MutableIntObjectMap mutableIntObjectMap = this.providerUpdates;
                        if (mutableIntObjectMap == null || (persistentCompositionLocalMap = (PersistentCompositionLocalMap) mutableIntObjectMap.get(iParent)) == null) {
                            SlotReader slotReader2 = this.reader;
                            persistentCompositionLocalMap = (PersistentCompositionLocalMap) slotReader2.aux(slotReader2.groups, iParent);
                        }
                        this.providerCache = persistentCompositionLocalMap;
                        return persistentCompositionLocalMap;
                    }
                }
                iParent = this.reader.parent(iParent);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap4 = this.rootProvider;
        this.providerCache = persistentCompositionLocalMap4;
        return persistentCompositionLocalMap4;
    }

    public final ComposeStackTrace currentStackTrace() {
        Collection collection;
        if (!this.parentContext.getStackTraceEnabled$runtime()) {
            return null;
        }
        ListBuilder listBuilderCreateListBuilder = AppCompatHintHelper.createListBuilder();
        SlotWriter slotWriter = this.writer;
        listBuilderCreateListBuilder.addAll(zzso.buildTrace(slotWriter, null, slotWriter.currentGroup, null));
        SlotReader slotReader = this.reader;
        boolean z = slotReader.closed;
        int[] iArr = slotReader.groups;
        if (z || slotReader.groupsSize == 0) {
            collection = EmptyList.INSTANCE;
        } else {
            ReaderTraceBuilder readerTraceBuilder = new ReaderTraceBuilder(0, slotReader);
            int iParent = slotReader.parent;
            Object objValueOf = Integer.valueOf(slotReader.currentSlot - SlotTableKt.access$slotAnchor(iArr, iParent));
            while (iParent >= 0) {
                readerTraceBuilder.processEdge(slotReader.groupKey(iParent), slotReader.hasObjectKey(iParent) ? slotReader.objectKey(iArr, iParent) : Composer$Companion.Empty, slotReader.table.sourceInformationOf(iParent), objValueOf);
                objValueOf = slotReader.anchor(iParent);
                iParent = slotReader.parent(iParent);
            }
            collection = (ArrayList) readerTraceBuilder.internalScopeRef;
        }
        listBuilderCreateListBuilder.addAll(collection);
        listBuilderCreateListBuilder.addAll(parentStackTrace$runtime());
        return new ComposeStackTrace(AppCompatHintHelper.build(listBuilderCreateListBuilder), this.sourceMarkersEnabled);
    }

    /* JADX INFO: renamed from: doCompose-aFTiNEg, reason: not valid java name */
    public final void m288doComposeaFTiNEg(MutableScatterMap mutableScatterMap, Function2 function2) {
        ArrayList arrayList = this.invalidations;
        if (this.isComposing) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        this.observerHolder.current();
        Trace.beginSection("Compose:recompose");
        try {
            long snapshotId = SnapshotKt.currentSnapshot().getSnapshotId();
            this.compositionToken = (int) (snapshotId ^ (snapshotId >>> 32));
            this.providerUpdates = null;
            m290updateComposerInvalidationsRY85e9Y$runtime(mutableScatterMap);
            this.nodeIndex = 0;
            this.isComposing = true;
            try {
                startRoot();
                Object objNextSlot = nextSlot();
                if (objNextSlot != function2 && function2 != null) {
                    updateValue(function2);
                }
                GapComposer$derivedStateObserver$1 gapComposer$derivedStateObserver$1 = this.derivedStateObserver;
                MutableVector mutableVectorDerivedStateObservers = Stack.derivedStateObservers();
                try {
                    mutableVectorDerivedStateObservers.add(gapComposer$derivedStateObserver$1);
                    OpaqueKey opaqueKey = ComposerKt.invocation;
                    if (function2 != null) {
                        startGroup(200, opaqueKey);
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                        function2.invoke(this, 1);
                        end(false);
                    } else if (!this.providersInvalid || objNextSlot == null || objNextSlot.equals(Composer$Companion.Empty)) {
                        skipCurrentGroup();
                    } else {
                        startGroup(200, opaqueKey);
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, objNextSlot);
                        Function2 function3 = (Function2) objNextSlot;
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function3);
                        function3.invoke(this, 1);
                        end(false);
                    }
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.size - 1);
                    endRoot();
                    this.isComposing = false;
                    arrayList.clear();
                    if (!this.writer.closed) {
                        ComposerKt.composeImmediateRuntimeError("Check failed");
                    }
                    forceFreshInsertTable();
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                } catch (Throwable th) {
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.size - 1);
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    ComposeStackTraceKt.tryAttachComposeStackTrace(th2, new GapComposer$$ExternalSyntheticLambda1(1, this));
                    throw th2;
                } catch (Throwable th3) {
                    this.isComposing = false;
                    arrayList.clear();
                    abortRoot();
                    if (!this.writer.closed) {
                        ComposerKt.composeImmediateRuntimeError("Check failed");
                    }
                    forceFreshInsertTable();
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            Trace.endSection();
            throw th4;
        }
    }

    public final void doRecordDownsFor(int i, int i2) {
        if (i <= 0 || i == i2) {
            return;
        }
        doRecordDownsFor(this.reader.parent(i), i2);
        if (this.reader.isNode(i)) {
            Object objNode = this.reader.node(i);
            ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
            composerChangeListWriter.realizeNodeMovementOperations();
            composerChangeListWriter.pendingDownNodes.add(objNode);
        }
    }

    /* JADX WARN: Code duplicated, block: B:150:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:202:0x051b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v32 */
    public final void end(boolean z) {
        long jRotateRight;
        IntStack intStack;
        ArrayList arrayList;
        int i;
        ?? r3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        IntStack intStack2;
        int i7;
        MutableScatterSet mutableScatterSet;
        int i8;
        int i9;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashSet hashSet;
        int i10;
        int i11;
        Object[] objArr;
        long[] jArr;
        int i12;
        Object[] objArr2;
        long[] jArr2;
        int i13;
        Object[] objArr3;
        long[] jArr3;
        int i14;
        Object[] objArr4;
        long[] jArr4;
        long jRotateRight2;
        IntStack intStack3 = this.parentStateStack;
        int i15 = intStack3.slots[intStack3.tos - 2] - 1;
        boolean z2 = this.inserting;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (z2) {
            SlotWriter slotWriter = this.writer;
            int i16 = slotWriter.parent;
            int iGroupKey = slotWriter.groupKey(i16);
            Object objGroupObjectKey = this.writer.groupObjectKey(i16);
            Object objGroupAux = this.writer.groupAux(i16);
            if (objGroupObjectKey != null) {
                jRotateRight2 = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) 0), 3) ^ ((long) (objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey.hashCode())), 3);
            } else if (objGroupAux == null || iGroupKey != 207 || objGroupAux.equals(neverEqualPolicy)) {
                jRotateRight2 = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) i15), 3) ^ ((long) iGroupKey), 3);
            } else {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) i15), 3) ^ ((long) objGroupAux.hashCode()), 3);
            }
            this.compositeKeyHashCode = jRotateRight2;
        } else {
            SlotReader slotReader = this.reader;
            int i17 = slotReader.parent;
            int iGroupKey2 = slotReader.groupKey(i17);
            SlotReader slotReader2 = this.reader;
            Object objObjectKey = slotReader2.objectKey(slotReader2.groups, i17);
            SlotReader slotReader3 = this.reader;
            Object objAux = slotReader3.aux(slotReader3.groups, i17);
            if (objObjectKey != null) {
                jRotateRight = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) 0), 3) ^ ((long) (objObjectKey instanceof Enum ? ((Enum) objObjectKey).ordinal() : objObjectKey.hashCode())), 3);
            } else if (objAux == null || iGroupKey2 != 207 || objAux.equals(neverEqualPolicy)) {
                jRotateRight = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) i15), 3) ^ ((long) iGroupKey2), 3);
            } else {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) i15), 3) ^ ((long) objAux.hashCode()), 3);
            }
            this.compositeKeyHashCode = jRotateRight;
        }
        int i18 = this.groupNodeCount;
        GapPending gapPending = this.pending;
        ArrayList arrayList4 = this.invalidations;
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        if (gapPending != null) {
            MutableIntObjectMap mutableIntObjectMap = gapPending.groupInfos;
            int i19 = gapPending.startIndex;
            ArrayList arrayList5 = gapPending.keyInfos;
            if (arrayList5.size() > 0) {
                ArrayList arrayList6 = gapPending.usedKeys;
                HashSet hashSet2 = new HashSet(arrayList6.size());
                int size = arrayList6.size();
                for (int i20 = 0; i20 < size; i20++) {
                    hashSet2.add(arrayList6.get(i20));
                }
                i = -1;
                MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                MutableScatterSet mutableScatterSet3 = new MutableScatterSet();
                int size2 = arrayList6.size();
                int size3 = arrayList5.size();
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                while (i21 < size3) {
                    KeyInfo keyInfo = (KeyInfo) arrayList5.get(i21);
                    if (hashSet2.contains(keyInfo)) {
                        intStack2 = intStack3;
                        i7 = i21;
                        if (!mutableScatterSet3.contains(keyInfo)) {
                            int i24 = i22;
                            if (i24 < size2) {
                                KeyInfo keyInfo2 = (KeyInfo) arrayList6.get(i24);
                                if (keyInfo2 != keyInfo) {
                                    GroupInfo groupInfo = (GroupInfo) mutableIntObjectMap.get(keyInfo2.location);
                                    int i25 = groupInfo != null ? groupInfo.nodeIndex : -1;
                                    mutableScatterSet3.add(keyInfo2);
                                    i10 = i23;
                                    if (i25 != i10) {
                                        GroupInfo groupInfo2 = (GroupInfo) mutableIntObjectMap.get(keyInfo2.location);
                                        int i26 = groupInfo2 != null ? groupInfo2.nodeCount : keyInfo2.nodes;
                                        mutableScatterSet = mutableScatterSet3;
                                        int i27 = i25 + i19;
                                        i8 = size2;
                                        int i28 = i10 + i19;
                                        if (i26 > 0) {
                                            i9 = i19;
                                            int i29 = composerChangeListWriter.moveCount;
                                            if (i29 > 0) {
                                                arrayList2 = arrayList5;
                                                if (composerChangeListWriter.moveFrom == i27 - i29 && composerChangeListWriter.moveTo == i28 - i29) {
                                                    composerChangeListWriter.moveCount = i29 + i26;
                                                }
                                            } else {
                                                arrayList2 = arrayList5;
                                            }
                                            composerChangeListWriter.realizeNodeMovementOperations();
                                            composerChangeListWriter.moveFrom = i27;
                                            composerChangeListWriter.moveTo = i28;
                                            composerChangeListWriter.moveCount = i26;
                                        } else {
                                            i9 = i19;
                                            arrayList2 = arrayList5;
                                            composerChangeListWriter.getClass();
                                        }
                                        if (i25 <= i10) {
                                            int i30 = i26;
                                            arrayList4 = arrayList4;
                                            arrayList3 = arrayList6;
                                            hashSet = hashSet2;
                                            if (i10 > i25) {
                                                Object[] objArr5 = mutableIntObjectMap.values;
                                                long[] jArr5 = mutableIntObjectMap.metadata;
                                                int length = jArr5.length - 2;
                                                if (length >= 0) {
                                                    int i31 = 0;
                                                    while (true) {
                                                        long j = jArr5[i31];
                                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i32 = 8 - ((~(i31 - length)) >>> 31);
                                                            int i33 = 0;
                                                            while (i33 < i32) {
                                                                if ((j & 255) < 128) {
                                                                    objArr2 = objArr5;
                                                                    GroupInfo groupInfo3 = (GroupInfo) objArr5[(i31 << 3) + i33];
                                                                    jArr2 = jArr5;
                                                                    int i34 = groupInfo3.nodeIndex;
                                                                    i13 = i25;
                                                                    if (i25 <= i34 && i34 < i13 + i30) {
                                                                        groupInfo3.nodeIndex = (i34 - i13) + i10;
                                                                    } else if (i13 + 1 <= i34 && i34 < i10) {
                                                                        groupInfo3.nodeIndex = i34 - i30;
                                                                    }
                                                                } else {
                                                                    objArr2 = objArr5;
                                                                    jArr2 = jArr5;
                                                                    i13 = i25;
                                                                }
                                                                j >>= 8;
                                                                i33++;
                                                                jArr5 = jArr2;
                                                                objArr5 = objArr2;
                                                                i25 = i13;
                                                            }
                                                            objArr = objArr5;
                                                            jArr = jArr5;
                                                            i12 = i25;
                                                            if (i32 != 8) {
                                                                break;
                                                            }
                                                        } else {
                                                            objArr = objArr5;
                                                            jArr = jArr5;
                                                            i12 = i25;
                                                        }
                                                        if (i31 == length) {
                                                            break;
                                                        }
                                                        i31++;
                                                        jArr5 = jArr;
                                                        objArr5 = objArr;
                                                        i25 = i12;
                                                    }
                                                }
                                            }
                                        } else {
                                            Object[] objArr6 = mutableIntObjectMap.values;
                                            long[] jArr6 = mutableIntObjectMap.metadata;
                                            int length2 = jArr6.length - 2;
                                            if (length2 >= 0) {
                                                arrayList3 = arrayList6;
                                                hashSet = hashSet2;
                                                int i35 = 0;
                                                while (true) {
                                                    long j2 = jArr6[i35];
                                                    int i36 = i26;
                                                    arrayList4 = arrayList4;
                                                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i37 = 8 - ((~(i35 - length2)) >>> 31);
                                                        int i38 = 0;
                                                        while (i38 < i37) {
                                                            if ((j2 & 255) < 128) {
                                                                i14 = i38;
                                                                GroupInfo groupInfo4 = (GroupInfo) objArr6[(i35 << 3) + i38];
                                                                objArr4 = objArr6;
                                                                int i39 = groupInfo4.nodeIndex;
                                                                jArr4 = jArr6;
                                                                if (i25 <= i39 && i39 < i25 + i36) {
                                                                    groupInfo4.nodeIndex = (i39 - i25) + i10;
                                                                } else if (i10 <= i39 && i39 < i25) {
                                                                    groupInfo4.nodeIndex = i39 + i36;
                                                                }
                                                            } else {
                                                                i14 = i38;
                                                                objArr4 = objArr6;
                                                                jArr4 = jArr6;
                                                            }
                                                            j2 >>= 8;
                                                            i38 = i14 + 1;
                                                            objArr6 = objArr4;
                                                            jArr6 = jArr4;
                                                        }
                                                        objArr3 = objArr6;
                                                        jArr3 = jArr6;
                                                        if (i37 != 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        objArr3 = objArr6;
                                                        jArr3 = jArr6;
                                                    }
                                                    if (i35 == length2) {
                                                        break;
                                                    }
                                                    i35++;
                                                    arrayList4 = arrayList4;
                                                    i26 = i36;
                                                    objArr6 = objArr3;
                                                    jArr6 = jArr3;
                                                }
                                            }
                                        }
                                        i11 = i7;
                                    } else {
                                        mutableScatterSet = mutableScatterSet3;
                                        i8 = size2;
                                        i9 = i19;
                                        arrayList2 = arrayList5;
                                    }
                                    arrayList3 = arrayList6;
                                    hashSet = hashSet2;
                                    i11 = i7;
                                } else {
                                    arrayList4 = arrayList4;
                                    mutableScatterSet = mutableScatterSet3;
                                    i8 = size2;
                                    i9 = i19;
                                    arrayList2 = arrayList5;
                                    arrayList3 = arrayList6;
                                    hashSet = hashSet2;
                                    i10 = i23;
                                    i11 = i7 + 1;
                                }
                                i22 = i24 + 1;
                                GroupInfo groupInfo5 = (GroupInfo) mutableIntObjectMap.get(keyInfo2.location);
                                int i40 = i10 + (groupInfo5 != null ? groupInfo5.nodeCount : keyInfo2.nodes);
                                i21 = i11;
                                gapPending = gapPending;
                                mutableScatterSet3 = mutableScatterSet;
                                size2 = i8;
                                i19 = i9;
                                arrayList5 = arrayList2;
                                arrayList6 = arrayList3;
                                hashSet2 = hashSet;
                                arrayList4 = arrayList4;
                                i23 = i40;
                                intStack3 = intStack2;
                            } else {
                                i22 = i24;
                                intStack3 = intStack2;
                                i21 = i7;
                            }
                        }
                    } else {
                        intStack2 = intStack3;
                        GroupInfo groupInfo6 = (GroupInfo) mutableIntObjectMap.get(keyInfo.location);
                        int i41 = groupInfo6 != null ? groupInfo6.nodeIndex : -1;
                        int i42 = keyInfo.location;
                        i7 = i21;
                        composerChangeListWriter.removeNode(i41 + i19, keyInfo.nodes);
                        gapPending.updateNodeCount(i42, 0);
                        composerChangeListWriter.writersReaderDelta = (i42 - composerChangeListWriter.composer.reader.currentGroup) + composerChangeListWriter.writersReaderDelta;
                        this.reader.reposition(i42);
                        recordDelete();
                        this.reader.skipGroup();
                        Stack.access$removeRange(arrayList4, i42, this.reader.groups[(i42 * 5) + 3] + i42);
                    }
                    i21 = i7 + 1;
                    intStack3 = intStack2;
                }
                intStack = intStack3;
                arrayList = arrayList4;
                composerChangeListWriter.realizeNodeMovementOperations();
                if (arrayList5.size() > 0) {
                    SlotReader slotReader4 = this.reader;
                    composerChangeListWriter.writersReaderDelta = (slotReader4.currentEnd - composerChangeListWriter.composer.reader.currentGroup) + composerChangeListWriter.writersReaderDelta;
                    slotReader4.skipToGroupEnd();
                }
            } else {
                intStack = intStack3;
                arrayList = arrayList4;
                i = -1;
            }
        } else {
            intStack = intStack3;
            arrayList = arrayList4;
            i = -1;
        }
        boolean z3 = this.inserting;
        if (!z3) {
            SlotReader slotReader5 = this.reader;
            int i43 = slotReader5.currentSlotEnd - slotReader5.currentSlot;
            if (i43 > 0) {
                if (i43 > 0) {
                    composerChangeListWriter.realizeOperationLocation(false);
                    IntStack intStack4 = composerChangeListWriter.startedGroups;
                    SlotReader slotReader6 = composerChangeListWriter.composer.reader;
                    if (slotReader6.groupsSize > 0 && intStack4.peekOr(-2) != (i6 = slotReader6.parent)) {
                        if (!composerChangeListWriter.startedGroup && composerChangeListWriter.implicitRootStart) {
                            composerChangeListWriter.realizeOperationLocation(false);
                            composerChangeListWriter.changeList.operations.pushOp(Operation.EnsureRootGroupStarted.INSTANCE);
                            composerChangeListWriter.startedGroup = true;
                        }
                        if (i6 > 0) {
                            GapAnchor gapAnchorAnchor = slotReader6.anchor(i6);
                            intStack4.push(i6);
                            composerChangeListWriter.realizeOperationLocation(false);
                            Operations operations = composerChangeListWriter.changeList.operations;
                            operations.pushOp(Operation.EnsureGroupStarted.INSTANCE);
                            zzsi.m814setObjectsGr0YRc(operations, 0, gapAnchorAnchor);
                            composerChangeListWriter.startedGroup = true;
                        }
                    }
                    Operations operations2 = composerChangeListWriter.changeList.operations;
                    operations2.pushOp(Operation.TrimParentValues.INSTANCE);
                    operations2.intArgs[operations2.intArgsSize - operations2.opCodes[operations2.opCodesSize - 1].ints] = i43;
                } else {
                    composerChangeListWriter.getClass();
                }
            }
        }
        int i44 = this.nodeIndex;
        while (true) {
            SlotReader slotReader7 = this.reader;
            if (slotReader7.emptyCount > 0 || (i5 = slotReader7.currentGroup) == slotReader7.currentEnd) {
                break;
            }
            recordDelete();
            composerChangeListWriter.removeNode(i44, this.reader.skipGroup());
            Stack.access$removeRange(arrayList, i5, this.reader.currentGroup);
        }
        if (z3) {
            if (z) {
                FixupList fixupList = this.insertFixups;
                Operations operations3 = fixupList.pendingOperations;
                if (operations3.opCodesSize == 0) {
                    ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
                }
                Operations operations4 = fixupList.operations;
                Operation[] operationArr = operations3.opCodes;
                int i45 = operations3.opCodesSize - 1;
                operations3.opCodesSize = i45;
                Operation operation = operationArr[i45];
                operationArr[i45] = null;
                operations4.pushOp(operation);
                Object[] objArr7 = operations3.objectArgs;
                Object[] objArr8 = operations4.objectArgs;
                int i46 = operations4.objectArgsSize;
                int i47 = operation.objects;
                int i48 = operations3.objectArgsSize;
                int i49 = i48 - i47;
                System.arraycopy(objArr7, i49, objArr8, i46 - i47, i48 - i49);
                Object[] objArr9 = operations3.objectArgs;
                int i50 = operations3.objectArgsSize;
                Arrays.fill(objArr9, i50 - i47, i50, (Object) null);
                int[] iArr = operations3.intArgs;
                int[] iArr2 = operations4.intArgs;
                int i51 = operations4.intArgsSize;
                int i52 = operation.ints;
                int i53 = operations3.intArgsSize;
                ArraysKt.copyInto(i51 - i52, i53 - i52, i53, iArr, iArr2);
                operations3.objectArgsSize -= i47;
                operations3.intArgsSize -= i52;
                i18 = 1;
            }
            SlotReader slotReader8 = this.reader;
            if (slotReader8.emptyCount <= 0) {
                PreconditionsKt.throwIllegalArgumentException("Unbalanced begin/end empty");
            }
            slotReader8.emptyCount--;
            SlotWriter slotWriter2 = this.writer;
            int i54 = slotWriter2.parent;
            slotWriter2.endGroup();
            if (this.reader.emptyCount <= 0) {
                int i55 = (-2) - i54;
                this.writer.endInsert();
                this.writer.close(true);
                GapAnchor gapAnchor = this.insertAnchor;
                if (this.insertFixups.operations.isEmpty()) {
                    SlotTable slotTable = this.insertTable;
                    composerChangeListWriter.pushPendingUpsAndDowns();
                    composerChangeListWriter.realizeOperationLocation(false);
                    IntStack intStack5 = composerChangeListWriter.startedGroups;
                    SlotReader slotReader9 = composerChangeListWriter.composer.reader;
                    if (slotReader9.groupsSize <= 0 || intStack5.peekOr(-2) == (i4 = slotReader9.parent)) {
                        i3 = 1;
                    } else {
                        if (!composerChangeListWriter.startedGroup && composerChangeListWriter.implicitRootStart) {
                            composerChangeListWriter.realizeOperationLocation(false);
                            composerChangeListWriter.changeList.operations.pushOp(Operation.EnsureRootGroupStarted.INSTANCE);
                            composerChangeListWriter.startedGroup = true;
                        }
                        if (i4 > 0) {
                            GapAnchor gapAnchorAnchor2 = slotReader9.anchor(i4);
                            intStack5.push(i4);
                            composerChangeListWriter.realizeOperationLocation(false);
                            Operations operations5 = composerChangeListWriter.changeList.operations;
                            operations5.pushOp(Operation.EnsureGroupStarted.INSTANCE);
                            zzsi.m814setObjectsGr0YRc(operations5, 0, gapAnchorAnchor2);
                            i3 = 1;
                            composerChangeListWriter.startedGroup = true;
                        } else {
                            i3 = 1;
                        }
                    }
                    composerChangeListWriter.realizeNodeMovementOperations();
                    Operations operations6 = composerChangeListWriter.changeList.operations;
                    operations6.pushOp(Operation.InsertSlots.INSTANCE);
                    zzsi.m815setObjectsEsEZvaA(operations6, 0, gapAnchor, i3, slotTable);
                    r3 = 0;
                } else {
                    SlotTable slotTable2 = this.insertTable;
                    FixupList fixupList2 = this.insertFixups;
                    composerChangeListWriter.pushPendingUpsAndDowns();
                    composerChangeListWriter.realizeOperationLocation(false);
                    IntStack intStack6 = composerChangeListWriter.startedGroups;
                    SlotReader slotReader10 = composerChangeListWriter.composer.reader;
                    if (slotReader10.groupsSize > 0 && intStack6.peekOr(-2) != (i2 = slotReader10.parent)) {
                        if (!composerChangeListWriter.startedGroup && composerChangeListWriter.implicitRootStart) {
                            composerChangeListWriter.realizeOperationLocation(false);
                            composerChangeListWriter.changeList.operations.pushOp(Operation.EnsureRootGroupStarted.INSTANCE);
                            composerChangeListWriter.startedGroup = true;
                        }
                        if (i2 > 0) {
                            GapAnchor gapAnchorAnchor3 = slotReader10.anchor(i2);
                            intStack6.push(i2);
                            composerChangeListWriter.realizeOperationLocation(false);
                            Operations operations7 = composerChangeListWriter.changeList.operations;
                            operations7.pushOp(Operation.EnsureGroupStarted.INSTANCE);
                            zzsi.m814setObjectsGr0YRc(operations7, 0, gapAnchorAnchor3);
                            composerChangeListWriter.startedGroup = true;
                        }
                    }
                    composerChangeListWriter.realizeNodeMovementOperations();
                    Operations operations8 = composerChangeListWriter.changeList.operations;
                    operations8.pushOp(Operation.InsertSlotsWithFixups.INSTANCE);
                    int i56 = operations8.objectArgsSize - operations8.opCodes[operations8.opCodesSize - 1].objects;
                    Object[] objArr10 = operations8.objectArgs;
                    objArr10[i56] = gapAnchor;
                    objArr10[i56 + 1] = slotTable2;
                    objArr10[i56 + 2] = fixupList2;
                    this.insertFixups = new FixupList();
                    r3 = 0;
                }
                this.inserting = r3;
                if (this.slotTable.groupsSize != 0) {
                    updateNodeCount(i55, r3);
                    updateNodeCountOverrides(i55, i18);
                }
            }
        } else {
            if (z) {
                composerChangeListWriter.moveUp();
            }
            int i57 = composerChangeListWriter.composer.reader.parent;
            IntStack intStack7 = composerChangeListWriter.startedGroups;
            int i58 = i;
            if (intStack7.peekOr(i58) > i57) {
                ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup");
            }
            if (intStack7.peekOr(i58) == i57) {
                composerChangeListWriter.realizeOperationLocation(false);
                intStack7.pop();
                composerChangeListWriter.changeList.operations.pushOp(Operation.EndCurrentGroup.INSTANCE);
            }
            int i59 = this.reader.parent;
            if (i18 != updatedNodeCount(i59)) {
                updateNodeCountOverrides(i59, i18);
            }
            if (z) {
                i18 = 1;
            }
            this.reader.endGroup();
            composerChangeListWriter.realizeNodeMovementOperations();
        }
        GapPending gapPending2 = (GapPending) Stack.m293popimpl(this.pendingStack);
        if (gapPending2 != null && !z3) {
            gapPending2.groupIndex++;
        }
        this.pending = gapPending2;
        this.nodeIndex = intStack.pop() + i18;
        this.rGroupIndex = intStack.pop();
        this.groupNodeCount = intStack.pop() + i18;
    }

    public final void endDefaults() {
        end(false);
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            int i = currentRecomposeScope$runtime.flags;
            if ((i & 1) != 0) {
                currentRecomposeScope$runtime.flags = i | 2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0031 A[EDGE_INSN: B:11:0x0031->B:28:0x0084 BREAK  A[LOOP:0: B:15:0x003f->B:27:0x0081]] */
    /* JADX WARN: Code duplicated, block: B:26:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0081 A[LOOP:0: B:15:0x003f->B:27:0x0081, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:61:0x0031 A[SYNTHETIC] */
    public final RecomposeScopeImpl endRestartGroup() {
        RecomposeScopeImpl recomposeScopeImpl;
        GapAnchor gapAnchorAnchor;
        ScrollNode$$ExternalSyntheticLambda0 scrollNode$$ExternalSyntheticLambda0;
        ArrayList arrayList = this.invalidateStack;
        RecomposeScopeImpl recomposeScopeImpl2 = Stack.m292isNotEmptyimpl(arrayList) ? (RecomposeScopeImpl) arrayList.remove(arrayList.size() - 1) : null;
        if (recomposeScopeImpl2 != null) {
            recomposeScopeImpl2.flags &= -9;
            this.observerHolder.current();
            int i = this.compositionToken;
            MutableObjectIntMap mutableObjectIntMap = recomposeScopeImpl2.trackedInstances;
            if (mutableObjectIntMap == null || (recomposeScopeImpl2.flags & 16) != 0) {
                scrollNode$$ExternalSyntheticLambda0 = null;
                break;
            }
            Object[] objArr = mutableObjectIntMap.keys;
            int[] iArr = mutableObjectIntMap.values;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                scrollNode$$ExternalSyntheticLambda0 = null;
                break;
            }
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((j & 255) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj = objArr[i5];
                            if (iArr[i5] != i) {
                                scrollNode$$ExternalSyntheticLambda0 = new ScrollNode$$ExternalSyntheticLambda0(i, 4, recomposeScopeImpl2, mutableObjectIntMap);
                                break loop0;
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 == 8) {
                        if (i2 == length) {
                            i2++;
                        }
                    }
                    scrollNode$$ExternalSyntheticLambda0 = null;
                    break;
                }
                if (i2 == length) {
                    scrollNode$$ExternalSyntheticLambda0 = null;
                    break;
                }
                i2++;
            }
            ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
            if (scrollNode$$ExternalSyntheticLambda0 != null) {
                Operations operations = composerChangeListWriter.changeList.operations;
                operations.pushOp(Operation.EndCompositionScope.INSTANCE);
                zzsi.m815setObjectsEsEZvaA(operations, 0, scrollNode$$ExternalSyntheticLambda0, 1, this.composition);
            }
            int i6 = recomposeScopeImpl2.flags;
            if ((i6 & 512) != 0) {
                recomposeScopeImpl2.flags = i6 & (-513);
                Operations operations2 = composerChangeListWriter.changeList.operations;
                operations2.pushOp(Operation.EndResumingScope.INSTANCE);
                zzsi.m814setObjectsGr0YRc(operations2, 0, recomposeScopeImpl2);
                int i7 = recomposeScopeImpl2.flags;
                recomposeScopeImpl2.flags = i7 & (-129);
                if ((i7 & 1024) != 0) {
                    recomposeScopeImpl2.flags = i7 & (-1153);
                    if (this.reusingGroup == this.reader.parent) {
                        this.reusing = false;
                        this.reusingGroup = -1;
                    }
                }
            }
        }
        if (recomposeScopeImpl2 != null) {
            int i8 = recomposeScopeImpl2.flags;
            if ((i8 & 16) == 0 && ((i8 & 1) != 0 || this.forceRecomposeScopes)) {
                if (recomposeScopeImpl2.anchor == null) {
                    if (this.inserting) {
                        SlotWriter slotWriter = this.writer;
                        gapAnchorAnchor = slotWriter.anchor(slotWriter.parent);
                    } else {
                        SlotReader slotReader = this.reader;
                        gapAnchorAnchor = slotReader.anchor(slotReader.parent);
                    }
                    recomposeScopeImpl2.anchor = gapAnchorAnchor;
                }
                recomposeScopeImpl2.flags &= -5;
                recomposeScopeImpl = recomposeScopeImpl2;
            } else {
                recomposeScopeImpl = null;
            }
        } else {
            recomposeScopeImpl = null;
        }
        end(false);
        return recomposeScopeImpl;
    }

    public final void endReuseFromRoot$runtime() {
        if (this.isComposing || this.reusingGroup != 0) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    public final void endRoot() {
        end(false);
        this.parentContext.doneComposing$runtime();
        end(false);
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        if (composerChangeListWriter.startedGroup) {
            composerChangeListWriter.realizeOperationLocation(false);
            composerChangeListWriter.realizeOperationLocation(false);
            composerChangeListWriter.changeList.operations.pushOp(Operation.EndCurrentGroup.INSTANCE);
            composerChangeListWriter.startedGroup = false;
        }
        composerChangeListWriter.pushPendingUpsAndDowns();
        if (composerChangeListWriter.startedGroups.tos != 0) {
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup()");
        }
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
        this.reader.close();
        this.providersInvalid = this.providersInvalidStack.pop() != 0;
    }

    public final void enterGroup(boolean z, GapPending gapPending) {
        this.pendingStack.add(this.pending);
        this.pending = gapPending;
        int i = this.groupNodeCount;
        IntStack intStack = this.parentStateStack;
        intStack.push(i);
        intStack.push(this.rGroupIndex);
        intStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
    }

    public final void forceFreshInsertTable() {
        SlotTable slotTable = new SlotTable();
        if (this.sourceMarkersEnabled) {
            slotTable.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime()) {
            slotTable.calledByMap = new MutableIntObjectMap();
        }
        this.insertTable = slotTable;
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
    }

    public final CompositionData getCompositionData() {
        GapCompositionDataImpl gapCompositionDataImpl = this._compositionData;
        if (gapCompositionDataImpl != null) {
            return gapCompositionDataImpl;
        }
        GapCompositionDataImpl gapCompositionDataImpl2 = new GapCompositionDataImpl(this.composition);
        this._compositionData = gapCompositionDataImpl2;
        return gapCompositionDataImpl2;
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime() {
        if (this.childrenComposing != 0) {
            return null;
        }
        ArrayList arrayList = this.invalidateStack;
        if (Stack.m292isNotEmptyimpl(arrayList)) {
            return (RecomposeScopeImpl) arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    public final boolean getDefaultsInvalid() {
        if (!getSkipping() || this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        return (currentRecomposeScope$runtime == null || (currentRecomposeScope$runtime.flags & 4) == 0) ? false : true;
    }

    public final CompositionErrorContextImpl getErrorContext$runtime() {
        if (this.parentContext.getStackTraceEnabled$runtime()) {
            return this.errorContext;
        }
        return null;
    }

    public final boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return (this.inserting || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || (currentRecomposeScope$runtime.flags & 8) != 0) ? false : true;
    }

    public final void insertMovableContentGuarded(ArrayList arrayList) {
        SlotReader slotReader;
        GapComposer gapComposer = this;
        ChangeList changeList = gapComposer.lateChanges;
        ComposerChangeListWriter composerChangeListWriter = gapComposer.changeListWriter;
        ChangeList changeList2 = composerChangeListWriter.changeList;
        try {
            composerChangeListWriter.changeList = changeList;
            changeList.operations.pushOp(Operation.ResetSlots.INSTANCE);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Pair pair = (Pair) arrayList.get(i);
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) pair.first;
                movableContentStateReference.getClass();
                GapAnchor gapAnchorAsGapAnchor = GapAnchorKt.asGapAnchor(null);
                SlotTable slotTableAsGapBufferSlotTable = SlotTableKt.asGapBufferSlotTable(null);
                int iAnchorIndex = slotTableAsGapBufferSlotTable.anchorIndex(gapAnchorAsGapAnchor);
                IntRef intRef = new IntRef();
                composerChangeListWriter.pushPendingUpsAndDowns();
                Operations operations = composerChangeListWriter.changeList.operations;
                operations.pushOp(Operation.DetermineMovableContentNodeIndex.INSTANCE);
                zzsi.m815setObjectsEsEZvaA(operations, 0, intRef, 1, gapAnchorAsGapAnchor);
                if (slotTableAsGapBufferSlotTable.equals(gapComposer.insertTable)) {
                    if (!gapComposer.writer.closed) {
                        ComposerKt.composeImmediateRuntimeError("Check failed");
                    }
                    gapComposer.forceFreshInsertTable();
                }
                SlotReader slotReaderOpenReader = slotTableAsGapBufferSlotTable.openReader();
                try {
                    slotReaderOpenReader.reposition(iAnchorIndex);
                    composerChangeListWriter.writersReaderDelta = iAnchorIndex;
                    try {
                        ChangeList changeList3 = new ChangeList();
                        slotReader = slotReaderOpenReader;
                        try {
                            recomposeMovableContent(null, null, null, EmptyList.INSTANCE, new GapComposer$$ExternalSyntheticLambda0(gapComposer, changeList3, slotReaderOpenReader, movableContentStateReference, 0));
                            ChangeList changeList4 = composerChangeListWriter.changeList;
                            changeList4.getClass();
                            if (!changeList3.operations.isEmpty()) {
                                Operations operations2 = changeList4.operations;
                                operations2.pushOp(Operation.ApplyChangeList.INSTANCE);
                                zzsi.m815setObjectsEsEZvaA(operations2, 0, changeList3, 1, intRef);
                            }
                            Unit unit = Unit.INSTANCE;
                            slotReader.close();
                            composerChangeListWriter.changeList.operations.pushOp(Operation.SkipToEndOfCurrentGroup.INSTANCE);
                            i++;
                            gapComposer = this;
                        } catch (Throwable th) {
                            th = th;
                            slotReader.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        slotReader = slotReaderOpenReader;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    slotReader = slotReaderOpenReader;
                }
            }
            composerChangeListWriter.pushPendingUpsAndDowns();
            composerChangeListWriter.changeList.operations.pushOp(Operation.EndMovableContentPlacement.INSTANCE);
            composerChangeListWriter.writersReaderDelta = 0;
            composerChangeListWriter.changeList = changeList2;
        } catch (Throwable th4) {
            composerChangeListWriter.changeList = changeList2;
            throw th4;
        }
    }

    public final void invokeMovableContentLambda(PersistentCompositionLocalMap persistentCompositionLocalMap, Object obj) {
        startMovableGroup(126665345, null);
        nextSlot();
        updateValue(obj);
        long j = this.compositeKeyHashCode;
        try {
            this.compositeKeyHashCode = 126665345;
            if (this.inserting) {
                SlotWriter.markGroup$default(this.writer);
            }
            boolean z = (this.inserting || Intrinsics.areEqual(this.reader.getGroupAux(), persistentCompositionLocalMap)) ? false : true;
            if (z) {
                recordProviderUpdate(persistentCompositionLocalMap);
            }
            m289startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalMap);
            this.providerCache = null;
            boolean z2 = this.providersInvalid;
            this.providersInvalid = z;
            ComposableLambdaImpl composableLambdaImpl = new ComposableLambdaImpl(-59194059, new Updater$$ExternalSyntheticLambda0(21, obj), true);
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, composableLambdaImpl);
            composableLambdaImpl.invoke((Object) this, (Object) 1);
            this.providersInvalid = z2;
            end(false);
            this.providerCache = null;
            this.compositeKeyHashCode = j;
            end(false);
        } catch (Throwable th) {
            try {
                ComposeStackTraceKt.tryAttachComposeStackTrace(th, new GapComposer$$ExternalSyntheticLambda1(2, this));
                throw th;
            } catch (Throwable th2) {
                end(false);
                this.providerCache = null;
                this.compositeKeyHashCode = j;
                end(false);
                throw th2;
            }
        }
    }

    public final Object nextSlot() {
        boolean z = this.inserting;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (!z) {
            Object next = this.reader.next();
            if (!this.reusing || (next instanceof ReusableGapRememberObserverHolder)) {
                return next;
            }
        } else if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
            return neverEqualPolicy;
        }
        return neverEqualPolicy;
    }

    public final List parentStackTrace$runtime() {
        CompositionContext compositionContext = this.parentContext;
        Composition composition$runtime = compositionContext.getComposition$runtime();
        CompositionImpl compositionImpl = composition$runtime instanceof CompositionImpl ? (CompositionImpl) composition$runtime : null;
        if (compositionImpl != null) {
            SlotTable slotTable = compositionImpl.slotStorage;
            SlotReader slotReaderOpenReader = SlotTableKt.asGapBufferSlotTable(slotTable).openReader();
            try {
                Integer numFindSubcompositionContextGroup$lambda$0$scanGroup = zzso.findSubcompositionContextGroup$lambda$0$scanGroup(slotReaderOpenReader, compositionContext, 0, slotReaderOpenReader.groupsSize);
                slotReaderOpenReader.close();
                if (numFindSubcompositionContextGroup$lambda$0$scanGroup != null) {
                    SlotReader slotReaderOpenReader2 = SlotTableKt.asGapBufferSlotTable(slotTable).openReader();
                    try {
                        return CollectionsKt.plus((Collection) zzso.traceForGroup(slotReaderOpenReader2, numFindSubcompositionContextGroup$lambda$0$scanGroup.intValue(), 0), compositionImpl.composer.parentStackTrace$runtime());
                    } finally {
                        slotReaderOpenReader2.close();
                    }
                }
            } catch (Throwable th) {
                slotReaderOpenReader.close();
                throw th;
            }
        }
        return EmptyList.INSTANCE;
    }

    public final int rGroupIndexOf(int i) {
        int iParent = this.reader.parent(i) + 1;
        int i2 = 0;
        while (iParent < i) {
            if (!this.reader.hasObjectKey(iParent)) {
                i2++;
            }
            iParent += this.reader.groups[(iParent * 5) + 3];
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0059 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0005, B:6:0x0012, B:8:0x0020, B:12:0x0029, B:11:0x0026, B:15:0x0030, B:18:0x0038, B:21:0x0040, B:23:0x0048, B:25:0x004e, B:26:0x0052, B:27:0x0053, B:29:0x0059, B:22:0x0044), top: B:34:0x0005, inners: #1 }] */
    public final Object recomposeMovableContent(CompositionImpl compositionImpl, CompositionImpl compositionImpl2, Integer num, List list, Function0 function0) {
        Object objInvoke;
        boolean z = this.isComposing;
        int i = this.nodeIndex;
        try {
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Pair pair = (Pair) list.get(i2);
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) pair.first;
                Object obj = pair.second;
                if (obj != null) {
                    tryImminentInvalidation$runtime(recomposeScopeImpl, obj);
                } else {
                    tryImminentInvalidation$runtime(recomposeScopeImpl, null);
                }
            }
            if (compositionImpl == null) {
                objInvoke = function0.invoke();
            } else {
                int iIntValue = num != null ? num.intValue() : -1;
                if (compositionImpl2 == null || compositionImpl2.equals(compositionImpl) || iIntValue < 0) {
                    objInvoke = function0.invoke();
                } else {
                    compositionImpl.invalidationDelegate = compositionImpl2;
                    compositionImpl.invalidationDelegateGroup = iIntValue;
                    try {
                        objInvoke = function0.invoke();
                        compositionImpl.invalidationDelegate = null;
                        compositionImpl.invalidationDelegateGroup = 0;
                    } catch (Throwable th) {
                        compositionImpl.invalidationDelegate = null;
                        compositionImpl.invalidationDelegateGroup = 0;
                        throw th;
                    }
                }
                if (objInvoke == null) {
                    objInvoke = function0.invoke();
                }
            }
            this.isComposing = z;
            this.nodeIndex = i;
            return objInvoke;
        } catch (Throwable th2) {
            this.isComposing = z;
            this.nodeIndex = i;
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003a  */
    /* JADX WARN: Code duplicated, block: B:168:0x032b  */
    /* JADX WARN: Code duplicated, block: B:202:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0113 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x0115 A[LOOP:7: B:38:0x00bf->B:57:0x0115, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x011e  */
    /* JADX WARN: Code duplicated, block: B:62:0x012a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0155  */
    /* JADX WARN: Code duplicated, block: B:70:0x0157  */
    /* JADX WARN: Code duplicated, block: B:73:0x015c  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:74:0x0168
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final void recomposeToGroupEnd() {
        /*
            Method dump skipped, instruction units count: 873
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.recomposeToGroupEnd():void");
    }

    public final void recordDelete() {
        int i;
        reportFreeMovableContent(this.reader.currentGroup);
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        composerChangeListWriter.realizeOperationLocation(false);
        IntStack intStack = composerChangeListWriter.startedGroups;
        GapComposer gapComposer = composerChangeListWriter.composer;
        SlotReader slotReader = gapComposer.reader;
        if (slotReader.groupsSize > 0 && intStack.peekOr(-2) != (i = slotReader.parent)) {
            if (!composerChangeListWriter.startedGroup && composerChangeListWriter.implicitRootStart) {
                composerChangeListWriter.realizeOperationLocation(false);
                composerChangeListWriter.changeList.operations.pushOp(Operation.EnsureRootGroupStarted.INSTANCE);
                composerChangeListWriter.startedGroup = true;
            }
            if (i > 0) {
                GapAnchor gapAnchorAnchor = slotReader.anchor(i);
                intStack.push(i);
                composerChangeListWriter.realizeOperationLocation(false);
                Operations operations = composerChangeListWriter.changeList.operations;
                operations.pushOp(Operation.EnsureGroupStarted.INSTANCE);
                zzsi.m814setObjectsGr0YRc(operations, 0, gapAnchorAnchor);
                composerChangeListWriter.startedGroup = true;
            }
        }
        composerChangeListWriter.changeList.operations.pushOp(Operation.RemoveCurrentGroup.INSTANCE);
        int i2 = composerChangeListWriter.writersReaderDelta;
        SlotReader slotReader2 = gapComposer.reader;
        composerChangeListWriter.writersReaderDelta = slotReader2.groups[(slotReader2.currentGroup * 5) + 3] + i2;
    }

    public final void recordProviderUpdate(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        MutableIntObjectMap mutableIntObjectMap = this.providerUpdates;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap();
            this.providerUpdates = mutableIntObjectMap;
        }
        mutableIntObjectMap.set(this.reader.currentGroup, persistentCompositionLocalMap);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a  */
    public final void recordUpsAndDowns(int i, int i2, int i3) {
        SlotReader slotReader = this.reader;
        if (i == i2) {
            i3 = i;
        } else if (i != i3 && i2 != i3) {
            if (slotReader.parent(i) == i2) {
                i3 = i2;
            } else if (slotReader.parent(i2) == i) {
                i3 = i;
            } else if (slotReader.parent(i) == slotReader.parent(i2)) {
                i3 = slotReader.parent(i);
            } else {
                int iParent = i;
                int i4 = 0;
                while (iParent > 0 && iParent != i3) {
                    iParent = slotReader.parent(iParent);
                    i4++;
                }
                int iParent2 = i2;
                int i5 = 0;
                while (iParent2 > 0 && iParent2 != i3) {
                    iParent2 = slotReader.parent(iParent2);
                    i5++;
                }
                int i6 = i4 - i5;
                int iParent3 = i;
                for (int i7 = 0; i7 < i6; i7++) {
                    iParent3 = slotReader.parent(iParent3);
                }
                int i8 = i5 - i4;
                int iParent4 = i2;
                for (int i9 = 0; i9 < i8; i9++) {
                    iParent4 = slotReader.parent(iParent4);
                }
                i3 = iParent3;
                for (int iParent5 = iParent4; i3 != iParent5; iParent5 = slotReader.parent(iParent5)) {
                    i3 = slotReader.parent(i3);
                }
            }
        }
        while (i > 0 && i != i3) {
            if (slotReader.isNode(i)) {
                this.changeListWriter.moveUp();
            }
            i = slotReader.parent(i);
        }
        doRecordDownsFor(i2, i3);
    }

    public final Object rememberedValue() {
        boolean z = this.inserting;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (!z) {
            Object next = this.reader.next();
            if (!this.reusing || (next instanceof ReusableGapRememberObserverHolder)) {
                return next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next;
            }
        } else if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
            return neverEqualPolicy;
        }
        return neverEqualPolicy;
    }

    public final void reportFreeMovableContent(int i) {
        boolean zIsNode = this.reader.isNode(i);
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        if (zIsNode) {
            composerChangeListWriter.realizeNodeMovementOperations();
            Object objNode = this.reader.node(i);
            composerChangeListWriter.realizeNodeMovementOperations();
            composerChangeListWriter.pendingDownNodes.add(objNode);
        }
        reportFreeMovableContent$reportGroup(this, i, zIsNode, 0);
        composerChangeListWriter.realizeNodeMovementOperations();
        if (zIsNode) {
            composerChangeListWriter.moveUp();
        }
    }

    public final boolean shouldExecute(int i, boolean z) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        if ((i & 1) == 0 && (this.inserting || this.reusing)) {
            ShouldPauseCallback shouldPauseCallback = this.shouldPauseCallback;
            if (shouldPauseCallback == null || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || !shouldPauseCallback.shouldPause() || (currentRecomposeScope$runtime.flags & 512) != 0) {
                return true;
            }
            currentRecomposeScope$runtime.setUsed();
            boolean z2 = this.reusing;
            int i2 = currentRecomposeScope$runtime.flags;
            currentRecomposeScope$runtime.flags = (z2 ? i2 | 128 : i2 & (-129)) | 256;
            Operations operations = this.changeListWriter.changeList.operations;
            operations.pushOp(Operation.RememberPausingScope.INSTANCE);
            zzsi.m814setObjectsGr0YRc(operations, 0, currentRecomposeScope$runtime);
            this.parentContext.reportPausedScope$runtime(currentRecomposeScope$runtime);
            return false;
        }
        if (!z && getSkipping()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:30:0x00af  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fd  */
    public final void skipCurrentGroup() {
        int i;
        long jRotateLeft;
        long jRotateLeft2;
        if (this.invalidations.isEmpty()) {
            this.groupNodeCount = this.reader.skipGroup() + this.groupNodeCount;
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        int[] iArr = slotReader.groups;
        int i2 = slotReader.currentGroup;
        Object objObjectKey = i2 < slotReader.currentEnd ? slotReader.objectKey(iArr, i2) : null;
        Object groupAux = slotReader.getGroupAux();
        int i3 = this.rGroupIndex;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (objObjectKey == null) {
            if (groupAux == null || groupKey != 207 || groupAux.equals(neverEqualPolicy)) {
                jRotateLeft2 = Long.rotateLeft(Long.rotateLeft(this.compositeKeyHashCode, 3) ^ ((long) groupKey), 3) ^ ((long) i3);
            } else {
                this.compositeKeyHashCode = Long.rotateLeft(((long) groupAux.hashCode()) ^ Long.rotateLeft(this.compositeKeyHashCode, 3), 3) ^ ((long) i3);
            }
            startReaderGroup(null, (iArr[(slotReader.currentGroup * 5) + 1] & 1073741824) != 0);
            recomposeToGroupEnd();
            slotReader.endGroup();
            if (objObjectKey != null) {
                if (objObjectKey instanceof Enum) {
                    this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) 0), 3) ^ ((long) ((Enum) objObjectKey).ordinal()), 3);
                } else {
                    this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) 0), 3) ^ ((long) objObjectKey.hashCode()), 3);
                }
            }
            if (groupAux == null && groupKey == 207 && !groupAux.equals(neverEqualPolicy)) {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) i3), 3) ^ ((long) groupAux.hashCode()), 3);
                return;
            } else {
                this.compositeKeyHashCode = Long.rotateRight(((long) groupKey) ^ Long.rotateRight(this.compositeKeyHashCode ^ ((long) i3), 3), 3);
            }
        }
        if (objObjectKey instanceof Enum) {
            jRotateLeft = Long.rotateLeft(((long) ((Enum) objObjectKey).ordinal()) ^ Long.rotateLeft(this.compositeKeyHashCode, 3), 3);
            i = 0;
        } else {
            i = 0;
            jRotateLeft = Long.rotateLeft(((long) objObjectKey.hashCode()) ^ Long.rotateLeft(this.compositeKeyHashCode, 3), 3);
        }
        jRotateLeft2 = jRotateLeft ^ ((long) i);
        this.compositeKeyHashCode = jRotateLeft2;
        startReaderGroup(null, (iArr[(slotReader.currentGroup * 5) + 1] & 1073741824) != 0);
        recomposeToGroupEnd();
        slotReader.endGroup();
        if (objObjectKey != null) {
            if (groupAux == null) {
            }
            this.compositeKeyHashCode = Long.rotateRight(((long) groupKey) ^ Long.rotateRight(this.compositeKeyHashCode ^ ((long) i3), 3), 3);
        } else if (objObjectKey instanceof Enum) {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) 0), 3) ^ ((long) ((Enum) objObjectKey).ordinal()), 3);
        } else {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.compositeKeyHashCode ^ ((long) 0), 3) ^ ((long) objObjectKey.hashCode()), 3);
        }
    }

    public final void skipReaderToGroupEnd() {
        SlotReader slotReader = this.reader;
        int i = slotReader.parent;
        this.groupNodeCount = i >= 0 ? slotReader.groups[(i * 5) + 1] & 67108863 : 0;
        slotReader.skipToGroupEnd();
    }

    public final void skipToGroupEnd() {
        if (this.groupNodeCount != 0) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (this.inserting) {
            return;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            int i = currentRecomposeScope$runtime.flags;
            if ((i & 128) == 0) {
                currentRecomposeScope$runtime.flags = i | 16;
            }
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    /* JADX WARN: Code duplicated, block: B:172:0x0326  */
    /* JADX WARN: Code duplicated, block: B:175:0x033c  */
    /* JADX WARN: Code duplicated, block: B:178:0x0357  */
    /* JADX WARN: Code duplicated, block: B:179:0x035d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x035f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:182:0x0363  */
    /* JADX WARN: Code duplicated, block: B:184:0x036a  */
    /* JADX WARN: Code duplicated, block: B:186:0x036d  */
    /* JADX WARN: Code duplicated, block: B:187:0x036f  */
    /* JADX WARN: Code duplicated, block: B:191:0x039d  */
    /* JADX WARN: Code duplicated, block: B:192:0x039f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:25:0x007c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:30:0x0090  */
    /* JADX WARN: Code duplicated, block: B:31:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0096 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x009f  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:65:0x010b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0111  */
    /* JADX WARN: Code duplicated, block: B:70:0x0125  */
    /* JADX WARN: Code duplicated, block: B:71:0x0129  */
    /* JADX WARN: Code duplicated, block: B:76:0x014d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0155  */
    /* JADX WARN: Code duplicated, block: B:79:0x015f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0173  */
    /* JADX WARN: Code duplicated, block: B:83:0x0175  */
    /* JADX WARN: Code duplicated, block: B:85:0x0179  */
    /* JADX WARN: Code duplicated, block: B:87:0x0186  */
    /* JADX WARN: Code duplicated, block: B:90:0x018e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0197  */
    /* JADX INFO: renamed from: start-AzEfcrM, reason: not valid java name */
    public final void m289startAzEfcrM(int i, int i2, Object obj, Object obj2) {
        long jRotateLeft;
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        GapPending gapPending;
        GapPending gapPending2;
        ArrayList arrayList;
        MutableIntObjectMap mutableIntObjectMap;
        int i3;
        Object objValueOf;
        MutableScatterMap mutableScatterMap;
        Object obj3;
        MutableObjectList mutableObjectList;
        SlotWriter slotWriter;
        int i4;
        Object obj4;
        int i5;
        int i6;
        Object[] objArr;
        Object[] objArr2;
        int i7;
        int i8;
        int i9;
        SlotReader slotReader;
        int[] iArr;
        ArrayList arrayList2;
        int i10;
        int i11;
        int i12;
        SlotReader slotReader2;
        int i13;
        Object objObjectKey;
        SlotWriter slotWriter2;
        int i14;
        GapPending gapPending3;
        Object obj5 = obj;
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
        int i15 = this.rGroupIndex;
        Object obj6 = Composer$Companion.Empty;
        if (obj5 == null) {
            if (obj2 == null || i != 207 || obj2.equals(obj6)) {
                jRotateLeft = Long.rotateLeft(Long.rotateLeft(this.compositeKeyHashCode, 3) ^ ((long) i), 3);
                j = i15;
            } else {
                this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.compositeKeyHashCode, 3) ^ ((long) obj2.hashCode()), 3) ^ ((long) i15);
            }
            if (obj5 == null) {
                this.rGroupIndex++;
            }
            if (i2 != 0) {
                z = true;
            } else {
                z = false;
            }
            if (this.inserting) {
                this.reader.emptyCount++;
                slotWriter2 = this.writer;
                i14 = slotWriter2.currentGroup;
                if (z) {
                    slotWriter2.startGroup(i, obj6, obj6, true);
                } else if (obj2 != null) {
                    if (obj5 == null) {
                        obj5 = obj6;
                    }
                    slotWriter2.startGroup(i, obj5, obj2, false);
                } else {
                    if (obj5 == null) {
                        obj5 = obj6;
                    }
                    slotWriter2.startGroup(i, obj5, obj6, false);
                }
                gapPending3 = this.pending;
                if (gapPending3 != null) {
                    int i16 = (-2) - i14;
                    KeyInfo keyInfo = new KeyInfo(-1, i, i16, -1);
                    gapPending3.groupInfos.set(i16, new GroupInfo(-1, this.nodeIndex - gapPending3.startIndex, 0));
                    gapPending3.usedKeys.add(keyInfo);
                }
                enterGroup(z, null);
                return;
            }
            if (i2 != 1 && this.reusing) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.pending == null) {
                int groupKey = this.reader.getGroupKey();
                if (!z2 && groupKey == i) {
                    slotReader2 = this.reader;
                    i13 = slotReader2.currentGroup;
                    if (i13 < slotReader2.currentEnd) {
                        objObjectKey = slotReader2.objectKey(slotReader2.groups, i13);
                    } else {
                        objObjectKey = null;
                    }
                    if (Intrinsics.areEqual(obj5, objObjectKey)) {
                        startReaderGroup(obj2, z);
                        z3 = z2;
                    }
                }
                slotReader = this.reader;
                iArr = slotReader.groups;
                arrayList2 = new ArrayList();
                if (slotReader.emptyCount <= 0) {
                    i10 = slotReader.currentGroup;
                    while (i10 < slotReader.currentEnd) {
                        int i17 = i10 * 5;
                        int i18 = iArr[i17];
                        Object objObjectKey2 = slotReader.objectKey(iArr, i10);
                        i11 = iArr[i17 + 1];
                        if ((i11 & 1073741824) != 0) {
                            i12 = 1;
                        } else {
                            i12 = i11 & 67108863;
                        }
                        arrayList2.add(new KeyInfo(objObjectKey2, i18, i10, i12));
                        i10 += iArr[i17 + 3];
                        z2 = z2;
                    }
                }
                z3 = z2;
                this.pending = new GapPending(this.nodeIndex, arrayList2);
            } else {
                z3 = z2;
            }
            gapPending = this.pending;
            if (gapPending != null) {
                arrayList = gapPending.usedKeys;
                mutableIntObjectMap = gapPending.groupInfos;
                i3 = gapPending.startIndex;
                if (obj5 != null) {
                    objValueOf = new JoinedKey(Integer.valueOf(i), obj5);
                } else {
                    objValueOf = Integer.valueOf(i);
                }
                mutableScatterMap = ((MultiValueMap) gapPending.keyMap$delegate.getValue()).map;
                obj3 = mutableScatterMap.get(objValueOf);
                if (obj3 == null) {
                    obj3 = null;
                } else if (obj3 instanceof MutableObjectList) {
                    mutableObjectList = (MutableObjectList) obj3;
                    Object objRemoveAt = mutableObjectList.removeAt(0);
                    if (mutableObjectList.isEmpty()) {
                        mutableScatterMap.remove(objValueOf);
                    }
                    if (mutableObjectList._size == 1) {
                        mutableScatterMap.set(objValueOf, mutableObjectList.first());
                    }
                    obj3 = objRemoveAt;
                } else {
                    mutableScatterMap.remove(objValueOf);
                }
                KeyInfo keyInfo2 = (KeyInfo) obj3;
                if (!z3 || keyInfo2 == null) {
                    this.reader.emptyCount++;
                    this.inserting = true;
                    this.providerCache = null;
                    if (this.writer.closed) {
                        SlotWriter slotWriterOpenWriter = this.insertTable.openWriter();
                        this.writer = slotWriterOpenWriter;
                        slotWriterOpenWriter.skipToGroupEnd();
                        this.writerHasAProvider = false;
                        this.providerCache = null;
                    }
                    this.writer.beginInsert();
                    slotWriter = this.writer;
                    int i19 = slotWriter.currentGroup;
                    if (z) {
                        slotWriter.startGroup(i, obj6, obj6, true);
                        i4 = 0;
                    } else if (obj2 != null) {
                        if (obj != null) {
                            obj6 = obj;
                        }
                        i4 = 0;
                        slotWriter.startGroup(i, obj6, obj2, false);
                    } else {
                        i4 = 0;
                        if (obj == null) {
                            obj4 = obj6;
                        } else {
                            obj4 = obj;
                        }
                        slotWriter.startGroup(i, obj4, obj6, false);
                    }
                    this.insertAnchor = this.writer.anchor(i19);
                    int i20 = (-2) - i19;
                    KeyInfo keyInfo3 = new KeyInfo(-1, i, i20, -1);
                    mutableIntObjectMap.set(i20, new GroupInfo(-1, this.nodeIndex - i3, i4));
                    arrayList.add(keyInfo3);
                    ArrayList arrayList3 = new ArrayList();
                    if (z) {
                        i5 = i4;
                    } else {
                        i5 = this.nodeIndex;
                    }
                    gapPending2 = new GapPending(i5, arrayList3);
                } else {
                    int i21 = keyInfo2.location;
                    arrayList.add(keyInfo2);
                    GroupInfo groupInfo = (GroupInfo) mutableIntObjectMap.get(i21);
                    this.nodeIndex = (groupInfo != null ? groupInfo.nodeIndex : -1) + i3;
                    GroupInfo groupInfo2 = (GroupInfo) mutableIntObjectMap.get(i21);
                    int i22 = groupInfo2 != null ? groupInfo2.slotIndex : -1;
                    int i23 = gapPending.groupIndex;
                    int i24 = i22 - i23;
                    int i25 = 8;
                    if (i22 <= i23) {
                        i6 = i24;
                        if (i23 > i22) {
                            Object[] objArr3 = mutableIntObjectMap.values;
                            long[] jArr = mutableIntObjectMap.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i26 = 0;
                                while (true) {
                                    long j2 = jArr[i26];
                                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i27 = 8 - ((~(i26 - length)) >>> 31);
                                        int i28 = 0;
                                        while (i28 < i27) {
                                            if ((j2 & 255) >= 128) {
                                                objArr2 = objArr3;
                                            } else {
                                                GroupInfo groupInfo3 = (GroupInfo) objArr3[(i26 << 3) + i28];
                                                int i29 = groupInfo3.slotIndex;
                                                if (i29 == i22) {
                                                    groupInfo3.slotIndex = i23;
                                                    objArr2 = objArr3;
                                                } else {
                                                    objArr2 = objArr3;
                                                    if (i22 + 1 <= i29 && i29 < i23) {
                                                        groupInfo3.slotIndex = i29 - 1;
                                                    }
                                                }
                                            }
                                            j2 >>= 8;
                                            i28++;
                                            objArr3 = objArr2;
                                        }
                                        objArr = objArr3;
                                        if (i27 != 8) {
                                            break;
                                        }
                                    } else {
                                        objArr = objArr3;
                                    }
                                    if (i26 == length) {
                                        break;
                                    }
                                    i26++;
                                    objArr3 = objArr;
                                }
                            }
                        }
                    } else {
                        Object[] objArr4 = mutableIntObjectMap.values;
                        long[] jArr2 = mutableIntObjectMap.metadata;
                        int length2 = jArr2.length - 2;
                        if (length2 >= 0) {
                            int i30 = 0;
                            while (true) {
                                long j3 = jArr2[i30];
                                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i31 = 8 - ((~(i30 - length2)) >>> 31);
                                    int i32 = 0;
                                    while (i32 < i31) {
                                        if ((j3 & 255) < 128) {
                                            i9 = i25;
                                            GroupInfo groupInfo4 = (GroupInfo) objArr4[(i30 << 3) + i32];
                                            i8 = i24;
                                            int i33 = groupInfo4.slotIndex;
                                            if (i33 == i22) {
                                                groupInfo4.slotIndex = i23;
                                            } else if (i23 <= i33 && i33 < i22) {
                                                groupInfo4.slotIndex = i33 + 1;
                                            }
                                        } else {
                                            i8 = i24;
                                            i9 = i25;
                                        }
                                        j3 >>= i9;
                                        i32++;
                                        i24 = i8;
                                        i25 = i9;
                                    }
                                    i6 = i24;
                                    if (i31 != i25) {
                                        break;
                                    }
                                } else {
                                    i6 = i24;
                                }
                                if (i30 == length2) {
                                    break;
                                }
                                i30++;
                                i24 = i6;
                                i25 = 8;
                            }
                        } else {
                            i6 = i24;
                        }
                    }
                    ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                    int i34 = composerChangeListWriter.writersReaderDelta;
                    GapComposer gapComposer = composerChangeListWriter.composer;
                    composerChangeListWriter.writersReaderDelta = (i21 - gapComposer.reader.currentGroup) + i34;
                    this.reader.reposition(i21);
                    if (i6 > 0) {
                        composerChangeListWriter.realizeOperationLocation(false);
                        IntStack intStack = composerChangeListWriter.startedGroups;
                        SlotReader slotReader3 = gapComposer.reader;
                        if (slotReader3.groupsSize > 0 && intStack.peekOr(-2) != (i7 = slotReader3.parent)) {
                            if (!composerChangeListWriter.startedGroup && composerChangeListWriter.implicitRootStart) {
                                composerChangeListWriter.realizeOperationLocation(false);
                                composerChangeListWriter.changeList.operations.pushOp(Operation.EnsureRootGroupStarted.INSTANCE);
                                composerChangeListWriter.startedGroup = true;
                            }
                            if (i7 > 0) {
                                GapAnchor gapAnchorAnchor = slotReader3.anchor(i7);
                                intStack.push(i7);
                                composerChangeListWriter.realizeOperationLocation(false);
                                Operations operations = composerChangeListWriter.changeList.operations;
                                operations.pushOp(Operation.EnsureGroupStarted.INSTANCE);
                                zzsi.m814setObjectsGr0YRc(operations, 0, gapAnchorAnchor);
                                composerChangeListWriter.startedGroup = true;
                            }
                        }
                        Operations operations2 = composerChangeListWriter.changeList.operations;
                        operations2.pushOp(Operation.MoveCurrentGroup.INSTANCE);
                        operations2.intArgs[operations2.intArgsSize - operations2.opCodes[operations2.opCodesSize - 1].ints] = i6;
                    }
                    startReaderGroup(obj2, z);
                    gapPending2 = null;
                }
            } else {
                gapPending2 = null;
            }
            enterGroup(z, gapPending2);
        }
        jRotateLeft = Long.rotateLeft(Long.rotateLeft(this.compositeKeyHashCode, 3) ^ ((long) (obj5 instanceof Enum ? ((Enum) obj5).ordinal() : obj5.hashCode())), 3);
        j = 0;
        this.compositeKeyHashCode = jRotateLeft ^ j;
        if (obj5 == null) {
            this.rGroupIndex++;
        }
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.inserting) {
            this.reader.emptyCount++;
            slotWriter2 = this.writer;
            i14 = slotWriter2.currentGroup;
            if (z) {
                slotWriter2.startGroup(i, obj6, obj6, true);
            } else if (obj2 != null) {
                if (obj5 == null) {
                    obj5 = obj6;
                }
                slotWriter2.startGroup(i, obj5, obj2, false);
            } else {
                if (obj5 == null) {
                    obj5 = obj6;
                }
                slotWriter2.startGroup(i, obj5, obj6, false);
            }
            gapPending3 = this.pending;
            if (gapPending3 != null) {
                int i110 = (-2) - i14;
                KeyInfo keyInfo4 = new KeyInfo(-1, i, i110, -1);
                gapPending3.groupInfos.set(i110, new GroupInfo(-1, this.nodeIndex - gapPending3.startIndex, 0));
                gapPending3.usedKeys.add(keyInfo4);
            }
            enterGroup(z, null);
            return;
        }
        if (i2 != 1) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.pending == null) {
            int groupKey2 = this.reader.getGroupKey();
            if (!z2) {
                slotReader2 = this.reader;
                i13 = slotReader2.currentGroup;
                if (i13 < slotReader2.currentEnd) {
                    objObjectKey = slotReader2.objectKey(slotReader2.groups, i13);
                } else {
                    objObjectKey = null;
                }
                if (Intrinsics.areEqual(obj5, objObjectKey)) {
                    startReaderGroup(obj2, z);
                    z3 = z2;
                }
            }
            slotReader = this.reader;
            iArr = slotReader.groups;
            arrayList2 = new ArrayList();
            if (slotReader.emptyCount <= 0) {
                i10 = slotReader.currentGroup;
                while (i10 < slotReader.currentEnd) {
                    int i111 = i10 * 5;
                    int i112 = iArr[i111];
                    Object objObjectKey3 = slotReader.objectKey(iArr, i10);
                    i11 = iArr[i111 + 1];
                    if ((i11 & 1073741824) != 0) {
                        i12 = 1;
                    } else {
                        i12 = i11 & 67108863;
                    }
                    arrayList2.add(new KeyInfo(objObjectKey3, i112, i10, i12));
                    i10 += iArr[i111 + 3];
                    z2 = z2;
                }
            }
            z3 = z2;
            this.pending = new GapPending(this.nodeIndex, arrayList2);
        } else {
            z3 = z2;
        }
        gapPending = this.pending;
        if (gapPending != null) {
            arrayList = gapPending.usedKeys;
            mutableIntObjectMap = gapPending.groupInfos;
            i3 = gapPending.startIndex;
            if (obj5 != null) {
                objValueOf = new JoinedKey(Integer.valueOf(i), obj5);
            } else {
                objValueOf = Integer.valueOf(i);
            }
            mutableScatterMap = ((MultiValueMap) gapPending.keyMap$delegate.getValue()).map;
            obj3 = mutableScatterMap.get(objValueOf);
            if (obj3 == null) {
                obj3 = null;
            } else if (obj3 instanceof MutableObjectList) {
                mutableObjectList = (MutableObjectList) obj3;
                Object objRemoveAt2 = mutableObjectList.removeAt(0);
                if (mutableObjectList.isEmpty()) {
                    mutableScatterMap.remove(objValueOf);
                }
                if (mutableObjectList._size == 1) {
                    mutableScatterMap.set(objValueOf, mutableObjectList.first());
                }
                obj3 = objRemoveAt2;
            } else {
                mutableScatterMap.remove(objValueOf);
            }
            KeyInfo keyInfo5 = (KeyInfo) obj3;
            if (z3) {
            }
            this.reader.emptyCount++;
            this.inserting = true;
            this.providerCache = null;
            if (this.writer.closed) {
                SlotWriter slotWriterOpenWriter2 = this.insertTable.openWriter();
                this.writer = slotWriterOpenWriter2;
                slotWriterOpenWriter2.skipToGroupEnd();
                this.writerHasAProvider = false;
                this.providerCache = null;
            }
            this.writer.beginInsert();
            slotWriter = this.writer;
            int i113 = slotWriter.currentGroup;
            if (z) {
                slotWriter.startGroup(i, obj6, obj6, true);
                i4 = 0;
            } else if (obj2 != null) {
                if (obj != null) {
                    obj6 = obj;
                }
                i4 = 0;
                slotWriter.startGroup(i, obj6, obj2, false);
            } else {
                i4 = 0;
                if (obj == null) {
                    obj4 = obj6;
                } else {
                    obj4 = obj;
                }
                slotWriter.startGroup(i, obj4, obj6, false);
            }
            this.insertAnchor = this.writer.anchor(i113);
            int i210 = (-2) - i113;
            KeyInfo keyInfo6 = new KeyInfo(-1, i, i210, -1);
            mutableIntObjectMap.set(i210, new GroupInfo(-1, this.nodeIndex - i3, i4));
            arrayList.add(keyInfo6);
            ArrayList arrayList4 = new ArrayList();
            if (z) {
                i5 = i4;
            } else {
                i5 = this.nodeIndex;
            }
            gapPending2 = new GapPending(i5, arrayList4);
        } else {
            gapPending2 = null;
        }
        enterGroup(z, gapPending2);
    }

    public final void startDefaults() {
        m289startAzEfcrM(-127, 0, null, null);
    }

    public final void startGroup(int i, OpaqueKey opaqueKey) {
        m289startAzEfcrM(i, 0, opaqueKey, null);
    }

    public final void startMovableGroup(int i, Object obj) {
        m289startAzEfcrM(i, 0, obj, null);
    }

    public final void startReaderGroup(Object obj, boolean z) {
        if (z) {
            SlotReader slotReader = this.reader;
            if (slotReader.emptyCount <= 0) {
                if ((slotReader.groups[(slotReader.currentGroup * 5) + 1] & 1073741824) == 0) {
                    PreconditionsKt.throwIllegalArgumentException("Expected a node group");
                }
                slotReader.startGroup();
                return;
            }
            return;
        }
        if (obj != null && this.reader.getGroupAux() != obj) {
            ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
            composerChangeListWriter.getClass();
            composerChangeListWriter.realizeOperationLocation(false);
            Operations operations = composerChangeListWriter.changeList.operations;
            operations.pushOp(Operation.UpdateAuxData.INSTANCE);
            zzsi.m814setObjectsGr0YRc(operations, 0, obj);
        }
        this.reader.startGroup();
    }

    public final void startReplaceGroup(int i) {
        int i2;
        int i3;
        if (this.pending != null) {
            m289startAzEfcrM(i, 0, null, null);
            return;
        }
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.compositeKeyHashCode, 3) ^ ((long) i), 3) ^ ((long) this.rGroupIndex);
        this.rGroupIndex++;
        SlotReader slotReader = this.reader;
        boolean z = this.inserting;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (z) {
            slotReader.emptyCount++;
            this.writer.startGroup(i, neverEqualPolicy, neverEqualPolicy, false);
            enterGroup(false, null);
            return;
        }
        if (slotReader.getGroupKey() == i && ((i3 = slotReader.currentGroup) >= slotReader.currentEnd || (slotReader.groups[(i3 * 5) + 1] & 536870912) == 0)) {
            slotReader.startGroup();
            enterGroup(false, null);
            return;
        }
        if (slotReader.emptyCount <= 0 && (i2 = slotReader.currentGroup) != slotReader.currentEnd) {
            int i4 = this.nodeIndex;
            recordDelete();
            this.changeListWriter.removeNode(i4, slotReader.skipGroup());
            Stack.access$removeRange(this.invalidations, i2, slotReader.currentGroup);
        }
        slotReader.emptyCount++;
        this.inserting = true;
        this.providerCache = null;
        if (this.writer.closed) {
            SlotWriter slotWriterOpenWriter = this.insertTable.openWriter();
            this.writer = slotWriterOpenWriter;
            slotWriterOpenWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
        SlotWriter slotWriter = this.writer;
        slotWriter.beginInsert();
        int i5 = slotWriter.currentGroup;
        slotWriter.startGroup(i, neverEqualPolicy, neverEqualPolicy, false);
        this.insertAnchor = slotWriter.anchor(i5);
        enterGroup(false, null);
    }

    public final void startReplaceableGroup(int i) {
        m289startAzEfcrM(i, 0, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    public final GapComposer startRestartGroup(int i) {
        RecomposeScopeImpl recomposeScopeImpl;
        boolean z;
        startReplaceGroup(i);
        boolean z2 = this.inserting;
        Parameters.Builder builder = this.observerHolder;
        ArrayList arrayList = this.invalidateStack;
        CompositionImpl compositionImpl = this.composition;
        if (z2) {
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl(compositionImpl);
            arrayList.add(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.currentToken = this.compositionToken;
            recomposeScopeImpl2.flags &= -17;
            builder.current();
            return this;
        }
        int i2 = this.reader.parent;
        ArrayList arrayList2 = this.invalidations;
        int iFindLocation = Stack.findLocation(i2, arrayList2);
        Invalidation invalidation = iFindLocation >= 0 ? (Invalidation) arrayList2.remove(iFindLocation) : null;
        Object next = this.reader.next();
        if (Intrinsics.areEqual(next, Composer$Companion.Empty)) {
            recomposeScopeImpl = new RecomposeScopeImpl(compositionImpl);
            updateValue(recomposeScopeImpl);
        } else {
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        if (invalidation == null) {
            int i3 = recomposeScopeImpl.flags;
            boolean z3 = (i3 & 64) != 0;
            if (z3) {
                recomposeScopeImpl.flags = i3 & (-65);
            }
            if (z3) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        int i4 = recomposeScopeImpl.flags;
        recomposeScopeImpl.flags = z ? i4 | 8 : i4 & (-9);
        arrayList.add(recomposeScopeImpl);
        recomposeScopeImpl.currentToken = this.compositionToken;
        recomposeScopeImpl.flags &= -17;
        builder.current();
        int i5 = recomposeScopeImpl.flags;
        if ((i5 & 256) != 0) {
            recomposeScopeImpl.flags = (i5 & (-257)) | 512;
            Operations operations = this.changeListWriter.changeList.operations;
            operations.pushOp(Operation.StartResumingScope.INSTANCE);
            zzsi.m814setObjectsGr0YRc(operations, 0, recomposeScopeImpl);
            if (!this.reusing) {
                int i6 = recomposeScopeImpl.flags;
                if ((i6 & 128) != 0) {
                    this.reusing = true;
                    this.reusingGroup = this.reader.parent;
                    recomposeScopeImpl.flags = i6 | 1024;
                }
            }
        }
        return this;
    }

    public final void startReusableGroup(Object obj) {
        if (!this.inserting && this.reader.getGroupKey() == 207 && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.currentGroup;
            this.reusing = true;
        }
        m289startAzEfcrM(207, 0, null, obj);
    }

    public final void startReusableNode() {
        m289startAzEfcrM(125, 2, null, null);
        this.nodeExpected = true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        m289startAzEfcrM(100, 0, null, null);
        CompositionContext compositionContext = this.parentContext;
        compositionContext.startComposing$runtime();
        PersistentCompositionLocalMap compositionLocalScope$runtime = compositionContext.getCompositionLocalScope$runtime();
        this.providersInvalidStack.push(this.providersInvalid ? 1 : 0);
        this.providersInvalid = changed(compositionLocalScope$runtime);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = compositionContext.getCollectingParameterInformation$runtime();
        }
        if (!this.sourceMarkersEnabled) {
            this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation$runtime();
        }
        if (this.sourceMarkersEnabled) {
            compositionLocalScope$runtime = ((PersistentCompositionLocalHashMap) compositionLocalScope$runtime).putValue(CompositionErrorContextKt.LocalCompositionErrorContext, new StaticValueHolder(getErrorContext$runtime()));
        }
        this.rootProvider = compositionLocalScope$runtime;
        Set set = (Set) Stack.read(compositionLocalScope$runtime, InspectionTablesKt.LocalInspectionTables);
        if (set != null) {
            set.add(getCompositionData());
            compositionContext.recordInspectionTable$runtime(set);
        }
        long compositeKeyHashCode$runtime = compositionContext.getCompositeKeyHashCode$runtime();
        m289startAzEfcrM((int) (compositeKeyHashCode$runtime ^ (compositeKeyHashCode$runtime >>> 32)), 0, null, null);
    }

    public final boolean tryImminentInvalidation$runtime(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        GapAnchor gapAnchor = recomposeScopeImpl.anchor;
        if (gapAnchor == null) {
            return false;
        }
        int iAnchorIndex = this.reader.table.anchorIndex(GapAnchorKt.asGapAnchor(gapAnchor));
        if (!this.isComposing || iAnchorIndex < this.reader.currentGroup) {
            return false;
        }
        ArrayList arrayList = this.invalidations;
        int iFindLocation = Stack.findLocation(iAnchorIndex, arrayList);
        if (iFindLocation < 0) {
            int i = -(iFindLocation + 1);
            if (!(obj instanceof DerivedSnapshotState)) {
                obj = null;
            }
            arrayList.add(i, new Invalidation(recomposeScopeImpl, iAnchorIndex, obj));
            return true;
        }
        Invalidation invalidation = (Invalidation) arrayList.get(iFindLocation);
        if (!(obj instanceof DerivedSnapshotState)) {
            invalidation.instances = null;
            return true;
        }
        Object obj2 = invalidation.instances;
        if (obj2 == null) {
            invalidation.instances = obj;
            return true;
        }
        if (obj2 instanceof MutableScatterSet) {
            ((MutableScatterSet) obj2).add(obj);
            return true;
        }
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        MutableScatterSet mutableScatterSet2 = new MutableScatterSet(2);
        mutableScatterSet2.plusAssign(obj2);
        mutableScatterSet2.plusAssign(obj);
        invalidation.instances = mutableScatterSet2;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008f A[LOOP:1: B:20:0x0042->B:35:0x008f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0092 A[EDGE_INSN: B:43:0x0092->B:36:0x0092 BREAK  A[LOOP:1: B:20:0x0042->B:35:0x008f], SYNTHETIC] */
    /* JADX INFO: renamed from: updateComposerInvalidations-RY85e9Y$runtime, reason: not valid java name */
    public final void m290updateComposerInvalidationsRY85e9Y$runtime(MutableScatterMap mutableScatterMap) {
        ArrayList arrayList = this.invalidations;
        for (int lastIndex = AppCompatHintHelper.getLastIndex(arrayList); -1 < lastIndex; lastIndex--) {
            Invalidation invalidation = (Invalidation) arrayList.get(lastIndex);
            GapAnchor gapAnchor = invalidation.scope.anchor;
            GapAnchor gapAnchorAsGapAnchor = gapAnchor != null ? GapAnchorKt.asGapAnchor(gapAnchor) : null;
            if (gapAnchorAsGapAnchor == null || !gapAnchorAsGapAnchor.getValid()) {
                arrayList.remove(lastIndex);
            } else {
                int i = invalidation.location;
                int i2 = gapAnchorAsGapAnchor.location;
                if (i != i2) {
                    invalidation.location = i2;
                }
            }
        }
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
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
                        if ((255 & j) < 128) {
                            int i6 = (i3 << 3) + i5;
                            Object obj = objArr[i6];
                            Object obj2 = objArr2[i6];
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                            GapAnchor gapAnchor2 = recomposeScopeImpl.anchor;
                            if (gapAnchor2 != null) {
                                int i7 = GapAnchorKt.asGapAnchor(gapAnchor2).location;
                                if (obj2 == NeverEqualPolicy.INSTANCE$2) {
                                    obj2 = null;
                                }
                                arrayList.add(new Invalidation(recomposeScopeImpl, i7, obj2));
                            }
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
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, Stack.InvalidationLocationAscending);
    }

    public final void updateNodeCount(int i, int i2) {
        if (updatedNodeCount(i) != i2) {
            if (i < 0) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap();
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(i, i2);
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                iArr = new int[this.reader.groupsSize];
                Arrays.fill(iArr, 0, iArr.length, -1);
                this.nodeCountOverrides = iArr;
            }
            iArr[i] = i2;
        }
    }

    public final void updateNodeCountOverrides(int i, int i2) {
        int iUpdatedNodeCount = updatedNodeCount(i);
        if (iUpdatedNodeCount != i2) {
            int i3 = i2 - iUpdatedNodeCount;
            ArrayList arrayList = this.pendingStack;
            int size = arrayList.size() - 1;
            while (i != -1) {
                int iUpdatedNodeCount2 = updatedNodeCount(i) + i3;
                updateNodeCount(i, iUpdatedNodeCount2);
                for (int i4 = size; -1 < i4; i4--) {
                    GapPending gapPending = (GapPending) arrayList.get(i4);
                    if (gapPending != null && gapPending.updateNodeCount(i, iUpdatedNodeCount2)) {
                        size = i4 - 1;
                        break;
                    }
                }
                if (i < 0) {
                    i = this.reader.parent;
                } else if (this.reader.isNode(i)) {
                    return;
                } else {
                    i = this.reader.parent(i);
                }
            }
        }
    }

    public final PersistentCompositionLocalHashMap updateProviderMapGroup(PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalHashMap persistentCompositionLocalHashMap) {
        PersistentCompositionLocalHashMap.Builder builder = ((PersistentCompositionLocalHashMap) persistentCompositionLocalMap).builder();
        builder.putAll(persistentCompositionLocalHashMap);
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapBuild = builder.build();
        startGroup(204, ComposerKt.providerMaps);
        nextSlot();
        updateValue(persistentCompositionLocalHashMapBuild);
        nextSlot();
        updateValue(persistentCompositionLocalHashMap);
        end(false);
        return persistentCompositionLocalHashMapBuild;
    }

    public final void updateRememberedValue(Object obj) {
        if (obj instanceof RememberObserver) {
            GapRememberObserverHolder gapRememberObserverHolder = new GapRememberObserverHolder((RememberObserver) obj, this.rGroupIndex - 1);
            if (this.inserting) {
                Operations operations = this.changeListWriter.changeList.operations;
                operations.pushOp(Operation.Remember.INSTANCE);
                zzsi.m814setObjectsGr0YRc(operations, 0, gapRememberObserverHolder);
            }
            this.abandonSet.add(obj);
            obj = gapRememberObserverHolder;
        }
        updateValue(obj);
    }

    public final void updateValue(Object obj) {
        if (this.inserting) {
            SlotWriter slotWriter = this.writer;
            if (slotWriter.insertCount <= 0 || slotWriter.currentSlot == slotWriter.slotsGapStart) {
                slotWriter.rawUpdate(obj);
                return;
            }
            MutableIntObjectMap mutableIntObjectMap = slotWriter.deferredSlotWrites;
            if (mutableIntObjectMap == null) {
                mutableIntObjectMap = new MutableIntObjectMap();
            }
            slotWriter.deferredSlotWrites = mutableIntObjectMap;
            int i = slotWriter.parent;
            Object mutableObjectList = mutableIntObjectMap.get(i);
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList();
                mutableIntObjectMap.set(i, mutableObjectList);
            }
            ((MutableObjectList) mutableObjectList).add(obj);
            return;
        }
        SlotReader slotReader = this.reader;
        boolean z = slotReader.hadNext;
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        if (!z) {
            GapAnchor gapAnchorAnchor = slotReader.anchor(slotReader.parent);
            Operations operations = composerChangeListWriter.changeList.operations;
            operations.pushOp(Operation.AppendValue.INSTANCE);
            zzsi.m815setObjectsEsEZvaA(operations, 0, gapAnchorAnchor, 1, obj);
            return;
        }
        int iAccess$slotAnchor = (slotReader.currentSlot - SlotTableKt.access$slotAnchor(slotReader.groups, slotReader.parent)) - 1;
        if (composerChangeListWriter.composer.reader.parent - composerChangeListWriter.writersReaderDelta >= 0) {
            composerChangeListWriter.realizeOperationLocation(true);
            Operations operations2 = composerChangeListWriter.changeList.operations;
            operations2.pushOp(Operation.UpdateValue.INSTANCE);
            zzsi.m814setObjectsGr0YRc(operations2, 0, obj);
            operations2.intArgs[operations2.intArgsSize - operations2.opCodes[operations2.opCodesSize - 1].ints] = iAccess$slotAnchor;
            return;
        }
        SlotReader slotReader2 = this.reader;
        GapAnchor gapAnchorAnchor2 = slotReader2.anchor(slotReader2.parent);
        Operations operations3 = composerChangeListWriter.changeList.operations;
        operations3.pushOp(Operation.UpdateValue.INSTANCE$3);
        zzsi.m815setObjectsEsEZvaA(operations3, 0, obj, 1, gapAnchorAnchor2);
        operations3.intArgs[operations3.intArgsSize - operations3.opCodes[operations3.opCodesSize - 1].ints] = iAccess$slotAnchor;
    }

    public final int updatedNodeCount(int i) {
        int i2;
        if (i >= 0) {
            int[] iArr = this.nodeCountOverrides;
            return (iArr == null || (i2 = iArr[i]) < 0) ? this.reader.nodeCount(i) : i2;
        }
        MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
        if (mutableIntIntMap == null || mutableIntIntMap.findKeyIndex(i) < 0) {
            return 0;
        }
        int iFindKeyIndex = mutableIntIntMap.findKeyIndex(i);
        if (iFindKeyIndex >= 0) {
            return mutableIntIntMap.values[iFindKeyIndex];
        }
        RuntimeHelpersKt.throwNoSuchElementException("Cannot find value for key " + i);
        throw null;
    }

    public final void useNode() {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
        if (this.inserting) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        SlotReader slotReader = this.reader;
        Object objNode = slotReader.node(slotReader.parent);
        ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
        composerChangeListWriter.realizeNodeMovementOperations();
        composerChangeListWriter.pendingDownNodes.add(objNode);
        if (this.reusing && (objNode instanceof ComposeNodeLifecycleCallback)) {
            composerChangeListWriter.pushPendingUpsAndDowns();
            composerChangeListWriter.changeList.operations.pushOp(Operation.UseCurrentNode.INSTANCE);
        }
    }

    public final boolean changed(boolean z) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Boolean) && z == ((Boolean) objNextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    public final boolean changed(float f) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Float) && f == ((Number) objNextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    public final boolean changed(long j) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Long) && j == ((Number) objNextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    public final boolean changed(int i) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Integer) && i == ((Number) objNextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CompositionContextHolder implements RememberObserver {
        public final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public final void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public final void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public final void onRemembered() {
        }
    }
}
