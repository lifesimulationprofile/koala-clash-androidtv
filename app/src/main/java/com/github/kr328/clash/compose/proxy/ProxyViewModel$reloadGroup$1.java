package com.github.kr328.clash.compose.proxy;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel$reloadGroup$1 extends ContinuationImpl {
    public ProxyViewModel L$0;
    public String L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ProxyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxyViewModel$reloadGroup$1(ProxyViewModel proxyViewModel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = proxyViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ProxyViewModel.access$reloadGroup(this.this$0, null, this);
    }
}
