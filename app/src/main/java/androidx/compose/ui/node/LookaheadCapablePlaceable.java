package androidx.compose.ui.node;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OuterPlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.Arrays;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MotionReferencePlacementDelegate, MeasureScope {
    public ResettableRulerScope _rulerScope;
    public PlaceableResult cachedRulerPlaceableResult;
    public boolean isPlacedUnderMotionFrameOfReference;
    public boolean isPlacingForAlignment;
    public boolean isShallowPlacing;
    public final OuterPlacementScope placementScope = new OuterPlacementScope(1, this);
    public MutableScatterMap rulerReaders;
    public RulerTrackingMap rulerValues;
    public Function1 rulersLambda;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ResettableRulerScope implements Density {
        public boolean coordinatesAccessed;
        public long positionOnScreen = 9223372034707292159L;
        public long size = 0;

        public ResettableRulerScope() {
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return LookaheadCapablePlaceable.this.getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return LookaheadCapablePlaceable.this.getFontScale();
        }

        public final void provides(VerticalRuler verticalRuler, float f) {
            LookaheadCapablePlaceable lookaheadCapablePlaceable = LookaheadCapablePlaceable.this;
            RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable.rulerValues;
            if (rulerTrackingMap == null) {
                rulerTrackingMap = new RulerTrackingMap();
                lookaheadCapablePlaceable.rulerValues = rulerTrackingMap;
            }
            int iIndexOf = ArraysKt.indexOf((VerticalRuler[]) rulerTrackingMap.rulers, verticalRuler);
            if (iIndexOf >= 0) {
                float[] fArr = (float[]) rulerTrackingMap.values;
                if (fArr[iIndexOf] != f) {
                    fArr[iIndexOf] = f;
                    ((byte[]) rulerTrackingMap.accessFlags)[iIndexOf] = 1;
                    return;
                } else {
                    byte[] bArr = (byte[]) rulerTrackingMap.accessFlags;
                    if (bArr[iIndexOf] == 2) {
                        bArr[iIndexOf] = 0;
                        return;
                    }
                    return;
                }
            }
            int i = rulerTrackingMap.size;
            VerticalRuler[] verticalRulerArr = (VerticalRuler[]) rulerTrackingMap.rulers;
            if (i == verticalRulerArr.length) {
                int i2 = i * 2;
                rulerTrackingMap.rulers = (VerticalRuler[]) Arrays.copyOf(verticalRulerArr, i2);
                rulerTrackingMap.values = Arrays.copyOf((float[]) rulerTrackingMap.values, i2);
                rulerTrackingMap.accessFlags = Arrays.copyOf((byte[]) rulerTrackingMap.accessFlags, i2);
            }
            ((VerticalRuler[]) rulerTrackingMap.rulers)[i] = verticalRuler;
            ((byte[]) rulerTrackingMap.accessFlags)[i] = 3;
            ((float[]) rulerTrackingMap.values)[i] = f;
            rulerTrackingMap.size++;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public final /* synthetic */ int mo86roundToPx0680j_4(float f) {
            return Density.CC.m695$default$roundToPx0680j_4(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public final /* synthetic */ float mo87toDpGaN1DYA(long j) {
            return Density.CC.m696$default$toDpGaN1DYA(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo89toDpu2uoSUM(int i) {
            return i / getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public final /* synthetic */ long mo90toDpSizekrfVVM(long j) {
            return Density.CC.m697$default$toDpSizekrfVVM(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public final /* synthetic */ float mo91toPxR2X_6o(long j) {
            return Density.CC.m698$default$toPxR2X_6o(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public final float mo92toPx0680j_4(float f) {
            return getDensity() * f;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public final /* synthetic */ long mo93toSizeXkaWNTQ(long j) {
            return Density.CC.m699$default$toSizeXkaWNTQ(j, this);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final long mo94toSpkPz2Gy4(float f) {
            return Density.CC.m700$default$toSp0xMU5do(this, mo88toDpu2uoSUM(f));
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final float mo88toDpu2uoSUM(float f) {
            return f / getDensity();
        }
    }

    public static void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        LookaheadAlignmentLines lookaheadAlignmentLines;
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrapped;
        LayoutNode layoutNode = nodeCoordinator.layoutNode;
        if (!Intrinsics.areEqual(nodeCoordinator2 != null ? nodeCoordinator2.layoutNode : null, layoutNode)) {
            layoutNode.layoutDelegate.measurePassDelegate.alignmentLines.onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = layoutNode.layoutDelegate.measurePassDelegate.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (lookaheadAlignmentLines = ((MeasurePassDelegate) parentAlignmentLinesOwner).alignmentLines) == null) {
            return;
        }
        lookaheadAlignmentLines.onAlignmentsChanged();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0108  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addRulerReader(LayoutNode layoutNode, VerticalRuler verticalRuler) {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        long j4;
        int i;
        char c2;
        long j5;
        long j6;
        int i2;
        int i3;
        int i4;
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i6 = 0;
                long j8 = 128;
                while (true) {
                    long j9 = jArr3[i6];
                    j2 = 255;
                    if ((((~j9) << c3) & j9 & j7) != j7) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j9 & 255) < j8) {
                                c2 = c3;
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) objArr[(i6 << 3) + i8];
                                j5 = j7;
                                Object[] objArr2 = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    j6 = j8;
                                    int i9 = 0;
                                    int i10 = i5;
                                    while (true) {
                                        int i11 = length2;
                                        long j10 = jArr4[i9];
                                        jArr2 = jArr3;
                                        j4 = j9;
                                        if ((((~j10) << c2) & j10 & j5) != j5) {
                                            int i12 = 8 - ((~(i9 - i11)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j10 & 255) < j6) {
                                                    int i14 = (i9 << 3) + i13;
                                                    LayoutNode layoutNode2 = (LayoutNode) ((WeakReference) objArr2[i14]).get();
                                                    i3 = i13;
                                                    if (layoutNode2 != null) {
                                                        boolean zIsAttached = layoutNode2.isAttached();
                                                        i4 = i8;
                                                        if (zIsAttached) {
                                                        }
                                                    } else {
                                                        i4 = i8;
                                                    }
                                                    mutableScatterSet.removeElementAt(i14);
                                                } else {
                                                    i3 = i13;
                                                    i4 = i8;
                                                }
                                                j10 >>= i10;
                                                i13 = i3 + 1;
                                                i8 = i4;
                                            }
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            i = i8;
                                        }
                                        length2 = i11;
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        jArr3 = jArr2;
                                        j9 = j4;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j4 = j9;
                                    i = i8;
                                    j6 = j8;
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j4 = j9;
                                i = i8;
                                c2 = c3;
                                j5 = j7;
                                j6 = j8;
                                i2 = i5;
                            }
                            i5 = i2;
                            j9 = j4 >> i2;
                            c3 = c2;
                            j7 = j5;
                            j8 = j6;
                            i8 = i + 1;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        c = c3;
                        j = j7;
                        j3 = j8;
                        if (i7 != i5) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        c = c3;
                        j = j7;
                        j3 = j8;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    c3 = c;
                    j7 = j;
                    j8 = j3;
                    jArr3 = jArr;
                    i5 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 255;
                j3 = 128;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 255;
            j3 = 128;
        }
        MutableScatterMap mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
            long[] jArr5 = mutableScatterMap2.metadata;
            int length3 = jArr5.length - 2;
            if (length3 >= 0) {
                int i15 = 0;
                while (true) {
                    long j11 = jArr5[i15];
                    if ((((~j11) << c) & j11 & j) != j) {
                        int i16 = 8 - ((~(i15 - length3)) >>> 31);
                        for (int i17 = 0; i17 < i16; i17++) {
                            if ((j11 & j2) < j3) {
                                int i18 = (i15 << 3) + i17;
                                if (((MutableScatterSet) mutableScatterMap2.values[i18]).isEmpty()) {
                                    mutableScatterMap2.removeValueAt(i18);
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i16 != 8) {
                            break;
                        }
                    }
                    if (i15 == length3) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
        }
        MutableScatterMap mutableScatterMap3 = this.rulerReaders;
        if (mutableScatterMap3 == null) {
            mutableScatterMap3 = new MutableScatterMap();
            this.rulerReaders = mutableScatterMap3;
        }
        Object mutableScatterSet2 = mutableScatterMap3.get(verticalRuler);
        if (mutableScatterSet2 == null) {
            mutableScatterSet2 = new MutableScatterSet();
            mutableScatterMap3.set(verticalRuler, mutableScatterSet2);
        }
        ((MutableScatterSet) mutableScatterSet2).plusAssign(new WeakReference(layoutNode));
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: captureRulers-OSxE8f4, reason: not valid java name */
    public final void m553captureRulersOSxE8f4(final PlaceableResult placeableResult, final long j, final long j2) {
        boolean z;
        char c;
        long j3;
        long j4;
        long j5;
        LayoutNode layoutNode;
        boolean z2;
        int i;
        char c2;
        long j6;
        MutableScatterSet mutableScatterSet;
        OwnerSnapshotObserver snapshotObserver;
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        RulerTrackingMap rulerTrackingMap2 = rulerTrackingMap;
        Owner owner = getLayoutNode().owner;
        if (owner != null && (snapshotObserver = ((AndroidComposeView) owner).getSnapshotObserver()) != null) {
            snapshotObserver.observer.observeReads(placeableResult, OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$2, new Function0() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    LookaheadCapablePlaceable lookaheadCapablePlaceable = this.this$0;
                    lookaheadCapablePlaceable.getRulerScope().coordinatesAccessed = false;
                    lookaheadCapablePlaceable.getRulerScope().positionOnScreen = j;
                    lookaheadCapablePlaceable.getRulerScope().size = j2;
                    Function1 rulers = placeableResult.result.getRulers();
                    if (rulers != null) {
                        rulers.invoke(lookaheadCapablePlaceable.getRulerScope());
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        boolean zIsLookingAhead = isLookingAhead();
        MutableScatterSet mutableScatterSet2 = (MutableScatterSet) rulerTrackingMap2.layoutNodes;
        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) rulerTrackingMap2.newRulers;
        int i2 = rulerTrackingMap2.size;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = ((byte[]) rulerTrackingMap2.accessFlags)[i3];
            if (b == 3) {
                mutableScatterSet3.plusAssign(((VerticalRuler[]) rulerTrackingMap2.rulers)[i3]);
            } else if (b != 0 && mutableScatterMap != null && (mutableScatterSet = (MutableScatterSet) mutableScatterMap.remove(((VerticalRuler[]) rulerTrackingMap2.rulers)[i3])) != null) {
                mutableScatterSet2.plusAssign(mutableScatterSet);
            }
        }
        int i4 = rulerTrackingMap2.size;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            byte[] bArr = (byte[]) rulerTrackingMap2.accessFlags;
            if (bArr[i6] == 2) {
                i5++;
            } else if (i5 > 0) {
                VerticalRuler[] verticalRulerArr = (VerticalRuler[]) rulerTrackingMap2.rulers;
                verticalRulerArr[i6 - i5] = verticalRulerArr[i6];
            }
            bArr[i6] = 2;
        }
        int i7 = rulerTrackingMap2.size;
        for (int i8 = i7 - i5; i8 < i7; i8++) {
            ((VerticalRuler[]) rulerTrackingMap2.rulers)[i8] = null;
        }
        rulerTrackingMap2.size -= i5;
        LookaheadCapablePlaceable parent = getParent();
        Object[] objArr = mutableScatterSet3.elements;
        long[] jArr = mutableScatterSet3.metadata;
        int length = jArr.length - 2;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i9 = 8;
        if (length >= 0) {
            j4 = 128;
            int i10 = 0;
            while (true) {
                long j8 = jArr[i10];
                j5 = 255;
                if ((((~j8) << c3) & j8 & j7) != j7) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j8 & 255) < 128) {
                            c2 = c3;
                            VerticalRuler verticalRuler = (VerticalRuler) objArr[(i10 << 3) + i12];
                            j6 = j7;
                            LookaheadCapablePlaceable lookaheadCapablePlaceable = parent == null ? this : parent;
                            i = i9;
                            LookaheadCapablePlaceable lookaheadCapablePlaceable2 = lookaheadCapablePlaceable;
                            while (true) {
                                RulerTrackingMap rulerTrackingMap3 = lookaheadCapablePlaceable2.rulerValues;
                                if (rulerTrackingMap3 != null) {
                                    z2 = zIsLookingAhead;
                                    if (ArraysKt.contains((VerticalRuler[]) rulerTrackingMap3.rulers, verticalRuler)) {
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                z2 = zIsLookingAhead;
                                LookaheadCapablePlaceable parent2 = lookaheadCapablePlaceable2.getParent();
                                if (parent2 == null) {
                                    break;
                                }
                                lookaheadCapablePlaceable2 = parent2;
                                zIsLookingAhead = z2;
                            }
                            MutableScatterMap mutableScatterMap2 = lookaheadCapablePlaceable2.rulerReaders;
                            MutableScatterSet mutableScatterSet4 = mutableScatterMap2 != null ? (MutableScatterSet) mutableScatterMap2.remove(verticalRuler) : null;
                            if (mutableScatterSet4 != null) {
                                lookaheadCapablePlaceable.notifyRulerValueChange(mutableScatterSet4);
                            }
                        } else {
                            z2 = zIsLookingAhead;
                            i = i9;
                            c2 = c3;
                            j6 = j7;
                        }
                        j8 >>= i;
                        i12++;
                        c3 = c2;
                        j7 = j6;
                        i9 = i;
                        zIsLookingAhead = z2;
                    }
                    z = zIsLookingAhead;
                    c = c3;
                    j3 = j7;
                    if (i11 != i9) {
                        break;
                    }
                } else {
                    z = zIsLookingAhead;
                    c = c3;
                    j3 = j7;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                c3 = c;
                j7 = j3;
                zIsLookingAhead = z;
                i9 = 8;
            }
        } else {
            z = zIsLookingAhead;
            c = 7;
            j3 = -9187201950435737472L;
            j4 = 128;
            j5 = 255;
        }
        mutableScatterSet3.clear();
        Object[] objArr2 = mutableScatterSet2.elements;
        long[] jArr2 = mutableScatterSet2.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i13 = 0;
            while (true) {
                long j9 = jArr2[i13];
                if ((((~j9) << c) & j9 & j3) != j3) {
                    int i14 = 8 - ((~(i13 - length2)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((j9 & j5) < j4 && (layoutNode = (LayoutNode) ((WeakReference) objArr2[(i13 << 3) + i15]).get()) != null) {
                            if (z) {
                                layoutNode.requestLookaheadRelayout$ui(false);
                            } else {
                                layoutNode.requestRelayout$ui(false);
                            }
                        }
                        j9 >>= 8;
                    }
                    if (i14 != 8) {
                        break;
                    }
                }
                if (i13 == length2) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        mutableScatterSet2.clear();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0053 A[LOOP:0: B:11:0x001c->B:21:0x0053, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x0056 A[EDGE_INSN: B:48:0x0056->B:22:0x0056 BREAK  A[LOOP:0: B:11:0x001c->B:21:0x0053], SYNTHETIC] */
    public final void captureRulersIfNeeded$ui(MeasureResult measureResult) {
        long j;
        long j2;
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        if (!this.isPlacingForAlignment) {
            Function1 rulers = measureResult.getRulers();
            if (rulers != null) {
                boolean z = this.rulersLambda != rulers;
                if (z || !getRulerScope().coordinatesAccessed) {
                    j = 0;
                    j2 = 9223372034707292159L;
                } else {
                    LayoutCoordinates coordinates = getCoordinates();
                    long jM717roundk4lQ0M = IntOffsetKt.m717roundk4lQ0M(coordinates.mo526localToScreenMKHz9U(0L));
                    long jMo522getSizeYbymL2g = coordinates.mo522getSizeYbymL2g();
                    j2 = jM717roundk4lQ0M;
                    j = jMo522getSizeYbymL2g;
                    z = (IntOffset.m712equalsimpl0(jM717roundk4lQ0M, getRulerScope().positionOnScreen) && IntSize.m720equalsimpl0(jMo522getSizeYbymL2g, getRulerScope().size)) ? false : true;
                }
                if (z) {
                    PlaceableResult placeableResult = this.cachedRulerPlaceableResult;
                    if (placeableResult != null) {
                        placeableResult.result = measureResult;
                    } else {
                        placeableResult = new PlaceableResult(measureResult, this);
                        this.cachedRulerPlaceableResult = placeableResult;
                    }
                    m553captureRulersOSxE8f4(placeableResult, j2, j);
                    this.rulersLambda = measureResult.getRulers();
                }
            } else if (mutableScatterMap != null) {
                Object[] objArr = mutableScatterMap.values;
                long[] jArr = mutableScatterMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j3 = jArr[i];
                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i != length) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j3) < 128) {
                                    notifyRulerValueChange((MutableScatterSet) objArr[(i << 3) + i3]);
                                }
                                j3 >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            } else if (i != length) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                mutableScatterMap.clear();
            }
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        if (getHasMeasureResult() && (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) {
            return iCalculateAlignmentLine + ((int) (alignmentLine instanceof VerticalAlignmentLine ? this.apparentToRealOffset >> 32 : this.apparentToRealOffset & 4294967295L));
        }
        return Integer.MIN_VALUE;
    }

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui();

    public abstract LookaheadCapablePlaceable getParent();

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long mo554getPositionnOccac();

    public final ResettableRulerScope getRulerScope() {
        ResettableRulerScope resettableRulerScope = this._rulerScope;
        if (resettableRulerScope != null) {
            return resettableRulerScope;
        }
        ResettableRulerScope resettableRulerScope2 = new ResettableRulerScope();
        this._rulerScope = resettableRulerScope2;
        return resettableRulerScope2;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public final MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return layout(i, i2, map, null, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void notifyRulerValueChange(MutableScatterSet mutableScatterSet) {
        LayoutNode layoutNode;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i3]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui(false);
                        } else {
                            layoutNode.requestRelayout$ui(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public abstract void replace$ui();

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo86roundToPx0680j_4(float f) {
        return Density.CC.m695$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo87toDpGaN1DYA(long j) {
        return Density.CC.m696$default$toDpGaN1DYA(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo89toDpu2uoSUM(int i) {
        return i / getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo90toDpSizekrfVVM(long j) {
        return Density.CC.m697$default$toDpSizekrfVVM(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo91toPxR2X_6o(long j) {
        return Density.CC.m698$default$toPxR2X_6o(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo92toPx0680j_4(float f) {
        return getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo93toSizeXkaWNTQ(long j) {
        return Density.CC.m699$default$toSizeXkaWNTQ(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo94toSpkPz2Gy4(float f) {
        return Density.CC.m700$default$toSp0xMU5do(this, mo88toDpu2uoSUM(f));
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public final void updatePlacedUnderMotionFrameOfReference(boolean z) {
        LookaheadCapablePlaceable parent = getParent();
        LayoutNode layoutNode = parent != null ? parent.getLayoutNode() : null;
        if (Intrinsics.areEqual(layoutNode, getLayoutNode())) {
            this.isPlacedUnderMotionFrameOfReference = z;
            return;
        }
        if ((layoutNode != null ? layoutNode.layoutDelegate.layoutState : 0) != 3) {
            if ((layoutNode != null ? layoutNode.layoutDelegate.layoutState : 0) != 4) {
                return;
            }
        }
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public final MeasureResult layout(final int i, final int i2, final Map map, final Function1 function1, final Function1 function2) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            public final Map getAlignmentLines() {
                return map;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getHeight() {
                return i2;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final Function1 getRulers() {
                return function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getWidth() {
                return i;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final void placeChildren() {
                function2.invoke(this.placementScope);
            }
        };
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo88toDpu2uoSUM(float f) {
        return f / getDensity();
    }
}
