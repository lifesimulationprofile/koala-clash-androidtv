package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutNearestRangeState implements State {
    public int lastFirstVisibleItem;
    public final ParcelableSnapshotMutableState value$delegate;

    public LazyLayoutNearestRangeState(int i) {
        int i2 = (i / 30) * 30;
        this.value$delegate = new ParcelableSnapshotMutableState(RangesKt.until(Math.max(i2 - 100, 0), i2 + 130), NeverEqualPolicy.INSTANCE$3);
        this.lastFirstVisibleItem = i;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return (IntRange) this.value$delegate.getValue();
    }
}
