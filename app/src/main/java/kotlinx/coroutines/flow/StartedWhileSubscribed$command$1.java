package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3 {
    public /* synthetic */ int I$0;
    public /* synthetic */ FlowCollector L$0;
    public int label;
    public final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, (Continuation) obj3);
        startedWhileSubscribed$command$1.L$0 = (FlowCollector) obj;
        startedWhileSubscribed$command$1.I$0 = iIntValue;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062 A[PHI: r0
      0x0062: PHI (r0v3 kotlinx.coroutines.flow.FlowCollector) = (r0v2 kotlinx.coroutines.flow.FlowCollector), (r0v6 kotlinx.coroutines.flow.FlowCollector) binds: [B:25:0x005f, B:13:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if (r0.emit(kotlinx.coroutines.flow.SharingCommand.START, r7) == r6) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        if (r0.emit(kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE, r7) == r6) goto L32;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.label
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 == 0) goto L34
            if (r0 == r5) goto L30
            if (r0 == r4) goto L2a
            if (r0 == r3) goto L24
            if (r0 == r2) goto L1e
            if (r0 != r1) goto L16
            goto L30
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlinx.coroutines.flow.FlowCollector r0 = r7.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L72
        L24:
            kotlinx.coroutines.flow.FlowCollector r0 = r7.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L62
        L2a:
            kotlinx.coroutines.flow.FlowCollector r0 = r7.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L30:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L80
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.flow.FlowCollector r0 = r7.L$0
            int r8 = r7.I$0
            if (r8 <= 0) goto L48
            r7.label = r5
            kotlinx.coroutines.flow.SharingCommand r8 = kotlinx.coroutines.flow.SharingCommand.START
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r6) goto L80
            goto L7f
        L48:
            r7.L$0 = r0
            r7.label = r4
            r4 = 0
            java.lang.Object r8 = kotlinx.coroutines.JobKt.delay(r4, r7)
            if (r8 != r6) goto L55
            goto L7f
        L55:
            r7.L$0 = r0
            r7.label = r3
            kotlinx.coroutines.flow.SharingCommand r8 = kotlinx.coroutines.flow.SharingCommand.STOP
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r6) goto L62
            goto L7f
        L62:
            r7.L$0 = r0
            r7.label = r2
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r8 = kotlinx.coroutines.JobKt.delay(r2, r7)
            if (r8 != r6) goto L72
            goto L7f
        L72:
            r8 = 0
            r7.L$0 = r8
            r7.label = r1
            kotlinx.coroutines.flow.SharingCommand r8 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r6) goto L80
        L7f:
            return r6
        L80:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
