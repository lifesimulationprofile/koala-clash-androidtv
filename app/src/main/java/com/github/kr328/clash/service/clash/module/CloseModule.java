package com.github.kr328.clash.service.clash.module;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CloseModule extends Module {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RequestClose {
        public static final RequestClose INSTANCE = new RequestClose();
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.CloseModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public CloseModule L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloseModule.this.run(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
    
        if (r6 == r4) goto L25;
     */
    @Override // com.github.kr328.clash.service.clash.module.Module
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object run(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.github.kr328.clash.service.clash.module.CloseModule.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.github.kr328.clash.service.clash.module.CloseModule$run$1 r0 = (com.github.kr328.clash.service.clash.module.CloseModule.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L13:
            com.github.kr328.clash.service.clash.module.CloseModule$run$1 r0 = new com.github.kr328.clash.service.clash.module.CloseModule$run$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r6 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r6
            r0.<init>(r6)
        L1a:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 2
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L3a
            if (r1 == r2) goto L34
            if (r1 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L6e
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            com.github.kr328.clash.service.clash.module.CloseModule r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L54
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1 r6 = new com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1
            r1 = 6
            r6.<init>(r1)
            r1 = 3
            kotlinx.coroutines.channels.BufferedChannel r6 = com.github.kr328.clash.service.clash.module.Module.receiveBroadcast$default(r5, r6, r1)
            r0.L$0 = r5
            r0.label = r2
            java.lang.Object r6 = r6.receive(r0)
            if (r6 != r4) goto L53
            goto L6d
        L53:
            r1 = r5
        L54:
            java.lang.String r6 = "User request close"
            com.github.kr328.clash.common.log.Log.d$default(r6)
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            kotlinx.coroutines.channels.BufferedChannel r6 = r1.events
            com.github.kr328.clash.service.clash.module.CloseModule$RequestClose r1 = com.github.kr328.clash.service.clash.module.CloseModule.RequestClose.INSTANCE
            java.lang.Object r6 = r6.send(r1, r0)
            if (r6 != r4) goto L69
            goto L6b
        L69:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L6b:
            if (r6 != r4) goto L6e
        L6d:
            return r4
        L6e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.CloseModule.run(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
