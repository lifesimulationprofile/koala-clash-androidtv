package com.github.kr328.clash.service.clash.module;

import android.os.Build;
import java.net.InetSocketAddress;
import kotlin.Result;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TunModule$attach$2 extends FunctionReferenceImpl implements Function3 {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object failure;
        int iIntValue = ((Number) obj).intValue();
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj2;
        InetSocketAddress inetSocketAddress2 = (InetSocketAddress) obj3;
        TunModule tunModule = (TunModule) this.receiver;
        tunModule.getClass();
        int iIntValue2 = -1;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                failure = Integer.valueOf(tunModule.connectivity.getConnectionOwnerUid(iIntValue, inetSocketAddress, inetSocketAddress2));
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            if (Result.m830exceptionOrNullimpl(failure) != null) {
                failure = -1;
            }
            iIntValue2 = ((Number) failure).intValue();
        }
        return Integer.valueOf(iIntValue2);
    }
}
