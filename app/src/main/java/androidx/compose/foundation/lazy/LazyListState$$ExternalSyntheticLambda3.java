package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyListState$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int f$1;

    public /* synthetic */ LazyListState$$ExternalSyntheticLambda3(int i, int i2) {
        this.$r8$classId = i2;
        this.f$1 = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                LazyLayoutPrefetchState.NestedPrefetchScopeImpl nestedPrefetchScopeImpl = (LazyLayoutPrefetchState.NestedPrefetchScopeImpl) obj;
                Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot), currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null);
                nestedPrefetchScopeImpl.getClass();
                return Unit.INSTANCE;
            case 1:
                return Integer.valueOf((((Integer) obj).intValue() * this.f$1) / 2);
            default:
                return Integer.valueOf(((-this.f$1) * ((Integer) obj).intValue()) / 2);
        }
    }

    public /* synthetic */ LazyListState$$ExternalSyntheticLambda3(LazyListState lazyListState, int i) {
        this.$r8$classId = 0;
        this.f$1 = i;
    }
}
