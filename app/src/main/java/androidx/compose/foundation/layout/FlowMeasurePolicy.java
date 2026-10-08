package androidx.compose.foundation.layout;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FlowMeasurePolicy implements RowColumnMeasurePolicy {
    public final CrossAxisAlignment$VerticalCrossAxisAlignment crossAxisAlignment;
    public final float crossAxisArrangementSpacing;
    public final Arrangement.Horizontal horizontalArrangement;
    public final float mainAxisSpacing;
    public final FlowLayoutOverflowState overflow;
    public final Arrangement.Vertical verticalArrangement;

    public FlowMeasurePolicy(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment$VerticalCrossAxisAlignment crossAxisAlignment$VerticalCrossAxisAlignment, float f2, FlowLayoutOverflowState flowLayoutOverflowState) {
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f;
        this.crossAxisAlignment = crossAxisAlignment$VerticalCrossAxisAlignment;
        this.crossAxisArrangementSpacing = f2;
        this.overflow = flowLayoutOverflowState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r18v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.compose.foundation.layout.FlowLayoutBuildingBlocks] */
    public static int intrinsicCrossAxisSize(List list, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState) {
        long jM21constructorimpl;
        int i4 = 0;
        if (list.isEmpty()) {
            jM21constructorimpl = IntIntPair.m21constructorimpl(0, 0);
        } else {
            int i5 = Integer.MAX_VALUE;
            ?? flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(flowLayoutOverflowState, ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), i2, i3);
            Measurable measurable = (Measurable) CollectionsKt.getOrNull(0, list);
            int iMinIntrinsicHeight = measurable != null ? measurable.minIntrinsicHeight(i) : 0;
            int iMinIntrinsicWidth = measurable != null ? measurable.minIntrinsicWidth(iMinIntrinsicHeight) : 0;
            boolean z = true;
            if (list.size() <= 1) {
                z = false;
            }
            int i6 = 0;
            if (flowLayoutBuildingBlocks.m114getWrapInfoOpUlnko(z, 0, IntIntPair.m21constructorimpl(i, Integer.MAX_VALUE), measurable == null ? null : new IntIntPair(IntIntPair.m21constructorimpl(iMinIntrinsicWidth, iMinIntrinsicHeight)), 0, 0, 0, false, false).isLastItemInContainer) {
                IntIntPair intIntPairM115ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m115ellipsisSizeF35zmw$foundation_layout(0, 0, measurable != null);
                jM21constructorimpl = IntIntPair.m21constructorimpl(intIntPairM115ellipsisSizeF35zmw$foundation_layout != null ? (int) (intIntPairM115ellipsisSizeF35zmw$foundation_layout.packedValue & 4294967295L) : 0, 0);
            } else {
                int size = list.size();
                int i7 = i;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                while (i8 < size) {
                    int i13 = i7 - iMinIntrinsicWidth;
                    int i14 = i8 + 1;
                    int iMax = Math.max(i12, iMinIntrinsicHeight);
                    Measurable measurable2 = (Measurable) CollectionsKt.getOrNull(i14, list);
                    int iMinIntrinsicHeight2 = measurable2 != null ? measurable2.minIntrinsicHeight(i) : i4;
                    int iMinIntrinsicWidth2 = measurable2 != null ? measurable2.minIntrinsicWidth(iMinIntrinsicHeight2) + i2 : i4;
                    int i15 = i14 - i10;
                    ?? r18 = i8 + 2 < list.size() ? z : i4;
                    int i16 = i11;
                    int i17 = iMinIntrinsicHeight2;
                    int i18 = iMinIntrinsicWidth2;
                    FlowLayoutBuildingBlocks.WrapInfo wrapInfoM114getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m114getWrapInfoOpUlnko(r18, i15, IntIntPair.m21constructorimpl(i13, i5), measurable2 == null ? null : new IntIntPair(IntIntPair.m21constructorimpl(iMinIntrinsicWidth2, iMinIntrinsicHeight2)), i16, i6, iMax, false, false);
                    if (wrapInfoM114getWrapInfoOpUlnko.isLastItemInLine) {
                        int i19 = iMax + i3 + i6;
                        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM114getWrapInfoOpUlnko, measurable2 != null, i16, i19, i13, i15);
                        int i20 = i18 - i2;
                        i11 = i16 + 1;
                        if (wrapInfoM114getWrapInfoOpUlnko.isLastItemInContainer) {
                            if (wrapEllipsisInfo != null) {
                                long j = wrapEllipsisInfo.ellipsisSize;
                                if (!wrapEllipsisInfo.placeEllipsisOnLastContentLine) {
                                    i19 += ((int) (j & 4294967295L)) + i3;
                                }
                            }
                            i6 = i19;
                            i9 = i14;
                            break;
                        }
                        i10 = i14;
                        i6 = i19;
                        iMinIntrinsicWidth = i20;
                        i12 = 0;
                        i7 = i;
                    } else {
                        iMinIntrinsicWidth = i18;
                        i7 = i13;
                        i11 = i16;
                        i12 = iMax;
                    }
                    i8 = i14;
                    i9 = i8;
                    iMinIntrinsicHeight = i17;
                    i5 = Integer.MAX_VALUE;
                    i4 = 0;
                    z = true;
                }
                jM21constructorimpl = IntIntPair.m21constructorimpl(i6 - i3, i9);
            }
        }
        return (int) (jM21constructorimpl >> 32);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    public final long mo113createConstraintsxF2OJ5Q(int i, int i2, int i3, boolean z) {
        RowMeasurePolicy rowMeasurePolicy = RowKt.DefaultRowMeasurePolicy;
        return !z ? ConstraintsKt.Constraints(i, i2, 0, i3) : Constraints.Companion.m688fitPrioritizingWidthZbe2FdA(i, i2, 0, i3);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final int crossAxisSize(Placeable placeable) {
        return placeable.getMeasuredHeight();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) obj;
        return this.horizontalArrangement.equals(flowMeasurePolicy.horizontalArrangement) && this.verticalArrangement.equals(flowMeasurePolicy.verticalArrangement) && Dp.m704equalsimpl0(this.mainAxisSpacing, flowMeasurePolicy.mainAxisSpacing) && this.crossAxisAlignment.equals(flowMeasurePolicy.crossAxisAlignment) && Dp.m704equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && Intrinsics.areEqual(this.overflow, flowMeasurePolicy.overflow);
    }

    public final int hashCode() {
        return this.overflow.hashCode() + ((((((Float.floatToIntBits(this.crossAxisArrangementSpacing) + ImageAnalysis$$ExternalSyntheticLambda1.m(-1.0f, ImageAnalysis$$ExternalSyntheticLambda1.m(this.mainAxisSpacing, (this.verticalArrangement.hashCode() + ((this.horizontalArrangement.hashCode() + 38161) * 31)) * 31, 31), 31)) * 31) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final int mainAxisSize(Placeable placeable) {
        return placeable.getMeasuredWidth();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final MeasureResult placeHelper(final Placeable[] placeableArr, MeasureScope measureScope, final int[] iArr, int i, final int i2, final int[] iArr2, final int i3, final int i4, final int i5) {
        final LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return measureScope.layout(i, i2, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.foundation.layout.FlowLineMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                OffsetKt offsetKt;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int[] iArr3 = iArr2;
                int i6 = iArr3 != null ? iArr3[i3] : 0;
                int i7 = i4;
                for (int i8 = i7; i8 < i5; i8++) {
                    Placeable placeable = placeableArr[i8];
                    Object parentData = placeable.getParentData();
                    RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
                    if (rowColumnParentData == null || (offsetKt = rowColumnParentData.crossAxisAlignment) == null) {
                        offsetKt = this.crossAxisAlignment;
                    }
                    Placeable.PlacementScope.place$default(placementScope, placeable, iArr[i8 - i7], offsetKt.align$foundation_layout(i2, placeable.getMeasuredHeight(), layoutDirection) + i6);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final void populateMainAxisPositions(int i, MeasureScope measureScope, int[] iArr, int[] iArr2) {
        this.horizontalArrangement.arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
    }

    public final String toString() {
        return "FlowMeasurePolicy(isHorizontal=true, horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + ((Object) Dp.m705toStringimpl(this.mainAxisSpacing)) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + ((Object) Dp.m705toStringimpl(this.crossAxisArrangementSpacing)) + ", maxItemsInMainAxis=2147483647, maxLines=2147483647, overflow=" + this.overflow + ')';
    }
}
