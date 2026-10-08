package com.github.kr328.clash.service.clash.module;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppListCacheModule$run$1 extends ContinuationImpl {
    public SuspendModule L$0;
    public ReceiveChannel L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SuspendModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppListCacheModule$run$1(SuspendModule suspendModule, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = suspendModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        this.this$0.run(this);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }
}
