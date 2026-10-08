package androidx.lifecycle.compose;

import androidx.compose.runtime.ProduceStateScopeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt$collectAsStateWithLifecycle$1$1$1$1 implements FlowCollector {
    public final /* synthetic */ ProduceStateScopeImpl $$this$produceState;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FlowExtKt$collectAsStateWithLifecycle$1$1$1$1(ProduceStateScopeImpl produceStateScopeImpl, int i) {
        this.$r8$classId = i;
        this.$$this$produceState = produceStateScopeImpl;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                this.$$this$produceState.setValue(obj);
                break;
            case 1:
                this.$$this$produceState.setValue(obj);
                break;
            case 2:
                this.$$this$produceState.setValue(obj);
                break;
            default:
                this.$$this$produceState.setValue(obj);
                break;
        }
        return Unit.INSTANCE;
    }
}
