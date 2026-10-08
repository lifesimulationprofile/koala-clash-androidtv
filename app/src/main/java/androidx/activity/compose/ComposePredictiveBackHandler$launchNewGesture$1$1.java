package androidx.activity.compose;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposePredictiveBackHandler$launchNewGesture$1$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ Ref$BooleanRef $completed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposePredictiveBackHandler$launchNewGesture$1$1(Ref$BooleanRef ref$BooleanRef, Continuation continuation) {
        super(3, continuation);
        this.$completed = ref$BooleanRef;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return new ComposePredictiveBackHandler$launchNewGesture$1$1(this.$completed, (Continuation) obj3).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        this.$completed.element = true;
        return Unit.INSTANCE;
    }
}
