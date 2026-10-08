package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.EmptyMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import coil.network.HttpException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutAwareModifierNode, ObserverModifierNode, ModifierLocalModifierNode, DelegatableNode {
    public final int focusability;
    public boolean isProcessingCustomEnter;
    public boolean isProcessingCustomExit;
    public final Function2 onFocusChange;

    public FocusTargetNode(int i, Function2 function2, int i2) {
        this.onFocusChange = (i2 & 4) != 0 ? null : function2;
        this.focusability = i;
    }

    /* JADX INFO: renamed from: assignFocus-3ESFkO8, reason: not valid java name */
    public final boolean m350assignFocus3ESFkO8() {
        MutableVector mutableVector;
        NodeChain nodeChain;
        boolean z;
        NodeChain nodeChain2;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(FocusTraversalKt.m360performCustomRequestFocusMxy_nc0(this));
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return false;
            }
            if (iOrdinal == 2) {
                return true;
            }
            if (iOrdinal == 3) {
                return false;
            }
            throw new HttpException();
        }
        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
        FocusStateImpl focusState = getFocusState();
        if (activeFocusTargetNode == this) {
            dispatchFocusCallbacks$ui(focusState, focusState);
            return true;
        }
        if (activeFocusTargetNode == null && !((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).platformFocusOwner.m592requestOwnerFocus7o62pno()) {
            return false;
        }
        if (activeFocusTargetNode != null) {
            mutableVector = new MutableVector(new FocusTargetNode[16]);
            if (!activeFocusTargetNode.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = activeFocusTargetNode.node.parent;
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
            while (layoutNodeRequireLayoutNode != null) {
                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                    while (node != null) {
                        if ((node.kindSet & 1024) != 0) {
                            Modifier.Node nodeAccess$pop = node;
                            MutableVector mutableVector2 = null;
                            while (nodeAccess$pop != null) {
                                if (nodeAccess$pop instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) nodeAccess$pop);
                                } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                        if ((node2.kindSet & 1024) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Unit unit = Unit.INSTANCE;
                                                nodeAccess$pop = node2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodeAccess$pop != null) {
                                                    mutableVector2.add(nodeAccess$pop);
                                                    nodeAccess$pop = null;
                                                }
                                                mutableVector2.add(node2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodeAccess$pop = HitTestResultKt.access$pop(mutableVector2);
                            }
                        }
                        node = node.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodeChain2 = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain2.tail;
            }
        } else {
            mutableVector = null;
        }
        Object[] objArr = new FocusTargetNode[16];
        Object[] objArr2 = new FocusTargetNode[16];
        if (!this.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node3 = this.node.parent;
        LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(this);
        boolean z2 = true;
        int i2 = 0;
        int i3 = 0;
        while (layoutNodeRequireLayoutNode2 != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 1024) != 0) {
                while (node3 != null) {
                    if ((node3.kindSet & 1024) != 0) {
                        Modifier.Node nodeAccess$pop2 = node3;
                        MutableVector mutableVector3 = null;
                        while (nodeAccess$pop2 != null) {
                            if (nodeAccess$pop2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode = (FocusTargetNode) nodeAccess$pop2;
                                if (Intrinsics.areEqual(mutableVector != null ? Boolean.valueOf(mutableVector.remove(focusTargetNode)) : null, Boolean.TRUE)) {
                                    int i4 = i2 + 1;
                                    if (objArr.length < i4) {
                                        int length = objArr.length;
                                        Object[] objArr3 = new Object[Math.max(i4, length * 2)];
                                        System.arraycopy(objArr, 0, objArr3, 0, length);
                                        objArr = objArr3;
                                    }
                                    objArr[i2] = focusTargetNode;
                                    i2 = i4;
                                } else {
                                    focusOwnerImpl = focusOwnerImpl;
                                    int i5 = i3 + 1;
                                    if (objArr2.length < i5) {
                                        int length2 = objArr2.length;
                                        Object[] objArr4 = new Object[Math.max(i5, length2 * 2)];
                                        System.arraycopy(objArr2, 0, objArr4, 0, length2);
                                        objArr2 = objArr4;
                                    }
                                    objArr2[i3] = focusTargetNode;
                                    i3 = i5;
                                }
                                if (focusTargetNode == activeFocusTargetNode) {
                                    z2 = false;
                                }
                                z = false;
                            } else {
                                focusOwnerImpl = focusOwnerImpl;
                                z = true;
                            }
                            if (z && (nodeAccess$pop2.kindSet & 1024) != 0 && (nodeAccess$pop2 instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node node4 = ((DelegatingNode) nodeAccess$pop2).delegate; node4 != null; node4 = node4.child) {
                                    if ((node4.kindSet & 1024) != 0) {
                                        int i7 = i6 + 1;
                                        if (i7 == 1) {
                                            Unit unit2 = Unit.INSTANCE;
                                            nodeAccess$pop2 = node4;
                                            i7 = i7;
                                        } else {
                                            MutableVector mutableVector4 = mutableVector3 == null ? new MutableVector(new Modifier.Node[16]) : mutableVector3;
                                            if (nodeAccess$pop2 != null) {
                                                mutableVector4.add(nodeAccess$pop2);
                                                nodeAccess$pop2 = null;
                                            }
                                            mutableVector4.add(node4);
                                            mutableVector3 = mutableVector4;
                                        }
                                        i6 = i7;
                                    }
                                }
                                if (i6 != 1) {
                                    nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector3);
                                }
                            } else {
                                nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector3);
                            }
                        }
                    }
                    node3 = node3.parent;
                    focusOwnerImpl = focusOwnerImpl;
                }
            }
            FocusOwnerImpl focusOwnerImpl2 = focusOwnerImpl;
            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
            node3 = (layoutNodeRequireLayoutNode2 == null || (nodeChain = layoutNodeRequireLayoutNode2.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
            focusOwnerImpl = focusOwnerImpl2;
        }
        FocusOwnerImpl focusOwnerImpl3 = focusOwnerImpl;
        if (z2 && activeFocusTargetNode != null && !FocusTraversalKt.clearFocus(activeFocusTargetNode, false)) {
            return false;
        }
        HitTestResultKt.observeReads(this, new Handshake.AnonymousClass2(2, this));
        int iOrdinal2 = getFocusState().ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).setActiveFocusTargetNode(this);
            } else if (iOrdinal2 != 2) {
                if (iOrdinal2 != 3) {
                    throw new HttpException();
                }
                ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).setActiveFocusTargetNode(this);
            }
        }
        FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;
        FocusStateImpl focusStateImpl2 = FocusStateImpl.Active;
        if (z2 && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(focusStateImpl2, focusStateImpl);
            Unit unit3 = Unit.INSTANCE;
        }
        FocusStateImpl focusStateImpl3 = FocusStateImpl.ActiveParent;
        if (mutableVector != null) {
            int i8 = mutableVector.size - 1;
            Object[] objArr5 = mutableVector.content;
            if (i8 < objArr5.length) {
                while (i8 >= 0) {
                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr5[i8];
                    if (focusOwnerImpl3.getActiveFocusTargetNode() != this) {
                        return false;
                    }
                    focusTargetNode2.dispatchFocusCallbacks$ui(focusStateImpl3, focusStateImpl);
                    i8--;
                }
            }
            Unit unit4 = Unit.INSTANCE;
        }
        int i9 = i3 - 1;
        if (i9 < objArr2.length) {
            while (i9 >= 0) {
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr2[i9];
                if (focusOwnerImpl3.getActiveFocusTargetNode() != this) {
                    return false;
                }
                focusTargetNode3.dispatchFocusCallbacks$ui(focusTargetNode3 == activeFocusTargetNode ? focusStateImpl2 : focusStateImpl, focusStateImpl3);
                i9--;
            }
        }
        if (focusOwnerImpl3.getActiveFocusTargetNode() != this) {
            return false;
        }
        dispatchFocusCallbacks$ui(focusState, focusStateImpl2);
        return focusOwnerImpl3.getActiveFocusTargetNode() == this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v5 */
    public final void dispatchFocusCallbacks$ui(FocusStateImpl focusStateImpl, FocusStateImpl focusStateImpl2) {
        NodeChain nodeChain;
        Function2 function2;
        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
        if (!focusStateImpl.equals(focusStateImpl2) && (function2 = this.onFocusChange) != null) {
            function2.invoke(focusStateImpl, focusStateImpl2);
        }
        Modifier.Node node = this.node;
        if (!node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = this.node;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 5120) != 0) {
                while (node2 != null) {
                    int i = node2.kindSet;
                    if ((i & 5120) != 0) {
                        if (node2 != node && (i & 1024) != 0) {
                            return;
                        }
                        if ((i & 4096) != 0) {
                            ?? Access$pop = node2;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof FocusEventModifierNode) {
                                    FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) Access$pop;
                                    if (activeFocusTargetNode == focusOwnerImpl.getActiveFocusTargetNode()) {
                                        focusEventModifierNode.onFocusEvent(focusStateImpl2);
                                    }
                                } else if ((Access$pop.kindSet & 4096) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node3 = ((DelegatingNode) Access$pop).delegate;
                                    int i2 = 0;
                                    Access$pop = Access$pop;
                                    mutableVector = mutableVector;
                                    while (node3 != null) {
                                        if ((node3.kindSet & 4096) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                mutableVector = mutableVector;
                                                Access$pop = node3;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector.add(node3);
                                            }
                                        }
                                        node3 = node3.child;
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Access$pop = HitTestResultKt.access$pop(mutableVector);
                            }
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
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public final FocusPropertiesImpl fetchFocusProperties$ui() {
        boolean z;
        NodeChain nodeChain;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        focusPropertiesImpl.canFocus = true;
        FocusRequester focusRequester = FocusRequester.Default;
        focusPropertiesImpl.next = focusRequester;
        focusPropertiesImpl.previous = focusRequester;
        focusPropertiesImpl.up = focusRequester;
        focusPropertiesImpl.down = focusRequester;
        focusPropertiesImpl.left = focusRequester;
        focusPropertiesImpl.right = focusRequester;
        focusPropertiesImpl.start = focusRequester;
        focusPropertiesImpl.end = focusRequester;
        focusPropertiesImpl.onEnter = FocusPropertiesImpl$onExit$1.INSTANCE$1;
        focusPropertiesImpl.onExit = FocusPropertiesImpl$onExit$1.INSTANCE;
        focusPropertiesImpl.focusRect = FocusProperties.Companion.UnsetFocusRect;
        int i = this.focusability;
        if (i == 1) {
            z = true;
        } else if (i == 0) {
            z = !(((InputMode) ((InputModeManagerImpl) ((InputModeManager) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalInputModeManager))).inputMode$delegate.getValue()).value == 1);
        } else {
            if (i != 2) {
                throw new IllegalStateException("Unknown Focusability");
            }
            z = false;
        }
        focusPropertiesImpl.canFocus = z;
        Modifier.Node node = this.node;
        if (!node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = this.node;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        loop0: while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 3072) != 0) {
                while (node2 != null) {
                    int i2 = node2.kindSet;
                    if ((i2 & 3072) != 0) {
                        if (node2 != node && (i2 & 1024) != 0) {
                            break loop0;
                        }
                        if ((i2 & 2048) != 0) {
                            ?? Access$pop = node2;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof FocusPropertiesModifierNode) {
                                    ((FocusPropertiesModifierNode) Access$pop).applyFocusProperties(focusPropertiesImpl);
                                } else if ((Access$pop.kindSet & 2048) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node3 = ((DelegatingNode) Access$pop).delegate;
                                    int i3 = 0;
                                    while (node3 != null) {
                                        if ((node3.kindSet & 2048) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                Access$pop = Access$pop;
                                                mutableVector = mutableVector;
                                                mutableVector = mutableVector;
                                                Access$pop = node3;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector.add(node3);
                                            }
                                        } else {
                                            Access$pop = Access$pop;
                                            mutableVector = mutableVector;
                                        }
                                        node3 = node3.child;
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
                        }
                    }
                    node2 = node2.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        return focusPropertiesImpl;
    }

    public final Rect fetchFocusRect$ui(LayoutCoordinates layoutCoordinates) {
        Rect rect = fetchFocusProperties$ui().focusRect;
        if (rect != FocusProperties.Companion.UnsetFocusRect) {
            return layoutCoordinates == null ? rect : rect.m381translatek4lQ0M(layoutCoordinates.mo524localPositionOfS_NoaFU(HitTestResultKt.requireLayoutCoordinates(this), 0L));
        }
        return layoutCoordinates != null ? layoutCoordinates.localBoundingBoxOf(HitTestResultKt.requireLayoutCoordinates(this), false) : RectKt.m382Recttz77jQw(0L, IntSizeKt.m724toSizeozmzZPI(HitTestResultKt.requireLayoutCoordinates(this).measuredSize));
    }

    public final LazyLayoutBeyondBoundsProviderModifierNode getBeyondBoundsLayoutParent() {
        NodeChain nodeChain;
        Object obj;
        if (!this.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = this.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        loop0: while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8388640) != 0) {
                while (node != null) {
                    int i = node.kindSet;
                    if ((i & 8388640) != 0) {
                        if ((8388608 & i) != 0) {
                            if (!(node instanceof LazyLayoutBeyondBoundsProviderModifierNode)) {
                                if (node instanceof DelegatingNode) {
                                    Modifier.Node node2 = null;
                                    for (Modifier.Node node3 = ((DelegatingNode) node).delegate; node3 != null; node3 = node3.child) {
                                        if (node3 instanceof LazyLayoutBeyondBoundsProviderModifierNode) {
                                            node2 = node3;
                                        }
                                    }
                                    node = node2;
                                } else {
                                    node = null;
                                }
                            }
                            LazyLayoutBeyondBoundsProviderModifierNode lazyLayoutBeyondBoundsProviderModifierNode = (LazyLayoutBeyondBoundsProviderModifierNode) node;
                            if (lazyLayoutBeyondBoundsProviderModifierNode != null) {
                                return lazyLayoutBeyondBoundsProviderModifierNode;
                            }
                        } else if ((i & 32) != 0) {
                            if (node instanceof ModifierLocalModifierNode) {
                                obj = node;
                            } else if (node instanceof DelegatingNode) {
                                obj = null;
                                for (Modifier.Node node4 = ((DelegatingNode) node).delegate; node4 != null; node4 = node4.child) {
                                    if (node4 instanceof ModifierLocalModifierNode) {
                                        obj = node4;
                                    }
                                }
                            } else {
                                obj = null;
                            }
                            ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) obj;
                            if (modifierLocalModifierNode != null) {
                                modifierLocalModifierNode.getProvidedValues().getClass();
                            }
                        }
                    }
                    node = node.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        return null;
    }

    public final FocusStateImpl getFocusState() {
        FocusTargetNode activeFocusTargetNode;
        NodeChain nodeChain;
        if (this.isAttached && (activeFocusTargetNode = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).getActiveFocusTargetNode()) != null) {
            if (this == activeFocusTargetNode) {
                return FocusStateImpl.Active;
            }
            if (activeFocusTargetNode.isAttached) {
                if (!activeFocusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node = activeFocusTargetNode.node.parent;
                LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
                while (layoutNodeRequireLayoutNode != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 1024) != 0) {
                                Modifier.Node nodeAccess$pop = node;
                                MutableVector mutableVector = null;
                                while (nodeAccess$pop != null) {
                                    if (nodeAccess$pop instanceof FocusTargetNode) {
                                        if (this == ((FocusTargetNode) nodeAccess$pop)) {
                                            return FocusStateImpl.ActiveParent;
                                        }
                                    } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                        int i = 0;
                                        for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                            if ((node2.kindSet & 1024) != 0) {
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
            }
        }
        return FocusStateImpl.Inactive;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final /* synthetic */ EmptyMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void invalidateFocus$ui() {
        int iOrdinal = getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new HttpException();
                }
                return;
            }
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.observeReads(this, new DialogHostKt$DialogHost$1$1$1(2, ref$ObjectRef, this));
        Object obj = ref$ObjectRef.element;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
            throw null;
        }
        if (((FocusProperties) obj).getCanFocus()) {
            return;
        }
        ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).m343clearFocusI7lrPNg(8, true, true);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        int iOrdinal = getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
                FocusTraversalKt.findActiveFocusNode(this);
                return;
            } else if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new HttpException();
                }
                return;
            }
        }
        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
        focusOwnerImpl.m343clearFocusI7lrPNg(8, true, false);
        focusOwnerImpl.focusInvalidationManager.scheduleInvalidation$2();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        invalidateFocus$ui();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        if (getFocusState().isFocused()) {
            ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).m343clearFocusI7lrPNg(8, true, true);
        }
    }

    /* JADX INFO: renamed from: requestFocus-3ESFkO8, reason: not valid java name */
    public final boolean m351requestFocus3ESFkO8(int i) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            return fetchFocusProperties$ui().canFocus ? m350assignFocus3ESFkO8() : FocusTraversalKt.m354findChildCorrespondingToFocusEnterOMvw8(this, i, new FocusPropertiesImpl$onExit$1(i));
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final /* synthetic */ void mo66onRemeasuredozmzZPI(long j) {
    }
}
