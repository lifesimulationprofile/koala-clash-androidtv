package androidx.compose.foundation;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GestureNodeKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ GestureNodeKt$$ExternalSyntheticLambda0(Function1 function1, int i) {
        this.$r8$classId = i;
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Function1 function1 = this.f$0;
                TraversableNode traversableNode = (TraversableNode) obj;
                if (!(traversableNode instanceof GestureNode)) {
                    throw new IllegalStateException("Node is not a GestureNode instance");
                }
                Boolean bool = (Boolean) function1.invoke(((GestureNode) traversableNode).gestureConnection);
                bool.getClass();
                return bool;
            case 1:
                Function1 function2 = this.f$0;
                Long l = (Long) obj;
                l.longValue();
                return function2.invoke(l);
            case 2:
                Snapshot snapshot = (Snapshot) this.f$0.invoke((SnapshotIdSet) obj);
                synchronized (SnapshotKt.lock) {
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getSnapshotId());
                    Unit unit = Unit.INSTANCE;
                }
                return snapshot;
            default:
                this.f$0.invoke(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
        }
    }
}
