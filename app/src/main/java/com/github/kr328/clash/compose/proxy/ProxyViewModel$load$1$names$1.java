package com.github.kr328.clash.compose.proxy;

import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.remote.IClashManager;
import com.google.android.gms.tasks.zzr;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel$load$1$names$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public final /* synthetic */ ProxyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProxyViewModel$load$1$names$1(ProxyViewModel proxyViewModel, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = proxyViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ProxyViewModel$load$1$names$1 proxyViewModel$load$1$names$1 = new ProxyViewModel$load$1$names$1(this.this$0, continuation, 0);
                proxyViewModel$load$1$names$1.L$0 = obj;
                return proxyViewModel$load$1$names$1;
            default:
                ProxyViewModel$load$1$names$1 proxyViewModel$load$1$names$2 = new ProxyViewModel$load$1$names$1(this.this$0, continuation, 1);
                proxyViewModel$load$1$names$2.L$0 = obj;
                return proxyViewModel$load$1$names$2;
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
        return ((ProxyViewModel$load$1$names$1) create(iClashManager, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IClashManager iClashManager = (IClashManager) this.L$0;
                zzr zzrVar = this.this$0.uiStore.proxyExcludeNotSelectable$delegate;
                KProperty kProperty = UiStore.$$delegatedProperties[4];
                return iClashManager.queryProxyGroupNames(((Boolean) zzrVar.getValue()).booleanValue());
            default:
                ResultKt.throwOnFailure(obj);
                IClashManager iClashManager2 = (IClashManager) this.L$0;
                zzr zzrVar2 = this.this$0.uiStore.proxyExcludeNotSelectable$delegate;
                KProperty kProperty2 = UiStore.$$delegatedProperties[4];
                return iClashManager2.queryProxyGroupNames(((Boolean) zzrVar2.getValue()).booleanValue());
        }
    }
}
