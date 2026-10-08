package com.github.kr328.clash.service;

import android.net.Network;
import android.os.Build;
import com.github.kr328.clash.service.clash.module.ConfigurationModule;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TunService$runtime$1$quit$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public final /* synthetic */ TunService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TunService$runtime$1$quit$1$2(TunService tunService, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = tunService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                TunService$runtime$1$quit$1$2 tunService$runtime$1$quit$1$2 = new TunService$runtime$1$quit$1$2(this.this$0, continuation, 0);
                tunService$runtime$1$quit$1$2.L$0 = obj;
                return tunService$runtime$1$quit$1$2;
            default:
                TunService$runtime$1$quit$1$2 tunService$runtime$1$quit$1$3 = new TunService$runtime$1$quit$1$2(this.this$0, continuation, 1);
                tunService$runtime$1$quit$1$3.L$0 = obj;
                return tunService$runtime$1$quit$1$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((TunService$runtime$1$quit$1$2) create((ConfigurationModule.LoadException) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return Boolean.TRUE;
            default:
                ((TunService$runtime$1$quit$1$2) create((Network) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return Boolean.FALSE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.this$0.reason = ((ConfigurationModule.LoadException) this.L$0).message;
                return Boolean.TRUE;
            default:
                ResultKt.throwOnFailure(obj);
                Network network = (Network) this.L$0;
                if (Build.VERSION.SDK_INT < 29) {
                    this.this$0.setUnderlyingNetworks(network != null ? new Network[]{network} : null);
                }
                return Boolean.FALSE;
        }
    }
}
