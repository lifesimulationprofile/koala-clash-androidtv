package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.foundation.IndicationModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusInvalidationManager;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import coil.request.RequestService;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NodeKindKt {
    public static final MutableObjectIntMap classToKindSetMap;

    static {
        MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
        classToKindSetMap = new MutableObjectIntMap();
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        if (!(node instanceof DelegatingNode)) {
            autoInvalidateNodeSelf(node, i & node.kindSet, i2);
            return;
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int i3 = delegatingNode.selfKindSet;
        autoInvalidateNodeSelf(node, i3 & i, i2);
        int i4 = (~i3) & i;
        for (Modifier.Node node2 = delegatingNode.delegate; node2 != null; node2 = node2.child) {
            autoInvalidateNodeIncludingDelegates(node2, i4, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((i & 2) != 0 && (node instanceof LayoutModifierNode)) {
                HitTestResultKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    HitTestResultKt.m547requireCoordinator64DMado(node, 2).onRelease();
                }
            }
            if ((i & 128) != 0 && i2 != 2) {
                HitTestResultKt.requireLayoutNode(node).invalidateMeasurements$ui();
            }
            if ((4194304 & i) != 0 && i2 != 2) {
                HitTestResultKt.requireLayoutNode(node).requestRelayout$ui(false);
            }
            if ((i & 256) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                if (i2 == 1) {
                    LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(node);
                    layoutNodeRequireLayoutNode.setGloballyPositionedObservers(layoutNodeRequireLayoutNode.globallyPositionedObservers + 1);
                } else if (i2 == 2) {
                    LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(node);
                    layoutNodeRequireLayoutNode2.setGloballyPositionedObservers(layoutNodeRequireLayoutNode2.globallyPositionedObservers - 1);
                }
                if (i2 != 2) {
                    LayoutNode layoutNodeRequireLayoutNode3 = HitTestResultKt.requireLayoutNode(node);
                    if (layoutNodeRequireLayoutNode3.globallyPositionedObservers != 0 && !layoutNodeRequireLayoutNode3.getLayoutPending$ui() && !layoutNodeRequireLayoutNode3.getMeasurePending$ui() && !layoutNodeRequireLayoutNode3.needsOnGloballyPositionedDispatch) {
                        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode3);
                        RequestService requestService = androidComposeView.measureAndLayoutDelegate.onPositionedDispatcher;
                        requestService.getClass();
                        if (layoutNodeRequireLayoutNode3.globallyPositionedObservers > 0) {
                            ((MutableVector) requestService.systemCallbacks).add(layoutNodeRequireLayoutNode3);
                            layoutNodeRequireLayoutNode3.needsOnGloballyPositionedDispatch = true;
                        }
                        androidComposeView.scheduleMeasureAndLayout(null);
                    }
                }
            }
            if ((i & 4) != 0 && (node instanceof DrawModifierNode)) {
                HitTestResultKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((i & 8) != 0 && (node instanceof SemanticsModifierNode)) {
                HitTestResultKt.requireLayoutNode(node).isSemanticsInvalidated = true;
            }
            if ((i & 64) != 0 && (node instanceof ParentDataModifierNode)) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = HitTestResultKt.requireLayoutNode((ParentDataModifierNode) node).layoutDelegate;
                layoutNodeLayoutDelegate.measurePassDelegate.parentDataDirty = true;
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.parentDataDirty = true;
                }
            }
            if ((i & 2048) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                ((FocusPropertiesModifierNode) node).applyFocusProperties(CanFocusChecker.INSTANCE);
            }
            if ((i & 4096) != 0 && (node instanceof FocusEventModifierNode)) {
                FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) node;
                FocusInvalidationManager focusInvalidationManager = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusEventModifierNode)).getFocusOwner()).focusInvalidationManager;
                if (focusInvalidationManager.focusEventNodes.add(focusEventModifierNode)) {
                    focusInvalidationManager.scheduleInvalidation$2();
                }
            }
            if ((i & 2097152) != 0 && (node instanceof IndirectPointerInputModifierNode) && i2 == 2) {
                ((IndirectPointerInputModifierNode) node).onCancelIndirectPointerInput();
            }
        }
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        if (!node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int i = element instanceof LayoutModifier ? 3 : 1;
        if (element instanceof IndicationModifier) {
            i |= 4;
        }
        if (element instanceof AppendedSemanticsElement) {
            i |= 8;
        }
        if (element instanceof AnimatedContentTransitionScopeImpl.ChildData) {
            i |= 64;
        }
        return element instanceof BringIntoViewModifierNode ? 524288 | i : i;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (!(node instanceof DelegatingNode)) {
            return calculateNodeKindSetFrom(node);
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int iCalculateNodeKindSetFromIncludingDelegates = delegatingNode.selfKindSet;
        for (Modifier.Node node2 = delegatingNode.delegate; node2 != null; node2 = node2.child) {
            iCalculateNodeKindSetFromIncludingDelegates |= calculateNodeKindSetFromIncludingDelegates(node2);
        }
        return iCalculateNodeKindSetFromIncludingDelegates;
    }

    /* JADX INFO: renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m581getIncludeSelfInTraversalH91voCI(int i) {
        return ((i & 128) != 0) | ((i & 4194304) != 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        int i = node.kindSet;
        if (i != 0) {
            return i;
        }
        Class<?> cls = node.getClass();
        MutableObjectIntMap mutableObjectIntMap = classToKindSetMap;
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(cls);
        if (iFindKeyIndex >= 0) {
            return mutableObjectIntMap.values[iFindKeyIndex];
        }
        int i2 = node instanceof LayoutModifierNode ? 3 : 1;
        if (node instanceof DrawModifierNode) {
            i2 |= 4;
        }
        if (node instanceof SemanticsModifierNode) {
            i2 |= 8;
        }
        if (node instanceof PointerInputModifierNode) {
            i2 |= 16;
        }
        if (node instanceof ModifierLocalModifierNode) {
            i2 |= 32;
        }
        if (node instanceof ParentDataModifierNode) {
            i2 |= 64;
        }
        if (node instanceof LayoutAwareModifierNode) {
            i2 |= 4194432;
        } else if (node instanceof MeasuredSizeAwareModifierNode) {
            i2 |= 128;
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            i2 |= 256;
        }
        if (node instanceof FocusTargetNode) {
            i2 |= 1024;
        }
        if (node instanceof FocusPropertiesModifierNode) {
            i2 |= 2048;
        }
        if (node instanceof FocusEventModifierNode) {
            i2 |= 4096;
        }
        if (node instanceof KeyInputModifierNode) {
            i2 |= 8192;
        }
        if (node instanceof AndroidComposeView.RootModifierNode) {
            i2 |= 16384;
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            i2 |= 32768;
        }
        if (node instanceof TraversableNode) {
            i2 |= 262144;
        }
        if (node instanceof BringIntoViewModifierNode) {
            i2 |= 524288;
        }
        if (node instanceof IndirectPointerInputModifierNode) {
            i2 |= 2097152;
        }
        if (node instanceof LazyLayoutBeyondBoundsProviderModifierNode) {
            i2 |= 8388608;
        }
        mutableObjectIntMap.set(i2, cls);
        return i2;
    }
}
