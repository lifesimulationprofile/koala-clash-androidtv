package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnapshotStateList$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Collection f$0;

    public /* synthetic */ SnapshotStateList$$ExternalSyntheticLambda0(int i, Collection collection) {
        this.$r8$classId = i;
        this.f$0 = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zRetainAll;
        switch (this.$r8$classId) {
            case 0:
                zRetainAll = ((List) obj).retainAll(this.f$0);
                break;
            case 1:
                zRetainAll = this.f$0.contains(obj);
                break;
            default:
                zRetainAll = this.f$0.contains(obj);
                break;
        }
        return Boolean.valueOf(zRetainAll);
    }
}
