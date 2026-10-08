package androidx.compose.ui.semantics;

import android.graphics.Region;
import android.os.Trace;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSizeKt;
import coil.request.Parameters;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsNodeKt {
    public static final Rect DefaultFakeNodeBounds = new Rect(0.0f, 0.0f, 10.0f, 10.0f);

    /* JADX WARN: Code duplicated, block: B:35:0x0063 A[LOOP:0: B:4:0x000d->B:35:0x0063, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0066 A[EDGE_INSN: B:43:0x0066->B:36:0x0066 BREAK  A[LOOP:0: B:4:0x000d->B:35:0x0063], SYNTHETIC] */
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean z) {
        Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
        Object obj = null;
        if ((node.aggregateChildKindSet & 8) != 0) {
            loop0: while (node != null) {
                if ((node.kindSet & 8) == 0) {
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                        break;
                    }
                    node = node.child;
                } else {
                    Modifier.Node nodeAccess$pop = node;
                    MutableVector mutableVector = null;
                    while (nodeAccess$pop != null) {
                        if (nodeAccess$pop instanceof SemanticsModifierNode) {
                            obj = nodeAccess$pop;
                            break loop0;
                        }
                        if ((nodeAccess$pop.kindSet & 8) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                if ((node2.kindSet & 8) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodeAccess$pop = node2;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (nodeAccess$pop != null) {
                                            mutableVector.add(nodeAccess$pop);
                                            nodeAccess$pop = null;
                                        }
                                        mutableVector.add(node2);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                    }
                    node = node.child;
                }
            }
        }
        Modifier.Node node3 = ((Modifier.Node) ((SemanticsModifierNode) obj)).node;
        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
        if (semanticsConfiguration == null) {
            semanticsConfiguration = new SemanticsConfiguration();
        }
        return new SemanticsNode(node3, z, layoutNode, semanticsConfiguration);
    }

    public static final MutableIntObjectMap getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner semanticsOwner, Function1 function1) {
        Trace.beginSection("getAllUncoveredSemanticsNodesToIntObjectMap");
        try {
            SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
            LayoutNode layoutNode = unmergedRootSemanticsNode.layoutNode;
            if (layoutNode.isPlaced() && layoutNode.isAttached()) {
                Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
                MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(48);
                Parameters.Builder builder = new Parameters.Builder(10);
                builder.set(IntRectKt.roundToIntRect(boundsInRoot));
                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(mutableIntObjectMap, unmergedRootSemanticsNode, unmergedRootSemanticsNode, new Parameters.Builder(10), builder, function1);
                return mutableIntObjectMap;
            }
            return IntObjectMapKt.EmptyIntObjectMap;
        } finally {
            Trace.endSection();
        }
    }

    public static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(MutableIntObjectMap mutableIntObjectMap, SemanticsNode semanticsNode, SemanticsNode semanticsNode2, Parameters.Builder builder, Parameters.Builder builder2, Function1 function1) {
        Parameters.Builder builder3 = builder;
        Region region = (Region) builder3.entries;
        Parameters.Builder builder4 = builder2;
        Region region2 = (Region) builder4.entries;
        LayoutNode layoutNode = semanticsNode2.layoutNode;
        LayoutNode layoutNode2 = semanticsNode2.layoutNode;
        if (!layoutNode.isPlaced() || !layoutNode2.isAttached() || region2.isEmpty()) {
            if (semanticsNode2.isFake$ui()) {
                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(mutableIntObjectMap, semanticsNode, semanticsNode2);
                return;
            }
            return;
        }
        Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
        if (touchBoundsInRoot.isEmpty()) {
            Object objFindSemanticsModifierNodeToGetBounds = semanticsNode2.findSemanticsModifierNodeToGetBounds();
            if (objFindSemanticsModifierNodeToGetBounds == null) {
                InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) layoutNode2.nodes.innerCoordinator;
                touchBoundsInRoot = RulerKt.findRootCoordinates(innerNodeCoordinator).localBoundingBoxOf(innerNodeCoordinator, false);
            } else {
                Modifier.Node node = ((Modifier.Node) objFindSemanticsModifierNodeToGetBounds).node;
                Object obj = semanticsNode2.unmergedConfig.props.get(SemanticsActions.OnClick);
                if (obj == null) {
                    obj = null;
                }
                touchBoundsInRoot = HitTestResultKt.effectiveBoundsInRoot(node, obj != null, false);
            }
        }
        IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(touchBoundsInRoot);
        builder3.set(intRectRoundToIntRect);
        if (region.op(region2, Region.Op.INTERSECT)) {
            int i = semanticsNode2.id;
            SemanticsNode semanticsNode3 = semanticsNode;
            if (i == semanticsNode3.id) {
                i = -1;
            }
            android.graphics.Rect bounds = region.getBounds();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = new SemanticsNodeWithAdjustedBounds(semanticsNode2, new IntRect(bounds.left, bounds.top, bounds.right, bounds.bottom));
            MutableIntObjectMap mutableIntObjectMap2 = mutableIntObjectMap;
            mutableIntObjectMap2.set(i, semanticsNodeWithAdjustedBounds);
            List children$ui$default = SemanticsNode.getChildren$ui$default(4, semanticsNode2);
            int size = children$ui$default.size() - 1;
            while (-1 < size) {
                if (!((Boolean) function1.invoke(children$ui$default.get(size))).booleanValue()) {
                    getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(mutableIntObjectMap2, semanticsNode3, (SemanticsNode) children$ui$default.get(size), builder3, builder4, function1);
                }
                size--;
                mutableIntObjectMap2 = mutableIntObjectMap;
                semanticsNode3 = semanticsNode;
                builder3 = builder;
                builder4 = builder2;
            }
            if (isImportantForAccessibility(semanticsNode2)) {
                region2.op(intRectRoundToIntRect.left, intRectRoundToIntRect.top, intRectRoundToIntRect.right, intRectRoundToIntRect.bottom, Region.Op.DIFFERENCE);
            }
        }
    }

    public static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(MutableIntObjectMap mutableIntObjectMap, SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        LayoutNode layoutNode;
        SemanticsNode parent = semanticsNode2.getParent();
        Rect boundsInRoot = (parent == null || (layoutNode = parent.layoutNode) == null || !layoutNode.isPlaced()) ? DefaultFakeNodeBounds : parent.getBoundsInRoot();
        int i = semanticsNode2.id;
        if (i == semanticsNode.id) {
            i = -1;
        }
        mutableIntObjectMap.set(i, new SemanticsNodeWithAdjustedBounds(semanticsNode2, IntRectKt.roundToIntRect(boundsInRoot)));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ec  */
    public static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(MutableIntObjectMap mutableIntObjectMap, SemanticsNode semanticsNode, SemanticsNode semanticsNode2, Parameters.Builder builder, Parameters.Builder builder2, Function1 function1) {
        boolean z;
        Rect rectEffectiveBoundsInRoot;
        boolean z2;
        MutableIntObjectMap mutableIntObjectMap2 = mutableIntObjectMap;
        Function1 function2 = function1;
        int i = semanticsNode.id;
        Region region = (Region) builder.entries;
        Parameters.Builder builder3 = builder2;
        Region region2 = (Region) builder3.entries;
        LayoutNode layoutNode = semanticsNode2.layoutNode;
        SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
        LayoutNode layoutNode2 = semanticsNode2.layoutNode;
        int i2 = semanticsNode2.id;
        boolean z3 = (layoutNode.isPlaced() && layoutNode2.isAttached()) ? false : true;
        if (!region2.isEmpty() || i2 == i) {
            if (!z3 || semanticsNode2.isFake$ui()) {
                IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(semanticsNode2.getTouchBoundsInRoot());
                builder.set(intRectRoundToIntRect);
                if (i2 == i) {
                    i2 = -1;
                }
                if (!region.op(region2, Region.Op.INTERSECT)) {
                    if (semanticsNode2.isFake$ui()) {
                        getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(mutableIntObjectMap, semanticsNode, semanticsNode2);
                        return;
                    } else {
                        if (i2 == -1) {
                            android.graphics.Rect bounds = region.getBounds();
                            mutableIntObjectMap2.set(i2, new SemanticsNodeWithAdjustedBounds(semanticsNode2, new IntRect(bounds.left, bounds.top, bounds.right, bounds.bottom)));
                            return;
                        }
                        return;
                    }
                }
                android.graphics.Rect bounds2 = region.getBounds();
                mutableIntObjectMap2.set(i2, new SemanticsNodeWithAdjustedBounds(semanticsNode2, new IntRect(bounds2.left, bounds2.top, bounds2.right, bounds2.bottom)));
                List children$ui$default = SemanticsNode.getChildren$ui$default(4, semanticsNode2);
                if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
                    SemanticsNode parent = semanticsNode2.getParent();
                    while (true) {
                        if (parent == null) {
                            parent = null;
                            break;
                        }
                        MutableScatterMap mutableScatterMap = parent.unmergedConfig.props;
                        if (mutableScatterMap.containsKey(SemanticsProperties.VerticalScrollAxisRange) || mutableScatterMap.containsKey(SemanticsProperties.HorizontalScrollAxisRange)) {
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                    if (parent == null) {
                        z2 = false;
                    } else {
                        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode2.findCoordinatorToGetBounds$ui();
                        if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                            nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                        } else {
                            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                            }
                            if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                            }
                        }
                        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui2 = parent.findCoordinatorToGetBounds$ui();
                        if (nodeCoordinatorFindCoordinatorToGetBounds$ui2 == null) {
                            nodeCoordinatorFindCoordinatorToGetBounds$ui2 = null;
                        } else {
                            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui2.getTail().isAttached) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui2 = null;
                            }
                            if (nodeCoordinatorFindCoordinatorToGetBounds$ui2 == null) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui2 = null;
                            }
                        }
                        if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null || nodeCoordinatorFindCoordinatorToGetBounds$ui2 == null) {
                            z2 = false;
                        } else {
                            Rect rectLocalBoundingBoxOf = nodeCoordinatorFindCoordinatorToGetBounds$ui2.localBoundingBoxOf(nodeCoordinatorFindCoordinatorToGetBounds$ui, false);
                            z2 = !rectLocalBoundingBoxOf.equals(rectLocalBoundingBoxOf.intersect(RectKt.m382Recttz77jQw(0L, IntSizeKt.m724toSizeozmzZPI(nodeCoordinatorFindCoordinatorToGetBounds$ui2.measuredSize))));
                        }
                    }
                    if (z2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    Parameters.Builder builder4 = new Parameters.Builder(10);
                    Object objFindSemanticsModifierNodeToGetBounds = semanticsNode2.findSemanticsModifierNodeToGetBounds();
                    if (objFindSemanticsModifierNodeToGetBounds == null) {
                        InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) layoutNode2.nodes.innerCoordinator;
                        rectEffectiveBoundsInRoot = RulerKt.findRootCoordinates(innerNodeCoordinator).localBoundingBoxOf(innerNodeCoordinator, false);
                    } else {
                        Modifier.Node node = ((Modifier.Node) objFindSemanticsModifierNodeToGetBounds).node;
                        Object obj = semanticsConfiguration.props.get(SemanticsActions.OnClick);
                        rectEffectiveBoundsInRoot = HitTestResultKt.effectiveBoundsInRoot(node, (obj == null ? null : obj) != null, false);
                    }
                    builder4.set(IntRectKt.roundToIntRect(rectEffectiveBoundsInRoot));
                    int size = children$ui$default.size() - 1;
                    while (-1 < size) {
                        if (!((Boolean) function2.invoke(children$ui$default.get(size))).booleanValue()) {
                            getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(mutableIntObjectMap2, semanticsNode, (SemanticsNode) children$ui$default.get(size), new Parameters.Builder(10), builder4, function2);
                        }
                        size--;
                        mutableIntObjectMap2 = mutableIntObjectMap;
                    }
                } else {
                    int size2 = children$ui$default.size() - 1;
                    while (-1 < size2) {
                        if (!((Boolean) function2.invoke(children$ui$default.get(size2))).booleanValue()) {
                            getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(mutableIntObjectMap, semanticsNode, (SemanticsNode) children$ui$default.get(size2), builder, builder3, function2);
                        }
                        size2--;
                        builder3 = builder2;
                        function2 = function1;
                    }
                }
                if (isImportantForAccessibility(semanticsNode2)) {
                    region2.op(intRectRoundToIntRect.left, intRectRoundToIntRect.top, intRectRoundToIntRect.right, intRectRoundToIntRect.bottom, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final Object getOrNull(SemanticsConfiguration semanticsConfiguration, SemanticsPropertyKey semanticsPropertyKey) {
        Object obj = semanticsConfiguration.props.get(semanticsPropertyKey);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public static final boolean isHidden(SemanticsNode semanticsNode) {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode.findCoordinatorToGetBounds$ui();
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null ? nodeCoordinatorFindCoordinatorToGetBounds$ui.isTransparent() : false) {
            return true;
        }
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        if (semanticsConfiguration.props.containsKey(SemanticsProperties.HideFromAccessibility)) {
            return true;
        }
        return semanticsConfiguration.props.containsKey(SemanticsProperties.InvisibleToUser);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0056 A[LOOP:0: B:9:0x001b->B:21:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x005b A[SYNTHETIC] */
    public static final boolean isImportantForAccessibility(SemanticsNode semanticsNode) {
        if (!isHidden(semanticsNode)) {
            SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
            if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
                return true;
            }
            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
            Object[] objArr = mutableScatterMap.keys;
            Object[] objArr2 = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                int i4 = (i << 3) + i3;
                                Object obj = objArr[i4];
                                Object obj2 = objArr2[i4];
                                if (((SemanticsPropertyKey) obj).isImportantForAccessibility) {
                                    return true;
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
            }
        }
        return false;
    }
}
