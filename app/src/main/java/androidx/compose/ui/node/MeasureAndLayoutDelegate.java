package androidx.compose.ui.node;

import android.os.Trace;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeView$localeList$2;
import androidx.compose.ui.unit.Constraints;
import androidx.core.view.MenuHostHelper;
import coil.memory.MemoryCacheService;
import coil.network.HttpException;
import coil.request.RequestService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MeasureAndLayoutDelegate {
    public boolean duringFullMeasureLayoutPass;
    public boolean duringMeasureLayout;
    public final LayoutNode root;
    public Constraints rootConstraints;
    public final MenuHostHelper relayoutNodes = new MenuHostHelper(22);
    public final RequestService onPositionedDispatcher = new RequestService(7);
    public final MutableVector onLayoutCompletedListeners = new MutableVector(new LayoutNode[16]);
    public final long measureIteration = 1;
    public final MutableVector postponedMeasureRequests = new MutableVector(new PostponedRequest[16]);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class PostponedRequest {
        public final boolean isForced;
        public final boolean isLookahead;
        public final LayoutNode node;

        public PostponedRequest(LayoutNode layoutNode, boolean z, boolean z2) {
            this.node = layoutNode;
            this.isLookahead = z;
            this.isForced = z2;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode layoutNode) {
        this.root = layoutNode;
    }

    public static final boolean access$remeasureAndRelayoutIfNeeded(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z) {
        Placeable.PlacementScope placementScope;
        InnerNodeCoordinator innerNodeCoordinator;
        LayoutNode parent$ui;
        LayoutNode layoutNode2 = measureAndLayoutDelegate.root;
        boolean z2 = layoutNode.isDeactivated;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        boolean zM559doLookaheadRemeasuresdFAvZA = false;
        if (!z2 && isUsedInMeasureOrLayout(layoutNode)) {
            Constraints constraints = layoutNode == layoutNode2 ? measureAndLayoutDelegate.rootConstraints : null;
            if (z) {
                zM559doLookaheadRemeasuresdFAvZA = layoutNodeLayoutDelegate.lookaheadMeasurePending ? m559doLookaheadRemeasuresdFAvZA(layoutNode, constraints) : false;
                if ((zM559doLookaheadRemeasuresdFAvZA || layoutNodeLayoutDelegate.lookaheadLayoutPending) && Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
                    layoutNode.lookaheadReplace$ui();
                }
            } else {
                boolean zM560doRemeasuresdFAvZA = layoutNode.getMeasurePending$ui() ? m560doRemeasuresdFAvZA(layoutNode, constraints) : false;
                if (layoutNode.getLayoutPending$ui() && (layoutNode == layoutNode2 || ((parent$ui = layoutNode.getParent$ui()) != null && parent$ui.isPlaced() && layoutNodeLayoutDelegate.measurePassDelegate.isPlacedByParent))) {
                    if (layoutNode == layoutNode2) {
                        if (layoutNode.intrinsicsUsageByParent == 3) {
                            layoutNode.clearSubtreePlacementIntrinsicsUsage();
                        }
                        LayoutNode parent$ui2 = layoutNode.getParent$ui();
                        if (parent$ui2 == null || (innerNodeCoordinator = (InnerNodeCoordinator) parent$ui2.nodes.innerCoordinator) == null || (placementScope = innerNodeCoordinator.placementScope) == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getPlacementScope();
                        }
                        Placeable.PlacementScope.placeRelative$default(placementScope, layoutNodeLayoutDelegate.measurePassDelegate, 0, 0);
                    } else {
                        layoutNode.replace$ui();
                    }
                    RequestService requestService = measureAndLayoutDelegate.onPositionedDispatcher;
                    requestService.getClass();
                    if (layoutNode.globallyPositionedObservers > 0) {
                        ((MutableVector) requestService.systemCallbacks).add(layoutNode);
                        layoutNode.needsOnGloballyPositionedDispatch = true;
                    }
                }
                zM559doLookaheadRemeasuresdFAvZA = zM560doRemeasuresdFAvZA;
            }
            measureAndLayoutDelegate.drainPostponedMeasureRequests();
        }
        return zM559doLookaheadRemeasuresdFAvZA;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    /* JADX INFO: renamed from: doLookaheadRemeasure-sdFAvZA, reason: not valid java name */
    public static boolean m559doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) throws Throwable {
        boolean zM558remeasureBRTryo0;
        LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (layoutNode2 == null) {
            return false;
        }
        if (constraints == null) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            Constraints constraints2 = lookaheadPassDelegate != null ? lookaheadPassDelegate.lookaheadConstraints : null;
            if (constraints2 == null || layoutNode2 == null) {
                zM558remeasureBRTryo0 = false;
            } else {
                zM558remeasureBRTryo0 = lookaheadPassDelegate.m558remeasureBRTryo0(constraints2.value);
            }
        } else if (layoutNode2 != null) {
            zM558remeasureBRTryo0 = layoutNodeLayoutDelegate.lookaheadPassDelegate.m558remeasureBRTryo0(constraints.value);
        } else {
            zM558remeasureBRTryo0 = false;
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if (zM558remeasureBRTryo0 && parent$ui != null) {
            if (parent$ui.lookaheadRoot == null) {
                LayoutNode.requestRemeasure$ui$default(parent$ui, false, 3);
                return zM558remeasureBRTryo0;
            }
            if (layoutNode.getMeasuredByParentInLookahead$ui() == 1) {
                LayoutNode.requestLookaheadRemeasure$ui$default(parent$ui, false, 3);
                return zM558remeasureBRTryo0;
            }
            if (layoutNode.getMeasuredByParentInLookahead$ui() == 2) {
                parent$ui.requestLookaheadRelayout$ui(false);
            }
        }
        return zM558remeasureBRTryo0;
    }

    /* JADX INFO: renamed from: doRemeasure-sdFAvZA, reason: not valid java name */
    public static boolean m560doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) throws Throwable {
        boolean zM564remeasureBRTryo0;
        if (constraints != null) {
            if (layoutNode.intrinsicsUsageByParent == 3) {
                layoutNode.clearSubtreeIntrinsicsUsage$ui();
            }
            zM564remeasureBRTryo0 = layoutNode.layoutDelegate.measurePassDelegate.m564remeasureBRTryo0(constraints.value);
        } else {
            MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
            Constraints constraints2 = measurePassDelegate.measuredOnce ? new Constraints(measurePassDelegate.measurementConstraints) : null;
            if (constraints2 != null) {
                if (layoutNode.intrinsicsUsageByParent == 3) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui();
                }
                zM564remeasureBRTryo0 = layoutNode.layoutDelegate.measurePassDelegate.m564remeasureBRTryo0(constraints2.value);
            } else {
                layoutNode.getClass();
                zM564remeasureBRTryo0 = false;
            }
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if (zM564remeasureBRTryo0 && parent$ui != null) {
            if (layoutNode.getMeasuredByParent$ui() == 1) {
                LayoutNode.requestRemeasure$ui$default(parent$ui, false, 3);
                return zM564remeasureBRTryo0;
            }
            if (layoutNode.getMeasuredByParent$ui() == 2) {
                parent$ui.requestRelayout$ui(false);
            }
        }
        return zM564remeasureBRTryo0;
    }

    public static boolean getCanAffectParentInLookahead(LayoutNode layoutNode) {
        LookaheadPassDelegate lookaheadPassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        if (layoutNode.layoutDelegate.lookaheadMeasurePending) {
            return (layoutNode.getMeasuredByParentInLookahead$ui() == 3 && ((lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate) == null || (lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines) == null || !lookaheadAlignmentLines.getRequired$ui())) ? false : true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    /* JADX WARN: Code duplicated, block: B:21:0x0037 A[SYNTHETIC] */
    public static boolean getCanAffectPlacedParent(LayoutNode layoutNode) {
        if (layoutNode.getMeasurePending$ui()) {
            do {
                if (layoutNode.getMeasuredByParent$ui() != 3 || layoutNode.layoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui()) {
                    layoutNode = layoutNode.getParent$ui();
                    if (layoutNode == null) {
                    }
                } else {
                    LayoutNode parent$ui = layoutNode.getParent$ui();
                    if ((parent$ui != null ? parent$ui.layoutDelegate.layoutState : 0) == 1) {
                        layoutNode = layoutNode.getParent$ui();
                        if (layoutNode == null) {
                        }
                    }
                }
            } while (!layoutNode.isPlaced());
            return true;
        }
        return false;
    }

    public static boolean isUsedInMeasureOrLayout(LayoutNode layoutNode) {
        LookaheadPassDelegate lookaheadPassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        return layoutNode.isPlaced() || layoutNodeLayoutDelegate.measurePassDelegate.isPlacedByParent || getCanAffectPlacedParent(layoutNode) || Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode) || layoutNodeLayoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui() || !((lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate) == null || (lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines) == null || !lookaheadAlignmentLines.getRequired$ui());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v6 */
    public final void callOnLayoutCompletedListeners() {
        Modifier.Node node;
        MutableVector mutableVector = this.onLayoutCompletedListeners;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            NodeChain nodeChain = ((LayoutNode) objArr[i2]).nodes;
            InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
            boolean zM581getIncludeSelfInTraversalH91voCI = NodeKindKt.m581getIncludeSelfInTraversalH91voCI(4194304);
            if (zM581getIncludeSelfInTraversalH91voCI) {
                node = innerNodeCoordinator.tail;
            } else {
                node = innerNodeCoordinator.tail.parent;
                if (node == null) {
                }
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
            for (Modifier.Node nodeHeadNode = innerNodeCoordinator.headNode(zM581getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & 4194304) != 0; nodeHeadNode = nodeHeadNode.child) {
                if ((nodeHeadNode.kindSet & 4194304) != 0) {
                    ?? Access$pop = nodeHeadNode;
                    ?? mutableVector2 = 0;
                    while (Access$pop != 0) {
                        if (Access$pop instanceof LayoutAwareModifierNode) {
                            ((LayoutAwareModifierNode) Access$pop).onPlaced((InnerNodeCoordinator) nodeChain.innerCoordinator);
                        } else if ((Access$pop.kindSet & 4194304) != 0 && (Access$pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                            int i3 = 0;
                            Access$pop = Access$pop;
                            mutableVector2 = mutableVector2;
                            while (node2 != null) {
                                if ((node2.kindSet & 4194304) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        mutableVector2 = mutableVector2;
                                        Access$pop = node2;
                                    } else {
                                        if (mutableVector2 == 0) {
                                            mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Access$pop != 0) {
                                            mutableVector2.add(Access$pop);
                                            Access$pop = 0;
                                        }
                                        mutableVector2.add(node2);
                                    }
                                }
                                node2 = node2.child;
                                Access$pop = Access$pop;
                                mutableVector2 = mutableVector2;
                            }
                            if (i3 == 1) {
                            }
                        }
                        Access$pop = HitTestResultKt.access$pop(mutableVector2);
                    }
                }
                if (nodeHeadNode == node) {
                    break;
                }
            }
        }
        mutableVector.clear();
    }

    public final void dispatchOnPositionedCallbacks(boolean z) {
        RequestService requestService = this.onPositionedDispatcher;
        if (z) {
            MutableVector mutableVector = (MutableVector) requestService.systemCallbacks;
            LayoutNode layoutNode = this.root;
            if (layoutNode.globallyPositionedObservers > 0) {
                mutableVector.clear();
                mutableVector.add(layoutNode);
                layoutNode.needsOnGloballyPositionedDispatch = true;
            }
        }
        if (((MutableVector) requestService.systemCallbacks).size != 0) {
            Trace.beginSection("Compose:onPositionedCallbacks");
            try {
                requestService.dispatch();
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.endSection();
            }
        }
    }

    public final void drainPostponedMeasureRequests() {
        MutableVector mutableVector = this.postponedMeasureRequests;
        int i = mutableVector.size;
        if (i != 0) {
            Object[] objArr = mutableVector.content;
            for (int i2 = 0; i2 < i; i2++) {
                PostponedRequest postponedRequest = (PostponedRequest) objArr[i2];
                LayoutNode layoutNode = postponedRequest.node;
                boolean z = postponedRequest.isForced;
                LayoutNode layoutNode2 = postponedRequest.node;
                if (layoutNode.isAttached()) {
                    if (postponedRequest.isLookahead) {
                        LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode2, z, 2);
                    } else {
                        LayoutNode.requestRemeasure$ui$default(layoutNode2, z, 2);
                    }
                }
            }
            mutableVector.clear();
        }
    }

    public final void ensureSubtreeLookaheadReplaced(LayoutNode layoutNode) {
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (Intrinsics.areEqual(layoutNode2.isPlacedInLookahead(), Boolean.TRUE) && !layoutNode2.isDeactivated) {
                if (this.relayoutNodes.contains(layoutNode2)) {
                    layoutNode2.lookaheadReplace$ui();
                }
                ensureSubtreeLookaheadReplaced(layoutNode2);
            }
        }
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        if (!this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalStateException("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (z ? layoutNode.layoutDelegate.lookaheadMeasurePending : layoutNode.getMeasurePending$ui()) {
            InlineClassHelperKt.throwIllegalArgumentException("node not yet measured");
        }
        forceMeasureTheSubtreeInternal(layoutNode, z);
    }

    public final void forceMeasureTheSubtreeInternal(LayoutNode layoutNode, boolean z) throws Throwable {
        LookaheadPassDelegate lookaheadPassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if ((!z && (layoutNode2.getMeasuredByParent$ui() == 1 || layoutNode2.layoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui())) || (z && (layoutNode2.getMeasuredByParentInLookahead$ui() == 1 || ((lookaheadPassDelegate = layoutNode2.layoutDelegate.lookaheadPassDelegate) != null && (lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines) != null && lookaheadAlignmentLines.getRequired$ui())))) {
                boolean zIsOutMostLookaheadRoot = HitTestResultKt.isOutMostLookaheadRoot(layoutNode2);
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode2.layoutDelegate;
                if (zIsOutMostLookaheadRoot && !z) {
                    if (layoutNodeLayoutDelegate.lookaheadMeasurePending && this.relayoutNodes.contains(layoutNode2)) {
                        remeasureIfNeeded(layoutNode2, true);
                    } else {
                        forceMeasureTheSubtree(layoutNode2, true);
                    }
                }
                if (z ? layoutNodeLayoutDelegate.lookaheadMeasurePending : layoutNode2.getMeasurePending$ui()) {
                    remeasureIfNeeded(layoutNode2, z);
                }
                if (!(z ? layoutNodeLayoutDelegate.lookaheadMeasurePending : layoutNode2.getMeasurePending$ui())) {
                    forceMeasureTheSubtreeInternal(layoutNode2, z);
                }
            }
        }
        if (z ? layoutNode.layoutDelegate.lookaheadMeasurePending : layoutNode.getMeasurePending$ui()) {
            remeasureIfNeeded(layoutNode, z);
        }
    }

    public final boolean measureAndLayout(AndroidComposeView$localeList$2 androidComposeView$localeList$2) {
        boolean z;
        boolean z2;
        LayoutNode layoutNode;
        boolean z3;
        boolean zRemeasureIfNeeded;
        MenuHostHelper menuHostHelper = this.relayoutNodes;
        LayoutNode layoutNode2 = this.root;
        if (!layoutNode2.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!layoutNode2.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        boolean z4 = false;
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = true;
            try {
                boolean zIsNotEmpty = menuHostHelper.isNotEmpty();
                MemoryCacheService memoryCacheService = (MemoryCacheService) menuHostHelper.mOnInvalidateMenuCallback;
                if (zIsNotEmpty) {
                    z = false;
                    while (true) {
                        MemoryCacheService memoryCacheService2 = (MemoryCacheService) menuHostHelper.mProviderToLifecycleContainers;
                        MemoryCacheService memoryCacheService3 = (MemoryCacheService) menuHostHelper.mMenuProviders;
                        if (!((SortedSet) memoryCacheService.imageLoader).isEmpty()) {
                            layoutNode = (LayoutNode) ((SortedSet) memoryCacheService.imageLoader).first();
                            memoryCacheService.remove(layoutNode);
                            z3 = layoutNode.lookaheadRoot != null;
                            z2 = false;
                        } else if (!((SortedSet) memoryCacheService3.imageLoader).isEmpty()) {
                            layoutNode = (LayoutNode) ((SortedSet) memoryCacheService3.imageLoader).first();
                            memoryCacheService3.remove(layoutNode);
                            z3 = layoutNode.lookaheadRoot != null;
                            z2 = true;
                        } else {
                            if (((SortedSet) memoryCacheService2.imageLoader).isEmpty()) {
                                break;
                            }
                            LayoutNode layoutNode3 = (LayoutNode) ((SortedSet) memoryCacheService2.imageLoader).first();
                            memoryCacheService2.remove(layoutNode3);
                            z2 = true;
                            layoutNode = layoutNode3;
                            z3 = false;
                        }
                        if (z2) {
                            zRemeasureIfNeeded = access$remeasureAndRelayoutIfNeeded(this, layoutNode, z3);
                        } else {
                            zRemeasureIfNeeded = remeasureIfNeeded(layoutNode, z3);
                            if (layoutNode.layoutDelegate.lookaheadLayoutPending) {
                                menuHostHelper.add(2, layoutNode);
                            }
                            if (layoutNode.getLayoutPending$ui()) {
                                menuHostHelper.add(4, layoutNode);
                            }
                        }
                        if (layoutNode == layoutNode2 && zRemeasureIfNeeded) {
                            z = true;
                        }
                    }
                    if (androidComposeView$localeList$2 != null) {
                        androidComposeView$localeList$2.invoke();
                    }
                } else {
                    z = false;
                }
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                z4 = z;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw th2;
                }
            }
        }
        callOnLayoutCompletedListeners();
        return z4;
    }

    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public final void m561measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        boolean z = layoutNode.isDeactivated;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (z) {
            return;
        }
        LayoutNode layoutNode2 = this.root;
        if (layoutNode.equals(layoutNode2)) {
            InlineClassHelperKt.throwIllegalArgumentException("measureAndLayout called on root");
        }
        if (!layoutNode2.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!layoutNode2.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = false;
            try {
                MenuHostHelper menuHostHelper = this.relayoutNodes;
                ((MemoryCacheService) menuHostHelper.mOnInvalidateMenuCallback).remove(layoutNode);
                ((MemoryCacheService) menuHostHelper.mMenuProviders).remove(layoutNode);
                ((MemoryCacheService) menuHostHelper.mProviderToLifecycleContainers).remove(layoutNode);
                if (m559doLookaheadRemeasuresdFAvZA(layoutNode, new Constraints(j)) || layoutNodeLayoutDelegate.lookaheadLayoutPending) {
                    if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
                        layoutNode.lookaheadReplace$ui();
                    }
                }
                ensureSubtreeLookaheadReplaced(layoutNode);
                if (layoutNode.intrinsicsUsageByParent == 3) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui();
                }
                boolean zM564remeasureBRTryo0 = layoutNodeLayoutDelegate.measurePassDelegate.m564remeasureBRTryo0(j);
                LayoutNode parent$ui = layoutNode.getParent$ui();
                if (zM564remeasureBRTryo0 && parent$ui != null) {
                    if (layoutNode.getMeasuredByParent$ui() == 1) {
                        LayoutNode.requestRemeasure$ui$default(parent$ui, false, 3);
                    } else if (layoutNode.getMeasuredByParent$ui() == 2) {
                        parent$ui.requestRelayout$ui(false);
                    }
                }
                if (layoutNode.getLayoutPending$ui() && layoutNode.isPlaced()) {
                    layoutNode.replace$ui();
                    RequestService requestService = this.onPositionedDispatcher;
                    requestService.getClass();
                    if (layoutNode.globallyPositionedObservers > 0) {
                        ((MutableVector) requestService.systemCallbacks).add(layoutNode);
                        layoutNode.needsOnGloballyPositionedDispatch = true;
                    }
                }
                drainPostponedMeasureRequests();
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw th2;
                }
            }
        }
        callOnLayoutCompletedListeners();
    }

    public final void measureOnly() {
        MenuHostHelper menuHostHelper = this.relayoutNodes;
        if (menuHostHelper.isNotEmpty()) {
            LayoutNode layoutNode = this.root;
            if (!layoutNode.isAttached()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
            }
            if (!layoutNode.isPlaced()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
            }
            if (this.duringMeasureLayout) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
            }
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                this.duringFullMeasureLayoutPass = false;
                try {
                    if ((((SortedSet) ((MemoryCacheService) menuHostHelper.mProviderToLifecycleContainers).imageLoader).isEmpty() || ((SortedSet) ((MemoryCacheService) menuHostHelper.mOnInvalidateMenuCallback).imageLoader).isEmpty()) ? false : true) {
                        if (layoutNode.lookaheadRoot != null) {
                            remeasureOnly(layoutNode, true);
                        } else {
                            remeasureLookaheadRootsInSubtree(layoutNode);
                        }
                    }
                    remeasureOnly(layoutNode, false);
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        this.duringMeasureLayout = false;
                        this.duringFullMeasureLayoutPass = false;
                        throw th2;
                    }
                }
            }
        }
    }

    public final boolean remeasureIfNeeded(LayoutNode layoutNode, boolean z) throws Throwable {
        boolean zM560doRemeasuresdFAvZA = false;
        if (!layoutNode.isDeactivated && isUsedInMeasureOrLayout(layoutNode)) {
            Constraints constraints = layoutNode == this.root ? this.rootConstraints : null;
            if (z) {
                if (layoutNode.layoutDelegate.lookaheadMeasurePending) {
                    zM560doRemeasuresdFAvZA = m559doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
                }
            } else if (layoutNode.getMeasurePending$ui()) {
                zM560doRemeasuresdFAvZA = m560doRemeasuresdFAvZA(layoutNode, constraints);
            }
            drainPostponedMeasureRequests();
        }
        return zM560doRemeasuresdFAvZA;
    }

    public final void remeasureLookaheadRootsInSubtree(LayoutNode layoutNode) throws Throwable {
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.getMeasuredByParent$ui() == 1 || layoutNode2.layoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui()) {
                if (HitTestResultKt.isOutMostLookaheadRoot(layoutNode2)) {
                    remeasureOnly(layoutNode2, true);
                } else {
                    remeasureLookaheadRootsInSubtree(layoutNode2);
                }
            }
        }
    }

    public final void remeasureOnly(LayoutNode layoutNode, boolean z) throws Throwable {
        if (layoutNode.isDeactivated) {
            return;
        }
        Constraints constraints = layoutNode == this.root ? this.rootConstraints : null;
        if (z) {
            m559doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
        } else {
            m560doRemeasuresdFAvZA(layoutNode, constraints);
        }
    }

    public final boolean requestRemeasure(LayoutNode layoutNode, boolean z) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNode.layoutDelegate.layoutState);
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 || iOrdinal == 3) {
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, false, z));
            } else {
                if (iOrdinal != 4) {
                    throw new HttpException();
                }
                if (!layoutNode.getMeasurePending$ui() || z) {
                    layoutNode.layoutDelegate.measurePassDelegate.measurePending = true;
                    if (!layoutNode.isDeactivated && (layoutNode.isPlaced() || getCanAffectPlacedParent(layoutNode))) {
                        LayoutNode parent$ui = layoutNode.getParent$ui();
                        if (parent$ui == null || !parent$ui.getMeasurePending$ui()) {
                            this.relayoutNodes.add(3, layoutNode);
                        }
                        if (!this.duringFullMeasureLayoutPass) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: updateRootConstraints-BRTryo0, reason: not valid java name */
    public final void m562updateRootConstraintsBRTryo0(long j) {
        Constraints constraints = this.rootConstraints;
        if (constraints == null ? false : Constraints.m677equalsimpl0(constraints.value, j)) {
            return;
        }
        if (this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("updateRootConstraints called while measuring");
        }
        this.rootConstraints = new Constraints(j);
        LayoutNode layoutNode = this.root;
        LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (layoutNode2 != null) {
            layoutNodeLayoutDelegate.lookaheadMeasurePending = true;
        }
        layoutNodeLayoutDelegate.measurePassDelegate.measurePending = true;
        this.relayoutNodes.add(layoutNode2 == null ? 3 : 1, layoutNode);
    }
}
