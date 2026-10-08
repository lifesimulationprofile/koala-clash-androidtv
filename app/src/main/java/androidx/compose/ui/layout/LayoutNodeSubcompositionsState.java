package androidx.compose.ui.layout;

import android.os.Handler;
import android.view.ViewGroup;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.collection.Values;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PausedCompositionImpl;
import androidx.compose.runtime.PausedCompositionState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.compose.NavHostKt;
import coil.network.HttpException;
import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {
    public final String NoIntrinsicsMessage;
    public final ApproachMeasureScopeImpl approachMeasureScope;
    public final MutableScatterMap approachPrecomposeSlotHandleMap;
    public CompositionContext compositionContext;
    public int currentApproachIndex;
    public int currentIndex;
    public final MutableScatterMap nodeToNodeState;
    public final MutableScatterMap precomposeMap;
    public int precomposedCount;
    public int reusableCount;
    public final Values reusableSlotIdsSet;
    public final LayoutNode root;
    public final Scope scope;
    public final MutableScatterMap slotIdToNode;
    public final MutableVector slotIdsOfCompositionsNeededInApproach;
    public SubcomposeSlotReusePolicy slotReusePolicy;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ApproachMeasureScopeImpl implements SubcomposeMeasureScope, MeasureScope {
        public final /* synthetic */ Scope $$delegate_0;

        public ApproachMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return this.$$delegate_0.density;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return this.$$delegate_0.fontScale;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public final LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.layoutDirection;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public final boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public final MeasureResult layout(int i, int i2, Map map, Function1 function1, Function1 function2) {
            return this.$$delegate_0.layout(i, i2, map, function1, function2);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public final int mo86roundToPx0680j_4(float f) {
            Scope scope = this.$$delegate_0;
            scope.getClass();
            return Density.CC.m695$default$roundToPx0680j_4(scope, f);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public final List subcompose(Object obj, Function2 function2) {
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
            MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState.slotIdToNode;
            LayoutNode layoutNode2 = (LayoutNode) mutableScatterMap.get(obj);
            if (layoutNode2 != null && ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).indexOf(layoutNode2) < layoutNodeSubcompositionsState.currentIndex) {
                return layoutNode2.getChildMeasurables$ui();
            }
            MutableScatterMap mutableScatterMap2 = layoutNodeSubcompositionsState.approachPrecomposeSlotHandleMap;
            MutableScatterMap mutableScatterMap3 = layoutNodeSubcompositionsState.precomposeMap;
            MutableVector mutableVector = layoutNodeSubcompositionsState.slotIdsOfCompositionsNeededInApproach;
            if (mutableVector.size < layoutNodeSubcompositionsState.currentApproachIndex) {
                InlineClassHelperKt.throwIllegalArgumentException("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
            }
            LayoutNode layoutNode3 = (LayoutNode) mutableScatterMap.get(obj);
            int i = mutableVector.size;
            int i2 = layoutNodeSubcompositionsState.currentApproachIndex;
            if (i == i2) {
                mutableVector.add(obj);
            } else {
                Object[] objArr = mutableVector.content;
                Object obj2 = objArr[i2];
                objArr[i2] = obj;
            }
            layoutNodeSubcompositionsState.currentApproachIndex++;
            boolean zContains = mutableScatterMap3.contains(obj);
            if (zContains || layoutNode3 != null) {
                if (!zContains && layoutNode3 != null) {
                    layoutNodeSubcompositionsState.move(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).indexOf(layoutNode3), ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).size);
                    layoutNodeSubcompositionsState.precomposedCount++;
                    mutableScatterMap.remove(obj);
                    mutableScatterMap3.set(obj, layoutNode3);
                    mutableScatterMap2.set(obj, layoutNodeSubcompositionsState.createPrecomposedSlotHandle(obj));
                    if (layoutNode.isAttached()) {
                        layoutNodeSubcompositionsState.makeSureStateIsConsistent();
                    }
                }
                LayoutNode layoutNode4 = (LayoutNode) mutableScatterMap3.get(obj);
                NodeState nodeState = layoutNode4 != null ? (NodeState) layoutNodeSubcompositionsState.nodeToNodeState.get(layoutNode4) : null;
                if (nodeState != null && nodeState.forceRecompose) {
                    layoutNodeSubcompositionsState.subcompose(layoutNode4, obj, false, function2);
                }
                if ((nodeState != null ? nodeState.pausedComposition : null) != null) {
                    layoutNodeSubcompositionsState.applyPausedPrecomposition(nodeState, true);
                }
            } else {
                layoutNodeSubcompositionsState.precompose(obj, function2, false);
                mutableScatterMap2.set(obj, layoutNodeSubcompositionsState.createPrecomposedSlotHandle(obj));
            }
            LayoutNode layoutNode5 = (LayoutNode) mutableScatterMap3.get(obj);
            if (layoutNode5 == null) {
                return EmptyList.INSTANCE;
            }
            List childDelegates$ui = layoutNode5.layoutDelegate.measurePassDelegate.getChildDelegates$ui();
            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) childDelegates$ui;
            int i3 = ((MutableVector) objectListMutableList.objectList).size;
            for (int i4 = 0; i4 < i3; i4++) {
                ((MeasurePassDelegate) objectListMutableList.get(i4)).layoutNodeLayoutDelegate.detachedFromParentLookaheadPass = true;
            }
            return childDelegates$ui;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public final float mo87toDpGaN1DYA(long j) {
            Scope scope = this.$$delegate_0;
            scope.getClass();
            return Density.CC.m696$default$toDpGaN1DYA(j, scope);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo89toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo89toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public final long mo90toDpSizekrfVVM(long j) {
            Scope scope = this.$$delegate_0;
            scope.getClass();
            return Density.CC.m697$default$toDpSizekrfVVM(j, scope);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public final float mo91toPxR2X_6o(long j) {
            Scope scope = this.$$delegate_0;
            scope.getClass();
            return Density.CC.m698$default$toPxR2X_6o(j, scope);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public final float mo92toPx0680j_4(float f) {
            return this.$$delegate_0.getDensity() * f;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public final long mo93toSizeXkaWNTQ(long j) {
            Scope scope = this.$$delegate_0;
            scope.getClass();
            return Density.CC.m699$default$toSizeXkaWNTQ(j, scope);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final long mo94toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo94toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public final MeasureResult layout(int i, int i2, Map map, Function1 function1) {
            return this.$$delegate_0.layout(i, i2, map, null, function1);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo88toDpu2uoSUM(float f) {
            return f / this.$$delegate_0.getDensity();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class NodeState {
        public ParcelableSnapshotMutableState activeState;
        public boolean composedWithReusableContentHost;
        public CompositionImpl composition;
        public Function2 content;
        public boolean forceRecompose;
        public boolean forceReuse;
        public PausedCompositionImpl pausedComposition;
        public Object slotId;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Scope implements SubcomposeMeasureScope {
        public float density;
        public float fontScale;
        public LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return this.fontScale;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public final boolean isLookingAhead() {
            int i = LayoutNodeSubcompositionsState.this.root.layoutDelegate.layoutState;
            return i == 4 || i == 2;
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public final MeasureResult layout(int i, int i2, Map map, Function1 function1) {
            return layout(i, i2, map, null, function1);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public final /* synthetic */ int mo86roundToPx0680j_4(float f) {
            return Density.CC.m695$default$roundToPx0680j_4(this, f);
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public final List subcompose(Object obj, Function2 function2) {
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            layoutNodeSubcompositionsState.makeSureStateIsConsistent();
            LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
            int i = layoutNode.layoutDelegate.layoutState;
            if (i != 1 && i != 3 && i != 2 && i != 4) {
                InlineClassHelperKt.throwIllegalStateException("subcompose can only be used inside the measure or layout blocks");
            }
            MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState.slotIdToNode;
            Object objTakeNodeFromReusables = mutableScatterMap.get(obj);
            if (objTakeNodeFromReusables == null) {
                objTakeNodeFromReusables = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.remove(obj);
                if (objTakeNodeFromReusables != null) {
                    if (layoutNodeSubcompositionsState.precomposedCount <= 0) {
                        InlineClassHelperKt.throwIllegalStateException("Check failed.");
                    }
                    layoutNodeSubcompositionsState.precomposedCount--;
                } else {
                    objTakeNodeFromReusables = layoutNodeSubcompositionsState.takeNodeFromReusables(obj);
                    if (objTakeNodeFromReusables == null) {
                        int i2 = layoutNodeSubcompositionsState.currentIndex;
                        LayoutNode layoutNode2 = new LayoutNode(2);
                        layoutNode.ignoreRemeasureRequests = true;
                        layoutNode.insertAt$ui(i2, layoutNode2);
                        Unit unit = Unit.INSTANCE;
                        layoutNode.ignoreRemeasureRequests = false;
                        objTakeNodeFromReusables = layoutNode2;
                    }
                }
                mutableScatterMap.set(obj, objTakeNodeFromReusables);
            }
            LayoutNode layoutNode3 = (LayoutNode) objTakeNodeFromReusables;
            if (CollectionsKt.getOrNull(layoutNodeSubcompositionsState.currentIndex, layoutNode.getFoldedChildren$ui()) != layoutNode3) {
                int iIndexOf = ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).indexOf(layoutNode3);
                if (iIndexOf < layoutNodeSubcompositionsState.currentIndex) {
                    InlineClassHelperKt.throwIllegalArgumentException("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
                }
                int i3 = layoutNodeSubcompositionsState.currentIndex;
                if (i3 != iIndexOf) {
                    layoutNodeSubcompositionsState.move(iIndexOf, i3);
                }
            }
            layoutNodeSubcompositionsState.currentIndex++;
            layoutNodeSubcompositionsState.subcompose(layoutNode3, obj, false, function2);
            return (i == 1 || i == 3) ? layoutNode3.getChildMeasurables$ui() : layoutNode3.getChildLookaheadMeasurables$ui();
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public final /* synthetic */ float mo87toDpGaN1DYA(long j) {
            return Density.CC.m696$default$toDpGaN1DYA(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo89toDpu2uoSUM(int i) {
            return i / getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public final /* synthetic */ long mo90toDpSizekrfVVM(long j) {
            return Density.CC.m697$default$toDpSizekrfVVM(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public final /* synthetic */ float mo91toPxR2X_6o(long j) {
            return Density.CC.m698$default$toPxR2X_6o(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public final float mo92toPx0680j_4(float f) {
            return getDensity() * f;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public final /* synthetic */ long mo93toSizeXkaWNTQ(long j) {
            return Density.CC.m699$default$toSizeXkaWNTQ(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final long mo94toSpkPz2Gy4(float f) {
            return Density.CC.m700$default$toSp0xMU5do(this, mo88toDpu2uoSUM(f));
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public final MeasureResult layout(final int i, final int i2, final Map map, final Function1 function1, final Function1 function2) {
            if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
                InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope$layout$1
                @Override // androidx.compose.ui.layout.MeasureResult
                public final Map getAlignmentLines() {
                    return map;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public final int getHeight() {
                    return i2;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public final Function1 getRulers() {
                    return function1;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public final int getWidth() {
                    return i;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public final void placeChildren() {
                    InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl;
                    LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
                    boolean zIsLookingAhead = this.isLookingAhead();
                    Function1 function3 = function2;
                    if (!zIsLookingAhead || (lookaheadDelegateImpl = ((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).lookaheadDelegate) == null) {
                        function3.invoke(((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).placementScope);
                    } else {
                        function3.invoke(lookaheadDelegateImpl.placementScope);
                    }
                }
            };
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo88toDpu2uoSUM(float f) {
            return f / getDensity();
        }
    }

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.root = layoutNode;
        this.slotReusePolicy = subcomposeSlotReusePolicy;
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.nodeToNodeState = new MutableScatterMap();
        this.slotIdToNode = new MutableScatterMap();
        this.scope = new Scope();
        this.approachMeasureScope = new ApproachMeasureScopeImpl();
        this.precomposeMap = new MutableScatterMap();
        this.reusableSlotIdsSet = new Values();
        this.approachPrecomposeSlotHandleMap = new MutableScatterMap();
        this.slotIdsOfCompositionsNeededInApproach = new MutableVector(new Object[16]);
        this.NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    public static final void access$disposePrecomposedSlot(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Object obj) {
        LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
        layoutNodeSubcompositionsState.makeSureStateIsConsistent();
        LayoutNode layoutNode2 = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.remove(obj);
        if (layoutNode2 != null) {
            if (layoutNodeSubcompositionsState.precomposedCount <= 0) {
                InlineClassHelperKt.throwIllegalStateException("No pre-composed items to dispose");
            }
            int iIndexOf = ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).indexOf(layoutNode2);
            if (iIndexOf < ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).size - layoutNodeSubcompositionsState.precomposedCount) {
                InlineClassHelperKt.throwIllegalStateException("Item is not in pre-composed item range");
            }
            layoutNodeSubcompositionsState.reusableCount++;
            layoutNodeSubcompositionsState.precomposedCount--;
            NodeState nodeState = (NodeState) layoutNodeSubcompositionsState.nodeToNodeState.get(layoutNode2);
            if (nodeState != null) {
                cancelPausedPrecomposition(nodeState);
            }
            int i = (((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).size - layoutNodeSubcompositionsState.precomposedCount) - layoutNodeSubcompositionsState.reusableCount;
            layoutNodeSubcompositionsState.move(iIndexOf, i);
            layoutNodeSubcompositionsState.disposeOrReuseStartingFromIndex(i);
        }
        if (layoutNodeSubcompositionsState.slotIdsOfCompositionsNeededInApproach.contains(obj)) {
            LayoutNode.requestRemeasure$ui$default(layoutNode, true, 6);
        }
    }

    public static void cancelPausedPrecomposition(NodeState nodeState) {
        MutableScatterSet mutableScatterSet;
        PausedCompositionImpl pausedCompositionImpl = nodeState.pausedComposition;
        if (pausedCompositionImpl != null) {
            pausedCompositionImpl.state.set(PausedCompositionState.Cancelled);
            zzky zzkyVar = pausedCompositionImpl.rememberManager;
            if (((MutableScatterSet) zzkyVar.zzd).isNotEmpty()) {
                mutableScatterSet = (MutableScatterSet) zzkyVar.zzd;
                MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                zzkyVar.zzd = new MutableScatterSet();
                ((MutableVector) zzkyVar.zzc).clear();
            } else {
                mutableScatterSet = null;
            }
            zzkyVar.dispatchAbandons();
            CompositionImpl compositionImpl = pausedCompositionImpl.composition;
            compositionImpl.pendingPausedComposition = null;
            if (mutableScatterSet != null) {
                compositionImpl.rememberManager.zzk = mutableScatterSet;
                compositionImpl.state = 2;
            }
            nodeState.pausedComposition = null;
            CompositionImpl compositionImpl2 = nodeState.composition;
            if (compositionImpl2 != null) {
                compositionImpl2.dispose();
            }
            nodeState.composition = null;
        }
    }

    public final void applyPausedPrecomposition(NodeState nodeState, boolean z) {
        PausedCompositionImpl pausedCompositionImpl = nodeState.pausedComposition;
        if (pausedCompositionImpl != null) {
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                LayoutNode layoutNode = this.root;
                layoutNode.ignoreRemeasureRequests = true;
                if (z) {
                    while (!pausedCompositionImpl.isComplete()) {
                        try {
                            pausedCompositionImpl.resume(new ZslControlImpl$$ExternalSyntheticLambda0(16));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                pausedCompositionImpl.apply();
                nodeState.pausedComposition = null;
                Unit unit = Unit.INSTANCE;
                layoutNode.ignoreRemeasureRequests = false;
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            } catch (Throwable th2) {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th2;
            }
        }
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle createPrecomposedSlotHandle(final Object obj) {
        return !this.root.isAttached() ? new AnonymousClass1() : new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createPrecomposedSlotHandle.2
            public final MutableIntSet hasPremeasured;

            {
                int[] iArr = IntSetKt.EmptyIntArray;
                this.hasPremeasured = new MutableIntSet();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public final void dispose() {
                LayoutNodeSubcompositionsState.access$disposePrecomposedSlot(LayoutNodeSubcompositionsState.this, obj);
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public final int getPlaceablesCount() {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(obj);
                if (layoutNode != null) {
                    return ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size;
                }
                return 0;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* JADX INFO: renamed from: premeasure-0kLqBqw */
            public final void mo532premeasure0kLqBqw(int i, long j) {
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                LayoutNode layoutNode = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.get(obj);
                if (layoutNode == null || !layoutNode.isAttached()) {
                    return;
                }
                int i2 = ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size;
                if (i < 0 || i >= i2) {
                    InlineClassHelperKt.throwIndexOutOfBoundsException("Index (" + i + ") is out of bound of [0, " + i2 + ')');
                }
                if (layoutNode.isPlaced()) {
                    InlineClassHelperKt.throwIllegalArgumentException("Pre-measure called on node that is not placed");
                }
                LayoutNode layoutNode2 = layoutNodeSubcompositionsState.root;
                layoutNode2.ignoreRemeasureRequests = true;
                ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).m591measureAndLayout0kLqBqw((LayoutNode) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).get(i), j);
                Unit unit = Unit.INSTANCE;
                layoutNode2.ignoreRemeasureRequests = false;
                this.hasPremeasured.add(i);
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public final void traverseDescendants(LogcatReader$$ExternalSyntheticLambda3 logcatReader$$ExternalSyntheticLambda3) {
                NodeChain nodeChain;
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(obj);
                Modifier.Node node = (layoutNode == null || (nodeChain = layoutNode.nodes) == null) ? null : (Modifier.Node) nodeChain.head;
                if (node == null || !node.isAttached) {
                    return;
                }
                HitTestResultKt.traverseDescendants(node, "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", logcatReader$$ExternalSyntheticLambda3);
            }
        };
    }

    public final void disposeOrReuseStartingFromIndex(int i) {
        boolean z;
        boolean z2 = false;
        this.reusableCount = 0;
        List foldedChildren$ui = this.root.getFoldedChildren$ui();
        MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) foldedChildren$ui;
        int i2 = (((MutableVector) objectListMutableList.objectList).size - this.precomposedCount) - 1;
        if (i <= i2) {
            this.reusableSlotIdsSet.clear();
            if (i <= i2) {
                int i3 = i;
                while (true) {
                    ((MutableOrderedScatterSet) this.reusableSlotIdsSet.parent).add(((NodeState) this.nodeToNodeState.get((LayoutNode) objectListMutableList.get(i3))).slotId);
                    if (i3 == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            z = false;
            while (i2 >= i) {
                try {
                    LayoutNode layoutNode = (LayoutNode) ((MutableObjectList.ObjectListMutableList) foldedChildren$ui).get(i2);
                    NodeState nodeState = (NodeState) this.nodeToNodeState.get(layoutNode);
                    Object obj = nodeState.slotId;
                    if (((MutableOrderedScatterSet) this.reusableSlotIdsSet.parent).contains(obj)) {
                        this.reusableCount++;
                        if (((Boolean) nodeState.activeState.getValue()).booleanValue()) {
                            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
                            layoutNodeLayoutDelegate.measurePassDelegate.measuredByParent = 3;
                            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                            if (lookaheadPassDelegate != null) {
                                lookaheadPassDelegate.measuredByParent = 3;
                            }
                            reuseComposition(nodeState, false);
                            if (nodeState.composedWithReusableContentHost) {
                                z = true;
                            }
                        }
                    } else {
                        LayoutNode layoutNode2 = this.root;
                        layoutNode2.ignoreRemeasureRequests = true;
                        this.nodeToNodeState.remove(layoutNode);
                        CompositionImpl compositionImpl = nodeState.composition;
                        if (compositionImpl != null) {
                            compositionImpl.dispose();
                        }
                        this.root.removeAt$ui(i2, 1);
                        Unit unit = Unit.INSTANCE;
                        layoutNode2.ignoreRemeasureRequests = false;
                    }
                    this.slotIdToNode.remove(obj);
                    i2--;
                } catch (Throwable th) {
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        } else {
            z = false;
        }
        if (z) {
            synchronized (SnapshotKt.lock) {
                MutableScatterSet mutableScatterSet = SnapshotKt.globalSnapshot.modified;
                if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
                    z2 = true;
                }
            }
            if (z2) {
                SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
            }
        }
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        int i = ((MutableVector) ((MutableObjectList.ObjectListMutableList) this.root.getFoldedChildren$ui()).objectList).size;
        MutableScatterMap mutableScatterMap = this.nodeToNodeState;
        if (mutableScatterMap._size != i) {
            InlineClassHelperKt.throwIllegalArgumentException("Inconsistency between the count of nodes tracked by the state (" + mutableScatterMap._size + ") and the children count on the SubcomposeLayout (" + i + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if ((i - this.reusableCount) - this.precomposedCount < 0) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Incorrect state. Total children ", ". Reusable children ");
            sbM.append(this.reusableCount);
            sbM.append(". Precomposed children ");
            sbM.append(this.precomposedCount);
            InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
        }
        MutableScatterMap mutableScatterMap2 = this.precomposeMap;
        if (mutableScatterMap2._size == this.precomposedCount) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + mutableScatterMap2._size);
    }

    public final void markActiveNodesAsReused(boolean z) {
        this.precomposedCount = 0;
        this.precomposeMap.clear();
        List foldedChildren$ui = this.root.getFoldedChildren$ui();
        int i = ((MutableVector) ((MutableObjectList.ObjectListMutableList) foldedChildren$ui).objectList).size;
        if (this.reusableCount != i) {
            this.reusableCount = i;
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    LayoutNode layoutNode = (LayoutNode) ((MutableObjectList.ObjectListMutableList) foldedChildren$ui).get(i2);
                    NodeState nodeState = (NodeState) this.nodeToNodeState.get(layoutNode);
                    if (nodeState != null && ((Boolean) nodeState.activeState.getValue()).booleanValue()) {
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
                        layoutNodeLayoutDelegate.measurePassDelegate.measuredByParent = 3;
                        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                        if (lookaheadPassDelegate != null) {
                            lookaheadPassDelegate.measuredByParent = 3;
                        }
                        reuseComposition(nodeState, z);
                        nodeState.slotId = RulerKt.ReusedSlotId;
                    }
                } catch (Throwable th) {
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.slotIdToNode.clear();
        }
        makeSureStateIsConsistent();
    }

    public final void move(int i, int i2) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        layoutNode.move$ui(i, i2, 1);
        Unit unit = Unit.INSTANCE;
        layoutNode.ignoreRemeasureRequests = false;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onDeactivate() {
        markActiveNodesAsReused(true);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x004f A[LOOP:0: B:5:0x0014->B:17:0x004f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[EDGE_INSN: B:21:0x0052->B:18:0x0052 BREAK  A[LOOP:0: B:5:0x0014->B:17:0x004f], SYNTHETIC] */
    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onRelease() {
        CompositionImpl compositionImpl;
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        MutableScatterMap mutableScatterMap = this.nodeToNodeState;
        Object[] objArr = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
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
                        if ((255 & j) < 128 && (compositionImpl = ((NodeState) objArr[(i << 3) + i3]).composition) != null) {
                            compositionImpl.dispose();
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
        layoutNode.removeAll$ui();
        Unit unit = Unit.INSTANCE;
        layoutNode.ignoreRemeasureRequests = false;
        mutableScatterMap.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    public final void precompose(Object obj, Function2 function2, boolean z) {
        LayoutNode layoutNode = this.root;
        if (layoutNode.isAttached()) {
            makeSureStateIsConsistent();
            if (this.slotIdToNode.containsKey(obj)) {
                return;
            }
            this.approachPrecomposeSlotHandleMap.remove(obj);
            MutableScatterMap mutableScatterMap = this.precomposeMap;
            Object objTakeNodeFromReusables = mutableScatterMap.get(obj);
            if (objTakeNodeFromReusables == null) {
                objTakeNodeFromReusables = takeNodeFromReusables(obj);
                if (objTakeNodeFromReusables != null) {
                    move(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).indexOf(objTakeNodeFromReusables), ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).size);
                    this.precomposedCount++;
                } else {
                    int i = ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).size;
                    LayoutNode layoutNode2 = new LayoutNode(2);
                    layoutNode.ignoreRemeasureRequests = true;
                    layoutNode.insertAt$ui(i, layoutNode2);
                    Unit unit = Unit.INSTANCE;
                    layoutNode.ignoreRemeasureRequests = false;
                    this.precomposedCount++;
                    objTakeNodeFromReusables = layoutNode2;
                }
                mutableScatterMap.set(obj, objTakeNodeFromReusables);
            }
            subcompose((LayoutNode) objTakeNodeFromReusables, obj, z, function2);
        }
    }

    public final void reuseComposition(NodeState nodeState, boolean z) {
        CompositionImpl compositionImpl;
        if (z || !nodeState.composedWithReusableContentHost) {
            nodeState.activeState = Stack.mutableStateOf$default(Boolean.FALSE);
        } else {
            nodeState.activeState.setValue(Boolean.FALSE);
        }
        if (nodeState.pausedComposition != null) {
            cancelPausedPrecomposition(nodeState);
            return;
        }
        if (z) {
            CompositionImpl compositionImpl2 = nodeState.composition;
            if (compositionImpl2 != null) {
                compositionImpl2.deactivate();
                return;
            }
            return;
        }
        OutOfFrameExecutor outOfFrameExecutor = ((AndroidComposeView) LayoutNodeKt.requireOwner(this.root)).getOutOfFrameExecutor();
        if (outOfFrameExecutor == null) {
            if (nodeState.composedWithReusableContentHost || (compositionImpl = nodeState.composition) == null) {
                return;
            }
            compositionImpl.deactivate();
            return;
        }
        Handshake.AnonymousClass2 anonymousClass2 = new Handshake.AnonymousClass2(6, nodeState);
        AndroidComposeView androidComposeView = (AndroidComposeView) outOfFrameExecutor;
        ArrayDeque arrayDeque = androidComposeView.outOfFrameQueue;
        boolean zIsEmpty = arrayDeque.isEmpty();
        arrayDeque.addLast(anonymousClass2);
        if (zIsEmpty) {
            Handler handler = androidComposeView.getHandler();
            if (handler == null) {
                throw new IllegalArgumentException("schedule is called when outOfFrameExecutor is not available (view is detached)");
            }
            handler.postAtFrontOfQueue(androidComposeView.outOfFrameRunnable);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0092 A[Catch: all -> 0x008d, TryCatch #0 {all -> 0x008d, blocks: (B:44:0x0076, B:47:0x0082, B:59:0x00ad, B:61:0x00bf, B:64:0x00d4, B:66:0x00d8, B:72:0x010c, B:67:0x00e5, B:68:0x00f0, B:70:0x00f4, B:71:0x0109, B:62:0x00c2, B:56:0x0092, B:58:0x00a0, B:75:0x0118, B:76:0x0122), top: B:79:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0 A[Catch: all -> 0x008d, TryCatch #0 {all -> 0x008d, blocks: (B:44:0x0076, B:47:0x0082, B:59:0x00ad, B:61:0x00bf, B:64:0x00d4, B:66:0x00d8, B:72:0x010c, B:67:0x00e5, B:68:0x00f0, B:70:0x00f4, B:71:0x0109, B:62:0x00c2, B:56:0x0092, B:58:0x00a0, B:75:0x0118, B:76:0x0122), top: B:79:0x0076 }] */
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
    public final void subcompose(LayoutNode layoutNode, Object obj, boolean z, Function2 function2) {
        boolean z2;
        CompositionImpl compositionImpl;
        MutableScatterMap mutableScatterMap = this.nodeToNodeState;
        Object obj2 = mutableScatterMap.get(layoutNode);
        Object obj3 = obj2;
        if (obj2 == null) {
            ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$SubcomposeLayoutKt.lambda$641200809;
            NodeState nodeState = new NodeState();
            nodeState.slotId = obj;
            nodeState.content = composableLambdaImpl;
            nodeState.composition = null;
            nodeState.activeState = Stack.mutableStateOf$default(Boolean.TRUE);
            mutableScatterMap.set(layoutNode, nodeState);
            obj3 = nodeState;
        }
        NodeState nodeState2 = (NodeState) obj3;
        boolean z3 = nodeState2.content != function2;
        if (nodeState2.pausedComposition != null) {
            if (z3) {
                cancelPausedPrecomposition(nodeState2);
            } else if (z) {
                return;
            } else {
                applyPausedPrecomposition(nodeState2, true);
            }
        }
        CompositionImpl compositionImpl2 = nodeState2.composition;
        if (compositionImpl2 != null) {
            synchronized (compositionImpl2.lock) {
                z2 = compositionImpl2.invalidations._size > 0;
            }
        } else {
            z2 = true;
        }
        if (z3 || z2 || nodeState2.forceRecompose) {
            nodeState2.content = function2;
            if (nodeState2.pausedComposition != null) {
                InlineClassHelperKt.throwIllegalArgumentException("new subcompose call while paused composition is still active");
            }
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                LayoutNode layoutNode2 = this.root;
                layoutNode2.ignoreRemeasureRequests = true;
                CompositionImpl compositionImpl3 = nodeState2.composition;
                CompositionContext compositionContext = this.compositionContext;
                if (compositionContext == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("parent composition reference not set");
                    throw new HttpException();
                }
                if (compositionImpl3 == null) {
                    if (z) {
                        ViewGroup.LayoutParams layoutParams = Wrapper_androidKt.DefaultLayoutParams;
                        compositionImpl = new CompositionImpl(compositionContext, new MenuHostHelper(layoutNode));
                    } else {
                        ViewGroup.LayoutParams layoutParams2 = Wrapper_androidKt.DefaultLayoutParams;
                        compositionImpl = new CompositionImpl(compositionContext, new MenuHostHelper(layoutNode));
                    }
                    compositionImpl3 = compositionImpl;
                } else {
                    if (compositionImpl3.state == 3) {
                        if (z) {
                            ViewGroup.LayoutParams layoutParams3 = Wrapper_androidKt.DefaultLayoutParams;
                            compositionImpl = new CompositionImpl(compositionContext, new MenuHostHelper(layoutNode));
                        } else {
                            ViewGroup.LayoutParams layoutParams4 = Wrapper_androidKt.DefaultLayoutParams;
                            compositionImpl = new CompositionImpl(compositionContext, new MenuHostHelper(layoutNode));
                        }
                        compositionImpl3 = compositionImpl;
                    }
                }
                nodeState2.composition = compositionImpl3;
                Function2 composableLambdaImpl2 = nodeState2.content;
                if (((AndroidComposeView) LayoutNodeKt.requireOwner(this.root)).getOutOfFrameExecutor() != null) {
                    nodeState2.composedWithReusableContentHost = false;
                } else {
                    nodeState2.composedWithReusableContentHost = true;
                    composableLambdaImpl2 = new ComposableLambdaImpl(1524156494, new NavHostKt.AnonymousClass32.AnonymousClass1(2, nodeState2, composableLambdaImpl2), true);
                }
                if (z) {
                    if (nodeState2.forceReuse) {
                        compositionImpl3.clearDeactivated();
                        compositionImpl3.ensureRunning();
                        nodeState2.pausedComposition = compositionImpl3.composeInitialPaused(true, composableLambdaImpl2);
                    } else {
                        nodeState2.pausedComposition = compositionImpl3.composeInitialPaused(compositionImpl3.clearDeactivated(), composableLambdaImpl2);
                    }
                } else if (nodeState2.forceReuse) {
                    compositionImpl3.clearDeactivated();
                    compositionImpl3.ensureRunning();
                    GapComposer gapComposer = compositionImpl3.composer;
                    gapComposer.reusingGroup = 0;
                    gapComposer.reusing = true;
                    compositionImpl3.parent.composeInitial$runtime(compositionImpl3, composableLambdaImpl2);
                    gapComposer.endReuseFromRoot$runtime();
                } else {
                    compositionImpl3.setContent(composableLambdaImpl2);
                }
                nodeState2.forceReuse = false;
                Unit unit = Unit.INSTANCE;
                layoutNode2.ignoreRemeasureRequests = false;
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                nodeState2.forceRecompose = false;
            } catch (Throwable th) {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
    }

    public final LayoutNode takeNodeFromReusables(Object obj) {
        MutableScatterMap mutableScatterMap;
        int i;
        if (this.reusableCount == 0) {
            return null;
        }
        MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) this.root.getFoldedChildren$ui();
        int i2 = ((MutableVector) objectListMutableList.objectList).size - this.precomposedCount;
        int i3 = i2 - this.reusableCount;
        int i4 = i2 - 1;
        int i5 = i4;
        while (true) {
            mutableScatterMap = this.nodeToNodeState;
            if (i5 < i3) {
                i = -1;
                break;
            }
            if (((NodeState) mutableScatterMap.get((LayoutNode) objectListMutableList.get(i5))).slotId.equals(obj)) {
                i = i5;
                break;
            }
            i5--;
        }
        if (i == -1) {
            while (true) {
                if (i4 < i3) {
                    i5 = i4;
                    break;
                }
                NodeState nodeState = (NodeState) mutableScatterMap.get((LayoutNode) objectListMutableList.get(i4));
                Object obj2 = nodeState.slotId;
                if (obj2 == RulerKt.ReusedSlotId || this.slotReusePolicy.areCompatible(obj, obj2)) {
                    nodeState.slotId = obj;
                    i5 = i4;
                    i = i5;
                    break;
                }
                i4--;
            }
        }
        if (i == -1) {
            return null;
        }
        if (i5 != i3) {
            move(i5, i3);
        }
        this.reusableCount--;
        LayoutNode layoutNode = (LayoutNode) objectListMutableList.get(i3);
        NodeState nodeState2 = (NodeState) mutableScatterMap.get(layoutNode);
        nodeState2.activeState = Stack.mutableStateOf$default(Boolean.TRUE);
        nodeState2.forceReuse = true;
        nodeState2.forceRecompose = true;
        return layoutNode;
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createPrecomposedSlotHandle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements SubcomposeLayoutState.PrecomposedSlotHandle {
        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
        public final /* synthetic */ int getPlaceablesCount() {
            return 0;
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
        public final void dispose() {
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
        public final /* synthetic */ void traverseDescendants(LogcatReader$$ExternalSyntheticLambda3 logcatReader$$ExternalSyntheticLambda3) {
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
        /* JADX INFO: renamed from: premeasure-0kLqBqw, reason: not valid java name */
        public final /* synthetic */ void mo532premeasure0kLqBqw(int i, long j) {
        }
    }
}
