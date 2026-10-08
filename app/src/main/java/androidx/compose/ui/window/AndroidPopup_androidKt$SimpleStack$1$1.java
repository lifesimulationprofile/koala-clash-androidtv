package androidx.compose.ui.window;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterNode$measure$1;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RootMeasurePolicy$measure$3;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$SimpleStack$1$1 implements MeasurePolicy {
    public final /* synthetic */ int $r8$classId;
    public static final AndroidPopup_androidKt$SimpleStack$1$1 INSTANCE$1 = new AndroidPopup_androidKt$SimpleStack$1$1(1);
    public static final AndroidPopup_androidKt$SimpleStack$1$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1$1(0);

    public /* synthetic */ AndroidPopup_androidKt$SimpleStack$1$1(int i) {
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
                int size = list.size();
                EmptyMap emptyMap = EmptyMap.INSTANCE;
                if (size == 0) {
                    return measureScope.layout(0, 0, emptyMap, AndroidPopup_androidKt$Popup$5$1$1.INSTANCE$4);
                }
                if (size == 1) {
                    Placeable placeableMo517measureBRTryo0 = ((Measurable) list.get(0)).mo517measureBRTryo0(j);
                    return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, emptyMap, new PainterNode$measure$1(placeableMo517measureBRTryo0, 6));
                }
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                int iMax = 0;
                int iMax2 = 0;
                for (int i = 0; i < size2; i++) {
                    Placeable placeableMo517measureBRTryo1 = ((Measurable) list.get(i)).mo517measureBRTryo0(j);
                    iMax = Math.max(iMax, placeableMo517measureBRTryo1.width);
                    iMax2 = Math.max(iMax2, placeableMo517measureBRTryo1.height);
                    arrayList.add(placeableMo517measureBRTryo1);
                }
                return measureScope.layout(iMax, iMax2, emptyMap, new RootMeasurePolicy$measure$3(3, arrayList));
            default:
                ArrayList arrayList2 = new ArrayList(list.size());
                int size3 = list.size();
                int iM685getMinWidthimpl = 0;
                int iM684getMinHeightimpl = 0;
                for (int i2 = 0; i2 < size3; i2++) {
                    Placeable placeableMo517measureBRTryo2 = ((Measurable) list.get(i2)).mo517measureBRTryo0(j);
                    iM685getMinWidthimpl = Math.max(iM685getMinWidthimpl, placeableMo517measureBRTryo2.width);
                    iM684getMinHeightimpl = Math.max(iM684getMinHeightimpl, placeableMo517measureBRTryo2.height);
                    arrayList2.add(placeableMo517measureBRTryo2);
                }
                if (list.isEmpty()) {
                    iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
                    iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j);
                }
                return measureScope.layout(iM685getMinWidthimpl, iM684getMinHeightimpl, EmptyMap.INSTANCE, new RootMeasurePolicy$measure$3(2, arrayList2));
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
