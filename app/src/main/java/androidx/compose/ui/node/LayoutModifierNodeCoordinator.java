package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final AndroidPaint modifierBoundsPaint;
    public LayoutModifierNode layoutModifierNode;
    public LookaheadDelegateForLayoutModifierNode lookaheadDelegate;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int iAccess$calculateAlignmentAndPlaceChildAsNeeded = HitTestResultKt.access$calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            this.cachedAlignmentLinesMap.set(iAccess$calculateAlignmentAndPlaceChildAsNeeded, alignmentLine);
            return iAccess$calculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int maxIntrinsicHeight(int i) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            return layoutModifierNodeCoordinator.layoutModifierNode.maxIntrinsicHeight(this, layoutModifierNodeCoordinator.wrapped.getLookaheadDelegate(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int maxIntrinsicWidth(int i) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            return layoutModifierNodeCoordinator.layoutModifierNode.maxIntrinsicWidth(this, layoutModifierNodeCoordinator.wrapped.getLookaheadDelegate(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public final Placeable mo517measureBRTryo0(long j) {
            m535setMeasurementConstraintsBRTryo0(j);
            new Constraints(j);
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            LookaheadDelegate.access$set_measureResult(this, layoutModifierNodeCoordinator.layoutModifierNode.mo25measure3p2s80s(this, layoutModifierNodeCoordinator.wrapped.getLookaheadDelegate(), j));
            return this;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int minIntrinsicHeight(int i) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            return layoutModifierNodeCoordinator.layoutModifierNode.minIntrinsicHeight(this, layoutModifierNodeCoordinator.wrapped.getLookaheadDelegate(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int minIntrinsicWidth(int i) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            return layoutModifierNodeCoordinator.layoutModifierNode.minIntrinsicWidth(this, layoutModifierNodeCoordinator.wrapped.getLookaheadDelegate(), i);
        }
    }

    static {
        AndroidPaint androidPaintPaint = BrushKt.Paint();
        androidPaintPaint.m404setColor8_81llA(Color.Blue);
        androidPaintPaint.setStrokeWidth(1.0f);
        androidPaintPaint.m408setStylek9PVt8s(1);
        modifierBoundsPaint = androidPaintPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        this.layoutModifierNode = layoutModifierNode;
        this.lookaheadDelegate = layoutNode.lookaheadRoot != null ? new LookaheadDelegateForLayoutModifierNode() : null;
        if ((((Modifier.Node) layoutModifierNode).node.kindSet & 512) != 0) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegateForLayoutModifierNode lookaheadDelegateForLayoutModifierNode = this.lookaheadDelegate;
        if (lookaheadDelegateForLayoutModifierNode == null) {
            return HitTestResultKt.access$calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
        }
        MutableObjectIntMap mutableObjectIntMap = lookaheadDelegateForLayoutModifierNode.cachedAlignmentLinesMap;
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(alignmentLine);
        if (iFindKeyIndex >= 0) {
            return mutableObjectIntMap.values[iFindKeyIndex];
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void ensureLookaheadDelegateCreated() {
        if (this.lookaheadDelegate == null) {
            this.lookaheadDelegate = new LookaheadDelegateForLayoutModifierNode();
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final Modifier.Node getTail() {
        return ((Modifier.Node) this.layoutModifierNode).node;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        return this.layoutModifierNode.maxIntrinsicHeight(this, this.wrapped, i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        return this.layoutModifierNode.maxIntrinsicWidth(this, this.wrapped, i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public final Placeable mo517measureBRTryo0(long j) {
        m535setMeasurementConstraintsBRTryo0(j);
        setMeasureResult$ui(this.layoutModifierNode.mo25measure3p2s80s(this, this.wrapped, j));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        return this.layoutModifierNode.minIntrinsicHeight(this, this.wrapped, i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        return this.layoutModifierNode.minIntrinsicWidth(this, this.wrapped, i);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator;
        this.wrapped.draw(canvas, graphicsLayer);
        if (!((AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode)).getShowLayoutBounds() || (nodeCoordinator = this.wrapped) == null) {
            return;
        }
        if (IntSize.m720equalsimpl0(this.measuredSize, nodeCoordinator.measuredSize) && IntOffset.m712equalsimpl0(nodeCoordinator.position, 0L)) {
            return;
        }
        long j = this.measuredSize;
        canvas.drawRect(0.5f, 0.5f, ((int) (j >> 32)) - 0.5f, ((int) (j & 4294967295L)) - 0.5f, modifierBoundsPaint);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo521placeAtf8xVGno(long j, float f, Function1 function1) {
        m576placeSelfMLgxB_4(j, f, function1);
        if (this.isShallowPlacing) {
            return;
        }
        onPlaced();
        NodeCoordinator nodeCoordinator = this.wrapped;
        nodeCoordinator.isPlacingForAlignment = this.isPlacingForAlignment;
        getMeasureResult$ui().placeChildren();
        nodeCoordinator.isPlacingForAlignment = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLayoutModifierNode$ui(LayoutModifierNode layoutModifierNode) {
        if (!layoutModifierNode.equals(this.layoutModifierNode) && (((Modifier.Node) layoutModifierNode).node.kindSet & 512) != 0) {
            throw new ClassCastException();
        }
        this.layoutModifierNode = layoutModifierNode;
    }
}
