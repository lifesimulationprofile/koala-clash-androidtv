package com.github.kr328.clash.service.clash.module;

import android.net.ConnectivityManager;
import android.net.VpnService;
import com.github.kr328.clash.UpdateChecker$check$2;
import java.security.SecureRandom;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TunModule extends Module {
    public static final SecureRandom random = new SecureRandom();
    public final BufferedChannel close;
    public final ConnectivityManager connectivity;
    public final VpnService vpn;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.TunModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TunModule.this.run(this);
        }
    }

    public TunModule(VpnService vpnService) {
        super(vpnService);
        this.vpn = vpnService;
        this.connectivity = (ConnectivityManager) vpnService.getSystemService(ConnectivityManager.class);
        this.close = ChannelKt.Channel$default(-1, 0, 6);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.clash.module.Module
    public final Object run(Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation2 = null;
        int i3 = 2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                BufferedChannel bufferedChannel = this.close;
                anonymousClass1.label = 1;
                if (bufferedChannel.receive(anonymousClass1) == coroutineSingletons) {
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    Unit unit = (Unit) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Throwable th = (Throwable) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                throw th;
            }
            ResultKt.throwOnFailure(obj);
            Unit unit2 = Unit.INSTANCE;
            NonCancellable nonCancellable = NonCancellable.INSTANCE;
            UpdateChecker$check$2 updateChecker$check$2 = new UpdateChecker$check$2(i3, continuation2, 11);
            anonymousClass1.L$0 = unit2;
            anonymousClass1.label = 2;
            return JobKt.withContext(nonCancellable, updateChecker$check$2, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit2;
        } catch (Throwable th2) {
            NonCancellable nonCancellable2 = NonCancellable.INSTANCE;
            UpdateChecker$check$2 updateChecker$check$3 = new UpdateChecker$check$2(i3, continuation2, 11);
            anonymousClass1.L$0 = th2;
            anonymousClass1.label = 3;
            if (JobKt.withContext(nonCancellable2, updateChecker$check$3, anonymousClass1) != coroutineSingletons) {
                throw th2;
            }
        }
    }
}
