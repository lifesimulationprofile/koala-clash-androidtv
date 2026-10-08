package androidx.compose.ui.node;

import androidx.compose.ui.platform.AndroidComposeView;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeLayoutDelegate {
    public int childrenAccessingCoordinatesDuringPlacement;
    public int childrenAccessingLookaheadCoordinatesDuringPlacement;
    public boolean coordinatesAccessedDuringModifierPlacement;
    public boolean coordinatesAccessedDuringPlacement;
    public boolean detachedFromParentLookaheadPass;
    public boolean detachedFromParentLookaheadPlacement;
    public final LayoutNode layoutNode;
    public boolean lookaheadCoordinatesAccessedDuringModifierPlacement;
    public boolean lookaheadCoordinatesAccessedDuringPlacement;
    public boolean lookaheadLayoutPending;
    public boolean lookaheadLayoutPendingForAlignment;
    public boolean lookaheadMeasurePending;
    public LookaheadPassDelegate lookaheadPassDelegate;
    public int nextChildLookaheadPlaceOrder;
    public int nextChildPlaceOrder;
    public int layoutState = 5;
    public final MeasurePassDelegate measurePassDelegate = new MeasurePassDelegate(this);

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    public final NodeCoordinator getOuterCoordinator() {
        return (NodeCoordinator) this.layoutNode.nodes.outerCoordinator;
    }

    public final void onCoordinatesUsed() {
        int i = this.layoutNode.layoutDelegate.layoutState;
        if (i == 3 || i == 4) {
            if (this.measurePassDelegate.layingOutChildren) {
                setCoordinatesAccessedDuringPlacement(true);
            } else {
                setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }
        if (i == 4) {
            LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
            if (lookaheadPassDelegate == null || !lookaheadPassDelegate.layingOutChildren) {
                setLookaheadCoordinatesAccessedDuringModifierPlacement(true);
            } else {
                setLookaheadCoordinatesAccessedDuringPlacement(true);
            }
        }
    }

    /* JADX INFO: renamed from: performLookaheadMeasure-BRTryo0$ui, reason: not valid java name */
    public final void m552performLookaheadMeasureBRTryo0$ui(long j) {
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = lookaheadPassDelegate.layoutNodeLayoutDelegate;
            layoutNodeLayoutDelegate.layoutState = 2;
            MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate.measurePassDelegate;
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            layoutNodeLayoutDelegate.lookaheadMeasurePending = false;
            lookaheadPassDelegate.performMeasureConstraints = j;
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSnapshotObserver();
            LookaheadPassDelegate$layoutChildrenBlock$1 lookaheadPassDelegate$layoutChildrenBlock$1 = lookaheadPassDelegate.performMeasureBlock;
            snapshotObserver.observer.observeReads(layoutNode, snapshotObserver.onCommitAffectingLookaheadMeasure, lookaheadPassDelegate$layoutChildrenBlock$1);
            layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
            layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
            if (HitTestResultKt.isOutMostLookaheadRoot(layoutNode)) {
                measurePassDelegate.layoutPending = true;
                measurePassDelegate.layoutPendingForAlignment = true;
            } else {
                measurePassDelegate.measurePending = true;
            }
            layoutNodeLayoutDelegate.layoutState = 5;
        }
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int i) {
        int i2 = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = i;
        if ((i2 == 0) != (i == 0)) {
            LayoutNode parent$ui = this.layoutNode.getParent$ui();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = parent$ui != null ? parent$ui.layoutDelegate : null;
            if (layoutNodeLayoutDelegate != null) {
                if (i == 0) {
                    layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
                } else {
                    layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
                }
            }
        }
    }

    public final void setChildrenAccessingLookaheadCoordinatesDuringPlacement(int i) {
        int i2 = this.childrenAccessingLookaheadCoordinatesDuringPlacement;
        this.childrenAccessingLookaheadCoordinatesDuringPlacement = i;
        if ((i2 == 0) != (i == 0)) {
            LayoutNode parent$ui = this.layoutNode.getParent$ui();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = parent$ui != null ? parent$ui.layoutDelegate : null;
            if (layoutNodeLayoutDelegate != null) {
                if (i == 0) {
                    layoutNodeLayoutDelegate.setChildrenAccessingLookaheadCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
                } else {
                    layoutNodeLayoutDelegate.setChildrenAccessingLookaheadCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
                }
            }
        }
    }

    public final void setCoordinatesAccessedDuringModifierPlacement(boolean z) {
        if (this.coordinatesAccessedDuringModifierPlacement != z) {
            this.coordinatesAccessedDuringModifierPlacement = z;
            if (z && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                if (z || this.coordinatesAccessedDuringPlacement) {
                    return;
                }
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean z) {
        if (this.coordinatesAccessedDuringPlacement != z) {
            this.coordinatesAccessedDuringPlacement = z;
            if (z && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                if (z || this.coordinatesAccessedDuringModifierPlacement) {
                    return;
                }
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void setLookaheadCoordinatesAccessedDuringModifierPlacement(boolean z) {
        if (this.lookaheadCoordinatesAccessedDuringModifierPlacement != z) {
            this.lookaheadCoordinatesAccessedDuringModifierPlacement = z;
            if (z && !this.lookaheadCoordinatesAccessedDuringPlacement) {
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
            } else {
                if (z || this.lookaheadCoordinatesAccessedDuringPlacement) {
                    return;
                }
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void setLookaheadCoordinatesAccessedDuringPlacement(boolean z) {
        if (this.lookaheadCoordinatesAccessedDuringPlacement != z) {
            this.lookaheadCoordinatesAccessedDuringPlacement = z;
            if (z && !this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
            } else {
                if (z || this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                    return;
                }
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void updateParentData() {
        MeasurePassDelegate measurePassDelegate = this.measurePassDelegate;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = measurePassDelegate.layoutNodeLayoutDelegate;
        Object obj = measurePassDelegate.parentData;
        LayoutNode layoutNode = this.layoutNode;
        if ((obj != null || layoutNodeLayoutDelegate.getOuterCoordinator().getParentData() != null) && measurePassDelegate.parentDataDirty) {
            measurePassDelegate.parentDataDirty = false;
            measurePassDelegate.parentData = layoutNodeLayoutDelegate.getOuterCoordinator().getParentData();
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if (parent$ui != null) {
                LayoutNode.requestRemeasure$ui$default(parent$ui, false, 7);
            }
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
            if (!(lookaheadPassDelegate.parentData == null && layoutNodeLayoutDelegate2.getOuterCoordinator().getLookaheadDelegate().coordinator.getParentData() == null) && lookaheadPassDelegate.parentDataDirty) {
                lookaheadPassDelegate.parentDataDirty = false;
                lookaheadPassDelegate.parentData = layoutNodeLayoutDelegate2.getOuterCoordinator().getLookaheadDelegate().coordinator.getParentData();
                if (HitTestResultKt.isOutMostLookaheadRoot(layoutNode)) {
                    LayoutNode parent$ui2 = layoutNode.getParent$ui();
                    if (parent$ui2 != null) {
                        LayoutNode.requestRemeasure$ui$default(parent$ui2, false, 7);
                        return;
                    }
                    return;
                }
                LayoutNode parent$ui3 = layoutNode.getParent$ui();
                if (parent$ui3 != null) {
                    LayoutNode.requestLookaheadRemeasure$ui$default(parent$ui3, false, 7);
                }
            }
        }
    }
}
