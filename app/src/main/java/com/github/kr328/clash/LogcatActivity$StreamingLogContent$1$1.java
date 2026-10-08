package com.github.kr328.clash;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatActivity$StreamingLogContent$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $messages$delegate;
    public int I$0;
    public /* synthetic */ Object L$0;
    public LogcatService L$1;
    public int label;
    public final /* synthetic */ LogcatActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogcatActivity$StreamingLogContent$1$1(LogcatActivity logcatActivity, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.this$0 = logcatActivity;
        this.$messages$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LogcatActivity$StreamingLogContent$1$1 logcatActivity$StreamingLogContent$1$1 = new LogcatActivity$StreamingLogContent$1$1(this.this$0, this.$messages$delegate, continuation);
        logcatActivity$StreamingLogContent$1$1.L$0 = obj;
        return logcatActivity$StreamingLogContent$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LogcatActivity$StreamingLogContent$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0084 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0086  */
    /* JADX WARN: Code duplicated, block: B:21:0x0088  */
    /* JADX WARN: Code duplicated, block: B:25:0x009a  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c2  */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
    
        if (r12 == r5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
    
        if (kotlinx.coroutines.JobKt.delay(500, r11) == r5) goto L31;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bf -> B:8:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            int r0 = r11.label
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 == 0) goto L3c
            if (r0 == r4) goto L34
            if (r0 == r3) goto L27
            if (r0 != r2) goto L1f
            int r0 = r11.I$0
            com.github.kr328.clash.LogcatService r6 = r11.L$1
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r12)
        L1b:
            r12 = r6
            r6 = r0
            r0 = r7
            goto L7e
        L1f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L27:
            int r0 = r11.I$0
            com.github.kr328.clash.LogcatService r6 = r11.L$1
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L9f
        L34:
            java.lang.Object r0 = r11.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L7b
        L3c:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r0 = r12
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Class<com.github.kr328.clash.LogcatService> r12 = com.github.kr328.clash.LogcatService.class
            kotlin.jvm.internal.ClassReference r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r12)
            android.content.Intent r6 = com.github.kr328.clash.common.util.ComponentsKt.getIntent(r6)
            com.github.kr328.clash.LogcatActivity r7 = r11.this$0
            com.github.kr328.clash.common.compat.ServicesKt.startForegroundServiceCompat(r7, r6)
            r11.L$0 = r0
            r11.label = r4
            int r6 = com.github.kr328.clash.LogcatActivity.$r8$clinit
            kotlin.coroutines.SafeContinuation r6 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r8 = com.google.android.gms.internal.mlkit_vision_barcode.zzga.intercepted(r11)
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.UNDECIDED
            r6.<init>(r8, r9)
            kotlin.jvm.internal.ClassReference r12 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r12)
            android.content.Intent r12 = com.github.kr328.clash.common.util.ComponentsKt.getIntent(r12)
            com.github.kr328.clash.LogcatActivity$bindLogcatService$2$1 r8 = new com.github.kr328.clash.LogcatActivity$bindLogcatService$2$1
            r8.<init>()
            r7.bindService(r12, r8, r4)
            java.lang.Object r12 = r6.getOrThrow()
            if (r12 != r5) goto L7b
            goto Lc1
        L7b:
            com.github.kr328.clash.LogcatService r12 = (com.github.kr328.clash.LogcatService) r12
            r6 = r4
        L7e:
            boolean r7 = kotlinx.coroutines.JobKt.isActive(r0)
            if (r7 == 0) goto Lc2
            if (r6 == 0) goto L88
            r7 = r4
            goto L89
        L88:
            r7 = r1
        L89:
            r11.L$0 = r0
            r11.L$1 = r12
            r11.I$0 = r6
            r11.label = r3
            com.github.kr328.clash.log.LogcatCache r8 = r12.cache
            java.lang.Object r7 = r8.snapshot(r7, r11)
            if (r7 != r5) goto L9a
            goto Lc1
        L9a:
            r10 = r6
            r6 = r12
            r12 = r7
            r7 = r0
            r0 = r10
        L9f:
            com.github.kr328.clash.log.LogcatCache$Snapshot r12 = (com.github.kr328.clash.log.LogcatCache.Snapshot) r12
            if (r12 == 0) goto Lb1
            java.util.ArrayList r12 = r12.messages
            java.util.List r12 = kotlin.collections.CollectionsKt.reversed(r12)
            int r0 = com.github.kr328.clash.LogcatActivity.$r8$clinit
            androidx.compose.runtime.MutableState r0 = r11.$messages$delegate
            r0.setValue(r12)
            r0 = r1
        Lb1:
            r11.L$0 = r7
            r11.L$1 = r6
            r11.I$0 = r0
            r11.label = r2
            r8 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r12 = kotlinx.coroutines.JobKt.delay(r8, r11)
            if (r12 != r5) goto L1b
        Lc1:
            return r5
        Lc2:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.LogcatActivity$StreamingLogContent$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
