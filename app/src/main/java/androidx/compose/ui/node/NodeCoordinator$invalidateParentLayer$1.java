package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NodeCoordinator$invalidateParentLayer$1 extends Lambda implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NodeCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NodeCoordinator$invalidateParentLayer$1(NodeCoordinator nodeCoordinator, int i) {
        super(0);
        this.$r8$classId = i;
        this.this$0 = nodeCoordinator;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                NodeCoordinator nodeCoordinator = this.this$0.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
                break;
            default:
                NodeCoordinator nodeCoordinator2 = this.this$0;
                nodeCoordinator2.drawContainedDrawModifiers(nodeCoordinator2.drawBlockCanvas, nodeCoordinator2.drawBlockParentLayer);
                break;
        }
        return Unit.INSTANCE;
    }
}
