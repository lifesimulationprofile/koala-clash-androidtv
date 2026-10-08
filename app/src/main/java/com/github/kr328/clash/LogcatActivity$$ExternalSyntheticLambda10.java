package com.github.kr328.clash;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.design.model.LogFile;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogcatActivity$$ExternalSyntheticLambda10 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ LogcatActivity$$ExternalSyntheticLambda10(int i, LogcatActivity logcatActivity, LogFile logFile, boolean z) {
        this.f$0 = logcatActivity;
        this.f$1 = logFile;
        this.f$2 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Object obj3 = this.f$1;
        boolean z = this.f$2;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                int i2 = LogcatActivity.$r8$clinit;
                ((LogcatActivity) obj4).LocalLogContent((LogFile) obj3, z, (GapComposer) obj, Stack.updateChangedFlags(9));
                break;
            default:
                ((Integer) obj2).getClass();
                ConnectionsScreenKt.ConnectionCard((ConnectionInfo) obj4, z, (Function0) obj3, (GapComposer) obj, Stack.updateChangedFlags(49));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ LogcatActivity$$ExternalSyntheticLambda10(ConnectionInfo connectionInfo, boolean z, Function0 function0, int i) {
        this.f$0 = connectionInfo;
        this.f$2 = z;
        this.f$1 = function0;
    }
}
