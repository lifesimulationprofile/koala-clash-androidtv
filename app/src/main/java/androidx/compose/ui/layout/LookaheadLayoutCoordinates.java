package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    public final long m533getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        LookaheadDelegate rootLookaheadDelegate = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
        return Offset.m372minusMKHz9U(mo524localPositionOfS_NoaFU(rootLookaheadDelegate.lookaheadLayoutCoordinates, 0L), lookaheadDelegate.coordinator.mo524localPositionOfS_NoaFU(rootLookaheadDelegate.coordinator, 0L));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator nodeCoordinator = ((NodeCoordinator) this.lookaheadDelegate.coordinator.layoutNode.nodes.outerCoordinator).wrappedBy;
        if (nodeCoordinator == null || (lookaheadDelegate = nodeCoordinator.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo522getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return (((long) lookaheadDelegate.width) << 32) | (((long) lookaheadDelegate.height) & 4294967295L);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached() {
        return this.lookaheadDelegate.coordinator.getTail().isAttached;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        return this.lookaheadDelegate.coordinator.localBoundingBoxOf(layoutCoordinates, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public final long mo523localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo524localPositionOfS_NoaFU(layoutCoordinates, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public final long mo524localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j) {
        boolean z = layoutCoordinates instanceof LookaheadLayoutCoordinates;
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (!z) {
            LookaheadDelegate rootLookaheadDelegate = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
            NodeCoordinator nodeCoordinator = rootLookaheadDelegate.coordinator;
            long jMo524localPositionOfS_NoaFU = mo524localPositionOfS_NoaFU(rootLookaheadDelegate.lookaheadLayoutCoordinates, j);
            long j2 = rootLookaheadDelegate.position;
            long jM372minusMKHz9U = Offset.m372minusMKHz9U(jMo524localPositionOfS_NoaFU, (4294967295L & ((long) Float.floatToRawIntBits((int) (j2 & 4294967295L)))) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32));
            if (!nodeCoordinator.getTail().isAttached) {
                InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
            }
            nodeCoordinator.onCoordinatesUsed$ui();
            NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
            if (nodeCoordinator2 != null) {
                nodeCoordinator = nodeCoordinator2;
            }
            return Offset.m373plusMKHz9U(jM372minusMKHz9U, nodeCoordinator.mo524localPositionOfS_NoaFU(layoutCoordinates, 0L));
        }
        LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinates) layoutCoordinates).lookaheadDelegate;
        NodeCoordinator nodeCoordinator3 = lookaheadDelegate2.coordinator;
        nodeCoordinator3.onCoordinatesUsed$ui();
        LookaheadDelegate lookaheadDelegate3 = lookaheadDelegate.coordinator.findCommonAncestor$ui(nodeCoordinator3).getLookaheadDelegate();
        if (lookaheadDelegate3 != null) {
            long jM713minusqkQi6aY = IntOffset.m713minusqkQi6aY(IntOffset.m714plusqkQi6aY(lookaheadDelegate2.m556positionIniSbpLlY$ui(lookaheadDelegate3, false), IntOffsetKt.m717roundk4lQ0M(j)), lookaheadDelegate.m556positionIniSbpLlY$ui(lookaheadDelegate3, false));
            return (((long) Float.floatToRawIntBits((int) (jM713minusqkQi6aY >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (jM713minusqkQi6aY & 4294967295L))) & 4294967295L);
        }
        LookaheadDelegate rootLookaheadDelegate2 = RulerKt.getRootLookaheadDelegate(lookaheadDelegate2);
        long jM714plusqkQi6aY = IntOffset.m714plusqkQi6aY(IntOffset.m714plusqkQi6aY(lookaheadDelegate2.m556positionIniSbpLlY$ui(rootLookaheadDelegate2, false), rootLookaheadDelegate2.position), IntOffsetKt.m717roundk4lQ0M(j));
        LookaheadDelegate rootLookaheadDelegate3 = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
        long jM713minusqkQi6aY2 = IntOffset.m713minusqkQi6aY(jM714plusqkQi6aY, IntOffset.m714plusqkQi6aY(lookaheadDelegate.m556positionIniSbpLlY$ui(rootLookaheadDelegate3, false), rootLookaheadDelegate3.position));
        long jFloatToRawIntBits = Float.floatToRawIntBits((int) (jM713minusqkQi6aY2 >> 32));
        return rootLookaheadDelegate3.coordinator.wrappedBy.mo524localPositionOfS_NoaFU(rootLookaheadDelegate2.coordinator.wrappedBy, (((long) Float.floatToRawIntBits((int) (jM713minusqkQi6aY2 & 4294967295L))) & 4294967295L) | (jFloatToRawIntBits << 32));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public final long mo525localToRootMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo525localToRootMKHz9U(Offset.m373plusMKHz9U(j, m533getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public final long mo526localToScreenMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo526localToScreenMKHz9U(Offset.m373plusMKHz9U(0L, m533getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public final long mo527localToWindowMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo527localToWindowMKHz9U(Offset.m373plusMKHz9U(j, m533getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public final long mo528screenToLocalMKHz9U(long j) {
        return Offset.m373plusMKHz9U(this.lookaheadDelegate.coordinator.mo528screenToLocalMKHz9U(j), m533getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public final void mo529transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        this.lookaheadDelegate.coordinator.mo529transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public final void mo530transformToScreen58bKbWc(float[] fArr) {
        this.lookaheadDelegate.coordinator.mo530transformToScreen58bKbWc(fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public final long mo531windowToLocalMKHz9U(long j) {
        return Offset.m373plusMKHz9U(this.lookaheadDelegate.coordinator.mo531windowToLocalMKHz9U(j), m533getLookaheadOffsetF1C5BW0());
    }
}
