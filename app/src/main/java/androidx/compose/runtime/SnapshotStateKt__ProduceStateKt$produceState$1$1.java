package androidx.compose.runtime;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateKt__ProduceStateKt$produceState$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function2 $producer;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableState $result;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnapshotStateKt__ProduceStateKt$produceState$1$1(Function2 function2, MutableState mutableState, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$producer = function2;
        this.$result = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                SnapshotStateKt__ProduceStateKt$produceState$1$1 snapshotStateKt__ProduceStateKt$produceState$1$1 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(this.$producer, this.$result, continuation, 0);
                snapshotStateKt__ProduceStateKt$produceState$1$1.L$0 = obj;
                return snapshotStateKt__ProduceStateKt$produceState$1$1;
            case 1:
                SnapshotStateKt__ProduceStateKt$produceState$1$1 snapshotStateKt__ProduceStateKt$produceState$1$2 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(this.$producer, this.$result, continuation, 1);
                snapshotStateKt__ProduceStateKt$produceState$1$2.L$0 = obj;
                return snapshotStateKt__ProduceStateKt$produceState$1$2;
            default:
                SnapshotStateKt__ProduceStateKt$produceState$1$1 snapshotStateKt__ProduceStateKt$produceState$1$3 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(this.$producer, this.$result, continuation, 2);
                snapshotStateKt__ProduceStateKt$produceState$1$3.L$0 = obj;
                return snapshotStateKt__ProduceStateKt$produceState$1$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((SnapshotStateKt__ProduceStateKt$produceState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, ((CoroutineScope) this.L$0).getCoroutineContext());
                    this.label = 1;
                    Object objInvoke = this.$producer.invoke(produceStateScopeImpl, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProduceStateScopeImpl produceStateScopeImpl2 = new ProduceStateScopeImpl(this.$result, ((CoroutineScope) this.L$0).getCoroutineContext());
                    this.label = 1;
                    Object objInvoke2 = this.$producer.invoke(produceStateScopeImpl2, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke2 == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProduceStateScopeImpl produceStateScopeImpl3 = new ProduceStateScopeImpl(this.$result, ((CoroutineScope) this.L$0).getCoroutineContext());
                    this.label = 1;
                    Object objInvoke3 = this.$producer.invoke(produceStateScopeImpl3, this);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke3 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
