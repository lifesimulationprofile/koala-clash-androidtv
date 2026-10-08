package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LazyLayoutSemanticsModifierNode f$0;

    public /* synthetic */ LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i) {
        this.$r8$classId = i;
        this.f$0 = lazyLayoutSemanticsModifierNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                LazyListState lazyListState = this.f$0.state.$state;
                return Float.valueOf((((ParcelableSnapshotMutableIntState) lazyListState.scrollPosition.call).getIntValue() * 500) + ((ParcelableSnapshotMutableIntState) lazyListState.scrollPosition.finder).getIntValue());
            case 1:
                LazyListState lazyListState2 = this.f$0.state.$state;
                int intValue = ((ParcelableSnapshotMutableIntState) lazyListState2.scrollPosition.call).getIntValue();
                int intValue2 = ((ParcelableSnapshotMutableIntState) lazyListState2.scrollPosition.finder).getIntValue();
                return Float.valueOf(lazyListState2.getCanScrollForward() ? (intValue * 500) + intValue2 + 100 : (intValue * 500) + intValue2);
            default:
                LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode = this.f$0;
                LazyListState lazyListState3 = lazyLayoutSemanticsModifierNode.state.$state;
                int iM148getViewportSizeYbymL2g = (int) (lazyListState3.getLayoutInfo().orientation == Orientation.Vertical ? lazyListState3.getLayoutInfo().m148getViewportSizeYbymL2g() & 4294967295L : lazyListState3.getLayoutInfo().m148getViewportSizeYbymL2g() >> 32);
                LazyListState lazyListState4 = lazyLayoutSemanticsModifierNode.state.$state;
                return Float.valueOf(iM148getViewportSizeYbymL2g - ((-lazyListState4.getLayoutInfo().viewportStartOffset) + lazyListState4.getLayoutInfo().afterContentPadding));
        }
    }
}
