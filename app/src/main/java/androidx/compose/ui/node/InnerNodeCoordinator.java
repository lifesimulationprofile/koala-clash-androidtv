package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import coil.request.RequestService;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final AndroidPaint innerBoundsPaint;
    public LookaheadDelegateImpl lookaheadDelegate;
    public final TailModifierNode tail;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class LookaheadDelegateImpl extends LookaheadDelegate {
        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
            LookaheadPassDelegate lookaheadPassDelegate = this.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            LookaheadAlignmentLines lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines;
            if (!lookaheadPassDelegate.duringAlignmentLinesQuery) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                if (layoutNodeLayoutDelegate.layoutState == 2) {
                    lookaheadAlignmentLines.usedByModifierMeasurement = true;
                    if (lookaheadAlignmentLines.dirty) {
                        layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
                        layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
                    }
                } else {
                    lookaheadAlignmentLines.usedByModifierLayout = true;
                }
            }
            LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
            if (lookaheadDelegateImpl != null) {
                lookaheadDelegateImpl.isPlacingForAlignment = true;
            }
            lookaheadPassDelegate.layoutChildren();
            LookaheadDelegateImpl lookaheadDelegateImpl2 = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
            if (lookaheadDelegateImpl2 != null) {
                lookaheadDelegateImpl2.isPlacingForAlignment = false;
            }
            Integer num = (Integer) lookaheadAlignmentLines.alignmentLineMap.get(alignmentLine);
            int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            this.cachedAlignmentLinesMap.set(iIntValue, alignmentLine);
            return iIntValue;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int maxIntrinsicHeight(int i) {
            RequestService orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
            return measurePolicyState.maxIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int maxIntrinsicWidth(int i) {
            RequestService orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
            return measurePolicyState.maxIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public final Placeable mo517measureBRTryo0(long j) {
            m535setMeasurementConstraintsBRTryo0(j);
            NodeCoordinator nodeCoordinator = this.coordinator;
            MutableVector mutableVector = nodeCoordinator.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate.measuredByParent = 3;
            }
            LayoutNode layoutNode = nodeCoordinator.layoutNode;
            LookaheadDelegate.access$set_measureResult(this, layoutNode.measurePolicy.mo24measure3p2s80s(this, layoutNode.getChildLookaheadMeasurables$ui(), j));
            return this;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int minIntrinsicHeight(int i) {
            RequestService orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
            return measurePolicyState.minIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int minIntrinsicWidth(int i) {
            RequestService orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
            return measurePolicyState.minIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public final void placeChildren() {
            this.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate.onNodePlaced$ui();
        }
    }

    static {
        AndroidPaint androidPaintPaint = BrushKt.Paint();
        androidPaintPaint.m404setColor8_81llA(Color.Red);
        androidPaintPaint.setStrokeWidth(1.0f);
        androidPaintPaint.m408setStylek9PVt8s(1);
        innerBoundsPaint = androidPaintPaint;
    }

    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        TailModifierNode tailModifierNode = new TailModifierNode();
        tailModifierNode.aggregateChildKindSet = 0;
        this.tail = tailModifierNode;
        tailModifierNode.coordinator = this;
        this.lookaheadDelegate = layoutNode.lookaheadRoot != null ? new LookaheadDelegateImpl(this) : null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final int calculateAlignmentLine(AlignmentLine alignmentLine) throws Throwable {
        LookaheadDelegateImpl lookaheadDelegateImpl = this.lookaheadDelegate;
        if (lookaheadDelegateImpl != null) {
            return lookaheadDelegateImpl.calculateAlignmentLine(alignmentLine);
        }
        MeasurePassDelegate measurePassDelegate = this.layoutNode.layoutDelegate.measurePassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines = measurePassDelegate.alignmentLines;
        if (!measurePassDelegate.duringAlignmentLinesQuery) {
            if (measurePassDelegate.layoutNodeLayoutDelegate.layoutState == 1) {
                lookaheadAlignmentLines.usedByModifierMeasurement = true;
                if (lookaheadAlignmentLines.dirty) {
                    measurePassDelegate.layoutPending = true;
                    measurePassDelegate.layoutPendingForAlignment = true;
                }
            } else {
                lookaheadAlignmentLines.usedByModifierLayout = true;
            }
        }
        InnerNodeCoordinator innerCoordinator = measurePassDelegate.getInnerCoordinator();
        boolean z = innerCoordinator.isPlacingForAlignment;
        innerCoordinator.isPlacingForAlignment = true;
        measurePassDelegate.layoutChildren();
        innerCoordinator.isPlacingForAlignment = z;
        Integer num = (Integer) lookaheadAlignmentLines.alignmentLineMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void ensureLookaheadDelegateCreated() {
        if (this.lookaheadDelegate == null) {
            this.lookaheadDelegate = new LookaheadDelegateImpl(this);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final Modifier.Node getTail() {
        return this.tail;
    }

    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v5 */
    @Override // androidx.compose.ui.node.NodeCoordinator
    /* JADX INFO: renamed from: hitTestChild-qzLsGqo, reason: not valid java name */
    public final void mo548hitTestChildqzLsGqo(TouchBoundsExpansion.Companion companion, long j, HitTestResult hitTestResult, int i, boolean z) {
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        Object[] objArr;
        int i3;
        LayoutNode layoutNode;
        LayoutNode layoutNode2;
        long jM541findBestHitDistancefn2tFes;
        boolean z5;
        long j2 = j;
        HitTestResult hitTestResult2 = hitTestResult;
        int i4 = companion.$r8$classId;
        LayoutNode layoutNode3 = this.layoutNode;
        switch (i4) {
            case 1:
                z2 = true;
                break;
            default:
                SemanticsConfiguration semanticsConfiguration = layoutNode3.getSemanticsConfiguration();
                z2 = !(semanticsConfiguration != null && semanticsConfiguration.isClearingSemantics);
                break;
        }
        if (z2) {
            if (m580withinLayerBoundsk4lQ0M(j2)) {
                i2 = i;
                z3 = z;
                z4 = true;
            } else {
                i2 = i;
                if (i2 == 1 && (Float.floatToRawIntBits(m568distanceInMinimumTouchTargettz77jQw(j2, m570getMinimumTouchTargetSizeNHjbRc())) & Integer.MAX_VALUE) < 2139095040) {
                    z4 = true;
                    z3 = false;
                }
            }
            if (z4) {
                int i5 = hitTestResult2.hitDepth;
                MutableVector zSortedChildren = layoutNode3.getZSortedChildren();
                objArr = zSortedChildren.content;
                i3 = zSortedChildren.size - 1;
                while (i3 >= 0) {
                    layoutNode = (LayoutNode) objArr[i3];
                    if (layoutNode.isPlaced()) {
                        switch (companion.$r8$classId) {
                            case 1:
                                layoutNode.m549hitTest6fMxITs$ui(j2, hitTestResult2, i2, z3);
                                layoutNode2 = layoutNode;
                                break;
                            default:
                                NodeChain nodeChain = layoutNode.nodes;
                                ((NodeCoordinator) nodeChain.outerCoordinator).m574hitTestqzLsGqo(NodeCoordinator.SemanticsSource, ((NodeCoordinator) nodeChain.outerCoordinator).m569fromParentPosition8S9VItk(j2), hitTestResult2, 1, z3);
                                hitTestResult2 = hitTestResult;
                                layoutNode2 = layoutNode;
                                break;
                        }
                        jM541findBestHitDistancefn2tFes = hitTestResult2.m541findBestHitDistancefn2tFes();
                        if (HitTestResultKt.m544getDistanceimpl(jM541findBestHitDistancefn2tFes) < 0.0f && HitTestResultKt.m546isInLayerimpl(jM541findBestHitDistancefn2tFes) && !HitTestResultKt.m545isInExpandedBoundsimpl(jM541findBestHitDistancefn2tFes)) {
                            switch (companion.$r8$classId) {
                                case 1:
                                    NodeCoordinator nodeCoordinator = (NodeCoordinator) layoutNode2.nodes.outerCoordinator;
                                    nodeCoordinator.getClass();
                                    Modifier.Node nodeHeadNode = nodeCoordinator.headNode(NodeKindKt.m581getIncludeSelfInTraversalH91voCI(16));
                                    if (nodeHeadNode != null && nodeHeadNode.isAttached) {
                                        if (!nodeHeadNode.node.isAttached) {
                                            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
                                        }
                                        Modifier.Node node = nodeHeadNode.node;
                                        if ((node.aggregateChildKindSet & 16) != 0) {
                                            while (true) {
                                                if (node != null) {
                                                    if ((node.kindSet & 16) != 0) {
                                                        ?? Access$pop = node;
                                                        ?? mutableVector = 0;
                                                        while (true) {
                                                            if (Access$pop != 0) {
                                                                if (Access$pop instanceof PointerInputModifierNode) {
                                                                    if (((PointerInputModifierNode) Access$pop).sharePointerInputWithSiblings()) {
                                                                        hitTestResult2.hitDepth = hitTestResult2.values._size - 1;
                                                                        z5 = true;
                                                                    }
                                                                    break;
                                                                } else if ((Access$pop.kindSet & 16) != 0 && (Access$pop instanceof DelegatingNode)) {
                                                                    Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                                                                    int i6 = 0;
                                                                    while (node2 != null) {
                                                                        if ((node2.kindSet & 16) != 0) {
                                                                            i6++;
                                                                            if (i6 == 1) {
                                                                                Access$pop = Access$pop;
                                                                                mutableVector = mutableVector;
                                                                                mutableVector = mutableVector;
                                                                                Access$pop = node2;
                                                                            } else {
                                                                                if (mutableVector == 0) {
                                                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                                                }
                                                                                if (Access$pop != 0) {
                                                                                    mutableVector.add(Access$pop);
                                                                                    Access$pop = 0;
                                                                                }
                                                                                mutableVector.add(node2);
                                                                            }
                                                                        } else {
                                                                            Access$pop = Access$pop;
                                                                            mutableVector = mutableVector;
                                                                        }
                                                                        node2 = node2.child;
                                                                        Access$pop = Access$pop;
                                                                        mutableVector = mutableVector;
                                                                    }
                                                                    if (i6 == 1) {
                                                                        Access$pop = Access$pop;
                                                                        mutableVector = mutableVector;
                                                                    } else {
                                                                        Access$pop = Access$pop;
                                                                        mutableVector = mutableVector;
                                                                    }
                                                                }
                                                                Access$pop = HitTestResultKt.access$pop(mutableVector);
                                                            } else {
                                                                continue;
                                                            }
                                                        }
                                                    }
                                                    node = node.child;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                default:
                                    z5 = false;
                                    break;
                            }
                            if (!z5) {
                                hitTestResult2.hitDepth = i5;
                            }
                        }
                    }
                    i3--;
                    j2 = j;
                    i2 = i;
                }
                hitTestResult2.hitDepth = i5;
            }
        }
        i2 = i;
        z3 = z;
        z4 = false;
        if (z4) {
            int i7 = hitTestResult2.hitDepth;
            MutableVector zSortedChildren2 = layoutNode3.getZSortedChildren();
            objArr = zSortedChildren2.content;
            i3 = zSortedChildren2.size - 1;
            while (i3 >= 0) {
                layoutNode = (LayoutNode) objArr[i3];
                if (layoutNode.isPlaced()) {
                    switch (companion.$r8$classId) {
                        case 1:
                            layoutNode.m549hitTest6fMxITs$ui(j2, hitTestResult2, i2, z3);
                            layoutNode2 = layoutNode;
                            break;
                        default:
                            NodeChain nodeChain2 = layoutNode.nodes;
                            ((NodeCoordinator) nodeChain2.outerCoordinator).m574hitTestqzLsGqo(NodeCoordinator.SemanticsSource, ((NodeCoordinator) nodeChain2.outerCoordinator).m569fromParentPosition8S9VItk(j2), hitTestResult2, 1, z3);
                            hitTestResult2 = hitTestResult;
                            layoutNode2 = layoutNode;
                            break;
                    }
                    jM541findBestHitDistancefn2tFes = hitTestResult2.m541findBestHitDistancefn2tFes();
                    if (HitTestResultKt.m544getDistanceimpl(jM541findBestHitDistancefn2tFes) < 0.0f) {
                        continue;
                    }
                }
                i3--;
                j2 = j;
                i2 = i;
            }
            hitTestResult2.hitDepth = i7;
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        RequestService orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
        return measurePolicyState.maxIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        RequestService orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
        return measurePolicyState.maxIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public final Placeable mo517measureBRTryo0(long j) {
        m535setMeasurementConstraintsBRTryo0(j);
        LayoutNode layoutNode = this.layoutNode;
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.measuredByParent = 3;
        }
        setMeasureResult$ui(layoutNode.measurePolicy.mo24measure3p2s80s(this, layoutNode.getChildMeasurables$ui(), j));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        RequestService orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
        return measurePolicyState.minIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        RequestService orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.systemCallbacks;
        return measurePolicyState.minIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) throws Throwable {
        LayoutNode layoutNode = this.layoutNode;
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode);
        MutableVector zSortedChildren = layoutNode.getZSortedChildren();
        Object[] objArr = zSortedChildren.content;
        int i = zSortedChildren.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.isPlaced()) {
                layoutNode2.draw$ui(canvas, graphicsLayer);
            }
        }
        if (((AndroidComposeView) ownerRequireOwner).getShowLayoutBounds()) {
            long j = this.measuredSize;
            canvas.drawRect(0.5f, 0.5f, ((int) (j >> 32)) - 0.5f, ((int) (j & 4294967295L)) - 0.5f, innerBoundsPaint);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo521placeAtf8xVGno(long j, float f, Function1 function1) throws Throwable {
        m576placeSelfMLgxB_4(j, f, function1);
        if (this.isShallowPlacing) {
            return;
        }
        this.layoutNode.layoutDelegate.measurePassDelegate.onNodePlaced$ui();
    }
}
