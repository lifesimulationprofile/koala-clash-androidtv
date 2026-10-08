package androidx.compose.material3.internal;

import androidx.compose.material3.TooltipStateImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BasicTooltipKt$handleGestures$1$1$1$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ TooltipStateImpl $state;
    public /* synthetic */ boolean Z$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTooltipKt$handleGestures$1$1$1$3$1(TooltipStateImpl tooltipStateImpl, Continuation continuation) {
        super(2, continuation);
        this.$state = tooltipStateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BasicTooltipKt$handleGestures$1$1$1$3$1 basicTooltipKt$handleGestures$1$1$1$3$1 = new BasicTooltipKt$handleGestures$1$1$1$3$1(this.$state, continuation);
        basicTooltipKt$handleGestures$1$1$1$3$1.Z$0 = ((Boolean) obj).booleanValue();
        return basicTooltipKt$handleGestures$1$1$1$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        return ((BasicTooltipKt$handleGestures$1$1$1$3$1) create(bool, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        if (!this.Z$0) {
            this.$state.dismiss();
        }
        return Unit.INSTANCE;
    }
}
