package androidx.lifecycle.compose;

import androidx.compose.runtime.ProduceStateScopeImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt$collectAsStateWithLifecycle$1$1$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ProduceStateScopeImpl $$this$produceState;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Flow $this_collectAsStateWithLifecycle;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowExtKt$collectAsStateWithLifecycle$1$1$1$2(Flow flow, ProduceStateScopeImpl produceStateScopeImpl, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$this_collectAsStateWithLifecycle = flow;
        this.$$this$produceState = produceStateScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new FlowExtKt$collectAsStateWithLifecycle$1$1$1$2(this.$this_collectAsStateWithLifecycle, this.$$this$produceState, continuation, 0);
            default:
                return new FlowExtKt$collectAsStateWithLifecycle$1$1$1$2(this.$this_collectAsStateWithLifecycle, this.$$this$produceState, continuation, 1);
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
        return ((FlowExtKt$collectAsStateWithLifecycle$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowExtKt$collectAsStateWithLifecycle$1$1$1$1 flowExtKt$collectAsStateWithLifecycle$1$1$1$1 = new FlowExtKt$collectAsStateWithLifecycle$1$1$1$1(this.$$this$produceState, 3);
                    this.label = 1;
                    Object objCollect = this.$this_collectAsStateWithLifecycle.collect(flowExtKt$collectAsStateWithLifecycle$1$1$1$1, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objCollect == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowExtKt$collectAsStateWithLifecycle$1$1$1$1 flowExtKt$collectAsStateWithLifecycle$1$1$1$2 = new FlowExtKt$collectAsStateWithLifecycle$1$1$1$1(this.$$this$produceState, 2);
                    this.label = 1;
                    Object objCollect2 = this.$this_collectAsStateWithLifecycle.collect(flowExtKt$collectAsStateWithLifecycle$1$1$1$2, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objCollect2 == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
