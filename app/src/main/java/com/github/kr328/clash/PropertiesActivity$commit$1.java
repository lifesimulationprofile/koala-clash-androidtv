package com.github.kr328.clash;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PropertiesActivity$commit$1 extends ContinuationImpl {
    public PropertiesActivity L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PropertiesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertiesActivity$commit$1(PropertiesActivity propertiesActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = propertiesActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PropertiesActivity.access$commit(this.this$0, null, null, null, this);
    }
}
