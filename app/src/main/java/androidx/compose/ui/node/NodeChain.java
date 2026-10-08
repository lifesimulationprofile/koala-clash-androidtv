package androidx.compose.ui.node;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable$ObserverWrapper;
import androidx.collection.MutableObjectIntMap;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.core.view.MenuHostHelper;
import coil.intercept.EngineInterceptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NodeChain {
    public final /* synthetic */ int $r8$classId;
    public Object buffer;
    public Object cachedDiffer;
    public Object current;
    public Object head;
    public final Object innerCoordinator;
    public final Object layoutNode;
    public Object outerCoordinator;
    public final Object sentinelHead;
    public final Object stack;
    public final Object tail;

    public NodeChain(LayoutNode layoutNode) {
        this.$r8$classId = 0;
        this.layoutNode = layoutNode;
        NodeChain$sentinelHead$1 nodeChain$sentinelHead$1 = new NodeChain$sentinelHead$1();
        nodeChain$sentinelHead$1.aggregateChildKindSet = -1;
        this.sentinelHead = nodeChain$sentinelHead$1;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        TailModifierNode tailModifierNode = innerNodeCoordinator.tail;
        this.tail = tailModifierNode;
        this.head = tailModifierNode;
        this.stack = new MutableVector(new Modifier[16]);
    }

    public static final void access$propagateCoordinator(NodeChain nodeChain, Modifier.Node node, NodeCoordinator nodeCoordinator) {
        for (Modifier.Node node2 = node.parent; node2 != null; node2 = node2.parent) {
            if (node2 == ((NodeChain$sentinelHead$1) nodeChain.sentinelHead)) {
                LayoutNode parent$ui = ((LayoutNode) nodeChain.layoutNode).getParent$ui();
                nodeCoordinator.wrappedBy = parent$ui != null ? (InnerNodeCoordinator) parent$ui.nodes.innerCoordinator : null;
                nodeChain.outerCoordinator = nodeCoordinator;
                return;
            } else {
                if ((node2.kindSet & 2) != 0) {
                    return;
                }
                node2.updateCoordinator$ui(nodeCoordinator);
            }
        }
    }

    public static Object anchoredDrag$default(NodeChain nodeChain, Function3 function3, ContinuationImpl continuationImpl) {
        MutatorMutex mutatorMutex = (MutatorMutex) nodeChain.sentinelHead;
        AnchoredDraggableState$anchoredDrag$2 anchoredDraggableState$anchoredDrag$2 = new AnchoredDraggableState$anchoredDrag$2(nodeChain, null, function3);
        mutatorMutex.getClass();
        Object objCoroutineScope = JobKt.coroutineScope(new EngineInterceptor.AnonymousClass2(MutatePriority.Default, mutatorMutex, anchoredDraggableState$anchoredDrag$2, null), continuationImpl);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    public static Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node node) {
        Modifier.Node nodeCreate;
        if (element instanceof ModifierNodeElement) {
            nodeCreate = ((ModifierNodeElement) element).create();
            nodeCreate.kindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(nodeCreate);
        } else {
            BackwardsCompatNode backwardsCompatNode = new BackwardsCompatNode();
            backwardsCompatNode.kindSet = NodeKindKt.calculateNodeKindSetFrom(element);
            backwardsCompatNode.element = element;
            new HashSet();
            nodeCreate = backwardsCompatNode;
        }
        if (nodeCreate.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        nodeCreate.insertedNodeAwaitingAttachForInvalidation = true;
        Modifier.Node node2 = node.child;
        if (node2 != null) {
            node2.parent = nodeCreate;
            nodeCreate.child = node2;
        }
        node.child = nodeCreate;
        nodeCreate.parent = node;
        return nodeCreate;
    }

    public static Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        boolean z = node.isAttached;
        if (z) {
            MutableObjectIntMap mutableObjectIntMap = NodeKindKt.classToKindSetMap;
            if (!z) {
                InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
            }
            NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 2);
            node.runDetachLifecycle$ui();
            node.markAsDetached$ui();
        }
        Modifier.Node node2 = node.child;
        Modifier.Node node3 = node.parent;
        if (node2 != null) {
            node2.parent = node3;
            node.child = null;
        }
        if (node3 != null) {
            node3.child = node2;
            node.parent = null;
        }
        return node3;
    }

    public static void updateNode(Modifier.Element element, Modifier.Element element2, Modifier.Node node) {
        if ((element instanceof ModifierNodeElement) && (element2 instanceof ModifierNodeElement)) {
            ((ModifierNodeElement) element2).update(node);
            if (node.isAttached) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.updatedNodeAwaitingAttachForInvalidation = true;
                return;
            }
        }
        if (!(node instanceof BackwardsCompatNode)) {
            InlineClassHelperKt.throwIllegalStateException("Unknown Modifier.Node type");
            return;
        }
        BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) node;
        boolean z = backwardsCompatNode.isAttached;
        if (z) {
            if (!z) {
                InlineClassHelperKt.throwIllegalStateException("unInitializeModifier called on unattached node");
            }
            if ((backwardsCompatNode.kindSet & 8) != 0) {
                ((AndroidComposeView) HitTestResultKt.requireOwner(backwardsCompatNode)).onSemanticsChange();
            }
        }
        backwardsCompatNode.element = element2;
        backwardsCompatNode.kindSet = NodeKindKt.calculateNodeKindSetFrom(element2);
        if (backwardsCompatNode.isAttached) {
            backwardsCompatNode.initializeModifier(false);
        }
        if (node.isAttached) {
            NodeKindKt.autoInvalidateUpdatedNode(node);
        } else {
            node.updatedNodeAwaitingAttachForInvalidation = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public Object anchoredDrag(Object obj, MutatePriority mutatePriority, Function4 function4, ContinuationImpl continuationImpl) throws Throwable {
        AnchoredDraggableState$anchoredDrag$3 anchoredDraggableState$anchoredDrag$3;
        Throwable th;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) this.buffer;
        if (continuationImpl instanceof AnchoredDraggableState$anchoredDrag$3) {
            anchoredDraggableState$anchoredDrag$3 = (AnchoredDraggableState$anchoredDrag$3) continuationImpl;
            int i = anchoredDraggableState$anchoredDrag$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anchoredDraggableState$anchoredDrag$3.label = i - Integer.MIN_VALUE;
            } else {
                anchoredDraggableState$anchoredDrag$3 = new AnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
            }
        } else {
            anchoredDraggableState$anchoredDrag$3 = new AnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
        }
        Object obj2 = anchoredDraggableState$anchoredDrag$3.result;
        int i2 = anchoredDraggableState$anchoredDrag$3.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            if (getAnchors().hasPositionFor(obj)) {
                try {
                    MutatorMutex mutatorMutex = (MutatorMutex) this.sentinelHead;
                    try {
                        TooltipStateImpl.AnonymousClass2 anonymousClass2 = new TooltipStateImpl.AnonymousClass2(this, obj, function4, continuation, 1);
                        anchoredDraggableState$anchoredDrag$3.label = 1;
                        mutatorMutex.getClass();
                        Object objCoroutineScope = JobKt.coroutineScope(new EngineInterceptor.AnonymousClass2(mutatePriority, mutatorMutex, anonymousClass2, null), anchoredDraggableState$anchoredDrag$3);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objCoroutineScope == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        parcelableSnapshotMutableState.setValue(null);
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        parcelableSnapshotMutableState.setValue(null);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else if (((Boolean) ((Function1) this.layoutNode).invoke(obj)).booleanValue()) {
                ((ParcelableSnapshotMutableState) this.outerCoordinator).setValue(obj);
                setCurrentValue(obj);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.throwOnFailure(obj2);
                parcelableSnapshotMutableState.setValue(null);
            } catch (Throwable th4) {
                th = th4;
                parcelableSnapshotMutableState.setValue(null);
                throw th;
            }
        }
        return Unit.INSTANCE;
    }

    public DefaultDraggableAnchors getAnchors() {
        return (DefaultDraggableAnchors) ((ParcelableSnapshotMutableState) this.stack).getValue();
    }

    public boolean getUsePreModifierChangeBehavior$foundation() {
        return false;
    }

    /* JADX INFO: renamed from: has-H91voCI$ui, reason: not valid java name */
    public boolean m565hasH91voCI$ui(int i) {
        return (i & ((Modifier.Node) this.head).aggregateChildKindSet) != 0;
    }

    public float newOffsetForDelta$foundation(float f) {
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.head;
        return RangesKt.coerceIn((Float.isNaN(parcelableSnapshotMutableFloatState.getFloatValue()) ? 0.0f : parcelableSnapshotMutableFloatState.getFloatValue()) + f, getAnchors().minPosition(), getAnchors().maxPosition());
    }

    public float requireOffset() {
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.head;
        if (Float.isNaN(parcelableSnapshotMutableFloatState.getFloatValue())) {
            androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return parcelableSnapshotMutableFloatState.getFloatValue();
    }

    public void runAttachLifecycle() {
        for (Modifier.Node node = (Modifier.Node) this.head; node != null; node = node.child) {
            node.runAttachLifecycle$ui();
            if (node.insertedNodeAwaitingAttachForInvalidation) {
                MutableObjectIntMap mutableObjectIntMap = NodeKindKt.classToKindSetMap;
                if (!node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
                }
                NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 1);
            }
            if (node.updatedNodeAwaitingAttachForInvalidation) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            }
            node.insertedNodeAwaitingAttachForInvalidation = false;
            node.updatedNodeAwaitingAttachForInvalidation = false;
        }
    }

    public void setCurrentValue(Object obj) {
        ((ParcelableSnapshotMutableState) this.innerCoordinator).setValue(obj);
    }

    /* JADX WARN: Code duplicated, block: B:174:0x0144 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:40:0x010d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:46:0x0120  */
    /* JADX WARN: Code duplicated, block: B:48:0x012a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0142  */
    /* JADX WARN: Code duplicated, block: B:72:0x018c  */
    /* JADX WARN: Code duplicated, block: B:73:0x018f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0193  */
    /* JADX WARN: Code duplicated, block: B:76:0x0196  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:78:0x01a2
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public void structuralUpdate(int r32, androidx.compose.runtime.collection.MutableVector r33, androidx.compose.runtime.collection.MutableVector r34, androidx.compose.ui.Modifier.Node r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.structuralUpdate(int, androidx.compose.runtime.collection.MutableVector, androidx.compose.runtime.collection.MutableVector, androidx.compose.ui.Modifier$Node, boolean):void");
    }

    public void syncCoordinators() {
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        OwnedLayer ownedLayer;
        LayoutNode layoutNode = (LayoutNode) this.layoutNode;
        NodeCoordinator nodeCoordinator = (InnerNodeCoordinator) this.innerCoordinator;
        for (Modifier.Node node = ((TailModifierNode) this.tail).parent; node != null; node = node.parent) {
            LayoutModifierNode layoutModifierNodeAsLayoutModifierNode = HitTestResultKt.asLayoutModifierNode(node);
            if (layoutModifierNodeAsLayoutModifierNode != null) {
                NodeCoordinator nodeCoordinator2 = node.coordinator;
                if (nodeCoordinator2 != null) {
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator2;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.layoutModifierNode;
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui(layoutModifierNodeAsLayoutModifierNode);
                    if (layoutModifierNode != node && (ownedLayer = layoutModifierNodeCoordinator.layer) != null) {
                        ((GraphicsLayerOwnerLayer) ownedLayer).invalidate();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(layoutNode, layoutModifierNodeAsLayoutModifierNode);
                    node.updateCoordinator$ui(layoutModifierNodeCoordinator);
                }
                nodeCoordinator.wrappedBy = layoutModifierNodeCoordinator;
                layoutModifierNodeCoordinator.wrapped = nodeCoordinator;
                nodeCoordinator = layoutModifierNodeCoordinator;
            } else {
                node.updateCoordinator$ui(nodeCoordinator);
            }
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        nodeCoordinator.wrappedBy = parent$ui != null ? (InnerNodeCoordinator) parent$ui.nodes.innerCoordinator : null;
        this.outerCoordinator = nodeCoordinator;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder("[");
                Modifier.Node node = (Modifier.Node) this.head;
                TailModifierNode tailModifierNode = (TailModifierNode) this.tail;
                if (node == tailModifierNode) {
                    sb.append("]");
                } else {
                    while (node != null && node != tailModifierNode) {
                        sb.append(String.valueOf(node));
                        if (node.child == tailModifierNode) {
                            sb.append("]");
                        } else {
                            sb.append(",");
                            node = node.child;
                        }
                    }
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Differ implements Observable {
        public Object after;
        public Object before;
        public Object node;
        public int offset;
        public boolean shouldAttachOnInsert;
        public final Object this$0;

        public Differ(Object obj) {
            this.node = new Object();
            this.offset = 0;
            this.shouldAttachOnInsert = false;
            this.after = new HashMap();
            this.this$0 = new CopyOnWriteArraySet();
            this.before = new AtomicReference(obj);
        }

        @Override // androidx.camera.core.impl.Observable
        public void addObserver(Executor executor, Observable.Observer observer) {
            StateObservable$ObserverWrapper stateObservable$ObserverWrapper;
            synchronized (this.node) {
                StateObservable$ObserverWrapper stateObservable$ObserverWrapper2 = (StateObservable$ObserverWrapper) ((HashMap) this.after).remove(observer);
                if (stateObservable$ObserverWrapper2 != null) {
                    stateObservable$ObserverWrapper2.mActive.set(false);
                    ((CopyOnWriteArraySet) this.this$0).remove(stateObservable$ObserverWrapper2);
                }
                stateObservable$ObserverWrapper = new StateObservable$ObserverWrapper((AtomicReference) this.before, executor, observer);
                ((HashMap) this.after).put(observer, stateObservable$ObserverWrapper);
                ((CopyOnWriteArraySet) this.this$0).add(stateObservable$ObserverWrapper);
            }
            stateObservable$ObserverWrapper.update(0);
        }

        public boolean areItemsTheSame(int i, int i2) {
            MutableVector mutableVector = (MutableVector) this.before;
            int i3 = this.offset;
            Modifier.Element element = (Modifier.Element) mutableVector.content[i + i3];
            Modifier.Element element2 = (Modifier.Element) ((MutableVector) this.after).content[i3 + i2];
            return Intrinsics.areEqual(element, element2) || element.getClass() == element2.getClass();
        }

        @Override // androidx.camera.core.impl.Observable
        public void removeObserver(Observable.Observer observer) {
            synchronized (this.node) {
                StateObservable$ObserverWrapper stateObservable$ObserverWrapper = (StateObservable$ObserverWrapper) ((HashMap) this.after).remove(observer);
                if (stateObservable$ObserverWrapper != null) {
                    stateObservable$ObserverWrapper.mActive.set(false);
                    ((CopyOnWriteArraySet) this.this$0).remove(stateObservable$ObserverWrapper);
                }
            }
        }

        public Differ(NodeChain nodeChain, Modifier.Node node, int i, MutableVector mutableVector, MutableVector mutableVector2, boolean z) {
            this.this$0 = nodeChain;
            this.node = node;
            this.offset = i;
            this.before = mutableVector;
            this.after = mutableVector2;
            this.shouldAttachOnInsert = z;
        }
    }

    public NodeChain(Object obj, Function1 function1) {
        this.$r8$classId = 1;
        this.layoutNode = new BorderKt$$ExternalSyntheticLambda1(29);
        this.sentinelHead = new MutatorMutex();
        this.innerCoordinator = Stack.mutableStateOf$default(obj);
        this.outerCoordinator = Stack.mutableStateOf$default(obj);
        this.tail = Stack.derivedStateOf(new AnchoredDraggableState$$ExternalSyntheticLambda1(this, 0));
        this.head = new ParcelableSnapshotMutableFloatState(Float.NaN);
        MenuHostHelper menuHostHelper = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        new AtomicInt(0);
        new DerivedSnapshotState.ResultRecord(SnapshotKt.currentSnapshot().getSnapshotId());
        this.current = new ParcelableSnapshotMutableFloatState(0.0f);
        this.buffer = Stack.mutableStateOf$default(null);
        this.stack = Stack.mutableStateOf$default(new DefaultDraggableAnchors(EmptyList.INSTANCE, new float[0]));
        this.cachedDiffer = new AnchoredDraggableState$anchoredDragScope$1(this);
        this.layoutNode = function1;
    }
}
