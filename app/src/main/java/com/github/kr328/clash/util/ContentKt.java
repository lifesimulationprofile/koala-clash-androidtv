package com.github.kr328.clash.util;

import android.content.ContentResolver;
import android.net.Uri;
import com.github.kr328.clash.LogcatActivity$writeLogTo$2$1;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContentKt {
    public static final Object copyContentTo(ContentResolver contentResolver, Uri uri, Uri uri2, SuspendLambda suspendLambda) throws Throwable {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = JobKt.withContext(DefaultIoScheduler.INSTANCE, new LogcatActivity$writeLogTo$2$1(contentResolver, uri, uri2, null, 9), suspendLambda);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }
}
