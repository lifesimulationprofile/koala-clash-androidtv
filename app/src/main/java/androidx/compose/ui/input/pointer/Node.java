package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.PointerInputModifierNode;
import coil.memory.RealWeakMemoryCache;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Node extends NodeParent {
    public NodeCoordinator coordinates;
    public boolean hasExited;
    public boolean isIn;
    public final Modifier.Node modifierNode;
    public PointerEvent pointerEvent;
    public final RealWeakMemoryCache pointerIds;
    public final LongSparseArray relevantChanges;
    public boolean wasIn;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
        RealWeakMemoryCache realWeakMemoryCache = new RealWeakMemoryCache(7, false);
        realWeakMemoryCache.cache = new long[2];
        this.pointerIds = realWeakMemoryCache;
        this.relevantChanges = new LongSparseArray(2);
        this.isIn = true;
        this.hasExited = true;
    }

    /* JADX WARN: Code duplicated, block: B:159:0x02e2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
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
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final boolean buildCache(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, RequestService requestService, boolean z) {
        LongSparseArray longSparseArray2;
        RealWeakMemoryCache realWeakMemoryCache;
        Object obj;
        boolean z2;
        boolean z3;
        PointerEvent pointerEvent;
        int i;
        int i2;
        boolean z4;
        boolean zBuildCache = super.buildCache(longSparseArray, layoutCoordinates, requestService, z);
        ?? Access$pop = this.modifierNode;
        boolean z5 = true;
        if (Access$pop.isAttached) {
            ?? mutableVector = 0;
            while (Access$pop != 0) {
                if (Access$pop instanceof PointerInputModifierNode) {
                    this.coordinates = HitTestResultKt.m547requireCoordinator64DMado((PointerInputModifierNode) Access$pop, 16);
                } else if ((Access$pop.kindSet & 16) != 0 && (Access$pop instanceof DelegatingNode)) {
                    Modifier.Node node = ((DelegatingNode) Access$pop).delegate;
                    int i3 = 0;
                    while (node != null) {
                        if ((node.kindSet & 16) != 0) {
                            i3++;
                            if (i3 == 1) {
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
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
                        } else {
                            Access$pop = Access$pop;
                            mutableVector = mutableVector;
                        }
                        node = node.child;
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
            if (this.coordinates != null) {
                int size = longSparseArray.size();
                int i4 = 0;
                while (true) {
                    longSparseArray2 = this.relevantChanges;
                    realWeakMemoryCache = this.pointerIds;
                    if (i4 >= size) {
                        break;
                    }
                    long jKeyAt = longSparseArray.keyAt(i4);
                    PointerInputChange pointerInputChange = (PointerInputChange) longSparseArray.valueAt(i4);
                    if (realWeakMemoryCache.contains(jKeyAt)) {
                        boolean z6 = z5;
                        long j = pointerInputChange.previousPosition;
                        List list = pointerInputChange._historical;
                        long j2 = pointerInputChange.position;
                        if ((((j & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0 && (((j2 & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                            z4 = z6;
                            EmptyList emptyList = EmptyList.INSTANCE;
                            ArrayList arrayList = new ArrayList((list == null ? emptyList : list).size());
                            if (list == null) {
                                list = emptyList;
                            }
                            int size2 = list.size();
                            int i5 = 0;
                            while (i5 < size2) {
                                int i6 = size2;
                                HistoricalChange historicalChange = (HistoricalChange) list.get(i5);
                                long j3 = jKeyAt;
                                List list2 = list;
                                long j4 = historicalChange.position;
                                if ((((j4 & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                                    arrayList.add(new HistoricalChange(historicalChange.uptimeMillis, this.coordinates.mo524localPositionOfS_NoaFU(layoutCoordinates, j4), historicalChange.scaleFactor, historicalChange.panOffset, historicalChange.originalEventPosition));
                                }
                                i5++;
                                list = list2;
                                size2 = i6;
                                jKeyAt = j3;
                                pointerInputChange = pointerInputChange;
                            }
                            long j5 = jKeyAt;
                            PointerInputChange pointerInputChange2 = new PointerInputChange(pointerInputChange.id, pointerInputChange.uptimeMillis, this.coordinates.mo524localPositionOfS_NoaFU(layoutCoordinates, j2), pointerInputChange.pressed, pointerInputChange.pressure, pointerInputChange.previousUptimeMillis, this.coordinates.mo524localPositionOfS_NoaFU(layoutCoordinates, j), pointerInputChange.previousPressed, pointerInputChange.type, arrayList, pointerInputChange.scrollDelta, pointerInputChange.scaleFactor, pointerInputChange.panOffset, pointerInputChange.originalEventPosition);
                            PointerInputChange pointerInputChange3 = pointerInputChange.consumedDelegate;
                            if (pointerInputChange3 == null) {
                                pointerInputChange3 = pointerInputChange;
                            }
                            pointerInputChange2.consumedDelegate = pointerInputChange3;
                            PointerInputChange pointerInputChange4 = pointerInputChange.consumedDelegate;
                            if (pointerInputChange4 != null) {
                                pointerInputChange = pointerInputChange4;
                            }
                            pointerInputChange2.consumedDelegate = pointerInputChange;
                            longSparseArray2.put(j5, pointerInputChange2);
                        } else {
                            z4 = z6;
                        }
                    } else {
                        z4 = z5;
                    }
                    i4++;
                    z5 = z4;
                    size = size;
                    zBuildCache = zBuildCache;
                }
                boolean z7 = zBuildCache;
                boolean z8 = z5;
                if (longSparseArray2.size() == 0) {
                    realWeakMemoryCache.operationsSinceCleanUp = 0;
                    this.children.clear();
                    return z8;
                }
                int i7 = realWeakMemoryCache.operationsSinceCleanUp;
                while (true) {
                    i7--;
                    if (-1 >= i7) {
                        break;
                    }
                    if (longSparseArray.indexOfKey(((long[]) realWeakMemoryCache.cache)[i7]) < 0 && i7 < (i2 = realWeakMemoryCache.operationsSinceCleanUp)) {
                        int i8 = i2 - 1;
                        int i9 = i7;
                        while (i9 < i8) {
                            long[] jArr = (long[]) realWeakMemoryCache.cache;
                            int i10 = i9 + 1;
                            jArr[i9] = jArr[i10];
                            i9 = i10;
                        }
                        realWeakMemoryCache.operationsSinceCleanUp--;
                    }
                }
                ArrayList arrayList2 = new ArrayList(longSparseArray2.size());
                int size3 = longSparseArray2.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    arrayList2.add(longSparseArray2.valueAt(i11));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList2, requestService);
                int size4 = arrayList2.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size4) {
                        obj = null;
                        break;
                    }
                    obj = arrayList2.get(i12);
                    if (requestService.m793activeHoverEvent0FcD4WY(((PointerInputChange) obj).id)) {
                        break;
                    }
                    i12++;
                }
                PointerInputChange pointerInputChange5 = (PointerInputChange) obj;
                if (pointerInputChange5 != null) {
                    boolean z9 = pointerInputChange5.pressed;
                    if (z) {
                        z2 = false;
                        if (!this.isIn && (z9 || pointerInputChange5.previousPressed)) {
                            long j6 = this.coordinates.measuredSize;
                            long j7 = pointerInputChange5.position;
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (j7 >> 32));
                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j7 & 4294967295L));
                            int i13 = (int) (j6 >> 32);
                            this.isIn = !((fIntBitsToFloat2 > ((float) ((int) (j6 & 4294967295L))) ? z8 : false) | (fIntBitsToFloat > ((float) i13) ? z8 : false) | (fIntBitsToFloat < 0.0f ? z8 : false) | (fIntBitsToFloat2 < 0.0f ? z8 : false));
                        }
                    } else {
                        z2 = false;
                        this.isIn = false;
                    }
                    boolean z10 = this.isIn;
                    boolean z11 = this.wasIn;
                    if (z10 == z11 || !((i = pointerEvent2.type) == 3 || i == 4 || i == 5)) {
                        int i14 = pointerEvent2.type;
                        if (i14 == 4 && z11 && !this.hasExited) {
                            pointerEvent2.type = 3;
                        } else if (i14 == 5 && z10 && z9) {
                            pointerEvent2.type = 3;
                        }
                    } else {
                        pointerEvent2.type = z10 ? 4 : 5;
                    }
                } else {
                    z2 = false;
                }
                if (!z7 && pointerEvent2.type == 3 && (pointerEvent = this.pointerEvent) != null) {
                    ?? r1 = pointerEvent.changes;
                    int size5 = r1.size();
                    ?? r5 = pointerEvent2.changes;
                    if (size5 != r5.size()) {
                        z3 = z8;
                        break;
                    }
                    int size6 = r5.size();
                    ?? r6 = z2;
                    while (true) {
                        if (r6 >= size6) {
                            z3 = z2;
                            break;
                        }
                        if (!Offset.m369equalsimpl0(((PointerInputChange) r1.get(r6)).position, ((PointerInputChange) r5.get(r6)).position)) {
                            z3 = z8;
                            break;
                        }
                        r6++;
                    }
                } else {
                    z3 = z8;
                    break;
                }
                this.pointerEvent = pointerEvent2;
                return z3;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final void cleanUpHits(RequestService requestService) {
        super.cleanUpHits(requestService);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        ?? r1 = pointerEvent.changes;
        int size = r1.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = (PointerInputChange) r1.get(i);
            boolean z = pointerInputChange.pressed;
            long j = pointerInputChange.id;
            boolean zM793activeHoverEvent0FcD4WY = requestService.m793activeHoverEvent0FcD4WY(j);
            boolean z2 = this.isIn;
            if ((!z && !zM793activeHoverEvent0FcD4WY) || (!z && !z2)) {
                this.pointerIds.remove(j);
            }
        }
        this.isIn = false;
        this.hasExited = pointerEvent.type == 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final void dispatchCancel() {
        MutableVector mutableVector = this.children;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) objArr[i2]).dispatchCancel();
        }
        ?? Access$pop = this.modifierNode;
        ?? mutableVector2 = 0;
        while (Access$pop != 0) {
            if (Access$pop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) Access$pop).onCancelPointerInput();
            } else if ((Access$pop.kindSet & 16) != 0 && (Access$pop instanceof DelegatingNode)) {
                Modifier.Node node = ((DelegatingNode) Access$pop).delegate;
                int i3 = 0;
                Access$pop = Access$pop;
                mutableVector2 = mutableVector2;
                while (node != null) {
                    if ((node.kindSet & 16) != 0) {
                        i3++;
                        if (i3 == 1) {
                            mutableVector2 = mutableVector2;
                            Access$pop = node;
                        } else {
                            if (mutableVector2 == 0) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                            }
                            if (Access$pop != 0) {
                                mutableVector2.add(Access$pop);
                                Access$pop = 0;
                            }
                            mutableVector2.add(node);
                        }
                    }
                    node = node.child;
                    Access$pop = Access$pop;
                    mutableVector2 = mutableVector2;
                }
                if (i3 == 1) {
                }
            }
            Access$pop = HitTestResultKt.access$pop(mutableVector2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchFinalEventPass(RequestService requestService) {
        Object[] objArr;
        LayoutNode layoutNode;
        LongSparseArray longSparseArray = this.relevantChanges;
        boolean z = false;
        z = false;
        z = false;
        if (longSparseArray.size() != 0) {
            Modifier.Node node = this.modifierNode;
            if (node.isAttached) {
                NodeCoordinator nodeCoordinator = node.coordinator;
                if ((nodeCoordinator == null || (layoutNode = nodeCoordinator.layoutNode) == null) ? false : layoutNode.isPlaced()) {
                    PointerEvent pointerEvent = this.pointerEvent;
                    long j = this.coordinates.measuredSize;
                    Modifier.Node nodeAccess$pop = node;
                    MutableVector mutableVector = null;
                    while (nodeAccess$pop != null) {
                        if (nodeAccess$pop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) nodeAccess$pop).mo36onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, j);
                            objArr = false;
                        } else {
                            objArr = true;
                        }
                        if (objArr != false) {
                            if (((nodeAccess$pop.kindSet & 16) != 0) != false && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                    if (((node2.kindSet & 16) != 0) != false) {
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
                        }
                        nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                    if (node.isAttached) {
                        MutableVector mutableVector2 = this.children;
                        Object[] objArr2 = mutableVector2.content;
                        int i2 = mutableVector2.size;
                        for (int i3 = 0; i3 < i2; i3++) {
                            ((Node) objArr2[i3]).dispatchFinalEventPass(requestService);
                        }
                    }
                    z = true;
                }
            }
        }
        cleanUpHits(requestService);
        longSparseArray.clear();
        this.coordinates = null;
        return z;
    }

    public final boolean dispatchMainEventPass(RequestService requestService, boolean z) {
        boolean z2;
        boolean z3;
        LayoutNode layoutNode;
        if (this.relevantChanges.size() == 0) {
            return false;
        }
        Modifier.Node nodeAccess$pop = this.modifierNode;
        if (nodeAccess$pop.isAttached) {
            NodeCoordinator nodeCoordinator = nodeAccess$pop.coordinator;
            if ((nodeCoordinator == null || (layoutNode = nodeCoordinator.layoutNode) == null) ? false : layoutNode.isPlaced()) {
                PointerEvent pointerEvent = this.pointerEvent;
                long j = this.coordinates.measuredSize;
                Modifier.Node nodeAccess$pop2 = nodeAccess$pop;
                MutableVector mutableVector = null;
                while (nodeAccess$pop2 != null) {
                    if (nodeAccess$pop2 instanceof PointerInputModifierNode) {
                        ((PointerInputModifierNode) nodeAccess$pop2).mo36onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, j);
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        if (((nodeAccess$pop2.kindSet & 16) != 0) && (nodeAccess$pop2 instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node node = ((DelegatingNode) nodeAccess$pop2).delegate; node != null; node = node.child) {
                                if ((node.kindSet & 16) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodeAccess$pop2 = node;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (nodeAccess$pop2 != null) {
                                            mutableVector.add(nodeAccess$pop2);
                                            nodeAccess$pop2 = null;
                                        }
                                        mutableVector.add(node);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                    }
                    nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector);
                }
                if (nodeAccess$pop.isAttached) {
                    MutableVector mutableVector2 = this.children;
                    Object[] objArr = mutableVector2.content;
                    int i2 = mutableVector2.size;
                    for (int i3 = 0; i3 < i2; i3++) {
                        ((Node) objArr[i3]).dispatchMainEventPass(requestService, z);
                    }
                }
                if (nodeAccess$pop.isAttached) {
                    MutableVector mutableVector3 = null;
                    while (nodeAccess$pop != null) {
                        if (nodeAccess$pop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) nodeAccess$pop).mo36onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, j);
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            if (((nodeAccess$pop.kindSet & 16) != 0) && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                    if ((node2.kindSet & 16) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodeAccess$pop = node2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector3.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector3.add(node2);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                        }
                        nodeAccess$pop = HitTestResultKt.access$pop(mutableVector3);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void removeInvalidPointerIdsAndChanges(long j, MutableObjectList mutableObjectList) {
        RealWeakMemoryCache realWeakMemoryCache = this.pointerIds;
        if (realWeakMemoryCache.contains(j) && mutableObjectList.indexOf(this) < 0) {
            realWeakMemoryCache.remove(j);
            this.relevantChanges.remove(j);
        }
        MutableVector mutableVector = this.children;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) objArr[i2]).removeInvalidPointerIdsAndChanges(j, mutableObjectList);
        }
    }

    public final String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + this.children + ", pointerIds=" + this.pointerIds + ')';
    }
}
