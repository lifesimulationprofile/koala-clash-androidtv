package com.github.kr328.clash.common;

import android.app.Application;
import com.github.kr328.clash.MainApplication;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Global implements CoroutineScope {
    public static final Global INSTANCE = new Global();
    public static MainApplication application_;
    public final /* synthetic */ ContextScope $$delegate_0;

    public Global() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.$$delegate_0 = JobKt.CoroutineScope(DefaultIoScheduler.INSTANCE);
    }

    public static Application getApplication$1() {
        MainApplication mainApplication = application_;
        if (mainApplication != null) {
            return mainApplication;
        }
        Intrinsics.throwUninitializedPropertyAccessException("application_");
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }
}
