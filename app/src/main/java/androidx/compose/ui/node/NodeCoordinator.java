package androidx.compose.ui.node;

import android.os.Build;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import androidx.navigation.compose.NavHostKt;
import coil.network.HttpException;
import coil.request.RequestService;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public NavHostKt.AnonymousClass32.AnonymousClass1 _drawBlock;
    public MeasureResult _measureResult;
    public MutableRect _rectCache;
    public Canvas drawBlockCanvas;
    public GraphicsLayer drawBlockParentLayer;
    public boolean isClipping;
    public boolean lastClip;
    public boolean lastLayerDrawingWasSkipped;
    public OwnedLayer layer;
    public Function1 layerBlock;
    public Density layerDensity;
    public LayoutDirection layerLayoutDirection;
    public LayerPositionalProperties layerPositionalProperties;
    public final LayoutNode layoutNode;
    public MutableObjectIntMap oldAlignmentLines;
    public boolean released;
    public boolean wasLayerBlockInvoked;
    public NodeCoordinator wrapped;
    public NodeCoordinator wrappedBy;
    public float zIndex;
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    public static final float[] tmpMatrix = Matrix.m442constructorimpl$default();
    public static final TouchBoundsExpansion.Companion PointerInputSource = new TouchBoundsExpansion.Companion(1);
    public static final TouchBoundsExpansion.Companion SemanticsSource = new TouchBoundsExpansion.Companion(2);
    public float lastLayerAlpha = 0.8f;
    public long position = 0;
    public Shape lastShape = BrushKt.RectangleShape;
    public final NodeCoordinator$invalidateParentLayer$1 invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this, 0);

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
        this.layerDensity = layoutNode.density;
        this.layerLayoutDirection = layoutNode.layoutDirection;
    }

    public static NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator nodeCoordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        return (lookaheadLayoutCoordinates == null || (nodeCoordinator = lookaheadLayoutCoordinates.lookaheadDelegate.coordinator) == null) ? (NodeCoordinator) layoutCoordinates : nodeCoordinator;
    }

    public final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        long j = this.position;
        float f = (int) (j >> 32);
        mutableRect.left -= f;
        mutableRect.right -= f;
        float f2 = (int) (j & 4294967295L);
        mutableRect.top -= f2;
        mutableRect.bottom -= f2;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
            float[] fArrM605getInverseMatrix3i98HWw = graphicsLayerOwnerLayer.m605getInverseMatrix3i98HWw();
            if (!graphicsLayerOwnerLayer.isIdentity) {
                if (fArrM605getInverseMatrix3i98HWw == null) {
                    mutableRect.left = 0.0f;
                    mutableRect.top = 0.0f;
                    mutableRect.right = 0.0f;
                    mutableRect.bottom = 0.0f;
                } else {
                    Matrix.m444mapimpl(fArrM605getInverseMatrix3i98HWw, mutableRect);
                }
            }
            if (this.isClipping && z) {
                long j2 = this.measuredSize;
                mutableRect.intersect(0.0f, 0.0f, (int) (j2 >> 32), (int) (j2 & 4294967295L));
            }
        }
    }

    /* JADX INFO: renamed from: ancestorToLocal-S_NoaFU, reason: not valid java name */
    public final long m566ancestorToLocalS_NoaFU(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        return (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) ? m569fromParentPosition8S9VItk(j) : m569fromParentPosition8S9VItk(nodeCoordinator2.m566ancestorToLocalS_NoaFU(nodeCoordinator, j));
    }

    /* JADX INFO: renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    public final long m567calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - getMeasuredWidth();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - getMeasuredHeight();
        float fMax = Math.max(0.0f, fIntBitsToFloat / 2.0f);
        return (((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat2 / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32);
    }

    /* JADX INFO: renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    public final float m568distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() >= Float.intBitsToFloat((int) (j2 >> 32)) && getMeasuredHeight() >= Float.intBitsToFloat((int) (j2 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jM567calculateMinimumTouchTargetPaddingE7KxVPU = m567calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM567calculateMinimumTouchTargetPaddingE7KxVPU >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM567calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat3 < 0.0f ? -fIntBitsToFloat3 : fIntBitsToFloat3 - getMeasuredWidth());
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Math.max(0.0f, fIntBitsToFloat4 < 0.0f ? -fIntBitsToFloat4 : fIntBitsToFloat4 - getMeasuredHeight()))) & 4294967295L) | (((long) Float.floatToRawIntBits(fMax)) << 32);
        if (fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) {
            int i = (int) (jFloatToRawIntBits >> 32);
            if (Float.intBitsToFloat(i) <= fIntBitsToFloat) {
                int i2 = (int) (jFloatToRawIntBits & 4294967295L);
                if (Float.intBitsToFloat(i2) <= fIntBitsToFloat2) {
                    float fIntBitsToFloat5 = Float.intBitsToFloat(i);
                    float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
                    return (fIntBitsToFloat6 * fIntBitsToFloat6) + (fIntBitsToFloat5 * fIntBitsToFloat5);
                }
            }
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null) {
            long j = this.position;
            float f = (int) (j >> 32);
            float f2 = (int) (j & 4294967295L);
            canvas.translate(f, f2);
            drawContainedDrawModifiers(canvas, graphicsLayer);
            canvas.translate(-f, -f2);
            return;
        }
        GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
        CanvasDrawScope canvasDrawScope = graphicsLayerOwnerLayer.scope;
        graphicsLayerOwnerLayer.updateDisplayList();
        graphicsLayerOwnerLayer.drawnWithEnabledZ = graphicsLayerOwnerLayer.graphicsLayer.impl.getShadowElevation() > 0.0f;
        MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
        menuHostHelper.setCanvas(canvas);
        menuHostHelper.mMenuProviders = graphicsLayer;
        GraphicsLayerKt.drawLayer(canvasDrawScope, graphicsLayerOwnerLayer.graphicsLayer);
    }

    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Canvas canvas2;
        GraphicsLayer graphicsLayer2;
        Modifier.Node nodeM571headH91voCI = m571headH91voCI(4);
        if (nodeM571headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
            return;
        }
        LayoutNode layoutNode = this.layoutNode;
        layoutNode.getClass();
        LayoutNodeDrawScope sharedDrawScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSharedDrawScope();
        long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(this.measuredSize);
        sharedDrawScope.getClass();
        MutableVector mutableVector = null;
        while (nodeM571headH91voCI != null) {
            if (nodeM571headH91voCI instanceof DrawModifierNode) {
                canvas2 = canvas;
                graphicsLayer2 = graphicsLayer;
                sharedDrawScope.m551drawDirecteZhPAX0$ui(canvas2, jM724toSizeozmzZPI, this, (DrawModifierNode) nodeM571headH91voCI, graphicsLayer2);
            } else {
                canvas2 = canvas;
                graphicsLayer2 = graphicsLayer;
                if ((nodeM571headH91voCI.kindSet & 4) != 0 && (nodeM571headH91voCI instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node node = ((DelegatingNode) nodeM571headH91voCI).delegate; node != null; node = node.child) {
                        if ((node.kindSet & 4) != 0) {
                            i++;
                            if (i == 1) {
                                nodeM571headH91voCI = node;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                }
                                if (nodeM571headH91voCI != null) {
                                    mutableVector.add(nodeM571headH91voCI);
                                    nodeM571headH91voCI = null;
                                }
                                mutableVector.add(node);
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                canvas = canvas2;
                graphicsLayer = graphicsLayer2;
            }
            nodeM571headH91voCI = HitTestResultKt.access$pop(mutableVector);
            canvas = canvas2;
            graphicsLayer = graphicsLayer2;
        }
    }

    public abstract void ensureLookaheadDelegateCreated();

    public final NodeCoordinator findCommonAncestor$ui(NodeCoordinator nodeCoordinator) {
        LayoutNode parent$ui = nodeCoordinator.layoutNode;
        LayoutNode layoutNode = this.layoutNode;
        if (parent$ui == layoutNode) {
            Modifier.Node tail = nodeCoordinator.getTail();
            Modifier.Node tail2 = getTail();
            if (!tail2.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node node = tail2.node.parent; node != null; node = node.parent) {
                if ((node.kindSet & 2) != 0 && node == tail) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (parent$ui.depth > layoutNode.depth) {
            parent$ui = parent$ui.getParent$ui();
        }
        LayoutNode parent$ui2 = layoutNode;
        while (parent$ui2.depth > parent$ui.depth) {
            parent$ui2 = parent$ui2.getParent$ui();
        }
        while (parent$ui != parent$ui2) {
            parent$ui = parent$ui.getParent$ui();
            parent$ui2 = parent$ui2.getParent$ui();
            if (parent$ui == null || parent$ui2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (parent$ui2 != layoutNode) {
            if (parent$ui != nodeCoordinator.layoutNode) {
                return (InnerNodeCoordinator) parent$ui.nodes.innerCoordinator;
            }
            return nodeCoordinator;
        }
        return this;
    }

    /* JADX INFO: renamed from: fromParentPosition-8S9VItk, reason: not valid java name */
    public final long m569fromParentPosition8S9VItk(long j) {
        long j2 = this.position;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) - ((int) (j2 >> 32)))) << 32);
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ((GraphicsLayerOwnerLayer) ownedLayer).m607mapOffset8S9VItk(jFloatToRawIntBits, true) : jFloatToRawIntBits;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.layoutNode.density.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.layoutNode.density.getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public final LayoutDirection getLayoutDirection() {
        return this.layoutNode.layoutDirection;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final MeasureResult getMeasureResult$ui() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m570getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo93toSizeXkaWNTQ(this.layoutNode.viewConfiguration.mo550getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measurable
    public final Object getParentData() {
        LayoutNode layoutNode = this.layoutNode;
        if (!layoutNode.nodes.m565hasH91voCI$ui(64)) {
            return null;
        }
        getTail();
        Object objModifyParentData = null;
        for (Modifier.Node node = (TailModifierNode) layoutNode.nodes.tail; node != null; node = node.parent) {
            if ((node.kindSet & 64) != 0) {
                ?? Access$pop = node;
                ?? mutableVector = 0;
                while (Access$pop != 0) {
                    if (Access$pop instanceof ParentDataModifierNode) {
                        objModifyParentData = ((ParentDataModifierNode) Access$pop).modifyParentData(objModifyParentData);
                    } else if ((Access$pop.kindSet & 64) != 0 && (Access$pop instanceof DelegatingNode)) {
                        Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                        int i = 0;
                        Access$pop = Access$pop;
                        mutableVector = mutableVector;
                        while (node2 != null) {
                            if ((node2.kindSet & 64) != 0) {
                                i++;
                                if (i == 1) {
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
                            }
                            node2 = node2.child;
                            Access$pop = Access$pop;
                            mutableVector = mutableVector;
                        }
                        if (i == 1) {
                        }
                    }
                    Access$pop = HitTestResultKt.access$pop(mutableVector);
                }
            }
        }
        return objModifyParentData;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        boolean z = getTail().isAttached;
        LayoutNode layoutNode = this.layoutNode;
        if (!z) {
            StringBuilder sb = new StringBuilder("LayoutCoordinate operations are only valid when isAttached is true");
            for (LayoutNode parent$ui = layoutNode; parent$ui != null; parent$ui = parent$ui.getParent$ui()) {
                sb.append("\n|");
                sb.append(parent$ui);
                sb.append(" isAttached=");
                sb.append(parent$ui.isAttached());
                sb.append(" modifier=");
                sb.append(parent$ui._modifier);
                sb.append(" tail=");
                sb.append(getTail());
            }
            InlineClassHelperKt.throwIllegalStateException(sb.toString());
        }
        onCoordinatesUsed$ui();
        return ((NodeCoordinator) layoutNode.nodes.outerCoordinator).wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* JADX INFO: renamed from: getPosition-nOcc-ac */
    public final long mo554getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo522getSizeYbymL2g() {
        return this.measuredSize;
    }

    public abstract Modifier.Node getTail();

    /* JADX INFO: renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m571headH91voCI(int i) {
        boolean zM581getIncludeSelfInTraversalH91voCI = NodeKindKt.m581getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!zM581getIncludeSelfInTraversalH91voCI && (tail = tail.parent) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM581getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & i) != 0; nodeHeadNode = nodeHeadNode.child) {
            if ((nodeHeadNode.kindSet & i) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        NodeChain nodeChain = this.layoutNode.nodes;
        if (((NodeCoordinator) nodeChain.outerCoordinator) == this) {
            return (Modifier.Node) nodeChain.head;
        }
        if (!z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                return nodeCoordinator.getTail();
            }
            return null;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || (tail = nodeCoordinator2.getTail()) == null) {
            return null;
        }
        return tail.child;
    }

    /* JADX INFO: renamed from: hit-5ShdDok, reason: not valid java name */
    public final void m572hit5ShdDok(Modifier.Node node, TouchBoundsExpansion.Companion companion, long j, HitTestResult hitTestResult, int i, boolean z) {
        if (node == null) {
            mo548hitTestChildqzLsGqo(companion, j, hitTestResult, i, z);
            return;
        }
        if (!companion.shouldHitTest(node)) {
            m572hit5ShdDok(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z);
            return;
        }
        int i2 = hitTestResult.hitDepth;
        MutableObjectList mutableObjectList = hitTestResult.values;
        hitTestResult.removeNodesInRange(i2 + 1, mutableObjectList._size);
        hitTestResult.hitDepth++;
        mutableObjectList.add(node);
        hitTestResult.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(-1.0f, z, false));
        m572hit5ShdDok(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z);
        hitTestResult.hitDepth = i2;
    }

    /* JADX INFO: renamed from: hitNear-Fh5PU_I, reason: not valid java name */
    public final void m573hitNearFh5PU_I(Modifier.Node node, TouchBoundsExpansion.Companion companion, long j, HitTestResult hitTestResult, int i, boolean z, float f) {
        if (node == null) {
            mo548hitTestChildqzLsGqo(companion, j, hitTestResult, i, z);
            return;
        }
        if (!companion.shouldHitTest(node)) {
            m573hitNearFh5PU_I(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f);
            return;
        }
        int i2 = hitTestResult.hitDepth;
        MutableObjectList mutableObjectList = hitTestResult.values;
        hitTestResult.removeNodesInRange(i2 + 1, mutableObjectList._size);
        hitTestResult.hitDepth++;
        mutableObjectList.add(node);
        hitTestResult.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(f, z, false));
        m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f, true);
        hitTestResult.hitDepth = i2;
    }

    /* JADX INFO: renamed from: hitTest-qzLsGqo, reason: not valid java name */
    public final void m574hitTestqzLsGqo(TouchBoundsExpansion.Companion companion, long j, HitTestResult hitTestResult, int i, boolean z) {
        boolean z2;
        boolean z3;
        Modifier.Node nodeM571headH91voCI = m571headH91voCI(companion.m582entityTypeOLwlOKw());
        if (!m580withinLayerBoundsk4lQ0M(j)) {
            if (i == 1) {
                float fM568distanceInMinimumTouchTargettz77jQw = m568distanceInMinimumTouchTargettz77jQw(j, m570getMinimumTouchTargetSizeNHjbRc());
                if ((Float.floatToRawIntBits(fM568distanceInMinimumTouchTargettz77jQw) & Integer.MAX_VALUE) < 2139095040) {
                    if (hitTestResult.hitDepth != AppCompatHintHelper.getLastIndex(hitTestResult)) {
                        if (HitTestResultKt.m543compareTo9YPOF3E(hitTestResult.m541findBestHitDistancefn2tFes(), HitTestResultKt.DistanceAndFlags(fM568distanceInMinimumTouchTargettz77jQw, false, false)) <= 0) {
                            return;
                        }
                    }
                    m573hitNearFh5PU_I(nodeM571headH91voCI, companion, j, hitTestResult, i, false, fM568distanceInMinimumTouchTargettz77jQw);
                    return;
                }
                return;
            }
            return;
        }
        if (nodeM571headH91voCI == null) {
            mo548hitTestChildqzLsGqo(companion, j, hitTestResult, i, z);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        if (fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < getMeasuredWidth() && fIntBitsToFloat2 < getMeasuredHeight()) {
            m572hit5ShdDok(nodeM571headH91voCI, companion, j, hitTestResult, i, z);
            return;
        }
        float fM568distanceInMinimumTouchTargettz77jQw2 = i == 1 ? m568distanceInMinimumTouchTargettz77jQw(j, m570getMinimumTouchTargetSizeNHjbRc()) : Float.POSITIVE_INFINITY;
        if ((Float.floatToRawIntBits(fM568distanceInMinimumTouchTargettz77jQw2) & Integer.MAX_VALUE) < 2139095040) {
            if (hitTestResult.hitDepth != AppCompatHintHelper.getLastIndex(hitTestResult)) {
                z2 = z;
                if (HitTestResultKt.m543compareTo9YPOF3E(hitTestResult.m541findBestHitDistancefn2tFes(), HitTestResultKt.DistanceAndFlags(fM568distanceInMinimumTouchTargettz77jQw2, z2, false)) > 0) {
                }
                m575outOfBoundsHit8NAm7pk(nodeM571headH91voCI, companion, j, hitTestResult, i, z2, fM568distanceInMinimumTouchTargettz77jQw2, z3);
            }
            z2 = z;
            z3 = true;
            m575outOfBoundsHit8NAm7pk(nodeM571headH91voCI, companion, j, hitTestResult, i, z2, fM568distanceInMinimumTouchTargettz77jQw2, z3);
        }
        z2 = z;
        z3 = false;
        m575outOfBoundsHit8NAm7pk(nodeM571headH91voCI, companion, j, hitTestResult, i, z2, fM568distanceInMinimumTouchTargettz77jQw2, z3);
    }

    /* JADX INFO: renamed from: hitTestChild-qzLsGqo */
    public void mo548hitTestChildqzLsGqo(TouchBoundsExpansion.Companion companion, long j, HitTestResult hitTestResult, int i, boolean z) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m574hitTestqzLsGqo(companion, nodeCoordinator.m569fromParentPosition8S9VItk(j), hitTestResult, i, z);
        }
    }

    public final void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached() {
        return getTail().isAttached;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !this.layoutNode.isAttached()) ? false : true;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!layoutCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + layoutCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        MutableRect mutableRect = this._rectCache;
        if (mutableRect == null) {
            mutableRect = new MutableRect();
            this._rectCache = mutableRect;
        }
        mutableRect.left = 0.0f;
        mutableRect.top = 0.0f;
        mutableRect.right = (int) (layoutCoordinates.mo522getSizeYbymL2g() >> 32);
        mutableRect.bottom = (int) (layoutCoordinates.mo522getSizeYbymL2g() & 4294967295L);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui) {
            coordinator.rectInParent$ui(mutableRect, z, false);
            if (mutableRect.isEmpty()) {
                return Rect.Zero;
            }
            coordinator = coordinator.wrappedBy;
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui, mutableRect, z);
        return new Rect(mutableRect.left, mutableRect.top, mutableRect.right, mutableRect.bottom);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public final long mo523localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo524localPositionOfS_NoaFU(layoutCoordinates, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public final long mo524localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadLayoutCoordinates lookaheadLayoutCoordinates = (LookaheadLayoutCoordinates) layoutCoordinates;
            lookaheadLayoutCoordinates.lookaheadDelegate.coordinator.onCoordinatesUsed$ui();
            return lookaheadLayoutCoordinates.mo524localPositionOfS_NoaFU(this, j ^ (-9223372034707292160L)) ^ (-9223372034707292160L);
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui) {
            OwnedLayer ownedLayer = coordinator.layer;
            if (ownedLayer != null) {
                j = ((GraphicsLayerOwnerLayer) ownedLayer).m607mapOffset8S9VItk(j, false);
            }
            j = IntOffsetKt.m716plusNvtHpc(j, coordinator.position);
            coordinator = coordinator.wrappedBy;
        }
        return m566ancestorToLocalS_NoaFU(nodeCoordinatorFindCommonAncestor$ui, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public final long mo525localToRootMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui();
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            LayoutNode layoutNode = nodeCoordinator.layoutNode;
            if (nodeCoordinator == ((NodeCoordinator) layoutNode.nodes.outerCoordinator) && !layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot) {
                long jM618getOffsetFromRectListForBjo55l4 = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().m618getOffsetFromRectListForBjo55l4(layoutNode);
                if (!IntOffset.m712equalsimpl0(jM618getOffsetFromRectListForBjo55l4, 9223372034707292159L)) {
                    return IntOffsetKt.m716plusNvtHpc(j, jM618getOffsetFromRectListForBjo55l4);
                }
            }
            OwnedLayer ownedLayer = nodeCoordinator.layer;
            if (ownedLayer != null) {
                j = ((GraphicsLayerOwnerLayer) ownedLayer).m607mapOffset8S9VItk(j, false);
            }
            j = IntOffsetKt.m716plusNvtHpc(j, nodeCoordinator.position);
        }
        return j;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public final long mo526localToScreenMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return ((AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode)).m590localToScreenMKHz9U(mo525localToRootMKHz9U(j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public final long mo527localToWindowMKHz9U(long j) {
        long jMo525localToRootMKHz9U = mo525localToRootMKHz9U(j);
        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode);
        androidComposeView.recalculateWindowPosition();
        return Matrix.m443mapMKHz9U(jMo525localToRootMKHz9U, androidComposeView.viewToWindowMatrix);
    }

    public final void onCoordinatesUsed$ui() {
        this.layoutNode.layoutDelegate.onCoordinatesUsed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public final void onMeasured() {
        Modifier.Node tail;
        boolean zM581getIncludeSelfInTraversalH91voCI = NodeKindKt.m581getIncludeSelfInTraversalH91voCI(128);
        Modifier.Node nodeHeadNode = headNode(zM581getIncludeSelfInTraversalH91voCI);
        if (nodeHeadNode == null || (nodeHeadNode.node.aggregateChildKindSet & 128) == 0) {
            return;
        }
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (!zM581getIncludeSelfInTraversalH91voCI) {
                tail = getTail().parent;
                if (tail == null) {
                }
                Unit unit = Unit.INSTANCE;
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
            tail = getTail();
            for (Modifier.Node nodeHeadNode2 = headNode(zM581getIncludeSelfInTraversalH91voCI); nodeHeadNode2 != null && (nodeHeadNode2.aggregateChildKindSet & 128) != 0; nodeHeadNode2 = nodeHeadNode2.child) {
                if ((nodeHeadNode2.kindSet & 128) != 0) {
                    ?? Access$pop = nodeHeadNode2;
                    ?? mutableVector = 0;
                    while (Access$pop != 0) {
                        if (Access$pop instanceof MeasuredSizeAwareModifierNode) {
                            ((MeasuredSizeAwareModifierNode) Access$pop).mo66onRemeasuredozmzZPI(this.measuredSize);
                        } else if ((Access$pop.kindSet & 128) != 0 && (Access$pop instanceof DelegatingNode)) {
                            Modifier.Node node = ((DelegatingNode) Access$pop).delegate;
                            int i = 0;
                            Access$pop = Access$pop;
                            mutableVector = mutableVector;
                            while (node != null) {
                                if ((node.kindSet & 128) != 0) {
                                    i++;
                                    if (i == 1) {
                                        mutableVector = mutableVector;
                                        Access$pop = node;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Access$pop != 0) {
                                            mutableVector.add(Access$pop);
                                            Access$pop = 0;
                                        }
                                        mutableVector.add(node);
                                    }
                                }
                                node = node.child;
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                            }
                        }
                        Access$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                }
                if (nodeHeadNode2 == tail) {
                    break;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public final void onPlaced() {
        boolean zM581getIncludeSelfInTraversalH91voCI = NodeKindKt.m581getIncludeSelfInTraversalH91voCI(4194304);
        Modifier.Node tail = getTail();
        if (!zM581getIncludeSelfInTraversalH91voCI && (tail = tail.parent) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM581getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & 4194304) != 0; nodeHeadNode = nodeHeadNode.child) {
            if ((nodeHeadNode.kindSet & 4194304) != 0) {
                ?? Access$pop = nodeHeadNode;
                ?? mutableVector = 0;
                while (Access$pop != 0) {
                    if (Access$pop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) Access$pop).onPlaced(this);
                    } else if ((Access$pop.kindSet & 4194304) != 0 && (Access$pop instanceof DelegatingNode)) {
                        Modifier.Node node = ((DelegatingNode) Access$pop).delegate;
                        int i = 0;
                        Access$pop = Access$pop;
                        mutableVector = mutableVector;
                        while (node != null) {
                            if ((node.kindSet & 4194304) != 0) {
                                i++;
                                if (i == 1) {
                                    mutableVector = mutableVector;
                                    Access$pop = node;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Access$pop != 0) {
                                        mutableVector.add(Access$pop);
                                        Access$pop = 0;
                                    }
                                    mutableVector.add(node);
                                }
                            }
                            node = node.child;
                            Access$pop = Access$pop;
                            mutableVector = mutableVector;
                        }
                        if (i == 1) {
                        }
                    }
                    Access$pop = HitTestResultKt.access$pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
        if (IntOffset.m712equalsimpl0(this.position, 0L)) {
            return;
        }
        this.layoutNode.onCoordinatorRectChanged$ui(this);
    }

    public final void onUnplaced() {
        boolean zM581getIncludeSelfInTraversalH91voCI = NodeKindKt.m581getIncludeSelfInTraversalH91voCI(1048576);
        Modifier.Node nodeHeadNode = headNode(zM581getIncludeSelfInTraversalH91voCI);
        if (nodeHeadNode == null || (nodeHeadNode.node.aggregateChildKindSet & 1048576) == 0) {
            return;
        }
        Modifier.Node tail = getTail();
        if (!zM581getIncludeSelfInTraversalH91voCI && (tail = tail.parent) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode2 = headNode(zM581getIncludeSelfInTraversalH91voCI); nodeHeadNode2 != null && (nodeHeadNode2.aggregateChildKindSet & 1048576) != 0; nodeHeadNode2 = nodeHeadNode2.child) {
            if ((nodeHeadNode2.kindSet & 1048576) != 0) {
                Modifier.Node nodeAccess$pop = nodeHeadNode2;
                MutableVector mutableVector = null;
                while (nodeAccess$pop != null) {
                    if ((nodeAccess$pop.kindSet & 1048576) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node node = ((DelegatingNode) nodeAccess$pop).delegate; node != null; node = node.child) {
                            if ((node.kindSet & 1048576) != 0) {
                                i++;
                                if (i == 1) {
                                    nodeAccess$pop = node;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (nodeAccess$pop != null) {
                                        mutableVector.add(nodeAccess$pop);
                                        nodeAccess$pop = null;
                                    }
                                    mutableVector.add(node);
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                }
            }
            if (nodeHeadNode2 == tail) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x01da A[PHI: r4
      0x01da: PHI (r4v12 ??) = (r4v1 ??), (r4v1 ??), (r4v14 ??) binds: [B:55:0x01a4, B:57:0x01a8, B:71:0x01d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX INFO: renamed from: outOfBoundsHit-8NAm7pk, reason: not valid java name */
    public final void m575outOfBoundsHit8NAm7pk(Modifier.Node node, TouchBoundsExpansion.Companion companion, long j, HitTestResult hitTestResult, int i, boolean z, float f, boolean z2) {
        ?? Access$pop;
        if (node == null) {
            mo548hitTestChildqzLsGqo(companion, j, hitTestResult, i, z);
            return;
        }
        if (!companion.shouldHitTest(node)) {
            m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f, z2);
            return;
        }
        int i2 = i;
        char c = 3;
        if (i2 == 3 || i2 == 4) {
            ?? r3 = node;
            ?? mutableVector = 0;
            while (r3 != 0) {
                int i3 = 0;
                if (r3 instanceof PointerInputModifierNode) {
                    long jMo31getTouchBoundsExpansionRZrCHBk = ((PointerInputModifierNode) r3).mo31getTouchBoundsExpansionRZrCHBk();
                    int i4 = (int) (j >> 32);
                    float fIntBitsToFloat = Float.intBitsToFloat(i4);
                    LayoutNode layoutNode = this.layoutNode;
                    LayoutDirection layoutDirection = layoutNode.layoutDirection;
                    int i5 = TouchBoundsExpansion.$r8$clinit;
                    long j2 = Long.MIN_VALUE & jMo31getTouchBoundsExpansionRZrCHBk;
                    LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                    if (fIntBitsToFloat < (-((j2 == 0 || layoutDirection == layoutDirection2) ? TouchBoundsExpansion.Companion.access$unpack(0, jMo31getTouchBoundsExpansionRZrCHBk) : TouchBoundsExpansion.Companion.access$unpack(2, jMo31getTouchBoundsExpansionRZrCHBk)))) {
                        break;
                    }
                    if (Float.intBitsToFloat(i4) >= getMeasuredWidth() + ((j2 == 0 || layoutNode.layoutDirection == layoutDirection2) ? TouchBoundsExpansion.Companion.access$unpack(2, jMo31getTouchBoundsExpansionRZrCHBk) : TouchBoundsExpansion.Companion.access$unpack(0, jMo31getTouchBoundsExpansionRZrCHBk))) {
                        break;
                    }
                    int i6 = (int) (j & 4294967295L);
                    if (Float.intBitsToFloat(i6) < (-TouchBoundsExpansion.Companion.access$unpack(1, jMo31getTouchBoundsExpansionRZrCHBk))) {
                        break;
                    }
                    if (Float.intBitsToFloat(i6) >= TouchBoundsExpansion.Companion.access$unpack(3, jMo31getTouchBoundsExpansionRZrCHBk) + getMeasuredHeight()) {
                        break;
                    }
                    MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
                    MutableObjectList mutableObjectList = hitTestResult.values;
                    if (hitTestResult.hitDepth == AppCompatHintHelper.getLastIndex(hitTestResult)) {
                        int i7 = hitTestResult.hitDepth;
                        hitTestResult.removeNodesInRange(i7 + 1, mutableObjectList._size);
                        hitTestResult.hitDepth++;
                        mutableObjectList.add(node);
                        mutableLongList.add(HitTestResultKt.DistanceAndFlags(0.0f, z, true));
                        m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i2, z, f, z2);
                        Unit unit = Unit.INSTANCE;
                        hitTestResult.hitDepth = i7;
                        return;
                    }
                    long jM541findBestHitDistancefn2tFes = hitTestResult.m541findBestHitDistancefn2tFes();
                    int i8 = hitTestResult.hitDepth;
                    if (!HitTestResultKt.m545isInExpandedBoundsimpl(jM541findBestHitDistancefn2tFes)) {
                        if (HitTestResultKt.m544getDistanceimpl(jM541findBestHitDistancefn2tFes) > 0.0f) {
                            int i9 = hitTestResult.hitDepth;
                            hitTestResult.removeNodesInRange(i9 + 1, mutableObjectList._size);
                            hitTestResult.hitDepth++;
                            mutableObjectList.add(node);
                            mutableLongList.add(HitTestResultKt.DistanceAndFlags(0.0f, z, true));
                            m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f, z2);
                            Unit unit2 = Unit.INSTANCE;
                            hitTestResult.hitDepth = i9;
                            return;
                        }
                        return;
                    }
                    int lastIndex = AppCompatHintHelper.getLastIndex(hitTestResult);
                    hitTestResult.hitDepth = lastIndex;
                    hitTestResult.removeNodesInRange(lastIndex + 1, mutableObjectList._size);
                    hitTestResult.hitDepth++;
                    mutableObjectList.add(node);
                    mutableLongList.add(HitTestResultKt.DistanceAndFlags(0.0f, z, true));
                    m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f, z2);
                    Unit unit3 = Unit.INSTANCE;
                    hitTestResult.hitDepth = lastIndex;
                    if (HitTestResultKt.m544getDistanceimpl(hitTestResult.m541findBestHitDistancefn2tFes()) < 0.0f) {
                        hitTestResult.removeNodesInRange(i8 + 1, hitTestResult.hitDepth + 1);
                    }
                    hitTestResult.hitDepth = i8;
                    return;
                }
                char c2 = c;
                if ((r3.kindSet & 16) == 0 || !(r3 instanceof DelegatingNode)) {
                    Access$pop = r3;
                    mutableVector = mutableVector;
                    Access$pop = HitTestResultKt.access$pop(mutableVector);
                } else {
                    Modifier.Node node2 = ((DelegatingNode) r3).delegate;
                    while (node2 != null) {
                        if ((node2.kindSet & 16) != 0) {
                            i3++;
                            if (i3 == 1) {
                                Access$pop = r3;
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
                            Access$pop = r3;
                            mutableVector = mutableVector;
                        }
                        node2 = node2.child;
                        Access$pop = Access$pop;
                        mutableVector = mutableVector;
                    }
                    if (i3 == 1) {
                        Access$pop = r3;
                        mutableVector = mutableVector;
                    } else {
                        Access$pop = r3;
                        mutableVector = mutableVector;
                        Access$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                }
                i2 = i;
                c = c2;
                r3 = Access$pop;
                mutableVector = mutableVector;
            }
        }
        if (z2) {
            m573hitNearFh5PU_I(node, companion, j, hitTestResult, i, z, f);
        } else {
            m577speculativeHitFh5PU_I(node, companion, j, hitTestResult, i, z, f);
        }
    }

    public abstract void performDraw(Canvas canvas, GraphicsLayer graphicsLayer);

    /* JADX INFO: renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    public final void m576placeSelfMLgxB_4(long j, float f, Function1 function1) {
        updateLayerBlock(function1, false);
        boolean zM712equalsimpl0 = IntOffset.m712equalsimpl0(this.position, j);
        LayoutNode layoutNode = this.layoutNode;
        if (!zM712equalsimpl0) {
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).voteFrameRate(-4.0f);
            this.position = j;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ((GraphicsLayerOwnerLayer) ownedLayer).m608movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            layoutNode.onCoordinatorRectChanged$ui(this);
            LookaheadCapablePlaceable.invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = layoutNode.owner;
            if (owner != null) {
                ((AndroidComposeView) owner).onLayoutChange(layoutNode);
            }
        }
        this.zIndex = f;
        if (this == ((NodeCoordinator) layoutNode.nodes.outerCoordinator)) {
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().recalculateRectIfDirty(layoutNode);
        }
        if (this.isPlacingForAlignment) {
            return;
        }
        captureRulersIfNeeded$ui(getMeasureResult$ui());
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    public final void rectInParent$ui(MutableRect mutableRect, boolean z, boolean z2) {
        long jFloatToRawIntBits;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long jM570getMinimumTouchTargetSizeNHjbRc = m570getMinimumTouchTargetSizeNHjbRc();
                    float f = mutableRect.left;
                    float f2 = mutableRect.top;
                    if (mutableRect.right >= 0.0f) {
                        long j = this.measuredSize;
                        if (f > ((int) (j >> 32)) || mutableRect.bottom < 0.0f || f2 > ((int) (j & 4294967295L))) {
                            jFloatToRawIntBits = 0;
                        } else {
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (jM570getMinimumTouchTargetSizeNHjbRc >> 32));
                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM570getMinimumTouchTargetSizeNHjbRc & 4294967295L));
                            float f3 = (fIntBitsToFloat - (mutableRect.right - mutableRect.left)) / 2.0f;
                            if (f3 > 0.0f) {
                                f -= f3;
                            } else {
                                float f4 = (-fIntBitsToFloat) / 2.0f;
                                if (f < f4) {
                                    f = f4;
                                }
                            }
                            float f5 = (fIntBitsToFloat2 - (mutableRect.bottom - mutableRect.top)) / 2.0f;
                            if (f5 > 0.0f) {
                                f2 -= f5;
                            } else {
                                float f6 = (-fIntBitsToFloat2) / 2.0f;
                                if (f2 < f6) {
                                    f2 = f6;
                                }
                            }
                            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
                        }
                    } else {
                        jFloatToRawIntBits = 0;
                    }
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
                    long j2 = this.measuredSize;
                    float f7 = (int) (j2 >> 32);
                    int i = (int) (jM570getMinimumTouchTargetSizeNHjbRc >> 32);
                    float f8 = (int) (j2 & 4294967295L);
                    int i2 = (int) (jM570getMinimumTouchTargetSizeNHjbRc & 4294967295L);
                    mutableRect.intersect(fIntBitsToFloat3, fIntBitsToFloat4, Math.min(Float.intBitsToFloat(i) + f7, Math.max(f7, Float.intBitsToFloat(i) + fIntBitsToFloat3)), Math.min(Float.intBitsToFloat(i2) + f8, Math.max(f8, Float.intBitsToFloat(i2) + fIntBitsToFloat4)));
                } else if (z) {
                    long j3 = this.measuredSize;
                    mutableRect.intersect(0.0f, 0.0f, (int) (j3 >> 32), (int) (j3 & 4294967295L));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
            float[] fArrM606getMatrixsQKQjiQ = graphicsLayerOwnerLayer.m606getMatrixsQKQjiQ();
            if (!graphicsLayerOwnerLayer.isIdentity) {
                if (fArrM606getMatrixsQKQjiQ == null) {
                    mutableRect.left = 0.0f;
                    mutableRect.top = 0.0f;
                    mutableRect.right = 0.0f;
                    mutableRect.bottom = 0.0f;
                } else {
                    Matrix.m444mapimpl(fArrM606getMatrixsQKQjiQ, mutableRect);
                }
            }
        }
        long j4 = this.position;
        float f9 = (int) (j4 >> 32);
        mutableRect.left += f9;
        mutableRect.right += f9;
        float f10 = (int) (j4 & 4294967295L);
        mutableRect.top += f10;
        mutableRect.bottom += f10;
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            updateLayerBlock(null, false);
            this.layoutNode.requestRelayout$ui(false);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void replace$ui() {
        mo521placeAtf8xVGno(this.position, this.zIndex, this.layerBlock);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public final long mo528screenToLocalMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return mo524localPositionOfS_NoaFU(RulerKt.findRootCoordinates(this), ((AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode)).m593screenToLocalMKHz9U(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [androidx.compose.runtime.collection.MutableVector] */
    public final void setMeasureResult$ui(MeasureResult measureResult) {
        NodeCoordinator nodeCoordinator;
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            LayoutNode layoutNode = this.layoutNode;
            int i = 0;
            if (measureResult2 == null || measureResult.getWidth() != measureResult2.getWidth() || measureResult.getHeight() != measureResult2.getHeight()) {
                int width = measureResult.getWidth();
                int height = measureResult.getHeight();
                OwnedLayer ownedLayer = this.layer;
                if (ownedLayer != null) {
                    ((GraphicsLayerOwnerLayer) ownedLayer).m609resizeozmzZPI((((long) width) << 32) | (((long) height) & 4294967295L));
                } else if (layoutNode.isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
                    nodeCoordinator.invalidateLayer();
                }
                m534setMeasuredSizeozmzZPI((((long) height) & 4294967295L) | (((long) width) << 32));
                if (this.layerBlock != null) {
                    updateLayerParameters(false);
                }
                boolean zM581getIncludeSelfInTraversalH91voCI = NodeKindKt.m581getIncludeSelfInTraversalH91voCI(4);
                Modifier.Node tail = getTail();
                if (zM581getIncludeSelfInTraversalH91voCI || (tail = tail.parent) != null) {
                    for (Modifier.Node nodeHeadNode = headNode(zM581getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & 4) != 0; nodeHeadNode = nodeHeadNode.child) {
                        if ((nodeHeadNode.kindSet & 4) != 0) {
                            ?? Access$pop = nodeHeadNode;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof DrawModifierNode) {
                                    ((DrawModifierNode) Access$pop).onMeasureResultChanged();
                                } else if ((Access$pop.kindSet & 4) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node = ((DelegatingNode) Access$pop).delegate;
                                    int i2 = 0;
                                    Access$pop = Access$pop;
                                    mutableVector = mutableVector;
                                    while (node != null) {
                                        if ((node.kindSet & 4) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                mutableVector = mutableVector;
                                                Access$pop = node;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector.add(node);
                                            }
                                        }
                                        node = node.child;
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Access$pop = HitTestResultKt.access$pop(mutableVector);
                            }
                        }
                        if (nodeHeadNode == tail) {
                            break;
                        }
                    }
                }
                Owner owner = layoutNode.owner;
                if (owner != null) {
                    ((AndroidComposeView) owner).onLayoutChange(layoutNode);
                }
                layoutNode.onCoordinatorRectChanged$ui(this);
            }
            MutableObjectIntMap mutableObjectIntMap = this.oldAlignmentLines;
            if ((mutableObjectIntMap == null || mutableObjectIntMap._size == 0) && measureResult.getAlignmentLines().isEmpty()) {
                return;
            }
            MutableObjectIntMap mutableObjectIntMap2 = this.oldAlignmentLines;
            Map alignmentLines = measureResult.getAlignmentLines();
            if (mutableObjectIntMap2 != null && mutableObjectIntMap2._size == alignmentLines.size()) {
                Object[] objArr = mutableObjectIntMap2.keys;
                int[] iArr = mutableObjectIntMap2.values;
                long[] jArr = mutableObjectIntMap2.metadata;
                int length = jArr.length - 2;
                if (length < 0) {
                    return;
                }
                int i3 = 0;
                loop0: while (true) {
                    long j = jArr[i3];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                        for (int i5 = i; i5 < i4; i5++) {
                            if ((255 & j) < 128) {
                                int i6 = (i3 << 3) + i5;
                                Object obj = objArr[i6];
                                int i7 = iArr[i6];
                                Integer num = (Integer) alignmentLines.get((AlignmentLine) obj);
                                if (num == null || num.intValue() != i7) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i4 != 8) {
                            return;
                        }
                    }
                    if (i3 == length) {
                        return;
                    }
                    i3++;
                    i = 0;
                }
            }
            layoutNode.layoutDelegate.measurePassDelegate.alignmentLines.onAlignmentsChanged();
            MutableObjectIntMap mutableObjectIntMap3 = this.oldAlignmentLines;
            if (mutableObjectIntMap3 == null) {
                MutableObjectIntMap mutableObjectIntMap4 = ObjectIntMapKt.EmptyObjectIntMap;
                mutableObjectIntMap3 = new MutableObjectIntMap();
                this.oldAlignmentLines = mutableObjectIntMap3;
            }
            mutableObjectIntMap3.clear();
            for (Map.Entry entry : measureResult.getAlignmentLines().entrySet()) {
                mutableObjectIntMap3.set(((Number) entry.getValue()).intValue(), entry.getKey());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX INFO: renamed from: speculativeHit-Fh5PU_I, reason: not valid java name */
    public final void m577speculativeHitFh5PU_I(Modifier.Node node, TouchBoundsExpansion.Companion companion, long j, HitTestResult hitTestResult, int i, boolean z, float f) {
        boolean z2;
        int i2;
        if (node == null) {
            mo548hitTestChildqzLsGqo(companion, j, hitTestResult, i, z);
            return;
        }
        if (!companion.shouldHitTest(node)) {
            m577speculativeHitFh5PU_I(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f);
            return;
        }
        switch (companion.$r8$classId) {
            case 1:
                ?? Access$pop = node;
                ?? mutableVector = 0;
                while (true) {
                    if (Access$pop != 0) {
                        if (Access$pop instanceof PointerInputModifierNode) {
                            z2 = ((PointerInputModifierNode) Access$pop).interceptOutOfBoundsChildEvents();
                            break;
                        } else if ((Access$pop.kindSet & 16) != 0 && (Access$pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                            int i3 = 0;
                            while (node2 != null) {
                                if ((node2.kindSet & 16) != 0) {
                                    i3++;
                                    if (i3 == 1) {
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
                            if (i3 == 1) {
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            } else {
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            }
                        }
                        Access$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                    break;
                }
            default:
                break;
        }
        if (!z2) {
            m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f, false);
            return;
        }
        MutableLongList mutableLongList = hitTestResult.distanceFromEdgeAndFlags;
        MutableObjectList mutableObjectList = hitTestResult.values;
        if (hitTestResult.hitDepth != AppCompatHintHelper.getLastIndex(hitTestResult)) {
            long jM541findBestHitDistancefn2tFes = hitTestResult.m541findBestHitDistancefn2tFes();
            int i4 = hitTestResult.hitDepth;
            int lastIndex = AppCompatHintHelper.getLastIndex(hitTestResult);
            hitTestResult.hitDepth = lastIndex;
            hitTestResult.removeNodesInRange(lastIndex + 1, mutableObjectList._size);
            hitTestResult.hitDepth++;
            mutableObjectList.add(node);
            mutableLongList.add(HitTestResultKt.DistanceAndFlags(f, z, false));
            m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f, false);
            Unit unit = Unit.INSTANCE;
            hitTestResult.hitDepth = lastIndex;
            long jM541findBestHitDistancefn2tFes2 = hitTestResult.m541findBestHitDistancefn2tFes();
            if (hitTestResult.hitDepth + 1 >= AppCompatHintHelper.getLastIndex(hitTestResult) || HitTestResultKt.m543compareTo9YPOF3E(jM541findBestHitDistancefn2tFes, jM541findBestHitDistancefn2tFes2) <= 0) {
                hitTestResult.removeNodesInRange(hitTestResult.hitDepth + 1, mutableObjectList._size);
            } else {
                hitTestResult.removeNodesInRange(i4 + 1, HitTestResultKt.m545isInExpandedBoundsimpl(jM541findBestHitDistancefn2tFes2) ? hitTestResult.hitDepth + 2 : hitTestResult.hitDepth + 1);
            }
            hitTestResult.hitDepth = i4;
            return;
        }
        int i5 = hitTestResult.hitDepth;
        int i6 = i5 + 1;
        hitTestResult.removeNodesInRange(i6, mutableObjectList._size);
        hitTestResult.hitDepth++;
        mutableObjectList.add(node);
        mutableLongList.add(HitTestResultKt.DistanceAndFlags(f, z, false));
        m575outOfBoundsHit8NAm7pk(HitTestResultKt.m542access$nextUntilhw7D004(node, companion.m582entityTypeOLwlOKw()), companion, j, hitTestResult, i, z, f, false);
        Unit unit2 = Unit.INSTANCE;
        hitTestResult.hitDepth = i5;
        if (i6 == AppCompatHintHelper.getLastIndex(hitTestResult) || HitTestResultKt.m545isInExpandedBoundsimpl(hitTestResult.m541findBestHitDistancefn2tFes())) {
            int i7 = hitTestResult.hitDepth;
            int i8 = i7 + 1;
            mutableObjectList.removeAt(i8);
            if (i8 < 0 || i8 >= (i2 = mutableLongList._size)) {
                RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
                throw null;
            }
            long[] jArr = mutableLongList.content;
            long j2 = jArr[i8];
            if (i8 != i2 - 1) {
                ArraysKt.copyInto(jArr, jArr, i8, i7 + 2, i2);
            }
            mutableLongList._size--;
        }
    }

    public final Rect touchBoundsInRoot() {
        if (getTail().isAttached) {
            LayoutCoordinates layoutCoordinatesFindRootCoordinates = RulerKt.findRootCoordinates(this);
            MutableRect mutableRect = this._rectCache;
            if (mutableRect == null) {
                mutableRect = new MutableRect();
                this._rectCache = mutableRect;
            }
            long jM567calculateMinimumTouchTargetPaddingE7KxVPU = m567calculateMinimumTouchTargetPaddingE7KxVPU(m570getMinimumTouchTargetSizeNHjbRc());
            int i = (int) (jM567calculateMinimumTouchTargetPaddingE7KxVPU >> 32);
            mutableRect.left = -Float.intBitsToFloat(i);
            int i2 = (int) (jM567calculateMinimumTouchTargetPaddingE7KxVPU & 4294967295L);
            mutableRect.top = -Float.intBitsToFloat(i2);
            mutableRect.right = Float.intBitsToFloat(i) + getMeasuredWidth();
            mutableRect.bottom = Float.intBitsToFloat(i2) + getMeasuredHeight();
            for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != layoutCoordinatesFindRootCoordinates; nodeCoordinator = nodeCoordinator.wrappedBy) {
                nodeCoordinator.rectInParent$ui(mutableRect, false, true);
                if (!mutableRect.isEmpty()) {
                }
            }
            return new Rect(mutableRect.left, mutableRect.top, mutableRect.right, mutableRect.bottom);
        }
        return Rect.Zero;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public final void mo529transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui = findCommonAncestor$ui(coordinator);
        Matrix.m445resetimpl(fArr);
        coordinator.m579transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui, fArr);
        m578transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui, fArr);
    }

    /* JADX INFO: renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    public final void m578transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        float[] fArrM605getInverseMatrix3i98HWw;
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        this.wrappedBy.m578transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.m712equalsimpl0(this.position, 0L)) {
            float[] fArr2 = tmpMatrix;
            Matrix.m445resetimpl(fArr2);
            long j = this.position;
            Matrix.m447translateimpl(fArr2, -((int) (j >> 32)), -((int) (j & 4294967295L)));
            Matrix.m446timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || (fArrM605getInverseMatrix3i98HWw = ((GraphicsLayerOwnerLayer) ownedLayer).m605getInverseMatrix3i98HWw()) == null) {
            return;
        }
        Matrix.m446timesAssign58bKbWc(fArr, fArrM605getInverseMatrix3i98HWw);
    }

    /* JADX INFO: renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    public final void m579transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        for (NodeCoordinator nodeCoordinator2 = this; !nodeCoordinator2.equals(nodeCoordinator); nodeCoordinator2 = nodeCoordinator2.wrappedBy) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                Matrix.m446timesAssign58bKbWc(fArr, ((GraphicsLayerOwnerLayer) ownedLayer).m606getMatrixsQKQjiQ());
            }
            long j = nodeCoordinator2.position;
            if (!IntOffset.m712equalsimpl0(j, 0L)) {
                float[] fArr2 = tmpMatrix;
                Matrix.m445resetimpl(fArr2);
                Matrix.m447translateimpl(fArr2, (int) (j >> 32), (int) (j & 4294967295L));
                Matrix.m446timesAssign58bKbWc(fArr, fArr2);
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public final void mo530transformToScreen58bKbWc(float[] fArr) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(this.layoutNode);
        NodeCoordinator coordinator = toCoordinator(RulerKt.findRootCoordinates(this));
        m579transformToAncestorEL8BTi8(coordinator, fArr);
        if (ownerRequireOwner instanceof MatrixPositionCalculator) {
            ((AndroidComposeView) ((MatrixPositionCalculator) ownerRequireOwner)).m589localToScreen58bKbWc(fArr);
            return;
        }
        long jMo526localToScreenMKHz9U = coordinator.mo526localToScreenMKHz9U(0L);
        if ((9223372034707292159L & jMo526localToScreenMKHz9U) != 9205357640488583168L) {
            Matrix.m447translateimpl(fArr, Float.intBitsToFloat((int) (jMo526localToScreenMKHz9U >> 32)), Float.intBitsToFloat((int) (jMo526localToScreenMKHz9U & 4294967295L)));
        }
    }

    public final void updateLayerBlock(Function1 function1, boolean z) {
        Owner owner;
        MutableVector mutableVector;
        Reference referencePoll;
        NavHostKt.AnonymousClass32.AnonymousClass1 anonymousClass1;
        MutableVector mutableVector2;
        Reference referencePoll2;
        Object obj;
        LayoutNode layoutNode = this.layoutNode;
        boolean z2 = (!z && this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, layoutNode.density) && this.layerLayoutDirection == layoutNode.layoutDirection) ? false : true;
        this.layerDensity = layoutNode.density;
        this.layerLayoutDirection = layoutNode.layoutDirection;
        boolean zIsAttached = layoutNode.isAttached();
        NodeCoordinator$invalidateParentLayer$1 nodeCoordinator$invalidateParentLayer$1 = this.invalidateParentLayer;
        if (!zIsAttached || function1 == null) {
            this.layerBlock = null;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
                AndroidComposeView androidComposeView = graphicsLayerOwnerLayer.ownerView;
                if (!BrushKt.m418isIdentity58bKbWc(graphicsLayerOwnerLayer.m606getMatrixsQKQjiQ())) {
                    layoutNode.onCoordinatorRectChanged$ui(this);
                }
                graphicsLayerOwnerLayer.drawBlock = null;
                graphicsLayerOwnerLayer.invalidateParentLayer = null;
                graphicsLayerOwnerLayer.isDestroyed = true;
                if (graphicsLayerOwnerLayer.isDirty) {
                    graphicsLayerOwnerLayer.isDirty = false;
                    androidComposeView.notifyLayerIsDirty$ui(graphicsLayerOwnerLayer, false);
                }
                GraphicsContext graphicsContext = graphicsLayerOwnerLayer.context;
                if (graphicsContext != null) {
                    graphicsContext.releaseGraphicsLayer(graphicsLayerOwnerLayer.graphicsLayer);
                    RequestService requestService = androidComposeView.layerCache;
                    do {
                        ReferenceQueue referenceQueue = (ReferenceQueue) requestService.hardwareBitmapService;
                        mutableVector = (MutableVector) requestService.systemCallbacks;
                        referencePoll = referenceQueue.poll();
                        if (referencePoll != null) {
                            mutableVector.remove(referencePoll);
                        }
                    } while (referencePoll != null);
                    mutableVector.add(new java.lang.ref.WeakReference(graphicsLayerOwnerLayer, (ReferenceQueue) requestService.hardwareBitmapService));
                    androidComposeView.dirtyLayers.remove(graphicsLayerOwnerLayer);
                }
                this.layer = null;
                layoutNode.innerLayerCoordinatorIsDirty = true;
                nodeCoordinator$invalidateParentLayer$1.invoke();
                if (getTail().isAttached && layoutNode.isPlaced() && (owner = layoutNode.owner) != null) {
                    ((AndroidComposeView) owner).onLayoutChange(layoutNode);
                }
            }
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.layerBlock = function1;
        if (this.layer != null) {
            if (z2) {
                updateLayerParameters(true);
                return;
            }
            return;
        }
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode);
        NavHostKt.AnonymousClass32.AnonymousClass1 anonymousClass2 = this._drawBlock;
        if (anonymousClass2 == null) {
            NavHostKt.AnonymousClass32.AnonymousClass1 anonymousClass3 = new NavHostKt.AnonymousClass32.AnonymousClass1(4, this, new NodeCoordinator$invalidateParentLayer$1(this, 1));
            this._drawBlock = anonymousClass3;
            anonymousClass1 = anonymousClass3;
        } else {
            anonymousClass1 = anonymousClass2;
        }
        AndroidComposeView androidComposeView2 = (AndroidComposeView) ownerRequireOwner;
        RequestService requestService2 = androidComposeView2.layerCache;
        do {
            ReferenceQueue referenceQueue2 = (ReferenceQueue) requestService2.hardwareBitmapService;
            mutableVector2 = (MutableVector) requestService2.systemCallbacks;
            referencePoll2 = referenceQueue2.poll();
            if (referencePoll2 != null) {
                mutableVector2.remove(referencePoll2);
            }
        } while (referencePoll2 != null);
        do {
            int i = mutableVector2.size;
            if (i == 0) {
                obj = null;
                break;
            }
            obj = ((Reference) mutableVector2.removeAt(i - 1)).get();
        } while (obj == null);
        OwnedLayer graphicsLayerOwnerLayer2 = (OwnedLayer) obj;
        if (graphicsLayerOwnerLayer2 != null) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer3 = (GraphicsLayerOwnerLayer) graphicsLayerOwnerLayer2;
            GraphicsContext graphicsContext2 = graphicsLayerOwnerLayer3.context;
            if (graphicsContext2 == null) {
                throw Modifier.CC.m("currently reuse is only supported when we manage the layer lifecycle");
            }
            if (!graphicsLayerOwnerLayer3.graphicsLayer.isReleased) {
                InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
            }
            graphicsLayerOwnerLayer3.graphicsLayer = graphicsContext2.createGraphicsLayer();
            graphicsLayerOwnerLayer3.isDestroyed = false;
            graphicsLayerOwnerLayer3.drawBlock = anonymousClass1;
            graphicsLayerOwnerLayer3.invalidateParentLayer = nodeCoordinator$invalidateParentLayer$1;
            graphicsLayerOwnerLayer3.isMatrixDirty = false;
            graphicsLayerOwnerLayer3.isInverseMatrixDirty = false;
            graphicsLayerOwnerLayer3.isIdentity = true;
            Matrix.m445resetimpl(graphicsLayerOwnerLayer3.matrixCache);
            float[] fArr = graphicsLayerOwnerLayer3.inverseMatrixCache;
            if (fArr != null) {
                Matrix.m445resetimpl(fArr);
            }
            graphicsLayerOwnerLayer3.transformOrigin = TransformOrigin.Center;
            graphicsLayerOwnerLayer3.drawnWithEnabledZ = false;
            long j = Integer.MAX_VALUE;
            graphicsLayerOwnerLayer3.size = (j & 4294967295L) | (j << 32);
            graphicsLayerOwnerLayer3.outline = null;
            graphicsLayerOwnerLayer3.mutatedFields = 0;
        } else {
            graphicsLayerOwnerLayer2 = new GraphicsLayerOwnerLayer(androidComposeView2.getGraphicsContext().createGraphicsLayer(), androidComposeView2.getGraphicsContext(), androidComposeView2, anonymousClass1, nodeCoordinator$invalidateParentLayer$1);
        }
        GraphicsLayerOwnerLayer graphicsLayerOwnerLayer4 = (GraphicsLayerOwnerLayer) graphicsLayerOwnerLayer2;
        graphicsLayerOwnerLayer4.m609resizeozmzZPI(this.measuredSize);
        graphicsLayerOwnerLayer4.m608movegyyYBs(this.position);
        this.layer = graphicsLayerOwnerLayer2;
        updateLayerParameters(true);
        layoutNode.innerLayerCoordinatorIsDirty = true;
        nodeCoordinator$invalidateParentLayer$1.invoke();
    }

    public final void updateLayerParameters(boolean z) {
        char c;
        AndroidComposeView androidComposeView;
        boolean z2;
        AndroidComposeView androidComposeView2;
        Owner owner;
        Function0 function0;
        Function0 function1;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null) {
            if (this.layerBlock == null) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
            return;
        }
        Function1 function2 = this.layerBlock;
        if (function2 == null) {
            throw Modifier.CC.m("updateLayerParameters requires a non-null layerBlock");
        }
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
        reusableGraphicsLayerScope.reset$2();
        LayoutNode layoutNode = this.layoutNode;
        reusableGraphicsLayerScope.graphicsDensity = layoutNode.density;
        reusableGraphicsLayerScope.layoutDirection = layoutNode.layoutDirection;
        reusableGraphicsLayerScope.size = IntSizeKt.m724toSizeozmzZPI(this.measuredSize);
        ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSnapshotObserver().observer.observeReads(this, OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$4, new DialogHostKt$DialogHost$1$1$1(5, function2, this));
        LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
        if (layerPositionalProperties == null) {
            layerPositionalProperties = new LayerPositionalProperties();
            this.layerPositionalProperties = layerPositionalProperties;
        }
        LayerPositionalProperties layerPositionalProperties2 = tmpLayerPositionalProperties;
        layerPositionalProperties2.getClass();
        layerPositionalProperties2.scaleX = layerPositionalProperties.scaleX;
        layerPositionalProperties2.scaleY = layerPositionalProperties.scaleY;
        layerPositionalProperties2.translationX = layerPositionalProperties.translationX;
        layerPositionalProperties2.translationY = layerPositionalProperties.translationY;
        layerPositionalProperties2.rotationX = layerPositionalProperties.rotationX;
        layerPositionalProperties2.rotationY = layerPositionalProperties.rotationY;
        layerPositionalProperties2.rotationZ = layerPositionalProperties.rotationZ;
        layerPositionalProperties2.cameraDistance = layerPositionalProperties.cameraDistance;
        layerPositionalProperties2.transformOrigin = layerPositionalProperties.transformOrigin;
        float f = reusableGraphicsLayerScope.scaleX;
        layerPositionalProperties.scaleX = f;
        layerPositionalProperties.scaleY = reusableGraphicsLayerScope.scaleY;
        layerPositionalProperties.translationX = reusableGraphicsLayerScope.translationX;
        layerPositionalProperties.translationY = reusableGraphicsLayerScope.translationY;
        layerPositionalProperties.rotationX = reusableGraphicsLayerScope.rotationX;
        layerPositionalProperties.rotationY = reusableGraphicsLayerScope.rotationY;
        layerPositionalProperties.rotationZ = reusableGraphicsLayerScope.rotationZ;
        layerPositionalProperties.cameraDistance = reusableGraphicsLayerScope.cameraDistance;
        long j = reusableGraphicsLayerScope.transformOrigin;
        layerPositionalProperties.transformOrigin = j;
        GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
        AndroidComposeView androidComposeView3 = graphicsLayerOwnerLayer.ownerView;
        int i = reusableGraphicsLayerScope.mutatedFields | graphicsLayerOwnerLayer.mutatedFields;
        graphicsLayerOwnerLayer.layoutDirection = reusableGraphicsLayerScope.layoutDirection;
        graphicsLayerOwnerLayer.density = reusableGraphicsLayerScope.graphicsDensity;
        int i2 = i & 4096;
        if (i2 != 0) {
            graphicsLayerOwnerLayer.transformOrigin = j;
        }
        if ((i & 1) != 0) {
            GraphicsLayerImpl graphicsLayerImpl = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (graphicsLayerImpl.getScaleX() != f) {
                graphicsLayerImpl.setScaleX(f);
            }
        }
        if ((i & 2) != 0) {
            GraphicsLayer graphicsLayer = graphicsLayerOwnerLayer.graphicsLayer;
            float f2 = reusableGraphicsLayerScope.scaleY;
            GraphicsLayerImpl graphicsLayerImpl2 = graphicsLayer.impl;
            if (graphicsLayerImpl2.getScaleY() != f2) {
                graphicsLayerImpl2.setScaleY(f2);
            }
        }
        if ((i & 4) != 0) {
            graphicsLayerOwnerLayer.graphicsLayer.setAlpha(reusableGraphicsLayerScope.alpha);
        }
        if ((i & 8) != 0) {
            GraphicsLayer graphicsLayer2 = graphicsLayerOwnerLayer.graphicsLayer;
            float f3 = reusableGraphicsLayerScope.translationX;
            GraphicsLayerImpl graphicsLayerImpl3 = graphicsLayer2.impl;
            if (graphicsLayerImpl3.getTranslationX() != f3) {
                graphicsLayerImpl3.setTranslationX(f3);
            }
        }
        if ((i & 16) != 0) {
            GraphicsLayer graphicsLayer3 = graphicsLayerOwnerLayer.graphicsLayer;
            float f4 = reusableGraphicsLayerScope.translationY;
            GraphicsLayerImpl graphicsLayerImpl4 = graphicsLayer3.impl;
            if (graphicsLayerImpl4.getTranslationY() != f4) {
                graphicsLayerImpl4.setTranslationY(f4);
            }
        }
        if ((i & 32) != 0) {
            GraphicsLayer graphicsLayer4 = graphicsLayerOwnerLayer.graphicsLayer;
            float f5 = reusableGraphicsLayerScope.shadowElevation;
            GraphicsLayerImpl graphicsLayerImpl5 = graphicsLayer4.impl;
            if (graphicsLayerImpl5.getShadowElevation() != f5) {
                graphicsLayerImpl5.setShadowElevation(f5);
                graphicsLayer4.outlineDirty = true;
                graphicsLayer4.configureOutlineAndClip();
            }
            if (reusableGraphicsLayerScope.shadowElevation > 0.0f && !graphicsLayerOwnerLayer.drawnWithEnabledZ && (function1 = graphicsLayerOwnerLayer.invalidateParentLayer) != null) {
                function1.invoke();
            }
        }
        if ((i & 64) != 0) {
            GraphicsLayer graphicsLayer5 = graphicsLayerOwnerLayer.graphicsLayer;
            long j2 = reusableGraphicsLayerScope.ambientShadowColor;
            GraphicsLayerImpl graphicsLayerImpl6 = graphicsLayer5.impl;
            if (!Color.m435equalsimpl0(j2, graphicsLayerImpl6.mo478getAmbientShadowColor0d7_KjU())) {
                graphicsLayerImpl6.mo482setAmbientShadowColor8_81llA(j2);
            }
        }
        if ((i & 128) != 0) {
            GraphicsLayer graphicsLayer6 = graphicsLayerOwnerLayer.graphicsLayer;
            long j3 = reusableGraphicsLayerScope.spotShadowColor;
            GraphicsLayerImpl graphicsLayerImpl7 = graphicsLayer6.impl;
            if (!Color.m435equalsimpl0(j3, graphicsLayerImpl7.mo481getSpotShadowColor0d7_KjU())) {
                graphicsLayerImpl7.mo488setSpotShadowColor8_81llA(j3);
            }
        }
        if ((i & 1024) != 0) {
            GraphicsLayer graphicsLayer7 = graphicsLayerOwnerLayer.graphicsLayer;
            float f6 = reusableGraphicsLayerScope.rotationZ;
            GraphicsLayerImpl graphicsLayerImpl8 = graphicsLayer7.impl;
            if (graphicsLayerImpl8.getRotationZ() != f6) {
                graphicsLayerImpl8.setRotationZ(f6);
            }
        }
        if ((i & 256) != 0) {
            GraphicsLayer graphicsLayer8 = graphicsLayerOwnerLayer.graphicsLayer;
            float f7 = reusableGraphicsLayerScope.rotationX;
            GraphicsLayerImpl graphicsLayerImpl9 = graphicsLayer8.impl;
            if (graphicsLayerImpl9.getRotationX() != f7) {
                graphicsLayerImpl9.setRotationX(f7);
            }
        }
        if ((i & 512) != 0) {
            GraphicsLayer graphicsLayer9 = graphicsLayerOwnerLayer.graphicsLayer;
            float f8 = reusableGraphicsLayerScope.rotationY;
            GraphicsLayerImpl graphicsLayerImpl10 = graphicsLayer9.impl;
            if (graphicsLayerImpl10.getRotationY() != f8) {
                graphicsLayerImpl10.setRotationY(f8);
            }
        }
        if ((i & 2048) != 0) {
            GraphicsLayer graphicsLayer10 = graphicsLayerOwnerLayer.graphicsLayer;
            float f9 = reusableGraphicsLayerScope.cameraDistance;
            GraphicsLayerImpl graphicsLayerImpl11 = graphicsLayer10.impl;
            if (graphicsLayerImpl11.getCameraDistance() != f9) {
                graphicsLayerImpl11.setCameraDistance(f9);
            }
        }
        if (i2 != 0) {
            c = ' ';
            if (TransformOrigin.m451equalsimpl0(graphicsLayerOwnerLayer.transformOrigin, TransformOrigin.Center)) {
                GraphicsLayer graphicsLayer11 = graphicsLayerOwnerLayer.graphicsLayer;
                if (!Offset.m369equalsimpl0(graphicsLayer11.pivotOffset, 9205357640488583168L)) {
                    graphicsLayer11.pivotOffset = 9205357640488583168L;
                    graphicsLayer11.impl.mo486setPivotOffsetk4lQ0M(9205357640488583168L);
                }
            } else {
                GraphicsLayer graphicsLayer12 = graphicsLayerOwnerLayer.graphicsLayer;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(TransformOrigin.m452getPivotFractionXimpl(graphicsLayerOwnerLayer.transformOrigin) * ((int) (graphicsLayerOwnerLayer.size >> 32)))) << 32) | (((long) Float.floatToRawIntBits(TransformOrigin.m453getPivotFractionYimpl(graphicsLayerOwnerLayer.transformOrigin) * ((int) (graphicsLayerOwnerLayer.size & 4294967295L)))) & 4294967295L);
                if (!Offset.m369equalsimpl0(graphicsLayer12.pivotOffset, jFloatToRawIntBits)) {
                    graphicsLayer12.pivotOffset = jFloatToRawIntBits;
                    graphicsLayer12.impl.mo486setPivotOffsetk4lQ0M(jFloatToRawIntBits);
                }
            }
        } else {
            c = ' ';
        }
        if ((i & 16384) != 0) {
            graphicsLayerOwnerLayer.graphicsLayer.setClip(reusableGraphicsLayerScope.clip);
        }
        if ((131072 & i) != 0) {
            GraphicsLayerImpl graphicsLayerImpl12 = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (!Intrinsics.areEqual(graphicsLayerImpl12.getRenderEffect(), null)) {
                graphicsLayerImpl12.setRenderEffect(null);
            }
        }
        if ((262144 & i) != 0) {
            GraphicsLayerImpl graphicsLayerImpl13 = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (!Intrinsics.areEqual(graphicsLayerImpl13.getColorFilter(), null)) {
                graphicsLayerImpl13.setColorFilter();
            }
        }
        if ((524288 & i) != 0) {
            GraphicsLayer graphicsLayer13 = graphicsLayerOwnerLayer.graphicsLayer;
            int i3 = reusableGraphicsLayerScope.blendMode;
            GraphicsLayerImpl graphicsLayerImpl14 = graphicsLayer13.impl;
            if (graphicsLayerImpl14.mo479getBlendMode0nO6VwU() != i3) {
                graphicsLayerImpl14.mo483setBlendModes9anfk8(i3);
            }
        }
        if ((32768 & i) != 0) {
            GraphicsLayerImpl graphicsLayerImpl15 = graphicsLayerOwnerLayer.graphicsLayer.impl;
            if (graphicsLayerImpl15.mo480getCompositingStrategyke2Ky5w() != 0) {
                graphicsLayerImpl15.mo484setCompositingStrategyWpw9cng(0);
            }
        }
        if ((i & 7963) != 0) {
            graphicsLayerOwnerLayer.isMatrixDirty = true;
            graphicsLayerOwnerLayer.isInverseMatrixDirty = true;
        }
        if (Intrinsics.areEqual(graphicsLayerOwnerLayer.outline, reusableGraphicsLayerScope.outline)) {
            androidComposeView = androidComposeView3;
            z2 = false;
        } else {
            BrushKt brushKt = reusableGraphicsLayerScope.outline;
            graphicsLayerOwnerLayer.outline = brushKt;
            if (brushKt == null) {
                androidComposeView = androidComposeView3;
            } else {
                GraphicsLayer graphicsLayer14 = graphicsLayerOwnerLayer.graphicsLayer;
                if (brushKt instanceof Outline$Rectangle) {
                    Rect rect = ((Outline$Rectangle) brushKt).rect;
                    float f10 = rect.left;
                    float f11 = rect.top;
                    androidComposeView = androidComposeView3;
                    graphicsLayer14.m477setRoundRectOutlineTNW_H78((((long) Float.floatToRawIntBits(f10)) << c) | (((long) Float.floatToRawIntBits(f11)) & 4294967295L), (((long) Float.floatToRawIntBits(rect.right - f10)) << c) | (((long) Float.floatToRawIntBits(rect.bottom - f11)) & 4294967295L), 0.0f);
                } else {
                    androidComposeView = androidComposeView3;
                    if (brushKt instanceof Outline$Generic) {
                        AndroidPath androidPath = ((Outline$Generic) brushKt).path;
                        graphicsLayer14.internalOutline = null;
                        graphicsLayer14.roundRectOutlineSize = 9205357640488583168L;
                        graphicsLayer14.roundRectOutlineTopLeft = 0L;
                        graphicsLayer14.roundRectCornerRadius = 0.0f;
                        graphicsLayer14.outlineDirty = true;
                        graphicsLayer14.usePathForClip = false;
                        graphicsLayer14.outlinePath = androidPath;
                        graphicsLayer14.configureOutlineAndClip();
                    } else {
                        if (!(brushKt instanceof Outline$Rounded)) {
                            throw new HttpException();
                        }
                        Outline$Rounded outline$Rounded = (Outline$Rounded) brushKt;
                        AndroidPath androidPath2 = outline$Rounded.roundRectPath;
                        if (androidPath2 != null) {
                            graphicsLayer14.internalOutline = null;
                            graphicsLayer14.roundRectOutlineSize = 9205357640488583168L;
                            graphicsLayer14.roundRectOutlineTopLeft = 0L;
                            graphicsLayer14.roundRectCornerRadius = 0.0f;
                            graphicsLayer14.outlineDirty = true;
                            graphicsLayer14.usePathForClip = false;
                            graphicsLayer14.outlinePath = androidPath2;
                            graphicsLayer14.configureOutlineAndClip();
                        } else {
                            RoundRect roundRect = outline$Rounded.roundRect;
                            graphicsLayer14.m477setRoundRectOutlineTNW_H78((((long) Float.floatToRawIntBits(roundRect.left)) << c) | (((long) Float.floatToRawIntBits(roundRect.top)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << c) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L), Float.intBitsToFloat((int) (roundRect.bottomLeftCornerRadius >> c)));
                        }
                    }
                }
                if (Build.VERSION.SDK_INT < 33 && (((brushKt instanceof Outline$Generic) || ((brushKt instanceof Outline$Rounded) && !RoundRectKt.isSimple(((Outline$Rounded) brushKt).roundRect))) && (function0 = graphicsLayerOwnerLayer.invalidateParentLayer) != null)) {
                    function0.invoke();
                }
            }
            z2 = true;
        }
        graphicsLayerOwnerLayer.mutatedFields = reusableGraphicsLayerScope.mutatedFields;
        if (i != 0 || z2) {
            if (Build.VERSION.SDK_INT >= 26) {
                ViewParent parent = androidComposeView.getParent();
                if (parent != null) {
                    androidComposeView2 = androidComposeView;
                    parent.onDescendantInvalidated(androidComposeView2, androidComposeView2);
                } else {
                    androidComposeView2 = androidComposeView;
                }
            } else {
                androidComposeView2 = androidComposeView;
                androidComposeView2.invalidate();
            }
            if (AndroidComposeView.isArrEnabled$ui()) {
                androidComposeView2.voteFrameRate(0.0f);
            }
        }
        boolean z3 = this.isClipping;
        this.isClipping = reusableGraphicsLayerScope.clip;
        this.lastLayerAlpha = reusableGraphicsLayerScope.alpha;
        boolean z4 = layerPositionalProperties2.scaleX == layerPositionalProperties.scaleX && layerPositionalProperties2.scaleY == layerPositionalProperties.scaleY && layerPositionalProperties2.translationX == layerPositionalProperties.translationX && layerPositionalProperties2.translationY == layerPositionalProperties.translationY && layerPositionalProperties2.rotationX == layerPositionalProperties.rotationX && layerPositionalProperties2.rotationY == layerPositionalProperties.rotationY && layerPositionalProperties2.rotationZ == layerPositionalProperties.rotationZ && layerPositionalProperties2.cameraDistance == layerPositionalProperties.cameraDistance && TransformOrigin.m451equalsimpl0(layerPositionalProperties2.transformOrigin, layerPositionalProperties.transformOrigin);
        if (z && ((!z4 || z3 != this.isClipping) && (owner = layoutNode.owner) != null)) {
            ((AndroidComposeView) owner).onLayoutChange(layoutNode);
        }
        if (z4) {
            return;
        }
        layoutNode.onCoordinatorRectChanged$ui(this);
        if (layoutNode.globallyPositionedObservers > 0) {
            AndroidComposeView androidComposeView4 = (AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode);
            RequestService requestService = androidComposeView4.measureAndLayoutDelegate.onPositionedDispatcher;
            requestService.getClass();
            if (layoutNode.globallyPositionedObservers > 0) {
                ((MutableVector) requestService.systemCallbacks).add(layoutNode);
                layoutNode.needsOnGloballyPositionedDispatch = true;
            }
            androidComposeView4.scheduleMeasureAndLayout(null);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public final long mo531windowToLocalMKHz9U(long j) {
        if (!getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = RulerKt.findRootCoordinates(this);
        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(this.layoutNode);
        androidComposeView.recalculateWindowPosition();
        return mo524localPositionOfS_NoaFU(layoutCoordinatesFindRootCoordinates, Offset.m372minusMKHz9U(Matrix.m443mapMKHz9U(j, androidComposeView.windowToViewMatrix), layoutCoordinatesFindRootCoordinates.mo525localToRootMKHz9U(0L)));
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0180  */
    /* JADX INFO: renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    public final boolean m580withinLayerBoundsk4lQ0M(long j) {
        boolean z;
        boolean z2;
        boolean zM612isWithinEllipseVE1yxkc;
        if ((((9187343241974906880L ^ (j & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) != 0) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || !this.isClipping) {
            return true;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        GraphicsLayer graphicsLayer = ((GraphicsLayerOwnerLayer) ownedLayer).graphicsLayer;
        if (graphicsLayer.clip) {
            BrushKt outline = graphicsLayer.getOutline();
            if (outline instanceof Outline$Rectangle) {
                Rect rect = ((Outline$Rectangle) outline).rect;
                if (rect.left > fIntBitsToFloat || fIntBitsToFloat >= rect.right || rect.top > fIntBitsToFloat2 || fIntBitsToFloat2 >= rect.bottom) {
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = true;
            } else if (outline instanceof Outline$Rounded) {
                RoundRect roundRect = ((Outline$Rounded) outline).roundRect;
                float f = roundRect.left;
                long j2 = roundRect.topRightCornerRadius;
                long j3 = roundRect.bottomLeftCornerRadius;
                long j4 = roundRect.bottomRightCornerRadius;
                z = false;
                float f2 = roundRect.bottom;
                z2 = true;
                float f3 = roundRect.top;
                float f4 = roundRect.right;
                long j5 = roundRect.topLeftCornerRadius;
                if (fIntBitsToFloat >= f && fIntBitsToFloat < f4 && fIntBitsToFloat2 >= f3 && fIntBitsToFloat2 < f2) {
                    int i = (int) (j5 >> 32);
                    float fIntBitsToFloat3 = Float.intBitsToFloat(i);
                    int i2 = (int) (j2 >> 32);
                    if (Float.intBitsToFloat(i2) + fIntBitsToFloat3 <= roundRect.getWidth()) {
                        int i3 = (int) (j3 >> 32);
                        float fIntBitsToFloat4 = Float.intBitsToFloat(i3);
                        int i4 = (int) (j4 >> 32);
                        if (Float.intBitsToFloat(i4) + fIntBitsToFloat4 <= roundRect.getWidth()) {
                            int i5 = (int) (j5 & 4294967295L);
                            int i6 = (int) (j3 & 4294967295L);
                            if (Float.intBitsToFloat(i6) + Float.intBitsToFloat(i5) <= roundRect.getHeight()) {
                                int i7 = (int) (j2 & 4294967295L);
                                int i8 = (int) (j4 & 4294967295L);
                                if (Float.intBitsToFloat(i8) + Float.intBitsToFloat(i7) <= roundRect.getHeight()) {
                                    float fIntBitsToFloat5 = Float.intBitsToFloat(i) + f;
                                    float fIntBitsToFloat6 = Float.intBitsToFloat(i5) + f3;
                                    float fIntBitsToFloat7 = f4 - Float.intBitsToFloat(i2);
                                    float fIntBitsToFloat8 = Float.intBitsToFloat(i7) + f3;
                                    float fIntBitsToFloat9 = f4 - Float.intBitsToFloat(i4);
                                    float fIntBitsToFloat10 = f2 - Float.intBitsToFloat(i8);
                                    float fIntBitsToFloat11 = f2 - Float.intBitsToFloat(i6);
                                    float fIntBitsToFloat12 = Float.intBitsToFloat(i3) + f;
                                    if (fIntBitsToFloat < fIntBitsToFloat5 && fIntBitsToFloat2 < fIntBitsToFloat6) {
                                        zM612isWithinEllipseVE1yxkc = InvertMatrixKt.m612isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat5, fIntBitsToFloat6, roundRect.topLeftCornerRadius);
                                    } else if (fIntBitsToFloat < fIntBitsToFloat12 && fIntBitsToFloat2 > fIntBitsToFloat11) {
                                        zM612isWithinEllipseVE1yxkc = InvertMatrixKt.m612isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat12, fIntBitsToFloat11, roundRect.bottomLeftCornerRadius);
                                    } else if (fIntBitsToFloat <= fIntBitsToFloat7 || fIntBitsToFloat2 >= fIntBitsToFloat8) {
                                        zM612isWithinEllipseVE1yxkc = (fIntBitsToFloat <= fIntBitsToFloat9 || fIntBitsToFloat2 <= fIntBitsToFloat10) ? z2 : InvertMatrixKt.m612isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat9, fIntBitsToFloat10, roundRect.bottomRightCornerRadius);
                                    } else {
                                        zM612isWithinEllipseVE1yxkc = InvertMatrixKt.m612isWithinEllipseVE1yxkc(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat7, fIntBitsToFloat8, roundRect.topRightCornerRadius);
                                    }
                                } else {
                                    AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                                    Modifier.CC.addRoundRect$default(androidPathPath, roundRect);
                                    zM612isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath);
                                }
                            } else {
                                AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
                                Modifier.CC.addRoundRect$default(androidPathPath2, roundRect);
                                zM612isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath2);
                            }
                        } else {
                            AndroidPath androidPathPath3 = AndroidPath_androidKt.Path();
                            Modifier.CC.addRoundRect$default(androidPathPath3, roundRect);
                            zM612isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath3);
                        }
                    } else {
                        AndroidPath androidPathPath4 = AndroidPath_androidKt.Path();
                        Modifier.CC.addRoundRect$default(androidPathPath4, roundRect);
                        zM612isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, androidPathPath4);
                    }
                }
            } else {
                z = false;
                z2 = true;
                if (!(outline instanceof Outline$Generic)) {
                    throw new HttpException();
                }
                zM612isWithinEllipseVE1yxkc = InvertMatrixKt.isInPath(fIntBitsToFloat, fIntBitsToFloat2, ((Outline$Generic) outline).path);
            }
            zM612isWithinEllipseVE1yxkc = z;
        } else {
            z = false;
            z2 = true;
        }
        return zM612isWithinEllipseVE1yxkc ? z2 : z;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutCoordinates getCoordinates() {
        return this;
    }
}
