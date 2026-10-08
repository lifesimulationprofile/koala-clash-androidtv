package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ReadonlySnapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MonotonicFrameClockKt$withFrameMillis$2 implements Function1 {
    public final /* synthetic */ Function1 $onFrame;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ MonotonicFrameClockKt$withFrameMillis$2(Function1 function1, int i) {
        this.$r8$classId = i;
        this.$onFrame = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        long j;
        switch (this.$r8$classId) {
            case 0:
                return this.$onFrame.invoke(Long.valueOf(((Number) obj).longValue() / 1000000));
            default:
                SnapshotIdSet snapshotIdSet = (SnapshotIdSet) obj;
                synchronized (SnapshotKt.lock) {
                    j = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = ((long) 1) + j;
                }
                return new ReadonlySnapshot(j, snapshotIdSet, this.$onFrame);
        }
    }
}
