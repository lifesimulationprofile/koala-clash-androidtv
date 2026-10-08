package androidx.compose.foundation.layout;

import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SpacerMeasurePolicy implements MeasurePolicy {
    public final /* synthetic */ int $r8$classId;
    public static final SpacerMeasurePolicy INSTANCE$1 = new SpacerMeasurePolicy(1);
    public static final SpacerMeasurePolicy INSTANCE = new SpacerMeasurePolicy(0);

    public /* synthetic */ SpacerMeasurePolicy(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
        switch (this.$r8$classId) {
            case 0:
                return measureScope.layout(Constraints.m681getHasFixedWidthimpl(j) ? Constraints.m683getMaxWidthimpl(j) : 0, Constraints.m680getHasFixedHeightimpl(j) ? Constraints.m682getMaxHeightimpl(j) : 0, EmptyMap.INSTANCE, new BasicTextKt$$ExternalSyntheticLambda3(10));
            default:
                return measureScope.layout(Constraints.m685getMinWidthimpl(j), Constraints.m684getMinHeightimpl(j), EmptyMap.INSTANCE, new BasicTextKt$$ExternalSyntheticLambda3(6));
        }
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }
}
