package androidx.compose.foundation.lazy;

import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.Stack;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 {
    public final /* synthetic */ boolean $isVertical;
    public final /* synthetic */ LazyListState $state;
    public final DerivedSnapshotState totalItemsCount$delegate;

    public LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(LazyListState lazyListState, boolean z) {
        this.$state = lazyListState;
        this.$isVertical = z;
        this.totalItemsCount$delegate = Stack.derivedStateOf(new BasicTextKt$$ExternalSyntheticLambda0(5, lazyListState));
    }
}
