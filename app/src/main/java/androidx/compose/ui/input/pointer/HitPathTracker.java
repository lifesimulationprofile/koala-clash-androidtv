package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import coil.request.RequestService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HitPathTracker {
    public boolean clearNodeCacheAfterDispatchedEvent;
    public boolean dispatchCancelAfterDispatchedEvent;
    public boolean dispatchingEvent;
    public boolean removeSpecificNodesAfterDispatchedEvent;
    public final LayoutCoordinates rootCoordinates;
    public final MutableObjectList nodesToRemove = new MutableObjectList();
    public final NodeParent root = new NodeParent();
    public final MutableLongObjectMap hitPointerIdsAndNodesForPruningNonMatches = new MutableLongObjectMap(10);

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x007c  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00fa A[LOOP:2: B:38:0x00a1->B:52:0x00fa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ff A[EDGE_INSN: B:61:0x00ff->B:53:0x00ff BREAK  A[LOOP:2: B:38:0x00a1->B:52:0x00fa], SYNTHETIC] */
    /* JADX INFO: renamed from: addHitPath-QJqDSyo, reason: not valid java name */
    public final void m507addHitPathQJqDSyo(long j, List list, boolean z) {
        MutableLongObjectMap mutableLongObjectMap;
        Node node;
        Object mutableObjectList;
        Object obj;
        int size = list.size();
        NodeParent nodeParent = this.root;
        NodeParent nodeParent2 = nodeParent;
        boolean z2 = true;
        int i = 0;
        while (true) {
            mutableLongObjectMap = this.hitPointerIdsAndNodesForPruningNonMatches;
            if (i >= size) {
                break;
            }
            Modifier.Node node2 = (Modifier.Node) list.get(i);
            if (node2.isAttached) {
                node2.detachedListener = new DialogHostKt$DialogHost$1$1$1(3, this, node2);
                if (z2) {
                    MutableVector mutableVector = nodeParent2.children;
                    Object[] objArr = mutableVector.content;
                    int i2 = mutableVector.size;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= i2) {
                            obj = null;
                            break;
                        }
                        obj = objArr[i3];
                        if (Intrinsics.areEqual(((Node) obj).modifierNode, node2)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    node = (Node) obj;
                    if (node != null) {
                        node.isIn = true;
                        node.pointerIds.add(j);
                        if (z) {
                            Object mutableObjectList2 = mutableLongObjectMap.get(j);
                            if (mutableObjectList2 == null) {
                                mutableObjectList2 = new MutableObjectList();
                                mutableLongObjectMap.set(j, mutableObjectList2);
                            }
                            ((MutableObjectList) mutableObjectList2).add(node);
                        }
                    } else {
                        z2 = false;
                        node = new Node(node2);
                        node.pointerIds.add(j);
                        if (z) {
                            mutableObjectList = mutableLongObjectMap.get(j);
                            if (mutableObjectList == null) {
                                mutableObjectList = new MutableObjectList();
                                mutableLongObjectMap.set(j, mutableObjectList);
                            }
                            ((MutableObjectList) mutableObjectList).add(node);
                        }
                        nodeParent2.children.add(node);
                    }
                } else {
                    node = new Node(node2);
                    node.pointerIds.add(j);
                    if (z) {
                        mutableObjectList = mutableLongObjectMap.get(j);
                        if (mutableObjectList == null) {
                            mutableObjectList = new MutableObjectList();
                            mutableLongObjectMap.set(j, mutableObjectList);
                        }
                        ((MutableObjectList) mutableObjectList).add(node);
                    }
                    nodeParent2.children.add(node);
                }
                nodeParent2 = node;
            }
            i++;
        }
        if (z) {
            long[] jArr = mutableLongObjectMap.keys;
            Object[] objArr2 = mutableLongObjectMap.values;
            long[] jArr2 = mutableLongObjectMap.metadata;
            int length = jArr2.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j2 = jArr2[i4];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i4 != length) {
                            break;
                            break;
                        }
                        i4++;
                    } else {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((255 & j2) < 128) {
                                int i8 = (i4 << 3) + i7;
                                long j3 = jArr[i8];
                                MutableObjectList mutableObjectList3 = (MutableObjectList) objArr2[i8];
                                MutableVector mutableVector2 = nodeParent.children;
                                Object[] objArr3 = mutableVector2.content;
                                int i9 = mutableVector2.size;
                                for (int i10 = 0; i10 < i9; i10++) {
                                    ((Node) objArr3[i10]).removeInvalidPointerIdsAndChanges(j3, mutableObjectList3);
                                }
                            }
                            j2 >>= i5;
                            i7++;
                            i5 = i5;
                        }
                        if (i6 != i5) {
                            break;
                        } else if (i4 != length) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
        }
        mutableLongObjectMap.clear();
    }

    public final boolean dispatchChanges(RequestService requestService, boolean z) {
        LongSparseArray longSparseArray = (LongSparseArray) requestService.systemCallbacks;
        LayoutCoordinates layoutCoordinates = this.rootCoordinates;
        NodeParent nodeParent = this.root;
        boolean zBuildCache = nodeParent.buildCache(longSparseArray, layoutCoordinates, requestService, z);
        MutableVector mutableVector = nodeParent.children;
        if (!zBuildCache) {
            return false;
        }
        boolean z2 = true;
        this.dispatchingEvent = true;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        boolean z3 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z3 = ((Node) objArr[i2]).dispatchMainEventPass(requestService, z) || z3;
        }
        Object[] objArr2 = mutableVector.content;
        int i3 = mutableVector.size;
        boolean z4 = false;
        for (int i4 = 0; i4 < i3; i4++) {
            z4 = ((Node) objArr2[i4]).dispatchFinalEventPass(requestService) || z4;
        }
        nodeParent.cleanUpHits(requestService);
        if (!z4 && !z3) {
            z2 = false;
        }
        this.dispatchingEvent = false;
        if (this.removeSpecificNodesAfterDispatchedEvent) {
            this.removeSpecificNodesAfterDispatchedEvent = false;
            MutableObjectList mutableObjectList = this.nodesToRemove;
            int i5 = mutableObjectList._size;
            for (int i6 = 0; i6 < i5; i6++) {
                removePointerInputModifierNode((Modifier.Node) mutableObjectList.get(i6));
            }
            mutableObjectList.clear();
        }
        if (this.dispatchCancelAfterDispatchedEvent) {
            this.dispatchCancelAfterDispatchedEvent = false;
            processCancel();
        }
        if (this.clearNodeCacheAfterDispatchedEvent) {
            this.clearNodeCacheAfterDispatchedEvent = false;
            nodeParent.children.clear();
        }
        return z2;
    }

    public final void processCancel() {
        if (this.dispatchingEvent) {
            this.dispatchCancelAfterDispatchedEvent = true;
            return;
        }
        NodeParent nodeParent = this.root;
        MutableVector mutableVector = nodeParent.children;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) objArr[i2]).dispatchCancel();
        }
        if (this.clearNodeCacheAfterDispatchedEvent) {
            this.clearNodeCacheAfterDispatchedEvent = true;
        } else {
            nodeParent.children.clear();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void removePointerInputModifierNode(Modifier.Node node) {
        if (this.dispatchingEvent) {
            this.removeSpecificNodesAfterDispatchedEvent = true;
            this.nodesToRemove.add(node);
            return;
        }
        NodeParent nodeParent = this.root;
        MutableObjectList mutableObjectList = nodeParent.removeMatchingPointerInputModifierNodeList;
        mutableObjectList.clear();
        mutableObjectList.add(nodeParent);
        while (mutableObjectList.isNotEmpty()) {
            NodeParent nodeParent2 = (NodeParent) mutableObjectList.removeAt(mutableObjectList._size - 1);
            int i = 0;
            while (true) {
                MutableVector mutableVector = nodeParent2.children;
                if (i < mutableVector.size) {
                    Node node2 = (Node) mutableVector.content[i];
                    if (Intrinsics.areEqual(node2.modifierNode, node)) {
                        nodeParent2.children.remove(node2);
                        node2.dispatchCancel();
                    } else {
                        mutableObjectList.add(node2);
                        i++;
                    }
                }
            }
        }
    }
}
