package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultIntrinsicMeasurable implements Measurable {
    public final /* synthetic */ int $r8$classId;
    public final Measurable measurable;
    public final int minMax;
    public final int widthHeight;

    public /* synthetic */ DefaultIntrinsicMeasurable(Measurable measurable, int i, int i2, int i3) {
        this.$r8$classId = i3;
        this.measurable = measurable;
        this.minMax = i;
        this.widthHeight = i2;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final Object getParentData() {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.getParentData();
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0, reason: not valid java name */
    public final Placeable mo517measureBRTryo0(long j) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.widthHeight;
                int i2 = this.minMax;
                Measurable measurable = this.measurable;
                if (i == 1) {
                    return new FixedSizeIntrinsicsPlaceable(i2 == 2 ? measurable.maxIntrinsicWidth(Constraints.m682getMaxHeightimpl(j)) : measurable.minIntrinsicWidth(Constraints.m682getMaxHeightimpl(j)), Constraints.m678getHasBoundedHeightimpl(j) ? Constraints.m682getMaxHeightimpl(j) : 32767, 0);
                }
                return new FixedSizeIntrinsicsPlaceable(Constraints.m679getHasBoundedWidthimpl(j) ? Constraints.m683getMaxWidthimpl(j) : 32767, i2 == 2 ? measurable.maxIntrinsicHeight(Constraints.m683getMaxWidthimpl(j)) : measurable.minIntrinsicHeight(Constraints.m683getMaxWidthimpl(j)), 0);
            case 1:
                int i3 = this.widthHeight;
                int i4 = this.minMax;
                Measurable measurable2 = this.measurable;
                if (i3 == 1) {
                    return new FixedSizeIntrinsicsPlaceable(i4 == 2 ? measurable2.maxIntrinsicWidth(Constraints.m682getMaxHeightimpl(j)) : measurable2.minIntrinsicWidth(Constraints.m682getMaxHeightimpl(j)), Constraints.m678getHasBoundedHeightimpl(j) ? Constraints.m682getMaxHeightimpl(j) : 32767, 1);
                }
                return new FixedSizeIntrinsicsPlaceable(Constraints.m679getHasBoundedWidthimpl(j) ? Constraints.m683getMaxWidthimpl(j) : 32767, i4 == 2 ? measurable2.maxIntrinsicHeight(Constraints.m683getMaxWidthimpl(j)) : measurable2.minIntrinsicHeight(Constraints.m683getMaxWidthimpl(j)), 1);
            default:
                int i5 = this.widthHeight;
                int i6 = this.minMax;
                Measurable measurable3 = this.measurable;
                if (i5 == 1) {
                    return new FixedSizeIntrinsicsPlaceable(i6 == 2 ? measurable3.maxIntrinsicWidth(Constraints.m682getMaxHeightimpl(j)) : measurable3.minIntrinsicWidth(Constraints.m682getMaxHeightimpl(j)), Constraints.m678getHasBoundedHeightimpl(j) ? Constraints.m682getMaxHeightimpl(j) : 32767, 2);
                }
                return new FixedSizeIntrinsicsPlaceable(Constraints.m679getHasBoundedWidthimpl(j) ? Constraints.m683getMaxWidthimpl(j) : 32767, i6 == 2 ? measurable3.maxIntrinsicHeight(Constraints.m683getMaxWidthimpl(j)) : measurable3.minIntrinsicHeight(Constraints.m683getMaxWidthimpl(j)), 2);
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.minIntrinsicWidth(i);
    }
}
