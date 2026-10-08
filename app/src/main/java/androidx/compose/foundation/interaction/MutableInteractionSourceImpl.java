package androidx.compose.foundation.interaction;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableInteractionSourceImpl {
    public final SharedFlowImpl interactions = FlowKt.MutableSharedFlow$default(2, 1);

    public final Object emit(Interaction interaction, Continuation continuation) throws Throwable {
        Object objEmit = this.interactions.emit(interaction, continuation);
        return objEmit == CoroutineSingletons.COROUTINE_SUSPENDED ? objEmit : Unit.INSTANCE;
    }

    public final void tryEmit(Interaction interaction) {
        this.interactions.tryEmit(interaction);
    }
}
