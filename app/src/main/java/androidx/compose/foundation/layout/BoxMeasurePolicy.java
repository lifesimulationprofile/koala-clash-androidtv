package androidx.compose.foundation.layout;

import androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BoxMeasurePolicy implements MeasurePolicy {
    public final BiasAlignment alignment;
    public final boolean propagateMinConstraints;

    public BoxMeasurePolicy(BiasAlignment biasAlignment, boolean z) {
        this.alignment = biasAlignment;
        this.propagateMinConstraints = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) obj;
        return this.alignment.equals(boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public final int hashCode() {
        return (this.alignment.hashCode() * 31) + (this.propagateMinConstraints ? 1231 : 1237);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return Modifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo24measure3p2s80s(final MeasureScope measureScope, List list, long j) {
        boolean zIsEmpty = list.isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (zIsEmpty) {
            return measureScope.layout(Constraints.m685getMinWidthimpl(j), Constraints.m684getMinHeightimpl(j), emptyMap, new BasicTextKt$$ExternalSyntheticLambda3(7));
        }
        long j2 = this.propagateMinConstraints ? j : j & (-8589934589L);
        if (list.size() == 1) {
            final Measurable measurable = (Measurable) list.get(0);
            measurable.getParentData();
            final Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(j2);
            final int iMax = Math.max(Constraints.m685getMinWidthimpl(j), placeableMo517measureBRTryo0.width);
            final int iMax2 = Math.max(Constraints.m684getMinHeightimpl(j), placeableMo517measureBRTryo0.height);
            return measureScope.layout(iMax, iMax2, emptyMap, new Function1() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    BoxKt.access$placeInBox((Placeable.PlacementScope) obj, placeableMo517measureBRTryo0, measurable, measureScope.getLayoutDirection(), iMax, iMax2, this.alignment);
                    return Unit.INSTANCE;
                }
            });
        }
        Placeable[] placeableArr = new Placeable[list.size()];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = Constraints.m685getMinWidthimpl(j);
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = Constraints.m684getMinHeightimpl(j);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable2 = (Measurable) list.get(i);
            measurable2.getParentData();
            Placeable placeableMo517measureBRTryo1 = measurable2.mo517measureBRTryo0(j2);
            placeableArr[i] = placeableMo517measureBRTryo1;
            ref$IntRef.element = Math.max(ref$IntRef.element, placeableMo517measureBRTryo1.width);
            ref$IntRef2.element = Math.max(ref$IntRef2.element, placeableMo517measureBRTryo1.height);
        }
        return measureScope.layout(ref$IntRef.element, ref$IntRef2.element, emptyMap, new BorderLogic$$ExternalSyntheticLambda1(placeableArr, list, measureScope, ref$IntRef, ref$IntRef2, this, 1));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public final String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ')';
    }
}
