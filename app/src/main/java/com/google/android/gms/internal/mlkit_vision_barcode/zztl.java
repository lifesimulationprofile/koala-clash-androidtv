package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zztl {
    public static final Object bringIntoView(DelegatableNode delegatableNode, Function0 function0, ContinuationImpl continuationImpl) {
        Object obj;
        NodeChain nodeChain;
        Modifier.Node node = (Modifier.Node) delegatableNode;
        boolean z = node.node.isAttached;
        if (!z) {
            return Unit.INSTANCE;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = node.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(delegatableNode);
        loop0: while (true) {
            obj = null;
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 524288) != 0) {
                while (node2 != null) {
                    if ((node2.kindSet & 524288) != 0) {
                        Modifier.Node nodeAccess$pop = node2;
                        MutableVector mutableVector = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof BringIntoViewModifierNode) {
                                obj = nodeAccess$pop;
                                break loop0;
                            }
                            if ((nodeAccess$pop.kindSet & 524288) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 524288) != 0) {
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
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                        }
                    }
                    node2 = node2.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        BringIntoViewModifierNode bringIntoViewModifierNode = (BringIntoViewModifierNode) obj;
        if (bringIntoViewModifierNode == null) {
            return Unit.INSTANCE;
        }
        NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(delegatableNode);
        Object objBringIntoView = bringIntoViewModifierNode.bringIntoView(nodeCoordinatorRequireLayoutCoordinates, new DialogHostKt$DialogHost$1$1$1(8, function0, nodeCoordinatorRequireLayoutCoordinates), continuationImpl);
        return objBringIntoView == CoroutineSingletons.COROUTINE_SUSPENDED ? objBringIntoView : Unit.INSTANCE;
    }
}
