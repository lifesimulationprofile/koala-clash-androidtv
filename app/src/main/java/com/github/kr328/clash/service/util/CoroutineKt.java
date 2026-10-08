package com.github.kr328.clash.service.util;

import androidx.compose.material3.ThumbNode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineKt {
    public static final void cancelAndJoinBlocking(CoroutineScope coroutineScope) {
        JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new ThumbNode.AnonymousClass1(coroutineScope, (Continuation) null, 25));
    }
}
