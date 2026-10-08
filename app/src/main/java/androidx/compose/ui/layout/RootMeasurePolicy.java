package androidx.compose.ui.layout;

import androidx.compose.ui.draw.PainterNode$measure$1;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy("Undefined intrinsics block and it is required");

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
        int size = list.size();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (size == 0) {
            return measureScope.layout(Constraints.m685getMinWidthimpl(j), Constraints.m684getMinHeightimpl(j), emptyMap, RootMeasurePolicy$measure$1.INSTANCE);
        }
        if (size == 1) {
            Placeable placeableMo517measureBRTryo0 = ((Measurable) list.get(0)).mo517measureBRTryo0(j);
            return measureScope.layout(ConstraintsKt.m692constrainWidthK40F9xA(placeableMo517measureBRTryo0.width, j), ConstraintsKt.m691constrainHeightK40F9xA(placeableMo517measureBRTryo0.height, j), emptyMap, new PainterNode$measure$1(placeableMo517measureBRTryo0, 4));
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size2; i++) {
            Placeable placeableMo517measureBRTryo1 = ((Measurable) list.get(i)).mo517measureBRTryo0(j);
            iMax = Math.max(placeableMo517measureBRTryo1.width, iMax);
            iMax2 = Math.max(placeableMo517measureBRTryo1.height, iMax2);
            arrayList.add(placeableMo517measureBRTryo1);
        }
        return measureScope.layout(ConstraintsKt.m692constrainWidthK40F9xA(iMax, j), ConstraintsKt.m691constrainHeightK40F9xA(iMax2, j), emptyMap, new RootMeasurePolicy$measure$3(0, arrayList));
    }
}
