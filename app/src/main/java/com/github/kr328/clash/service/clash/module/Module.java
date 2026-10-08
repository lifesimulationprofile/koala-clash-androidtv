package com.github.kr328.clash.service.clash.module;

import android.app.Service;
import android.content.IntentFilter;
import com.github.kr328.clash.TileService$receiver$1;
import com.github.kr328.clash.common.compat.ContextKt;
import com.github.kr328.clash.common.constants.Permissions;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Module {
    public final BufferedChannel events = ChannelKt.Channel$default(Integer.MAX_VALUE, 0, 6);
    public final ArrayList receivers = new ArrayList();
    public final Service service;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.Module$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public String L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Module.this.execute(this);
        }
    }

    public Module(Service service) {
        this.service = service;
    }

    public static BufferedChannel receiveBroadcast$default(Module module, Function1 function1, int i) {
        int i2 = (i & 2) != 0 ? Integer.MAX_VALUE : -1;
        Service service = module.service;
        IntentFilter intentFilter = new IntentFilter();
        function1.invoke(intentFilter);
        BufferedChannel bufferedChannelChannel$default = ChannelKt.Channel$default(i2, 0, 6);
        TileService$receiver$1 tileService$receiver$1 = new TileService$receiver$1(3, bufferedChannelChannel$default);
        ContextKt.registerReceiverCompat(service, tileService$receiver$1, intentFilter, Permissions.RECEIVE_SELF_BROADCASTS);
        module.receivers.add(tileService$receiver$1);
        return bufferedChannelChannel$default;
    }

    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        if (kotlinx.coroutines.JobKt.withContext(r11, r3, r1) == r7) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = ": initialize"
            boolean r1 = r11 instanceof com.github.kr328.clash.service.clash.module.Module.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r11
            com.github.kr328.clash.service.clash.module.Module$execute$1 r1 = (com.github.kr328.clash.service.clash.module.Module.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.github.kr328.clash.service.clash.module.Module$execute$1 r1 = new com.github.kr328.clash.service.clash.module.Module$execute$1
            r1.<init>(r11)
        L1a:
            java.lang.Object r11 = r1.result
            int r2 = r1.label
            r3 = 3
            r4 = 1
            r5 = 2
            r6 = 0
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r2 == 0) goto L50
            if (r2 == r4) goto L41
            if (r2 == r5) goto L3d
            if (r2 == r3) goto L34
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L34:
            java.lang.Object r0 = r1.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto La2
        L3d:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L87
        L41:
            java.lang.String r0 = r1.L$1
            java.lang.Object r2 = r1.L$0
            com.github.kr328.clash.service.clash.module.Module r2 = (com.github.kr328.clash.service.clash.module.Module) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L4b
            goto L71
        L4b:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L8c
        L50:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Class r11 = r10.getClass()
            java.lang.String r11 = r11.getSimpleName()
            java.lang.String r0 = r11.concat(r0)     // Catch: java.lang.Throwable -> L8a
            com.github.kr328.clash.common.log.Log.d$default(r0)     // Catch: java.lang.Throwable -> L8a
            r1.L$0 = r10     // Catch: java.lang.Throwable -> L8a
            r1.L$1 = r11     // Catch: java.lang.Throwable -> L8a
            r1.label = r4     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r0 = r10.run(r1)     // Catch: java.lang.Throwable -> L8a
            if (r0 != r7) goto L6f
            goto La1
        L6f:
            r2 = r10
            r0 = r11
        L71:
            kotlinx.coroutines.NonCancellable r11 = kotlinx.coroutines.NonCancellable.INSTANCE
            kotlinx.coroutines.InterruptibleKt$runInterruptible$2 r3 = new kotlinx.coroutines.InterruptibleKt$runInterruptible$2
            r4 = 10
            r3.<init>(r2, r0, r6, r4)
            r1.L$0 = r6
            r1.L$1 = r6
            r1.label = r5
            java.lang.Object r11 = kotlinx.coroutines.JobKt.withContext(r11, r3, r1)
            if (r11 != r7) goto L87
            goto La1
        L87:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L8a:
            r0 = move-exception
            r2 = r10
        L8c:
            kotlinx.coroutines.NonCancellable r4 = kotlinx.coroutines.NonCancellable.INSTANCE
            kotlinx.coroutines.InterruptibleKt$runInterruptible$2 r5 = new kotlinx.coroutines.InterruptibleKt$runInterruptible$2
            r8 = 10
            r5.<init>(r2, r11, r6, r8)
            r1.L$0 = r0
            r1.L$1 = r6
            r1.label = r3
            java.lang.Object r11 = kotlinx.coroutines.JobKt.withContext(r4, r5, r1)
            if (r11 != r7) goto La2
        La1:
            return r7
        La2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.Module.execute(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public abstract Object run(Continuation continuation);
}
