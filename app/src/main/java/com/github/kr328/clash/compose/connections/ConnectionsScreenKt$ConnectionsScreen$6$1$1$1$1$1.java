package com.github.kr328.clash.compose.connections;

import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.service.remote.IClashManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ConnectionInfo $conn;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1(ConnectionInfo connectionInfo, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$conn = connectionInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1 connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1 = new ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1(this.$conn, continuation, 0);
                connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1.L$0 = obj;
                return connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1;
            default:
                ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1 connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$2 = new ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1(this.$conn, continuation, 1);
                connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$2.L$0 = obj;
                return connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        IClashManager iClashManager = (IClashManager) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1) create(iClashManager, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ((IClashManager) this.L$0).closeConnection(this.$conn.id);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                ((IClashManager) this.L$0).closeConnection(this.$conn.id);
                break;
        }
        return Unit.INSTANCE;
    }
}
