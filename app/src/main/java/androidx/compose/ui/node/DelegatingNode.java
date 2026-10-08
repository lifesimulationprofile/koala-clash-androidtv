package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DelegatingNode extends Modifier.Node {
    public Modifier.Node delegate;
    public final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    public final DelegatableNode delegate(DelegatableNode delegatableNode) {
        Modifier.Node node = ((Modifier.Node) delegatableNode).node;
        if (node != delegatableNode) {
            Modifier.Node node2 = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            Modifier.Node node3 = node2 != null ? node2.parent : null;
            if (node != this.node || !Intrinsics.areEqual(node3, this)) {
                throw new IllegalStateException("Cannot delegate to an already delegated node");
            }
        } else {
            if (node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
            }
            node.setAsDelegateTo$ui(this.node);
            int i = this.kindSet;
            int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
            node.kindSet = iCalculateNodeKindSetFromIncludingDelegates;
            int i2 = this.kindSet;
            int i3 = iCalculateNodeKindSetFromIncludingDelegates & 2;
            if (i3 != 0 && (i2 & 2) != 0 && !(this instanceof LayoutModifierNode)) {
                InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + node);
            }
            node.child = this.delegate;
            this.delegate = node;
            node.parent = this;
            updateNodeKindSet(iCalculateNodeKindSetFromIncludingDelegates | this.kindSet, false);
            if (this.isAttached) {
                if (i3 == 0 || (i & 2) != 0) {
                    updateCoordinator$ui(this.coordinator);
                } else {
                    NodeChain nodeChain = HitTestResultKt.requireLayoutNode(this).nodes;
                    this.node.updateCoordinator$ui(null);
                    nodeChain.syncCoordinators();
                }
                node.markAsAttached$ui();
                node.runAttachLifecycle$ui();
                if (!node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
                }
                NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 1);
            }
        }
        return delegatableNode;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void markAsAttached$ui() {
        super.markAsAttached$ui();
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.updateCoordinator$ui(this.coordinator);
            if (!node.isAttached) {
                node.markAsAttached$ui();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void markAsDetached$ui() {
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.markAsDetached$ui();
        }
        super.markAsDetached$ui();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void reset$ui() {
        super.reset$ui();
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.reset$ui();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void runAttachLifecycle$ui() {
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.runAttachLifecycle$ui();
        }
        super.runAttachLifecycle$ui();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void runDetachLifecycle$ui() {
        super.runDetachLifecycle$ui();
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.runDetachLifecycle$ui();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void setAsDelegateTo$ui(Modifier.Node node) {
        this.node = node;
        for (Modifier.Node node2 = this.delegate; node2 != null; node2 = node2.child) {
            node2.setAsDelegateTo$ui(node);
        }
    }

    public final void undelegate(DelegatableNode delegatableNode) {
        Modifier.Node node = null;
        for (Modifier.Node node2 = this.delegate; node2 != null; node2 = node2.child) {
            if (node2 == delegatableNode) {
                boolean z = node2.isAttached;
                if (z) {
                    MutableObjectIntMap mutableObjectIntMap = NodeKindKt.classToKindSetMap;
                    if (!z) {
                        InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
                    }
                    NodeKindKt.autoInvalidateNodeIncludingDelegates(node2, -1, 2);
                    node2.runDetachLifecycle$ui();
                    node2.markAsDetached$ui();
                }
                node2.setAsDelegateTo$ui(node2);
                node2.aggregateChildKindSet = 0;
                if (node == null) {
                    this.delegate = node2.child;
                } else {
                    node.child = node2.child;
                }
                node2.child = null;
                node2.parent = null;
                int i = this.kindSet;
                int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
                updateNodeKindSet(iCalculateNodeKindSetFromIncludingDelegates, true);
                if (this.isAttached && (i & 2) != 0 && (iCalculateNodeKindSetFromIncludingDelegates & 2) == 0) {
                    NodeChain nodeChain = HitTestResultKt.requireLayoutNode(this).nodes;
                    this.node.updateCoordinator$ui(null);
                    nodeChain.syncCoordinators();
                    return;
                }
                return;
            }
            node = node2;
        }
        throw new IllegalStateException(("Could not find delegate: " + delegatableNode).toString());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void updateCoordinator$ui(NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.updateCoordinator$ui(nodeCoordinator);
        }
    }

    public final void updateNodeKindSet(int i, boolean z) {
        Modifier.Node node;
        int i2 = this.kindSet;
        this.kindSet = i;
        if (i2 != i) {
            Modifier.Node node2 = this.node;
            if (node2 == this) {
                this.aggregateChildKindSet = i;
            }
            if (this.isAttached) {
                Modifier.Node node3 = this;
                while (node3 != null) {
                    i |= node3.kindSet;
                    node3.kindSet = i;
                    if (node3 == node2) {
                        break;
                    } else {
                        node3 = node3.parent;
                    }
                }
                if (z && node3 == node2) {
                    i = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node2);
                    node2.kindSet = i;
                }
                int i3 = i | ((node3 == null || (node = node3.child) == null) ? 0 : node.aggregateChildKindSet);
                while (node3 != null) {
                    i3 |= node3.kindSet;
                    node3.aggregateChildKindSet = i3;
                    node3 = node3.parent;
                }
            }
        }
    }
}
