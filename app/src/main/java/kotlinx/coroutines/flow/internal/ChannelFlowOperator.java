package kotlinx.coroutines.flow.internal;

import androidx.navigation.compose.NavHostKt$NavHost$25$1$1;
import com.github.kr328.clash.FilesActivity$showError$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.io.FilesKt__UtilsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChannelFlowOperator extends ChannelFlow {
    public final Flow flow;

    public ChannelFlowOperator(Flow flow, CoroutineContext coroutineContext, int i, int i2) {
        super(coroutineContext, i, i2);
        this.flow = flow;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        int i = this.capacity;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == -3) {
            CoroutineContext context = continuation.getContext();
            Boolean bool = Boolean.FALSE;
            FilesKt__UtilsKt$$ExternalSyntheticLambda0 filesKt__UtilsKt$$ExternalSyntheticLambda0 = new FilesKt__UtilsKt$$ExternalSyntheticLambda0(5);
            CoroutineContext coroutineContext = this.context;
            CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(bool, filesKt__UtilsKt$$ExternalSyntheticLambda0)).booleanValue() ? context.plus(coroutineContext) : JobKt.foldCopies(context, coroutineContext, false);
            if (Intrinsics.areEqual(coroutineContextPlus, context)) {
                Object objFlowCollect = flowCollect(flowCollector, continuation);
                return objFlowCollect == coroutineSingletons ? objFlowCollect : Unit.INSTANCE;
            }
            ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
            if (Intrinsics.areEqual(coroutineContextPlus.get(continuationInterceptor$Key), context.get(continuationInterceptor$Key))) {
                CoroutineContext context2 = continuation.getContext();
                if (!(flowCollector instanceof SendingCollector) && !(flowCollector instanceof NopCollector)) {
                    flowCollector = new NavHostKt$NavHost$25$1$1(flowCollector, context2);
                }
                Object objWithContextUndispatched = ChannelFlowKt.withContextUndispatched(coroutineContextPlus, flowCollector, coroutineContextPlus.fold(0, InlineList.countAll), new FilesActivity$showError$1(this, null, 21), continuation);
                return objWithContextUndispatched == coroutineSingletons ? objWithContextUndispatched : Unit.INSTANCE;
            }
        }
        Object objCollect = super.collect(flowCollector, continuation);
        return objCollect == coroutineSingletons ? objCollect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object collectTo(ProducerScope producerScope, Continuation continuation) {
        Object objFlowCollect = flowCollect(new SendingCollector(producerScope), continuation);
        return objFlowCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlowCollect : Unit.INSTANCE;
    }

    public abstract Object flowCollect(FlowCollector flowCollector, Continuation continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return this.flow + " -> " + super.toString();
    }
}
