package kotlinx.coroutines.flow;

import coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SafeFlow implements Flow {
    public final /* synthetic */ int $r8$classId;
    public final Object block;

    public /* synthetic */ SafeFlow(StateFlowImpl stateFlowImpl, int i) {
        this.$r8$classId = i;
        this.block = stateFlowImpl;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    /* JADX WARN: Type inference failed for: r6v4, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        Throwable th;
        SafeCollector safeCollector;
        switch (this.$r8$classId) {
            case 0:
                if (continuation instanceof AbstractFlow$collect$1) {
                    abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
                    int i = abstractFlow$collect$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        abstractFlow$collect$1.label = i - Integer.MIN_VALUE;
                    } else {
                        abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
                    }
                } else {
                    abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
                }
                Object obj = abstractFlow$collect$1.result;
                int i2 = abstractFlow$collect$1.label;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    safeCollector = abstractFlow$collect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        safeCollector.releaseIntercepted();
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                ResultKt.throwOnFailure(obj);
                SafeCollector safeCollector2 = new SafeCollector(flowCollector, abstractFlow$collect$1._context);
                try {
                    abstractFlow$collect$1.L$0 = safeCollector2;
                    abstractFlow$collect$1.label = 1;
                    Object objInvoke = ((SuspendLambda) this.block).invoke(safeCollector2, abstractFlow$collect$1);
                    Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke != obj2) {
                        objInvoke = Unit.INSTANCE;
                        break;
                    }
                    if (objInvoke == obj2) {
                        return obj2;
                    }
                    safeCollector = safeCollector2;
                    safeCollector.releaseIntercepted();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    safeCollector = safeCollector2;
                    safeCollector.releaseIntercepted();
                    throw th;
                }
            case 1:
                Object objCollect = ((Flow) this.block).collect(new ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2(flowCollector, 1), continuation);
                return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
            default:
                Object objCollect2 = ((Flow) this.block).collect(new ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2(flowCollector, 0), continuation);
                return objCollect2 == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect2 : Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(Function2 function2) {
        this.$r8$classId = 0;
        this.block = (SuspendLambda) function2;
    }
}
