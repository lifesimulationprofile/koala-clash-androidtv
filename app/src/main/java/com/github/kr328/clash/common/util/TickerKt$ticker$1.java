package com.github.kr328.clash.common.util;

import androidx.compose.animation.SizeAnimationModifierNode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TickerKt$ticker$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $channel;
    public final /* synthetic */ long $period;
    public final /* synthetic */ int $r8$classId = 1;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TickerKt$ticker$1(SizeAnimationModifierNode.AnimData animData, long j, SizeAnimationModifierNode sizeAnimationModifierNode, Continuation continuation) {
        super(2, continuation);
        this.L$0 = animData;
        this.$period = j;
        this.$channel = sizeAnimationModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                TickerKt$ticker$1 tickerKt$ticker$1 = new TickerKt$ticker$1((BufferedChannel) this.$channel, this.$period, continuation);
                tickerKt$ticker$1.L$0 = obj;
                return tickerKt$ticker$1;
            default:
                return new TickerKt$ticker$1((SizeAnimationModifierNode.AnimData) this.L$0, this.$period, (SizeAnimationModifierNode) this.$channel, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((TickerKt$ticker$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0079 A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:20:0x0057, B:28:0x0073, B:30:0x0079, B:34:0x0092, B:25:0x0068), top: B:40:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009c -> B:21:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.$r8$classId
            switch(r0) {
                case 0: goto L46;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r8.$channel
            androidx.compose.animation.SizeAnimationModifierNode r0 = (androidx.compose.animation.SizeAnimationModifierNode) r0
            java.lang.Object r1 = r8.L$0
            androidx.compose.animation.SizeAnimationModifierNode$AnimData r1 = (androidx.compose.animation.SizeAnimationModifierNode.AnimData) r1
            int r2 = r8.label
            r3 = 1
            if (r2 == 0) goto L21
            if (r2 != r3) goto L19
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            goto L3f
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.animation.core.Animatable r1 = r1.anim
            androidx.compose.ui.unit.IntSize r2 = new androidx.compose.ui.unit.IntSize
            long r4 = r8.$period
            r2.<init>(r4)
            androidx.compose.animation.core.TweenSpec r9 = r0.animationSpec
            r8.label = r3
            r4 = 0
            r6 = 12
            r5 = r8
            r3 = r9
            java.lang.Object r9 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6)
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r9 != r0) goto L3f
            goto L45
        L3f:
            androidx.compose.animation.core.AnimationResult r9 = (androidx.compose.animation.core.AnimationResult) r9
            int r9 = r9.endReason
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L45:
            return r0
        L46:
            r5 = r8
            int r0 = r5.label
            r1 = 2
            r2 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 == 0) goto L6c
            if (r0 == r2) goto L64
            if (r0 != r1) goto L5c
            java.lang.Object r0 = r5.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L9f
        L5a:
            r9 = r0
            goto L73
        L5c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L64:
            java.lang.Object r0 = r5.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L9f
            goto L92
        L6c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r5.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
        L73:
            boolean r0 = kotlinx.coroutines.JobKt.isActive(r9)     // Catch: java.lang.Exception -> L9f
            if (r0 == 0) goto L9f
            java.lang.Object r0 = r5.$channel     // Catch: java.lang.Exception -> L9f
            kotlinx.coroutines.channels.BufferedChannel r0 = (kotlinx.coroutines.channels.BufferedChannel) r0     // Catch: java.lang.Exception -> L9f
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L9f
            java.lang.Long r4 = new java.lang.Long     // Catch: java.lang.Exception -> L9f
            r4.<init>(r6)     // Catch: java.lang.Exception -> L9f
            r5.L$0 = r9     // Catch: java.lang.Exception -> L9f
            r5.label = r2     // Catch: java.lang.Exception -> L9f
            java.lang.Object r0 = r0.send(r4, r8)     // Catch: java.lang.Exception -> L9f
            if (r0 != r3) goto L91
            goto La1
        L91:
            r0 = r9
        L92:
            long r6 = r5.$period     // Catch: java.lang.Exception -> L9f
            r5.L$0 = r0     // Catch: java.lang.Exception -> L9f
            r5.label = r1     // Catch: java.lang.Exception -> L9f
            java.lang.Object r9 = kotlinx.coroutines.JobKt.delay(r6, r8)     // Catch: java.lang.Exception -> L9f
            if (r9 != r3) goto L5a
            goto La1
        L9f:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        La1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.common.util.TickerKt$ticker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TickerKt$ticker$1(BufferedChannel bufferedChannel, long j, Continuation continuation) {
        super(2, continuation);
        this.$channel = bufferedChannel;
        this.$period = j;
    }
}
