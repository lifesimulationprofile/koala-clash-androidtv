package com.github.kr328.clash;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessControlActivity$reloadApps$1 extends ContinuationImpl {
    public AccessControlActivity L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AccessControlActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessControlActivity$reloadApps$1(AccessControlActivity accessControlActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = accessControlActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AccessControlActivity.access$reloadApps(this.this$0, this);
    }
}
