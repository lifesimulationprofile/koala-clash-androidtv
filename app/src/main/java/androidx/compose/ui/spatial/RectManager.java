package androidx.compose.ui.spatial;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.room.RoomOpenHelper;
import kotlin.jvm.functions.Function0;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RectManager {
    public final MutableRect cachedRect;
    public final MutableObjectList callbacks;
    public final Handshake.AnonymousClass2 dispatchLambda;
    public AndroidComposeView$$ExternalSyntheticLambda2 dispatchToken;
    public final AndroidComposeView executeDelayed;
    public boolean isDirty;
    public boolean isFragmented;
    public boolean isScreenOrWindowDirty;
    public final RoomOpenHelper rects;
    public long scheduledDispatchDeadline;
    public final ThrottledCallbacks throttledCallbacks;

    public RectManager(AndroidComposeView androidComposeView) {
        this.executeDelayed = androidComposeView;
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper((char) 0, 7);
        roomOpenHelper.mConfiguration = new long[192];
        roomOpenHelper.mDelegate = new long[192];
        this.rects = roomOpenHelper;
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList();
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new Handshake.AnonymousClass2(13, this);
        this.cachedRect = new MutableRect();
    }

    /* JADX INFO: renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    public static long m617outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeChain nodeChain = layoutNode.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        long jM714plusqkQi6aY = 0;
        for (NodeCoordinator nodeCoordinator2 = (InnerNodeCoordinator) nodeChain.innerCoordinator; nodeCoordinator2 != null && nodeCoordinator2 != nodeCoordinator; nodeCoordinator2 = nodeCoordinator2.wrappedBy) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null && !BrushKt.m418isIdentity58bKbWc(((GraphicsLayerOwnerLayer) ownedLayer).m606getMatrixsQKQjiQ())) {
                return 9223372034707292159L;
            }
            jM714plusqkQi6aY = IntOffset.m714plusqkQi6aY(jM714plusqkQi6aY, nodeCoordinator2.position);
        }
        return jM714plusqkQi6aY;
    }

    public static void resetHasPositionalLayerTransformationsForSubtreeIfNeeded(LayoutNode layoutNode) {
        if (layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot) {
            OwnedLayer ownedLayer = ((NodeCoordinator) layoutNode.nodes.outerCoordinator).layer;
            if (ownedLayer == null || BrushKt.m418isIdentity58bKbWc(((GraphicsLayerOwnerLayer) ownedLayer).m606getMatrixsQKQjiQ())) {
                layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot = false;
                if (layoutNode.outerToInnerOffsetDirty) {
                    layoutNode.outerToInnerOffset = m617outerToInnerOffsetBjo55l4(layoutNode);
                    layoutNode.outerToInnerOffsetDirty = false;
                }
                if (IntOffset.m712equalsimpl0(layoutNode.outerToInnerOffset, 9223372034707292159L)) {
                    return;
                }
                MutableVector mutableVector = layoutNode.get_children$ui();
                Object[] objArr = mutableVector.content;
                int i = mutableVector.size;
                for (int i2 = 0; i2 < i; i2++) {
                    resetHasPositionalLayerTransformationsForSubtreeIfNeeded((LayoutNode) objArr[i2]);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0237  */
    /* JADX WARN: Code duplicated, block: B:103:0x0244  */
    /* JADX WARN: Code duplicated, block: B:105:0x024f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0255  */
    /* JADX WARN: Code duplicated, block: B:109:0x025e A[LOOP:11: B:108:0x025c->B:109:0x025e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x0267 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x0269 A[LOOP:9: B:101:0x0238->B:113:0x0269, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:116:0x0270 A[ADDED_TO_REGION, LOOP:12: B:116:0x0270->B:117:0x0272, LOOP_START, PHI: r1
      0x0270: PHI (r1v10 androidx.compose.ui.spatial.ThrottledCallbacks$Entry) = 
      (r1v8 androidx.compose.ui.spatial.ThrottledCallbacks$Entry)
      (r1v11 androidx.compose.ui.spatial.ThrottledCallbacks$Entry)
     binds: [B:115:0x026e, B:117:0x0272] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x0272 A[LOOP:12: B:116:0x0270->B:117:0x0272, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:121:0x027f  */
    /* JADX WARN: Code duplicated, block: B:142:0x021a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x026c A[EDGE_INSN: B:143:0x026c->B:114:0x026c BREAK  A[LOOP:9: B:101:0x0238->B:113:0x0269], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x026c A[EDGE_INSN: B:144:0x026c->B:114:0x026c BREAK  A[LOOP:9: B:101:0x0238->B:113:0x0269], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0192  */
    /* JADX WARN: Code duplicated, block: B:78:0x019c  */
    /* JADX WARN: Code duplicated, block: B:80:0x019f A[LOOP:7: B:79:0x019d->B:80:0x019f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x01df  */
    /* JADX WARN: Code duplicated, block: B:91:0x0206  */
    /* JADX WARN: Code duplicated, block: B:94:0x0224  */
    /* JADX WARN: Code duplicated, block: B:98:0x022c  */
    public final void dispatchCallbacks() {
        long j;
        int i;
        long j2;
        long j3;
        int i2;
        Object[] objArr;
        long[] jArr;
        int length;
        ThrottledCallbacks.Entry entry;
        int i3;
        long j4;
        int i4;
        long j5;
        int i5;
        ThrottledCallbacks.Entry entry2;
        long[] jArr2;
        long[] jArr3;
        int i6;
        int i7;
        int i8;
        long j6;
        long j7;
        float[] fArr;
        ThrottledCallbacks.Entry entry3;
        ThrottledCallbacks.Entry entry4;
        long j8;
        long j9;
        AndroidComposeView$$ExternalSyntheticLambda2 androidComposeView$$ExternalSyntheticLambda2 = this.dispatchToken;
        if (androidComposeView$$ExternalSyntheticLambda2 != null) {
            if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) androidComposeView$$ExternalSyntheticLambda2)) {
                androidComposeView$$ExternalSyntheticLambda2 = null;
            }
            if (androidComposeView$$ExternalSyntheticLambda2 != null) {
                this.executeDelayed.removeCallbacks(androidComposeView$$ExternalSyntheticLambda2);
            }
            this.dispatchToken = null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = this.isDirty;
        int i9 = 1;
        boolean z2 = z || this.isScreenOrWindowDirty;
        RoomOpenHelper roomOpenHelper = this.rects;
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if (z) {
            this.isDirty = false;
            MutableObjectList mutableObjectList = this.callbacks;
            Object[] objArr2 = mutableObjectList.content;
            int i10 = mutableObjectList._size;
            for (int i11 = 0; i11 < i10; i11++) {
                ((Function0) objArr2[i11]).invoke();
            }
            long[] jArr4 = (long[]) roomOpenHelper.mConfiguration;
            int i12 = roomOpenHelper.version;
            int i13 = 0;
            while (i13 < jArr4.length - 2 && i13 < i12) {
                long j10 = jArr4[i13 + 2];
                if ((((int) (j10 >> 60)) & i9) != 0) {
                    long j11 = jArr4[i13];
                    long j12 = jArr4[i13 + 1];
                    ThrottledCallbacks.Entry entry5 = (ThrottledCallbacks.Entry) throttledCallbacks.rectChangedMap.get(((int) j10) & 33554431);
                    while (entry5 != null) {
                        ThrottledCallbacks.Entry entry6 = entry5.next;
                        int i14 = i12;
                        int i15 = i13;
                        long j13 = entry5.lastInvokeMillis;
                        boolean z3 = jCurrentTimeMillis - j13 >= 0 || j13 == Long.MIN_VALUE;
                        entry5.topLeft = j11;
                        entry5.bottomRight = j12;
                        if (z3) {
                            entry5.lastInvokeMillis = jCurrentTimeMillis;
                            j8 = j12;
                            j9 = j11;
                            entry5.m621fire9b9wPM(j9, j8, throttledCallbacks.windowOffset, throttledCallbacks.screenOffset, throttledCallbacks.viewToWindowMatrix);
                        } else {
                            j8 = j12;
                            j9 = j11;
                        }
                        entry5 = entry6;
                        i12 = i14;
                        j11 = j9;
                        j12 = j8;
                        i13 = i15;
                        jArr4 = jArr4;
                    }
                }
                i13 += 3;
                i12 = i12;
                jArr4 = jArr4;
                i9 = 1;
            }
            j = 0;
            long[] jArr5 = (long[]) roomOpenHelper.mConfiguration;
            int i16 = roomOpenHelper.version;
            for (int i17 = 0; i17 < jArr5.length - 2 && i17 < i16; i17 += 3) {
                int i18 = i17 + 2;
                jArr5[i18] = jArr5[i18] & (-1152921504606846977L);
            }
        } else {
            j = 0;
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            long j14 = throttledCallbacks.windowOffset;
            long j15 = throttledCallbacks.screenOffset;
            float[] fArr2 = throttledCallbacks.viewToWindowMatrix;
            int i19 = 8;
            MutableIntObjectMap mutableIntObjectMap = throttledCallbacks.rectChangedMap;
            j2 = 128;
            Object[] objArr3 = mutableIntObjectMap.values;
            long[] jArr6 = mutableIntObjectMap.metadata;
            int length2 = jArr6.length - 2;
            if (length2 >= 0) {
                RoomOpenHelper roomOpenHelper2 = roomOpenHelper;
                ThrottledCallbacks throttledCallbacks2 = throttledCallbacks;
                int i20 = 0;
                j3 = 255;
                while (true) {
                    long j16 = jArr6[i20];
                    long[] jArr7 = jArr6;
                    Object[] objArr4 = objArr3;
                    if ((((~j16) << 7) & j16 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i21 = 8 - ((~(i20 - length2)) >>> 31);
                        long j17 = j16;
                        int i22 = 0;
                        while (i22 < i21) {
                            if ((j17 & 255) < 128) {
                                ThrottledCallbacks.Entry entry7 = (ThrottledCallbacks.Entry) objArr4[(i20 << 3) + i22];
                                while (entry7 != null) {
                                    throttledCallbacks2.m619fireWY9HvpM(entry7, j14, j15, fArr2, jCurrentTimeMillis);
                                    entry7 = entry7.next;
                                    roomOpenHelper2 = roomOpenHelper2;
                                }
                            }
                            RoomOpenHelper roomOpenHelper3 = roomOpenHelper2;
                            int i23 = i19;
                            j17 >>= i23;
                            i22++;
                            throttledCallbacks2 = throttledCallbacks2;
                            i19 = i23;
                            roomOpenHelper2 = roomOpenHelper3;
                        }
                        roomOpenHelper = roomOpenHelper2;
                        i = i19;
                        throttledCallbacks = throttledCallbacks2;
                        if (i21 != i) {
                            break;
                        }
                    } else {
                        roomOpenHelper = roomOpenHelper2;
                        i = i19;
                        throttledCallbacks = throttledCallbacks2;
                    }
                    if (i20 == length2) {
                        break;
                    }
                    i20++;
                    throttledCallbacks2 = throttledCallbacks;
                    i19 = i;
                    objArr3 = objArr4;
                    jArr6 = jArr7;
                    roomOpenHelper2 = roomOpenHelper;
                }
            } else {
                i = 8;
            }
            if (z2) {
                j6 = throttledCallbacks.windowOffset;
                j7 = throttledCallbacks.screenOffset;
                fArr = throttledCallbacks.viewToWindowMatrix;
                entry3 = throttledCallbacks.globalChangeEntries;
                if (entry3 != null) {
                    for (entry4 = entry3; entry4 != null; entry4 = entry4.next) {
                        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(entry4.node);
                        long jM618getOffsetFromRectListForBjo55l4 = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode)).getRectManager().m618getOffsetFromRectListForBjo55l4(layoutNodeRequireLayoutNode);
                        entry4.topLeft = jM618getOffsetFromRectListForBjo55l4;
                        MeasurePassDelegate measurePassDelegate = layoutNodeRequireLayoutNode.layoutDelegate.measurePassDelegate;
                        entry4.bottomRight = (((long) (measurePassDelegate.width + ((int) (jM618getOffsetFromRectListForBjo55l4 >> 32)))) << 32) | (((long) (measurePassDelegate.height + ((int) (jM618getOffsetFromRectListForBjo55l4 & 4294967295L)))) & 4294967295L);
                        throttledCallbacks.m619fireWY9HvpM(entry4, j6, j7, fArr, jCurrentTimeMillis);
                    }
                }
            }
            if (this.isFragmented) {
                i2 = 0;
                this.isFragmented = false;
                RoomOpenHelper roomOpenHelper4 = roomOpenHelper;
                jArr2 = (long[]) roomOpenHelper4.mConfiguration;
                int i24 = roomOpenHelper4.version;
                jArr3 = (long[]) roomOpenHelper4.mDelegate;
                i7 = 0;
                for (i6 = 0; i6 < jArr2.length - 2 && i7 < jArr3.length - 2 && i6 < i24; i6 += 3) {
                    i8 = i6 + 2;
                    if (jArr2[i8] != RectListKt.TombStone) {
                        jArr3[i7] = jArr2[i6];
                        jArr3[i7 + 1] = jArr2[i6 + 1];
                        jArr3[i7 + 2] = jArr2[i8];
                        i7 += 3;
                    }
                }
                roomOpenHelper4.version = i7;
                roomOpenHelper4.mConfiguration = jArr3;
                roomOpenHelper4.mDelegate = jArr2;
            } else {
                i2 = 0;
            }
            if (throttledCallbacks.minDebounceDeadline <= jCurrentTimeMillis) {
                MutableIntObjectMap mutableIntObjectMap2 = throttledCallbacks.rectChangedMap;
                objArr = mutableIntObjectMap2.values;
                jArr = mutableIntObjectMap2.metadata;
                length = jArr.length - 2;
                if (length >= 0) {
                    i3 = i2;
                    while (true) {
                        j4 = jArr[i3];
                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        } else {
                            i4 = 8 - ((~(i3 - length)) >>> 31);
                            j5 = j4;
                            for (i5 = i2; i5 < i4; i5++) {
                                if ((j5 & j3) < j2) {
                                    for (entry2 = (ThrottledCallbacks.Entry) objArr[(i3 << 3) + i5]; entry2 != null; entry2 = entry2.next) {
                                    }
                                }
                                j5 >>= i;
                            }
                            if (i4 == i) {
                                break;
                            } else if (i3 != length) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                entry = throttledCallbacks.globalChangeEntries;
                if (entry != null) {
                    while (entry != null) {
                        entry = entry.next;
                    }
                }
                throttledCallbacks.minDebounceDeadline = -1L;
            }
            if (throttledCallbacks.minDebounceDeadline > j) {
                scheduleDebounceCallback();
            }
        }
        i = 8;
        j2 = 128;
        j3 = 255;
        if (z2) {
            j6 = throttledCallbacks.windowOffset;
            j7 = throttledCallbacks.screenOffset;
            fArr = throttledCallbacks.viewToWindowMatrix;
            entry3 = throttledCallbacks.globalChangeEntries;
            if (entry3 != null) {
                while (entry4 != null) {
                    LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(entry4.node);
                    long jM618getOffsetFromRectListForBjo55l5 = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode2)).getRectManager().m618getOffsetFromRectListForBjo55l4(layoutNodeRequireLayoutNode2);
                    entry4.topLeft = jM618getOffsetFromRectListForBjo55l5;
                    MeasurePassDelegate measurePassDelegate2 = layoutNodeRequireLayoutNode2.layoutDelegate.measurePassDelegate;
                    entry4.bottomRight = (((long) (measurePassDelegate2.width + ((int) (jM618getOffsetFromRectListForBjo55l5 >> 32)))) << 32) | (((long) (measurePassDelegate2.height + ((int) (jM618getOffsetFromRectListForBjo55l5 & 4294967295L)))) & 4294967295L);
                    throttledCallbacks.m619fireWY9HvpM(entry4, j6, j7, fArr, jCurrentTimeMillis);
                }
            }
        }
        if (this.isFragmented) {
            i2 = 0;
            this.isFragmented = false;
            RoomOpenHelper roomOpenHelper5 = roomOpenHelper;
            jArr2 = (long[]) roomOpenHelper5.mConfiguration;
            int i25 = roomOpenHelper5.version;
            jArr3 = (long[]) roomOpenHelper5.mDelegate;
            i7 = 0;
            while (i6 < jArr2.length - 2) {
                i8 = i6 + 2;
                if (jArr2[i8] != RectListKt.TombStone) {
                    jArr3[i7] = jArr2[i6];
                    jArr3[i7 + 1] = jArr2[i6 + 1];
                    jArr3[i7 + 2] = jArr2[i8];
                    i7 += 3;
                }
            }
            roomOpenHelper5.version = i7;
            roomOpenHelper5.mConfiguration = jArr3;
            roomOpenHelper5.mDelegate = jArr2;
        } else {
            i2 = 0;
        }
        if (throttledCallbacks.minDebounceDeadline <= jCurrentTimeMillis) {
            MutableIntObjectMap mutableIntObjectMap3 = throttledCallbacks.rectChangedMap;
            objArr = mutableIntObjectMap3.values;
            jArr = mutableIntObjectMap3.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                i3 = i2;
                while (true) {
                    j4 = jArr[i3];
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        if (i3 != length) {
                            break;
                            break;
                        }
                        i3++;
                    } else {
                        i4 = 8 - ((~(i3 - length)) >>> 31);
                        j5 = j4;
                        while (i5 < i4) {
                            if ((j5 & j3) < j2) {
                                while (entry2 != null) {
                                }
                            }
                            j5 >>= i;
                        }
                        if (i4 == i) {
                            break;
                            break;
                        } else {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            entry = throttledCallbacks.globalChangeEntries;
            if (entry != null) {
                while (entry != null) {
                    entry = entry.next;
                }
            }
            throttledCallbacks.minDebounceDeadline = -1L;
        }
        if (throttledCallbacks.minDebounceDeadline > j) {
            scheduleDebounceCallback();
        }
    }

    /* JADX INFO: renamed from: getOffsetFromRectListFor-Bjo55l4, reason: not valid java name */
    public final long m618getOffsetFromRectListForBjo55l4(LayoutNode layoutNode) {
        long j;
        int i = layoutNode.semanticsId & 33554431;
        RoomOpenHelper roomOpenHelper = this.rects;
        long[] jArr = (long[]) roomOpenHelper.mConfiguration;
        int i2 = roomOpenHelper.version;
        int i3 = 0;
        while (true) {
            if (i3 >= jArr.length - 2 || i3 >= i2) {
                j = Long.MAX_VALUE;
                break;
            }
            if ((((int) jArr[i3 + 2]) & 33554431) == i) {
                j = jArr[i3];
                break;
            }
            i3 += 3;
        }
        if (j == Long.MAX_VALUE) {
            return 9223372034707292159L;
        }
        return (((long) ((int) (j >> 32))) << 32) | (((long) ((int) j)) & 4294967295L);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0101  */
    /* JADX WARN: Code duplicated, block: B:33:0x0105  */
    public final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        boolean z;
        LayoutNode parent$ui;
        int i;
        boolean z2 = true;
        layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot = true;
        NodeChain nodeChain = layoutNode.nodes;
        MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
        int measuredWidth = measurePassDelegate.getMeasuredWidth();
        float measuredHeight = measurePassDelegate.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.left = 0.0f;
        mutableRect.top = 0.0f;
        mutableRect.right = measuredWidth;
        mutableRect.bottom = measuredHeight;
        for (NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            LayoutNode layoutNode2 = nodeCoordinator.layoutNode;
            if (nodeCoordinator == ((NodeCoordinator) layoutNode2.nodes.outerCoordinator) && !layoutNode2.hasPositionalLayerTransformationsInOffsetFromRoot) {
                long jM618getOffsetFromRectListForBjo55l4 = m618getOffsetFromRectListForBjo55l4(layoutNode2);
                if (!IntOffset.m712equalsimpl0(jM618getOffsetFromRectListForBjo55l4, 9223372034707292159L)) {
                    mutableRect.m367translatek4lQ0M((((long) Float.floatToRawIntBits((int) (jM618getOffsetFromRectListForBjo55l4 >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (jM618getOffsetFromRectListForBjo55l4 & 4294967295L))) & 4294967295L));
                    break;
                }
            }
            OwnedLayer ownedLayer = nodeCoordinator.layer;
            if (ownedLayer != null) {
                float[] fArrM606getMatrixsQKQjiQ = ((GraphicsLayerOwnerLayer) ownedLayer).m606getMatrixsQKQjiQ();
                if (!BrushKt.m418isIdentity58bKbWc(fArrM606getMatrixsQKQjiQ)) {
                    Matrix.m444mapimpl(fArrM606getMatrixsQKQjiQ, mutableRect);
                }
            }
            long j = nodeCoordinator.position;
            mutableRect.m367translatek4lQ0M((4294967295L & ((long) Float.floatToRawIntBits((int) (j & 4294967295L)))) | (Float.floatToRawIntBits((int) (j >> 32)) << 32));
        }
        int i2 = (int) mutableRect.left;
        int i3 = (int) mutableRect.top;
        int i4 = (int) mutableRect.right;
        int i5 = (int) mutableRect.bottom;
        int i6 = layoutNode.semanticsId;
        boolean z3 = layoutNode.addedToRectList;
        layoutNode.addedToRectList = true;
        RoomOpenHelper roomOpenHelper = this.rects;
        if (z3) {
            int i7 = i6 & 33554431;
            long[] jArr = (long[]) roomOpenHelper.mConfiguration;
            int i8 = roomOpenHelper.version;
            int i9 = 0;
            while (true) {
                if (i9 >= jArr.length - 2 || i9 >= i8) {
                    z = z2;
                    parent$ui = layoutNode.getParent$ui();
                    if (parent$ui != null) {
                        i = parent$ui.semanticsId;
                    } else {
                        i = -1;
                    }
                    roomOpenHelper.insert(i6, i2, i3, i4, i5, (512 & 32) != 0 ? -1 : i, nodeChain.m565hasH91voCI$ui(1024), nodeChain.m565hasH91voCI$ui(16), this.throttledCallbacks.rectChangedMap.containsKey(i6), -1);
                } else {
                    int i10 = i9 + 2;
                    long j2 = jArr[i10];
                    z = z2;
                    if ((((int) j2) & 33554431) == i7) {
                        jArr[i9] = (((long) i2) << 32) | (((long) i3) & 4294967295L);
                        jArr[i9 + 1] = (((long) i4) << 32) | (((long) i5) & 4294967295L);
                        jArr[i10] = (((j2 >> 63) & 1) << 60) | j2;
                    } else {
                        i9 += 3;
                        z2 = z;
                    }
                }
            }
        } else {
            z = z2;
            parent$ui = layoutNode.getParent$ui();
            if (parent$ui != null) {
                i = parent$ui.semanticsId;
            } else {
                i = -1;
            }
            roomOpenHelper.insert(i6, i2, i3, i4, i5, (512 & 32) != 0 ? -1 : i, nodeChain.m565hasH91voCI$ui(1024), nodeChain.m565hasH91voCI$ui(16), this.throttledCallbacks.rectChangedMap.containsKey(i6), -1);
        }
        layoutNode.rectInParentDirty = false;
        this.isDirty = z;
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i11 = mutableVector.size;
        for (int i12 = 0; i12 < i11; i12++) {
            LayoutNode layoutNode3 = (LayoutNode) objArr[i12];
            if (layoutNode3.isPlaced()) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode3);
            }
        }
    }

    public final void recalculateRectIfDirty(LayoutNode layoutNode) {
        long j;
        OwnedLayer ownedLayer;
        boolean zIsPlaced = layoutNode.isPlaced();
        NodeChain nodeChain = layoutNode.nodes;
        if (zIsPlaced && layoutNode.rectInParentDirty) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if (parent$ui == null || parent$ui.hasPositionalLayerTransformationsInOffsetFromRoot) {
                j = parent$ui == null ? 0L : 9223372034707292159L;
            } else {
                if (parent$ui.outerToInnerOffsetDirty) {
                    parent$ui.outerToInnerOffsetDirty = false;
                    parent$ui.outerToInnerOffset = m617outerToInnerOffsetBjo55l4(parent$ui);
                }
                j = parent$ui.outerToInnerOffset;
            }
            NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
            if (IntOffset.m712equalsimpl0(j, 9223372034707292159L) || !((ownedLayer = nodeCoordinator.layer) == null || BrushKt.m418isIdentity58bKbWc(((GraphicsLayerOwnerLayer) ownedLayer).m606getMatrixsQKQjiQ()))) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
            } else if (layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNode);
            } else {
                long jM714plusqkQi6aY = IntOffset.m714plusqkQi6aY(j, nodeCoordinator.position);
                MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
                int measuredWidth = measurePassDelegate.getMeasuredWidth();
                int measuredHeight = measurePassDelegate.getMeasuredHeight();
                int i = layoutNode.semanticsId;
                boolean z = layoutNode.addedToRectList;
                RoomOpenHelper roomOpenHelper = this.rects;
                long j2 = 4294967295L;
                if (!z) {
                    layoutNode.addedToRectList = true;
                    boolean zM565hasH91voCI$ui = nodeChain.m565hasH91voCI$ui(1024);
                    boolean zM565hasH91voCI$ui2 = nodeChain.m565hasH91voCI$ui(16);
                    boolean zContainsKey = this.throttledCallbacks.rectChangedMap.containsKey(i);
                    if (parent$ui != null) {
                        int i2 = parent$ui.semanticsId;
                        int i3 = (int) (jM714plusqkQi6aY >> 32);
                        int i4 = (int) (jM714plusqkQi6aY & 4294967295L);
                        int i5 = i & 33554431;
                        long[] jArr = (long[]) roomOpenHelper.mConfiguration;
                        for (int i6 = roomOpenHelper.version - 3; i6 >= 0; i6 -= 3) {
                            if ((((int) jArr[i6 + 2]) & 33554431) == i2) {
                                long j3 = jArr[i6];
                                int i7 = ((int) (j3 >> 32)) + i3;
                                int i8 = ((int) j3) + i4;
                                roomOpenHelper.insert(i5, i7, i8, measuredWidth + i7, i8 + measuredHeight, i2, zM565hasH91voCI$ui, zM565hasH91voCI$ui2, zContainsKey, i6);
                                break;
                            }
                        }
                    } else {
                        int i9 = (int) (jM714plusqkQi6aY >> 32);
                        int i10 = (int) (jM714plusqkQi6aY & 4294967295L);
                        roomOpenHelper.insert(i, i9, i10, i9 + measuredWidth, i10 + measuredHeight, (512 & 32) != 0 ? -1 : 0, zM565hasH91voCI$ui, zM565hasH91voCI$ui2, zContainsKey, -1);
                    }
                } else if (parent$ui != null) {
                    int i11 = parent$ui.semanticsId;
                    int i12 = (int) (jM714plusqkQi6aY >> 32);
                    int i13 = (int) (jM714plusqkQi6aY & 4294967295L);
                    int i14 = i & 33554431;
                    long[] jArr2 = (long[]) roomOpenHelper.mConfiguration;
                    int i15 = roomOpenHelper.version;
                    int i16 = 0;
                    loop0: while (i16 < jArr2.length - 2 && i16 < i15) {
                        long j4 = j2;
                        if ((((int) jArr2[i16 + 2]) & 33554431) == i11) {
                            long j5 = jArr2[i16];
                            int i17 = ((int) (j5 >> 32)) + i12;
                            int i18 = ((int) j5) + i13;
                            int i19 = i17 + measuredWidth;
                            int i20 = i18 + measuredHeight;
                            i16 += 3;
                            while (i16 < jArr2.length - 2 && i16 < i15) {
                                int i21 = i16 + 2;
                                int i22 = i11;
                                int i23 = i12;
                                long j6 = jArr2[i21];
                                int i24 = i13;
                                if ((((int) j6) & 33554431) == i14) {
                                    long j7 = jArr2[i16];
                                    long[] jArr3 = jArr2;
                                    int i25 = i17 - ((int) (j7 >> 32));
                                    int i26 = i18 - ((int) j7);
                                    jArr3[i16] = (((long) i18) & j4) | (((long) i17) << 32);
                                    jArr3[i16 + 1] = (((long) i19) << 32) | (((long) i20) & j4);
                                    jArr3[i21] = j6 | (((j6 >> 63) & 1) << 60);
                                    if (i25 != 0 || i26 != 0) {
                                        roomOpenHelper.updateSubhierarchy(i25, i26, (j6 & RectListKt.EverythingButParentId) | (((long) ((i16 + 3) & 33554431)) << 25));
                                        break loop0;
                                    }
                                    break loop0;
                                }
                                i16 += 3;
                                i11 = i22;
                                i12 = i23;
                                i13 = i24;
                            }
                        }
                        i16 += 3;
                        jArr2 = jArr2;
                        j2 = j4;
                        i11 = i11;
                        i12 = i12;
                        i13 = i13;
                    }
                } else {
                    int i27 = (int) (jM714plusqkQi6aY >> 32);
                    int i28 = (int) (jM714plusqkQi6aY & 4294967295L);
                    int i29 = measuredWidth + i27;
                    int i30 = i28 + measuredHeight;
                    int i31 = i & 33554431;
                    long[] jArr4 = (long[]) roomOpenHelper.mConfiguration;
                    int i32 = roomOpenHelper.version;
                    for (int i33 = 0; i33 < jArr4.length - 2 && i33 < i32; i33 += 3) {
                        int i34 = i33 + 2;
                        long j8 = jArr4[i34];
                        if ((((int) j8) & 33554431) == i31) {
                            long j9 = jArr4[i33];
                            jArr4[i33] = (((long) i27) << 32) | (((long) i28) & 4294967295L);
                            jArr4[i33 + 1] = (((long) i30) & 4294967295L) | (((long) i29) << 32);
                            jArr4[i34] = (((j8 >> 63) & 1) << 60) | j8;
                            int i35 = i27 - ((int) (j9 >> 32));
                            int i36 = i28 - ((int) j9);
                            if (!(i35 != 0) && !(i36 != 0)) {
                                break;
                            }
                            roomOpenHelper.updateSubhierarchy(i35, i36, (RectListKt.EverythingButParentId & j8) | (((long) ((i33 + 3) & 33554431)) << 25));
                            break;
                        }
                    }
                }
            }
            layoutNode.rectInParentDirty = false;
            this.isDirty = true;
            scheduleDebounceCallback();
        }
    }

    public final void remove(LayoutNode layoutNode) {
        if (layoutNode.addedToRectList) {
            int i = layoutNode.semanticsId & 33554431;
            RoomOpenHelper roomOpenHelper = this.rects;
            long[] jArr = (long[]) roomOpenHelper.mConfiguration;
            int i2 = roomOpenHelper.version;
            for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
                int i4 = i3 + 2;
                if ((((int) jArr[i4]) & 33554431) == i) {
                    jArr[i3] = -1;
                    jArr[i3 + 1] = -1;
                    jArr[i4] = RectListKt.TombStone;
                    break;
                }
            }
            layoutNode.addedToRectList = false;
            layoutNode.rectInParentDirty = true;
            this.isDirty = true;
            this.isFragmented = true;
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
    public final void scheduleDebounceCallback() {
        AndroidComposeView$$ExternalSyntheticLambda2 androidComposeView$$ExternalSyntheticLambda2 = this.dispatchToken;
        boolean z = androidComposeView$$ExternalSyntheticLambda2 != null;
        long j = this.throttledCallbacks.minDebounceDeadline;
        if (j >= 0 || !z) {
            if (this.scheduledDispatchDeadline == j && z) {
                return;
            }
            AndroidComposeView androidComposeView = this.executeDelayed;
            if (androidComposeView$$ExternalSyntheticLambda2 != null) {
                if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) androidComposeView$$ExternalSyntheticLambda2)) {
                    androidComposeView$$ExternalSyntheticLambda2 = null;
                }
                if (androidComposeView$$ExternalSyntheticLambda2 != null) {
                    androidComposeView.removeCallbacks(androidComposeView$$ExternalSyntheticLambda2);
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jMax = Math.max(j, ((long) 16) + jCurrentTimeMillis);
            this.scheduledDispatchDeadline = jMax;
            AndroidComposeView$$ExternalSyntheticLambda2 androidComposeView$$ExternalSyntheticLambda3 = new AndroidComposeView$$ExternalSyntheticLambda2(0, this.dispatchLambda);
            androidComposeView.postDelayed(androidComposeView$$ExternalSyntheticLambda3, jMax - jCurrentTimeMillis);
            this.dispatchToken = androidComposeView$$ExternalSyntheticLambda3;
        }
    }
}
