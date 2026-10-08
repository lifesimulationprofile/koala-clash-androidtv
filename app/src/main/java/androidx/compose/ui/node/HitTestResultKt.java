package androidx.compose.ui.node;

import android.view.View;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.platform.AndroidComposeView;
import coil.network.HttpException;
import coil.request.Parameters;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HitTestResultKt {
    public static final DepthSortedSetKt$DepthComparator$1 DepthComparator = new DepthSortedSetKt$DepthComparator$1(0);

    public static final long DistanceAndFlags(float f, boolean z, boolean z2) {
        return (((z ? 1L : 0L) | (z2 ? 2L : 0L)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32);
    }

    public static final void access$addLayoutNodeChildren(MutableVector mutableVector, Modifier.Node node) {
        MutableVector mutableVector2 = requireLayoutNode(node).get_children$ui();
        int i = mutableVector2.size - 1;
        Object[] objArr = mutableVector2.content;
        if (i < objArr.length) {
            while (i >= 0) {
                mutableVector.add((Modifier.Node) ((LayoutNode) objArr[i]).nodes.head);
                i--;
            }
        }
    }

    public static final int access$calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        LookaheadCapablePlaceable child = lookaheadCapablePlaceable.getChild();
        if (child == null) {
            InlineClassHelperKt.throwIllegalStateException("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.getMeasureResult$ui().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = (Integer) lookaheadCapablePlaceable.getMeasureResult$ui().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
        } else {
            int i = child.get(alignmentLine);
            if (i != Integer.MIN_VALUE) {
                child.isShallowPlacing = true;
                lookaheadCapablePlaceable.isPlacingForAlignment = true;
                lookaheadCapablePlaceable.replace$ui();
                child.isShallowPlacing = false;
                lookaheadCapablePlaceable.isPlacingForAlignment = false;
                return i + ((int) (alignmentLine instanceof HorizontalAlignmentLine ? child.mo554getPositionnOccac() & 4294967295L : child.mo554getPositionnOccac() >> 32));
            }
        }
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: access$nextUntil-hw7D004, reason: not valid java name */
    public static final Modifier.Node m542access$nextUntilhw7D004(DelegatableNode delegatableNode, int i) {
        Modifier.Node node = ((Modifier.Node) delegatableNode).node.child;
        if (node == null || (node.aggregateChildKindSet & i) == 0) {
            return null;
        }
        while (node != null) {
            int i2 = node.kindSet;
            if ((i2 & 2) != 0) {
                return null;
            }
            if ((i2 & i) != 0) {
                return node;
            }
            node = node.child;
        }
        return null;
    }

    public static final Modifier.Node access$pop(MutableVector mutableVector) {
        int i;
        if (mutableVector == null || (i = mutableVector.size) == 0) {
            return null;
        }
        return (Modifier.Node) mutableVector.removeAt(i - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        if ((node.kindSet & 2) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node node2 = ((DelegatingNode) node).delegate;
                while (node2 != 0) {
                    if (node2 instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) node2;
                    }
                    node2 = (!(node2 instanceof DelegatingNode) || (node2.kindSet & 2) == 0) ? node2.child : ((DelegatingNode) node2).delegate;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: compareTo-9YPOF3E, reason: not valid java name */
    public static final int m543compareTo9YPOF3E(long j, long j2) {
        boolean zM546isInLayerimpl = m546isInLayerimpl(j);
        if (zM546isInLayerimpl != m546isInLayerimpl(j2)) {
            return zM546isInLayerimpl ? -1 : 1;
        }
        int iSignum = (int) Math.signum(m544getDistanceimpl(j) - m544getDistanceimpl(j2));
        if (Math.min(m544getDistanceimpl(j), m544getDistanceimpl(j2)) >= 0.0f && m545isInExpandedBoundsimpl(j) != m545isInExpandedBoundsimpl(j2)) {
            return m545isInExpandedBoundsimpl(j) ? -1 : 1;
        }
        return iSignum;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object currentValueOf(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, ProvidableCompositionLocal providableCompositionLocal) {
        if (!((Modifier.Node) compositionLocalConsumerModifierNode).node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("Cannot read CompositionLocal because the Modifier node is not currently attached.");
        }
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) requireLayoutNode(compositionLocalConsumerModifierNode).compositionLocalMap;
        persistentCompositionLocalHashMap.getClass();
        return Stack.read(persistentCompositionLocalHashMap, providableCompositionLocal);
    }

    public static final Rect effectiveBoundsInRoot(Modifier.Node node, boolean z, boolean z2) {
        if (!node.node.isAttached) {
            return Rect.Zero;
        }
        if (z) {
            return m547requireCoordinator64DMado(node, 8).touchBoundsInRoot();
        }
        NodeCoordinator nodeCoordinatorM547requireCoordinator64DMado = m547requireCoordinator64DMado(node, 8);
        return RulerKt.findRootCoordinates(nodeCoordinatorM547requireCoordinator64DMado).localBoundingBoxOf(nodeCoordinatorM547requireCoordinator64DMado, z2);
    }

    public static final TraversableNode findNearestAncestor(Modifier.Node node, Object obj) {
        NodeChain nodeChain;
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = node.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(node);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node2 != null) {
                    if ((node2.kindSet & 262144) != 0) {
                        Modifier.Node nodeAccess$pop = node2;
                        MutableVector mutableVector = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodeAccess$pop;
                                if (obj.equals(traversableNode.getTraverseKey())) {
                                    return traversableNode;
                                }
                            }
                            if ((nodeAccess$pop.kindSet & 262144) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 262144) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodeAccess$pop = node3;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector.add(node3);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodeAccess$pop = access$pop(mutableVector);
                        }
                    }
                    node2 = node2.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        return null;
    }

    public static final ArrayList getChildrenOfVirtualChildren(IntrinsicMeasureScope intrinsicMeasureScope) {
        LayoutNode layoutNode = ((LookaheadCapablePlaceable) intrinsicMeasureScope).getLayoutNode();
        boolean zIsInLookaheadPass = isInLookaheadPass(layoutNode);
        MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui();
        MutableVector mutableVector = (MutableVector) objectListMutableList.objectList;
        ArrayList arrayList = new ArrayList(mutableVector.size);
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objectListMutableList.get(i2);
            arrayList.add(zIsInLookaheadPass ? layoutNode2.getChildLookaheadMeasurables$ui() : layoutNode2.getChildMeasurables$ui());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m544getDistanceimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        if (((Modifier.Node) drawModifierNode).node.isAttached) {
            m547requireCoordinator64DMado(drawModifierNode, 1).invalidateLayer();
        }
    }

    public static final void invalidateLayer(LayoutModifierNode layoutModifierNode) {
        m547requireCoordinator64DMado(layoutModifierNode, 2).invalidateLayer();
    }

    public static final void invalidateMeasurement(LayoutModifierNode layoutModifierNode) {
        requireLayoutNode(layoutModifierNode).invalidateMeasurements$ui();
    }

    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui();
    }

    /* JADX INFO: renamed from: isInExpandedBounds-impl, reason: not valid java name */
    public static final boolean m545isInExpandedBoundsimpl(long j) {
        return (j & 2) != 0;
    }

    /* JADX INFO: renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m546isInLayerimpl(long j) {
        return (j & 1) != 0;
    }

    public static final boolean isInLookaheadPass(LayoutNode layoutNode) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNode.layoutDelegate.layoutState);
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    throw new HttpException();
                }
                LayoutNode parent$ui = layoutNode.getParent$ui();
                if (parent$ui != null) {
                    return isInLookaheadPass(parent$ui);
                }
                throw new IllegalArgumentException("no parent for idle node");
            }
        }
        return true;
    }

    public static final boolean isOutMostLookaheadRoot(LayoutNode layoutNode) {
        if (layoutNode.lookaheadRoot == null) {
            return false;
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        return (parent$ui != null ? parent$ui.lookaheadRoot : null) == null || layoutNode.layoutDelegate.detachedFromParentLookaheadPass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void observeReads(Modifier.Node node, Function0 function0) {
        ObserverNodeOwnerScope observerNodeOwnerScope = node.ownerScope;
        if (observerNodeOwnerScope == null) {
            observerNodeOwnerScope = new ObserverNodeOwnerScope((ObserverModifierNode) node);
            node.ownerScope = observerNodeOwnerScope;
        }
        OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) requireOwner(node)).getSnapshotObserver();
        snapshotObserver.observer.observeReads(observerNodeOwnerScope, OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$5, function0);
    }

    public static final void requestAutofill(DelegatableNode delegatableNode) {
        final AndroidAutofillManager androidAutofillManager;
        final LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        if (layoutNodeRequireLayoutNode.isCurrentlyCalculatingSemanticsConfiguration) {
            return;
        }
        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode);
        if (!AndroidComposeView.autofillSupported() || (androidAutofillManager = androidComposeView._autofillManager) == null) {
            return;
        }
        androidAutofillManager.rectManager.rects.withRect(layoutNodeRequireLayoutNode.semanticsId, new Function4() { // from class: androidx.compose.ui.autofill.AndroidAutofillManager$requestAutofill$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                int iIntValue = ((Number) obj).intValue();
                int iIntValue2 = ((Number) obj2).intValue();
                int iIntValue3 = ((Number) obj3).intValue();
                int iIntValue4 = ((Number) obj4).intValue();
                AndroidAutofillManager androidAutofillManager2 = androidAutofillManager;
                androidAutofillManager2.reusableRect.set(iIntValue, iIntValue2, iIntValue3, iIntValue4);
                Parameters.Builder builder = androidAutofillManager2.platformAutofillManager;
                ((android.view.autofill.AutofillManager) builder.entries).requestAutofill(androidAutofillManager2.view, layoutNodeRequireLayoutNode.semanticsId, androidAutofillManager2.reusableRect);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m547requireCoordinator64DMado(DelegatableNode delegatableNode, int i) {
        NodeCoordinator nodeCoordinator = ((Modifier.Node) delegatableNode).node.coordinator;
        return (nodeCoordinator.getTail() == delegatableNode && NodeKindKt.m581getIncludeSelfInTraversalH91voCI(i)) ? nodeCoordinator.wrapped : nodeCoordinator;
    }

    public static final GraphicsContext requireGraphicsContext(DelegatableNode delegatableNode) {
        return ((AndroidComposeView) requireOwner(delegatableNode)).getGraphicsContext();
    }

    public static final NodeCoordinator requireLayoutCoordinates(DelegatableNode delegatableNode) {
        if (!((Modifier.Node) delegatableNode).node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        NodeCoordinator nodeCoordinatorM547requireCoordinator64DMado = m547requireCoordinator64DMado(delegatableNode, 2);
        if (!nodeCoordinatorM547requireCoordinator64DMado.getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }
        return nodeCoordinatorM547requireCoordinator64DMado;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        NodeCoordinator nodeCoordinator = ((Modifier.Node) delegatableNode).node.coordinator;
        if (nodeCoordinator != null) {
            return nodeCoordinator.layoutNode;
        }
        throw Modifier.CC.m("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Owner owner = requireLayoutNode(delegatableNode).owner;
        if (owner != null) {
            return owner;
        }
        throw Modifier.CC.m("This node does not have an owner.");
    }

    public static final View requireView(Modifier.Node node) {
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get View because the Modifier node is not currently attached.");
        }
        return (View) LayoutNodeKt.requireOwner(requireLayoutNode(node));
    }

    public static final void traverseAncestors(DelegatableNode delegatableNode, Object obj, Function1 function1) {
        NodeChain nodeChain;
        boolean z;
        Modifier.Node node = (Modifier.Node) delegatableNode;
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = node.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node2 != null) {
                    if ((node2.kindSet & 262144) != 0) {
                        Modifier.Node nodeAccess$pop = node2;
                        MutableVector mutableVector = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodeAccess$pop;
                                if (!(obj.equals(traversableNode.getTraverseKey()) ? ((Boolean) function1.invoke(traversableNode)).booleanValue() : true)) {
                                    return;
                                } else {
                                    z = false;
                                }
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (((nodeAccess$pop.kindSet & 262144) != 0) && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                        if ((node3.kindSet & 262144) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodeAccess$pop = node3;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodeAccess$pop != null) {
                                                    mutableVector.add(nodeAccess$pop);
                                                    nodeAccess$pop = null;
                                                }
                                                mutableVector.add(node3);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                            }
                            nodeAccess$pop = access$pop(mutableVector);
                        }
                    }
                    node2 = node2.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v8 */
    public static final void traverseDescendants(Modifier.Node node, String str, Function1 function1) {
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node2 = node.node;
        Modifier.Node node3 = node2.child;
        if (node3 == null) {
            access$addLayoutNodeChildren(mutableVector, node2);
        } else {
            mutableVector.add(node3);
        }
        while (true) {
            int i = mutableVector.size;
            if (i == 0) {
                return;
            }
            Modifier.Node node4 = (Modifier.Node) mutableVector.removeAt(i - 1);
            if ((node4.aggregateChildKindSet & 262144) != 0) {
                Modifier.Node node5 = node4;
                while (true) {
                    if (node5 != null && node5.isAttached) {
                        if ((node5.kindSet & 262144) != 0) {
                            ?? Access$pop = node5;
                            ?? mutableVector2 = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) Access$pop;
                                    TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = str.equals(traversableNode.getTraverseKey()) ? (TraversableNode$Companion$TraverseDescendantsAction) function1.invoke(traversableNode) : TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                                    if (traversableNode$Companion$TraverseDescendantsAction != TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal) {
                                        if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((Access$pop.kindSet & 262144) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node6 = ((DelegatingNode) Access$pop).delegate;
                                    int i2 = 0;
                                    Access$pop = Access$pop;
                                    mutableVector2 = mutableVector2;
                                    while (node6 != null) {
                                        if ((node6.kindSet & 262144) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                mutableVector2 = mutableVector2;
                                                Access$pop = node6;
                                            } else {
                                                if (mutableVector2 == 0) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector2.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector2.add(node6);
                                            }
                                        }
                                        node6 = node6.child;
                                        Access$pop = Access$pop;
                                        mutableVector2 = mutableVector2;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Access$pop = access$pop(mutableVector2);
                            }
                        }
                        node5 = node5.child;
                    }
                }
            }
            access$addLayoutNodeChildren(mutableVector, node4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateLayerBlock(LayoutModifierNode layoutModifierNode, Function1 function1) {
        NodeCoordinator nodeCoordinator;
        if (((Modifier.Node) layoutModifierNode).node.isAttached && (nodeCoordinator = m547requireCoordinator64DMado(layoutModifierNode, 2).wrapped) != null) {
            nodeCoordinator.updateLayerBlock(function1, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void traverseAncestors(TraversableNode traversableNode, Function1 function1) {
        NodeChain nodeChain;
        boolean z;
        Modifier.Node node = (Modifier.Node) traversableNode;
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = node.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(traversableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node2 != null) {
                    if ((node2.kindSet & 262144) != 0) {
                        Modifier.Node nodeAccess$pop = node2;
                        MutableVector mutableVector = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof TraversableNode) {
                                TraversableNode traversableNode2 = (TraversableNode) nodeAccess$pop;
                                if (!((Intrinsics.areEqual(traversableNode.getTraverseKey(), traversableNode2.getTraverseKey()) && traversableNode.getClass() == traversableNode2.getClass()) ? ((Boolean) function1.invoke(traversableNode2)).booleanValue() : true)) {
                                    return;
                                } else {
                                    z = false;
                                }
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (((nodeAccess$pop.kindSet & 262144) != 0) && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                        if ((node3.kindSet & 262144) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodeAccess$pop = node3;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodeAccess$pop != null) {
                                                    mutableVector.add(nodeAccess$pop);
                                                    nodeAccess$pop = null;
                                                }
                                                mutableVector.add(node3);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                            }
                            nodeAccess$pop = access$pop(mutableVector);
                        }
                    }
                    node2 = node2.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [androidx.compose.ui.node.TraversableNode, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final void traverseDescendants(TraversableNode traversableNode, Function1 function1) {
        TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction;
        Modifier.Node node = (Modifier.Node) traversableNode;
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node2 = node.node;
        Modifier.Node node3 = node2.child;
        if (node3 == null) {
            access$addLayoutNodeChildren(mutableVector, node2);
        } else {
            mutableVector.add(node3);
        }
        while (true) {
            int i = mutableVector.size;
            if (i == 0) {
                return;
            }
            Modifier.Node node4 = (Modifier.Node) mutableVector.removeAt(i - 1);
            if ((node4.aggregateChildKindSet & 262144) != 0) {
                Modifier.Node node5 = node4;
                while (true) {
                    if (node5 != null && node5.isAttached) {
                        if ((node5.kindSet & 262144) != 0) {
                            ?? Access$pop = node5;
                            ?? mutableVector2 = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof TraversableNode) {
                                    TraversableNode traversableNode2 = (TraversableNode) Access$pop;
                                    if (Intrinsics.areEqual(traversableNode.getTraverseKey(), traversableNode2.getTraverseKey()) && traversableNode.getClass() == traversableNode2.getClass()) {
                                        traversableNode$Companion$TraverseDescendantsAction = (TraversableNode$Companion$TraverseDescendantsAction) function1.invoke(traversableNode2);
                                    } else {
                                        traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                                    }
                                    if (traversableNode$Companion$TraverseDescendantsAction != TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal) {
                                        if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((Access$pop.kindSet & 262144) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node6 = ((DelegatingNode) Access$pop).delegate;
                                    int i2 = 0;
                                    Access$pop = Access$pop;
                                    mutableVector2 = mutableVector2;
                                    while (node6 != null) {
                                        if ((node6.kindSet & 262144) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                mutableVector2 = mutableVector2;
                                                Access$pop = node6;
                                            } else {
                                                if (mutableVector2 == 0) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector2.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector2.add(node6);
                                            }
                                        }
                                        node6 = node6.child;
                                        Access$pop = Access$pop;
                                        mutableVector2 = mutableVector2;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Access$pop = access$pop(mutableVector2);
                            }
                        }
                        node5 = node5.child;
                    }
                }
            }
            access$addLayoutNodeChildren(mutableVector, node4);
        }
    }
}
