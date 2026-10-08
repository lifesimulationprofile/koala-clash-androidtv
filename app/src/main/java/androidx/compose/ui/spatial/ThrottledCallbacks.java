package androidx.compose.ui.spatial;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ThrottledCallbacks {
    public Entry globalChangeEntries;
    public long minDebounceDeadline;
    public final MutableIntObjectMap rectChangedMap;
    public long screenOffset;
    public float[] viewToWindowMatrix;
    public long windowOffset;
    public long windowSize;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Entry {
        public long bottomRight;
        public final BackHandlerKt$$ExternalSyntheticLambda2 callback;
        public final int id;
        public long lastInvokeMillis = Long.MIN_VALUE;
        public Entry next;
        public final AwaitFirstLayoutModifier.Node node;
        public long topLeft;

        public Entry(int i, AwaitFirstLayoutModifier.Node node, BackHandlerKt$$ExternalSyntheticLambda2 backHandlerKt$$ExternalSyntheticLambda2) {
            this.id = i;
            this.node = node;
            this.callback = backHandlerKt$$ExternalSyntheticLambda2;
        }

        /* JADX INFO: renamed from: fire-9b-9wPM, reason: not valid java name */
        public final void m621fire9b9wPM(long j, long j2, long j3, long j4, float[] fArr) {
            RelativeLayoutBounds relativeLayoutBounds;
            RelativeLayoutBounds relativeLayoutBounds2;
            long j5 = ThrottledCallbacks.this.windowSize;
            AwaitFirstLayoutModifier.Node node = this.node;
            NodeCoordinator nodeCoordinatorM547requireCoordinator64DMado = HitTestResultKt.m547requireCoordinator64DMado(node, 2);
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(node);
            boolean zIsPlaced = layoutNodeRequireLayoutNode.isPlaced();
            NodeChain nodeChain = layoutNodeRequireLayoutNode.nodes;
            if (zIsPlaced) {
                if (((NodeCoordinator) nodeChain.outerCoordinator) != nodeCoordinatorM547requireCoordinator64DMado) {
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (j >> 32)) << 32);
                    long j6 = nodeCoordinatorM547requireCoordinator64DMado.measuredSize;
                    NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
                    nodeCoordinator.getClass();
                    long jM717roundk4lQ0M = IntOffsetKt.m717roundk4lQ0M(nodeCoordinator.mo524localPositionOfS_NoaFU(nodeCoordinatorM547requireCoordinator64DMado, jFloatToRawIntBits));
                    relativeLayoutBounds = new RelativeLayoutBounds(jM717roundk4lQ0M, (4294967295L & ((long) (((int) (jM717roundk4lQ0M & 4294967295L)) + ((int) (j6 & 4294967295L))))) | (((long) (((int) (jM717roundk4lQ0M >> 32)) + ((int) (j6 >> 32)))) << 32), j3, j4, j5, fArr, node);
                } else {
                    relativeLayoutBounds = new RelativeLayoutBounds(j, j2, j3, j4, j5, fArr, node);
                }
                relativeLayoutBounds2 = relativeLayoutBounds;
            } else {
                relativeLayoutBounds2 = null;
            }
            if (relativeLayoutBounds2 == null) {
                return;
            }
            this.callback.invoke(relativeLayoutBounds2);
        }

        public final void unregister() {
            ThrottledCallbacks throttledCallbacks = ThrottledCallbacks.this;
            MutableIntObjectMap mutableIntObjectMap = throttledCallbacks.rectChangedMap;
            int i = this.id;
            Entry entry = (Entry) mutableIntObjectMap.remove(i);
            if (entry != null) {
                if (entry.equals(this)) {
                    Entry entry2 = this.next;
                    this.next = null;
                    if (entry2 == null) {
                        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this.node.node);
                        if (layoutNodeRequireLayoutNode.addedToRectList) {
                            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode)).getRectManager().rects.updateHasCallbacks(layoutNodeRequireLayoutNode.semanticsId, false);
                            return;
                        }
                        return;
                    }
                    int iFindAbsoluteInsertIndex = mutableIntObjectMap.findAbsoluteInsertIndex(i);
                    Object[] objArr = mutableIntObjectMap.values;
                    Object obj = objArr[iFindAbsoluteInsertIndex];
                    mutableIntObjectMap.keys[iFindAbsoluteInsertIndex] = i;
                    objArr[iFindAbsoluteInsertIndex] = entry2;
                    return;
                }
                int iFindAbsoluteInsertIndex2 = mutableIntObjectMap.findAbsoluteInsertIndex(i);
                Object[] objArr2 = mutableIntObjectMap.values;
                Object obj2 = objArr2[iFindAbsoluteInsertIndex2];
                mutableIntObjectMap.keys[iFindAbsoluteInsertIndex2] = i;
                objArr2[iFindAbsoluteInsertIndex2] = entry;
                while (true) {
                    Entry entry3 = entry.next;
                    if (entry3 == null) {
                        break;
                    }
                    if (entry3 == this) {
                        entry.next = this.next;
                        this.next = null;
                        return;
                    }
                    entry = entry3;
                }
            }
            Entry entry4 = throttledCallbacks.globalChangeEntries;
            if (entry4 == this) {
                throttledCallbacks.globalChangeEntries = entry4.next;
                this.next = null;
                return;
            }
            Entry entry5 = entry4 != null ? entry4.next : null;
            while (true) {
                Entry entry6 = entry4;
                entry4 = entry5;
                if (entry4 == null) {
                    return;
                }
                if (entry4 == this) {
                    if (entry6 != null) {
                        entry6.next = entry4.next;
                    }
                    this.next = null;
                    return;
                }
                entry5 = entry4.next;
            }
        }
    }

    public ThrottledCallbacks() {
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        this.rectChangedMap = new MutableIntObjectMap();
        this.minDebounceDeadline = -1L;
        this.windowOffset = 0L;
        this.screenOffset = 0L;
    }

    /* JADX INFO: renamed from: fire-WY9HvpM, reason: not valid java name */
    public final void m619fireWY9HvpM(Entry entry, long j, long j2, float[] fArr, long j3) {
        long j4 = entry.lastInvokeMillis;
        if (j3 - j4 > 0 || j4 == Long.MIN_VALUE) {
            entry.lastInvokeMillis = j3;
            entry.m621fire9b9wPM(entry.topLeft, entry.bottomRight, j, j2, fArr);
        }
    }

    /* JADX INFO: renamed from: updateOffsets-LDcG7Xg, reason: not valid java name */
    public final boolean m620updateOffsetsLDcG7Xg(long j, long j2, float[] fArr, int i, int i2) {
        boolean z;
        if (IntOffset.m712equalsimpl0(j2, this.windowOffset)) {
            z = false;
        } else {
            this.windowOffset = j2;
            z = true;
        }
        if (!IntOffset.m712equalsimpl0(j, this.screenOffset)) {
            this.screenOffset = j;
            z = true;
        }
        if (fArr != null) {
            this.viewToWindowMatrix = fArr;
            z = true;
        }
        long j3 = (((long) i) << 32) | (((long) i2) & 4294967295L);
        if (j3 == this.windowSize) {
            return z;
        }
        this.windowSize = j3;
        return true;
    }
}
