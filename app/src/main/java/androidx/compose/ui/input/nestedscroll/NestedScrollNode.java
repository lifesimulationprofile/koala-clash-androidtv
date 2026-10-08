package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Velocity;
import androidx.navigation.NavGraphNavigator$navigate$missingRequiredArgs$1;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import okhttp3.Dispatcher;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public NestedScrollConnection connection;
    public NestedScrollNode lastKnownParentNode;
    public Dispatcher resolvedDispatcher;
    public final String traverseKey;

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, Dispatcher dispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = dispatcher == null ? new Dispatcher(8) : dispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final CoroutineScope getNestedCoroutineScope() {
        NestedScrollNode parentNestedScrollNode$ui = getParentNestedScrollNode$ui();
        CoroutineScope nestedCoroutineScope = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.getNestedCoroutineScope() : null;
        if (nestedCoroutineScope != null && JobKt.isActive(nestedCoroutineScope)) {
            return nestedCoroutineScope;
        }
        CoroutineScope coroutineScope = (CoroutineScope) this.resolvedDispatcher.runningSyncCalls;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollNode getParentNestedScrollNode$ui() {
        NodeChain nodeChain;
        TraversableNode traversableNode = null;
        if (!this.isAttached) {
            return null;
        }
        if (!this.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = this.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        loop0: while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node != null) {
                    if ((node.kindSet & 262144) != 0) {
                        Modifier.Node nodeAccess$pop = node;
                        MutableVector mutableVector = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof TraversableNode) {
                                TraversableNode traversableNode2 = (TraversableNode) nodeAccess$pop;
                                if (Intrinsics.areEqual(this.traverseKey, traversableNode2.getTraverseKey()) && NestedScrollNode.class == traversableNode2.getClass()) {
                                    traversableNode = traversableNode2;
                                    break loop0;
                                }
                            }
                            if ((nodeAccess$pop.kindSet & 262144) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                    if ((node2.kindSet & 262144) != 0) {
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
                    }
                    node = node.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        return (NestedScrollNode) traversableNode;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        Dispatcher dispatcher = this.resolvedDispatcher;
        dispatcher.executorServiceOrNull = this;
        dispatcher.readyAsyncCalls = null;
        this.lastKnownParentNode = null;
        dispatcher.runningAsyncCalls = new Handshake.AnonymousClass2(5, this);
        dispatcher.runningSyncCalls = getCoroutineScope();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.traverseAncestors(this, new NavGraphNavigator$navigate$missingRequiredArgs$1(ref$ObjectRef, 1));
        NestedScrollNode nestedScrollNode = (NestedScrollNode) ((TraversableNode) ref$ObjectRef.element);
        this.lastKnownParentNode = nestedScrollNode;
        Dispatcher dispatcher = this.resolvedDispatcher;
        dispatcher.readyAsyncCalls = nestedScrollNode;
        if (((NestedScrollNode) dispatcher.executorServiceOrNull) == this) {
            dispatcher.executorServiceOrNull = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        long j3;
        long j4;
        long j5;
        NestedScrollNode parentNestedScrollNode$ui;
        long j6;
        long j7;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            int i = nestedScrollNode$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, (ContinuationImpl) continuation);
        }
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$2 = nestedScrollNode$onPostFling$1;
        Object objMo99onPostFlingRZ2iAVY = nestedScrollNode$onPostFling$2.result;
        int i2 = nestedScrollNode$onPostFling$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
            NestedScrollConnection nestedScrollConnection = this.connection;
            nestedScrollNode$onPostFling$2.J$0 = j;
            nestedScrollNode$onPostFling$2.J$1 = j2;
            nestedScrollNode$onPostFling$2.label = 1;
            objMo99onPostFlingRZ2iAVY = nestedScrollConnection.mo99onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$2);
            if (objMo99onPostFlingRZ2iAVY != coroutineSingletons) {
                j3 = j;
                j4 = j2;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            j4 = nestedScrollNode$onPostFling$2.J$1;
            j3 = nestedScrollNode$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j7 = nestedScrollNode$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
        }
        j6 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
        j5 = j7;
        return new Velocity(Velocity.m737plusAH228Gc(j5, j6));
        j5 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
        boolean z = this.isAttached;
        if (z) {
            parentNestedScrollNode$ui = z ? getParentNestedScrollNode$ui() : null;
        } else {
            parentNestedScrollNode$ui = this.lastKnownParentNode;
        }
        if (parentNestedScrollNode$ui != null) {
            long jM737plusAH228Gc = Velocity.m737plusAH228Gc(j3, j5);
            long jM736minusAH228Gc = Velocity.m736minusAH228Gc(j4, j5);
            nestedScrollNode$onPostFling$2.J$0 = j5;
            nestedScrollNode$onPostFling$2.label = 2;
            objMo99onPostFlingRZ2iAVY = parentNestedScrollNode$ui.mo99onPostFlingRZ2iAVY(jM737plusAH228Gc, jM736minusAH228Gc, nestedScrollNode$onPostFling$2);
            if (objMo99onPostFlingRZ2iAVY != coroutineSingletons) {
                j7 = j5;
                j6 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
                j5 = j7;
            }
            return coroutineSingletons;
        }
        j6 = 0;
        return new Velocity(Velocity.m737plusAH228Gc(j5, j6));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final long mo100onPostScrollDzOQY0M(long j, long j2, int i) {
        long jMo100onPostScrollDzOQY0M = this.connection.mo100onPostScrollDzOQY0M(j, j2, i);
        NestedScrollNode parentNestedScrollNode$ui = this.isAttached ? getParentNestedScrollNode$ui() : null;
        return Offset.m373plusMKHz9U(jMo100onPostScrollDzOQY0M, parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo100onPostScrollDzOQY0M(Offset.m373plusMKHz9U(j, jMo100onPostScrollDzOQY0M), Offset.m372minusMKHz9U(j2, jMo100onPostScrollDzOQY0M), i) : 0L);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        if (r12 == r4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        if (r12 == r4) goto L29;
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo101onPreFlingQWom1Mo(long r10, kotlin.coroutines.Continuation r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r12 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r12
            r0.<init>(r9, r12)
        L1a:
            java.lang.Object r12 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            long r10 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L72
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            long r10 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L56
        L3c:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r9.isAttached
            if (r12 == 0) goto L48
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r12 = r9.getParentNestedScrollNode$ui()
            goto L49
        L48:
            r12 = 0
        L49:
            if (r12 == 0) goto L5e
            r0.J$0 = r10
            r0.label = r3
            java.lang.Object r12 = r12.mo101onPreFlingQWom1Mo(r10, r0)
            if (r12 != r4) goto L56
            goto L71
        L56:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r5 = r12.packedValue
        L5a:
            r7 = r5
            r5 = r10
            r10 = r7
            goto L61
        L5e:
            r5 = 0
            goto L5a
        L61:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r12 = r9.connection
            long r5 = androidx.compose.ui.unit.Velocity.m736minusAH228Gc(r5, r10)
            r0.J$0 = r10
            r0.label = r2
            java.lang.Object r12 = r12.mo101onPreFlingQWom1Mo(r5, r0)
            if (r12 != r4) goto L72
        L71:
            return r4
        L72:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r0 = r12.packedValue
            long r10 = androidx.compose.ui.unit.Velocity.m737plusAH228Gc(r10, r0)
            androidx.compose.ui.unit.Velocity r12 = new androidx.compose.ui.unit.Velocity
            r12.<init>(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo101onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public final long mo102onPreScrollOzD1aCk(int i, long j) {
        NestedScrollNode parentNestedScrollNode$ui = this.isAttached ? getParentNestedScrollNode$ui() : null;
        long jMo102onPreScrollOzD1aCk = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo102onPreScrollOzD1aCk(i, j) : 0L;
        return Offset.m373plusMKHz9U(jMo102onPreScrollOzD1aCk, this.connection.mo102onPreScrollOzD1aCk(i, Offset.m372minusMKHz9U(j, jMo102onPreScrollOzD1aCk)));
    }
}
