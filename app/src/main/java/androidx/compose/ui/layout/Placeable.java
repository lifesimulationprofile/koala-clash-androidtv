package androidx.compose.ui.layout;

import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Placeable {
    public int height;
    public long measuredSize;
    public int width;
    public long measurementConstraints = PlaceableKt.DefaultConstraints;
    public long apparentToRealOffset = 0;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class PlacementScope implements Density {
        public boolean motionFrameOfReferencePlacement;

        /* JADX WARN: Multi-variable type inference failed */
        public static final void access$handleMotionFrameOfReferencePlacement(PlacementScope placementScope, Placeable placeable) {
            placementScope.getClass();
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).updatePlacedUnderMotionFrameOfReference(placementScope.motionFrameOfReferencePlacement);
            }
        }

        public static void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2) {
            placementScope.getClass();
            access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
            placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY((((long) i2) & 4294967295L) | (((long) i) << 32), placeable.apparentToRealOffset), 0.0f, null);
        }

        /* JADX INFO: renamed from: place-70tqf50$default, reason: not valid java name */
        public static void m536place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j) {
            placementScope.getClass();
            access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
            placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j, placeable.apparentToRealOffset), 0.0f, null);
        }

        public static void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2) {
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            if (placementScope.getParentLayoutDirection() == LayoutDirection.Ltr || placementScope.getParentWidth() == 0) {
                access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j, placeable.apparentToRealOffset), 0.0f, null);
            } else {
                int parentWidth = (placementScope.getParentWidth() - placeable.width) - ((int) (j >> 32));
                access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY((((long) parentWidth) << 32) | (((long) ((int) (j & 4294967295L))) & 4294967295L), placeable.apparentToRealOffset), 0.0f, null);
            }
        }

        public static void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, Function1 function1, int i3) {
            if ((i3 & 8) != 0) {
                int i4 = PlaceableKt.$r8$clinit;
                function1 = RootMeasurePolicy$measure$1.INSTANCE$1;
            }
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            if (placementScope.getParentLayoutDirection() == LayoutDirection.Ltr || placementScope.getParentWidth() == 0) {
                access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j, placeable.apparentToRealOffset), 0.0f, function1);
            } else {
                access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY((((long) ((placementScope.getParentWidth() - placeable.width) - ((int) (j >> 32)))) << 32) | (((long) ((int) (j & 4294967295L))) & 4294967295L), placeable.apparentToRealOffset), 0.0f, function1);
            }
        }

        public static void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, Function1 function1, int i3) {
            if ((i3 & 8) != 0) {
                int i4 = PlaceableKt.$r8$clinit;
                function1 = RootMeasurePolicy$measure$1.INSTANCE$1;
            }
            placementScope.getClass();
            access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
            placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY((((long) i2) & 4294967295L) | (((long) i) << 32), placeable.apparentToRealOffset), 0.0f, function1);
        }

        public float current(VerticalRuler verticalRuler) {
            return Float.NaN;
        }

        public abstract LayoutDirection getParentLayoutDirection();

        public abstract int getParentWidth();

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

    public Placeable() {
        long j = 0;
        this.measuredSize = (j & 4294967295L) | (j << 32);
    }

    public abstract int get(AlignmentLine alignmentLine);

    public int getMeasuredHeight() {
        return (int) (this.measuredSize & 4294967295L);
    }

    public int getMeasuredWidth() {
        return (int) (this.measuredSize >> 32);
    }

    public /* synthetic */ Object getParentData() {
        return null;
    }

    public final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn((int) (this.measuredSize >> 32), Constraints.m685getMinWidthimpl(this.measurementConstraints), Constraints.m683getMaxWidthimpl(this.measurementConstraints));
        int iCoerceIn = RangesKt.coerceIn((int) (this.measuredSize & 4294967295L), Constraints.m684getMinHeightimpl(this.measurementConstraints), Constraints.m682getMaxHeightimpl(this.measurementConstraints));
        this.height = iCoerceIn;
        int i = this.width;
        long j = this.measuredSize;
        this.apparentToRealOffset = (((long) ((i - ((int) (j >> 32))) / 2)) << 32) | (4294967295L & ((long) ((iCoerceIn - ((int) (j & 4294967295L))) / 2)));
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public abstract void mo521placeAtf8xVGno(long j, float f, Function1 function1);

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m534setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m720equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m535setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m677equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        onMeasuredSizeChanged();
    }
}
