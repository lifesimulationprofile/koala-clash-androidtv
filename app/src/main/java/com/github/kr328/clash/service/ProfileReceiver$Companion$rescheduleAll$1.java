package com.github.kr328.clash.service;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileReceiver$Companion$rescheduleAll$1 extends ContinuationImpl {
    public Context L$0;
    public Mutex L$1;
    public Collection L$2;
    public Iterator L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AsyncTimeout.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileReceiver$Companion$rescheduleAll$1(AsyncTimeout.Companion companion, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.rescheduleAll(null, this);
    }
}
