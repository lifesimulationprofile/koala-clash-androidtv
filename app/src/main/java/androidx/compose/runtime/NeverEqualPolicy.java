package androidx.compose.runtime;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NeverEqualPolicy implements CoroutineContext.Key, SnapshotMutationPolicy {
    public final /* synthetic */ int $r8$classId;
    public static final ZslControlImpl$$ExternalSyntheticLambda0 Empty = new ZslControlImpl$$ExternalSyntheticLambda0(8);
    public static final /* synthetic */ NeverEqualPolicy $$INSTANCE = new NeverEqualPolicy(2);
    public static final NeverEqualPolicy INSTANCE = new NeverEqualPolicy(0);
    public static final NeverEqualPolicy INSTANCE$1 = new NeverEqualPolicy(3);
    public static final NeverEqualPolicy INSTANCE$2 = new NeverEqualPolicy(4);
    public static final NeverEqualPolicy INSTANCE$3 = new NeverEqualPolicy(5);

    public /* synthetic */ NeverEqualPolicy(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return false;
            case 3:
                return obj == obj2;
            default:
                return Intrinsics.areEqual(obj, obj2);
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "NeverEqualPolicy";
            case 3:
                return "ReferentialEqualityPolicy";
            case 5:
                return "StructuralEqualityPolicy";
            case 7:
                return "Empty";
            default:
                return super.toString();
        }
    }
}
