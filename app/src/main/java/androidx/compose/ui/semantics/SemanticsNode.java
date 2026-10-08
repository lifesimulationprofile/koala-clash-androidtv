package androidx.compose.ui.semantics;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.navigation.Navigator;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNode {
    public SemanticsNode fakeNodeParent;
    public final int id;
    public final LayoutNode layoutNode;
    public final boolean mergingEnabled;
    public final Modifier.Node outerSemanticsNode;
    public final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node node, boolean z, LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        this.outerSemanticsNode = node;
        this.mergingEnabled = z;
        this.layoutNode = layoutNode;
        this.unmergedConfig = semanticsConfiguration;
        this.id = layoutNode.semanticsId;
    }

    public static /* synthetic */ List getChildren$ui$default(int i, SemanticsNode semanticsNode) {
        return semanticsNode.getChildren$ui((i & 1) != 0 ? !semanticsNode.mergingEnabled : false, (i & 2) == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
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
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public final Rect boundsInImportantForBoundsAncestor(NodeCoordinator nodeCoordinator) {
        ?? Access$pop;
        SemanticsNode parent = getParent();
        if (parent == null) {
            return Rect.Zero;
        }
        Modifier.Node node = (Modifier.Node) parent.layoutNode.nodes.head;
        if ((node.aggregateChildKindSet & 8) == 0) {
            Access$pop = 0;
            break;
        }
        loop0: while (true) {
            if (node != null) {
                if ((node.kindSet & 8) != 0) {
                    Access$pop = node;
                    ?? mutableVector = 0;
                    while (Access$pop != 0) {
                        if (Access$pop instanceof SemanticsModifierNode) {
                            if (((SemanticsModifierNode) Access$pop).isImportantForBounds()) {
                                break loop0;
                            }
                        } else if ((Access$pop.kindSet & 8) != 0 && (Access$pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                            int i = 0;
                            while (node2 != null) {
                                if ((node2.kindSet & 8) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            } else {
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            }
                        }
                        Access$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                }
                if ((node.aggregateChildKindSet & 8) != 0) {
                    node = node.child;
                }
            }
            Access$pop = 0;
            break;
        }
        SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) Access$pop;
        NodeCoordinator nodeCoordinatorM547requireCoordinator64DMado = semanticsModifierNode != null ? HitTestResultKt.m547requireCoordinator64DMado(semanticsModifierNode, 8) : null;
        return nodeCoordinatorM547requireCoordinator64DMado == null ? parent.boundsInImportantForBoundsAncestor(nodeCoordinator) : nodeCoordinatorM547requireCoordinator64DMado.localBoundingBoxOf(nodeCoordinator, true);
    }

    /* JADX INFO: renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    public final SemanticsNode m615fakeSemanticsNodeypyhhiA(Role role, Function1 function1) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = false;
        semanticsConfiguration.isClearingSemantics = false;
        function1.invoke(semanticsConfiguration);
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1), false, new LayoutNode(this.id + (role != null ? 1000000000 : 2000000000), true), semanticsConfiguration);
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    public final void fillOneLayerOfSemanticsWrappers(LayoutNode layoutNode, ArrayList arrayList) {
        MutableVector zSortedChildren = layoutNode.getZSortedChildren();
        Object[] objArr = zSortedChildren.content;
        int i = zSortedChildren.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.isAttached() && !layoutNode2.isDeactivated) {
                if (layoutNode2.nodes.m565hasH91voCI$ui(8)) {
                    arrayList.add(SemanticsNodeKt.SemanticsNode(layoutNode2, this.mergingEnabled));
                } else {
                    fillOneLayerOfSemanticsWrappers(layoutNode2, arrayList);
                }
            }
        }
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui() {
        if (!isFake$ui()) {
            SemanticsModifierNode semanticsModifierNodeFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
            return semanticsModifierNodeFindSemanticsModifierNodeToGetBounds != null ? HitTestResultKt.m547requireCoordinator64DMado(semanticsModifierNodeFindSemanticsModifierNodeToGetBounds, 8) : (InnerNodeCoordinator) this.layoutNode.nodes.innerCoordinator;
        }
        SemanticsNode parent = getParent();
        if (parent != null) {
            return parent.findCoordinatorToGetBounds$ui();
        }
        return null;
    }

    public final void findOneLayerOfMergingSemanticsNodes(ArrayList arrayList, ArrayList arrayList2) {
        unmergedChildren$ui(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = (SemanticsNode) arrayList.get(size2);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                arrayList2.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(arrayList, arrayList2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public final SemanticsModifierNode findSemanticsModifierNodeToGetBounds() {
        ?? Access$pop;
        boolean z;
        ?? r2;
        boolean z2 = this.unmergedConfig.isMergingSemanticsOfDescendants;
        LayoutNode layoutNode = this.layoutNode;
        ?? r5 = 0;
        r5 = 0;
        r5 = 0;
        r5 = 0;
        if (!z2) {
            Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
            if ((node.aggregateChildKindSet & 8) != 0) {
                loop3: while (node != null) {
                    if ((node.kindSet & 8) != 0) {
                        Access$pop = node;
                        ?? mutableVector = 0;
                        while (true) {
                            if (Access$pop != 0) {
                                if (Access$pop instanceof SemanticsModifierNode) {
                                    if (((SemanticsModifierNode) Access$pop).isImportantForBounds()) {
                                        r5 = Access$pop;
                                    }
                                } else if ((Access$pop.kindSet & 8) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                                    int i = 0;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 8) != 0) {
                                            i++;
                                            if (i == 1) {
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
                                    if (i == 1) {
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    } else {
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    }
                                }
                                Access$pop = HitTestResultKt.access$pop(mutableVector);
                            }
                        }
                    }
                    if ((node.aggregateChildKindSet & 8) == 0) {
                        break;
                    }
                    node = node.child;
                }
            }
        } else {
            Modifier.Node node3 = (Modifier.Node) layoutNode.nodes.head;
            if ((node3.aggregateChildKindSet & 8) != 0) {
                Access$pop = 0;
                while (node3 != null) {
                    if ((node3.kindSet & 8) != 0) {
                        Modifier.Node nodeAccess$pop = node3;
                        MutableVector mutableVector2 = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof SemanticsModifierNode) {
                                SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) nodeAccess$pop;
                                if (semanticsModifierNode.isImportantForBounds()) {
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        r2 = Access$pop;
                                        r2 = Access$pop;
                                        return semanticsModifierNode;
                                    }
                                    if (Access$pop == 0) {
                                        r2 = semanticsModifierNode;
                                    }
                                }
                                r2 = Access$pop;
                                z = false;
                                Access$pop = r2;
                            } else {
                                z = true;
                            }
                            if (z) {
                                Access$pop = Access$pop;
                                if ((nodeAccess$pop.kindSet & 8) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node node4 = ((DelegatingNode) nodeAccess$pop).delegate; node4 != null; node4 = node4.child) {
                                        if ((node4.kindSet & 8) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodeAccess$pop = node4;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodeAccess$pop != null) {
                                                    mutableVector2.add(nodeAccess$pop);
                                                    nodeAccess$pop = null;
                                                }
                                                mutableVector2.add(node4);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                            } else {
                                Access$pop = Access$pop;
                            }
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector2);
                        }
                    }
                    if ((node3.aggregateChildKindSet & 8) == 0) {
                        break;
                    }
                    node3 = node3.child;
                    Access$pop = Access$pop;
                }
                r5 = Access$pop;
            }
        }
        return (SemanticsModifierNode) r5;
    }

    public final Rect getBoundsInRoot() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                return RulerKt.findRootCoordinates(nodeCoordinatorFindCoordinatorToGetBounds$ui).localBoundingBoxOf(nodeCoordinatorFindCoordinatorToGetBounds$ui, true);
            }
        }
        return Rect.Zero;
    }

    public final Rect getBoundsInWindow() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                return RulerKt.boundsInWindow(nodeCoordinatorFindCoordinatorToGetBounds$ui, true);
            }
        }
        return Rect.Zero;
    }

    public final List getChildren$ui(boolean z, boolean z2) {
        if (!z && this.unmergedConfig.isClearingSemantics) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        if (!isMergingSemanticsOfDescendants()) {
            return unmergedChildren$ui(arrayList, z2);
        }
        ArrayList arrayList2 = new ArrayList();
        findOneLayerOfMergingSemanticsNodes(arrayList, arrayList2);
        return arrayList2;
    }

    public final SemanticsConfiguration getConfig() {
        boolean zIsMergingSemanticsOfDescendants = isMergingSemanticsOfDescendants();
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        if (!zIsMergingSemanticsOfDescendants) {
            return semanticsConfiguration;
        }
        SemanticsConfiguration semanticsConfigurationCopy = semanticsConfiguration.copy();
        mergeConfig(new ArrayList(), semanticsConfigurationCopy);
        return semanticsConfigurationCopy;
    }

    public final SemanticsNode getParent() {
        LayoutNode parent$ui;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode layoutNode = this.layoutNode;
        boolean z = this.mergingEnabled;
        if (!z) {
            parent$ui = null;
            break;
        }
        parent$ui = layoutNode.getParent$ui();
        while (true) {
            if (parent$ui == null) {
                parent$ui = null;
                break;
            }
            SemanticsConfiguration semanticsConfiguration = parent$ui.getSemanticsConfiguration();
            if (semanticsConfiguration != null && semanticsConfiguration.isMergingSemanticsOfDescendants) {
                break;
            }
            parent$ui = parent$ui.getParent$ui();
        }
        if (parent$ui == null) {
            for (LayoutNode parent$ui2 = layoutNode.getParent$ui(); parent$ui2 != null; parent$ui2 = parent$ui2.getParent$ui()) {
                if (parent$ui2.nodes.m565hasH91voCI$ui(8)) {
                    parent$ui = parent$ui2;
                }
            }
            parent$ui = null;
        }
        if (parent$ui == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(parent$ui, z);
    }

    public final Rect getTouchBoundsInRoot() {
        Object objFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
        if (objFindSemanticsModifierNodeToGetBounds == null) {
            return ((InnerNodeCoordinator) this.layoutNode.nodes.innerCoordinator).touchBoundsInRoot();
        }
        Modifier.Node node = ((Modifier.Node) objFindSemanticsModifierNodeToGetBounds).node;
        Object obj = this.unmergedConfig.props.get(SemanticsActions.OnClick);
        if (obj == null) {
            obj = null;
        }
        return HitTestResultKt.effectiveBoundsInRoot(node, obj != null, true);
    }

    public final SemanticsConfiguration getUnmergedConfig$ui() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui() {
        return this.fakeNodeParent != null;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public final boolean isUnmergedLeafNode$ui() {
        if (isFake$ui() || !getChildren$ui$default(4, this).isEmpty()) {
            return false;
        }
        LayoutNode parent$ui = this.layoutNode.getParent$ui();
        while (parent$ui != null) {
            SemanticsConfiguration semanticsConfiguration = parent$ui.getSemanticsConfiguration();
            if (semanticsConfiguration != null && semanticsConfiguration.isMergingSemanticsOfDescendants) {
                if (parent$ui == null) {
                    return true;
                }
                return false;
            }
            parent$ui = parent$ui.getParent$ui();
        }
        parent$ui = null;
        if (parent$ui == null) {
            return true;
        }
        return false;
    }

    public final void mergeConfig(ArrayList arrayList, SemanticsConfiguration semanticsConfiguration) {
        if (this.unmergedConfig.isClearingSemantics) {
            return;
        }
        unmergedChildren$ui(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = (SemanticsNode) arrayList.get(size2);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                semanticsConfiguration.mergeChild$ui(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(arrayList, semanticsConfiguration);
            }
        }
    }

    public final List unmergedChildren$ui(ArrayList arrayList, boolean z) {
        if (isFake$ui()) {
            return EmptyList.INSTANCE;
        }
        fillOneLayerOfSemanticsWrappers(this.layoutNode, arrayList);
        if (z) {
            SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
            Object obj = mutableScatterMap.get(SemanticsProperties.Role);
            if (obj == null) {
                obj = null;
            }
            Role role = (Role) obj;
            if (role != null && semanticsConfiguration.isMergingSemanticsOfDescendants && !arrayList.isEmpty()) {
                arrayList.add(m615fakeSemanticsNodeypyhhiA(role, new Navigator.AnonymousClass1(25, role)));
            }
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
            if (mutableScatterMap.containsKey(semanticsPropertyKey) && !arrayList.isEmpty() && semanticsConfiguration.isMergingSemanticsOfDescendants) {
                Object obj2 = mutableScatterMap.get(semanticsPropertyKey);
                if (obj2 == null) {
                    obj2 = null;
                }
                List list = (List) obj2;
                String str = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
                if (str != null) {
                    arrayList.add(0, m615fakeSemanticsNodeypyhhiA(null, new Navigator.AnonymousClass1(26, str)));
                }
            }
        }
        return arrayList;
    }
}
