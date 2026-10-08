package com.github.kr328.clash.service;

import android.app.Service;
import com.github.kr328.clash.service.util.CoroutineKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseService extends Service implements CoroutineScope {
    public final /* synthetic */ ContextScope $$delegate_0 = JobKt.CoroutineScope(Dispatchers.Default);

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CoroutineKt.cancelAndJoinBlocking(this);
    }
}
